package com.sobot.chat.api.model;

import java.io.Serializable;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/SobotLeaveMsgFieldModel.class */
public class SobotLeaveMsgFieldModel implements Serializable {
    private String id;
    private String params;
    private String value;

    public SobotLeaveMsgFieldModel(String str, String str2, String str3) {
        this.id = str;
        this.value = str2;
        this.params = str3;
    }

    public String getId() {
        return this.id;
    }

    public String getParams() {
        return this.params;
    }

    public String getValue() {
        return this.value;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setParams(String str) {
        this.params = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        return "SobotLeaveMsgFieldModel{id='" + this.id + "', value='" + this.value + "', params='" + this.params + "'}";
    }
}
