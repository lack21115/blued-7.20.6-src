package com.kwad.components.ad.reward.presenter;

import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bi;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/q.class */
public final class q extends com.kwad.components.ad.reward.presenter.a implements com.kwad.components.ad.reward.d.f, com.kwad.components.ad.reward.d.h, ai.b {
    private com.kwad.components.core.webview.a.d.e gz;
    private boolean sF;
    private a sG;
    private p sH;
    private n sI;
    private o sJ;
    private int sK;
    private boolean sL;
    private boolean sM;
    private boolean sN;
    private float sq;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/q$a.class */
    final class a extends com.kwad.components.core.video.j {
        private long sP;
        private long videoDuration;

        private a() {
        }

        /* synthetic */ a(q qVar, byte b) {
            this();
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j, long j2) {
            super.onVideoPlayProgress(j, j2);
            this.sP = j2;
            this.videoDuration = j;
            if (q.this.qt.fE()) {
                return;
            }
            q.this.a(j, j2, false);
        }
    }

    public q(AdTemplate adTemplate) {
        this(adTemplate, true, true);
    }

    public q(AdTemplate adTemplate, boolean z, boolean z2) {
        this.sK = 0;
        this.sL = false;
        this.sM = true;
        this.sN = true;
        this.sM = z;
        this.sN = z2;
        if (com.kwad.sdk.core.response.a.a.bv(com.kwad.sdk.core.response.a.d.cb(adTemplate))) {
            o oVar = new o();
            this.sJ = oVar;
            a(oVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(com.kwad.components.ad.reward.d.f fVar) {
        return getPriority() - fVar.getPriority();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2, boolean z) {
        p pVar;
        if (hG() && j2 >= 10000 && ((float) j2) >= ((float) j) * this.sq) {
            if (!com.kwad.components.ad.reward.kwai.b.gE()) {
                n nVar = this.sI;
                if (nVar != null) {
                    nVar.M(!z);
                    this.sK = 2;
                }
            } else if (this.sL || (pVar = this.sH) == null) {
            } else {
                pVar.hB();
                this.sK = 1;
                this.sL = true;
            }
        }
    }

    private com.kwad.components.core.webview.a.d.e bW() {
        if (this.gz == null) {
            this.gz = new com.kwad.components.core.webview.a.d.e() { // from class: com.kwad.components.ad.reward.presenter.q.2
                @Override // com.kwad.components.core.webview.a.d.b
                public final void u(String str) {
                    q.this.hF();
                }
            };
        }
        return this.gz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hF() {
        if (this.sN) {
            p pVar = new p(this);
            this.sH = pVar;
            a((Presenter) pVar, true);
        }
        if (this.sM) {
            n nVar = new n(this);
            this.sI = nVar;
            a((Presenter) nVar, true);
        }
        a(new com.kwad.components.ad.reward.presenter.e.a(), true);
    }

    private boolean hG() {
        return this.sF;
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void a(PlayableSource playableSource, com.kwad.components.ad.reward.d.l lVar) {
        n nVar;
        p pVar;
        this.qt.A(true);
        if (this.sK == 1 && (pVar = this.sH) != null) {
            pVar.hC();
        } else if (this.sK != 2 || (nVar = this.sI) == null) {
        } else {
            nVar.hide();
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.ai.b
    public final void a(ai.a aVar) {
        a aVar2;
        boolean isSuccess = aVar.isSuccess();
        this.sF = isSuccess;
        if (!isSuccess || (aVar2 = this.sG) == null) {
            return;
        }
        a(aVar2.videoDuration, this.sG.sP, false);
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.qt.mAdTemplate);
        if (com.kwad.sdk.core.response.a.a.bv(cb)) {
            if (this.qt.pg) {
                com.kwad.components.core.webview.a.c.a.rn().a(bW());
            } else {
                bi.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.q.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        q.this.hF();
                    }
                }, 100L);
            }
        } else if (!com.kwad.sdk.core.response.a.a.by(cb)) {
            com.kwad.components.core.m.a.pb().O(this.qt.mAdTemplate);
        }
        this.qt.b(this);
        if (this.qt.oP != null) {
            this.qt.oP.a(this);
        }
        boolean gD = com.kwad.components.ad.reward.kwai.b.gD();
        this.sq = com.kwad.components.ad.reward.kwai.b.gC();
        if (gD) {
            this.sG = new a(this, (byte) 0);
            this.qt.oN.a(this.sG, null);
        }
        com.kwad.components.ad.reward.b.ff().a(this);
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final void bM() {
        RewardActionBarControl.ShowActionBarResult ia = this.qt.oQ.ia();
        if (ia != null) {
            ia.equals(RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_PLAYABLE_PORTRAIT);
        }
        if (this.sJ == null || this.qt.fP()) {
            return;
        }
        if (hG()) {
            this.sJ.e(PlayableSource.PLAY_FINISHED_NORMAL);
        } else {
            this.sJ.hA();
        }
    }

    public final boolean bX() {
        boolean fV = this.qt.fV();
        if (!this.qt.fE() || fV) {
            return false;
        }
        com.kwad.components.ad.reward.b.ff().fg();
        this.qt.A(false);
        return true;
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void ca() {
        this.qt.A(false);
        a aVar = this.sG;
        if (aVar == null || this.sK != 2) {
            return;
        }
        a(aVar.videoDuration, this.sG.sP, true);
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void cb() {
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final int getPriority() {
        return 0;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qt.c(this);
        if (this.qt.oP != null) {
            this.qt.oP.b(this);
        }
        if (this.sG != null) {
            this.qt.oN.b(this.sG, null);
        }
        com.kwad.components.ad.reward.b.ff().b(this);
        com.kwad.components.core.webview.a.c.a.rn().b(this.gz);
    }
}
