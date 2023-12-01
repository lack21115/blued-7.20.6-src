package com.kwad.components.core.webview.a;

import android.text.TextUtils;
import com.kwad.components.core.webview.a.a.l;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/a/a.class */
public final class a implements com.kwad.sdk.core.webview.b.a {
    private final AdTemplate mAdTemplate;

    public a(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "getLandingPageInfo";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        String str2;
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            String aK = com.kwad.sdk.core.response.a.a.aK(com.kwad.sdk.core.response.a.d.cb(adTemplate));
            if (!TextUtils.isEmpty(aK)) {
                l lVar = new l();
                lVar.Ve = aK;
                cVar.a(lVar);
                return;
            }
            str2 = "landing page url is null";
        } else {
            str2 = "adTemplate is null";
        }
        cVar.onError(-1, str2);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
