package com.igexin.sdk.message;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/sdk/message/GTCmdMessage.class */
public class GTCmdMessage extends BaseMessage {
    private int action;

    public GTCmdMessage() {
    }

    public GTCmdMessage(int i) {
        this.action = i;
    }

    public int getAction() {
        return this.action;
    }

    public void setAction(int i) {
        this.action = i;
    }
}
