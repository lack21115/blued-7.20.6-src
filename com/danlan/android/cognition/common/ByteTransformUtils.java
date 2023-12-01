package com.danlan.android.cognition.common;

import com.danlan.android.cognition.StringFog;

/* loaded from: source-7206380-dex2jar.jar:com/danlan/android/cognition/common/ByteTransformUtils.class */
public class ByteTransformUtils {
    public static String byte2HexStr(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        while (i < i2) {
            String hexString = Integer.toHexString(bArr[i] & 255);
            if (hexString.length() == 1) {
                stringBuffer.append(StringFog.decrypt("EQ=="));
            }
            stringBuffer.append(hexString);
            i++;
        }
        return stringBuffer.toString().toUpperCase();
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

    private static byte uniteBytes(String str, String str2) {
        byte byteValue = (byte) (Byte.decode(StringFog.decrypt("EVs=") + str).byteValue() << 4);
        return (byte) (byteValue | Byte.decode(StringFog.decrypt("EVs=") + str2).byteValue());
    }
}
