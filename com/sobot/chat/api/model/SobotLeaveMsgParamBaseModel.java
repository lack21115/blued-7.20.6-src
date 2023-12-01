package com.sobot.chat.api.model;

import java.io.Serializable;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/SobotLeaveMsgParamBaseModel.class */
public class SobotLeaveMsgParamBaseModel implements Serializable {
    private String code;
    private SobotLeaveMsgParamModel data;
    private String msg;

    public String getCode() {
        return this.code;
    }

    public SobotLeaveMsgParamModel getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setData(SobotLeaveMsgParamModel sobotLeaveMsgParamModel) {
        this.data = sobotLeaveMsgParamModel;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public String toString() {
        return "SobotLeaveMsgParamBaseModel{code=" + this.code + ", data=" + this.data + ", msg='" + this.msg + "'}";
    }
}
