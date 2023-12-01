package com.kwad.components.core.webview.a.kwai;

import com.kwad.sdk.core.response.model.AdStatusInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.Observable;
import java.util.Observer;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/a/kwai/a.class */
public final class a extends v implements Observer {
    private AdTemplate mAdTemplate;

    public a(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "getTrackAdStatus";
    }

    @Override // com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        super.handleJsCall(str, cVar);
        b(this.mAdTemplate.mAdStatusInfo);
    }

    @Override // java.util.Observer
    public final void update(Observable observable, Object obj) {
        AdStatusInfo adStatusInfo = (AdStatusInfo) obj;
        if (adStatusInfo != null) {
            b(adStatusInfo);
        }
    }
}
