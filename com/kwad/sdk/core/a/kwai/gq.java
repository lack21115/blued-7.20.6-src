package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/gq.class */
public final class gq implements com.kwad.sdk.core.d<com.kwad.sdk.core.response.model.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.posId = jSONObject.optLong("posId");
        aVar.alO = jSONObject.optInt("adPhotoCountForMedia");
        aVar.alP = jSONObject.optBoolean("enablePreload");
        aVar.alQ = jSONObject.optLong("increaseAdLoadTime", new Long("10000").longValue());
        aVar.alR = jSONObject.optInt("adLoadStrategy");
        aVar.alS = jSONObject.optInt("drawAdForcedWatchTimes", new Integer("3").intValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (aVar.posId != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "posId", aVar.posId);
        }
        if (aVar.alO != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "adPhotoCountForMedia", aVar.alO);
        }
        if (aVar.alP) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "enablePreload", aVar.alP);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "increaseAdLoadTime", aVar.alQ);
        if (aVar.alR != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "adLoadStrategy", aVar.alR);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "drawAdForcedWatchTimes", aVar.alS);
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.response.model.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
