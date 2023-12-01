package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/ft.class */
public final class ft implements com.kwad.sdk.core.d<com.kwad.sdk.core.network.j> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jVar.url = jSONObject.optString("url");
        if (jVar.url == JSONObject.NULL) {
            jVar.url = "";
        }
        jVar.host = jSONObject.optString("host");
        if (jVar.host == JSONObject.NULL) {
            jVar.host = "";
        }
        jVar.httpCode = jSONObject.optInt("http_code");
        jVar.errorMsg = jSONObject.optString("error_msg");
        if (jVar.errorMsg == JSONObject.NULL) {
            jVar.errorMsg = "";
        }
        jVar.agz = jSONObject.optString("req_type");
        if (jVar.agz == JSONObject.NULL) {
            jVar.agz = "";
        }
        jVar.agA = jSONObject.optInt("use_ip");
        jVar.agB = jSONObject.optString("ok_http_version");
        if (jVar.agB == JSONObject.NULL) {
            jVar.agB = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (jVar.url != null && !jVar.url.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "url", jVar.url);
        }
        if (jVar.host != null && !jVar.host.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "host", jVar.host);
        }
        if (jVar.httpCode != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "http_code", jVar.httpCode);
        }
        if (jVar.errorMsg != null && !jVar.errorMsg.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "error_msg", jVar.errorMsg);
        }
        if (jVar.agz != null && !jVar.agz.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "req_type", jVar.agz);
        }
        if (jVar.agA != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "use_ip", jVar.agA);
        }
        if (jVar.agB != null && !jVar.agB.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "ok_http_version", jVar.agB);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        a2(jVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        return b2(jVar, jSONObject);
    }
}
