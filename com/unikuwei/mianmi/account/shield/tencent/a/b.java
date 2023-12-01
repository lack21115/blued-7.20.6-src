package com.unikuwei.mianmi.account.shield.tencent.a;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.ByteArrayOutputStream;

/* loaded from: source-8829756-dex2jar.jar:com/unikuwei/mianmi/account/shield/tencent/a/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static char[] f40982a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static byte[] b = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    public static String a(String str) {
        return str.replace("+", "%2B").replace("=", "%3D").replace(BridgeUtil.SPLIT_MARK, "%2F").replace(" ", "%20");
    }

    public static String a(byte[] bArr) {
        String str;
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
                stringBuffer.append(f40982a[i4 >>> 2]);
                stringBuffer.append(f40982a[(i4 & 3) << 4]);
                str = "==";
                break;
            }
            int i5 = i3 + 1;
            int i6 = bArr[i3] & 255;
            if (i5 == length) {
                stringBuffer.append(f40982a[i4 >>> 2]);
                stringBuffer.append(f40982a[((i4 & 3) << 4) | ((i6 & 240) >>> 4)]);
                stringBuffer.append(f40982a[(i6 & 15) << 2]);
                str = "=";
                break;
            }
            int i7 = bArr[i5] & 255;
            stringBuffer.append(f40982a[i4 >>> 2]);
            stringBuffer.append(f40982a[((i4 & 3) << 4) | ((i6 & 240) >>> 4)]);
            stringBuffer.append(f40982a[((i6 & 15) << 2) | ((i7 & 192) >>> 6)]);
            stringBuffer.append(f40982a[i7 & 63]);
            i = i5 + 1;
        }
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    public static byte[] b(String str) {
        byte b2;
        byte b3;
        byte b4;
        byte b5;
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        int i = 0;
        while (i < length) {
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
                    return byteArrayOutputStream.toByteArray();
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
                    return byteArrayOutputStream.toByteArray();
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
        return byteArrayOutputStream.toByteArray();
    }
}
