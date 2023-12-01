package com.kwad.components.ad.reward.presenter;

import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/presenter/l.class */
public final class l extends a {
    private long gM;
    private com.kwad.components.ad.reward.d.b mAdOpenInteractionListener;
    private AdLivePlayStateListener mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.l.1
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayCompleted() {
            super.onLivePlayCompleted();
            if (l.this.qt.pf && l.this.qt.pk) {
                l.this.mAdOpenInteractionListener.onVideoSkipToEnd(l.this.gM);
            } else {
                l.this.qt.pC = true;
                l.this.mAdOpenInteractionListener.onVideoPlayEnd();
            }
            AdInfo cb = com.kwad.sdk.core.response.a.d.cb(l.this.qt.mAdTemplate);
            if (com.kwad.sdk.core.response.a.a.aG(cb) && com.kwad.sdk.core.response.a.a.aF(cb) == 1) {
                return;
            }
            e.u(l.this.qt);
            if (l.this.qt.pC) {
                com.kwad.components.ad.reward.m.m(l.this.qt);
            }
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j) {
            super.onLivePlayProgress(j);
            l.this.qt.pB = j;
            if (l.this.qt.pk) {
                return;
            }
            l.this.gM = j;
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayStart() {
            super.onLivePlayStart();
            l.this.mAdOpenInteractionListener.onVideoPlayStart();
            l.this.qt.pC = false;
        }
    };
    private final com.kwad.components.core.video.i mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.reward.presenter.l.2
        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
            if (l.this.qt.pk) {
                l.this.mAdOpenInteractionListener.onVideoSkipToEnd(l.this.gM);
            } else {
                l.this.mAdOpenInteractionListener.onVideoPlayEnd();
            }
            AdInfo cb = com.kwad.sdk.core.response.a.d.cb(l.this.qt.mAdTemplate);
            if (com.kwad.sdk.core.response.a.a.aG(cb) && com.kwad.sdk.core.response.a.a.aF(cb) == 1) {
                return;
            }
            e.u(l.this.qt);
            if (l.this.qt.pC) {
                com.kwad.components.ad.reward.m.m(l.this.qt);
            }
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayError(int i, int i2) {
            l.this.mAdOpenInteractionListener.onVideoPlayError(i, i2);
            l.this.hq();
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j, long j2) {
            l.this.qt.pB = j2;
            l.this.qt.pC = j - j2 < 800;
            if (l.this.qt.pk) {
                return;
            }
            l.this.gM = j2;
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayStart() {
            l.this.mAdOpenInteractionListener.onVideoPlayStart();
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.qt.pB = 0L;
        this.qt.pC = false;
        this.mAdOpenInteractionListener = this.qt.mAdOpenInteractionListener;
        this.qt.oN.a(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qt.oN.b(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
    }
}
