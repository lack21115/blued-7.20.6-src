package com.anythink.core.common.b;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/b/f.class */
public final class f implements Application.ActivityLifecycleCallbacks {
    int a;
    boolean d;
    boolean c = false;
    ConcurrentHashMap<String, Boolean> b = new ConcurrentHashMap<>(3);

    public f(boolean z) {
        this.d = false;
        if (z) {
            this.d = true;
            a();
        }
    }

    private static void a() {
        com.anythink.core.common.j.c.a();
        com.anythink.core.common.j.a.a(n.a().g()).a(21, new com.anythink.core.common.e.e());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        if (this.d) {
            return;
        }
        this.d = true;
        a();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        n.a().a(activity);
        this.a++;
        this.b.put(activity.toString(), Boolean.TRUE);
        if (this.a != 1 || this.d) {
            return;
        }
        this.d = true;
        a();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        this.a--;
        boolean containsKey = this.b.containsKey(activity.toString());
        if (!this.c && !containsKey) {
            this.c = true;
            this.a++;
        }
        if (containsKey) {
            try {
                this.b.remove(activity.toString());
            } catch (Throwable th) {
            }
        }
        if (this.a == 0) {
            this.d = false;
        }
    }
}
