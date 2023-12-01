package com.bytedance.bdtracker;

import android.app.Activity;
import android.app.Application;
import android.app.Presentation;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import com.bytedance.bdtracker.b;
import com.bytedance.bdtracker.z2;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/o.class */
public class o implements Application.ActivityLifecycleCallbacks {

    /* renamed from: c  reason: collision with root package name */
    public static c2 f21273c;
    public static c2 d;
    public static long e;
    public static String f;
    public static Object g;
    public static Object h;
    public static long i;
    public static String j;
    public static c2 l;
    public static final /* synthetic */ boolean o = !o.class.desiredAssertionStatus();

    /* renamed from: a  reason: collision with root package name */
    public static final List<String> f21272a = Arrays.asList("androidx.lifecycle.ReportFragment", "androidx.lifecycle.ReportFragment");
    public static int b = 0;
    public static final Map<Integer, List<c2>> k = new HashMap();
    public static final HashSet<Integer> m = new HashSet<>(8);
    public static volatile o n = null;

    public static int a(Presentation presentation) {
        if (presentation == null) {
            return 0;
        }
        int i2 = 0;
        if (Build.VERSION.SDK_INT >= 17) {
            Display display = presentation.getDisplay();
            i2 = 0;
            if (display != null) {
                i2 = display.getDisplayId();
            }
        }
        return i2;
    }

    public static c2 a() {
        c2 c2Var = f21273c;
        c2 c2Var2 = d;
        if (c2Var2 != null) {
            return c2Var2;
        }
        if (c2Var != null) {
            return c2Var;
        }
        return null;
    }

    public static c2 a(Class<?> cls, boolean z, String str, String str2, String str3, String str4, long j2, String str5, JSONObject jSONObject) {
        c2 c2Var = new c2();
        c2Var.y = cls;
        if (TextUtils.isEmpty(str2)) {
            c2Var.r = str;
        } else {
            c2Var.r = str + ":" + str2;
        }
        c2Var.a(j2);
        c2Var.p = -1L;
        if (str5 == null) {
            str5 = "";
        }
        c2Var.q = str5;
        if (str3 == null) {
            str3 = "";
        }
        c2Var.s = str3;
        c2 c2Var2 = l;
        c2Var.t = c2Var2 != null ? c2Var2.s : "";
        if (str4 == null) {
            str4 = "";
        }
        c2Var.u = str4;
        c2 c2Var3 = l;
        c2Var.v = c2Var3 != null ? c2Var3.u : "";
        c2Var.m = jSONObject;
        a(c2Var, z);
        l = c2Var;
        return c2Var;
    }

    public static c2 a(boolean z, c2 c2Var, long j2) {
        c2 c2Var2 = (c2) c2Var.m5742clone();
        c2Var2.a(j2);
        long j3 = j2 - c2Var.b;
        long j4 = j3;
        if (j3 <= 0) {
            j4 = 1000;
        }
        c2Var2.p = j4;
        a(c2Var2, z);
        return c2Var2;
    }

    public static o a(Application application) {
        o oVar;
        synchronized (o.class) {
            try {
                if (n == null) {
                    n = new o();
                    application.registerActivityLifecycleCallbacks(n);
                }
                oVar = n;
            } catch (Throwable th) {
                throw th;
            }
        }
        return oVar;
    }

    public static /* synthetic */ String a(Activity activity) {
        StringBuilder a2 = a.a("onActivityPaused ");
        a2.append(t2.b(activity));
        return a2.toString();
    }

    public static void a(final c2 c2Var, final boolean z) {
        b.a(c2Var, new b.InterfaceC0306b() { // from class: com.bytedance.bdtracker.-$$Lambda$Co0BiTIIIvrkZer0A3v6V1ZAGQs
            @Override // com.bytedance.bdtracker.b.InterfaceC0306b
            public final boolean a(c cVar) {
                return o.a(c2.this, z, cVar);
            }
        });
    }

