package com.blued.community.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.CustomViewPager;
import com.blued.android.module.common.view.TabPageIndicatorWithDot;
import com.blued.community.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/databinding/FragmentHomeBinding.class */
public final class FragmentHomeBinding implements ViewBinding {
    public final LinearLayout a;
    public final ShapeTextView b;
    public final ShapeTextView c;
    public final CustomViewPager d;
    public final TabPageIndicatorWithDot e;
    private final ConstraintLayout f;

    private FragmentHomeBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, ShapeTextView shapeTextView, ShapeTextView shapeTextView2, CustomViewPager customViewPager, TabPageIndicatorWithDot tabPageIndicatorWithDot) {
        this.f = constraintLayout;
        this.a = linearLayout;
        this.b = shapeTextView;
        this.c = shapeTextView2;
        this.d = customViewPager;
        this.e = tabPageIndicatorWithDot;
    }

    public static FragmentHomeBinding a(View view) {
        String str;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_title);
        if (linearLayout != null) {
            ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_exit);
            if (shapeTextView != null) {
                ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.tv_test);
                if (shapeTextView2 != null) {
                    CustomViewPager customViewPager = (CustomViewPager) view.findViewById(R.id.view_pager);
                    if (customViewPager != null) {
                        TabPageIndicatorWithDot tabPageIndicatorWithDot = (TabPageIndicatorWithDot) view.findViewById(R.id.vp_indicator);
                        if (tabPageIndicatorWithDot != null) {
                            return new FragmentHomeBinding((ConstraintLayout) view, linearLayout, shapeTextView, shapeTextView2, customViewPager, tabPageIndicatorWithDot);
                        }
                        str = "vpIndicator";
                    } else {
                        str = "viewPager";
                    }
                } else {
                    str = "tvTest";
                }
            } else {
                str = "tvExit";
            }
        } else {
            str = "llTitle";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f;
    }
}
