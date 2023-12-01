package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyCpLikeToGiftBinding.class */
public final class ItemYyCpLikeToGiftBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeTextView f16697a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    private final ConstraintLayout f16698c;

    private ItemYyCpLikeToGiftBinding(ConstraintLayout constraintLayout, ShapeTextView shapeTextView, TextView textView) {
        this.f16698c = constraintLayout;
        this.f16697a = shapeTextView;
        this.b = textView;
    }

    public static ItemYyCpLikeToGiftBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_gift);
        if (shapeTextView != null) {
            TextView textView = (TextView) view.findViewById(R.id.tv_msg_content);
            if (textView != null) {
                return new ItemYyCpLikeToGiftBinding((ConstraintLayout) view, shapeTextView, textView);
            }
            str = "tvMsgContent";
        } else {
            str = "tvGift";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f16698c;
    }
}
