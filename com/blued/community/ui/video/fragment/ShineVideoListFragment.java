package com.blued.community.ui.video.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.shortvideo.widget.SpacesItemDecoration;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.send.fragment.FeedAddPostFragment;
import com.blued.community.ui.video.adapter.ShineVideoListAdapter;
import com.blued.community.ui.video.manager.ShineVideoDataManager;
import com.blued.community.view.FloatFooterView;
import com.blued.das.client.feed.FeedProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.Collection;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/fragment/ShineVideoListFragment.class */
public class ShineVideoListFragment extends BaseFragment implements ShineVideoDataManager.IShineVideoDataDownloadListner, BaseQuickAdapter.RequestLoadMoreListener {

    /* renamed from: a  reason: collision with root package name */
    public static String f20380a = "KEY_FROM_INDEPENDENT";
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private View f20381c;
    private CommonTopTitleNoTrans d;
    private PullToRefreshRecyclerView e;
    private RecyclerView f;
    private NoDataAndLoadFailView g;
    private ShineVideoListAdapter h;
    private FloatFooterView i;
    private Long j;
    private int k;
    private float l;

    public static void a(Context context) {
        TerminalActivity.d(context, ShineVideoListFragment.class, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        CommunityServiceManager.d().a("feed_post_btn_click", 4);
        EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_BTN_CLICK, FeedProtos.FeedFrom.FLASH, false, "");
        FeedAddPostFragment.a(getContext(), true);
    }

