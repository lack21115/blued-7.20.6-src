package com.blued.android.core.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/PoolingByteArrayOutputStream.class */
public class PoolingByteArrayOutputStream extends ByteArrayOutputStream {

    /* renamed from: a  reason: collision with root package name */
    private final ByteArrayPool f9737a;

    public PoolingByteArrayOutputStream(ByteArrayPool byteArrayPool, int i) {
        this.f9737a = byteArrayPool;
        this.buf = byteArrayPool.a(Math.max(i, 256));
    }

    private void a(int i) {
        if (this.count + i <= this.buf.length) {
            return;
        }
        byte[] a2 = this.f9737a.a((this.count + i) * 2);
        System.arraycopy((Object) this.buf, 0, (Object) a2, 0, this.count);
        this.f9737a.a(this.buf);
        this.buf = a2;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f9737a.a(this.buf);
        this.buf = null;
        super.close();
    }

    public void finalize() {
        this.f9737a.a(this.buf);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public void write(int i) {
        synchronized (this) {
            a(1);
            super.write(i);
        }
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        synchronized (this) {
            a(i2);
            super.write(bArr, i, i2);
        }
    }
}
