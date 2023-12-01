package com.blued.community.ui.topic.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.widget.refresh.BluedAdapterLoadMoreView;
import com.blued.community.R;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.topic.adapter.MyTopicAdapter;
import com.blued.community.ui.topic.adapter.SuperTopicAdapter;
import com.blued.community.ui.topic.model.BluedTopic;
import com.blued.community.ui.topic.model.BluedTopicExtra;
import com.blued.community.utils.MarkDownLinkHelper;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.Collection;

/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/topic/fragment/MyTopicSinglePageFragment.class */
public class MyTopicSinglePageFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    public CommonTopTitleNoTrans f20259a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private View f20260c;
    private PullToRefreshRecyclerView d;
    private RecyclerView e;
    private MyTopicAdapter f;
    private NoDataAndLoadFailView g;
    private int h = 1;
    private int i = 20;
    private boolean j = true;
    private MyTopicAdapter.MY_TOPIC_PAGE k = MyTopicAdapter.MY_TOPIC_PAGE.CREATED;
    private BluedUIHttpResponse l = new BluedUIHttpResponse<BluedEntity<BluedTopic, BluedTopicExtra>>(getFragmentActive()) { // from class: com.blued.community.ui.topic.fragment.MyTopicSinglePageFragment.4

        /* renamed from: a  reason: collision with root package name */
        boolean f20264a;

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public boolean onUIFailure(int i, String str) {
            this.f20264a = true;
            return super.onUIFailure(i, str);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            super.onUIFinish();
            MyTopicSinglePageFragment.this.d.j();
            MyTopicSinglePageFragment.this.f.loadMoreComplete();
            if (this.f20264a) {
                MyTopicSinglePageFragment.this.g.b();
                if (MyTopicSinglePageFragment.this.f.getData().size() > 0) {
                    MyTopicSinglePageFragment.this.f.loadMoreFail();
                    return;
                }
                return;
            }
            if (MyTopicSinglePageFragment.this.f.getData().size() == 0) {
                MyTopicSinglePageFragment.this.g.a();
            } else {
                MyTopicSinglePageFragment.this.g.d();
            }
            if (MyTopicSinglePageFragment.this.j) {
                MyTopicSinglePageFragment.this.f.setEnableLoadMore(true);
                return;
            }
            MyTopicSinglePageFragment.this.f.loadMoreEnd();
            MyTopicSinglePageFragment.this.f.setEnableLoadMore(false);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIUpdate(BluedEntity<BluedTopic, BluedTopicExtra> bluedEntity) {
            if (bluedEntity != null) {
                if (!bluedEntity.hasData()) {
                    if (MyTopicSinglePageFragment.this.h == 1) {
                        MyTopicSinglePageFragment.this.f.setNewData(bluedEntity.data);
                    }
                    if (MyTopicSinglePageFragment.this.h != 1) {
                        MyTopicSinglePageFragment.d(MyTopicSinglePageFragment.this);
                        MyTopicSinglePageFragment.this.j = false;
                        return;
                    }
                    return;
                }
                if (bluedEntity.hasMore()) {
                    MyTopicSinglePageFragment.this.j = true;
                } else {
                    MyTopicSinglePageFragment.this.j = false;
                }
                if (MyTopicSinglePageFragment.this.h == 1) {
                    MyTopicSinglePageFragment.this.f.setNewData(bluedEntity.data);
                } else {
                    MyTopicSinglePageFragment.this.f.addData((Collection) bluedEntity.data);
                }
            }
        }
    };

    static /* synthetic */ int a(MyTopicSinglePageFragment myTopicSinglePageFragment) {
        int i = myTopicSinglePageFragment.h;
        myTopicSinglePageFragment.h = i + 1;
        return i;
    }

    private void a() {
        ((KeyboardListenLinearLayout) this.f20260c.findViewById(R.id.keyboard_root)).setBackgroundColor(BluedSkinUtils.a(getContext(), R.color.syc_b));
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.f20260c.findViewById(R.id.title);
        this.f20259a = commonTopTitleNoTrans;
        commonTopTitleNoTrans.setLeftClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.topic.fragment.-$$Lambda$MyTopicSinglePageFragment$bBF4P3WNhySFdCI78bVy6ah_y5g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyTopicSinglePageFragment.this.a(view);
            }
        });
        PullToRefreshRecyclerView pullToRefreshRecyclerView = (PullToRefreshRecyclerView) this.f20260c.findViewById(R.id.list_view_search);
        this.d = pullToRefreshRecyclerView;
        pullToRefreshRecyclerView.setBackgroundColor(BluedSkinUtils.a(this.b, R.color.syc_b));
        this.d.setRefreshEnabled(true);
        RecyclerView refreshableView = this.d.getRefreshableView();
        this.e = refreshableView;
        refreshableView.setClipToPadding(false);
        this.e.setScrollBarStyle(33554432);
        this.e.setLayoutManager(new LinearLayoutManager(this.b));
        MyTopicAdapter myTopicAdapter = new MyTopicAdapter(this.b, this.k, getFragmentActive());
        this.f = myTopicAdapter;
        this.e.setAdapter(myTopicAdapter);
        NoDataAndLoadFailView noDataAndLoadFailView = new NoDataAndLoadFailView(this.b);
        this.g = noDataAndLoadFailView;
        noDataAndLoadFailView.setNoDataImg(R.drawable.icon_no_data_common);
        this.g.setNoDataStr(R.string.no_joined_topic_yet);
        this.g.setTopSpace(DensityUtils.a(this.b, 90.0f));
        this.g.setImageScale(1.0f);
        this.g.d();
        this.f.setEmptyView(this.g);
        this.f.a(new SuperTopicAdapter.OnShowListener() { // from class: com.blued.community.ui.topic.fragment.MyTopicSinglePageFragment.1
            @Override // com.blued.community.ui.topic.adapter.SuperTopicAdapter.OnShowListener
            public void a(BluedTopic bluedTopic) {
                FeedProtos.Event event = FeedProtos.Event.SUPER_TOPIC_DRAW;
                FeedProtos.DetailFrom detailFrom = FeedProtos.DetailFrom.SUPER_TOPIC_JOIN;
                String str = bluedTopic.super_did;
                boolean z = true;
                boolean z2 = bluedTopic.is_anonym == 1;
                boolean a2 = MarkDownLinkHelper.a(bluedTopic.description);
                if (bluedTopic.is_follow != 1) {
                    z = false;
                }
                EventTrackFeed.a(event, detailFrom, str, z2, a2, z);
            }

            @Override // com.blued.community.ui.topic.adapter.SuperTopicAdapter.OnShowListener
            public void b(BluedTopic bluedTopic) {
            }
        });
        this.d.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<RecyclerView>() { // from class: com.blued.community.ui.topic.fragment.MyTopicSinglePageFragment.2
            @Override // com.blued.android.framework.view.pulltorefresh.PullToRefreshBase.OnRefreshListener
            public void onRefresh(PullToRefreshBase<RecyclerView> pullToRefreshBase) {
                MyTopicSinglePageFragment.this.h = 1;
                MyTopicSinglePageFragment.this.a(true);
            }
        });
        this.f.setLoadMoreView(new BluedAdapterLoadMoreView());
        this.f.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.blued.community.ui.topic.fragment.MyTopicSinglePageFragment.3
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
            public void onLoadMoreRequested() {
                MyTopicSinglePageFragment.a(MyTopicSinglePageFragment.this);
                MyTopicSinglePageFragment.this.a(false);
            }
        }, this.e);
        this.d.k();
    }

    public static void a(Context context, MyTopicAdapter.MY_TOPIC_PAGE my_topic_page) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("PAGE_KEY", my_topic_page);
        TerminalActivity.d(context, MyTopicSinglePageFragment.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        getActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            this.h = 1;
        }
        if (this.k == MyTopicAdapter.MY_TOPIC_PAGE.CREATED) {
            FeedHttpUtils.a(this.l, "created", this.h, this.i, getFragmentActive());
        } else {
            FeedHttpUtils.a(this.l, "joined", this.h, this.i, getFragmentActive());
        }
    }

    static /* synthetic */ int d(MyTopicSinglePageFragment myTopicSinglePageFragment) {
        int i = myTopicSinglePageFragment.h;
        myTopicSinglePageFragment.h = i - 1;
        return i;
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.utils.PageTimeUtils.APMInterface
    public String getPageBizName() {
        return this.k == MyTopicAdapter.MY_TOPIC_PAGE.JOINED ? "A48" : "A47";
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.k = (MyTopicAdapter.MY_TOPIC_PAGE) getArguments().getSerializable("PAGE_KEY");
        FragmentActivity activity = getActivity();
        this.b = activity;
        View view = this.f20260c;
        if (view == null) {
            this.f20260c = LayoutInflater.from(activity).inflate(R.layout.fragment_mine_topic_single_page, viewGroup, false);
            a();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.f20260c.getParent()).removeView(this.f20260c);
        }
        return this.f20260c;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }
}
