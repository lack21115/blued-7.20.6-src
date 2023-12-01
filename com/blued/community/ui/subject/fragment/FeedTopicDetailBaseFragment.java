package com.blued.community.ui.subject.fragment;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.anythink.core.common.c.g;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.ui.SimpleFragment;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.community.R;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.model.FeedParse;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.circle.manager.CircleMethods;
import com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.send.fragment.FeedAddPostFragment;
import com.blued.community.ui.topic.model.BluedTopic;
import com.blued.community.ui.topic.model.FeedSubjectDetailExtra;
import com.blued.community.utils.CommunityShareUtils;
import com.blued.community.view.FloatFooterView;
import com.blued.das.client.feed.FeedProtos;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/subject/fragment/FeedTopicDetailBaseFragment.class */
public abstract class FeedTopicDetailBaseFragment extends SimpleFragment {
    protected FeedListAdapterForRecyclerView a;
    protected NoDataAndLoadFailView b;
    protected ImageView c;
    protected String d;
    protected String e;
    protected BluedTopic f;
    protected String g;
    protected float h;
    private SmartRefreshLayout i;
    private RecyclerView j;
    private FloatFooterView l;
    private View m;
    private String t;
    private final LinearLayoutManager k = new LinearLayoutManager(getContext());
    private int n = 1;
    private int o = 20;
    private boolean p = true;
    private String q = "";
    private int r = 5;
    private int s = 10;
    private final RecyclerView.OnScrollListener u = new RecyclerView.OnScrollListener() { // from class: com.blued.community.ui.subject.fragment.FeedTopicDetailBaseFragment$onScrollListener$1
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            FloatFooterView g;
            RecyclerView.OnScrollListener onScrollListener;
            Intrinsics.e(recyclerView, "recyclerView");
            FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = FeedTopicDetailBaseFragment.this.a;
            if (feedListAdapterForRecyclerView != null && (onScrollListener = feedListAdapterForRecyclerView.s) != null) {
                onScrollListener.onScrollStateChanged(recyclerView, i);
            }
            if (FeedTopicDetailBaseFragment.this.g() != null && i == 0) {
                if (!recyclerView.canScrollVertically(-1)) {
                    FloatFooterView g2 = FeedTopicDetailBaseFragment.this.g();
                    if (g2 != null) {
                        g2.startBtmBtnShow();
                    }
                } else if (!recyclerView.canScrollVertically(1) && (g = FeedTopicDetailBaseFragment.this.g()) != null) {
                    g.startBtmBtnHide();
                }
            }
            FeedTopicDetailBaseFragment.this.a(recyclerView, i);
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FloatFooterView g;
            RecyclerView.OnScrollListener onScrollListener;
            Intrinsics.e(recyclerView, "recyclerView");
            FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = FeedTopicDetailBaseFragment.this.a;
            if (feedListAdapterForRecyclerView != null && (onScrollListener = feedListAdapterForRecyclerView.s) != null) {
                onScrollListener.onScrolled(recyclerView, i, i2);
            }
            if (i2 < 0) {
                FloatFooterView g2 = FeedTopicDetailBaseFragment.this.g();
                if (g2 != null) {
                    g2.startBtmBtnShow();
                }
            } else if (i2 > 0 && (g = FeedTopicDetailBaseFragment.this.g()) != null) {
                g.startBtmBtnHide();
            }
            FeedTopicDetailBaseFragment.this.a(recyclerView, i, i2);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FeedTopicDetailBaseFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.o();
    }

