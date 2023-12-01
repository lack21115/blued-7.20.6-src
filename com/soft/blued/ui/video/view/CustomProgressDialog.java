package com.soft.blued.ui.video.view;

import android.app.ProgressDialog;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/video/view/CustomProgressDialog.class */
public class CustomProgressDialog extends ProgressDialog {
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
