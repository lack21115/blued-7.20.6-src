package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/hz.class */
public final class hz implements com.kwad.sdk.core.d<com.kwad.components.ad.splashscreen.local.c> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.ad.splashscreen.local.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.gq = jSONObject.optLong("lastShowTimestamp");
        cVar.gr = jSONObject.optInt("currentDailyCount");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.ad.splashscreen.local.c cVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (cVar.gq != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "lastShowTimestamp", cVar.gq);
        }
        if (cVar.gr != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "currentDailyCount", cVar.gr);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.ad.splashscreen.local.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.ad.splashscreen.local.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }
}
