package com.blued.android.module.yy_china.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogYyPopBinding;
import com.blued.android.module.yy_china.fragment.BaseFullScreenDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/PopYyDialog.class */
public final class PopYyDialog extends BaseFullScreenDialog {
    private DialogYyPopBinding a;
    private PopYyDialogGetView b;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(PopYyDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    private final void g() {
        ImageView imageView;
        FrameLayout frameLayout;
        PopYyDialogGetView popYyDialogGetView = this.b;
        if (popYyDialogGetView != null) {
            View a = popYyDialogGetView.a();
            DialogYyPopBinding f = f();
            if (f != null && (frameLayout = f.a) != null) {
                frameLayout.addView(a, popYyDialogGetView.b());
            }
            a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$PopYyDialog$mONO5Xz5H_5dbWAmkkPttpnhTEw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PopYyDialog.a(view);
                }
            });
        }
        DialogYyPopBinding dialogYyPopBinding = this.a;
        if (dialogYyPopBinding == null || (imageView = dialogYyPopBinding.b) == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$PopYyDialog$_gA-Ou3ehFyJ_UYu4VwGyDEa0TQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopYyDialog.a(PopYyDialog.this, view);
            }
        });
    }

    public final void a(PopYyDialogGetView popYyDialogGetView) {
        this.b = popYyDialogGetView;
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog
    public boolean d() {
        PopYyDialogGetView popYyDialogGetView = this.b;
        if (popYyDialogGetView == null) {
            return false;
        }
        return popYyDialogGetView.c();
    }

    public final DialogYyPopBinding f() {
        return this.a;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        this.a = DialogYyPopBinding.a(inflater.inflate(R.layout.dialog_yy_pop, viewGroup, true));
        g();
        DialogYyPopBinding dialogYyPopBinding = this.a;
        return dialogYyPopBinding == null ? null : dialogYyPopBinding.getRoot();
    }
}
