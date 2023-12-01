package com.tencent.tendinsv.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/utils/j.class */
public final class j implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private static volatile j f39099a;
    private final List<a> b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<Activity> f39100c;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/utils/j$a.class */
    public interface a {
        void a(Activity activity);
    }

    private j() {
    }

    public static j a() {
        if (f39099a == null) {
            synchronized (j.class) {
                try {
                    if (f39099a == null) {
                        f39099a = new j();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f39099a;
    }

    public void a(Application application, a aVar) {
        this.b.add(aVar);
        application.registerActivityLifecycleCallbacks(this);
    }

    public void b(Application application, a aVar) {
        this.b.remove(aVar);
        application.unregisterActivityLifecycleCallbacks(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        l.a(com.tencent.tendinsv.b.G, "onActivityCreated name", ((Activity) new WeakReference(activity).get()).getComponentName().getClassName());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        l.a(com.tencent.tendinsv.b.G, "onActivityDestroyed name", ((Activity) new WeakReference(activity).get()).getComponentName().getClassName());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        l.a(com.tencent.tendinsv.b.G, "onActivityPaused name", ((Activity) new WeakReference(activity).get()).getComponentName().getClassName());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.f39100c = new WeakReference<>(activity);
        l.a(com.tencent.tendinsv.b.G, "onActivityResumed name", ((Activity) new WeakReference(activity).get()).getComponentName().getClassName());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        l.a(com.tencent.tendinsv.b.G, "onSaveInstanceState name", ((Activity) new WeakReference(activity).get()).getComponentName().getClassName());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        l.a(com.tencent.tendinsv.b.G, "onActivityStarted name", activity.getComponentName().getClassName());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        try {
            l.a(com.tencent.tendinsv.b.G, "onActivityStopped name", activity.getComponentName().getClassName());
            if (this.f39100c == null || this.f39100c.equals(new WeakReference(activity))) {
                for (a aVar : this.b) {
                    if (aVar != null) {
                        aVar.a(activity);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
