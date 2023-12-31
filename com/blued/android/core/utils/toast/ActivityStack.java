package com.blued.android.core.utils.toast;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/toast/ActivityStack.class */
final class ActivityStack implements Application.ActivityLifecycleCallbacks {
    private Activity a;

    ActivityStack() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ActivityStack a(Application application) {
        ActivityStack activityStack = new ActivityStack();
        application.registerActivityLifecycleCallbacks(activityStack);
        return activityStack;
    }

    public Activity a() {
        return this.a;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (this.a != activity) {
            return;
        }
        this.a = null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.a = activity;
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
