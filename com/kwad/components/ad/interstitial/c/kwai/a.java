package com.kwad.components.ad.interstitial.c.kwai;

import com.kwad.components.core.webview.a.a.m;
import com.kwad.components.core.webview.a.a.u;
import com.kwad.components.core.webview.a.h;
import com.kwad.components.core.webview.a.i;
import com.kwad.components.core.webview.a.kwai.i;
import com.kwad.components.core.webview.a.kwai.o;
import com.kwad.components.core.webview.a.kwai.p;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.l;
import com.kwad.sdk.widget.e;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/c/kwai/a.class */
public abstract class a extends com.kwad.components.ad.interstitial.c.b implements i {
    private h mTKLoadController;

    @Override // com.kwad.components.ad.interstitial.c.b, com.kwad.sdk.mvp.Presenter
    public void ar() {
        super.ar();
        this.mTKLoadController.bind(getActivity(), this.jt.mAdTemplate, this);
    }

    @Override // com.kwad.components.core.webview.a.i
    public e getTouchCoordsView() {
        return this.jt.jC;
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
        this.jt.jw = true;
        this.jt.hN.onAdClicked();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onCreate() {
        super.onCreate();
        this.mTKLoadController = new h(-1L, getContext());
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onRegisterLifecycleLisener(an anVar) {
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onRegisterVideoMuteStateListener(o oVar) {
        m mVar = new m();
        mVar.Vf = !this.jt.dZ.isVideoSoundEnable();
        oVar.b(mVar);
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onRegisterVideoProgressListener(p pVar, com.kwad.components.core.video.i iVar) {
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onRegisterWebCardHandler(l lVar, com.kwad.sdk.core.webview.b bVar) {
        lVar.c(new com.kwad.components.core.webview.a.kwai.i(new i.a() { // from class: com.kwad.components.ad.interstitial.c.kwai.a.1
            @Override // com.kwad.components.core.webview.a.kwai.i.a
            public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
                a.this.onAdClicked(aVar);
            }
        }));
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onSkipClick(u uVar) {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        this.mTKLoadController.unBind();
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onUpdateMuteStatus(m mVar) {
    }

    @Override // com.kwad.components.core.webview.a.i
    public void pageClose(WebCloseStatus webCloseStatus) {
    }
}
