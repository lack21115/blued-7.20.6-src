package com.opos.exoplayer.core.h;

import com.opos.exoplayer.core.h.q;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/h/o.class */
public final class o extends q.a {

    /* renamed from: a  reason: collision with root package name */
    private final String f25462a;
    private final t<? super g> b;

    /* renamed from: c  reason: collision with root package name */
    private final int f25463c;
    private final int d;
    private final boolean e;

    public o(String str, t<? super g> tVar) {
        this(str, tVar, 8000, 8000, false);
    }

    public o(String str, t<? super g> tVar, int i, int i2, boolean z) {
        this.f25462a = str;
        this.b = tVar;
        this.f25463c = i;
        this.d = i2;
        this.e = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.exoplayer.core.h.q.a
    /* renamed from: a */
    public n b(q.f fVar) {
        return new n(this.f25462a, null, this.b, this.f25463c, this.d, this.e, fVar);
    }
}
