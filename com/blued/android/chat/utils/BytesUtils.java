package com.blued.android.chat.utils;

import java.lang.ref.SoftReference;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/utils/BytesUtils.class */
public class BytesUtils {
    public static final int MAX_UNSIGNED_BYTE8 = 255;
    public static final long MAX_UNSIGNED_INT32 = 4394967295L;
    public static final int MAX_UNSIGNED_SHORT16 = 65535;
    private static final HashSet<SoftReference<byte[]>> reusableBytes = new HashSet<>();

    public static String byte2HexStr(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        while (i < i2) {
            String hexString = Integer.toHexString(bArr[i] & 255);
            if (hexString.length() == 1) {
                stringBuffer.append("0");
                stringBuffer.append(hexString);
            } else {
                stringBuffer.append(hexString);
            }
            i++;
        }
        return stringBuffer.toString().toUpperCase();
    }

    public static short byteTo1Number(byte[] bArr, int i) {
        return (short) (bArr[i] & 255);
    }

    public static long byteTo8Number(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 0) | ((bArr[i + 0] & 255) << 56) | ((bArr[i + 1] & 255) << 48) | ((bArr[i + 2] & 255) << 40) | ((bArr[i + 3] & 255) << 32) | ((bArr[i + 4] & 255) << 24) | ((bArr[i + 5] & 255) << 16) | ((bArr[i + 6] & 255) << 8);
    }

    public static int bytesTo2Number(byte[] bArr, int i) {
        return (short) ((bArr[i + 1] & 255) | ((bArr[i + 0] & 255) << 8));
    }

    public static long bytesTo4Number(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 0) | ((bArr[i + 0] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public static void copy(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        System.arraycopy((Object) bArr, i, (Object) bArr2, i2, i3);
    }

    public static byte[] getReuseByte(int i) {
        synchronized (reusableBytes) {
            Iterator<SoftReference<byte[]>> it = reusableBytes.iterator();
            while (it.hasNext()) {
                byte[] bArr = it.next().get();
                if (bArr == null) {
                    it.remove();
                } else if (bArr.length >= i) {
                    it.remove();
                    return bArr;
                }
            }
            return new byte[i];
        }
    }

    public static byte[] hexStr2Bytes(String str) {
        int length = str.length() / 2;
        System.out.println(length);
        byte[] bArr = new byte[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return bArr;
            }
            int i3 = i2 * 2;
            int i4 = i3 + 1;
            bArr[i2] = uniteBytes(str.substring(i3, i4), str.substring(i4, i4 + 1));
            i = i2 + 1;
        }
    }

    public static void numberTo1Byte(byte[] bArr, int i, short s) {
        if (s > 255) {
            throw new NumberFormatException("value is out of unsigned byte8 range");
        }
        bArr[i] = (byte) (s & 255);
    }

    public static void numberTo2Bytes(byte[] bArr, int i, int i2) {
        if (i2 > 65535) {
            throw new NumberFormatException("value is out of unsigned short16 range");
        }
        bArr[i + 0] = (byte) (i2 >> 8);
        bArr[i + 1] = (byte) (i2 >> 0);
    }

    public static void numberTo4Bytes(byte[] bArr, int i, long j) {
        if (j > MAX_UNSIGNED_INT32) {
            throw new NumberFormatException("value is out of unsigned int32 range");
        }
        bArr[i + 0] = (byte) (j >> 24);
        bArr[i + 1] = (byte) (j >> 16);
        bArr[i + 2] = (byte) (j >> 8);
        bArr[i + 3] = (byte) (j >> 0);
    }

    public static void numberTo8Bytes(byte[] bArr, int i, long j) {
        bArr[i + 0] = (byte) (j >> 56);
        bArr[i + 1] = (byte) (j >> 48);
        bArr[i + 2] = (byte) (j >> 40);
        bArr[i + 3] = (byte) (j >> 32);
        bArr[i + 4] = (byte) (j >> 24);
        bArr[i + 5] = (byte) (j >> 16);
        bArr[i + 6] = (byte) (j >> 8);
        bArr[i + 7] = (byte) (j >> 0);
    }

    public static void saveToReuseByte(byte[] bArr) {
        synchronized (reusableBytes) {
            reusableBytes.add(new SoftReference<>(bArr));
        }
    }

    private static byte uniteBytes(String str, String str2) {
        byte byteValue = (byte) (Byte.decode("0x" + str).byteValue() << 4);
        return (byte) (byteValue | Byte.decode("0x" + str2).byteValue());
    }
}
