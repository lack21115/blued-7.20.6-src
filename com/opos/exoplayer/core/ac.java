package com.opos.exoplayer.core;

import com.opos.exoplayer.core.e.e;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/ac.class */
final class ac {

    /* renamed from: a  reason: collision with root package name */
    public final e.b f25059a;
    public final long b;

    /* renamed from: c  reason: collision with root package name */
    public final long f25060c;
    public final long d;
    public final long e;
    public final boolean f;
    public final boolean g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(e.b bVar, long j, long j2, long j3, long j4, boolean z, boolean z2) {
        this.f25059a = bVar;
        this.b = j;
        this.f25060c = j2;
        this.d = j3;
        this.e = j4;
        this.f = z;
        this.g = z2;
    }

    public ac a(int i) {
        return new ac(this.f25059a.a(i), this.b, this.f25060c, this.d, this.e, this.f, this.g);
    }

    public ac a(long j) {
        return new ac(this.f25059a, j, this.f25060c, this.d, this.e, this.f, this.g);
    }
}
