package demo.test.input_ticket;

import demo.entity.input_ticket.PurchaseParam;
import demo.entity.personal_ticket_holder.ReimburseCollection;
import demo.entity.input_ticket.StaBookBuildParam;
import demo.utils.HttpClientUtil;
import demo.utils.URLConfigEnum;

import java.util.Map;

/**
 * @author wrk
 * @time 2021-05-13 15:22
 * 采购台账API测试入口类
 */
public class PurchaseLedgerTest {
    public static void main(String[] args) throws Exception {
        String result="";
        /**
         *
         * 采购台账发票收票 (发票上传)
         * */
        //result =uploadpdf();

        /**
         * 采购台账发票取消收票 （发票取消上传）
         * */
        //result =CollDelete();

        /**
         * 采购台账查询接口
         * */
        //result=purchaseQuery();


        /**
         * 报销台账查询接口（新）
         * */
        // String result =CollQuery();


        /**
         * 入账
         * */
        //result = accountStatus();


        /**
         * 取消入账
         **/
        //result =CollCancelAccount();

        /**
         * 个人票夹发票提交到采购平台
         * */

        /**
         * 附件预览
         * */

        /**
         * 采购台账结算
         * */



        /**
         * 采购台账取消结算
         * */
    }


    /**
     * 采购台账查询接口
     * */
    private static String purchaseQuery() throws Exception {
        Map<String, Object> paramsMap = PurchaseParam.query();
        return HttpClientUtil.jsonPost(URLConfigEnum.PURCHASE_QUERY.getUrl(), paramsMap);
    }


    //个人用户同步
    public static String syncUser() throws Exception {
        Object paramMap = ReimburseCollection.syncUser();
        return HttpClientUtil.jsonPost(URLConfigEnum.SYNC_USER.getUrl(), paramMap);
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

}

