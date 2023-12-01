package com.kwad.sdk.core.a.kwai;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/gu.class */
public final class gu implements com.kwad.sdk.core.d<com.kwad.sdk.ranger.a.kwai.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.ranger.a.kwai.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.amB = jSONObject.optInt("func_ratio_count");
        bVar.ayE = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("func_values");
        if (optJSONArray == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= optJSONArray.length()) {
                return;
            }
            com.kwad.sdk.ranger.a.kwai.a aVar = new com.kwad.sdk.ranger.a.kwai.a();
            aVar.parseJson(optJSONArray.optJSONObject(i2));
            bVar.ayE.add(aVar);
            i = i2 + 1;
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.ranger.a.kwai.b bVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (bVar.amB != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "func_ratio_count", bVar.amB);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "func_values", bVar.ayE);
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.ranger.a.kwai.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.ranger.a.kwai.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
