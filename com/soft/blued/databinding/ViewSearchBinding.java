package com.soft.blued.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/ViewSearchBinding.class */
public final class ViewSearchBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f15938a;
    public final ShapeLinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    private final FrameLayout f15939c;

    private ViewSearchBinding(FrameLayout frameLayout, ImageView imageView, ShapeLinearLayout shapeLinearLayout) {
        this.f15939c = frameLayout;
        this.f15938a = imageView;
        this.b = shapeLinearLayout;
    }

    public static ViewSearchBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(2131369672);
        if (imageView != null) {
            ShapeLinearLayout findViewById = view.findViewById(R.id.search_layout);
            if (findViewById != null) {
                return new ViewSearchBinding((FrameLayout) view, imageView, findViewById);
            }
            str = "searchLayout";
        } else {
            str = "searchIcon";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.f15939c;
    }
}
