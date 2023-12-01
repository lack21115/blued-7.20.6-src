package com.anythink.expressad.exoplayer.h.b;

import com.anythink.expressad.exoplayer.j.k;
import com.anythink.expressad.exoplayer.m;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/b/a.class */
public abstract class a extends i {

    /* renamed from: a  reason: collision with root package name */
    public final long f4583a;
    private b k;
    private int[] l;

    public a(com.anythink.expressad.exoplayer.j.h hVar, k kVar, m mVar, int i, Object obj, long j, long j2, long j3, long j4) {
        super(hVar, kVar, mVar, i, obj, j, j2, j4);
        this.f4583a = j3;
    }

    public final int a(int i) {
        return this.l[i];
    }

    public final void a(b bVar) {
        this.k = bVar;
        this.l = bVar.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final b c() {
        return this.k;
    }
}
