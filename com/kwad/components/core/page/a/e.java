package com.kwad.components.core.page.a;

import android.app.Activity;
import com.kwad.components.core.video.i;
import com.kwad.components.core.video.j;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/page/a/e.class */
public final class e extends c {
    private com.kwad.components.core.page.b.a mPlayModule;
    private i mVideoPlayStateListener = new j() { // from class: com.kwad.components.core.page.a.e.1
        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayError(int i, int i2) {
            Activity activity = e.this.LA.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayStart() {
        }
    };

    @Override // com.kwad.components.core.page.a.c, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        com.kwad.components.core.page.b.a aVar = this.LA.mPlayModule;
        this.mPlayModule = aVar;
        aVar.a(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mPlayModule.b(this.mVideoPlayStateListener);
    }
}
