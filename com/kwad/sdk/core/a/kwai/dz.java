package com.kwad.sdk.core.a.kwai;

import android.net.http.Headers;
import com.google.common.net.HttpHeaders;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/dz.class */
public final class dz implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.a.kwai.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.webview.a.kwai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.apS = jSONObject.optString(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN);
        if (aVar.apS == JSONObject.NULL) {
            aVar.apS = "";
        }
        aVar.apT = jSONObject.optString(HttpHeaders.TIMING_ALLOW_ORIGIN);
        if (aVar.apT == JSONObject.NULL) {
            aVar.apT = "";
        }
        aVar.apU = jSONObject.optString(Headers.CONTENT_TYPE);
        if (aVar.apU == JSONObject.NULL) {
            aVar.apU = "";
        }
        aVar.apV = jSONObject.optString("Date");
        if (aVar.apV == JSONObject.NULL) {
            aVar.apV = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.webview.a.kwai.a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (aVar.apS != null && !aVar.apS.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, aVar.apS);
        }
        if (aVar.apT != null && !aVar.apT.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, HttpHeaders.TIMING_ALLOW_ORIGIN, aVar.apT);
        }
        if (aVar.apU != null && !aVar.apU.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, Headers.CONTENT_TYPE, aVar.apU);
        }
        if (aVar.apV != null && !aVar.apV.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "Date", aVar.apV);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.webview.a.kwai.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.webview.a.kwai.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
