package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.ranger.d;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/b.class */
public final class b implements com.kwad.sdk.core.d<d.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(d.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.axY = jSONObject.optString("originalActStr");
        if (aVar.axY == JSONObject.NULL) {
            aVar.axY = "";
        }
        aVar.axZ = jSONObject.optString("targetField");
        if (aVar.axZ == JSONObject.NULL) {
            aVar.axZ = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(d.a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (aVar.axY != null && !aVar.axY.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "originalActStr", aVar.axY);
        }
        if (aVar.axZ != null && !aVar.axZ.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "targetField", aVar.axZ);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(d.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(d.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
