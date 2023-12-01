package com.blued.community.ui.circle.fragment;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.activity.PreloadFragment;
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
import java.util.Collection;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/fragment/CircleMyRespondFragment.class */
public class CircleMyRespondFragment extends PreloadFragment implements View.OnClickListener {
    public Context j;
    public PullToRefreshRecyclerView k;
    public RecyclerView l;
    public MyCircleTalkAdapter m;
    private NoDataAndLoadFailView o;
    private int p = 1;
    private boolean q = true;
    BluedUIHttpResponse n = new BluedUIHttpResponse<BluedEntity<MyCircleTalkModel, BluedEntityBaseExtra>>(getFragmentActive()) { // from class: com.blued.community.ui.circle.fragment.CircleMyRespondFragment.3

        /* renamed from: a  reason: collision with root package name */
        boolean f19229a = false;

        private void a(BluedEntity<MyCircleTalkModel, BluedEntityBaseExtra> bluedEntity, boolean z) {
            if (bluedEntity == null || bluedEntity.data == null) {
                CircleMyRespondFragment.this.m.setEnableLoadMore(false);
                return;
            }
            if (bluedEntity.hasMore()) {
                CircleMyRespondFragment.this.q = true;
            } else {
                CircleMyRespondFragment.this.q = false;
            }
            Log.v("drb", "isHasData:" + CircleMyRespondFragment.this.q);
            if (CircleMyRespondFragment.this.p == 1) {
                CircleMyRespondFragment.this.m.setNewData(bluedEntity.data);
            } else {
                CircleMyRespondFragment.this.m.addData((Collection) bluedEntity.data);
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public boolean onUIFailure(int i, String str) {
            this.f19229a = true;
            if (CircleMyRespondFragment.this.p != 1) {
                CircleMyRespondFragment.c(CircleMyRespondFragment.this);
            }
            return super.onUIFailure(i, str);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            if (CircleMyRespondFragment.this.m.getItemCount() != 1) {
                CircleMyRespondFragment.this.o.d();
            } else if (this.f19229a) {
                CircleMyRespondFragment.this.o.b();
            } else {
                CircleMyRespondFragment.this.o.a();
            }
            this.f19229a = false;
            CircleMyRespondFragment.this.k.j();
            CircleMyRespondFragment.this.m.loadMoreComplete();
            if (CircleMyRespondFragment.this.q) {
                CircleMyRespondFragment.this.m.setEnableLoadMore(true);
            } else {
                CircleMyRespondFragment.this.m.setEnableLoadMore(false);
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

    static /* synthetic */ int c(CircleMyRespondFragment circleMyRespondFragment) {
        int i = circleMyRespondFragment.p;
        circleMyRespondFragment.p = i - 1;
        return i;
    }

    private void h() {
        NoDataAndLoadFailView noDataAndLoadFailView = new NoDataAndLoadFailView(this.j);
        this.o = noDataAndLoadFailView;
        noDataAndLoadFailView.d();
        this.o.setImageScale(0.7f);
        this.o.setNoDataImg(R.drawable.icon_no_circle);
        this.o.setNoDataStr(R.string.my_new_base_respond_no_data);
        PullToRefreshRecyclerView pullToRefreshRecyclerView = (PullToRefreshRecyclerView) this.b.findViewById(R.id.wrapper);
        this.k = pullToRefreshRecyclerView;
        pullToRefreshRecyclerView.setRefreshEnabled(true);
        this.l = this.k.getRefreshableView();
        MyCircleTalkAdapter myCircleTalkAdapter = new MyCircleTalkAdapter(this.j, getFragmentActive());
        this.m = myCircleTalkAdapter;
        this.l.setAdapter(myCircleTalkAdapter);
        this.m.setEmptyView(this.o);
        this.m.setLoadMoreView(new BluedAdapterLoadMoreView());
        this.l.setLayoutManager(new GridLayoutManager(this.j, 1));
        this.m.setEnableLoadMore(true);
        this.m.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.blued.community.ui.circle.fragment.CircleMyRespondFragment.1
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
            public void onLoadMoreRequested() {
                CircleMyRespondFragment.this.a(false);
            }
        });
        this.k.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<RecyclerView>() { // from class: com.blued.community.ui.circle.fragment.CircleMyRespondFragment.2
            @Override // com.blued.android.framework.view.pulltorefresh.PullToRefreshBase.OnRefreshListener
            public void onRefresh(PullToRefreshBase<RecyclerView> pullToRefreshBase) {
                CircleMyRespondFragment.this.a(true);
            }
        });
        this.k.k();
    }

    @Override // com.blued.android.framework.activity.PreloadFragment
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
        if (this.q || (i = this.p) == 1) {
            CircleHttpUtils.a(this.n, this.p, "reply");
        } else {
            this.p = i - 1;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.ctt_left) {
            getActivity().finish();
        }
    }

    @Override // com.blued.android.framework.activity.PreloadFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        PullToRefreshRecyclerView pullToRefreshRecyclerView;
        super.setUserVisibleHint(z);
        if (!z || this.f9777c || (pullToRefreshRecyclerView = this.k) == null) {
            return;
        }
        pullToRefreshRecyclerView.k();
        this.f9777c = true;
    }
}
