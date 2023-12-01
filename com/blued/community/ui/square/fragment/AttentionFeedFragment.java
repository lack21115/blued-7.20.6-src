package com.blued.community.ui.square.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpUtils;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.enums.PopupPosition;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.utils.NinePatchUtils;
import com.blued.android.module.common.view.CommonGuidePop;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.widget.refresh.RecommendLoadMoreView;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.model.AttentionFeedPostGuideExtra;
import com.blued.community.model.AttentionFeedPostGuideModel;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView;
import com.blued.community.ui.feed.manager.FeedConstants;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.send.fragment.FeedAddPostFragment;
import com.blued.community.ui.send.view.FeedSendRecyclerView;
import com.blued.community.ui.square.adapter.AttentionRecommendLiveAdapter;
import com.blued.community.ui.square.fragment.AttentionFeedFragment;
import com.blued.community.ui.square.model.AttentionLiveRecommendData;
import com.blued.community.ui.square.presenter.AttentionFeedPresenter;
import com.blued.community.ui.topic.model.BluedTopic;
import com.blued.community.utils.CommBundleBuilder;
import com.blued.community.utils.CommRouteUtil;
import com.blued.community.utils.CommunityPreferences;
import com.blued.community.view.CommonMultiItemAdapter;
import com.blued.community.view.CommonViewHolder;
import com.blued.community.view.FloatFooterView;
import com.blued.das.client.feed.FeedProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/square/fragment/AttentionFeedFragment.class */
public class AttentionFeedFragment<T extends AttentionFeedPresenter> extends MvpFragment<AttentionFeedPresenter> {
    private Context a;
    private View b;
    private RecyclerView c;
    private LinearLayoutManager d;
    private CommonMultiItemAdapter<BluedTopic> e;
    private View f;
    private ImageView g;
    private TextView k;
    private View l;
    private RecyclerView m;
    private FeedSendRecyclerView n;
    private View o;
    private LinearLayout p;
    private RecyclerView q;
    private SmartRefreshLayout r;
    private FloatFooterView s;
    private FeedListAdapterForRecyclerView t;
    private NoDataAndLoadFailView u;
    private AttentionRecommendLiveAdapter v;
    private LinearLayoutManager w;
    private AttentionFeedPostGuideModel y;
    private int x = -1;
    private RecyclerView.OnScrollListener z = new RecyclerView.OnScrollListener() { // from class: com.blued.community.ui.square.fragment.AttentionFeedFragment.2
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (AttentionFeedFragment.this.t != null && AttentionFeedFragment.this.t.s != null) {
                AttentionFeedFragment.this.t.s.onScrollStateChanged(recyclerView, i);
            }
            if (AttentionFeedFragment.this.s != null && i == 0) {
                if (!recyclerView.canScrollVertically(-1)) {
                    AttentionFeedFragment.this.s.startBtmBtnShow();
                } else if (!recyclerView.canScrollVertically(1)) {
                    if (!AttentionFeedFragment.this.j().n()) {
                        AppMethods.a((CharSequence) AttentionFeedFragment.this.a.getResources().getString(R.string.no_more_please_try_again));
                    }
                    AttentionFeedFragment.this.s.startBtmBtnHide();
                }
            }
            if (i == 0) {
                int findFirstVisibleItemPosition = AttentionFeedFragment.this.w.findFirstVisibleItemPosition();
                int findLastVisibleItemPosition = AttentionFeedFragment.this.w.findLastVisibleItemPosition();
                if (AttentionFeedFragment.this.x < findFirstVisibleItemPosition || AttentionFeedFragment.this.x > findLastVisibleItemPosition) {
                    return;
                }
                AttentionFeedFragment attentionFeedFragment = AttentionFeedFragment.this;
                attentionFeedFragment.a((BluedIngSelfFeed) attentionFeedFragment.t.getData().get(AttentionFeedFragment.this.x));
            }
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (AttentionFeedFragment.this.t != null && AttentionFeedFragment.this.t.s != null) {
                AttentionFeedFragment.this.t.s.onScrolled(recyclerView, i, i2);
            }
            if (i2 < 0) {
                AttentionFeedFragment.this.s.startBtmBtnShow();
            } else if (i2 > 0) {
                AttentionFeedFragment.this.s.startBtmBtnHide();
            }
        }
    };
    private final int A = 604800;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.community.ui.square.fragment.AttentionFeedFragment$1  reason: invalid class name */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/square/fragment/AttentionFeedFragment$1.class */
    public class AnonymousClass1 extends CommonMultiItemAdapter<BluedTopic> {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(BluedTopic bluedTopic, View view) {
            FeedConstants.b = FeedProtos.DetailFrom.FIND_FOLLOW_TOPIC;
            CommRouteUtil.a(this.mContext, bluedTopic.super_did, bluedTopic.name);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void onConvert(CommonViewHolder commonViewHolder, final BluedTopic bluedTopic, int i) {
            String str;
            if (TextUtils.isEmpty(bluedTopic.last_contents)) {
                str = CommonStringUtils.b(bluedTopic.visited_total) + AttentionFeedFragment.this.getString(R.string.subject_visit_count);
            } else {
                str = bluedTopic.last_contents;
            }
            int i2 = R.drawable.item_attention_subject_icon;
            if (bluedTopic.is_anonym == 1) {
                i2 = R.drawable.item_attention_subject_icon_ann;
            }
            commonViewHolder.setImageUrl(R.id.item_attention_subject_iv, bluedTopic.avatar, 9.0f).setText(R.id.item_attention_subject_name, bluedTopic.name).setText(R.id.item_attention_subject_iv_viewer, str).setImageResource(R.id.item_attention_subject_icon, i2).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.square.fragment.-$$Lambda$AttentionFeedFragment$1$cKmo-MrUpWMPgvbLsRWWiR2jBZQ
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AttentionFeedFragment.AnonymousClass1.this.a(bluedTopic, view);
                }
            });
            if (bluedTopic.isShowUrlVisited) {
                return;
            }
            EventTrackFeed.a(FeedProtos.Event.SUPER_TOPIC_DRAW, FeedProtos.DetailFrom.FIND_FOLLOW_TOPIC, bluedTopic.super_did, bluedTopic.is_anonym == 1, false, bluedTopic.is_follow == 1);
            bluedTopic.isShowUrlVisited = true;
        }

        public void onAddItemType() {
            addItemType(0, R.layout.item_attention_list_subject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final BluedIngSelfFeed bluedIngSelfFeed) {
        View viewByPosition;
        long A = CommunityPreferences.A();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        String B = CommunityPreferences.B();
        if (currentTimeMillis - A <= 604800 || TextUtils.equals(B, bluedIngSelfFeed.feed_id) || (viewByPosition = this.t.getViewByPosition(this.q, this.x, R.id.ll_read_num)) == null || TextUtils.isEmpty(bluedIngSelfFeed.recommendation_new)) {
            return;
        }
        CommonGuidePop commonGuidePop = new CommonGuidePop(this.a, bluedIngSelfFeed.recommendation_new, NinePatchUtils.GuideArrowPosition.RIGHT, R.drawable.guide_blue_bubble_down);
        final BasePopupView h = new XPopup.Builder(this.a).a(viewByPosition).d((Boolean) false).b(-DensityUtils.a(this.a, 3.0f)).c(DensityUtils.a(this.a, 8.0f)).a(PopupPosition.Top).a(PopupAnimation.ScaleAlphaFromCenter).a((BasePopupView) commonGuidePop).h();
        commonGuidePop.setOnClick(new CommonGuidePop.OnClickListener() { // from class: com.blued.community.ui.square.fragment.AttentionFeedFragment.3
            @Override // com.blued.android.module.common.view.CommonGuidePop.OnClickListener
            public void a() {
                CommunityServiceManager.b().a(AttentionFeedFragment.this.a, bluedIngSelfFeed.promotion_url);
                if (h.s()) {
                    h.p();
                }
            }
        });
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.square.fragment.AttentionFeedFragment.4
            @Override // java.lang.Runnable
            public void run() {
                if (h.s()) {
                    h.p();
                }
            }
        }, 5000L);
        h.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.square.fragment.AttentionFeedFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        CommunityPreferences.i(bluedIngSelfFeed.feed_id);
        CommunityPreferences.a(currentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, BluedTopic bluedTopic, String str2, String str3, View view) {
        FeedAddPostFragment.a((Context) getActivity(), new CommBundleBuilder().b(16).a(str).a(bluedTopic));
        EventTrackFeed.l(FeedProtos.Event.FEED_FOLLOW_PAGE_PUBLISH_GUIDE_CLICK, str2, str3);
    }

    private void b(boolean z) {
        this.r.g();
        this.r.h();
        if (z) {
            this.u.a();
        } else {
            this.u.b();
        }
    }

    private void d() {
        this.f = this.i.findViewById(R.id.feed_attention_guide_layout);
        this.g = (ImageView) this.i.findViewById(R.id.feed_attention_guide_avatar);
        this.k = (TextView) this.i.findViewById(R.id.feed_attention_guide_name);
        this.l = this.i.findViewById(R.id.feed_attention_guide_btn);
        this.b = this.i.findViewById(R.id.feed_attention_subject_layout);
        this.c = this.i.findViewById(R.id.feed_attention_subject_rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
        this.d = linearLayoutManager;
        this.c.setLayoutManager(linearLayoutManager);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        this.e = anonymousClass1;
        this.c.setAdapter(anonymousClass1);
        this.m = this.i.findViewById(R.id.rv_live_recommend);
        this.n = (FeedSendRecyclerView) this.i.findViewById(R.id.feed_send_list);
        this.o = this.i.findViewById(R.id.view_send_list_cut);
        this.p = (LinearLayout) this.i.findViewById(R.id.ll_live_recommend);
        this.q = this.i.findViewById(R.id.recycler_view);
        this.r = this.i.findViewById(R.id.refresh_layout);
        this.s = this.i.findViewById(R.id.ll_feed_post);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        CommunityServiceManager.d().a("feed_post_btn_click", 1);
        EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_BTN_CLICK, FeedProtos.FeedFrom.FOLLOW, FeedMethods.b(), "");
        FeedAddPostFragment.a(this.a);
    }

    private void v() {
        this.s.setOnBtnClickListener(new FloatFooterView.OnBtnClickListener() { // from class: com.blued.community.ui.square.fragment.AttentionFeedFragment.6
            public void onPostFeedClick() {
                AttentionFeedFragment.this.e();
            }
        });
        this.n.setRequestHost(getFragmentActive());
        this.o.setVisibility(8);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.a);
        this.w = linearLayoutManager;
        this.q.setLayoutManager(linearLayoutManager);
        if (this.t == null) {
            this.t = new FeedListAdapterForRecyclerView(this.a, this, this.q, 0);
            NoDataAndLoadFailView noDataAndLoadFailView = new NoDataAndLoadFailView(getContext());
            this.u = noDataAndLoadFailView;
            this.t.setEmptyView(noDataAndLoadFailView);
        }
        j().a(this.t);
        this.q.setAdapter(this.t);
        this.q.addOnScrollListener(this.z);
        this.r.a(new OnRefreshLoadMoreListener() { // from class: com.blued.community.ui.square.fragment.AttentionFeedFragment.7
            public void onLoadMore(RefreshLayout refreshLayout) {
                AttentionFeedFragment.this.j().f();
            }

            public void onRefresh(RefreshLayout refreshLayout) {
                AttentionFeedFragment.this.j().e();
                AttentionFeedFragment.this.y();
            }
        });
        CommunityServiceManager.d().a("first_auto_load", 3);
        this.n.b();
    }

    private void w() {
        if (this.v == null) {
            AttentionRecommendLiveAdapter attentionRecommendLiveAdapter = new AttentionRecommendLiveAdapter(this.a, getFragmentActive());
            this.v = attentionRecommendLiveAdapter;
            attentionRecommendLiveAdapter.setEnableLoadMore(true);
            this.v.setLoadMoreView(new RecommendLoadMoreView());
        }
        this.v.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.blued.community.ui.square.fragment.AttentionFeedFragment.8
            public void onLoadMoreRequested() {
                AttentionFeedFragment.this.j().a(false);
            }
        }, this.m);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.a);
        linearLayoutManager.setOrientation(0);
        this.m.setLayoutManager(linearLayoutManager);
        this.m.setAdapter(this.v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0142 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void x() {
        /*
            Method dump skipped, instructions count: 689
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.community.ui.square.fragment.AttentionFeedFragment.x():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        FeedHttpUtils.g(new BluedUIHttpResponse<BluedEntity<AttentionFeedPostGuideModel, AttentionFeedPostGuideExtra>>(getFragmentActive()) { // from class: com.blued.community.ui.square.fragment.AttentionFeedFragment.12
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<AttentionFeedPostGuideModel, AttentionFeedPostGuideExtra> bluedEntity) {
                if (bluedEntity != null) {
                    AttentionFeedFragment.this.y = bluedEntity.getSingleData();
                    AttentionFeedFragment.this.x();
                    if (bluedEntity.extra != null) {
                        CommunityPreferences.o(bluedEntity.extra.getLast_date());
                    }
                }
            }
        }, getFragmentActive());
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.a = getContext();
        d();
        v();
        w();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, List list) {
        boolean z;
        super.a(str, list);
        switch (str.hashCode()) {
            case -1644013921:
                if (str.equals("feed_list")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1030803812:
                if (str.equals("send_list_visibility")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1008757777:
                if (str.equals("live_list")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case 1559947723:
                if (str.equals("subject_attention")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        if (!z) {
            MvpUtils.a(list, AttentionLiveRecommendData.class, new MvpUtils.DataListHandler<AttentionLiveRecommendData>() { // from class: com.blued.community.ui.square.fragment.AttentionFeedFragment.9
                @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                public void a() {
                    AttentionFeedFragment.this.b();
                }

                @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                public void a(List<AttentionLiveRecommendData> list2) {
                    AttentionFeedFragment.this.b(list2);
                }
            });
        } else if (z) {
            MvpUtils.a(list, BluedIngSelfFeed.class, new MvpUtils.DataListHandler<BluedIngSelfFeed>() { // from class: com.blued.community.ui.square.fragment.AttentionFeedFragment.10
                @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                public void a() {
                }

                @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                public void a(List<BluedIngSelfFeed> list2) {
                    AttentionFeedFragment.this.t.setNewData(list2);
                    if (list2 == null || list2.size() <= 0) {
                        return;
                    }
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < list2.size()) {
                            if (list2.get(i2).is_bubble_ticktock != 1 && list2.get(i2).isMyFeed()) {
                                AttentionFeedFragment.this.x = i2;
                                break;
                            }
                            i = i2 + 1;
                        } else {
                            break;
                        }
                    }
                    if (AttentionFeedFragment.this.x == 0 || AttentionFeedFragment.this.x == 1 || AttentionFeedFragment.this.x == 2) {
                        AttentionFeedFragment attentionFeedFragment = AttentionFeedFragment.this;
                        attentionFeedFragment.a(list2.get(attentionFeedFragment.x));
                    }
                }
            });
        } else if (!z) {
            if (!z) {
                return;
            }
            MvpUtils.a(list, BluedTopic.class, new MvpUtils.DataListHandler<BluedTopic>() { // from class: com.blued.community.ui.square.fragment.AttentionFeedFragment.11
                @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                public void a() {
                    AttentionFeedFragment.this.a((List<BluedTopic>) null);
                }

                @Override // com.blued.android.framework.ui.mvp.MvpUtils.DataListHandler
                public void a(List<BluedTopic> list2) {
                    AttentionFeedFragment.this.a(list2);
                }
            });
        } else {
            FeedSendRecyclerView feedSendRecyclerView = this.n;
            if (feedSendRecyclerView == null || feedSendRecyclerView.getAdapter() == null || this.n.getAdapter().getItemCount() == 0) {
                this.o.setVisibility(8);
                return;
            }
            this.o.setVisibility(0);
            this.n.a();
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

    protected void a(List<BluedTopic> list) {
        if (list == null || list.size() <= 0) {
            this.b.setVisibility(8);
            return;
        }
        this.b.setVisibility(0);
        this.e.setDataAndNotify(list);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void af_() {
        this.q.setAdapter((RecyclerView.Adapter) null);
        super.af_();
        RecyclerView recyclerView = this.q;
        if (recyclerView != null) {
            recyclerView.removeOnScrollListener(this.z);
        }
    }

    protected void b() {
        this.p.setVisibility(8);
    }

    protected void b(List<AttentionLiveRecommendData> list) {
        this.p.setVisibility(0);
        this.v.setNewData(list);
        if (j().o() == 1) {
            this.m.scrollToPosition(0);
        }
        this.v.loadMoreComplete();
        this.v.setEnableLoadMore(j().n());
    }

    protected void c() {
        RecyclerView recyclerView;
        if (this.r == null || (recyclerView = this.q) == null) {
            return;
        }
        recyclerView.scrollToPosition(0);
        this.r.i();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_feed_list_attention;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void g_(String str) {
        super.g_(str);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void o() {
        super.o();
        this.r.b(true);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment
    public void onDestroyView() {
        FeedSendRecyclerView feedSendRecyclerView = this.n;
        if (feedSendRecyclerView != null) {
            feedSendRecyclerView.c();
        }
        super.onDestroyView();
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onPause() {
        super.onPause();
        FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.t;
        if (feedListAdapterForRecyclerView != null) {
            feedListAdapterForRecyclerView.e();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onResume() {
        super.onResume();
        if (this.t != null && getUserVisibleHint()) {
            this.t.d();
        }
        FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.t;
        if (feedListAdapterForRecyclerView != null) {
            feedListAdapterForRecyclerView.notifyDataSetChanged();
        }
        this.s.setRedDotVisibility(FeedMethods.b());
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        y();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void p() {
        super.p();
        this.r.b(false);
        AppMethods.d(R.string.common_nomore_data);
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
        FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.t;
        if (feedListAdapterForRecyclerView != null) {
            if (z) {
                feedListAdapterForRecyclerView.d();
            } else {
                feedListAdapterForRecyclerView.e();
            }
        }
        if (z) {
            int i = this.x;
            if ((i == 0 || i == 1 || i == 2) && this.t.getData() != null && this.t.getData().size() > this.x) {
                a((BluedIngSelfFeed) this.t.getData().get(this.x));
            }
        }
    }
}
