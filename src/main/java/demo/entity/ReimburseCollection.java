package demo.entity;

import com.alibaba.fastjson.JSON;
import demo.utils.Base64Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReimburseCollection {

    //个人用户同步
    public static Object syncUser() {
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        List<Object> paramsList = new ArrayList<Object>();
        Map<String, Object> user = new HashMap<String, Object>();
        user.put("username","张三");
        user.put("mobile","13888888888");
        user.put("userMobile","userMobile");
        user.put("email","aaa@a.com");
        user.put("orgRelations","aaa@a.com");

        Map<String, Object> orgRelations = new HashMap<String, Object>();
        paramsList.add(user);
        paramsMap.put("requestdatas", JSON.toJSONString(paramsList));
        return paramsMap;
    }

    //用户组织关系同步
//    public static Map<String, Object> syncUserOrgs() {
//
//    }
    //发票上传V2
    public static Map<String, Object> uploadpdf() {
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        //用户账号
        paramsMap.put("usercode", "15011181852");
        paramsMap.put("useremail", "wangyer@yonyou.com");
        paramsMap.put("usermobile", "15011181852");
        paramsMap.put("nsrsbh", "915000006664268767");
        paramsMap.put("orgcode", "915000006664268767");
        paramsMap.put("pdfFiles", pdfFiles());
        return paramsMap;
    }

    public static List<Object> pdfFiles(){
        List<Object> files = new ArrayList<Object>();
        Map<String, Object> data = new HashMap<String, Object>();
        //选填
      // data.put("srcBillType","taxi");
     //   data.put("srcBillCode","23456789");
        data.put("fileName","机票-电子.pdf");
        data.put("content", Base64Util.imageToBase64("C:\\Users\\11055\\Desktop\\机票-电子1(1).pdf"));
        data.put("classification","交通");
        files.add(data);
        return files;
    }
    //发票取消上传
    public static Map<String, Object> CollDelete() {
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        //用户账号
        paramsMap.put("usercode", "15011181852");
        paramsMap.put("useremail", "wangyer@yonyou.com");
        paramsMap.put("usermobile", "15011181852");
        paramsMap.put("nsrsbh", "201609140000001");
        paramsMap.put("orgcode", "20160914001");
        paramsMap.put("invoices", invoices());
        return paramsMap;
    }
    public static List<Object> invoices(){
        List<Object> files = new ArrayList<Object>();
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("fpDm","061001901111");
        data.put("fpHm","59777884");
        data.put("voucherid","");
        data.put("accountUser","");
        data.put("accountNote","");
        files.add(data);
        return files;
    }
    //发票已报销
    public static Map<String, Object> CollReimbursed() {
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("nsrsbh", "201609140000001");
        paramsMap.put("orgcode", "20160914001");
        paramsMap.put("invoices", invoices());
        return paramsMap;
    }
    //发票取消报销
// unreimbursed
    public static Map<String, Object> CollUnreimbursed() {
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("nsrsbh", "201609140000001");
        paramsMap.put("orgcode", "20160914001");
        paramsMap.put("invoices", invoices());
        return paramsMap;
    }
    //报销台账查询接口（新）
    public static Map<String, Object> query() {
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("nsrsbh", "201609140000001");
        paramsMap.put("orgcode", "20160914001");
        paramsMap.put("fpHm", "");
        paramsMap.put("fpDm", "");
        paramsMap.put("xsfMc", "销售方名称");
        paramsMap.put("submitter", "提交人");
        paramsMap.put("reimburse_user", "报销人");
        paramsMap.put("submitDate_begin", "");
        paramsMap.put("submitDate_end", "提交时期-起始");
        paramsMap.put("kprq_begin", "开票日期-起始");
        paramsMap.put("kprq_end", "开票日期-结束");
        paramsMap.put("fplx", "发票类型");
        paramsMap.put("hasItems", "true");
        //从1开始
        paramsMap.put("page",1);
        paramsMap.put("size",5);
        return paramsMap;
    }
    //入账
    public static Map<String, Object> accountStatus() {
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("nsrsbh", "201609140000001");
        paramsMap.put("orgcode", "20160914001");
        paramsMap.put("invoices", invoices());
        return paramsMap;
    }
    //取消入账
    public static Map<String, Object> CollCancelAccount() {
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("nsrsbh", "201609140000001");
        paramsMap.put("orgcode", "20160914001");
        paramsMap.put("invoices", invoices());
        return paramsMap;
    }



}
