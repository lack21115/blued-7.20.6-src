package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/hw.class */
public final class hw implements com.kwad.sdk.core.d<com.kwad.sdk.internal.api.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.internal.api.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.disableShake = jSONObject.optBoolean("disableShake");
        bVar.disableRotate = jSONObject.optBoolean("disableRotate");
        bVar.disableSlide = jSONObject.optBoolean("disableSlide");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.internal.api.b bVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (bVar.disableShake) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "disableShake", bVar.disableShake);
        }
        if (bVar.disableRotate) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "disableRotate", bVar.disableRotate);
        }
        if (bVar.disableSlide) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "disableSlide", bVar.disableSlide);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.internal.api.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.internal.api.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
