package demo.test.input_ticket;

import demo.entity.personal_ticket_holder.ReimburseCollection;
import demo.entity.input_ticket.StaBookBuildParam;
import demo.test.APITest;
import demo.utils.HttpClientUtil;
import demo.utils.URLConfigEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author wrk
 * @time 2021-05-13 15:21
 * 报销台账Api测试入口类
 */
public class ReimburseLedgerTest {


    private static Logger LOGGER = LoggerFactory.getLogger(APITest.class);

    public static void main(String[] args) throws Exception {
        String result = "";
        /**
         * ocr识别接口v2
         * */
        //result=recognise();


        /**
         * 识别结果保存台账
         * */
        //result=OCR_Save();

        /**
         * 台账报销
         * */
        //result=reimbursed();


        /**
         * 台账取消报销
         * */
        //result=cancelReimbursed();

        /**
         * 台账记账
         * */
        //result=account();

        /**
         * 台账取消记账
         * */
        //result=cancelAccount();

        /**
         * 报销台账删除
         * */
        //result=delete();

        /**
         * 飞机票台账查询
         * */
        //result=air();

        /**
         *  火车票台账查询
         * */
        //result=train();

        /**
         * 出租车台账查询
         * */
        //result=taxi();

        /**
         * 机打发票台账查询
         * */

        /**
         * 定额发票台账查询
         * */

        /**
         * 过路费发票台账查询
         * */

        /**
         * 客运汽车发票台账查询
         * */

        /**
         *报销台账查询详情信息接口
         *  */
        //result=CollQuery();

        /**
         *报销台账置支付状态接口
         * */

        /**
         *报销台账置取消支付状态接口
         * */

        /**
         * 报销台账更新凭证号接口
         * */


        System.out.println(result);


    }


    //OCR识别接口v2
    public static String recognise() throws Exception {
        //构造POST表单Map
        Map<String, Object> paramsMap = StaBookBuildParam.buildRecognisePostParam();
        //json格式
        return HttpClientUtil.jsonPost(URLConfigEnum.RECOGNISE.getUrl(), paramsMap);
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

    //报销台账查询接口（新）
    public static String CollQuery() throws Exception {
        Map<String, Object> paramsMap = ReimburseCollection.query();
        return HttpClientUtil.jsonPost(URLConfigEnum.QUERY.getUrl(), paramsMap);
    }
}

