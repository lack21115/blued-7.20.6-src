package com.soft.blued.ui.discover.presenter;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModelProviders;
import com.blued.android.chat.listener.SingleSessionListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.soft.blued.ui.community.model.DiscoveryPageTabModel;
import com.soft.blued.ui.discover.observer.DiscoverSquareViewModel;
import com.soft.blued.ui.home.HomeActivity;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/discover/presenter/DiscoveryPagePresenter.class */
public class DiscoveryPagePresenter extends MvpPresenter implements SingleSessionListener {
    public List<DiscoveryPageTabModel> h;

    public int a(int i) {
        int i2 = -1;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= m().size()) {
                return i2;
            }
            if (m().get(i4).tabid == i) {
                i2 = i4;
            }
            i3 = i4 + 1;
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(FragmentActivity fragmentActivity, Bundle bundle, Bundle bundle2) {
        super.a(fragmentActivity, bundle, bundle2);
        this.h = DiscoveryPageTabModel.getDiscoveryTabs(h());
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(final LifecycleOwner lifecycleOwner) {
        super.a(lifecycleOwner);
        ChatHelperV4.a().a(this);
        lifecycleOwner.getLifecycle().addObserver(new LifecycleObserver() { // from class: com.soft.blued.ui.discover.presenter.DiscoveryPagePresenter.1
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public void onDestroy() {
                ChatHelperV4.a().b(DiscoveryPagePresenter.this);
                lifecycleOwner.getLifecycle().removeObserver(this);
            }
        });
        if (HomeActivity.f30985c != null) {
            DiscoverSquareViewModel discoverSquareViewModel = (DiscoverSquareViewModel) ViewModelProviders.of(HomeActivity.f30985c).get(DiscoverSquareViewModel.class);
            discoverSquareViewModel.f29844a.observe(lifecycleOwner, new Observer<Integer>() { // from class: com.soft.blued.ui.discover.presenter.DiscoveryPagePresenter.2
                @Override // androidx.lifecycle.Observer
                /* renamed from: a */
                public void onChanged(Integer num) {
                    DiscoveryPagePresenter.this.a("view_page_to_item", (String) num);
                }
            });
            discoverSquareViewModel.b.observe(lifecycleOwner, new Observer<Void>() { // from class: com.soft.blued.ui.discover.presenter.DiscoveryPagePresenter.3
                @Override // androidx.lifecycle.Observer
                /* renamed from: a */
                public void onChanged(Void r5) {
                    DiscoveryPagePresenter.this.a("show_red_dot", (String) Integer.valueOf(DiscoveryPagePresenter.this.a(3)));
                }
            });
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(IFetchDataListener iFetchDataListener) {
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
    }

    public List<DiscoveryPageTabModel> m() {
        List<DiscoveryPageTabModel> list = this.h;
        if (list == null || list.size() <= 0) {
            this.h = DiscoveryPageTabModel.getDiscoveryTabs(h());
        }
        return this.h;
    }

    @Override // com.blued.android.chat.listener.SingleSessionListener
    public void onSessionDataChanged(SessionModel sessionModel) {
        if (sessionModel == null || sessionModel.sessionType != 1 || sessionModel.sessionId != 13 || sessionModel.noReadMsgCount == 0) {
            return;
        }
        a("show_red_dot", (String) Integer.valueOf(a(3)));
    }

    @Override // com.blued.android.chat.listener.SingleSessionListener
    public void onSessionRemoved(short s, long j) {
        if (s == 1 && j == 13) {
            a("hide_red_dot", (String) Integer.valueOf(a(3)));
        }
    }
}
