package com.autonavi.base.amap.mapcore;

import java.io.ByteArrayOutputStream;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/base/amap/mapcore/Convert.class */
public class Convert {
    public static final String bytesToHexString(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return stringBuffer.toString();
            }
            String hexString = Integer.toHexString(bArr[i2] & 255);
            if (hexString.length() < 2) {
                stringBuffer.append(0);
            }
            stringBuffer.append(hexString.toUpperCase());
            i = i2 + 1;
        }
    }

    public static void convert1bString(byte[] bArr, int i, ConvertString convertString) {
        try {
            convertString.byteLength = bArr[i];
            convertString.value = new String(bArr, i + 1, convertString.byteLength, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            convertString.byteLength = 0;
            convertString.value = "";
        }
    }

    public static void convert2bString(byte[] bArr, int i, ConvertString convertString) {
        try {
            convertString.byteLength = getShort(bArr, i);
            convertString.value = new String(bArr, i + 2, convertString.byteLength, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            convertString.byteLength = 0;
            convertString.value = "";
        }
    }

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

    public static byte[] copyString(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy((Object) bArr, i, (Object) bArr2, 0, i2);
        return bArr2;
    }

    public static byte[] covertBytes(byte b) {
        return new byte[]{b};
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

    public static byte[] get2BString(String str) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes = str.getBytes("UTF-8");
            byteArrayOutputStream.write(convertShort(bytes.length));
            byteArrayOutputStream.write(bytes);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return new byte[1];
        }
    }

    public static boolean getBit(byte b, int i) {
        int i2 = 32 - i;
        return (((b << i2) >>> i2) >>> (i - 1)) > 0;
    }

    public static byte[] getDouble(double d) {
        byte[] bArr = new byte[8];
        String hexString = Long.toHexString(Double.doubleToLongBits(d));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 8) {
                return bArr;
            }
            int i3 = i2 * 2;
            bArr[7 - i2] = (byte) Integer.parseInt(hexString.substring(i3, i3 + 2), 16);
            i = i2 + 1;
        }
    }

    public static int getInt(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) + ((bArr[i + 2] & 255) << 16) + ((bArr[i + 1] & 255) << 8) + ((bArr[i + 0] & 255) << 0);
    }

    public static int getNum(byte b, int i, int i2) {
        int i3 = (32 - i2) - 1;
        return ((b << i3) >>> i3) >>> i;
    }

    public static int getNum(short s, int i, int i2) {
        int i3 = 32 - i2;
        return ((s << i3) >>> i3) >>> (i - 1);
    }

    public static short getShort(byte[] bArr, int i) {
        return (short) (((bArr[i + 1] & 255) << 8) + ((bArr[i + 0] & 255) << 0));
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
