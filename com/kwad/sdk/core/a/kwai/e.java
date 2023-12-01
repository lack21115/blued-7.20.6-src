package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/e.class */
public final class e implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.c.a.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.webview.c.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.TA = jSONObject.optBoolean("clickActionButton");
        aVar.TC = jSONObject.optInt("area");
        aVar.jU = jSONObject.optInt("itemClickType");
        aVar.aqn = jSONObject.optInt("convertPageType", new Integer("-1").intValue());
        aVar.TD = new com.kwad.sdk.core.webview.c.a.c();
        aVar.TD.parseJson(jSONObject.optJSONObject("logParam"));
        aVar.IQ = jSONObject.optBoolean("needReport", new Boolean(com.huawei.hms.ads.fw.Code).booleanValue());
        aVar.creativeId = jSONObject.optLong("creativeId", new Long("-1").longValue());
        aVar.IY = jSONObject.optString("liveItemId");
        if (aVar.IY == JSONObject.NULL) {
            aVar.IY = "";
        }
        aVar.aqo = jSONObject.optInt("sceneType");
        aVar.adStyle = jSONObject.optInt("adStyle", new Integer("-1").intValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.webview.c.a.a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (aVar.TA) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "clickActionButton", aVar.TA);
        }
        if (aVar.TC != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "area", aVar.TC);
        }
        if (aVar.jU != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "itemClickType", aVar.jU);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "convertPageType", aVar.aqn);
        com.kwad.sdk.utils.t.a(jSONObject2, "logParam", aVar.TD);
        com.kwad.sdk.utils.t.putValue(jSONObject2, "needReport", aVar.IQ);
        com.kwad.sdk.utils.t.putValue(jSONObject2, "creativeId", aVar.creativeId);
        if (aVar.IY != null && !aVar.IY.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "liveItemId", aVar.IY);
        }
        if (aVar.aqo != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "sceneType", aVar.aqo);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "adStyle", aVar.adStyle);
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.webview.c.a.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.webview.c.a.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
