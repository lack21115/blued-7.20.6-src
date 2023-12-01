package com.opos.exoplayer.core.f;

import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/i.class */
public abstract class i extends com.opos.exoplayer.core.b.f implements d {

    /* renamed from: c  reason: collision with root package name */
    private d f25411c;
    private long d;

    @Override // com.opos.exoplayer.core.f.d
    public int a(long j) {
        return this.f25411c.a(j - this.d);
    }

    @Override // com.opos.exoplayer.core.f.d
    public long a(int i) {
        return this.f25411c.a(i) + this.d;
    }

    @Override // com.opos.exoplayer.core.b.a
    public void a() {
        super.a();
        this.f25411c = null;
    }

    public void a(long j, d dVar, long j2) {
        this.f25075a = j;
        this.f25411c = dVar;
        long j3 = j2;
        if (j2 == Long.MAX_VALUE) {
            j3 = this.f25075a;
        }
        this.d = j3;
    }

    @Override // com.opos.exoplayer.core.f.d
    public int b() {
        return this.f25411c.b();
    }

    @Override // com.opos.exoplayer.core.f.d
    public List<b> b(long j) {
        return this.f25411c.b(j - this.d);
    }

    public abstract void e();
}
