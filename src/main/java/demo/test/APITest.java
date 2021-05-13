package demo.test;

import demo.entity.output_invoice.InvoiceBuildParam;
import demo.entity.input_ticket.PurchaseParam;
import demo.entity.personal_ticket_holder.ReimburseCollection;
import demo.entity.input_ticket.StaBookBuildParam;
import demo.utils.HttpClientUtil;
import demo.utils.URLConfigEnum;
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
        String result = "";
        //获取专票
//        result = queryInvoice();
        //请求二维码信息
//        result =insertForQRInvoice();
        //专票红冲状态查询接口
//        result = redStateTotal();
        //采购台账查询接口（新）
//        result = purchaseQuery();
        //发票作废
//        result = invalid();
        //个人用户同步
//        String result = syncUser();
        //发票打印
//        String result = taxPrint();
        //删除
        //String result = invoiceApplyDel();
        //开票状态查询服务
//        result = queryInvoiceStatus();
        //OCR识别接口
//        result = recognise();
        //开票申请审核通过
        //String result = issue();
        //发票红冲请求服务
        //String result =red();
        //电子发票部分红冲
        //String result =partRed();
        //开票蓝票请求服务
        result = insertWithArray();
        //开票蓝票请求服务--发票拆分
//        result=insertWithSplit();
        //识别结果保存台账
//         String result = OCR_Save();
        //台账报销
        // String result =  reimbursed();
        //台账取消报销
        //  String result=cancelRei=mbursed();
        //台账记账
        // String result=account();
        //台账取消记账
        // String result= cancelAccount();
        //报销台账删除
        // String result=delete();
        //飞机票台账查询
