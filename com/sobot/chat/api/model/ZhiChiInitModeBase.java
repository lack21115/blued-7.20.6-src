package com.sobot.chat.api.model;

import java.io.Serializable;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/ZhiChiInitModeBase.class */
public class ZhiChiInitModeBase implements Serializable {
    private static final long serialVersionUID = 1;
    private int accountStatus;
    private String adminHelloWord;
    private boolean adminHelloWordCountRule;
    private boolean adminHelloWordFlag;
    private boolean adminNoneLineFlag;
    private String adminNonelineTitle;
    private String adminTipTime;
    private String adminTipWord;
    private boolean announceTopFlag;
    private String appId;
    private String cid;
    private String companyId;
    private String companyLogo;
    private String companyName;
    private String companyStatus;
    private String currentRobotFlag;
    private boolean customOutTimeFlag;
    private String customerId;
    private boolean emailFlag;
    private boolean emailShowFlag;
    private boolean enclosureFlag;
    private boolean enclosureShowFlag;
    private String groupflag;
    private int guideFlag;
    private int inputTime;
    private int invalidSessionFlag;
    private String isblack;
    private boolean lableLinkFlag;
    private String manualCommentTitle;
    private String manualType;
    private int msgFlag;
    private String msgLeaveContentTxt;
    private String msgLeaveTxt;
    private String msgTmp;
    private boolean msgToTicketFlag;
    private String msgTxt;
    private String offlineMsgAdminId;
    private int offlineMsgConnectFlag;
    private String partnerid;
    private boolean realuateFlag;
    private int realuateTransferFlag;
    private String robotCommentTitle;
    private String robotHelloWord;
    private boolean robotHelloWordFlag;
    private String robotLogo;
    private String robotName;
    private boolean robotSwitchFlag;
    private String robotUnknownWord;
    private String robotid;
    private boolean serviceEndPushFlag;
    private String serviceEndPushMsg;
    private boolean serviceOutCountRule;
    private boolean serviceOutTimeFlag;
    private boolean smartRouteInfoFlag;
    private boolean telFlag;
    private boolean telShowFlag;
    private boolean ticketShowFlag;
    private boolean ticketStartWay;
    private String type;
    private String uid;
    private String userOutTime;
    private String userOutWord;
    private String userTipTime;
    private String userTipWord;
    private int ustatus;
    private boolean announceClickFlag = false;
    private String announceClickUrl = "";
    private boolean announceMsgFlag = false;
    private String announceMsg = "";

    public int getAccountStatus() {
        return this.accountStatus;
    }

    public String getAdminHelloWord() {
        return this.adminHelloWord;
    }

    public String getAdminNonelineTitle() {
        return this.adminNonelineTitle;
    }

    public String getAdminTipTime() {
        return this.adminTipTime;
    }

    public String getAdminTipWord() {
        return this.adminTipWord;
    }

    public boolean getAnnounceClickFlag() {
        return this.announceClickFlag;
    }

    public String getAnnounceClickUrl() {
        return this.announceClickUrl;
    }

    public String getAnnounceMsg() {
        return this.announceMsg;
    }

