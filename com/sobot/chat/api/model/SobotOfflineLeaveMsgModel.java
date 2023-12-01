package com.sobot.chat.api.model;

import java.io.Serializable;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/SobotOfflineLeaveMsgModel.class */
public class SobotOfflineLeaveMsgModel implements Serializable {
    public String leaveExplain;
    public String msgLeaveContentTxt;
    public String msgLeaveTxt;

    public String getLeaveExplain() {
        return this.leaveExplain;
    }

    public String getMsgLeaveContentTxt() {
        return this.msgLeaveContentTxt;
    }

    public String getMsgLeaveTxt() {
        return this.msgLeaveTxt;
    }

    public void setLeaveExplain(String str) {
        this.leaveExplain = str;
    }

    public void setMsgLeaveContentTxt(String str) {
        this.msgLeaveContentTxt = str;
    }

    public void setMsgLeaveTxt(String str) {
        this.msgLeaveTxt = str;
    }

    public String toString() {
        return "SobotOfflineLeaveMsgModel{msgLeaveTxt='" + this.msgLeaveTxt + "', msgLeaveContentTxt='" + this.msgLeaveContentTxt + "', leaveExplain='" + this.leaveExplain + "'}";
    }
}
