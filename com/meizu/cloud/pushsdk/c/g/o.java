package com.meizu.cloud.pushsdk.c.g;

import java.nio.charset.Charset;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/c/g/o.class */
final class o {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f10467a = Charset.forName("UTF-8");

    public static void a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)));
        }
    }

    public static void a(Throwable th) {
        b(th);
    }

    public static boolean a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= i3) {
                return true;
            }
            if (bArr[i5 + i] != bArr2[i5 + i2]) {
                return false;
            }
            i4 = i5 + 1;
        }
    }

    private static <T extends Throwable> void b(Throwable th) throws Throwable {
        throw th;
    }
}
