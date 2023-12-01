package com.xiaomi.push;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.Random;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/gw.class */
public class gw {

    /* renamed from: a  reason: collision with other field name */
    private static final char[] f529a = "&quot;".toCharArray();
    private static final char[] b = "&apos;".toCharArray();

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f41458c = "&amp;".toCharArray();
    private static final char[] d = "&lt;".toCharArray();
    private static final char[] e = "&gt;".toCharArray();

    /* renamed from: a  reason: collision with root package name */
    private static Random f41457a = new Random();
    private static char[] f = "0123456789abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public static String a(int i) {
        if (i <= 0) {
            return null;
        }
        char[] cArr = new char[i];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return new String(cArr);
            }
            cArr[i3] = f[f41457a.nextInt(71)];
            i2 = i3 + 1;
        }
    }

    public static String a(String str) {
        int i;
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        StringBuilder sb = new StringBuilder((int) (length * 1.3d));
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = i3;
            if (i2 >= length) {
                break;
            }
            char c2 = charArray[i2];
            int i4 = i;
            if (c2 <= '>') {
                if (c2 == '<') {
                    if (i2 > i) {
                        sb.append(charArray, i, i2 - i);
                    }
                    i4 = i2 + 1;
                    sb.append(d);
                } else if (c2 == '>') {
                    if (i2 > i) {
                        sb.append(charArray, i, i2 - i);
                    }
                    i4 = i2 + 1;
                    sb.append(e);
                } else if (c2 == '&') {
                    if (i2 > i) {
                        sb.append(charArray, i, i2 - i);
                    }
                    int i5 = i2 + 5;
                    if (length > i5 && charArray[i2 + 1] == '#' && Character.isDigit(charArray[i2 + 2]) && Character.isDigit(charArray[i2 + 3]) && Character.isDigit(charArray[i2 + 4])) {
                        i4 = i;
                        if (charArray[i5] == ';') {
                        }
                    }
                    i4 = i2 + 1;
                    sb.append(f41458c);
                } else if (c2 == '\"') {
                    if (i2 > i) {
                        sb.append(charArray, i, i2 - i);
                    }
                    i4 = i2 + 1;
                    sb.append(f529a);
                } else {
                    i4 = i;
                    if (c2 == '\'') {
                        if (i2 > i) {
                            sb.append(charArray, i, i2 - i);
                        }
                        i4 = i2 + 1;
                        sb.append(b);
                    }
                }
            }
            i2++;
            i3 = i4;
        }
        if (i == 0) {
            return str;
        }
        if (i2 > i) {
            sb.append(charArray, i, i2 - i);
        }
        return sb.toString();
    }

    public static final String a(String str, String str2, String str3) {
        int i;
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(str2, 0);
        String str4 = str;
        if (indexOf >= 0) {
            char[] charArray = str.toCharArray();
            char[] charArray2 = str3.toCharArray();
            int length = str2.length();
            StringBuilder sb = new StringBuilder(charArray.length);
            sb.append(charArray, 0, indexOf);
            sb.append(charArray2);
            int i2 = indexOf;
            while (true) {
                i = i2 + length;
                int indexOf2 = str.indexOf(str2, i);
                if (indexOf2 <= 0) {
                    break;
                }
                sb.append(charArray, i, indexOf2 - i);
                sb.append(charArray2);
                i2 = indexOf2;
            }
            sb.append(charArray, i, charArray.length - i);
            str4 = sb.toString();
        }
        return str4;
    }

    public static String a(byte[] bArr) {
        return String.valueOf(bk.a(bArr));
    }

    public static final String b(String str) {
        return a(a(a(a(a(str, "&lt;", SimpleComparison.LESS_THAN_OPERATION), "&gt;", SimpleComparison.GREATER_THAN_OPERATION), "&quot;", "\""), "&apos;", "'"), "&amp;", "&");
    }
}
