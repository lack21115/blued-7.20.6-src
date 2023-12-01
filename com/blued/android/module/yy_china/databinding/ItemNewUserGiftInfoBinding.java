package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemNewUserGiftInfoBinding.class */
public final class ItemNewUserGiftInfoBinding implements ViewBinding {
    public final SquareImageView a;
    public final ShapeLinearLayout b;
    public final TextView c;
    private final ConstraintLayout d;

    private ItemNewUserGiftInfoBinding(ConstraintLayout constraintLayout, SquareImageView squareImageView, ShapeLinearLayout shapeLinearLayout, TextView textView) {
        this.d = constraintLayout;
        this.a = squareImageView;
        this.b = shapeLinearLayout;
        this.c = textView;
    }

    public static ItemNewUserGiftInfoBinding a(View view) {
        String str;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.iv);
        if (squareImageView != null) {
            ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.sl);
            if (shapeLinearLayout != null) {
                TextView textView = (TextView) view.findViewById(R.id.tv_name);
                if (textView != null) {
                    return new ItemNewUserGiftInfoBinding((ConstraintLayout) view, squareImageView, shapeLinearLayout, textView);
                }
                str = "tvName";
            } else {
                str = "sl";
            }
        } else {
            str = "iv";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.d;
    }
}
