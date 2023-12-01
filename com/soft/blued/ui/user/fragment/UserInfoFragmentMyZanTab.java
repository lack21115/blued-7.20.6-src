package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.activity.PreloadFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.model.FeedParse;
import com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.soft.blued.R;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.ui.home.HomeArgumentHelper;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/UserInfoFragmentMyZanTab.class */
public class UserInfoFragmentMyZanTab extends PreloadFragment implements View.OnClickListener {
    public Context j;
    public PullToRefreshRecyclerView k;
    public RecyclerView l;
    public FeedListAdapterForRecyclerView m;
    private NoDataAndLoadFailView o;
    private int p = 1;
    private int q = 20;
    private boolean r = true;
    BluedUIHttpResponse n = new BluedUIHttpResponse<BluedEntity<BluedIngSelfFeed, BluedEntityBaseExtra>>(getFragmentActive()) { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentMyZanTab.4

        /* renamed from: a  reason: collision with root package name */
        boolean f20324a = false;

        private void a(BluedEntity<BluedIngSelfFeed, BluedEntityBaseExtra> bluedEntity, boolean z) {
            if (bluedEntity == null || bluedEntity.data == null || bluedEntity.data.size() <= 0) {
                return;
            }
            if (bluedEntity.hasMore()) {
                UserInfoFragmentMyZanTab.this.r = true;
                UserInfoFragmentMyZanTab.this.m.setEnableLoadMore(true);
            } else {
                UserInfoFragmentMyZanTab.this.r = false;
                UserInfoFragmentMyZanTab.this.m.setEnableLoadMore(false);
            }
            if (UserInfoFragmentMyZanTab.this.p == 1) {
                UserInfoFragmentMyZanTab.this.m.setNewData(bluedEntity.data);
            } else {
                UserInfoFragmentMyZanTab.this.m.addData(bluedEntity.data);
            }
            UserInfoFragmentMyZanTab.this.m.notifyDataSetChanged();
        }

        public void onUICache(BluedEntity<BluedIngSelfFeed, BluedEntityBaseExtra> bluedEntity) {
            a(bluedEntity, true);
        }

        public boolean onUIFailure(int i, String str) {
            this.f20324a = true;
            if (UserInfoFragmentMyZanTab.this.p != 1) {
                UserInfoFragmentMyZanTab.b(UserInfoFragmentMyZanTab.this);
            }
            return super.onUIFailure(i, str);
        }

        public void onUIFinish() {
            if (UserInfoFragmentMyZanTab.this.m.getItemCount() != 1) {
                UserInfoFragmentMyZanTab.this.o.d();
            } else if (this.f20324a) {
                UserInfoFragmentMyZanTab.this.o.b();
                Log.v("drb", "showFail");
            } else {
                UserInfoFragmentMyZanTab.this.o.a();
                Log.v("drb", "showNodata");
            }
            this.f20324a = false;
            UserInfoFragmentMyZanTab.this.m.notifyDataSetChanged();
            UserInfoFragmentMyZanTab.this.m.loadMoreComplete();
            UserInfoFragmentMyZanTab.this.k.j();
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
                    bluedIngSelfFeed.feedParse = new FeedParse(UserInfoFragmentMyZanTab.this.j, bluedIngSelfFeed, 12);
                }
            }
            return parseData;
        }
    };

    static /* synthetic */ int b(UserInfoFragmentMyZanTab userInfoFragmentMyZanTab) {
        int i = userInfoFragmentMyZanTab.p;
        userInfoFragmentMyZanTab.p = i - 1;
        return i;
    }

    private void h() {
        NoDataAndLoadFailView noDataAndLoadFailView = new NoDataAndLoadFailView(this.j);
        this.o = noDataAndLoadFailView;
        noDataAndLoadFailView.d();
        this.o.setImageScale(0.7f);
        this.o.setNoDataImg(2131233633);
        this.o.setNoDataStr((int) R.string.my_zan_nodata);
        this.o.setBtnStr((int) R.string.my_zan_to_square);
        this.o.setNoDataBtnVisibility(0);
        this.o.setNoDataBtnListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentMyZanTab.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                UserInfoFragmentMyZanTab.this.getActivity().finish();
                HomeArgumentHelper.a(UserInfoFragmentMyZanTab.this.j, IAdInterListener.AdProdType.PRODUCT_FEEDS, (Bundle) null);
            }
        });
        PullToRefreshRecyclerView findViewById = this.b.findViewById(R.id.wrapper);
        this.k = findViewById;
        findViewById.setRefreshEnabled(true);
        RecyclerView recyclerView = (RecyclerView) this.k.getRefreshableView();
        this.l = recyclerView;
        RecyclerView.Adapter feedListAdapterForRecyclerView = new FeedListAdapterForRecyclerView(this.j, this, recyclerView, 12);
        this.m = feedListAdapterForRecyclerView;
        this.l.setAdapter(feedListAdapterForRecyclerView);
        this.m.setEmptyView(this.o);
        this.l.setLayoutManager(new GridLayoutManager(this.j, 1));
        this.m.setEnableLoadMore(true);
        this.m.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentMyZanTab.2
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
            public void onLoadMoreRequested() {
                UserInfoFragmentMyZanTab.this.a(false);
            }
        });
        this.k.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<RecyclerView>() { // from class: com.soft.blued.ui.user.fragment.UserInfoFragmentMyZanTab.3
            public void onRefresh(PullToRefreshBase<RecyclerView> pullToRefreshBase) {
                UserInfoFragmentMyZanTab.this.a(true);
            }
        });
        this.k.k();
    }

    public void a(View view) {
        FragmentActivity activity = getActivity();
        this.j = activity;
        this.b = LayoutInflater.from(activity).inflate(R.layout.fragment_circle_pubish_respond, (ViewGroup) view, true);
        h();
    }

    public void a(boolean z) {
        int i;
        if (z) {
            this.p = 1;
        } else {
            this.p++;
        }
        if (!this.r && (i = this.p) != 1) {
            this.p = i - 1;
            return;
        }
        MineHttpUtils.a(this.j, this.n, this.p + "", this.q + "", (IRequestHost) getFragmentActive());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() != 2131363120) {
            return;
        }
        getActivity().finish();
    }

    public void setUserVisibleHint(boolean z) {
        PullToRefreshRecyclerView pullToRefreshRecyclerView;
        super.setUserVisibleHint(z);
        if (!z || this.c || (pullToRefreshRecyclerView = this.k) == null) {
            return;
        }
        pullToRefreshRecyclerView.k();
        this.c = true;
    }
}
