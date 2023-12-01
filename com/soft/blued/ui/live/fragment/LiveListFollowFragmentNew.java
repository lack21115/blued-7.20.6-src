package com.soft.blued.ui.live.fragment;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.live_china.manager.LiveDataListManager;
import com.blued.android.module.live_china.model.BluedLiveListData;
import com.blued.android.module.live_china.model.LiveRecommendModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.observer.LiveListPositionObserver;
import com.blued.android.module.live_china.observer.LiveListRefreshObserver;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.blued.das.message.MessageProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.soft.blued.R;
import com.soft.blued.push.PushChecker;
import com.soft.blued.ui.discover.observer.LiveListSetSelectedTab;
import com.soft.blued.ui.home.HomeTabClick;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import com.soft.blued.ui.live.adapter.LiveFollowItemAdapter;
import com.soft.blued.ui.live.adapter.LiveFollowRecommendAdapter;
import com.soft.blued.ui.live.presenter.LiveFollowPresenter;
import com.soft.blued.ui.live.utils.LiveListDataUtils;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveListFollowFragmentNew.class */
public class LiveListFollowFragmentNew extends MvpFragment<LiveFollowPresenter> implements View.OnClickListener, LiveListPositionObserver.ILiveListPositionObserver, HomeTabClick.TabClickListener {

