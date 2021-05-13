package demo.test.personal_ticket_holder;

import demo.entity.input_ticket.StaBookBuildParam;
import demo.utils.HttpClientUtil;
import demo.utils.URLConfigEnum;

import java.util.Map;

/**
 * @author wrk
 * @time 2021-05-13 16:32
 * 个人全票种api测试类
 */
public class PersonalTicketTest {
    public static void main(String[] args) {

        String result = "";
        /**
         * ocr识别接口v2
         * */
        //result=recognise();

        /**
         * ocr接口图片预览接口
         * */

        /**
         * 个人票夹列表查询
         * */

        /**
         * 修改列表状态
         * */

        /**
         * 根据号码代码获取信息
         * */

        /**
         * 个人票价附件预览
         * */

        /**
         * 个人票夹附件下载
         * */

        /**
         *
         * 个人票夹新增
         * */

        /**
         *
         * 个人票夹删除
         * */

        /**
         *
         * 个人票夹修改
         * */

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
         * 个人票夹行程单预览
         * */

        /**
         * 个人票夹行程单下载
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

}

