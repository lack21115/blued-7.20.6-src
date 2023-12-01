package com.kwad.components.ad.reward.presenter.f;

import android.widget.FrameLayout;
import com.kwad.components.ad.reward.d.l;
import com.kwad.components.ad.reward.j;
import com.kwad.components.ad.reward.j.a;
import com.kwad.components.ad.reward.n;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/f/h.class */
public final class h extends c implements com.kwad.components.ad.reward.d.h {
    private FrameLayout hw;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private long wr;
    private com.kwad.components.core.webview.a.e ws;
    private a.InterfaceC0324a wt = new a.InterfaceC0324a() { // from class: com.kwad.components.ad.reward.presenter.f.h.1
        @Override // com.kwad.components.ad.reward.j.a.InterfaceC0324a
        public final void iX() {
            if (h.this.ws != null) {
                com.kwad.components.core.webview.a.a.i iVar = new com.kwad.components.core.webview.a.a.i();
                AdInfo cb = com.kwad.sdk.core.response.a.d.cb(h.this.qt.mAdTemplate);
                int i = 0;
                int aE = com.kwad.sdk.core.response.a.a.aG(cb) && com.kwad.components.core.p.a.pt().pu() == 0 ? com.kwad.sdk.core.response.a.a.aE(cb) : com.kwad.sdk.core.response.a.a.aC(cb);
                if (h.this.qt.pi) {
                    i = aE;
                }
                iVar.rewardTime = i;
                h.this.ws.b(iVar);
            }
        }
    };
    private com.kwad.components.ad.reward.d.f mPlayEndPageListener = new com.kwad.components.ad.reward.d.a() { // from class: com.kwad.components.ad.reward.presenter.f.h.2
        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            if (com.kwad.sdk.core.response.a.a.aj(com.kwad.sdk.core.response.a.d.cb(h.this.qt.mAdTemplate))) {
                h.this.hw.setVisibility(8);
            }
        }
    };

    private com.kwad.components.core.webview.a.e iV() {
        return new com.kwad.components.core.webview.a.e() { // from class: com.kwad.components.ad.reward.presenter.f.h.3
            @Override // com.kwad.components.core.webview.a.e, com.kwad.sdk.core.webview.b.a
            public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
                super.handleJsCall(str, cVar);
                com.kwad.components.core.webview.a.a.i iVar = new com.kwad.components.core.webview.a.a.i();
                AdInfo cb = com.kwad.sdk.core.response.a.d.cb(h.this.qt.mAdTemplate);
                int i = 0;
                int aE = com.kwad.sdk.core.response.a.a.aG(cb) && com.kwad.components.core.p.a.pt().pu() == 0 ? com.kwad.sdk.core.response.a.a.aE(cb) : com.kwad.sdk.core.response.a.a.aC(cb);
                if (h.this.qt.pi) {
                    i = aE;
                }
                iVar.rewardTime = i;
                cVar.a(iVar);
            }
        };
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c
    public final void a(long j, long j2) {
        super.a(j, j2);
        int i = 0;
        int aE = com.kwad.sdk.core.response.a.a.aG(this.mAdInfo) && com.kwad.components.core.p.a.pt().pu() == 0 ? com.kwad.sdk.core.response.a.a.aE(this.mAdInfo) : com.kwad.sdk.core.response.a.a.aC(this.mAdInfo);
        if (this.qt.pi) {
            i = 1000;
        }
        n.a(this.qt, j2, this.wr, aE * i);
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void a(PlayableSource playableSource, l lVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        if (ck() && !this.qt.oN.jF()) {
            AdTemplate adTemplate = this.qt.mAdTemplate;
            this.mAdTemplate = adTemplate;
            AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
            this.mAdInfo = cb;
            this.wr = Math.min(com.kwad.sdk.core.response.a.a.G(cb), com.kwad.sdk.core.response.a.a.X(this.mAdInfo));
            this.qt.b(this.mPlayEndPageListener);
            this.qt.oN.jH().a(this.wt);
            com.kwad.components.ad.reward.b.ff().a(this);
        }
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void ca() {
        if (this.qt.ph) {
            this.hw.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void cb() {
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.qt.mAdTemplate);
        if (!this.qt.ph || com.kwad.sdk.core.response.a.a.aj(cb)) {
            return;
        }
        this.hw.setVisibility(0);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c
    protected final boolean ck() {
        return j.b(this.qt) && !this.qt.oN.jF();
    }

    @Override // com.kwad.components.core.webview.a.i
    public final FrameLayout getTKContainer() {
        return this.hw;
    }

    @Override // com.kwad.components.core.webview.a.i
    public final String getTkTemplateId() {
        return com.kwad.components.core.webview.a.j.b("ksad-video-top-bar", this.qt.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.ksad_js_top);
        this.hw = frameLayout;
        frameLayout.setVisibility(0);
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onGetContainerLimited(u.a aVar) {
        aVar.width = (int) ((com.kwad.sdk.c.kwai.a.getScreenWidth(getContext()) / com.kwad.sdk.c.kwai.a.ax(getContext())) + 0.5f);
        aVar.height = 44;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.components.core.webview.a.i
    public final void onRegisterWebCardHandler(com.kwad.sdk.components.l lVar, com.kwad.sdk.core.webview.b bVar) {
        super.onRegisterWebCardHandler(lVar, bVar);
        com.kwad.components.core.webview.a.e iV = iV();
        this.ws = iV;
        lVar.c(iV);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.components.core.webview.a.i
    public final void onTkLoadFailed() {
        super.onTkLoadFailed();
        this.qt.ph = false;
        this.qt.E(false);
        this.hw.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (ck()) {
            this.qt.c(this.mPlayEndPageListener);
            this.qt.oN.jH().b(this.wt);
            com.kwad.components.ad.reward.b.ff().b(this);
        }
    }
}
