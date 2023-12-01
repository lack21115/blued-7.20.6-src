package com.kwad.components.ad.reward.presenter;

import com.kwad.components.core.page.DownloadLandPageActivity;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.webview.KsAdWebView;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/o.class */
public final class o extends a {
    private com.kwad.components.core.playable.a oP;
    private PlayableSource sw;
    private final com.kwad.components.ad.reward.d.h sx = new com.kwad.components.ad.reward.d.i() { // from class: com.kwad.components.ad.reward.presenter.o.1
        @Override // com.kwad.components.ad.reward.d.i, com.kwad.components.ad.reward.d.h
        public final void a(PlayableSource playableSource, com.kwad.components.ad.reward.d.l lVar) {
            o.this.sw = playableSource;
            if (o.this.oP != null && o.this.oP.oY()) {
                o.this.oP.e(playableSource);
                if (o.this.qt != null) {
                    o.this.qt.d(playableSource);
                    o.this.qt.F(true);
                    if (o.this.qt.oN.jF()) {
                        o.this.qt.oN.jG().pause();
                    }
                }
                com.kwad.components.ad.reward.b.ff().b(playableSource);
                return;
            }
            if (o.this.oP != null) {
                o.this.oP.hA();
            }
            if (lVar != null) {
                lVar.gW();
                com.kwad.sdk.core.d.b.d("RewardPlayablePresenter", "onEnterPlayable outer handled");
            } else if (com.kwad.sdk.core.response.a.a.ax(com.kwad.sdk.core.response.a.d.cb(o.this.qt.mAdTemplate))) {
                DownloadLandPageActivity.launch(o.this.getActivity(), o.this.qt.mAdTemplate, true);
            }
        }

        @Override // com.kwad.components.ad.reward.d.i, com.kwad.components.ad.reward.d.h
        public final void ca() {
            o.this.oP.hA();
            if (o.this.qt != null) {
                o.this.qt.d((PlayableSource) null);
                if (o.this.qt.oN.jF()) {
                    o.this.qt.oN.jG().resume();
                }
            }
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        com.kwad.components.core.playable.a aVar = this.qt.oP;
        this.oP = aVar;
        aVar.a(this.qt.mAdTemplate, this.qt.mRootContainer, this.qt.mApkDownloadHelper);
        com.kwad.components.ad.reward.monitor.a.a(this.qt.pf, "playable");
        com.kwad.components.ad.reward.monitor.a.a(this.qt.pf, "playable", com.kwad.sdk.core.response.a.a.bB(com.kwad.sdk.core.response.a.d.cb(this.qt.mAdTemplate)));
        this.oP.oX();
        this.oP.a(new ai.b() { // from class: com.kwad.components.ad.reward.presenter.o.2
            @Override // com.kwad.components.core.webview.jshandler.ai.b
            public final void a(ai.a aVar2) {
                if (aVar2.isSuccess()) {
                    return;
                }
                AdInfo cb = com.kwad.sdk.core.response.a.d.cb(o.this.qt.mAdTemplate);
                long loadTime = o.this.qt.oP.getLoadTime();
                if (loadTime == -1) {
                    return;
                }
                com.kwad.components.ad.reward.monitor.a.a(o.this.qt.pf, "playable", com.kwad.sdk.core.response.a.a.bB(cb), System.currentTimeMillis() - loadTime, 3);
            }
        });
        this.oP.a(new KsAdWebView.d() { // from class: com.kwad.components.ad.reward.presenter.o.3
            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageFinished() {
                AdInfo cb = com.kwad.sdk.core.response.a.d.cb(o.this.qt.mAdTemplate);
                long loadTime = o.this.qt.oP.getLoadTime();
                if (loadTime == -1) {
                    return;
                }
                com.kwad.components.ad.reward.monitor.a.a(o.this.qt.pf, "playable", com.kwad.sdk.core.response.a.a.bB(cb), System.currentTimeMillis() - loadTime);
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onReceivedHttpError(int i, String str, String str2) {
                com.kwad.components.ad.reward.monitor.a.a(o.this.qt.pf, "playable", com.kwad.sdk.core.response.a.a.bB(com.kwad.sdk.core.response.a.d.cb(o.this.qt.mAdTemplate)), System.currentTimeMillis() - o.this.qt.oP.getLoadTime(), 2);
            }
        });
        com.kwad.components.ad.reward.b.ff().a(this.sx);
    }

    public final void e(PlayableSource playableSource) {
        com.kwad.components.core.playable.a aVar = this.oP;
        if (aVar != null) {
            if (playableSource != null) {
                aVar.e(playableSource);
            } else {
                aVar.e(this.sw);
            }
        }
    }

    public final void hA() {
        com.kwad.components.core.playable.a aVar = this.oP;
        if (aVar != null) {
            aVar.hA();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        ((KsAdWebView) findViewById(R.id.ksad_playable_webview)).setVisibility(4);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.oP.oW();
        this.oP.hA();
        com.kwad.components.ad.reward.b.ff().b(this.sx);
    }
}