    public void a() {
        RecyclerView.Adapter feedListAdapterForRecyclerView = new FeedListAdapterForRecyclerView(getContext(), (BaseFragment) this, this.j, this.r);
        this.a = feedListAdapterForRecyclerView;
        RecyclerView recyclerView = this.j;
        if (recyclerView != null) {
            recyclerView.setAdapter(feedListAdapterForRecyclerView);
        }
        RecyclerView recyclerView2 = this.j;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(this.k);
        }
        RecyclerView recyclerView3 = this.j;
        if (recyclerView3 != null) {
            recyclerView3.addOnScrollListener(this.u);
        }
        SmartRefreshLayout smartRefreshLayout = this.i;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.a(new OnRefreshLoadMoreListener() { // from class: com.blued.community.ui.subject.fragment.FeedTopicDetailBaseFragment$initRecycleView$1
                public void onLoadMore(RefreshLayout refreshLayout) {
                    Intrinsics.e(refreshLayout, "refreshLayout");
                    FeedTopicDetailBaseFragment feedTopicDetailBaseFragment = FeedTopicDetailBaseFragment.this;
                    feedTopicDetailBaseFragment.a(feedTopicDetailBaseFragment.i() + 1);
                    FeedTopicDetailBaseFragment.this.a(false);
                }

                public void onRefresh(RefreshLayout refreshLayout) {
                    Intrinsics.e(refreshLayout, "refreshLayout");
                    FeedTopicDetailBaseFragment.this.a(true);
                }
            });
        }
        View inflate = View.inflate(getContext(), R.layout.layout_load_more_end_footer_with_margin, null);
        this.m = inflate;
        if (inflate != null) {
            inflate.setVisibility(8);
        }
        FeedListAdapterForRecyclerView feedListAdapterForRecyclerView2 = this.a;
        if (feedListAdapterForRecyclerView2 != null) {
            feedListAdapterForRecyclerView2.addFooterView(this.m);
        }
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(int i) {
        this.n = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(RecyclerView recyclerView, int i) {
        Intrinsics.e(recyclerView, "recyclerView");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.e(recyclerView, "recyclerView");
    }

    public final void a(String str) {
        Intrinsics.e(str, "<set-?>");
        this.q = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z) {
        int i;
        if (z) {
            this.n = 1;
        }
        if (this.n == 1) {
            this.p = true;
        }
        if (this.p || (i = this.n) == 1) {
            final ActivityFragmentActive fragmentActive = getFragmentActive();
            FeedHttpUtils.a(new BluedUIHttpResponse<BluedEntity<BluedTopic, FeedSubjectDetailExtra>>(fragmentActive) { // from class: com.blued.community.ui.subject.fragment.FeedTopicDetailBaseFragment$getData$1
                private boolean b;

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public boolean onUIFailure(int i2, String errorMessage) {
                    Intrinsics.e(errorMessage, "errorMessage");
                    this.b = true;
                    return super.onUIFailure(i2, errorMessage);
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIFinish() {
                    List data;
                    List data2;
                    SmartRefreshLayout d = FeedTopicDetailBaseFragment.this.d();
                    if (d != null) {
                        d.g();
                    }
                    SmartRefreshLayout d2 = FeedTopicDetailBaseFragment.this.d();
                    if (d2 != null) {
                        d2.h();
                    }
                    FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = FeedTopicDetailBaseFragment.this.a;
                    if ((feedListAdapterForRecyclerView == null || (data = feedListAdapterForRecyclerView.getData()) == null || data.size() != 0) ? false : true) {
                        if (this.b) {
                            NoDataAndLoadFailView noDataAndLoadFailView = FeedTopicDetailBaseFragment.this.b;
                            if (noDataAndLoadFailView == null) {
                                return;
                            }
                            noDataAndLoadFailView.b();
                            return;
                        }
                        NoDataAndLoadFailView noDataAndLoadFailView2 = FeedTopicDetailBaseFragment.this.b;
                        if (noDataAndLoadFailView2 == null) {
                            return;
                        }
                        noDataAndLoadFailView2.a();
                        return;
                    }
                    NoDataAndLoadFailView noDataAndLoadFailView3 = FeedTopicDetailBaseFragment.this.b;
                    if (noDataAndLoadFailView3 != null) {
                        noDataAndLoadFailView3.d();
                    }
                    if (!FeedTopicDetailBaseFragment.this.j()) {
                        FeedListAdapterForRecyclerView feedListAdapterForRecyclerView2 = FeedTopicDetailBaseFragment.this.a;
                        if (!((feedListAdapterForRecyclerView2 == null || (data2 = feedListAdapterForRecyclerView2.getData()) == null || data2.size() != 0) ? false : true)) {
                            View h = FeedTopicDetailBaseFragment.this.h();
                            if (h == null) {
                                return;
                            }
                            h.setVisibility(0);
                            return;
                        }
                    }
                    View h2 = FeedTopicDetailBaseFragment.this.h();
                    if (h2 == null) {
                        return;
                    }
                    h2.setVisibility(8);
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIUpdate(BluedEntity<BluedTopic, FeedSubjectDetailExtra> bluedEntity) {
                    if (bluedEntity == null) {
                        return;
                    }
                    FeedTopicDetailBaseFragment feedTopicDetailBaseFragment = FeedTopicDetailBaseFragment.this;
                    feedTopicDetailBaseFragment.b(bluedEntity.hasMore());
                    if (bluedEntity.getSingleData() != null && bluedEntity.getSingleData().tt != null) {
                        if (bluedEntity.hasMore()) {
                            feedTopicDetailBaseFragment.b(true);
                            SmartRefreshLayout d = feedTopicDetailBaseFragment.d();
                            if (d != null) {
                                d.b(true);
                            }
                        } else {
                            feedTopicDetailBaseFragment.b(false);
                            SmartRefreshLayout d2 = feedTopicDetailBaseFragment.d();
                            if (d2 != null) {
                                d2.b(false);
                            }
                        }
                        if (!TextUtils.isEmpty(bluedEntity.getSingleData().super_did)) {
                            feedTopicDetailBaseFragment.d = bluedEntity.getSingleData().super_did;
                        }
                        for (BluedIngSelfFeed bluedIngSelfFeed : bluedEntity.getSingleData().tt) {
                            bluedIngSelfFeed.current_track_subject_id = feedTopicDetailBaseFragment.d;
                        }
                        if (feedTopicDetailBaseFragment.i() == 1) {
                            if (!TextUtils.isEmpty(bluedEntity.getSingleData().name)) {
                                feedTopicDetailBaseFragment.f = bluedEntity.getSingleData();
                                feedTopicDetailBaseFragment.c();
                            }
                            if (bluedEntity.getSingleData().tt.size() == 0) {
                                NoDataAndLoadFailView noDataAndLoadFailView = feedTopicDetailBaseFragment.b;
                                if (noDataAndLoadFailView != null) {
                                    noDataAndLoadFailView.a();
                                }
                            } else {
                                NoDataAndLoadFailView noDataAndLoadFailView2 = feedTopicDetailBaseFragment.b;
                                if (noDataAndLoadFailView2 != null) {
                                    noDataAndLoadFailView2.d();
                                }
                            }
                        }
                        if (feedTopicDetailBaseFragment.i() == 1) {
                            FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = feedTopicDetailBaseFragment.a;
                            if (feedListAdapterForRecyclerView != null) {
                                feedListAdapterForRecyclerView.a(bluedEntity.getSingleData().tt);
                            }
                        } else {
                            FeedListAdapterForRecyclerView feedListAdapterForRecyclerView2 = feedTopicDetailBaseFragment.a;
                            if (feedListAdapterForRecyclerView2 != null) {
                                feedListAdapterForRecyclerView2.b(bluedEntity.getSingleData().tt);
                            }
                        }
                        feedTopicDetailBaseFragment.t = null;
                    } else if (feedTopicDetailBaseFragment.i() != 1) {
                        feedTopicDetailBaseFragment.a(feedTopicDetailBaseFragment.i() - 1);
                        feedTopicDetailBaseFragment.b(false);
                    }
                    if (bluedEntity.extra == null || bluedEntity.extra.draw_floor <= 0) {
                        return;
                    }
                    feedTopicDetailBaseFragment.c(bluedEntity.extra.draw_floor);
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public BluedEntity<BluedTopic, FeedSubjectDetailExtra> parseData(String response) {
                    String str;
                    Intrinsics.e(response, "response");
                    BluedEntity<BluedTopic, FeedSubjectDetailExtra> parseData = super.parseData(response);
                    if (parseData != null) {
                        if (!parseData.hasData()) {
                            return parseData;
                        }
                        for (BluedIngSelfFeed bluedIngSelfFeed : parseData.getSingleData().tt) {
                            bluedIngSelfFeed.feedParse = new FeedParse(FeedTopicDetailBaseFragment.this.getContext(), bluedIngSelfFeed, FeedTopicDetailBaseFragment.this.k());
                            str = FeedTopicDetailBaseFragment.this.t;
                            boolean z2 = false;
                            if (str != null) {
                                String str2 = str;
                                String str3 = bluedIngSelfFeed.feed_id;
                                Intrinsics.c(str3, "item.feed_id");
                                if (StringsKt.c((CharSequence) str2, (CharSequence) str3, false, 2, (Object) null)) {
                                    z2 = true;
                                }
                            }
                            if (z2) {
                                bluedIngSelfFeed.is_op_recommend = 1;
                            }
                        }
                    }
                    return parseData;
                }
            }, this.e, this.d, g.a.g, String.valueOf(this.n), String.valueOf(this.o), this.q, this.t, getFragmentActive());
            return;
        }
        this.n = i - 1;
        AppMethods.a((CharSequence) getString(R.string.common_nomore_data));
        SmartRefreshLayout smartRefreshLayout = this.i;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.g();
        }
        SmartRefreshLayout smartRefreshLayout2 = this.i;
        if (smartRefreshLayout2 == null) {
            return;
        }
        smartRefreshLayout2.h();
    }

    public void b() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(int i) {
        this.r = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(boolean z) {
        this.p = z;
    }

    public void c() {
        String str;
        BluedTopic bluedTopic = this.f;
        if (bluedTopic == null) {
            return;
        }
        this.d = bluedTopic.super_did;
        this.e = bluedTopic.name;
        int i = R.drawable.topic_default_bg;
        if (bluedTopic.is_anonym == 1) {
            FloatFooterView g = g();
            if (g != null) {
                g.setBtnText(R.string.super_topic_post);
            }
            i = R.drawable.topic_anonymous_default_header;
        } else {
            FloatFooterView g2 = g();
            if (g2 != null) {
                g2.setBtnText(R.string.post);
            }
        }
        if (!TextUtils.isEmpty(bluedTopic.avatar)) {
            this.g = bluedTopic.avatar;
        }
        ImageView imageView = this.c;
        if (imageView == null || (str = this.g) == null) {
            return;
        }
        ImageLoader.a(getFragmentActive(), Intrinsics.a(str, (Object) "!750x430.png")).b(i).d(i).a(this.h).a(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(int i) {
        this.s = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SmartRefreshLayout d() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final RecyclerView e() {
        return this.j;
    }

    public final LinearLayoutManager f() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final FloatFooterView g() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View h() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int i() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean j() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int k() {
        return this.r;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int l() {
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void m() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n() {
        BluedTopic bluedTopic = this.f;
        if (bluedTopic == null) {
            return;
        }
        BluedTopic bluedTopic2 = new BluedTopic();
        bluedTopic2.super_did = bluedTopic.super_did;
        bluedTopic2.avatar = bluedTopic.avatar;
        bluedTopic2.name = bluedTopic.name;
        if (TextUtils.isEmpty(bluedTopic.description)) {
            bluedTopic2.description = getString(R.string.share_a_topic_to_you);
        } else {
            bluedTopic2.description = bluedTopic.description;
        }
        CommunityShareUtils.b().a(getContext(), bluedTopic2);
    }

    public void o() {
        String str;
        BluedTopic bluedTopic = this.f;
        if (bluedTopic == null) {
            return;
        }
        if (!TextUtils.isEmpty(bluedTopic.super_did) && !TextUtils.isEmpty(bluedTopic.name)) {
            FeedAddPostFragment.a(getContext(), bluedTopic);
            str = bluedTopic.super_did;
        } else if (TextUtils.isEmpty(this.d) || TextUtils.isEmpty(this.e)) {
            FeedAddPostFragment.a(getContext());
            str = null;
        } else {
            bluedTopic.super_did = this.d;
            bluedTopic.name = this.e;
            FeedAddPostFragment.a(getContext(), bluedTopic);
            str = this.d;
        }
        EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_BTN_CLICK, FeedProtos.FeedFrom.SUPER_TOPIC_DETAIL, str, false, bluedTopic.is_anonym == 1, "");
    }

    public void onInitView() {
        super.onInitView();
        FloatFooterView findViewById = this.rootView.findViewById(R.id.ll_feed_post);
        this.l = findViewById;
        if (findViewById != null) {
            findViewById.setOnBtnClickListener(new FloatFooterView.OnBtnClickListener() { // from class: com.blued.community.ui.subject.fragment.-$$Lambda$FeedTopicDetailBaseFragment$HGdZUl5NQcPhY030Hc2Bbb_jsUQ
                public final void onPostFeedClick() {
                    FeedTopicDetailBaseFragment.b(FeedTopicDetailBaseFragment.this);
                }
            });
        }
        this.i = this.rootView.findViewById(R.id.refresh_layout);
        this.j = this.rootView.findViewById(R.id.recycler_view);
        a();
        b();
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        FeedMethods.a(lifecycleOwner, this.a);
        CircleMethods.a(lifecycleOwner, this.a);
    }

    public void onParseArguments() {
        super.onParseArguments();
        this.d = this.args.getString("topic_id");
        this.e = this.args.getString("topic_name");
        this.t = this.args.getString("insert_tt_dids", "");
    }

    public void onPause() {
        super.onPause();
        FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.a;
        if (feedListAdapterForRecyclerView == null) {
            return;
        }
        feedListAdapterForRecyclerView.e();
    }

    public void onResume() {
        super.onResume();
        FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.a;
        if (feedListAdapterForRecyclerView == null) {
            return;
        }
        feedListAdapterForRecyclerView.d();
    }
}
