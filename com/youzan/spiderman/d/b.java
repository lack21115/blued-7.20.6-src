package com.youzan.spiderman.d;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/d/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f28120a;
    private ExecutorService b = Executors.newCachedThreadPool();

    private b() {
    }

    public static b a() {
        if (f28120a == null) {
            f28120a = new b();
        }
        return f28120a;
    }

    public final void a(Runnable runnable) {
        this.b.execute(runnable);
    }
}
