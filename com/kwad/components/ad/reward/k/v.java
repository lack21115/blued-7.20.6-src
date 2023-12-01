package com.kwad.components.ad.reward.k;

import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/k/v.class */
public final class v {
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;

    private v() {
    }

    public static v B(AdTemplate adTemplate) {
        v vVar = new v();
        vVar.setAdTemplate(adTemplate);
        return vVar;
    }

    public static v a(AdTemplate adTemplate, com.kwad.components.core.d.b.c cVar) {
        v vVar = new v();
        vVar.setAdTemplate(adTemplate);
        vVar.setApkDownloadHelper(cVar);
        return vVar;
    }

    private void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    private void setApkDownloadHelper(com.kwad.components.core.d.b.c cVar) {
        this.mApkDownloadHelper = cVar;
    }

    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    public final com.kwad.components.core.d.b.c hb() {
        return this.mApkDownloadHelper;
    }
}
