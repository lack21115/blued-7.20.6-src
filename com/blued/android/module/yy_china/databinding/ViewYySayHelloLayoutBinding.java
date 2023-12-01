package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewYySayHelloLayoutBinding.class */
public final class ViewYySayHelloLayoutBinding implements ViewBinding {
    public final ImageView a;
    public final ShapeTextView b;
    private final ConstraintLayout c;

    private ViewYySayHelloLayoutBinding(ConstraintLayout constraintLayout, ImageView imageView, ShapeTextView shapeTextView) {
        this.c = constraintLayout;
        this.a = imageView;
        this.b = shapeTextView;
    }

    public static ViewYySayHelloLayoutBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_yy_say_hello_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ViewYySayHelloLayoutBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_hello_view);
        if (imageView != null) {
            ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_response);
            if (shapeTextView != null) {
                return new ViewYySayHelloLayoutBinding((ConstraintLayout) view, imageView, shapeTextView);
            }
            str = "tvResponse";
        } else {
            str = "ivHelloView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.c;
    }
}
