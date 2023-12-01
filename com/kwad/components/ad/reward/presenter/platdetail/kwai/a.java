package com.kwad.components.ad.reward.presenter.platdetail.kwai;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.components.ad.reward.n;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.video.i;
import com.kwad.components.core.webview.a.j;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bm;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/platdetail/kwai/a.class */
public final class a extends com.kwad.components.ad.reward.presenter.a implements View.OnClickListener, bm.a {
    private static final String[] uD = {"%ss后获得奖励1", "已获得奖励1/2", "已获得全部奖励"};
    private TextView gI;
    private bm gK;
    private boolean gL;
    private long gM;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private ImageView uA;
    private View uB;
    private TextView uz;
    private boolean uC = false;
    private boolean uE = false;
    private com.kwad.components.core.webview.a.d.e gG = new com.kwad.components.core.webview.a.d.e() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.a.1
        @Override // com.kwad.components.core.webview.a.d.b
        public final void u(String str) {
            if (j.b("ksad-video-top-bar", a.this.qt.mAdTemplate).equals(str)) {
                a.this.cc();
            }
        }
    };
    private AdLivePlayStateListener mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.a.2
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            if (a.this.gL) {
                return;
            }
            a.this.gK.sendEmptyMessageDelayed(1, 500L);
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j) {
            super.onLivePlayProgress(j);
            if (j > 800) {
                a.this.a(com.kwad.sdk.core.response.a.a.X(a.this.mAdInfo), j);
                a.this.gM = j;
                a.a(a.this, true);
            }
        }
    };
    private final i mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.a.3
        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j, long j2) {
            long a2 = com.kwad.components.ad.reward.j.a(j, a.this.mAdInfo);
            a.this.gM = j2;
            a.this.a(a2, j2);
        }
    };
    private final com.kwad.components.ad.reward.d.j mRewardVerifyListener = new com.kwad.components.ad.reward.d.j() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.a.4
        @Override // com.kwad.components.ad.reward.d.j
        public final void onRewardVerify() {
            a.b(a.this, true);
            a.this.uz.setText(a.uD[2]);
        }
    };

    private void A(int i) {
        this.qt.py = i;
        if (!com.kwad.components.ad.reward.j.q(this.mAdTemplate)) {
            this.gI.setText(String.valueOf(i));
        } else if (this.uE) {
        } else {
            this.uz.setText(String.format(uD[0], Integer.valueOf(i)));
        }
    }

    private void a(long j, long j2, long j3) {
        if (j < (j2 - 800) - j3) {
            int i = (int) ((((float) (j2 - j)) / 1000.0f) + 0.5f);
            A(i);
            if (this.qt.pp != null) {
                this.qt.pp.W(i);
                return;
            }
            return;
        }
        this.qt.f23926pl = true;
        if (!com.kwad.components.ad.reward.j.q(this.mAdTemplate)) {
            notifyRewardVerify();
            ie();
            if (this.qt.pp != null) {
                this.qt.pp.W(0);
                return;
            }
            return;
        }
        if (!com.kwad.components.ad.reward.j.o(this.mAdTemplate) || this.qt.pw == null) {
            if (com.kwad.components.ad.reward.j.p(this.mAdTemplate) && this.qt.px != null && !this.qt.px.jv()) {
                this.qt.px.ju();
            }
        } else if (!this.qt.pw.jv()) {
            this.qt.pw.ju();
        }
        if (this.uE) {
            return;
        }
        this.uz.setText(uD[1]);
        m7647if();
    }

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.gL = true;
        return true;
    }

    static /* synthetic */ boolean b(a aVar, boolean z) {
        aVar.uE = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cc() {
        AdTemplate adTemplate = this.qt.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        this.mApkDownloadHelper = this.qt.mApkDownloadHelper;
        long a2 = com.kwad.components.ad.reward.j.a(com.kwad.sdk.core.response.a.a.G(this.mAdInfo), this.mAdInfo) / 1000;
        if (com.kwad.components.ad.reward.j.q(this.mAdTemplate)) {
            this.uB.setVisibility(0);
            this.uB.setOnClickListener(this);
            this.uz.setText(String.format(uD[0], Long.valueOf(a2)));
            this.gI.setVisibility(8);
        } else {
            this.uB.setVisibility(8);
            this.gI.setText(String.valueOf(a2));
            this.gI.setVisibility(0);
            this.gI.setAlpha(1.0f);
        }
        com.kwad.components.ad.reward.c.fj().a(this.mRewardVerifyListener);
        this.qt.oN.a(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
    }

    private void ie() {
        if (this.uC) {
            return;
        }
        this.uC = true;
        this.uA.setAlpha(0.0f);
        this.uA.setVisibility(0);
        this.uA.setOnClickListener(this);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.a.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                a.this.gI.setVisibility(8);
            }
        });
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.a.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                a.this.gI.setAlpha(1.0f - floatValue);
                a.this.uA.setAlpha(floatValue);
            }
        });
        ofFloat.start();
    }

    /* renamed from: if  reason: not valid java name */
    private void m7647if() {
        if (this.qt.mAdRewardStepListener != null) {
            this.qt.mAdRewardStepListener.fo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, 41, this.qt.mRootContainer.getTouchCoords(), this.qt.mReportExtData);
        this.qt.mAdOpenInteractionListener.bN();
    }

    private void notifyRewardVerify() {
        this.qt.mAdOpenInteractionListener.onRewardVerify();
    }

    public final void a(long j, long j2) {
        int i = 0;
        int aE = com.kwad.sdk.core.response.a.a.aG(this.mAdInfo) && com.kwad.components.core.p.a.pt().pu() == 0 ? com.kwad.sdk.core.response.a.a.aE(this.mAdInfo) : com.kwad.sdk.core.response.a.a.aC(this.mAdInfo);
        if (this.qt.pi) {
            i = 1000;
        }
        long j3 = aE * i;
        n.a(this.qt, j2, j, j3);
        a(j2, j, j3);
    }

    @Override // com.kwad.sdk.utils.bm.a
    public final void a(Message message) {
        if (message.what == 1) {
            if (this.qt.fW() || this.qt.fV()) {
                this.gK.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            this.gM += 500;
            a(com.kwad.sdk.core.response.a.a.X(this.mAdInfo), this.gM);
            this.gK.sendEmptyMessageDelayed(1, 500L);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.gK = new bm(this);
        if (com.kwad.components.ad.reward.j.b(this.qt)) {
            com.kwad.components.core.webview.a.c.a.rn().a(this.gG);
            return;
        }
        cc();
        if (this.qt.oN.jF()) {
            A((int) (((float) com.kwad.sdk.core.response.a.a.X(this.mAdInfo)) / 1000.0f));
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Tracker.onClick(view);
        if (view == this.uA || view == this.uB) {
            com.kwad.components.core.d.b.a.a(new a.C0519a(view.getContext()).I(this.mAdTemplate).b(this.mApkDownloadHelper).ap(2).q(this.qt.oN.getPlayDuration()).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.kwai.a.7
                @Override // com.kwad.components.core.d.b.a.b
                public final void onAdClicked() {
                    a.this.notifyAdClick();
                }
            }));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.gI = (TextView) findViewById(R.id.ksad_video_count_down);
        this.uA = (ImageView) findViewById(R.id.ksad_detail_reward_icon);
        this.uz = (TextView) findViewById(R.id.ksad_reward_deep_task_count_down);
        this.uB = findViewById(R.id.ksad_detail_reward_deep_task_view);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.reward.c.fj().b(this.mRewardVerifyListener);
        this.qt.oN.b(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
        com.kwad.components.core.webview.a.c.a.rn().b(this.gG);
        this.uA.setVisibility(8);
        this.uB.setVisibility(8);
        this.uC = false;
        this.uE = false;
        this.gL = false;
    }
}
