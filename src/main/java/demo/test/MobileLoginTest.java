package demo.test;

import com.alibaba.fastjson.JSON;
import demo.utils.MobileLoginUtils;

import java.util.HashMap;
import java.util.Map;

public class MobileLoginTest {

  public static void main(String[] args) {
//    testLogin();
//    testQuery();
    test();
  }

  public static void testLogin() {

    String username = "17600104874";
    String password = "xiaobo0307hao";

    //登录获取token
    String token = MobileLoginUtils.loginV2(username,password);

    System.out.println(token);

  }

  public static void testQuery() {

    //登录时获得的token
    String token = "NmM5MWEyZGYtZDY1My00MDBlLWI3MmQtODk0ODFkODk2N2Jk";

    String url = "https://yesfp.yonyoucloud.com/piaoeda-web/mobile/invoices/advancequery?page=1&size=5&token="+token;
    Map<String, Object> entity = new HashMap<>();
//    entity.put("fpjz", "1");
    //entity.put("classify", "交通");
    entity.put("expensestatus", new Integer[] {-1,33,36});

    String result = MobileLoginUtils.doPostJson(url, JSON.toJSONString(entity));

    System.out.println(result);

  }

  public static void test() {
    String token = "NmM5MWEyZGYtZDY1My00MDBlLWI3MmQtODk0ODFkODk2N2Jk";//登录时获得的token

    String url = "https://yesfp.yonyoucloud.com/piaoeda-web/mobile/invoices/advancequery?page=1&size=5&token="+token;
    Map<String, Object> entity = new HashMap<>();
    entity.put("fpjz", "0");
    //entity.put("classify", "交通");
    entity.put("expensestatus", new Integer[] {-1,33});

    String result = MobileLoginUtils.doPostJson(url, JSON.toJSONString(entity));

    System.out.println(result);

  }

}
