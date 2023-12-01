package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import com.bytedance.applog.tracker.Tracker;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/common/internal/DialogRedirect.class */
public abstract class DialogRedirect implements DialogInterface.OnClickListener {
    public static DialogRedirect getInstance(Activity activity, Intent intent, int i) {
        return new DialogRedirectImpl(intent, activity, i);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        try {
            redirect();
        } catch (Throwable th) {
            try {
                HMSLog.e("DialogRedirect", "Failed to start resolution intent");
            } finally {
                dialogInterface.dismiss();
            }
        }
    }

    protected abstract void redirect();
}
