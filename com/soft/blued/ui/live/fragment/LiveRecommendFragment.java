package com.soft.blued.ui.live.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.anythink.expressad.video.module.a.a.m;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.activity.PreloadFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.PauseOnScrollListener;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.utils.NetworkUtils;
import com.blued.android.module.common.view.AutoScrollViewPager;
import com.blued.android.module.common.view.LinePageIndicator;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.live_china.model.AnchorLiveStateModel;
import com.blued.android.module.live_china.model.BannerModel;
import com.blued.android.module.live_china.model.BluedLiveListData;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.observer.LiveListPositionObserver;
import com.blued.android.module.live_china.observer.LiveSwipeRefreshObserver;
import com.blued.android.similarity_operation_provider.BluedURIRouterAdapter;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;
import com.soft.blued.R;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.http.LiveHttpUtils;
import com.soft.blued.ui.home.HomeTabClick;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import com.soft.blued.ui.live.adapter.LiveListAdapter;
import com.soft.blued.ui.live.contract.LiveListContract;
import com.soft.blued.ui.live.manager.LiveFloatRedBagViewScrollObserver;
import com.soft.blued.ui.live.presenter.LiveListManager;
import com.soft.blued.ui.live.utils.LiveUtils;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveRecommendFragment.class */
public class LiveRecommendFragment extends PreloadFragment implements View.OnClickListener, LiveListPositionObserver.ILiveListPositionObserver, HomeTabClick.TabClickListener, LiveListContract.IView {
    private TextView A;
    private TextView B;
    private boolean G;
    public Context j;
    public PauseOnScrollListener k;
    private FrameLayout l;
    private BannerPagerAdapter m;
    private AutoScrollViewPager n;
    private LinePageIndicator o;
    private SmartRefreshLayout p;
    private RecyclerView q;
    private LiveListAdapter r;
    private LinearLayout s;
    private TextView t;
    private LiveListManager u;
    private int y;
    private NoDataAndLoadFailView z;
    private String v = "";
    private String w = "";
    private String x = "";
    private List<BannerModel> C = new ArrayList();
    private List<View> D = new ArrayList();
    private List<BannerViewHolder> E = new ArrayList();
    private List<Unbinder> F = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveRecommendFragment$BannerPagerAdapter.class */
    public class BannerPagerAdapter extends PagerAdapter {
        BannerPagerAdapter() {
        }

