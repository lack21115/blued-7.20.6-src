package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.ranger.d;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/gt.class */
public final class gt implements com.kwad.sdk.core.d<com.kwad.sdk.ranger.d> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.ranger.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.axS = jSONObject.optLong("funcSwitch");
        dVar.axT = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("urlList");
        if (optJSONArray != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    break;
                }
                dVar.axT.add((String) optJSONArray.opt(i2));
                i = i2 + 1;
            }
        }
        dVar.axU = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("actConfigList");
        if (optJSONArray2 != null) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= optJSONArray2.length()) {
                    break;
                }
                d.a aVar = new d.a();
                aVar.parseJson(optJSONArray2.optJSONObject(i4));
                dVar.axU.add(aVar);
                i3 = i4 + 1;
            }
        }
        dVar.axV = jSONObject.optLong("byteCount");
        dVar.axW = jSONObject.optDouble("sampleRate");
        dVar.axX = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("anchorNodeList");
        if (optJSONArray3 == null) {
            return;
        }
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= optJSONArray3.length()) {
                return;
            }
            com.kwad.sdk.ranger.kwai.a aVar2 = new com.kwad.sdk.ranger.kwai.a();
            aVar2.parseJson(optJSONArray3.optJSONObject(i6));
            dVar.axX.add(aVar2);
            i5 = i6 + 1;
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.ranger.d dVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (dVar.axS != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "funcSwitch", dVar.axS);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "urlList", dVar.axT);
        com.kwad.sdk.utils.t.putValue(jSONObject2, "actConfigList", dVar.axU);
        if (dVar.axV != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "byteCount", dVar.axV);
        }
        if (dVar.axW != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "sampleRate", dVar.axW);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "anchorNodeList", dVar.axX);
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.ranger.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.ranger.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }
}
