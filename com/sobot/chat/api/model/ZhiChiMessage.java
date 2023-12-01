package com.sobot.chat.api.model;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/ZhiChiMessage.class */
public class ZhiChiMessage extends BaseCode<ZhiChiMessageBase> {
    private String msg;

    @Override // com.sobot.chat.api.model.BaseCode
    public String getMsg() {
        return this.msg;
    }

    @Override // com.sobot.chat.api.model.BaseCode
    public void setMsg(String str) {
        this.msg = str;
    }
}
