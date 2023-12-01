package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/ez.class */
public final class ez implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.l> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.a.a.l lVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        lVar.Ve = jSONObject.optString("landingPageUrl");
        if (lVar.Ve == JSONObject.NULL) {
            lVar.Ve = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.a.a.l lVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (lVar.Ve != null && !lVar.Ve.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "landingPageUrl", lVar.Ve);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.a.l lVar, JSONObject jSONObject) {
        a2(lVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.a.l lVar, JSONObject jSONObject) {
        return b2(lVar, jSONObject);
    }
}
