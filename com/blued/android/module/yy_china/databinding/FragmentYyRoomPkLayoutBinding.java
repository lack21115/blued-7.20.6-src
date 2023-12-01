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

    /* renamed from: a  reason: collision with root package name */
    public final View f16549a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ViewPager f16550c;
    public final TabPageIndicatorWithDot d;
    private final FrameLayout e;

    private FragmentYyRoomPkLayoutBinding(FrameLayout frameLayout, View view, ImageView imageView, ViewPager viewPager, TabPageIndicatorWithDot tabPageIndicatorWithDot) {
        this.e = frameLayout;
        this.f16549a = view;
        this.b = imageView;
        this.f16550c = viewPager;
        this.d = tabPageIndicatorWithDot;
    }

    public static FragmentYyRoomPkLayoutBinding a(View view) {
        String str;
        View findViewById = view.findViewById(R.id.conver_view);
        if (findViewById != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_pk_more);
            if (imageView != null) {
                ViewPager viewPager = (ViewPager) view.findViewById(R.id.pk_category);
                if (viewPager != null) {
                    TabPageIndicatorWithDot tabPageIndicatorWithDot = (TabPageIndicatorWithDot) view.findViewById(R.id.tablayout);
                    if (tabPageIndicatorWithDot != null) {
                        return new FragmentYyRoomPkLayoutBinding((FrameLayout) view, findViewById, imageView, viewPager, tabPageIndicatorWithDot);
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

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.e;
    }
}
