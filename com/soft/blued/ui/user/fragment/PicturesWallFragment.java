package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.blued.android.framework.activity.PreloadFragment;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.framework.view.pulltorefresh.RecyclerViewLoadMoreView;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.model.AlbumFlow;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.ui.comment.model.FeedComment;
import com.blued.community.ui.eventbus.BusFeedInteractModel;
import com.blued.community.ui.feed.model.FeedRepost;
import com.blued.community.ui.feed.observer.IFeedDataObserver;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.feed.observer.AlbumViewObserver;
import com.soft.blued.ui.photo.fragment.BasePhotoFragment;
import com.soft.blued.ui.photo.manager.AlbumViewDataManager;
import com.soft.blued.ui.photo.observer.PhotoListPositionObserver;
import com.soft.blued.ui.user.adapter.WaterfallPicturesAdapter;
import com.soft.blued.ui.user.model.AlbumForDataTrans;
import java.util.Collection;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/PicturesWallFragment.class */
public class PicturesWallFragment extends PreloadFragment implements IFeedDataObserver, BaseQuickAdapter.RequestLoadMoreListener, AlbumViewObserver.IAblumViewObserver, PhotoListPositionObserver.IPhotoListPositionObserver {
    private Context l;
    private View m;
    private ProgressBar n;
    private RecyclerView o;
    private WaterfallPicturesAdapter p;
    private PullToRefreshRecyclerView q;
    private StaggeredGridLayoutManager r;
    private AlbumForDataTrans t;
    private BluedUIHttpResponse u;
    private final int j = 10;
    private final int k = 2;
    private String s = "";
    private int v = 1;
    private boolean w = false;
    private boolean x = false;
    private boolean y = false;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/PicturesWallFragment$SpacingItemDecoration.class */
    public class SpacingItemDecoration extends RecyclerView.ItemDecoration {
        private int b;

        public SpacingItemDecoration(int i) {
            this.b = i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            rect.left = this.b / 2;
            rect.bottom = this.b;
        }
    }

