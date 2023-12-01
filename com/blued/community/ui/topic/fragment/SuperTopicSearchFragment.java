package com.blued.community.ui.topic.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.SearchEditText;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.view.SearchView;
import com.blued.android.module.common.widget.refresh.BluedAdapterLoadMoreView;
import com.blued.community.R;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.feed.manager.FeedConstants;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.topic.adapter.SuperTopicAdapter;
import com.blued.community.ui.topic.model.BluedTopic;
import com.blued.community.ui.topic.model.BluedTopicExtra;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.Collection;

/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/topic/fragment/SuperTopicSearchFragment.class */
public class SuperTopicSearchFragment extends KeyBoardFragment {
    public SearchEditText b;

    /* renamed from: c  reason: collision with root package name */
    private Context f20272c;
    private LayoutInflater j;
    private KeyboardListenLinearLayout k;
    private PullToRefreshRecyclerView l;
    private RecyclerView m;
    private SuperTopicAdapter n;
    private NoDataAndLoadFailView o;
    private SearchView s;
    private int p = 1;
    private int q = 20;
    private boolean r = true;
    private BluedUIHttpResponse t = new BluedUIHttpResponse<BluedEntity<BluedTopic, BluedTopicExtra>>(getFragmentActive()) { // from class: com.blued.community.ui.topic.fragment.SuperTopicSearchFragment.6

        /* renamed from: a  reason: collision with root package name */
        boolean f20278a;

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public boolean onUIFailure(int i, String str) {
            this.f20278a = true;
            return super.onUIFailure(i, str);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            super.onUIFinish();
            SuperTopicSearchFragment.this.l.j();
            if (!this.f20278a) {
                if (SuperTopicSearchFragment.this.r) {
                    SuperTopicSearchFragment.this.n.loadMoreComplete();
                    return;
                } else {
                    SuperTopicSearchFragment.this.n.loadMoreEnd();
                    return;
                }
            }
            SuperTopicSearchFragment.this.o.b();
            if (SuperTopicSearchFragment.this.n.getData().size() > 0) {
                SuperTopicSearchFragment.this.n.loadMoreFail();
            } else {
                SuperTopicSearchFragment.this.n.setEnableLoadMore(false);
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIUpdate(BluedEntity<BluedTopic, BluedTopicExtra> bluedEntity) {
            if (bluedEntity != null) {
                BluedTopicExtra bluedTopicExtra = bluedEntity.extra;
                if (bluedTopicExtra != null && bluedTopicExtra.super_topics_exist == 0) {
                    SuperTopicSearchFragment.this.o.a();
                }
                if (!bluedEntity.hasData()) {
                    if (SuperTopicSearchFragment.this.p == 1) {
                        SuperTopicSearchFragment.this.n.setNewData(bluedEntity.data);
                    }
                    if (SuperTopicSearchFragment.this.p != 1) {
                        SuperTopicSearchFragment.g(SuperTopicSearchFragment.this);
                        SuperTopicSearchFragment.this.r = false;
                        return;
                    }
                    return;
                }
                SuperTopicSearchFragment.this.r = bluedEntity.hasMore();
                if (SuperTopicSearchFragment.this.p != 1 || bluedTopicExtra == null || TextUtils.isEmpty(bluedTopicExtra.q)) {
                    SuperTopicSearchFragment.this.n.addData((Collection) bluedEntity.data);
                    return;
                }
                SuperTopicSearchFragment.this.n.a(bluedTopicExtra.q);
                SuperTopicSearchFragment.this.n.setNewData(bluedEntity.data);
            }
        }
    };

    public static void a(Context context) {
        TerminalActivity.d(context, SuperTopicSearchFragment.class, new Bundle());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str) {
        int i;
        if (TextUtils.isEmpty(str)) {
            this.l.j();
            this.n.setEnableLoadMore(false);
            return;
        }
        if (z) {
            this.p = 1;
        }
        if (this.p == 1) {
            this.r = true;
        }
        if (this.r || (i = this.p) == 1) {
            EventTrackFeed.g(FeedProtos.Event.SUPER_TOPIC_SEARCH_KEYWORD, str);
            FeedHttpUtils.a(this.t, this.p, this.q, str, getFragmentActive());
            return;
        }
        this.p = i - 1;
        AppMethods.d(R.string.common_nomore_data);
        this.l.j();
        this.n.loadMoreEnd();
    }

    static /* synthetic */ int e(SuperTopicSearchFragment superTopicSearchFragment) {
        int i = superTopicSearchFragment.p;
        superTopicSearchFragment.p = i + 1;
        return i;
    }

    static /* synthetic */ int g(SuperTopicSearchFragment superTopicSearchFragment) {
        int i = superTopicSearchFragment.p;
        superTopicSearchFragment.p = i - 1;
        return i;
    }

    private void h() {
        SearchView searchView = (SearchView) this.k.findViewById(R.id.search_view);
        this.s = searchView;
        SearchEditText editView = searchView.getEditView();
        this.b = editView;
        FeedMethods.a(editView);
        this.s.setOnSearchInfoListener(new SearchView.OnSearchInfoListener() { // from class: com.blued.community.ui.topic.fragment.SuperTopicSearchFragment.1
            @Override // com.blued.android.module.common.view.SearchView.OnSearchInfoListener
            public void a() {
                KeyboardUtils.a(SuperTopicSearchFragment.this.getActivity());
                SuperTopicSearchFragment.this.getActivity().finish();
            }

            @Override // com.blued.android.module.common.view.SearchView.OnSearchInfoListener
            public void a(String str) {
                SuperTopicSearchFragment.this.n.setNewData(null);
                SuperTopicSearchFragment.this.o.d();
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                SuperTopicSearchFragment.this.p = 1;
                SuperTopicSearchFragment.this.n.setEnableLoadMore(true);
                SuperTopicSearchFragment.this.a(true, str);
            }

            @Override // com.blued.android.module.common.view.SearchView.OnSearchInfoListener
            public void b() {
            }
        });
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.topic.fragment.SuperTopicSearchFragment.2
            @Override // java.lang.Runnable
            public void run() {
                SuperTopicSearchFragment.this.s.a(true);
                KeyboardUtils.c(SuperTopicSearchFragment.this.getActivity());
                SuperTopicSearchFragment.this.s.getEditView().requestFocus();
                SuperTopicSearchFragment.this.s.getEditView().setCursorVisible(true);
            }
        }, 500L);
    }

