package com.blued.android.module.yy_china.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogNewUserInfosBinding;
import com.blued.android.module.yy_china.fragment.BaseFullScreenDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYNewUserGiftinsfoDialog.class */
public final class YYNewUserGiftinsfoDialog extends BaseFullScreenDialog {

    /* renamed from: a  reason: collision with root package name */
    private DialogNewUserInfosBinding f18344a;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYNewUserGiftinsfoDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    private final void f() {
        ImageView imageView;
        DialogNewUserInfosBinding dialogNewUserInfosBinding = this.f18344a;
        if (dialogNewUserInfosBinding == null || (imageView = dialogNewUserInfosBinding.f16372a) == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYNewUserGiftinsfoDialog$BLCCNsCtsBKCGaRb5olUgLZLJ00
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYNewUserGiftinsfoDialog.a(YYNewUserGiftinsfoDialog.this, view);
            }
        });
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.dialog_new_user_infos, viewGroup, true);
        this.f18344a = DialogNewUserInfosBinding.a(inflate);
        f();
        return inflate;
    }
}
