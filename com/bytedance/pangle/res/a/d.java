package com.bytedance.pangle.res.a;

import java.io.EOFException;
import java.io.InputStream;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/res/a/d.class */
public final class d {
    private static <T> T a(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    public static void a(InputStream inputStream, byte[] bArr, int i, int i2) {
        int read;
        a(inputStream);
        a(bArr);
        int i3 = 0;
        if (i2 < 0) {
            throw new IndexOutOfBoundsException(String.format("len (%s) cannot be negative", Integer.valueOf(i2)));
        }
        int i4 = i + i2;
        int length = bArr.length;
        if (i < 0 || i4 < i || i4 > length) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append(i4);
            sb.append(length);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        while (i3 < i2 && (read = inputStream.read(bArr, i + i3, i2 - i3)) != -1) {
            i3 += read;
        }
        if (i3 == i2) {
            return;
        }
        throw new EOFException("reached end of stream after reading " + i3 + " bytes; " + i2 + " bytes expected");
    }
}
