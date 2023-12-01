package com.tencent.liteav.base.util;

import com.tencent.liteav.base.util.j;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/util/l.class */
final /* synthetic */ class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final j.a f22647a;
    private final Runnable b;

    private l(j.a aVar, Runnable runnable) {
        this.f22647a = aVar;
        this.b = runnable;
    }

    public static Runnable a(j.a aVar, Runnable runnable) {
        return new l(aVar, runnable);
    }

    @Override // java.lang.Runnable
    public final void run() {
        j.a aVar = this.f22647a;
        Runnable runnable = this.b;
        runnable.run();
        synchronized (j.this) {
            j.this.f22643c.remove(runnable);
        }
    }
}
