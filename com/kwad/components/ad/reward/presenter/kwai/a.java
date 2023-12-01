package com.kwad.components.ad.reward.presenter.kwai;

import android.widget.FrameLayout;
import com.kwad.components.ad.reward.h.q;
import com.kwad.components.ad.reward.j;
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
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bl;
import com.kwad.sdk.widget.e;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/kwai/a.class */
public final class a extends com.kwad.components.ad.reward.presenter.a implements i {
    private FrameLayout lE;
    private AdInfo mAdInfo;
    private h mTKLoadController;
    private long tv;
    private long tw;
    private boolean tx;
    private boolean ty;
    private j.b tz = new j.b() { // from class: com.kwad.components.ad.reward.presenter.kwai.a.1
        @Override // com.kwad.components.ad.reward.j.b
        public final boolean interceptPlayCardResume() {
            return a.this.lE != null && a.this.lE.getVisibility() == 0;
        }
    };
    private final com.kwad.components.core.video.j mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.reward.presenter.kwai.a.2
        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j, long j2) {
            super.onVideoPlayProgress(j, j2);
            long a2 = j.a(j, a.this.mAdInfo);
            if (j2 <= a.this.tv || a2 - j2 <= a.this.tw || a.this.tx) {
                return;
            }
            a.a(a.this, true);
            a.this.mTKLoadController.bind(a.this.qt.getActivity(), a.this.qt.mAdTemplate, a.this);
        }
    };

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.tx = true;
        return true;
    }

    private h hN() {
        return new h(-1L, getContext());
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        if (this.mTKLoadController == null) {
            this.mTKLoadController = hN();
        }
        AdInfo cb = d.cb(this.qt.mAdTemplate);
        this.mAdInfo = cb;
        this.tv = com.kwad.sdk.core.response.a.a.aB(cb) * 1000;
        this.tw = com.kwad.sdk.core.response.a.a.aC(this.mAdInfo) * 1000;
        this.qt.oN.a(this.mVideoPlayStateListener, null);
        this.qt.a(this.tz);
    }

    @Override // com.kwad.components.core.webview.a.i
    public final FrameLayout getTKContainer() {
        return this.lE;
    }

    @Override // com.kwad.components.core.webview.a.i
    public final String getTkTemplateId() {
        b.d("TkRewardInteractPresenter", "getTkTemplateId: ");
        return com.kwad.components.core.webview.a.j.b("ksad-video-interact-card", this.qt.mAdTemplate);
    }

    @Override // com.kwad.components.core.webview.a.i
    public final e getTouchCoordsView() {
        return this.qt.mRootContainer;
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
        this.lE = (FrameLayout) findViewById(R.id.ksad_js_interact);
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onGetContainerLimited(u.a aVar) {
        float ax = com.kwad.sdk.c.kwai.a.ax(getContext());
        aVar.width = (int) ((bd.getScreenWidth(getContext()) / ax) + 0.5f);
        aVar.height = (int) ((bd.getScreenHeight(getContext()) / ax) + 0.5f);
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onRegisterLifecycleLisener(an anVar) {
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onRegisterVideoMuteStateListener(o oVar) {
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onRegisterVideoProgressListener(p pVar, com.kwad.components.core.video.i iVar) {
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onRegisterWebCardHandler(l lVar, com.kwad.sdk.core.webview.b bVar) {
        lVar.c(new q(bVar, this.qt.mApkDownloadHelper, this.qt, -1L, new com.kwad.sdk.core.webview.c.kwai.a() { // from class: com.kwad.components.ad.reward.presenter.kwai.a.3
            @Override // com.kwad.sdk.core.webview.c.kwai.a
            public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
                if (a.this.qt.mAdOpenInteractionListener != null) {
                    a.this.qt.mAdOpenInteractionListener.bN();
                }
            }
        }, null));
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onSkipClick(com.kwad.components.core.webview.a.a.u uVar) {
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onTkLoadFailed() {
        b.d("TkRewardInteractPresenter", "onTkLoadFailed: ");
        this.lE.setVisibility(8);
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onTkLoadSuccess() {
        b.d("TkRewardInteractPresenter", "onTkLoadSuccess: ");
        getContext();
        if (ai.DL()) {
            this.lE.setVisibility(0);
            com.kwad.components.ad.reward.c.a.P(this.qt.mContext);
            this.qt.oN.jH().pause();
            this.ty = true;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qt.oN.b(this.mVideoPlayStateListener, null);
        this.qt.b(this.tz);
        this.mTKLoadController.unBind();
        this.mTKLoadController = null;
        this.lE.setVisibility(8);
        this.tx = false;
        this.ty = false;
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void onUpdateMuteStatus(m mVar) {
    }

    @Override // com.kwad.components.core.webview.a.i
    public final void pageClose(WebCloseStatus webCloseStatus) {
        this.qt.pi = webCloseStatus != null && webCloseStatus.interactSuccess;
        if (this.qt.pi) {
            this.qt.oN.jH().jD();
        }
        if (this.ty && bl.o(this.lE, 30)) {
            this.qt.oN.resume();
        }
        this.lE.setVisibility(8);
    }
}
