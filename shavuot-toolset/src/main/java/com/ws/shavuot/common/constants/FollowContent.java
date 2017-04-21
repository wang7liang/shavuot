package com.ws.shavuot.common.constants;

import com.ws.shavuot.common.exception.ProcessorException;
import com.ws.shavuot.common.utils.StringUtils;

import java.lang.reflect.Field;

/**
 * Created by lisong on 16/10/8.
 * 自动跟进事件 定义
 */
public class FollowContent {
    /**
     * 新增客户信息时的自动跟进
     */
    private static String FOLLOW_COMPANY_CREATE = "%s 录入了新客户。";
    /**
     * 发起委案
     * 谁 录入了委案信息
     *现改为 【企业】的 【职务】【谁】，发起了一个新的委托
     */
    private static String FOLLOW_ENTRUST_START = "%s 。";
    /**
     * 案管接案
     * 我已于【接案时间】接案
     */
    private static String FOLLOW_ENTRUST_ACCEPT = "我已于%s接案。";

    /**
     * 编辑委托详情
     * demo 我已编辑委托详情：+“原内容”+更改为+“更改内容”
     * 与企业沟通委托信息，将委托信息：+“原内容”+更改为+“更改内容”
     */
    private static String FOLLOW_ENTRUST_EDIT = "与企业沟通委托信息，将委托信息：%s。";
    /**
     * 编辑委托详情
     * demo 我已编辑委托详情：+“原内容”+更改为+“更改内容”
     * 与企业沟通委托信息，将委托信息：+“原内容”+更改为+“更改内容”
     */
    private static String FOLLOW_ENTRUST_EDIT_COURTTIME = "%s。";

    /**
     * 发送应征表单
     * demo 我已将应征表单发给+“律师姓名 ”+“律师事务所”
     * 内容发生了更改
     * 与【律师姓名】【（律师事务所）】沟通委托情况，已将应征信息采集表单邮件给该律师
     */
    private static String FOLLOW_ENTRUST_SEND_FORM = "与%s（%s）沟通委托情况，已将应征信息采集表单邮件给该律师。";
    /**
     * 编辑应征方案
     * demo XXX律师修改了BJ000001案的应征方案
     */
    private static String FOLLOW_ENTRUST_APPLY_EDIT = "%s";

    /**
     * 律师应征
     * demo “律师姓名”+“律师事务所”+已应征
     * [律师姓名][(律师事务所)]+已经提交应征信息。[收费方式]：［价格］。［办案方式］
     */
    private static String FOLLOW_ENTRUST_LAWYER_APPLY = "%s";

    /**
     * 案件管理顾问提交对律师的匹配度评价
     * demo “律师姓名”+“律师事务所”＋的匹配度评价已添加
     * 对【律师姓名】【（律师事务所）】的应征方案进行了评价：【评价内容】
     */
    private static String FOLLOW_ENTRUST_LAWYER_ASSESMENT = "%s。";

    /**
     * 案件管理顾问优先推荐律师后
     * demo 我已优先推荐+“律师事务所”+“律师姓名”＋律师
     */
    private static String FOLLOW_ENTRUST_LAWYER_PFEFER_RECOMMEND = "我已优先推荐 %s %s 律师。";

    /**
     * 取消优先推荐
     */
    private static String FOLLOW_ENTRUST_LAWYER_PFEFER_RECOMMEND_CANCEL = "我已取消优先推荐 %s %s 律师。";

    /**
     * 确认代理律师
     * demo 已确认＋“律师姓名”＋为代理律师
     * 与企业沟通后，确认本案代理律师：[律师姓名][(律师事务所)]
     */
    private static String FOLLOW_ENTRUST_CONFIRM_AGENT_LAWYER = "与企业沟通后，确认本案代理律师：%s(%s)";

    /**
     * 暂停
     * demo 本次案件委托已暂停：“暂停原因”
     */
    private static String FOLLOW_ENTRUST_PAUSE = "本次案件委托已暂停：%s。";

    /**
     * 恢复
     * demo 本次案件委托已恢复
     * 与企业方确认，案件恢复委托
     */
    private static String FOLLOW_ENTRUST_RECOVER = "与企业方确认，案件恢复委托。";

