package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/ig.class */
public final class ig implements com.kwad.sdk.core.d<com.kwad.sdk.ranger.a.kwai.c> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.ranger.a.kwai.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.name = jSONObject.optString("name");
        if (cVar.name == JSONObject.NULL) {
            cVar.name = "";
        }
        cVar.ayF = jSONObject.optString("detect_info");
        if (cVar.ayF == JSONObject.NULL) {
            cVar.ayF = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.ranger.a.kwai.c cVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (cVar.name != null && !cVar.name.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "name", cVar.name);
        }
        if (cVar.ayF != null && !cVar.ayF.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "detect_info", cVar.ayF);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.ranger.a.kwai.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.ranger.a.kwai.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }
}
