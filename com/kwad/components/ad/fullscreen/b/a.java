package com.kwad.components.ad.fullscreen.b;

import com.kwad.components.ad.reward.d;
import com.kwad.components.ad.reward.d.k;
import com.kwad.components.core.video.i;
import com.kwad.components.core.video.j;
import com.kwad.components.core.webview.a.a.r;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/fullscreen/b/a.class */
public final class a extends com.kwad.components.ad.reward.presenter.a {
    private i mVideoPlayStateListener = new j() { // from class: com.kwad.components.ad.fullscreen.b.a.1
        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
            super.onVideoPlayCompleted();
            a.this.qt.fH();
        }
    };
    private AdLivePlayStateListener mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.fullscreen.b.a.2
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayCompleted() {
            super.onLivePlayCompleted();
            a.this.qt.fH();
        }
    };
    private final k gs = new k() { // from class: com.kwad.components.ad.fullscreen.b.a.3
        @Override // com.kwad.components.ad.reward.d.k
        public final void a(r rVar) {
            if (rVar == null || rVar.type != 1) {
                return;
            }
            a.this.qt.oN.release();
            a.this.qt.fH();
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.qt.oN.a(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
        d.fm().a(this.gs);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qt.oN.b(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
        d.fm().b(this.gs);
    }
}
