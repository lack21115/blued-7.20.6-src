package com.blued.android.core.utils.toast;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/toast/WindowLifecycle.class */
public final class WindowLifecycle implements Application.ActivityLifecycleCallbacks {
    private Activity a;
    private Application b;
    private ToastImpl c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WindowLifecycle(Activity activity) {
        this.a = activity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WindowLifecycle(Application application) {
        this.b = application;
    }

    public WindowManager a() {
        if (this.a != null) {
            if (Build.VERSION.SDK_INT < 17 || !this.a.isDestroyed()) {
                return this.a.getWindowManager();
            }
            return null;
        }
        Application application = this.b;
        if (application != null) {
            return (WindowManager) application.getSystemService("window");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ToastImpl toastImpl) {
        this.c = toastImpl;
        if (this.a == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.a.registerActivityLifecycleCallbacks(this);
        } else {
            this.a.getApplication().registerActivityLifecycleCallbacks(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.c = null;
        if (this.a == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.a.unregisterActivityLifecycleCallbacks(this);
        } else {
            this.a.getApplication().unregisterActivityLifecycleCallbacks(this);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (this.a != activity) {
            return;
        }
        ToastImpl toastImpl = this.c;
        if (toastImpl != null) {
            toastImpl.c();
        }
        b();
        this.a = null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        ToastImpl toastImpl;
        if (this.a == activity && (toastImpl = this.c) != null) {
            toastImpl.c();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
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
