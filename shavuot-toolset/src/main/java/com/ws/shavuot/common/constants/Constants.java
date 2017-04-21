package com.ws.shavuot.common.constants;

/**
 * <p>Description：数据字典类</p>
 * <p>Author：FranklinD</p>
 * <p>Date：2016年03月26日 10:10</p>
 * <p>Version 1.0</p>
 */
public class Constants {

    /**
     * 委案撤销默认类型
     */
    public static final String CASE_ENTRUST_DEFAULT_VALUE = "1010000002";
    /**
     * 推荐律师不满意
     */
    public static final String CASE_ENTRUST_DEFAULT_NAME = "推荐的律师不满意";

    /**
     * 跟进列表url
     */
    public static final String FOLLOW_LIST_URL = "/follow/list?targetId=%d&targetType=%s";

    /**********************************
     * 确认的参数
     **************************/
    public static final String LANG_UTF_8 = "UTF-8";
    public static final String SPLIT_STR = "|";
    public static final String SPLIT_STR_DOT = ".";
    public static final String SPLIT_STR_MARK = "、";
    public static final String DATA_TYPE_OPERATE = "operate";
    public static final String PAGE_INDEX = "pageIndex";
    public static final String PAGE_SIZE = "pageSize";

    public static final String INTERFACE_RESULT = "success";
    public static final String INTERFACE_CONTENT = "data";


    public static final String IMG_LARGE = "large";
    public static final String IMG_MEDIUM = "medium";
    public static final String IMG_SMALL = "small";
    /**
     * 常量比较数据
     */
    public static final int COUNT_0 = 0;
    public static final int COUNT_1 = 1;
    public static final int COUNT_2 = 2;
    public static final int COUNT_5 = 5;
    /**
     * 分页显示条数
     */
    public static final int PAGESIZE_0 = 0;
    public static final int PAGESIZE_1 = 1;
    public static final int PAGESIZE_2 = 2;
    public static final int PAGESIZE_3 = 3;
    public static final int PAGESIZE_5 = 5;
    public static final int PAGESIZE_10 = 10;
    public static final int PAGESIZE_30 = 30;

    /**
     * task 分列表标记
     */
    public static final String TASK_TYPE_FLAG = "type";
    public static final String TASK_TYPE_1 = "1";
    public static final String TASK_TYPE_2 = "2";
    public static final String TASK_TYPE_3 = "3";
    /**
     * 友好提示常量定义
     */
    public static final String RESP_MSG_APPLY_ADD_SUCCESS = "您已成功保存应征方案";
    public static final String RESP_MSG_APPLY_ADD_LAWYER_SUCCESS = "您已成功确认律师，请进入案件详情跟进案件进展";//// TODO: 2016/7/21 初步确认律师
    public static final String RESP_MSG_APPLY_CONFIRM_RECOMMAND = "您已成功优先推荐应征方案";
    public static final String RESP_MSG_APPLY_CANCEL_RECOMMAND = "取消推荐";
    public static final String RESP_MSG_APPLY_CHECK_PARAM_APPLYINFO = "应征方案不存在";
    public static final String RESP_MSG_APPLY_CHECK_PARAM_APPLYID = "应征方案ID为空";
    public static final String RESP_MSG_APPLY_CHECK_PARAM_ALREADY_RECOMMAND = "当前应征方案已经被推荐";
    public static final String RESP_MSG_APPLY_CHECK_PARAM_ALREADY_UNRECOMMAND = "当前应征方案已经被取消推荐";
    public static final String RESP_MSG_APPLY_EDIT_APPLY = "您已成功修改应征方案";
    public static final String RESP_MSG_APPLY_RECOMMAND_APPLY = "您已成功推荐应征方案";
    public static final String RESP_MSG_APPLY_CANCEL_RECOMMAND_APPLY = "您已成功取消推荐应征方案";
    //方案匹配度评价
    public static final String RESP_MSG_APPLY_CHECK_PARAM_EVALUATION = "应征方案评价内容为空";
    public static final String RESP_MSG_APPLY_CHECK_PARAM_EVALUATION_EXIST = "当前应征方案已评价";
    public static final String RESP_MSG_APPLY_EVALUATION_SUCCESS = "应征方案匹配度评价成功";
    //委托
    public static final String RESP_MSG_ENTRUST_ADD_ENTRUST = "您已成功发起案件委托";
    public static final String RESP_MSG_ENTRUST_ENTRUSTFORM = "您已成功发起委案表单";
    public static final String RESP_MSG_ENTRUST_APPLYFORM = "您已成功发送应征表单";
    public static final String RESP_MSG_ENTRUST_SAVE_APPLYFORM = "您已成功保存应征表单";
    public static final String RESP_MSG_ENTRUST_ACCEPT_ENTRUST = "您已成功接案";
    public static final String RESP_MSG_ENTRUST_ASSIGN_MANAGER = "您已成功指派案件管理顾问";
    public static final String RESP_MSG_ENTRUST_ADD_FOLLOW = "您已成功保存跟进";
    public static final String RESP_MSG_ENTRUST_EDIT_FOLLOW = "您已成功保存跟进";
    public static final String RESP_MSG_ENTRUST_DELETE_FOLLOW = "您已删除跟进";
    public static final String RESP_MSG_ENTRUST_EDIT_ENTRUST = "您已成功保存案件委托信息";
    public static final String RESP_MSG_ENTRUST_PAUSE_ENTRUST = "您已成功暂停案件委托";
    public static final String RESP_MSG_ENTRUST_RECOVER_ENTRUST = "您已成功恢复案件委托";
    public static final String RESP_MSG_ENTRUST_REVOCATION_ENTRUST = "您已成功撤销案件委托";
    public static final String RESP_MSG_ENTRUST_APPLY = "您已成功结束律师招募";
    public static final String RESP_MSG_ENTRUST_ADD_COURTTIME_SUCCESS = "您已成功设置开庭时间";
    //案件
    public static final String RESP_MSG_CASE_ADD_CASE = "您已成功新增案件";
    public static final String RESP_MSG_CASE_EDIT_CASE = "您已成功修改案件信息";
    public static final String RESP_MSG_CASE_ADD_CONFERENCE = "您已成功安排会议";
    public static final String RESP_MSG_CASE_ADD_TASK = "您已成功发起待办";
    public static final String RESP_MSG_CASE_ADD_FOLLOW = "您已成功保存跟进";
    public static final String RESP_MSG_CASE_END_CASE = "您已成功结案";
    public static final String RESP_MSG_CASE_ASSESS_LAWYER = "您已成功评价律师";
    public static final String RESP_MSG_CASE_ADD_LAWYER = "您已成功保存律师";
    //代办
    public static final String RESP_MSG_TASK_CANCEL_TASK = "您已成功取消待办";
    public static final String RESP_MSG_TASK_COMPLETE_TASK = "您已成功完成待办";
    public static final String RESP_MSG_TASK_EDIT_TASK = "您已成功修改待办";
    public static final String RESP_MSG_TASK_ASSIGNEE_TASK = "您已成功修改待办";
    public static final String RESP_MSG_TASK_UPLOAD_DOCUMENT = "您已成功上传文档";
    public static final String RESP_MSG_TASK_DEL_DOCUMENT = "您已成功删除文档";
    //会议
    public static final String RESP_MSG_CONFERENCE_ADD = "您已成功发起会议";
    public static final String RESP_MSG_CONFERENCE_DELETE_DOCUMENT = "您已成功删除会议纪要";
    public static final String RESP_MSG_CONFERENCE_UPLOAD_DOCUMENT = "您已成功上传会议纪要";
    public static final String RESP_MSG_CONFERENCE_UPDTE_CHANGETIME = "您已成功改期";
    public static final String RESP_MSG_CONFERENCE_CANCEL_CONFERENCE = "您已成功取消会议";
    public static final String RESP_MSG_CONFERENCE_EDIT_CONFERENCE = "您已成功修改会议信息";
    public static final String RESP_MSG_CONFERENCE_UPDTE_ADDPARTICIPANT = "您已成功邀请会议参与人";
    //文档
    public static final String RESP_MSG_DOCUMENT_DEL_DOCUMENT = "您已成功删除文档";
    public static final String RESP_MSG_DOCUMENT_UPLOAD_DOCUMENT = "您已成功上传文档";
    public static final String RESP_MSG_DOCUMENT_REUPLOAD_DOCUMENT = "您已成功上传文档";


