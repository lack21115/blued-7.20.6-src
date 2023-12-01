package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/ak.class */
public final class ak implements com.kwad.sdk.core.d<AdStyleInfo.PlayEndInfo.AdWebCardInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adWebCardInfo.typeLandscape = jSONObject.optLong("typeLandscape");
        adWebCardInfo.typePortrait = jSONObject.optLong("typePortrait");
        adWebCardInfo.cardUrl = jSONObject.optString("cardUrl");
        if (adWebCardInfo.cardUrl == JSONObject.NULL) {
            adWebCardInfo.cardUrl = "";
        }
        adWebCardInfo.cardData = jSONObject.optString("cardData");
        if (adWebCardInfo.cardData == JSONObject.NULL) {
            adWebCardInfo.cardData = "";
        }
        adWebCardInfo.cardShowPlayCount = jSONObject.optInt("cardShowPlayCount");
        adWebCardInfo.cardShowTime = jSONObject.optLong("cardShowTime");
        adWebCardInfo.cardDelayTime = jSONObject.optLong("cardDelayTime");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (adWebCardInfo.typeLandscape != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "typeLandscape", adWebCardInfo.typeLandscape);
        }
        if (adWebCardInfo.typePortrait != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "typePortrait", adWebCardInfo.typePortrait);
        }
        if (adWebCardInfo.cardUrl != null && !adWebCardInfo.cardUrl.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "cardUrl", adWebCardInfo.cardUrl);
        }
        if (adWebCardInfo.cardData != null && !adWebCardInfo.cardData.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "cardData", adWebCardInfo.cardData);
        }
        if (adWebCardInfo.cardShowPlayCount != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "cardShowPlayCount", adWebCardInfo.cardShowPlayCount);
        }
        if (adWebCardInfo.cardShowTime != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "cardShowTime", adWebCardInfo.cardShowTime);
        }
        if (adWebCardInfo.cardDelayTime != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "cardDelayTime", adWebCardInfo.cardDelayTime);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo, JSONObject jSONObject) {
        a2(adWebCardInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo, JSONObject jSONObject) {
        return b2(adWebCardInfo, jSONObject);
    }
}
