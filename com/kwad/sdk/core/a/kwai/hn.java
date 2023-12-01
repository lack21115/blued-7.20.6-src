package com.kwad.sdk.core.a.kwai;

import com.kwad.components.ad.reward.h.t;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/hn.class */
public final class hn implements com.kwad.sdk.core.d<t.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(t.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.xe = jSONObject.optBoolean("needCloseNeo");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(t.a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (aVar.xe) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "needCloseNeo", aVar.xe);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(t.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(t.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
