package com.tencent.beacon.a.b;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/a/b/h.class */
public class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Runnable f34930a;
    final /* synthetic */ i b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(i iVar, Runnable runnable) {
        this.b = iVar;
        this.f34930a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        AtomicInteger atomicInteger;
        try {
            this.f34930a.run();
        } catch (Throwable th) {
            atomicInteger = i.e;
            if (atomicInteger.addAndGet(1) < 100) {
                g.e().a("599", "[task] run occur error!", th);
            }
            com.tencent.beacon.base.util.e.a(th.getMessage());
            com.tencent.beacon.base.util.c.a(th);
        }
    }
}
