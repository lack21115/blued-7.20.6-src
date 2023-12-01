package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/ek.class */
public final class ek implements com.kwad.sdk.core.d<com.kwad.sdk.kwai.kwai.kwai.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.kwai.kwai.kwai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.gq = jSONObject.optLong("lastShowTimestamp");
        aVar.UX = jSONObject.optInt("showCount");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.kwai.kwai.kwai.a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (aVar.gq != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "lastShowTimestamp", aVar.gq);
        }
        if (aVar.UX != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "showCount", aVar.UX);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.kwai.kwai.kwai.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.kwai.kwai.kwai.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
