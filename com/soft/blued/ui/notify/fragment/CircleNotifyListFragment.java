package com.soft.blued.ui.notify.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.bytedance.applog.tracker.Tracker;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.soft.blued.ui.notify.adapter.CircleNotifyAdapter;
import com.soft.blued.ui.notify.model.CircleNotify;
import com.soft.blued.ui.notify.presenter.CircleNotifyListPresenter;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/notify/fragment/CircleNotifyListFragment.class */
public class CircleNotifyListFragment extends MvpFragment<CircleNotifyListPresenter> {

    /* renamed from: a  reason: collision with root package name */
    private CircleNotifyAdapter f32895a;
    private NoDataAndLoadFailView b;
    @BindView
    RecyclerView recyclerView;
    @BindView
    SmartRefreshLayout refreshLayout;
    @BindView
    CommonTopTitleNoTrans title;

    public static void a(Context context) {
        TerminalActivity.d(context, CircleNotifyListFragment.class, null);
    }

    private void b(boolean z) {
        this.refreshLayout.j();
        this.refreshLayout.h();
        if (!z) {
            this.refreshLayout.l(false);
        }
        if (this.f32895a.getData().size() <= 0) {
            if (z) {
                this.b.a();
            } else {
                this.b.b();
            }
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.title.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.notify.fragment.CircleNotifyListFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                CircleNotifyListFragment.this.t();
            }
        });
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        CircleNotifyAdapter circleNotifyAdapter = new CircleNotifyAdapter(getContext(), getFragmentActive());
        this.f32895a = circleNotifyAdapter;
        this.recyclerView.setAdapter(circleNotifyAdapter);
        NoDataAndLoadFailView noDataAndLoadFailView = new NoDataAndLoadFailView(getContext());
        this.b = noDataAndLoadFailView;
        noDataAndLoadFailView.setNoDataImg(2131233627);
        this.b.setNoDataStr(2131891064);
        this.f32895a.setEmptyView(this.b);
        this.refreshLayout.l(true);
        this.refreshLayout.a(new OnRefreshLoadMoreListener() { // from class: com.soft.blued.ui.notify.fragment.CircleNotifyListFragment.2
            @Override // com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
            public void onLoadMore(RefreshLayout refreshLayout) {
                CircleNotifyListFragment.this.j().f();
            }

            @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public void onRefresh(RefreshLayout refreshLayout) {
                CircleNotifyListFragment.this.j().e();
            }
        });
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, boolean z) {
        super.a(str, z);
        if (str == null) {
            return;
        }
        boolean z2 = true;
        int hashCode = str.hashCode();
        if (hashCode != -1290256561) {
            if (hashCode == 623698297 && str.equals("_load_type_loadmore_")) {
                z2 = true;
            }
        } else if (str.equals("_load_type_refresh_")) {
            z2 = false;
        }
        if (!z2 || z2) {
            b(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(List<CircleNotify> list) {
        this.f32895a.setNewData(list);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void af_() {
        super.af_();
        this.b = null;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return 2131558998;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void l() {
        this.refreshLayout.i();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void o() {
        super.o();
        this.refreshLayout.l(true);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void p() {
        super.p();
        this.refreshLayout.l(false);
    }
}
