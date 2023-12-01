package com.soft.blued.ui.live.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.anythink.expressad.video.module.a.a.m;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.common.view.AutoScrollViewPager;
import com.blued.android.module.common.view.CustomTwoLevelHeader;
import com.blued.android.module.common.view.LinePageIndicator;
import com.blued.android.module.live_china.mine.LiveRouteUtil;
import com.blued.android.module.live_china.model.AnchorLiveStateModel;
import com.blued.android.module.live_china.model.BannerModel;
import com.blued.android.module.live_china.model.LiveFirstChargeInfo;
import com.blued.android.module.live_china.model.LiveLiangModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.LiveTabInfo;
import com.blued.android.module.live_china.model.LiveTabModel;
import com.blued.android.module.live_china.model.LiveTwoFloorModel;
import com.blued.android.module.live_china.model.MultiDialogModel;
import com.blued.android.module.live_china.observer.LiveSwipeRefreshObserver;
import com.blued.android.module.live_china.observer.LiveTabNewObserver;
import com.blued.android.module.live_china.observer.LiveTagsSetSelectedTab;
import com.blued.android.module.live_china.pop.LiveLiangExpirePop;
import com.blued.android.module.live_china.pop.LiveLiangIDReceivedPop;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.similarity_operation_provider.BluedURIRouterAdapter;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.api.OnTwoLevelListener;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;
import com.soft.blued.R;
import com.soft.blued.app.BluedApplicationLike;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.customview.LiveHotPullToRefreshLayout;
import com.soft.blued.customview.smartrefresh.TwoLevelRefreshView;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.log.track.EventTrackLive;
import com.soft.blued.ui.home.HomeTabClick;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import com.soft.blued.ui.live.adapter.LiveCategoryAdapter;
import com.soft.blued.ui.live.manager.LiveHotViewScrollObserver;
import com.soft.blued.ui.live.model.LiveClassifyTabModel;
import com.soft.blued.ui.live.presenter.LiveHomePresenter;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveHomeFragment.class */
public class LiveHomeFragment extends MvpFragment<LiveHomePresenter> implements View.OnClickListener, LiveSwipeRefreshObserver.IEnableRefeshObserver, LiveTabNewObserver.ILiveTabRefreshObserver, LiveTagsSetSelectedTab.iLiveTagsSetSelectedTab, HomeTabClick.TabClickListener, LiveHotViewScrollObserver.IScrollObserver {

    /* renamed from: a  reason: collision with root package name */
    public List<LiveTabModel> f31167a;
    @BindView
    AutoScrollViewPager asvp_banner_hot_new;
    @BindView
    FrameLayout asvp_banner_hot_parent;
    public List<LiveTabModel> b;

