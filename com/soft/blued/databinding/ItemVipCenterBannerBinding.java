package com.soft.blued.databinding;

import android.view.View;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.AutoScrollViewPager;
import com.blued.android.module.common.view.LinePageIndicator;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/ItemVipCenterBannerBinding.class */
public final class ItemVipCenterBannerBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final AutoScrollViewPager f15661a;
    public final LinePageIndicator b;

    /* renamed from: c  reason: collision with root package name */
    private final CardView f15662c;

    private ItemVipCenterBannerBinding(CardView cardView, AutoScrollViewPager autoScrollViewPager, LinePageIndicator linePageIndicator) {
        this.f15662c = cardView;
        this.f15661a = autoScrollViewPager;
        this.b = linePageIndicator;
    }

    public static ItemVipCenterBannerBinding a(View view) {
        String str;
        AutoScrollViewPager findViewById = view.findViewById(R.id.banner_view_pager);
        if (findViewById != null) {
            LinePageIndicator findViewById2 = view.findViewById(R.id.indicator);
            if (findViewById2 != null) {
                return new ItemVipCenterBannerBinding((CardView) view, findViewById, findViewById2);
            }
            str = "indicator";
        } else {
            str = "bannerViewPager";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public CardView getRoot() {
        return this.f15662c;
    }
}
