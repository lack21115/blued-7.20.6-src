package c.t.m.g;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/l2.class */
public class l2 {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f3872a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

    public static int a(char c2) {
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
                stringBuffer.append(f3872a[(i4 >> 18) & 63]);
                stringBuffer.append(f3872a[(i4 >> 12) & 63]);
                stringBuffer.append(f3872a[(i4 >> 6) & 63]);
                stringBuffer.append(f3872a[i4 & 63]);
                i += 3;
                if (i3 >= 14) {
                    break;
                }
                i2 = i3 + 1;
            }
        }
        int i5 = 0 + length;
        if (i == i5 - 2) {
            int i6 = ((bArr[i + 1] & 255) << 8) | ((bArr[i] & 255) << 16);
            stringBuffer.append(f3872a[(i6 >> 18) & 63]);
            stringBuffer.append(f3872a[(i6 >> 12) & 63]);
            stringBuffer.append(f3872a[(i6 >> 6) & 63]);
            stringBuffer.append("=");
        } else if (i == i5 - 1) {
            int i7 = (bArr[i] & 255) << 16;
            stringBuffer.append(f3872a[(i7 >> 18) & 63]);
            stringBuffer.append(f3872a[(i7 >> 12) & 63]);
            stringBuffer.append("==");
        }
        return stringBuffer.toString();
    }

    public static void a(String str, OutputStream outputStream) throws IOException {
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
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            a(str, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                return byteArray;
            } catch (IOException e) {
                PrintStream printStream = System.err;
                printStream.println("Error while decoding BASE64: " + e.toString());
                return byteArray;
            }
        } catch (IOException e2) {
            throw new RuntimeException();
        }
    }
}
