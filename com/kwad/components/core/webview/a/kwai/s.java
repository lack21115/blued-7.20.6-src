package com.kwad.components.core.webview.a.kwai;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/a/kwai/s.class */
public final class s implements com.kwad.sdk.core.webview.b.a {
    private a UL;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/a/kwai/s$a.class */
    public interface a {
        void a(com.kwad.components.core.webview.a.a.t tVar);
    }

    public final void a(a aVar) {
        this.UL = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "showToast";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        if (this.UL != null) {
            com.kwad.components.core.webview.a.a.t tVar = new com.kwad.components.core.webview.a.a.t();
            try {
                tVar.parseJson(new JSONObject(str));
                this.UL.a(tVar);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.UL = null;
    }
}
