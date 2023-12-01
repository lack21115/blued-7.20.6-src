package com.kwad.components.core.q.a;

import android.widget.FrameLayout;
import com.kwad.components.core.l.d;
import com.kwad.components.core.q.kwai.b;
import com.kwad.components.core.webview.a.a.m;
import com.kwad.components.core.webview.a.h;
import com.kwad.components.core.webview.a.i;
import com.kwad.components.core.webview.a.kwai.o;
import com.kwad.components.core.webview.a.kwai.p;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.l;
import com.kwad.sdk.core.webview.b.g;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.widget.e;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/q/a/a.class */
public final class a extends Presenter implements i {
    private FrameLayout PE;
    private an PF;
    protected boolean PG;
    protected b PH;
    private com.kwad.components.core.j.kwai.a PI = new com.kwad.components.core.j.kwai.a() { // from class: com.kwad.components.core.q.a.a.1
        @Override // com.kwad.components.core.j.kwai.a
        public final void a(d dVar) {
            a.this.pF();
        }

        @Override // com.kwad.components.core.j.kwai.a
        public final void b(d dVar) {
            a.this.pG();
        }

        @Override // com.kwad.components.core.j.kwai.a
        public final void c(d dVar) {
            a.this.pH();
        }

        @Override // com.kwad.components.core.j.kwai.a
        public final void fY() {
        }
    };
    private h mTKLoadController;

    private void pE() {
        an anVar = this.PF;
        if (anVar == null) {
            return;
        }
        if (this.PG) {
            anVar.rd();
            return;
        }
        anVar.qZ();
        this.PF.ra();
        this.PG = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pF() {
        pE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pG() {
        an anVar = this.PF;
        if (anVar == null || !this.PG) {
            return;
        }
        anVar.re();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pH() {
        an anVar = this.PF;
        if (anVar == null || !this.PG) {
            return;
        }
        anVar.rb();
        this.PF.rc();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.PH = (b) Bh();
        this.PE = (FrameLayout) findViewById(R.id.ksad_js_container);
        h hVar = new h(getContext(), 1000);
        this.mTKLoadController = hVar;
        hVar.setStyleTemplate(this.PH.mStyleTemplate);
        if (this.PH.Pz != null) {
            this.PH.Pz.a(this.mTKLoadController);
            this.mTKLoadController.setTKBridgeHandler(new g() { // from class: com.kwad.components.core.q.a.a.2
                @Override // com.kwad.sdk.core.webview.b.g
                public final void callTKBridge(String str) {
                    if (a.this.PH.Pz != null) {
                        a.this.PH.Pz.callTKBridge(str);
                    }
                }
            });
            this.mTKLoadController.addCustomEnv("hasTKBridge", Boolean.TRUE);
        }
        this.mTKLoadController.bind(getActivity(), this.PH.mAdTemplate, this);
        this.PH.JT.add(this.PI);
    }

    @Override // com.kwad.components.core.webview.a.i
    public final FrameLayout getTKContainer() {
        return this.PE;
    }

    @Override // com.kwad.components.core.webview.a.i
    public final String getTkTemplateId() {
        return this.PH.mStyleTemplate.templateId;
    }

    @Override // com.kwad.components.core.webview.a.i
    public final e getTouchCoordsView() {
        return this.PH.mRootContainer;
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onCloseTKDialogClick() {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onGetContainerLimited(u.a aVar) {
        float ax = com.kwad.sdk.c.kwai.a.ax(getContext());
        aVar.width = (int) ((bd.getScreenWidth(getContext()) / ax) + 0.5f);
        aVar.height = (int) ((bd.getScreenHeight(getContext()) / ax) + 0.5f);
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onRegisterLifecycleLisener(an anVar) {
        this.PF = anVar;
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onRegisterVideoMuteStateListener(o oVar) {
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onRegisterVideoProgressListener(p pVar, com.kwad.components.core.video.i iVar) {
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onRegisterWebCardHandler(l lVar, com.kwad.sdk.core.webview.b bVar) {
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onSkipClick(com.kwad.components.core.webview.a.a.u uVar) {
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onTkLoadFailed() {
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onTkLoadSuccess() {
        pE();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        pH();
        this.mTKLoadController.unBind();
        this.PH.JT.remove(this.PI);
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onUpdateMuteStatus(m mVar) {
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void pageClose(WebCloseStatus webCloseStatus) {
        getActivity().finish();
    }
}
