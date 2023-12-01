package com.soft.blued.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/PopGroupCommandBinding.class */
public final class PopGroupCommandBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f15832a;
    private final RelativeLayout b;

    private PopGroupCommandBinding(RelativeLayout relativeLayout, ImageView imageView) {
        this.b = relativeLayout;
        this.f15832a = imageView;
    }

    public static PopGroupCommandBinding a(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.iv);
        if (imageView != null) {
            return new PopGroupCommandBinding((RelativeLayout) view, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat("iv"));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.b;
    }
}