//         result= air();
        //火车票台账查询
        //String result= train();
        //出租车台账查询
        //String result= taxi();
        //个人票夹提交发票到报销台账_全票种
        //  String result = commit();
        //个人发票上传
        //String result =uploadpdf();
        //发票取消上传
        // String result =CollDelete();
        //发票已报销
        //String result =CollReimbursed();
        //发票取消报销
        // String result =CollUnreimbursed();
        //入账
        //String result = accountStatus();
        //报销台账查询接口（新）
        // String result =CollQuery();
        //取消入账
        //String result =CollCancelAccount();
        //发票上传V2
        //String result =V2Uploadpdf();
        System.out.println(result);

    }
    //获取专票
    private static String queryInvoice() throws Exception {
        Map<String, Object> paramsMap = InvoiceBuildParam.buildQueryInvoiceParam();
        return HttpClientUtil.jsonPost(URLConfigEnum.QUERY_INVOICE.getUrl(), paramsMap);
    }

    //请求二维码信息
 /*   private static String insertForQRInvoice() throws Exception {
        Map<String, Object> paramsMap = InvoiceBuildParam.insertForQRInvoice();
        return HttpClientUtil.get(URLConfigEnum.INSERT_FOR_QR_INVOICE.getUrl(), paramsMap);
    }
*/
    //专票红冲状态查询接口
    private static String redStateTotal() throws Exception {
        Map<String, Object> paramsMap = InvoiceBuildParam.buildRedStateTotalParam();
        return HttpClientUtil.get(URLConfigEnum.RED_STATE_TOTAL.getUrl(), paramsMap);
    }

    //采购台账查询接口（新）
    private static String purchaseQuery() throws Exception {
        Map<String, Object> paramsMap = PurchaseParam.query();
        return HttpClientUtil.jsonPost(URLConfigEnum.PURCHASE_QUERY.getUrl(), paramsMap);
    }

    //模拟回调服务
    //要求 1、post请求   2、服务公网可访问  3、接收请求传过来的参数
    /*
    @PostMapping(value = "getTicketInfo")
    public Object getTicketInfo(@RequestBody JSONObject v2) {
        System.out.println(v2);
        return v2;
    }

     */

    //发票作废
    public static String invalid() throws Exception {
        Map<String, Object> paramMap = InvoiceBuildParam.buildInvalidParam();
        System.out.println(paramMap);
        return HttpClientUtil.post(URLConfigEnum.INVALID.getUrl(), paramMap);
    }

    //个人用户同步
    public static String syncUser() throws Exception {
        Object paramMap = ReimburseCollection.syncUser();
        return HttpClientUtil.jsonPost(URLConfigEnum.SYNC_USER.getUrl(), paramMap);
    }

    //发票打印
    public static String taxPrint() throws Exception{
        Map<String, Object> paramsMap = InvoiceBuildParam.buildTaxPrintParam();
        return HttpClientUtil.jsonPost(URLConfigEnum.TAX_PRINT.getUrl(), paramsMap);
    }

    //删除
    public static String invoiceApplyDel() throws Exception {
        Map<String, Object> paramsMap = InvoiceBuildParam.buildInvoiceApplyDelParam();
        return HttpClientUtil.post(URLConfigEnum.INVOICE_APPLY_DEL_URL.getUrl(), paramsMap);

    }

    //开票蓝票请求服务
    public static String insertWithArray() throws Exception {
        //构造POST表单Map
        Map<String, String> paramsMap = InvoiceBuildParam.buildInsertWithArrayPostParam();
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
        Map<String, Object> paramsMap = InvoiceBuildParam.insertWithSplit();
        return HttpClientUtil.post(URLConfigEnum.INSERT_WITH_SPLIT.getUrl(), (Map) paramsMap);
    }

    //开票状态查询服务
    public static String queryInvoiceStatus() throws Exception {
        //构造POST表单Map
        Map<String, String> paramsMap = InvoiceBuildParam.buildQueryInvoiceStatusPostParam();
        return HttpClientUtil.post(URLConfigEnum.QUERY_INBOICE_STATUS.getUrl(), (Map) paramsMap);
    }

    //开票申请审核通过
    public static String issue() throws Exception {
        Map<String, Object> paramsMap = InvoiceBuildParam.issue();
        return HttpClientUtil.post(URLConfigEnum.ISSUE.getUrl(), (Map) paramsMap);
    }

    //发票红冲请求服务
    public static String red() throws Exception {
        Map<String, Object> paramsMap = InvoiceBuildParam.red();
        return HttpClientUtil.post(URLConfigEnum.RED.getUrl(), (Map) paramsMap);
    }

    //电子发票部分红冲
    public static String partRed() throws Exception {
        Map<String, Object> paramsMap = InvoiceBuildParam.red();
        return HttpClientUtil.post(URLConfigEnum.PART_RED.getUrl(), (Map) paramsMap);
    }

    /**
     * 识别结果保存台帐
     */
    public static String OCR_Save() throws Exception {
        Map<String, Object> paramsMap = StaBookBuildParam.OCR_Save();
        //json格式
        return HttpClientUtil.jsonPost(URLConfigEnum.OCR_SAVE.getUrl(), paramsMap);
    }

    /**
     * 台账报销
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
     * 台账记账
     */
    public static String account() throws Exception {
        Map<String, Object> paramsMap = StaBookBuildParam.account();
        //json格式
        return HttpClientUtil.jsonPost(URLConfigEnum.ACCOUNT.getUrl(), paramsMap);
    }

    /**
     * 台账取消记账
     */
    public static String cancelAccount() throws Exception {
        Map<String, Object> paramsMap = StaBookBuildParam.cancelAccount();
        //json格式
        return HttpClientUtil.jsonPost(URLConfigEnum.CANCEL_ACCOUNT.getUrl(), paramsMap);
    }

    /**
     * 报销台账删除
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

    /**
     * 个人票夹提交发票到报销台账_全票种
     *
     * @return
     */
    public static String commit() throws Exception {
        Map<String, Object> paramsMap = StaBookBuildParam.commit();
        //json格式
        return HttpClientUtil.jsonPost(URLConfigEnum.COMMIT.getUrl(), paramsMap);
    }

    //发票上传
    public static String uploadpdf() throws Exception {
        Map<String, Object> paramsMap = ReimburseCollection.uploadpdf();
        return HttpClientUtil.jsonPost(URLConfigEnum.UPLOADPDF.getUrl(), paramsMap);

    }

    //发票取消上传
    public static String CollDelete() throws Exception {
        Map<String, Object> paramsMap = ReimburseCollection.CollDelete();
        return HttpClientUtil.jsonPost(URLConfigEnum.COLLECTION_DELETE.getUrl(), paramsMap);

    }

    //发票已报销
    public static String CollReimbursed() throws Exception {
        Map<String, Object> paramsMap = ReimburseCollection.CollReimbursed();
        return HttpClientUtil.jsonPost(URLConfigEnum.COLLECTION_REIMBURSED.getUrl(), paramsMap);

    }

    //发票取消报销
    public static String CollUnreimbursed() throws Exception {
        Map<String, Object> paramsMap = ReimburseCollection.CollUnreimbursed();
        return HttpClientUtil.jsonPost(URLConfigEnum.COLLECTION_UNREIMBURSED.getUrl(), paramsMap);

    }

    //报销台账查询接口（新）
    public static String CollQuery() throws Exception {
        Map<String, Object> paramsMap = ReimburseCollection.query();
        return HttpClientUtil.jsonPost(URLConfigEnum.QUERY.getUrl(), paramsMap);

    }
    //入账

    public static String accountStatus() throws Exception {
        Map<String, Object> paramsMap = ReimburseCollection.accountStatus();
        return HttpClientUtil.jsonPost(URLConfigEnum.ACCOUNT_STATUS.getUrl(), paramsMap);

    }

    //取消入账
    public static String CollCancelAccount() throws Exception {
        Map<String, Object> paramsMap = ReimburseCollection.CollCancelAccount();
        return HttpClientUtil.jsonPost(URLConfigEnum.COLLECTION_CANCEL_ACCOUNT.getUrl(), paramsMap);

    }

    //发票上传V2
    public static String V2Uploadpdf() throws Exception {
        Map<String, Object> paramsMap = ReimburseCollection.uploadpdf();
        return HttpClientUtil.jsonPost(URLConfigEnum.V2_UPLOADPDF.getUrl(), paramsMap);

    }
}
