package com.blued.community.ui.square.fragment;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.amap.api.services.district.DistrictSearchQuery;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.RefreshUtils;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.view.TranslationAnimHintView;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.manager.CommunityManager;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.model.FeedDiversionModel;
import com.blued.community.model.FeedOperationFloatModel;
import com.blued.community.track.ByteDanceEvent;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.send.fragment.CollectionAddPostFragment;
import com.blued.community.ui.send.fragment.FeedAddPostFragment;
import com.blued.community.ui.square.model.NearbyTransformersModel;
import com.blued.community.ui.square.presenter.NearbyFeedPresenter;
import com.blued.community.utils.CommRouteUtil;
import com.blued.community.view.FeedOperationFloatView;
import com.blued.community.view.FloatFooterView;
import com.blued.community.view.TransformersLayout;
import com.blued.das.client.feed.FeedProtos;
import com.blued.track.trackUtils.EventTrackGuy;
import com.google.android.material.appbar.AppBarLayout;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/square/fragment/NearbyFeedFragment.class */
public class NearbyFeedFragment<T extends NearbyFeedPresenter> extends MvpFragment<NearbyFeedPresenter> {
    public static long q;
    public static long r;
    private View A;
    private ImageView B;
    private boolean C;
    private FeedOperationFloatView D;
    private boolean E;
    private int F;
    private int G;
    private int K;
    private int L;
    public Context a;
    public CoordinatorLayout b;
    public RecyclerView c;
    protected RecyclerView.LayoutManager d;
    public SmartRefreshLayout e;
    public AppBarLayout f;
    public View g;
    public View k;
    public View l;
    public View m;
    public NoDataAndLoadFailView n;
    public FeedListAdapterForRecyclerView o;
    protected ImageView p;
    private FloatFooterView s;
    private ImageView t;
    private View u;
    private ShapeTextView v;
    private ShapeTextView w;
    private TranslationAnimHintView x;
    private TransformersLayout y;
    private View z;
    private boolean H = true;
    private boolean I = false;
    private long J = 0;
    private boolean M = true;
    private RecyclerView.OnScrollListener N = new RecyclerView.OnScrollListener() { // from class: com.blued.community.ui.square.fragment.NearbyFeedFragment.2
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (NearbyFeedFragment.this.o != null && NearbyFeedFragment.this.o.s != null) {
                NearbyFeedFragment.this.o.s.onScrollStateChanged(recyclerView, i);
            }
            if (i == 0 && NearbyFeedFragment.this.H && NearbyFeedFragment.this.M) {
                LinearLayoutManager layoutManager = recyclerView.getLayoutManager();
                NearbyFeedFragment.this.F = layoutManager.findFirstVisibleItemPosition();
                NearbyFeedFragment.this.G = layoutManager.findLastVisibleItemPosition();
                if (NearbyFeedFragment.this.G > 12) {
                    NearbyFeedFragment.this.M = false;
                    NearbyFeedFragment.this.F();
                }
            }
            if (NearbyFeedFragment.this.s == null || i != 0) {
                return;
            }
            if (!recyclerView.canScrollVertically(-1)) {
                NearbyFeedFragment.this.s.startBtmBtnShow();
            } else if (recyclerView.canScrollVertically(1)) {
            } else {
                if (!NearbyFeedFragment.this.j().m()) {
                    AppMethods.a((CharSequence) NearbyFeedFragment.this.a.getResources().getString(R.string.no_more_please_try_again));
                }
                NearbyFeedFragment.this.s.startBtmBtnHide();
            }
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (NearbyFeedFragment.this.o != null && NearbyFeedFragment.this.o.s != null) {
                NearbyFeedFragment.this.o.s.onScrolled(recyclerView, i, i2);
            }
            if (i2 < 0 && NearbyFeedFragment.this.K > NearbyFeedFragment.this.L) {
                NearbyFeedFragment.this.G();
            }
            if (i2 < 0) {
                NearbyFeedFragment.this.s.startBtmBtnShow();
            } else if (i2 > 0) {
                NearbyFeedFragment.this.s.startBtmBtnHide();
            }
        }
    };
    private final int O = 1;
    private NearbyFeedFragment<T>.FeedHandler P = new FeedHandler();
    private FeedOperationFloatModel Q = null;
    private Runnable R = new Runnable() { // from class: com.blued.community.ui.square.fragment.-$$Lambda$NearbyFeedFragment$LgIAK5u4FVq0LRq_Y3IRj2TQ-Wo
        @Override // java.lang.Runnable
        public final void run() {
            NearbyFeedFragment.this.I();
        }
    };

    /* renamed from: com.blued.community.ui.square.fragment.NearbyFeedFragment$6  reason: invalid class name */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/square/fragment/NearbyFeedFragment$6.class */
    class AnonymousClass6 implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ NearbyFeedFragment a;

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (this.a.g == null) {
                valueAnimator.cancel();
                return;
            }
            this.a.g.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            this.a.g.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/square/fragment/NearbyFeedFragment$FeedHandler.class */
    public class FeedHandler extends Handler {
        private FeedHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 1) {
                return;
            }
            LogUtils.c("冒泡插入: insertBubbleFeedId:" + NearbyFeedFragment.this.j().k);
            if (TextUtils.isEmpty(NearbyFeedFragment.this.j().k) || NearbyFeedFragment.this.j().o().dataList.size() <= 0 || NearbyFeedFragment.this.j().o().dataList.get(0).is_bubble_ticktock != 1 || !NearbyFeedFragment.this.j().k.contains(NearbyFeedFragment.this.j().o().dataList.get(0).feed_id)) {
                return;
            }
            NearbyFeedFragment.this.j().o().dataList.get(0).playAnimType = 6;
            LogUtils.c("冒泡插入: 设置animType");
        }
    }

    private void A() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        LogUtils.c("冒泡插入: onListDataSet:");
        this.P.removeMessages(1);
        this.P.sendEmptyMessageDelayed(1, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        FeedOperationFloatModel feedOperationFloatModel = this.Q;
        if (feedOperationFloatModel == null || feedOperationFloatModel.getPush_content() == null) {
            this.t.setVisibility(8);
            return;
        }
        String img = this.Q.getPush_content().getImg();
        int p_id = this.Q.getP_id();
        if (TextUtils.isEmpty(img)) {
            this.t.setVisibility(8);
            return;
        }
        this.t.setVisibility(0);
        ImageLoader.a(getFragmentActive(), img).f().g(-1).a(new ImageLoadResult(getFragmentActive()) { // from class: com.blued.community.ui.square.fragment.NearbyFeedFragment.11
            @Override // com.blued.android.core.image.ImageLoadResult
            public void a() {
            }

            @Override // com.blued.android.core.image.ImageLoadResult
            public void a(int i, Exception exc) {
                NearbyFeedFragment.this.t.setVisibility(8);
            }
        }).a(this.t);
        EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_GUIDE_POP_SHOW, FeedProtos.SourcePage.FEED_PLAZA_NEARBY, String.valueOf(p_id));
    }

    private void D() {
        FeedOperationFloatModel feedOperationFloatModel = this.Q;
        if (feedOperationFloatModel == null || feedOperationFloatModel.getPush_content() == null) {
            return;
        }
        int p_id = this.Q.getP_id();
        if (this.Q.getTarget_path() == 1) {
            CommRouteUtil.a(getActivity());
        } else if (this.Q.getTarget_path() == 2) {
            CommunityServiceManager.b().a(getContext(), this.Q.getTarget_link());
        }
        this.t.setVisibility(8);
        FeedHttpUtils.a(1, 1, p_id, getFragmentActive());
        EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_GUIDE_POP_CLICK, FeedProtos.SourcePage.FEED_PLAZA_NEARBY, String.valueOf(p_id));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E */
    public void J() {
        this.H = true;
        this.M = true;
        this.c.scrollToPosition(0);
        RefreshUtils.a(this.f);
        this.e.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        this.H = false;
        if (this.z.getVisibility() == 0) {
            return;
        }
        int[] iArr = new int[2];
        this.v.getLocationInWindow(iArr);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.z.getLayoutParams();
        marginLayoutParams.height = FeedMethods.c(70);
        marginLayoutParams.topMargin = iArr[1] + FeedMethods.c(-40);
        this.z.setLayoutParams(marginLayoutParams);
        if (CommunityManager.a.a().s()) {
            this.A.setBackgroundResource(R.drawable.nearby_feed_refresh_guide_bg_dark);
        } else {
            this.A.setBackgroundResource(R.drawable.nearby_feed_refresh_guide_bg);
        }
        LiveEventBus.get("FEED_LIST_REFRESH_GUIDE").post(true);
        this.z.setVisibility(0);
        ImageLoader.c(getFragmentActive(), "feed_list_refresh_guide.png").g().g(1).a(this.B);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(400L);
        this.A.startAnimation(translateAnimation);
        AppInfo.n().removeCallbacks(this.R);
        AppInfo.n().postDelayed(this.R, 12000L);
        EventTrackFeed.d(FeedProtos.Event.FEED_REFRESH_SHOW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        this.H = true;
        if (this.z.getVisibility() == 8) {
            return;
        }
        this.z.setVisibility(8);
        AppInfo.n().removeCallbacks(this.R);
        LiveEventBus.get("FEED_LIST_REFRESH_GUIDE").postDelay(false, 400L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H */
    public void I() {
        this.H = true;
        if (this.z.getVisibility() == 8) {
            return;
        }
        AppInfo.n().removeCallbacks(this.R);
        LiveEventBus.get("FEED_LIST_REFRESH_GUIDE").post(false);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        translateAnimation.setDuration(400L);
        translateAnimation.setFillAfter(false);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.community.ui.square.fragment.NearbyFeedFragment.12
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                NearbyFeedFragment.this.z.setVisibility(8);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.A.startAnimation(translateAnimation);
    }

    private void a(int i) {
        b(i);
        w();
        A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        D();
    }

    private void a(ShapeTextView shapeTextView) {
        ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView, R.color.syc_h);
        shapeTextView.setTextSize(17.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FeedOperationFloatModel feedOperationFloatModel) {
        this.D.setOperationData(feedOperationFloatModel);
        if (feedOperationFloatModel != null) {
            CommunityManager.a.a().b(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AppBarLayout appBarLayout, int i) {
        this.K = i;
        if (this.L > i) {
            this.L = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<NearbyTransformersModel> list) {
        this.y.setTransformersData(list);
        if (this.y.getChildCount() > 0) {
            this.u.setVisibility(0);
        } else {
            this.u.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        j().a(i);
        this.o.b(c(i));
        this.o.setNewData(j().b(i).dataList);
        if (j().b(i).dataList.size() == 0) {
            this.n.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        j().h = 1;
        a(2);
        a(this.w);
        b(this.v);
        this.D.setVisibleByParent(false);
        EventTrackFeed.a(FeedProtos.Event.FEED_CITY_TIME_PAGE_SHOW);
    }

    private void b(ShapeTextView shapeTextView) {
        ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView, R.color.syc_j);
        shapeTextView.setTextSize(15.0f);
    }

    private int c(int i) {
        if (i != 1) {
            return i != 2 ? -1 : 19;
        }
        return 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        j().h = 0;
        a(1);
        a(this.v);
        b(this.w);
        this.D.setVisibleByParent(true);
        EventTrackFeed.a(FeedProtos.Event.FEED_CITY_ALL_PAGE_SHOW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(String str) {
        if ("find".equalsIgnoreCase(str)) {
            if (this.I) {
                w();
            }
        } else if (this.z.getVisibility() == 0) {
            this.I = true;
            G();
        }
    }

    private void c(boolean z) {
        NoDataAndLoadFailView noDataAndLoadFailView;
        this.e.g();
        this.e.j(z);
        if (this.o.getData().size() <= 0 && (noDataAndLoadFailView = this.n) != null) {
            if (z) {
                noDataAndLoadFailView.a();
            } else {
                noDataAndLoadFailView.b();
            }
        }
        if (z && this.C) {
            d();
        }
        this.C = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        w();
        EventTrackFeed.d(FeedProtos.Event.FEED_REFRESH_CLICK);
    }

    private void v() {
        this.b = this.i.findViewById(R.id.coordinator);
        View findViewById = this.i.findViewById(R.id.bgAreaForStagger);
        this.l = findViewById;
        findViewById.setVisibility(8);
        this.m = this.i.findViewById(R.id.areaListView);
        this.k = this.i.findViewById(R.id.pageRoot);
        this.c = this.i.findViewById(R.id.recycler_view);
        this.e = this.i.findViewById(R.id.refresh_layout);
        this.s = this.i.findViewById(R.id.ll_feed_post);
        this.t = (ImageView) this.i.findViewById(R.id.img_guide);
        this.u = this.i.findViewById(R.id.view_rule);
        this.f = this.i.findViewById(R.id.appbar);
        this.v = (ShapeTextView) this.i.findViewById(R.id.tv_sort_all);
        this.w = (ShapeTextView) this.i.findViewById(R.id.tv_sort_time);
        this.g = this.i.findViewById(R.id.ll_refresh);
        this.x = (TranslationAnimHintView) this.i.findViewById(R.id.hint_view);
        this.y = this.i.findViewById(R.id.transformers);
        FeedOperationFloatView findViewById2 = this.i.findViewById(R.id.feed_operation_float_view_id);
        this.D = findViewById2;
        findViewById2.setFrom(1);
        this.p = (ImageView) this.i.findViewById(R.id.img_like_anim);
        this.z = this.i.findViewById(R.id.nearby_feed_refresh_guide_parent_layout);
        this.A = this.i.findViewById(R.id.nearby_feed_refresh_guide_layout);
        this.B = (ImageView) this.i.findViewById(R.id.nearby_feed_refresh_guide_iv);
        this.z.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.square.fragment.-$$Lambda$NearbyFeedFragment$YPqF6_-sqFX4vouAVW-1YE2LVkg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NearbyFeedFragment.this.d(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        G();
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.square.fragment.-$$Lambda$NearbyFeedFragment$9Bjn2v_4jKYOUSKr2Lr33RSjYqo
            @Override // java.lang.Runnable
            public final void run() {
                NearbyFeedFragment.this.J();
            }
        }, 200L);
    }

    private void x() {
        LiveEventBus.get("FEED_LIST_REFRESH_TAB_CHANGED", String.class).observe(this, new Observer() { // from class: com.blued.community.ui.square.fragment.-$$Lambda$NearbyFeedFragment$maO4D3Dha6qRcptLO6evOrf75Iw
            public final void onChanged(Object obj) {
                NearbyFeedFragment.this.c((String) obj);
            }
        });
        LiveEventBus.get("APP_CHANGE_TO_BACKGROUND", Boolean.class).observe(this, new Observer<Boolean>() { // from class: com.blued.community.ui.square.fragment.NearbyFeedFragment.1
            /* renamed from: a */
            public void onChanged(Boolean bool) {
                String q2 = CommunityManager.a.a().q();
                String str = q2;
                if (q2 == null) {
                    str = "";
                }
                LogUtils.c("FEED_DRAW.back=" + bool + ", time: " + (SystemClock.elapsedRealtime() - NearbyFeedFragment.this.J) + ", strFrg: " + str);
                if (bool.booleanValue()) {
                    NearbyFeedFragment.this.J = SystemClock.elapsedRealtime();
                } else if (!NearbyFeedFragment.this.getUserVisibleHint() || SystemClock.elapsedRealtime() - NearbyFeedFragment.this.J <= 180000) {
                } else {
                    if (str.contains(NearbyFeedFragment.this.getSimpleName()) || str.contains("NearbyFeedHomeFragment") || str.contains("NearbyHomeFragment")) {
                        LogUtils.c("FEED_DRAW<<<<<< ");
                        NearbyFeedFragment.this.w();
                    }
                }
            }
        });
        this.f.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.blued.community.ui.square.fragment.-$$Lambda$NearbyFeedFragment$biOkeNQpoa1ZrU-mSRK660Eoypw
            public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                NearbyFeedFragment.this.a(appBarLayout, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        CommunityServiceManager.d().a("feed_post_btn_click", 0);
        b();
        if (CommunityServiceManager.a().x() == 1) {
            CollectionAddPostFragment.a.a(this.a);
        } else {
            FeedAddPostFragment.a(this.a);
        }
    }

    private void z() {
        this.s.setOnBtnClickListener(new FloatFooterView.OnBtnClickListener() { // from class: com.blued.community.ui.square.fragment.NearbyFeedFragment.3
            public void onPostFeedClick() {
                NearbyFeedFragment.this.y();
            }
        });
        this.s.setBtnAnimatorUpdateListener(new FloatFooterView.BtnAnimatorUpdateListener() { // from class: com.blued.community.ui.square.fragment.NearbyFeedFragment.4
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (NearbyFeedFragment.this.t != null) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) NearbyFeedFragment.this.t.getLayoutParams();
                    layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, -intValue);
                    NearbyFeedFragment.this.t.setLayoutParams(layoutParams);
                }
            }
        });
        c();
        j().a(this.o);
        this.c.addOnScrollListener(this.N);
        this.e.a(new OnRefreshLoadMoreListener() { // from class: com.blued.community.ui.square.fragment.NearbyFeedFragment.5
            public void onLoadMore(RefreshLayout refreshLayout) {
                NearbyFeedFragment.this.j().f();
            }

            public void onRefresh(RefreshLayout refreshLayout) {
                CommunityServiceManager.e().a(NearbyFeedFragment.this.getParentFragment());
                NearbyFeedFragment.this.j().e();
                NearbyFeedFragment.this.G();
                EventTrackGuy.a(DistrictSearchQuery.KEYWORDS_CITY);
            }
        });
        EventTrackFeed.a(FeedProtos.Event.FEED_CITY_ALL_PAGE_SHOW);
        this.v.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.community.ui.square.fragment.-$$Lambda$NearbyFeedFragment$8DO0GyIZShlRFzDM1g-HzEZP4og
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NearbyFeedFragment.this.c(view);
            }
        }));
        this.w.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.community.ui.square.fragment.-$$Lambda$NearbyFeedFragment$59wG4EWqIbW5GgSHUhvUAmmDEqM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NearbyFeedFragment.this.b(view);
            }
        }));
        CommunityServiceManager.d().a("first_auto_load", 1);
        this.t.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.square.fragment.-$$Lambda$NearbyFeedFragment$tcSemS2WzskWfvadB28-FV9OWPo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NearbyFeedFragment.this.a(view);
            }
        });
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.a = getActivity();
        v();
        z();
        ByteDanceEvent.a("A60", new JSONObject());
        x();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(final String str, List list) {
        boolean z;
        super.a(str, list);
        switch (str.hashCode()) {
            case -2025065628:
                if (str.equals("FEED_FLOAT_OP_DATA")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1876638542:
                if (str.equals("feed_time_list_cache")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1327980128:
                if (str.equals("feed_default_list_cache")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -202849937:
                if (str.equals("feed_time_list")) {
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
            case 742942941:
                if (str.equals("feed_default_list")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1543378915:
                if (str.equals("feed_operate")) {
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
                this.o.a(System.currentTimeMillis());
                return;
            case true:
            case true:
                MvpUtils.a(list, BluedIngSelfFeed.class, new MvpUtils.DataListHandler<BluedIngSelfFeed>() { // from class: com.blued.community.ui.square.fragment.NearbyFeedFragment.7
                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                    public void a() {
                        NearbyFeedFragment.this.j().o().dataList.clear();
                        NearbyFeedFragment nearbyFeedFragment = NearbyFeedFragment.this;
                        nearbyFeedFragment.b(nearbyFeedFragment.j().n());
                    }

                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                    public void a(List<BluedIngSelfFeed> list2) {
                        NearbyFeedFragment.this.j().o().dataList = list2;
                        if (NearbyFeedFragment.this.j().i != null && NearbyFeedFragment.this.j().j < NearbyFeedFragment.this.j().o().dataList.size()) {
                            NearbyFeedFragment.this.j().o().dataList.add(NearbyFeedFragment.this.j().j, NearbyFeedFragment.this.j().i);
                        }
                        if (str == "feed_default_list") {
                            NearbyFeedFragment.this.B();
                        }
                        NearbyFeedFragment nearbyFeedFragment = NearbyFeedFragment.this;
                        nearbyFeedFragment.b(nearbyFeedFragment.j().n());
                    }
                });
                return;
            case true:
            case true:
                MvpUtils.a(list, BluedIngSelfFeed.class, new MvpUtils.DataListHandler<BluedIngSelfFeed>() { // from class: com.blued.community.ui.square.fragment.NearbyFeedFragment.8
                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                    public void a() {
                        NearbyFeedFragment.this.j().p().dataList.clear();
                        NearbyFeedFragment nearbyFeedFragment = NearbyFeedFragment.this;
                        nearbyFeedFragment.b(nearbyFeedFragment.j().n());
                    }

                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                    public void a(List<BluedIngSelfFeed> list2) {
                        NearbyFeedFragment.this.j().p().dataList = list2;
                        NearbyFeedFragment nearbyFeedFragment = NearbyFeedFragment.this;
                        nearbyFeedFragment.b(nearbyFeedFragment.j().n());
                    }
                });
                return;
            case true:
                MvpUtils.a(list, NearbyTransformersModel.class, new MvpUtils.DataListHandler<NearbyTransformersModel>() { // from class: com.blued.community.ui.square.fragment.NearbyFeedFragment.9
                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                    public void a() {
                        NearbyFeedFragment.this.a(new ArrayList());
                    }

                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                    public void a(List<NearbyTransformersModel> list2) {
                        NearbyFeedFragment.this.a(list2);
                    }
                });
                return;
            case true:
                MvpUtils.a(list, FeedDiversionModel.class, new MvpUtils.DataListHandler<FeedDiversionModel>() { // from class: com.blued.community.ui.square.fragment.NearbyFeedFragment.10
                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                    public void a() {
                        NearbyFeedFragment.this.a((FeedOperationFloatModel) null);
                        NearbyFeedFragment.this.Q = null;
                        NearbyFeedFragment.this.C();
                    }

                    @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                    public void a(List<FeedDiversionModel> list2) {
                        if (list2.size() <= 0 || list2.get(0).getSuspension_bubble() == null) {
                            NearbyFeedFragment.this.a((FeedOperationFloatModel) null);
                        } else {
                            NearbyFeedFragment.this.a(list2.get(0).getSuspension_bubble());
                        }
                        if (list2.size() <= 0 || list2.get(0).getButton_bubble() == null) {
                            NearbyFeedFragment.this.Q = null;
                        } else {
                            NearbyFeedFragment.this.Q = list2.get(0).getButton_bubble();
                        }
                        NearbyFeedFragment.this.C();
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
            c(z);
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void af_() {
        this.c.setAdapter((RecyclerView.Adapter) null);
        super.af_();
        RecyclerView recyclerView = this.c;
        if (recyclerView != null) {
            recyclerView.removeOnScrollListener(this.N);
        }
    }

    public void b() {
        EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_BTN_CLICK, FeedProtos.FeedFrom.PUBLISH_PLAZA_NEARBY, false, "");
    }

    public void b(boolean z) {
        this.C = z;
    }

    public void c() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.a);
        this.d = linearLayoutManager;
        this.c.setLayoutManager(linearLayoutManager);
        if (this.o == null) {
            this.o = new FeedListAdapterForRecyclerView(this.a, this, this.c, 4);
            NoDataAndLoadFailView noDataAndLoadFailView = new NoDataAndLoadFailView(this.a);
            this.n = noDataAndLoadFailView;
            this.o.setEmptyView(noDataAndLoadFailView);
        }
        this.c.setAdapter(this.o);
    }

    protected void d() {
        TranslationAnimHintView.HintInfo hintInfo = new TranslationAnimHintView.HintInfo();
        hintInfo.a = 6;
        hintInfo.b = getString(R.string.community_city_switching_succeeded);
        hintInfo.f = true;
        this.x.a(hintInfo);
    }

    public void e() {
        CommunityServiceManager.e().a(getParentFragment());
        if (this.e == null || this.c == null) {
            return;
        }
        w();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_nearby_feed;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void l() {
        w();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void o() {
        super.o();
        this.e.b(true);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        FeedOperationFloatView feedOperationFloatView = this.D;
        if (feedOperationFloatView != null) {
            feedOperationFloatView.refreshDarkMode();
        }
        a(j().q());
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment
    public void onDestroy() {
        super.onDestroy();
        FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.o;
        if (feedListAdapterForRecyclerView != null) {
            feedListAdapterForRecyclerView.p();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onPause() {
        super.onPause();
        FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.o;
        if (feedListAdapterForRecyclerView != null) {
            feedListAdapterForRecyclerView.e();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onResume() {
        super.onResume();
        FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.o;
        if (feedListAdapterForRecyclerView != null && this.E) {
            feedListAdapterForRecyclerView.d();
        }
        if (this.z.getVisibility() == 0) {
            ImageLoader.c(getFragmentActive(), "feed_list_refresh_guide.png").g().g(1).a(this.B);
        }
        if (q > 0 && SystemClock.elapsedRealtime() - q > 5000) {
            F();
        }
        if (r > 0 && SystemClock.elapsedRealtime() - r > 60000) {
            F();
        }
        q = 0L;
        r = 0L;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void p() {
        super.p();
        this.e.b(false);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public boolean q() {
        return true;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public boolean r() {
        return true;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.E = z;
        FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.o;
        if (feedListAdapterForRecyclerView != null) {
            if (z) {
                feedListAdapterForRecyclerView.d();
                if (this.I) {
                    w();
                    return;
                }
                return;
            }
            if (this.z.getVisibility() == 0) {
                this.I = true;
                G();
            }
            this.o.e();
        }
    }
}
