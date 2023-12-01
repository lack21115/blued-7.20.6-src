package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.ad;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/cb.class */
public final class cb implements com.kwad.sdk.core.d<ad.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(ad.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.TA = jSONObject.optBoolean("clickActionButton");
        aVar.TB = jSONObject.optString("adTemplate");
        if (aVar.TB == JSONObject.NULL) {
            aVar.TB = "";
        }
        aVar.TC = jSONObject.optInt("area");
        aVar.TD = new com.kwad.sdk.core.webview.c.a.c();
        aVar.TD.parseJson(jSONObject.optJSONObject("logParam"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(ad.a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (aVar.TA) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "clickActionButton", aVar.TA);
        }
        if (aVar.TB != null && !aVar.TB.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "adTemplate", aVar.TB);
        }
        if (aVar.TC != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "area", aVar.TC);
        }
        com.kwad.sdk.utils.t.a(jSONObject2, "logParam", aVar.TD);
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ad.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ad.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
