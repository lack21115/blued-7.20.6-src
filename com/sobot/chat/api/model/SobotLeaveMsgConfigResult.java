package com.sobot.chat.api.model;

import java.io.Serializable;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/SobotLeaveMsgConfigResult.class */
public class SobotLeaveMsgConfigResult implements Serializable {
    private String code;
    private SobotLeaveMsgConfig data;
    private String msg;

    public String getCode() {
        return this.code;
    }

    public SobotLeaveMsgConfig getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setData(SobotLeaveMsgConfig sobotLeaveMsgConfig) {
        this.data = sobotLeaveMsgConfig;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public String toString() {
        return "SobotLeaveMsgParamBaseModel{code=" + this.code + ", data=" + this.data + ", msg='" + this.msg + "'}";
    }
}
