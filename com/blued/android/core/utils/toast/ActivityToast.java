package com.blued.android.core.utils.toast;

import android.app.Activity;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/toast/ActivityToast.class */
public class ActivityToast extends CustomToast {
    private final ToastImpl a;

    public ActivityToast(Activity activity) {
        this.a = new ToastImpl(activity, (CustomToast) this);
    }

    @Override // com.blued.android.core.utils.toast.config.IToast
    public void cancel() {
        this.a.c();
    }

    @Override // com.blued.android.core.utils.toast.config.IToast
    public void show() {
        this.a.b();
    }
}
