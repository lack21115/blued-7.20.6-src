package com.blued.android.framework.ui.dialog;

import android.app.Dialog;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/dialog/ToastDialog.class */
public class ToastDialog {
    private Dialog a;
    private OnFinishListener b;

    /* renamed from: com.blued.android.framework.ui.dialog.ToastDialog$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/dialog/ToastDialog$1.class */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ ToastDialog a;

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.a == null || !this.a.a.isShowing()) {
                return;
            }
            this.a.a.dismiss();
            if (this.a.b != null) {
                this.a.b.a();
            }
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/dialog/ToastDialog$OnFinishListener.class */
    public interface OnFinishListener {
        void a();
    }
}
