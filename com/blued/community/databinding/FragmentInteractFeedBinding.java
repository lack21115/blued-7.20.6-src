package com.blued.community.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.CustomViewPager;
import com.blued.android.module.common.view.PageTabLayout;
import com.blued.community.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/databinding/FragmentInteractFeedBinding.class */
public final class FragmentInteractFeedBinding implements ViewBinding {
    public final FrameLayout a;
    public final ShapeTextView b;
    public final PageTabLayout c;
    public final CommonTopTitleNoTrans d;
    public final CustomViewPager e;
    private final LinearLayout f;

    private FragmentInteractFeedBinding(LinearLayout linearLayout, FrameLayout frameLayout, ShapeTextView shapeTextView, PageTabLayout pageTabLayout, CommonTopTitleNoTrans commonTopTitleNoTrans, CustomViewPager customViewPager) {
        this.f = linearLayout;
        this.a = frameLayout;
        this.b = shapeTextView;
        this.c = pageTabLayout;
        this.d = commonTopTitleNoTrans;
        this.e = customViewPager;
    }

    public static FragmentInteractFeedBinding a(View view) {
        String str;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_tab_title);
        if (frameLayout != null) {
            ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.shape_tab);
            if (shapeTextView != null) {
                PageTabLayout pageTabLayout = (PageTabLayout) view.findViewById(R.id.tab_layout);
                if (pageTabLayout != null) {
                    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) view.findViewById(R.id.top_title);
                    if (commonTopTitleNoTrans != null) {
                        CustomViewPager customViewPager = (CustomViewPager) view.findViewById(R.id.view_pager);
                        if (customViewPager != null) {
                            return new FragmentInteractFeedBinding((LinearLayout) view, frameLayout, shapeTextView, pageTabLayout, commonTopTitleNoTrans, customViewPager);
                        }
                        str = "viewPager";
                    } else {
                        str = "topTitle";
                    }
                } else {
                    str = "tabLayout";
                }
            } else {
                str = "shapeTab";
            }
        } else {
            str = "flTabTitle";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.f;
    }
}
