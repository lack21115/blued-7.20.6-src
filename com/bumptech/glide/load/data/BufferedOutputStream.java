package com.bumptech.glide.load.data;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/data/BufferedOutputStream.class */
public final class BufferedOutputStream extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    private final OutputStream f7107a;
    private byte[] b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayPool f7108c;
    private int d;

    public BufferedOutputStream(OutputStream outputStream, ArrayPool arrayPool) {
        this(outputStream, arrayPool, 65536);
    }

    BufferedOutputStream(OutputStream outputStream, ArrayPool arrayPool, int i) {
        this.f7107a = outputStream;
        this.f7108c = arrayPool;
        this.b = (byte[]) arrayPool.a(i, byte[].class);
    }

    private void a() throws IOException {
        int i = this.d;
        if (i > 0) {
            this.f7107a.write(this.b, 0, i);
            this.d = 0;
        }
    }

    private void b() throws IOException {
        if (this.d == this.b.length) {
            a();
        }
    }

    private void c() {
        byte[] bArr = this.b;
        if (bArr != null) {
            this.f7108c.a((ArrayPool) bArr);
            this.b = null;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
            this.f7107a.close();
            c();
        } catch (Throwable th) {
            this.f7107a.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        a();
        this.f7107a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.b;
        int i2 = this.d;
        this.d = i2 + 1;
        bArr[i2] = (byte) i;
        b();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        int i4 = 0;
        do {
            int i5 = i2 - i4;
            int i6 = i + i4;
            if (this.d == 0 && i5 >= this.b.length) {
                this.f7107a.write(bArr, i6, i5);
                return;
            }
            int min = Math.min(i5, this.b.length - this.d);
            System.arraycopy(bArr, i6, this.b, this.d, min);
            this.d += min;
            i3 = i4 + min;
            b();
            i4 = i3;
        } while (i3 < i2);
    }
}
