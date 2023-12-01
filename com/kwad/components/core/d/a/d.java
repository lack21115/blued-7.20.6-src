package com.kwad.components.core.d.a;

import com.kwad.components.core.d.a.b;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/d/a/d.class */
public final class d extends com.kwad.sdk.mvp.a {
    public b Iv;
    public b.C0518b Iw;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.d.b.c mApkDownloadHelper;
    public AdBaseFrameLayout mRootContainer;

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        com.kwad.components.core.d.b.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.clear();
        }
    }
}
