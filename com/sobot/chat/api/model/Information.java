package com.sobot.chat.api.model;

import com.sobot.chat.api.apiUtils.GsonUtil;
import com.sobot.chat.api.enumtype.SobotAutoSendMsgMode;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/Information.class */
public class Information implements Serializable {
    private static final long serialVersionUID = 1;
    private String admin_hello_word;
    private String admin_offline_title;
    private String admin_tip_word;
    private String app_key;
    private String appkey;
    private boolean canBackWithNotEvaluation;
    private String choose_adminid;
    private String createTime;
    private String customInfo;
    private int custom_title_url;
    private String customerCode;
    private String customerFields;
    private String customer_code;
    private String customer_fields;
    private String email;
    private String equipmentId;
    private String face;
    private String group_name;
    private String groupid;
    private String helpCenterTel;
    private String helpCenterTelTitle;
    private boolean hideManualEvaluationLabels;
    private boolean hideMenuCamera;
    private boolean hideMenuFile;
    private boolean hideMenuLeave;
    private boolean hideMenuManualLeave;
    private boolean hideMenuPicture;
    private boolean hideMenuSatisfaction;
    private boolean hideMenuVedio;
    private boolean hideRototEvaluationLabels;
    private String isVip;
    private Map<String, String> leaveCusFieldMap;
    private String leaveMsgGroupId;
    private String leaveMsgGuideContent;
    private String leaveMsgTemplateContent;
    private List<SobotLeaveMsgFieldModel> leaveParamsExtends;
    private String leaveTemplateId;
    private String locale;
    private String mulitParams;
    private String multi_params;
    private String params;
    private String partnerid;
    private String qq;
    private String realname;
    private String receptionistId;
    private String remark;
    private String robot_alias;
    private String robot_code;
    private String robot_hello_word;
    private String secretKey;
    private boolean showLeaveDetailBackEvaluate;
    private String sign;
    private String skillSetId;
    private String skillSetName;
    private String summaryParams;
    private String summary_params;
    private String tel;
    private int tranReceptionistFlag;
    private String transferAction;
    private String uid;
    private String uname;
    private String user_emails;
    private String user_label;
    private String user_name;
    private String user_nick;
    private String user_out_word;
    private String user_tels;
    private String user_tip_word;
    private String vip_level;
    private String visitTitle;
    private String visitUrl;
    private String visit_title;
    private String visit_url;
    private int service_mode = -1;
    private boolean queue_first = false;
    private ConsultingContent content = null;
    private OrderCardContentModel orderGoodsInfo = null;
    private SobotAutoSendMsgMode autoSendMsgMode = SobotAutoSendMsgMode.Default;
    private Map<String, String> margs = null;
    private boolean isShowLeftBackPop = false;
    private boolean isCloseInquiryForm = false;
    private int faqId = 0;
    private int isFirstEntry = 1;
    private ConsultingContent consultingContent = null;
    private int initModeType = -1;
    private boolean isQueueFirst = false;
    private Map<String, String> questionRecommendParams = null;
    private int titleImgId = 0;
    private boolean isArtificialIntelligence = false;
    private int artificialIntelligenceNum = 1;
    private boolean isUseVoice = true;
    private boolean isUseRobotVoice = false;
    private boolean isShowSatisfaction = false;
    private boolean isShowCloseSatisfaction = false;
    private boolean isShow = false;
    private String robotCode = "";
    private HashSet<String> transferKeyWord = null;

    public String getAdmin_hello_word() {
        return this.admin_hello_word;
    }

    public String getAdmin_offline_title() {
        return this.admin_offline_title;
    }

    public String getAdmin_tip_word() {
        return this.admin_tip_word;
    }

    public String getApp_key() {
        return this.app_key;
    }

    @Deprecated
    public String getAppkey() {
        return this.appkey;
    }

    public int getArtificialIntelligenceNum() {
        return this.artificialIntelligenceNum;
    }

    public SobotAutoSendMsgMode getAutoSendMsgMode() {
        return this.autoSendMsgMode;
    }

    public String getChoose_adminid() {
        return this.choose_adminid;
    }

    @Deprecated
    public ConsultingContent getConsultingContent() {
        return this.consultingContent;
    }

