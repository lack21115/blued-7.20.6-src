package com.blued.android.module.shortvideo.utils;

import android.app.Activity;
import android.content.DialogInterface;
import com.bytedance.applog.tracker.Tracker;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/utils/StvPermissionChecker.class */
public class StvPermissionChecker {

    /* renamed from: a  reason: collision with root package name */
    private Activity f15854a;

    /* renamed from: com.blued.android.module.shortvideo.utils.StvPermissionChecker$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/utils/StvPermissionChecker$1.class */
    class AnonymousClass1 implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f15855a;
        final /* synthetic */ StvPermissionChecker b;

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Tracker.onClick(dialogInterface, i);
            Activity activity = this.b.f15854a;
            List list = this.f15855a;
            activity.requestPermissions((String[]) list.toArray(new String[list.size()]), 124);
        }
    }
}
