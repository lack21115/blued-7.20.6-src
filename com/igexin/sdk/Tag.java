package com.igexin.sdk;

import java.io.Serializable;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/sdk/Tag.class */
public class Tag implements Serializable {
    private static final long serialVersionUID = 7265815580156141684L;
    private String name;

    private boolean isValidTagName(String str) {
        boolean z;
        int length = str.length() - 1;
        boolean z2 = false;
        while (true) {
            z = z2;
            if (length >= 0) {
                char charAt = str.charAt(length);
                z2 = (charAt >= 19968 && charAt <= 40869) || (charAt >= 'A' && charAt <= 'Z') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= '0' && charAt <= '9') || charAt == '+' || charAt == '-' || charAt == '*' || charAt == '_' || charAt == ' ' || charAt == ':'));
                z = z2;
                if (!z2) {
                    break;
                }
                length--;
            } else {
                break;
            }
        }
        return z;
    }

    public String getName() {
        return this.name;
    }

    public boolean isValidTagValue(String str) {
        return isValidTagName(str);
    }

    public Tag setName(String str) {
        this.name = str;
        return this;
    }
}
