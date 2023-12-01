package com.blued.android.framework.ui.dialog;

import android.content.DialogInterface;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/dialog/LoadingDialog.class */
public class LoadingDialog implements DialogInterface.OnCancelListener {
    private OnCancelListener a;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/dialog/LoadingDialog$OnCancelListener.class */
    public interface OnCancelListener {
        void a();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        OnCancelListener onCancelListener = this.a;
        if (onCancelListener != null) {
            onCancelListener.a();
        }
    }
}