    private void i() {
        PullToRefreshRecyclerView pullToRefreshRecyclerView = (PullToRefreshRecyclerView) this.k.findViewById(R.id.list_view_search);
        this.l = pullToRefreshRecyclerView;
        pullToRefreshRecyclerView.setRefreshEnabled(true);
        RecyclerView refreshableView = this.l.getRefreshableView();
        this.m = refreshableView;
        refreshableView.setClipToPadding(false);
        this.m.setScrollBarStyle(33554432);
        this.m.setLayoutManager(new LinearLayoutManager(this.f20272c));
        SuperTopicAdapter superTopicAdapter = new SuperTopicAdapter(this.f20272c, getFragmentActive());
        this.n = superTopicAdapter;
        this.m.setAdapter(superTopicAdapter);
        NoDataAndLoadFailView noDataAndLoadFailView = new NoDataAndLoadFailView(this.f20272c);
        this.o = noDataAndLoadFailView;
        noDataAndLoadFailView.setNoDataImg(R.drawable.icon_no_data_common);
        this.o.setNoDataStr(R.string.super_topic_no_data);
        this.o.setTopSpace(DensityUtils.a(this.f20272c, 84.0f));
        this.o.setImageScale(1.0f);
        this.o.d();
        this.n.setEmptyView(this.o);
        this.n.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.community.ui.topic.fragment.SuperTopicSearchFragment.3
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                if (baseQuickAdapter.getItem(i) == null || !(baseQuickAdapter.getItem(i) instanceof BluedTopic)) {
                    return;
                }
                BluedTopic bluedTopic = (BluedTopic) baseQuickAdapter.getItem(i);
                FeedConstants.b = FeedProtos.DetailFrom.FIND_SUPER_TOPIC_LIST;
                SuperTopicDetailFragment.a(SuperTopicSearchFragment.this.f20272c, bluedTopic.super_did);
            }
        });
        this.l.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<RecyclerView>() { // from class: com.blued.community.ui.topic.fragment.SuperTopicSearchFragment.4
            @Override // com.blued.android.framework.view.pulltorefresh.PullToRefreshBase.OnRefreshListener
            public void onRefresh(PullToRefreshBase<RecyclerView> pullToRefreshBase) {
                SuperTopicSearchFragment.this.p = 1;
                SuperTopicSearchFragment superTopicSearchFragment = SuperTopicSearchFragment.this;
                superTopicSearchFragment.a(true, superTopicSearchFragment.b.getText().toString());
            }
        });
        this.n.setLoadMoreView(new BluedAdapterLoadMoreView());
        this.n.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.blued.community.ui.topic.fragment.SuperTopicSearchFragment.5
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
            public void onLoadMoreRequested() {
                SuperTopicSearchFragment.e(SuperTopicSearchFragment.this);
                SuperTopicSearchFragment superTopicSearchFragment = SuperTopicSearchFragment.this;
                superTopicSearchFragment.a(false, superTopicSearchFragment.b.getText().toString());
            }
        }, this.m);
    }

    @Override // com.blued.android.framework.activity.keyboardpage.KeyBoardFragment
    public void j_(int i) {
        if (i != -3) {
            if (i != -2) {
                return;
            }
            this.s.a(false);
            return;
        }
        SearchView searchView = this.s;
        if (searchView != null) {
            searchView.a(true);
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getActivity().getWindow().setSoftInputMode(16);
        this.f20272c = getActivity();
        KeyboardListenLinearLayout keyboardListenLinearLayout = this.k;
        if (keyboardListenLinearLayout == null) {
            KeyboardListenLinearLayout keyboardListenLinearLayout2 = (KeyboardListenLinearLayout) layoutInflater.inflate(R.layout.fragment_hot_topic_search_list, viewGroup, false);
            this.k = keyboardListenLinearLayout2;
            super.a(keyboardListenLinearLayout2);
            this.j = LayoutInflater.from(getActivity());
            h();
            i();
        } else if (keyboardListenLinearLayout.getParent() != null) {
            ((ViewGroup) this.k.getParent()).removeView(this.k);
        }
        return this.k;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }
}
