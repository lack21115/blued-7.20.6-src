package com.kuaishou.weapon.p0;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/i.class */
public class i {
    private static byte a(byte b, byte b2) {
        char byteValue = (char) (((char) Byte.decode("0x" + new String(new byte[]{b})).byteValue()) << 4);
        return (byte) (byteValue ^ ((char) Byte.decode("0x" + new String(new byte[]{b2})).byteValue()));
    }

    public static String a(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        return new String(c(c(str), str2));
    }

    private static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return stringBuffer.toString();
            }
            stringBuffer.append((char) bArr[i2]);
            i = i2 + 1;
        }
    }

    private static byte[] a(String str) {
        byte[] bytes = str.getBytes();
        byte[] bArr = new byte[256];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 256) {
                break;
            }
            bArr[i2] = (byte) i2;
            i = i2 + 1;
        }
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= 256) {
                return bArr;
            }
            i4 = ((bytes[i3] & 255) + (bArr[i6] & 255) + i4) & 255;
            byte b = bArr[i6];
            bArr[i6] = bArr[i4];
            bArr[i4] = b;
            i3 = (i3 + 1) % bytes.length;
            i5 = i6 + 1;
        }
    }

    public static byte[] a(byte[] bArr, String str) {
        if (bArr == null || str == null) {
            return null;
        }
        return c(bArr, str);
    }

    private static String b(String str) {
        String str2 = "";
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= str.length()) {
                return str2;
            }
            String hexString = Integer.toHexString(str.charAt(i2) & 255);
            String str3 = hexString;
            if (hexString.length() == 1) {
                str3 = "0" + hexString;
            }
            str2 = str2 + str3;
            i = i2 + 1;
        }
    }

    private static byte[] b(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        return c(str.getBytes(), str2);
    }

    public static byte[] b(byte[] bArr, String str) {
        if (bArr == null || str == null) {
            return null;
        }
        return c(bArr, str);
    }

    private static byte[] c(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        byte[] bytes = str.getBytes();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return bArr;
            }
            int i3 = i2 * 2;
            bArr[i2] = a(bytes[i3], bytes[i3 + 1]);
            i = i2 + 1;
        }
    }

    private static byte[] c(byte[] bArr, String str) {
        byte[] a2 = a(str);
        byte[] bArr2 = new byte[bArr.length];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & 255;
            i2 = ((a2[i] & 255) + i2) & 255;
            byte b = a2[i];
            a2[i] = a2[i2];
            a2[i2] = b;
            bArr2[i3] = (byte) (a2[((a2[i] & 255) + (a2[i2] & 255)) & 255] ^ bArr[i3]);
        }
        return bArr2;
    }
}
