package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.ranger.kwai.a;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/an.class */
public final class an implements com.kwad.sdk.core.d<com.kwad.sdk.ranger.kwai.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.ranger.kwai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.ayo = jSONObject.optString("nodeClassName");
        if (aVar.ayo == JSONObject.NULL) {
            aVar.ayo = "";
        }
        aVar.ayp = jSONObject.optString("childFieldName");
        if (aVar.ayp == JSONObject.NULL) {
            aVar.ayp = "";
        }
        aVar.ayq = jSONObject.optBoolean("childFieldIsStatic");
        aVar.ayr = jSONObject.optString("reportKey");
        if (aVar.ayr == JSONObject.NULL) {
            aVar.ayr = "";
        }
        aVar.ays = new a.b();
        aVar.ays.parseJson(jSONObject.optJSONObject("childMethod"));
        aVar.ayt = new com.kwad.sdk.ranger.kwai.a();
        aVar.ayt.parseJson(jSONObject.optJSONObject("deepNode"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.ranger.kwai.a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (aVar.ayo != null && !aVar.ayo.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "nodeClassName", aVar.ayo);
        }
        if (aVar.ayp != null && !aVar.ayp.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "childFieldName", aVar.ayp);
        }
        if (aVar.ayq) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "childFieldIsStatic", aVar.ayq);
        }
        if (aVar.ayr != null && !aVar.ayr.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "reportKey", aVar.ayr);
        }
        com.kwad.sdk.utils.t.a(jSONObject2, "childMethod", aVar.ays);
        com.kwad.sdk.utils.t.a(jSONObject2, "deepNode", aVar.ayt);
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.ranger.kwai.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.ranger.kwai.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
