package com.kwad.components.core.webview.a.kwai;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/a/kwai/i.class */
public final class i implements com.kwad.sdk.core.webview.b.a {
    private a UH;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/a/kwai/i$a.class */
    public interface a {
        void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar);
    }

    public i(a aVar) {
        this.UH = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "notifyClickAd";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        com.kwad.sdk.core.webview.c.a.a aVar = new com.kwad.sdk.core.webview.c.a.a();
        try {
            aVar.parseJson(new JSONObject(str));
        } catch (JSONException e) {
            com.kwad.sdk.core.d.b.printStackTrace(e);
        }
        a aVar2 = this.UH;
        if (aVar2 != null) {
            aVar2.onAdClicked(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
