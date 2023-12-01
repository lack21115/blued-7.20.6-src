package com.blued.community.ui.square.fragment;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.common.utils.RefreshUtils;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.svgaplayer.SVGACallback;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.svgaplayer.SVGAPlayer;
import com.blued.android.statistics.BluedStatistics;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.manager.CommunityManager;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.model.FeedDiversionModel;
import com.blued.community.track.ByteDanceEvent;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.feed.model.RecommendFeedRefreshGuideModel;
import com.blued.community.ui.send.fragment.FeedAddPostFragment;
import com.blued.community.ui.square.model.CommBannerModel;
import com.blued.community.ui.square.model.DiscoverSquareExtra;
import com.blued.community.ui.square.presenter.RecommendFeedPresenter;
import com.blued.community.ui.square.view.DiscoveryEntryView;
import com.blued.community.utils.CommRouteUtil;
import com.blued.community.utils.CommunityPreferences;
import com.blued.community.view.CommAutoScrollBannerView;
import com.blued.community.view.FeedOperationFloatView;
import com.blued.community.view.FloatFooterView;
import com.blued.das.client.feed.FeedProtos;
import com.blued.track.trackUtils.EventTrackGuy;
import com.google.android.material.appbar.AppBarLayout;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/square/fragment/RecommendFeedFragment.class */
public class RecommendFeedFragment<T extends RecommendFeedPresenter> extends MvpFragment<RecommendFeedPresenter> {

    /* renamed from: a  reason: collision with root package name */
    FeedListAdapterForRecyclerView f20169a;

