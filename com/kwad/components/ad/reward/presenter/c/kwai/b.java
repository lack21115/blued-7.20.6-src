package com.kwad.components.ad.reward.presenter.c.kwai;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import com.kwad.components.ad.reward.d.f;
import com.kwad.components.ad.reward.k.j;
import com.kwad.components.ad.reward.k.p;
import com.kwad.components.ad.reward.k.r;
import com.kwad.components.ad.reward.k.s;
import com.kwad.components.ad.reward.k.v;
import com.kwad.components.ad.reward.widget.tailframe.TailFrameView;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.sdk.R;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/c/kwai/b.class */
public final class b extends com.kwad.components.ad.reward.presenter.a implements ai.b {
    private com.kwad.components.ad.i.b cp;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private DetailVideoView mDetailVideoView;
    private TailFrameView uY;
    private volatile boolean uZ;
    private boolean va;
    private j vb;
    private s vc;
    private p vd;
    private Drawable vg;
    private boolean sF = false;
    private int ve = Integer.MIN_VALUE;
    private int vf = Integer.MIN_VALUE;
    private final com.kwad.components.ad.reward.d.j mRewardVerifyListener = new com.kwad.components.ad.reward.d.j() { // from class: com.kwad.components.ad.reward.presenter.c.kwai.b.1
        @Override // com.kwad.components.ad.reward.d.j
        public final void onRewardVerify() {
            b.this.io();
            if (b.this.uY == null || !com.kwad.components.ad.reward.j.q(b.this.mAdTemplate)) {
                return;
            }
            b.this.uY.jJ();
        }
    };
    private f mPlayEndPageListener = new com.kwad.components.ad.reward.d.a() { // from class: com.kwad.components.ad.reward.presenter.c.kwai.b.3
        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            if ((!d.cp(b.this.mAdTemplate) && b.this.sF && !b.this.qt.fP()) || b.this.qt.pq || b.this.qt.pv) {
                return;
            }
            boolean z = com.kwad.sdk.core.response.a.b.bF(b.this.mAdTemplate) && b.this.qt.fX() && b.this.qt.fJ() == 1;
            b.this.va = true;
            com.kwad.sdk.core.d.b.d("RewardPlayEndNativeCardPresenter", "onPlayEndPageShow " + z);
            b bVar = b.this;
            if (z) {
                com.kwad.components.ad.i.b bVar2 = bVar.qt.oS;
                if (bVar2 != null && bVar2.az()) {
                    b.this.qt.D(true);
                    b.this.va = false;
                }
                b.this.ir();
            } else if (bVar.cp != null && b.this.cp.az()) {
                b.this.va = false;
            }
            b.this.qt.pH = true ^ b.this.va;
            if (b.this.va) {
                if (b.this.qt.oR != null) {
                    com.kwad.components.ad.reward.monitor.a.a(b.this.qt.pf, "end_card", com.kwad.sdk.core.response.a.b.bd(b.this.mAdTemplate), System.currentTimeMillis() - b.this.qt.oR.getLoadTime(), 1);
                }
                b.this.W(z);
            }
        }

