package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/util/HexUtil.class */
public final class HexUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23140a = "";
    private static final String b = "HexUtil";

    private HexUtil() {
    }

    public static String byteArray2HexStr(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return byteArray2HexStr(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            Log.e(b, "byte array 2 hex string UnsupportedEncodingException : " + e.getMessage());
            return "";
        } catch (Exception e2) {
            Log.e(b, "byte array 2 hex string exception : " + e2.getMessage());
            return "";
        }
    }

    public static String byteArray2HexStr(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return sb.toString();
            }
            String hexString = Integer.toHexString(bArr[i2] & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
            i = i2 + 1;
        }
    }

    public static byte[] hexStr2ByteArray(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        int length = upperCase.length() / 2;
        byte[] bArr = new byte[length];
        try {
            byte[] bytes = upperCase.getBytes("UTF-8");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("0x");
                int i3 = i2 * 2;
                sb.append(new String(new byte[]{bytes[i3]}, "UTF-8"));
                byte byteValue = (byte) (Byte.decode(sb.toString()).byteValue() << 4);
                bArr[i2] = (byte) (byteValue ^ Byte.decode("0x" + new String(new byte[]{bytes[i3 + 1]}, "UTF-8")).byteValue());
                i = i2 + 1;
            }
        } catch (UnsupportedEncodingException e) {
            e = e;
            Log.e(b, "hex string 2 byte UnsupportedEncodingException or NumberFormatException : " + e.getMessage());
            return bArr;
        } catch (NumberFormatException e2) {
            e = e2;
            Log.e(b, "hex string 2 byte UnsupportedEncodingException or NumberFormatException : " + e.getMessage());
            return bArr;
        } catch (Exception e3) {
            Log.e(b, "byte array 2 hex string exception : " + e3.getMessage());
            return bArr;
        }
        return bArr;
    }
}
