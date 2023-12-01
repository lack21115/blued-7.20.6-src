package com.meizu.cloud.pushsdk.d.b.a;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/d/b/a/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static ExecutorService f10475a;
    private static int b = 2;

    public static ExecutorService a() {
        synchronized (b.class) {
            try {
                if (f10475a == null) {
                    f10475a = Executors.newScheduledThreadPool(b);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f10475a;
    }

    public static Future a(Callable callable) {
        return a().submit(callable);
    }

    public static void a(int i) {
        b = i;
    }

    public static void a(Runnable runnable) {
        a().execute(runnable);
    }
}
