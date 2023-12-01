package com.kwad.sdk.crash;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.kwad.sdk.crash.g;
import com.kwad.sdk.crash.handler.AnrHandler;
import com.kwad.sdk.crash.handler.NativeCrashHandler;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.utils.y;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/b.class */
public final class b {
    private static volatile boolean aqC = false;
    private static volatile boolean aqD = false;
    private static Handler Sw = new Handler(Looper.getMainLooper());
    private static final AtomicBoolean ISLOADED = new AtomicBoolean(false);
    private static final String[] aqE = {"c++_shared", "kscutils", "exception-handler"};
    private static boolean aqF = false;
    private static boolean aqG = false;

    public static void a(c cVar) {
        if (cVar.context == null || aqD) {
            return;
        }
        aqD = true;
        aqF = cVar.aqF;
        aqG = cVar.aqG;
        try {
            com.kwad.sdk.crash.utils.e.init(cVar.context);
            com.kwad.sdk.crash.kwai.a.init(cVar.context, cVar.aqR);
            e.zy().a(cVar);
            bl(cVar.context);
            if (!bk(cVar.context) && (aqF || aqG)) {
                g.a(cVar, new g.a() { // from class: com.kwad.sdk.crash.b.1
                    @Override // com.kwad.sdk.crash.g.a
                    public final void zt() {
                        b.Sw.post(new Runnable() { // from class: com.kwad.sdk.crash.b.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                if (b.aqF) {
                                    b.zj();
                                }
                                if (b.aqG) {
                                    b.c(false, "/sdcard/");
                                }
                            }
                        });
                    }
                });
            }
            zk();
        } catch (Throwable th) {
        }
    }

    private static boolean bk(Context context) {
        return context == null || y.bR(context) >= 3;
    }

    private static void bl(Context context) {
        com.kwad.sdk.crash.handler.c.zO().init(com.kwad.sdk.crash.kwai.a.zJ(), new f() { // from class: com.kwad.sdk.crash.b.3
            @Override // com.kwad.sdk.crash.f
            public final void a(int i, ExceptionMessage exceptionMessage) {
                e.zy().b(i, exceptionMessage);
            }
        }, new com.kwad.sdk.crash.report.c() { // from class: com.kwad.sdk.crash.b.4
            @Override // com.kwad.sdk.crash.report.e
            public final void a(ExceptionMessage exceptionMessage, CountDownLatch countDownLatch) {
                a(exceptionMessage, 1, countDownLatch);
            }

            @Override // com.kwad.sdk.crash.report.e
            public final File zu() {
                return new File(com.kwad.sdk.crash.kwai.a.zI(), "java_crash/upload");
            }
        });
        Thread.setDefaultUncaughtExceptionHandler(new com.kwad.sdk.crash.handler.d(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(boolean z, String str) {
        if (com.kwad.sdk.crash.kwai.a.v(com.kwad.sdk.crash.kwai.a.zL())) {
            NativeCrashHandler.getInstance().init(com.kwad.sdk.crash.kwai.a.zL(), z, str, new com.kwad.sdk.crash.report.c() { // from class: com.kwad.sdk.crash.b.7
                @Override // com.kwad.sdk.crash.report.e
                public final void a(ExceptionMessage exceptionMessage, CountDownLatch countDownLatch) {
                    com.kwad.sdk.core.d.b.d("ExceptionCollector", "Native upload");
                    a(exceptionMessage, 4, countDownLatch);
                }

                @Override // com.kwad.sdk.crash.report.e
                public final File zu() {
                    return new File(com.kwad.sdk.crash.kwai.a.zI(), "native_crash_log/upload");
                }
            });
        }
    }

    public static void g(final Throwable th) {
        com.kwad.sdk.utils.g.execute(new Runnable() { // from class: com.kwad.sdk.crash.b.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (com.kwad.sdk.crash.a.a.h(Throwable.this)) {
                        com.kwad.sdk.crash.handler.a.i(Throwable.this);
                    }
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.b.printStackTrace(th2);
                }
            }
        });
    }

    public static boolean zi() {
        if (ISLOADED.get()) {
            return true;
        }
        try {
            String[] strArr = aqE;
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    ISLOADED.set(true);
                    return true;
                }
                System.loadLibrary(strArr[i2]);
                i = i2 + 1;
            }
        } catch (Throwable th) {
            ISLOADED.set(false);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zj() {
        AnrHandler.getInstance().init(com.kwad.sdk.crash.kwai.a.zK(), new f() { // from class: com.kwad.sdk.crash.b.5
            @Override // com.kwad.sdk.crash.f
            public final void a(int i, ExceptionMessage exceptionMessage) {
                e.zy().b(i, exceptionMessage);
            }
        }, new com.kwad.sdk.crash.report.c() { // from class: com.kwad.sdk.crash.b.6
            @Override // com.kwad.sdk.crash.report.e
            public final void a(ExceptionMessage exceptionMessage, CountDownLatch countDownLatch) {
                com.kwad.sdk.core.d.b.d("ExceptionCollector", "ANR upload");
                a(exceptionMessage, 3, countDownLatch);
            }

            @Override // com.kwad.sdk.crash.report.e
            public final File zu() {
                return new File(com.kwad.sdk.crash.kwai.a.zI(), "anr_log/upload");
            }
        });
    }

    private static void zk() {
        synchronized (b.class) {
            try {
                if (!aqC) {
                    aqC = true;
                    com.kwad.sdk.core.threads.a.xI().postDelayed(new Runnable() { // from class: com.kwad.sdk.crash.b.8
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                b.zl();
                            } catch (Throwable th) {
                            }
                        }
                    }, TimeUnit.SECONDS.toMillis(d.are));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zl() {
        zm();
        if (aqF) {
            zn();
        }
        if (aqG) {
            zo();
        }
    }

    private static void zm() {
        com.kwad.sdk.core.d.b.d("ExceptionCollector", "reportJavaException");
        com.kwad.sdk.crash.report.f fVar = new com.kwad.sdk.crash.report.f();
        fVar.a(com.kwad.sdk.crash.handler.c.zO().getUploader());
        fVar.x(com.kwad.sdk.crash.kwai.a.zJ());
    }

    private static void zn() {
        com.kwad.sdk.core.d.b.d("ExceptionCollector", "reportAnrException");
        com.kwad.sdk.crash.report.b bVar = new com.kwad.sdk.crash.report.b();
        bVar.a(AnrHandler.getInstance().getUploader());
        bVar.x(com.kwad.sdk.crash.kwai.a.zK());
    }

    private static void zo() {
        com.kwad.sdk.core.d.b.d("ExceptionCollector", "reportNativeException");
        com.kwad.sdk.crash.report.g gVar = new com.kwad.sdk.crash.report.g();
        gVar.a(NativeCrashHandler.getInstance().getUploader());
        gVar.x(com.kwad.sdk.crash.kwai.a.zL());
    }
}