    public static PicturesWallFragment a(String str) {
        PicturesWallFragment picturesWallFragment = new PicturesWallFragment();
        Bundle bundle = new Bundle();
        bundle.putString("tab_id", str);
        picturesWallFragment.setArguments(bundle);
        return picturesWallFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BluedEntityA<AlbumFlow> bluedEntityA) {
        if (bluedEntityA == null || !bluedEntityA.hasData()) {
            int i = this.v;
            if (i != 1) {
                this.v = i - 1;
            }
            this.p.setEnableLoadMore(false);
            return;
        }
        if (this.v == 1) {
            this.p.setNewData(bluedEntityA.data);
            this.t.data.clear();
            a(this.p.getData());
            AlbumViewDataManager.a().a(bluedEntityA.hasMore());
        } else {
            this.p.addData((Collection<? extends AlbumFlow>) bluedEntityA.data);
            a(this.p.a());
            AlbumViewDataManager.a().a(bluedEntityA.hasMore(), this.t.data);
        }
        if (bluedEntityA.hasMore()) {
            this.p.setEnableLoadMore(true);
            return;
        }
        this.p.loadMoreEnd(true);
        this.p.setEnableLoadMore(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlbumFlow albumFlow) {
        FeedHttpUtils.a(this.l, new BluedUIHttpResponse<BluedEntity>() { // from class: com.soft.blued.ui.user.fragment.PicturesWallFragment.7
            public void onFailure(Throwable th, int i, String str) {
                BluedHttpUtils.b(th, i, str);
            }

            public void onUIUpdate(BluedEntity bluedEntity) {
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), albumFlow.feed_id, albumFlow.is_ads, getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlbumFlow albumFlow, int i, String str) {
        FeedHttpUtils.a(this.l, new BluedUIHttpResponse<BluedEntity>() { // from class: com.soft.blued.ui.user.fragment.PicturesWallFragment.6
            public void onFailure(Throwable th, int i2, String str2) {
                BluedHttpUtils.b(th, i2, str2);
            }

            public void onUIUpdate(BluedEntity bluedEntity) {
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), albumFlow.feed_id, i, str, getFragmentActive());
    }

    private void a(List<AlbumFlow> list) {
        for (AlbumFlow albumFlow : list) {
            this.t.data.add((AlbumFlow) albumFlow.clone());
        }
    }

    private void d(View view) {
        if (view == null) {
            return;
        }
        this.p = new WaterfallPicturesAdapter(this.l, getFragmentActive());
        this.t = new AlbumForDataTrans();
        ProgressBar progressBar = (ProgressBar) view.findViewById(2131368973);
        this.n = progressBar;
        progressBar.setVisibility(8);
        this.r = new StaggeredGridLayoutManager(2, 1);
        PullToRefreshRecyclerView findViewById = view.findViewById(R.id.ptrrv_picture_list);
        this.q = findViewById;
        this.o = (RecyclerView) findViewById.getRefreshableView();
        this.p.setLoadMoreView(new RecyclerViewLoadMoreView());
        this.p.setEnableLoadMore(false);
        this.p.setOnLoadMoreListener(this, this.o);
        this.p.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.soft.blued.ui.user.fragment.PicturesWallFragment.1
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                BasePhotoFragment.a(PicturesWallFragment.this.l, PicturesWallFragment.this.t, i, 10, "", "", -1);
                InstantLog.a("picture_lib_click");
            }
        });
        this.p.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() { // from class: com.soft.blued.ui.user.fragment.PicturesWallFragment.2
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemChildClickListener
            public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                AlbumFlow albumFlow = (AlbumFlow) baseQuickAdapter.getData().get(i);
                if (view2.getId() == 2131365513 && !UserInfoHelper.a(albumFlow.relationship)) {
                    if (albumFlow.iliked == 0) {
                        albumFlow.iliked = 1;
                        PicturesWallFragment.this.a(albumFlow, albumFlow.is_ads, albumFlow.liked_url);
                    } else {
                        albumFlow.iliked = 0;
                        PicturesWallFragment.this.a(albumFlow);
                    }
                    LiveEventBus.get("feed_like_change").post(albumFlow);
                }
            }
        });
        this.p.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() { // from class: com.soft.blued.ui.user.fragment.PicturesWallFragment.3
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemChildClickListener
            public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                AlbumFlow albumFlow = (AlbumFlow) baseQuickAdapter.getData().get(i);
                if (view2.getId() == 2131365513 && !UserInfoHelper.a(albumFlow.relationship)) {
                    if (albumFlow.iliked == 0) {
                        albumFlow.iliked = 1;
                        PicturesWallFragment.this.a(albumFlow, albumFlow.is_ads, albumFlow.liked_url);
                    } else {
                        albumFlow.iliked = 0;
                        PicturesWallFragment.this.a(albumFlow);
                    }
                    LiveEventBus.get("feed_like_change").post(albumFlow);
                }
            }
        });
        this.q.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<RecyclerView>() { // from class: com.soft.blued.ui.user.fragment.PicturesWallFragment.4
            public void onRefresh(PullToRefreshBase<RecyclerView> pullToRefreshBase) {
                PicturesWallFragment.this.u.refresh();
                PicturesWallFragment.this.v = 1;
                PicturesWallFragment.this.i();
            }
        });
        this.o.addItemDecoration(new SpacingItemDecoration(DensityUtils.a(this.l, 10.0f)));
        this.o.setLayoutManager(this.r);
        this.o.setAdapter(this.p);
        View noDataAndLoadFailView = new NoDataAndLoadFailView(this.l);
        noDataAndLoadFailView.b();
        this.p.setEmptyView(noDataAndLoadFailView);
        BluedUIHttpResponse<BluedEntityA<AlbumFlow>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<AlbumFlow>>(this.s, getFragmentActive()) { // from class: com.soft.blued.ui.user.fragment.PicturesWallFragment.5

            /* renamed from: a  reason: collision with root package name */
            boolean f20202a = false;

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUICache(BluedEntityA<AlbumFlow> bluedEntityA) {
                super.onUICache(bluedEntityA);
                if (bluedEntityA == null) {
                    PicturesWallFragment.this.x = false;
                } else {
                    PicturesWallFragment.this.x = true;
                }
                PicturesWallFragment.this.a(bluedEntityA);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: b */
            public void onUIUpdate(BluedEntityA<AlbumFlow> bluedEntityA) {
                PicturesWallFragment.this.a(bluedEntityA);
            }

            public boolean onUIFailure(int i, String str) {
                this.f20202a = true;
                AlbumViewDataManager.a().c();
                return super.onUIFailure(i, str);
            }

            public void onUIFinish() {
                super.onUIFinish();
                if (PicturesWallFragment.this.v == 1) {
                    PicturesWallFragment.this.q.j();
                    if (this.f20202a && !PicturesWallFragment.this.x) {
                        PicturesWallFragment.this.m.setVisibility(0);
                    }
                    PicturesWallFragment.this.p.disableLoadMoreIfNotFullPage();
                } else if (this.f20202a) {
                    if (PicturesWallFragment.this.v != 1) {
                        PicturesWallFragment.j(PicturesWallFragment.this);
                    }
                    PicturesWallFragment.this.p.loadMoreFail();
                } else if (PicturesWallFragment.this.p.a() == null || PicturesWallFragment.this.p.a().size() < 0) {
                    PicturesWallFragment.this.p.loadMoreFail();
                } else {
                    PicturesWallFragment.this.p.loadMoreComplete();
                }
                PicturesWallFragment.this.p.notifyDataSetChanged();
                PicturesWallFragment.this.y = false;
            }

            public void onUIStart() {
                super.onUIStart();
                PicturesWallFragment.this.y = true;
            }
        };
        this.u = bluedUIHttpResponse;
        bluedUIHttpResponse.refresh();
        this.q.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        FeedHttpUtils.a(this.u, String.valueOf(this.v), "15", this.s, getFragmentActive());
    }

    static /* synthetic */ int j(PicturesWallFragment picturesWallFragment) {
        int i = picturesWallFragment.v;
        picturesWallFragment.v = i - 1;
        return i;
    }

    @Override // com.soft.blued.ui.feed.observer.AlbumViewObserver.IAblumViewObserver
    public void a() {
        this.v++;
        i();
    }

    @Override // com.soft.blued.ui.photo.observer.PhotoListPositionObserver.IPhotoListPositionObserver
    public void a(int i) {
        this.r.scrollToPositionWithOffset(i - 1, 30);
    }

    public void a(View view) {
        LayoutInflater.from(this.l).inflate(R.layout.fragment_pictures_wall, (ViewGroup) view, true);
        d(view);
    }

    public void a(BluedIngSelfFeed bluedIngSelfFeed) {
    }

    public void a(FeedComment feedComment) {
    }

    public void a(BusFeedInteractModel busFeedInteractModel) {
    }

    public void a(FeedRepost feedRepost) {
    }

    public void a(String str, int i) {
    }

    public void a(String str, String str2) {
    }

    public void b(BluedIngSelfFeed bluedIngSelfFeed) {
    }

    public void b(String str, int i) {
    }

    public void b(String str, String str2) {
    }

    public void c(int i) {
    }

    public void c(String str) {
    }

    public void c(String str, int i) {
        this.p.a(str, i);
        this.t.data.clear();
        a(this.p.getData());
    }

    public void d(int i) {
    }

    public void d(String str, int i) {
    }

    public void h() {
        RecyclerView recyclerView = this.o;
        if (recyclerView != null) {
            recyclerView.smoothScrollToPosition(0);
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.l = context;
        if (getArguments() != null) {
            this.s = getArguments().getString("tab_id");
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
    public void onLoadMoreRequested() {
        this.v++;
        i();
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (!z) {
            this.w = false;
            AlbumViewDataManager.a().a(false);
            AlbumViewObserver.a().b(this);
            PhotoListPositionObserver.a().b(this);
        } else if (this.w) {
        } else {
            this.w = true;
            AlbumViewObserver.a().a(this);
            PhotoListPositionObserver.a().a(this);
        }
    }
}
