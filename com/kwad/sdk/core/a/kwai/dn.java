package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/dn.class */
public final class dn implements com.kwad.sdk.core.d<com.kwad.sdk.ranger.a.kwai.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.ranger.a.kwai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.key = jSONObject.optString("key");
        if (aVar.key == JSONObject.NULL) {
            aVar.key = "";
        }
        aVar.value = jSONObject.optInt("value");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.ranger.a.kwai.a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (aVar.key != null && !aVar.key.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "key", aVar.key);
        }
        if (aVar.value != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "value", aVar.value);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.ranger.a.kwai.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.ranger.a.kwai.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
