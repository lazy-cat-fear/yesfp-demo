package demo.utils;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MobileLoginUtils {

  //电子发票服务地址(测试)
  private static String FP_BASE_URL = "https://yesfp.yonyoucloud.com";
  //电子发票服务地址(正式)
//  private static String FP_BASE_URL = "https://fapiao.yonyoucloud.com";

  private static final char[] HEX_CHAR =
      {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

  private static OkHttpClient okClient;


  static {
    OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
    okHttpClient.hostnameVerifier(new HostnameVerifier() {
      @Override
      public boolean verify(String hostname, SSLSession session) {
        return true;
      }
    });
    okClient = okHttpClient.build();
  }

  /**
   * 个人票夹接入使用该接口，不用之前的mobilelogin了
   * @param username 用户名
   * @param password 密码
   * @return token
   */
  public static String loginV2(String username, String password) {
    String encryptedPwd = encryptV2(password);
    JSONObject jsonObject = new JSONObject();
    try {
      jsonObject.put("account", username);
      jsonObject.put("password", encryptedPwd);
      jsonObject.put("srcapp","mobile");
      String loginResponse =
          doPostJson(FP_BASE_URL + "/cas/v1/mobile/user/mobileloginV2", jsonObject.toString());
      return handleLoginResponse(loginResponse);
    } catch (Exception e) {
      return null;
    }
  }


  public static String login(String username, String password) {

    String encryptedPwd = encrypt(password);

    JSONObject jsonObject = new JSONObject();
    try {
      jsonObject.put("account", username);
      jsonObject.put("password", encryptedPwd);
      jsonObject.put("usercode", "001");
      jsonObject.put("isbind", "Y");
      jsonObject.put("appid", "commontesterCA");
      String loginResponse =
          doPostJson(FP_BASE_URL + "/cas/v1/mobile/user/mobilelogin", jsonObject.toString());
      return handleLoginResponse(loginResponse);

    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }


  /**
   * 支持 JSON、JSONP 两种格式。
   */
  private static JsonObject toJsonObject(String jsonString) {
    Pattern jsonPattern = Pattern.compile("\\{.*\\}", Pattern.DOTALL);
    Matcher m = jsonPattern.matcher(jsonString);

    if (m.find()) {
      JsonParser parser = new JsonParser();
      return parser.parse(m.group()).getAsJsonObject();
    }

    return new JsonObject();

  }

  private static String handleLoginResponse(String loginResponse) {
    JsonObject response = toJsonObject(loginResponse);
    String code = response.get("code").getAsString();
    final String msgString = response.get("msg").getAsString();
    if ("0000".equals(code)) {
      JsonObject datas = response.getAsJsonObject("datas");
      String token = datas.get("token").getAsString();
      return token;
    } else {
      return msgString;
    }
  }

  public static String doPostJson(String url, String json) {
    //url = FP_BASE_URL.concat(url);

    RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);
    Request.Builder builder = new Request.Builder().post(requestBody).url(url);

    Request build = builder.build();
    String string = null;

    try {
      Response response = okClient.newCall(build).execute();
      string = response.body().string();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return string;
  }

  private static String encryptV2(String password){
    JsonObject jo = getFpPubkey();
    String modules = jo.get("modules").getAsString();
    String exponent = jo.get("exponent").getAsString();
    PublicKey publicKey = getPublicKey(modules, exponent);
    try {
      return encryptByPublicKey(password, publicKey);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 根据服务器返回的公钥，对密码进行加密
   */
  private static String encrypt(String password) {
    JsonObject jo = getFpPubkey();
    String modules = jo.get("modules").getAsString();
    String exponent = jo.get("exponent").getAsString();

    PublicKey publicKey = getPublicKey(modules, exponent);
    String encryptByPublicKey = null;
    try {
      String encodeData = SHA1(password);

      encryptByPublicKey = encryptByPublicKey(encodeData, publicKey);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return encryptByPublicKey + "_encrypted";
  }

  public static String doGet(String url) {
    url = FP_BASE_URL.concat(url);

    Request request = new Request.Builder().url(url).build();

    Response response;
    try {
      response = okClient.newCall(request).execute();

      return response.body().string();

    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  private static JsonObject getFpPubkey() {
    String PUBKEY_URL = "/cas/v1/pubkey";

    String response = doGet(PUBKEY_URL);
    return toJsonObject(response).getAsJsonObject("datas");

  }

  /**
   * 公钥加密
   */
  private static String encryptByPublicKey(String data, PublicKey publicKey) throws Exception {
    String reverse = reverse(data);
    Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding");
    cipher.init(Cipher.ENCRYPT_MODE, publicKey);
    byte[] bytes = cipher.doFinal(reverse.getBytes());
    /*
     * // 模长 int key_len = publicKey.getModulus().bitLength() / 8; // 加密数据长度 <= 模长-11 String[] datas
     * = splitString(data, key_len - 11); //如果明文长度大于模长-11则要分组加密 for (String s : datas) { byte[]
     * bytes1 = cipher.doFinal(s.getBytes()); }
     */
    return byteArrayToString(bytes);
  }

  private static String byteArrayToString(byte[] data) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < data.length; i++) {
      // 取出字节的高四位 作为索引得到相应的十六进制标识符 注意无符号右移
      stringBuilder.append(HEX_CHAR[(data[i] & 0xf0) >>> 4]);
      // 取出字节的低四位 作为索引得到相应的十六进制标识符
      stringBuilder.append(HEX_CHAR[(data[i] & 0x0f)]);
      /*
       * if (i < data.length - 1) { stringBuilder.append(' '); }
       */
    }
    return stringBuilder.toString();
  }

  private static String reverse(String data) {
    int length = data.length();
    StringBuffer stringBuffer = new StringBuffer();
    for (int i = length - 1; i >= 0; i--) {
      stringBuffer.append(data.charAt(i));
    }
    return stringBuffer.toString();
  }

  /**
   * 使用模和指数生成RSA公钥 注意：【此代码用了默认补位方式，为RSA/None/PKCS1Padding，不同JDK默认的补位方式可能不同，如Android默认是RSA
   * /None/NoPadding】
   *
   * @param modulus 模
   * @param exponent 指数
   */
  private static RSAPublicKey getPublicKey(String modulus, String exponent) {
    try {
      BigInteger b1 = new BigInteger(modulus, 16);
      BigInteger b2 = new BigInteger(exponent, 16);
      KeyFactory keyFactory = KeyFactory.getInstance("RSA");
      RSAPublicKeySpec keySpec = new RSAPublicKeySpec(b1, b2);
      PublicKey publicKey = keyFactory.generatePublic(keySpec);
      return (RSAPublicKey) publicKey;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  private static String SHA1(String decript) {
    try {
      MessageDigest digest = MessageDigest.getInstance("SHA-1");
      digest.update(decript.getBytes());
      byte messageDigest[] = digest.digest();
      // Create Hex String
      StringBuffer hexString = new StringBuffer();
      // 字节数组转换为 十六进制 数
      for (int i = 0; i < messageDigest.length; i++) {
        String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
        if (shaHex.length() < 2) {
          hexString.append(0);
        }
        hexString.append(shaHex);
      }
      return hexString.toString();

    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return "";
  }
}
