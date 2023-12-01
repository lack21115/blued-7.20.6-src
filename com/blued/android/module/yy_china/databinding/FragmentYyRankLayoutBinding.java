package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.YYHomeThemeTabView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/FragmentYyRankLayoutBinding.class */
public final class FragmentYyRankLayoutBinding implements ViewBinding {
    public final ImageView a;
    public final ImageView b;
    public final YYHomeThemeTabView c;
    public final ViewPager d;
    private final ConstraintLayout e;

    private FragmentYyRankLayoutBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, YYHomeThemeTabView yYHomeThemeTabView, ViewPager viewPager) {
        this.e = constraintLayout;
        this.a = imageView;
        this.b = imageView2;
        this.c = yYHomeThemeTabView;
        this.d = viewPager;
    }

    public static FragmentYyRankLayoutBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.img_close);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.img_cover_view);
            if (imageView2 != null) {
                YYHomeThemeTabView yYHomeThemeTabView = (YYHomeThemeTabView) view.findViewById(R.id.ll_tab_layout);
                if (yYHomeThemeTabView != null) {
                    ViewPager findViewById = view.findViewById(R.id.rank_viewpager);
                    if (findViewById != null) {
                        return new FragmentYyRankLayoutBinding((ConstraintLayout) view, imageView, imageView2, yYHomeThemeTabView, findViewById);
                    }
                    str = "rankViewpager";
                } else {
                    str = "llTabLayout";
                }
            } else {
                str = "imgCoverView";
            }
        } else {
            str = "imgClose";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.e;
    }
}
