package com.kwad.components.ad.draw.kwai;

import com.kwad.components.core.d.b.c;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.view.AdBaseFrameLayout;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/draw/kwai/b.class */
public final class b extends com.kwad.sdk.mvp.a {
    public KsDrawAd.AdInteractionListener bV;
    public com.kwad.components.ad.draw.b.a bX;
    public com.kwad.components.ad.draw.a.a.a co;
    public com.kwad.components.ad.i.b cp;
    public c mApkDownloadHelper;
    public AdBaseFrameLayout mRootContainer;

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.clear();
        }
        this.bX.release();
    }
}
