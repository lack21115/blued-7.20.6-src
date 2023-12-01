package com.sobot.chat.core.a.b;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/core/a/b/b.class */
public class b {
    public static final String b = "UTF-8";

    /* renamed from: a  reason: collision with root package name */
    final b f14531a = this;

    public static String a(byte[] bArr, String str) {
        if (bArr != null) {
            try {
                return new String(Arrays.copyOfRange(bArr, 2, bArr.length), str);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static byte[] a(String str, String str2) {
        if (str != null) {
            try {
                return str.getBytes(str2);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static byte[] b(String str, String str2) {
        if (str != null) {
            try {
                byte[] a2 = a(str, str2);
                byte[] bArr = new byte[a2.length + 2];
                bArr[0] = 1;
                bArr[1] = 1;
                System.arraycopy(a2, 0, bArr, 2, a2.length);
                return bArr;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static byte[] c(String str, String str2) {
        if (str != null) {
            try {
                byte[] a2 = a(str, str2);
                byte[] bArr = new byte[a2.length + 2];
                bArr[0] = 1;
                bArr[1] = 0;
                System.arraycopy(a2, 0, bArr, 2, a2.length);
                return bArr;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static byte[] d(String str, String str2) {
        if (str != null) {
            try {
                byte[] a2 = a(str, str2);
                byte[] bArr = new byte[a2.length + 2];
                bArr[0] = 1;
                bArr[1] = 3;
                System.arraycopy(a2, 0, bArr, 2, a2.length);
                return bArr;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static byte[] e(String str, String str2) {
        if (str != null) {
            try {
                byte[] a2 = a(str, str2);
                byte[] bArr = new byte[a2.length + 2];
                bArr[0] = 1;
                bArr[1] = 2;
                System.arraycopy(a2, 0, bArr, 2, a2.length);
                return bArr;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static byte[] f(String str, String str2) {
        if (str != null) {
            try {
                return a(str, str2);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
