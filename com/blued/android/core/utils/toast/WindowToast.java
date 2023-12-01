package com.blued.android.core.utils.toast;

import android.app.Application;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/toast/WindowToast.class */
public class WindowToast extends CustomToast {
    private final ToastImpl a;

    public WindowToast(Application application) {
        this.a = new ToastImpl(application, (CustomToast) this);
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
