package com.sobot.network.http.upload;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/upload/SobotUploadModelBase.class */
public class SobotUploadModelBase {
    private String msg;
    private String status;
    private String switchFlag;

    public String getMsg() {
        return this.msg;
    }

    public String getStatus() {
        return this.status;
    }

    public String getSwitchFlag() {
        return this.switchFlag;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setSwitchFlag(String str) {
        this.switchFlag = str;
    }

    public String toString() {
        return "CommonModelBase{status='" + this.status + "'switchFlag='" + this.switchFlag + "'}";
    }
}
