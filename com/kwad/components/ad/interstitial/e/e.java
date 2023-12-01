package com.kwad.components.ad.interstitial.e;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.kwad.components.ad.interstitial.c.c;
import com.kwad.components.ad.interstitial.e.f;
import com.kwad.components.core.webview.a.j;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.j.k;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/e/e.class */
public final class e extends a {
    private KsAdVideoPlayConfig dZ;
    private com.kwad.components.core.webview.a.d.e gG;
    protected KsInterstitialAd.AdInteractionListener hN;
    private com.kwad.components.ad.interstitial.d hU;
    private int jI;
    protected com.kwad.components.ad.interstitial.c.c jt;
    private boolean jy;
    private c.a jz;
    protected com.kwad.components.ad.interstitial.c.b lU;
    private boolean lV;
    protected ViewGroup lW;
    protected AdInfo mAdInfo;
    protected AdTemplate mAdTemplate;

    public e(Context context) {
        this(context, null);
    }

    private e(Context context, AttributeSet attributeSet) {
        super(context, null);
        this.jI = -1;
        this.gG = new com.kwad.components.core.webview.a.d.e() { // from class: com.kwad.components.ad.interstitial.e.e.1
            @Override // com.kwad.components.core.webview.a.d.b
            public final void u(String str) {
                if (j.b("ksad-interstitial-card", e.this.mAdTemplate).equals(str)) {
                    e.a(e.this, false);
                    if (e.this.lU != null) {
                        e.this.lU.jW();
                    }
                    e eVar = e.this;
                    eVar.lU = eVar.ev();
                    e.this.lU.E(e.this.lW);
                    e.this.lU.f(e.this.jt);
                }
            }
        };
        this.lW = (ViewGroup) k.inflate(context, getLayoutId(), this);
    }

    private f a(Context context, AdInfo adInfo, com.kwad.components.ad.interstitial.c.c cVar) {
        boolean a2 = com.kwad.components.ad.interstitial.c.c.a(this.mContext, adInfo);
        f.a aVar = new f.a();
        aVar.v(a2);
        aVar.w(!cVar.M(context) && com.kwad.components.ad.interstitial.kwai.b.cI());
        aVar.I(com.kwad.components.ad.interstitial.kwai.b.cJ());
        boolean z = true;
        if (com.kwad.sdk.core.response.a.a.aO(adInfo)) {
            z = !ai.DL();
        }
        aVar.x(z);
        return new f(context, aVar);
    }

    static /* synthetic */ boolean a(e eVar, boolean z) {
        eVar.lV = false;
        return false;
    }

    private com.kwad.components.ad.interstitial.c.c eu() {
        com.kwad.components.ad.interstitial.c.c cVar = new com.kwad.components.ad.interstitial.c.c();
        cVar.mAdTemplate = this.mAdTemplate;
        cVar.hN = this.hN;
        cVar.hU = this.hU;
        cVar.mApkDownloadHelper = new com.kwad.components.core.d.b.c(this.mAdTemplate);
        cVar.dZ = this.dZ;
        cVar.eN = new com.kwad.sdk.core.video.videoview.a(this.mContext);
        cVar.jC = (KSFrameLayout) this.lW.findViewById(R.id.ksad_container);
        cVar.hL = new com.kwad.components.ad.interstitial.d.b(cVar.jC, 100);
        cVar.hL.rD();
        cVar.jI = this.jI;
        cVar.jy = this.jy;
        cVar.jz = this.jz;
        cVar.gG = this.gG;
        cVar.ju = a(this.mContext, com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate), cVar);
        return cVar;
    }

    @Override // com.kwad.components.ad.interstitial.e.a
    public final void a(AdTemplate adTemplate, com.kwad.components.ad.interstitial.d dVar, KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        adTemplate.realShowType = 2;
        this.dZ = ksAdVideoPlayConfig;
        this.hU = dVar;
        this.lV = com.kwad.sdk.core.response.a.b.bu(this.mAdTemplate);
        this.hN = adInteractionListener;
        this.jt = eu();
        if (this.lU == null) {
            this.lU = ev();
        }
        this.lU.E(this.lW);
        this.lU.f(this.jt);
    }

    @Override // com.kwad.components.ad.interstitial.e.a
    public final void cu() {
        com.kwad.components.ad.interstitial.c.b bVar = this.lU;
        if (bVar != null) {
            bVar.cT();
        }
    }

    @Override // com.kwad.components.ad.interstitial.e.a
    public final void cv() {
        com.kwad.components.ad.interstitial.c.b bVar = this.lU;
        if (bVar != null) {
            bVar.cU();
        }
    }

    public final com.kwad.components.ad.interstitial.c.b ev() {
        com.kwad.components.ad.interstitial.c.kwai.b gVar;
        com.kwad.components.ad.interstitial.c.b bVar = new com.kwad.components.ad.interstitial.c.b();
        if (!this.lV) {
            bVar.a(new com.kwad.components.ad.interstitial.c.d());
            if (com.kwad.sdk.core.response.a.a.aU(this.mAdInfo)) {
                bVar.a(new com.kwad.components.ad.interstitial.c.j());
            }
            bVar.a(new com.kwad.components.ad.interstitial.c.k());
            bVar.a(new com.kwad.components.ad.interstitial.c.f());
            if (com.kwad.sdk.core.response.a.a.aH(this.mAdInfo)) {
                bVar.a(new com.kwad.components.ad.interstitial.c.a());
            }
            if (this.jt.M(getContext())) {
                gVar = new com.kwad.components.ad.interstitial.c.g();
            }
            bVar.a(new com.kwad.components.ad.interstitial.c.i());
            return bVar;
        }
        gVar = new com.kwad.components.ad.interstitial.c.kwai.b();
        bVar.a(gVar);
        bVar.a(new com.kwad.components.ad.interstitial.c.i());
        return bVar;
    }

    protected final int getLayoutId() {
        return R.layout.ksad_interstitial_vertical;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.components.ad.interstitial.c.c cVar = this.jt;
        if (cVar != null) {
            cVar.release();
        }
        com.kwad.components.ad.interstitial.c.b bVar = this.lU;
        if (bVar != null) {
            bVar.destroy();
        }
    }

    public final void setAdConvertListener(c.a aVar) {
        this.jz = aVar;
        com.kwad.components.ad.interstitial.c.c cVar = this.jt;
        if (cVar != null) {
            cVar.jz = aVar;
        }
    }

    @Override // com.kwad.components.ad.interstitial.e.a
    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.hN = adInteractionListener;
        com.kwad.components.ad.interstitial.c.c cVar = this.jt;
        if (cVar != null) {
            cVar.hN = adInteractionListener;
        }
    }

    public final void setAggregateAdView(boolean z) {
        this.jy = z;
        com.kwad.components.ad.interstitial.c.c cVar = this.jt;
        if (cVar != null) {
            cVar.jy = z;
        }
    }

    public final void setAggregateShowTriggerType(int i) {
        this.jI = i;
        com.kwad.components.ad.interstitial.c.c cVar = this.jt;
        if (cVar != null) {
            cVar.jI = i;
        }
    }
}
