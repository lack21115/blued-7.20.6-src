package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.model.FeedParse;
import com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.soft.blued.R;
import com.soft.blued.http.MineHttpUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/UserInfoFragmentMyFeedTab.class */
public class UserInfoFragmentMyFeedTab extends BaseFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public Context f20316a;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    public PullToRefreshRecyclerView f20317c;
    public RecyclerView d;
    public FeedListAdapterForRecyclerView e;
    private NoDataAndLoadFailView g;
    private int h = 1;
    private int i = 20;
    private boolean j = true;
    BluedUIHttpResponse f = new BluedUIHttpResponse<BluedEntity<BluedIngSelfFeed, BluedEntityBaseExtra>>(getFragmentActive()) { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentMyFeedTab.3

        /* renamed from: a  reason: collision with root package name */
        boolean f20320a = false;

        private void a(BluedEntity<BluedIngSelfFeed, BluedEntityBaseExtra> bluedEntity, boolean z) {
            if (bluedEntity == null || bluedEntity.data == null || bluedEntity.data.size() <= 0) {
                return;
            }
            if (bluedEntity.hasMore()) {
                UserInfoFragmentMyFeedTab.this.j = true;
                UserInfoFragmentMyFeedTab.this.e.setEnableLoadMore(true);
            } else {
                UserInfoFragmentMyFeedTab.this.j = false;
                UserInfoFragmentMyFeedTab.this.e.setEnableLoadMore(false);
            }
            if (UserInfoFragmentMyFeedTab.this.h == 1) {
                UserInfoFragmentMyFeedTab.this.e.setNewData(bluedEntity.data);
            } else {
                UserInfoFragmentMyFeedTab.this.e.addData(bluedEntity.data);
            }
            UserInfoFragmentMyFeedTab.this.e.notifyDataSetChanged();
        }

        public void onUICache(BluedEntity<BluedIngSelfFeed, BluedEntityBaseExtra> bluedEntity) {
            a(bluedEntity, true);
        }

        public boolean onUIFailure(int i, String str) {
            this.f20320a = true;
            if (UserInfoFragmentMyFeedTab.this.h != 1) {
                UserInfoFragmentMyFeedTab.b(UserInfoFragmentMyFeedTab.this);
            }
            return super.onUIFailure(i, str);
        }

        public void onUIFinish() {
            if (UserInfoFragmentMyFeedTab.this.e.getItemCount() != 1) {
                UserInfoFragmentMyFeedTab.this.g.d();
            } else if (this.f20320a) {
                UserInfoFragmentMyFeedTab.this.g.b();
            } else {
                UserInfoFragmentMyFeedTab.this.g.a();
            }
            this.f20320a = false;
            UserInfoFragmentMyFeedTab.this.e.notifyDataSetChanged();
            UserInfoFragmentMyFeedTab.this.e.loadMoreComplete();
            UserInfoFragmentMyFeedTab.this.f20317c.j();
        }

        public void onUIStart() {
            super.onUIStart();
        }

        public void onUIUpdate(BluedEntity<BluedIngSelfFeed, BluedEntityBaseExtra> bluedEntity) {
            a(bluedEntity, false);
        }

        public BluedEntity<BluedIngSelfFeed, BluedEntityBaseExtra> parseData(String str) {
            BluedEntity<BluedIngSelfFeed, BluedEntityBaseExtra> parseData = super.parseData(str);
            if (parseData != null) {
                if (!parseData.hasData()) {
                    return parseData;
                }
                for (BluedIngSelfFeed bluedIngSelfFeed : parseData.data) {
                    bluedIngSelfFeed.feedParse = new FeedParse(UserInfoFragmentMyFeedTab.this.f20316a, bluedIngSelfFeed, 11);
                }
            }
            return parseData;
        }
    };

    private void a() {
    }

    static /* synthetic */ int b(UserInfoFragmentMyFeedTab userInfoFragmentMyFeedTab) {
        int i = userInfoFragmentMyFeedTab.h;
        userInfoFragmentMyFeedTab.h = i - 1;
        return i;
    }

    private void b() {
        NoDataAndLoadFailView noDataAndLoadFailView = new NoDataAndLoadFailView(this.f20316a);
        this.g = noDataAndLoadFailView;
        noDataAndLoadFailView.d();
        this.g.setImageScale(0.7f);
        this.g.setTopSpace(DensityUtils.a(this.f20316a, 58.0f));
        PullToRefreshRecyclerView findViewById = this.b.findViewById(R.id.wrapper);
        this.f20317c = findViewById;
        findViewById.setRefreshEnabled(true);
        RecyclerView recyclerView = (RecyclerView) this.f20317c.getRefreshableView();
        this.d = recyclerView;
        RecyclerView.Adapter feedListAdapterForRecyclerView = new FeedListAdapterForRecyclerView(this.f20316a, this, recyclerView, 11);
        this.e = feedListAdapterForRecyclerView;
        this.d.setAdapter(feedListAdapterForRecyclerView);
        this.e.setEmptyView(this.g);
        this.d.setLayoutManager(new GridLayoutManager(this.f20316a, 1));
        this.e.setEnableLoadMore(true);
        this.e.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentMyFeedTab.1
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
            public void onLoadMoreRequested() {
                UserInfoFragmentMyFeedTab.this.a(false);
            }
        });
        this.f20317c.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<RecyclerView>() { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentMyFeedTab.2
            public void onRefresh(PullToRefreshBase<RecyclerView> pullToRefreshBase) {
                UserInfoFragmentMyFeedTab.this.a(true);
            }
        });
        this.f20317c.k();
    }

    public void a(boolean z) {
        int i;
        if (z) {
            this.h = 1;
        } else {
            this.h++;
        }
        if (!this.j && (i = this.h) != 1) {
            this.h = i - 1;
            return;
        }
        MineHttpUtils.b(this.f20316a, this.f, UserInfo.getInstance().getLoginUserInfo().uid, this.h + "", this.i + "", getFragmentActive());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() != 2131363120) {
            return;
        }
        getActivity().finish();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f20316a = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_circle_pubish_respond, viewGroup, false);
            a();
            b();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }
}
