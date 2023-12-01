package com.soft.blued.ui.live.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.activity.PreloadFragment;
import com.blued.android.framework.view.PauseOnScrollListener;
import com.blued.android.module.common.utils.NetworkUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.live_china.model.BannerModel;
import com.blued.android.module.live_china.model.BluedLiveListData;
import com.blued.android.module.live_china.observer.LiveListPositionObserver;
import com.blued.android.module.live_china.observer.LiveSwipeRefreshObserver;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;
import com.soft.blued.R;
import com.soft.blued.ui.home.HomeTabClick;
import com.soft.blued.ui.live.adapter.LiveListAdapter;
import com.soft.blued.ui.live.contract.LiveListContract;
import com.soft.blued.ui.live.manager.LiveFloatRedBagViewScrollObserver;
import com.soft.blued.ui.live.presenter.LiveListManager;
import com.soft.blued.ui.live.utils.LiveUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveListTabFragment.class */
public class LiveListTabFragment extends PreloadFragment implements View.OnClickListener, LiveListPositionObserver.ILiveListPositionObserver, HomeTabClick.TabClickListener, LiveListContract.IView {
    public Context j;
    public PauseOnScrollListener k;
    private SmartRefreshLayout l;
    private RecyclerView m;
    private LiveListAdapter n;
    private LinearLayout o;
    private LiveListManager p;
    private String q = "";
    private String r = "";
    private int s;
    private NoDataAndLoadFailView t;
    private TextView u;
    private TextView v;
    private CommonTopTitleNoTrans w;
    private boolean x;

    public static void a(Context context, String str, String str2, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("tab_id", str);
        bundle.putString("tab_name", str2);
        bundle.putInt("tab_type", i);
        TerminalActivity.d(context, LiveListTabFragment.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str) {
        LiveListAdapter liveListAdapter = this.n;
        if (liveListAdapter == null || !this.x) {
            return;
        }
        liveListAdapter.c();
    }

    private void h() {
        LiveEventBus.get("live_float_dismiss", String.class).observe(this, new Observer() { // from class: com.soft.blued.ui.live.fragment.-$$Lambda$LiveListTabFragment$EvqmNvepDRCUzKa2gkVAQ5cAWbo
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveListTabFragment.this.a((String) obj);
            }
        });
    }

    private void i() {
        this.j = getActivity();
        if (getArguments() != null) {
            this.q = getArguments().getString("tab_id");
            this.r = getArguments().getString("tab_name");
            this.s = getArguments().getInt("tab_type");
        }
        LiveListManager a2 = LiveListManager.a();
        this.p = a2;
        a2.a(this, this.q, this.s);
        LiveListPositionObserver.a().a(this);
        this.k = new PauseOnScrollListener(false, true);
    }

