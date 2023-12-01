package com.tencent.tmsbeacon.c.a;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.tencent.tmsbeacon.module.StatModule;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/c/a/d.class */
public class d implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private long f39535a = System.currentTimeMillis();
    private Map<Activity, Long> b = new HashMap(3);

    /* renamed from: c  reason: collision with root package name */
    private StatModule f39536c;

    public d(StatModule statModule) {
        this.f39536c = statModule;
    }

    private void a(Activity activity) {
        Long l = this.b.get(activity);
        Long l2 = l;
        if (l == null) {
            l2 = Long.valueOf(this.f39535a);
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.f39536c.b(activity.getLocalClassName(), currentTimeMillis - l2.longValue(), currentTimeMillis);
        this.b.remove(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.b.put(activity, Long.valueOf(System.currentTimeMillis()));
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
