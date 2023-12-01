package com.tencent.cos.xml.common;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/common/ServerEncryptType.class */
public enum ServerEncryptType {
    NONE("NONE"),
    SSE_C("SSE-C"),
    SSE_COS("SSE-COS"),
    SSE_KMS("SSE-KMS");
    
    private String type;

    ServerEncryptType(String str) {
        this.type = str;
    }

    public static ServerEncryptType fromString(String str) {
        ServerEncryptType[] values = values();
        int length = values.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            ServerEncryptType serverEncryptType = values[i2];
            if (serverEncryptType.type.equalsIgnoreCase(str)) {
                return serverEncryptType;
            }
            i = i2 + 1;
        }
    }

    public String getType() {
        return this.type;
    }
}
