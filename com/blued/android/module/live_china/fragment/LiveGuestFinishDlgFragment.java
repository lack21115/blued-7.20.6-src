package com.blued.android.module.live_china.fragment;

import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.AnimationUtils;
import com.blued.android.module.live.base.utils.LiveUserRelationshipUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveFinishRecommendAdapter;
import com.blued.android.module.live_china.fragment.LiveGuestFinishDlgFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveDataListManager;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveAnnounceInfoExtra;
import com.blued.android.module.live_china.model.LiveAnnounceInfoModel;
import com.blued.android.module.live_china.model.LiveRoomAnchorModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.LiverecommendListData;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveUtils;
import com.blued.android.module.live_china.utils.log.InstantLog;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveGuestFinishDlgFragment.class */
public class LiveGuestFinishDlgFragment extends com.blued.android.module.common.fragment.LiveBaseDialogFragment {
    private CountDownTimer A;
    public ProgressBar j;
    public ImageView k;
    public PlayingOnliveFragment l;
    public ImageView m;
    private ImageView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private ShapeTextView s;
    private LinearLayout t;
    private LinearLayout u;
    private LiveFinishRecommendAdapter v;
    private RecyclerView x;
    private View y;
    private TextView z;
    private List<LiverecommendListData> w = new ArrayList();
    LiveUserRelationshipUtils.IAddOrRemoveAttentionDone n = new LiveUserRelationshipUtils.IAddOrRemoveAttentionDone() { // from class: com.blued.android.module.live_china.fragment.LiveGuestFinishDlgFragment.3
        @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
        public void Q_() {
        }

        @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
        public void a(String str) {
            LiveGuestFinishDlgFragment.this.c(str);
        }

        @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
        public void b(String str) {
            LiveGuestFinishDlgFragment.this.c(str);
        }

        @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
        public void c() {
        }

        @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
        public void d() {
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.live_china.fragment.LiveGuestFinishDlgFragment$2  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveGuestFinishDlgFragment$2.class */
    public class AnonymousClass2 extends BluedUIHttpResponse<BluedEntity<LiverecommendListData, BluedEntityBaseExtra>> {
        AnonymousClass2(IRequestHost iRequestHost) {
            super(iRequestHost);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            LiveGuestFinishDlgFragment.this.m();
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            super.onUIFinish();
            LiveGuestFinishDlgFragment.this.u.setVisibility(8);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIStart() {
            super.onUIStart();
            LiveGuestFinishDlgFragment.this.u.setVisibility(0);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIUpdate(BluedEntity<LiverecommendListData, BluedEntityBaseExtra> bluedEntity) {
            if (bluedEntity.data == null || bluedEntity.data.size() <= 0) {
                return;
            }
            LiveGuestFinishDlgFragment.this.w.clear();
            LiveGuestFinishDlgFragment.this.w.addAll(bluedEntity.data);
            LiveGuestFinishDlgFragment.this.a(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveGuestFinishDlgFragment$2$dVFU1qTdFRmjvqRY_5RjOVuwFMM
                @Override // java.lang.Runnable
                public final void run() {
                    LiveGuestFinishDlgFragment.AnonymousClass2.this.a();
                }
            });
            if (LiveGuestFinishDlgFragment.this.v != null) {
                LiveGuestFinishDlgFragment.this.v.notifyDataSetChanged();
            }
        }
    }

    private LiveRoomData a(LiverecommendListData liverecommendListData) {
        LiveRoomData liveRoomData = new LiveRoomData();
        liveRoomData.lid = StringUtils.a(liverecommendListData.lid, 0L);
        liveRoomData.description = liverecommendListData.description;
        liveRoomData.live_type = Integer.parseInt(liverecommendListData.live_type);
        liveRoomData.live_url = liverecommendListData.live_play;
        liveRoomData.screen_pattern = Integer.parseInt(liverecommendListData.screen_pattern);
        liveRoomData.profile = new LiveRoomAnchorModel();
        liveRoomData.profile.uid = liverecommendListData.uid;
        liveRoomData.profile.name = liverecommendListData.anchor.name;
        liveRoomData.profile.avatar = liverecommendListData.anchor.avatar;
        liveRoomData.profile.vbadge = Integer.parseInt(liverecommendListData.anchor.vbadge);
        return liveRoomData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        if (LiveRoomManager.a().t()) {
            return;
        }
        EventTrackLive.a(LiveProtos.Event.LIVE_END_PAGE_FOLLOW_BTN_CLICK, LiveRoomManager.a().d(), LiveRoomManager.a().g(), EventTrackLive.a(LiveRoomManager.a().p().relationship));
        if (LiveRoomManager.a().p().isFollow) {
            b(LiveRoomManager.a().g());
        } else {
            a(LiveRoomManager.a().g());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveAnnounceInfoModel liveAnnounceInfoModel) {
        if (liveAnnounceInfoModel == null || liveAnnounceInfoModel.controller != 1) {
            this.t.setVisibility(8);
            this.y.setVisibility(8);
            return;
        }
        this.t.setVisibility(0);
        this.y.setVisibility(0);
        String a = liveAnnounceInfoModel.live_time_controller == 1 ? LiveUtils.a(liveAnnounceInfoModel) : "";
        String str = liveAnnounceInfoModel.notice_controller == 1 ? liveAnnounceInfoModel.notice : "";
        if (TextUtils.isEmpty(a)) {
            this.q.setVisibility(8);
        } else {
            TextView textView = this.q;
            textView.setText(a + "直播");
            this.q.setVisibility(0);
        }
        if (TextUtils.isEmpty(str)) {
            this.r.setVisibility(8);
            return;
        }
        EventTrackLive.a(LiveProtos.Event.LIVE_END_NOTICE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        this.r.setText(liveAnnounceInfoModel.notice);
        this.r.setVisibility(0);
    }

    private void a(LiveRoomData liveRoomData) {
        if (this.l == null) {
            LiveFloatManager.a().n();
            return;
        }
        InstantLog.a("live_room_slide");
        this.l.aT.setVisibility(8);
        LiveFloatManager.a().b(false);
        if (!LiveDataListManager.a().a(getContext(), liveRoomData, this.l.aX + 1, "live_end_recommend")) {
            LiveFloatManager.a().n();
        }
        this.l.T();
        if (getActivity() != null) {
            getActivity().overridePendingTransition(0, 0);
        }
    }

    private void a(Boolean bool) {
        if (this.s == null) {
            return;
        }
        if (!bool.booleanValue()) {
            this.s.setText(getString(R.string.follow));
            return;
        }
        this.s.setText(getString(R.string.followed));
        ShapeModel shapeModel = this.s.getShapeModel();
        shapeModel.k = getResources().getColor(R.color.syc_33ffffff);
        this.s.setShapeModel(shapeModel);
        this.s.setEnabled(false);
    }

    private void a(List<LiverecommendListData> list) {
        ArrayList arrayList = new ArrayList();
        for (LiverecommendListData liverecommendListData : list) {
            LiveRoomData liveRoomData = new LiveRoomData();
            liveRoomData.lid = StringUtils.a(liverecommendListData.lid, 0L);
            liveRoomData.description = liverecommendListData.description;
            liveRoomData.live_type = Integer.parseInt(liverecommendListData.live_type);
            liveRoomData.live_url = liverecommendListData.live_play;
            liveRoomData.screen_pattern = Integer.parseInt(liverecommendListData.screen_pattern);
            liveRoomData.profile = new LiveRoomAnchorModel();
            liveRoomData.profile.uid = liverecommendListData.uid;
            liveRoomData.profile.name = liverecommendListData.anchor.name;
            liveRoomData.profile.avatar = liverecommendListData.anchor.avatar;
            liveRoomData.profile.vbadge = Integer.parseInt(liverecommendListData.anchor.vbadge);
            arrayList.add(liveRoomData);
        }
        if (LiveDataListManager.a().b().size() == 1) {
            LiveDataListManager.a().b().clear();
        }
        LiveDataListManager.a().b(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        if (LiveRoomManager.a().t()) {
            return;
        }
        LiveRoomInfo.a().a(getContext(), LiveRoomManager.a().g(), LiveRoomManager.a().p().profile.name, LiveRoomManager.a().p().profile.avatar, 0, 2);
        p();
    }

    private void b(LiverecommendListData liverecommendListData) {
        LiveRoomData liveRoomData = new LiveRoomData();
        liveRoomData.lid = StringUtils.a(liverecommendListData.lid, 0L);
        liveRoomData.description = liverecommendListData.description;
        liveRoomData.live_type = Integer.parseInt(liverecommendListData.live_type);
        liveRoomData.live_url = liverecommendListData.live_play;
        liveRoomData.screen_pattern = Integer.parseInt(liverecommendListData.screen_pattern);
        liveRoomData.profile = new LiveRoomAnchorModel();
        liveRoomData.profile.name = liverecommendListData.anchor.name;
        liveRoomData.profile.avatar = liverecommendListData.anchor.avatar;
        liveRoomData.profile.vbadge = Integer.parseInt(liverecommendListData.anchor.vbadge);
        LiveDataListManager.a().a(liveRoomData);
    }

    private void b(String str) {
        LiveRoomInfo.a().b(getContext(), this.n, str, r(), a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(LiverecommendListData liverecommendListData) {
        EventTrackLive.c(LiveProtos.Event.USER_END_PAGE_RECOMMEND_ROOM_CLICK, LiveRoomManager.a().g(), LiveRoomManager.a().e(), liverecommendListData.lid, liverecommendListData.uid);
        a(this.w);
        if (liverecommendListData.lid.equals(LiveRoomManager.a().e())) {
            return;
        }
        if (!String.valueOf(LiveDataListManager.a().c()).equals(liverecommendListData.lid)) {
            b(liverecommendListData);
        }
        a(a(liverecommendListData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (LiveRoomManager.a().p() != null) {
            LiveRoomManager.a().p().relationship = str;
        }
        if ("1".equals(str) || "3".equals(str)) {
            if (LiveRoomManager.a().p() != null) {
                LiveRoomManager.a().p().isFollow = true;
            }
            a((Boolean) true);
        } else {
            if (LiveRoomManager.a().p() != null) {
                LiveRoomManager.a().p().isFollow = false;
            }
            a((Boolean) false);
        }
        LiveRoomInfo.a().v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        EventTrackLive.a(LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(View view) {
    }

    private void n() {
        this.v = new LiveFinishRecommendAdapter(getContext(), new LiveFinishRecommendAdapter.LiveClickCallBack() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveGuestFinishDlgFragment$3MPB3Rj-CyaFX4g5ZW6z2ZVQsfA
            @Override // com.blued.android.module.live_china.adapter.LiveFinishRecommendAdapter.LiveClickCallBack
            public final void addDesireSuccess(LiverecommendListData liverecommendListData) {
                LiveGuestFinishDlgFragment.this.c(liverecommendListData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        s();
        if (this.w.size() <= 0) {
            p();
            return;
        }
        LiverecommendListData liverecommendListData = this.w.get(0);
        a(this.w);
        if (liverecommendListData.lid.equals(LiveRoomManager.a().e())) {
            return;
        }
        if (!String.valueOf(LiveDataListManager.a().c()).equals(liverecommendListData.lid)) {
            b(liverecommendListData);
        }
        a(a(liverecommendListData));
    }

    private void p() {
        LiveFloatManager.a().b(false);
        LiveFloatManager.a().n();
        s();
        if (getTargetFragment() == null || !(getTargetFragment() instanceof PlayingOnliveFragment)) {
            return;
        }
        ((PlayingOnliveFragment) getTargetFragment()).T();
    }

    private void q() {
        EventTrackLive.a(LiveProtos.Event.USER_END_PAGE_RECOMMEND_ROOM_CHANGE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        m();
        l();
    }

    private String r() {
        return "liveanchor_" + LiveRoomManager.a().d();
    }

    private void s() {
        CountDownTimer countDownTimer = this.A;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void a(PlayingOnliveFragment playingOnliveFragment) {
        this.l = playingOnliveFragment;
    }

    public void a(String str) {
        LiveRoomInfo.a().a(getContext(), this.n, str, r(), a());
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public int d() {
        return R.layout.fragment_live_guest_finish;
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void e() {
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveGuestFinishDlgFragment$1CdVmZ9vn7CCA7TvDz_RaUMr7IM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGuestFinishDlgFragment.e(view);
            }
        });
        EventTrackLive.a(LiveProtos.Event.LIVE_END_PAGE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        this.o = (ImageView) this.b.findViewById(R.id.live_guest_finish_anchor_header);
        this.p = (TextView) this.b.findViewById(R.id.live_guest_finish_anchor_name);
        this.k = (ImageView) this.b.findViewById(R.id.live_guest_finish_leave_btn);
        this.j = (ProgressBar) this.b.findViewById(R.id.live_guest_finish_loading_view);
        this.z = (TextView) this.b.findViewById(R.id.tv_auto_next_tips_time);
        this.t = (LinearLayout) this.b.findViewById(R.id.ll_notice_root);
        this.q = (TextView) this.b.findViewById(R.id.tv_notice_time);
        this.r = (TextView) this.b.findViewById(R.id.tv_notice_content);
        this.y = this.b.findViewById(R.id.view_dividing_line);
        this.s = (ShapeTextView) this.b.findViewById(R.id.live_guest_finish_anchor_attention);
        TextView textView = (TextView) this.b.findViewById(R.id.live_guest_finish_changed);
        this.u = (LinearLayout) this.b.findViewById(R.id.live_guest_finish_changed_loading);
        this.x = this.b.findViewById(R.id.rv_recommend_data);
        this.m = (ImageView) this.b.findViewById(R.id.background_header);
        n();
        this.x.setLayoutManager(new GridLayoutManager(getContext(), 2));
        this.x.setHasTransientState(true);
        this.v.setNewData(this.w);
        this.x.setAdapter(this.v);
        this.k.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveGuestFinishDlgFragment$F54IpRe3w911DEShvE2UQuz_4Ys
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGuestFinishDlgFragment.this.d(view);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveGuestFinishDlgFragment$m1SakXA2XOsr9PcbdYkZo2OuSZc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGuestFinishDlgFragment.this.c(view);
            }
        });
        if (!LiveRoomManager.a().t()) {
            ImageLoader.a(a(), LiveRoomManager.a().p().profile.avatar).b(R.drawable.user_bg_round).c().a(this.o);
            this.o.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveGuestFinishDlgFragment$OAHQmySn3FglFpA_Mecm92rg5j0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveGuestFinishDlgFragment.this.b(view);
                }
            });
            this.p.setText(LiveRoomManager.a().p().profile.name);
            a(Boolean.valueOf(LiveRoomManager.a().p().isFollow));
            if (!LiveRoomManager.a().t()) {
                EventTrackLive.a(LiveProtos.Event.LIVE_END_PAGE_FOLLOW_BTN_SHOW, LiveRoomManager.a().d(), LiveRoomManager.a().g(), EventTrackLive.a(LiveRoomManager.a().p().relationship));
            }
            this.s.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveGuestFinishDlgFragment$VlVWh_sHfM2KpTop68pmSxRzC2c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveGuestFinishDlgFragment.this.a(view);
                }
            });
        }
        AnimationUtils.a(this.b);
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void f() {
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void g() {
        super.g();
        ImageLoader.a(a(), LiveRoomManager.a().p().profile.avatar).d().a(this.m);
        k();
        l();
    }

    public void k() {
        LiveRoomHttpUtils.y(new BluedUIHttpResponse<BluedEntity<LiveAnnounceInfoModel, LiveAnnounceInfoExtra>>(a()) { // from class: com.blued.android.module.live_china.fragment.LiveGuestFinishDlgFragment.1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                LiveGuestFinishDlgFragment.this.dismissAllowingStateLoss();
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<LiveAnnounceInfoModel, LiveAnnounceInfoExtra> bluedEntity) {
                if (bluedEntity == null || bluedEntity.getSingleData() == null) {
                    return;
                }
                LiveGuestFinishDlgFragment.this.a(bluedEntity.getSingleData());
            }
        }, LiveRoomManager.a().g());
    }

    public void l() {
        LiveRoomHttpUtils.u(new AnonymousClass2(a()));
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.blued.android.module.live_china.fragment.LiveGuestFinishDlgFragment$4] */
    public void m() {
        s();
        this.A = new CountDownTimer(8000L, 1000L) { // from class: com.blued.android.module.live_china.fragment.LiveGuestFinishDlgFragment.4
            @Override // android.os.CountDownTimer
            public void onFinish() {
                LiveGuestFinishDlgFragment.this.o();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                if (LiveGuestFinishDlgFragment.this.z != null) {
                    LiveGuestFinishDlgFragment.this.z.setText(String.format(AppInfo.d().getString(R.string.live_finish_auto_next_tips), String.valueOf(j / 1000)));
                }
            }
        }.start();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        o();
        return true;
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment, com.blued.android.core.ui.BaseDialogFragment
    public void onDestroy() {
        super.onDestroy();
        s();
    }
}
