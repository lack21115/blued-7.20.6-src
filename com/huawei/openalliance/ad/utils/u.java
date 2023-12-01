package com.huawei.openalliance.ad.utils;

import android.text.TextUtils;
import com.huawei.hms.ads.ge;
import java.util.Locale;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/u.class */
public abstract class u {
    private static final String Code = "";
    private static final String V = "HexUtil";

    public static String Code(byte[] bArr) {
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

    public static byte[] Code(String str) {
        StringBuilder sb;
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
                StringBuilder sb2 = new StringBuilder();
                sb2.append("0x");
                int i3 = i2 * 2;
                sb2.append(new String(new byte[]{bytes[i3]}, "UTF-8"));
                byte byteValue = (byte) (Byte.decode(sb2.toString()).byteValue() << 4);
                bArr[i2] = (byte) (byteValue ^ Byte.decode("0x" + new String(new byte[]{bytes[i3 + 1]}, "UTF-8")).byteValue());
                i = i2 + 1;
            }
        } catch (NumberFormatException e) {
            e = e;
            sb = new StringBuilder();
            sb.append("hex string 2 byte: ");
            sb.append(e.getClass().getSimpleName());
            ge.Z(V, sb.toString());
            return bArr;
        } catch (Throwable th) {
            e = th;
            sb = new StringBuilder();
            sb.append("hex string 2 byte: ");
            sb.append(e.getClass().getSimpleName());
            ge.Z(V, sb.toString());
            return bArr;
        }
        return bArr;
    }
}
