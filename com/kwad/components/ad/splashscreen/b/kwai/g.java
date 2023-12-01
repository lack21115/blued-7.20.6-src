package com.kwad.components.ad.splashscreen.b.kwai;

import android.widget.FrameLayout;
import com.kwad.components.core.webview.a.j;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.l;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.core.report.y;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/b/kwai/g.class */
public final class g extends com.kwad.components.ad.splashscreen.b.b.a implements com.kwad.sdk.core.g.c {
    private FrameLayout lE;
    private an wi;

    private p a(com.kwad.sdk.core.webview.b bVar) {
        return new p(bVar, this.Cg.mApkDownloadHelper, new com.kwad.sdk.core.webview.c.kwai.a() { // from class: com.kwad.components.ad.splashscreen.b.kwai.g.1
            @Override // com.kwad.sdk.core.webview.c.kwai.a
            public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
                if (aVar != null) {
                    g.this.Cg.mRootContainer.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.kwai.g.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            g.this.Cg.ku();
                        }
                    });
                }
            }
        });
    }

    private void ad(int i) {
        y.a aVar = new y.a();
        if (this.Cg.mTimerHelper != null) {
            aVar.duration = this.Cg.mTimerHelper.getTime();
        }
        i a2 = new i().bp(6).a(aVar);
        a2.bk(i == 2 ? 14 : 1);
        com.kwad.sdk.core.report.a.b(this.Cg.mAdTemplate, a2, (JSONObject) null);
    }

    private void lo() {
        this.Cg.mRootContainer.findViewById(R.id.splash_play_card_view).setVisibility(8);
    }

    @Override // com.kwad.components.ad.splashscreen.b.b.a, com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.Cg.BH.a(this);
    }

    @Override // com.kwad.components.core.webview.a.i
    public final FrameLayout getTKContainer() {
        return this.lE;
    }

    @Override // com.kwad.components.core.webview.a.i
    public final String getTkTemplateId() {
        return j.b("ksad-splash-end-card", this.Cg.mAdTemplate);
    }

    @Override // com.kwad.components.ad.splashscreen.b.b.a, com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.lE = (FrameLayout) findViewById(R.id.splash_end_card_view);
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onGetContainerLimited(u.a aVar) {
        aVar.width = com.kwad.sdk.c.kwai.a.b(getContext(), this.Cg.mRootContainer.getWidth());
        aVar.height = com.kwad.sdk.c.kwai.a.b(getContext(), this.Cg.mRootContainer.getHeight());
    }

    @Override // com.kwad.sdk.core.g.c
    public final void onPageInvisible() {
        an anVar = this.wi;
        if (anVar != null) {
            anVar.re();
        }
    }

    @Override // com.kwad.sdk.core.g.c
    public final void onPageVisible() {
        an anVar = this.wi;
        if (anVar != null) {
            anVar.rd();
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.b.a, com.kwad.components.core.webview.a.i
    public final void onRegisterLifecycleLisener(an anVar) {
        super.onRegisterLifecycleLisener(anVar);
        this.wi = anVar;
    }

    @Override // com.kwad.components.ad.splashscreen.b.b.a, com.kwad.components.core.webview.a.i
    public final void onRegisterWebCardHandler(l lVar, com.kwad.sdk.core.webview.b bVar) {
        super.onRegisterWebCardHandler(lVar, bVar);
        lVar.c(a(bVar));
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onTkLoadFailed() {
        an anVar = this.wi;
        if (anVar != null) {
            anVar.rb();
            this.wi.rc();
        }
        lo();
        this.lE.setVisibility(8);
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onTkLoadSuccess() {
        an anVar = this.wi;
        if (anVar != null) {
            anVar.qZ();
            this.wi.ra();
        }
        lo();
        this.lE.setVisibility(0);
    }

    @Override // com.kwad.components.ad.splashscreen.b.b.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        an anVar = this.wi;
        if (anVar != null) {
            anVar.rb();
            this.wi.rc();
        }
        super.onUnbind();
        this.Cg.BH.b(this);
    }

    @Override // com.kwad.components.ad.splashscreen.b.b.a, com.kwad.components.core.webview.a.i
    public final void pageClose(WebCloseStatus webCloseStatus) {
        super.pageClose(webCloseStatus);
        ad(webCloseStatus.closeType);
        if (webCloseStatus.closeType == 2) {
            this.Cg.kB();
        } else {
            this.Cg.ky();
        }
    }
}
