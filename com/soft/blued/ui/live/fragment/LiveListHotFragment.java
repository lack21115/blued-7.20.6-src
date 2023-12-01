package com.soft.blued.ui.live.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.TypeUtils;
import com.blued.android.framework.view.PauseOnScrollListener;
import com.blued.android.module.live_china.model.BluedLiveListData;
import com.blued.android.module.live_china.observer.LiveListPositionObserver;
import com.blued.android.module.live_china.observer.LiveSwipeRefreshObserver;
import com.blued.android.module.live_china.observer.LiveTabNewObserver;
import com.igexin.push.core.b;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;
import com.soft.blued.R;
import com.soft.blued.ui.live.adapter.LiveListAdapter;
import com.soft.blued.ui.live.manager.LiveFloatRedBagViewScrollObserver;
import com.soft.blued.ui.live.manager.LiveHotViewScrollObserver;
import com.soft.blued.ui.live.presenter.LiveListHotPresenter;
import com.soft.blued.utils.Logger;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveListHotFragment.class */
public class LiveListHotFragment extends MvpFragment<LiveListHotPresenter> implements LiveListPositionObserver.ILiveListPositionObserver, LiveTabNewObserver.ILiveTabRefreshObserver {

    /* renamed from: a  reason: collision with root package name */
    public Context f31201a;
    public LiveListAdapter b;

    /* renamed from: c  reason: collision with root package name */
    public PauseOnScrollListener f31202c;
    private String d = "0";
    private int e = 0;
    private boolean f = true;
    private boolean g;
    @BindView
    RecyclerView grid_view;
    @BindView
    LinearLayout ll_default_empty;
    @BindView
    SmartRefreshLayout refresh_view;

