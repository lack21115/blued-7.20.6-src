package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/ey.class */
public final class ey implements com.kwad.sdk.core.d<com.kwad.sdk.utils.a.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.utils.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aCK = jSONObject.optInt("put_count");
        aVar.aCL = jSONObject.optInt("get_failed_count");
        aVar.aCM = jSONObject.optInt("get_success_count");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.utils.a.a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (aVar.aCK != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "put_count", aVar.aCK);
        }
        if (aVar.aCL != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "get_failed_count", aVar.aCL);
        }
        if (aVar.aCM != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "get_success_count", aVar.aCM);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.utils.a.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.utils.a.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
