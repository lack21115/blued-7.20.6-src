package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/hm.class */
public final class hm implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.r> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.a.a.r rVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rVar.Vj = jSONObject.optBoolean("userForce");
        rVar.type = jSONObject.optInt("type");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.a.a.r rVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (rVar.Vj) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "userForce", rVar.Vj);
        }
        if (rVar.type != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "type", rVar.type);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.a.r rVar, JSONObject jSONObject) {
        a2(rVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.a.r rVar, JSONObject jSONObject) {
        return b2(rVar, jSONObject);
    }
}