    /* renamed from: a  reason: collision with root package name */
    public long f31186a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private LiveFollowItemAdapter f31187c;
    private LiveFollowRecommendAdapter d;
    private boolean f;
    private boolean g;
    @BindView
    ImageView ivClose;
    @BindView
    ImageView ivIcon;
    private boolean k;
    private String l;
    @BindView
    View liveRecommendEmpty;
    @BindView
    View live_no_follow_banner;
    @BindView
    NoDataAndLoadFailView llNoInternet;
    @BindView
    RecyclerView mRecyclerView;
    @BindView
    View msg_toast;
    @BindView
    SmartRefreshLayout refreshFollowList;
    @BindView
    SmartRefreshLayout refreshNewUserList;
    @BindView
    RecyclerView rvFollowList;
    @BindView
    TextView tvHint;
    @BindView
    View tv_live_start_btn;
    private int e = 0;
    private Observer<String> m = new Observer<String>() { // from class: com.soft.blued.ui.live.fragment.LiveListFollowFragmentNew.13
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(String str) {
            Log.i("xpm", "KEY_EVENT_LIVE_FLOAT_DISMISS");
            if (LiveListFollowFragmentNew.this.f31187c == null || !LiveListFollowFragmentNew.this.k) {
                return;
            }
            LiveListFollowFragmentNew.this.f31187c.c();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int a(GridLayoutManager gridLayoutManager, int i) {
        return i < this.e ? 1 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        BluedLiveListData bluedLiveListData;
        String str;
        String str2;
        String str3;
        if (this.f31187c.getData() == null || i >= this.f31187c.getData().size() || (bluedLiveListData = (BluedLiveListData) this.f31187c.getData().get(i)) == null) {
            return;
        }
        if (bluedLiveListData.anchor != null) {
            str = bluedLiveListData.anchor.name;
            String str4 = bluedLiveListData.anchor.avatar;
            str3 = bluedLiveListData.anchor.uid;
            str2 = str4;
        } else {
            str = "";
            str2 = str;
            str3 = "";
        }
        if (!bluedLiveListData.isLivingForFollow()) {
            UserInfoFragmentNew.a(this.b, str3, "");
            return;
        }
        if (bluedLiveListData.anchor != null) {
            EventTrackLive.a(LiveProtos.Event.LIVE_ROOM_CLICK, "follow_list", bluedLiveListData.lid, bluedLiveListData.anchor.uid, bluedLiveListData.isPKStreamShow(), bluedLiveListData.weight, bluedLiveListData.cover_box_id);
        }
        LiveRoomData liveRoomData = new LiveRoomData(StringUtils.a(bluedLiveListData.lid, 0L), bluedLiveListData.screen_pattern, "followed", str3, str, str2, 0);
        liveRoomData.live_url = bluedLiveListData.live_play;
        liveRoomData.details = "";
        LiveRoomInfoChannel.a(this.b, liveRoomData, -1, LiveRoomInfoChannel.a(this.f31187c.a(), "followed"));
    }

    private void d(List<BluedLiveListData> list) {
        int i = 0;
        this.e = 0;
        if (list != null) {
            for (BluedLiveListData bluedLiveListData : list) {
                if (bluedLiveListData != null && bluedLiveListData.isLivingForFollow()) {
                    bluedLiveListData.positionReal = i;
                    this.e++;
                    i++;
                }
            }
        }
    }

    private void e() {
        if (getArguments() != null) {
            this.l = getArguments().getString("live_pay_beans_details", "");
        }
    }

    private void v() {
        EventTrackLive.g(LiveProtos.Event.LIVE_FIRST_TAB_SHOW, "follow");
        this.rvFollowList.setLayoutManager(new GridLayoutManager(this.b, 2));
        LiveFollowItemAdapter liveFollowItemAdapter = new LiveFollowItemAdapter(this);
        this.f31187c = liveFollowItemAdapter;
        liveFollowItemAdapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() { // from class: com.soft.blued.ui.live.fragment.-$$Lambda$LiveListFollowFragmentNew$GhBJw81wLIshWWsASf0AKTMglQM
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.SpanSizeLookup
            public final int getSpanSize(GridLayoutManager gridLayoutManager, int i) {
                int a2;
                a2 = LiveListFollowFragmentNew.this.a(gridLayoutManager, i);
                return a2;
            }
        });
        this.rvFollowList.setAdapter(this.f31187c);
        this.rvFollowList.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.soft.blued.ui.live.fragment.LiveListFollowFragmentNew.1
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
                if (childAdapterPosition >= LiveListFollowFragmentNew.this.e) {
                    rect.left = 0;
                    rect.right = 0;
                    return;
                }
                if (childAdapterPosition % 2 == 0) {
                    rect.left = DisplayUtil.a(view.getContext(), 10.0f);
                    rect.right = DisplayUtil.a(view.getContext(), 2.0f);
                } else {
                    rect.left = DisplayUtil.a(view.getContext(), 2.0f);
                    rect.right = DisplayUtil.a(view.getContext(), 10.0f);
                }
                if (childAdapterPosition == 0 || childAdapterPosition == 1) {
                    rect.top = DisplayUtil.a(view.getContext(), 15.0f);
                } else {
                    rect.top = 0;
                }
                if (childAdapterPosition / 2 == ((LiveListFollowFragmentNew.this.e + 1) / 2) - 1) {
                    rect.bottom = DisplayUtil.a(view.getContext(), 15.0f);
                } else {
                    rect.bottom = DisplayUtil.a(view.getContext(), 2.0f);
                }
            }
        });
        this.rvFollowList.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.soft.blued.ui.live.fragment.LiveListFollowFragmentNew.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    if (LiveListFollowFragmentNew.this.f31187c != null) {
                        LiveListFollowFragmentNew.this.f31187c.c(false);
                        LiveListFollowFragmentNew.this.f31187c.e();
                    }
                } else if (i != 1 || LiveListFollowFragmentNew.this.f31187c == null) {
                } else {
                    LiveListFollowFragmentNew.this.f31187c.c(true);
                }
            }
        });
        this.d = new LiveFollowRecommendAdapter(this.b, getFragmentActive());
        this.mRecyclerView.setLayoutManager(new GridLayoutManager(this.b, 2));
        this.mRecyclerView.setAdapter(this.d);
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.soft.blued.ui.live.fragment.LiveListFollowFragmentNew.3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    if (LiveListFollowFragmentNew.this.d != null) {
                        LiveListFollowFragmentNew.this.d.b(false);
                        LiveListFollowFragmentNew.this.d.e();
                    }
                } else if (i != 1 || LiveListFollowFragmentNew.this.d == null) {
                } else {
                    LiveListFollowFragmentNew.this.d.b(true);
                }
            }
        });
        this.d.addHeaderView(LayoutInflater.from(this.b).inflate(2131559723, (ViewGroup) null));
        w();
        PushChecker.a().a(this.msg_toast, 1, MessageProtos.WarnTime.TOAST_LIVE);
    }

    private void w() {
        this.refreshFollowList.a(new OnRefreshLoadMoreListener() { // from class: com.soft.blued.ui.live.fragment.LiveListFollowFragmentNew.4
            @Override // com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
            public void onLoadMore(RefreshLayout refreshLayout) {
                LiveListFollowFragmentNew.this.j().f();
            }

            @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public void onRefresh(RefreshLayout refreshLayout) {
                if (LiveListFollowFragmentNew.this.f31187c != null) {
                    LiveListFollowFragmentNew.this.f31187c.d();
                }
                LiveListFollowFragmentNew.this.j().e();
                LiveListRefreshObserver.a().b();
            }
        });
        this.rvFollowList.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.soft.blued.ui.live.fragment.LiveListFollowFragmentNew.5
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    if (LiveListFollowFragmentNew.this.f31187c != null) {
                        LiveListFollowFragmentNew.this.f31187c.c(false);
                        LiveListFollowFragmentNew.this.f31187c.e();
                    }
                } else if (i != 1 || LiveListFollowFragmentNew.this.f31187c == null) {
                } else {
                    LiveListFollowFragmentNew.this.f31187c.c(true);
                }
            }
        });
        this.refreshNewUserList.l(false);
        this.refreshNewUserList.a(new OnRefreshLoadMoreListener() { // from class: com.soft.blued.ui.live.fragment.LiveListFollowFragmentNew.6
            @Override // com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
            public void onLoadMore(RefreshLayout refreshLayout) {
                LiveListFollowFragmentNew.this.j().m();
            }

            @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public void onRefresh(RefreshLayout refreshLayout) {
                if (LiveListFollowFragmentNew.this.d != null) {
                    LiveListFollowFragmentNew.this.d.d();
                }
                LiveListFollowFragmentNew.this.j().e();
            }
        });
        this.f31187c.a(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.soft.blued.ui.live.fragment.LiveListFollowFragmentNew.7
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
            public void onLoadMoreRequested() {
                LiveListFollowFragmentNew.this.j().m();
            }
        });
        this.f31187c.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() { // from class: com.soft.blued.ui.live.fragment.LiveListFollowFragmentNew.8
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemLongClickListener
            public boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                return true;
            }
        });
        this.f31187c.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.soft.blued.ui.live.fragment.LiveListFollowFragmentNew.9
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                LiveListFollowFragmentNew.this.a(i);
            }
        });
    }

    private void x() {
        if (this.f31187c.b().size() < 5) {
            PushChecker.a().a(getContext(), 2, MessageProtos.WarnTime.LIVE_FIRST);
        } else {
            this.rvFollowList.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.soft.blued.ui.live.fragment.LiveListFollowFragmentNew.11
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                    super.onScrollStateChanged(recyclerView, i);
                    if (i == 1) {
                        PushChecker.a().a(LiveListFollowFragmentNew.this.getContext(), 2, MessageProtos.WarnTime.LIVE_FIRST);
                    }
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    super.onScrolled(recyclerView, i, i2);
                }
            });
        }
    }

    private void y() {
        LiveEventBus.get("live_float_dismiss", String.class).observeForever(this.m);
    }

    private void z() {
        LiveEventBus.get("live_float_dismiss", String.class).removeObserver(this.m);
    }

    @Override // com.blued.android.module.live_china.observer.LiveListPositionObserver.ILiveListPositionObserver
    public void a(int i, long j) {
        Logger.e("LiveListFollowFragmentNew", "notifyLiveListPosition position = " + i + " ; sessionId = " + j);
        if (this.rvFollowList == null || i == -1) {
            return;
        }
        final int a2 = LiveListDataUtils.a(j, this.f31187c.a());
        this.rvFollowList.post(new Runnable() { // from class: com.soft.blued.ui.live.fragment.LiveListFollowFragmentNew.12
            @Override // java.lang.Runnable
            public void run() {
                LiveListFollowFragmentNew.this.rvFollowList.requestFocus();
                LiveListFollowFragmentNew.this.rvFollowList.scrollToPosition(a2 + 1);
            }
        });
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        e();
        v();
        y();
        j().e();
    }

    public void a(BluedLiveListData bluedLiveListData) {
        this.f31187c.getData().remove(bluedLiveListData);
        d(this.f31187c.getData());
        this.f31187c.notifyDataSetChanged();
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
        if (!z2) {
            this.refreshFollowList.j();
        } else if (!z2) {
        } else {
            this.refreshFollowList.h();
        }
    }

    public void a(List<BluedLiveListData> list) {
        this.refreshNewUserList.setVisibility(8);
        this.refreshFollowList.setVisibility(0);
        d(list);
        if (list != null) {
            if (this.e > 0) {
                this.live_no_follow_banner.setVisibility(8);
            } else {
                this.live_no_follow_banner.setVisibility(0);
            }
            LiveDataListManager.a().c(LiveRoomInfoChannel.a(list, "followed"));
            this.f31187c.a(list);
        }
        if (list == null || j().h != 1) {
            return;
        }
        x();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void af_() {
        super.af_();
        z();
    }

    public void b() {
        this.refreshFollowList.j();
        this.refreshNewUserList.j();
        this.refreshNewUserList.h();
        this.f31187c.a(true);
        this.refreshNewUserList.l(true);
        if (this.d.getData() != null && this.d.getData().size() > 0) {
            this.liveRecommendEmpty.setVisibility(8);
            this.refreshNewUserList.setVisibility(0);
            this.mRecyclerView.setVisibility(0);
            return;
        }
        this.refreshFollowList.setVisibility(8);
        this.refreshNewUserList.setVisibility(0);
        this.mRecyclerView.setVisibility(8);
        this.liveRecommendEmpty.setVisibility(0);
        this.tv_live_start_btn.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.fragment.LiveListFollowFragmentNew.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveEventBus.get("live_start_live").post("");
            }
        });
    }

    public void b(List<LiveRecommendModel> list) {
        EventTrackLive.a(LiveProtos.Event.LIVE_FOLLOW_PAGE_SHOW, (Boolean) false);
        if (this.d == null) {
            return;
        }
        this.refreshFollowList.setVisibility(8);
        this.refreshNewUserList.setVisibility(0);
        this.mRecyclerView.setVisibility(0);
        this.liveRecommendEmpty.setVisibility(8);
        this.d.getData().clear();
        this.d.b();
        this.d.a(list);
        this.refreshNewUserList.j();
        this.refreshNewUserList.l(true);
    }

    public void c() {
        this.refreshNewUserList.j();
        this.refreshNewUserList.h();
        this.f31187c.a(false);
        this.refreshNewUserList.l(false);
    }

    @Override // com.soft.blued.ui.home.HomeTabClick.TabClickListener
    public void c(String str) {
        if (this.refreshNewUserList == null || this.refreshFollowList == null || this.rvFollowList == null || !"live".equals(str) || !this.k) {
            return;
        }
        if (this.refreshNewUserList.getVisibility() == 0) {
            this.refreshNewUserList.i();
            return;
        }
        this.rvFollowList.scrollToPosition(0);
        this.refreshFollowList.i();
    }

    public void c(List<LiveRecommendModel> list) {
        if (this.f31187c == null || list == null || list.isEmpty()) {
            return;
        }
        this.f31187c.b(list);
        this.d.a(list);
    }

    public void d() {
        LiveFollowRecommendAdapter liveFollowRecommendAdapter = this.d;
        if (liveFollowRecommendAdapter == null) {
            return;
        }
        liveFollowRecommendAdapter.a(this.k);
        if (this.k) {
            this.d.c();
        } else {
            this.d.d();
        }
    }

    @Override // com.soft.blued.ui.home.HomeTabClick.TabClickListener
    public void d(String str) {
        if ("live".equals(str) && this.k) {
            c(str);
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_live_follow_list_new;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void o() {
        super.o();
        this.refreshFollowList.l(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() != 2131371860) {
            return;
        }
        LiveListSetSelectedTab.a().a(1);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = getActivity();
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        HomeTabClick.b("live", this);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        LiveFollowItemAdapter liveFollowItemAdapter;
        super.onPause();
        this.f31186a = System.currentTimeMillis();
        if (this.k && (liveFollowItemAdapter = this.f31187c) != null) {
            liveFollowItemAdapter.d();
        }
        d();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        LiveFollowItemAdapter liveFollowItemAdapter;
        SmartRefreshLayout smartRefreshLayout;
        super.onResume();
        if (this.f31186a != 0 && this.k) {
            if (System.currentTimeMillis() - this.f31186a > 300000 && (smartRefreshLayout = this.refreshFollowList) != null) {
                smartRefreshLayout.i();
            }
            this.f31186a = 0L;
        }
        if (this.k && (liveFollowItemAdapter = this.f31187c) != null) {
            liveFollowItemAdapter.c();
        }
        d();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (this.f) {
            if (this.k) {
                this.g = true;
                this.refreshFollowList.i();
            }
            this.f = false;
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void p() {
        super.p();
        this.refreshFollowList.l(false);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public boolean q() {
        return true;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public boolean r() {
        return true;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.k = z;
        if (!this.g && z) {
            this.g = true;
        }
        if (z) {
            HomeTabClick.a("live", this);
            LiveListPositionObserver.a().a(this);
        } else {
            LiveListPositionObserver.a().b(this);
        }
        LiveFollowItemAdapter liveFollowItemAdapter = this.f31187c;
        if (liveFollowItemAdapter != null) {
            liveFollowItemAdapter.b(z);
            if (z) {
                this.f31187c.c();
            } else {
                this.f31187c.d();
            }
        }
        d();
    }
}
