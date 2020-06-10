package demo.test;

import demo.utils.HttpClientUtil;
import demo.utils.URLConfigEnum;
import demo.entity.BuildParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @program: yesfp-demo
 * @description: api的测试类
 * @author: kw
 * @create: 2020/05/21 15:22
 */
public class APITest {

    private static Logger LOGGER = LoggerFactory.getLogger(APITest.class);

    public static void main(String[] args) throws Exception {

//    String result = queryInvoiceStatus();
        //OCR识别接口
//        String result = recognise();
//      String result = issue();
//       String result =red();
       String result =partRed();
        //开票蓝票请求服务
//       String result = insertWithArray();
        //开票蓝票请求服务--发票拆分
//        String result=insertWithSplit();
        System.out.println(result);

    }

    //开票蓝票请求服务
    public static String insertWithArray() throws Exception {
        //构造POST表单Map
        Map<String, String> paramsMap = BuildParam.buildInsertWithArrayPostParam();
        System.out.println(paramsMap);
        return HttpClientUtil.post(URLConfigEnum.INSERT_WITH_ARRAY_URL.getUrl(),(Map)paramsMap);
    }

    //OCR识别接口
    public static String recognise() throws Exception {
        //构造POST表单Map
        Map<String, Object> paramsMap = BuildParam.buildRecognisePostParam();
        //json格式
        return HttpClientUtil.jsonPost(URLConfigEnum.RECOGNISE.getUrl(),paramsMap);
    }
    //开票蓝票请求服务--发票拆分
    public static String insertWithSplit()throws Exception{
        Map<String, Object> paramsMap = BuildParam.insertWithSplit();
        return HttpClientUtil.post(URLConfigEnum.INSERT_WITH_SPLIT.getUrl(),(Map)paramsMap);
    }
    //开票状态查询服务
    public static String queryInvoiceStatus() throws Exception {
        //构造POST表单Map
        Map<String, String> paramsMap = BuildParam.buildQueryInvoiceStatusPostParam();
        return HttpClientUtil.post(URLConfigEnum.QUERY_INBOICE_STATUS.getUrl(),(Map)paramsMap);
    }
    //开票申请审核通过
    public static String issue()throws Exception{
        Map<String,Object> paramsMap = BuildParam.issue();
        return HttpClientUtil.post(URLConfigEnum.ISSUE.getUrl(),(Map)paramsMap);
    }
    //发票红冲请求服务
    public static String red() throws Exception{
        Map<String,Object> paramsMap = BuildParam.red();
        return HttpClientUtil.post(URLConfigEnum.RED.getUrl(),(Map)paramsMap);
    }
    //电子发票部分红冲
    public static String partRed() throws Exception{
        Map<String,Object> paramsMap = BuildParam.red();
        return HttpClientUtil.post(URLConfigEnum.PART_RED.getUrl(),(Map)paramsMap);
    }

}
