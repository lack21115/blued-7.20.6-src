package com.blued.android.core.utils.toast;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/toast/WindowLifecycle.class */
public final class WindowLifecycle implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private Activity f9767a;
    private Application b;

    /* renamed from: c  reason: collision with root package name */
    private ToastImpl f9768c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WindowLifecycle(Activity activity) {
        this.f9767a = activity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WindowLifecycle(Application application) {
        this.b = application;
    }

    public WindowManager a() {
        if (this.f9767a != null) {
            if (Build.VERSION.SDK_INT < 17 || !this.f9767a.isDestroyed()) {
                return this.f9767a.getWindowManager();
            }
            return null;
        }
        Application application = this.b;
        if (application != null) {
            return (WindowManager) application.getSystemService(Context.WINDOW_SERVICE);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ToastImpl toastImpl) {
        this.f9768c = toastImpl;
        if (this.f9767a == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f9767a.registerActivityLifecycleCallbacks(this);
        } else {
            this.f9767a.getApplication().registerActivityLifecycleCallbacks(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f9768c = null;
        if (this.f9767a == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f9767a.unregisterActivityLifecycleCallbacks(this);
        } else {
            this.f9767a.getApplication().unregisterActivityLifecycleCallbacks(this);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (this.f9767a != activity) {
            return;
        }
        ToastImpl toastImpl = this.f9768c;
        if (toastImpl != null) {
            toastImpl.c();
        }
        b();
        this.f9767a = null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        ToastImpl toastImpl;
        if (this.f9767a == activity && (toastImpl = this.f9768c) != null) {
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
