package com.kwad.components.ad.e.a;

import android.view.View;
import com.kwad.sdk.R;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/e/a/j.class */
public final class j extends com.kwad.components.ad.e.kwai.a {
    private View nF;

    /* JADX INFO: Access modifiers changed from: private */
    public void eX() {
        if (this.nF.getVisibility() == 0) {
            return;
        }
        this.nF.setVisibility(0);
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.nF.setVisibility(8);
        this.mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.e.a.j.1
            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayError(int i, int i2) {
                j.this.eX();
            }
        };
        this.ni.nj.a(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.nF = findViewById(R.id.ksad_video_error_container);
    }
}
