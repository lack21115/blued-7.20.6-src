package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/cf.class */
public final class cf implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.h> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.a.a.h hVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        hVar.Va = jSONObject.optInt("hasDeepReward");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.a.a.h hVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (hVar.Va != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "hasDeepReward", hVar.Va);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.a.h hVar, JSONObject jSONObject) {
        a2(hVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.a.h hVar, JSONObject jSONObject) {
        return b2(hVar, jSONObject);
    }
}
