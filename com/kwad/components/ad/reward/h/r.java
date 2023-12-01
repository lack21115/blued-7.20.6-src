package com.kwad.components.ad.reward.h;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bi;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/h/r.class */
public final class r implements com.kwad.sdk.core.webview.b.a {
    private AdTemplate mAdTemplate;
    private com.kwad.components.ad.reward.j xc;

    public r(com.kwad.components.ad.reward.j jVar, AdTemplate adTemplate) {
        this.xc = jVar;
        this.mAdTemplate = adTemplate;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "neoDidShowPlayAgain";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        try {
            this.mAdTemplate.isPlayAgainData = true;
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.h.r.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (r.this.xc != null) {
                        r.this.xc.B(true);
                    }
                }
            });
        } catch (Exception e) {
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            adTemplate.isPlayAgainData = false;
        }
    }
}