    /* renamed from: c  reason: collision with root package name */
    private CoordinatorLayout f20170c;
    private AppBarLayout d;
    private CommAutoScrollBannerView e;
    private LinearLayout f;
    private View g;
    private NoDataAndLoadFailView k;
    private SmartRefreshLayout l;
    private RecyclerView m;
    private FloatFooterView n;
    private ImageView o;
    private FeedOperationFloatView p;
    private View q;
    private SVGAImageView r;
    private LinearLayoutManager s;
    private FeedDiversionModel t;
    private int u = 0;
    private RecommendFeedFragment<T>.RecommendHandler v = new RecommendHandler();
    private boolean w = false;
    private boolean x = false;
    private boolean y = false;
    private boolean z = false;
    private boolean A = false;
    private int B = 0;
    public boolean b = true;
    private int C = -1;
    private final int D = 1;
    private final int E = 2;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/square/fragment/RecommendFeedFragment$RecommendHandler.class */
    public class RecommendHandler extends Handler {
        private RecommendHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                RecommendFeedFragment.this.D();
            } else if (RecommendFeedFragment.this.w) {
            } else {
                RecommendFeedFragment.this.d(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public void H() {
        B();
        x();
    }

    private void B() {
        FeedDiversionModel feedDiversionModel = this.t;
        if (feedDiversionModel == null) {
            this.p.setOperationData(null);
            return;
        }
        this.p.setOperationData(feedDiversionModel.getSuspension_bubble());
        if (this.t.getSuspension_bubble() != null) {
            CommunityManager.f19086a.a().a(0);
            CommunityPreferences.w("RecommendDrawDepthBubbleShowCount");
        }
        this.x = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        LogUtils.c("推荐下滑 onListDataSet: " + this.u + ", isOperationFloatViewShown:" + this.x);
        if (TextUtils.isEmpty(j().h)) {
            LogUtils.c("推荐下滑 strBubbleInsertFeedId == null");
        } else {
            int i = this.u;
            if (i == 1) {
                this.v.removeMessages(1);
                this.v.sendEmptyMessageDelayed(1, 1000L);
            } else if (i == 2 && !this.x) {
                this.v.removeMessages(2);
                this.v.sendEmptyMessageDelayed(2, 1000L);
            }
        }
        this.w = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        j().h = null;
        if (this.w || this.x) {
            return;
        }
        RecommendFeedRefreshGuideModel a2 = this.f20169a.a(1, 2);
        if (a2 == null || a2.getLocY() < 0) {
            LogUtils.c("推荐下滑 model == null || model.getLocY() < 0");
            return;
        }
        this.C = a2.getIndex();
        LogUtils.c("推荐下滑 getItemViewLocY: " + a2);
        int locY = (a2.getLocY() - AppInfo.m) + FeedMethods.c(44) + FeedMethods.c(68);
        int abs = (int) (((float) Math.abs(locY)) / 2.1f);
        LogUtils.c("推荐下滑 distance: " + locY + ", time:" + abs);
        this.m.smoothScrollBy(0, locY, new LinearInterpolator(), abs);
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.square.fragment.-$$Lambda$RecommendFeedFragment$8X_zU7dkPwT1jkhjt7LiSuhC_BE
            @Override // java.lang.Runnable
            public final void run() {
                RecommendFeedFragment.this.G();
            }
        }, (long) abs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E */
    public void G() {
        LogUtils.c("推荐下滑 执行刷新动画");
        if (this.q.getVisibility() == 0) {
            return;
        }
        this.b = true;
        this.q.setVisibility(0);
        new SVGAPlayer.Builder().a("recommend_refresh_guide_arrow_gray.svga").a((Integer) 1).a(this.r);
        this.r.setCallback(new SVGACallback() { // from class: com.blued.community.ui.square.fragment.RecommendFeedFragment.10
            @Override // com.blued.android.module.svgaplayer.SVGACallback
            public void onFinished() {
                RecommendFeedFragment.this.F();
            }

            @Override // com.blued.android.module.svgaplayer.SVGACallback
            public void onPause() {
            }

            @Override // com.blued.android.module.svgaplayer.SVGACallback
            public void onRepeat() {
            }

            @Override // com.blued.android.module.svgaplayer.SVGACallback
            public void onStep(int i, double d) {
            }
        });
        EventTrackFeed.a(FeedProtos.Event.FEED_RECOMMEND_GLIDE_GUIDE_SHOW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        if (k()) {
            this.q.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(RecommendFeedRefreshGuideModel recommendFeedRefreshGuideModel, int i) {
        LogUtils.c("推荐下滑 列表滑动后设置动画， position:" + recommendFeedRefreshGuideModel.getIndex());
        if (this.f20169a.getData().size() > 0) {
            if (i == 2) {
                this.f20169a.e(recommendFeedRefreshGuideModel.getIndex());
            } else if (i == 1 && this.A) {
                this.f20169a.e(recommendFeedRefreshGuideModel.getIndex());
            } else {
                ((BluedIngSelfFeed) this.f20169a.getData().get(recommendFeedRefreshGuideModel.getIndex())).isRecommendRefreshGuideFeed = true;
                ((BluedIngSelfFeed) this.f20169a.getData().get(recommendFeedRefreshGuideModel.getIndex())).playAnimType = 8;
                FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.f20169a;
                feedListAdapterForRecyclerView.notifyItemChanged(feedListAdapterForRecyclerView.getHeaderLayoutCount() + recommendFeedRefreshGuideModel.getIndex());
                LogUtils.c("推荐下滑 设置赞转评缩放动画， position:" + recommendFeedRefreshGuideModel.getIndex());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Boolean bool) {
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.square.fragment.-$$Lambda$RecommendFeedFragment$pgKXszlhIv4vW5PEP4pGzeONDE0
            @Override // java.lang.Runnable
            public final void run() {
                RecommendFeedFragment.this.H();
            }
        }, 2000L);
    }

    private void b(boolean z) {
        this.l.j();
        this.l.h();
        if (this.f20169a.getData().size() > 0) {
            this.k.d();
        } else if (z) {
            this.k.a();
        } else {
            this.k.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final int i) {
        j().h = null;
        LogUtils.c("推荐下滑 场景type=" + i);
        if (this.u != 1) {
            return;
        }
        int i2 = this.B;
        if (i2 < 0) {
            i2 = 0;
        }
        final RecommendFeedRefreshGuideModel a2 = this.f20169a.a(i2, 1);
        if (a2 == null || a2.getLocY() < 0) {
            LogUtils.c("推荐下滑 model == null || model.getLocY() < 0");
            return;
        }
        this.C = a2.getIndex();
        LogUtils.c("推荐下滑 getItemViewLocY: " + a2);
        int locY = a2.getLocY() - (AppInfo.m / 2);
        int abs = (int) (((float) Math.abs(locY)) / 2.1f);
        LogUtils.c("推荐下滑 执行列表滑动 distance: " + locY + ", time:" + abs);
        int height = this.d.getHeight();
        StringBuilder sb = new StringBuilder();
        sb.append("推荐下滑 appbarHeight=");
        sb.append(height);
        LogUtils.c(sb.toString());
        AppBarLayout appBarLayout = this.d;
        if (appBarLayout != null) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).getBehavior();
            LogUtils.c("推荐下滑 topAndBottomOffset:" + (behavior instanceof AppBarLayout.Behavior ? ((AppBarLayout.Behavior) behavior).getTopAndBottomOffset() : 0));
            if (behavior == null || locY > height) {
                behavior.onNestedPreScroll(this.f20170c, this.d, this.m, 0, height, new int[]{0, 0}, 1);
                this.m.smoothScrollBy(0, locY - height, new LinearInterpolator(), abs);
            } else {
                behavior.onNestedPreScroll(this.f20170c, this.d, this.m, 0, locY, new int[]{0, 0}, 1);
            }
        } else {
            this.m.smoothScrollBy(0, locY, new LinearInterpolator(), abs);
        }
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.square.fragment.-$$Lambda$RecommendFeedFragment$5XCWAzNsXlvIfo2aaiYxo08jYYs
            @Override // java.lang.Runnable
            public final void run() {
                RecommendFeedFragment.this.a(a2, i);
            }
        }, abs);
    }

    private void w() {
        this.f20170c = (CoordinatorLayout) this.i.findViewById(R.id.coordinator);
        this.d = (AppBarLayout) this.i.findViewById(R.id.appbar);
        this.e = (CommAutoScrollBannerView) this.i.findViewById(R.id.fl_ads);
        this.f = (LinearLayout) this.i.findViewById(R.id.ll_entry);
        this.g = this.i.findViewById(R.id.line_entry);
        this.k = (NoDataAndLoadFailView) this.i.findViewById(R.id.view_nodata);
        this.l = (SmartRefreshLayout) this.i.findViewById(R.id.refresh_layout);
        this.m = (RecyclerView) this.i.findViewById(R.id.recycler_view);
        this.n = (FloatFooterView) this.i.findViewById(R.id.ll_feed_post);
        this.o = (ImageView) this.i.findViewById(R.id.img_guide);
        FeedOperationFloatView feedOperationFloatView = (FeedOperationFloatView) this.i.findViewById(R.id.feed_operation_float_view_id);
        this.p = feedOperationFloatView;
        feedOperationFloatView.setFrom(2);
        this.q = this.i.findViewById(R.id.feed_refresh_guide_layout);
        this.r = (SVGAImageView) this.i.findViewById(R.id.feed_refresh_guide_iv);
    }

    private void x() {
        FeedDiversionModel feedDiversionModel = this.t;
        if (feedDiversionModel == null || feedDiversionModel.getButton_bubble() == null || this.t.getButton_bubble().getPush_content() == null) {
            this.o.setVisibility(8);
            return;
        }
        String img = this.t.getButton_bubble().getPush_content().getImg();
        int p_id = this.t.getButton_bubble().getP_id();
        if (TextUtils.isEmpty(img)) {
            this.o.setVisibility(8);
            return;
        }
        this.o.setVisibility(0);
        CommunityPreferences.w("RecommendDrawDepthBubbleShowCount");
        ImageLoader.a(getFragmentActive(), img).f().g(-1).a(new ImageLoadResult(getFragmentActive()) { // from class: com.blued.community.ui.square.fragment.RecommendFeedFragment.4
            @Override // com.blued.android.core.image.ImageLoadResult
            public void a() {
            }

            @Override // com.blued.android.core.image.ImageLoadResult
            public void a(int i, Exception exc) {
                RecommendFeedFragment.this.o.setVisibility(8);
            }
        }).a(this.o);
        EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_GUIDE_POP_SHOW, FeedProtos.SourcePage.FEED_PLAZA_RECOMMEND, String.valueOf(p_id));
    }

    private void y() {
        FeedDiversionModel feedDiversionModel = this.t;
        if (feedDiversionModel == null || feedDiversionModel.getButton_bubble() == null || this.t.getButton_bubble().getPush_content() == null) {
            return;
        }
        int p_id = this.t.getButton_bubble().getP_id();
        if (this.t.getButton_bubble().getTarget_path() == 1) {
            CommRouteUtil.a(getActivity());
        } else if (this.t.getButton_bubble().getTarget_path() == 2) {
            CommunityServiceManager.b().a(getContext(), this.t.getButton_bubble().getTarget_link());
        }
        this.o.setVisibility(8);
        FeedHttpUtils.a(2, 1, p_id, getFragmentActive());
        EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_GUIDE_POP_CLICK, FeedProtos.SourcePage.FEED_PLAZA_RECOMMEND, String.valueOf(p_id));
        CommunityPreferences.a("RecommendDrawDepthBubbleShowCount", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        CommunityServiceManager.d().a("feed_post_btn_click", 1);
        EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_BTN_CLICK, FeedProtos.FeedFrom.PUBLISH_PLAZA_RECOMMEND, FeedMethods.b(), "");
        FeedAddPostFragment.a(getContext(), true);
    }

