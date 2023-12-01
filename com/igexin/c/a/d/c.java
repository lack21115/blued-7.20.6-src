package com.igexin.c.a.d;

import java.util.concurrent.TimeUnit;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/c/a/d/c.class */
public abstract class c implements com.igexin.c.a.d.a.g {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f9656a = true;

    @Override // com.igexin.c.a.d.a.g
    public final boolean a(long j, f fVar) {
        return TimeUnit.SECONDS.toMillis((long) fVar.B) < j - fVar.z;
    }

    @Override // com.igexin.c.a.d.a.g
    public final long b(long j, f fVar) {
        return (TimeUnit.SECONDS.toMillis(fVar.B) + fVar.z) - j;
    }

    @Override // com.igexin.c.a.d.a.g
    public void b() {
        this.f9656a = false;
    }

    @Override // com.igexin.c.a.d.a.g
    public final boolean d() {
        return this.f9656a;
    }
}