    /**
     * 撤销
     * demo 本次案件委托已撤销：“撤销原因”
     * 我已撤销本次案件委托：［撤销类型］。［撤销原因］
     */
    private static String FOLLOW_ENTRUST_CANCEL = "我已撤销本次案件委托：%s。%s。";

    /**
     * 结束招募
     */
    private static String FOLLOW_ENTRUST_LAWYER_WANT_END = "我已结束本案的招募律师工作。";

    /**
     * 案件管理人变更
     */
    private static String FOLLOW_ENTRUST_CHARGER_UPDATE = "%s";

    /**
     * 指派案件管理顾问
     */
    private static String FOLLOW_ENTRUST_ASSIGN_MANAGER = " %s";

    /**
     * 委案阶段安排会议后
     * demo 已安排会议+“会议时间”+“参加人员”
     * 我已安排［会议主题］。+会议时间：“会议时间”+；参与人员：“参加人员姓名”、"参会人员姓名"；预计时长：［时长］
     */
    private static String FOLLOW_CONFERENCE_ARRANGE = "%s。";

    /**
     * 案件新增会议
     * 我发起了一个实时会议，参会人员:[参会人员姓名]
     */
    private static String FOLLOW_CONFERENCE_CASE_ARRANGE = "我发起了一个实时会议，参会人员:%s";

    /**
     * 委案阶段会议提交改期后
     * demo 会议召开时间由“会议原定时间”变更为“＋新的会议时间”
     * 原定于【会议原定时间】召开的【会议主题】会议，会议时间变更为【新的会议时间】
     */
    private static String FOLLOW_CONFERENCE_DATE_CHANGE = " %s。";

    /**
     * 委案阶段会议确认取消后
     * demo "会议主题"+会议已被取消+“取消原因”
     * 原定于【会议原定时间】召开的【会议主题】会议，因故取消
     */
    private static String FOLLOW_CONFERENCE_CANCEL = "原定于%s召开的%s会议，因故取消。";

    /**
     * 委案阶段会议结束后
     * demo "会议主题"+会议已结束
     * 【会议主题】的会议于【结束时间】结束
     */
    private static String FOLLOW_CONFERENCE_END = "%s的会议于%s结束。";

    /**
     * 委案阶段会议纪要上传成功后
     * demo “会议主题”+上传会议纪要
     * 我已上传＋“会议主题”+的会议纪要
     */
    private static String FOLLOW_DOCUMENT_UPLOAD_CONFERENCE_SUMMARY = "我已上传%s的会议纪要。";

    /**
     * 调整参会人员
     * demo "会议主题"邀请：＋“被邀请人姓名”＋、＋“被邀请人姓名”
     * ［会议主题］的会议参会人员由［原参会人姓名］变更为［新参会人姓名］
     */
    private static String FOLLOW_CONFERENCE_PARTNER_ADJUSTMENT = " %s。";

    /**
     * 添加参会人员
     * 邀请［被邀请人姓名］、［被邀请人姓名］参加定于【会议时间】的［会议主题］的会议
     */
    private static String FOLLOW_CONFERENCE_ADD_MEMBER = "  %s。";

    /**
     * 上传文档
     * demo 文档：“《”＋“文档名”＋“》”＋已上传
     * 我已上传文档：“《”＋“文档名”＋“》”、“《”＋“文档名”＋“》”
     */
    private static String FOLLOW_DOCUMENT_UPLOAD_FILE = "我已上传文档：%s。";

    /**
     * 文档更新
     */
    private static String FOLLOW_DOCUMENT_FILE_UPDATE = "我已更新文档：《%s》。";


    /**
     * 委案阶段提交待办后
     * demo 新增待办：＋“待办事项”
     * 发起待办事项：＋“待办事项”。负责人：［待办负责人］，计划［待办截止时间］前完成
     */
    private static String FOLLOW_TODO_ADD = "%s。";

    /**
     * 委案阶段完成待办后
     * demo “待办事项”+已完成
     * 于【完成时间】完成［待办事项］
     */
    private static String FOLLOW_TODO_COMPLETE = "于%s完成%s。";

