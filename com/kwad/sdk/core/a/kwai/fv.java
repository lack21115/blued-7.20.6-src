package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/fv.class */
public final class fv implements com.kwad.sdk.core.d<com.kwad.components.core.offline.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.offline.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.JX = jSONObject.optInt("load_module");
        bVar.JY = jSONObject.optLong("load_status");
        bVar.JZ = jSONObject.optLong("load_duration_ms");
        bVar.Ka = jSONObject.optLong("error_code");
        bVar.Kb = jSONObject.optLong("error_msg");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.offline.b bVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (bVar.JX != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "load_module", bVar.JX);
        }
        if (bVar.JY != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "load_status", bVar.JY);
        }
        if (bVar.JZ != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "load_duration_ms", bVar.JZ);
        }
        if (bVar.Ka != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "error_code", bVar.Ka);
        }
        if (bVar.Kb != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "error_msg", bVar.Kb);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.offline.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.offline.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
