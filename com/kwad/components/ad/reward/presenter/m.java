package com.kwad.components.ad.reward.presenter;

import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.sdk.utils.bi;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/m.class */
public final class m extends a {
    private AdLivePlayStateListener mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.m.2
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayCompleted() {
            super.onLivePlayCompleted();
            m.this.hx();
        }
    };
    private com.kwad.components.core.video.i mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.reward.presenter.m.3
        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
            super.onVideoPlayCompleted();
            m.this.hx();
        }
    };
    private final com.kwad.components.ad.reward.d.k gs = new com.kwad.components.ad.reward.d.k() { // from class: com.kwad.components.ad.reward.presenter.m.4
        @Override // com.kwad.components.ad.reward.d.k
        public final void a(com.kwad.components.core.webview.a.a.r rVar) {
            if (rVar == null || rVar.type != 1) {
                return;
            }
            m.this.qt.oN.release();
            m.this.qt.fH();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void hx() {
        if (com.kwad.components.core.r.h.e(this.qt.mAdTemplate, this.qt.pk)) {
            com.kwad.components.core.r.h.g(this.qt.mContext, this.qt.mAdTemplate);
        }
        if (h.y(this.qt) || com.kwad.components.core.r.h.e(this.qt.mAdTemplate, this.qt.pk)) {
            bi.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.m.1
                @Override // java.lang.Runnable
                public final void run() {
                    m.this.qt.fH();
                }
            }, 200L);
        } else {
            this.qt.fH();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.qt.oN.a(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
        com.kwad.components.ad.reward.d.fm().a(this.gs);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qt.oN.b(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
        com.kwad.components.ad.reward.d.fm().b(this.gs);
    }
}