    /**
     * 委案阶段待办确认取消后
     * demo “待办事项”+已取消+“取消原因”
     * 于【取消时间】取消待办事项：【待办事项】，取消原因：【取消原因】
     */
    private static String FOLLOW_TODO_CANCEL = "%s";

    /**
     * 委案阶段待办确定新负责人后
     * demo 待办负责人由＋“原负责人姓名”＋变更为＋“新负责人姓名”
     * 【待办事项】的负责人由【原负责人】变更为【现负责人】
     */
    private static String FOLLOW_TODO_CHARGER_UPDATE = "%s。";

    /**
     * 编辑待办
     */
    private static String FOLLOW_TODO_UPDATE = "待办信息变更： %s ";



    /**
     * 新增案件跟进
     */
    private static String FOLLOW_CASE_ADD = "%s 录入了案件信息。";
    /**
     * 结案跟进
     * 【案件编号】已结案，结案原因：【结案原因】
     */
    private static String FOLLOW_CASE_END = "%s已结案，结案原因：%s。";
    /**
     * 案件编辑
     * 我已编辑案件信息：+“原内容”+更改为+“更改内容”
     */
    private static String FOLLOW_CASE_EDIT = "我已编辑案件信息：%s。";

    /**
     * 案件介绍后对律师评价
     * 对［律师姓名］［（律所名称）］进行了评价：［评价］
     */
    private static String FOLLOW_CASE_CHARGER_COMMENT_LAWYER = " %s。";

    /**
     * 案件新增律师
     * 我已邀请 ［律师姓名］［律所名称］办理本案
     */
    private static String FOLLOW_CASE_ADD_LAWYER = "我已邀请 %s %s办理本案";

    /**
     * 批量推荐律师跟进
     * 我已推荐＋“推荐律师数”位律师，分别为：＋“律师姓名”＋（＋“律所名称”＋）、＋“律师姓名”＋（＋“律所名称”＋）”
     */
    private static String FOLLOW_ENTRUST_LAWYER_BATCH_RECOMMEND = "我已推荐%s位律师，分别为：%s";

    /**
     * 新增案件或者委案的时候，同步跟进到客户
     */
    private static String FOLLOW_COMPANY_ADD_CASE_ENTRUST = "%s";

    /**
     * 客户新增待办
     */
    private static String FOLLOW_COMPANY_ADD_CASE_TASK = "新增待办：%s";

    /**
     * 新增商机
     */
    private static String FOLLOW_BUSSINESSOPPORTUNITY_ADD_FOLLOW = " %s新增了商机";
    /**
     * 根据跟进事件查找 sourceType
     * @param followCase
     * @return
     */
    @Deprecated
    public static  String getSourceTypeByFollowCase(String followCase){

        if(StringUtils.isBlank(followCase)){
            throw new ProcessorException("跟进事件参数不能为空");
        }
        if(followCase.indexOf("FOLLOW_ENTRUST")>-1){
            return Constants.TargetType.TARGET_CASE.getCode();
        }
        if(followCase.indexOf("FOLLOW_CONFERENCE")>-1){
            return Constants.TargetType.TARGET_CONFERENCE.getCode();
        }
        if(followCase.indexOf("FOLLOW_DOCUMENT")>-1){
            return Constants.TargetType.TARGET_DOCUMENT.getCode();
        }
        if(followCase.indexOf("FOLLOW_TODO")>-1){
            return Constants.TargetType.TARGET_TASK.getCode();
        }
        if(followCase.indexOf("FOLLOW_COMPANY")>-1){
            return Constants.TargetType.TARGET_COMPANY.getCode();
        }

        throw new ProcessorException("跟进事件参数不在可选范围内");
    }

    /**
     * 通过属性名字符串找对应的实体属性的值
     * @param fieldName
     * @return
     */
    public static String getValueByFieldName(String fieldName) {
        FollowContent followContent = new FollowContent();
        String value = "";
        try {
            Field field = followContent.getClass().getDeclaredField(fieldName);
            value = (String) field.get(followContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

}
