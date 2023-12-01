package com.blued.android.module.yy_china.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogYyMoreMenuBinding;
import com.blued.android.module.yy_china.view.YYMoreMenuView;
import com.bytedance.applog.tracker.Tracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YyMoreMenuView.class */
public final class YyMoreMenuView extends BaseFullScreenDialog implements View.OnClickListener {
    private DialogYyMoreMenuBinding a;
    private View.OnClickListener b;
    private BaseYYStudioFragment c;

    private final void f() {
        ImageView imageView;
        YYMoreMenuView yYMoreMenuView;
        YYMoreMenuView yYMoreMenuView2;
        DialogYyMoreMenuBinding dialogYyMoreMenuBinding = this.a;
        if (dialogYyMoreMenuBinding != null && (yYMoreMenuView2 = dialogYyMoreMenuBinding.b) != null) {
            yYMoreMenuView2.a(this.c, getResources().getString(R.string.yy_leave_room));
        }
        DialogYyMoreMenuBinding dialogYyMoreMenuBinding2 = this.a;
        if (dialogYyMoreMenuBinding2 != null && (yYMoreMenuView = dialogYyMoreMenuBinding2.b) != null) {
            yYMoreMenuView.setShutdownLisenter(this.b);
        }
        DialogYyMoreMenuBinding dialogYyMoreMenuBinding3 = this.a;
        if (dialogYyMoreMenuBinding3 == null || (imageView = dialogYyMoreMenuBinding3.a) == null) {
            return;
        }
        imageView.setOnClickListener(this);
    }

    public final void a(BaseYYStudioFragment fragment, View.OnClickListener lisenter) {
        Intrinsics.e(fragment, "fragment");
        Intrinsics.e(lisenter, "lisenter");
        this.c = fragment;
        this.b = lisenter;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        dismiss();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        Intrinsics.c(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        Window window = onCreateDialog.getWindow();
        if (window == null) {
            return onCreateDialog;
        }
        window.setWindowAnimations(R.style.yy_pop_right_in_anim);
        return onCreateDialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        this.a = DialogYyMoreMenuBinding.a(inflater, viewGroup, false);
        f();
        DialogYyMoreMenuBinding dialogYyMoreMenuBinding = this.a;
        return dialogYyMoreMenuBinding == null ? null : dialogYyMoreMenuBinding.getRoot();
    }
}
