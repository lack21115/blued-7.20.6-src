package com.kwad.sdk.core.diskcache.a;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/diskcache/a/c.class */
public final class c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String bK(String str) {
        if (str == null) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return e(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            return String.valueOf(str.hashCode());
        }
    }

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
}
