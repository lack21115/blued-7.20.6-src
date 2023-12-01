package com.soft.blued.ui.community.fragment;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.blued.community.ui.circle.fragment.CircleNewFragment;
import com.blued.community.ui.circle.presenter.CirclePresenter;
import com.soft.blued.ui.home.HomeTabClick;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/community/fragment/CircleHomeFragment.class */
public class CircleHomeFragment extends CircleNewFragment<CirclePresenter> implements HomeTabClick.TabClickListener {
    public void c() {
        super.c();
        this.a.setVisibility(8);
    }

    @Override // com.soft.blued.ui.home.HomeTabClick.TabClickListener
    public void c(String str) {
        if (IAdInterListener.AdProdType.PRODUCT_FEEDS.equals(str)) {
            l();
        }
    }

    @Override // com.soft.blued.ui.home.HomeTabClick.TabClickListener
    public void d(String str) {
        c(str);
    }

    public void l() {
        b();
    }

    public void onDestroyView() {
        HomeTabClick.b(IAdInterListener.AdProdType.PRODUCT_FEEDS, this);
        super.onDestroyView();
    }

    public void onResume() {
        if (getUserVisibleHint()) {
            HomeTabClick.a(IAdInterListener.AdProdType.PRODUCT_FEEDS, this);
        }
        super.onResume();
    }

    public void setUserVisibleHint(boolean z) {
        if (z) {
            HomeTabClick.a(IAdInterListener.AdProdType.PRODUCT_FEEDS, this);
        }
        super.setUserVisibleHint(z);
    }
}