    public ConsultingContent getContent() {
        return this.content;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    @Deprecated
    public String getCustomInfo() {
        return this.customInfo;
    }

    public int getCustom_title_url() {
        return this.custom_title_url;
    }

    @Deprecated
    public String getCustomerCode() {
        return this.customerCode;
    }

    @Deprecated
    public String getCustomerFields() {
        return this.customerFields;
    }

    public String getCustomer_code() {
        return this.customer_code;
    }

    public String getCustomer_fields() {
        return this.customer_fields;
    }

    @Deprecated
    public String getEmail() {
        return this.email;
    }

    public String getEquipmentId() {
        return this.equipmentId;
    }

    public String getFace() {
        return this.face;
    }

    public int getFaqId() {
        return this.faqId;
    }

    public String getGroup_name() {
        return this.group_name;
    }

    public String getGroupid() {
        return this.groupid;
    }

    public String getHelpCenterTel() {
        return this.helpCenterTel;
    }

    public String getHelpCenterTelTitle() {
        return this.helpCenterTelTitle;
    }

    @Deprecated
    public int getInitModeType() {
        return this.initModeType;
    }

    public int getIsFirstEntry() {
        return this.isFirstEntry;
    }

    public String getIsVip() {
        return this.isVip;
    }

    public Map<String, String> getLeaveCusFieldMap() {
        return this.leaveCusFieldMap;
    }

    public String getLeaveMsgGroupId() {
        return this.leaveMsgGroupId;
    }

    public String getLeaveMsgGuideContent() {
        return this.leaveMsgGuideContent;
    }

    public String getLeaveMsgTemplateContent() {
        return this.leaveMsgTemplateContent;
    }

    public List<SobotLeaveMsgFieldModel> getLeaveParamsExtends() {
        return this.leaveParamsExtends;
    }

    public String getLeaveTemplateId() {
        return this.leaveTemplateId;
    }

    public String getLocale() {
        return this.locale;
    }

    public Map<String, String> getMargs() {
        return this.margs;
    }

    @Deprecated
    public String getMulitParams() {
        return this.mulitParams;
    }

    public String getMulti_params() {
        return this.multi_params;
    }

    public OrderCardContentModel getOrderGoodsInfo() {
        return this.orderGoodsInfo;
    }

    public String getParams() {
        return this.params;
    }

    public String getPartnerid() {
        return this.partnerid;
    }

    public String getQq() {
        return this.qq;
    }

    @Deprecated
    public Map<String, String> getQuestionRecommendParams() {
        return this.questionRecommendParams;
    }

    @Deprecated
    public String getRealname() {
        return this.realname;
    }

    @Deprecated
    public String getReceptionistId() {
        return this.receptionistId;
    }

    public String getRemark() {
        return this.remark;
    }

    @Deprecated
    public String getRobotCode() {
        return this.robotCode;
    }

    public String getRobot_alias() {
        return this.robot_alias;
    }

    public String getRobot_code() {
        return this.robot_code;
    }

    public String getRobot_hello_word() {
        return this.robot_hello_word;
    }

    public String getSecretKey() {
        return this.secretKey;
    }

    public int getService_mode() {
        return this.service_mode;
    }

    public String getSign() {
        return this.sign;
    }

    @Deprecated
    public String getSkillSetId() {
        return this.skillSetId;
    }

    @Deprecated
    public String getSkillSetName() {
        return this.skillSetName;
    }

    @Deprecated
    public String getSummaryParams() {
        return this.summaryParams;
    }

    public String getSummary_params() {
        return this.summary_params;
    }

    @Deprecated
    public String getTel() {
        return this.tel;
    }

    @Deprecated
    public int getTitleImgId() {
        return this.titleImgId;
    }

    public int getTranReceptionistFlag() {
        return this.tranReceptionistFlag;
    }

    public String getTransferAction() {
        return this.transferAction;
    }

    public HashSet<String> getTransferKeyWord() {
        return this.transferKeyWord;
    }

    @Deprecated
    public String getUid() {
        return this.uid;
    }

    @Deprecated
    public String getUname() {
        return this.uname;
    }

    public String getUser_emails() {
        return this.user_emails;
    }

    public String getUser_label() {
        return this.user_label;
    }

    public String getUser_name() {
        return this.user_name;
    }

    public String getUser_nick() {
        return this.user_nick;
    }

    public String getUser_out_word() {
        return this.user_out_word;
    }

    public String getUser_tels() {
        return this.user_tels;
    }

    public String getUser_tip_word() {
        return this.user_tip_word;
    }

    public String getVip_level() {
        return this.vip_level;
    }

    @Deprecated
    public String getVisitTitle() {
        return this.visitTitle;
    }

    @Deprecated
    public String getVisitUrl() {
        return this.visitUrl;
    }

    public String getVisit_title() {
        return this.visit_title;
    }

    public String getVisit_url() {
        return this.visit_url;
    }

    public boolean isArtificialIntelligence() {
        return this.isArtificialIntelligence;
    }

    public boolean isCanBackWithNotEvaluation() {
        return this.canBackWithNotEvaluation;
    }

    public boolean isCloseInquiryForm() {
        return this.isCloseInquiryForm;
    }

    public boolean isHideManualEvaluationLabels() {
        return this.hideManualEvaluationLabels;
    }

    public boolean isHideMenuCamera() {
        return this.hideMenuCamera;
    }

    public boolean isHideMenuFile() {
        return this.hideMenuFile;
    }

    public boolean isHideMenuLeave() {
        return this.hideMenuLeave;
    }

    public boolean isHideMenuManualLeave() {
        return this.hideMenuManualLeave;
    }

    public boolean isHideMenuPicture() {
        return this.hideMenuPicture;
    }

    public boolean isHideMenuSatisfaction() {
        return this.hideMenuSatisfaction;
    }

    public boolean isHideMenuVedio() {
        return this.hideMenuVedio;
    }

    public boolean isHideRototEvaluationLabels() {
        return this.hideRototEvaluationLabels;
    }

    @Deprecated
    public boolean isQueueFirst() {
        return this.isQueueFirst;
    }

    public boolean isShowCloseBtn() {
        return this.isShow;
    }

    public boolean isShowCloseSatisfaction() {
        return this.isShowCloseSatisfaction;
    }

    public boolean isShowLeaveDetailBackEvaluate() {
        return this.showLeaveDetailBackEvaluate;
    }

    public boolean isShowLeftBackPop() {
        return this.isShowLeftBackPop;
    }

    public boolean isShowSatisfaction() {
        return this.isShowSatisfaction;
    }

    public boolean isUseRobotVoice() {
        return this.isUseRobotVoice;
    }

    public boolean isUseVoice() {
        return this.isUseVoice;
    }

    public boolean is_queue_first() {
        return this.queue_first;
    }

    public void setAdmin_Hello_Word(String str) {
        this.admin_hello_word = str;
    }

    public void setAdmin_Offline_Title(String str) {
        this.admin_offline_title = str;
    }

    public void setAdmin_Tip_Word(String str) {
        this.admin_tip_word = str;
    }

    public void setApp_key(String str) {
        this.appkey = str;
        this.app_key = str;
    }

    @Deprecated
    public void setAppkey(String str) {
        this.appkey = str;
        this.app_key = str;
    }

    public void setArtificialIntelligence(boolean z) {
        this.isArtificialIntelligence = z;
    }

    public void setArtificialIntelligenceNum(int i) {
        this.artificialIntelligenceNum = i;
    }

    public void setAutoSendMsgMode(SobotAutoSendMsgMode sobotAutoSendMsgMode) {
        this.autoSendMsgMode = sobotAutoSendMsgMode;
    }

    public void setCanBackWithNotEvaluation(boolean z) {
        this.canBackWithNotEvaluation = z;
    }

    public void setChoose_adminid(String str) {
        this.choose_adminid = str;
        this.receptionistId = str;
    }

    public void setCloseInquiryForm(boolean z) {
        this.isCloseInquiryForm = z;
    }

    @Deprecated
    public void setConsultingContent(ConsultingContent consultingContent) {
        this.consultingContent = consultingContent;
        this.content = consultingContent;
    }

    public void setContent(ConsultingContent consultingContent) {
        this.content = consultingContent;
        this.consultingContent = consultingContent;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    @Deprecated
    public void setCustomInfo(String str) {
        this.customInfo = str;
        this.params = str;
    }

    @Deprecated
    public void setCustomInfo(Map<String, String> map) {
        this.customInfo = GsonUtil.map2Json(map);
        this.params = GsonUtil.map2Json(map);
    }

    public void setCustom_title_url(int i) {
        this.custom_title_url = i;
        this.titleImgId = i;
    }

    @Deprecated
    public void setCustomerCode(String str) {
        this.customerCode = str;
        this.customer_code = str;
    }

    @Deprecated
    public void setCustomerFields(String str) {
        this.customerFields = str;
        this.customer_fields = str;
    }

    @Deprecated
    public void setCustomerFields(Map<String, String> map) {
        this.customerFields = GsonUtil.map2Json(map);
        this.customer_fields = GsonUtil.map2Json(map);
    }

    public void setCustomer_code(String str) {
        this.customer_code = str;
        this.customerCode = str;
    }

    public void setCustomer_fields(String str) {
        this.customer_fields = str;
        this.customerFields = str;
    }

    public void setCustomer_fields(Map<String, String> map) {
        this.customer_fields = GsonUtil.map2Json(map);
        this.customerFields = GsonUtil.map2Json(map);
    }

    @Deprecated
    public void setEmail(String str) {
        this.email = str;
        this.user_emails = str;
    }

    public void setEquipmentId(String str) {
        this.equipmentId = str;
    }

    public void setFace(String str) {
        this.face = str;
    }

    public void setFaqId(int i) {
        this.faqId = i;
    }

    public void setGroup_name(String str) {
        this.group_name = str;
        this.skillSetName = str;
    }

    public void setGroupid(String str) {
        this.groupid = str;
        this.skillSetId = str;
    }

    public void setHelpCenterTel(String str) {
        this.helpCenterTel = str;
    }

    public void setHelpCenterTelTitle(String str) {
        this.helpCenterTelTitle = str;
    }

    public void setHideManualEvaluationLabels(boolean z) {
        this.hideManualEvaluationLabels = z;
    }

    public void setHideMenuCamera(boolean z) {
        this.hideMenuCamera = z;
    }

    public void setHideMenuFile(boolean z) {
        this.hideMenuFile = z;
    }

    public void setHideMenuLeave(boolean z) {
        this.hideMenuLeave = z;
    }

    public void setHideMenuManualLeave(boolean z) {
        this.hideMenuManualLeave = z;
    }

    public void setHideMenuPicture(boolean z) {
        this.hideMenuPicture = z;
    }

    public void setHideMenuSatisfaction(boolean z) {
        this.hideMenuSatisfaction = z;
    }

    public void setHideMenuVedio(boolean z) {
        this.hideMenuVedio = z;
    }

    public void setHideRototEvaluationLabels(boolean z) {
        this.hideRototEvaluationLabels = z;
    }

    @Deprecated
    public void setInitModeType(int i) {
        this.initModeType = i;
        this.service_mode = i;
    }

    public void setIsFirstEntry(int i) {
        this.isFirstEntry = i;
    }

    public void setIsVip(String str) {
        this.isVip = str;
    }

    public void setIs_Queue_First(boolean z) {
        this.queue_first = z;
        this.isQueueFirst = z;
    }

    public void setLeaveCusFieldMap(Map<String, String> map) {
        this.leaveCusFieldMap = map;
    }

    public void setLeaveMsgGroupId(String str) {
        this.leaveMsgGroupId = str;
    }

    public void setLeaveMsgGuideContent(String str) {
        this.leaveMsgGuideContent = str;
    }

    public void setLeaveMsgTemplateContent(String str) {
        this.leaveMsgTemplateContent = str;
    }

    public void setLeaveParamsExtends(List<SobotLeaveMsgFieldModel> list) {
        this.leaveParamsExtends = list;
    }

    public void setLeaveTemplateId(String str) {
        this.leaveTemplateId = str;
    }

    public void setLocale(String str) {
        this.locale = str;
    }

    public void setMargs(Map<String, String> map) {
        this.margs = map;
        this.questionRecommendParams = map;
    }

    @Deprecated
    public void setMulitParams(String str) {
        this.mulitParams = str;
        this.multi_params = str;
    }

    public void setMulti_params(String str) {
        this.multi_params = str;
        this.mulitParams = str;
    }

    public void setOrderGoodsInfo(OrderCardContentModel orderCardContentModel) {
        this.orderGoodsInfo = orderCardContentModel;
    }

    public void setParams(String str) {
        this.params = str;
        this.customInfo = str;
    }

    public void setParams(Map<String, String> map) {
        this.params = GsonUtil.map2Json(map);
        this.customInfo = GsonUtil.map2Json(map);
    }

    public void setPartnerid(String str) {
        this.partnerid = str;
        this.uid = str;
    }

    public void setQq(String str) {
        this.qq = str;
    }

    @Deprecated
    public void setQuestionRecommendParams(Map<String, String> map) {
        this.questionRecommendParams = map;
        this.margs = map;
    }

    @Deprecated
    public void setQueueFirst(boolean z) {
        this.isQueueFirst = z;
        this.queue_first = z;
    }

    @Deprecated
    public void setRealname(String str) {
        this.realname = str;
        this.user_name = str;
    }

    @Deprecated
    public void setReceptionistId(String str) {
        this.receptionistId = str;
        this.choose_adminid = str;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    @Deprecated
    public void setRobotCode(String str) {
        this.robotCode = str;
        this.robot_code = str;
    }

    public void setRobot_Hello_Word(String str) {
        this.robot_hello_word = str;
    }

    public void setRobot_alias(String str) {
        this.robot_alias = str;
    }

    public void setRobot_code(String str) {
        this.robot_code = str;
        this.robotCode = str;
    }

    public void setSecretKey(String str) {
        this.secretKey = str;
    }

    public void setService_mode(int i) {
        this.service_mode = i;
        this.initModeType = i;
    }

    public void setShowCloseBtn(boolean z) {
        this.isShow = z;
    }

    public void setShowCloseSatisfaction(boolean z) {
        this.isShowCloseSatisfaction = z;
    }

    public void setShowLeaveDetailBackEvaluate(boolean z) {
        this.showLeaveDetailBackEvaluate = z;
    }

    public void setShowLeftBackPop(boolean z) {
        this.isShowLeftBackPop = z;
    }

    public void setShowSatisfaction(boolean z) {
        this.isShowSatisfaction = z;
    }

    public void setSign(String str) {
        this.sign = str;
    }

    @Deprecated
    public void setSkillSetId(String str) {
        this.skillSetId = str;
        this.groupid = str;
    }

    @Deprecated
    public void setSkillSetName(String str) {
        this.skillSetName = str;
        this.group_name = str;
    }

    @Deprecated
    public void setSummaryParams(String str) {
        this.summaryParams = str;
        this.summary_params = str;
    }

    @Deprecated
    public void setSummaryParams(Map<String, String> map) {
        this.summaryParams = GsonUtil.map2Json(map);
        this.summary_params = GsonUtil.map2Json(map);
    }

    public void setSummary_params(String str) {
        this.summary_params = str;
        this.summaryParams = str;
    }

    public void setSummary_params(Map<String, String> map) {
        this.summary_params = GsonUtil.map2Json(map);
        this.summaryParams = GsonUtil.map2Json(map);
    }

    @Deprecated
    public void setTel(String str) {
        this.tel = str;
        this.user_tels = str;
    }

    @Deprecated
    public void setTitleImgId(int i) {
        this.titleImgId = i;
        this.custom_title_url = i;
    }

    public void setTranReceptionistFlag(int i) {
        this.tranReceptionistFlag = i;
    }

    public void setTransferAction(String str) {
        this.transferAction = str;
    }

    public void setTransferKeyWord(HashSet<String> hashSet) {
        this.transferKeyWord = hashSet;
    }

    @Deprecated
    public void setUid(String str) {
        this.uid = str;
        this.partnerid = str;
    }

    @Deprecated
    public void setUname(String str) {
        this.uname = str;
        this.user_nick = str;
    }

    public void setUseRobotVoice(boolean z) {
        this.isUseRobotVoice = z;
    }

    public void setUseVoice(boolean z) {
        this.isUseVoice = z;
    }

    public void setUser_Out_Word(String str) {
        this.user_out_word = str;
    }

    public void setUser_Tip_Word(String str) {
        this.user_tip_word = str;
    }

    public void setUser_emails(String str) {
        this.user_emails = str;
        this.email = str;
    }

    public void setUser_label(String str) {
        this.user_label = str;
    }

    public void setUser_name(String str) {
        this.user_name = str;
        this.realname = str;
    }

    public void setUser_nick(String str) {
        this.user_nick = str;
        this.uname = str;
    }

    public void setUser_tels(String str) {
        this.user_tels = str;
        this.tel = str;
    }

    public void setVip_level(String str) {
        this.vip_level = str;
    }

    @Deprecated
    public void setVisitTitle(String str) {
        this.visitTitle = str;
        this.visit_title = str;
    }

    @Deprecated
    public void setVisitUrl(String str) {
        this.visitUrl = str;
        this.visit_url = str;
    }

    public void setVisit_title(String str) {
        this.visit_title = str;
        this.visitTitle = str;
    }

    public void setVisit_url(String str) {
        this.visit_url = str;
        this.visitUrl = str;
    }

    public String toString() {
        return "Information{app_key='" + this.app_key + "', customer_code='" + this.customer_code + "', choose_adminid='" + this.choose_adminid + "', partnerid='" + this.partnerid + "', user_nick='" + this.user_nick + "', user_name='" + this.user_name + "', user_tels='" + this.user_tels + "', user_emails='" + this.user_emails + "', params='" + this.params + "', summary_params='" + this.summary_params + "', customer_fields='" + this.customer_fields + "', multi_params='" + this.multi_params + "', qq='" + this.qq + "', remark='" + this.remark + "', face='" + this.face + "', visit_title='" + this.visit_title + "', visit_url='" + this.visit_url + "', service_mode=" + this.service_mode + ", groupid='" + this.groupid + "', group_name='" + this.group_name + "', transferAction='" + this.transferAction + "', queue_first=" + this.queue_first + ", content=" + this.content + ", orderGoodsInfo=" + this.orderGoodsInfo + ", autoSendMsgMode=" + this.autoSendMsgMode + ", margs=" + this.margs + ", custom_title_url=" + this.custom_title_url + ", isVip='" + this.isVip + "', vip_level='" + this.vip_level + "', user_label='" + this.user_label + "', isShowLeftBackPop=" + this.isShowLeftBackPop + ", isCloseInquiryForm=" + this.isCloseInquiryForm + ", leaveMsgTemplateContent='" + this.leaveMsgTemplateContent + "', leaveMsgGuideContent='" + this.leaveMsgGuideContent + "', leaveMsgGroupId='" + this.leaveMsgGroupId + "', leaveCusFieldMap=" + this.leaveCusFieldMap + ", hideMenuSatisfaction=" + this.hideMenuSatisfaction + ", hideMenuLeave=" + this.hideMenuLeave + ", hideMenuPicture=" + this.hideMenuPicture + ", hideMenuVedio=" + this.hideMenuVedio + ", hideMenuCamera=" + this.hideMenuCamera + ", hideMenuFile=" + this.hideMenuFile + ", showLeaveDetailBackEvaluate=" + this.showLeaveDetailBackEvaluate + ", canBackWithNotEvaluation=" + this.canBackWithNotEvaluation + ", robot_code='" + this.robot_code + "', robot_alias='" + this.robot_alias + "', hideRototEvaluationLabels=" + this.hideRototEvaluationLabels + ", hideManualEvaluationLabels=" + this.hideManualEvaluationLabels + ", locale='" + this.locale + "', leaveParamsExtends=" + this.leaveParamsExtends + ", faqId=" + this.faqId + ", helpCenterTel='" + this.helpCenterTel + "', helpCenterTelTitle='" + this.helpCenterTelTitle + "', leaveTemplateId='" + this.leaveTemplateId + "', hideMenuManualLeave=" + this.hideMenuManualLeave + ", isFirstEntry=" + this.isFirstEntry + ", sign='" + this.sign + "', createTime='" + this.createTime + "', user_out_word='" + this.user_out_word + "', user_tip_word='" + this.user_tip_word + "', admin_tip_word='" + this.admin_tip_word + "', robot_hello_word='" + this.robot_hello_word + "', admin_offline_title='" + this.admin_offline_title + "', admin_hello_word='" + this.admin_hello_word + "', secretKey='" + this.secretKey + "', appkey='" + this.appkey + "', customerCode='" + this.customerCode + "', receptionistId='" + this.receptionistId + "', uid='" + this.uid + "', uname='" + this.uname + "', realname='" + this.realname + "', tel='" + this.tel + "', email='" + this.email + "', customInfo='" + this.customInfo + "', summaryParams='" + this.summaryParams + "', customerFields='" + this.customerFields + "', mulitParams='" + this.mulitParams + "', visitTitle='" + this.visitTitle + "', visitUrl='" + this.visitUrl + "', consultingContent=" + this.consultingContent + ", initModeType=" + this.initModeType + ", skillSetId='" + this.skillSetId + "', skillSetName='" + this.skillSetName + "', isQueueFirst=" + this.isQueueFirst + ", questionRecommendParams=" + this.questionRecommendParams + ", titleImgId=" + this.titleImgId + ", isArtificialIntelligence=" + this.isArtificialIntelligence + ", artificialIntelligenceNum=" + this.artificialIntelligenceNum + ", isUseVoice=" + this.isUseVoice + ", isUseRobotVoice=" + this.isUseRobotVoice + ", isShowSatisfaction=" + this.isShowSatisfaction + ", isShowCloseSatisfaction=" + this.isShowCloseSatisfaction + ", isShow=" + this.isShow + ", equipmentId='" + this.equipmentId + "', tranReceptionistFlag=" + this.tranReceptionistFlag + ", robotCode='" + this.robotCode + "', transferKeyWord=" + this.transferKeyWord + '}';
    }
}