    public static final String RESP_MSG_CUSTOMER_CONTACT_ADD = "您已成功保存客户联系人";
    public static final String RESP_MSG_CUSTOMER_CONTACT_DEL = "您已成功删除客户联系人";
    public static final String RESP_MSG_CUSTOMER_CONTACT_UPDATE = "您已成功修改客户联系人";

    public static final String RESP_MSG_CUSTOMER_ADD = "您已成功保存客户信息";
    public static final String RESP_MSG_CUSTOMER_DEL = "您已成功删除客户信息";
    public static final String RESP_MSG_CUSTOMER_UPDATE = "您已成功修改客户信息";
    public static final String RESP_MSG_CUSTOMER_ADD_ASSIST = "您已成功保存协助人";
    public static final String RESP_MSG_CUSTOMER_ADD_MANAGER = "您已成功保存负责人";
    public static final String RESP_MSG_CUSTOMER_ADD_FOLLOW = "您已成功保存跟进";
    public static final String RESP_MSG_CUSTOMER_UPDATE_STATUS = "您已成功修改状态";
    public static final String RESP_MSG_CUSTOMER_ADD_CONTACT = "您已成功新增联系人";
    public static final String RESP_MSG_CUSTOMER_DELETE_CONTACT = "您已成功删除客户联系人";

    public static final String RESP_MSG_BUSINESSOPPORTUNITY_CLAIM_MANAGER = "您已成功认领商机";
    public static final String RESP_MSG_BUSINESSOPPORTUNITY_ADD_ENTRUST = "您已成功转化商机";
    public static final String RESP_MSG_BUSINESSOPPORTUNITY_ADD = "您已成功保存商机";


    //文档存放路径
    public static final String DOUCMENT_FILE_SAVE_PATH = "uploads/";

    //新浪短链配置信息
    public static final String sinaShortUrl = "http://api.t.sina.com.cn/short_url/shorten.json";
    public static final String sinaAppKey = "3271760578";

    /**
     * 委案和案件合并后的关系类型定义
     * 20161108
     */
    public enum TargetType {

        TARGET_CASE("1", "案件"),
        TARGET_TASK("2", "待办"),
        TARGET_CONFERENCE("3", "会议"),
        TARGET_DOCUMENT("4", "文档"),
        TARGET_FOLLOW("5", "跟进"),
        //        TARGET_CONFERENCESUMMARY("6", "会议纪要"),
        TARGET_APPLY("8", "应征"),
        TARGET_USER("9", "用户"),
        TARGET_COMPANY("10", "公司"),
        TARGET_MARKET("11", "商机"),
        TARGET_CONTRACT("16", "合同");

        private String code;
        private String name;

        public String getCode() {
            return code;
        }

        TargetType(String code, String name) {
            this.code = code;
            this.name = name;
        }
    }

