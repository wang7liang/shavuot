package com.ws.shavuot.common.utils;

/**
 * Created by wghxynn on 16/7/8.
 */
public class MessageUtil {

    /**
     * 新增待办
     */
    public static final String ADD_CASETASK = "您有新的待办，请依据如下描述完成待办事项：";
    /**
     * 案件恢复-发送给案件管理顾问
     */
    public static final String RECOVERY_CASEENTRUST_ADVISOR = "您跟进的案件已恢复。";
    /**
     * 案件撤销--发送给案件管理顾问
     */
    public static final String REMOVE_CASEENTRUST_ADVISOR = "已撤销案件。";


    public static String getStringShareConnection(String caseTitle, String zhusu, String beisu, String lawyerName) {
        return "(" + caseTitle + ")" + zhusu + "与" + beisu + "诉讼案件今日应与" + lawyerName + "共享三方联系单";
    }

    public static String getStringConfirmCourtTime(String caseTitle, String zhusu, String beisu) {
        return "请确认(" + caseTitle + ")" + zhusu + "与" + beisu + "诉讼案件状态，是否收到出庭通知？并请您在收到出庭通知当日务必上传出庭通知书或者在系统内填录开庭日期或者通知案件管理顾问。";
    }

    public static String getConfirmBerforCourtConference(String caseTitle, String zhusu, String beisu) {
        return "请确认(" + caseTitle + ")" + zhusu + "与" + beisu + "诉讼案件是否需要庭前会议，如果需要庭前会议的 ，请在系统内确认庭前会议时间";
    }

    public static String getBerforCourt3Days(String caseTitle, String zhusu, String beisu, String courtTime) {
        return "(" + caseTitle + ")" + zhusu + "与" + beisu + "诉讼案件将于" + courtTime + "开庭，请准备好相关材料";
    }

    public static String getBerforCourt1Days(String caseTitle, String zhusu, String beisu, String courtTime, String courtPlace, String courtName) {
        return "(" + caseTitle + ")" + zhusu + "与" + beisu + "诉讼案件将在" + courtTime + "开庭，地点：" + courtName + "。";
    }

    public static String getBerforCourt0Days(String caseTitle, String zhusu, String beisu, String courtTime) {
        return "(" + caseTitle + ")" + zhusu + "与" + beisu + "诉讼案件请于三日内提交开庭报告";
    }

    public static String getAfterCourt10Days(String caseTitle, String zhusu, String beisu) {
        return "(" + caseTitle + ")" + zhusu + "与" + beisu + "诉讼案件有任何情况或收到判决书，请及时将结果反馈给无讼和（" + zhusu + "）";
    }

    public static String getAfterCourt3Days(String caseTitle, String zhusu, String beisu) {
        return "(" + caseTitle + ")" + zhusu + "与" + beisu + "诉讼案件请于今日提交开庭报告";
    }

    public static String getAfterCourt1Days(String caseTitle, String zhusu, String beisu) {
        return "请及时确认(" + caseTitle + ")" + zhusu + "与" + beisu + "诉讼案件是否需要庭后会议，如果需要庭后会议，请在系统内确认庭后会议时间";
    }

    //确认律师 给案件管理顾问发送消息
    public static String getConfirmLawyerToAdvisor(String createBy, String lawyerName) {
        return createBy + "已确认" + lawyerName + "为案件代理人";
    }

    //确认律师 给律师发送消息
    public static String getAddCaseEntrustMessageToOwner(String createBy) {
        return createBy + "已将您负责的案件录入系统，请继续跟进案件进展。";
    }

    public static String getAcceptCaseEntrustMessageToOwner(String createBy, String caseTitle) {
        return createBy + "已接案：" + caseTitle;
    }

