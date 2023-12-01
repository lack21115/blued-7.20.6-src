package com.kwad.sdk.core.a.kwai;

import com.kwad.components.ad.reward.b.e;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/cx.class */
public final class cx implements com.kwad.sdk.core.d<e.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(e.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.ru = jSONObject.optString("dialogEvent");
        if (aVar.ru == JSONObject.NULL) {
            aVar.ru = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(e.a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (aVar.ru != null && !aVar.ru.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "dialogEvent", aVar.ru);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(e.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(e.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