    public enum DictType {
        ROLE_TYPE("1000", "系统角色"),
        TRILROUND("1001", "审理程序"),
        CASE_ENTRUST_POSITION("1002", "诉讼地位"),
        CASE_APPLY_RECOMMAND_STATUS("1003", "应征方案推荐"),
        CASE_APPLY_COMMENT_STATUS("1004", "应征方案评价状态"),
        CHOOSE_TYPE("1005", "遴选方式"),
        CHARGE_TYPE("1006", "付费方式"),
        WORK_YEARS("1007", "执业年限要求"),
        ATTENTION_EMPHASIS("1008", "专业能力"),
        SIMILAR_CASE_EXPERIENCE("1009", "相似案例"),
        CONFERENCE_STATUS("1014", "会议状态"),
        CONFERENCE_TYPE("1011", "会议类型"),
        PURPOSE("1015", "诉讼目的"),
        LAWYER_POSITION("1018", "律师职位"),
        CASE_STATUS("1025", "案件状态"),
        TASK_STATUS("1027", "待办状态"),
        LAWYER_STATUS("1028", "律师状态"),
        CASE_APPLY_STATUS("1029", "应征方案状态"),
        CASE_END_DESC("1032", "结案说明"),
        CASE_ENTRUST_STATUS("1033", "委案状态"),
        LAWYER_WORK_TYPE("1035", "办案类型"),
        LAWYER_TEAMPOSITION("1036", "律师团队职位"),
        CASE_ENTRUST_CONVERT_STATUS("1037", "委案转案件状态"),
        CASE_ENTRUST_REVOKE("1010", "委案撤销类型"),
        //FEE_SCOPE("1038", "标的额范围"),
        FEE_SCOPE("1038", "标的额范围"),
        COMPANY_LAWYER_STATUS("1040", "企业律师状态"),
        DOCUMENTTYE("1041", "文档分类"),
        CASE_ENTRUST_CHARGE_TYPE("1042", "委案倾向付费方式"),


        CUSTOMER_LEVEL("2001", "客户级别"),
        CUSTOMER_TYPE("2002", "客户性质"),
        CUSTOMER_TEAMWORKLAWYER("2003", "外部合作律师"),
        CUSTOMER_STATUS("2004", "客户状态"),
        CUSTOMER_STATUS_BANFA("2010", "办法客户状态"),
        CUSTOMER_SOURCE("2005", "客户来源"),
        CUSTOMER_SOURCE_BANFA("2012", "客户来源"),
        CUSTOMER_POSITION("2006", "职位"),
        CUSTOMER_FOLLOWTYPE("2007", "跟进类型"),
        CUSTOMER_FOLLOWTYPE_BANFA("2011", "办法客户状态"),
        CUSTOMER_DECISION("2008", "关键决策人"),
        KA_STATUS("2013", "KA客户状态"),
        CUSTOMER_SIZE("3001", "企业规模"),
        CUSTOMER_LAWWORKER_INFO("3002", "法务团队情况"),
        CASE_TYPE("1017", "案件类型"),
        YISHEN("1043", "一审"),
        ERSHEN("1044", "二审"),
        ZAISHEN("1045", "再审"),
        ZHIXING("1046", "执行"),
        ZHONGCAI("1047", "仲裁"),
        OTHERSTAGE("1049", "其它"),
        CASESOURCE("1048", "案件来源"),
        ENTRUSTORTYPE("1050", "商机委托方类型"),
        DEMANDTYPE("1051", "商机找律师需求"),
        QUERYTYPE("1053", "律师列表-律师库||应征库"),
        CONTRACTTYPE("5003", "合同类型"),
        CONTRACTCHECKRESULT("5007", "合同审核结果");


        private String code;
        private String name;

        public String getCode() {
            return code;
        }

        DictType(String code, String name) {
            this.code = code;
            this.name = name;
        }
    }

    /**
     * 审理程序
     */
    public enum TRILROUND {
        YISHEN("1001000001", "一审"),
        ERSHEN("1001000002", "二审"),
        ZAISHEN("1001000003", "再审"),
        ZHIXING("1001000006", "执行"),
        ZHONGCAI("1001000005", "仲裁"),
        OTHER("1001000004", "其它");

        private String code;
        private String name;

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        TRILROUND(String code, String name) {
            this.code = code;
            this.name = name;
        }
    }

    /**
     * 菜单类型
     */
    public enum MenuType {
        CASE_ENTRUST(2, "委托"),
        CASE_RESOURCE(3, "案源"),
        TASK(5, "待办"),
        CONFERENCE(6, "会议"),
        DOCUMENT(7, "文档"),
        LAWYER(8, "律师"),
        APPLY(9, "应征"),
        APPLY_LAWYER(10, "我的应征"),
        MESSAGE(11, "消息"),
        MARKET_CUSTOMER(12, "客户"),
        Market(13, "商机"),
        APPLYS(15, "应征"),
        CONTRACT(16, "合同"),
        COLLECTION(17, "收款"),
        PAYMENT(18, "付款"),
        BANFA_CUSTOMER(19, "客户");

        private Integer code;
        private String name;

        public Integer getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        MenuType(Integer code, String name) {
            this.code = code;
            this.name = name;
        }

        public static String getName(int code) {
            for (MenuType type : values()) {
                if (type.getCode() == code) {
                    return type.getName();
                }
            }
            return null;
        }
    }

