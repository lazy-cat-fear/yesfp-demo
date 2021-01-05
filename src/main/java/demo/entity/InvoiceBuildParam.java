package demo.entity;

import com.google.gson.GsonBuilder;
import demo.utils.Base64Util;

import java.util.*;

/**
 * @program: yesfp-demo
 * @description: 开票
 * @author: kw
 * @create: 2020/05/21 12:41
 */
public class InvoiceBuildParam {

    /**
     * 构造 发票作废 表单数据
     */
    public static Map<String, Object> buildInvalidParam() {
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("requestdatas", buildInvalidRequestdatas());
        return paramsMap;
    }

    /**
     * 构造 发票打印 表单数据
     */
    public static Map<String, Object> buildTaxPrintParam() {
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        //发票代码
        paramsMap.put("fpDm", "200004275230");
        //发票号码
        paramsMap.put("fpHm", "23770399");
        paramsMap.put("orgCode", "20160914001");

        return paramsMap;
    }

    /**
     * 构造 开票状态查询服务 表单数据
     */
    public static Map<String, String> buildQueryInvoiceStatusPostParam() {
        Map<String, String> paramsMap = new HashMap<String, String>();
        paramsMap.put("fpqqlsh", buildFpqqlsh());
        return paramsMap;
    }

    /**
     * 构造 开票申请删除 表单数据
     */
    public static Map<String, Object> buildInvoiceApplyDelParam() {
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        List<Object> datas = new ArrayList<>();
        Map<String, String> requestdatas = new HashMap();
        requestdatas.put("FPQQLSH",buildFpqqlsh());
        requestdatas.put("XSF_NSRSBH","9144011476190205X4");
        datas.add(requestdatas);
        paramsMap.put("requestdatas", new GsonBuilder().create().toJson(datas));
        return paramsMap;
    }



    /**
     * 构造 开票蓝票请求服务 表单数据
     */
    public static Map<String, String> buildInsertWithArrayPostParam() {
        Map<String, String> paramsMap = new HashMap<String, String>();
        paramsMap.put("requestdatas", buildRequestDatas());
        //可以选填
        //paramsMap.put("email", buildEmailConfigs());
        //paramsMap.put("sms", buildSmsConfigs());
        paramsMap.put("url", buildUrlConfigs());
        paramsMap.put("autoAudit", "false");
        return paramsMap;
    }
    /**
     * 开票申请审核通过
     */
    public static Map<String, Object> issue(){
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("requestdatas", buildRequestDatas());
        paramsMap.put("autoAudit", true);
        return paramsMap;
}
    /**
     * 发票红冲请求服务
     *  电子发票部分红冲
     */
    public static  Map<String,Object> red(){
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("requestdatas", redRequestDatas());
        paramsMap.put("url", buildUrlConfigs());
        paramsMap.put("autoAudit", "false");
        return paramsMap;
    }
    /**
     * 开票蓝票请求服务--发票拆分
     */
    public static  Map<String,Object> insertWithSplit(){
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("requestdatas", buildRequestDatasSplit());
        paramsMap.put("url", buildUrlConfigs());
        paramsMap.put("autoAudit", "true");
        paramsMap.put("email",buildEmailConfigs());
        paramsMap.put("sms",buildSmsConfigs());
        return paramsMap;
    }

    /**
     * url回掉配置
     */
    private static String buildUrlConfigs() {
        List<Object> datas = new ArrayList<Object>();
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("fpqqlsh", buildFpqqlsh());
        data.put("url", "http://117.12.12.3:7787/EinvoiceRESTService/CallBackEInvoices/");
        datas.add(data);
        GsonBuilder builder = new GsonBuilder();
        return builder.create().toJson(datas);
    }

    /**
     * 构造短信发送信息
     */
    private static String buildSmsConfigs() {
        List<Object> datas = new ArrayList<Object>();
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("fpqqlsh", buildFpqqlsh());
        data.put("address", "155****3180");
        datas.add(data);
        GsonBuilder builder = new GsonBuilder();
        return builder.create().toJson(datas);
    }

    /**
     * 构造email发送信息
     */
    private static String buildEmailConfigs() {
        List<Object> datas = new ArrayList<Object>();
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("fpqqlsh", buildFpqqlsh());
        data.put("address", "j*****11@yonyou.com");
        datas.add(data);
        GsonBuilder builder = new GsonBuilder();
        return builder.create().toJson(datas);
    }

