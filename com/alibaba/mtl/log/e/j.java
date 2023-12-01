package com.alibaba.mtl.log.e;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/e/j.class */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static char[] f4496a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return sb.toString();
            }
            sb.append(f4496a[(bArr[i2] & 240) >>> 4]);
            sb.append(f4496a[bArr[i2] & 15]);
            i = i2 + 1;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m2186a(byte[] bArr) {
        if (bArr != null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
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
        byte[] m2186a = m2186a(bArr);
        return m2186a != null ? a(m2186a) : "0000000000000000";
    }
}
