package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/gk.class */
public final class gk implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.q> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.a.a.q qVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        qVar.Vi = jSONObject.optBoolean("isEnd");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.a.a.q qVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (qVar.Vi) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "isEnd", qVar.Vi);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.a.q qVar, JSONObject jSONObject) {
        a2(qVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.a.q qVar, JSONObject jSONObject) {
        return b2(qVar, jSONObject);
    }
}
