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
import com.soft.blued.R;
import com.soft.blued.ui.notify.adapter.CircleNotifyAdapter;
import com.soft.blued.ui.notify.model.CircleNotify;
import com.soft.blued.ui.notify.presenter.CircleNotifyListPresenter;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/notify/fragment/CircleNotifyListFragment.class */
public class CircleNotifyListFragment extends MvpFragment<CircleNotifyListPresenter> {

    /* renamed from: a  reason: collision with root package name */
    private CircleNotifyAdapter f19204a;
    private NoDataAndLoadFailView b;
    @BindView
    RecyclerView recyclerView;
    @BindView
    SmartRefreshLayout refreshLayout;
    @BindView
    CommonTopTitleNoTrans title;

    public static void a(Context context) {
        TerminalActivity.d(context, CircleNotifyListFragment.class, (Bundle) null);
    }

    private void b(boolean z) {
        this.refreshLayout.j();
        this.refreshLayout.h();
        if (!z) {
            this.refreshLayout.l(false);
        }
        if (this.f19204a.getData().size() <= 0) {
            if (z) {
                this.b.a();
            } else {
                this.b.b();
            }
        }
    }

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
        this.f19204a = circleNotifyAdapter;
        this.recyclerView.setAdapter(circleNotifyAdapter);
        NoDataAndLoadFailView noDataAndLoadFailView = new NoDataAndLoadFailView(getContext());
        this.b = noDataAndLoadFailView;
        noDataAndLoadFailView.setNoDataImg(2131233627);
        this.b.setNoDataStr(2131891064);
        this.f19204a.setEmptyView((View) this.b);
        this.refreshLayout.l(true);
        this.refreshLayout.a(new OnRefreshLoadMoreListener() { // from class: com.soft.blued.ui.notify.fragment.CircleNotifyListFragment.2
            @Override // com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
            public void onLoadMore(RefreshLayout refreshLayout) {
                ((CircleNotifyListPresenter) CircleNotifyListFragment.this.j()).f();
            }

            @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public void onRefresh(RefreshLayout refreshLayout) {
                ((CircleNotifyListPresenter) CircleNotifyListFragment.this.j()).e();
            }
        });
    }

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
        this.f19204a.setNewData(list);
    }

    public void af_() {
        super.af_();
        this.b = null;
    }

    public int g() {
        return R.layout.fragment_circle_notify_list;
    }

    public void l() {
        this.refreshLayout.i();
    }

    public void o() {
        super.o();
        this.refreshLayout.l(true);
    }

    public void p() {
        super.p();
        this.refreshLayout.l(false);
    }
}
