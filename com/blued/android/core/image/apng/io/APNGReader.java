package com.blued.android.core.image.apng.io;

import android.text.TextUtils;
import java.io.IOException;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/apng/io/APNGReader.class */
public class APNGReader extends FilterReader {
    private static ThreadLocal<byte[]> b = new ThreadLocal<>();

    public APNGReader(Reader reader) {
        super(reader);
    }

    protected static byte[] a() {
        byte[] bArr = b.get();
        byte[] bArr2 = bArr;
        if (bArr == null) {
            bArr2 = new byte[4];
            b.set(bArr2);
        }
        return bArr2;
    }

    public boolean a(String str) throws IOException {
        if (TextUtils.isEmpty(str) || str.length() != 4) {
            return false;
        }
        int d = d();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 4) {
                return true;
            }
            if (((d >> (i2 * 8)) & 255) != str.charAt(i2)) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public short c() throws IOException {
        byte[] a2 = a();
        read(a2, 0, 2);
        return (short) (((a2[0] & 255) << 8) | (a2[1] & 255));
    }

    public int d() throws IOException {
        byte[] a2 = a();
        read(a2, 0, 4);
        return ((a2[3] & 255) << 24) | (a2[0] & 255) | ((a2[1] & 255) << 8) | ((a2[2] & 255) << 16);
    }

    public int m_() throws IOException {
        byte[] a2 = a();
        read(a2, 0, 4);
        return ((a2[0] & 255) << 24) | (a2[3] & 255) | ((a2[2] & 255) << 8) | ((a2[1] & 255) << 16);
    }
}
