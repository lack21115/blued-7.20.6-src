package com.tencent.tendinsv.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/utils/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f25403a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

    private static int a(char c2) {
        int i;
        if (c2 < 'A' || c2 > 'Z') {
            if (c2 >= 'a' && c2 <= 'z') {
                i = c2 - 'a';
            } else if (c2 < '0' || c2 > '9') {
                if (c2 != '+') {
                    if (c2 != '/') {
                        if (c2 == '=') {
                            return 0;
                        }
                        throw new RuntimeException("unexpected code: " + c2);
                    }
                    return 63;
                }
                return 62;
            } else {
                i = (c2 - '0') + 26;
            }
            return i + 26;
        }
        return c2 - 'A';
    }

    public static String a(byte[] bArr) {
        String str;
        int length = bArr.length;
        StringBuffer stringBuffer = new StringBuffer((bArr.length * 3) / 2);
        int i = 0;
        loop0: while (true) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i > length - 3) {
                    break loop0;
                }
                int i4 = ((bArr[i] & 255) << 16) | ((bArr[i + 1] & 255) << 8) | (bArr[i + 2] & 255);
                stringBuffer.append(f25403a[(i4 >> 18) & 63]);
                stringBuffer.append(f25403a[(i4 >> 12) & 63]);
                stringBuffer.append(f25403a[(i4 >> 6) & 63]);
                stringBuffer.append(f25403a[i4 & 63]);
                i += 3;
                if (i3 >= 14) {
                    break;
                }
                i2 = i3 + 1;
            }
            stringBuffer.append(" ");
        }
        int i5 = 0 + length;
        if (i != i5 - 2) {
            if (i == i5 - 1) {
                int i6 = (bArr[i] & 255) << 16;
                stringBuffer.append(f25403a[(i6 >> 18) & 63]);
                stringBuffer.append(f25403a[(i6 >> 12) & 63]);
                str = "==";
            }
            return stringBuffer.toString();
        }
        int i7 = ((bArr[i + 1] & 255) << 8) | ((bArr[i] & 255) << 16);
        stringBuffer.append(f25403a[(i7 >> 18) & 63]);
        stringBuffer.append(f25403a[(i7 >> 12) & 63]);
        stringBuffer.append(f25403a[(i7 >> 6) & 63]);
        str = "=";
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    private static void a(String str, OutputStream outputStream) {
        int length = str.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < length && str.charAt(i2) <= ' ') {
                i = i2 + 1;
            } else if (i2 == length) {
                return;
            } else {
                int a2 = a(str.charAt(i2));
                int a3 = a(str.charAt(i2 + 1));
                int i3 = i2 + 2;
                int a4 = a(str.charAt(i3));
                int i4 = i2 + 3;
                int a5 = (a2 << 18) + (a3 << 12) + (a4 << 6) + a(str.charAt(i4));
                outputStream.write((a5 >> 16) & 255);
                if (str.charAt(i3) == '=') {
                    return;
                }
                outputStream.write((a5 >> 8) & 255);
                if (str.charAt(i4) == '=') {
                    return;
                }
                outputStream.write(a5 & 255);
                i = i2 + 4;
            }
        }
    }

    public static byte[] a(String str) {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    a(str, byteArrayOutputStream2);
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    try {
                        byteArrayOutputStream2.close();
                        return byteArray;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return byteArray;
                    }
                } catch (IOException e2) {
                    throw new RuntimeException();
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e4) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