    private void A() {
        if (this.grid_view.getLayoutManager() == null) {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f31201a, 6);
            this.grid_view.setLayoutManager(gridLayoutManager);
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.soft.blued.ui.live.fragment.LiveListHotFragment.4
                /* JADX WARN: Code restructure failed: missing block: B:9:0x0032, code lost:
                    if (r0 != 2) goto L13;
                 */
                @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public int getSpanSize(int r4) {
                    /*
                        r3 = this;
                        r0 = r3
                        com.soft.blued.ui.live.fragment.LiveListHotFragment r0 = com.soft.blued.ui.live.fragment.LiveListHotFragment.this
                        com.soft.blued.ui.live.adapter.LiveListAdapter r0 = r0.b
                        r7 = r0
                        r0 = 2
                        r5 = r0
                        r0 = r7
                        if (r0 == 0) goto L3a
                        r0 = r3
                        com.soft.blued.ui.live.fragment.LiveListHotFragment r0 = com.soft.blued.ui.live.fragment.LiveListHotFragment.this
                        com.soft.blued.ui.live.adapter.LiveListAdapter r0 = r0.b
                        r1 = r4
                        java.lang.Object r0 = r0.getItem(r1)
                        if (r0 == 0) goto L3a
                        r0 = r3
                        com.soft.blued.ui.live.fragment.LiveListHotFragment r0 = com.soft.blued.ui.live.fragment.LiveListHotFragment.this
                        com.soft.blued.ui.live.adapter.LiveListAdapter r0 = r0.b
                        r1 = r4
                        int r0 = r0.getItemViewType(r1)
                        r6 = r0
                        r0 = r6
                        if (r0 == 0) goto L38
                        r0 = r5
                        r4 = r0
                        r0 = r6
                        r1 = 2
                        if (r0 == r1) goto L3d
                        goto L3a
                    L38:
                        r0 = 3
                        return r0
                    L3a:
                        r0 = 6
                        r4 = r0
                    L3d:
                        r0 = r4
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.live.fragment.LiveListHotFragment.AnonymousClass4.getSpanSize(int):int");
                }
            });
            this.b.notifyDataSetChanged();
        }
    }

    private void b(List<BluedLiveListData> list) {
        if (list != null) {
            this.b.a(((Boolean) TypeUtils.a(Boolean.valueOf(j().o()))).booleanValue());
            this.b.setNewData(list);
        }
        if (this.b.getData().size() > 0) {
            this.ll_default_empty.setVisibility(8);
            this.grid_view.setVisibility(0);
        } else {
            this.ll_default_empty.setVisibility(0);
            this.grid_view.setVisibility(8);
        }
        A();
    }

    private void y() {
        this.f31202c = new PauseOnScrollListener(false, true);
    }

    private void z() {
        this.refresh_view.c(false);
        this.refresh_view.b((OnMultiPurposeListener) new SimpleMultiPurposeListener() { // from class: com.soft.blued.ui.live.fragment.LiveListHotFragment.1
            @Override // com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener, com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
            public void onLoadMore(RefreshLayout refreshLayout) {
                LiveListHotFragment.this.j().f();
            }

            @Override // com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener, com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public void onRefresh(RefreshLayout refreshLayout) {
            }
        });
        this.grid_view.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.soft.blued.ui.live.fragment.LiveListHotFragment.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (LiveListHotFragment.this.g) {
                    LiveListHotFragment.this.f31202c.onScrollStateChanged(null, i);
                    if (i == 0) {
                        if (LiveListHotFragment.this.b != null) {
                            LiveListHotFragment.this.b.c(false);
                            LiveListHotFragment.this.b.e();
                        }
                    } else if (i != 1 || LiveListHotFragment.this.b == null) {
                    } else {
                        LiveListHotFragment.this.b.c(true);
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                LiveFloatRedBagViewScrollObserver.a().a(recyclerView, i, i2);
                LiveHotViewScrollObserver.a().a(recyclerView, i, i2);
            }
        });
        LiveListAdapter liveListAdapter = new LiveListAdapter(getFragmentActive(), this.f31201a, true, 1, this.d);
        this.b = liveListAdapter;
        this.grid_view.setAdapter(liveListAdapter);
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.live.fragment.LiveListHotFragment.3
            @Override // java.lang.Runnable
            public void run() {
                LiveSwipeRefreshObserver.a().c();
            }
        }, 300L);
    }

    @Override // com.blued.android.module.live_china.observer.LiveListPositionObserver.ILiveListPositionObserver
    public void a(int i, long j) {
        int i2;
        Logger.a("rrb", "notifyLiveListPosition = ", Integer.valueOf(i), "-- sessionId = ", Long.valueOf(j));
        if (this.g && i != -1) {
            try {
                if (this.grid_view == null || this.b == null) {
                    return;
                }
                List<T> data = this.b.getData();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    i2 = i;
                    if (i4 >= data.size()) {
                        break;
                    } else if (TextUtils.equals(((BluedLiveListData) data.get(i4)).lid, String.valueOf(j))) {
                        i2 = i4;
                        break;
                    } else {
                        i3 = i4 + 1;
                    }
                }
                this.grid_view.getLayoutManager().scrollToPosition(i2);
                Logger.a("rrb", "scrollToPosition position = ", Integer.valueOf(i2));
            } catch (Exception e) {
                e.printStackTrace();
                Logger.a("rrb", "e = ", e);
            }
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        z();
        LiveTabNewObserver.a().a(this);
        LiveListPositionObserver.a().a(this);
        this.g = true;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, boolean z) {
        super.a(str, z);
        Log.i("xpm", "dismissDataLoading");
        x();
        w();
        this.grid_view.stopScroll();
    }

    public void a(List<BluedLiveListData> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("receive notifyListUpdate:");
        sb.append(list != null ? Integer.valueOf(list.size()) : b.l);
        Log.i("xpm", sb.toString());
        b(list);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void af_() {
        super.af_();
        this.g = false;
        LiveTabNewObserver.a().b(this);
        LiveListPositionObserver.a().b(this);
    }

    @Override // com.blued.android.module.live_china.observer.LiveTabNewObserver.ILiveTabRefreshObserver
    public void ag_() {
        if (this.g && this.grid_view.getLayoutManager() != null) {
            this.grid_view.getLayoutManager().scrollToPosition(0);
        }
    }

    public void b() {
        Log.i("xpm", "receive notifyListUpdateNoData");
        b(new ArrayList());
    }

    public void c() {
        this.refresh_view.l(true);
    }

    @Override // com.blued.android.module.live_china.observer.LiveTabNewObserver.ILiveTabRefreshObserver
    public void d() {
        if (this.f) {
            Log.i("xpm", "notifyLiveDataRefresh");
            j().e();
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveTabNewObserver.ILiveTabRefreshObserver
    public void e() {
        if (this.g && !this.grid_view.canScrollVertically(-1)) {
            this.grid_view.stopScroll();
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_live_list_tabpage;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void g_(String str) {
        super.g_(str);
        Log.i("xpm", "showDataLoading");
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void o() {
        super.o();
        Log.i("xpm", "enableLoadMore");
        c();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f31201a = getContext();
        y();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.g = false;
        LiveTabNewObserver.a().b(this);
        LiveListPositionObserver.a().b(this);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void p() {
        super.p();
        Log.i("xpm", "disableLoadMore");
        v();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public boolean q() {
        return true;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.f = z;
    }

    public void v() {
        this.refresh_view.l(false);
    }

    public void w() {
        this.refresh_view.h();
    }

    public void x() {
        LiveSwipeRefreshObserver.a().b();
    }
}