    /* renamed from: c  reason: collision with root package name */
    public LiveTabModel f31168c;
    private Context f;
    @BindView
    CustomTwoLevelHeader header;
    @BindView
    FrameLayout live_banner;
    @BindView
    ShapeLinearLayout living_count;
    @BindView
    View ll_tab;
    @BindView
    LinePageIndicator lpi_line;
    private BannerPagerAdapter m;
    @BindView
    ViewPager main_live_new_viewpager;
    private MyAdapter o;
    private LiveCategoryAdapter p;
    private LiveTwoFloorModel q;
    private boolean r;
    @BindView
    RecyclerView recycle_view_cateroty;
    @BindView
    RefreshLayout refreshLayout;
    @BindView
    TwoLevelRefreshView refresh_view;
    private long s;
    @BindView
    LiveHotPullToRefreshLayout swipe_view;
    @BindView
    TextView tv_living_count;
    private LiveLiangIDReceivedPop u;
    private LiveLiangExpirePop v;
    private boolean y;
    private List<View> g = new ArrayList();
    private List<BannerViewHolder> k = new ArrayList();
    private List<Unbinder> l = new ArrayList();
    private List<BannerModel> n = new ArrayList();
    public boolean d = false;
    public boolean e = false;
    private boolean t = false;
    private boolean w = false;
    private boolean x = false;
    private Observer<String> z = new Observer<String>() { // from class: com.soft.blued.ui.live.fragment.LiveHomeFragment.1
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(String str) {
            Log.i("xpm", "KEY_EVENT_LIVE_FLOAT_DISMISS");
            LiveListHotFragment D = LiveHomeFragment.this.D();
            if (D == null || D.b == null || !LiveHomeFragment.this.r) {
                return;
            }
            D.b.c();
        }
    };
    private Observer<String> A = new Observer<String>() { // from class: com.soft.blued.ui.live.fragment.LiveHomeFragment.2
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(String str) {
            Log.i("xpm", "KEY_EVENT_BACK_TWO_LEVEL");
            LiveHomeFragment.this.a(new Runnable() { // from class: com.soft.blued.ui.live.fragment.LiveHomeFragment.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (LiveHomeFragment.this.header != null) {
                        LiveHomeFragment.this.header.a();
                    }
                }
            }, 300L);
        }
    };
    private Observer<String> B = new Observer() { // from class: com.soft.blued.ui.live.fragment.-$$Lambda$LiveHomeFragment$XzFHx6v0z3hoKQZuXXkavYlgWVI
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            LiveHomeFragment.this.e((String) obj);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveHomeFragment$BannerPagerAdapter.class */
    public class BannerPagerAdapter extends PagerAdapter {
        BannerPagerAdapter() {
        }

        public void a(List<BannerModel> list) {
            if (list != null) {
                if (LiveHomeFragment.this.n != null) {
                    LiveHomeFragment.this.n.clear();
                } else {
                    LiveHomeFragment.this.n = new ArrayList();
                }
                LiveHomeFragment.this.n.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            if (LiveHomeFragment.this.n != null) {
                return LiveHomeFragment.this.n.size();
            }
            return 0;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            if (LiveHomeFragment.this.n == null || LiveHomeFragment.this.n.size() < i) {
                View inflate = LayoutInflater.from(LiveHomeFragment.this.f).inflate(2131559775, viewGroup, false);
                LiveHomeFragment.this.g.add(inflate);
                return inflate;
            }
            final BannerModel bannerModel = (BannerModel) LiveHomeFragment.this.n.get(i);
            final String str = bannerModel.url;
            while (LiveHomeFragment.this.g.size() < LiveHomeFragment.this.n.size()) {
                BannerViewHolder bannerViewHolder = new BannerViewHolder();
                View inflate2 = LayoutInflater.from(LiveHomeFragment.this.f).inflate(2131559775, viewGroup, false);
                Unbinder a2 = ButterKnife.a(bannerViewHolder, inflate2);
                LiveHomeFragment.this.g.add(inflate2);
                LiveHomeFragment.this.k.add(bannerViewHolder);
                LiveHomeFragment.this.l.add(a2);
            }
            BannerViewHolder bannerViewHolder2 = (BannerViewHolder) LiveHomeFragment.this.k.get(i);
            ImageLoader.a(LiveHomeFragment.this.getFragmentActive(), bannerModel.imgurl).b(2131231620).a(bannerViewHolder2.aariv_banner);
            if (!bannerModel.isShowUrlVisited) {
                FindHttpUtils.b(bannerModel.show_url);
                bannerModel.isShowUrlVisited = true;
            }
            bannerViewHolder2.aariv_banner.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.fragment.LiveHomeFragment.BannerPagerAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (!TextUtils.isEmpty(bannerModel.anchor_id)) {
                        LiveHomeFragment.this.j().d(bannerModel.anchor_id);
                        return;
                    }
                    FindHttpUtils.b(bannerModel.click_url);
                    WebViewShowInfoFragment.show(LiveHomeFragment.this.f, str, 9);
                }
            });
            View view = (View) LiveHomeFragment.this.g.get(i);
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

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveHomeFragment$BannerViewHolder.class */
    class BannerViewHolder {
        @BindView
        ImageView aariv_banner;

        BannerViewHolder() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveHomeFragment$BannerViewHolder_ViewBinding.class */
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

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveHomeFragment$MyAdapter.class */
    public class MyAdapter extends FragmentStatePagerAdapter {
        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            super.destroyItem(viewGroup, i, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return LiveHomeFragment.this.f31167a.size();
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            return new LiveListHotFragment();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return LiveHomeFragment.this.f31167a.get(i).name;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            return super.instantiateItem(viewGroup, i);
        }
    }

    private void E() {
        LiveEventBus.get("live_float_dismiss", String.class).observeForever(this.z);
        LiveEventBus.get("live_back_to_two_level", String.class).observeForever(this.A);
        LiveEventBus.get(EventBusConstant.KEY_EVENT_HOME_CLICK_LIVE_TAB, String.class).observeForever(this.B);
    }

    private void F() {
        LiveEventBus.get("live_float_dismiss", String.class).removeObserver(this.z);
        LiveEventBus.get("live_back_to_two_level", String.class).removeObserver(this.A);
        LiveEventBus.get(EventBusConstant.KEY_EVENT_HOME_CLICK_LIVE_TAB, String.class).removeObserver(this.B);
    }

    private void G() {
        this.f31167a = new ArrayList();
        this.b = new ArrayList();
        this.f31167a.add(0, new LiveTabModel("0", this.f.getString(2131889583), 0, 0));
    }

    private void H() {
        if (LiveRoomPreferences.v() <= 0) {
            Date date = new Date(System.currentTimeMillis());
            if ((date.getYear() * 10000) + ((date.getMonth() + 1) * 100) + date.getDate() > LiveRoomPreferences.w()) {
                LiveRoomHttpUtils.r(new BluedUIHttpResponse<BluedEntityA<LiveFirstChargeInfo>>(getFragmentActive()) { // from class: com.soft.blued.ui.live.fragment.LiveHomeFragment.3
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    /* renamed from: a */
                    public void onUIUpdate(BluedEntityA<LiveFirstChargeInfo> bluedEntityA) {
                        if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                            return;
                        }
                        int i = bluedEntityA.getSingleData().count;
                        LiveRoomPreferences.e(i);
                        if (i == 0) {
                            LiveRoomHttpUtils.e();
                        }
                        LiveHomeFragment.this.b(i);
                    }
                }, getFragmentActive());
            }
        }
    }

    private void I() {
        BannerPagerAdapter bannerPagerAdapter = new BannerPagerAdapter();
        this.m = bannerPagerAdapter;
        this.asvp_banner_hot_new.setAdapter(bannerPagerAdapter);
        this.asvp_banner_hot_new.setInterval(m.ag);
        this.lpi_line.setViewPager(this.asvp_banner_hot_new);
        this.ll_tab.setVisibility(8);
        this.header.b(300);
        this.header.a(new OnTwoLevelListener() { // from class: com.soft.blued.ui.live.fragment.LiveHomeFragment.4
            @Override // com.scwang.smartrefresh.layout.api.OnTwoLevelListener
            public boolean onTwoLevel(RefreshLayout refreshLayout) {
                return false;
            }
        });
        this.refreshLayout.l(false);
        this.refreshLayout.b(new SimpleMultiPurposeListener() { // from class: com.soft.blued.ui.live.fragment.LiveHomeFragment.5
            @Override // com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener, com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
            public void a(RefreshHeader refreshHeader, boolean z, float f, int i, int i2, int i3) {
                super.a(refreshHeader, z, f, i, i2, i3);
                if (LiveHomeFragment.this.y && (LiveHomeFragment.this.getParentFragment() instanceof LiveFragment)) {
                    ((LiveFragment) LiveHomeFragment.this.getParentFragment()).a(f, i);
                }
            }

            @Override // com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener, com.scwang.smartrefresh.layout.listener.OnStateChangedListener
            public void a(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
                if (LiveHomeFragment.this.y) {
                    if (refreshState2 == RefreshState.None) {
                        LiveHomeFragment.this.A();
                        if (LiveHomeFragment.this.q != null && !TextUtils.isEmpty(LiveHomeFragment.this.q.two_floor_picture)) {
                            EventTrackLive.b(LiveProtos.Event.LIVE_HOME_REFRESH_IMAGE_SHOW, LiveHomeFragment.this.q.lid, LiveHomeFragment.this.q.uid, LiveHomeFragment.this.q.id);
                        }
                        if (LiveHomeFragment.this.q == null || StringUtils.a(LiveHomeFragment.this.q.lid, 0L) <= 0) {
                            return;
                        }
                        EventTrackLive.b(LiveProtos.Event.LIVE_HOME_REFRESH_WORD_SHOW, LiveHomeFragment.this.q.lid, LiveHomeFragment.this.q.uid, LiveHomeFragment.this.q.id);
                    } else if (refreshState2 != RefreshState.ReleaseToTwoLevel && refreshState2 == RefreshState.TwoLevelReleased) {
                        LiveHomeFragment.this.j().n();
                        if (LiveHomeFragment.this.q == null) {
                            return;
                        }
                        if (TextUtils.equals("3", LiveHomeFragment.this.q.type) && !TextUtils.isEmpty(LiveHomeFragment.this.q.activity_addr)) {
                            WebViewShowInfoFragment.show(LiveHomeFragment.this.f, LiveHomeFragment.this.q.activity_addr, 14);
                        } else if (!TextUtils.equals("1", LiveHomeFragment.this.q.type) || StringUtils.a(LiveHomeFragment.this.q.lid, 0L) <= 0) {
                        } else {
                            LiveTwoLevelFragment.a(LiveHomeFragment.this.f, "two_floor_live", LiveHomeFragment.this.q);
                        }
                    }
                }
            }

            @Override // com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener, com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public void onRefresh(RefreshLayout refreshLayout) {
                if (LiveHomeFragment.this.y) {
                    LiveListHotFragment D = LiveHomeFragment.this.D();
                    if (D != null && D.b != null) {
                        D.b.d();
                    }
                    LiveTabNewObserver.a().b();
                    LiveTabNewObserver.a().d();
                    LiveTabNewObserver.a().c();
                    LiveHomeFragment.this.swipe_view.a();
                    LiveHomeFragment.this.j().e();
                    if (LiveHomeFragment.this.getParentFragment() instanceof LiveFragment) {
                        ((LiveFragment) LiveHomeFragment.this.getParentFragment()).b(true);
                    }
                }
            }
        });
        if (this.o == null) {
            this.o = new MyAdapter(getChildFragmentManager());
        }
        this.main_live_new_viewpager.setAdapter(this.o);
        this.main_live_new_viewpager.setOffscreenPageLimit(1);
        this.recycle_view_cateroty.setLayoutManager(new GridLayoutManager(this.f, 5));
        LiveCategoryAdapter liveCategoryAdapter = new LiveCategoryAdapter(this);
        this.p = liveCategoryAdapter;
        this.recycle_view_cateroty.setAdapter(liveCategoryAdapter);
        ShapeHelper.b(this.living_count, 2131102269);
        this.living_count.setOnClickListener(this);
        a(new Runnable() { // from class: com.soft.blued.ui.live.fragment.LiveHomeFragment.6
            @Override // java.lang.Runnable
            public void run() {
                if (LiveHomeFragment.this.y) {
                    LiveHomeFragment.this.refreshLayout.b(LiveHomeFragment.this.header);
                }
            }
        });
        j().a(true);
        A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J() {
        j().a(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        if (i != 0 || this.w || this.x) {
            return;
        }
        Date date = new Date(System.currentTimeMillis());
        LiveRoomPreferences.f((date.getYear() * 10000) + ((date.getMonth() + 1) * 100) + date.getDate());
        LiveRouteUtil.a(this, getFragmentActive(), 0, false, 10020);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(String str) {
        Log.i("xpm", "KEY_EVENT_HOME_CLICK_LIVE_TAB");
        a(new Runnable() { // from class: com.soft.blued.ui.live.fragment.-$$Lambda$LiveHomeFragment$YAXqZmEMk4e1VUewsYCYk7RuOAA
            @Override // java.lang.Runnable
            public final void run() {
                LiveHomeFragment.this.J();
            }
        });
    }

    public void A() {
        RefreshLayout refreshLayout = this.refreshLayout;
        if (refreshLayout != null && refreshLayout.getState() == RefreshState.None && (getParentFragment() instanceof LiveFragment)) {
            Log.i("xpm", "setTwoLevelEnable:" + this.t);
            this.header.a(this.t);
            LiveTwoFloorModel liveTwoFloorModel = this.q;
            String str = liveTwoFloorModel != null ? liveTwoFloorModel.two_floor_picture : "";
            if (TextUtils.isEmpty(str)) {
                this.refresh_view.a(this.t, false);
            } else {
                this.refresh_view.a(this.t, true);
            }
            ((LiveFragment) getParentFragment()).a(this.t, str, 0);
            LiveTwoFloorModel liveTwoFloorModel2 = this.q;
            if (liveTwoFloorModel2 == null || liveTwoFloorModel2.anchor == null || TextUtils.isEmpty(this.q.anchor.avatar)) {
                return;
            }
            ImageFileLoader.a(getFragmentActive()).a(this.q.anchor.avatar).a();
        }
    }

    public void B() {
        LiveClassifyTabModel C = C();
        if (C == null) {
            return;
        }
        if (C.getTabModelList().size() <= 0) {
            LiveClassifyTabModel liveClassifyTabModel = new LiveClassifyTabModel();
            liveClassifyTabModel.initTabModelList(this.b);
            BluedPreferences.K(AppInfo.f().toJson(liveClassifyTabModel));
            for (int i = 0; i < this.b.size(); i++) {
                LiveTabModel liveTabModel = this.b.get(i);
                if (liveTabModel.vcode > 0) {
                    liveTabModel.showNew = true;
                    this.e = true;
                }
            }
            return;
        }
        List<LiveTabModel> tabModelList = C.getTabModelList();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.b.size()) {
                return;
            }
            LiveTabModel liveTabModel2 = this.b.get(i3);
            boolean z = false;
            for (int i4 = 0; i4 < tabModelList.size(); i4++) {
                LiveTabModel liveTabModel3 = tabModelList.get(i4);
                if (TextUtils.equals(liveTabModel2.id, liveTabModel3.id)) {
                    if (liveTabModel2.vcode > 0 && liveTabModel2.vcode != liveTabModel3.vcode) {
                        liveTabModel2.showNew = true;
                        this.e = true;
                        Logger.a("drb", "showTabNew = ", Integer.valueOf(i3));
                    }
                    z = true;
                }
            }
            if (!z && liveTabModel2.vcode > 0) {
                liveTabModel2.showNew = true;
                this.e = true;
            }
            i2 = i3 + 1;
        }
    }

    public LiveClassifyTabModel C() {
        String bx = BluedPreferences.bx();
        if (!TextUtils.isEmpty(bx)) {
            try {
                return (LiveClassifyTabModel) AppInfo.f().fromJson(bx, (Class<Object>) LiveClassifyTabModel.class);
            } catch (Exception e) {
            }
        }
        return new LiveClassifyTabModel();
    }

    public LiveListHotFragment D() {
        if (!isAdded() || getChildFragmentManager() == null || getChildFragmentManager().getFragments() == null || getChildFragmentManager().getFragments().size() <= 0) {
            return null;
        }
        Fragment fragment = getChildFragmentManager().getFragments().get(0);
        if (fragment instanceof LiveListHotFragment) {
            return (LiveListHotFragment) fragment;
        }
        return null;
    }

    public void a(int i) {
        if (this.b.size() > i) {
            LiveTabModel liveTabModel = this.b.get(i);
            liveTabModel.showNew = false;
            b(liveTabModel);
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        I();
        LiveHotViewScrollObserver.a().a(this);
        LiveSwipeRefreshObserver.a().a(this);
        LiveTabNewObserver.a().a(this);
        LiveTagsSetSelectedTab.a().a(this);
        E();
        this.y = true;
    }

    @Override // com.soft.blued.ui.live.manager.LiveHotViewScrollObserver.IScrollObserver
    public void a(RecyclerView recyclerView, int i, int i2) {
        if (this.y && i2 == 0) {
        }
    }

    public void a(AnchorLiveStateModel anchorLiveStateModel) {
        String str;
        if (anchorLiveStateModel == null) {
            return;
        }
        if (anchorLiveStateModel.is_live != 1) {
            BluedURIRouterAdapter.openUserInfoPage(this.f, anchorLiveStateModel.uid, anchorLiveStateModel.name, 0, 1, "live_banner", false, "");
            return;
        }
        LiveRoomData liveRoomData = new LiveRoomData(anchorLiveStateModel.lid, 0, "footprint", anchorLiveStateModel.uid, anchorLiveStateModel.name, anchorLiveStateModel.avatar, 0);
        LiveListHotFragment D = D();
        ArrayList arrayList = new ArrayList();
        if (D == null || D.b == null || D.b.a() == null) {
            str = "";
        } else {
            arrayList.addAll(D.b.a());
            str = D.b.b();
        }
        List<LiveRoomData> a2 = LiveRoomInfoChannel.a(arrayList, str);
        if (a2 != null) {
            a2.add(0, liveRoomData);
        }
        LiveRoomInfoChannel.a(AppInfo.d(), liveRoomData, 0, a2);
    }

    public void a(LiveTabInfo liveTabInfo) {
        Log.i("xpm", "receive showLiveTab");
        if (liveTabInfo == null || liveTabInfo.liveTabs.size() == 0) {
            this.ll_tab.setVisibility(8);
            return;
        }
        int i = 0;
        this.ll_tab.setVisibility(0);
        this.b.clear();
        this.b.addAll(liveTabInfo.liveTabs);
        this.f31168c = liveTabInfo.liveTabModelExtra;
        B();
        z();
        if (this.f31168c != null) {
            LiveTabModel liveTabModel = null;
            if (this.b != null) {
                while (true) {
                    liveTabModel = null;
                    if (i >= this.b.size()) {
                        break;
                    } else if (TextUtils.equals(this.f31168c.default_cate_id, this.b.get(i).id)) {
                        liveTabModel = this.b.get(i);
                        break;
                    } else {
                        i++;
                    }
                }
            }
            LiveTabModel liveTabModel2 = liveTabModel;
            if (liveTabModel == null) {
                liveTabModel2 = this.f31168c;
                liveTabModel2.id = liveTabModel2.default_cate_id;
            }
            a(liveTabModel2);
        }
    }

    public void a(LiveTabModel liveTabModel) {
        ViewPager b;
        ViewPager b2;
        if (liveTabModel == null) {
            return;
        }
        if (TextUtils.equals(liveTabModel.id, "0") || TextUtils.isEmpty(liveTabModel.id)) {
            Fragment findFragmentByTag = getActivity().getSupportFragmentManager().findFragmentByTag("live");
            LiveFragment liveFragment = null;
            if (findFragmentByTag != null) {
                liveFragment = null;
                if (findFragmentByTag instanceof LiveFragment) {
                    liveFragment = (LiveFragment) findFragmentByTag;
                }
            }
            if (liveFragment == null || (b = liveFragment.b()) == null) {
                return;
            }
            b.setCurrentItem(1);
        } else if (!TextUtils.equals(liveTabModel.id, "11") && !TextUtils.equals(liveTabModel.id, "12")) {
            LiveListTabFragment.a(this.f, liveTabModel.id, liveTabModel.name, liveTabModel.type);
        } else {
            Fragment findFragmentByTag2 = getActivity().getSupportFragmentManager().findFragmentByTag("live");
            LiveFragment liveFragment2 = null;
            if (findFragmentByTag2 != null) {
                liveFragment2 = null;
                if (findFragmentByTag2 instanceof LiveFragment) {
                    liveFragment2 = (LiveFragment) findFragmentByTag2;
                }
            }
            if (liveFragment2 == null || (b2 = liveFragment2.b()) == null) {
                return;
            }
            b2.setCurrentItem(0);
        }
    }

    public void a(MultiDialogModel multiDialogModel) {
        if (multiDialogModel == null || multiDialogModel.from_type < 0) {
            LiveRouteUtil.a(this, (MultiDialogModel) null);
        } else {
            LiveRouteUtil.a(this, multiDialogModel);
        }
    }

    public void a(List<BannerModel> list) {
        Log.i("xpm", "receive showBanner");
        if (list == null || list.size() <= 0) {
            this.asvp_banner_hot_parent.setVisibility(8);
            this.lpi_line.setVisibility(8);
            return;
        }
        this.lpi_line.setVisibility(0);
        if (list.size() == 1) {
            this.lpi_line.setVisibility(8);
        }
        this.m.a(list);
        this.asvp_banner_hot_parent.setVisibility(0);
        this.asvp_banner_hot_new.a();
        this.asvp_banner_hot_new.setCurrentItem(0, false);
        this.lpi_line.a(this.asvp_banner_hot_new, 0);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void af_() {
        super.af_();
        this.y = false;
        List<Unbinder> list = this.l;
        if (list != null) {
            for (Unbinder unbinder : list) {
                unbinder.unbind();
            }
            this.l.clear();
        }
        this.g.clear();
        this.k.clear();
        F();
        LiveHotViewScrollObserver.a().b(this);
        LiveSwipeRefreshObserver.a().b(this);
        LiveTabNewObserver.a().b(this);
        LiveTagsSetSelectedTab.a().b(this);
    }

    @Override // com.blued.android.module.live_china.observer.LiveTabNewObserver.ILiveTabRefreshObserver
    public void ag_() {
    }

    @Override // com.blued.android.module.live_china.observer.LiveSwipeRefreshObserver.IEnableRefeshObserver
    public void b() {
        this.refreshLayout.j();
    }

    public void b(LiveTabModel liveTabModel) {
        LiveClassifyTabModel C = C();
        if (C == null) {
            return;
        }
        LiveTabModel findTabModel = C.findTabModel(liveTabModel.id);
        if (findTabModel == null) {
            C.addItem(liveTabModel);
        } else {
            findTabModel.update(liveTabModel);
        }
        BluedPreferences.L(AppInfo.f().toJson(C));
    }

    @Override // com.blued.android.module.live_china.observer.LiveTagsSetSelectedTab.iLiveTagsSetSelectedTab
    public void b(String str) {
        ViewPager b;
        ViewPager b2;
        LiveTabModel liveTabModel;
        if (this.y) {
            if (TextUtils.equals(str, "0") || TextUtils.isEmpty(str)) {
                if (getActivity() == null) {
                    return;
                }
                Fragment findFragmentByTag = getActivity().getSupportFragmentManager().findFragmentByTag("live");
                LiveFragment liveFragment = null;
                if (findFragmentByTag != null) {
                    liveFragment = null;
                    if (findFragmentByTag instanceof LiveFragment) {
                        liveFragment = (LiveFragment) findFragmentByTag;
                    }
                }
                if (liveFragment == null || (b = liveFragment.b()) == null) {
                    return;
                }
                b.setCurrentItem(1);
            } else if (TextUtils.equals(str, "11") || TextUtils.equals(str, "12")) {
                Fragment findFragmentByTag2 = getActivity().getSupportFragmentManager().findFragmentByTag("live");
                LiveFragment liveFragment2 = null;
                if (findFragmentByTag2 != null) {
                    liveFragment2 = null;
                    if (findFragmentByTag2 instanceof LiveFragment) {
                        liveFragment2 = (LiveFragment) findFragmentByTag2;
                    }
                }
                if (liveFragment2 == null || (b2 = liveFragment2.b()) == null) {
                    return;
                }
                b2.setCurrentItem(0);
            } else {
                LiveCategoryAdapter liveCategoryAdapter = this.p;
                if (liveCategoryAdapter == null || liveCategoryAdapter.getData().size() <= 0) {
                    return;
                }
                Iterator<LiveTabModel> it = this.p.getData().iterator();
                while (true) {
                    liveTabModel = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    liveTabModel = it.next();
                    if (liveTabModel != null && TextUtils.equals(liveTabModel.id, str)) {
                        break;
                    }
                }
                if (liveTabModel != null) {
                    LiveListTabFragment.a(this.f, liveTabModel.id, liveTabModel.name, liveTabModel.type);
                }
            }
        }
    }

    public void b(List<LiveTwoFloorModel> list) {
        Log.i("xpm", "receive setTwoLevel");
        if (list == null || list.size() <= 0) {
            this.t = false;
        } else {
            LiveTwoFloorModel liveTwoFloorModel = list.get(0);
            this.q = liveTwoFloorModel;
            if (liveTwoFloorModel == null) {
                this.t = false;
            } else if (TextUtils.equals("1", liveTwoFloorModel.type) && StringUtils.a(this.q.lid, 0L) > 0) {
                this.t = true;
            } else if (!TextUtils.equals("3", this.q.type) || TextUtils.isEmpty(this.q.activity_addr)) {
                this.t = false;
            } else {
                this.t = true;
            }
        }
        A();
    }

    @Override // com.blued.android.module.live_china.observer.LiveSwipeRefreshObserver.IEnableRefeshObserver
    public void c() {
        Log.i("xpm", "autoRefresh 1");
        this.refreshLayout.i();
    }

    @Override // com.soft.blued.ui.home.HomeTabClick.TabClickListener
    public void c(String str) {
        if (this.y && "live".equals(str) && this.r) {
            Log.i("xpm", "autoRefresh 4");
            this.refreshLayout.i();
        }
    }

    public void c(List<LiveLiangModel> list) {
        LiveLiangModel liveLiangModel;
        Log.i("xpm", "receive LIVE_LIANG_ID");
        if (list != null && list.size() > 0 && (liveLiangModel = list.get(0)) != null) {
            if (liveLiangModel.is_first_default == 1) {
                liveLiangModel.is_first_default = 0;
                this.w = true;
                LiveLiangIDReceivedPop liveLiangIDReceivedPop = this.u;
                if (liveLiangIDReceivedPop != null && liveLiangIDReceivedPop.s()) {
                    return;
                }
                this.u = LiveLiangIDReceivedPop.a(this.f, liveLiangModel.liang_id, getFragmentActive());
            } else if (StringUtils.a(liveLiangModel.expire, 0L) > 0 && StringUtils.a(liveLiangModel.expire, 0L) <= 86400) {
                this.w = true;
                LiveLiangExpirePop liveLiangExpirePop = this.v;
                if (liveLiangExpirePop != null && liveLiangExpirePop.s()) {
                    return;
                }
                if (!LiveRoomPreferences.L()) {
                    LiveRoomPreferences.d(true);
                    this.v = LiveLiangExpirePop.a(this.f, liveLiangModel.liang_id);
                }
            }
        }
        if (this.w) {
            return;
        }
        H();
    }

    @Override // com.blued.android.module.live_china.observer.LiveTabNewObserver.ILiveTabRefreshObserver
    public void d() {
    }

    @Override // com.soft.blued.ui.home.HomeTabClick.TabClickListener
    public void d(String str) {
        if (this.y && "live".equals(str) && this.r) {
            c(str);
        }
    }

    @Override // com.blued.android.module.live_china.observer.LiveTabNewObserver.ILiveTabRefreshObserver
    public void e() {
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_live_home_view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewPager b;
        Tracker.onClick(view);
        if (view.getId() != 2131367602) {
            return;
        }
        Fragment findFragmentByTag = getActivity().getSupportFragmentManager().findFragmentByTag("live");
        LiveFragment liveFragment = null;
        if (findFragmentByTag != null) {
            liveFragment = null;
            if (findFragmentByTag instanceof LiveFragment) {
                liveFragment = (LiveFragment) findFragmentByTag;
            }
        }
        if (liveFragment == null || (b = liveFragment.b()) == null) {
            return;
        }
        b.setCurrentItem(2);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f = getActivity();
        G();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        HomeTabClick.b("live", this);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        LiveListHotFragment D;
        super.onPause();
        this.x = true;
        if (this.s == 0) {
            this.s = System.currentTimeMillis();
        }
        if (!this.r || (D = D()) == null || D.b == null) {
            return;
        }
        Log.i("xpm", "LiveHome onPause");
        D.b.d();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        LiveListHotFragment D;
        super.onResume();
        this.x = false;
        if (this.r && this.s != 0) {
            if (System.currentTimeMillis() - this.s > 300000) {
                Log.i("xpm", "autoRefresh 2");
                this.refreshLayout.i();
            }
            this.s = 0L;
        }
        if (this.r && (D = D()) != null && D.b != null) {
            Log.i("xpm", "LiveHome onResume");
            D.b.c();
        }
        ShapeLinearLayout shapeLinearLayout = this.living_count;
        if (shapeLinearLayout != null) {
            ShapeHelper.b(shapeLinearLayout, 2131102269);
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onStart() {
        MyAdapter myAdapter;
        super.onStart();
        if (!BluedApplicationLike.SPECIAL_DEVICE_FOR_VIEW_OVERFLOW || (myAdapter = this.o) == null || myAdapter.getCount() <= 1) {
            return;
        }
        this.main_live_new_viewpager.setOffscreenPageLimit(this.o.getCount());
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.x = true;
        if (BluedApplicationLike.SPECIAL_DEVICE_FOR_VIEW_OVERFLOW) {
            this.main_live_new_viewpager.setOffscreenPageLimit(1);
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.asvp_banner_hot_parent.getLayoutParams();
        layoutParams.width = AppInfo.l - DisplayUtil.a(getContext(), 24.0f);
        layoutParams.height = (int) ((layoutParams.width * 140.0f) / 702.0f);
        this.asvp_banner_hot_parent.setLayoutParams(layoutParams);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public boolean q() {
        return true;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.r = z;
        if (z) {
            HomeTabClick.a("live", this);
        }
        LiveListHotFragment D = D();
        if (D == null || D.b == null) {
            return;
        }
        D.b.b(z);
        if (this.r) {
            D.b.c();
        } else {
            D.b.d();
        }
    }

    public void v() {
    }

    public void w() {
        Log.i("xpm", "receive showBannerNodata");
        this.asvp_banner_hot_parent.setVisibility(8);
        this.lpi_line.setVisibility(8);
    }

    public void x() {
        Log.i("xpm", "receive setTwoLevelNodata");
        this.t = false;
        this.q = null;
        A();
    }

    public void y() {
        this.d = true;
        ArrayList arrayList = new ArrayList();
        if (this.b.size() > 10) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 > 8) {
                    break;
                }
                arrayList.add(this.b.get(i2));
                i = i2 + 1;
            }
            LiveTabModel liveTabModel = new LiveTabModel("15", getText(2131889736).toString(), 0, 0);
            LiveTabModel liveTabModel2 = this.f31168c;
            if (liveTabModel2 != null) {
                liveTabModel.less_cate_icon = liveTabModel2.less_cate_icon;
                liveTabModel.more_cate_icon = this.f31168c.more_cate_icon;
            }
            arrayList.add(liveTabModel);
            int i3 = 9;
            while (true) {
                int i4 = i3;
                if (i4 >= this.b.size()) {
                    break;
                }
                arrayList.add(this.b.get(i4));
                i3 = i4 + 1;
            }
        } else {
            for (int i5 = 0; i5 < this.b.size(); i5++) {
                arrayList.add(this.b.get(i5));
            }
        }
        this.p.a(arrayList);
    }

    public void z() {
        this.d = false;
        ArrayList arrayList = new ArrayList();
        if (this.b.size() > 10) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.b.size()) {
                    break;
                }
                if (i2 <= 8) {
                    arrayList.add(this.b.get(i2));
                }
                i = i2 + 1;
            }
            LiveTabModel liveTabModel = new LiveTabModel("15", getText(2131889823).toString(), 0, 0);
            LiveTabModel liveTabModel2 = this.f31168c;
            if (liveTabModel2 != null) {
                liveTabModel.less_cate_icon = liveTabModel2.less_cate_icon;
                liveTabModel.more_cate_icon = this.f31168c.more_cate_icon;
            }
            arrayList.add(liveTabModel);
        } else {
            for (int i3 = 0; i3 < this.b.size(); i3++) {
                arrayList.add(this.b.get(i3));
            }
        }
        this.p.a(arrayList);
    }
}
