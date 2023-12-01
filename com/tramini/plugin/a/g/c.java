package com.tramini.plugin.a.g;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/g/c.class */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static Map<Character, Character> f26853c;
    private static Map<Character, Character> d;
    private static final String b = c.class.getSimpleName();
    private static char[] e = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static byte[] f = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    /* renamed from: a  reason: collision with root package name */
    public static String f26852a = "";
    private static String g = "";

    static {
        f26853c = null;
        d = null;
        d = new HashMap();
        f26853c = new HashMap();
    }

    private c() {
    }

    public static String a(String str) {
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
                            char c2 = charArray[i2];
                            if (d == null) {
                                d = new HashMap();
                                int i3 = 0;
                                while (true) {
                                    int i4 = i3;
                                    if (i4 >= f26852a.length()) {
                                        break;
                                    }
                                    d.put(Character.valueOf(g.charAt(i4)), Character.valueOf(f26852a.charAt(i4)));
                                    i3 = i4 + 1;
                                }
                            }
                            cArr[i2] = (d.containsKey(Character.valueOf(c2)) ? d.get(Character.valueOf(c2)) : Character.valueOf(c2)).charValue();
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
                stringBuffer.append(e[i4 >>> 2]);
                stringBuffer.append(e[(i4 & 3) << 4]);
                stringBuffer.append("==");
                break;
            }
            int i5 = i3 + 1;
            int i6 = bArr[i3] & 255;
            if (i5 == length) {
                stringBuffer.append(e[i4 >>> 2]);
                stringBuffer.append(e[((i4 & 3) << 4) | ((i6 & 240) >>> 4)]);
                stringBuffer.append(e[(i6 & 15) << 2]);
                stringBuffer.append("=");
                break;
            }
            int i7 = bArr[i5] & 255;
            stringBuffer.append(e[i4 >>> 2]);
            stringBuffer.append(e[((i4 & 3) << 4) | ((i6 & 240) >>> 4)]);
            stringBuffer.append(e[((i6 & 15) << 2) | ((i7 & 192) >>> 6)]);
            stringBuffer.append(e[i7 & 63]);
            i = i5 + 1;
        }
        return stringBuffer.toString();
    }

    public static String b(String str) {
        char[] charArray;
        try {
            if (TextUtils.isEmpty(str) || (charArray = a(str.getBytes()).toCharArray()) == null || charArray.length <= 0) {
                return "";
            }
            char[] cArr = new char[charArray.length];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= charArray.length) {
                    return new String(cArr);
                }
                char c2 = charArray[i2];
                if (f26853c == null) {
                    f26853c = new HashMap();
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= f26852a.length()) {
                            break;
                        }
                        f26853c.put(Character.valueOf(f26852a.charAt(i4)), Character.valueOf(g.charAt(i4)));
                        i3 = i4 + 1;
                    }
                }
                cArr[i2] = (f26853c.containsKey(Character.valueOf(c2)) ? f26853c.get(Character.valueOf(c2)) : Character.valueOf(c2)).charValue();
                i = i2 + 1;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static void c(String str) {
        int i;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("k");
            String optString2 = jSONObject.optString("v");
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                return;
            }
            f26852a = optString;
            g = optString2;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= f26852a.length()) {
                    break;
                }
                d.put(Character.valueOf(g.charAt(i3)), Character.valueOf(f26852a.charAt(i3)));
                i2 = i3 + 1;
            }
            for (i = 0; i < f26852a.length(); i++) {
                f26853c.put(Character.valueOf(f26852a.charAt(i)), Character.valueOf(g.charAt(i)));
            }
        } catch (Throwable th) {
        }
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
        r0 = com.tramini.plugin.a.g.c.f[r0];
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
        throw new UnsupportedOperationException("Method not decompiled: com.tramini.plugin.a.g.c.d(java.lang.String):byte[]");
    }
}
