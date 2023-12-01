package com.soft.blued.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.NoScrollViewPager;
import com.blued.android.module.common.view.PageTabLayout;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/FragmentVirtualImagePackageBinding.class */
public final class FragmentVirtualImagePackageBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final PageTabLayout f15337a;
    public final LinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final NoScrollViewPager f15338c;
    private final FrameLayout d;

    private FragmentVirtualImagePackageBinding(FrameLayout frameLayout, PageTabLayout pageTabLayout, LinearLayout linearLayout, NoScrollViewPager noScrollViewPager) {
        this.d = frameLayout;
        this.f15337a = pageTabLayout;
        this.b = linearLayout;
        this.f15338c = noScrollViewPager;
    }

    public static FragmentVirtualImagePackageBinding a(View view) {
        String str;
        PageTabLayout findViewById = view.findViewById(R.id.tabLayout);
        if (findViewById != null) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.view_no_data);
            if (linearLayout != null) {
                NoScrollViewPager findViewById2 = view.findViewById(2131373100);
                if (findViewById2 != null) {
                    return new FragmentVirtualImagePackageBinding((FrameLayout) view, findViewById, linearLayout, findViewById2);
                }
                str = "viewPager";
            } else {
                str = "viewNoData";
            }
        } else {
            str = "tabLayout";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.d;
    }
}
