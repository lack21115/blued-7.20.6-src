package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogYyCloseMenuBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYCloseMenuDialog.class */
public final class YYCloseMenuDialog extends BaseFullScreenDialog {
    private BaseYYStudioFragment a;
    private View.OnClickListener b;
    private DialogYyCloseMenuBinding c;

    public YYCloseMenuDialog(BaseYYStudioFragment baseYYStudioFragment, View.OnClickListener onClickListener) {
        this.a = baseYYStudioFragment;
        this.b = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYCloseMenuDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.g();
        View.OnClickListener onClickListener = this$0.b;
        if (onClickListener == null) {
            return;
        }
        onClickListener.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYCloseMenuDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        BaseYYStudioFragment baseYYStudioFragment = this$0.a;
        if (baseYYStudioFragment == null) {
            return;
        }
        this$0.g();
        baseYYStudioFragment.onBackPressed();
        FragmentActivity activity = baseYYStudioFragment.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YYCloseMenuDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.g();
    }

    private final void f() {
        View view;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        DialogYyCloseMenuBinding dialogYyCloseMenuBinding = this.c;
        if (dialogYyCloseMenuBinding != null && (linearLayout2 = dialogYyCloseMenuBinding.d) != null) {
            linearLayout2.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYCloseMenuDialog$Jo6RLadeSkxiJFkZy4uz6RtQbJs
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYCloseMenuDialog.a(YYCloseMenuDialog.this, view2);
                }
            }));
        }
        DialogYyCloseMenuBinding dialogYyCloseMenuBinding2 = this.c;
        if (dialogYyCloseMenuBinding2 != null && (linearLayout = dialogYyCloseMenuBinding2.b) != null) {
            linearLayout.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYCloseMenuDialog$TuBspoAOsNaZFMcAp9Q11Pp4Y0w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYCloseMenuDialog.b(YYCloseMenuDialog.this, view2);
                }
            }));
        }
        DialogYyCloseMenuBinding dialogYyCloseMenuBinding3 = this.c;
        if (dialogYyCloseMenuBinding3 == null || (view = dialogYyCloseMenuBinding3.a) == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYCloseMenuDialog$lxnk2uHsKU3AyAjTNI22ynmsL7o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYCloseMenuDialog.c(YYCloseMenuDialog.this, view2);
            }
        });
    }

    private final void g() {
        ConstraintLayout constraintLayout;
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.push_top_out2);
        loadAnimation.setFillAfter(true);
        DialogYyCloseMenuBinding dialogYyCloseMenuBinding = this.c;
        ConstraintLayout constraintLayout2 = dialogYyCloseMenuBinding == null ? null : dialogYyCloseMenuBinding.c;
        if (constraintLayout2 != null) {
            constraintLayout2.setVisibility(8);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.yy_china.fragment.YYCloseMenuDialog$cancelDialog$1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                YYCloseMenuDialog.this.dismissAllowingStateLoss();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        DialogYyCloseMenuBinding dialogYyCloseMenuBinding2 = this.c;
        if (dialogYyCloseMenuBinding2 == null || (constraintLayout = dialogYyCloseMenuBinding2.c) == null) {
            return;
        }
        constraintLayout.startAnimation(loadAnimation);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        this.c = DialogYyCloseMenuBinding.a(inflater, viewGroup, false);
        f();
        DialogYyCloseMenuBinding dialogYyCloseMenuBinding = this.c;
        return dialogYyCloseMenuBinding == null ? null : dialogYyCloseMenuBinding.getRoot();
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment
    public void onViewCreated(View view, Bundle bundle) {
        ConstraintLayout constraintLayout;
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.push_top_in2);
        loadAnimation.setFillAfter(true);
        DialogYyCloseMenuBinding dialogYyCloseMenuBinding = this.c;
        ConstraintLayout constraintLayout2 = dialogYyCloseMenuBinding == null ? null : dialogYyCloseMenuBinding.c;
        if (constraintLayout2 != null) {
            constraintLayout2.setVisibility(0);
        }
        DialogYyCloseMenuBinding dialogYyCloseMenuBinding2 = this.c;
        if (dialogYyCloseMenuBinding2 == null || (constraintLayout = dialogYyCloseMenuBinding2.c) == null) {
            return;
        }
        constraintLayout.startAnimation(loadAnimation);
    }
}
