package com.kwad.components.core.page.a;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.components.core.webview.jshandler.v;
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/page/a/f.class */
public final class f extends c {
    private int LC = -1;
    private ViewGroup LD;
    private final a LE;
    private WebView Lc;
    private com.kwad.components.core.webview.a cU;
    private com.kwad.sdk.core.webview.b cV;
    private AdTemplate mAdTemplate;
    private final boolean mIsRewardLandPage;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/page/a/f$a.class */
    public interface a {
        void ay(int i);
    }

    public f(a aVar, boolean z) {
        this.LE = aVar;
        this.mIsRewardLandPage = z;
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        com.kwad.sdk.core.d.b.d("LandPageWebViewPresenter", "registerWebCardHandler");
        com.kwad.components.core.d.b.c cVar = new com.kwad.components.core.d.b.c(this.LA.mAdTemplate);
        aVar.a(new v(this.cV));
        aVar.a(new y(this.cV));
        aVar.a(new aq(this.cV, cVar));
        aVar.a(new u(this.cV));
        aVar.a(new an());
        aVar.a(new ai(oj(), com.kwad.sdk.core.response.a.b.bb(this.mAdTemplate)));
        aVar.a(new ac(this.cV));
        aVar.a(new ag(getOpenNewPageListener()));
        aVar.a(new s(this.cV, cVar, null));
        aVar.a(new p(this.cV, cVar, null, 2, this.mIsRewardLandPage));
    }

    private void aF() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.cV = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        this.cV.LD = this.LD;
        this.cV.Lc = this.Lc;
    }

    private void aH() {
        aI();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.Lc);
        this.cU = aVar;
        a(aVar);
        this.Lc.addJavascriptInterface(this.cU, "KwaiAd");
    }

    private void aI() {
        com.kwad.components.core.webview.a aVar = this.cU;
        if (aVar != null) {
            aVar.destroy();
            this.cU = null;
        }
    }

    private void aw(String str) {
        aH();
        Tracker.loadUrl(this.Lc, str);
    }

    private ag.a getOpenNewPageListener() {
        return new ag.a() { // from class: com.kwad.components.core.page.a.f.2
            @Override // com.kwad.components.core.webview.jshandler.ag.a
            public final void a(com.kwad.components.core.webview.kwai.b bVar) {
                AdWebViewActivityProxy.launch(f.this.Lc.getContext(), new AdWebViewActivityProxy.a.C0359a().au(bVar.title).av(bVar.url).aA(true).L(f.this.mAdTemplate).oc());
            }
        };
    }

    private ai.b oj() {
        return new ai.b() { // from class: com.kwad.components.core.page.a.f.1
            @Override // com.kwad.components.core.webview.jshandler.ai.b
            public final void a(ai.a aVar) {
                f.this.LC = aVar.status;
                if (f.this.LE != null) {
                    f.this.LE.ay(aVar.status);
                }
                if (aVar.status == 1) {
                    f.this.LD.setVisibility(0);
                } else {
                    f.this.Lc.setVisibility(8);
                }
            }
        };
    }

    @Override // com.kwad.components.core.page.a.c, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        AdTemplate adTemplate = this.LA.mAdTemplate;
        this.mAdTemplate = adTemplate;
        String bb = com.kwad.sdk.core.response.a.b.bb(adTemplate);
        if (!TextUtils.isEmpty(bb)) {
            aF();
            aw(bb);
            return;
        }
        a aVar = this.LE;
        if (aVar != null) {
            aVar.ay(this.LC);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.Lc = (WebView) findViewById(R.id.ksad_landing_page_webview);
        this.LD = (ViewGroup) findViewById(R.id.ksad_web_card_container);
        this.Lc.setBackgroundColor(0);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        aI();
    }
}
