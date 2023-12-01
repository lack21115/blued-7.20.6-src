package com.sobot.chat.api.model;

import java.io.Serializable;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/CommonModel.class */
public class CommonModel extends BaseCode<CommonModelBase> implements Serializable {
    private static final long serialVersionUID = 1;
    private String msg;

    @Override // com.sobot.chat.api.model.BaseCode
    public String getMsg() {
        return this.msg;
    }

    @Override // com.sobot.chat.api.model.BaseCode
    public void setMsg(String str) {
        this.msg = str;
    }

    @Override // com.sobot.chat.api.model.BaseCode
    public String toString() {
        return "CommonModel{msg='" + this.msg + "'}";
    }
}
