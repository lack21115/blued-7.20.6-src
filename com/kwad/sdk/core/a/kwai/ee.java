package com.kwad.sdk.core.a.kwai;

import com.anythink.pd.ExHandler;
import com.kwad.sdk.core.config.item.h;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/ee.class */
public final class ee implements com.kwad.sdk.core.d<h.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(h.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.adV = jSONObject.optString(ExHandler.JSON_REQUEST_IMEI);
        if (aVar.adV == JSONObject.NULL) {
            aVar.adV = "";
        }
        aVar.adW = jSONObject.optString("oaid");
        if (aVar.adW == JSONObject.NULL) {
            aVar.adW = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(h.a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (aVar.adV != null && !aVar.adV.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, ExHandler.JSON_REQUEST_IMEI, aVar.adV);
        }
        if (aVar.adW != null && !aVar.adW.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "oaid", aVar.adW);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(h.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(h.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
