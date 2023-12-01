package com.tencent.bugly.idasc.proguard;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.tencent.bugly.idasc.BuglyStrategy;
import com.tencent.bugly.idasc.crashreport.biz.UserInfoBean;
import com.tencent.bugly.idasc.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.idasc.proguard.r;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/s.class */
public class s {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f21646a = false;
    public static r b;

    /* renamed from: c  reason: collision with root package name */
    private static int f21647c = 10;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/s$a.class */
    public static final class a implements Application.ActivityLifecycleCallbacks {
        a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            String name = activity.getClass().getName();
            if (s.l == null || s.l.getName().equals(name)) {
                al.c(">>> %s onCreated <<<", name);
                aa b = aa.b();
                if (b != null) {
                    b.L.add(s.a(name, "onCreated"));
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            String name = activity.getClass().getName();
            if (s.l == null || s.l.getName().equals(name)) {
                al.c(">>> %s onDestroyed <<<", name);
                aa b = aa.b();
                if (b != null) {
                    b.L.add(s.a(name, "onDestroyed"));
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            String name = activity.getClass().getName();
            if (s.l == null || s.l.getName().equals(name)) {
                al.c(">>> %s onPaused <<<", name);
                aa b = aa.b();
                if (b == null) {
                    return;
                }
                b.L.add(s.a(name, "onPaused"));
                b.A = System.currentTimeMillis();
                b.B = b.A - b.z;
                long unused = s.h = b.A;
                if (b.B < 0) {
                    b.B = 0L;
                }
                b.y = "background";
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            String name = activity.getClass().getName();
            if (s.l == null || s.l.getName().equals(name)) {
                al.c(">>> %s onResumed <<<", name);
                aa b = aa.b();
                if (b == null) {
                    return;
                }
                b.L.add(s.a(name, "onResumed"));
                b.y = name;
                b.z = System.currentTimeMillis();
                b.C = b.z - s.i;
                long j = b.z - s.h;
                if (j > (s.f > 0 ? s.f : s.e)) {
                    b.c();
                    s.g();
                    al.a("[session] launch app one times (app in background %d seconds and over %d seconds)", Long.valueOf(j / 1000), Long.valueOf(s.e / 1000));
                    if (s.g % s.f21647c == 0) {
                        s.b.a(4, s.m);
                        return;
                    }
                    s.b.a(4, false);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - s.j > s.d) {
                        long unused = s.j = currentTimeMillis;
                        al.a("add a timer to upload hot start user info", new Object[0]);
                        if (s.m) {
                            ak.a().a(new r.a(null, true), s.d);
                        }
                    }
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            al.c(">>> %s onStart <<<", activity.getClass().getName());
            aa.b().a(activity.hashCode(), true);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            al.c(">>> %s onStop <<<", activity.getClass().getName());
            aa.b().a(activity.hashCode(), false);
        }
    }

    static /* synthetic */ String a(String str, String str2) {
        return ap.a() + "  " + str + "  " + str2 + "\n";
    }

    public static void a() {
        r rVar = b;
        if (rVar != null) {
            rVar.a(2, false);
        }
    }

    public static void a(long j2) {
        long j3 = j2;
        if (j2 < 0) {
            j3 = ac.a().c().p;
        }
        f = j3;
    }

    public static void a(Context context) {
        if (!f21646a || context == null) {
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
                    if (!al.a(e2)) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        f21646a = false;
    }

    public static void a(final Context context, final BuglyStrategy buglyStrategy) {
        long j2;
        if (f21646a) {
            return;
        }
        boolean z = aa.a(context).f;
        m = z;
        b = new r(context, z);
        f21646a = true;
        if (buglyStrategy != null) {
            l = buglyStrategy.getUserInfoActivity();
            j2 = buglyStrategy.getAppReportDelay();
        } else {
            j2 = 0;
        }
        if (j2 <= 0) {
            c(context, buglyStrategy);
        } else {
            ak.a().a(new Runnable() { // from class: com.tencent.bugly.idasc.proguard.s.1
                @Override // java.lang.Runnable
                public final void run() {
                    s.c(Context.this, buglyStrategy);
                }
            }, j2);
        }
    }

    public static void a(StrategyBean strategyBean, boolean z) {
        r rVar = b;
        if (rVar != null && !z) {
            rVar.b();
        }
        if (strategyBean == null) {
            return;
        }
        if (strategyBean.p > 0) {
            e = strategyBean.p;
        }
        if (strategyBean.u > 0) {
            f21647c = strategyBean.u;
        }
        if (strategyBean.v > 0) {
            d = strategyBean.v;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, BuglyStrategy buglyStrategy) {
        boolean z;
        boolean z2;
        boolean z3;
        if (buglyStrategy != null) {
            z2 = buglyStrategy.recordUserInfoOnceADay();
            z = buglyStrategy.isEnableUserInfo();
        } else {
            z = true;
            z2 = false;
        }
        if (z2) {
            aa a2 = aa.a(context);
            List<UserInfoBean> a3 = r.a(a2.d);
            if (a3 != null) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= a3.size()) {
                        break;
                    }
                    UserInfoBean userInfoBean = a3.get(i3);
                    if (userInfoBean.n.equals(a2.o) && userInfoBean.b == 1) {
                        long b2 = ap.b();
                        if (b2 <= 0) {
                            break;
                        } else if (userInfoBean.e >= b2) {
                            if (userInfoBean.f <= 0) {
                                b.b();
                            }
                            z3 = false;
                        }
                    }
                    i2 = i3 + 1;
                }
            }
            z3 = true;
            if (!z3) {
                return;
            }
            z = false;
        }
        aa b3 = aa.b();
        if (b3 != null && z.a()) {
            b3.a(0, true);
        }
        if (z) {
            Application application = null;
            if (Build.VERSION.SDK_INT >= 14) {
                if (context.getApplicationContext() instanceof Application) {
                    application = (Application) context.getApplicationContext();
                }
                if (application != null) {
                    try {
                        if (k == null) {
                            k = new a();
                        }
                        application.registerActivityLifecycleCallbacks(k);
                    } catch (Exception e2) {
                        if (!al.a(e2)) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
        if (m) {
            i = System.currentTimeMillis();
            b.a(1, false);
            al.a("[session] launch app, new start", new Object[0]);
            b.a();
            b.a(com.anythink.expressad.d.a.b.aD);
        }
    }

    static /* synthetic */ int g() {
        int i2 = g;
        g = i2 + 1;
        return i2;
    }
}
