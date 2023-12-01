package com.tencent.bugly.crashreport.biz;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.biz.a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/crashreport/biz/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static a f35123a;
    private static boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private static int f35124c = 10;
    private static long d = 300000;
    private static long e = 30000;
    private static long f = 0;
    private static int g = 0;
    private static long h = 0;
    private static long i = 0;
    private static long j = 0;
    private static Application.ActivityLifecycleCallbacks k;
    private static Class<?> l;
    private static boolean m = true;

    static /* synthetic */ String a(String str, String str2) {
        return z.a() + "  " + str + "  " + str2 + "\n";
    }

    public static void a() {
        a aVar = f35123a;
        if (aVar != null) {
            aVar.a(2, false, 0L);
        }
    }

    public static void a(long j2) {
        long j3 = j2;
        if (j2 < 0) {
            j3 = com.tencent.bugly.crashreport.common.strategy.a.a().c().o;
        }
        f = j3;
    }

    public static void a(Context context) {
        if (!b || context == null) {
            return;
        }
        Application application = null;
        if (Build.VERSION.SDK_INT >= 14) {
            if (context.getApplicationContext() instanceof Application) {
                application = (Application) context.getApplicationContext();
            }
            if (application != null) {
                try {
                    if (k != null) {
                        application.unregisterActivityLifecycleCallbacks(k);
                    }
                } catch (Exception e2) {
                    if (!x.a(e2)) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        b = false;
    }

    public static void a(final Context context, final BuglyStrategy buglyStrategy) {
        long j2;
        if (b) {
            return;
        }
        boolean z = com.tencent.bugly.crashreport.common.info.a.a(context).e;
        m = z;
        f35123a = new a(context, z);
        b = true;
        if (buglyStrategy != null) {
            l = buglyStrategy.getUserInfoActivity();
            j2 = buglyStrategy.getAppReportDelay();
        } else {
            j2 = 0;
        }
        if (j2 <= 0) {
            c(context, buglyStrategy);
        } else {
            w.a().a(new Runnable() { // from class: com.tencent.bugly.crashreport.biz.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.c(Context.this, buglyStrategy);
                }
            }, j2);
        }
    }

    public static void a(StrategyBean strategyBean, boolean z) {
        w a2;
        a aVar = f35123a;
        if (aVar != null && !z && (a2 = w.a()) != null) {
            a2.a(new a.AnonymousClass2());
        }
        if (strategyBean == null) {
            return;
        }
        if (strategyBean.o > 0) {
            e = strategyBean.o;
        }
        if (strategyBean.t > 0) {
            f35124c = strategyBean.t;
        }
        if (strategyBean.u > 0) {
            d = strategyBean.u;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void c(android.content.Context r7, com.tencent.bugly.BuglyStrategy r8) {
        /*
            Method dump skipped, instructions count: 447
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.biz.b.c(android.content.Context, com.tencent.bugly.BuglyStrategy):void");
    }

    static /* synthetic */ int g() {
        int i2 = g;
        g = i2 + 1;
        return i2;
    }
}
