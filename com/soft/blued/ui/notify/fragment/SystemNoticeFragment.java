package com.soft.blued.ui.notify.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.anythink.expressad.video.module.a.a.m;
import com.blued.android.chat.ChatManager;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.skin.listener.BluedSkinSupportable;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.enums.PopupPosition;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.badgeview.QBadgeContainer;
import com.blued.android.module.common.utils.NinePatchUtils;
import com.blued.android.module.common.utils.RefreshUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.view.CommonGuidePop;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.community.model.FeedNotice;
import com.blued.community.track.EventTrackFeed;
import com.blued.das.client.feed.FeedProtos;
import com.bytedance.applog.tracker.Tracker;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.badge.BadgeDrawable;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.ui.discover.fragment.ViewpointNoticeLikeListFragment;
import com.soft.blued.ui.home.HomeActivity;
import com.soft.blued.ui.home.HomeTabClick;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg_group.fragment.GroupNoticeNewFragment;
import com.soft.blued.ui.notify.fragment.SystemNoticeAdapter;
import com.soft.blued.ui.notify.model.ViewpointNoticeCount;
import com.soft.blued.ui.notify.presenter.SystemNoticePresenter;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/notify/fragment/SystemNoticeFragment.class */
public class SystemNoticeFragment extends MvpFragment<SystemNoticePresenter> implements BluedSkinSupportable, HomeTabClick.TabClickListener {

    /* renamed from: a  reason: collision with root package name */
    private SystemNoticeAdapter f19230a;
    @BindView
    AppBarLayout appbar;
    private NoDataAndLoadFailView b;
    @BindView
    CoordinatorLayout coordinator;
    @BindView
    ImageView ivAttention;
    @BindView
    ImageView ivCircle;
    @BindView
    ImageView ivGroup;
    @BindView
    ImageView ivLike;
    @BindView
    LinearLayout llAttention;
    @BindView
    LinearLayout llCircle;
    @BindView
    LinearLayout llGroup;
    @BindView
    LinearLayout llLike;
    @BindView
    LinearLayout llMenu;
    @BindView
    RecyclerView recycleView;
    @BindView
    SmartRefreshLayout srlList;
    @BindView
    QBadgeContainer tvAttentionCount;
    @BindView
    QBadgeContainer tvCircleCount;
    @BindView
    QBadgeContainer tvGroupCount;
    @BindView
    QBadgeContainer tvLikeCount;

    /* renamed from: c  reason: collision with root package name */
    private List<QBadgeContainer> f19231c = new ArrayList();
    private boolean d = false;

    private void a(int i) {
        QBadgeContainer qBadgeContainer = this.tvAttentionCount;
        if (qBadgeContainer == null) {
            return;
        }
        qBadgeContainer.a(i);
    }

    private void b(int i) {
        QBadgeContainer qBadgeContainer = this.tvLikeCount;
        if (qBadgeContainer == null) {
            return;
        }
        qBadgeContainer.a(i);
    }

