package com.kwad.sdk.core.a.kwai;

import com.huawei.hms.push.AttributionReporter;
import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/cn.class */
public final class cn implements com.kwad.sdk.core.d<AdInfo.DownloadSafeInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.DownloadSafeInfo downloadSafeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        downloadSafeInfo.permissionInfo = jSONObject.optString("permissionInfo");
        if (downloadSafeInfo.permissionInfo == JSONObject.NULL) {
            downloadSafeInfo.permissionInfo = "";
        }
        downloadSafeInfo.appName = jSONObject.optString("appName");
        if (downloadSafeInfo.appName == JSONObject.NULL) {
            downloadSafeInfo.appName = "";
        }
        downloadSafeInfo.corporationName = jSONObject.optString("corporationName");
        if (downloadSafeInfo.corporationName == JSONObject.NULL) {
            downloadSafeInfo.corporationName = "";
        }
        downloadSafeInfo.packageSize = jSONObject.optLong("packageSize");
        downloadSafeInfo.appVersion = jSONObject.optString(AttributionReporter.APP_VERSION);
        if (downloadSafeInfo.appVersion == JSONObject.NULL) {
            downloadSafeInfo.appVersion = "";
        }
        downloadSafeInfo.appPrivacyUrl = jSONObject.optString("appPrivacyUrl");
        if (downloadSafeInfo.appPrivacyUrl == JSONObject.NULL) {
            downloadSafeInfo.appPrivacyUrl = "";
        }
        downloadSafeInfo.appPermissionInfoUrl = jSONObject.optString("appPermissionInfoUrl");
        if (downloadSafeInfo.appPermissionInfoUrl == JSONObject.NULL) {
            downloadSafeInfo.appPermissionInfoUrl = "";
        }
        downloadSafeInfo.secWindowPopNoWifiSwitch = jSONObject.optBoolean("secWindowPopNoWifiSwitch");
        downloadSafeInfo.secWindowPopSwitch = jSONObject.optBoolean("secWindowPopSwitch");
        downloadSafeInfo.downloadPauseEnable = jSONObject.optBoolean("downloadPauseEnable", new Boolean("false").booleanValue());
        downloadSafeInfo.windowPopUrl = jSONObject.optString("windowPopUrl");
        if (downloadSafeInfo.windowPopUrl == JSONObject.NULL) {
            downloadSafeInfo.windowPopUrl = "";
        }
        downloadSafeInfo.webPageTipbarSwitch = jSONObject.optBoolean("webPageTipbarSwitch", new Boolean("false").booleanValue());
        downloadSafeInfo.webPageTipbarText = jSONObject.optString("webPageTipbarText");
        if (downloadSafeInfo.webPageTipbarText == JSONObject.NULL) {
            downloadSafeInfo.webPageTipbarText = "";
        }
        downloadSafeInfo.autoDownloadUrl = jSONObject.optString("autoDownloadUrl");
        if (downloadSafeInfo.autoDownloadUrl == JSONObject.NULL) {
            downloadSafeInfo.autoDownloadUrl = "";
        }
        downloadSafeInfo.complianceInfo = new AdInfo.ComplianceInfo();
        downloadSafeInfo.complianceInfo.parseJson(jSONObject.optJSONObject("complianceInfo"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.DownloadSafeInfo downloadSafeInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (downloadSafeInfo.permissionInfo != null && !downloadSafeInfo.permissionInfo.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "permissionInfo", downloadSafeInfo.permissionInfo);
        }
        if (downloadSafeInfo.appName != null && !downloadSafeInfo.appName.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "appName", downloadSafeInfo.appName);
        }
        if (downloadSafeInfo.corporationName != null && !downloadSafeInfo.corporationName.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "corporationName", downloadSafeInfo.corporationName);
        }
        if (downloadSafeInfo.packageSize != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "packageSize", downloadSafeInfo.packageSize);
        }
        if (downloadSafeInfo.appVersion != null && !downloadSafeInfo.appVersion.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, AttributionReporter.APP_VERSION, downloadSafeInfo.appVersion);
        }
        if (downloadSafeInfo.appPrivacyUrl != null && !downloadSafeInfo.appPrivacyUrl.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "appPrivacyUrl", downloadSafeInfo.appPrivacyUrl);
        }
        if (downloadSafeInfo.appPermissionInfoUrl != null && !downloadSafeInfo.appPermissionInfoUrl.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "appPermissionInfoUrl", downloadSafeInfo.appPermissionInfoUrl);
        }
        if (downloadSafeInfo.secWindowPopNoWifiSwitch) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "secWindowPopNoWifiSwitch", downloadSafeInfo.secWindowPopNoWifiSwitch);
        }
        if (downloadSafeInfo.secWindowPopSwitch) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "secWindowPopSwitch", downloadSafeInfo.secWindowPopSwitch);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "downloadPauseEnable", downloadSafeInfo.downloadPauseEnable);
        if (downloadSafeInfo.windowPopUrl != null && !downloadSafeInfo.windowPopUrl.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "windowPopUrl", downloadSafeInfo.windowPopUrl);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "webPageTipbarSwitch", downloadSafeInfo.webPageTipbarSwitch);
        if (downloadSafeInfo.webPageTipbarText != null && !downloadSafeInfo.webPageTipbarText.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "webPageTipbarText", downloadSafeInfo.webPageTipbarText);
        }
        if (downloadSafeInfo.autoDownloadUrl != null && !downloadSafeInfo.autoDownloadUrl.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "autoDownloadUrl", downloadSafeInfo.autoDownloadUrl);
        }
        com.kwad.sdk.utils.t.a(jSONObject2, "complianceInfo", downloadSafeInfo.complianceInfo);
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.DownloadSafeInfo downloadSafeInfo, JSONObject jSONObject) {
        a2(downloadSafeInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.DownloadSafeInfo downloadSafeInfo, JSONObject jSONObject) {
        return b2(downloadSafeInfo, jSONObject);
    }
}
