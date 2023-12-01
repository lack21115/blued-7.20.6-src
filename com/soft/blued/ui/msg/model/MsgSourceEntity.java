package com.soft.blued.ui.msg.model;

import com.blued.das.message.MessageProtos;
import java.io.Serializable;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/MsgSourceEntity.class */
public class MsgSourceEntity implements Serializable {
    private String content;
    private int type;

    public MsgSourceEntity(MessageProtos.StrangerSource strangerSource) {
        this.type = strangerSource.getNumber();
        this.content = "";
    }

    public MsgSourceEntity(MessageProtos.StrangerSource strangerSource, String str) {
        this.type = strangerSource.getNumber();
        this.content = str;
    }

    public String getContent() {
        return this.content;
    }

    public MessageProtos.StrangerSource getType() {
        MessageProtos.StrangerSource forNumber = MessageProtos.StrangerSource.forNumber(this.type);
        return forNumber != null ? forNumber : MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setType(int i) {
        this.type = i;
    }
}
