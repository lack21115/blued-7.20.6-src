package com.kwad.sdk.core.a.kwai;

import android.provider.UserDictionary;
import com.anythink.pd.ExHandler;
import com.huawei.hms.push.AttributionReporter;
import com.kwad.sdk.core.webview.c.a;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/dx.class */
public final class dx implements com.kwad.sdk.core.d<a.C0399a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(a.C0399a c0399a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0399a.SK = jSONObject.optString("SDKVersion");
        if (c0399a.SK == JSONObject.NULL) {
            c0399a.SK = "";
        }
        c0399a.SL = jSONObject.optInt("SDKVersionCode");
        c0399a.ajB = jSONObject.optString("tkVersion");
        if (c0399a.ajB == JSONObject.NULL) {
            c0399a.ajB = "";
        }
        c0399a.SM = jSONObject.optString("sdkApiVersion");
        if (c0399a.SM == JSONObject.NULL) {
            c0399a.SM = "";
        }
        c0399a.SN = jSONObject.optInt("sdkApiVersionCode");
        c0399a.SO = jSONObject.optInt("sdkType");
        c0399a.appVersion = jSONObject.optString(AttributionReporter.APP_VERSION);
        if (c0399a.appVersion == JSONObject.NULL) {
            c0399a.appVersion = "";
        }
        c0399a.appName = jSONObject.optString("appName");
        if (c0399a.appName == JSONObject.NULL) {
            c0399a.appName = "";
        }
        c0399a.appId = jSONObject.optString("appId");
        if (c0399a.appId == JSONObject.NULL) {
            c0399a.appId = "";
        }
        c0399a.aqh = jSONObject.optString("globalId");
        if (c0399a.aqh == JSONObject.NULL) {
            c0399a.aqh = "";
        }
        c0399a.alo = jSONObject.optString("eGid");
        if (c0399a.alo == JSONObject.NULL) {
            c0399a.alo = "";
        }
        c0399a.aln = jSONObject.optString("deviceSig");
        if (c0399a.aln == JSONObject.NULL) {
            c0399a.aln = "";
        }
        c0399a.SP = jSONObject.optString("networkType");
        if (c0399a.SP == JSONObject.NULL) {
            c0399a.SP = "";
        }
        c0399a.SQ = jSONObject.optString("manufacturer");
        if (c0399a.SQ == JSONObject.NULL) {
            c0399a.SQ = "";
        }
        c0399a.model = jSONObject.optString("model");
        if (c0399a.model == JSONObject.NULL) {
            c0399a.model = "";
        }
        c0399a.SR = jSONObject.optString("deviceBrand");
        if (c0399a.SR == JSONObject.NULL) {
            c0399a.SR = "";
        }
        c0399a.SS = jSONObject.optInt("osType");
        c0399a.ST = jSONObject.optString("systemVersion");
        if (c0399a.ST == JSONObject.NULL) {
            c0399a.ST = "";
        }
        c0399a.SU = jSONObject.optInt("osApi");
        c0399a.SV = jSONObject.optString("language");
        if (c0399a.SV == JSONObject.NULL) {
            c0399a.SV = "";
        }
        c0399a.SW = jSONObject.optString(UserDictionary.Words.LOCALE);
        if (c0399a.SW == JSONObject.NULL) {
            c0399a.SW = "";
        }
        c0399a.aqi = jSONObject.optString("uuid");
        if (c0399a.aqi == JSONObject.NULL) {
            c0399a.aqi = "";
        }
        c0399a.aqj = jSONObject.optBoolean("isDynamic");
        c0399a.SX = jSONObject.optInt("screenWidth");
        c0399a.SY = jSONObject.optInt("screenHeight");
        c0399a.adV = jSONObject.optString(ExHandler.JSON_REQUEST_IMEI);
        if (c0399a.adV == JSONObject.NULL) {
            c0399a.adV = "";
        }
        c0399a.adW = jSONObject.optString("oaid");
        if (c0399a.adW == JSONObject.NULL) {
            c0399a.adW = "";
        }
        c0399a.ali = jSONObject.optString("androidId");
        if (c0399a.ali == JSONObject.NULL) {
            c0399a.ali = "";
        }
        c0399a.alB = jSONObject.optString("mac");
        if (c0399a.alB == JSONObject.NULL) {
            c0399a.alB = "";
        }
        c0399a.SZ = jSONObject.optInt("statusBarHeight");
        c0399a.Ta = jSONObject.optInt("titleBarHeight");
        c0399a.aqk = jSONObject.optString("bridgeVersion");
        if (c0399a.aqk == JSONObject.NULL) {
            c0399a.aqk = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0399a c0399a, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (c0399a.SK != null && !c0399a.SK.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "SDKVersion", c0399a.SK);
        }
        if (c0399a.SL != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "SDKVersionCode", c0399a.SL);
        }
        if (c0399a.ajB != null && !c0399a.ajB.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "tkVersion", c0399a.ajB);
        }
        if (c0399a.SM != null && !c0399a.SM.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "sdkApiVersion", c0399a.SM);
        }
        if (c0399a.SN != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "sdkApiVersionCode", c0399a.SN);
        }
        if (c0399a.SO != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "sdkType", c0399a.SO);
        }
        if (c0399a.appVersion != null && !c0399a.appVersion.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, AttributionReporter.APP_VERSION, c0399a.appVersion);
        }
        if (c0399a.appName != null && !c0399a.appName.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "appName", c0399a.appName);
        }
        if (c0399a.appId != null && !c0399a.appId.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "appId", c0399a.appId);
        }
        if (c0399a.aqh != null && !c0399a.aqh.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "globalId", c0399a.aqh);
        }
        if (c0399a.alo != null && !c0399a.alo.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "eGid", c0399a.alo);
        }
        if (c0399a.aln != null && !c0399a.aln.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "deviceSig", c0399a.aln);
        }
        if (c0399a.SP != null && !c0399a.SP.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "networkType", c0399a.SP);
        }
        if (c0399a.SQ != null && !c0399a.SQ.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "manufacturer", c0399a.SQ);
        }
        if (c0399a.model != null && !c0399a.model.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "model", c0399a.model);
        }
        if (c0399a.SR != null && !c0399a.SR.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "deviceBrand", c0399a.SR);
        }
        if (c0399a.SS != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "osType", c0399a.SS);
        }
        if (c0399a.ST != null && !c0399a.ST.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "systemVersion", c0399a.ST);
        }
        if (c0399a.SU != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "osApi", c0399a.SU);
        }
        if (c0399a.SV != null && !c0399a.SV.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "language", c0399a.SV);
        }
        if (c0399a.SW != null && !c0399a.SW.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, UserDictionary.Words.LOCALE, c0399a.SW);
        }
        if (c0399a.aqi != null && !c0399a.aqi.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "uuid", c0399a.aqi);
        }
        if (c0399a.aqj) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "isDynamic", c0399a.aqj);
        }
        if (c0399a.SX != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "screenWidth", c0399a.SX);
        }
        if (c0399a.SY != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "screenHeight", c0399a.SY);
        }
        if (c0399a.adV != null && !c0399a.adV.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, ExHandler.JSON_REQUEST_IMEI, c0399a.adV);
        }
        if (c0399a.adW != null && !c0399a.adW.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "oaid", c0399a.adW);
        }
        if (c0399a.ali != null && !c0399a.ali.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "androidId", c0399a.ali);
        }
        if (c0399a.alB != null && !c0399a.alB.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "mac", c0399a.alB);
        }
        if (c0399a.SZ != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "statusBarHeight", c0399a.SZ);
        }
        if (c0399a.Ta != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "titleBarHeight", c0399a.Ta);
        }
        if (c0399a.aqk != null && !c0399a.aqk.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "bridgeVersion", c0399a.aqk);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0399a c0399a, JSONObject jSONObject) {
        a2(c0399a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0399a c0399a, JSONObject jSONObject) {
        return b2(c0399a, jSONObject);
    }
}