    private void j() {
        this.w = (CommonTopTitleNoTrans) this.b.findViewById(2131370749);
        if (TextUtils.equals(this.q, "12")) {
            this.w.setVisibility(8);
        } else {
            this.w.setVisibility(0);
            this.w.f();
            this.w.a();
            this.w.setLeftImgDrawable(BluedSkinUtils.b(this.j, 2131233902));
            this.w.setCenterText(this.r);
            this.w.setLeftClickListener(this);
        }
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) this.b.findViewById(2131369121);
        this.l = smartRefreshLayout;
        smartRefreshLayout.b((OnMultiPurposeListener) new SimpleMultiPurposeListener() { // from class: com.soft.blued.ui.live.fragment.LiveListTabFragment.1
            @Override // com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener, com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
            public void onLoadMore(RefreshLayout refreshLayout) {
                LiveListTabFragment.this.p.a(false, LiveListTabFragment.this.q, LiveListTabFragment.this.s);
            }

            @Override // com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener, com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public void onRefresh(RefreshLayout refreshLayout) {
                if (LiveListTabFragment.this.m.getLayoutManager() != null) {
                    LiveListTabFragment.this.m.getLayoutManager().scrollToPosition(0);
                }
                if (LiveListTabFragment.this.n != null) {
                    LiveListTabFragment.this.n.d();
                }
                if (LiveListTabFragment.this.p != null) {
                    LiveListTabFragment.this.p.a(true, LiveListTabFragment.this.q, LiveListTabFragment.this.s);
                }
                if (TextUtils.equals(LiveListTabFragment.this.q, "12") && (LiveListTabFragment.this.getParentFragment() instanceof LiveFragment)) {
                    ((LiveFragment) LiveListTabFragment.this.getParentFragment()).b(false);
                }
            }
        });
        this.m = (RecyclerView) this.b.findViewById(2131364131);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.j, 2);
        this.m.setLayoutManager(gridLayoutManager);
        this.m.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.soft.blued.ui.live.fragment.LiveListTabFragment.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                LiveListTabFragment.this.k.onScrollStateChanged(null, i);
                if (i == 0) {
                    if (LiveListTabFragment.this.n != null) {
                        LiveListTabFragment.this.n.c(false);
                        LiveListTabFragment.this.n.e();
                    }
                } else if (i != 1 || LiveListTabFragment.this.n == null) {
                } else {
                    LiveListTabFragment.this.n.c(true);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (TextUtils.equals(LiveListTabFragment.this.q, "12")) {
                    LiveFloatRedBagViewScrollObserver.a().a(recyclerView, i, i2);
                }
            }
        });
        this.o = (LinearLayout) this.b.findViewById(R.id.ll_default_empty);
        this.t = (NoDataAndLoadFailView) this.b.findViewById(R.id.ll_no_internet);
        this.v = (TextView) this.o.findViewById(2131371861);
        TextView textView = (TextView) this.o.findViewById(2131371860);
        this.u = textView;
        textView.setOnClickListener(this);
        LiveListAdapter liveListAdapter = new LiveListAdapter(getFragmentActive(), this.j, false, 2, this.q);
        this.n = liveListAdapter;
        this.m.setAdapter(liveListAdapter);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.soft.blued.ui.live.fragment.LiveListTabFragment.3
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                int i2 = 2;
                if (LiveListTabFragment.this.n != null) {
                    i2 = 2;
                    if (LiveListTabFragment.this.n.getItem(i) != 0) {
                        int itemViewType = LiveListTabFragment.this.n.getItemViewType(i);
                        i2 = 2;
                        if (itemViewType != 8) {
                            i2 = 2;
                            if (itemViewType != 9) {
                                i2 = 1;
                            }
                        }
                    }
                }
                return i2;
            }
        });
        LiveListManager liveListManager = this.p;
        if (liveListManager != null && liveListManager.c(this.q, this.s) > 0) {
            this.p.b(this.q, this.s);
        }
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.live.fragment.LiveListTabFragment.4
            @Override // java.lang.Runnable
            public void run() {
                LiveListTabFragment.this.l.i();
            }
        }, 300L);
    }

    @Override // com.soft.blued.ui.live.contract.LiveListContract.IView
    public void a() {
        this.l.l(false);
    }

    @Override // com.soft.blued.ui.live.contract.LiveListContract.IView
    public void a(int i) {
        Logger.a("LiveListCategoryFragment", "showNoDataButton permission = ", Integer.valueOf(i));
        if (this.o.getVisibility() == 0) {
            if (i == 1) {
                this.u.setVisibility(0);
                this.v.setVisibility(0);
                return;
            }
            this.u.setVisibility(8);
            this.v.setVisibility(8);
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveListPositionObserver.ILiveListPositionObserver
    public void a(int i, long j) {
        if (i == -1) {
            return;
        }
        try {
            if (this.m != null) {
                this.m.getLayoutManager().scrollToPosition(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.blued.android.framework.activity.PreloadFragment
    public void a(View view) {
        LayoutInflater.from(this.j).inflate(R.layout.fragment_live_list_tabpage, (ViewGroup) this.b, true);
        j();
    }

    @Override // com.soft.blued.ui.live.contract.LiveListContract.IView
    public void a(List<BannerModel> list) {
    }

    @Override // com.soft.blued.ui.live.contract.LiveListContract.IView
    public void a(List<BluedLiveListData> list, boolean z) {
        this.m.stopScroll();
        if (list != null) {
            if (z) {
                this.n.a(list);
            } else {
                this.n.setNewData(list);
            }
        }
        Logger.a("LiveListCategoryFragment", "mAdapter.getData().size() = ", this.n.getData().size() + "tabId:" + this.q);
        if (this.n.getData().size() > 0) {
            this.t.d();
            this.o.setVisibility(8);
            this.m.setVisibility(0);
            return;
        }
        if (NetworkUtils.b()) {
            this.o.setVisibility(0);
            this.t.d();
        } else {
            this.t.b();
            this.o.setVisibility(8);
        }
        this.m.setVisibility(8);
    }

    @Override // com.soft.blued.ui.live.contract.LiveListContract.IView
    public void b() {
        this.l.h();
    }

    @Override // com.soft.blued.ui.live.contract.LiveListContract.IView
    public void c() {
        this.l.j();
        LiveSwipeRefreshObserver.a().b();
    }

    @Override // com.soft.blued.ui.home.HomeTabClick.TabClickListener
    public void c(String str) {
        if ("live".equals(str) && this.x) {
            this.l.i();
        }
    }

    @Override // com.soft.blued.ui.live.contract.LiveListContract.IView
    public void d() {
        if (this.n.getData().size() <= 0) {
            this.t.b();
            this.o.setVisibility(8);
        }
    }

    @Override // com.soft.blued.ui.home.HomeTabClick.TabClickListener
    public void d(String str) {
        if ("live".equals(str) && this.x) {
            c(str);
        }
    }

    @Override // com.soft.blued.ui.live.contract.LiveListContract.IView
    public void e() {
        this.l.l(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131363120) {
            getActivity().finish();
        } else if (id != 2131371860) {
        } else {
            BluedPreferences.aK();
            LiveUtils.a(this.j, this.p.a(this.q, this.s));
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        i();
    }

    @Override // com.blued.android.framework.activity.PreloadFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (!TextUtils.equals(this.q, "12")) {
            setUserVisibleHint(true);
        }
        h();
        return onCreateView;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        LiveListPositionObserver.a().b(this);
        HomeTabClick.b("live", this);
        LiveListManager liveListManager = this.p;
        if (liveListManager != null) {
            liveListManager.d(this.q, this.s);
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.x) {
            Log.i("xpm", "List TAB onPause");
            LiveListAdapter liveListAdapter = this.n;
            if (liveListAdapter != null) {
                liveListAdapter.d();
            }
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.x) {
            Log.i("xpm", "List TAB onResume");
            LiveListAdapter liveListAdapter = this.n;
            if (liveListAdapter != null) {
                liveListAdapter.c();
            }
        }
    }

    @Override // com.blued.android.framework.activity.PreloadFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.x = z;
        Log.i("xpm", "List TAB isVisibleToUser:" + z);
        if (z && TextUtils.equals(this.q, "12")) {
            HomeTabClick.a("live", this);
        }
        LiveListAdapter liveListAdapter = this.n;
        if (liveListAdapter != null) {
            liveListAdapter.b(z);
        }
        if (z) {
            LiveListAdapter liveListAdapter2 = this.n;
            if (liveListAdapter2 != null) {
                liveListAdapter2.c();
                return;
            }
            return;
        }
        LiveListAdapter liveListAdapter3 = this.n;
        if (liveListAdapter3 != null) {
            liveListAdapter3.d();
        }
    }
}
