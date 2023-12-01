package com.blued.android.framework.ui.dialog;

import android.content.DialogInterface;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/dialog/LoadingDialog.class */
public class LoadingDialog implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    private OnCancelListener f9892a;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/dialog/LoadingDialog$OnCancelListener.class */
    public interface OnCancelListener {
        void a();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        OnCancelListener onCancelListener = this.f9892a;
        if (onCancelListener != null) {
            onCancelListener.a();
        }
    }
}
