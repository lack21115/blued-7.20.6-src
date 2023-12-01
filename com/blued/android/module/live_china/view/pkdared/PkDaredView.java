package com.blued.android.module.live_china.view.pkdared;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.blued.android.chat.model.SessionProfileModel;
import com.blued.android.chat.utils.ChatHelper;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveDataListManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.AnchorLiveStateModel;
import com.blued.android.module.live_china.model.EnumPKStage;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.model.LiveRoomAnchorModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.PropModule;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.observer.PkDaredObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import java.util.HashMap;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/pkdared/PkDaredView.class */
public class PkDaredView extends FrameLayout implements PkDaredObserver.IPkDaredObserver {

    /* renamed from: a  reason: collision with root package name */
    public EnumPKStage f15425a;
    private IRequestHost b;

    /* renamed from: c  reason: collision with root package name */
    private int f15426c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private String i;
    private String j;
    private String k;
    private long l;
    private FrameLayout m;
    private ViewGroup n;
    private PkDaredMatchView o;
    private PkDaredBodyView p;
    private PkDaredEggView q;
    private PkDaredFogView r;
    private PkDaredTextBarView s;
    private PkDaredPropBarView t;
    private PkDaredNoticeView u;
    private PkDaredResultView v;
    private View w;

    public PkDaredView(Context context) {
        super(context);
        this.f15425a = EnumPKStage.MATCH;
        a(context);
    }

