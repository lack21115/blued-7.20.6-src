package com.blued.android.module.live_china.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.live_china.adapter.LiveOnlineUserAdapter;
import com.blued.android.module.live_china.databinding.DialogLiveOnlineUserFooterviewBinding;
import com.blued.android.module.live_china.databinding.LayoutOnlineUserBinding;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveOnLineUserCountModel;
import com.blued.android.module.live_china.model.LiveOnlineUserEntity;
import com.blued.android.module.live_china.model.LiveOnlineUserEntityExtra;
import com.blued.android.module.live_china.model.LiveRoomUserModel;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.presenter.LiveOnLineUserPresenter;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.BluedViewExKt;
import com.blued.android.module.ui.mvp.fragment.MvpFragment;
import com.blued.das.live.LiveProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveOnlineUserFragment.class */
public final class LiveOnlineUserFragment extends MvpFragment<LiveOnLineUserPresenter, LayoutOnlineUserBinding> {
    private final Lazy b = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0<LiveOnlineUserAdapter>() { // from class: com.blued.android.module.live_china.fragment.LiveOnlineUserFragment$onlineUserAdapter$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final LiveOnlineUserAdapter invoke() {
            Context requireContext = LiveOnlineUserFragment.this.requireContext();
            Intrinsics.c(requireContext, "requireContext()");
            ActivityFragmentActive fragmentActive = LiveOnlineUserFragment.this.getFragmentActive();
            Intrinsics.c(fragmentActive, "fragmentActive");
            return new LiveOnlineUserAdapter(requireContext, fragmentActive, false);
        }
    });
    private final Lazy c = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0<DialogLiveOnlineUserFooterviewBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveOnlineUserFragment$onlineUserMaxTipsBinding$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final DialogLiveOnlineUserFooterviewBinding invoke() {
            return DialogLiveOnlineUserFooterviewBinding.a(LayoutInflater.from(LiveOnlineUserFragment.this.getContext()));
        }
    });
    private final Lazy d = LazyKt.a(new Function0<LayoutOnlineUserBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveOnlineUserFragment$binding$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final LayoutOnlineUserBinding invoke() {
            return LayoutOnlineUserBinding.a(LayoutInflater.from(LiveOnlineUserFragment.this.getContext()));
        }
    });
    private final ArrayList<LiveOnlineUserEntity> e = new ArrayList<>();
    private int f = 1;

    private final void a(final int i) {
        if (c()) {
            LiveOnLineUserPresenter m = m();
            ActivityFragmentActive fragmentActive = getFragmentActive();
            Intrinsics.c(fragmentActive, "fragmentActive");
            m.a(fragmentActive, i, m().a(), new LiveOnLineUserPresenter.OnLineUserDataSuccess() { // from class: com.blued.android.module.live_china.fragment.LiveOnlineUserFragment$getOnLineUserList$1
                @Override // com.blued.android.module.live_china.presenter.LiveOnLineUserPresenter.OnLineUserDataSuccess
                public void a(BluedEntity<LiveOnlineUserEntity, LiveOnlineUserEntityExtra> data) {
                    LiveOnlineUserAdapter b;
                    LayoutOnlineUserBinding u;
                    ArrayList arrayList;
                    ArrayList arrayList2;
                    LiveOnlineUserAdapter b2;
                    LayoutOnlineUserBinding u2;
                    ArrayList arrayList3;
                    LiveOnlineUserAdapter b3;
                    LiveOnlineUserAdapter b4;
                    DialogLiveOnlineUserFooterviewBinding t;
                    Intrinsics.e(data, "data");
                    b = LiveOnlineUserFragment.this.b();
                    b.loadMoreComplete();
                    u = LiveOnlineUserFragment.this.u();
                    u.c.g();
                    LiveOnlineUserEntityExtra liveOnlineUserEntityExtra = data.extra;
                    if (liveOnlineUserEntityExtra != null) {
                        LiveOnlineUserFragment liveOnlineUserFragment = LiveOnlineUserFragment.this;
                        int i2 = i;
                        b3 = liveOnlineUserFragment.b();
                        b3.setEnableLoadMore(liveOnlineUserEntityExtra.hasmore == 1);
                        if (i2 == 1) {
                            t = liveOnlineUserFragment.t();
                            t.a.setText(liveOnlineUserEntityExtra.getFooter_desc());
                            LiveEventBus.get("update_online_user_count", LiveOnLineUserCountModel.class).post(new LiveOnLineUserCountModel(liveOnlineUserEntityExtra.getTitle(), liveOnlineUserEntityExtra.getNoble_title()));
                        }
                        b4 = liveOnlineUserFragment.b();
                        b4.a(liveOnlineUserEntityExtra.getBehalf());
                    }
                    if (i == 1) {
                        arrayList3 = LiveOnlineUserFragment.this.e;
                        arrayList3.clear();
                    }
                    arrayList = LiveOnlineUserFragment.this.e;
                    arrayList.addAll(data.data);
                    arrayList2 = LiveOnlineUserFragment.this.e;
                    if (arrayList2.size() == 0) {
                        u2 = LiveOnlineUserFragment.this.u();
                        LinearLayout linearLayout = u2.a;
                        Intrinsics.c(linearLayout, "binding.llNoOnlineUserEmptyView");
                        BluedViewExKt.b(linearLayout);
                    }
                    b2 = LiveOnlineUserFragment.this.b();
                    b2.notifyDataSetChanged();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveOnlineUserFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(this$0, "this$0");
        LiveOnlineUserEntity liveOnlineUserEntity = this$0.e.get(i);
        if (liveOnlineUserEntity == null || liveOnlineUserEntity.is_hide() == 1) {
            return;
        }
        LiveRoomUserModel liveRoomUserModel = new LiveRoomUserModel();
        liveRoomUserModel.uid = String.valueOf(liveOnlineUserEntity.getUid());
        liveRoomUserModel.avatar = liveOnlineUserEntity.getAvatar();
        LiveSetDataObserver.a().a(liveRoomUserModel);
        LiveEventBus.get("close_online_user_dialog", Boolean.TYPE).post(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveOnlineUserFragment this$0, RefreshLayout it) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(it, "it");
        this$0.f = 1;
        this$0.a(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LiveOnlineUserAdapter b() {
        return (LiveOnlineUserAdapter) this.b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(LiveOnlineUserFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        int i = this$0.f + 1;
        this$0.f = i;
        this$0.a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DialogLiveOnlineUserFooterviewBinding t() {
        return (DialogLiveOnlineUserFooterviewBinding) this.c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutOnlineUserBinding u() {
        return (LayoutOnlineUserBinding) this.d.getValue();
    }

    public final void a() {
        EventTrackLive.a(LiveProtos.Event.LIVE_ONLINE_USER_PAGE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        LayoutOnlineUserBinding u = u();
        u.b.setLayoutManager(new LinearLayoutManager(getContext()));
        u.b.setAdapter(b());
        b().setNewData(this.e);
        b().addFooterView(t().getRoot());
        u.c.b(false);
        u.c.i();
        u.c.a(new OnRefreshListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveOnlineUserFragment$gbyDHh8suiotxxNnsM99d6lqtEY
            public final void onRefresh(RefreshLayout refreshLayout) {
                LiveOnlineUserFragment.a(LiveOnlineUserFragment.this, refreshLayout);
            }
        });
        b().setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveOnlineUserFragment$p_AdM0h9PrRPBWGIb20sydPG1mQ
            public final void onLoadMoreRequested() {
                LiveOnlineUserFragment.e(LiveOnlineUserFragment.this);
            }
        }, u.b);
        b().setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveOnlineUserFragment$v9uhICLT4Ih_XbPyIT-whmMr26Y
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                LiveOnlineUserFragment.a(LiveOnlineUserFragment.this, baseQuickAdapter, view, i);
            }
        });
    }

    @Override // com.blued.android.module.ui.mvp.fragment.MvpFragment, com.blued.android.core.ui.BaseFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        a();
        RelativeLayout root = u().getRoot();
        Intrinsics.c(root, "binding.root");
        return root;
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onResume() {
        SmartRefreshLayout smartRefreshLayout;
        super.onResume();
        ArrayList<LiveOnlineUserEntity> arrayList = this.e;
        if (!(arrayList == null || arrayList.isEmpty()) || (smartRefreshLayout = u().c) == null) {
            return;
        }
        smartRefreshLayout.i();
    }
}
