package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewRedPackageBinding.class */
public final class ViewRedPackageBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f16873a;
    public final ShapeTextView b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeTextView f16874c;
    private final ConstraintLayout d;

    private ViewRedPackageBinding(ConstraintLayout constraintLayout, ImageView imageView, ShapeTextView shapeTextView, ShapeTextView shapeTextView2) {
        this.d = constraintLayout;
        this.f16873a = imageView;
        this.b = shapeTextView;
        this.f16874c = shapeTextView2;
    }

    public static ViewRedPackageBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_red_package, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ViewRedPackageBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.img_red_package);
        if (imageView != null) {
            ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_countdown);
            if (shapeTextView != null) {
                ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.tv_red_package_count);
                if (shapeTextView2 != null) {
                    return new ViewRedPackageBinding((ConstraintLayout) view, imageView, shapeTextView, shapeTextView2);
                }
                str = "tvRedPackageCount";
            } else {
                str = "tvCountdown";
            }
        } else {
            str = "imgRedPackage";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.d;
    }
}