    public boolean getAnnounceMsgFlag() {
        return this.announceMsgFlag;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getCid() {
        return this.cid;
    }

    public String getCompanyId() {
        return this.companyId;
    }

    public String getCompanyLogo() {
        return this.companyLogo;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public String getCompanyStatus() {
        return this.companyStatus;
    }

    @Deprecated
    public String getCurrentRobotFlag() {
        return this.currentRobotFlag;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public String getGroupflag() {
        return this.groupflag;
    }

    public int getGuideFlag() {
        return this.guideFlag;
    }

    public int getInputTime() {
        return this.inputTime;
    }

    public int getInvalidSessionFlag() {
        return this.invalidSessionFlag;
    }

    public String getIsblack() {
        return this.isblack;
    }

    public String getManualCommentTitle() {
        return this.manualCommentTitle;
    }

    public String getManualType() {
        return this.manualType;
    }

    public int getMsgFlag() {
        return this.msgFlag;
    }

    public String getMsgLeaveContentTxt() {
        return this.msgLeaveContentTxt;
    }

    public String getMsgLeaveTxt() {
        return this.msgLeaveTxt;
    }

    public String getMsgTmp() {
        return this.msgTmp;
    }

    public String getMsgTxt() {
        return this.msgTxt;
    }

    public String getOfflineMsgAdminId() {
        return this.offlineMsgAdminId;
    }

    public int getOfflineMsgConnectFlag() {
        return this.offlineMsgConnectFlag;
    }

    public String getPartnerid() {
        return this.partnerid;
    }

    public int getRealuateTransferFlag() {
        return this.realuateTransferFlag;
    }

    public String getRobotCommentTitle() {
        return this.robotCommentTitle;
    }

    public String getRobotHelloWord() {
        return this.robotHelloWord;
    }

    public String getRobotLogo() {
        return this.robotLogo;
    }

    public String getRobotName() {
        return this.robotName;
    }

    public String getRobotUnknownWord() {
        return this.robotUnknownWord;
    }

    public String getRobotid() {
        return this.robotid;
    }

    public String getServiceEndPushMsg() {
        return this.serviceEndPushMsg;
    }

    public String getType() {
        return this.type;
    }

    @Deprecated
    public String getUid() {
        return this.uid;
    }

    public String getUserOutTime() {
        return this.userOutTime;
    }

    public String getUserOutWord() {
        return this.userOutWord;
    }

    public String getUserTipTime() {
        return this.userTipTime;
    }

    public String getUserTipWord() {
        return this.userTipWord;
    }

    public int getUstatus() {
        return this.ustatus;
    }

    public boolean isAdminHelloWordCountRule() {
        return this.adminHelloWordCountRule;
    }

    public boolean isAdminHelloWordFlag() {
        return this.adminHelloWordFlag;
    }

    public boolean isAdminNoneLineFlag() {
        return this.adminNoneLineFlag;
    }

    public boolean isAnnounceClickFlag() {
        return this.announceClickFlag;
    }

    public boolean isAnnounceMsgFlag() {
        return this.announceMsgFlag;
    }

    public boolean isAnnounceTopFlag() {
        return this.announceTopFlag;
    }

    public boolean isCustomOutTimeFlag() {
        return this.customOutTimeFlag;
    }

    public boolean isEmailFlag() {
        return this.emailFlag;
    }

    public boolean isEmailShowFlag() {
        return this.emailShowFlag;
    }

    public boolean isEnclosureFlag() {
        return this.enclosureFlag;
    }

    public boolean isEnclosureShowFlag() {
        return this.enclosureShowFlag;
    }

    public boolean isLableLinkFlag() {
        return this.lableLinkFlag;
    }

    public boolean isMsgToTicketFlag() {
        return this.msgToTicketFlag;
    }

    public boolean isRealuateFlag() {
        return this.realuateFlag;
    }

    public boolean isRobotHelloWordFlag() {
        return this.robotHelloWordFlag;
    }

    public boolean isRobotSwitchFlag() {
        return this.robotSwitchFlag;
    }

    public boolean isServiceEndPushFlag() {
        return this.serviceEndPushFlag;
    }

    public boolean isServiceOutCountRule() {
        return this.serviceOutCountRule;
    }

    public boolean isServiceOutTimeFlag() {
        return this.serviceOutTimeFlag;
    }

    public boolean isSmartRouteInfoFlag() {
        return this.smartRouteInfoFlag;
    }

    public boolean isTelFlag() {
        return this.telFlag;
    }

    public boolean isTelShowFlag() {
        return this.telShowFlag;
    }

    public boolean isTicketShowFlag() {
        return this.ticketShowFlag;
    }

    public boolean isTicketStartWay() {
        return this.ticketStartWay;
    }

    public void setAccountStatus(int i) {
        this.accountStatus = i;
    }

    public void setAdminHelloWord(String str) {
        this.adminHelloWord = str;
    }

    public void setAdminHelloWordCountRule(boolean z) {
        this.adminHelloWordCountRule = z;
    }

    public void setAdminHelloWordFlag(boolean z) {
        this.adminHelloWordFlag = z;
    }

    public void setAdminNoneLineFlag(boolean z) {
        this.adminNoneLineFlag = z;
    }

    public void setAdminNonelineTitle(String str) {
        this.adminNonelineTitle = str;
    }

    public void setAdminTipTime(String str) {
        this.adminTipTime = str;
    }

    public void setAdminTipWord(String str) {
        this.adminTipWord = str;
    }

    public void setAnnounceClickFlag(boolean z) {
        this.announceClickFlag = z;
    }

    public void setAnnounceClickUrl(String str) {
        this.announceClickUrl = str;
    }

    public void setAnnounceMsg(String str) {
        this.announceMsg = str;
    }

    public void setAnnounceMsgFlag(boolean z) {
        this.announceMsgFlag = z;
    }

    public void setAnnounceTopFlag(boolean z) {
        this.announceTopFlag = z;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setCid(String str) {
        this.cid = str;
    }

    public void setCompanyId(String str) {
        this.companyId = str;
    }

    public void setCompanyLogo(String str) {
        this.companyLogo = str;
    }

    public void setCompanyName(String str) {
        this.companyName = str;
    }

    public void setCompanyStatus(String str) {
        this.companyStatus = str;
    }

    @Deprecated
    public void setCurrentRobotFlag(String str) {
        this.currentRobotFlag = str;
        this.robotid = str;
    }

    public void setCustomOutTimeFlag(boolean z) {
        this.customOutTimeFlag = z;
    }

    public void setCustomerId(String str) {
        this.customerId = str;
    }

    public void setEmailFlag(boolean z) {
        this.emailFlag = z;
    }

    public void setEmailShowFlag(boolean z) {
        this.emailShowFlag = z;
    }

    public void setEnclosureFlag(boolean z) {
        this.enclosureFlag = z;
    }

    public void setEnclosureShowFlag(boolean z) {
        this.enclosureShowFlag = z;
    }

    public void setGroupflag(String str) {
        this.groupflag = str;
    }

    public void setGuideFlag(int i) {
        this.guideFlag = i;
    }

    public void setInputTime(int i) {
        if (i <= 0) {
            this.inputTime = 1;
        } else {
            this.inputTime = i;
        }
    }

    public void setInvalidSessionFlag(int i) {
        this.invalidSessionFlag = i;
    }

    public void setIsblack(String str) {
        this.isblack = str;
    }

    public void setLableLinkFlag(boolean z) {
        this.lableLinkFlag = z;
    }

    public void setManualCommentTitle(String str) {
        this.manualCommentTitle = str;
    }

    public void setManualType(String str) {
        this.manualType = str;
    }

    public void setMsgFlag(int i) {
        this.msgFlag = i;
    }

    public void setMsgLeaveContentTxt(String str) {
        this.msgLeaveContentTxt = str;
    }

    public void setMsgLeaveTxt(String str) {
        this.msgLeaveTxt = str;
    }

    public void setMsgTmp(String str) {
        this.msgTmp = str;
    }

    public void setMsgToTicketFlag(boolean z) {
        this.msgToTicketFlag = z;
    }

    public void setMsgTxt(String str) {
        this.msgTxt = str;
    }

    public void setOfflineMsgAdminId(String str) {
        this.offlineMsgAdminId = str;
    }

    public void setOfflineMsgConnectFlag(int i) {
        this.offlineMsgConnectFlag = i;
    }

    public void setPartnerid(String str) {
        this.partnerid = str;
        this.uid = str;
    }

    public void setRealuateFlag(boolean z) {
        this.realuateFlag = z;
    }

    public void setRealuateTransferFlag(int i) {
        this.realuateTransferFlag = i;
    }

    public void setRobotCommentTitle(String str) {
        this.robotCommentTitle = str;
    }

    public void setRobotHelloWord(String str) {
        this.robotHelloWord = str;
    }

    public void setRobotHelloWordFlag(boolean z) {
        this.robotHelloWordFlag = z;
    }

    public void setRobotLogo(String str) {
        this.robotLogo = str;
    }

    public void setRobotName(String str) {
        this.robotName = str;
    }

    public void setRobotSwitchFlag(boolean z) {
        this.robotSwitchFlag = z;
    }

    public void setRobotUnknownWord(String str) {
        this.robotUnknownWord = str;
    }

    public void setRobotid(String str) {
        this.robotid = str;
        this.currentRobotFlag = str;
    }

    public void setServiceEndPushFlag(boolean z) {
        this.serviceEndPushFlag = z;
    }

    public void setServiceEndPushMsg(String str) {
        this.serviceEndPushMsg = str;
    }

    public void setServiceOutCountRule(boolean z) {
        this.serviceOutCountRule = z;
    }

    public void setServiceOutTimeFlag(boolean z) {
        this.serviceOutTimeFlag = z;
    }

    public void setSmartRouteInfoFlag(boolean z) {
        this.smartRouteInfoFlag = z;
    }

    public void setTelFlag(boolean z) {
        this.telFlag = z;
    }

    public void setTelShowFlag(boolean z) {
        this.telShowFlag = z;
    }

    public void setTicketShowFlag(boolean z) {
        this.ticketShowFlag = z;
    }

    public void setTicketStartWay(boolean z) {
        this.ticketStartWay = z;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Deprecated
    public void setUid(String str) {
        this.uid = str;
        this.partnerid = str;
    }

    public void setUserOutTime(String str) {
        this.userOutTime = str;
    }

    public void setUserOutWord(String str) {
        this.userOutWord = str;
    }

    public void setUserTipTime(String str) {
        this.userTipTime = str;
    }

    public void setUserTipWord(String str) {
        this.userTipWord = str;
    }

    public void setUstatus(int i) {
        this.ustatus = i;
    }

    public String toString() {
        return "ZhiChiInitModeBase{robotid='" + this.robotid + "', partnerid='" + this.partnerid + "', currentRobotFlag='" + this.currentRobotFlag + "', uid='" + this.uid + "', offlineMsgConnectFlag=" + this.offlineMsgConnectFlag + ", offlineMsgAdminId='" + this.offlineMsgAdminId + "', invalidSessionFlag=" + this.invalidSessionFlag + ", realuateTransferFlag=" + this.realuateTransferFlag + ", appId='" + this.appId + "', robotLogo='" + this.robotLogo + "', manualCommentTitle='" + this.manualCommentTitle + "', msgTmp='" + this.msgTmp + "', type='" + this.type + "', isblack='" + this.isblack + "', robotUnknownWord='" + this.robotUnknownWord + "', groupflag='" + this.groupflag + "', guideFlag=" + this.guideFlag + ", msgTxt='" + this.msgTxt + "', msgFlag=" + this.msgFlag + ", msgToTicketFlag=" + this.msgToTicketFlag + ", msgLeaveTxt='" + this.msgLeaveTxt + "', msgLeaveContentTxt='" + this.msgLeaveContentTxt + "', adminTipTime='" + this.adminTipTime + "', inputTime=" + this.inputTime + ", ustatus=" + this.ustatus + ", companyLogo='" + this.companyLogo + "', companyName='" + this.companyName + "', cid='" + this.cid + "', robotName='" + this.robotName + "', companyStatus='" + this.companyStatus + "', userOutTime='" + this.userOutTime + "', companyId='" + this.companyId + "', robotCommentTitle='" + this.robotCommentTitle + "', manualType='" + this.manualType + "', realuateFlag=" + this.realuateFlag + ", userTipTime='" + this.userTipTime + "', customerId='" + this.customerId + "', robotSwitchFlag=" + this.robotSwitchFlag + ", lableLinkFlag=" + this.lableLinkFlag + ", accountStatus=" + this.accountStatus + ", smartRouteInfoFlag=" + this.smartRouteInfoFlag + ", serviceOutCountRule=" + this.serviceOutCountRule + ", adminHelloWordCountRule=" + this.adminHelloWordCountRule + ", adminHelloWord='" + this.adminHelloWord + "', robotHelloWord='" + this.robotHelloWord + "', userTipWord='" + this.userTipWord + "', adminNonelineTitle='" + this.adminNonelineTitle + "', adminTipWord='" + this.adminTipWord + "', userOutWord='" + this.userOutWord + "', robotHelloWordFlag=" + this.robotHelloWordFlag + ", adminHelloWordFlag=" + this.adminHelloWordFlag + ", adminNoneLineFlag=" + this.adminNoneLineFlag + ", serviceEndPushFlag=" + this.serviceEndPushFlag + ", serviceEndPushMsg='" + this.serviceEndPushMsg + "', emailFlag=" + this.emailFlag + ", emailShowFlag=" + this.emailShowFlag + ", enclosureFlag=" + this.enclosureFlag + ", enclosureShowFlag=" + this.enclosureShowFlag + ", telFlag=" + this.telFlag + ", telShowFlag=" + this.telShowFlag + ", ticketShowFlag=" + this.ticketShowFlag + ", ticketStartWay=" + this.ticketStartWay + ", customOutTimeFlag=" + this.customOutTimeFlag + ", serviceOutTimeFlag=" + this.serviceOutTimeFlag + ", announceTopFlag=" + this.announceTopFlag + ", announceClickFlag=" + this.announceClickFlag + ", announceClickUrl='" + this.announceClickUrl + "', announceMsgFlag=" + this.announceMsgFlag + ", announceMsg='" + this.announceMsg + "'}";
    }
}
