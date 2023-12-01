package com.blued.community.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.CustomViewPager;
import com.blued.android.module.common.view.TabPageIndicatorWithDot;
import com.blued.community.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/databinding/FragmentCollectionAddPostBinding.class */
public final class FragmentCollectionAddPostBinding implements ViewBinding {
    public final ImageView a;
    public final LinearLayout b;
    public final ShapeTextView c;
    public final CustomViewPager d;
    public final TabPageIndicatorWithDot e;
    private final ConstraintLayout f;

    private FragmentCollectionAddPostBinding(ConstraintLayout constraintLayout, ImageView imageView, LinearLayout linearLayout, ShapeTextView shapeTextView, CustomViewPager customViewPager, TabPageIndicatorWithDot tabPageIndicatorWithDot) {
        this.f = constraintLayout;
        this.a = imageView;
        this.b = linearLayout;
        this.c = shapeTextView;
        this.d = customViewPager;
        this.e = tabPageIndicatorWithDot;
    }

    public static FragmentCollectionAddPostBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_close);
        if (imageView != null) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_title);
            if (linearLayout != null) {
                ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_post);
                if (shapeTextView != null) {
                    CustomViewPager customViewPager = (CustomViewPager) view.findViewById(R.id.view_pager);
                    if (customViewPager != null) {
                        TabPageIndicatorWithDot tabPageIndicatorWithDot = (TabPageIndicatorWithDot) view.findViewById(R.id.vp_indicator);
                        if (tabPageIndicatorWithDot != null) {
                            return new FragmentCollectionAddPostBinding((ConstraintLayout) view, imageView, linearLayout, shapeTextView, customViewPager, tabPageIndicatorWithDot);
                        }
                        str = "vpIndicator";
                    } else {
                        str = "viewPager";
                    }
                } else {
                    str = "tvPost";
                }
            } else {
                str = "llTitle";
            }
        } else {
            str = "ivClose";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f;
    }
}
