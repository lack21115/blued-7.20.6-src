package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyMsgKtvSingSendGiftBinding.class */
public final class ItemYyMsgKtvSingSendGiftBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeTextView f16757a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeTextView f16758c;
    private final ShapeConstraintLayout d;

    private ItemYyMsgKtvSingSendGiftBinding(ShapeConstraintLayout shapeConstraintLayout, ShapeTextView shapeTextView, TextView textView, ShapeTextView shapeTextView2) {
        this.d = shapeConstraintLayout;
        this.f16757a = shapeTextView;
        this.b = textView;
        this.f16758c = shapeTextView2;
    }

    public static ItemYyMsgKtvSingSendGiftBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_applaud);
        if (shapeTextView != null) {
            TextView textView = (TextView) view.findViewById(R.id.tv_cont);
            if (textView != null) {
                ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.tv_send_gift);
                if (shapeTextView2 != null) {
                    return new ItemYyMsgKtvSingSendGiftBinding((ShapeConstraintLayout) view, shapeTextView, textView, shapeTextView2);
                }
                str = "tvSendGift";
            } else {
                str = "tvCont";
            }
        } else {
            str = "tvApplaud";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ShapeConstraintLayout getRoot() {
        return this.d;
    }
}
