package com.kwad.components.ad.h;

import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.b;
import com.kwad.components.core.video.i;
import com.kwad.components.core.video.j;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/h/a.class */
public class a {
    public b Gj;
    private boolean Gk = false;
    private i Gl = new j() { // from class: com.kwad.components.ad.h.a.1
        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayCompleted() {
            a.this.mAdTemplate.setmCurPlayTime(-1L);
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayError(int i, int i2) {
            super.onVideoPlayError(i, i2);
            if (!a.this.Gk) {
                a.this.lH();
            } else if (d.uQ()) {
                a.this.lH();
            }
        }

        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j, long j2) {
            a.this.mAdTemplate.setmCurPlayTime(j2);
        }
    };
    public AdTemplate mAdTemplate;
    protected DetailVideoView mDetailVideoView;

    public a(AdTemplate adTemplate, DetailVideoView detailVideoView) {
        this.mAdTemplate = adTemplate;
        this.mDetailVideoView = detailVideoView;
        this.Gj = new b(detailVideoView);
        lF();
    }

    private void lF() {
        this.Gj.c(this.Gl);
    }

    private void lG() {
        i iVar;
        b bVar = this.Gj;
        if (bVar == null || (iVar = this.Gl) == null) {
            return;
        }
        bVar.d(iVar);
        this.Gl = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lH() {
        com.kwad.components.core.m.a.pb().g(this.mAdTemplate, 21008);
        this.Gk = true;
    }

    public void release() {
        this.Gk = false;
        lG();
    }

    public void releaseSync() {
        this.Gk = false;
        lG();
    }
}
