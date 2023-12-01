package com.kwad.components.core.webview.a.kwai;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/a/kwai/j.class */
public class j implements com.kwad.sdk.core.webview.b.a {
    public void a(com.kwad.components.core.webview.a.a.n nVar) {
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public String getKey() {
        return "openURL";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        com.kwad.components.core.webview.a.a.n nVar = new com.kwad.components.core.webview.a.a.n();
        try {
            nVar.parseJson(new JSONObject(str));
            a(nVar);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public void onDestroy() {
    }
}
