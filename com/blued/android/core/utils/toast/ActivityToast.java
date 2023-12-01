package com.blued.android.core.utils.toast;

import android.app.Activity;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/toast/ActivityToast.class */
public class ActivityToast extends CustomToast {

    /* renamed from: a  reason: collision with root package name */
    private final ToastImpl f9749a;

    public ActivityToast(Activity activity) {
        this.f9749a = new ToastImpl(activity, (CustomToast) this);
    }

    @Override // com.blued.android.core.utils.toast.config.IToast
    public void cancel() {
        this.f9749a.c();
    }

    @Override // com.blued.android.core.utils.toast.config.IToast
    public void show() {
        this.f9749a.b();
    }
}
