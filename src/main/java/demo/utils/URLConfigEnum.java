package demo.utils;

/**
 * @description:  url的配置类
 * @author: kw
 * @date: 2020/5/21
 * @param:
 * @return:
 */
public enum URLConfigEnum {

    //如果需要测试其他接口 直接在这里添加枚举即可

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
    //pro22.pfx为测试环境通讯证书，正式环境需要替换成正式的
    KEY_PATH("src/main/resources/certificate/pro22.pfx"),
//    KEY_PATH("src/main/resources/certificate/正式环境通讯证书.pfx"),
    //证书密码
    PASSWORD("password");
//    PASSWORD("密码");

    //测试环境有测试appid和证书，正式环境有正式appid和证书，请务必对应使用
    //测试环境appid就用这个，正式环境需要替换成正式的
//    private static String APPID = "正式环境appid";
    private static String APPID = "commontesterCA";

    //这个是测试环境的域名，正式环境为https://fapiao.yonyoucloud.com
//    private static String DOMAIN = "https://fapiao.yonyoucloud.com";
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
