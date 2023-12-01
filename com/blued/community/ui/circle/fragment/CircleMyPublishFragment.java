package com.blued.community.ui.circle.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.common.widget.refresh.BluedAdapterLoadMoreView;
import com.blued.community.R;
import com.blued.community.http.CircleHttpUtils;
import com.blued.community.ui.circle.adapter.MyCircleTalkAdapter;
import com.blued.community.ui.circle.model.MyCircleTalkModel;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/fragment/CircleMyPublishFragment.class */
public class CircleMyPublishFragment extends BaseFragment implements View.OnClickListener {
    public Context a;
    public View b;
    public PullToRefreshRecyclerView c;
    public RecyclerView d;
    public MyCircleTalkAdapter e;
    private NoDataAndLoadFailView g;
    private int h = 1;
    private boolean i = true;
    BluedUIHttpResponse f = new BluedUIHttpResponse<BluedEntity<MyCircleTalkModel, BluedEntityBaseExtra>>(getFragmentActive()) { // from class: com.blued.community.ui.circle.fragment.CircleMyPublishFragment.3
        boolean a = false;

        private void a(BluedEntity<MyCircleTalkModel, BluedEntityBaseExtra> bluedEntity, boolean z) {
            if (bluedEntity == null || bluedEntity.data == null) {
                return;
            }
            if (bluedEntity.hasMore()) {
                CircleMyPublishFragment.this.i = true;
            } else {
                CircleMyPublishFragment.this.i = false;
            }
            if (CircleMyPublishFragment.this.h == 1) {
                CircleMyPublishFragment.this.e.setNewData(bluedEntity.data);
            } else {
                CircleMyPublishFragment.this.e.addData(bluedEntity.data);
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public boolean onUIFailure(int i, String str) {
            this.a = true;
            if (CircleMyPublishFragment.this.h != 1) {
                CircleMyPublishFragment.b(CircleMyPublishFragment.this);
            }
            return super.onUIFailure(i, str);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            if (CircleMyPublishFragment.this.e.getItemCount() != 1) {
                CircleMyPublishFragment.this.g.d();
            } else if (this.a) {
                CircleMyPublishFragment.this.g.b();
            } else {
                CircleMyPublishFragment.this.g.a();
            }
            this.a = false;
            CircleMyPublishFragment.this.c.j();
            CircleMyPublishFragment.this.e.loadMoreComplete();
            if (CircleMyPublishFragment.this.i) {
                CircleMyPublishFragment.this.e.setEnableLoadMore(true);
            } else {
                CircleMyPublishFragment.this.e.setEnableLoadMore(false);
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIStart() {
            super.onUIStart();
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIUpdate(BluedEntity<MyCircleTalkModel, BluedEntityBaseExtra> bluedEntity) {
            a(bluedEntity, false);
        }
    };

    private void a() {
    }

    static /* synthetic */ int b(CircleMyPublishFragment circleMyPublishFragment) {
        int i = circleMyPublishFragment.h;
        circleMyPublishFragment.h = i - 1;
        return i;
    }

    private void b() {
        NoDataAndLoadFailView noDataAndLoadFailView = new NoDataAndLoadFailView(this.a);
        this.g = noDataAndLoadFailView;
        noDataAndLoadFailView.d();
        this.g.setImageScale(0.7f);
        this.g.setNoDataImg(R.drawable.icon_no_circle);
        this.g.setNoDataStr(R.string.my_new_base_release_no_data);
        PullToRefreshRecyclerView pullToRefreshRecyclerView = (PullToRefreshRecyclerView) this.b.findViewById(R.id.wrapper);
        this.c = pullToRefreshRecyclerView;
        pullToRefreshRecyclerView.setRefreshEnabled(true);
        this.d = this.c.getRefreshableView();
        MyCircleTalkAdapter myCircleTalkAdapter = new MyCircleTalkAdapter(this.a, getFragmentActive());
        this.e = myCircleTalkAdapter;
        this.d.setAdapter(myCircleTalkAdapter);
        this.e.setEmptyView(this.g);
        this.e.setLoadMoreView(new BluedAdapterLoadMoreView());
        this.d.setLayoutManager(new GridLayoutManager(this.a, 1));
        this.e.setEnableLoadMore(true);
        Log.v("drb", "setEnableLoadMore(true)");
        this.e.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.blued.community.ui.circle.fragment.CircleMyPublishFragment.1
            public void onLoadMoreRequested() {
                CircleMyPublishFragment.this.a(false);
            }
        });
        this.c.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<RecyclerView>() { // from class: com.blued.community.ui.circle.fragment.CircleMyPublishFragment.2
            @Override // com.blued.android.framework.view.pulltorefresh.PullToRefreshBase.OnRefreshListener
            public void onRefresh(PullToRefreshBase<RecyclerView> pullToRefreshBase) {
                CircleMyPublishFragment.this.a(true);
            }
        });
        this.c.k();
    }

    public void a(boolean z) {
        int i;
        if (z) {
            this.h = 1;
        } else {
            this.h++;
        }
        if (this.i || (i = this.h) == 1) {
            CircleHttpUtils.a(this.f, this.h, "mine");
        } else {
            this.h = i - 1;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.ctt_left) {
            getActivity().finish();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = getActivity();
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
