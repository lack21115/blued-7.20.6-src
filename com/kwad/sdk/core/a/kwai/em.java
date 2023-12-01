package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/em.class */
public final class em implements com.kwad.sdk.core.d<com.kwad.components.ad.interstitial.b.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.ad.interstitial.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.jl = jSONObject.optLong("lastShowCardTimeStamp");
        aVar.jm = jSONObject.optInt("cardShowCount");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.ad.interstitial.b.a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (aVar.jl != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "lastShowCardTimeStamp", aVar.jl);
        }
        if (aVar.jm != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "cardShowCount", aVar.jm);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.ad.interstitial.b.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.ad.interstitial.b.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
