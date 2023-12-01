package com.kwad.sdk.core.a.kwai;

import android.provider.UserDictionary;
import com.huawei.hms.push.AttributionReporter;
import com.kwad.components.core.webview.jshandler.x;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/go.class */
public final class go implements com.kwad.sdk.core.d<x.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(x.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.SK = jSONObject.optString("SDKVersion");
        if (aVar.SK == JSONObject.NULL) {
            aVar.SK = "";
        }
        aVar.SL = jSONObject.optInt("SDKVersionCode");
        aVar.SM = jSONObject.optString("sdkApiVersion");
        if (aVar.SM == JSONObject.NULL) {
            aVar.SM = "";
        }
        aVar.SN = jSONObject.optInt("sdkApiVersionCode");
        aVar.SO = jSONObject.optInt("sdkType");
        aVar.appVersion = jSONObject.optString(AttributionReporter.APP_VERSION);
        if (aVar.appVersion == JSONObject.NULL) {
            aVar.appVersion = "";
        }
        aVar.appName = jSONObject.optString("appName");
        if (aVar.appName == JSONObject.NULL) {
            aVar.appName = "";
        }
        aVar.appId = jSONObject.optString("appId");
        if (aVar.appId == JSONObject.NULL) {
            aVar.appId = "";
        }
        aVar.SP = jSONObject.optString("networkType");
        if (aVar.SP == JSONObject.NULL) {
            aVar.SP = "";
        }
        aVar.SQ = jSONObject.optString("manufacturer");
        if (aVar.SQ == JSONObject.NULL) {
            aVar.SQ = "";
        }
        aVar.model = jSONObject.optString("model");
        if (aVar.model == JSONObject.NULL) {
            aVar.model = "";
        }
        aVar.SR = jSONObject.optString("deviceBrand");
        if (aVar.SR == JSONObject.NULL) {
            aVar.SR = "";
        }
        aVar.SS = jSONObject.optInt("osType");
        aVar.ST = jSONObject.optString("systemVersion");
        if (aVar.ST == JSONObject.NULL) {
            aVar.ST = "";
        }
        aVar.SU = jSONObject.optInt("osApi");
        aVar.SV = jSONObject.optString("language");
        if (aVar.SV == JSONObject.NULL) {
            aVar.SV = "";
        }
        aVar.SW = jSONObject.optString(UserDictionary.Words.LOCALE);
        if (aVar.SW == JSONObject.NULL) {
            aVar.SW = "";
        }
        aVar.SX = jSONObject.optInt("screenWidth");
        aVar.SY = jSONObject.optInt("screenHeight");
        aVar.SZ = jSONObject.optInt("statusBarHeight");
        aVar.Ta = jSONObject.optInt("titleBarHeight");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(x.a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (aVar.SK != null && !aVar.SK.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "SDKVersion", aVar.SK);
        }
        if (aVar.SL != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "SDKVersionCode", aVar.SL);
        }
        if (aVar.SM != null && !aVar.SM.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "sdkApiVersion", aVar.SM);
        }
        if (aVar.SN != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "sdkApiVersionCode", aVar.SN);
        }
        if (aVar.SO != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "sdkType", aVar.SO);
        }
        if (aVar.appVersion != null && !aVar.appVersion.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, AttributionReporter.APP_VERSION, aVar.appVersion);
        }
        if (aVar.appName != null && !aVar.appName.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "appName", aVar.appName);
        }
        if (aVar.appId != null && !aVar.appId.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "appId", aVar.appId);
        }
        if (aVar.SP != null && !aVar.SP.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "networkType", aVar.SP);
        }
        if (aVar.SQ != null && !aVar.SQ.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "manufacturer", aVar.SQ);
        }
        if (aVar.model != null && !aVar.model.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "model", aVar.model);
        }
        if (aVar.SR != null && !aVar.SR.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "deviceBrand", aVar.SR);
        }
        if (aVar.SS != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "osType", aVar.SS);
        }
        if (aVar.ST != null && !aVar.ST.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "systemVersion", aVar.ST);
        }
        if (aVar.SU != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "osApi", aVar.SU);
        }
        if (aVar.SV != null && !aVar.SV.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "language", aVar.SV);
        }
        if (aVar.SW != null && !aVar.SW.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, UserDictionary.Words.LOCALE, aVar.SW);
        }
        if (aVar.SX != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "screenWidth", aVar.SX);
        }
        if (aVar.SY != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "screenHeight", aVar.SY);
        }
        if (aVar.SZ != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "statusBarHeight", aVar.SZ);
        }
        if (aVar.Ta != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "titleBarHeight", aVar.Ta);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(x.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(x.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
