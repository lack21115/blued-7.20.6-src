package com.sobot.chat.api.model;

import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/SobotKeyWordTransfer.class */
public class SobotKeyWordTransfer {
    private String groupId;
    private List<ZhiChiGroupBase> groupList;
    private String keyword;
    private String keywordId;
    private int onlineFlag;
    private boolean queueFlag;
    private String tipsMessage;
    private int transferFlag;
    private String transferTips;

    public String getGroupId() {
        return this.groupId;
    }

    public List<ZhiChiGroupBase> getGroupList() {
        return this.groupList;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public String getKeywordId() {
        return this.keywordId;
    }

    public int getOnlineFlag() {
        return this.onlineFlag;
    }

    public String getTipsMessage() {
        return this.tipsMessage;
    }

    public int getTransferFlag() {
        return this.transferFlag;
    }

    public String getTransferTips() {
        return this.transferTips;
    }

    public boolean isQueueFlag() {
        return this.queueFlag;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public void setGroupList(List<ZhiChiGroupBase> list) {
        this.groupList = list;
    }

    public void setKeyword(String str) {
        this.keyword = str;
    }

    public void setKeywordId(String str) {
        this.keywordId = str;
    }

    public void setOnlineFlag(int i) {
        this.onlineFlag = i;
    }

    public void setQueueFlag(boolean z) {
        this.queueFlag = z;
    }

    public void setTipsMessage(String str) {
        this.tipsMessage = str;
    }

    public void setTransferFlag(int i) {
        this.transferFlag = i;
    }

    public void setTransferTips(String str) {
        this.transferTips = str;
    }

    public String toString() {
        return "SobotKeyWordTransfer{keywordId='" + this.keywordId + "', keyword='" + this.keyword + "', transferFlag=" + this.transferFlag + ", groupId='" + this.groupId + "', tipsMessage='" + this.tipsMessage + "', queueFlag=" + this.queueFlag + ", groupList=" + this.groupList + ", onlineFlag='" + this.onlineFlag + "', transferTips='" + this.transferTips + "'}";
    }
}
