package com.blued.android.module.live_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.module.common.view.PageTabLayout;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/FragmentLiveMainBinding.class */
public final class FragmentLiveMainBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final View f11948a;
    public final PageTabLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final FrameLayout f11949c;
    public final ViewPager d;
    private final LinearLayout e;

    private FragmentLiveMainBinding(LinearLayout linearLayout, View view, PageTabLayout pageTabLayout, FrameLayout frameLayout, ViewPager viewPager) {
        this.e = linearLayout;
        this.f11948a = view;
        this.b = pageTabLayout;
        this.f11949c = frameLayout;
        this.d = viewPager;
    }

    public static FragmentLiveMainBinding a(View view) {
        String str;
        View findViewById = view.findViewById(R.id.line);
        if (findViewById != null) {
            PageTabLayout pageTabLayout = (PageTabLayout) view.findViewById(R.id.tablayout);
            if (pageTabLayout != null) {
                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.tablayout_root);
                if (frameLayout != null) {
                    ViewPager viewPager = (ViewPager) view.findViewById(R.id.view_pager);
                    if (viewPager != null) {
                        return new FragmentLiveMainBinding((LinearLayout) view, findViewById, pageTabLayout, frameLayout, viewPager);
                    }
                    str = "viewPager";
                } else {
                    str = "tablayoutRoot";
                }
            } else {
                str = "tablayout";
            }
        } else {
            str = "line";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.e;
    }
}
