package com.sobot.chat.api.model;

import java.io.Serializable;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/StPostMsgParam.class */
public class StPostMsgParam implements Serializable {
    private String companyId;
    private boolean flagExitSdk;
    private int flagExitType = -1;
    private String groupId;
    private String msgTmp;
    private String msgTxt;
    private String uid;

    public String getCompanyId() {
        return this.companyId;
    }

    public int getFlagExitType() {
        return this.flagExitType;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public String getMsgTmp() {
        return this.msgTmp;
    }

    public String getMsgTxt() {
        return this.msgTxt;
    }

    public String getPartnerid() {
        return this.uid;
    }

    public boolean isFlagExitSdk() {
        return this.flagExitSdk;
    }

    public void setCompanyId(String str) {
        this.companyId = str;
    }

    public void setFlagExitSdk(boolean z) {
        this.flagExitSdk = z;
    }

    public void setFlagExitType(int i) {
        this.flagExitType = i;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public void setMsgTmp(String str) {
        this.msgTmp = str;
    }

    public void setMsgTxt(String str) {
        this.msgTxt = str;
    }

    public void setPartnerid(String str) {
        this.uid = str;
    }
}
