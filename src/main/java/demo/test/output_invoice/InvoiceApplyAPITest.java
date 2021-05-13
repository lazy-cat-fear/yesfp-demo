package demo.test.output_invoice;

import demo.entity.output_invoice.InvoiceBuildParam;
import demo.test.APITest;
import demo.utils.HttpClientUtil;
import demo.utils.URLConfigEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author: kw
 * @description: 开票申请相关的API测试入口类
 * @create: 2021/05/13 13:53
 */
public class InvoiceApplyAPITest {


    private static Logger LOGGER = LoggerFactory.getLogger(APITest.class);

    public static void main(String[] args) throws Exception {
        String result = "";
        /**
         * 开蓝票
         * TIP
         * 每次请求的数据不能超过10张单据
         * 此接口只能用来开具蓝票
         * 签名载荷（Payload）中必须包含属性requestdatas，它的值为表单参数requestdatas的MD5值，具体使用方式参考样例代码示例
         *最小请求参数样例
         * 销售方地址及电话、银行及账号、销售方名称可以通过销售方纳税人识别号获取
         * 需要其他参数见税务云openapi
         * */
        result=insertWithArray();


        /**
         *开蓝票-自动拆分
         * 每次请求的数据不能超过10张单据
         * 此接口只能用来开具蓝票
         * 最小请求参数样例
         * 销售方地址及电话、银行及账号、销售方名称可以通过销售方纳税人识别号获取
         * 需要其他参数见税务云openapi
         *  */
        //result=insertWithSplit();


        /**
         * 开票状态查询
         * 只需要发票请求流水号
         * */
        //result=queryInvoiceStatus();


        /**
         * 发票红冲请求服务
         * 需要注意的是红冲会生成一个新的请求流水号  注意不是蓝字的发票请求流水号，是本次发票红冲的请求流水号
         * */
        //String result =red();


        /**
         * 开票申请审核通过
         * 此服务与开票蓝票请求服务、发票红冲请求服务配合使用。
         * 对于autoAudit=false的开票请求，通过调用此服务驱动开票。autoAudit=true时，不用调用此服务。
         * */
        //result=issue();

        /**
         * 电子发票部分红冲
         * */
        //String result =partRed();

        /**
         * 一些在openapi遗漏的功能
         * */

        /**
         * 发票申请删除
         * 申请删除是指将未开票的发票删除
         * 正在开票中的不允许删除
         * */
//        result=invoiceApplyDel();

        /**
         * 发票作废
         * 作废是指将不能开红的已开票的发票作废
         * */
//        result=invalid();


        System.out.println(result);


    }





    //开票蓝票请求服务
    public static String insertWithArray() throws Exception {
        //构造POST表单Map
        Map<String, String> paramsMap = InvoiceBuildParam.buildInsertWithArrayPostParam();
        System.out.println(paramsMap);
        return HttpClientUtil.post(URLConfigEnum.INSERT_WITH_ARRAY_URL.getUrl(), (Map) paramsMap);
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
    //发票作废
    public static String invalid() throws Exception {
        Map<String, Object> paramMap = InvoiceBuildParam.buildInvalidParam();
        System.out.println(paramMap);
        return HttpClientUtil.post(URLConfigEnum.INVALID.getUrl(), paramMap);
    }

    //开票申请删除
    public static String invoiceApplyDel() throws Exception {
        Map<String, Object> paramsMap = InvoiceBuildParam.buildInvoiceApplyDelParam();
        return HttpClientUtil.post(URLConfigEnum.INVOICE_APPLY_DEL_URL.getUrl(), paramsMap);
    }

}


