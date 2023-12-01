package com.meizu.cloud.pushsdk.c.g;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/c/g/i.class */
public final class i implements d {

    /* renamed from: a  reason: collision with root package name */
    private final b f24070a;
    private final m b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f24071c;

    public i(m mVar) {
        this(mVar, new b());
    }

    public i(m mVar, b bVar) {
        if (mVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.f24070a = bVar;
        this.b = mVar;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.m
    public long b(b bVar, long j) throws IOException {
        if (bVar != null) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.f24071c) {
                throw new IllegalStateException("closed");
            } else {
                if (this.f24070a.b == 0 && this.b.b(this.f24070a, 2048L) == -1) {
                    return -1L;
                }
                return this.f24070a.b(bVar, Math.min(j, this.f24070a.b));
            }
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // com.meizu.cloud.pushsdk.c.g.m, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f24071c) {
            return;
        }
        this.f24071c = true;
        this.b.close();
        this.f24070a.j();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.d
    public InputStream d() {
        return new InputStream() { // from class: com.meizu.cloud.pushsdk.c.g.i.1
            @Override // java.io.InputStream
            public int available() throws IOException {
                if (i.this.f24071c) {
                    throw new IOException("closed");
                }
                return (int) Math.min(i.this.f24070a.b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                i.this.close();
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                if (i.this.f24071c) {
                    throw new IOException("closed");
                }
                if (i.this.f24070a.b == 0 && i.this.b.b(i.this.f24070a, 2048L) == -1) {
                    return -1;
                }
                return i.this.f24070a.f() & 255;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                if (i.this.f24071c) {
                    throw new IOException("closed");
                }
                o.a(bArr.length, i, i2);
                if (i.this.f24070a.b == 0 && i.this.b.b(i.this.f24070a, 2048L) == -1) {
                    return -1;
                }
                return i.this.f24070a.a(bArr, i, i2);
            }

            public String toString() {
                return i.this + ".inputStream()";
            }
        };
    }

    @Override // com.meizu.cloud.pushsdk.c.g.d
    public String h() throws IOException {
        this.f24070a.a(this.b);
        return this.f24070a.h();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.d
    public byte[] i() throws IOException {
        this.f24070a.a(this.b);
        return this.f24070a.i();
    }

    public String toString() {
        return "buffer(" + this.b + ")";
    }
}
