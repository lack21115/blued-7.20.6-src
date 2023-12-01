package com.kwad.components.core.webview.a.b;

import com.kwad.components.core.webview.a.a.m;
import com.kwad.components.core.webview.a.a.u;
import com.kwad.components.core.webview.a.h;
import com.kwad.components.core.webview.a.i;
import com.kwad.components.core.webview.a.kwai.o;
import com.kwad.components.core.webview.a.kwai.p;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.l;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.e;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/a/b/a.class */
public abstract class a extends Presenter implements i {
    protected b Vr;
    protected h mTKLoadController;

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(b bVar) {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void ar() {
        super.ar();
        b bVar = (b) Bh();
        this.Vr = bVar;
        a(bVar);
        if (this.mTKLoadController == null) {
            this.mTKLoadController = hN();
        }
        if (this.Vr.mStyleTemplate != null) {
            this.mTKLoadController.setStyleTemplate(this.Vr.mStyleTemplate);
        }
        this.mTKLoadController.bind(this.Vr.mActivity, this.Vr.mAdTemplate, this);
    }

    @Override // com.kwad.components.core.webview.a.i
    public e getTouchCoordsView() {
        return this.Vr.Vs;
    }

    protected h hN() {
        return new h(this.Vr.mPlayedDuration, getContext());
    }

    public void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onCloseTKDialogClick() {
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onRegisterVideoMuteStateListener(o oVar) {
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onRegisterVideoProgressListener(p pVar, com.kwad.components.core.video.i iVar) {
    }

    public void onRegisterWebCardHandler(l lVar, com.kwad.sdk.core.webview.b bVar) {
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onSkipClick(u uVar) {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mTKLoadController.unBind();
        this.mTKLoadController = null;
    }

    @Override // com.kwad.components.core.webview.a.i
    public void onUpdateMuteStatus(m mVar) {
    }

    public void pageClose(WebCloseStatus webCloseStatus) {
        if (this.Vr.mTkDialogFragment != null) {
            this.Vr.mTkDialogFragment.dismiss();
        }
    }
}
