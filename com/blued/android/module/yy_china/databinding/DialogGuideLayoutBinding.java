package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogGuideLayoutBinding.class */
public final class DialogGuideLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f16350a;
    public final ShapeTextView b;

    /* renamed from: c  reason: collision with root package name */
    private final ConstraintLayout f16351c;

    private DialogGuideLayoutBinding(ConstraintLayout constraintLayout, ImageView imageView, ShapeTextView shapeTextView) {
        this.f16351c = constraintLayout;
        this.f16350a = imageView;
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

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f16351c;
    }
}
