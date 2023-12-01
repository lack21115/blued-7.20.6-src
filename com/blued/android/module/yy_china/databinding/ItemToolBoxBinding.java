package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemToolBoxBinding.class */
public final class ItemToolBoxBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeTextView f16665a;
    public final SquareImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f16666c;
    private final LinearLayout d;

    private ItemToolBoxBinding(LinearLayout linearLayout, ShapeTextView shapeTextView, SquareImageView squareImageView, TextView textView) {
        this.d = linearLayout;
        this.f16665a = shapeTextView;
        this.b = squareImageView;
        this.f16666c = textView;
    }

    public static ItemToolBoxBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.img_red_dot);
        if (shapeTextView != null) {
            SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.tool_img);
            if (squareImageView != null) {
                TextView textView = (TextView) view.findViewById(R.id.tool_name);
                if (textView != null) {
                    return new ItemToolBoxBinding((LinearLayout) view, shapeTextView, squareImageView, textView);
                }
                str = "toolName";
            } else {
                str = "toolImg";
            }
        } else {
            str = "imgRedDot";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.d;
    }
}