        @Override // com.kwad.components.ad.reward.d.a, com.kwad.components.ad.reward.d.f
        public final int getPriority() {
            return -1;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void P(boolean z) {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, z ? 2 : 153, this.qt.mRootContainer.getTouchCoords(), this.qt.mReportExtData);
        this.qt.mAdOpenInteractionListener.bN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(int i) {
        ViewGroup.LayoutParams layoutParams = this.mDetailVideoView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = i;
            this.mDetailVideoView.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(boolean z) {
        s sVar = this.vc;
        if (sVar != null) {
            sVar.show();
        } else if (z) {
            this.vd.show();
            this.vd.b(v.B(this.mAdTemplate));
            this.qt.D(true);
        } else {
            io();
            this.uY.a(new com.kwad.components.ad.reward.widget.tailframe.b() { // from class: com.kwad.components.ad.reward.presenter.c.kwai.b.5
                @Override // com.kwad.components.ad.reward.widget.tailframe.b
                public final void R(boolean z2) {
                    b.this.P(z2);
                }
            });
            this.uY.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void io() {
        if (this.uZ) {
            return;
        }
        ip();
    }

    private void ip() {
        com.kwad.sdk.core.d.b.d("RewardPlayEndNativeCardPresenter", "initTailView");
        this.uY.a(getContext(), this.qt.mScreenOrientation == 0, iu());
        this.uZ = true;
    }

    private void iq() {
        boolean bv = com.kwad.sdk.core.response.a.a.bv(this.mAdInfo);
        boolean cn2 = d.cn(this.mAdTemplate);
        if (bv && cn2) {
            s sVar = new s(R.id.ksad_playable_end_stub);
            this.vc = sVar;
            sVar.a(new r.a() { // from class: com.kwad.components.ad.reward.presenter.c.kwai.b.2
                @Override // com.kwad.components.ad.reward.k.r.a
                public final void hV() {
                    new y.b().akO = 6;
                }

                @Override // com.kwad.components.ad.reward.k.r.a
                public final void hW() {
                    com.kwad.components.ad.reward.b.ff().c(PlayableSource.ENDCARD_CLICK, new com.kwad.components.ad.reward.f.a(b.this.getContext()));
                    com.kwad.sdk.core.report.a.a(b.this.qt.mAdTemplate, new i().bl(67).bp(6));
                }

                @Override // com.kwad.components.ad.reward.k.r.a
                public final void hX() {
                    b.this.qt.a(2, b.this.getContext(), 2, 1);
                }

                @Override // com.kwad.components.ad.reward.k.r.a
                public final void hY() {
                    b.this.qt.a(2, b.this.getContext(), 2, 2);
                }
            });
            this.vc.e((ViewGroup) getRootView());
            this.vc.b(v.B(this.qt.mAdTemplate));
            this.vc.d(this.mAdTemplate, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ir() {
        this.mDetailVideoView.post(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.c.kwai.b.4
            @Override // java.lang.Runnable
            public final void run() {
                DetailVideoView detailVideoView;
                int i;
                if (b.this.mDetailVideoView == null) {
                    return;
                }
                b.this.getContext();
                if (com.kwad.sdk.utils.ai.DL()) {
                    return;
                }
                boolean aR = com.kwad.sdk.core.response.a.a.aR(b.this.mAdInfo);
                int screenWidth = com.kwad.sdk.c.kwai.a.getScreenWidth(b.this.getContext());
                b bVar = b.this;
                bVar.ve = bVar.mDetailVideoView.getLayoutParams().width;
                com.kwad.sdk.core.d.b.d("RewardPlayEndNativeCardPresenter", "setPlayAgainDetailView:  videoOriginalWidth :" + b.this.ve);
                b.this.R(screenWidth / 2);
                b bVar2 = b.this;
                bVar2.vf = bVar2.mDetailVideoView.getTextureViewGravity();
                if (aR) {
                    detailVideoView = b.this.mDetailVideoView;
                    i = 21;
                } else {
                    detailVideoView = b.this.mDetailVideoView;
                    i = 17;
                }
                detailVideoView.updateTextureViewGravity(i);
                b bVar3 = b.this;
                bVar3.vg = bVar3.mDetailVideoView.getBackground();
                b.this.mDetailVideoView.setBackgroundColor(b.this.getContext().getResources().getColor(R.color.ksad_play_again_horizontal_bg_light));
                b.this.is();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void is() {
        ImageView imageView = (ImageView) findViewById(R.id.ksad_blur_video_cover);
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(0);
        com.kwad.components.ad.reward.presenter.b.a(imageView, com.kwad.sdk.core.response.a.a.O(this.mAdInfo), this.mAdTemplate);
    }

    private void it() {
        if (this.va) {
            io();
            this.uY.destroy();
            this.uY.setVisibility(8);
            this.vb.hide();
            this.vd.hide();
        }
    }

    private boolean iu() {
        AdInfo.AdMaterialInfo.MaterialFeature aN = com.kwad.sdk.core.response.a.a.aN(this.mAdInfo);
        return aN.height > aN.width;
    }

    @Override // com.kwad.components.core.webview.jshandler.ai.b
    public final void a(ai.a aVar) {
        this.sF = aVar.isSuccess();
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        j jVar;
        p pVar;
        super.ar();
        if (this.qt.oP != null) {
            this.qt.oP.a(this);
        }
        AdTemplate adTemplate = this.qt.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = d.cb(adTemplate);
        this.cp = this.qt.oR;
        this.qt.b(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.c.fj().a(this.mRewardVerifyListener);
        this.uY.setCallerContext(this.qt);
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_playend_native_jinniu);
        if (viewStub != null) {
            jVar = new j(this.qt, viewStub);
        } else {
            jVar = new j(this.qt, (ViewGroup) findViewById(R.id.ksad_reward_jinniu_end_card_root));
        }
        this.vb = jVar;
        ViewStub viewStub2 = (ViewStub) findViewById(R.id.ksad_playend_native_play_again);
        if (viewStub2 != null) {
            pVar = new p(this.mAdTemplate, this.qt, viewStub2, this.mDetailVideoView);
        } else {
            pVar = new p(this.mAdTemplate, this.qt, (ViewGroup) findViewById(R.id.ksad_play_again_end_root), this.mDetailVideoView);
        }
        this.vd = pVar;
        iq();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.uY = (TailFrameView) findViewById(R.id.ksad_video_tail_frame);
        DetailVideoView detailVideoView = (DetailVideoView) findViewById(R.id.ksad_video_player);
        this.mDetailVideoView = detailVideoView;
        if (detailVideoView.getLayoutTransition() != null) {
            this.mDetailVideoView.getLayoutTransition().enableTransitionType(4);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (this.qt.oP != null) {
            this.qt.oP.b(this);
        }
        com.kwad.components.ad.reward.c.fj().b(this.mRewardVerifyListener);
        it();
        this.qt.c(this.mPlayEndPageListener);
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null) {
            int i = this.vf;
            if (i != Integer.MIN_VALUE) {
                detailVideoView.updateTextureViewGravity(i);
            }
            com.kwad.sdk.core.d.b.d("RewardPlayEndNativeCardPresenter", "onUnbind:  videoOriginalWidth :" + this.ve);
            int i2 = this.ve;
            if (i2 != Integer.MIN_VALUE) {
                R(i2);
            }
            Drawable drawable = this.vg;
            if (drawable != null) {
                this.mDetailVideoView.setBackground(drawable);
            }
        }
        p pVar = this.vd;
        if (pVar != null) {
            pVar.jW();
        }
    }
}
