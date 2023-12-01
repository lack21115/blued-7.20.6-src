package com.sobot.chat.api.model;

import java.io.Serializable;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/SobotOfflineLeaveMsgBaseModel.class */
public class SobotOfflineLeaveMsgBaseModel implements Serializable {
    private String code;
    private SobotOfflineLeaveMsgModel data;
    private String msg;

    public String getCode() {
        return this.code;
    }

    public SobotOfflineLeaveMsgModel getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setData(SobotOfflineLeaveMsgModel sobotOfflineLeaveMsgModel) {
        this.data = sobotOfflineLeaveMsgModel;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public String toString() {
        return "SobotOfflineLeaveMsgBaseModel{code=" + this.code + ", data=" + this.data + ", msg='" + this.msg + "'}";
    }
}
