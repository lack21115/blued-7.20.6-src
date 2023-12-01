package com.anythink.core.common.k;

import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/k/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    static HashMap<Character, Character> f6801a;
    private static final String e = "ZE1XbmhiZXlLcjBKSXZMTk94M0JGa0V1bWw5Mlk1ZmpTcUdUN1I4cFpWY2lQSEFzdEM0VVhhNlFEdzFnb3orLw==";
    private static final String b = c.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f6802c = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static final byte[] d = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};
    private static String f = "";

    private c() {
    }

    private static Character a(char c2) {
        synchronized (c.class) {
            try {
                if (TextUtils.isEmpty(f)) {
                    f = b(e);
                }
                if (f6801a == null) {
                    f6801a = new HashMap<>();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= f6802c.length) {
                            break;
                        }
                        f6801a.put(Character.valueOf(f.charAt(i2)), Character.valueOf(f6802c[i2]));
                        i = i2 + 1;
                    }
                }
                if (f6801a.containsKey(Character.valueOf(c2))) {
                    return f6801a.get(Character.valueOf(c2));
                }
                return Character.valueOf(c2);
            } finally {
            }
        }
    }

    public static String a(String str) {
        return TextUtils.isEmpty(str) ? "" : a(str.getBytes());
    }

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            int i3 = i2 + 1;
            int i4 = bArr[i2] & 255;
            if (i3 == length) {
                stringBuffer.append(f6802c[i4 >>> 2]);
                stringBuffer.append(f6802c[(i4 & 3) << 4]);
                stringBuffer.append("==");
                break;
            }
            int i5 = i3 + 1;
            int i6 = bArr[i3] & 255;
            if (i5 == length) {
                stringBuffer.append(f6802c[i4 >>> 2]);
                stringBuffer.append(f6802c[((i4 & 3) << 4) | ((i6 & 240) >>> 4)]);
                stringBuffer.append(f6802c[(i6 & 15) << 2]);
                stringBuffer.append("=");
                break;
            }
            int i7 = bArr[i5] & 255;
            stringBuffer.append(f6802c[i4 >>> 2]);
            stringBuffer.append(f6802c[((i4 & 3) << 4) | ((i6 & 240) >>> 4)]);
            stringBuffer.append(f6802c[((i6 & 15) << 2) | ((i7 & 192) >>> 6)]);
            stringBuffer.append(f6802c[i7 & 63]);
            i = i5 + 1;
        }
        return stringBuffer.toString();
    }

    public static String b(String str) {
        return TextUtils.isEmpty(str) ? "" : new String(d(str));
    }

    public static String c(String str) {
        String str2 = "";
        String str3 = "";
        try {
            if (!TextUtils.isEmpty(str)) {
                char[] charArray = str.toCharArray();
                String str4 = "";
                if (charArray != null) {
                    str4 = "";
                    if (charArray.length > 0) {
                        char[] cArr = new char[charArray.length];
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= charArray.length) {
                                break;
                            }
                            cArr[i2] = a(charArray[i2]).charValue();
                            i = i2 + 1;
                        }
                        str4 = new String(cArr);
                    }
                }
                str2 = str4;
                return new String(d(str4));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            str3 = str2;
        }
        return str3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b5, code lost:
        if (r0 == (-1)) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b8, code lost:
        r0.write(((r0 & 15) << 4) | ((r0 & 60) >>> 2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ce, code lost:
        r0 = r6;
        r6 = r0 + 1;
        r0 = r0[r0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00d9, code lost:
        if (r0 != 61) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e1, code lost:
        return r0.toByteArray();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00e2, code lost:
        r0 = com.anythink.core.common.k.c.d[r0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ea, code lost:
        if (r6 >= r0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ef, code lost:
        if (r0 == (-1)) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00fc, code lost:
        if (r0 == (-1)) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ff, code lost:
        r0.write(r0 | ((r0 & 3) << 6));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] d(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.k.c.d(java.lang.String):byte[]");
    }
}
