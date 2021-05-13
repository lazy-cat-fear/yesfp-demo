package demo.entity.input_ticket;

import demo.utils.Base64Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 台账
 */
public class StaBookBuildParam {
    /**
     * OCR识别
     * @return
     */
    public static Map<String, Object> buildRecognisePostParam() {
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("nsrsbh", "201609140000001");
      //  paramsMap.put("nsrsbh", "91110105MA0084MW37");
        paramsMap.put("orgcode", "20160914001");
      //  paramsMap.put("orgcode", "91110105MA0084MW37");
        //注意 base64编码不能有换行  选择BASE64Encoder需要将换行处理  用Base64比较好
        //paramsMap.put("file", Base64Util.imageToBase64("D:\\3.jpg"));
        paramsMap.put("file", Base64Util.NetImageToBase64("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1590057248&di=a298d5f9728d9ded45906a643d8b8b2d&src=http://5b0988e595225.cdn.sohucs.com/images/20180810/75d14550cff44cf4bcc0346dd50c3aae.jpeg"));//ImageToBase64("D:\\1.png"));
        return paramsMap;
    }
    /**
     * 识别结果保存台帐
     */
    public static Map<String,Object> OCR_Save(){
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("nsrsbh", "201609140000001");
        paramsMap.put("orgcode", "20160914001");
        paramsMap.put("bills",OCR_SaveBills());

        return paramsMap;
    }


    /**
     * 保存报销票据明细
     */
    public static List<Object> OCR_SaveBills(){
        List<Object> bills = new ArrayList<Object>();
        Map<String, Object> datas = new HashMap<String, Object>();
        datas.put("imageId","60214");
        datas.put("billType","train");
        datas.put("data", OCR_SaveTrainData());
        bills.add(datas);
        return bills;
    }
    /**
     * 机打发票data
     */
    public static Map<String,Object> OCR_SaveMachineData(){
        Map<String, Object> data = new HashMap<String, Object>();
        //开票日期"yyyyMMdd"
        data.put("date","20200610");
        //消费类型
        data.put("kind","交通");
        data.put("sellerName","销方名称");
        data.put("buyerName","购方名称");
        //发票代码
        data.put("invoiceCode","211001111013");
        //发票号码
        data.put("invoiceNum","87650531");
        //购方税号
        data.put("buyerTaxId","1234");
        //校验码
        data.put("checkCode","");
        //合计金额BigDecimal
        data.put("totalAmount",9);
        //报销状态
        data.put("purchaserStatus","");
        //买方税号
        data.put("sellerTaxId",12345);
        data.put("time","");

        return data;
    }
    /**
     * 增值税发票data
     *//*

    public static  Map<String, Object> OCR_SaveInvoiceData(){
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("hasExist",false);
        data.put("hjje",5000);
        data.put("xsfMc","成都郫县希望职业学校");
        data.put("gmfNsrsbh","");
        data.put("gmfMc","吴星君计算机应用");
        //售方纳税人识别号
        data.put("xsfNsrsbh","52510124551090719U");
        //发票id
        data.put("pkInvoice","0");
        data.put("jshj","5600");
        //作废标志
        data.put("zfbz","N");
        //发票代码
        data.put("fpDm","211001111012");
        //发票类型
        data.put("fplx","9");
        //报销状态
        data.put("purchaserStatus",0);
        data.put("hasattache",false);
        //开票日期
        data.put("kprq","20171018");
        //发票号码
        data.put("fpHm","87650531");
        //校验码
        data.put("jym","557129");
        //征税方式
        data.put("zsfs","0");
        //表体明细行
        data.put("items",items());
        return data;
    }
    public static List<Object>items(){
        List<Object> items = new ArrayList<Object>();
        Map<String, Object> item = new HashMap<String, Object>();
        //项目名称
        item.put("xmmc","服务费");
        //项目数量
        item.put("xmsl",1);
        //项目金额
        item.put("xmje","100");
        //税率
        item.put("sl",0.06);
        items.add(item);
        return items;
    }*/
    /**
     * 航空电子行程单DATA
     */
    public static  Map<String, Object> OCR_SaveAirData(){
        Map<String, Object> data = new HashMap<String, Object>();
        //开票日期"yyyyMMdd"
        data.put("date","20200610");
        data.put("id","20200610");
        data.put("fare",4444);

        data.put("agentCode","HKK068,08688003");
        data.put("issueBy","成都携程旅行社有限公司北京分社");
        //消费类型
        data.put("kind","交通");
        data.put("userName","www");
        data.put("userId","371102198004020527");
        data.put("caacDevelopFund",50);
        //校验码
        data.put("checkCode","");
        //合计金额BigDecimal
        data.put("totalAmount",9);
        data.put("ticketNum","8802175000276");
        //发票代码
        data.put("itemList",itemList());
        //发票号码
        data.put("fuelSurcharge",30);
        return data;
    }
    public static List<Object>itemList(){
        List<Object> items = new ArrayList<Object>();
        Map<String, Object> item = new HashMap<String, Object>();
        //项目名称
        item.put("id","111");
        //项目数量
        item.put("airId","123");
        item.put("date","20200610");
        //项目金额
        item.put("seat","Y");
        //税率
        item.put("carrier","海航");
        item.put("from","杭州");
        item.put("time","19:23");
        item.put("to","北京");
        item.put("flightNumber","HU7678");


        items.add(item);
        return items;
    }

