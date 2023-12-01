package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Looper;
import com.kwad.components.splash.monitor.SplashMonitorInfo;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.amap.api.col.3sl.iw  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/iw.class */
public final class iw extends it implements Thread.UncaughtExceptionHandler {
    private static ExecutorService e;
    private static WeakReference<Context> g;
    private Context d;
    private static Set<Integer> f = Collections.synchronizedSet(new HashSet());
    private static final ThreadFactory h = new ThreadFactory() { // from class: com.amap.api.col.3sl.iw.2

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f5187a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "pama#" + this.f5187a.getAndIncrement()) { // from class: com.amap.api.col.3sl.iw.2.1
                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() {
                    try {
                        super.run();
                    } catch (Throwable th) {
                    }
                }
            };
        }
    };

    private iw(Context context) {
        this.d = context;
        try {
            this.b = Thread.getDefaultUncaughtExceptionHandler();
            if (this.b == null) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.f5180c = true;
                return;
            }
            String obj = this.b.toString();
            if (!obj.startsWith("com.amap.apis.utils.core.dynamiccore") && (obj.indexOf("com.amap.api") != -1 || obj.indexOf("com.loc") != -1)) {
                this.f5180c = false;
                return;
            }
            Thread.setDefaultUncaughtExceptionHandler(this);
            this.f5180c = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static iw a(Context context, ia iaVar) throws hn {
        synchronized (iw.class) {
            try {
                if (iaVar != null) {
                    if (iaVar.a() == null || "".equals(iaVar.a())) {
                        throw new hn("sdk name is invalid");
                    }
                    if (!f.add(Integer.valueOf(iaVar.hashCode()))) {
                        return (iw) it.f5179a;
                    }
                    if (it.f5179a == null) {
                        it.f5179a = new iw(context);
                    } else {
                        it.f5179a.f5180c = false;
                    }
                    it.f5179a.a(iaVar, it.f5179a.f5180c);
                    return (iw) it.f5179a;
                }
                throw new hn("sdk info is null");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            g = new WeakReference<>(context.getApplicationContext());
        } catch (Throwable th) {
        }
    }

    public static void a(Context context, ia iaVar, String str, String str2, String str3) {
        ix.a(context, iaVar, str, 0, str2, str3);
    }

    public static void a(ia iaVar, String str, hn hnVar) {
        if (hnVar != null) {
            a(iaVar, str, hnVar.c(), hnVar.d(), hnVar.e(), hnVar.b());
        }
    }

    public static void a(ia iaVar, String str, String str2, String str3, String str4) {
        a(iaVar, str, str2, str3, "", str4);
    }

    public static void a(ia iaVar, String str, String str2, String str3, String str4, String str5) {
        try {
            if (it.f5179a != null) {
                it.f5179a.a(iaVar, "path:" + str + ",type:" + str2 + ",gsid:" + str3 + ",csid:" + str4 + ",code:" + str5, SplashMonitorInfo.ERROR_NET_MSG);
            }
        } catch (Throwable th) {
        }
    }

    public static void b() {
        synchronized (iw.class) {
            try {
                if (e != null) {
                    e.shutdown();
                }
                jr.a();
                if (it.f5179a != null && Thread.getDefaultUncaughtExceptionHandler() == it.f5179a && it.f5179a.b != null) {
                    Thread.setDefaultUncaughtExceptionHandler(it.f5179a.b);
                }
                it.f5179a = null;
            }
        }
    }

    public static void b(Context context, ia iaVar, String str, String str2, String str3) {
        ix.a(context, iaVar, str, 1, str2, str3);
    }

    public static void b(ia iaVar, String str, String str2) {
        try {
            if (it.f5179a != null) {
                it.f5179a.a(iaVar, str, str2);
            }
        } catch (Throwable th) {
        }
    }

    public static void c() {
        WeakReference<Context> weakReference = g;
        if (weakReference != null && weakReference.get() != null) {
            iu.a(g.get());
        } else if (it.f5179a != null) {
            it.f5179a.a();
        }
    }

    public static void c(Throwable th, String str, String str2) {
        try {
            if (it.f5179a != null) {
                it.f5179a.a(th, 1, str, str2);
            }
        } catch (Throwable th2) {
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0040 -> B:24:0x0031). Please submit an issue!!! */
    @Deprecated
    public static ExecutorService d() {
        ExecutorService executorService;
        synchronized (iw.class) {
            try {
                if (e == null || e.isShutdown()) {
                    e = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(256), h);
                }
            } catch (Throwable th) {
            }
            try {
                executorService = e;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return executorService;
    }

    public static iw e() {
        iw iwVar;
        synchronized (iw.class) {
            try {
                iwVar = (iw) it.f5179a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iwVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p0003sl.it
    public final void a() {
        iu.a(this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p0003sl.it
    public final void a(ia iaVar, String str, String str2) {
        ix.a(iaVar, this.d, str2, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p0003sl.it
    public final void a(final ia iaVar, final boolean z) {
        try {
            lb.a().a(new lc() { // from class: com.amap.api.col.3sl.iw.1
                @Override // com.amap.api.col.p0003sl.lc
                public final void runTask() {
                    try {
                        synchronized (Looper.getMainLooper()) {
                            iu.a(iaVar);
                        }
                        if (z) {
                            ix.a(iw.this.d);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        } catch (RejectedExecutionException e2) {
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p0003sl.it
    public final void a(Throwable th, int i, String str, String str2) {
        ix.a(this.d, th, i, str, str2);
    }

    public final void b(Throwable th, String str, String str2) {
        if (th == null) {
            return;
        }
        try {
            a(th, 1, str, str2);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        if (th == null) {
            return;
        }
        a(th, 0, null, null);
        if (this.b != null) {
            try {
                Thread.setDefaultUncaughtExceptionHandler(this.b);
            } catch (Throwable th2) {
            }
            this.b.uncaughtException(thread, th);
        }
    }
}
