package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.module.yy_china.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYRedPackageGuideDialog.class */
public final class YYRedPackageGuideDialog extends BaseFullScreenDialog {
    private String a;

    public YYRedPackageGuideDialog(String delayTime) {
        Intrinsics.e(delayTime, "delayTime");
        this.a = "";
        this.a = delayTime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYRedPackageGuideDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYRedPackageGuideDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.dialog_red_package_guide, viewGroup, true);
        ((ImageView) inflate.findViewById(R.id.img_back)).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYRedPackageGuideDialog$SouurSm0bTQtArD_eJSeixMyFks
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRedPackageGuideDialog.a(YYRedPackageGuideDialog.this, view);
            }
        });
        inflate.findViewById(R.id.cover_view).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYRedPackageGuideDialog$-Eokj9AXeuq6-R_-AI80_z8uymM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYRedPackageGuideDialog.b(YYRedPackageGuideDialog.this, view);
            }
        });
        TextView textView = (TextView) inflate.findViewById(R.id.tv_content_3);
        textView.setText("3. 红包倒计时为" + this.a + "s，本聊天室内的所有用户以及通过红包入口吸引进来的用户均可参与抢红包；");
        return inflate;
    }
}
