package com.huawei.hms.ads.uiengineloader;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengineloader/z.class */
public abstract class z {
    public static String a(byte[] bArr) {
        if (bArr == null) {
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
}
