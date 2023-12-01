package com.tencent.tmsbeacon.c.a;

import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.tmsbeacon.a.c.e;
import com.tencent.tmsbeacon.a.c.f;
import com.tencent.tmsbeacon.a.d.a;
import com.tencent.tmsbeacon.module.StatModule;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/c/a/c.class */
public class c implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private static SparseArray<WeakReference<Activity>> f25841a = new SparseArray<>();
    private boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private long f25842c = 0;
    private long d = 0;
    private long e = 20000;
    private String f = "";
    private Map<String, String> g;
    private StatModule h;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/c/a/c$a.class */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e l = e.l();
            f e = f.e();
            c.this.g.put("A19", l.q());
            c.this.g.put("A85", com.tencent.tmsbeacon.a.c.b.d ? "Y" : "N");
            c.this.g.put("A20", e.j());
            c.this.g.put("A69", e.k());
            c.this.h.a(c.this.g);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/c/a/c$b.class */
    public class b implements Runnable {
        public final /* synthetic */ Activity b;

        public b(Activity activity) {
            this.b = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            new com.tencent.tmsbeacon.c.c(this.b.getApplicationContext()).a();
        }
    }

    public c(StatModule statModule) {
        this.h = statModule;
        HashMap hashMap = new HashMap(6);
        this.g = hashMap;
        hashMap.put("A63", "N");
        this.g.put("A66", "F");
    }

    private long a() {
        if (this.e <= 20000) {
            String b2 = com.tencent.tmsbeacon.d.a.a().b("hotLauncher");
            if (b2 != null) {
                try {
                    this.e = Long.valueOf(b2).longValue();
                    com.tencent.tmsbeacon.base.util.c.a("[strategy] -> change launcher time: %s ms", b2);
                } catch (NumberFormatException e) {
                    com.tencent.tmsbeacon.base.util.c.b("[strategy] -> event param 'hotLauncher' error.", new Object[0]);
                }
            }
            this.e++;
        }
        return this.e;
    }

    private void a(Activity activity) {
        com.tencent.tmsbeacon.a.c.b.d = true;
        b(activity);
        if (!this.b) {
            com.tencent.tmsbeacon.base.util.c.a("[event] lifecycle callback recover active user.", new Object[0]);
            com.tencent.tmsbeacon.a.b.a.a().a(new b(activity));
            this.b = true;
        }
        if (b()) {
            c();
        }
    }

    private void a(boolean z, Activity activity) {
        if (z) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f25842c > 0) {
                long j = this.d;
                if (j > 0 && j + a() <= currentTimeMillis) {
                    com.tencent.tmsbeacon.base.util.c.a("[lifecycle] -> return foreground more than 20s.", new Object[0]);
                    c();
                    StatModule statModule = this.h;
                    if (statModule != null) {
                        statModule.a();
                    }
                }
            }
            this.f25842c = currentTimeMillis;
            this.d = 0L;
            return;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        this.d = currentTimeMillis2;
        long j2 = this.f25842c;
        if (800 + j2 > currentTimeMillis2) {
            com.tencent.tmsbeacon.base.util.c.a("[lifecycle] -> debounce activity switch.", new Object[0]);
            this.f25842c = 0L;
            return;
        }
        if (j2 == 0) {
            this.f25842c = currentTimeMillis2;
        }
        StatModule statModule2 = this.h;
        if (statModule2 != null) {
            statModule2.b();
        }
    }

    private static void b(Activity activity) {
        if (activity == null || f25841a == null) {
            return;
        }
        int hashCode = activity.hashCode();
        if (f25841a.get(hashCode) == null) {
            f25841a.put(hashCode, new WeakReference<>(activity));
        }
    }

    private boolean b() {
        String d = com.tencent.tmsbeacon.base.util.b.d();
        if ("".equals(this.f)) {
            this.f = com.tencent.tmsbeacon.a.d.a.a().getString("LAUEVE_DENGTA", "");
        }
        boolean z = false;
        if (!d.equals(this.f)) {
            a.SharedPreferences$EditorC0861a edit = com.tencent.tmsbeacon.a.d.a.a().edit();
            if (com.tencent.tmsbeacon.base.util.b.a((SharedPreferences.Editor) edit)) {
                edit.putString("LAUEVE_DENGTA", d);
            }
            z = false;
            if (!"".equals(this.f)) {
                com.tencent.tmsbeacon.base.util.c.a("[core] -> report new day launcher event.", new Object[0]);
                z = true;
            }
            this.f = d;
        }
        return z;
    }

    private void c() {
        com.tencent.tmsbeacon.a.b.a.a().a(new a());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        a(activity);
        a(true, activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        a(activity);
        a(false, activity);
    }
}
