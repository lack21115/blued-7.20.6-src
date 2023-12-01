package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/p.class */
public final class p implements com.kwad.sdk.core.d<com.kwad.components.core.i.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.i.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.JR = jSONObject.optInt("currentActiveCount");
        aVar.JS = jSONObject.optLong("lastForceActiveTimestamp");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.i.a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (aVar.JR != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "currentActiveCount", aVar.JR);
        }
        if (aVar.JS != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "lastForceActiveTimestamp", aVar.JS);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.i.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.i.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
