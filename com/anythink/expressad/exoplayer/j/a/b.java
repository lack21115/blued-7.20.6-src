package com.anythink.expressad.exoplayer.j.a;

import com.anythink.expressad.exoplayer.j.a.a;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.k.x;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/a/b.class */
public final class b implements com.anythink.expressad.exoplayer.j.g {

    /* renamed from: a  reason: collision with root package name */
    public static final int f4714a = 20480;
    private final com.anythink.expressad.exoplayer.j.a.a b;

    /* renamed from: c  reason: collision with root package name */
    private final long f4715c;
    private final int d;
    private final boolean e;
    private com.anythink.expressad.exoplayer.j.k f;
    private File g;
    private OutputStream h;
    private FileOutputStream i;
    private long j;
    private long k;
    private x l;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/a/b$a.class */
    public static final class a extends a.C0067a {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public b(com.anythink.expressad.exoplayer.j.a.a aVar) {
        this(aVar, 2097152L, 20480, true);
    }

    private b(com.anythink.expressad.exoplayer.j.a.a aVar, long j, int i) {
        this(aVar, j, i, true);
    }

    private b(com.anythink.expressad.exoplayer.j.a.a aVar, long j, int i, boolean z) {
        this.b = (com.anythink.expressad.exoplayer.j.a.a) com.anythink.expressad.exoplayer.k.a.a(aVar);
        this.f4715c = j;
        this.d = i;
        this.e = z;
    }

    private b(com.anythink.expressad.exoplayer.j.a.a aVar, long j, boolean z) {
        this(aVar, j, 20480, z);
    }

    private void b() {
        if (this.f.g != -1) {
            Math.min(this.f.g - this.k, this.f4715c);
        }
        this.g = this.b.c(this.f.h, this.f.e + this.k);
        FileOutputStream fileOutputStream = new FileOutputStream(this.g);
        this.i = fileOutputStream;
        if (this.d > 0) {
            x xVar = this.l;
            if (xVar == null) {
                this.l = new x(this.i, this.d);
            } else {
                xVar.a(fileOutputStream);
            }
            this.h = this.l;
        } else {
            this.h = fileOutputStream;
        }
        this.j = 0L;
    }

    private void c() {
        OutputStream outputStream = this.h;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.flush();
            if (this.e) {
                this.i.getFD().sync();
            }
            af.a(this.h);
            this.h = null;
            File file = this.g;
            this.g = null;
            this.b.a(file);
        } catch (Throwable th) {
            af.a(this.h);
            this.h = null;
            File file2 = this.g;
            this.g = null;
            file2.delete();
            throw th;
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.g
    public final void a() {
        if (this.f == null) {
            return;
        }
        try {
            c();
        } catch (IOException e) {
            throw new a(e);
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.g
    public final void a(com.anythink.expressad.exoplayer.j.k kVar) {
        if (kVar.g == -1 && !kVar.a(2)) {
            this.f = null;
            return;
        }
        this.f = kVar;
        this.k = 0L;
        try {
            b();
        } catch (IOException e) {
            throw new a(e);
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.g
    public final void a(byte[] bArr, int i, int i2) {
        if (this.f == null) {
            return;
        }
        int i3 = 0;
        while (i3 < i2) {
            try {
                if (this.j == this.f4715c) {
                    c();
                    b();
                }
                int min = (int) Math.min(i2 - i3, this.f4715c - this.j);
                this.h.write(bArr, i + i3, min);
                i3 += min;
                long j = min;
                this.j += j;
                this.k += j;
            } catch (IOException e) {
                throw new a(e);
            }
        }
    }
}
