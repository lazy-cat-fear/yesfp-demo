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
    QUERY_INBOICE_STATUS("/invoiceclient-web/api/invoiceApply/queryInvoiceStatus?appid=");


    private String value;
    //测试环境有测试appid和证书，正式环境有正式appid和证书，请务必对应使用
    //测试环境appid就用这个，正式环境需要替换成正式的
    private static String APPID = "commontesterCA";
    //这个是测试环境的域名，正式环境为https://fapiao.yonyoucloud.com
    private static String DOMAIN = "https://yesfp.yonyoucloud.com";

    URLConfigEnum(String value) {
        this.value = value;
    }

    public String getUrl() {
        return DOMAIN + value + APPID;
    }

}
