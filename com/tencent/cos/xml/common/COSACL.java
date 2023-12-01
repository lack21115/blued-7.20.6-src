package com.tencent.cos.xml.common;

import com.meizu.cloud.pushsdk.constants.PushConstants;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/common/COSACL.class */
public enum COSACL {
    PRIVATE(PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE),
    PUBLIC_READ("public-read"),
    PUBLIC_READ_WRITE("public-read-write"),
    DEFAULT("default");
    
    private String acl;

    COSACL(String str) {
        this.acl = str;
    }

    public static COSACL fromString(String str) {
        COSACL[] values = values();
        int length = values.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            COSACL cosacl = values[i2];
            if (cosacl.acl.equalsIgnoreCase(str)) {
                return cosacl;
            }
            i = i2 + 1;
        }
    }

    public String getAcl() {
        return this.acl;
    }
}
