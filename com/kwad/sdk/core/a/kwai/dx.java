package com.kwad.sdk.core.a.kwai;

import android.provider.UserDictionary;
import com.huawei.hms.push.AttributionReporter;
import com.kwad.sdk.core.webview.c.a;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/dx.class */
public final class dx implements com.kwad.sdk.core.d<a.C0569a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(a.C0569a c0569a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0569a.SK = jSONObject.optString("SDKVersion");
        if (c0569a.SK == JSONObject.NULL) {
            c0569a.SK = "";
        }
        c0569a.SL = jSONObject.optInt("SDKVersionCode");
        c0569a.ajB = jSONObject.optString("tkVersion");
        if (c0569a.ajB == JSONObject.NULL) {
            c0569a.ajB = "";
        }
        c0569a.SM = jSONObject.optString("sdkApiVersion");
        if (c0569a.SM == JSONObject.NULL) {
            c0569a.SM = "";
        }
        c0569a.SN = jSONObject.optInt("sdkApiVersionCode");
        c0569a.SO = jSONObject.optInt("sdkType");
        c0569a.appVersion = jSONObject.optString(AttributionReporter.APP_VERSION);
        if (c0569a.appVersion == JSONObject.NULL) {
            c0569a.appVersion = "";
        }
        c0569a.appName = jSONObject.optString("appName");
        if (c0569a.appName == JSONObject.NULL) {
            c0569a.appName = "";
        }
        c0569a.appId = jSONObject.optString("appId");
        if (c0569a.appId == JSONObject.NULL) {
            c0569a.appId = "";
        }
        c0569a.aqh = jSONObject.optString("globalId");
        if (c0569a.aqh == JSONObject.NULL) {
            c0569a.aqh = "";
        }
        c0569a.alo = jSONObject.optString("eGid");
        if (c0569a.alo == JSONObject.NULL) {
            c0569a.alo = "";
        }
        c0569a.aln = jSONObject.optString("deviceSig");
        if (c0569a.aln == JSONObject.NULL) {
            c0569a.aln = "";
        }
        c0569a.SP = jSONObject.optString("networkType");
        if (c0569a.SP == JSONObject.NULL) {
            c0569a.SP = "";
        }
        c0569a.SQ = jSONObject.optString("manufacturer");
        if (c0569a.SQ == JSONObject.NULL) {
            c0569a.SQ = "";
        }
        c0569a.model = jSONObject.optString("model");
        if (c0569a.model == JSONObject.NULL) {
            c0569a.model = "";
        }
        c0569a.SR = jSONObject.optString("deviceBrand");
        if (c0569a.SR == JSONObject.NULL) {
            c0569a.SR = "";
        }
        c0569a.SS = jSONObject.optInt("osType");
        c0569a.ST = jSONObject.optString("systemVersion");
        if (c0569a.ST == JSONObject.NULL) {
            c0569a.ST = "";
        }
        c0569a.SU = jSONObject.optInt("osApi");
        c0569a.SV = jSONObject.optString("language");
        if (c0569a.SV == JSONObject.NULL) {
            c0569a.SV = "";
        }
        c0569a.SW = jSONObject.optString(UserDictionary.Words.LOCALE);
        if (c0569a.SW == JSONObject.NULL) {
            c0569a.SW = "";
        }
        c0569a.aqi = jSONObject.optString("uuid");
        if (c0569a.aqi == JSONObject.NULL) {
            c0569a.aqi = "";
        }
        c0569a.aqj = jSONObject.optBoolean("isDynamic");
        c0569a.SX = jSONObject.optInt("screenWidth");
        c0569a.SY = jSONObject.optInt("screenHeight");
        c0569a.adV = jSONObject.optString("imei");
        if (c0569a.adV == JSONObject.NULL) {
            c0569a.adV = "";
        }
        c0569a.adW = jSONObject.optString("oaid");
        if (c0569a.adW == JSONObject.NULL) {
            c0569a.adW = "";
        }
        c0569a.ali = jSONObject.optString("androidId");
        if (c0569a.ali == JSONObject.NULL) {
            c0569a.ali = "";
        }
        c0569a.alB = jSONObject.optString("mac");
        if (c0569a.alB == JSONObject.NULL) {
            c0569a.alB = "";
        }
        c0569a.SZ = jSONObject.optInt("statusBarHeight");
        c0569a.Ta = jSONObject.optInt("titleBarHeight");
        c0569a.aqk = jSONObject.optString("bridgeVersion");
        if (c0569a.aqk == JSONObject.NULL) {
            c0569a.aqk = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0569a c0569a, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (c0569a.SK != null && !c0569a.SK.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "SDKVersion", c0569a.SK);
        }
        if (c0569a.SL != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "SDKVersionCode", c0569a.SL);
        }
        if (c0569a.ajB != null && !c0569a.ajB.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "tkVersion", c0569a.ajB);
        }
        if (c0569a.SM != null && !c0569a.SM.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "sdkApiVersion", c0569a.SM);
        }
        if (c0569a.SN != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "sdkApiVersionCode", c0569a.SN);
        }
        if (c0569a.SO != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "sdkType", c0569a.SO);
        }
        if (c0569a.appVersion != null && !c0569a.appVersion.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, AttributionReporter.APP_VERSION, c0569a.appVersion);
        }
        if (c0569a.appName != null && !c0569a.appName.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "appName", c0569a.appName);
        }
        if (c0569a.appId != null && !c0569a.appId.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "appId", c0569a.appId);
        }
        if (c0569a.aqh != null && !c0569a.aqh.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "globalId", c0569a.aqh);
        }
        if (c0569a.alo != null && !c0569a.alo.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "eGid", c0569a.alo);
        }
        if (c0569a.aln != null && !c0569a.aln.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "deviceSig", c0569a.aln);
        }
        if (c0569a.SP != null && !c0569a.SP.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "networkType", c0569a.SP);
        }
        if (c0569a.SQ != null && !c0569a.SQ.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "manufacturer", c0569a.SQ);
        }
        if (c0569a.model != null && !c0569a.model.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "model", c0569a.model);
        }
        if (c0569a.SR != null && !c0569a.SR.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "deviceBrand", c0569a.SR);
        }
        if (c0569a.SS != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "osType", c0569a.SS);
        }
        if (c0569a.ST != null && !c0569a.ST.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "systemVersion", c0569a.ST);
        }
        if (c0569a.SU != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "osApi", c0569a.SU);
        }
        if (c0569a.SV != null && !c0569a.SV.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "language", c0569a.SV);
        }
        if (c0569a.SW != null && !c0569a.SW.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, UserDictionary.Words.LOCALE, c0569a.SW);
        }
        if (c0569a.aqi != null && !c0569a.aqi.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "uuid", c0569a.aqi);
        }
        if (c0569a.aqj) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "isDynamic", c0569a.aqj);
        }
        if (c0569a.SX != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "screenWidth", c0569a.SX);
        }
        if (c0569a.SY != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "screenHeight", c0569a.SY);
        }
        if (c0569a.adV != null && !c0569a.adV.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "imei", c0569a.adV);
        }
        if (c0569a.adW != null && !c0569a.adW.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "oaid", c0569a.adW);
        }
        if (c0569a.ali != null && !c0569a.ali.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "androidId", c0569a.ali);
        }
        if (c0569a.alB != null && !c0569a.alB.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "mac", c0569a.alB);
        }
        if (c0569a.SZ != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "statusBarHeight", c0569a.SZ);
        }
        if (c0569a.Ta != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "titleBarHeight", c0569a.Ta);
        }
        if (c0569a.aqk != null && !c0569a.aqk.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "bridgeVersion", c0569a.aqk);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0569a c0569a, JSONObject jSONObject) {
        a2(c0569a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0569a c0569a, JSONObject jSONObject) {
        return b2(c0569a, jSONObject);
    }
}
