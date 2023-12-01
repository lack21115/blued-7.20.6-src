package com.anythink.core.common.b;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/b/e.class */
public class e implements Application.ActivityLifecycleCallbacks {
    public static final String a = "start_time";
    public static final String b = "end_time";
    public static final String c = "psid";
    public static final String d = "launch_mode";
    public static final int e = 0;
    public static final int f = 1;
    long g;
    JSONObject i;
    private final String l = e.class.getName();
    Handler j = new Handler(Looper.getMainLooper());
    Runnable k = new Runnable() { // from class: com.anythink.core.common.b.e.1
        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.b.e.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.a();
                }
            });
        }
    };
    int h = 0;

    public e(long j) {
        this.g = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        synchronized (this) {
            if (this.i != null) {
                Context g = n.a().g();
                com.anythink.core.common.k.p.a(g, g.o, n.a().p() + "playRecord", "");
                this.g = 0L;
                JSONObject jSONObject = this.i;
                long optLong = jSONObject.optLong(a);
                long optLong2 = jSONObject.optLong(b);
                String optString = jSONObject.optString(c);
                int optInt = jSONObject.optInt(d);
                this.i = null;
                com.anythink.core.common.j.c.a(optInt == 1 ? 3 : 1, optLong, optLong2, optString);
                new StringBuilder("Time up to send application playTime, reset playStartTime and send agent, playtime:").append((optLong2 - optLong) / 1000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        synchronized (this) {
            this.j.removeCallbacks(this.k);
            com.anythink.core.c.a b2 = com.anythink.core.c.b.a(n.a().g()).b(n.a().p());
            if (this.i != null) {
                JSONObject jSONObject = this.i;
                long optLong = jSONObject.optLong(a);
                long optLong2 = jSONObject.optLong(b);
                String optString = jSONObject.optString(c);
                int optInt = jSONObject.optInt(d);
                if (System.currentTimeMillis() - optLong2 > b2.B()) {
                    new StringBuilder("onActivityResumed : Time countdown is closed, time up to send agent and create new psid, playtime:").append((optLong2 - optLong) / 1000);
                    Context g = n.a().g();
                    com.anythink.core.common.k.p.a(g, g.o, n.a().p() + "playRecord", "");
                    com.anythink.core.common.j.c.a(optInt == 1 ? 3 : 1, optLong, optLong2, optString);
                    this.g = 0L;
                }
            }
            this.i = null;
            if (this.g == 0) {
                this.h = 1;
                try {
                    this.g = n.a().a(n.a().g(), n.a().p(), 1);
                } catch (Exception e2) {
                }
            } else {
                String p = n.a().p();
                Context g2 = n.a().g();
                com.anythink.core.common.k.p.a(g2, g.o, p + "playRecord", "");
            }
            if (this.g == 0) {
                this.g = System.currentTimeMillis();
            }
            new StringBuilder("onActivityResumed: Method use time:").append(System.currentTimeMillis() - j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00d1 -> B:7:0x0090). Please submit an issue!!! */
    public void b() {
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis();
            String p = n.a().p();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(c, n.a().r());
                jSONObject.put(a, this.g);
                jSONObject.put(b, System.currentTimeMillis());
                jSONObject.put(d, this.h);
                this.i = jSONObject;
                Context g = n.a().g();
                com.anythink.core.common.k.p.a(g, g.o, p + "playRecord", jSONObject.toString());
                new StringBuilder("onActivityPaused: record leave time:").append(jSONObject.toString());
            } catch (Exception e2) {
            }
            com.anythink.core.c.a b2 = com.anythink.core.c.b.a(n.a().g()).b(p);
            if (b2.D() == 1) {
                this.j.postDelayed(this.k, b2.B());
            }
            new StringBuilder("onActivityPaused: Method use time:").append(System.currentTimeMillis() - currentTimeMillis);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.b.e.3
            @Override // java.lang.Runnable
            public final void run() {
                e.this.b();
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        final long currentTimeMillis = System.currentTimeMillis();
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.b.e.2
            @Override // java.lang.Runnable
            public final void run() {
                e.this.a(currentTimeMillis);
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }
}
