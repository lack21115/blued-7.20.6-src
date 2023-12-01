package com.youzan.spiderman.a;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/a/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f41717a;
    private ExecutorService b = Executors.newCachedThreadPool();

    private c() {
    }

    public static c a() {
        if (f41717a == null) {
            f41717a = new c();
        }
        return f41717a;
    }

    public final void a(a aVar) {
        this.b.execute(aVar);
    }
}
