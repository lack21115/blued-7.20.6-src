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
    public final AutoScrollViewPager f29351a;
    public final LinePageIndicator b;

    /* renamed from: c  reason: collision with root package name */
    private final CardView f29352c;

    private ItemVipCenterBannerBinding(CardView cardView, AutoScrollViewPager autoScrollViewPager, LinePageIndicator linePageIndicator) {
        this.f29352c = cardView;
        this.f29351a = autoScrollViewPager;
        this.b = linePageIndicator;
    }

    public static ItemVipCenterBannerBinding a(View view) {
        String str;
        AutoScrollViewPager autoScrollViewPager = (AutoScrollViewPager) view.findViewById(R.id.banner_view_pager);
        if (autoScrollViewPager != null) {
            LinePageIndicator linePageIndicator = (LinePageIndicator) view.findViewById(2131364744);
            if (linePageIndicator != null) {
                return new ItemVipCenterBannerBinding((CardView) view, autoScrollViewPager, linePageIndicator);
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
        return this.f29352c;
    }
}
