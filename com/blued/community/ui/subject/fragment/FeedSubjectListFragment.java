package com.blued.community.ui.subject.fragment;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.cardview.widget.CardView;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.adapter.CommonAdapter;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.community.R;
import com.blued.community.http.CommunityHttpUtils;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.manager.CommunityManager;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.common.CommonRecyclerFragment;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.subject.adapter.FeedSubjectListAdapter;
import com.blued.community.ui.topic.model.BluedTopic;
import com.blued.community.ui.topic.model.BluedTopicExtra;
import com.blued.community.utils.CommRouteUtil;
import com.blued.community.view.CommonMultiItemAdapter;
import com.blued.das.client.feed.FeedProtos;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/subject/fragment/FeedSubjectListFragment.class */
public final class FeedSubjectListFragment extends CommonRecyclerFragment<BluedTopic, BluedTopicExtra> {

    /* renamed from: a  reason: collision with root package name */
    private CardView f20224a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private View f20225c;
    private GridView d;
    private CommonAdapter<BluedTopic> e;
    private View f;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FeedSubjectListFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FeedSubjectListFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.u();
    }

    private final void t() {
        CommRouteUtil.c(getContext());
    }

    private final void u() {
        CommRouteUtil.d(getContext());
        EventTrackFeed.a(FeedProtos.Event.SUPER_TOPIC_MINE_BTN_CLICK);
    }

    @Override // com.blued.community.ui.common.CommonRecyclerFragment
    public void a(boolean z) {
        super.a(z);
        if (z) {
            final ActivityFragmentActive fragmentActive = getFragmentActive();
            FeedHttpUtils.f(new BluedUIHttpResponse<BluedEntityA<BluedTopic>>(fragmentActive) { // from class: com.blued.community.ui.subject.fragment.FeedSubjectListFragment$getData$1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<BluedTopic> parseData) {
                    Intrinsics.e(parseData, "parseData");
                    if (!parseData.hasData()) {
                        View q = FeedSubjectListFragment.this.q();
                        if (q == null) {
                            return;
                        }
                        q.setVisibility(8);
                        return;
                    }
                    View q2 = FeedSubjectListFragment.this.q();
                    if (q2 != null) {
                        q2.setVisibility(0);
                    }
                    GridView r = FeedSubjectListFragment.this.r();
                    if (r != null) {
                        ViewGroup.LayoutParams layoutParams = r.getLayoutParams();
                        if (layoutParams == null) {
                            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                        }
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                        if (parseData.data.size() > 2) {
                            layoutParams2.height = FeedMethods.c(125);
                        } else {
                            layoutParams2.height = FeedMethods.c(65);
                        }
                    }
                    CommonAdapter<BluedTopic> s = FeedSubjectListFragment.this.s();
                    if (s == null) {
                        return;
                    }
                    s.a(parseData.data);
                }
            }, getFragmentActive());
        }
    }

    @Override // com.blued.community.ui.common.CommonRecyclerFragment
    public int f() {
        return R.string.subject_title;
    }

    @Override // com.blued.community.ui.common.CommonRecyclerFragment
    public CommonMultiItemAdapter<BluedTopic> g() {
        return new FeedSubjectListAdapter(0);
    }

    @Override // com.blued.community.ui.common.CommonRecyclerFragment
    public void j() {
        super.j();
        NoDataAndLoadFailView b = b();
        if (b == null) {
            return;
        }
        b.setNoDataBtnStr(R.string.common_no_data);
    }

    @Override // com.blued.community.ui.common.CommonRecyclerFragment
    public Type k() {
        Type type = new TypeToken<BluedEntity<BluedTopic, BluedTopicExtra>>() { // from class: com.blued.community.ui.subject.fragment.FeedSubjectListFragment$getHttpResDataType$1
        }.getType();
        Intrinsics.c(type, "object : TypeToken<Blued…uedTopicExtra>>() {}.type");
        return type;
    }

    @Override // com.blued.community.ui.common.CommonRecyclerFragment
    public String l() {
        return Intrinsics.a(CommunityHttpUtils.a(), (Object) "/ticktocks/super_topics?filter=list");
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public void onInitListener() {
        super.onInitListener();
        CardView cardView = this.f20224a;
        if (cardView != null) {
            cardView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.subject.fragment.-$$Lambda$FeedSubjectListFragment$dJ4Dmxk0-idVJdM_q1i_WjmOdJM
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedSubjectListFragment.a(FeedSubjectListFragment.this, view);
                }
            });
        }
        View view = this.f20225c;
        if (view == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.subject.fragment.-$$Lambda$FeedSubjectListFragment$wSYRfLbDpEx1wCE9YS_swC92vyM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FeedSubjectListFragment.b(FeedSubjectListFragment.this, view2);
            }
        });
    }

    @Override // com.blued.community.ui.common.CommonRecyclerFragment, com.blued.android.framework.ui.SimpleFragment
    public void onInitView() {
        CommonMultiItemAdapter<BluedTopic> a2;
        super.onInitView();
        View inflate = getLayoutInflater().inflate(R.layout.feed_subject_list_header, (ViewGroup) null);
        this.f = inflate;
        CardView cardView = inflate == null ? null : (CardView) inflate.findViewById(R.id.feed_subject_list_search);
        this.f20224a = cardView;
        if (cardView != null) {
            cardView.setCardBackgroundColor(CommunityManager.f19086a.a().s() ? Color.parseColor("#202020") : getResources().getColor(R.color.syc_c));
        }
        View view = this.f;
        this.f20225c = view == null ? null : view.findViewById(R.id.feed_subject_list_mine_layout);
        View view2 = this.f;
        this.b = view2 == null ? null : view2.findViewById(R.id.feed_subject_list_my_join_all);
        View view3 = this.f;
        this.d = view3 == null ? null : (GridView) view3.findViewById(R.id.feed_subject_list_my_join_grid);
        FeedSubjectListFragment$onInitView$1 feedSubjectListFragment$onInitView$1 = new FeedSubjectListFragment$onInitView$1(this, R.layout.item_feed_subject_my_grid);
        this.e = feedSubjectListFragment$onInitView$1;
        GridView gridView = this.d;
        if (gridView != null) {
            gridView.setAdapter((ListAdapter) feedSubjectListFragment$onInitView$1);
        }
        View view4 = this.f;
        if (view4 == null || (a2 = a()) == null) {
            return;
        }
        a2.addHeaderView(view4);
    }

    @Override // com.blued.community.ui.common.CommonRecyclerFragment, com.blued.android.framework.ui.SimpleFragment
    public int onSetRootViewId() {
        return R.layout.fragment_feed_subject_list;
    }

    public final View q() {
        return this.f20225c;
    }

    public final GridView r() {
        return this.d;
    }

    public final CommonAdapter<BluedTopic> s() {
        return this.e;
    }
}
