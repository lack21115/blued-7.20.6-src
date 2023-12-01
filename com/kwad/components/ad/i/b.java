package com.kwad.components.ad.i;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.kwad.components.core.d.b.c;
import com.kwad.components.core.webview.a.kwai.f;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.components.core.webview.jshandler.j;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.jshandler.q;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.components.core.webview.jshandler.v;
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.j.k;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.bl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/i/b.class */
public class b {
    protected View GA;
    private String GC;
    private j.a GD;
    private a GE;
    private InterfaceC0309b GF;
    protected KsAdWebView cS;
    private com.kwad.components.core.webview.a cU;
    protected com.kwad.sdk.core.webview.b cV;
    private AdBaseFrameLayout dG;
    private FrameLayout df;
    protected AdTemplate mAdTemplate;
    protected an mCardLifecycleHandler;
    private JSONObject mReportExtData;
    private int mScreenOrientation;
    private com.kwad.sdk.core.webview.c.kwai.a mWebCardClickListener;
    private as xY;
    private List<AdTemplate> Gy = new ArrayList();
    private List<c> Gz = new ArrayList();
    private int cW = -1;
    protected boolean GB = false;
    private aa.b cY = new aa.b() { // from class: com.kwad.components.ad.i.b.4
        @Override // com.kwad.components.core.webview.jshandler.aa.b
        public final void a(aa.a aVar) {
            b.this.lK();
        }
    };
    private ai.b cZ = new ai.b() { // from class: com.kwad.components.ad.i.b.5
        @Override // com.kwad.components.core.webview.jshandler.ai.b
        public final void a(ai.a aVar) {
            b.this.cW = aVar.status;
            com.kwad.sdk.core.d.b.i("PlayEndWebCard", b.this.getName() + "updatePageStatus mPageState: " + aVar + "，targetUrl: " + b.this.GC);
            if (aVar.isSuccess() && b.this.GF != null) {
                b.this.GF.hK();
            }
        }
    };

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/i/b$a.class */
    public interface a {
        void a(b bVar);

        void iw();
    }

    /* renamed from: com.kwad.components.ad.i.b$b  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/i/b$b.class */
    public interface InterfaceC0309b {
        void hK();
    }

    public b() {
    }

    public b(JSONObject jSONObject, String str) {
        this.mReportExtData = jSONObject;
        this.GC = str;
    }

