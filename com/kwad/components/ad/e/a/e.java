package com.kwad.components.ad.e.a;

import com.kwad.sdk.api.KsNativeAd;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/e/a/e.class */
public final class e extends com.kwad.components.ad.e.kwai.a {
    private boolean bY = false;
    private KsNativeAd.VideoPlayListener mM;

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.mM = this.ni.mM;
        this.mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.e.a.e.1
            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayCompleted() {
                if (e.this.mM != null) {
                    e.this.mM.onVideoPlayComplete();
                }
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayError(int i, int i2) {
                if (e.this.mM != null) {
                    e.this.mM.onVideoPlayError(i, i2);
                }
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayPaused() {
                super.onVideoPlayPaused();
                if (e.this.mM != null) {
                    try {
                        e.this.mM.onVideoPlayPause();
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                    }
                }
                e.this.bY = true;
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayStart() {
                if (e.this.mM != null) {
                    e.this.mM.onVideoPlayStart();
                }
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlaying() {
                super.onVideoPlaying();
                if (e.this.bY) {
                    e.this.bY = false;
                    if (e.this.mM != null) {
                        try {
                            e.this.mM.onVideoPlayResume();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                        }
                    }
                }
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPrepared() {
                super.onVideoPrepared();
                if (e.this.mM != null) {
                    try {
                        e.this.mM.onVideoPlayReady();
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                    }
                }
            }
        };
        this.ni.nj.a(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