    public static String getApplyEdit(String lawyerName, String caseEntrustUUID) {
        return lawyerName+"律师修改了"+caseEntrustUUID+"案的应征方案";
    }
    public static String sendFormEdit(String lawyerName,String entrustName, String caseEntrustUUID) {
        return String.format("%s您好，无讼案管%s给你发送了%s的应征表单，请尽快填写。",lawyerName,entrustName,caseEntrustUUID);
    }
    public static String sendConfirmedLawyer(String lawyerName,String title) {
        return String.format("%s您好，%s 的案件已经确认由您办理，请尽快登录无讼智能法务产品查看案件详情。",lawyerName,title);
    }

    /**
     * 新增会议-确认庭前会议时间
     *
     * @param caseTitle
     * @param zhusu
     * @param beisu
     * @param conferenceTime
     * @param timeLength
     * @return
     */
    public static String getConfimBerforCourtConference(String caseTitle, String zhusu, String beisu, String conferenceType, String conferenceTime, int timeLength) {
        return "(" + caseTitle + ")" + zhusu + "与" + beisu + "诉讼案件" + conferenceType + "将于" + conferenceTime + "召开，会议时长约" + timeLength + "分钟，请大家预留出相应时间";
    }

    /**
     * 批量-庭前会议提醒
     *
     * @param caseTitle
     * @param zhusu
     * @param beisu
     * @param conferenceTime
     * @param timeLength
     * @return
     */
    public static String getBerforCourtConferenceforNotice(String caseTitle, String zhusu, String beisu, String conferenceType, String conferenceTime, int timeLength) {
        return "(" + caseTitle + ")" + zhusu + "与" + beisu + "诉讼案件" + conferenceType + "是将于" + conferenceTime + "召开，会议时长约" + timeLength + "分钟，请大家准时参加";
    }

    /**
     * 新增委案
     */
    public static String getAddCaseEntrustToAdvisor(String caseTitle, String zhusu, String cityName, String caseType) {
        if (StringUtils.isBlank(caseType)) {
            caseType = "";
        }
        return "(" + caseTitle + ")" + zhusu + "委托" + cityName + "的" + caseType + "案件，待接案。";
    }


    /**
     * 新增委案
     */
    public static String sendApplyFormToLawyer(String advisor) {
        return advisor + "顾问已将律师信息采集表发送到您的邮箱，请及时填写，祝工作愉快";
    }


    /**
     * 新增委案
     */
    public static String getCustomerStatusFollow(String name, String status, Integer days) {
        return name + "已在" + status + "停留" + days + "天，请尽快跟进";
    }

    public static String getCustomerLevelFollow(String name, Integer days) {
        return "您已有" + days + "天没有跟进" + name + "天，请尽快跟进";
    }


    public static String deleteAssistMesage(String name, String companyName) {
        return name + "已将您从" + companyName + "的协助人中删除，请知晓。";
    }

    public static String addAssistMessage(String name, String companyName) {
        return name + "已添加您为" + companyName + "的协助人，请跟进客户。";
    }

    /**
     * 批量推荐律师
     * @param caseTitle
     * @param cityName
     * @param caseType
     * @param advisorName
     * @param num
     * @return
     */
    public static String batchRecommendApplyWithEmail(String caseTitle, String cityName, String caseType, String advisorName, Integer num) {
        if (StringUtils.isBlank(caseType)) {
            caseType = "";
        }
        return "(" + caseTitle + cityName + caseType + ")" + advisorName + "已为您推荐" + num + "位律师，请登陆您的邮箱查看。";
    }

    public static String batchRecommendApplyInSystem(String caseTitle, String cityName, String caseType, String advisorName, Integer num) {
        if (StringUtils.isBlank(caseType)) {
            caseType = "";
        }
        return "(" + caseTitle + cityName + caseType + ")" + advisorName + "已为您推荐" + num + "位律师，请登陆您登录系统查看。";
    }

    public static String addCaseApply(String lawyerName, String fireName, String caseUUID) {

        return String.format("%s 的 %s 提交了 %s 的应征方案",fireName,lawyerName,caseUUID);

    }
}
