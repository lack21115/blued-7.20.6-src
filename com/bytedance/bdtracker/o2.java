package com.bytedance.bdtracker;

import java.security.MessageDigest;
import java.util.Objects;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/o2.class */
public class o2 {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f21278a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(byte[] bArr) {
        if (bArr != null) {
            try {
                if (bArr.length == 0) {
                    return null;
                }
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(bArr);
                return b(messageDigest.digest());
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public static String b(byte[] bArr) {
        if (bArr == null) {
            z2.a("[Assert failed] bytes is null", (Throwable) null);
            return null;
        }
        int length = bArr.length;
        if (j1.b(true, "bytes is null")) {
            return null;
        }
        if (length + 0 <= ((byte[]) Objects.requireNonNull(bArr)).length) {
            int i = length * 2;
            char[] cArr = new char[i];
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                int i4 = bArr[i3 + 0] & 255;
                int i5 = i2 + 1;
                char[] cArr2 = f21278a;
                cArr[i2] = cArr2[i4 >> 4];
                i2 = i5 + 1;
                cArr[i5] = cArr2[i4 & 15];
            }
            return new String(cArr, 0, i);
        }
        throw new IndexOutOfBoundsException();
    }
}
