package com.kwad.components.ad.reward.k;

import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.ab;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.bb;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/k/e.class */
public class e extends com.kwad.sdk.core.download.kwai.a implements ab.b, ai.b {
    private KsAdWebView cS;
    private com.kwad.components.core.webview.a cU;
    private com.kwad.sdk.core.webview.b cV;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private final com.kwad.components.ad.reward.d.j mRewardVerifyListener = new com.kwad.components.ad.reward.d.j() { // from class: com.kwad.components.ad.reward.k.e.1
        @Override // com.kwad.components.ad.reward.d.j
        public final void onRewardVerify() {
            if (e.this.xY != null) {
                e.this.xY.al(true);
            }
        }
    };
    private com.kwad.sdk.core.webview.c.kwai.a mWebCardClickListener;
    private View xX;
    private as xY;
    private f xZ;

    public e(KsAdWebView ksAdWebView, View view, com.kwad.components.core.d.b.c cVar, com.kwad.sdk.core.webview.c.kwai.a aVar) {
        this.xX = view;
        this.cS = ksAdWebView;
        this.mApkDownloadHelper = cVar;
        this.mWebCardClickListener = aVar;
    }

    private void a(com.kwad.components.core.webview.a aVar, String str) {
        aVar.a(new com.kwad.components.core.webview.jshandler.p(this.cV, this.mApkDownloadHelper, this.mWebCardClickListener));
        aVar.a(new com.kwad.components.core.webview.jshandler.v(this.cV));
        aVar.a(new com.kwad.components.core.webview.jshandler.u(this.cV));
        aVar.a(new ai(this, str));
        as asVar = new as();
        this.xY = asVar;
        aVar.a(asVar);
        aVar.a(new ac(this.cV));
        aVar.a(new y(this.cV));
        aVar.a(new com.kwad.components.core.webview.a.kwai.f());
        aVar.a(new ab(this.cV, this));
        aVar.a(new aq(this.cV, this.mApkDownloadHelper));
        aVar.a(new com.kwad.components.ad.reward.f.b(this.cS.getContext(), this.mAdTemplate, PlayableSource.ACTIONBAR_CLICK));
    }

    private void aI() {
        com.kwad.components.core.webview.a aVar = this.cU;
        if (aVar != null) {
            aVar.destroy();
            this.cU = null;
        }
    }

    private void ah(boolean z) {
        com.kwad.sdk.core.d.b.d("BottomCardWebViewHelper", "switchWebView: " + z);
        KsAdWebView ksAdWebView = this.cS;
        if (ksAdWebView == null) {
            return;
        }
        ksAdWebView.setVisibility(z ? 0 : 8);
    }

    private void b(AdTemplate adTemplate, ViewGroup viewGroup) {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.cV = bVar;
        bVar.setAdTemplate(adTemplate);
        this.cV.mScreenOrientation = 0;
        this.cV.app = null;
        this.cV.LD = viewGroup;
        this.cV.Lc = this.cS;
        this.cV.mReportExtData = null;
        this.cV.apr = true;
    }

    private KsAdWebView.d getWebErrorListener() {
        return new KsAdWebView.d() { // from class: com.kwad.components.ad.reward.k.e.2
            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageFinished() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onReceivedHttpError(int i, String str, String str2) {
                com.kwad.sdk.core.d.b.d("BottomCardWebViewHelper", "onReceivedHttpError: " + i + ", " + str);
                e.this.jM();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jM() {
        View view = this.xX;
        if (view != null) {
            view.setVisibility(0);
        }
        ah(false);
    }

    private void k(String str, int i) {
        f fVar = this.xZ;
        if (fVar != null) {
            fVar.i(str, i);
        }
    }

    private void v(String str) {
        if (bb.isNullString(str)) {
            jM();
            return;
        }
        aI();
        this.cS.setClientConfig(this.cS.getClientConfig().ct(this.mAdTemplate).b(getWebErrorListener()));
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.cS);
        this.cU = aVar;
        a(aVar, str);
        this.cS.addJavascriptInterface(this.cU, "KwaiAd");
        this.cS.loadUrl(str);
    }

    public final void a(f fVar) {
        this.xZ = fVar;
    }

    @Override // com.kwad.components.core.webview.jshandler.ab.b
    public final void a(ab.a aVar) {
        com.kwad.sdk.core.d.b.d("BottomCardWebViewHelper", "onAdFrameValid : " + aVar.toJson());
    }

    @Override // com.kwad.components.core.webview.jshandler.ai.b
    public final void a(ai.a aVar) {
        com.kwad.sdk.core.d.b.d("BottomCardWebViewHelper", getClass().getName() + " updatePageStatus: " + aVar);
        if (aVar.status == 1) {
            ah(true);
        } else {
            jM();
        }
    }

    public final void a(AdTemplate adTemplate, ViewGroup viewGroup) {
        KsAdWebView ksAdWebView = this.cS;
        if (ksAdWebView != null) {
            ksAdWebView.setBackgroundColor(0);
            if (this.cS.getBackground() != null) {
                this.cS.getBackground().setAlpha(0);
            }
        }
        com.kwad.components.ad.reward.c.fj().a(this.mRewardVerifyListener);
        this.mAdTemplate = adTemplate;
        b(adTemplate, viewGroup);
        v(com.kwad.sdk.core.response.a.b.aP(this.mAdTemplate));
        com.kwad.components.core.d.b.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.b(this);
        }
    }

    public final void jL() {
        com.kwad.components.core.d.b.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this);
        }
        com.kwad.components.ad.reward.c.fj().b(this.mRewardVerifyListener);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFailed() {
        AdTemplate adTemplate = this.mAdTemplate;
        k(adTemplate != null ? com.kwad.sdk.core.response.a.a.aw(com.kwad.sdk.core.response.a.d.cb(adTemplate)) : "立即下载", 100);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFinished() {
        AdTemplate adTemplate = this.mAdTemplate;
        k(adTemplate == null ? "" : com.kwad.sdk.core.response.a.a.aH(adTemplate), 100);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onIdle() {
        AdTemplate adTemplate = this.mAdTemplate;
        k(adTemplate != null ? com.kwad.sdk.core.response.a.a.aw(com.kwad.sdk.core.response.a.d.cb(adTemplate)) : "立即下载", 100);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onInstalled() {
        AdTemplate adTemplate = this.mAdTemplate;
        k(adTemplate != null ? com.kwad.sdk.core.response.a.a.T(com.kwad.sdk.core.response.a.d.cb(adTemplate)) : "立即打开", 100);
    }

    @Override // com.kwad.sdk.core.download.kwai.a
    public final void onPaused(int i) {
        k(com.kwad.sdk.core.response.a.a.bz(i), i);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onProgressUpdate(int i) {
        if (i != 0) {
            k(com.kwad.sdk.core.response.a.a.by(i), i);
        }
    }
}
