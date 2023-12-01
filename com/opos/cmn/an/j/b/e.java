package com.opos.cmn.an.j.b;

import java.util.concurrent.Callable;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/j/b/e.class */
public final class e<T> implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final c f10907a = new c();
    private static final b b = new b();

    /* renamed from: c  reason: collision with root package name */
    private Runnable f10908c;
    private Callable<T> d;
    private d<T, Throwable> e;

    public e(f<T, Throwable> fVar) {
        this.f10908c = fVar.e;
        this.d = fVar.f;
        this.e = new d<>(fVar.d == com.opos.cmn.an.j.a.a.MAIN ? f10907a : b, fVar.f10910c, fVar.f10909a, fVar.b);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f10908c != null) {
                this.f10908c.run();
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
