package com.youzan.androidsdk.tool;

import java.security.MessageDigest;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/tool/Base64.class */
public class Base64 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final char f1065 = (char) Integer.parseInt("00000011", 2);

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final char f1066 = (char) Integer.parseInt("00001111", 2);

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final char f1067 = (char) Integer.parseInt("00111111", 2);

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final char f1068 = (char) Integer.parseInt("11111100", 2);

    /* renamed from: ᐝ  reason: contains not printable characters */
    private static final char f1069 = (char) Integer.parseInt("11110000", 2);

    /* renamed from: ʻ  reason: contains not printable characters */
    private static final char f1063 = (char) Integer.parseInt("11000000", 2);

    /* renamed from: ʼ  reason: contains not printable characters */
    private static final char[] f1064 = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    public static String UTF_8 = "utf-8";

    public static String encode(byte[] bArr) {
        int i;
        char c2;
        int i2;
        StringBuffer stringBuffer = new StringBuffer(((int) (bArr.length * 1.34d)) + 3);
        int i3 = 0;
        char c3 = 0;
        for (int i4 = 0; i4 < bArr.length; i4++) {
            int i5 = i3 % 8;
            while (true) {
                i3 = i5;
                if (i3 < 8) {
                    if (i3 == 0) {
                        i = ((char) (bArr[i4] & f1068)) >>> 2;
                    } else if (i3 == 2) {
                        i = bArr[i4] & f1067;
                    } else if (i3 != 4) {
                        if (i3 == 6) {
                            c2 = (char) (((char) (bArr[i4] & f1065)) << 4);
                            int i6 = i4 + 1;
                            c3 = c2;
                            if (i6 < bArr.length) {
                                i2 = (bArr[i6] & f1069) >>> 4;
                                i = c2 | i2;
                            }
                        }
                        stringBuffer.append(f1064[c3]);
                        i5 = i3 + 6;
                    } else {
                        c2 = (char) (((char) (bArr[i4] & f1066)) << 2);
                        int i7 = i4 + 1;
                        c3 = c2;
                        if (i7 < bArr.length) {
                            i2 = (bArr[i7] & f1063) >>> 6;
                            i = c2 | i2;
                        } else {
                            stringBuffer.append(f1064[c3]);
                            i5 = i3 + 6;
                        }
                    }
                    c3 = (char) i;
                    stringBuffer.append(f1064[c3]);
                    i5 = i3 + 6;
                }
            }
        }
        if (stringBuffer.length() % 4 != 0) {
            int i8 = 4;
            int length = stringBuffer.length() % 4;
            while (true) {
                int i9 = i8 - length;
                if (i9 <= 0) {
                    break;
                }
                stringBuffer.append("=");
                i8 = i9;
                length = 1;
            }
        }
        return stringBuffer.toString();
    }

    public static String md5(String str) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] bytes = str.getBytes(UTF_8);
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[digest.length << 1];
            int i = 0;
            for (byte b : digest) {
                int i2 = i + 1;
                cArr2[i] = cArr[(b >>> 4) & 15];
                i = i2 + 1;
                cArr2[i2] = cArr[b & 15];
            }
            return new String(cArr2);
        } catch (Exception e) {
            return null;
        }
    }
}
