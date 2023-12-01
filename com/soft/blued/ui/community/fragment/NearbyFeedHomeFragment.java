package com.soft.blued.ui.community.fragment;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
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

    public void a(Bundle bundle) {
        super.a(bundle);
        v();
    }

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

    public String getSimpleRouterName() {
        return "A60";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (HomeActivity.f17295c != null) {
            ((NearbyViewModel) ViewModelProviders.of((FragmentActivity) HomeActivity.f17295c).get(NearbyViewModel.class)).e.observe(this, new Observer<Void>() { // from class: com.soft.blued.ui.community.fragment.NearbyFeedHomeFragment.1
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

    public void onDestroy() {
        super.onDestroy();
        BluedSkinUtils.b(this);
    }

    public void onDestroyView() {
        HomeTabClick.b("find", this);
        super.onDestroyView();
    }

    public void onResume() {
        if (getUserVisibleHint()) {
            HomeTabClick.a("find", this);
        }
        super.onResume();
    }

    public void setUserVisibleHint(boolean z) {
        if (z) {
            HomeTabClick.a("find", this);
            LiveEventBus.get(EventBusConstant.KEY_EVENT_CITY_NEW).post(null);
        }
        super.setUserVisibleHint(z);
    }
}
