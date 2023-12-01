package com.alibaba.mtl.log.e;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/e/j.class */
public class j {
    public static char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return sb.toString();
            }
            sb.append(a[(bArr[i2] & 240) >>> 4]);
            sb.append(a[bArr[i2] & 15]);
            i = i2 + 1;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m8629a(byte[] bArr) {
        if (bArr != null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(com.anythink.core.common.k.f.a);
                messageDigest.update(bArr);
                return messageDigest.digest();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static String b(byte[] bArr) {
        byte[] m8629a = m8629a(bArr);
        return m8629a != null ? a(m8629a) : "0000000000000000";
    }
}
