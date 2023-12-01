package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.module.common.view.PageTabLayout;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.view.LiveGiftSetBannerView;
import com.google.android.material.appbar.AppBarLayout;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/FragmentLiveGiftSetViewBinding.class */
public final class FragmentLiveGiftSetViewBinding implements ViewBinding {
    public final AppBarLayout a;
    public final LiveGiftSetBannerView b;
    public final CoordinatorLayout c;
    public final ShapeFrameLayout d;
    public final ImageView e;
    public final PageTabLayout f;
    public final PageTabLayout g;
    public final ViewPager h;
    private final LinearLayout i;

    private FragmentLiveGiftSetViewBinding(LinearLayout linearLayout, AppBarLayout appBarLayout, LiveGiftSetBannerView liveGiftSetBannerView, CoordinatorLayout coordinatorLayout, ShapeFrameLayout shapeFrameLayout, ImageView imageView, PageTabLayout pageTabLayout, PageTabLayout pageTabLayout2, ViewPager viewPager) {
        this.i = linearLayout;
        this.a = appBarLayout;
        this.b = liveGiftSetBannerView;
        this.c = coordinatorLayout;
        this.d = shapeFrameLayout;
        this.e = imageView;
        this.f = pageTabLayout;
        this.g = pageTabLayout2;
        this.h = viewPager;
    }

    public static FragmentLiveGiftSetViewBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static FragmentLiveGiftSetViewBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_live_gift_set_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static FragmentLiveGiftSetViewBinding a(View view) {
        String str;
        AppBarLayout findViewById = view.findViewById(R.id.appbar);
        if (findViewById != null) {
            LiveGiftSetBannerView liveGiftSetBannerView = (LiveGiftSetBannerView) view.findViewById(R.id.banner);
            if (liveGiftSetBannerView != null) {
                CoordinatorLayout findViewById2 = view.findViewById(R.id.coordinator);
                if (findViewById2 != null) {
                    ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout) view.findViewById(R.id.fl_tab);
                    if (shapeFrameLayout != null) {
                        ImageView imageView = (ImageView) view.findViewById(R.id.iv_qa);
                        if (imageView != null) {
                            PageTabLayout pageTabLayout = (PageTabLayout) view.findViewById(R.id.tab_layout);
                            if (pageTabLayout != null) {
                                PageTabLayout pageTabLayout2 = (PageTabLayout) view.findViewById(R.id.tab_layout_4);
                                if (pageTabLayout2 != null) {
                                    ViewPager findViewById3 = view.findViewById(R.id.view_pager);
                                    if (findViewById3 != null) {
                                        return new FragmentLiveGiftSetViewBinding((LinearLayout) view, findViewById, liveGiftSetBannerView, findViewById2, shapeFrameLayout, imageView, pageTabLayout, pageTabLayout2, findViewById3);
                                    }
                                    str = "viewPager";
                                } else {
                                    str = "tabLayout4";
                                }
                            } else {
                                str = "tabLayout";
                            }
                        } else {
                            str = "ivQa";
                        }
                    } else {
                        str = "flTab";
                    }
                } else {
                    str = "coordinator";
                }
            } else {
                str = "banner";
            }
        } else {
            str = "appbar";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.i;
    }
}
