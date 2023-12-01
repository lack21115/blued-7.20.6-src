package com.kwad.components.ad.draw.a.b;

import com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame;
import com.kwad.components.core.video.i;
import com.kwad.components.core.video.j;
import com.kwad.sdk.R;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/draw/a/b/a.class */
public final class a extends com.kwad.components.ad.draw.kwai.a {
    private com.kwad.components.ad.i.b cp;
    private DrawVideoTailFrame dd;
    private i mVideoPlayStateListener = new j() { // from class: com.kwad.components.ad.draw.a.b.a.1
        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
            super.onVideoPlayCompleted();
            if (a.this.cp == null || !a.this.cp.az()) {
                a.this.aQ();
            } else {
                a.this.dd.setVisibility(8);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void aQ() {
        this.dd.aX();
        this.dd.setVisibility(0);
    }

    @Override // com.kwad.components.ad.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.cp = this.bW.cp;
        this.dd.bindView(this.bW.mAdTemplate);
        this.dd.setAdBaseFrameLayout(this.bW.mRootContainer);
        this.dd.setApkDownloadHelper(this.bW.mApkDownloadHelper);
        this.dd.setVisibility(8);
        this.dd.setAdInteractionListener(this.bW.bV);
        this.bW.bX.a(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.dd = (DrawVideoTailFrame) findViewById(R.id.ksad_video_tail_frame);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.bW.bX.b(this.mVideoPlayStateListener);
        this.dd.release();
    }
}
