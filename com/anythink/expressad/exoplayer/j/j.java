package com.anythink.expressad.exoplayer.j;

import java.io.InputStream;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/j.class */
public final class j extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    private final h f4742a;
    private final k b;
    private long f;
    private boolean d = false;
    private boolean e = false;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f4743c = new byte[1];

    public j(h hVar, k kVar) {
        this.f4742a = hVar;
        this.b = kVar;
    }

    private void c() {
        if (this.d) {
            return;
        }
        this.f4742a.a(this.b);
        this.d = true;
    }

    public final long a() {
        return this.f;
    }

    public final void b() {
        c();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.e) {
            return;
        }
        this.f4742a.b();
        this.e = true;
    }

    @Override // java.io.InputStream
    public final int read() {
        if (read(this.f4743c) == -1) {
            return -1;
        }
        return this.f4743c[0] & 255;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) {
        com.anythink.expressad.exoplayer.k.a.b(!this.e);
        c();
        int a2 = this.f4742a.a(bArr, i, i2);
        if (a2 == -1) {
            return -1;
        }
        this.f += a2;
        return a2;
    }
}
