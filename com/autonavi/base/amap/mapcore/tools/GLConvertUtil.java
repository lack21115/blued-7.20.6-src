package com.autonavi.base.amap.mapcore.tools;

import java.io.ByteArrayOutputStream;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/base/amap/mapcore/tools/GLConvertUtil.class */
public class GLConvertUtil {
    public static double convertDouble(byte[] bArr, int i) {
        long j = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 8) {
                return Double.longBitsToDouble(j);
            }
            j += (bArr[i3 + i] & 255) << (i3 * 8);
            i2 = i3 + 1;
        }
    }

    public static byte[] convertInt(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)};
    }

    public static byte[] convertShort(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255)};
    }

    public static byte[] get1BString(String str) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes = str.getBytes("UTF-8");
            byteArrayOutputStream.write(new byte[]{(byte) bytes.length});
            byteArrayOutputStream.write(bytes);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return new byte[1];
        }
    }

    public static int getInt(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) + ((bArr[i + 2] & 255) << 16) + ((bArr[i + 1] & 255) << 8) + ((bArr[i + 0] & 255) << 0);
    }

    public static int getInt2(byte[] bArr, int i) {
        return ((bArr[i + 0] & 255) << 24) + ((bArr[i + 1] & 255) << 16) + ((bArr[i + 2] & 255) << 8) + ((bArr[i + 3] & 255) << 0);
    }

    public static long getLong(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 56) + ((bArr[i + 6] & 255) << 48) + ((bArr[i + 5] & 255) << 40) + ((bArr[i + 4] & 255) << 32) + ((bArr[i + 3] & 255) << 24) + ((bArr[i + 2] & 255) << 16) + ((bArr[i + 1] & 255) << 8) + ((bArr[i + 0] & 255) << 0);
    }

    public static short getShort(byte[] bArr, int i) {
        return (short) (((bArr[i + 1] & 255) << 8) + ((bArr[i + 0] & 255) << 0));
    }

    public static short getShort2(byte[] bArr, int i) {
        return (short) (((bArr[i + 0] & 255) << 8) + ((bArr[i + 1] & 255) << 0));
    }

    public static String getString(byte[] bArr, int i, int i2) {
        try {
            return new String(bArr, i, i2, "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }

    public static byte[] getSubBytes(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy((Object) bArr, i, (Object) bArr2, 0, i2);
        return bArr2;
    }

    public static int getUShort(byte[] bArr, int i) {
        return ((bArr[i + 1] & 255) << 8) + ((bArr[i + 0] & 255) << 0);
    }

    public static void moveArray(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        byte[] bArr3 = new byte[i3];
        System.arraycopy((Object) bArr, i, (Object) bArr3, 0, i3);
        System.arraycopy((Object) bArr3, 0, (Object) bArr2, i2, i3);
    }

    public static void writeInt(byte[] bArr, int i, int i2) {
        System.arraycopy((Object) convertInt(i2), 0, (Object) bArr, i, 4);
    }

    public static void writeShort(byte[] bArr, int i, short s) {
        System.arraycopy((Object) convertShort(s), 0, (Object) bArr, i, 2);
    }
}
