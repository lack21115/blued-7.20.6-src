package com.kwad.components.ad.splashscreen.b;

import android.content.Context;
import android.os.SystemClock;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.WebView;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.ap;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.components.core.webview.jshandler.v;
import com.kwad.sdk.R;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bi;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/b/o.class */
public final class o extends e implements com.kwad.components.ad.splashscreen.e, com.kwad.components.ad.splashscreen.g {
    private com.kwad.components.ad.splashscreen.e.b Dd;
    private boolean De;
    private long Dg;
    private an Dh;
    private KsAdWebView cS;
    private com.kwad.components.core.webview.a cU;
    private com.kwad.sdk.core.webview.b cV;
    private com.kwad.sdk.core.f.d ef;
    private Vibrator eg;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private boolean Df = false;
    private boolean Di = false;
    private final Runnable Dj = new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.o.1
        @Override // java.lang.Runnable
        public final void run() {
            o.a(o.this, true);
            com.kwad.components.ad.splashscreen.monitor.a.a(com.kwad.sdk.core.response.a.b.aN(o.this.mAdTemplate), SystemClock.elapsedRealtime() - o.this.Dg, 1, "");
            o.this.li();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public Vibrator F(Context context) {
        if (context != null) {
            return (Vibrator) getContext().getSystemService(Context.VIBRATOR_SERVICE);
        }
        return null;
    }

    private void a(WebView webView, String str) {
        aI();
        webView.getSettings().setAllowFileAccess(true);
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(webView);
        this.cU = aVar;
        a(aVar, str);
        webView.addJavascriptInterface(this.cU, "KwaiAd");
    }

    private void a(com.kwad.components.core.webview.a aVar, final String str) {
        aVar.a(new aq(this.cV, this.Cg.mApkDownloadHelper));
        aVar.a(dz());
        aVar.a(dy());
        aVar.a(new v(this.cV));
        aVar.a(new com.kwad.components.core.webview.a.kwai.f());
        aVar.a(new ai(new ai.b() { // from class: com.kwad.components.ad.splashscreen.b.o.7
            @Override // com.kwad.components.core.webview.jshandler.ai.b
            public final void a(ai.a aVar2) {
                com.kwad.sdk.core.d.b.d("SplashWebViewPresenter", "updatePageStatus: " + aVar2);
                bi.b(o.this.Dj);
                if (aVar2.status != 1) {
                    com.kwad.components.ad.splashscreen.monitor.a.a(str, SystemClock.elapsedRealtime() - o.this.Dg, 3, "");
                    o.this.li();
                    return;
                }
                if (!o.this.Di && o.this.Dh != null) {
                    o.this.Dh.qZ();
                    o.this.Dh.ra();
                }
                if (com.kwad.sdk.core.response.a.b.dh(o.this.mAdInfo)) {
                    o.this.lh();
                }
            }
        }, str));
        aVar.a(new ap(new ap.a() { // from class: com.kwad.components.ad.splashscreen.b.o.8
            @Override // com.kwad.components.core.webview.jshandler.ap.a
            public final void bJ() {
                o.this.bB();
            }
        }));
        aVar.a(new ac(this.cV));
        an anVar = new an();
        this.Dh = anVar;
        aVar.a(anVar);
    }

    private void a(KsAdWebView ksAdWebView, final String str) {
        ksAdWebView.setBackgroundColor(0);
        ksAdWebView.getBackground().setAlpha(0);
        ksAdWebView.setVisibility(0);
        aF();
        a((WebView) ksAdWebView, str);
        ksAdWebView.setClientConfig(ksAdWebView.getClientConfig().ct(this.Cg.mAdTemplate).b(new com.kwad.components.a() { // from class: com.kwad.components.ad.splashscreen.b.o.6
            @Override // com.kwad.components.a, com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageFinished() {
                super.onPageFinished();
                com.kwad.components.ad.splashscreen.monitor.a.d(str, SystemClock.elapsedRealtime() - o.this.Dg);
            }

            @Override // com.kwad.components.a, com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onReceivedHttpError(int i, String str2, String str3) {
                super.onReceivedHttpError(i, str2, str3);
                bi.b(o.this.Dj);
                o.this.li();
                com.kwad.components.ad.splashscreen.monitor.a.a(str, SystemClock.elapsedRealtime() - o.this.Dg, 2, str2);
            }
        }));
        com.kwad.components.ad.splashscreen.monitor.a.aa(str);
        ksAdWebView.loadUrl(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r6, int r7, com.kwad.sdk.core.report.y.b r8, int r9) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.splashscreen.b.o.a(boolean, int, com.kwad.sdk.core.report.y$b, int):void");
    }

    static /* synthetic */ boolean a(o oVar, boolean z) {
        oVar.Di = true;
        return true;
    }

    private void aF() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.cV = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        this.cV.mScreenOrientation = 0;
        this.cV.app = this.Cg.mRootContainer;
        this.cV.LD = this.Cg.mRootContainer;
        this.cV.Lc = this.cS;
        this.cV.mReportExtData = null;
        this.cV.apr = false;
        this.cV.aps = o(this.mAdInfo);
    }

    private void aI() {
        com.kwad.components.core.webview.a aVar = this.cU;
        if (aVar != null) {
            aVar.destroy();
            this.cU = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bB() {
        if (this.ef != null || this.Df) {
            return;
        }
        com.kwad.sdk.core.f.d dVar = new com.kwad.sdk.core.f.d(com.kwad.sdk.core.response.a.b.bx(this.Cg.mAdTemplate));
        this.ef = dVar;
        dVar.a(new com.kwad.sdk.core.f.b() { // from class: com.kwad.components.ad.splashscreen.b.o.9
            @Override // com.kwad.sdk.core.f.b
            public final void a(double d) {
                boolean mF = com.kwad.components.core.d.a.b.mF();
                if (!o.this.Cg.BH.rG() || mF) {
                    o.this.lg();
                    return;
                }
                o.this.h(d);
                o.this.lg();
                if (o.this.eg == null) {
                    o oVar = o.this;
                    oVar.eg = oVar.F(oVar.getContext());
                }
                bi.a(o.this.getContext(), o.this.eg);
            }

            @Override // com.kwad.sdk.core.f.b
            public final void bd() {
            }
        });
        this.ef.aX(getContext());
    }

    private com.kwad.components.core.webview.jshandler.p dy() {
        return new com.kwad.components.core.webview.jshandler.p(this.cV, this.Cg.mApkDownloadHelper, new com.kwad.sdk.core.webview.c.kwai.a() { // from class: com.kwad.components.ad.splashscreen.b.o.3
            @Override // com.kwad.sdk.core.webview.c.kwai.a
            public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
                if (com.kwad.sdk.c.kwai.a.tC()) {
                    return;
                }
                if (aVar.zg() || o.o(o.this.mAdInfo)) {
                    y.b bVar = new y.b();
                    bVar.Ts = aVar.TD.Ts;
                    o.this.a(false, aVar.TC, bVar, aVar.jU);
                }
            }
        });
    }

    private s dz() {
        return new s(this.cV, this.Cg.mApkDownloadHelper, new com.kwad.sdk.core.webview.c.kwai.a() { // from class: com.kwad.components.ad.splashscreen.b.o.4
            @Override // com.kwad.sdk.core.webview.c.kwai.a
            public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
                if (aVar.TA || !o.o(o.this.mAdInfo)) {
                    o.this.a(false, aVar.TA ? 1 : 3, null, aVar.jU);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(final double d) {
        if (this.Cg != null) {
            this.Cg.a(1, getContext(), 157, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.b.o.11
                @Override // com.kwad.components.ad.splashscreen.h.a
                public final void b(com.kwad.sdk.core.report.i iVar) {
                    iVar.i(d);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lg() {
        bi.a(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.o.10
            @Override // java.lang.Runnable
            public final void run() {
                o.this.ef.xD();
            }
        }, null, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void li() {
        Runnable runnable;
        this.Df = true;
        KsAdWebView ksAdWebView = this.cS;
        if (ksAdWebView != null) {
            ksAdWebView.setVisibility(8);
        }
        if (com.kwad.sdk.core.response.a.b.cZ(this.mAdInfo)) {
            runnable = new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.o.12
                @Override // java.lang.Runnable
                public final void run() {
                    o.this.a((Presenter) new l(), true);
                }
            };
        } else if (com.kwad.sdk.core.response.a.b.db(this.mAdInfo)) {
            runnable = new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.o.13
                @Override // java.lang.Runnable
                public final void run() {
                    o.this.a((Presenter) new k(), true);
                }
            };
        } else if (!com.kwad.sdk.core.response.a.b.de(this.mAdInfo)) {
            lj();
            return;
        } else {
            runnable = new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.o.2
                @Override // java.lang.Runnable
                public final void run() {
                    o.this.a((Presenter) new m(), true);
                }
            };
        }
        bi.postOnUiThread(runnable);
    }

    private void lj() {
        lh();
        com.kwad.components.ad.splashscreen.e.b bVar = new com.kwad.components.ad.splashscreen.e.b((ViewGroup) getRootView(), (ViewStub) findViewById(R.id.ksad_splash_actionbar_native_stub), com.kwad.sdk.core.response.a.c.bQ(this.mAdTemplate), this.Cg.mApkDownloadHelper);
        this.Dd = bVar;
        bVar.C(this.mAdTemplate);
        this.Dd.a(this);
        this.Dd.li();
    }

    public static boolean o(AdInfo adInfo) {
        return adInfo.adSplashInfo.fullScreenClickSwitch == 1;
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void aa(int i) {
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.cS = (KsAdWebView) findViewById(R.id.ksad_splash_web_card_webView);
        AdTemplate adTemplate = this.Cg.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        this.De = false;
        this.Df = false;
        String aN = com.kwad.sdk.core.response.a.b.aN(this.mAdTemplate);
        if (this.cS == null || TextUtils.isEmpty(aN) || this.Cg.BL) {
            li();
        } else {
            this.Dg = SystemClock.elapsedRealtime();
            com.kwad.components.ad.splashscreen.monitor.a.kD();
            a(this.cS, aN);
            bi.a(this.Dj, null, com.kwad.sdk.core.response.a.b.dj(this.mAdInfo));
        }
        this.Cg.a(this);
    }

    @Override // com.kwad.components.ad.splashscreen.e
    public final void f(boolean z, boolean z2) {
        com.kwad.sdk.core.d.b.d("SplashWebViewPresenter", "isClick: " + z + ", isActionBar: " + z2);
        a(!z, z2 ? 1 : 2, null, 132);
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void kt() {
        com.kwad.sdk.core.f.d dVar = this.ef;
        if (dVar != null) {
            dVar.aY(getContext());
        }
    }

    public final void lh() {
        if (this.De) {
            return;
        }
        this.De = true;
        y.b bVar = new y.b();
        y.a aVar = new y.a();
        aVar.ajY = com.kwad.components.ad.splashscreen.local.d.p(this.mAdInfo);
        bVar.akG = aVar;
        com.kwad.sdk.core.report.a.a(this.Cg.mAdTemplate, 123, bVar, (JSONObject) null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.splashscreen.e.b bVar = this.Dd;
        if (bVar != null) {
            bVar.onUnbind();
        }
        com.kwad.sdk.core.f.d dVar = this.ef;
        if (dVar != null) {
            dVar.aY(getContext());
        }
        an anVar = this.Dh;
        if (anVar != null) {
            anVar.rb();
            this.Dh.rc();
        }
        aI();
    }
}