    public PkDaredView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15425a = EnumPKStage.MATCH;
        a(context);
    }

    public PkDaredView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15425a = EnumPKStage.MATCH;
        a(context);
    }

    public PkDaredView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f15425a = EnumPKStage.MATCH;
        a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ViewGroup.LayoutParams layoutParams, int i, int i2, ValueAnimator valueAnimator) {
        layoutParams.height = (int) (i + ((i2 - i) * ((Float) valueAnimator.getAnimatedValue()).floatValue()));
        this.m.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, String str2, String str3, long j, int i, int i2, int i3, int i4, int i5, int i6, String str4, String str5, boolean z) {
        int i7;
        PkDaredTextBarView pkDaredTextBarView;
        j();
        this.f15425a = EnumPKStage.PK_1;
        this.i = str;
        this.j = str2;
        this.k = str3;
        this.l = j;
        this.p.a(str2, i, i2, i3, i4, this.b);
        this.g = i5;
        this.h = i6;
        this.p.a(i5, i6);
        this.q.setTargetScore(this.g);
        int i8 = this.f15426c;
        if ((LiveRoomInfo.a().g() == LiveRoomManager.a().f()) || TextUtils.isEmpty(str4) || (pkDaredTextBarView = this.s) == null) {
            this.s.setVisibility(8);
            i7 = i8;
        } else {
            pkDaredTextBarView.a(str4, str5);
            i7 = i8 + this.e;
        }
        if (z && this.n != null) {
            PkDaredJoinView pkDaredJoinView = new PkDaredJoinView(getContext());
            this.n.addView(pkDaredJoinView);
            pkDaredJoinView.a(str2, str3, this.b);
        }
        if (this.f != i7) {
            e();
        }
        EventTrackLive.f(LiveProtos.Event.LIVE_CHALLENGE_PK_PANEL_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().p().profile.uid, TextUtils.isEmpty(this.i) ? "0" : this.i, String.valueOf(this.l));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z, View view) {
        if (z || this.l <= 0 || TextUtils.isEmpty(this.i) || "0".equals(this.i)) {
            return;
        }
        LiveRoomHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<AnchorLiveStateModel>>() { // from class: com.blued.android.module.live_china.view.pkdared.PkDaredView.1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<AnchorLiveStateModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    return;
                }
                AnchorLiveStateModel singleData = bluedEntityA.getSingleData();
                if (singleData.is_live == 1) {
                    PkDaredView.this.i = String.valueOf(singleData.lid);
                    try {
                        PkDaredView.this.g();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }, String.valueOf(this.l), this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z, String str, String str2, String str3, String str4, int i, int i2, int i3, boolean z2) {
        PropModule propModule = new PropModule();
        propModule.isOur = z;
        propModule.propIcon = str;
        propModule.propName = str2;
        propModule.function = str3;
        propModule.markUp = str4;
        propModule.countDown = i;
        propModule.totalTime = i2;
        propModule.noticeDuration = i3 * 1000;
        this.t.a(this.b, propModule);
        if (z2) {
            this.u.a(this.b, z, propModule);
        }
        if (this.s.getVisibility() == 0 && this.s.getTranslationY() == 0.0f) {
            this.s.animate().alpha(0.0f).translationY(-this.e).setDuration(300L).setInterpolator(new DecelerateInterpolator(1.5f));
        }
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(int i, int i2, int i3, int i4, int i5) {
        this.f15425a = EnumPKStage.EGG;
        this.q.a(i, i2, i3, i4, i5, this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(int i, String str, int i2, String str2, String str3, int i3) {
        this.q.a(i, str, i2, str2, str3, i3);
        if (i == 1) {
            SessionProfileModel sessionProfileModel = new SessionProfileModel();
            sessionProfileModel.nickname = str;
            LiveChattingModel copy = LiveChattingModel.copy(ChatHelper.getChattingModelForSendmsg(LiveRoomManager.a().d(), (short) -10007, "", sessionProfileModel, "", LiveRoomManager.a().j()));
            copy.fromId = i2;
            copy.fromNickName = str;
            HashMap hashMap = new HashMap();
            hashMap.put("propName", str2);
            copy.msgMapExtra = hashMap;
            LiveMsgSendManager.a().a(copy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(int i, boolean z) {
        e();
        this.f15425a = EnumPKStage.MATCH;
        this.o.setRequestHost(this.b);
        this.o.setVisibility(0);
        this.o.a(i, z);
        this.p.setVisibility(8);
        this.p.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(int i, boolean z, String str, int i2, String str2, int i3, int i4, int i5, int i6) {
        this.p.setVisibility(8);
        this.v.a(i, z, str, i2, str2, this.b, i3, i4, i5, i6);
        this.t.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(PkDaredNoticeItemView pkDaredNoticeItemView) {
        this.u.a(pkDaredNoticeItemView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(boolean z, PkDaredPropItemView pkDaredPropItemView) {
        this.t.a(z, pkDaredPropItemView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(boolean z, String str, String str2, int i) {
        this.u.a(z, str, str2, i);
    }

    private void f() {
        boolean z = LiveRoomInfo.a().g() == LiveRoomManager.a().f();
        if (z) {
            this.w.setClickable(false);
            this.w.setVisibility(8);
            return;
        }
        this.w.setVisibility(0);
        this.w.setClickable(true);
        final boolean z2 = z;
        this.w.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredView$SZ9Vy0LeW5AAlwUy6J8K5-NAI-8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PkDaredView.this.a(z2, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(int i, int i2) {
        this.f15425a = EnumPKStage.KILL_ACTIVATE;
        this.p.e(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        EventTrackLive.f(LiveProtos.Event.LIVE_CHALLENGE_PK_PANEL_ANCHOR_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().p().profile.uid, TextUtils.isEmpty(this.i) ? "0" : this.i, String.valueOf(this.l));
        LiveRoomData liveRoomData = new LiveRoomData();
        liveRoomData.lid = Long.parseLong(this.i);
        String str = this.j;
        if (str != null && !str.isEmpty()) {
            LiveRoomAnchorModel liveRoomAnchorModel = new LiveRoomAnchorModel();
            liveRoomAnchorModel.name = this.j;
            liveRoomAnchorModel.avatar = this.k;
            liveRoomAnchorModel.uid = String.valueOf(this.l);
            liveRoomData.profile = liveRoomAnchorModel;
        }
        LiveDataListManager.a().b(liveRoomData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(int i, int i2) {
        this.p.d(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void p() {
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredView$Ro-eVmy0EPKQjOncWiurJs7o7s4
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredView.this.n();
            }
        });
    }

    private void h(final int i) {
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredView$p5cBB7wcdhf6josdQ4mhN77G0fI
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredView.this.p(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(int i, int i2) {
        this.p.c(i, i2);
    }

    private void i() {
        this.f15426c = DensityUtils.a(getContext(), 61.5f);
        this.d = DensityUtils.a(getContext(), 19.6f);
        this.e = DensityUtils.a(getContext(), 14.5f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(int i) {
        if (!(LiveRoomInfo.a().g() == LiveRoomManager.a().f())) {
            a();
            return;
        }
        j();
        g(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(int i, int i2) {
        if (this.p != null && this.f15425a == EnumPKStage.EGG) {
            this.q.a(i, i2);
        }
    }

    private void j() {
        this.o.a();
        this.p.a();
        this.q.a();
        this.r.a();
        this.s.a();
        this.t.a();
        this.u.a();
        this.v.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(int i) {
        this.f15425a = EnumPKStage.KILL_ACTIVATE;
        this.p.d(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(int i, int i2) {
        PkDaredBodyView pkDaredBodyView = this.p;
        if (pkDaredBodyView == null) {
            return;
        }
        pkDaredBodyView.b(i, i2);
        if (this.f != this.f15426c) {
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k() {
        this.f15425a = EnumPKStage.PK_2;
        this.p.c();
        this.q.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(int i) {
        this.f15425a = EnumPKStage.KILL_UN_ACTIVATE;
        this.p.c(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l() {
        if (this.s.getVisibility() == 0 && this.s.getTranslationY() < 0.0f) {
            this.s.animate().alpha(1.0f).translationY(0.0f).setDuration(300L).setInterpolator(new DecelerateInterpolator(1.5f));
        }
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(int i) {
        this.f15425a = EnumPKStage.KILL_PREDICTION;
        this.p.b(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m() {
        h(0);
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(int i) {
        this.f15425a = EnumPKStage.EGG_PREDICTION;
        this.p.a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ void n() {
        /*
            r3 = this;
            r0 = r3
            int r0 = r0.f15426c
            if (r0 != 0) goto Lb
            r0 = r3
            r0.i()
        Lb:
            r0 = r3
            int r0 = r0.f15426c
            r5 = r0
            r0 = r3
            com.blued.android.module.live_china.view.pkdared.PkDaredPropBarView r0 = r0.t
            boolean r0 = r0.d()
            if (r0 == 0) goto L26
            r0 = r3
            int r0 = r0.d
            r4 = r0
        L1f:
            r0 = r5
            r1 = r4
            int r0 = r0 + r1
            r4 = r0
            goto L3a
        L26:
            r0 = r5
            r4 = r0
            r0 = r3
            com.blued.android.module.live_china.view.pkdared.PkDaredTextBarView r0 = r0.s
            boolean r0 = r0.b()
            if (r0 == 0) goto L3a
            r0 = r3
            int r0 = r0.e
            r4 = r0
            goto L1f
        L3a:
            r0 = r3
            int r0 = r0.f
            r1 = r4
            if (r0 == r1) goto L47
            r0 = r3
            r1 = r4
            r0.h(r1)
        L47:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.view.pkdared.PkDaredView.n():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(int i) {
        this.p.e(i);
        this.r.a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o() {
        if (getVisibility() != 0) {
            setVisibility(0);
            post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredView$88tGFQ1a2f4nw3lDZaaEkc8Wkfw
                @Override // java.lang.Runnable
                public final void run() {
                    PkDaredView.this.p();
                }
            });
        } else {
            p();
        }
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(int i) {
        if (i <= 0) {
            a();
            return;
        }
        this.f15425a = EnumPKStage.MATCH;
        this.o.setVisibility(0);
        this.o.b(i, true);
        this.p.setVisibility(8);
        this.p.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(final int i) {
        if (this.f == i) {
            return;
        }
        final ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
        final int i2 = layoutParams.height;
        int max = Math.max((int) ((Math.abs(i - i2) * 500.0f) / this.f15426c), 200);
        this.f = i;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(max);
        ofFloat.setInterpolator(new DecelerateInterpolator(2.0f));
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredView$mXxv9Smvl-AAfbG3wOwRC5VSXw0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                PkDaredView.this.a(layoutParams, i2, i, valueAnimator);
            }
        });
        ofFloat.start();
    }

    @Override // com.blued.android.module.live_china.observer.PkDaredObserver.IPkDaredObserver
    public void a() {
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredView$Bqu5N3AFsag2J2LfojdDKeBzgm8
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredView.this.m();
            }
        });
        LiveSetDataObserver.a().z();
    }

    @Override // com.blued.android.module.live_china.observer.PkDaredObserver.IPkDaredObserver
    public void a(int i) {
        a(i, false);
    }

    @Override // com.blued.android.module.live_china.observer.PkDaredObserver.IPkDaredObserver
    public void a(final int i, final int i2) {
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredView$rj17zFfi2UuCPHnVg_3-xl0WJms
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredView.this.j(i, i2);
            }
        });
    }

    @Override // com.blued.android.module.live_china.observer.PkDaredObserver.IPkDaredObserver
    public void a(final int i, final int i2, final int i3, final int i4, final int i5) {
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredView$xR5uLnnvmW1eUi0D_e1lKI2AOl8
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredView.this.b(i, i2, i3, i4, i5);
            }
        });
    }

    @Override // com.blued.android.module.live_china.observer.PkDaredObserver.IPkDaredObserver
    public void a(final int i, final String str, final int i2, final String str2, final String str3, final int i3) {
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredView$e0EQV_bhGn0H6vp0bznWNiX8jQI
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredView.this.b(i, str, i2, str2, str3, i3);
            }
        });
    }

    public void a(final int i, final boolean z) {
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = 0L;
        setVisibility(0);
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredView$9Zdi4476VhJBr2ofSCFzX3RF1SA
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredView.this.b(i, z);
            }
        });
    }

    @Override // com.blued.android.module.live_china.observer.PkDaredObserver.IPkDaredObserver
    public void a(final int i, final boolean z, final String str, final int i2, final String str2, final int i3, final int i4, final int i5, final int i6) {
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredView$YTKar36GpFJZVVcoz-mFt7IV6oU
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredView.this.b(i, z, str, i2, str2, i3, i4, i5, i6);
            }
        });
    }

    protected void a(Context context) {
        LayoutInflater.from(getContext()).inflate(R.layout.live_pk_dared_view, this);
        this.m = (FrameLayout) findViewById(R.id.fl_view_root);
        this.o = (PkDaredMatchView) findViewById(R.id.pdmv_match);
        this.p = (PkDaredBodyView) findViewById(R.id.pdbv_body);
        this.q = (PkDaredEggView) findViewById(R.id.pdev_egg);
        this.r = (PkDaredFogView) findViewById(R.id.pdfv_fog);
        this.s = (PkDaredTextBarView) findViewById(R.id.pptv_text_bar);
        this.t = (PkDaredPropBarView) findViewById(R.id.ppbv_prop_bar);
        this.u = (PkDaredNoticeView) findViewById(R.id.pdnv_notice);
        this.v = (PkDaredResultView) findViewById(R.id.pdrv_result);
        this.w = findViewById(R.id.view_click);
        i();
    }

    public void a(IRequestHost iRequestHost) {
        this.b = iRequestHost;
        PkDaredObserver.a().a(this);
    }

    @Override // com.blued.android.module.live_china.observer.PkDaredObserver.IPkDaredObserver
    public void a(final PkDaredNoticeItemView pkDaredNoticeItemView) {
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredView$UWEdS2LsyuE2V-gJqER7ICr-q7w
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredView.this.b(pkDaredNoticeItemView);
            }
        });
    }

    @Override // com.blued.android.module.live_china.observer.PkDaredObserver.IPkDaredObserver
    public void a(final String str, final String str2, final long j, final String str3, final int i, final int i2, final int i3, final int i4, final int i5, final int i6, final String str4, final String str5, final boolean z) {
        setVisibility(0);
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredView$FHxfvrSGT0qcgxtvf9Pw28lrItk
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredView.this.a(str3, str, str2, j, i, i2, i3, i4, i5, i6, str4, str5, z);
            }
        });
    }

    @Override // com.blued.android.module.live_china.observer.PkDaredObserver.IPkDaredObserver
    public void a(boolean z, final int i) {
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredView$0pINv5Dx5lO02Ah24GdDbffNV_w
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredView.this.n(i);
            }
        });
    }

    @Override // com.blued.android.module.live_china.observer.PkDaredObserver.IPkDaredObserver
    public void a(final boolean z, final PkDaredPropItemView pkDaredPropItemView) {
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredView$MKAhEol5IbQgFUZ1WzfssFsHgPE
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredView.this.b(z, pkDaredPropItemView);
            }
        });
    }

    @Override // com.blued.android.module.live_china.observer.PkDaredObserver.IPkDaredObserver
    public void a(final boolean z, final String str, final String str2, final int i) {
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredView$4eomAU5AK8EoGUSDQx4SpFtaQu4
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredView.this.b(z, str, str2, i);
            }
        });
    }

    @Override // com.blued.android.module.live_china.observer.PkDaredObserver.IPkDaredObserver
    public void a(final boolean z, final String str, final String str2, final String str3, final String str4, final int i, final int i2, final boolean z2, final int i3) {
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredView$2HvrfYAmBJmY_VpqUddd7zxaI3k
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredView.this.a(z, str, str2, str3, str4, i, i2, i3, z2);
            }
        });
    }

    @Override // com.blued.android.module.live_china.observer.PkDaredObserver.IPkDaredObserver
    public void b() {
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredView$ThU2M-jNL0BGwQJksTdZngp5ALs
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredView.this.l();
            }
        });
    }

    @Override // com.blued.android.module.live_china.observer.PkDaredObserver.IPkDaredObserver
    public void b(final int i) {
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredView$06tdGhWHcfEMdgkZy0ba0AAFUrk
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredView.this.m(i);
            }
        });
    }

    @Override // com.blued.android.module.live_china.observer.PkDaredObserver.IPkDaredObserver
    public void b(final int i, final int i2) {
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredView$Ta9AQVqDHF550H89IOVAG1rbOqA
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredView.this.i(i, i2);
            }
        });
    }

    @Override // com.blued.android.module.live_china.observer.PkDaredObserver.IPkDaredObserver
    public void c() {
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredView$9OJndC3CGaqIfgWgVODyuVfTWyk
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredView.this.k();
            }
        });
    }

    @Override // com.blued.android.module.live_china.observer.PkDaredObserver.IPkDaredObserver
    public void c(final int i) {
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredView$x3HVljl35-Qqcz6cnl9noFm5xik
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredView.this.l(i);
            }
        });
    }

    @Override // com.blued.android.module.live_china.observer.PkDaredObserver.IPkDaredObserver
    public void c(final int i, final int i2) {
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredView$tgae1qf8yHbAj8MYJdZAmn2jBOM
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredView.this.h(i, i2);
            }
        });
    }

    public void d() {
        j();
        PkDaredObserver.a().b(this);
    }

    @Override // com.blued.android.module.live_china.observer.PkDaredObserver.IPkDaredObserver
    public void d(final int i) {
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredView$6LMkVWmf9fBMCZW94HJQIq3bxkg
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredView.this.k(i);
            }
        });
    }

    @Override // com.blued.android.module.live_china.observer.PkDaredObserver.IPkDaredObserver
    public void d(final int i, final int i2) {
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredView$2x9SM60Z7lG5pwWlbKabUlmUpcY
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredView.this.g(i, i2);
            }
        });
    }

    public void e() {
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredView$yrXoxyFpN6OLTfngA44qeNNKnms
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredView.this.o();
            }
        });
        LiveSetDataObserver.a().y();
    }

    @Override // com.blued.android.module.live_china.observer.PkDaredObserver.IPkDaredObserver
    public void e(final int i) {
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredView$8tMJZbfKOMHzpmMgG8MR1nChJQ0
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredView.this.j(i);
            }
        });
    }

    @Override // com.blued.android.module.live_china.observer.PkDaredObserver.IPkDaredObserver
    public void e(final int i, final int i2) {
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredView$_8hSGCh5Gw2GQVRwg89yfxJv7rc
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredView.this.f(i, i2);
            }
        });
    }

    @Override // com.blued.android.module.live_china.observer.PkDaredObserver.IPkDaredObserver
    public void f(final int i) {
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = 0L;
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredView$Ek6ND3EvboudpHB6L3vafFPKYto
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredView.this.i(i);
            }
        });
    }

    public void g(final int i) {
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredView$LQN8WGKqa0gcH_eQ1_xeVw24TOA
            @Override // java.lang.Runnable
            public final void run() {
                PkDaredView.this.o(i);
            }
        });
    }

    public void setStartPKAnimRootView(ViewGroup viewGroup) {
        this.n = viewGroup;
    }
}
