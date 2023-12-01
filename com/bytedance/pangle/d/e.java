package com.bytedance.pangle.d;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/d/e.class */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static Executor f7767a = Executors.newCachedThreadPool(new ThreadFactory() { // from class: com.bytedance.pangle.d.e.1

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f7769a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "pangle-Fast-" + this.f7769a.getAndIncrement());
        }
    });
    private static final Object b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static Handler f7768c = null;

    private static Handler a() {
        Handler handler;
        synchronized (b) {
            if (f7768c == null) {
                f7768c = new Handler(Looper.getMainLooper());
            }
            handler = f7768c;
        }
        return handler;
    }

    public static ExecutorService a(int i) {
        return Executors.newFixedThreadPool(i, new ThreadFactory() { // from class: com.bytedance.pangle.d.e.2

            /* renamed from: a  reason: collision with root package name */
            private final AtomicInteger f7770a = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "pangle-Install-" + this.f7770a.getAndIncrement());
            }
        });
    }

    public static void a(Runnable runnable) {
        f7767a.execute(runnable);
    }

    public static void b(Runnable runnable) {
        if (a().getLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            a().post(runnable);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0000, code lost:
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String e1672829046108dc(java.lang.String r5) {
        /*
        L0:
            r0 = 73
            r6 = r0
            r0 = 96
            r7 = r0
        L6:
            r0 = r6
            switch(r0) {
                case 72: goto L85;
                case 73: goto L23;
                case 74: goto L40;
                default: goto L20;
            }
        L20:
            goto L8e
        L23:
            r0 = r7
            switch(r0) {
                case 94: goto L0;
                case 95: goto L85;
                case 96: goto L85;
                default: goto L40;
            }
        L40:
            r0 = r7
            switch(r0) {
                case 55: goto L5f;
                case 56: goto L85;
                case 57: goto L85;
                default: goto L5c;
            }
        L5c:
            goto L0
        L5f:
            r0 = r5
            char[] r0 = r0.toCharArray()
            r5 = r0
            r0 = 0
            r6 = r0
        L66:
            r0 = r6
            r1 = r5
            int r1 = r1.length
            if (r0 >= r1) goto L7c
            r0 = r5
            r1 = r6
            r2 = r5
            r3 = r6
            char r2 = r2[r3]
            r3 = r6
            r2 = r2 ^ r3
            char r2 = (char) r2
            r0[r1] = r2
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            goto L66
        L7c:
            java.lang.String r0 = new java.lang.String
            r1 = r0
            r2 = r5
            r1.<init>(r2)
            return r0
        L85:
            r0 = 74
            r6 = r0
            r0 = 55
            r7 = r0
            goto L6
        L8e:
            r0 = 72
            r6 = r0
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.d.e.e1672829046108dc(java.lang.String):java.lang.String");
    }
}
