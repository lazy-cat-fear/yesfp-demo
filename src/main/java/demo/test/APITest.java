package demo.test;

import demo.entity.StaBookBuildParam;
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
        //String result = recognise();
        //开票申请审核通过
//      String result = issue();
     //发票红冲请求服务
//       String result =red();
        // 电子发票部分红冲
//       String result =partRed();
        //开票蓝票请求服务
//       String result = insertWithArray();
        //开票蓝票请求服务--发票拆分
//        String result=insertWithSplit();
        //识别结果保存台账
     // String result = orc_Save();
        //台账报销
     // String result =  reimbursed();
        //台账取消报销
     //  String result=cancelReimbursed();
        //台账记账
      // String result=account();
        //台账取消记账
       // String result= cancelAccount();
        //报销台账删除
       // String result=delete();
        //飞机票台账查询
       // String result= air();
        //火车票台账查询
         //String result= train();
        //出租车台账查询
        String result= taxi();
        System.out.println(result);

    }

    //开票蓝票请求服务
    public static String insertWithArray() throws Exception {
        //构造POST表单Map
        Map<String, String> paramsMap = BuildParam.buildInsertWithArrayPostParam();
        System.out.println(paramsMap);
        return HttpClientUtil.post(URLConfigEnum.INSERT_WITH_ARRAY_URL.getUrl(), (Map) paramsMap);
    }

    //OCR识别接口
    public static String recognise() throws Exception {
        //构造POST表单Map
        Map<String, Object> paramsMap = StaBookBuildParam.buildRecognisePostParam();
        //json格式
        return HttpClientUtil.jsonPost(URLConfigEnum.RECOGNISE.getUrl(), paramsMap);
    }

    //开票蓝票请求服务--发票拆分
    public static String insertWithSplit() throws Exception {
        Map<String, Object> paramsMap = BuildParam.insertWithSplit();
        return HttpClientUtil.post(URLConfigEnum.INSERT_WITH_SPLIT.getUrl(), (Map) paramsMap);
    }

    //开票状态查询服务
    public static String queryInvoiceStatus() throws Exception {
        //构造POST表单Map
        Map<String, String> paramsMap = BuildParam.buildQueryInvoiceStatusPostParam();
        return HttpClientUtil.post(URLConfigEnum.QUERY_INBOICE_STATUS.getUrl(), (Map) paramsMap);
    }

    //开票申请审核通过
    public static String issue() throws Exception {
        Map<String, Object> paramsMap = BuildParam.issue();
        return HttpClientUtil.post(URLConfigEnum.ISSUE.getUrl(), (Map) paramsMap);
    }

    //发票红冲请求服务
    public static String red() throws Exception {
        Map<String, Object> paramsMap = BuildParam.red();
        return HttpClientUtil.post(URLConfigEnum.RED.getUrl(), (Map) paramsMap);
    }

    //电子发票部分红冲
    public static String partRed() throws Exception {
        Map<String, Object> paramsMap = BuildParam.red();
        return HttpClientUtil.post(URLConfigEnum.PART_RED.getUrl(), (Map) paramsMap);
    }

    /**
     * 识别结果保存台帐
     */
    public static String orc_Save() throws Exception {
        Map<String, Object> paramsMap = StaBookBuildParam.orc_Save();
        //json格式
        return HttpClientUtil.jsonPost(URLConfigEnum.OCR_SAVE.getUrl(), paramsMap);
    }

    /**
     *台账报销
     */
    public static String reimbursed() throws Exception {
        Map<String, Object> paramsMap = StaBookBuildParam.reimbursed();
        //json格式
        return HttpClientUtil.jsonPost(URLConfigEnum.REIMBURSED.getUrl(), paramsMap);
    }
    /**
     * 台账取消报销
     */
    public static String cancelReimbursed() throws Exception {
        Map<String, Object> paramsMap = StaBookBuildParam.cancelReimbursed();
        //json格式
        return HttpClientUtil.jsonPost(URLConfigEnum.CANCEL_REIMBURSED.getUrl(), paramsMap);
    }
    /**
     *台账记账
     */
    public static String account() throws Exception {
        Map<String, Object> paramsMap = StaBookBuildParam.account();
        //json格式
        return HttpClientUtil.jsonPost(URLConfigEnum.ACCOUNT.getUrl(), paramsMap);
    }
    /**
     *台账取消记账
     */
    public static String cancelAccount() throws Exception {
        Map<String, Object> paramsMap = StaBookBuildParam.cancelAccount();
        //json格式
        return HttpClientUtil.jsonPost(URLConfigEnum.CANCEL_ACCOUNT.getUrl(), paramsMap);
    }
    /**
     *报销台账删除
     */
    public static String delete() throws Exception {
        Map<String, Object> paramsMap = StaBookBuildParam.delete();
        //json格式
        return HttpClientUtil.jsonPost(URLConfigEnum.DELETE.getUrl(), paramsMap);
    }
    /**
     * 飞机票台账查询
     */
    public static String air() throws Exception {
        Map<String, Object> paramsMap = StaBookBuildParam.find();
        //json格式
        return HttpClientUtil.jsonPost(URLConfigEnum.AIR.getUrl(), paramsMap);
    }
    /**
     * 火车票台账查询
     */
    public static String train() throws Exception {
        Map<String, Object> paramsMap = StaBookBuildParam.find();
        //json格式
        return HttpClientUtil.jsonPost(URLConfigEnum.TRAIN.getUrl(), paramsMap);
    }
    /**
     * 出租车台账查询
     */
    public static String taxi() throws Exception {
        Map<String, Object> paramsMap = StaBookBuildParam.find();
        //json格式
        return HttpClientUtil.jsonPost(URLConfigEnum.TAXI.getUrl(), paramsMap);
    }
}
