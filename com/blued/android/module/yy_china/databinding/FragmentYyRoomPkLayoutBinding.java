package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.module.common.view.TabPageIndicatorWithDot;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/FragmentYyRoomPkLayoutBinding.class */
public final class FragmentYyRoomPkLayoutBinding implements ViewBinding {
    public final View a;
    public final ImageView b;
    public final ViewPager c;
    public final TabPageIndicatorWithDot d;
    private final FrameLayout e;

    private FragmentYyRoomPkLayoutBinding(FrameLayout frameLayout, View view, ImageView imageView, ViewPager viewPager, TabPageIndicatorWithDot tabPageIndicatorWithDot) {
        this.e = frameLayout;
        this.a = view;
        this.b = imageView;
        this.c = viewPager;
        this.d = tabPageIndicatorWithDot;
    }

    public static FragmentYyRoomPkLayoutBinding a(View view) {
        String str;
        View findViewById = view.findViewById(R.id.conver_view);
        if (findViewById != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_pk_more);
            if (imageView != null) {
                ViewPager findViewById2 = view.findViewById(R.id.pk_category);
                if (findViewById2 != null) {
                    TabPageIndicatorWithDot tabPageIndicatorWithDot = (TabPageIndicatorWithDot) view.findViewById(R.id.tablayout);
                    if (tabPageIndicatorWithDot != null) {
                        return new FragmentYyRoomPkLayoutBinding((FrameLayout) view, findViewById, imageView, findViewById2, tabPageIndicatorWithDot);
                    }
                    str = "tablayout";
                } else {
                    str = "pkCategory";
                }
            } else {
                str = "ivPkMore";
            }
        } else {
            str = "converView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.e;
    }
}
