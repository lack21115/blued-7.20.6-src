package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/u.class */
public final class u implements com.kwad.sdk.core.d<com.kwad.sdk.internal.api.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.internal.api.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aaM = jSONObject.optInt("thirdAge");
        aVar.aaN = jSONObject.optInt("thirdGender");
        aVar.aaO = jSONObject.optString("thirdInterest");
        if (aVar.aaO == JSONObject.NULL) {
            aVar.aaO = "";
        }
        aVar.aaP = jSONObject.optString("prevTitle");
        if (aVar.aaP == JSONObject.NULL) {
            aVar.aaP = "";
        }
        aVar.aaQ = jSONObject.optString("postTitle");
        if (aVar.aaQ == JSONObject.NULL) {
            aVar.aaQ = "";
        }
        aVar.aaR = jSONObject.optString("historyTitle");
        if (aVar.aaR == JSONObject.NULL) {
            aVar.aaR = "";
        }
        aVar.aaS = jSONObject.optString("channel");
        if (aVar.aaS == JSONObject.NULL) {
            aVar.aaS = "";
        }
        aVar.aaT = jSONObject.optLong("cpmBidFloor");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.internal.api.a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (aVar.aaM != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "thirdAge", aVar.aaM);
        }
        if (aVar.aaN != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "thirdGender", aVar.aaN);
        }
        if (aVar.aaO != null && !aVar.aaO.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "thirdInterest", aVar.aaO);
        }
        if (aVar.aaP != null && !aVar.aaP.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "prevTitle", aVar.aaP);
        }
        if (aVar.aaQ != null && !aVar.aaQ.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "postTitle", aVar.aaQ);
        }
        if (aVar.aaR != null && !aVar.aaR.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "historyTitle", aVar.aaR);
        }
        if (aVar.aaS != null && !aVar.aaS.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "channel", aVar.aaS);
        }
        if (aVar.aaT != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "cpmBidFloor", aVar.aaT);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.internal.api.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.internal.api.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
