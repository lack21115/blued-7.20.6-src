package com.soft.blued.ui.community.fragment;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.blued.community.ui.square.fragment.RecommendFeedFragment;
import com.blued.community.ui.square.presenter.RecommendFeedPresenter;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.home.HomeTabClick;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/community/fragment/RecommendFeedHomeFragment.class */
public class RecommendFeedHomeFragment extends RecommendFeedFragment<RecommendFeedPresenter> implements HomeTabClick.TabClickListener {

    /* renamed from: c  reason: collision with root package name */
    private boolean f16103c = false;

    @Override // com.soft.blued.ui.home.HomeTabClick.TabClickListener
    public void c(String str) {
        if (IAdInterListener.AdProdType.PRODUCT_FEEDS.equals(str)) {
            d();
        }
    }

    @Override // com.soft.blued.ui.home.HomeTabClick.TabClickListener
    public void d(String str) {
        c(str);
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
            if (!this.f16103c) {
                InstantLog.b("first_auto_load", 2);
                this.f16103c = true;
            }
        }
        super.setUserVisibleHint(z);
    }
}
