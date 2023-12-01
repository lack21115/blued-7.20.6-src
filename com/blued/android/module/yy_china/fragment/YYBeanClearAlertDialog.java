package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogBeansClearBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYBeanClearAlertDialog.class */
public final class YYBeanClearAlertDialog extends BaseFullScreenDialog {
    private final View.OnClickListener a;
    private DialogBeansClearBinding b;

    public YYBeanClearAlertDialog(View.OnClickListener cli) {
        Intrinsics.e(cli, "cli");
        this.a = cli;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYBeanClearAlertDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYBeanClearAlertDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.a.onClick(null);
        this$0.dismissAllowingStateLoss();
    }

    private final void f() {
        ShapeTextView shapeTextView;
        ShapeTextView shapeTextView2;
        DialogBeansClearBinding dialogBeansClearBinding = this.b;
        if (dialogBeansClearBinding != null && (shapeTextView2 = dialogBeansClearBinding.a) != null) {
            shapeTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYBeanClearAlertDialog$TF2lP8NvLbjpSuGChTc4LIbx5ng
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYBeanClearAlertDialog.a(YYBeanClearAlertDialog.this, view);
                }
            });
        }
        DialogBeansClearBinding dialogBeansClearBinding2 = this.b;
        if (dialogBeansClearBinding2 == null || (shapeTextView = dialogBeansClearBinding2.b) == null) {
            return;
        }
        shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYBeanClearAlertDialog$iyltdyMhn9CCKIAbEEsLIn5ChQk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYBeanClearAlertDialog.b(YYBeanClearAlertDialog.this, view);
            }
        });
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.dialog_beans_clear, (ViewGroup) null);
        this.b = DialogBeansClearBinding.a(inflate);
        f();
        return inflate;
    }
}
