package com.kwad.components.core.webview.a.kwai;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/a/kwai/d.class */
public class d implements com.kwad.sdk.core.webview.b.a {
    public void a(com.kwad.components.core.webview.a.a.g gVar) {
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public String getKey() {
        return "commonLog";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        com.kwad.components.core.webview.a.a.g gVar = new com.kwad.components.core.webview.a.a.g();
        try {
            gVar.parseJson(new JSONObject(str));
            a(gVar);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public void onDestroy() {
    }
}