    /**
     * 角色类型
     */
    public enum RoleType {
        MANAGER(1, "案件管理顾问"),
        MANAGER_LEADER(10, "案管总监"),
        LAW_WORKER(2, "法务"),
        LAW_WORKER_MANAGER(20, "法务总监"),
        LAWYER(3, "律师"),
        MARKETING(4, "市场部人员"),
        MARKETING_MANAGER(40, "市场部总监"),
        BANFA(5, "办法部人员"),
        BANFA_MANAGER(50, "办法部总监"),
        FINANCIALSTAFF(6, "财务人员"),
        PROJECTASSISTANT(7, "PA"),
        CEO(8, "CEO"),
        ROOT(9, "系统管理员");

        private Integer code;
        private String name;

        public Integer getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        RoleType(Integer code, String name) {
            this.code = code;
            this.name = name;
        }
    }

    /**
     * 邮件消息类型
     */
    public enum EmailMessageType {
        ENTRUSTFORM("1", "委案表单"),
        APPLYFORM("2", "应征表单"),
        APPLYDETAIL("3", "应征详情");

        private String code;
        private String name;

        public String getCode() {
            return code;
        }

        EmailMessageType(String code, String name) {
            this.code = code;
            this.name = name;
        }
    }

    /**
     * 邮件消息状态
     */
    public enum EmailMessageStatus {
        TODO("1", "未完成"),
        DONE("2", "完成");


        private String code;
        private String name;

        public String getCode() {
            return code;
        }

        EmailMessageStatus(String code, String name) {
            this.code = code;
            this.name = name;
        }
    }

    /**
     * 接口访问类型
     */
    public enum RequestMethodType {
        GET("1", "GET"),
        POST("2", "POST"),
        PUT("3", "PUT"),
        DELETE("4", "DELETE");

        private String code;
        private String name;

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public static String getCode(String name) {
            for (RequestMethodType type : values()) {
                if (type.getName().equals(name)) {
                    return type.getCode();
                }
            }
            return null;
        }

        RequestMethodType(String code, String name) {
            this.code = code;
            this.name = name;
        }
    }

    /**
     * 律师团队办案成员类型
     */
    public enum CaseApplyMemberTeamPosition {
        MAIN_LAWYER("1036000001", "主办律师"),
        HELP_LAWYER("1036000002", "辅助律师");

        private String code;
        private String name;

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        CaseApplyMemberTeamPosition(String code, String name) {
            this.code = code;
            this.name = name;
        }
    }

    /**
     * 案件状态枚举
     */
    @Deprecated
    public enum CaseStatus {
        DOING("1025000001", "进行中"),
        DONE("1025000002", "已结案");

        private String code;
        private String title;

        CaseStatus(String code, String title) {
            this.code = code;
            this.title = title;
        }

        public String getCode() {
            return code;
        }
    }

    /**
     * 案件状态枚举
     */
    public enum CASESOURCE {

        MARKET("1048000001", "市场推广"),
        OLDCUSTOMER("1048000002", "熟人推荐"),
        WUSONGHEZUO("1048000003", "无讼合作"),
        WUSONGBANFA("1048000004", "无讼办法"),
        WEBCHART("1048000005", "线上微信群"),
        OFFLINEACTIVITY("1048000006", "线下活动转化"),
        ENTRUSTAGAIN("1048000007", "再次委托"),
        FROMLAWWORK("1048000008", "法务自主发起");

        private String code;
        private String title;

        CASESOURCE(String code, String title) {
            this.code = code;
            this.title = title;
        }

        public String getCode() {
            return code;
        }
    }

    /**
     * 会议类型
     */
    public enum ConferenceType {

        CASE_CONFERENCE("1", "案件会议");

        private String code;
        private String title;

        ConferenceType(String code, String title) {
            this.title = title;
            this.code = code;
        }

        public String getCode() {
            return code;
        }

    }

    /**
     * 会议状态枚举
     */
    public enum ConferenceStatus {
        NOT_START("1014000002", "未开始"),
        BEGINING("1014000001", "进行中"),
        OVER("1014000003", "已结束"),
        CANCEL("1014000004", "已取消");

        private String title;
        private String code;

        ConferenceStatus(String code, String title) {
            this.title = title;
            this.code = code;
        }

        public String getCode() {
            return code;
        }

    }

    /**
     * 会议类型枚举
     */
    public enum ConferenceStageType {
        BEFORECOURTCONFERENCE("1011000001", "庭前会议"),
        USUALCONFERENCE("1011000002", "讨论会"),
        AFTERCOURTCONFERENCE("1011000003", "庭后复盘会议");

        private String title;
        private String code;

        ConferenceStageType(String code, String title) {
            this.title = title;
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getTitle() {
            return title;
        }
    }

    /**
     * 会议参与人状态枚举
     */
    public enum ConferenceParticipantStatus {
        NOT_CALL("2010000001", "未发起"),
        NOT_CONNECT("2010000002", "未接通"),
        CONNECTED("2010000003", "已接通"),
        DISCONNECTED("2010000004", "已挂断");

        private String title;
        private String code;

        ConferenceParticipantStatus(String code, String title) {
            this.title = title;
            this.code = code;
        }

        public String getCode() {
            return code;
        }

    }

    /**
     * 委案应征方案是否优选枚举
     */
    public enum CaseApplyOptimizeFlag {

        TRUE("1", "优选"),
        FALSE("2", "不优选");

        private String code;
        private String name;

        CaseApplyOptimizeFlag(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }
    }

    /**
     * 委案转化状态
     */
    public enum CaseEntrustConvertStatus {
        CONVERT("1037000001", "已转化为案件"),
        UNCONVERT("1037000002", "尚未转化为案件"),
        FROM_CASE("1037000003", "新增案件");

        private String code;
        private String title;

        public String getCode() {
            return code;
        }

        CaseEntrustConvertStatus(String code, String title) {
            this.code = code;
            this.title = title;
        }
    }

