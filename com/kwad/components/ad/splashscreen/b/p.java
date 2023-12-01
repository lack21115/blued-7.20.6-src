package com.kwad.components.ad.splashscreen.b;

import android.text.TextUtils;
import android.widget.ImageView;
import com.kwad.components.ad.splashscreen.widget.SkipView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.h;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/b/p.class */
public final class p extends e implements com.kwad.sdk.core.g.c {
    private SkipView Dn;
    private ImageView gT;
    private AdInfo mAdInfo;
    private volatile boolean Dl = false;
    private boolean Dm = false;
    private boolean Ci = false;
    private boolean Cl = false;
    private h.a gV = new h.a() { // from class: com.kwad.components.ad.splashscreen.b.p.1
        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeOccupied() {
            p.this.Dl = false;
            if (p.this.gT != null) {
                p.this.gT.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.p.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (p.this.Cg.BG != null) {
                            p.this.Cg.BG.setAudioEnabled(p.this.Dl, false);
                        }
                        if (p.this.Cg != null) {
                            AdInfo cb = com.kwad.sdk.core.response.a.d.cb(p.this.Cg.mAdTemplate);
                            boolean z = p.this.Dl;
                            AdInfo.AdSplashInfo adSplashInfo = cb.adSplashInfo;
                            String str = z ? adSplashInfo.speakerIconUrl : adSplashInfo.speakerMuteIconUrl;
                            if (TextUtils.isEmpty(str)) {
                                p.this.gT.setImageDrawable(p.this.getContext().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                            } else {
                                KSImageLoader.loadImage(p.this.gT, str, p.this.Cg.mAdTemplate);
                            }
                            p.this.gT.setSelected(false);
                        }
                    }
                });
            }
        }

        @Override // com.kwad.sdk.utils.h.a
        public final void onAudioBeReleased() {
        }
    };
    private com.kwad.components.core.video.i Do = new com.kwad.components.core.video.i() { // from class: com.kwad.components.ad.splashscreen.b.p.2
        private boolean Dr = false;
        private String Ds = com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.a.a.BQ);

        @Override // com.kwad.components.core.video.i
        public final void onVideoPlayBufferingPaused() {
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPlayBufferingPlaying() {
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
            if (this.Dr) {
                return;
            }
            p.this.Cg.kw();
            this.Dr = true;
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPlayError(int i, int i2) {
            if (p.this.Cl) {
                return;
            }
            p.this.Cg.f(0, "onVideoPlayError");
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPlayPaused() {
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j, final long j2) {
            p.this.Cg.ab(((int) j2) / 1000);
            final int min = Math.min(p.this.mAdInfo.adSplashInfo.videoDisplaySecond, ((int) j) / 1000);
            final String str = this.Ds;
            p pVar = p.this;
            if (p.a(pVar, pVar.mAdInfo)) {
                p.this.Dn.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.p.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        int i = (int) (((min * 1000) - j2) / 1000);
                        int i2 = i;
                        if (i <= 0) {
                            i2 = 1;
                        }
                        p.this.Dn.ag(str + i2);
                    }
                });
            }
            float f = ((float) j2) / 1000.0f;
            if (min <= 0 || f + 0.5d <= min - 1 || this.Dr) {
                return;
            }
            p pVar2 = p.this;
            if (p.a(pVar2, pVar2.mAdInfo)) {
                p.this.Cg.kw();
                this.Dr = true;
            }
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPlayStart() {
            if (p.this.Cg.BG != null) {
                p.this.Cg.BG.setAudioEnabled(p.this.Dl, false);
            }
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPlaying() {
            if (p.this.Dm) {
                return;
            }
            p.this.Cg.kv();
            if (p.this.Cg.BG != null) {
                p.this.Cg.BG.aj(true);
                p.this.Cg.BG.setAudioEnabled(p.this.Dl, true);
            }
            p.b(p.this, true);
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPrepared() {
        }

        @Override // com.kwad.components.core.video.i
        public final void onVideoPreparing() {
        }
    };

    private static void a(SkipView skipView, AdInfo adInfo) {
        skipView.setTimerBtnVisible(com.kwad.sdk.core.response.a.a.cf(adInfo));
    }

    static /* synthetic */ boolean a(p pVar, AdInfo adInfo) {
        return q(adInfo);
    }

    static /* synthetic */ boolean b(p pVar, boolean z) {
        pVar.Dm = true;
        return true;
    }

    private static boolean q(AdInfo adInfo) {
        return !com.kwad.sdk.core.response.a.a.cc(adInfo);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0145  */
    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void ar() {
        /*
            Method dump skipped, instructions count: 372
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.splashscreen.b.p.ar():void");
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.Cl = true;
    }

    @Override // com.kwad.sdk.core.g.c
    public final void onPageInvisible() {
        if (this.Cg.BG != null) {
            this.Cg.BG.pause();
        }
    }

    @Override // com.kwad.sdk.core.g.c
    public final void onPageVisible() {
        if (this.Ci) {
            return;
        }
        this.Ci = true;
        com.kwad.components.ad.splashscreen.local.c.R(getContext());
        com.kwad.components.core.r.b.pK().a(this.Cg.mAdTemplate, null, null);
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_SPLASH, "adShowSuccess").report();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (this.Cg.BG != null) {
            this.Cg.BG.b(this.Do);
            this.Cg.BG.b(this.gV);
        }
        if (this.Dn.getHandler() != null) {
            this.Dn.getHandler().removeCallbacksAndMessages(null);
        }
        this.Cg.BH.b(this);
    }
}
