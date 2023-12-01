package com.opos.cmn.an.j.b;

import java.util.concurrent.Callable;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/j/b/e.class */
public final class e<T> implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final c f24594a = new c();
    private static final b b = new b();

    /* renamed from: c  reason: collision with root package name */
    private Runnable f24595c;
    private Callable<T> d;
    private d<T, Throwable> e;

    public e(f<T, Throwable> fVar) {
        this.f24595c = fVar.e;
        this.d = fVar.f;
        this.e = new d<>(fVar.d == com.opos.cmn.an.j.a.a.MAIN ? f24594a : b, fVar.f24597c, fVar.f24596a, fVar.b);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f24595c != null) {
                this.f24595c.run();
            } else if (this.d != null) {
                this.e.b((d<T, Throwable>) this.d.call());
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("RunnableWrapper", "threadpool execute error:", e);
            this.e.a((d<T, Throwable>) e);
        }
        this.e.a();
    }
}
