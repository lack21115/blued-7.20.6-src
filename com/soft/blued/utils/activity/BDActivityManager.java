package com.soft.blued.utils.activity;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import com.igexin.push.core.b;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/activity/BDActivityManager.class */
public final class BDActivityManager implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    public static final BDActivityManager f34819a = new BDActivityManager();
    private static final Object b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private Application f34820c;
    private final List<Activity> d = new ArrayList();
    private final List<IActivityResumedCallback> e = new ArrayList();
    private final List<IActivityPausedCallback> f = new ArrayList();
    private final List<IActivityDestroyedCallback> g = new ArrayList();

    private BDActivityManager() {
    }

    static String a(Object obj) {
        if (obj == null) {
            return b.l;
        }
        return obj.getClass().getName() + '@' + Integer.toHexString(obj.hashCode());
    }

    private void a(Activity activity) {
        synchronized (b) {
            this.d.remove(activity);
        }
    }

    private void b(Activity activity) {
        synchronized (b) {
            int indexOf = this.d.indexOf(activity);
            if (indexOf == -1) {
                this.d.add(activity);
            } else if (indexOf < this.d.size() - 1) {
                this.d.remove(activity);
                this.d.add(activity);
            }
        }
    }

    private Activity c() {
        synchronized (b) {
            if (this.d.size() > 0) {
                return this.d.get(this.d.size() - 1);
            }
            return null;
        }
    }

    public Activity a() {
        return c();
    }

    public void a(Application application, Activity activity) {
        Log.d("ActivityManager", "init");
        Application application2 = this.f34820c;
        if (application2 != null) {
            application2.unregisterActivityLifecycleCallbacks(this);
        }
        this.f34820c = application;
        b(activity);
        application.registerActivityLifecycleCallbacks(this);
    }

    public List<Activity> b() {
        return this.d;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Log.d("ActivityManager", "onCreated:" + a((Object) activity));
        b(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Log.d("ActivityManager", "onDestroyed:" + a((Object) activity));
        a(activity);
        for (IActivityDestroyedCallback iActivityDestroyedCallback : new ArrayList(this.g)) {
            iActivityDestroyedCallback.a(activity, c());
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Log.d("ActivityManager", "onPaused:" + a((Object) activity));
        for (IActivityPausedCallback iActivityPausedCallback : new ArrayList(this.f)) {
            iActivityPausedCallback.a(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Log.d("ActivityManager", "onResumed:" + a((Object) activity));
        b(activity);
        for (IActivityResumedCallback iActivityResumedCallback : new ArrayList(this.e)) {
            iActivityResumedCallback.a(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Log.d("ActivityManager", "onStarted:" + a((Object) activity));
        b(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Log.d("ActivityManager", "onStopped:" + a((Object) activity));
    }
}
