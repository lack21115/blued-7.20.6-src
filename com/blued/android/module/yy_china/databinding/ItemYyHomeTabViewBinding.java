package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyHomeTabViewBinding.class */
public final class ItemYyHomeTabViewBinding implements ViewBinding {
    public final ImageView a;
    public final ShapeLinearLayout b;
    public final TextView c;
    private final ConstraintLayout d;

    private ItemYyHomeTabViewBinding(ConstraintLayout constraintLayout, ImageView imageView, ShapeLinearLayout shapeLinearLayout, TextView textView) {
        this.d = constraintLayout;
        this.a = imageView;
        this.b = shapeLinearLayout;
        this.c = textView;
    }

    public static ItemYyHomeTabViewBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_top_name);
        if (imageView != null) {
            ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.shape_ll);
            if (shapeLinearLayout != null) {
                TextView textView = (TextView) view.findViewById(R.id.tv_top_name);
                if (textView != null) {
                    return new ItemYyHomeTabViewBinding((ConstraintLayout) view, imageView, shapeLinearLayout, textView);
                }
                str = "tvTopName";
            } else {
                str = "shapeLl";
            }
        } else {
            str = "ivTopName";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.d;
    }
}
