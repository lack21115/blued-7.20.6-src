package com.igexin.sdk.message;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/sdk/message/SetTagCmdMessage.class */
public class SetTagCmdMessage extends GTCmdMessage {
    private String code;
    private String sn;

    public SetTagCmdMessage() {
    }

    public SetTagCmdMessage(String str, String str2, int i) {
        super(i);
        this.sn = str;
        this.code = str2;
    }

    public String getCode() {
        return this.code;
    }

    public String getSn() {
        return this.sn;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setSn(String str) {
        this.sn = str;
    }
}
