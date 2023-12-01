package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/hp.class */
public final class hp implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.t> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.a.a.t tVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tVar.message = jSONObject.optString("message");
        if (tVar.message == JSONObject.NULL) {
            tVar.message = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.a.a.t tVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (tVar.message != null && !tVar.message.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "message", tVar.message);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.a.t tVar, JSONObject jSONObject) {
        a2(tVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.a.t tVar, JSONObject jSONObject) {
        return b2(tVar, jSONObject);
    }
}
