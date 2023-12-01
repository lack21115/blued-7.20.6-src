package com.tencent.beacon.d.a;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.tencent.beacon.module.StatModule;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/d/a/d.class */
public class d implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private long f21317a = System.currentTimeMillis();
    private Map<Activity, Long> b = new HashMap(3);

    /* renamed from: c  reason: collision with root package name */
    private StatModule f21318c;

    public d(StatModule statModule) {
        this.f21318c = statModule;
    }

    private void a(Activity activity) {
        Long l = this.b.get(activity);
        Long l2 = l;
        if (l == null) {
            l2 = Long.valueOf(this.f21317a);
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.f21318c.b(activity.getLocalClassName(), currentTimeMillis - l2.longValue(), currentTimeMillis);
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
