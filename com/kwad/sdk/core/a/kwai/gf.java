package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/gf.class */
public final class gf implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.PatchAdInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdStyleInfo.PlayDetailInfo.PatchAdInfo patchAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        patchAdInfo.weakStyleIcon = jSONObject.optString("weakStyleIcon");
        if (patchAdInfo.weakStyleIcon == JSONObject.NULL) {
            patchAdInfo.weakStyleIcon = "";
        }
        patchAdInfo.weakStyleTitle = jSONObject.optString("weakStyleTitle");
        if (patchAdInfo.weakStyleTitle == JSONObject.NULL) {
            patchAdInfo.weakStyleTitle = "";
        }
        patchAdInfo.weakStyleDownloadingTitle = jSONObject.optString("weakStyleDownloadingTitle");
        if (patchAdInfo.weakStyleDownloadingTitle == JSONObject.NULL) {
            patchAdInfo.weakStyleDownloadingTitle = "";
        }
        patchAdInfo.weakStyleAdMark = jSONObject.optString("weakStyleAdMark");
        if (patchAdInfo.weakStyleAdMark == JSONObject.NULL) {
            patchAdInfo.weakStyleAdMark = "";
        }
        patchAdInfo.weakStyleAppearTime = jSONObject.optLong("weakStyleAppearTime");
        patchAdInfo.weakStyleEnableClose = jSONObject.optBoolean("weakStyleEnableClose", new Boolean(com.huawei.hms.ads.fw.Code).booleanValue());
        patchAdInfo.typePortrait = jSONObject.optInt("typePortrait");
        patchAdInfo.strongStyleCardUrl = jSONObject.optString("strongStyleCardUrl");
        if (patchAdInfo.strongStyleCardUrl == JSONObject.NULL) {
            patchAdInfo.strongStyleCardUrl = "";
        }
        patchAdInfo.strongStyleAppearTime = jSONObject.optLong("strongStyleAppearTime");
        patchAdInfo.strongStyleTitle = jSONObject.optString("strongStyleTitle");
        if (patchAdInfo.strongStyleTitle == JSONObject.NULL) {
            patchAdInfo.strongStyleTitle = "";
        }
        patchAdInfo.strongStyleSubTitle = jSONObject.optString("strongStyleSubTitle");
        if (patchAdInfo.strongStyleSubTitle == JSONObject.NULL) {
            patchAdInfo.strongStyleSubTitle = "";
        }
        patchAdInfo.strongStyleAdMark = jSONObject.optString("strongStyleAdMark");
        if (patchAdInfo.strongStyleAdMark == JSONObject.NULL) {
            patchAdInfo.strongStyleAdMark = "";
        }
        patchAdInfo.strongStyleEnableClose = jSONObject.optBoolean("strongStyleEnableClose", new Boolean(com.huawei.hms.ads.fw.Code).booleanValue());
        patchAdInfo.weakStyleShowTime = jSONObject.optLong("weakStyleShowTime");
        patchAdInfo.strongStyleShowTime = jSONObject.optLong("strongStyleShowTime");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdStyleInfo.PlayDetailInfo.PatchAdInfo patchAdInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (patchAdInfo.weakStyleIcon != null && !patchAdInfo.weakStyleIcon.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "weakStyleIcon", patchAdInfo.weakStyleIcon);
        }
        if (patchAdInfo.weakStyleTitle != null && !patchAdInfo.weakStyleTitle.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "weakStyleTitle", patchAdInfo.weakStyleTitle);
        }
        if (patchAdInfo.weakStyleDownloadingTitle != null && !patchAdInfo.weakStyleDownloadingTitle.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "weakStyleDownloadingTitle", patchAdInfo.weakStyleDownloadingTitle);
        }
        if (patchAdInfo.weakStyleAdMark != null && !patchAdInfo.weakStyleAdMark.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "weakStyleAdMark", patchAdInfo.weakStyleAdMark);
        }
        if (patchAdInfo.weakStyleAppearTime != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "weakStyleAppearTime", patchAdInfo.weakStyleAppearTime);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "weakStyleEnableClose", patchAdInfo.weakStyleEnableClose);
        if (patchAdInfo.typePortrait != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "typePortrait", patchAdInfo.typePortrait);
        }
        if (patchAdInfo.strongStyleCardUrl != null && !patchAdInfo.strongStyleCardUrl.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "strongStyleCardUrl", patchAdInfo.strongStyleCardUrl);
        }
        if (patchAdInfo.strongStyleAppearTime != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "strongStyleAppearTime", patchAdInfo.strongStyleAppearTime);
        }
        if (patchAdInfo.strongStyleTitle != null && !patchAdInfo.strongStyleTitle.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "strongStyleTitle", patchAdInfo.strongStyleTitle);
        }
        if (patchAdInfo.strongStyleSubTitle != null && !patchAdInfo.strongStyleSubTitle.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "strongStyleSubTitle", patchAdInfo.strongStyleSubTitle);
        }
        if (patchAdInfo.strongStyleAdMark != null && !patchAdInfo.strongStyleAdMark.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "strongStyleAdMark", patchAdInfo.strongStyleAdMark);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "strongStyleEnableClose", patchAdInfo.strongStyleEnableClose);
        if (patchAdInfo.weakStyleShowTime != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "weakStyleShowTime", patchAdInfo.weakStyleShowTime);
        }
        if (patchAdInfo.strongStyleShowTime != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "strongStyleShowTime", patchAdInfo.strongStyleShowTime);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.PlayDetailInfo.PatchAdInfo patchAdInfo, JSONObject jSONObject) {
        a2(patchAdInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.PlayDetailInfo.PatchAdInfo patchAdInfo, JSONObject jSONObject) {
        return b2(patchAdInfo, jSONObject);
    }
}
