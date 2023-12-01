package com.blued.android.module.live_china.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.live_china.adapter.LiveOnlineUserAdapter;
import com.blued.android.module.live_china.databinding.LayoutOnlineNobleUserHeadViewBinding;
import com.blued.android.module.live_china.databinding.LayoutOnlineUserBinding;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveOnlineUserEntity;
import com.blued.android.module.live_china.model.LiveRoomUserModel;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.presenter.LiveOnLineUserPresenter;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.ui.mvp.fragment.MvpFragment;
import com.blued.das.live.LiveProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jeremyliao.liveeventbus.LiveEventBus;
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
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveOnlineNobleUserFragment.class */
public final class LiveOnlineNobleUserFragment extends MvpFragment<LiveOnLineUserPresenter, LayoutOnlineUserBinding> {
    private final Lazy b = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0<LiveOnlineUserAdapter>() { // from class: com.blued.android.module.live_china.fragment.LiveOnlineNobleUserFragment$onlineUserAdapter$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final LiveOnlineUserAdapter invoke() {
            Context requireContext = LiveOnlineNobleUserFragment.this.requireContext();
            Intrinsics.c(requireContext, "requireContext()");
            ActivityFragmentActive fragmentActive = LiveOnlineNobleUserFragment.this.getFragmentActive();
            Intrinsics.c(fragmentActive, "fragmentActive");
            return new LiveOnlineUserAdapter(requireContext, fragmentActive, true);
        }
    });
    private final Lazy c = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0<LayoutOnlineNobleUserHeadViewBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveOnlineNobleUserFragment$nobleUserHeadViewBinding$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final LayoutOnlineNobleUserHeadViewBinding invoke() {
            return LayoutOnlineNobleUserHeadViewBinding.a(LayoutInflater.from(LiveOnlineNobleUserFragment.this.getContext()));
        }
    });
    private final ArrayList<LiveOnlineUserEntity> d = new ArrayList<>();
    private int e = 1;
    private final Lazy f = LazyKt.a(new Function0<LayoutOnlineUserBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveOnlineNobleUserFragment$binding$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final LayoutOnlineUserBinding invoke() {
            return LayoutOnlineUserBinding.a(LayoutInflater.from(LiveOnlineNobleUserFragment.this.getContext()));
        }
    });

    private final void a(final int i) {
        if (c()) {
            LiveOnLineUserPresenter m = m();
            ActivityFragmentActive fragmentActive = getFragmentActive();
            Intrinsics.c(fragmentActive, "fragmentActive");
            m.a(fragmentActive, i, m().b(), new LiveOnLineUserPresenter.OnLineUserDataSuccess() { // from class: com.blued.android.module.live_china.fragment.LiveOnlineNobleUserFragment$getOnLineUserList$1
                /* JADX WARN: Code restructure failed: missing block: B:27:0x00b0, code lost:
                    if (r0.length() == 0) goto L24;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:30:0x00b6, code lost:
                    if (r7 == false) goto L25;
                 */
                @Override // com.blued.android.module.live_china.presenter.LiveOnLineUserPresenter.OnLineUserDataSuccess
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void a(com.blued.android.framework.http.parser.BluedEntity<com.blued.android.module.live_china.model.LiveOnlineUserEntity, com.blued.android.module.live_china.model.LiveOnlineUserEntityExtra> r6) {
                    /*
                        Method dump skipped, instructions count: 316
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.fragment.LiveOnlineNobleUserFragment$getOnLineUserList$1.a(com.blued.android.framework.http.parser.BluedEntity):void");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
        LiveSetDataObserver.a().f(H5Url.a(91));
        LiveEventBus.get("close_online_user_dialog", Boolean.TYPE).post(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveOnlineNobleUserFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(this$0, "this$0");
        LiveOnlineUserEntity liveOnlineUserEntity = this$0.d.get(i);
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
    public static final void a(LiveOnlineNobleUserFragment this$0, RefreshLayout it) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(it, "it");
        this$0.e = 1;
        this$0.a(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LiveOnlineUserAdapter b() {
        return (LiveOnlineUserAdapter) this.b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(LiveOnlineNobleUserFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        int i = this$0.e + 1;
        this$0.e = i;
        this$0.a(i);
    }

    private final LayoutOnlineNobleUserHeadViewBinding t() {
        return (LayoutOnlineNobleUserHeadViewBinding) this.c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutOnlineUserBinding u() {
        return (LayoutOnlineUserBinding) this.f.getValue();
    }

    public final void a() {
        EventTrackLive.a(LiveProtos.Event.LIVE_ONLINE_NOBLE_PAGE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        LayoutOnlineUserBinding u = u();
        u.b.setLayoutManager(new LinearLayoutManager(getContext()));
        u.b.setAdapter(b());
        b().setNewData(this.d);
        b().addHeaderView(t().getRoot());
        t().getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveOnlineNobleUserFragment$AxGq059wX2b8b2N16z-zI_j6OXk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveOnlineNobleUserFragment.a(view);
            }
        });
        u.c.b(false);
        u.c.i();
        u.c.a(new OnRefreshListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveOnlineNobleUserFragment$kK_77mKA4zJNYYbLxWrMu8kZaX4
            public final void onRefresh(RefreshLayout refreshLayout) {
                LiveOnlineNobleUserFragment.a(LiveOnlineNobleUserFragment.this, refreshLayout);
            }
        });
        b().setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveOnlineNobleUserFragment$OwFzbTRiik9fpwNV50fvMuzrL_Q
            public final void onLoadMoreRequested() {
                LiveOnlineNobleUserFragment.d(LiveOnlineNobleUserFragment.this);
            }
        }, u.b);
        b().setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveOnlineNobleUserFragment$U2-H1-sYq1nlSwjJRq_Y449O5TQ
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                LiveOnlineNobleUserFragment.a(LiveOnlineNobleUserFragment.this, baseQuickAdapter, view, i);
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
}
