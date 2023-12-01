package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/fx.class */
public final class fx implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.n> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.a.a.n nVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        nVar.url = jSONObject.optString("url");
        if (nVar.url == JSONObject.NULL) {
            nVar.url = "";
        }
        nVar.title = jSONObject.optString("title");
        if (nVar.title == JSONObject.NULL) {
            nVar.title = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.a.a.n nVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (nVar.url != null && !nVar.url.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "url", nVar.url);
        }
        if (nVar.title != null && !nVar.title.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "title", nVar.title);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.a.n nVar, JSONObject jSONObject) {
        a2(nVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.a.n nVar, JSONObject jSONObject) {
        return b2(nVar, jSONObject);
    }
}
