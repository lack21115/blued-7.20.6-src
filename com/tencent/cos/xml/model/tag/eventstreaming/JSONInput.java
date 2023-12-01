package com.tencent.cos.xml.model.tag.eventstreaming;

import java.io.Serializable;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/JSONInput.class */
public class JSONInput implements Serializable {
    private String type;

    public JSONInput(JSONType jSONType) {
        this.type = jSONType.toString();
    }

    public JSONInput(String str) {
        this.type = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(JSONType jSONType) {
        setType(jSONType == null ? null : jSONType.toString());
    }

    public void setType(String str) {
        this.type = str;
    }

    public JSONInput withType(JSONType jSONType) {
        setType(jSONType);
        return this;
    }

    public JSONInput withType(String str) {
        setType(str);
        return this;
    }
}
