package com.opos.exoplayer.core;

import com.opos.exoplayer.core.drm.DrmInitData;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/a.class */
public abstract class a implements s, t {

    /* renamed from: a  reason: collision with root package name */
    private final int f25002a;
    private u b;

    /* renamed from: c  reason: collision with root package name */
    private int f25003c;
    private int d;
    private com.opos.exoplayer.core.e.i e;
    private long f;
    private boolean g = true;
    private boolean h;

    public a(int i) {
        this.f25002a = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean a(com.opos.exoplayer.core.drm.b<?> bVar, DrmInitData drmInitData) {
        if (drmInitData == null) {
            return true;
        }
        if (bVar == null) {
            return false;
        }
        return bVar.a(drmInitData);
    }

    @Override // com.opos.exoplayer.core.s, com.opos.exoplayer.core.t
    public final int a() {
        return this.f25002a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a(l lVar, com.opos.exoplayer.core.b.e eVar, boolean z) {
        int a2 = this.e.a(lVar, eVar, z);
        if (a2 == -4) {
            if (eVar.c()) {
                this.g = true;
                return this.h ? -4 : -3;
            }
            eVar.f25074c += this.f;
            return a2;
        }
        if (a2 == -5) {
            Format format = lVar.f25515a;
            if (format.w != Long.MAX_VALUE) {
                lVar.f25515a = format.a(format.w + this.f);
            }
        }
        return a2;
    }

    @Override // com.opos.exoplayer.core.s
    public final void a(int i) {
        this.f25003c = i;
    }

    @Override // com.opos.exoplayer.core.r.b
    public void a(int i, Object obj) {
    }

    @Override // com.opos.exoplayer.core.s
    public final void a(long j) {
        this.h = false;
        this.g = false;
        a(j, false);
    }

    protected void a(long j, boolean z) {
    }

    @Override // com.opos.exoplayer.core.s
    public final void a(u uVar, Format[] formatArr, com.opos.exoplayer.core.e.i iVar, long j, boolean z, long j2) {
        com.opos.exoplayer.core.i.a.b(this.d == 0);
        this.b = uVar;
        this.d = 1;
        a(z);
        a(formatArr, iVar, j2);
        a(j, z);
    }

    protected void a(boolean z) {
    }

    public void a(Format[] formatArr, long j) {
    }

    @Override // com.opos.exoplayer.core.s
    public final void a(Format[] formatArr, com.opos.exoplayer.core.e.i iVar, long j) {
        com.opos.exoplayer.core.i.a.b(!this.h);
        this.e = iVar;
        this.g = false;
        this.f = j;
        a(formatArr, j);
    }

    @Override // com.opos.exoplayer.core.s
    public final int a_() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int b(long j) {
        return this.e.a(j - this.f);
    }

    @Override // com.opos.exoplayer.core.s
    public final t b() {
        return this;
    }

    @Override // com.opos.exoplayer.core.s
    public final void b_() {
        boolean z = true;
        if (this.d != 1) {
            z = false;
        }
        com.opos.exoplayer.core.i.a.b(z);
        this.d = 2;
        n();
    }

    @Override // com.opos.exoplayer.core.s
    public com.opos.exoplayer.core.i.i c() {
        return null;
    }

    @Override // com.opos.exoplayer.core.s
    public final com.opos.exoplayer.core.e.i f() {
        return this.e;
    }

    @Override // com.opos.exoplayer.core.s
    public final boolean g() {
        return this.g;
    }

    @Override // com.opos.exoplayer.core.s
    public final void h() {
        this.h = true;
    }

    @Override // com.opos.exoplayer.core.s
    public final boolean i() {
        return this.h;
    }

    @Override // com.opos.exoplayer.core.s
    public final void j() {
        this.e.c();
    }

    @Override // com.opos.exoplayer.core.s
    public final void k() {
        com.opos.exoplayer.core.i.a.b(this.d == 2);
        this.d = 1;
        o();
    }

    @Override // com.opos.exoplayer.core.s
    public final void l() {
        boolean z = true;
        if (this.d != 1) {
            z = false;
        }
        com.opos.exoplayer.core.i.a.b(z);
        this.d = 0;
        this.e = null;
        this.h = false;
        p();
    }

    @Override // com.opos.exoplayer.core.t
    public int m() {
        return 0;
    }

    protected void n() {
    }

    protected void o() {
    }

    protected void p() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final u q() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int r() {
        return this.f25003c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean s() {
        return this.g ? this.h : this.e.b();
    }
}
