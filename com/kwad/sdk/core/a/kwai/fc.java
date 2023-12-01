package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/fc.class */
public final class fc implements com.kwad.sdk.core.d<com.kwad.components.ad.fullscreen.a.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.ad.fullscreen.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.gq = jSONObject.optLong("lastShowTimestamp");
        bVar.gr = jSONObject.optInt("currentDailyCount");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.ad.fullscreen.a.b bVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (bVar.gq != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "lastShowTimestamp", bVar.gq);
        }
        if (bVar.gr != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "currentDailyCount", bVar.gr);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.ad.fullscreen.a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.ad.fullscreen.a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
