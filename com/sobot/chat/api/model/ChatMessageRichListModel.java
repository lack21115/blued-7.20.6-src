package com.sobot.chat.api.model;

import java.io.Serializable;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/ChatMessageRichListModel.class */
public class ChatMessageRichListModel implements Serializable {
    private String msg;
    private String name;
    private int type;

    public String getMsg() {
        return this.msg;
    }

    public String getName() {
        return this.name;
    }

    public int getType() {
        return this.type;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setType(int i) {
        this.type = i;
    }
}
