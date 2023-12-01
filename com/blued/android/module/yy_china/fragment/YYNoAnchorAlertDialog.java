package com.blued.android.module.yy_china.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.IYYRoomInfoCallback;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogNoAnchorBinding;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYMsgNoAnchorModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYNoAnchorAlertDialog.class */
public final class YYNoAnchorAlertDialog extends BaseFullScreenDialog {
    private YYMsgNoAnchorModel a;
    private BaseYYStudioFragment b;
    private DialogNoAnchorBinding c;

    public YYNoAnchorAlertDialog(YYMsgNoAnchorModel yYMsgNoAnchorModel, BaseYYStudioFragment baseYYStudioFragment) {
        this.a = yYMsgNoAnchorModel;
        this.b = baseYYStudioFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYNoAnchorAlertDialog this$0) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.a().isActive()) {
            this$0.dismissAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYNoAnchorAlertDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        YYMsgNoAnchorModel yYMsgNoAnchorModel = this$0.a;
        if (TextUtils.isEmpty(yYMsgNoAnchorModel == null ? null : yYMsgNoAnchorModel.link)) {
            return;
        }
        BaseYYStudioFragment baseYYStudioFragment = this$0.b;
        if (baseYYStudioFragment != null) {
            baseYYStudioFragment.onBackPressed();
            FragmentActivity activity = baseYYStudioFragment.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
        IYYRoomInfoCallback c = YYRoomInfoManager.e().c();
        Context context = this$0.getContext();
        YYMsgNoAnchorModel yYMsgNoAnchorModel2 = this$0.a;
        c.a(context, yYMsgNoAnchorModel2 == null ? null : yYMsgNoAnchorModel2.link, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYNoAnchorAlertDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    private final void f() {
        View view;
        ShapeTextView shapeTextView;
        DialogNoAnchorBinding dialogNoAnchorBinding = this.c;
        if (dialogNoAnchorBinding != null && (shapeTextView = dialogNoAnchorBinding.a) != null) {
            shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYNoAnchorAlertDialog$N6ud2qEuO0NnKYCQ4dOsMRamVrM
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYNoAnchorAlertDialog.a(YYNoAnchorAlertDialog.this, view2);
                }
            });
        }
        DialogNoAnchorBinding dialogNoAnchorBinding2 = this.c;
        if (dialogNoAnchorBinding2 != null && (view = dialogNoAnchorBinding2.b) != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYNoAnchorAlertDialog$sbDoE5oYWQwn_2QRcELwb0VkGcw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYNoAnchorAlertDialog.b(YYNoAnchorAlertDialog.this, view2);
                }
            });
        }
        YYMsgNoAnchorModel yYMsgNoAnchorModel = this.a;
        if (yYMsgNoAnchorModel == null) {
            return;
        }
        DialogNoAnchorBinding dialogNoAnchorBinding3 = this.c;
        TextView textView = dialogNoAnchorBinding3 == null ? null : dialogNoAnchorBinding3.f;
        if (textView != null) {
            textView.setText(yYMsgNoAnchorModel.title);
        }
        DialogNoAnchorBinding dialogNoAnchorBinding4 = this.c;
        TextView textView2 = dialogNoAnchorBinding4 == null ? null : dialogNoAnchorBinding4.e;
        if (textView2 != null) {
            textView2.setText(yYMsgNoAnchorModel.content);
        }
        DialogNoAnchorBinding dialogNoAnchorBinding5 = this.c;
        ShapeTextView shapeTextView2 = dialogNoAnchorBinding5 == null ? null : dialogNoAnchorBinding5.a;
        if (shapeTextView2 != null) {
            shapeTextView2.setText(yYMsgNoAnchorModel.submit_title);
        }
        if (!TextUtils.isEmpty(yYMsgNoAnchorModel.background)) {
            ImageWrapper a = ImageLoader.a(a(), yYMsgNoAnchorModel.background);
            DialogNoAnchorBinding dialogNoAnchorBinding6 = this.c;
            a.a(dialogNoAnchorBinding6 == null ? null : dialogNoAnchorBinding6.c);
        }
        if (yYMsgNoAnchorModel.delay > 0) {
            if (yYMsgNoAnchorModel.delay < 1000) {
                yYMsgNoAnchorModel.delay *= 1000;
            }
            a(new Runnable() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYNoAnchorAlertDialog$QjuTiLUgZeFmSJLjoeLN1rqjGck
                @Override // java.lang.Runnable
                public final void run() {
                    YYNoAnchorAlertDialog.a(YYNoAnchorAlertDialog.this);
                }
            }, yYMsgNoAnchorModel.delay);
        }
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.dialog_no_anchor, (ViewGroup) null);
        this.c = DialogNoAnchorBinding.a(inflate);
        f();
        return inflate;
    }
}
