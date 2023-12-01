package com.kwad.components.ad.reward.h.kwai;

import com.kwad.components.ad.reward.j;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/h/kwai/a.class */
public final class a extends com.kwad.components.core.webview.a.b.b {
    private j xc;

    public a(j jVar) {
        this.xc = jVar;
    }

    public final void b(com.kwad.components.ad.reward.b.b bVar) {
        com.kwad.components.ad.reward.b.a.gQ().a(this.mAdTemplate, bVar);
    }

    public final j jd() {
        return this.xc;
    }

    @Override // com.kwad.components.core.webview.a.b.b, com.kwad.sdk.mvp.a
    public final void release() {
        super.release();
        this.xc = null;
    }
}
