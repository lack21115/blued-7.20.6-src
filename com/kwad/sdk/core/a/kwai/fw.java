package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/fw.class */
public final class fw implements com.kwad.sdk.core.d<com.kwad.components.core.webview.kwai.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.kwai.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.url = jSONObject.optString("url");
        if (bVar.url == JSONObject.NULL) {
            bVar.url = "";
        }
        bVar.title = jSONObject.optString("title");
        if (bVar.title == JSONObject.NULL) {
            bVar.title = "";
        }
        bVar.params = jSONObject.optString("params");
        if (bVar.params == JSONObject.NULL) {
            bVar.params = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.kwai.b bVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (bVar.url != null && !bVar.url.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "url", bVar.url);
        }
        if (bVar.title != null && !bVar.title.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "title", bVar.title);
        }
        if (bVar.params != null && !bVar.params.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "params", bVar.params);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.kwai.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.kwai.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
