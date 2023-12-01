package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/gz.class */
public final class gz implements com.kwad.sdk.core.d<com.kwad.components.ad.reward.c.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.ad.reward.c.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.gq = jSONObject.optLong("lastShowTimestamp");
        bVar.rx = jSONObject.optInt("showInteractCount");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.ad.reward.c.b bVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (bVar.gq != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "lastShowTimestamp", bVar.gq);
        }
        if (bVar.rx != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "showInteractCount", bVar.rx);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.ad.reward.c.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.ad.reward.c.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