    private void aF() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.cV = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        this.cV.mScreenOrientation = this.mScreenOrientation;
        this.cV.app = this.dG;
        this.cV.LD = this.df;
        this.cV.Lc = this.cS;
        this.cV.mReportExtData = this.mReportExtData;
        b(this.cV);
    }

    private void aH() {
        aI();
        this.cS.getSettings().setAllowFileAccess(true);
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.cS);
        this.cU = aVar;
        a(aVar);
        this.cS.addJavascriptInterface(this.cU, "KwaiAd");
    }

    private void aI() {
        com.kwad.components.core.webview.a aVar = this.cU;
        if (aVar != null) {
            aVar.destroy();
            this.cU = null;
        }
    }

    private void aP() {
        int i = this.cW;
        String str = i == -1 ? "timeout" : i != 1 ? "h5error" : "others";
        com.kwad.sdk.core.d.b.w("PlayEndWebCard", "show webCard fail, reason: " + str);
    }

    private static int getLayoutId() {
        return R.layout.ksad_ad_web_card_layout;
    }

    private KsAdWebView.d getWebListener() {
        return new KsAdWebView.d() { // from class: com.kwad.components.ad.i.b.1
            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageFinished() {
                b.this.GB = true;
                b.this.fv();
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onReceivedHttpError(int i, String str, String str2) {
                b.this.GB = false;
            }
        };
    }

    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, c cVar) {
        a(frameLayout, adBaseFrameLayout, adTemplate, cVar, 0);
    }

    @Deprecated
    public void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, c cVar, int i) {
        this.Gz.add(cVar);
        this.dG = adBaseFrameLayout;
        this.df = frameLayout;
        this.mScreenOrientation = i;
        this.mAdTemplate = adTemplate;
        fq();
        aF();
    }

    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, List<AdTemplate> list, List<c> list2, int i) {
        this.Gz = list2;
        this.dG = adBaseFrameLayout;
        this.df = frameLayout;
        this.mScreenOrientation = i;
        if (list != null && list.size() > 0) {
            this.Gy = list;
            this.mAdTemplate = list.get(0);
        }
        fq();
        aF();
    }

    public final void a(a aVar) {
        this.GE = aVar;
    }

    public final void a(InterfaceC0309b interfaceC0309b) {
        this.GF = interfaceC0309b;
        this.df.setVisibility(4);
        this.cW = -1;
        String l = l(this.mAdTemplate);
        com.kwad.sdk.core.d.b.d("PlayEndWebCard", "startPreloadWebView url : " + l);
        if (TextUtils.isEmpty(l) || this.cS == null) {
            return;
        }
        aH();
        fu();
        this.cS.loadUrl(l);
    }

    public void a(com.kwad.components.core.webview.a aVar) {
        if (this.Gz.size() <= 1 || this.Gy.size() <= 1) {
            c cVar = this.Gz.get(0);
            aVar.a(new s(this.cV, cVar, this.mWebCardClickListener));
            aVar.a(new p(this.cV, cVar, this.mWebCardClickListener));
            aVar.a(new aq(this.cV, cVar));
        } else {
            aVar.a(new s(this.cV, this.Gz.get(0), this.mWebCardClickListener));
            aVar.a(new p(this.cV, this.Gz, this.mWebCardClickListener));
            aVar.a(new ae(this.Gy, this.Gz));
        }
        as asVar = new as();
        this.xY = asVar;
        aVar.a(asVar);
        aVar.a(new v(this.cV));
        aVar.a(new f());
        aVar.a(new y(this.cV));
        aVar.a(new u(this.cV));
        aVar.a(new ai(this.cZ, l(this.mAdTemplate)));
        an anVar = new an();
        this.mCardLifecycleHandler = anVar;
        aVar.a(anVar);
        aVar.a(new aa(this.cY));
        aVar.a(new ac(this.cV));
        j jVar = new j();
        jVar.b(new j.a() { // from class: com.kwad.components.ad.i.b.2
            @Override // com.kwad.components.core.webview.jshandler.j.a
            public final void onPlayAgainClick(boolean z) {
                if (b.this.GD != null) {
                    b.this.GD.onPlayAgainClick(z);
                }
            }
        });
        aVar.a(jVar);
        aVar.a(new q(new com.kwad.sdk.core.webview.c.kwai.b() { // from class: com.kwad.components.ad.i.b.3
            @Override // com.kwad.sdk.core.webview.c.kwai.b
            public final void a(WebCloseStatus webCloseStatus) {
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.i.b.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (b.this.GE != null) {
                            b.this.GE.iw();
                        }
                    }
                });
            }
        }));
    }

    public final void a(j.a aVar) {
        this.GD = aVar;
    }

    public final void a(com.kwad.sdk.core.webview.c.kwai.a aVar) {
        this.mWebCardClickListener = aVar;
    }

    public final void al(boolean z) {
        this.xY.al(true);
    }

    public final boolean az() {
        if (!bE()) {
            FrameLayout frameLayout = this.df;
            if (frameLayout != null) {
                frameLayout.setVisibility(4);
            }
            aP();
            return false;
        }
        an anVar = this.mCardLifecycleHandler;
        if (anVar != null) {
            anVar.qZ();
        }
        FrameLayout frameLayout2 = this.df;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(0);
        }
        if (this.mCardLifecycleHandler != null && fr()) {
            this.mCardLifecycleHandler.ra();
        }
        a aVar = this.GE;
        if (aVar != null) {
            aVar.a(this);
            return true;
        }
        return true;
    }

    protected void b(com.kwad.sdk.core.webview.b bVar) {
        bVar.setAdTemplate(this.mAdTemplate);
    }

    public boolean bE() {
        return this.cW == 1;
    }

    public void fq() {
        this.df.removeAllViews();
        this.df.setVisibility(4);
        this.GA = k.inflate(this.df.getContext(), getLayoutId(), this.df);
        KsAdWebView ksAdWebView = (KsAdWebView) this.df.findViewById(R.id.ksad_web_card_webView);
        this.cS = ksAdWebView;
        if (ksAdWebView != null) {
            ksAdWebView.setBackgroundColor(0);
            this.cS.getBackground().setAlpha(0);
            this.cS.setClientConfig(this.cS.getClientConfig().ct(this.mAdTemplate).b(getWebListener()));
            ft();
        }
    }

    protected boolean fr() {
        return true;
    }

    protected void ft() {
    }

    protected void fu() {
    }

    protected void fv() {
    }

    public final long getLoadTime() {
        KsAdWebView ksAdWebView = this.cS;
        if (ksAdWebView != null) {
            return ksAdWebView.getLoadTime();
        }
        return -1L;
    }

    protected String getName() {
        return "PlayEndWebCard";
    }

    public final void jW() {
        aI();
    }

    public String l(AdTemplate adTemplate) {
        String str = this.GC;
        String str2 = str;
        if (str == null) {
            str2 = com.kwad.sdk.core.response.a.b.bd(this.mAdTemplate);
        }
        return str2;
    }

    public final void lK() {
        if (bl.a(this.cS, 50, false)) {
            an anVar = this.mCardLifecycleHandler;
            if (anVar != null) {
                anVar.rb();
            }
            this.df.setVisibility(4);
            an anVar2 = this.mCardLifecycleHandler;
            if (anVar2 != null) {
                anVar2.rc();
            }
        }
    }

    public final FrameLayout lL() {
        return this.df;
    }

    public final void release() {
        aI();
        this.GF = null;
    }
}
