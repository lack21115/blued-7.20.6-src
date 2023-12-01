package com.danlan.android.security.obfuscator;

import java.io.UnsupportedEncodingException;

/* loaded from: source-7206380-dex2jar.jar:com/danlan/android/security/obfuscator/StringFogImpl.class */
public final class StringFogImpl {
    private static byte[] a(byte[] bArr, String str) {
        int length = bArr.length;
        int length2 = str.length();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= length) {
                return bArr;
            }
            int i4 = i3;
            if (i3 >= length2) {
                i4 = 0;
            }
            bArr[i] = (byte) (bArr[i] ^ str.charAt(i4));
            i++;
            i2 = i4 + 1;
        }
    }

    public String a(String str, String str2) {
        try {
            return new String(a(Base64.a(str, 2), str2), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return new String(a(Base64.a(str, 2), str2));
        }
    }

    public boolean b(String str, String str2) {
        return str != null && (str.length() * 4) / 3 >= 65535;
    }
}
