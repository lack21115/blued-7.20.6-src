package com.kwad.components.core.webview.a.kwai;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/a/kwai/r.class */
public class r implements com.kwad.sdk.core.webview.b.a {
    public void a(com.kwad.components.core.webview.a.a.s sVar) {
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public String getKey() {
        return "showTKDialog";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        com.kwad.components.core.webview.a.a.s sVar = new com.kwad.components.core.webview.a.a.s();
        try {
            sVar.parseJson(new JSONObject(str));
            a(sVar);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public void onDestroy() {
    }
}
