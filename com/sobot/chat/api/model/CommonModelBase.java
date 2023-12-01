package com.sobot.chat.api.model;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/CommonModelBase.class */
public class CommonModelBase {
    private String desensitizationWord;
    private String msg;
    private int sentisive = 0;
    private String sentisiveExplain;
    private String status;
    private String switchFlag;

    public String getDesensitizationWord() {
        return this.desensitizationWord;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getSentisive() {
        return this.sentisive;
    }

    public String getSentisiveExplain() {
        return this.sentisiveExplain;
    }

    public String getStatus() {
        return this.status;
    }

    public String getSwitchFlag() {
        return this.switchFlag;
    }

    public void setDesensitizationWord(String str) {
        this.desensitizationWord = str;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setSentisive(int i) {
        this.sentisive = i;
    }

    public void setSentisiveExplain(String str) {
        this.sentisiveExplain = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setSwitchFlag(String str) {
        this.switchFlag = str;
    }

    public String toString() {
        return "CommonModelBase{status='" + this.status + "', msg='" + this.msg + "', switchFlag='" + this.switchFlag + "', sentisive=" + this.sentisive + ", sentisiveExplain='" + this.sentisiveExplain + "', desensitizationWord='" + this.desensitizationWord + "'}";
    }
}
