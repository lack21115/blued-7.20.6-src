package com.youzan.spiderman.d;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/d/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f41811a;
    private ExecutorService b = Executors.newCachedThreadPool();

    private b() {
    }

    public static b a() {
        if (f41811a == null) {
            f41811a = new b();
        }
        return f41811a;
    }

    public final void a(Runnable runnable) {
        this.b.execute(runnable);
    }
}