    public enum UserStatus {
        NORMAL("1", "有效"),
        UNNORMAL("2", "无效");

        private String code;
        private String name;

        public String getCode() {
            return code;
        }

        UserStatus(String code, String name) {
            this.code = code;
            this.name = name;
        }
    }

    public enum MessageTypeEnum {
        READ(0, "已读"),
        UNREAD(1, "已读");

        private Integer code;
        private String name;

        public Integer getCode() {
            return code;
        }

        MessageTypeEnum(Integer code, String name) {
            this.code = code;
            this.name = name;
        }
    }

    /**
     * 跟进事件枚举
     */
    public enum FollowCase {
        FOLLOW_ENTRUST_ACCEPT,
        FOLLOW_ENTRUST_CHARGER_UPDATE,
        FOLLOW_ENTRUST_START,
        FOLLOW_ENTRUST_EDIT,
        FOLLOW_ENTRUST_EDIT_COURTTIME,
        FOLLOW_ENTRUST_SEND_FORM,
        FOLLOW_ENTRUST_LAWYER_APPLY,
        FOLLOW_ENTRUST_LAWYER_ASSESMENT,
        FOLLOW_ENTRUST_LAWYER_PFEFER_RECOMMEND,
        FOLLOW_ENTRUST_LAWYER_PFEFER_RECOMMEND_CANCEL,
        FOLLOW_ENTRUST_CONFIRM_AGENT_LAWYER,
        FOLLOW_ENTRUST_PAUSE,
        FOLLOW_ENTRUST_RECOVER,
        FOLLOW_ENTRUST_CANCEL,
        FOLLOW_ENTRUST_LAWYER_BATCH_RECOMMEND,
        FOLLOW_ENTRUST_LAWYER_WANT_END,
        FOLLOW_ENTRUST_ASSIGN_MANAGER,
        FOLLOW_CONFERENCE_ARRANGE,
        FOLLOW_CONFERENCE_CASE_ARRANGE,
        FOLLOW_CONFERENCE_DATE_CHANGE,
        FOLLOW_CONFERENCE_CANCEL,
        FOLLOW_CONFERENCE_END,
        FOLLOW_CONFERENCE_PARTNER_ADJUSTMENT,
        FOLLOW_CONFERENCE_ADD_MEMBER,
        FOLLOW_DOCUMENT_UPLOAD_CONFERENCE_SUMMARY,
        FOLLOW_DOCUMENT_UPLOAD_FILE,
        FOLLOW_DOCUMENT_FILE_UPDATE,
        FOLLOW_TODO_ADD,
        FOLLOW_TODO_COMPLETE,
        FOLLOW_TODO_CANCEL,
        FOLLOW_TODO_CHARGER_UPDATE,
        FOLLOW_TODO_UPDATE,
        FOLLOW_CASE_ADD,
        FOLLOW_CASE_END,
        FOLLOW_CASE_EDIT,
        FOLLOW_CASE_CHARGER_COMMENT_LAWYER,
        FOLLOW_CASE_ADD_LAWYER,
        FOLLOW_ENTRUST_APPLY_EDIT,
        FOLLOW_COMPANY_ADD_CASE_ENTRUST,
        FOLLOW_COMPANY_ADD_CASE_TASK,
        FOLLOW_COMPANY_CREATE,
        FOLLOW_BUSSINESSOPPORTUNITY_ADD_FOLLOW
    }

    /**
     * 跟进类型枚举
     */
    public enum FollowVisibleStatus {
        INTERNALVISIBLE("1", "仅内部可见"),
        OUTVISIBLE("2", "全部可见");

        private String title;
        private String code;

