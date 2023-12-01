package com.tencent.cos.xml.model.tag.eventstreaming;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/JSONType.class */
public enum JSONType {
    DOCUMENT("DOCUMENT"),
    LINES("LINES");
    
    private final String jsonType;

    JSONType(String str) {
        this.jsonType = str;
    }

    public static JSONType fromValue(String str) {
        if (str == null || "".equals(str)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        JSONType[] values = values();
        int length = values.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
            }
            JSONType jSONType = values[i2];
            if (jSONType.toString().equals(str)) {
                return jSONType;
            }
            i = i2 + 1;
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.jsonType;
    }
}
