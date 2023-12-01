package com.sdk.tencent.q;

import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/q/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static char[] f28074a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    public static byte[] b = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    public static String a(String str) {
        byte b2;
        byte b3;
        byte b4;
        byte b5;
        byte[] bytes = str.getBytes(Charset.defaultCharset());
        int length = bytes.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        int i = 0;
        loop0: while (i < length) {
            while (true) {
                int i2 = i;
                i = i2 + 1;
                b2 = b[bytes[i2]];
                if (i >= length || b2 != -1) {
                    break;
                }
            }
            int i3 = i;
            if (b2 == -1) {
                break;
            }
            while (true) {
                i = i3 + 1;
                b3 = b[bytes[i3]];
                if (i >= length || b3 != -1) {
                    break;
                }
                i3 = i;
            }
            if (b3 == -1) {
                break;
            }
            byteArrayOutputStream.write((b2 << 2) | ((b3 & 48) >>> 4));
            while (true) {
                int i4 = i;
                i = i4 + 1;
                byte b6 = bytes[i4];
                if (b6 == 61) {
                    break loop0;
                }
                b4 = b[b6];
                if (i >= length || b4 != -1) {
                    break;
                }
            }
            if (b4 == -1) {
                break;
            }
            byteArrayOutputStream.write(((b3 & 15) << 4) | ((b4 & 60) >>> 2));
            while (true) {
                int i5 = i;
                i = i5 + 1;
                byte b7 = bytes[i5];
                if (b7 == 61) {
                    break loop0;
                }
                b5 = b[b7];
                if (i >= length || b5 != -1) {
                    break;
                }
            }
            if (b5 == -1) {
                break;
            }
            byteArrayOutputStream.write(b5 | ((b4 & 3) << 6));
        }
        return new String(byteArrayOutputStream.toByteArray(), Charset.defaultCharset());
    }
}
