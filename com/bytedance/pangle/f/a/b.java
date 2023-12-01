package com.bytedance.pangle.f.a;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/f/a/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    InputStream f21399a;
    private int b;

    public b(InputStream inputStream) {
        a(inputStream);
    }

    public final int a() {
        int i = 0;
        for (int i2 = 0; i2 != 32; i2 += 8) {
            int read = this.f21399a.read();
            if (read == -1) {
                throw new EOFException();
            }
            this.b++;
            i |= read << i2;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(InputStream inputStream) {
        this.f21399a = inputStream;
        this.b = 0;
    }

    public final int[] a(int i) {
        int[] iArr = new int[i];
        int i2 = i;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i2 <= 0) {
                return iArr;
            }
            iArr[i4] = a();
            i2--;
            i3 = i4 + 1;
        }
    }

    public final void b() {
        long skip = this.f21399a.skip(4L);
        this.b = (int) (this.b + skip);
        if (skip != 4) {
            throw new EOFException();
        }
    }

    public final void b(int i) {
        int a2 = a();
        if (a2 != i) {
            throw new IOException(String.format("Expected: 0x%08x got: 0x%08x", Integer.valueOf(i), Integer.valueOf(a2)));
        }
    }
}
