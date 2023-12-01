package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/cp.class */
public final class cp implements com.kwad.sdk.core.d<AdMatrixInfo.DownloadTexts> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.DownloadTexts downloadTexts, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        downloadTexts.adActionDescription = jSONObject.optString("adActionDescription");
        if (downloadTexts.adActionDescription == JSONObject.NULL) {
            downloadTexts.adActionDescription = "";
        }
        downloadTexts.installAppLabel = jSONObject.optString("installAppLabel");
        if (downloadTexts.installAppLabel == JSONObject.NULL) {
            downloadTexts.installAppLabel = "";
        }
        downloadTexts.openAppLabel = jSONObject.optString("openAppLabel");
        if (downloadTexts.openAppLabel == JSONObject.NULL) {
            downloadTexts.openAppLabel = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.DownloadTexts downloadTexts, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (downloadTexts.adActionDescription != null && !downloadTexts.adActionDescription.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "adActionDescription", downloadTexts.adActionDescription);
        }
        if (downloadTexts.installAppLabel != null && !downloadTexts.installAppLabel.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "installAppLabel", downloadTexts.installAppLabel);
        }
        if (downloadTexts.openAppLabel != null && !downloadTexts.openAppLabel.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "openAppLabel", downloadTexts.openAppLabel);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.DownloadTexts downloadTexts, JSONObject jSONObject) {
        a2(downloadTexts, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.DownloadTexts downloadTexts, JSONObject jSONObject) {
        return b2(downloadTexts, jSONObject);
    }
}
