package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogPrizeOfActivityBinding;
import com.blued.android.module.yy_china.model.YYDrawActivityModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/DialogPrizeOfActivity.class */
public final class DialogPrizeOfActivity extends BaseFullScreenDialog {
    private final YYDrawActivityModel a;
    private DialogPrizeOfActivityBinding b;

    public DialogPrizeOfActivity(YYDrawActivityModel yYDrawActivityModel) {
        this.a = yYDrawActivityModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DialogPrizeOfActivity this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DialogPrizeOfActivity this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    private final void f() {
        YYDrawActivityModel yYDrawActivityModel = this.a;
        if (yYDrawActivityModel == null) {
            return;
        }
        DialogPrizeOfActivityBinding dialogPrizeOfActivityBinding = this.b;
        TextView textView = dialogPrizeOfActivityBinding == null ? null : dialogPrizeOfActivityBinding.d;
        if (textView != null) {
            textView.setText(Intrinsics.a("恭喜抢到", (Object) yYDrawActivityModel.name));
        }
        ImageWrapper a = ImageLoader.a(a(), yYDrawActivityModel.image);
        DialogPrizeOfActivityBinding dialogPrizeOfActivityBinding2 = this.b;
        a.a(dialogPrizeOfActivityBinding2 == null ? null : dialogPrizeOfActivityBinding2.c);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.dialog_prize_of_activity, (ViewGroup) null);
        this.b = DialogPrizeOfActivityBinding.a(inflate);
        f();
        return inflate;
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment
    public void onViewCreated(View view, Bundle bundle) {
        ShapeTextView shapeTextView;
        View view2;
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        DialogPrizeOfActivityBinding dialogPrizeOfActivityBinding = this.b;
        if (dialogPrizeOfActivityBinding != null && (view2 = dialogPrizeOfActivityBinding.a) != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$DialogPrizeOfActivity$63PJZ6x2IZoX_-m9EL2shUtkOzo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    DialogPrizeOfActivity.a(view3);
                }
            });
        }
        DialogPrizeOfActivityBinding dialogPrizeOfActivityBinding2 = this.b;
        if (dialogPrizeOfActivityBinding2 != null && (shapeTextView = dialogPrizeOfActivityBinding2.b) != null) {
            shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$DialogPrizeOfActivity$tAi5tw5uRTYKnCYgWo6Yyi_APP8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    DialogPrizeOfActivity.a(DialogPrizeOfActivity.this, view3);
                }
            });
        }
        YYDrawActivityModel yYDrawActivityModel = this.a;
        if (yYDrawActivityModel == null) {
            return;
        }
        a(new Runnable() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$DialogPrizeOfActivity$oz7pVXUAEKNKR9yfEBgZtZTixxA
            @Override // java.lang.Runnable
            public final void run() {
                DialogPrizeOfActivity.a(DialogPrizeOfActivity.this);
            }
        }, yYDrawActivityModel.duration * 1000);
    }
}
