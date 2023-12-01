package com.blued.android.module.shortvideo.view;

import android.app.ProgressDialog;
import android.content.Context;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/view/CustomProgressDialog.class */
public class CustomProgressDialog extends ProgressDialog {
    public CustomProgressDialog(Context context) {
        super(context);
        setMessage("处理中...");
        setMax(100);
        setProgressStyle(1);
        setCanceledOnTouchOutside(false);
        setCancelable(true);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        super.cancel();
        setProgress(0);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        setProgress(0);
    }
}
