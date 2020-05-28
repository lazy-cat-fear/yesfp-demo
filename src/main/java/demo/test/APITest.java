package demo.test;

import demo.utils.HttpClientUtil;
import demo.utils.URLConfigEnum;
import demo.entity.BuildParam;

import java.util.Map;

/**
 * @program: yesfp-demo
 * @description: api的测试类
 * @author: kw
 * @create: 2020/05/21 15:22
 */
public class APITest {

    public static void main(String[] args) throws Exception {

//        String result = queryInvoiceStatus();
//        String result = recognise();
        String result = insertWithArray();
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

    //开票状态查询服务
    public static String queryInvoiceStatus() throws Exception {
        //构造POST表单Map
        Map<String, String> paramsMap = BuildParam.buildQueryInvoiceStatusPostParam();
        return HttpClientUtil.post(URLConfigEnum.QUERY_INBOICE_STATUS.getUrl(),(Map)paramsMap);
    }

}
