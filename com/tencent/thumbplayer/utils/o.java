package com.tencent.thumbplayer.utils;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/utils/o.class */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private static volatile HandlerThread f39445a;
    private static volatile Handler b;

    /* renamed from: c  reason: collision with root package name */
    private static int f39446c;
    private static volatile ExecutorService d;
    private static volatile ExecutorService e;
    private static volatile ScheduledExecutorService f;
    private static volatile o g;

    private o() {
    }

    public static o a() {
        if (g == null) {
            synchronized (o.class) {
                try {
                    if (g == null) {
                        g = new o();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return g;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0037 A[Catch: all -> 0x0054, TryCatch #0 {all -> 0x0054, blocks: (B:4:0x0003, B:6:0x0009, B:8:0x0018, B:12:0x002e, B:14:0x0037, B:16:0x0052, B:9:0x001e, B:11:0x0027), top: B:23:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void f() {
        /*
            java.lang.Class<com.tencent.thumbplayer.utils.o> r0 = com.tencent.thumbplayer.utils.o.class
            monitor-enter(r0)
            android.os.HandlerThread r0 = com.tencent.thumbplayer.utils.o.f39445a     // Catch: java.lang.Throwable -> L54
            if (r0 != 0) goto L1e
            android.os.HandlerThread r0 = new android.os.HandlerThread     // Catch: java.lang.Throwable -> L54
            r1 = r0
            java.lang.String r2 = "TP-ShareThreadPool"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L54
            r4 = r0
            r0 = r4
            com.tencent.thumbplayer.utils.o.f39445a = r0     // Catch: java.lang.Throwable -> L54
        L17:
            r0 = r4
            r0.start()     // Catch: java.lang.Throwable -> L54
            goto L2e
        L1e:
            android.os.HandlerThread r0 = com.tencent.thumbplayer.utils.o.f39445a     // Catch: java.lang.Throwable -> L54
            boolean r0 = r0.isAlive()     // Catch: java.lang.Throwable -> L54
            if (r0 != 0) goto L2e
            android.os.HandlerThread r0 = com.tencent.thumbplayer.utils.o.f39445a     // Catch: java.lang.Throwable -> L54
            r4 = r0
            goto L17
        L2e:
            android.os.HandlerThread r0 = com.tencent.thumbplayer.utils.o.f39445a     // Catch: java.lang.Throwable -> L54
            android.os.Looper r0 = r0.getLooper()     // Catch: java.lang.Throwable -> L54
            if (r0 != 0) goto L50
            android.os.HandlerThread r0 = com.tencent.thumbplayer.utils.o.f39445a     // Catch: java.lang.Throwable -> L54
            boolean r0 = r0.quit()     // Catch: java.lang.Throwable -> L54
            android.os.HandlerThread r0 = new android.os.HandlerThread     // Catch: java.lang.Throwable -> L54
            r1 = r0
            java.lang.String r2 = "TP-ShareThreadPool"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L54
            r4 = r0
            r0 = r4
            com.tencent.thumbplayer.utils.o.f39445a = r0     // Catch: java.lang.Throwable -> L54
            r0 = r4
            r0.start()     // Catch: java.lang.Throwable -> L54
        L50:
            java.lang.Class<com.tencent.thumbplayer.utils.o> r0 = com.tencent.thumbplayer.utils.o.class
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L54
            return
        L54:
            r4 = move-exception
            java.lang.Class<com.tencent.thumbplayer.utils.o> r0 = com.tencent.thumbplayer.utils.o.class
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L54
            r0 = r4
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.utils.o.f():void");
    }

    public HandlerThread a(String str) {
        return a(str, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000b, code lost:
        if (r7 <= (-19)) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.os.HandlerThread a(java.lang.String r6, int r7) {
        /*
            r5 = this;
            r0 = r7
            r1 = 19
            if (r0 >= r1) goto Le
            r0 = r7
            r8 = r0
            r0 = r7
            r1 = -19
            if (r0 > r1) goto L10
        Le:
            r0 = 0
            r8 = r0
        L10:
            r0 = r6
            r9 = r0
            r0 = r6
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L1e
            java.lang.String r0 = "TP-HandlerThread"
            r9 = r0
        L1e:
            android.os.HandlerThread r0 = new android.os.HandlerThread
            r1 = r0
            r2 = r9
            r3 = r8
            r1.<init>(r2, r3)
            r6 = r0
            r0 = r6
            r0.start()
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.utils.o.a(java.lang.String, int):android.os.HandlerThread");
    }

    public void a(HandlerThread handlerThread, Handler handler) {
        if (handlerThread == null) {
            return;
        }
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (!handlerThread.equals(f39445a)) {
            handlerThread.quit();
            return;
        }
        synchronized (o.class) {
            try {
                f39446c--;
                TPLogUtil.i("TPPlayer[TPThreadPool]", "handlerThread recycle mShareThreadCount:" + f39446c);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public HandlerThread b() {
        HandlerThread handlerThread;
        f();
        synchronized (o.class) {
            try {
                f39446c++;
                TPLogUtil.i("TPPlayer[TPThreadPool]", "handlerThread obtainShareThread mShareThreadCount:" + f39446c);
                handlerThread = f39445a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return handlerThread;
    }

    public ExecutorService c() {
        if (d == null) {
            synchronized (o.class) {
                try {
                    if (d == null) {
                        d = Executors.newSingleThreadExecutor();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return d;
    }

    public ExecutorService d() {
        if (e == null) {
            synchronized (o.class) {
                try {
                    if (e == null) {
                        e = p.a(4, 20);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return e;
    }

    public ScheduledExecutorService e() {
        if (f == null) {
            synchronized (o.class) {
                try {
                    if (f == null) {
                        f = Executors.newScheduledThreadPool(4);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f;
    }
}