    public void a(int i) {
        this.w = true;
        this.B = i;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        w();
        c();
        b();
    }

    public void a(RecyclerView recyclerView, int i) {
        if (k()) {
            FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.f20169a;
            if (feedListAdapterForRecyclerView != null && feedListAdapterForRecyclerView.s != null) {
                this.f20169a.s.onScrollStateChanged(recyclerView, i);
            }
            if (this.n == null || i != 0) {
                return;
            }
            if (!recyclerView.canScrollVertically(-1)) {
                LogUtils.c("到达底部");
                this.n.startBtmBtnShow();
            } else if (recyclerView.canScrollVertically(1)) {
            } else {
                LogUtils.c("到达顶部");
                this.n.startBtmBtnHide();
            }
        }
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        if (k()) {
            if (i2 < 0) {
                this.n.startBtmBtnShow();
            } else if (i2 > 0) {
                this.n.startBtmBtnHide();
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(final String str, List list) {
        boolean z;
        super.a(str, list);
        switch (str.hashCode()) {
            case -2109989095:
                if (str.equals("delete_circle_feed")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -2025065628:
                if (str.equals("FEED_FLOAT_OP_DATA")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1925279588:
                if (str.equals("discover_entry")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1542303787:
                if (str.equals("discover_picture_list")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1045564913:
                if (str.equals("featured_list")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 283250254:
                if (str.equals("feed_data_list_refresh")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case 1898642770:
                if (str.equals("featured_list_cache")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        switch (z) {
            case false:
                this.b = false;
                this.C = -1;
                this.f20169a.a(System.currentTimeMillis());
                return;
            case true:
                MvpUtils.a(list, CommBannerModel.class, new MvpUtils.DataListHandler<CommBannerModel>() { // from class: com.blued.community.ui.square.fragment.RecommendFeedFragment.5
                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                    public void a() {
                        RecommendFeedFragment.this.e.setVisibleFromOuter(8);
                    }

                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                    public void a(List<CommBannerModel> list2) {
                        RecommendFeedFragment.this.e.setBannerData(list2);
                    }
                });
                return;
            case true:
                MvpUtils.a(list, String.class, new MvpUtils.DataHandler<String>() { // from class: com.blued.community.ui.square.fragment.RecommendFeedFragment.6
                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataHandler
                    public void a() {
                    }

                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataHandler
                    public void a(String str2) {
                        RecommendFeedFragment.this.f20169a.b(str2);
                    }
                });
                return;
            case true:
            case true:
                MvpUtils.a(list, BluedIngSelfFeed.class, new MvpUtils.DataListHandler<BluedIngSelfFeed>() { // from class: com.blued.community.ui.square.fragment.RecommendFeedFragment.7
                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                    public void a() {
                    }

                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                    public void a(List<BluedIngSelfFeed> list2) {
                        if ("featured_list".equalsIgnoreCase(str) && RecommendFeedFragment.this.b && RecommendFeedFragment.this.C >= 0) {
                            int i = RecommendFeedFragment.this.C;
                            while (true) {
                                int i2 = i + 1;
                                if (i2 >= list2.size()) {
                                    break;
                                }
                                list2.get(i2).isAfterRecommendRefreshGuide = true;
                                i = i2;
                            }
                        }
                        RecommendFeedFragment.this.f20169a.setNewData(list2);
                        if ("featured_list".equalsIgnoreCase(str)) {
                            RecommendFeedFragment.this.C();
                        }
                    }
                });
                return;
            case true:
                MvpUtils.a(list, DiscoverSquareExtra.Explore.class, new MvpUtils.DataListHandler<DiscoverSquareExtra.Explore>() { // from class: com.blued.community.ui.square.fragment.RecommendFeedFragment.8
                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                    public void a() {
                    }

                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                    public void a(List<DiscoverSquareExtra.Explore> list2) {
                        RecommendFeedFragment.this.a(list2);
                    }
                });
                return;
            case true:
                MvpUtils.a(list, FeedDiversionModel.class, new MvpUtils.DataListHandler<FeedDiversionModel>() { // from class: com.blued.community.ui.square.fragment.RecommendFeedFragment.9
                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                    public void a() {
                        RecommendFeedFragment.this.t = null;
                        RecommendFeedFragment.this.H();
                    }

                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                    public void a(List<FeedDiversionModel> list2) {
                        if (list2.size() > 0) {
                            RecommendFeedFragment.this.t = list2.get(0);
                        }
                        if (RecommendFeedFragment.this.e.isSvgaAnimPlaying()) {
                            return;
                        }
                        RecommendFeedFragment.this.H();
                    }
                });
                return;
            default:
                return;
        }
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

    protected void a(List<DiscoverSquareExtra.Explore> list) {
        this.f.removeAllViews();
        for (DiscoverSquareExtra.Explore explore : list) {
            DiscoveryEntryView discoveryEntryView = new DiscoveryEntryView(getContext(), getFragmentActive());
            this.f.addView(discoveryEntryView);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) discoveryEntryView.getLayoutParams();
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            discoveryEntryView.setLayoutParams(layoutParams);
            discoveryEntryView.a(explore, getFragmentActive());
        }
        this.g.setVisibility(0);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void af_() {
        super.af_();
    }

    public void b() {
        this.n.setOnBtnClickListener(new FloatFooterView.OnBtnClickListener() { // from class: com.blued.community.ui.square.fragment.RecommendFeedFragment.1
            @Override // com.blued.community.view.FloatFooterView.OnBtnClickListener
            public void onPostFeedClick() {
                RecommendFeedFragment.this.z();
            }
        });
        this.n.setBtnAnimatorUpdateListener(new FloatFooterView.BtnAnimatorUpdateListener() { // from class: com.blued.community.ui.square.fragment.RecommendFeedFragment.2
            @Override // com.blued.community.view.FloatFooterView.BtnAnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (RecommendFeedFragment.this.o != null) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) RecommendFeedFragment.this.o.getLayoutParams();
                    layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, -intValue);
                    RecommendFeedFragment.this.o.setLayoutParams(layoutParams);
                }
            }
        });
        if (this.f20169a == null) {
            this.f20169a = new FeedListAdapterForRecyclerView(getContext(), this, this.m, 6);
        }
        j().a(this.f20169a);
        this.m.setAdapter(this.f20169a);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.s = linearLayoutManager;
        this.m.setLayoutManager(linearLayoutManager);
        this.l.a(new OnRefreshLoadMoreListener() { // from class: com.blued.community.ui.square.fragment.RecommendFeedFragment.3
            @Override // com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
            public void onLoadMore(RefreshLayout refreshLayout) {
                RecommendFeedFragment.this.j().f();
            }

            @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public void onRefresh(RefreshLayout refreshLayout) {
                RecommendFeedFragment.this.j().e();
                EventTrackGuy.a("find_recommend");
            }
        });
        this.o.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.square.fragment.-$$Lambda$RecommendFeedFragment$vdvxrJMMpJ_LN_W65n4lW3ehO8o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecommendFeedFragment.this.a(view);
            }
        });
        LiveEventBus.get("FEED_RECOMMEND_BANNER_ADV_ANIM_FINISH", Boolean.class).observe(this, new Observer() { // from class: com.blued.community.ui.square.fragment.-$$Lambda$RecommendFeedFragment$DWQvndibKqVDxoSktyhxbSYH67s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RecommendFeedFragment.this.a((Boolean) obj);
            }
        });
        String a2 = BluedStatistics.g().a("推荐feed下滑交互引导实验_RecommendedMore", "");
        LogUtils.c("推荐下滑--> getAbConfig=" + a2);
        if ("RecommendedBehavior".equalsIgnoreCase(a2)) {
            this.u = 1;
        } else if ("RecommendedDirectly".equalsIgnoreCase(a2)) {
            this.u = 2;
        }
        LogUtils.c("推荐下滑--> 实验组=" + this.u);
    }

    public void b(int i) {
        this.y = true;
        this.w = true;
        this.B = i;
        LogUtils.c("推荐下滑 点击用户头像");
    }

    public void c() {
        this.k.d();
    }

    public void c(int i) {
        this.y = true;
        this.w = true;
        this.B = i;
        LogUtils.c("推荐下滑 点击进入详情页");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        RecyclerView recyclerView;
        if (this.l == null || (recyclerView = this.m) == null) {
            return;
        }
        recyclerView.scrollToPosition(0);
        RefreshUtils.a(this.d);
        this.l.d(100);
    }

    public void e() {
        this.A = true;
        LogUtils.c("推荐下滑 其他页面点赞了");
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_recommend_feed;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void l() {
        this.l.i();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.f20169a;
        if (feedListAdapterForRecyclerView != null) {
            feedListAdapterForRecyclerView.e();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ByteDanceEvent.a("A58", new JSONObject());
        LinearLayout linearLayout = this.f;
        if (linearLayout != null) {
            int childCount = linearLayout.getChildCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= childCount) {
                    break;
                }
                View childAt = this.f.getChildAt(i2);
                if (childAt instanceof DiscoveryEntryView) {
                    ((DiscoveryEntryView) childAt).a(getFragmentActive());
                }
                i = i2 + 1;
            }
        }
        if (this.f20169a != null && getUserVisibleHint()) {
            this.f20169a.d();
        }
        FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.f20169a;
        if (feedListAdapterForRecyclerView != null) {
            feedListAdapterForRecyclerView.notifyDataSetChanged();
        }
        this.n.setRedDotVisibility(FeedMethods.b());
        if (CommunityPreferences.f()) {
            d();
            CommunityPreferences.b(false);
        }
        if (!TextUtils.isEmpty(j().h) && this.y) {
            LogUtils.c("推荐下滑 用户点击用户头像进入个人主页后，或点击查看大图后返回推荐feed页面, isThirdPageLiked=" + this.A);
            this.y = false;
            d(1);
        }
        if (TextUtils.isEmpty(j().h) || !this.z) {
            return;
        }
        LogUtils.c("推荐下滑 点击进入详情页后，再返回推荐feed页面");
        this.z = false;
        d(2);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void p() {
        this.l.l(false);
        AppMethods.a((CharSequence) getString(R.string.no_more_please_try_again));
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public boolean q() {
        return true;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public boolean r() {
        return true;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.f20169a;
        if (feedListAdapterForRecyclerView != null) {
            if (z) {
                feedListAdapterForRecyclerView.d();
            } else {
                feedListAdapterForRecyclerView.e();
            }
        }
    }

    public void v() {
        this.z = true;
    }
}
