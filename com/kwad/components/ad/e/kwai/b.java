package com.kwad.components.ad.e.kwai;

import com.kwad.components.ad.e.d;
import com.kwad.components.core.d.b.c;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/e/kwai/b.class */
public final class b extends com.kwad.sdk.mvp.a {
    public c mApkDownloadHelper;
    public KsNativeAd.VideoPlayListener mM;
    public d.a mR;
    public AdBasePvFrameLayout nd;
    public com.kwad.components.ad.e.b.a nj;

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.clear();
        }
        this.nj.release();
    }
}
