package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/cu.class */
public final class cu implements com.kwad.sdk.core.d<com.kwad.sdk.core.report.l> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.report.l lVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        lVar.air = jSONObject.optString("log");
        if (lVar.air == JSONObject.NULL) {
            lVar.air = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.report.l lVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (lVar.air != null && !lVar.air.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "log", lVar.air);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.report.l lVar, JSONObject jSONObject) {
        a2(lVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.report.l lVar, JSONObject jSONObject) {
        return b2(lVar, jSONObject);
    }
}