        public void a(List<BannerModel> list) {
            if (list != null) {
                if (LiveRecommendFragment.this.C != null) {
                    LiveRecommendFragment.this.C.clear();
                } else {
                    LiveRecommendFragment.this.C = new ArrayList();
                }
                LiveRecommendFragment.this.C.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            if (LiveRecommendFragment.this.C != null) {
                return LiveRecommendFragment.this.C.size();
            }
            return 0;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            final String str = ((BannerModel) LiveRecommendFragment.this.C.get(i)).url;
            while (LiveRecommendFragment.this.D.size() < LiveRecommendFragment.this.C.size()) {
                BannerViewHolder bannerViewHolder = new BannerViewHolder();
                View inflate = LayoutInflater.from(LiveRecommendFragment.this.j).inflate(2131559775, viewGroup, false);
                Unbinder a2 = ButterKnife.a(bannerViewHolder, inflate);
                LiveRecommendFragment.this.D.add(inflate);
                LiveRecommendFragment.this.E.add(bannerViewHolder);
                LiveRecommendFragment.this.F.add(a2);
            }
            final BannerModel bannerModel = (BannerModel) LiveRecommendFragment.this.C.get(i);
            BannerViewHolder bannerViewHolder2 = (BannerViewHolder) LiveRecommendFragment.this.E.get(i);
            ImageLoader.a(LiveRecommendFragment.this.getFragmentActive(), bannerModel.imgurl).b(2131231620).a(bannerViewHolder2.aariv_banner);
            if (!bannerModel.isShowUrlVisited) {
                FindHttpUtils.b(bannerModel.show_url);
                bannerModel.isShowUrlVisited = true;
            }
            bannerViewHolder2.aariv_banner.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.fragment.LiveRecommendFragment.BannerPagerAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (!TextUtils.isEmpty(bannerModel.anchor_id)) {
                        LiveRecommendFragment.this.a(bannerModel.anchor_id);
                        return;
                    }
                    FindHttpUtils.b(bannerModel.click_url);
                    WebViewShowInfoFragment.show(LiveRecommendFragment.this.j, str, 9);
                }
            });
            View view = (View) LiveRecommendFragment.this.D.get(i);
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view).removeView(view);
            }
            viewGroup.addView(view);
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveRecommendFragment$BannerViewHolder.class */
    class BannerViewHolder {
        @BindView
        ImageView aariv_banner;

        BannerViewHolder() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveRecommendFragment$BannerViewHolder_ViewBinding.class */
    public class BannerViewHolder_ViewBinding implements Unbinder {
        private BannerViewHolder b;

        public BannerViewHolder_ViewBinding(BannerViewHolder bannerViewHolder, View view) {
            this.b = bannerViewHolder;
            bannerViewHolder.aariv_banner = (ImageView) Utils.a(view, 2131361890, "field 'aariv_banner'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            BannerViewHolder bannerViewHolder = this.b;
            if (bannerViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.b = null;
            bannerViewHolder.aariv_banner = null;
        }
    }

    public static LiveRecommendFragment a(String str, int i, String str2) {
        LiveRecommendFragment liveRecommendFragment = new LiveRecommendFragment();
        Bundle bundle = new Bundle();
        bundle.putString("tab_id", str);
        bundle.putString("tab_name", "");
        bundle.putInt("tab_type", i);
        bundle.putString("live_pay_beans_details", str2);
        liveRecommendFragment.setArguments(bundle);
        return liveRecommendFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str) {
        LiveListAdapter liveListAdapter = this.r;
        if (liveListAdapter == null || !this.G) {
            return;
        }
        liveListAdapter.c();
    }

    private void i() {
        LiveEventBus.get("live_float_dismiss", String.class).observe(this, new Observer() { // from class: com.soft.blued.ui.live.fragment.-$$Lambda$LiveRecommendFragment$sNfnYiAWfU3ApGK0iq1uW1ug5eI
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveRecommendFragment.this.b((String) obj);
            }
        });
    }

    private void j() {
        this.j = getActivity();
        if (getArguments() != null) {
            this.v = getArguments().getString("tab_id");
            this.w = getArguments().getString("tab_name");
            this.y = getArguments().getInt("tab_type");
            this.x = getArguments().getString("live_pay_beans_details");
        }
        LiveListManager a2 = LiveListManager.a();
        this.u = a2;
        a2.a(this, this.v, this.y);
        LiveListPositionObserver.a().a(this);
        this.k = new PauseOnScrollListener(false, true);
    }

    private void k() {
        FrameLayout frameLayout = (FrameLayout) this.b.findViewById(2131362322);
        this.l = frameLayout;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.width = AppInfo.l - DisplayUtil.a(getContext(), 20.0f);
        layoutParams.height = (int) ((layoutParams.width * 125.0f) / 726.0f);
        this.l.setLayoutParams(layoutParams);
        this.n = (AutoScrollViewPager) this.b.findViewById(2131362321);
        this.o = (LinePageIndicator) this.b.findViewById(2131368404);
        BannerPagerAdapter bannerPagerAdapter = new BannerPagerAdapter();
        this.m = bannerPagerAdapter;
        this.n.setAdapter(bannerPagerAdapter);
        this.n.setInterval(m.ag);
        this.o.setViewPager(this.n);
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) this.b.findViewById(2131369121);
        this.p = smartRefreshLayout;
        smartRefreshLayout.b((OnMultiPurposeListener) new SimpleMultiPurposeListener() { // from class: com.soft.blued.ui.live.fragment.LiveRecommendFragment.1
            @Override // com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener, com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
            public void onLoadMore(RefreshLayout refreshLayout) {
                LiveRecommendFragment.this.u.a(false, LiveRecommendFragment.this.v, LiveRecommendFragment.this.y);
            }

            @Override // com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener, com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public void onRefresh(RefreshLayout refreshLayout) {
                if (LiveRecommendFragment.this.q.getLayoutManager() != null) {
                    LiveRecommendFragment.this.q.getLayoutManager().scrollToPosition(0);
                }
                if (LiveRecommendFragment.this.r != null) {
                    LiveRecommendFragment.this.r.d();
                }
                if (LiveRecommendFragment.this.u != null) {
                    LiveRecommendFragment.this.u.a(true, LiveRecommendFragment.this.v, LiveRecommendFragment.this.y);
                    LiveRecommendFragment.this.u.e(LiveRecommendFragment.this.v, LiveRecommendFragment.this.y);
                }
                if (LiveRecommendFragment.this.getParentFragment() instanceof LiveFragment) {
                    ((LiveFragment) LiveRecommendFragment.this.getParentFragment()).b(true);
                }
            }
        });
        this.q = (RecyclerView) this.b.findViewById(2131364131);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.j, 2);
        this.q.setLayoutManager(gridLayoutManager);
        this.q.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.soft.blued.ui.live.fragment.LiveRecommendFragment.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                LiveRecommendFragment.this.k.onScrollStateChanged(null, i);
                if (i == 0) {
                    if (LiveRecommendFragment.this.r != null) {
                        LiveRecommendFragment.this.r.c(false);
                        LiveRecommendFragment.this.r.e();
                    }
                } else if (i != 1 || LiveRecommendFragment.this.r == null) {
                } else {
                    LiveRecommendFragment.this.r.c(true);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                LiveFloatRedBagViewScrollObserver.a().a(recyclerView, i, i2);
            }
        });
        LinearLayout linearLayout = (LinearLayout) this.b.findViewById(R.id.ll_default_empty);
        this.s = linearLayout;
        this.t = (TextView) linearLayout.findViewById(2131371844);
        if (BluedPreferences.cK()) {
            this.t.setTextColor(Color.parseColor("#989898"));
        }
        this.z = (NoDataAndLoadFailView) this.b.findViewById(R.id.ll_no_internet);
        this.B = (TextView) this.s.findViewById(2131371861);
        TextView textView = (TextView) this.s.findViewById(2131371860);
        this.A = textView;
        textView.setOnClickListener(this);
        LiveListAdapter liveListAdapter = new LiveListAdapter(getFragmentActive(), this.j, false, 2, this.v);
        this.r = liveListAdapter;
        this.q.setAdapter(liveListAdapter);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.soft.blued.ui.live.fragment.LiveRecommendFragment.3
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                int i2 = 2;
                if (LiveRecommendFragment.this.r != null) {
                    i2 = 2;
                    if (LiveRecommendFragment.this.r.getItem(i) != 0) {
                        int itemViewType = LiveRecommendFragment.this.r.getItemViewType(i);
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
        LiveListManager liveListManager = this.u;
        if (liveListManager != null && liveListManager.c(this.v, this.y) > 0) {
            this.u.b(this.v, this.y);
        }
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.live.fragment.LiveRecommendFragment.4
            @Override // java.lang.Runnable
            public void run() {
                LiveRecommendFragment.this.p.i();
            }
        }, 300L);
        this.u.e(this.v, this.y);
    }

    @Override // com.soft.blued.ui.live.contract.LiveListContract.IView
    public void a() {
        this.p.l(false);
    }

    @Override // com.soft.blued.ui.live.contract.LiveListContract.IView
    public void a(int i) {
        Logger.a("LiveListCategoryFragment", "showNoDataButton permission = ", Integer.valueOf(i));
        if (this.s.getVisibility() == 0) {
            if (i == 1) {
                this.A.setVisibility(0);
                this.B.setVisibility(0);
                return;
            }
            this.A.setVisibility(8);
            this.B.setVisibility(8);
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveListPositionObserver.ILiveListPositionObserver
    public void a(int i, long j) {
        if (i == -1) {
            return;
        }
        try {
            if (this.q != null) {
                this.q.getLayoutManager().scrollToPosition(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.blued.android.framework.activity.PreloadFragment
    public void a(View view) {
        LayoutInflater.from(this.j).inflate(R.layout.fragment_live_recomend, (ViewGroup) this.b, true);
        k();
    }

    public void a(String str) {
        LiveHttpUtils.a(getContext(), new BluedUIHttpResponse<BluedEntityA<AnchorLiveStateModel>>() { // from class: com.soft.blued.ui.live.fragment.LiveRecommendFragment.5
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<AnchorLiveStateModel> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData() || bluedEntityA.getSingleData() == null) {
                    return;
                }
                try {
                    AnchorLiveStateModel singleData = bluedEntityA.getSingleData();
                    if (singleData.is_live != 1) {
                        BluedURIRouterAdapter.openUserInfoPage(LiveRecommendFragment.this.j, singleData.uid, singleData.name, 0, 1, "live_banner", false, "");
                        return;
                    }
                    LiveRoomData liveRoomData = new LiveRoomData(singleData.lid, 0, "footprint", singleData.uid, singleData.name, singleData.avatar, 0);
                    liveRoomData.details = LiveRecommendFragment.this.x;
                    LiveRecommendFragment.this.x = "";
                    LiveRoomInfoChannel.a(AppInfo.d(), liveRoomData, -1, null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, str, (IRequestHost) null);
    }

    @Override // com.soft.blued.ui.live.contract.LiveListContract.IView
    public void a(List<BannerModel> list) {
        b(list);
    }

    @Override // com.soft.blued.ui.live.contract.LiveListContract.IView
    public void a(List<BluedLiveListData> list, boolean z) {
        this.q.stopScroll();
        if (list != null) {
            if (z) {
                this.r.a(list);
            } else {
                this.r.setNewData(list);
            }
        }
        Logger.a("LiveListCategoryFragment", "mAdapter.getData().size() = ", this.r.getData().size() + "tabId:" + this.v);
        if (this.r.getData().size() > 0) {
            this.z.d();
            this.s.setVisibility(8);
            this.q.setVisibility(0);
            return;
        }
        if (NetworkUtils.b()) {
            this.s.setVisibility(0);
            this.z.d();
        } else {
            this.z.b();
            this.s.setVisibility(8);
        }
        this.q.setVisibility(8);
    }

    @Override // com.soft.blued.ui.live.contract.LiveListContract.IView
    public void b() {
        this.p.h();
    }

    public void b(List<BannerModel> list) {
        Log.i("xpm", "receive showBanner");
        if (list == null || list.size() <= 0) {
            h();
            return;
        }
        this.o.setVisibility(0);
        if (list.size() == 1) {
            this.o.setVisibility(8);
        }
        this.m.a(list);
        this.l.setVisibility(0);
        this.n.a();
        this.n.setCurrentItem(0, false);
        this.o.a(this.n, 0);
    }

    @Override // com.soft.blued.ui.live.contract.LiveListContract.IView
    public void c() {
        this.p.j();
        LiveSwipeRefreshObserver.a().b();
    }

    @Override // com.soft.blued.ui.home.HomeTabClick.TabClickListener
    public void c(String str) {
        if ("live".equals(str) && this.G) {
            this.p.i();
        }
    }

    @Override // com.soft.blued.ui.live.contract.LiveListContract.IView
    public void d() {
        if (this.r.getData().size() <= 0) {
            this.z.b();
            this.s.setVisibility(8);
        }
    }

    @Override // com.soft.blued.ui.home.HomeTabClick.TabClickListener
    public void d(String str) {
        if ("live".equals(str) && this.G) {
            c(str);
        }
    }

    @Override // com.soft.blued.ui.live.contract.LiveListContract.IView
    public void e() {
        this.p.l(true);
    }

    public void h() {
        Log.i("xpm", "receive showBannerNodata");
        this.l.setVisibility(8);
        this.o.setVisibility(8);
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
            LiveUtils.a(this.j, this.u.a(this.v, this.y));
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        j();
    }

    @Override // com.blued.android.framework.activity.PreloadFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        i();
        return onCreateView;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        LiveListPositionObserver.a().b(this);
        HomeTabClick.b("live", this);
        LiveListManager liveListManager = this.u;
        if (liveListManager != null) {
            liveListManager.d(this.v, this.y);
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.G) {
            Log.i("xpm", "List TAB onPause");
            LiveListAdapter liveListAdapter = this.r;
            if (liveListAdapter != null) {
                liveListAdapter.d();
            }
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.G) {
            Log.i("xpm", "List TAB onResume");
            LiveListAdapter liveListAdapter = this.r;
            if (liveListAdapter != null) {
                liveListAdapter.c();
            }
        }
    }

    @Override // com.blued.android.framework.activity.HomeTabFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    @Override // com.blued.android.framework.activity.PreloadFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.G = z;
        Log.i("xpm", "List TAB isVisibleToUser:" + z);
        if (z) {
            HomeTabClick.a("live", this);
        }
        LiveListAdapter liveListAdapter = this.r;
        if (liveListAdapter != null) {
            liveListAdapter.b(z);
        }
        if (z) {
            LiveListAdapter liveListAdapter2 = this.r;
            if (liveListAdapter2 != null) {
                liveListAdapter2.c();
                return;
            }
            return;
        }
        LiveListAdapter liveListAdapter3 = this.r;
        if (liveListAdapter3 != null) {
            liveListAdapter3.d();
        }
    }
}
