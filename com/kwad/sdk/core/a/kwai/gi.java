package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/gi.class */
public final class gi implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.p> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.a.a.p pVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        pVar.Vh = jSONObject.optBoolean("isPlayAgainScene");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.a.a.p pVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (pVar.Vh) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "isPlayAgainScene", pVar.Vh);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.a.p pVar, JSONObject jSONObject) {
        a2(pVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.a.p pVar, JSONObject jSONObject) {
        return b2(pVar, jSONObject);
    }
}
