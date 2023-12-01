package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/cz.class */
public final class cz implements com.kwad.sdk.core.d<com.kwad.sdk.crash.online.monitor.kwai.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.crash.online.monitor.kwai.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.appId = jSONObject.optString("appId");
        if (bVar.appId == JSONObject.NULL) {
            bVar.appId = "";
        }
        bVar.asn = jSONObject.optString("pluginListenerName");
        if (bVar.asn == JSONObject.NULL) {
            bVar.asn = "";
        }
        bVar.aso = jSONObject.optString("reportMethodName");
        if (bVar.aso == JSONObject.NULL) {
            bVar.aso = "";
        }
        bVar.asp = jSONObject.optString("otherProxyClassName");
        if (bVar.asp == JSONObject.NULL) {
            bVar.asp = "";
        }
        bVar.asq = jSONObject.optString("otherFieldName");
        if (bVar.asq == JSONObject.NULL) {
            bVar.asq = "";
        }
        bVar.asr = jSONObject.optString("otherLevelFieldName");
        if (bVar.asr == JSONObject.NULL) {
            bVar.asr = "";
        }
        bVar.ass = jSONObject.optString("blockTag");
        if (bVar.ass == JSONObject.NULL) {
            bVar.ass = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.crash.online.monitor.kwai.b bVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (bVar.appId != null && !bVar.appId.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "appId", bVar.appId);
        }
        if (bVar.asn != null && !bVar.asn.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "pluginListenerName", bVar.asn);
        }
        if (bVar.aso != null && !bVar.aso.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "reportMethodName", bVar.aso);
        }
        if (bVar.asp != null && !bVar.asp.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "otherProxyClassName", bVar.asp);
        }
        if (bVar.asq != null && !bVar.asq.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "otherFieldName", bVar.asq);
        }
        if (bVar.asr != null && !bVar.asr.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "otherLevelFieldName", bVar.asr);
        }
        if (bVar.ass != null && !bVar.ass.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "blockTag", bVar.ass);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.crash.online.monitor.kwai.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.crash.online.monitor.kwai.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
