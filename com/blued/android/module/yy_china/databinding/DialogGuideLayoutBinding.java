package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogGuideLayoutBinding.class */
public final class DialogGuideLayoutBinding implements ViewBinding {
    public final ImageView a;
    public final ShapeTextView b;
    private final ConstraintLayout c;

    private DialogGuideLayoutBinding(ConstraintLayout constraintLayout, ImageView imageView, ShapeTextView shapeTextView) {
        this.c = constraintLayout;
        this.a = imageView;
        this.b = shapeTextView;
    }

    public static DialogGuideLayoutBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.img_guide_arrow);
        if (imageView != null) {
            ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_guide_message);
            if (shapeTextView != null) {
                return new DialogGuideLayoutBinding((ConstraintLayout) view, imageView, shapeTextView);
            }
            str = "tvGuideMessage";
        } else {
            str = "imgGuideArrow";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.c;
    }
}
