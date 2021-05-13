package demo.test.output_invoice;

import demo.entity.output_invoice.InvoiceBuildParam;
import demo.utils.HttpClientUtil;
import demo.utils.URLConfigEnum;

import java.util.Map;

/**
 * @author: kw
 * @description: 发票打印相关的API测试入口类
 * @create: 2021/05/13 13:54
 */
public class InvoicePrintApiTest {
    public static void main(String[] args) throws Exception {
        /**
         * 发票打印 打印接口只支持纸质发票打印
         * */
        String result=taxPrint();
    }

    public static String taxPrint() throws Exception{
        Map<String, Object> paramsMap = InvoiceBuildParam.buildTaxPrintParam();
        return HttpClientUtil.jsonPost(URLConfigEnum.TAX_PRINT.getUrl(), paramsMap);
    }
}


