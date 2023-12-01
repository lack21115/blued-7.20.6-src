package com.bytedance.pangle.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/util/f.class */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static String f21502a = "DES/ECB/NoPadding";
    public static String b = "DESede/ECB/NoPadding";

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f21503c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(String str) {
        return b(a(str.getBytes(), "MD5"));
    }

    public static String a(byte[] bArr) {
        return b(a(bArr, "MD5"));
    }

    private static byte[] a(byte[] bArr, String str) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String b(byte[] bArr) {
        int length;
        if (bArr != null && (length = bArr.length) > 0) {
            char[] cArr = new char[length << 1];
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i + 1;
                char[] cArr2 = f21503c;
                cArr[i] = cArr2[(bArr[i2] >>> 4) & 15];
                i = i3 + 1;
                cArr[i3] = cArr2[bArr[i2] & 15];
            }
            return new String(cArr);
        }
        return null;
    }
}
