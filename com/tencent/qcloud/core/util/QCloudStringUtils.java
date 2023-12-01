package com.tencent.qcloud.core.util;

import java.nio.charset.Charset;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/util/QCloudStringUtils.class */
public class QCloudStringUtils {
    public static boolean equals(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence != charSequence2) {
            if (charSequence == null || charSequence2 == null) {
                return false;
            }
            return ((charSequence instanceof String) && (charSequence2 instanceof String)) ? charSequence.equals(charSequence2) : regionMatches(charSequence, false, 0, charSequence2, 0, Math.max(charSequence.length(), charSequence2.length()));
        }
        return true;
    }

    public static byte[] getBytesUTF8(String str) {
        return str.getBytes(Charset.forName("UTF-8"));
    }

    public static String getExtension(String str) {
        int lastIndexOf;
        if (str != null && (lastIndexOf = str.lastIndexOf(".")) >= 0) {
            return str.substring(lastIndexOf + 1);
        }
        return null;
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static String newStringUTF8(byte[] bArr) {
        return new String(bArr, Charset.forName("UTF-8"));
    }

    static boolean regionMatches(CharSequence charSequence, boolean z, int i, CharSequence charSequence2, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        if (charSequence instanceof String) {
            i4 = i;
            i5 = i2;
            i6 = i3;
            if (charSequence2 instanceof String) {
                return ((String) charSequence).regionMatches(z, i, (String) charSequence2, i2, i3);
            }
        }
        while (i6 > 0) {
            char charAt = charSequence.charAt(i4);
            char charAt2 = charSequence2.charAt(i5);
            if (charAt != charAt2) {
                if (!z) {
                    return false;
                }
                if (Character.toUpperCase(charAt) != Character.toUpperCase(charAt2) && Character.toLowerCase(charAt) != Character.toLowerCase(charAt2)) {
                    return false;
                }
            }
            i4++;
            i6--;
            i5++;
        }
        return true;
    }
}
