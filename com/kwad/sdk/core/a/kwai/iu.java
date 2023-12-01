package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/iu.class */
public final class iu implements com.kwad.sdk.core.d<com.kwad.sdk.core.threads.d> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.threads.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.amD = jSONObject.optInt("rate_reciprocal");
        dVar.amJ = jSONObject.optInt("threshold");
        dVar.interval = jSONObject.optLong(com.umeng.analytics.pro.bh.aX);
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.threads.d dVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (dVar.amD != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "rate_reciprocal", dVar.amD);
        }
        if (dVar.amJ != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "threshold", dVar.amJ);
        }
        if (dVar.interval != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, com.umeng.analytics.pro.bh.aX, dVar.interval);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.threads.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.threads.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }
}