    /**
     * 构造requestdatas
     */
    private static String buildRequestDatas() {
        List<Object> datas = new ArrayList<Object>();
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("FPQQLSH", buildFpqqlsh());
        //测试环境请一定要使用测试纳税人识别号
        data.put("XSF_NSRSBH", "201609140000001");//91110105MA0084MW37
        data.put("GMF_MC", "广州佰仕德材料科技有限公司");
        data.put("GMF_NSRSBH", "91440101MA5CR3FU35");
        data.put("GMF_DZDH", "广州市花都区红棉大道北16号4楼4B07室 020-61796191");
        data.put("GMF_YHZH", "中国农业银行股份有限公司广州花都名门支行 44087001040011474");
        data.put("FPLX", "4");
        //组织编码，测试环境请一定使用测试环境的组织编码
        data.put("ORGCODE", "20160914001");//91110105MA0084MW37
        data.put("JSHJ", 2);
        data.put("items", buildItems());

        datas.add(data);
        GsonBuilder builder = new GsonBuilder();
        return builder.create().toJson(datas);
    }
    /**
     * 构造redRequestdatas
     */
    private static String redRequestDatas() {
        List<Object> datas = new ArrayList<Object>();
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("FPQQLSH", buildFpqqlsh());
        //蓝色发票代码
        data.put("fpDm", "044007679677");//91110105MA0084MW37
        //蓝色发票号码
        data.put("fpHm", "21427457");
        data.put("JSHJ", -1);
        data.put("items", buildItems());
      //  data.put("ORGCODE", "");//91110105MA0084MW37
        datas.add(data);
        GsonBuilder builder = new GsonBuilder();
        return builder.create().toJson(datas);
    }

    /**
     * 拆分
     * @return
     */
    private static String buildRequestDatasSplit() {
        List<Object> datas = new ArrayList<Object>();
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("FPQQLSH", buildFpqqlsh());
        //测试环境请一定要使用测试纳税人识别号
        data.put("XSF_NSRSBH", "201609140000001");//91110105MA0084MW37
        data.put("XSF_MC", "销售方名称");
        data.put("XSF_DZDH", "江苏省 无锡市   中国江苏省无锡市江阴市滨江西路");
        data.put("GMF_MC", "接口测试组织-请勿修改");
        data.put("GMF_MC", "接口测试组织-请勿修改");
        data.put("JSHJ", 2);
        data.put("items", buildItems());
       // data.put("items", buildItems1());
        datas.add(data);
        GsonBuilder builder = new GsonBuilder();
        return builder.create().toJson(datas);
    }
    /**
     * 构造request发票明细
     */
    private static List<Object> buildItems() {
        List<Object> items = new ArrayList<Object>();
        Map<String, Object> data1 = new HashMap<String, Object>();
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("XMJSHJ", 1);
        data.put("XMMC", "硅胶5299B");
        data.put("XMBM", "202020012");
        data.put("GGXH", "25kg/桶");
        data.put("DW", "千克");
        data.put("XMSL", 0);
       // data.put("SE", -57.52);
        //税率16%需要写成0.16的格式
        data.put("SL", 0.13);
        //SPBM字段为商品税收分类编码，不同的商品会有不同的编码，不对应的话会影响报税，需要咨询下公司财务
        data.put("SPBM", "1070213070000000000");
        items.add(data);

        data1.put("XMJSHJ", 1);
        data1.put("XMMC", "硅胶5299B");
        data1.put("XMBM", "202020012");
        data1.put("GGXH", "25kg/桶");
        data1.put("DW", "千克");
        data1.put("XMSL", 0);
        // data.put("SE", -57.52);
        //税率16%需要写成0.16的格式
        data1.put("SL", 0.13);
        //SPBM字段为商品税收分类编码，不同的商品会有不同的编码，不对应的话会影响报税，需要咨询下公司财务
        data1.put("SPBM", "1070213070000000000");
        items.add(data1);
        return items;
    }


    /**
     * 获取发票请求流水号
     * 长度不超过20位，长度在1到20位的字母和数字组合，不可以重复的，不要包含window系统文件名限制的特殊字符
     *
     * @return 发票请求流水号
     */
    private static String buildFpqqlsh() {
        return "1002A11000000013MW7a";
    }


    /**
     * 发票作废Requestdatas参数
     */
    private static String buildInvalidRequestdatas() {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("fpHm", "200004275230");
        data.put("fpDm", "23770399");
        GsonBuilder builder = new GsonBuilder();
        return builder.create().toJson(data);
    }

}
