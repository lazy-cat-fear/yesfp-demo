package demo.crypto;

import demo.utils.URLConfigEnum;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.compression.CompressionCodecs;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.interfaces.RSAPrivateKey;
import java.util.Map;

/**
 * @program: yesfp-demo
 * @description:
 * @author: kw
 * @create: 2020/05/21 12:37
 */
public class SignHelper {

    /**
     * 签名
     *
     * @param paramsMap 表单参数
     * @return 签名值
     * @throws Exception
     */
    public static String sign(Map<String, String> paramsMap) throws Exception {
        //读取证书私钥
        PrivateKey privateKey = loadPrivateKeyOfCA();
        Map<String, Object> claims =
                JwtParamBuilder.build().setSubject("tester").setIssuer("einvoice").setAudience("einvoice")
                        .addJwtId().addIssuedAt().setExpirySeconds(3600).setNotBeforeSeconds(3600).getClaims();
        // 需要将表单参数requestdatas的数据进行md5加密，然后放到签名数据的requestdatas中。
        // 此签名数据必须存在，否则在验证签名时会不通过。
        if (paramsMap.containsKey("requestdatas")) {
            String value = paramsMap.get("requestdatas");
            claims.put("requestdatas", getMD5(value));
        }
        else if (paramsMap.containsKey("nsrsbh")) {
            String value = paramsMap.get("nsrsbh");
            claims.put("nsrsbh", getMD5(value));
        } else {
            //throw new Exception("签名错误");
        }
////        String value = paramsMap.get("nsrsbh");
////        claims.put("nsrsbh", getMD5(value));
//        String value = paramsMap.get("requestdatas");
//        System.out.println("============requestdatas=========="+value);
//        claims.put("requestdatas", getMD5(value));
        // 使用jdk1.6版本时，删除下面代码的中.compressWith(CompressionCodecs.DEFLATE)
        String compactJws = Jwts.builder().signWith(SignatureAlgorithm.RS512, privateKey)
                .setClaims(claims).compressWith(CompressionCodecs.DEFLATE).compact();
        return compactJws;
    }

//    /**
//     * 当在linux环境下运行代码，签名方法报空指针异常的时候，采用该签名方法可以避免这个问题
//     * 使用该方法需要添加新的maven依赖，如下：
//     * <dependency>
//     *     <groupId>com.auth0</groupId>
//     *     <artifactId>java-jwt</artifactId>
//     *     <version>3.3.0</version>
//     * </dependency>
//     * @param paramsMap
//     * @return
//     * @throws Exception
//     */
//    private String sign(Map<String, String> paramsMap) throws Exception {
//
//        RSAPrivateKey privateKey = loadPrivateKeyOfCA();
//        Map<String, Object> claims =
//                JwtParamBuilder.build().setSubject("tester").setIssuer("einvoice").setAudience("einvoice")
//                        .addJwtId().addIssuedAt().setExpirySeconds(300).setNotBeforeSeconds(300).getClaims();
//        String token;
//        try {
//            Algorithm algorithm = Algorithm.RSA512(null, privateKey);
//            token = JWT.create()
//                    .withClaim("requestdatas",getMD5(paramsMap.get("requestdatas")))
//                    .withHeader(claims)
//                    .sign(algorithm);
//        } catch (JWTCreationException exception){
//            //Invalid Signing configuration / Couldn't convert Claims.
//            return null;
//        }
//
//        return token;
//    }

    /**
     * 读取证书私钥
     *
     * @return
     * @throws UnrecoverableKeyException
     * @throws KeyStoreException
     * @throws NoSuchAlgorithmException
     * @throws CertificateException
     * @throws IOException
     */
    protected static RSAPrivateKey loadPrivateKeyOfCA() throws UnrecoverableKeyException, KeyStoreException,
            NoSuchAlgorithmException, CertificateException, IOException {
        FileInputStream in = new FileInputStream(URLConfigEnum.KEY_PATH.getValue());
        KeyStore ks = KeyStore.getInstance("pkcs12");
        //证书密码
        String PASSWORD = URLConfigEnum.PASSWORD.getValue(); //"password";
        ks.load(in, PASSWORD.toCharArray());
        String alias = ks.aliases().nextElement();
        RSAPrivateKey caprk = (RSAPrivateKey) ks.getKey(alias, PASSWORD.toCharArray());
        return caprk;
    }

    /**
     * 计算参数MD5
     *
     * @param str
     * @return
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    private static String getMD5(String str) throws UnsupportedEncodingException,
            NoSuchAlgorithmException {
        byte[] buf;
        buf = str.getBytes("utf-8");
        MessageDigest md5 = null;
        md5 = MessageDigest.getInstance("MD5");
        md5.update(buf);
        byte[] tmp = md5.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : tmp) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }


}
