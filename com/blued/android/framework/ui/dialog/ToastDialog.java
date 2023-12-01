package com.blued.android.framework.ui.dialog;

import android.app.Dialog;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/dialog/ToastDialog.class */
public class ToastDialog {

    /* renamed from: a  reason: collision with root package name */
    private Dialog f9893a;
    private OnFinishListener b;

    /* renamed from: com.blued.android.framework.ui.dialog.ToastDialog$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/dialog/ToastDialog$1.class */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ToastDialog f9894a;

        @Override // java.lang.Runnable
        public void run() {
            if (this.f9894a.f9893a == null || !this.f9894a.f9893a.isShowing()) {
                return;
            }
            this.f9894a.f9893a.dismiss();
            if (this.f9894a.b != null) {
                this.f9894a.b.a();
            }
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/dialog/ToastDialog$OnFinishListener.class */
    public interface OnFinishListener {
        void a();
    }
}
