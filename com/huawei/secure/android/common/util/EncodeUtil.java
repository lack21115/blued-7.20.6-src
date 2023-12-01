package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/util/EncodeUtil.class */
public class EncodeUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23137a = "EncodeUtil";
    private static final char[] b = {',', '.', '-'};

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f23138c = new String[256];

    static {
        char c2 = 0;
        while (true) {
            char c3 = c2;
            if (c3 >= 255) {
                return;
            }
            if ((c3 < '0' || c3 > '9') && ((c3 < 'A' || c3 > 'Z') && (c3 < 'a' || c3 > 'z'))) {
                f23138c[c3] = b(c3).intern();
            } else {
                f23138c[c3] = null;
            }
            c2 = (char) (c3 + 1);
        }
    }

    private static Character a(a aVar) {
        aVar.c();
        Character d = aVar.d();
        if (d == null) {
            aVar.i();
            return null;
        } else if (d.charValue() != '\\') {
            aVar.i();
            return null;
        } else {
            Character d2 = aVar.d();
            if (d2 == null) {
                aVar.i();
                return null;
            } else if (d2.charValue() == 'b') {
                return '\b';
            } else {
                if (d2.charValue() == 't') {
                    return '\t';
                }
                if (d2.charValue() == 'n') {
                    return '\n';
                }
                if (d2.charValue() == 'v') {
                    return (char) 11;
                }
                if (d2.charValue() == 'f') {
                    return '\f';
                }
                if (d2.charValue() == 'r') {
                    return '\r';
                }
                if (d2.charValue() == '\"') {
                    return '\"';
                }
                if (d2.charValue() == '\'') {
                    return '\'';
                }
                if (d2.charValue() == '\\') {
                    return '\\';
                }
                if (Character.toLowerCase(d2.charValue()) == 'x') {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < 2; i++) {
                        Character e = aVar.e();
                        if (e == null) {
                            aVar.i();
                            return null;
                        }
                        sb.append(e);
                    }
                    try {
                        int parseInt = Integer.parseInt(sb.toString(), 16);
                        if (Character.isValidCodePoint(parseInt)) {
                            return Character.valueOf((char) parseInt);
                        }
                    } catch (NumberFormatException e2) {
                        aVar.i();
                        return null;
                    }
                } else if (Character.toLowerCase(d2.charValue()) == 'u') {
                    StringBuilder sb2 = new StringBuilder();
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < 4) {
                            Character e3 = aVar.e();
                            if (e3 == null) {
                                aVar.i();
                                return null;
                            }
                            sb2.append(e3);
                            i2 = i3 + 1;
                        } else {
                            try {
                                int parseInt2 = Integer.parseInt(sb2.toString(), 16);
                                if (Character.isValidCodePoint(parseInt2)) {
                                    return Character.valueOf((char) parseInt2);
                                }
                            } catch (NumberFormatException e4) {
                                aVar.i();
                                return null;
                            }
                        }
                    }
                } else if (a.c(d2)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(d2);
                    Character d3 = aVar.d();
                    if (a.c(d3)) {
                        sb3.append(d3);
                        Character d4 = aVar.d();
                        if (a.c(d4)) {
                            sb3.append(d4);
                        } else {
                            aVar.a(d4);
                        }
                    } else {
                        aVar.a(d3);
                    }
                    try {
                        int parseInt3 = Integer.parseInt(sb3.toString(), 8);
                        if (Character.isValidCodePoint(parseInt3)) {
                            return Character.valueOf((char) parseInt3);
                        }
                    } catch (NumberFormatException e5) {
                        aVar.i();
                        return null;
                    }
                }
                return d2;
            }
        }
    }

    private static String a(char c2) {
        return c2 < 255 ? f23138c[c2] : b(c2);
    }

    private static String a(char[] cArr, Character ch) {
        if (a(ch.charValue(), cArr)) {
            return "" + ch;
        } else if (a(ch.charValue()) == null) {
            return "" + ch;
        } else {
            String hexString = Integer.toHexString(ch.charValue());
            if (ch.charValue() < 256) {
                return "\\x" + "00".substring(hexString.length()) + hexString.toUpperCase(Locale.ENGLISH);
            }
            return "\\u" + "0000".substring(hexString.length()) + hexString.toUpperCase(Locale.ENGLISH);
        }
    }

    private static String a(char[] cArr, String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= str.length()) {
                return sb.toString();
            }
            sb.append(a(cArr, Character.valueOf(str.charAt(i2))));
            i = i2 + 1;
        }
    }

    private static boolean a(char c2, char[] cArr) {
        int length = cArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (c2 == cArr[i2]) {
                return true;
            }
            i = i2 + 1;
        }
    }

    private static String b(char c2) {
        return Integer.toHexString(c2);
    }

    public static String decodeForJavaScript(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            a aVar = new a(str);
            while (aVar.a()) {
                Character a2 = a(aVar);
                if (a2 != null) {
                    sb.append(a2);
                } else {
                    sb.append(aVar.d());
                }
            }
            return sb.toString();
        } catch (Exception e) {
            String str2 = f23137a;
            Log.e(str2, "decode js: " + e.getMessage());
            return "";
        }
    }

    public static String encodeForJavaScript(String str) {
        return encodeForJavaScript(str, b);
    }

    public static String encodeForJavaScript(String str, char[] cArr) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return a(cArr, str);
        } catch (Exception e) {
            String str2 = f23137a;
            Log.e(str2, "encode js: " + e.getMessage());
            return "";
        }
    }
}
