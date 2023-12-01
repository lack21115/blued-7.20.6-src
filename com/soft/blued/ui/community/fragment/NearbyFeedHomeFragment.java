package com.soft.blued.ui.community.fragment;

import android.os.Bundle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.skin.listener.BluedSkinObserver;
import com.blued.community.ui.square.fragment.NearbyFeedFragment;
import com.blued.community.ui.square.presenter.NearbyFeedPresenter;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.ui.find.observer.NearbyViewModel;
import com.soft.blued.ui.home.HomeActivity;
import com.soft.blued.ui.home.HomeTabClick;
import skin.support.observe.SkinObservable;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/community/fragment/NearbyFeedHomeFragment.class */
public class NearbyFeedHomeFragment extends NearbyFeedFragment<NearbyFeedPresenter> implements BluedSkinObserver, HomeTabClick.TabClickListener {
    private void v() {
        if (this.m != null) {
            this.m.setBackgroundColor(BluedSkinUtils.a(getActivity(), 2131101780));
        }
    }

    @Override // com.blued.community.ui.square.fragment.NearbyFeedFragment, com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        v();
    }

    @Override // skin.support.observe.SkinObserver
    public void a(SkinObservable skinObservable, Object obj) {
        v();
    }

    @Override // com.soft.blued.ui.home.HomeTabClick.TabClickListener
    public void c(String str) {
        if ("find".equals(str)) {
            e();
        }
    }

    @Override // com.soft.blued.ui.home.HomeTabClick.TabClickListener
    public void d(String str) {
        c(str);
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public String getSimpleRouterName() {
        return "A60";
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (HomeActivity.f30985c != null) {
            ((NearbyViewModel) ViewModelProviders.of(HomeActivity.f30985c).get(NearbyViewModel.class)).e.observe(this, new Observer<Void>() { // from class: com.soft.blued.ui.community.fragment.NearbyFeedHomeFragment.1
                @Override // androidx.lifecycle.Observer
                /* renamed from: a */
                public void onChanged(Void r4) {
                    NearbyFeedHomeFragment.this.e();
                    NearbyFeedHomeFragment.this.b(true);
                }
            });
        }
        BluedSkinUtils.a(this);
    }

    @Override // com.blued.community.ui.square.fragment.NearbyFeedFragment, com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        BluedSkinUtils.b(this);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        HomeTabClick.b("find", this);
        super.onDestroyView();
    }

    @Override // com.blued.community.ui.square.fragment.NearbyFeedFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        if (getUserVisibleHint()) {
            HomeTabClick.a("find", this);
        }
        super.onResume();
    }

    @Override // com.blued.community.ui.square.fragment.NearbyFeedFragment, com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        if (z) {
            HomeTabClick.a("find", this);
            LiveEventBus.get(EventBusConstant.KEY_EVENT_CITY_NEW).post(null);
        }
        super.setUserVisibleHint(z);
    }
}
