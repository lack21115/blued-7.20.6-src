package com.kwad.components.ad.e.kwai;

import com.kwad.components.core.video.i;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/e/kwai/a.class */
public class a extends Presenter {
    public i mVideoPlayStateListener;
    public b ni;

    @Override // com.kwad.sdk.mvp.Presenter
    public void ar() {
        super.ar();
        this.ni = (b) Bh();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        this.ni.nj.b(this.mVideoPlayStateListener);
    }
}
