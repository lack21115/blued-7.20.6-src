package com.tencent.liteav.base.util;

import com.tencent.liteav.base.util.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/util/l.class */
public final /* synthetic */ class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final j.a f36338a;
    private final Runnable b;

    private l(j.a aVar, Runnable runnable) {
        this.f36338a = aVar;
        this.b = runnable;
    }

    public static Runnable a(j.a aVar, Runnable runnable) {
        return new l(aVar, runnable);
    }

    @Override // java.lang.Runnable
    public final void run() {
        j.a aVar = this.f36338a;
        Runnable runnable = this.b;
        runnable.run();
        synchronized (j.this) {
            j.this.f36334c.remove(runnable);
        }
    }
}