    public void a() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.f20381c.findViewById(R.id.title);
        this.d = commonTopTitleNoTrans;
        commonTopTitleNoTrans.setLeftClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.video.fragment.ShineVideoListFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                ShineVideoListFragment.this.getActivity().finish();
            }
        });
        FloatFooterView floatFooterView = (FloatFooterView) this.f20381c.findViewById(R.id.ll_feed_post);
        this.i = floatFooterView;
        floatFooterView.setOnBtnClickListener(new FloatFooterView.OnBtnClickListener() { // from class: com.blued.community.ui.video.fragment.ShineVideoListFragment.2
            @Override // com.blued.community.view.FloatFooterView.OnBtnClickListener
            public void onPostFeedClick() {
                ShineVideoListFragment.this.b();
            }
        });
        NoDataAndLoadFailView noDataAndLoadFailView = new NoDataAndLoadFailView(this.b);
        this.g = noDataAndLoadFailView;
        noDataAndLoadFailView.a();
        PullToRefreshRecyclerView pullToRefreshRecyclerView = (PullToRefreshRecyclerView) this.f20381c.findViewById(R.id.list_view);
        this.e = pullToRefreshRecyclerView;
        this.f = pullToRefreshRecyclerView.getRefreshableView();
        this.f.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        SpacesItemDecoration spacesItemDecoration = new SpacesItemDecoration(DensityUtils.a(this.b, 2.5f));
        spacesItemDecoration.a(5);
        spacesItemDecoration.a(true, true, true, true);
        spacesItemDecoration.a(DensityUtils.a(this.b, 7.5f), DensityUtils.a(this.b, 9.5f), DensityUtils.a(this.b, 7.5f), 0);
        this.f.addItemDecoration(spacesItemDecoration);
        ShineVideoListAdapter shineVideoListAdapter = new ShineVideoListAdapter(this.b, getFragmentActive());
        this.h = shineVideoListAdapter;
        this.f.setAdapter(shineVideoListAdapter);
        this.h.setEmptyView(this.g);
        this.h.setOnLoadMoreListener(this, this.f);
        this.e.setRefreshEnabled(true);
        ShineVideoDataManager.a().i().refresh();
        this.e.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<RecyclerView>() { // from class: com.blued.community.ui.video.fragment.ShineVideoListFragment.3
            @Override // com.blued.android.framework.view.pulltorefresh.PullToRefreshBase.OnRefreshListener
            public void onRefresh(PullToRefreshBase<RecyclerView> pullToRefreshBase) {
                CommunityServiceManager.d().a(0, 0);
                ShineVideoDataManager.a().i().refresh();
                ShineVideoDataManager.a().a(true, (IRequestHost) ShineVideoListFragment.this.getFragmentActive());
            }
        });
        this.e.k();
        this.f.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.blued.community.ui.video.fragment.ShineVideoListFragment.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                int i3 = ((StaggeredGridLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPositions(null)[0];
                if (recyclerView.getChildAt(0) != null) {
                    int top = recyclerView.getChildAt(0).getTop();
                    if (ShineVideoListFragment.this.j == null) {
                        ShineVideoListFragment.this.j = Long.valueOf(System.currentTimeMillis());
                    }
                    long currentTimeMillis = System.currentTimeMillis() - ShineVideoListFragment.this.j.longValue();
                    if (i3 == 0 && top == 0) {
                        ShineVideoListFragment.this.i.startBtmBtnShow();
                    } else if (ShineVideoListFragment.this.k < i3) {
                        ShineVideoListFragment.this.i.startBtmBtnHide();
                    } else if (ShineVideoListFragment.this.k == i3) {
                        float f = top;
                        int abs = (int) Math.abs(ShineVideoListFragment.this.l - f);
                        if (ShineVideoListFragment.this.l < f && currentTimeMillis != 0 && (abs * 1000) / currentTimeMillis > 2000) {
                            ShineVideoListFragment.this.i.startBtmBtnShow();
                        } else if (ShineVideoListFragment.this.l > f && abs > 10) {
                            ShineVideoListFragment.this.i.startBtmBtnHide();
                        }
                    }
                    ShineVideoListFragment.this.k = i3;
                    ShineVideoListFragment.this.l = top;
                    ShineVideoListFragment.this.j = Long.valueOf(System.currentTimeMillis());
                }
            }
        });
        CommunityServiceManager.d().a("first_auto_load", 6);
    }

    @Override // com.blued.community.ui.video.manager.ShineVideoDataManager.IShineVideoDataDownloadListner
    public void a(BluedIngSelfFeed bluedIngSelfFeed) {
    }

    public void a(List<BluedIngSelfFeed> list) {
        if (list != null) {
            if (ShineVideoDataManager.a().f() == 1) {
                this.h.setNewData(list);
            } else {
                this.h.addData((Collection<? extends BluedIngSelfFeed>) list);
            }
        }
    }

    @Override // com.blued.community.ui.video.manager.ShineVideoDataManager.IShineVideoDataDownloadListner
    public void a(boolean z) {
        if (this.h.getItemCount() == 0) {
            if (z) {
                this.g.b();
            } else {
                this.g.a();
            }
            this.h.notifyDataSetChanged();
        }
        if (ShineVideoDataManager.a().f() == 1) {
            this.e.j();
        }
        if (z) {
            this.h.loadMoreFail();
        } else {
            this.h.loadMoreComplete();
        }
    }

    @Override // com.blued.community.ui.video.manager.ShineVideoDataManager.IShineVideoDataDownloadListner
    public void a(boolean z, List<BluedIngSelfFeed> list) {
        a(list);
        if (z && list != null && list.size() > 0) {
            this.h.setEnableLoadMore(true);
            return;
        }
        this.h.loadMoreEnd();
        this.h.setEnableLoadMore(false);
        AppMethods.a((CharSequence) this.b.getResources().getString(R.string.no_more_please_try_again));
    }

    @Override // com.blued.community.ui.video.manager.ShineVideoDataManager.IShineVideoDataDownloadListner
    public void b(BluedIngSelfFeed bluedIngSelfFeed) {
        if (ShineVideoDataManager.a().b() != null) {
            this.h.setNewData(ShineVideoDataManager.a().b());
        }
    }

    @Override // com.blued.community.ui.video.manager.ShineVideoDataManager.IShineVideoDataDownloadListner
    public void b(List<BluedIngSelfFeed> list) {
        a(list);
    }

    @Override // com.blued.community.ui.video.manager.ShineVideoDataManager.IShineVideoDataDownloadListner
    public void c(List<BluedIngSelfFeed> list) {
        if (list != null) {
            this.h.setNewData(list);
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentActivity activity = getActivity();
        this.b = activity;
        View view = this.f20381c;
        if (view == null) {
            this.f20381c = LayoutInflater.from(activity).inflate(R.layout.fragment_shine_video_list, (ViewGroup) null);
            a();
            ShineVideoDataManager.a().a(this);
        } else {
            ((ViewGroup) view.getParent()).removeView(this.f20381c);
        }
        return this.f20381c;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ShineVideoDataManager.a().b(this);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
    public void onLoadMoreRequested() {
        CommunityServiceManager.d().a(1, 0);
        ShineVideoDataManager.a().a(false, (IRequestHost) getFragmentActive());
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        RecyclerView recyclerView;
        super.onResume();
        if (ShineVideoDataManager.a().j() == -1 || (recyclerView = this.f) == null) {
            return;
        }
        recyclerView.scrollToPosition(ShineVideoDataManager.a().j());
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }
}
