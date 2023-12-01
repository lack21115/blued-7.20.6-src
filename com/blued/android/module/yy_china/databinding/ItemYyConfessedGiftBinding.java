package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyConfessedGiftBinding.class */
public final class ItemYyConfessedGiftBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final SquareImageView f16682a;
    public final ShapeTextView b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f16683c;
    public final TextView d;
    private final ConstraintLayout e;

    private ItemYyConfessedGiftBinding(ConstraintLayout constraintLayout, SquareImageView squareImageView, ShapeTextView shapeTextView, TextView textView, TextView textView2) {
        this.e = constraintLayout;
        this.f16682a = squareImageView;
        this.b = shapeTextView;
        this.f16683c = textView;
        this.d = textView2;
    }

    public static ItemYyConfessedGiftBinding a(View view) {
        String str;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.iv_gift);
        if (squareImageView != null) {
            ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.iv_select);
            if (shapeTextView != null) {
                TextView textView = (TextView) view.findViewById(R.id.tv_beans);
                if (textView != null) {
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_name);
                    if (textView2 != null) {
                        return new ItemYyConfessedGiftBinding((ConstraintLayout) view, squareImageView, shapeTextView, textView, textView2);
                    }
                    str = "tvName";
                } else {
                    str = "tvBeans";
                }
            } else {
                str = "ivSelect";
            }
        } else {
            str = "ivGift";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.e;
    }
}
