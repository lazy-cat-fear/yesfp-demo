package demo.entity.input_ticket;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: kw
 * @description: 采购台账
 * @create: 2021/03/02 10:20
 */
public class PurchaseParam {

    //采购台账查询接口（新）
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
        paramsMap.put("submitDate_end", "提交时期aaaaa-起始");
        paramsMap.put("kprq_begin", "开票日期-起始");
        paramsMap.put("kprq_end", "开票日期-结束");
        paramsMap.put("fplx", "发票类型");
        paramsMap.put("hasItems", "true");
        //从1开始
        paramsMap.put("page",1);
        paramsMap.put("size",5);
        return paramsMap;
    }

}