    public static void a(Object obj) {
        c2 c2Var = d;
        if (c2Var == null || h != obj) {
            return;
        }
        j = c2Var.r;
        long currentTimeMillis = System.currentTimeMillis();
        i = currentTimeMillis;
        a(true, d, currentTimeMillis);
        d = null;
        h = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0035, code lost:
        if (r5.getInitConfig().isAutoTrackFragmentEnabled() != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ boolean a(com.bytedance.bdtracker.c2 r3, boolean r4, com.bytedance.bdtracker.c r5) {
        /*
            com.bytedance.bdtracker.b$b r0 = com.bytedance.bdtracker.b.d
            r1 = r5
            boolean r0 = r0.a(r1)
            r7 = r0
            r0 = 0
            r6 = r0
            r0 = r7
            if (r0 != 0) goto L14
            r0 = 0
            return r0
        L14:
            r0 = r5
            r1 = r3
            java.lang.Class<?> r1 = r1.y
            boolean r0 = r0.isAutoTrackPageIgnored(r1)
            if (r0 == 0) goto L21
            r0 = 0
            return r0
        L21:
            r0 = r4
            if (r0 == 0) goto L3c
            r0 = r5
            com.bytedance.applog.InitConfig r0 = r0.getInitConfig()
            if (r0 == 0) goto L38
            r0 = r6
            r4 = r0
            r0 = r5
            com.bytedance.applog.InitConfig r0 = r0.getInitConfig()
            boolean r0 = r0.isAutoTrackFragmentEnabled()
            if (r0 == 0) goto L3a
        L38:
            r0 = 1
            r4 = r0
        L3a:
            r0 = r4
            return r0
        L3c:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.o.a(com.bytedance.bdtracker.c2, boolean, com.bytedance.bdtracker.c):boolean");
    }

    public static /* synthetic */ String b(Activity activity) {
        StringBuilder a2 = a.a("onActivityResumed ");
        a2.append(t2.b(activity));
        return a2.toString();
    }

    public static void b(Object obj) {
        if (obj == null || h == obj) {
            return;
        }
        if (obj != null && f21272a.contains(obj.getClass().getName())) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String str = currentTimeMillis - i < 300 ? j : currentTimeMillis - e < 300 ? f : null;
        String name = obj.getClass().getName();
        Class<?> cls = obj.getClass();
        Activity activity = null;
        if (t2.d(obj)) {
            try {
                activity = (Activity) obj.getClass().getMethod("getActivity", new Class[0]).invoke(obj, new Object[0]);
            } catch (Throwable th) {
                activity = null;
            }
        }
        d = a(cls, true, activity != null ? activity.getClass().getName() : "", name, t2.b(obj), t2.a(obj), currentTimeMillis, str, t2.c(obj));
        h = obj;
    }

    public void a(Activity activity, int i2) {
        c2 a2 = a(activity.getClass(), false, activity.getClass().getName(), "", t2.b(activity), t2.a(activity), System.currentTimeMillis(), f, t2.c(activity));
        f21273c = a2;
        a2.w = !m.remove(Integer.valueOf(i2)) ? 1 : 0;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        m.add(Integer.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        m.remove(Integer.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(final Activity activity) {
        z2.a(new z2.a() { // from class: com.bytedance.bdtracker.-$$Lambda$pUECAkxopq7B6O3We2D7jc3Annw
            @Override // com.bytedance.bdtracker.z2.a
            public final String a() {
                return o.a(Activity.this);
            }
        });
        if (d != null) {
            a(h);
        }
        c2 c2Var = f21273c;
        if (c2Var != null) {
            f = c2Var.r;
            long currentTimeMillis = System.currentTimeMillis();
            e = currentTimeMillis;
            a(false, f21273c, currentTimeMillis);
            f21273c = null;
            if (activity == null || activity.isChild()) {
                return;
            }
            g = null;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(final Activity activity) {
        z2.a(new z2.a() { // from class: com.bytedance.bdtracker.-$$Lambda$BrEj5jKoKtp3fEgDCeX8WDVpqas
            @Override // com.bytedance.bdtracker.z2.a
            public final String a() {
                return o.b(Activity.this);
            }
        });
        c2 a2 = a(activity.getClass(), false, activity.getClass().getName(), "", t2.b(activity), t2.a(activity), System.currentTimeMillis(), f, t2.c(activity));
        f21273c = a2;
        a2.w = !m.remove(Integer.valueOf(activity.hashCode())) ? 1 : 0;
        if (activity.isChild()) {
            return;
        }
        activity.getWindow().getDecorView().hashCode();
        g = activity;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        b++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (f != null) {
            int i2 = b - 1;
            b = i2;
            if (i2 <= 0) {
                f = null;
                j = null;
                i = 0L;
                e = 0L;
            }
        }
    }
}
