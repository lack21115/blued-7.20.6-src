package com.blued.android.framework.qrcode.decoding;

import android.app.Activity;
import android.content.DialogInterface;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-8756600-dex2jar.jar:com/blued/android/framework/qrcode/decoding/FinishListener.class */
public final class FinishListener implements DialogInterface.OnCancelListener, DialogInterface.OnClickListener, Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f9874a;

    public FinishListener(Activity activity) {
        this.f9874a = activity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        run();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        run();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9874a.finish();
    }
}
