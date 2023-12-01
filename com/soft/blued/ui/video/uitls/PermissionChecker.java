package com.soft.blued.ui.video.uitls;

import android.app.Activity;
import android.content.DialogInterface;
import com.bytedance.applog.tracker.Tracker;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/video/uitls/PermissionChecker.class */
public class PermissionChecker {

    /* renamed from: a  reason: collision with root package name */
    private Activity f34467a;

    /* renamed from: com.soft.blued.ui.video.uitls.PermissionChecker$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/video/uitls/PermissionChecker$1.class */
    class AnonymousClass1 implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f34468a;
        final /* synthetic */ PermissionChecker b;

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Tracker.onClick(dialogInterface, i);
            Activity activity = this.b.f34467a;
            List list = this.f34468a;
            activity.requestPermissions((String[]) list.toArray(new String[list.size()]), 124);
        }
    }
}
