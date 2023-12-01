package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.ranger.kwai.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/in.class */
public final class in implements com.kwad.sdk.core.d<a.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.name = jSONObject.optString("name");
        if (bVar.name == JSONObject.NULL) {
            bVar.name = "";
        }
        bVar.ayB = jSONObject.optBoolean("isStatic");
        bVar.ayC = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("paramList");
        if (optJSONArray == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= optJSONArray.length()) {
                return;
            }
            a.C0407a c0407a = new a.C0407a();
            c0407a.parseJson(optJSONArray.optJSONObject(i2));
            bVar.ayC.add(c0407a);
            i = i2 + 1;
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.b bVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (bVar.name != null && !bVar.name.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "name", bVar.name);
        }
        if (bVar.ayB) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "isStatic", bVar.ayB);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "paramList", bVar.ayC);
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
