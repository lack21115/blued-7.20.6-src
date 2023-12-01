package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/cj.class */
public final class cj implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.DetailWebCardInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo detailWebCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        detailWebCardInfo.style = jSONObject.optInt("style");
        detailWebCardInfo.maxTimeOut = jSONObject.optLong("maxTimeOut");
        detailWebCardInfo.typeLandscape = jSONObject.optLong("typeLandscape");
        detailWebCardInfo.typePortrait = jSONObject.optLong("typePortrait");
        detailWebCardInfo.cardUrl = jSONObject.optString("cardUrl");
        if (detailWebCardInfo.cardUrl == JSONObject.NULL) {
            detailWebCardInfo.cardUrl = "";
        }
        detailWebCardInfo.cardData = jSONObject.optString("cardData");
        if (detailWebCardInfo.cardData == JSONObject.NULL) {
            detailWebCardInfo.cardData = "";
        }
        detailWebCardInfo.cardShowTime = jSONObject.optLong("cardShowTime");
        detailWebCardInfo.cardType = jSONObject.optInt("cardType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo detailWebCardInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (detailWebCardInfo.style != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "style", detailWebCardInfo.style);
        }
        if (detailWebCardInfo.maxTimeOut != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "maxTimeOut", detailWebCardInfo.maxTimeOut);
        }
        if (detailWebCardInfo.typeLandscape != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "typeLandscape", detailWebCardInfo.typeLandscape);
        }
        if (detailWebCardInfo.typePortrait != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "typePortrait", detailWebCardInfo.typePortrait);
        }
        if (detailWebCardInfo.cardUrl != null && !detailWebCardInfo.cardUrl.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "cardUrl", detailWebCardInfo.cardUrl);
        }
        if (detailWebCardInfo.cardData != null && !detailWebCardInfo.cardData.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "cardData", detailWebCardInfo.cardData);
        }
        if (detailWebCardInfo.cardShowTime != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "cardShowTime", detailWebCardInfo.cardShowTime);
        }
        if (detailWebCardInfo.cardType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "cardType", detailWebCardInfo.cardType);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo detailWebCardInfo, JSONObject jSONObject) {
        a2(detailWebCardInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo detailWebCardInfo, JSONObject jSONObject) {
        return b2(detailWebCardInfo, jSONObject);
    }
}
