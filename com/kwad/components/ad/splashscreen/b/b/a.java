package com.kwad.components.ad.splashscreen.b.b;

import com.kwad.components.ad.splashscreen.b.e;
import com.kwad.components.core.webview.a.a.m;
import com.kwad.components.core.webview.a.a.u;
import com.kwad.components.core.webview.a.h;
import com.kwad.components.core.webview.a.i;
import com.kwad.components.core.webview.a.kwai.o;
import com.kwad.components.core.webview.a.kwai.p;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.l;
import com.kwad.sdk.core.webview.b;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/b/b/a.class */
public abstract class a extends e implements i {
    private h mTKLoadController;

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public void ar() {
        super.ar();
        this.mTKLoadController.bind(null, this.Cg.mAdTemplate, this);
    }

    @Override // com.kwad.components.core.webview.a.i
    public com.kwad.sdk.widget.e getTouchCoordsView() {
        return this.Cg.mRootContainer;
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onCloseTKDialogClick() {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onCreate() {
        super.onCreate();
        this.mTKLoadController = new h(getContext(), 1000);
    }

    public void onRegisterLifecycleLisener(an anVar) {
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onRegisterVideoMuteStateListener(o oVar) {
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onRegisterVideoProgressListener(p pVar, com.kwad.components.core.video.i iVar) {
    }

    public void onRegisterWebCardHandler(l lVar, b bVar) {
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
