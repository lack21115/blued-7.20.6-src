package com.blued.android.core.utils.swipeback;

import android.app.Activity;
import com.blued.android.core.utils.swipeback.SwipeBackLayout;
import java.lang.ref.WeakReference;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/swipeback/SwipeBackListenerActivityAdapter.class */
public class SwipeBackListenerActivityAdapter implements SwipeBackLayout.SwipeListenerEx {
    private final WeakReference<Activity> a;

    @Override // com.blued.android.core.utils.swipeback.SwipeBackLayout.SwipeListener
    public void a() {
    }

    @Override // com.blued.android.core.utils.swipeback.SwipeBackLayout.SwipeListener
    public void a(int i) {
        Activity activity;
        WeakReference<Activity> weakReference = this.a;
        if (weakReference == null || (activity = weakReference.get()) == null) {
            return;
        }
        SwipeBackUtils.a(activity);
    }

    @Override // com.blued.android.core.utils.swipeback.SwipeBackLayout.SwipeListener
    public void a(int i, float f) {
    }

    @Override // com.blued.android.core.utils.swipeback.SwipeBackLayout.SwipeListener
    public void a(int i, int i2, float f, float f2, float f3) {
    }

    @Override // com.blued.android.core.utils.swipeback.SwipeBackLayout.SwipeListenerEx
    public void b() {
        Activity activity;
        WeakReference<Activity> weakReference = this.a;
        if (weakReference == null || (activity = weakReference.get()) == null || activity.isFinishing()) {
            return;
        }
        activity.finish();
        activity.overridePendingTransition(0, 0);
    }
}
