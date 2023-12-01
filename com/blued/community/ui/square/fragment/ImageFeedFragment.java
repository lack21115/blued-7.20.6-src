package com.blued.community.ui.square.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.community.R;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.feed.adapter.FeedListAdapterForRecyclerView;
import com.blued.community.ui.send.fragment.FeedAddPostFragment;
import com.blued.community.ui.square.presenter.ImageFeedPresenter;
import com.blued.community.view.FloatFooterView;
import com.blued.das.client.feed.FeedProtos;
import com.bytedance.applog.tracker.Tracker;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/square/fragment/ImageFeedFragment.class */
public class ImageFeedFragment extends MvpFragment<ImageFeedPresenter> {
    private Context a;
    private CommonTopTitleNoTrans b;
    private RecyclerView c;
    private SmartRefreshLayout d;
    private FloatFooterView e;
    private NoDataAndLoadFailView f;
    private FeedListAdapterForRecyclerView g;
    private RecyclerView.OnScrollListener k = new RecyclerView.OnScrollListener() { // from class: com.blued.community.ui.square.fragment.ImageFeedFragment.4
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (ImageFeedFragment.this.g != null && ImageFeedFragment.this.g.s != null) {
                ImageFeedFragment.this.g.s.onScrollStateChanged(recyclerView, i);
            }
            if (ImageFeedFragment.this.e == null || i != 0) {
                return;
            }
            if (!recyclerView.canScrollVertically(-1)) {
                ImageFeedFragment.this.e.startBtmBtnShow();
            } else if (recyclerView.canScrollVertically(1)) {
            } else {
                ImageFeedFragment.this.e.startBtmBtnHide();
            }
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (ImageFeedFragment.this.g != null && ImageFeedFragment.this.g.s != null) {
                ImageFeedFragment.this.g.s.onScrolled(recyclerView, i, i2);
            }
            if (ImageFeedFragment.this.e != null) {
                if (i2 < 0) {
                    ImageFeedFragment.this.e.startBtmBtnShow();
                } else if (i2 > 0) {
                    ImageFeedFragment.this.e.startBtmBtnHide();
                }
            }
        }
    };

    public static void a(Context context) {
        TerminalActivity.d(context, ImageFeedFragment.class, null);
    }

    private void b() {
        this.b = (CommonTopTitleNoTrans) this.i.findViewById(R.id.title);
        this.c = this.i.findViewById(R.id.recycler_view);
        this.d = this.i.findViewById(R.id.refresh_layout);
        this.e = this.i.findViewById(R.id.ll_feed_post);
    }

    private void b(boolean z) {
        this.d.g();
        this.d.h();
        if (this.g.getData().size() <= 0) {
            if (z) {
                this.f.a();
            } else {
                this.f.b();
            }
        }
    }

    private void c() {
        this.b.setLeftClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.square.fragment.ImageFeedFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                ImageFeedFragment.this.t();
            }
        });
        this.e.setOnBtnClickListener(new FloatFooterView.OnBtnClickListener() { // from class: com.blued.community.ui.square.fragment.ImageFeedFragment.2
            public void onPostFeedClick() {
                ImageFeedFragment.this.d();
            }
        });
        if (this.g == null) {
            this.g = new FeedListAdapterForRecyclerView(getContext(), this, this.c, 10);
            NoDataAndLoadFailView noDataAndLoadFailView = new NoDataAndLoadFailView(this.a);
            this.f = noDataAndLoadFailView;
            this.g.setEmptyView(noDataAndLoadFailView);
        }
        j().a(this.g);
        this.c.setAdapter(this.g);
        this.c.setLayoutManager(new GridLayoutManager(getContext(), 1));
        this.c.addOnScrollListener(this.k);
        this.d.a(new OnRefreshLoadMoreListener() { // from class: com.blued.community.ui.square.fragment.ImageFeedFragment.3
            public void onLoadMore(RefreshLayout refreshLayout) {
                ImageFeedFragment.this.j().f();
            }

            public void onRefresh(RefreshLayout refreshLayout) {
                ImageFeedFragment.this.j().e();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_BTN_CLICK, FeedProtos.FeedFrom.PUBLISH_PLAZA_IMAGE, false, "");
        FeedAddPostFragment.a(getContext(), true);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.a = getContext();
        b();
        c();
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
    public void a(List<BluedIngSelfFeed> list) {
        this.g.setNewData(list);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void af_() {
        super.af_();
        this.f = null;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_image_feed;
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

    @Override // com.blued.android.core.ui.BaseFragment
    public void onPause() {
        super.onPause();
        FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.g;
        if (feedListAdapterForRecyclerView != null) {
            feedListAdapterForRecyclerView.e();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onResume() {
        super.onResume();
        if (this.g == null || !getUserVisibleHint()) {
            return;
        }
        this.g.d();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void p() {
        super.p();
        this.d.b(false);
        AppMethods.d(R.string.common_nomore_data);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.g;
        if (feedListAdapterForRecyclerView != null) {
            if (z) {
                feedListAdapterForRecyclerView.d();
            } else {
                feedListAdapterForRecyclerView.e();
            }
        }
    }
}