    /**
     * 火车票台账data
     */
    public static  Map<String, Object> OCR_SaveTrainData(){
        Map<String, Object> data = new HashMap<String, Object>();
        //开票日期"yyyyMMdd"
        data.put("date","20200610");
        data.put("id","20200610");
        //消费类型
        data.put("kind","交通");
        data.put("origin","北京南");
        data.put("destination","北京北");
        data.put("number","P026491");
        //合计金额BigDecimal
        data.put("totalAmount",9);
        data.put("trainNum","G9");
        data.put("name","XXX");
        data.put("time","12:00");
        data.put("seatNo","二等座");

        return data;
    }

    /**
     * 出租车保存报销data
     * @return
     */

    public static  Map<String, Object> OCR_SaveTaxiData(){
        Map<String, Object> data = new HashMap<String, Object>();
        //发票代码
        data.put("invoiceCode","211001111012");
        //发票号码
        data.put("invoiceNum","87650531");
        //开票日期"yyyyMMdd"
        data.put("date","20200610");
        data.put("id","20200610");
        //消费类型
        data.put("kind","交通");
        //合计金额BigDecimal
        data.put("totalAmount",9);
        //里程
        data.put("mileage",8);
        //上车时间
        data.put("startTime","13:23");
        //结束时间
        data.put("endTime","13:25");
        //发票所在地
        data.put("place","黑龙江省哈尔滨市");
        return data;
    }



    /**
     * 台账报销
     */
    public static Map<String,Object> reimbursed(){
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("nsrsbh", "201609140000001");
        paramsMap.put("orgcode", "20160914001");
        paramsMap.put("bills",reimbursedBills());
        return paramsMap;

    }
    public static List<Object>  reimbursedBills(){
        List<Object> datas = new ArrayList<Object>();
        Map<String, Object> data = new HashMap<String, Object>();
        //发票代码
        data.put("invoiceCode","211001111012");
        //发票号码
        data.put("invoiceNum","87650531");
        data.put("billType","taxi");
        data.put("reimburseUser","XXX");
        datas.add(data);
        return datas;
    }
    /**
     * 台账取消报销
     */
    public static Map<String,Object> cancelReimbursed(){
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("nsrsbh", "201609140000001");
        paramsMap.put("orgcode", "20160914001");
        paramsMap.put("bills",reimbursedBills());
        return paramsMap;

    }
    /**
     * 台账记账
     */
    public  static Map<String, Object> account(){
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("nsrsbh", "201609140000001");
        paramsMap.put("orgcode", "20160914001");
        paramsMap.put("bills",accountBills());
        return paramsMap;
    }
    /**
     * 台账记账Bills
     */
    public  static List<Object> accountBills(){
        List<Object> datas = new ArrayList<Object>();
        Map<String, Object> data = new HashMap<String, Object>();
        //发票代码
        data.put("invoiceCode","211001111012");
        //发票号码
        data.put("invoiceNum","87650531");
        data.put("billType","taxi");
        data.put("accountUser","记账人");
        data.put("accountNote","记账人备注");
        datas.add(data);
        return datas;
    }
    /**
     * 台账取消记账
     */
    public  static Map<String, Object> cancelAccount(){
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("nsrsbh", "201609140000001");
        paramsMap.put("orgcode", "20160914001");
        paramsMap.put("bills",accountBills());
        return paramsMap;
    }
    /**
     * 报销台账删除
     */
    public  static Map<String, Object> delete(){
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("nsrsbh", "201609140000001");
        paramsMap.put("orgcode", "20160914001");
        paramsMap.put("bills",accountBills());
        return paramsMap;
    }
    /**
     * 飞机票、火车票，出租车台账查询
     */
    public static Map<String,Object> find(){
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("orgcode", "20160914001");
        paramsMap.put("submitDate_begin","2000-07-05");
        paramsMap.put("submitDate_end","2020-06-11");
        return paramsMap;
    }

    /**
     * 个人票夹提交发票到报销台账_全票种
     * @return
     */
    public static Map<String,Object> commit(){
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("usermobile", "15011181852");
        paramsMap.put("useremail", "wangyer@yonyou.com");
        paramsMap.put("orgcode", "20160914001");
        paramsMap.put("nsrsbh", "201609140000001");
        paramsMap.put("submitter", "提交人");
        paramsMap.put("srcBillCode", "23456789");
        paramsMap.put("srcBillType", "taxi");
        paramsMap.put("reimburseUser", "测试报销人1");
        paramsMap.put("returnEnclosure", "Y");
        paramsMap.put("busiOp", "1");
        paramsMap.put("summarys", summarys());
        return paramsMap;
    }
    public  static List<Object> summarys(){
    List<Object> datas = new ArrayList<Object>();
    Map<String, Object> data1 = new HashMap<String, Object>();
    Map<String, Object> data2 = new HashMap<String, Object>();
        data1.put("invoiceNum","68706393");
        data1.put("invoiceCode","042001700107");
        data1.put("billType","invoice");
        data2.put("invoiceNum","51266661");
        data2.put("invoiceCode","111001881002");
        data2.put("billType","taxi");
        datas.add(data1);
        datas.add(data2);
      return datas;
    }

}
