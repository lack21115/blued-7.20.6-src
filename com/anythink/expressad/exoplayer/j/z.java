package com.anythink.expressad.exoplayer.j;

import android.net.Uri;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/z.class */
public final class z implements h {

    /* renamed from: a  reason: collision with root package name */
    private final h f4781a;
    private final g b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4782c;
    private long d;

    public z(h hVar, g gVar) {
        this.f4781a = (h) com.anythink.expressad.exoplayer.k.a.a(hVar);
        this.b = (g) com.anythink.expressad.exoplayer.k.a.a(gVar);
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final int a(byte[] bArr, int i, int i2) {
        if (this.d == 0) {
            return -1;
        }
        int a2 = this.f4781a.a(bArr, i, i2);
        if (a2 > 0) {
            this.b.a(bArr, i, a2);
            long j = this.d;
            if (j != -1) {
                this.d = j - a2;
            }
        }
        return a2;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final long a(k kVar) {
        long a2 = this.f4781a.a(kVar);
        this.d = a2;
        if (a2 == 0) {
            return 0L;
        }
        k kVar2 = kVar;
        if (kVar.g == -1) {
            kVar2 = kVar;
            if (this.d != -1) {
                kVar2 = new k(kVar.f4745c, kVar.e, kVar.f, this.d, kVar.h, kVar.i);
            }
        }
        this.f4782c = true;
        this.b.a(kVar2);
        return this.d;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final Uri a() {
        return this.f4781a.a();
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final void b() {
        try {
            this.f4781a.b();
        } finally {
            if (this.f4782c) {
                this.f4782c = false;
                this.b.a();
            }
        }
    }
}
