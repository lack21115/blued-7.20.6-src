package com.kwad.components.ad.reward.presenter.f;

import android.widget.FrameLayout;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.core.webview.a.a.y;
import com.kwad.components.core.webview.a.b;
import com.kwad.components.core.webview.a.j;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.sdk.R;
import com.kwad.sdk.components.l;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/f/b.class */
public final class b extends c {
    private FrameLayout vJ;
    private boolean vK = false;

    private void Y(boolean z) {
        this.vJ.setVisibility(z ? 0 : 8);
    }

    private com.kwad.components.core.webview.a.c en() {
        return new com.kwad.components.core.webview.a.c() { // from class: com.kwad.components.ad.reward.presenter.f.b.1
            @Override // com.kwad.components.core.webview.a.c, com.kwad.sdk.core.webview.b.a
            public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
                super.handleJsCall(str, cVar);
                com.kwad.components.core.webview.a.a.c cVar2 = new com.kwad.components.core.webview.a.a.c();
                cVar2.UX = com.kwad.components.ad.reward.model.b.cQ();
                cVar.a(cVar2);
            }
        };
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        if (this.vK) {
            return;
        }
        Y(true);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c
    protected final boolean ck() {
        return true;
    }

    @Override // com.kwad.components.core.webview.a.i
    public final FrameLayout getTKContainer() {
        return this.vJ;
    }

    @Override // com.kwad.components.core.webview.a.i
    public final String getTkTemplateId() {
        return j.b("ksad-live-video-card", this.qt.mAdTemplate);
    }

    public final BackPressHandleResult gs() {
        return this.vM == null ? BackPressHandleResult.NOT_HANDLED : this.vM.gs();
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c
    protected final boolean iI() {
        return true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.vJ = (FrameLayout) findViewById(R.id.ksad_js_live_card);
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onGetContainerLimited(u.a aVar) {
        float ax = com.kwad.sdk.c.kwai.a.ax(getContext());
        aVar.width = (int) ((com.kwad.sdk.c.kwai.a.getScreenWidth(getContext()) / ax) + 0.5f);
        aVar.height = (int) ((com.kwad.sdk.c.kwai.a.getScreenHeight(getContext()) / ax) + 0.5f);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.components.core.webview.a.i
    public final void onRegisterWebCardHandler(l lVar, com.kwad.sdk.core.webview.b bVar) {
        super.onRegisterWebCardHandler(lVar, bVar);
        lVar.c(en());
        lVar.c(new com.kwad.components.core.webview.a.b(new b.a() { // from class: com.kwad.components.ad.reward.presenter.f.b.2
            @Override // com.kwad.components.core.webview.a.b.a
            public final void es() {
                com.kwad.components.ad.reward.model.b.L(b.this.qt.mContext);
            }
        }));
        lVar.c(new n() { // from class: com.kwad.components.ad.reward.presenter.f.b.3
            @Override // com.kwad.components.core.webview.jshandler.n
            public final void a(y yVar) {
                super.a(yVar);
                b.this.qt.mAdOpenInteractionListener.onVideoPlayStart();
                com.kwad.components.ad.reward.monitor.a.b(b.this.qt.pf, b.this.qt.mAdTemplate, b.this.qt.mPageEnterTime);
            }

            @Override // com.kwad.components.core.webview.jshandler.n
            public final void b(y yVar) {
                super.b(yVar);
                b.this.qt.mAdTemplate.setmCurPlayTime(yVar.nZ);
            }

            @Override // com.kwad.components.core.webview.jshandler.n
            public final void c(y yVar) {
                super.c(yVar);
                b.this.qt.mAdOpenInteractionListener.onVideoPlayEnd();
                b.this.qt.mAdTemplate.setmCurPlayTime(-1L);
                com.kwad.components.ad.reward.presenter.e.u(b.this.qt);
            }

            @Override // com.kwad.components.core.webview.jshandler.n
            public final void d(y yVar) {
                super.d(yVar);
                long rj = yVar.rj();
                b.this.qt.mAdOpenInteractionListener.onVideoPlayError(yVar.errorCode, (int) rj);
                com.kwad.components.ad.reward.monitor.a.a(b.this.qt.pf, b.this.qt.mAdTemplate, b.this.qt.pB, yVar.errorCode, rj);
            }
        });
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.components.core.webview.a.i
    public final void onSkipClick(com.kwad.components.core.webview.a.a.u uVar) {
        com.kwad.sdk.core.d.b.d("TKLivePresenter", "onSkipClick: " + uVar.Vl);
        if (this.qt != null && this.qt.mAdOpenInteractionListener != null) {
            this.qt.mAdOpenInteractionListener.onVideoSkipToEnd(uVar.Vl * 1000);
        }
        com.kwad.components.ad.reward.presenter.e.u(this.qt);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.c, com.kwad.components.core.webview.a.i
    public final void onTkLoadFailed() {
        super.onTkLoadFailed();
        this.vK = true;
        Y(false);
    }
}
