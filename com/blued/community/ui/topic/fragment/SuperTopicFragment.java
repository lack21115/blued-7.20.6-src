package com.blued.community.ui.topic.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.common.utils.click.SingleItemClickProxy;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.view.SearchView;
import com.blued.android.module.common.widget.refresh.BluedAdapterLoadMoreView;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.feed.manager.FeedConstants;
import com.blued.community.ui.topic.adapter.MyTopicAdapter;
import com.blued.community.ui.topic.adapter.SuperTopicAdapter;
import com.blued.community.ui.topic.model.BluedTopic;
import com.blued.community.ui.topic.presenter.SuperTopicPresenter;
import com.blued.community.utils.CommRouteUtil;
import com.blued.community.utils.MarkDownLinkHelper;
import com.blued.das.client.feed.FeedProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/topic/fragment/SuperTopicFragment.class */
public class SuperTopicFragment extends MvpFragment<SuperTopicPresenter> implements View.OnClickListener {
    private CommonTopTitleNoTrans a;
    private SearchView b;
    private RecyclerView c;
    private SmartRefreshLayout d;
    private TextView e;
    private SuperTopicAdapter f;
    private NoDataAndLoadFailView g;

    public static void a(Context context) {
        if (!CommunityServiceManager.a().A()) {
            AppMethods.d(R.string.common_page_service_upgraded);
        } else if (CommunityServiceManager.a().D() == 1) {
            CommRouteUtil.b(context);
        } else {
            TerminalActivity.d(context, SuperTopicFragment.class, null);
        }
    }

    private void b() {
        this.a = (CommonTopTitleNoTrans) this.i.findViewById(R.id.title);
        this.b = (SearchView) this.i.findViewById(R.id.search_view);
        this.c = this.i.findViewById(R.id.recycler_view);
        this.d = this.i.findViewById(R.id.refresh_layout);
        TextView textView = (TextView) this.i.findViewById(R.id.tv_my_topic);
        this.e = textView;
        textView.setOnClickListener(this);
    }

    private void b(boolean z) {
        this.d.g();
        this.d.h();
        if (this.f.getData().size() <= 0) {
            if (z) {
                this.g.a();
            } else {
                this.g.b();
            }
        }
    }

    private void c() {
        this.a.setLeftClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.topic.fragment.SuperTopicFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                SuperTopicFragment.this.t();
            }
        });
    }

    private void d() {
        this.c.setLayoutManager(new LinearLayoutManager(getContext()));
        SuperTopicAdapter superTopicAdapter = new SuperTopicAdapter(getContext(), getFragmentActive());
        this.f = superTopicAdapter;
        superTopicAdapter.a(true);
        this.c.setAdapter(this.f);
        NoDataAndLoadFailView noDataAndLoadFailView = new NoDataAndLoadFailView(getContext());
        this.g = noDataAndLoadFailView;
        this.f.setEmptyView(noDataAndLoadFailView);
        this.f.setHeaderAndEmpty(true);
        this.f.setOnItemClickListener(new SingleItemClickProxy(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.community.ui.topic.fragment.SuperTopicFragment.2
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                if (baseQuickAdapter.getItem(i) == null || !(baseQuickAdapter.getItem(i) instanceof BluedTopic)) {
                    return;
                }
                BluedTopic bluedTopic = (BluedTopic) baseQuickAdapter.getItem(i);
                FeedConstants.b = FeedProtos.DetailFrom.FIND_SUPER_TOPIC_LIST;
                SuperTopicDetailFragment.a(SuperTopicFragment.this.getContext(), bluedTopic.super_did);
            }
        }));
        this.f.a(new SuperTopicAdapter.OnShowListener() { // from class: com.blued.community.ui.topic.fragment.SuperTopicFragment.3
            @Override // com.blued.community.ui.topic.adapter.SuperTopicAdapter.OnShowListener
            public void a(BluedTopic bluedTopic) {
                FeedProtos.Event event = FeedProtos.Event.SUPER_TOPIC_DRAW;
                FeedProtos.DetailFrom detailFrom = FeedProtos.DetailFrom.FIND_SUPER_TOPIC_LIST;
                String str = bluedTopic.super_did;
                boolean z = true;
                boolean z2 = bluedTopic.is_anonym == 1;
                boolean a = MarkDownLinkHelper.a(bluedTopic.description);
                if (bluedTopic.is_follow != 1) {
                    z = false;
                }
                EventTrackFeed.a(event, detailFrom, str, z2, a, z);
            }

            @Override // com.blued.community.ui.topic.adapter.SuperTopicAdapter.OnShowListener
            public void b(BluedTopic bluedTopic) {
            }
        });
        this.f.setLoadMoreView(new BluedAdapterLoadMoreView());
        this.d.a(new OnRefreshLoadMoreListener() { // from class: com.blued.community.ui.topic.fragment.SuperTopicFragment.4
            public void onLoadMore(RefreshLayout refreshLayout) {
                SuperTopicFragment.this.j().f();
            }

            public void onRefresh(RefreshLayout refreshLayout) {
                SuperTopicFragment.this.j().e();
            }
        });
    }

    private void e() {
        this.b.setMaskLayerOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.topic.fragment.SuperTopicFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                SuperTopicSearchFragment.a(SuperTopicFragment.this.getContext());
            }
        });
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        b();
        c();
        e();
        d();
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(List<BluedTopic> list) {
        this.f.setNewData(list);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void af_() {
        super.af_();
        this.g = null;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_super_topic;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void g_(String str) {
        super.g_(str);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void l() {
        this.d.i();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void o() {
        super.o();
        this.d.b(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.tv_my_topic) {
            EventTrackFeed.a(FeedProtos.Event.SUPER_TOPIC_MINE_BTN_CLICK);
            MyTopicSinglePageFragment.a(getContext(), MyTopicAdapter.MY_TOPIC_PAGE.JOINED);
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void p() {
        super.p();
        this.d.b(false);
        AppMethods.d(R.string.common_nomore_data);
    }
}
