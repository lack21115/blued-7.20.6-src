package com.kwai.sodler.lib.d;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/sodler/lib/d/b.class */
public final class b {
    private static String e(byte[] bArr) {
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

    public static String getMD5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return e(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            return String.valueOf(str.hashCode());
        }
    }
}
