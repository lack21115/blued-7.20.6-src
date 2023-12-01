package com.kwad.components.ad.interstitial;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.expressad.foundation.g.a.f;
import com.kwad.components.ad.interstitial.e.g;
import com.kwad.components.ad.interstitial.e.h;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.bh;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/d.class */
public final class d extends com.kwad.components.core.l.e {
    private com.kwad.components.ad.interstitial.e.a hJ;
    private boolean hK;
    private com.kwad.components.ad.interstitial.d.b hL;
    private final KsAdVideoPlayConfig hM;
    private KsInterstitialAd.AdInteractionListener hN;
    private final h hO;
    private final AdTemplate mAdTemplate;
    private bh mTimerHelper;

    public d(Activity activity, AdTemplate adTemplate, KsVideoPlayConfig ksVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        super(activity);
        this.hO = new h() { // from class: com.kwad.components.ad.interstitial.d.1
            @Override // com.kwad.components.ad.interstitial.e.h
            public final void j(boolean z) {
                if (d.this.hK) {
                    Activity activity2 = d.this.mActivity;
                    com.kwad.sdk.core.b.b.vS();
                    if (activity2 == com.kwad.sdk.core.b.b.getCurrentActivity()) {
                        com.kwad.sdk.core.report.a.j(d.this.mAdTemplate, z ? 2 : 1);
                        d.this.cp();
                    }
                }
            }
        };
        this.hN = adInteractionListener;
        this.hM = new KsAdVideoPlayConfig.Builder().videoSoundEnable(ksVideoPlayConfig != null && ksVideoPlayConfig.isVideoSoundEnable()).dataFlowAutoStart(com.kwad.components.ad.interstitial.kwai.b.cH()).build();
        this.mAdTemplate = adTemplate;
    }

    private boolean cn() {
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        return com.kwad.sdk.core.response.a.a.bY(cb) && !co() && com.kwad.components.ad.interstitial.a.a.cO() < com.kwad.sdk.core.response.a.a.cb(cb);
    }

    private boolean co() {
        return com.kwad.sdk.core.response.a.b.aL(this.mAdTemplate) && com.kwad.components.ad.interstitial.b.a.cQ() < com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.acC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cp() {
        int bV = com.kwad.sdk.core.response.a.a.bV(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate));
        this.hJ = cn() ? new com.kwad.components.ad.interstitial.aggregate.b(this.mContext) : (TextUtils.isEmpty(com.kwad.sdk.core.response.a.b.bg(this.mAdTemplate)) || !ai.DL()) ? new com.kwad.components.ad.interstitial.e.c(this.mContext) : bV == 2 ? new com.kwad.components.ad.interstitial.e.e(this.mContext) : bV == 1 ? new com.kwad.components.ad.interstitial.e.d(this.mContext) : new com.kwad.components.ad.interstitial.e.c(this.mContext);
        this.hJ.a(this.mAdTemplate, this, this.hM, this.hN);
        this.yE.removeAllViews();
        this.yE.addView(this.hJ);
        cq();
    }

    private void cq() {
        com.kwad.components.ad.interstitial.d.b bVar = new com.kwad.components.ad.interstitial.d.b(this.hJ, 100);
        this.hL = bVar;
        bVar.a(new com.kwad.sdk.core.g.c() { // from class: com.kwad.components.ad.interstitial.d.2
            @Override // com.kwad.sdk.core.g.c
            public final void onPageInvisible() {
                d.this.getTimerHelper().EY();
            }

            @Override // com.kwad.sdk.core.g.c
            public final void onPageVisible() {
                d.this.getTimerHelper().EX();
            }
        });
        this.hL.rD();
    }

    @Override // com.kwad.components.core.l.e
    public final ViewGroup cm() {
        g gVar = new g(this.mContext);
        gVar.setOrientationChangeListener(this.hO);
        return gVar;
    }

    @Override // com.kwad.components.core.l.e, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        com.kwad.sdk.kwai.kwai.c.sZ().tc();
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.hN;
        if (adInteractionListener != null) {
            adInteractionListener.onPageDismiss();
        }
    }

    @Override // com.kwad.components.core.l.e
    public final void g(View view) {
        cp();
        com.kwad.sdk.g.a.V(f.d, "show");
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_INTERSTITIAL, "adShowSuccess").report();
    }

    @Override // com.kwad.components.core.l.e
    public final int getLayoutId() {
        return 0;
    }

    public final bh getTimerHelper() {
        if (this.mTimerHelper == null) {
            this.mTimerHelper = new bh();
        }
        return this.mTimerHelper;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        if (com.kwad.components.ad.interstitial.kwai.b.cL()) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.components.ad.interstitial.d.b bVar = this.hL;
        if (bVar != null) {
            bVar.release();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.hK = z;
        com.kwad.components.ad.interstitial.e.a aVar = this.hJ;
        if (aVar != null) {
            if (z) {
                aVar.cu();
            } else {
                aVar.cv();
            }
        }
    }

    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.hN = adInteractionListener;
        com.kwad.components.ad.interstitial.e.a aVar = this.hJ;
        if (aVar != null) {
            aVar.setAdInteractionListener(adInteractionListener);
        }
    }
}
