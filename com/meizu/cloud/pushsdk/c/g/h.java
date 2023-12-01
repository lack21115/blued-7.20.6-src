package com.meizu.cloud.pushsdk.c.g;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/c/g/h.class */
public final class h implements c {

    /* renamed from: a  reason: collision with root package name */
    private final b f24068a;
    private final l b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f24069c;

    public h(l lVar) {
        this(lVar, new b());
    }

    public h(l lVar, b bVar) {
        if (lVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        this.f24068a = bVar;
        this.b = lVar;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public long a(m mVar) throws IOException {
        if (mVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long b = mVar.b(this.f24068a, 2048L);
            if (b == -1) {
                return j;
            }
            j += b;
            a();
        }
    }

    public c a() throws IOException {
        if (this.f24069c) {
            throw new IllegalStateException("closed");
        }
        long e = this.f24068a.e();
        if (e > 0) {
            this.b.a(this.f24068a, e);
        }
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.l
    public void a(b bVar, long j) throws IOException {
        if (this.f24069c) {
            throw new IllegalStateException("closed");
        }
        this.f24068a.a(bVar, j);
        a();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public b b() {
        return this.f24068a;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public c b(e eVar) throws IOException {
        if (this.f24069c) {
            throw new IllegalStateException("closed");
        }
        this.f24068a.b(eVar);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public c b(String str) throws IOException {
        if (this.f24069c) {
            throw new IllegalStateException("closed");
        }
        this.f24068a.b(str);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public c c(byte[] bArr) throws IOException {
        if (this.f24069c) {
            throw new IllegalStateException("closed");
        }
        this.f24068a.c(bArr);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public c c(byte[] bArr, int i, int i2) throws IOException {
        if (this.f24069c) {
            throw new IllegalStateException("closed");
        }
        this.f24068a.c(bArr, i, i2);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.l, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Throwable th;
        if (this.f24069c) {
            return;
        }
        Throwable th2 = null;
        try {
            if (this.f24068a.b > 0) {
                this.b.a(this.f24068a, this.f24068a.b);
                th2 = null;
            }
        } catch (Throwable th3) {
            th2 = th3;
        }
        try {
            this.b.close();
            th = th2;
        } catch (Throwable th4) {
            th = th2;
            if (th2 == null) {
                th = th4;
            }
        }
        this.f24069c = true;
        if (th != null) {
            o.a(th);
        }
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public c e(long j) throws IOException {
        if (this.f24069c) {
            throw new IllegalStateException("closed");
        }
        this.f24068a.e(j);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.l, java.io.Flushable
    public void flush() throws IOException {
        if (this.f24069c) {
            throw new IllegalStateException("closed");
        }
        if (this.f24068a.b > 0) {
            l lVar = this.b;
            b bVar = this.f24068a;
            lVar.a(bVar, bVar.b);
        }
        this.b.flush();
    }

    public String toString() {
        return "buffer(" + this.b + ")";
    }
}
