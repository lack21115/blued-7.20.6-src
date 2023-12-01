package com.kwad.sdk.core.a.kwai;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/fz.class */
public final class fz implements com.kwad.sdk.core.d<com.kwad.sdk.f.kwai.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.f.kwai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.sceneId = jSONObject.optString("sceneId");
        if (aVar.sceneId == JSONObject.NULL) {
            aVar.sceneId = "";
        }
        aVar.atl = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("packages");
        if (optJSONArray == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= optJSONArray.length()) {
                return;
            }
            com.kwad.sdk.f.kwai.b bVar = new com.kwad.sdk.f.kwai.b();
            bVar.parseJson(optJSONArray.optJSONObject(i2));
            aVar.atl.add(bVar);
            i = i2 + 1;
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.f.kwai.a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (aVar.sceneId != null && !aVar.sceneId.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "sceneId", aVar.sceneId);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "packages", aVar.atl);
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.f.kwai.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.f.kwai.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
