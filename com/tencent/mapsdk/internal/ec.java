package com.tencent.mapsdk.internal;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ec.class */
public class ec implements hc {
    private static long a(int i, InputStream inputStream) throws IOException {
        long j = 0;
        for (int i2 = i - 1; i2 >= 0; i2--) {
            j |= (b(inputStream) & 255) << (i2 * 8);
        }
        return j;
    }

    public static boolean a(InputStream inputStream) throws IOException {
        return b(inputStream) != 0;
    }

    public static byte[] a(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return bArr;
            }
            i2 = i3 + inputStream.read(bArr, i3, i - i3);
        }
    }

    public static byte b(InputStream inputStream) throws IOException {
        return (byte) inputStream.read();
    }

    public static char c(InputStream inputStream) throws IOException {
        long j = 0;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 2) {
                return (char) j;
            }
            j |= (b(inputStream) & 255) << (i2 * 8);
            i = i2 + 1;
        }
    }

    public static int d(InputStream inputStream) throws IOException {
        return (int) a(4, inputStream);
    }

    public static long e(InputStream inputStream) throws IOException {
        return a(8, inputStream);
    }

    public static int f(InputStream inputStream) throws IOException {
        return (int) a(2, inputStream);
    }

    public static String g(InputStream inputStream) throws IOException {
        return new String(a(inputStream, f(inputStream)));
    }
}
