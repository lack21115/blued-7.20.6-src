package com.blued.android.core.utils.toast;

import android.app.Application;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/toast/WindowToast.class */
public class WindowToast extends CustomToast {

    /* renamed from: a  reason: collision with root package name */
    private final ToastImpl f9769a;

    public WindowToast(Application application) {
        this.f9769a = new ToastImpl(application, (CustomToast) this);
    }

    @Override // com.blued.android.core.utils.toast.config.IToast
    public void cancel() {
        this.f9769a.c();
    }

    @Override // com.blued.android.core.utils.toast.config.IToast
    public void show() {
        this.f9769a.b();
    }
}
