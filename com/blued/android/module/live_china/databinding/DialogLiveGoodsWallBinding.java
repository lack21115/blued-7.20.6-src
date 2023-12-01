package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.module.common.view.TabPageIndicatorWithDot;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/DialogLiveGoodsWallBinding.class */
public final class DialogLiveGoodsWallBinding implements ViewBinding {
    public final TabPageIndicatorWithDot a;
    public final View b;
    public final View c;
    public final ViewPager d;
    private final FrameLayout e;

    private DialogLiveGoodsWallBinding(FrameLayout frameLayout, TabPageIndicatorWithDot tabPageIndicatorWithDot, View view, View view2, ViewPager viewPager) {
        this.e = frameLayout;
        this.a = tabPageIndicatorWithDot;
        this.b = view;
        this.c = view2;
        this.d = viewPager;
    }

    public static DialogLiveGoodsWallBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static DialogLiveGoodsWallBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_live_goods_wall, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogLiveGoodsWallBinding a(View view) {
        String str;
        TabPageIndicatorWithDot tabPageIndicatorWithDot = (TabPageIndicatorWithDot) view.findViewById(R.id.tab_layout);
        if (tabPageIndicatorWithDot != null) {
            View findViewById = view.findViewById(R.id.view_bg_top_brand);
            if (findViewById != null) {
                View findViewById2 = view.findViewById(R.id.view_bg_top_wall);
                if (findViewById2 != null) {
                    ViewPager findViewById3 = view.findViewById(R.id.view_pager);
                    if (findViewById3 != null) {
                        return new DialogLiveGoodsWallBinding((FrameLayout) view, tabPageIndicatorWithDot, findViewById, findViewById2, findViewById3);
                    }
                    str = "viewPager";
                } else {
                    str = "viewBgTopWall";
                }
            } else {
                str = "viewBgTopBrand";
            }
        } else {
            str = "tabLayout";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.e;
    }
}
