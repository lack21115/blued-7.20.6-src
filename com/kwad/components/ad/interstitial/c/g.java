package com.kwad.components.ad.interstitial.c;

import com.kwad.components.core.video.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bi;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/c/g.class */
public final class g extends b implements a.c {
    private static long ld = 1000;
    private c jt;
    private a le;
    private int lf;
    private AdTemplate mAdTemplate;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/c/g$a.class */
    final class a implements Runnable {
        private int lg;
        private boolean lh;
        private boolean li;

        private a() {
            this.lg = Integer.MIN_VALUE;
            this.lh = false;
            this.li = false;
        }

        /* synthetic */ a(g gVar, byte b) {
            this();
        }

        public final void q(boolean z) {
            this.li = true;
        }

        public final void r(boolean z) {
            this.lh = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.li) {
                return;
            }
            if (!this.lh) {
                if (this.lg == Integer.MIN_VALUE) {
                    this.lg = g.this.lf;
                }
                if (this.lg < 0) {
                    return;
                }
                com.kwad.sdk.core.d.b.d("InterstitialPlayablePresenter", g.this.toString() + ", this: " + toString() + " PlayableTimerRunnable run : " + this.lg);
                g.this.H(this.lg);
                this.lg = this.lg - 1;
            }
            bi.a(this, null, g.ld);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(int i) {
        if (this.jt.ju == null) {
            return;
        }
        if (i != 0) {
            this.jt.ju.b(true, i);
        } else if (this.jt.da()) {
        } else {
            this.jt.b(getContext(), this.mAdTemplate);
            dx();
            c cVar = this.jt;
            cVar.a(true, -1, cVar.eN);
        }
    }

    private void dx() {
        if (this.jt.eN != null) {
            this.jt.eN.release();
        }
        this.jt.hU.dismiss();
        if (this.jt.jy || this.jt.hN == null) {
            return;
        }
        this.jt.hN.onAdClosed();
    }

    @Override // com.kwad.components.ad.interstitial.c.b, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        com.kwad.sdk.core.d.b.d("InterstitialPlayablePresenter", this + " onBind");
        c cVar = (c) Bh();
        this.jt = cVar;
        AdTemplate adTemplate = cVar.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        long j = cb.adInsertScreenInfo.autoCloseTime;
        if (j > 0) {
            this.lf = (int) Math.min(com.kwad.components.ad.interstitial.kwai.b.b(cb), j);
        } else {
            this.lf = com.kwad.components.ad.interstitial.kwai.b.b(cb);
        }
        if (this.jt.ju != null) {
            this.jt.ju.b(true, this.lf);
        }
        if (com.kwad.sdk.core.response.a.a.aU(cb)) {
            this.le = null;
            this.jt.a(this);
            return;
        }
        a aVar = new a(this, (byte) 0);
        this.le = aVar;
        bi.a(aVar, null, 1000L);
    }

    @Override // com.kwad.components.core.video.a.c
    public final void bt() {
        if (this.jt.da()) {
            return;
        }
        this.jt.b(getContext(), this.mAdTemplate);
        dx();
    }

    @Override // com.kwad.components.ad.interstitial.c.b
    public final void cT() {
        super.cT();
        a aVar = this.le;
        if (aVar != null) {
            aVar.r(false);
        }
    }

    @Override // com.kwad.components.ad.interstitial.c.b
    public final void cU() {
        super.cU();
        a aVar = this.le;
        if (aVar != null) {
            aVar.r(true);
        }
    }

    @Override // com.kwad.components.core.video.a.c
    public final void d(long j) {
        H(this.lf - ((int) (j / 1000)));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.b.d("InterstitialPlayablePresenter", this + " onUnbind");
        this.jt.b(this);
        a aVar = this.le;
        if (aVar != null) {
            aVar.q(true);
            bi.b(this.le);
            this.le = null;
        }
    }

    @Override // com.kwad.components.core.video.a.c
    public final void onVideoPlayStart() {
    }

    @Override // com.kwad.components.core.video.a.c
    public final void onVideoPlaying() {
    }
}
