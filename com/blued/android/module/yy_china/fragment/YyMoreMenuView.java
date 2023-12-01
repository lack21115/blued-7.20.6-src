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

    /* renamed from: a  reason: collision with root package name */
    private DialogYyMoreMenuBinding f17495a;
    private View.OnClickListener b;

    /* renamed from: c  reason: collision with root package name */
    private BaseYYStudioFragment f17496c;

    private final void f() {
        ImageView imageView;
        YYMoreMenuView yYMoreMenuView;
        YYMoreMenuView yYMoreMenuView2;
        DialogYyMoreMenuBinding dialogYyMoreMenuBinding = this.f17495a;
        if (dialogYyMoreMenuBinding != null && (yYMoreMenuView2 = dialogYyMoreMenuBinding.b) != null) {
            yYMoreMenuView2.a(this.f17496c, getResources().getString(R.string.yy_leave_room));
        }
        DialogYyMoreMenuBinding dialogYyMoreMenuBinding2 = this.f17495a;
        if (dialogYyMoreMenuBinding2 != null && (yYMoreMenuView = dialogYyMoreMenuBinding2.b) != null) {
            yYMoreMenuView.setShutdownLisenter(this.b);
        }
        DialogYyMoreMenuBinding dialogYyMoreMenuBinding3 = this.f17495a;
        if (dialogYyMoreMenuBinding3 == null || (imageView = dialogYyMoreMenuBinding3.f16440a) == null) {
            return;
        }
        imageView.setOnClickListener(this);
    }

    public final void a(BaseYYStudioFragment fragment, View.OnClickListener lisenter) {
        Intrinsics.e(fragment, "fragment");
        Intrinsics.e(lisenter, "lisenter");
        this.f17496c = fragment;
        this.b = lisenter;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment
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

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        this.f17495a = DialogYyMoreMenuBinding.a(inflater, viewGroup, false);
        f();
        DialogYyMoreMenuBinding dialogYyMoreMenuBinding = this.f17495a;
        return dialogYyMoreMenuBinding == null ? null : dialogYyMoreMenuBinding.getRoot();
    }
}