        FollowVisibleStatus(String code, String title) {
            this.title = title;
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

    /**
     * 支付方式枚举
     */
    public enum ChargeType {
        PRICE_ONCE("1006000001", "一次性付费"),
        PRICE_RISK("1006000002", "风险代理");

        private String code;
        private String title;

        public String getCode() {
            return code;
        }

        public String getTitle() {
            return title;
        }

        ChargeType(String code, String title) {
            this.code = code;
            this.title = title;
        }
    }

    public enum CaseEntrsutChargeType {
        PRICE_ONCE("1042000001", "一次性付费"),
        PRICE_RISK("1042000002", "风险代理"),
        BOTH("1042000003", "两者兼有");

        private String code;
        private String title;

        public String getCode() {
            return code;
        }

        CaseEntrsutChargeType(String code, String title) {
            this.code = code;
            this.title = title;
        }
    }


    public enum TaskStatusEnum {
        ONGOING("1027000001", "进行中"),
        COMPLETE("1027000002", "已完成"),
        OUTLIMIT("1027000003", "已逾期"),
        CANCALE("1027000004", "已取消");

        private String code;
        private String name;

        public String getCode() {
            return code;
        }

        TaskStatusEnum(String code, String name) {
            this.code = code;
            this.name = name;
        }
    }

    /**
     * 应征方案办案方式（团队、个人）
     */
    public enum CaseApplyWorkMethod {
        SINGLE("1035000001", "个人办案"),
        TEAM("1035000002", "团队办案");

        private String code;
        private String name;

        public String getCode() {
            return code;
        }

        CaseApplyWorkMethod(String code, String name) {
            this.code = code;
            this.name = name;
        }
    }

    /**
     * 相似案例类型
     */
    public enum CaseApplySimilarCaseTypeEnum {
        SIMILAR_REASON("1", "相似案由案件"),
        SIMILAR_COURT("2", "相近法院案件");

        private String code;
        private String name;

        CaseApplySimilarCaseTypeEnum(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }
    }

    /**
     * 应征方案相似案例状态
     */
    public enum CaseApplySimilarCaseExampleStatusEnum {

        NORMAL("1", "正常"),
        DELETE("2", "删除");

        private String code;
        private String name;

        CaseApplySimilarCaseExampleStatusEnum(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }
    }

    /**
     * 委案状态枚举
     */
    public enum CaseEntrustStatus {
        NEW("1033000001", "待接案"),
        SELECTING("1033000002", "遴选中"),
        OK("1033000003", "进行中"),
        DONE("1033000004", "已结案"),
        DELETE("1033000005", "已撤销");

        private String code;
        private String title;

        CaseEntrustStatus(String code, String title) {
            this.code = code;
            this.title = title;
        }

        public String getCode() {
            return code;
        }
    }

    /**
     * 数据库字段变更记录
     */
    public enum FieldLog {
        ENTRUST(1),
        CASE(2),
        APPLY(3),
        CUSTOMER(4),
        TODO(5);

        private int code;

        FieldLog(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }

    /**
     * 撤销选项
     */
    public enum RECALL {
        HAPPY("1010000001", "和解"),
        UNHAPPY("1010000002", "推荐的律师不满意"),
        ALREADY("1010000003", "已从其他途径寻找律师"),
        NONEED("1010000004", "暂时不需要寻找律师");

        private String code;
        private String name;

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        RECALL(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public static String getName(String code) {
            for (RECALL type : values()) {
                if (type.getCode().equals(code)) {
                    return type.getName();
                }
            }
            return null;
        }
    }

    /**
     * message状态
     * 1未读
     * 2已读
     */
    public enum MessageStatus {
        UNREAD(1, "未读"),
        READ(2, "已读");

        private Integer code;
        private String name;

        MessageStatus(Integer code, String name) {
            this.code = code;
            this.name = name;
        }

        public Integer getCode() {
            return code;
        }
    }

    /**
     * 短信发送状态
     */
    public enum SmsStatus {
        SENT("1", "已发送"),
        SUCCEED("2", "送达成功"),
        FAILED("3", "送达失败");

        private String code;
        private String name;

        SmsStatus(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }
    }

    /**
     * kafka消息处理状态
     */
    public enum MQStatus {
        SUCCEED("1", "处理成功"),
        FAILED("2", "处理失败");

        private String code;
        private String name;

        MQStatus(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }
    }
//
//    public enum TargetTypeEnum {
//        CASE(1, "案件"),
//        TASK(2, "待办"),
//        CONFERENCE(3, "会议"),
//        DOCUMENT(4, "文档"),
//        FOLLOW(5, "跟进"),
//        CONFERENCESUMMARY(6, "会议纪要"),
//        CASE_ENTRUST(7, "委案"),
//        CASE_APPLY(8, "应征"),
//        USER(9, "用户"),
//        COMPANY(10, "公司");
//
//
//        private int code;
//        private String name;
//
//        public int getCode() {
//            return code;
//        }
//
//        TargetTypeEnum(int code, String name) {
//            this.code = code;
//            this.name = name;
//        }
//    }

    /**
     * 应征方案状态枚举
     */
    public enum CaseApplyStatus {
        APPLYING("1029000002", "已应征"),
        APPLY_FAILED("1029000004", "应征失败"),
        APPLY_SUCCESS("1029000005", "应征成功");

        private String code;
        private String name;

        public String getCode() {
            return code;
        }

        CaseApplyStatus(String code, String name) {
            this.code = code;
            this.name = name;
        }
    }

    /**
     * 应征方案状态枚举
     */
    public enum CommonStatus {
        NORMAL("1", "正常"),
        UNNORMAL("2", "删除");

        private String code;
        private String name;

        public String getCode() {
            return code;
        }

        CommonStatus(String code, String name) {
            this.code = code;
            this.name = name;
        }
    }

    /**
     * 应征方案办案人员状态
     */
    public enum CaseApplyMemberStatusEnum {
        NORMAL("1", "正常"),
        DISABLED("2", "已禁用");

        private String code;
        private String name;

        public String getCode() {
            return code;
        }

        CaseApplyMemberStatusEnum(String code, String name) {
            this.code = code;
            this.name = name;
        }
    }

    /**
     * 案件相关人员类型
     */
    public enum CaseRelativeUserTypeEnum {
        HELP_LAWYER(1016000001, "辅助律师"),
        MAIN_LAWYER(1016000002, "主办律师"),
        MANAGER(1016000003, "案管"),
        PRINCIPAL(1016000004, "案件负责人"),
        CORRELATION(1016000005, "案件相关人");


        private Integer code;
        private String name;

        public Integer getCode() {
            return code;
        }

        CaseRelativeUserTypeEnum(Integer code, String name) {
            this.code = code;
            this.name = name;
        }
    }

    /**
     * 律师要求枚举
     */
    public enum ChooseType {
        CHOOSE_TYPE_NOT_PUBLIC("1005000001", "不公开招募"),
        CHOOSE_TYPE_ONLY_INSIDE("1005000002", "内部招募"),
        CHOOSE_TYPE_PUBLIC("1005000003", "公开招募"),
        CHOOSE_TYPE_APPOINT("1005000004", "指定律师");

        private String code;
        private String title;

        ChooseType(String code, String title) {
            this.code = code;
            this.title = title;
        }

        public String getCode() {
            return code;
        }

        public String getTitle() {
            return title;
        }
    }

    /**
     * 平台对于公司的管理状态
     * 1有效
     * 2无效
     */
    public enum CommonValidStatus {
        VALID("1", "有效"),
        UNVALID("2", "无效"),
        DELETE("0", "删除");

        private String code;
        private String name;

        CommonValidStatus(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }
    }

    /**
     * 企业律师状态
     */
    public enum CompanyLawyerStatus {
        NORMAL("1040000001", "正常"),
        DELETE("1040000002", "停用");

        private String code;
        private String name;

        CompanyLawyerStatus(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }

    }

    /**
     * 付费方式确认状态
     */
    public enum ChargeStatus {
        UNCONFIRM("1", "未确认"),
        CONFIRM("2", "确认"),
        INVALID("3", "失效");

        private String code;
        private String name;

        ChargeStatus(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }
    }

    /**
     * 应征方案推荐状态
     */
    public enum CaseApplyRecommendStatus {
        UNRECOMMEND("1003000001", "非优先推荐"),
        RECOMMEND("1003000002", "优先推荐");

        private String code;
        private String name;

        public String getCode() {
            return code;
        }

        CaseApplyRecommendStatus(String code, String name) {
            this.code = code;
            this.name = name;
        }
    }

    /**
     * 应征方案推荐状态
     */
    public enum Recommended {
        UNRECOMMEND("0", "未推荐"),
        RECOMMEND("1", "已推荐");

        private String code;
        private String name;

        public String getCode() {
            return code;
        }

        Recommended(String code, String name) {
            this.code = code;
            this.name = name;
        }
    }

    /**
     * 应征方案评价状态
     */
    public enum CaseApplyEvaluationStatus {
        UNEVALUATION("1004000001", "未评价"),
        EVALUATION("1004000002", "已评价");

        private String code;
        private String name;

        public String getCode() {
            return code;
        }

        CaseApplyEvaluationStatus(String code, String name) {
            this.code = code;
            this.name = name;
        }
    }

    /**
     * 律师状态枚举
     */
    public enum LawyerStatusEnum {

        ACTIVE("1028000001", "活跃中"),
        DISABLED("1028000002", "已停用");

        private String code;
        private String title;

        LawyerStatusEnum(String code, String title) {
            this.code = code;
            this.title = title;
        }

        public String getCode() {
            return code;
        }

    }

    public enum DocStatus {
        NOMAL("1", "正常"),
        CASEAPLLY_DOCUMENT_STATUS("8", "应征方案文档状态"),// 应征方案刚上传时的状态，此时在文档列表中不可见，但是在详情中可见
        DELETE("9", "删除");

        private String code;
        private String title;

        DocStatus(String code, String title) {
            this.code = code;
            this.title = title;
        }

        public String getCode() {
            return code;
        }

    }
    /**********************************确认的参数**************************/

    /**
     * exo相关枚举
     */
    public static class ExoEnum {
        //TODO 需要删除

        /**
         * exo-restApi地址枚举
         */
        public enum ExoRestUrlEnum {

            /**
             * exo-服务地址
             */
            EXO_REST_BASE("http://192.168.25.75:8888/rest/private/v1/"),

            /**
             * 添加日历信息
             */
            CALENDAR_ADD("calendar/calendars/"),

            /**
             * 查询日历信息
             */
            CALENDAR_LIST("calendar/calendars/"),

            /**
             * 根据id查询日历信息
             */
            CALENDAR_BY_ID("calendar/calendars/{id}"),

            /**
             * 修改日历
             */
            CALENDAR_UPDATE("calendar/calendars/{id}"),

            /**
             * 删除日历
             */
            CALENDAR_DELETE("calendar/calendars/{id}");

            private String url;

            public String getUrl() {
                return url;
            }

            ExoRestUrlEnum(String url) {
                this.url = url;
            }
        }

    }

    /**
     * HTTP相关枚举
     */
    public static class HttpEnumClass {
        /**
         * HTTP头信息枚举
         */
        public enum HttpHeaderEnum {
            /**
             * basic认证头信息
             */
            AUTH("Authorization");
            private String headerCode;

            public String getHeaderCode() {
                return headerCode;
            }

            HttpHeaderEnum(String headerCode) {
                this.headerCode = headerCode;
            }
        }
    }

    public static class Batch {
        /**
         * 定时器消息判定有效无效
         */
        public enum MessageStatus {

            VAILD("1", "有效"),
            UNVAILD("0", "失效");

            private String code;
            private String name;

            public String getCode() {
                return code;
            }

            public String getName() {
                return name;
            }

            MessageStatus(String code, String name) {
                this.code = code;
                this.name = name;
            }
        }

        /**
         * 定时器消息来源
         */
        public enum MessageSource {

            TASK(1, "待办逾期"),
            TASKTWODAYS(2, "距离待办完成还有两天"),
            CONFERENCEDAYS(3, "距离会议召开一天"),
            STARTCONFERENCE(4, "启动会议"),
            SHARECONNECTION(5, "共享第三方联系"),
            FOLLOW_CONFIM_ENTRUST_10DAYS(6, "确认委托10天"),
            FOLLOW_CONFIM_ENTRUST_30DAYS(7, "确认委托30"),
            COURT_CONFERNCE_7DAYS(8, "开庭前7个工作日提醒开庭"),
            BEFORE_COURT_3DAYS(9, "开庭前三天提醒"),
            BEFORE_COURT_1DAYS(10, "开庭前一天提醒"),
            AFTER_COURT_3DAYS(12, "开庭后三天提醒"),
            AFTER_COURT_1DAYS(15, "开庭后三天提醒"),
            AFTER_COURT_10DAYS(13, "开庭后10天提醒"),
            BEFORE_COURT_0DAYS(11, "开庭当天提醒"),
            CONFERENCEONEBEFOREBEFOREHALFHOUR(14, "距离会议召开会议半小时");

            private int code;
            private String name;

            public int getCode() {
                return code;
            }

            public String getName() {
                return name;
            }

            MessageSource(int code, String name) {
                this.code = code;
                this.name = name;
            }
        }
    }

    public static class Customer {
        public enum CONTACTDECISION {
            ISDECISON("2008000001", "关键决策人");
            private String code;
            private String name;

            public String getCode() {
                return code;
            }

            public String getName() {
                return name;
            }

            CONTACTDECISION(String code, String name) {
                this.code = code;
                this.name = name;
            }
        }

        public enum STATUS {
            WAITING("2004000001", "观望中"),
            FIRSTTOUCH("2004000002", "首次接触"),
            SUBMITMATERIAL("2004000003", "递交材料"),
            VISITCUSTOMER("2004000004", "拜访客户"),
            CUSTOMERVISIT("2004000005", "客户到访"),
            AGREEMENT("2004000007", "已签框架协议"),
            STOPING("2004000009", "停滞中"),
            FRISTENTRUST("2004000006", "首次委案"),
            ALWAYSENTRUST("2004000008", "持续委案"),
            STOPENTRUST("2004000010", "已拒绝");

            private String code;
            private String name;

            public String getCode() {
                return code;
            }

            public String getName() {
                return name;
            }

            STATUS(String code, String name) {
                this.code = code;
                this.name = name;
            }

            public static String getName(String code) {
                for (STATUS type : values()) {
                    if (type.getCode().equals(code)) {
                        return type.getName();
                    }
                }
                return null;
            }
        }

        public enum LEVEL {
            IMPORTANT("2001000001", "重要客户A"),
            GENERAL("2001000002", "一般客户B"),
            UNIMPORTANT("2001000003", "次要客户C");

            private String code;
            private String name;

            public String getCode() {
                return code;
            }

            public String getName() {
                return name;
            }

            LEVEL(String code, String name) {
                this.code = code;
                this.name = name;
            }
        }

        public enum KASTATUS {
            ZHIMING("2013000000", "指明"),
            LIANXI("2013000001", "联系"),
            BAIFANG("2013000002", "拜访"),
            SHANGJI("2013000003", "商机"),
            TANPAN("2013000004", "谈判"),
            HEZUO("2013000005", "合作");

            private String code;
            private String name;

            public String getCode() {
                return code;
            }

            public String getName() {
                return name;
            }

            KASTATUS(String code, String name) {
                this.code = code;
                this.name = name;
            }
        }
    }

    public enum CaseAmountType {
        CLEAR("1", "精确"),
        UNCLEAR("2", "范围");

        private String code;
        private String name;

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        CaseAmountType(String code, String name) {
            this.code = code;
            this.name = name;
        }
    }

    public static class BusinessOpportunity {
        public enum STATUS {
            WAITFORCHANGE("2009000001", "待转化"),
            WAITFORCLAIM("2009000002", "待认领"),
            CHANGEDTOENTRUST("2009000003", "已转化");

            private String code;
            private String name;

            public String getCode() {
                return code;
            }

            public String getName() {
                return name;
            }

            STATUS(String code, String name) {
                this.code = code;
                this.name = name;
            }
        }

        public enum DEMANDTYPE {
            CASEAGENT("1051000001", "案件代理"),
            REMOTECONSULTFILES("1051000002", "异地查档"),
            SUSONG("1051000003","诉讼"),
            FEISU("1051000004","非诉服务"),
            FALVZIXUN("1051000005","法律咨询"),
            LVSHIHAN("1051000006","律师函"),
            CONTRACTSERVICE("1051000007","合同服务");

            private String code;
            private String name;

            public String getCode() {
                return code;
            }

            public String getName() {
                return name;
            }

            DEMANDTYPE(String code, String name) {
                this.code = code;
                this.name = name;
            }
        }
    }

    public static class LawyerInfo {
        public enum QueryType {
            APPLYLAWYERS("1053000001", "应征库"),
            INNERLAWYERS("1053000002", "内部库");

            private String code;
            private String name;

            public String getCode() {
                return code;
            }

            public String getName() {
                return name;
            }

            QueryType(String code, String name) {
                this.code = code;
                this.name = name;
            }
        }
    }

    public static class Document {
        public enum docType {
            CASE_ZHENGJU("1041000001", "案件证据材料"),
            CASE_SUSONG("1041000002", "案件诉讼材料"),
            APPLY("1041000007", "代理意见"),
            CONTRACT_DOC("1041000009", "合同doc"),
            CONTRACT_PHOTO("1041000010", "合同银行流水图片");
            private String code;
            private String name;

            public String getCode() {
                return code;
            }

            public String getName() {
                return name;
            }

            docType(String code, String name) {
                this.code = code;
                this.name = name;
            }
        }

        public enum VISIBLESTATUS {

            ALL("1052000001", "全部可见"),
            LAWWORKER("1052000002", "企业法务可见"),
            LAWYER("1052000003", "律师可见"),
            INNERGROUP("1052000004", "内部人员可见");

            private String code;
            private String name;

            public String getCode() {
                return code;
            }

            public String getName() {
                return name;
            }

            VISIBLESTATUS(String code, String name) {
                this.code = code;
                this.name = name;
            }

        }
    }

    public static class Task {
        public enum TASKTYPE {
            SEND("2", "我发起的代办"),
            RECEIVE("1", "我负责的代办"),
            ALLL("3", "所有代办");
            private String code;
            private String name;

            public String getCode() {
                return code;
            }

            public String getName() {
                return name;
            }

            TASKTYPE(String code, String name) {
                this.code = code;
                this.name = name;
            }
        }
    }
}
