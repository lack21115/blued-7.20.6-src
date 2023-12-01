package com.kwad.components.ad.e.a;

import android.widget.ProgressBar;
import com.kwad.sdk.R;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/e/a/k.class */
public final class k extends com.kwad.components.ad.e.kwai.a {
    private ProgressBar nH;

    /* JADX INFO: Access modifiers changed from: private */
    public void K(int i) {
        this.nH.setProgress(i);
        if (this.nH.getVisibility() == 0) {
            return;
        }
        this.nH.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eY() {
        if (this.nH.getVisibility() != 0) {
            return;
        }
        this.nH.setVisibility(8);
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.nH.setProgress(0);
        this.nH.setVisibility(8);
        this.mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.e.a.k.1
            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayCompleted() {
                k.this.eY();
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayError(int i, int i2) {
                k.this.eY();
            }

            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayProgress(long j, long j2) {
                k.this.K(j != 0 ? (int) ((((float) j2) * 100.0f) / ((float) j)) : 0);
            }
        };
        this.ni.nj.a(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.nH = (ProgressBar) findViewById(R.id.ksad_video_progress);
    }
}
