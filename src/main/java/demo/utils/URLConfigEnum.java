package demo.utils;

/**
 * @description:  url的配置类
 * @author: kw
 * @date: 2020/5/21
 * @param:
 * @return:
 */
public enum URLConfigEnum {

    //开票



    //受票



    //个人票夹

    //如果需要测试其他接口 直接在这里添加枚举即可
    //获取专票
    QUERY_INVOICE("/invoiceclient-web/api/vat/queryInvoice?appid="),
    //请求二维码信息
    INSERT_FOR_QR_INVOICE("/invoiceclient-web/api/invoiceApply/insertForQRInvoice?appid="),
    //专票红冲状态查询接口
    RED_STATE_TOTAL("/output-tax/api/invoiceApply/red/state/total?appid="),
    //采购台账
    PURCHASE_QUERY("/invoiceclient-web/api/purchase-collection/query?appid="),
    //发票作废
    INVALID("/invoiceclient-web/api/invoiceApply/invalid?appid="),
    //用户同步
    SYNC_USER("/piaoeda-web/api/einvoice/v2/sync-user?appid="),
    //发票打印
    TAX_PRINT("/output-tax/api/invoice-his/print?appid="),
    //开票申请删除
    INVOICE_APPLY_DEL_URL("/invoiceclient-web/api/invoiceApply/del?appid="),
    //开票蓝票请求服务
    INSERT_WITH_ARRAY_URL("/invoiceclient-web/api/invoiceApply/insertWithArray?appid="),
    //OCR识别接口
    RECOGNISE("/input-tax/api/ocr/v2/recognise?appid="),
    //开票状态查询服务
    QUERY_INBOICE_STATUS("/invoiceclient-web/api/invoiceApply/queryInvoiceStatus?appid="),
    //开票申请审核通过
    ISSUE("/invoiceclient-web/api/invoiceApply/issue?appid="),
    //发票红冲请求服务
    RED("/invoiceclient-web/api/invoiceApply/red?appid="),
    //电子发票部分红冲
    PART_RED("/invoiceclient-web/api/invoiceApply/part-red?appid="),
    //开票蓝票请求服务--发票拆分
   INSERT_WITH_SPLIT ("/invoiceclient-web/api/invoiceApply/insertWithSplit?appid="),
    //识别结果保存台帐
    OCR_SAVE("/input-tax/api/bill-collections/ocr-save?appid="),
    //台账报销
    REIMBURSED("/input-tax/api/bill-collections/reimbursed?appid="),
    //台账取消报销
    CANCEL_REIMBURSED("/input-tax/api/bill-collections/cancel-reimbursed?appid="),
    //台账记账
    ACCOUNT("/input-tax/api/bill-collections/account?appid="),
    //台账记账
    CANCEL_ACCOUNT("/input-tax/api/bill-collections/cancel-account?appid="),
    //报销台账删除
    DELETE("/input-tax/api/bill-collections/delete?appid="),
    //飞机票台账查询
    AIR("/input-tax/api/bill-collections/air?pagenum=1&pagesize=15&appid="),
    //火车票台账查询
    TRAIN("/input-tax/api/bill-collections/train?pagenum=1&pagesize=15&appid="),
    //出租车台账查询
    TAXI("/input-tax/api/bill-collections/taxi?pagenum=1&pagesize=15&appid="),
    //个人票夹提交发票到报销台账_全票种
    COMMIT("/piaoeda-web/api/bill/v2/commit?appid="),
    //发票上传
    UPLOADPDF("/invoiceclient-web/api/reimburseCollection/uploadpdf?appid="),
    //发票取消上传
    COLLECTION_DELETE("/invoiceclient-web/api/reimburseCollection/delete?appid="),
    //发票已报销
    COLLECTION_REIMBURSED ("/invoiceclient-web/api/reimburseCollection/reimbursed?appid="),
    //发票取消报销
    COLLECTION_UNREIMBURSED("/invoiceclient-web/api/reimburseCollection/unreimbursed?appid="),
    //报销台账查询接口（新）
    QUERY("/invoiceclient-web/api/reimburseCollection/query?appid="),
    //入账
    ACCOUNT_STATUS("/invoiceclient-web/api/reimburseCollection/accountStatus?appid="),
    //取消入账
    COLLECTION_CANCEL_ACCOUNT("/invoiceclient-web/api/reimburseCollection/cancelAccount?appid="),
    //发票上传V2
    V2_UPLOADPDF("/input-tax/api/reimburseCollection/v2/uploadpdf?appid="),
    //pro22.pfx为测试环境通讯证书，正式环境需要替换成正式的
   KEY_PATH("src/main/resources/certificate/pro22.pfx"),
//      KEY_PATH("src/main/resources/certificate/证书.pfx"),
    //证书密码
   PASSWORD("password");
//        PASSWORD(
//        "");


    //测试环境有测试appid和证书，正式环境有正式appid和证书，请务必对应使用
    //测试环境appid就用这个，正式环境需要替换成正式的
//      private static String APPID = "";
    private static String APPID = "commontesterCA";

    //这个是测试环境的域名，正式环境为https://fapiao.yonyoucloud.com
//    private static String DOMAIN = "https://tax.diwork.com"; //yonsuite yonbip 环境域名
//       private static String DOMAIN = "https://fapiao.yonyoucloud.com";
   private static String DOMAIN = "https://yesfp.yonyoucloud.com";

    private String value;
    URLConfigEnum(String value) {
        this.value = value;
    }

    public String getValue() {return value;}
    public String getUrl() {
        return DOMAIN + value + APPID;
    }
}
