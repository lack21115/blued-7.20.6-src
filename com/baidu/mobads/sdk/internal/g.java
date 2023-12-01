package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/g.class */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f9428a = {48, 75, 97, 106, 68, 55, 65, 90, 99, 70, 50, 81, 110, 80, 114, 53, 102, 119, 105, 72, 82, 78, 121, 103, 109, 117, 112, 85, 84, 73, 88, 120, 54, 57, 66, 87, 98, 45, 104, 77, 67, 71, 74, 111, 95, 86, 56, 69, 115, 107, 122, 49, 89, 100, 118, 76, 51, 52, 108, 101, 116, 113, 83, 79};
    private static final byte[] b = new byte[128];

    static {
        int i = 0;
        while (true) {
            int i2 = i;
            byte[] bArr = f9428a;
            if (i2 >= bArr.length) {
                return;
            }
            b[bArr[i2]] = (byte) i2;
            i = i2 + 1;
        }
    }

    private static boolean a(byte b2) {
        if (b2 == 36) {
            return true;
        }
        return b2 >= 0 && b2 < 128 && b[b2] != -1;
    }

    public static String b(String str) {
        if (str == null || str.length() < 4) {
            return null;
        }
        try {
            String str2 = new String(c(str));
            while (str2.endsWith("$")) {
                str2 = str2.substring(0, str2.length() - 1);
            }
            return str2;
        } catch (Exception e) {
            return "";
        }
    }

    private static byte[] c(String str) {
        if (d(str) || str == null || str.length() < 4) {
            return null;
        }
        byte[] bArr = str.charAt(str.length() - 2) == '$' ? new byte[(((str.length() / 4) - 1) * 3) + 1] : str.charAt(str.length() - 1) == '$' ? new byte[(((str.length() / 4) - 1) * 3) + 2] : new byte[(str.length() / 4) * 3];
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= str.length() - 4) {
                break;
            }
            byte b2 = b[str.charAt(i)];
            byte b3 = b[str.charAt(i + 1)];
            byte b4 = b[str.charAt(i + 2)];
            byte b5 = b[str.charAt(i + 3)];
            bArr[i3] = (byte) ((b2 << 2) | (b3 >> 4));
            bArr[i3 + 1] = (byte) ((b3 << 4) | (b4 >> 2));
            bArr[i3 + 2] = (byte) ((b4 << 6) | b5);
            i += 4;
            i2 = i3 + 3;
        }
        if (str.charAt(str.length() - 2) == '$') {
            bArr[bArr.length - 1] = (byte) ((b[str.charAt(str.length() - 3)] >> 4) | (b[str.charAt(str.length() - 4)] << 2));
            return bArr;
        } else if (str.charAt(str.length() - 1) == '$') {
            byte b6 = b[str.charAt(str.length() - 4)];
            byte b7 = b[str.charAt(str.length() - 3)];
            byte b8 = b[str.charAt(str.length() - 2)];
            bArr[bArr.length - 2] = (byte) ((b6 << 2) | (b7 >> 4));
            bArr[bArr.length - 1] = (byte) ((b8 >> 2) | (b7 << 4));
            return bArr;
        } else {
            byte b9 = b[str.charAt(str.length() - 4)];
            byte b10 = b[str.charAt(str.length() - 3)];
            byte b11 = b[str.charAt(str.length() - 2)];
            byte b12 = b[str.charAt(str.length() - 1)];
            bArr[bArr.length - 3] = (byte) ((b9 << 2) | (b10 >> 4));
            bArr[bArr.length - 2] = (byte) ((b10 << 4) | (b11 >> 2));
            bArr[bArr.length - 1] = (byte) (b12 | (b11 << 6));
            return bArr;
        }
    }

    private static boolean d(String str) {
        if (str == null) {
            return true;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= str.length()) {
                return false;
            }
            if (!a((byte) str.charAt(i2))) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int length = str.getBytes().length % 3;
        while (true) {
            int i = length;
            if (i <= 0 || i >= 3) {
                break;
            }
            str = str + "$";
            length = i + 1;
        }
        byte[] bytes = str.getBytes();
        byte[] bArr = new byte[(bytes.length / 3) * 4];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i2 >= bytes.length) {
                return new String(bArr);
            }
            byte[] bArr2 = f9428a;
            bArr[i4] = bArr2[(bytes[i2] & 252) >> 2];
            byte b2 = bytes[i2];
            int i5 = i2 + 1;
            bArr[i4 + 1] = bArr2[((b2 & 3) << 4) + ((bytes[i5] & 240) >> 4)];
            byte b3 = bytes[i5];
            int i6 = i2 + 2;
            bArr[i4 + 2] = bArr2[((b3 & 15) << 2) + ((bytes[i6] & 192) >> 6)];
            bArr[i4 + 3] = bArr2[bytes[i6] & 63];
            i2 += 3;
            i3 = i4 + 4;
        }
    }
}
