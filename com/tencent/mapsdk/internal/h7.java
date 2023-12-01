package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.ArticleInfo;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/h7.class */
public class h7 {

    /* renamed from: a  reason: collision with root package name */
    private static final a f37518a = new a("sw");
    private static final a b = new a("lw");

    /* renamed from: c  reason: collision with root package name */
    private static final a f37519c = new a("mlw");
    private static final a d = new a(ArticleInfo.QUERY_WORD);
    private static final a e = new a("mqw");
    private static ScheduledThreadPoolExecutor f;
    private static ThreadPoolExecutor g;
    private static ThreadPoolExecutor h;
    private static ThreadPoolExecutor i;
    private static ThreadPoolExecutor j;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/h7$a.class */
    public static class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private String f37520a;
        private final AtomicInteger b = new AtomicInteger(0);

        public a(String str) {
            this.f37520a = str;
            if (TextUtils.isEmpty(str)) {
                this.f37520a = "def";
            }
        }

        public a a() {
            this.b.set(0);
            return this;
        }

        public int b() {
            return this.b.get();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "tms-" + this.f37520a + "-" + this.b.incrementAndGet());
            StringBuilder sb = new StringBuilder();
            sb.append("创建线程：");
            sb.append(thread);
            na.a(sb.toString());
            return thread;
        }
    }

    public static String a() {
        Thread currentThread = Thread.currentThread();
        return currentThread + ";" + currentThread.getState() + ";interrupted=" + Thread.interrupted() + "|" + currentThread.isInterrupted();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(java.util.concurrent.ExecutorService r3) {
        /*
            java.lang.Class<com.tencent.mapsdk.internal.h7> r0 = com.tencent.mapsdk.internal.h7.class
            monitor-enter(r0)
            r0 = 0
            r6 = r0
            r0 = r3
            if (r0 == 0) goto L54
            r0 = r3
            boolean r0 = r0.isShutdown()     // Catch: java.lang.Throwable -> L50
            if (r0 != 0) goto L54
            r0 = r3
            boolean r0 = r0.isTerminated()     // Catch: java.lang.Throwable -> L50
            if (r0 != 0) goto L54
            r0 = 1
            r4 = r0
            goto L20
        L20:
            r0 = r3
            boolean r0 = r0 instanceof java.util.concurrent.ThreadPoolExecutor     // Catch: java.lang.Throwable -> L50
            if (r0 == 0) goto L42
            r0 = r6
            r5 = r0
            r0 = r4
            if (r0 == 0) goto L44
            r0 = r3
            java.util.concurrent.ThreadPoolExecutor r0 = (java.util.concurrent.ThreadPoolExecutor) r0     // Catch: java.lang.Throwable -> L50
            boolean r0 = r0.isTerminating()     // Catch: java.lang.Throwable -> L50
            r7 = r0
            r0 = r6
            r5 = r0
            r0 = r7
            if (r0 != 0) goto L44
            r0 = 1
            r5 = r0
            goto L44
        L42:
            r0 = r4
            r5 = r0
        L44:
            java.lang.Class<com.tencent.mapsdk.internal.h7> r0 = com.tencent.mapsdk.internal.h7.class
            monitor-exit(r0)
            r0 = r5
            r1 = 1
            r0 = r0 ^ r1
            return r0
        L4b:
            java.lang.Class<com.tencent.mapsdk.internal.h7> r0 = com.tencent.mapsdk.internal.h7.class
            monitor-exit(r0)
            r0 = r3
            throw r0
        L50:
            r3 = move-exception
            goto L4b
        L54:
            r0 = 0
            r4 = r0
            goto L20
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.internal.h7.a(java.util.concurrent.ExecutorService):boolean");
    }

    public static ThreadPoolExecutor b() {
        ThreadPoolExecutor threadPoolExecutor;
        synchronized (h7.class) {
            try {
                if (a(h)) {
                    int max = Math.max(4, Runtime.getRuntime().availableProcessors());
                    h = new ThreadPoolExecutor(max / 2, max, 2L, TimeUnit.SECONDS, new LinkedBlockingQueue(), e.a(), new ThreadPoolExecutor.DiscardPolicy());
                }
                threadPoolExecutor = h;
            } catch (Throwable th) {
                throw th;
            }
        }
        return threadPoolExecutor;
    }

    public static ThreadPoolExecutor c() {
        ThreadPoolExecutor threadPoolExecutor;
        synchronized (h7.class) {
            try {
                if (a(j)) {
                    j = new ThreadPoolExecutor(0, Math.max(4, Runtime.getRuntime().availableProcessors()) / 2, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f37519c.a(), new ThreadPoolExecutor.DiscardPolicy());
                }
                threadPoolExecutor = j;
            } catch (Throwable th) {
                throw th;
            }
        }
        return threadPoolExecutor;
    }

    public static ScheduledThreadPoolExecutor d() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        synchronized (h7.class) {
            try {
                if (a(f)) {
                    f = new ScheduledThreadPoolExecutor(2, f37518a.a(), new ThreadPoolExecutor.DiscardPolicy());
                }
                scheduledThreadPoolExecutor = f;
            } catch (Throwable th) {
                throw th;
            }
        }
        return scheduledThreadPoolExecutor;
    }

    public static ThreadPoolExecutor e() {
        ThreadPoolExecutor threadPoolExecutor;
        synchronized (h7.class) {
            try {
                if (a(g)) {
                    g = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), d.a(), new ThreadPoolExecutor.DiscardPolicy());
                }
                threadPoolExecutor = g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return threadPoolExecutor;
    }

    public static ThreadPoolExecutor f() {
        ThreadPoolExecutor threadPoolExecutor;
        synchronized (h7.class) {
            try {
                if (a(i)) {
                    i = new ThreadPoolExecutor(0, 1, 2L, TimeUnit.SECONDS, new LinkedBlockingQueue(), b.a(), new ThreadPoolExecutor.DiscardPolicy());
                }
                threadPoolExecutor = i;
            } catch (Throwable th) {
                throw th;
            }
        }
        return threadPoolExecutor;
    }
}