    private void b(ViewpointNoticeCount viewpointNoticeCount) {
        a(viewpointNoticeCount.followers);
        b(viewpointNoticeCount.liked);
        c(viewpointNoticeCount.groups);
        d(viewpointNoticeCount.circle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<FeedNotice> list) {
        View viewByPosition;
        if (list == null || list.size() <= 0 || list.get(0) == null || list.get(0).type != 12 || !BluedPreferences.fM() || (viewByPosition = this.f19230a.getViewByPosition(this.recycleView, 0, R.id.tv_feed_notice_reply)) == null) {
            return;
        }
        CommonGuidePop commonGuidePop = new CommonGuidePop(getContext(), getContext().getString(R.string.bubble_feed_notice_guide_content), NinePatchUtils.GuideArrowPosition.c, 2131232898);
        final BasePopupView h = new XPopup.Builder(getContext()).a(viewByPosition).d(false).b(DensityUtils.a(getContext(), 7.0f)).a(PopupPosition.d).a(PopupAnimation.a).a(commonGuidePop).h();
        commonGuidePop.setOnClick(new CommonGuidePop.OnClickListener() { // from class: com.soft.blued.ui.notify.fragment.SystemNoticeFragment.5
            public void a() {
                if (h.s()) {
                    h.p();
                }
            }
        });
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.notify.fragment.SystemNoticeFragment.6
            @Override // java.lang.Runnable
            public void run() {
                if (h.s()) {
                    h.p();
                }
            }
        }, m.ag);
        h.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.notify.fragment.SystemNoticeFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        BluedPreferences.fL();
    }

    private void b(boolean z) {
        if (this.f19230a.getData().size() <= 0) {
            if (z) {
                this.b.a();
            } else {
                this.b.b();
            }
        }
    }

    private void c(int i) {
        QBadgeContainer qBadgeContainer = this.tvGroupCount;
        if (qBadgeContainer == null) {
            return;
        }
        qBadgeContainer.a(i);
    }

    private void d(int i) {
        QBadgeContainer qBadgeContainer = this.tvCircleCount;
        if (qBadgeContainer == null) {
            return;
        }
        qBadgeContainer.a(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(Bundle bundle) {
        super.a(bundle);
        LiveEventBus.get(EventBusConstant.KEY_EVENT_NOTICE_NEED_REFRESH, Void.class).observe(this, new Observer<Void>() { // from class: com.soft.blued.ui.notify.fragment.SystemNoticeFragment.1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Void r3) {
                if (SystemNoticeFragment.this.getUserVisibleHint()) {
                    ((SystemNoticePresenter) SystemNoticeFragment.this.j()).e();
                }
            }
        });
        this.f19231c.clear();
        this.tvAttentionCount.a(this.llAttention);
        this.tvAttentionCount.d((int) BadgeDrawable.TOP_END);
        this.tvAttentionCount.a(BluedSkinUtils.a(getContext(), 2131101780), 1.0f, true);
        this.tvAttentionCount.a("");
        this.f19231c.add(this.tvAttentionCount);
        this.tvLikeCount.a(this.llLike);
        this.tvLikeCount.d((int) BadgeDrawable.TOP_END);
        this.tvLikeCount.a(BluedSkinUtils.a(getContext(), 2131101780), 1.0f, true);
        this.tvLikeCount.a("");
        this.f19231c.add(this.tvLikeCount);
        this.tvGroupCount.a(this.llGroup);
        this.tvGroupCount.d((int) BadgeDrawable.TOP_END);
        this.tvGroupCount.a(BluedSkinUtils.a(getContext(), 2131101780), 1.0f, true);
        this.tvGroupCount.a("");
        this.f19231c.add(this.tvGroupCount);
        this.tvCircleCount.a(this.llCircle);
        this.tvCircleCount.d((int) BadgeDrawable.TOP_END);
        this.tvCircleCount.a(BluedSkinUtils.a(getContext(), 2131101780), 1.0f, true);
        this.tvCircleCount.a("");
        this.f19231c.add(this.tvCircleCount);
        SystemNoticeAdapter systemNoticeAdapter = new SystemNoticeAdapter(getContext(), getFragmentActive(), getFragmentManager(), true);
        this.f19230a = systemNoticeAdapter;
        systemNoticeAdapter.a(new SystemNoticeAdapter.OnReadListener() { // from class: com.soft.blued.ui.notify.fragment.SystemNoticeFragment.2
            @Override // com.soft.blued.ui.notify.fragment.SystemNoticeAdapter.OnReadListener
            public void a() {
                ((SystemNoticePresenter) SystemNoticeFragment.this.j()).h.f16157c = SystemNoticeFragment.this.f19230a.b();
                ((SystemNoticePresenter) SystemNoticeFragment.this.j()).b((ViewpointNoticeCount) null);
            }
        });
        View noDataAndLoadFailView = new NoDataAndLoadFailView(getContext());
        this.b = noDataAndLoadFailView;
        this.f19230a.setEmptyView(noDataAndLoadFailView);
        ((SystemNoticePresenter) j()).a(this.f19230a);
        this.recycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.recycleView.setAdapter(this.f19230a);
        this.srlList.a(new OnRefreshListener() { // from class: com.soft.blued.ui.notify.fragment.SystemNoticeFragment.3
            @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public void onRefresh(RefreshLayout refreshLayout) {
                ((SystemNoticePresenter) SystemNoticeFragment.this.j()).e();
            }
        });
        this.srlList.a(new OnLoadMoreListener() { // from class: com.soft.blued.ui.notify.fragment.SystemNoticeFragment.4
            @Override // com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
            public void onLoadMore(RefreshLayout refreshLayout) {
                ((SystemNoticePresenter) SystemNoticeFragment.this.j()).f();
            }
        });
    }

    public void a(ViewpointNoticeCount viewpointNoticeCount) {
        if (viewpointNoticeCount != null) {
            b(viewpointNoticeCount);
            if (viewpointNoticeCount.isHttp) {
                viewpointNoticeCount.isHttp = false;
                ((SystemNoticePresenter) j()).b(viewpointNoticeCount);
            }
        }
    }

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
            this.srlList.j();
            this.srlList.h();
        }
        b(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(final List<FeedNotice> list) {
        this.f19230a.setNewData(list);
        ((SystemNoticePresenter) j()).h.f16157c = this.f19230a.b();
        ((SystemNoticePresenter) j()).b((ViewpointNoticeCount) null);
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.notify.fragment.SystemNoticeFragment.8
            @Override // java.lang.Runnable
            public void run() {
                SystemNoticeFragment.this.b(list);
            }
        }, 300L);
    }

    public void af_() {
        super.af_();
        this.b = null;
    }

    public void applySkin() {
        List<QBadgeContainer> list = this.f19231c;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (QBadgeContainer qBadgeContainer : this.f19231c) {
            qBadgeContainer.a(BluedSkinUtils.a(getContext(), 2131101780), 1.0f, true);
        }
        this.f19230a.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        this.f19230a.setNewData(null);
        ((SystemNoticePresenter) j()).h.f16157c = 0;
        ((SystemNoticePresenter) j()).b((ViewpointNoticeCount) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        AppMethods.d((int) R.string.done);
        this.f19230a.setNewData(null);
        this.b.a();
    }

    @Override // com.soft.blued.ui.home.HomeTabClick.TabClickListener
    public void c(String str) {
        RecyclerView recyclerView;
        if (!"msg".equals(str) || this.srlList == null || (recyclerView = this.recycleView) == null) {
            return;
        }
        recyclerView.scrollToPosition(0);
        RefreshUtils.a(this.appbar);
        this.srlList.i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        this.recycleView.scrollToPosition(0);
        this.srlList.i();
    }

    @Override // com.soft.blued.ui.home.HomeTabClick.TabClickListener
    public void d(String str) {
        c(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        this.f19230a.c();
    }

    public int g() {
        return R.layout.fragment_system_notice;
    }

    public void l() {
        this.srlList.i();
    }

    public void o() {
        super.o();
        this.srlList.l(true);
    }

    public void onPause() {
        super.onPause();
        ((SystemNoticePresenter) j()).i = false;
    }

    public void onResume() {
        super.onResume();
        this.srlList.setBackgroundColor(BluedSkinUtils.a(getContext(), 2131101780));
        this.llMenu.setBackgroundColor(BluedSkinUtils.a(getContext(), 2131101780));
        this.tvAttentionCount.a(BluedSkinUtils.a(getContext(), 2131101780), 1.0f, true);
        this.tvLikeCount.a(BluedSkinUtils.a(getContext(), 2131101780), 1.0f, true);
        this.tvGroupCount.a(BluedSkinUtils.a(getContext(), 2131101780), 1.0f, true);
        this.tvCircleCount.a(BluedSkinUtils.a(getContext(), 2131101780), 1.0f, true);
        ((SystemNoticePresenter) j()).i = true;
    }

    @OnClick
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_attention_count /* 2131370922 */:
                LiveEventBus.get(EventBusConstant.KEY_EVENT_NEW_SYSTEM_MSG_READ_COUNT).post(Integer.valueOf(this.tvAttentionCount.getBadgeNumber()));
                EventTrackFeed.b(FeedProtos.Event.MSG_NOTICE_FOLLOW_CLICK);
                this.tvAttentionCount.a("");
                ChatHelperV4.a().a(getContext(), 5L, 10L);
                ChatManager.getInstance().ignoredNoReadNum((short) 1, 5L);
                ((SystemNoticePresenter) j()).o();
                return;
            case R.id.tv_circle_count /* 2131371102 */:
                if (!BluedConfig.a().K()) {
                    ToastUtils.a(getString(2131887260));
                    return;
                }
                LiveEventBus.get(EventBusConstant.KEY_EVENT_NEW_SYSTEM_MSG_READ_COUNT).post(Integer.valueOf(this.tvCircleCount.getBadgeNumber()));
                EventTrackFeed.b(FeedProtos.Event.MSG_NOTICE_CIRCLE_CLICK);
                this.tvCircleCount.a("");
                CircleNotifyListFragment.a(getContext());
                ((SystemNoticePresenter) j()).r();
                return;
            case R.id.tv_group_count /* 2131371584 */:
                LiveEventBus.get(EventBusConstant.KEY_EVENT_NEW_SYSTEM_MSG_READ_COUNT).post(Integer.valueOf(this.tvGroupCount.getBadgeNumber()));
                this.tvGroupCount.a("");
                TerminalActivity.d(getContext(), GroupNoticeNewFragment.class, (Bundle) null);
                ((SystemNoticePresenter) j()).q();
                return;
            case R.id.tv_like_count /* 2131371808 */:
                LiveEventBus.get(EventBusConstant.KEY_EVENT_NEW_SYSTEM_MSG_READ_COUNT).post(Integer.valueOf(this.tvLikeCount.getBadgeNumber()));
                EventTrackFeed.b(FeedProtos.Event.MSG_NOTICE_LIKE_CLICK);
                this.tvLikeCount.a("");
                ViewpointNoticeLikeListFragment.a(getContext());
                ((SystemNoticePresenter) j()).p();
                return;
            default:
                return;
        }
    }

    public void p() {
        super.p();
        this.srlList.l(false);
    }

    public boolean q() {
        return true;
    }

    public boolean r() {
        return true;
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (getActivity() == null || !(getActivity() instanceof HomeActivity)) {
            return;
        }
        if (z && ((HomeActivity) getActivity()).g() == 0 && this.srlList != null) {
            if (this.d) {
                ((SystemNoticePresenter) j()).e();
            }
            this.d = true;
        }
        ((SystemNoticePresenter) j()).j = z;
    }
}
