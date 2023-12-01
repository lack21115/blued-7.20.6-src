package com.sobot.chat.api.model;

import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/SobotPostMsgTemplateResult.class */
public class SobotPostMsgTemplateResult {
    private String code;
    private ArrayList<SobotPostMsgTemplate> data;
    private String ustatus;

    public String getCode() {
        return this.code;
    }

    public ArrayList<SobotPostMsgTemplate> getData() {
        return this.data;
    }

    public String getUstatus() {
        return this.ustatus;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setData(ArrayList<SobotPostMsgTemplate> arrayList) {
        this.data = arrayList;
    }

    public void setUstatus(String str) {
        this.ustatus = str;
    }
}
