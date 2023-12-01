package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyKtvNoticeSendGiftBinding.class */
public final class ItemYyKtvNoticeSendGiftBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f16746a;
    public final ShapeTextView b;

    /* renamed from: c  reason: collision with root package name */
    private final ConstraintLayout f16747c;

    private ItemYyKtvNoticeSendGiftBinding(ConstraintLayout constraintLayout, TextView textView, ShapeTextView shapeTextView) {
        this.f16747c = constraintLayout;
        this.f16746a = textView;
        this.b = shapeTextView;
    }

    public static ItemYyKtvNoticeSendGiftBinding a(View view) {
        String str;
        TextView textView = (TextView) view.findViewById(R.id.tv_mess);
        if (textView != null) {
            ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_send_gift);
            if (shapeTextView != null) {
                return new ItemYyKtvNoticeSendGiftBinding((ConstraintLayout) view, textView, shapeTextView);
            }
            str = "tvSendGift";
        } else {
            str = "tvMess";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f16747c;
    }
}
