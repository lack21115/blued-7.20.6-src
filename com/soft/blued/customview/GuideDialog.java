package com.soft.blued.customview;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import com.blued.android.module.common.utils.BluedSharedPreferences;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.utils.BluedPreferences;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/GuideDialog.class */
public class GuideDialog extends Dialog {

    /* renamed from: com.soft.blued.customview.GuideDialog$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/GuideDialog$1.class */
    class AnonymousClass1 implements DialogInterface.OnDismissListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f14736a;

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            GuideDialog.a(this.f14736a);
        }
    }

    /* renamed from: com.soft.blued.customview.GuideDialog$2  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/GuideDialog$2.class */
    class AnonymousClass2 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f14737a;
        final /* synthetic */ GuideDialog b;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            GuideDialog.a(this.f14737a);
            this.b.dismiss();
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/GuideDialog$GUIDE_KEY.class */
    public interface GUIDE_KEY {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/GuideDialog$GuideKeyDef.class */
    public @interface GuideKeyDef {
    }

    public static void a(String str) {
        BluedSharedPreferences.Editor c2 = BluedPreferences.c().c();
        c2.a(GuideDialog.class.getName() + str, true).a();
    }
}
