package com.anythink.core.common.k;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/k/r.class */
public final class r {
    private static String a(String str, String str2) {
        int length = str.length();
        int length2 = str2.length();
        if (length == length2) {
            return str;
        }
        int abs = Math.abs(length2 - length);
        StringBuilder sb = new StringBuilder(str);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= abs) {
                return sb.toString();
            }
            sb.append(" ");
            i = i2 + 1;
        }
    }
}
