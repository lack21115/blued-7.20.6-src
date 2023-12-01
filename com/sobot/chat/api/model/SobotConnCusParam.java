package com.sobot.chat.api.model;

import java.io.Serializable;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/SobotConnCusParam.class */
public class SobotConnCusParam implements Serializable {
    private String activeTransfer;
    private String chooseAdminId;
    private String cid;
    private boolean currentFlag;
    private String docId;
    private String groupId;
    private String groupName;
    private String keyword;
    private String keywordId;
    private String offlineMsgAdminId;
    private int offlineMsgConnectFlag;
    private String partnerid;
    private String summaryParams;
    private String summary_params;
    private int tranFlag;
    private int tran_flag;
    private String transferAction;
    private int transferType;
    private String uid;
    private String unknownQuestion;
    private boolean queue_first = false;
    private boolean isQueueFirst = false;

    public String getActiveTransfer() {
        return this.activeTransfer;
    }

    public String getChooseAdminId() {
        return this.chooseAdminId;
    }

    public String getCid() {
        return this.cid;
    }

    public String getDocId() {
        return this.docId;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public String getKeywordId() {
        return this.keywordId;
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

    @Deprecated
    public String getSummaryParams() {
        return this.summaryParams;
    }

    public String getSummary_params() {
        return this.summary_params;
    }

    @Deprecated
    public int getTranFlag() {
        return this.tranFlag;
    }

    public int getTran_flag() {
        return this.tran_flag;
    }

    public String getTransferAction() {
        return this.transferAction;
    }

    public int getTransferType() {
        return this.transferType;
    }

    @Deprecated
    public String getUid() {
        return this.uid;
    }

    public String getUnknownQuestion() {
        return this.unknownQuestion;
    }

    public boolean isCurrentFlag() {
        return this.currentFlag;
    }

    @Deprecated
    public boolean isQueueFirst() {
        return this.isQueueFirst;
    }

    public boolean is_queue_first() {
        return this.queue_first;
    }

    public void setActiveTransfer(String str) {
        this.activeTransfer = str;
    }

    public void setChooseAdminId(String str) {
        this.chooseAdminId = str;
    }

    public void setCid(String str) {
        this.cid = str;
    }

    public void setCurrentFlag(boolean z) {
        this.currentFlag = z;
    }

    public void setDocId(String str) {
        this.docId = str;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setIs_Queue_First(boolean z) {
        this.queue_first = z;
        this.isQueueFirst = z;
    }

    public void setKeyword(String str) {
        this.keyword = str;
    }

    public void setKeywordId(String str) {
        this.keywordId = str;
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

    @Deprecated
    public void setQueueFirst(boolean z) {
        this.isQueueFirst = z;
        this.queue_first = z;
    }

    @Deprecated
    public void setSummaryParams(String str) {
        this.summaryParams = str;
        this.summary_params = str;
    }

    public void setSummary_params(String str) {
        this.summary_params = str;
        this.summaryParams = str;
    }

    @Deprecated
    public void setTranFlag(int i) {
        this.tranFlag = i;
        this.tran_flag = i;
    }

    public void setTran_flag(int i) {
        this.tran_flag = i;
        this.tranFlag = i;
    }

    public void setTransferAction(String str) {
        this.transferAction = str;
    }

    public void setTransferType(int i) {
        this.transferType = i;
    }

    @Deprecated
    public void setUid(String str) {
        this.uid = str;
        this.partnerid = str;
    }

    public void setUnknownQuestion(String str) {
        this.unknownQuestion = str;
    }

    public String toString() {
        return "SobotConnCusParam{tran_flag=" + this.tran_flag + ", queue_first=" + this.queue_first + ", transferAction='" + this.transferAction + "', summary_params='" + this.summary_params + "', partnerid='" + this.partnerid + "', tranFlag=" + this.tranFlag + ", isQueueFirst=" + this.isQueueFirst + ", summaryParams='" + this.summaryParams + "', uid='" + this.uid + "', offlineMsgConnectFlag=" + this.offlineMsgConnectFlag + ", offlineMsgAdminId='" + this.offlineMsgAdminId + "', docId='" + this.docId + "', unknownQuestion='" + this.unknownQuestion + "', activeTransfer='" + this.activeTransfer + "', chooseAdminId='" + this.chooseAdminId + "', cid='" + this.cid + "', groupId='" + this.groupId + "', groupName='" + this.groupName + "', currentFlag=" + this.currentFlag + ", keyword='" + this.keyword + "', keywordId='" + this.keywordId + "', transferType=" + this.transferType + '}';
    }
}
