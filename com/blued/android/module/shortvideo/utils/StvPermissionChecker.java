package com.blued.android.module.shortvideo.utils;

import android.app.Activity;
import android.content.DialogInterface;
import com.bytedance.applog.tracker.Tracker;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/utils/StvPermissionChecker.class */
public class StvPermissionChecker {
    private Activity a;

    /* renamed from: com.blued.android.module.shortvideo.utils.StvPermissionChecker$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/utils/StvPermissionChecker$1.class */
    class AnonymousClass1 implements DialogInterface.OnClickListener {
        final /* synthetic */ List a;
        final /* synthetic */ StvPermissionChecker b;

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Tracker.onClick(dialogInterface, i);
            Activity activity = this.b.a;
            List list = this.a;
            activity.requestPermissions((String[]) list.toArray(new String[list.size()]), 124);
        }
    }
}
