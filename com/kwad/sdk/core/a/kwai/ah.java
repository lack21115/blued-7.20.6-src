package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/ah.class */
public final class ah implements com.kwad.sdk.core.d<AdStyleInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdStyleInfo adStyleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adStyleInfo.playDetailInfo = new AdStyleInfo.PlayDetailInfo();
        adStyleInfo.playDetailInfo.parseJson(jSONObject.optJSONObject("playDetailInfo"));
        adStyleInfo.playEndInfo = new AdStyleInfo.PlayEndInfo();
        adStyleInfo.playEndInfo.parseJson(jSONObject.optJSONObject("playEndInfo"));
        adStyleInfo.feedAdInfo = new AdStyleInfo.FeedAdInfo();
        adStyleInfo.feedAdInfo.parseJson(jSONObject.optJSONObject("feedAdInfo"));
        adStyleInfo.adBrowseInfo = new AdStyleInfo.AdBrowseInfo();
        adStyleInfo.adBrowseInfo.parseJson(jSONObject.optJSONObject("adBrowseInfo"));
        adStyleInfo.extraDisplayInfo = new AdStyleInfo.ExtraDisplayInfo();
        adStyleInfo.extraDisplayInfo.parseJson(jSONObject.optJSONObject("extraDisplayInfo"));
        adStyleInfo.playableExtraData = jSONObject.optString("playableExtraData");
        if (adStyleInfo.playableExtraData == JSONObject.NULL) {
            adStyleInfo.playableExtraData = "";
        }
        adStyleInfo.slideClick = jSONObject.optBoolean("slideClick");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdStyleInfo adStyleInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject2, "playDetailInfo", adStyleInfo.playDetailInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "playEndInfo", adStyleInfo.playEndInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "feedAdInfo", adStyleInfo.feedAdInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "adBrowseInfo", adStyleInfo.adBrowseInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "extraDisplayInfo", adStyleInfo.extraDisplayInfo);
        if (adStyleInfo.playableExtraData != null && !adStyleInfo.playableExtraData.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "playableExtraData", adStyleInfo.playableExtraData);
        }
        if (adStyleInfo.slideClick) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "slideClick", adStyleInfo.slideClick);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo adStyleInfo, JSONObject jSONObject) {
        a2(adStyleInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo adStyleInfo, JSONObject jSONObject) {
        return b2(adStyleInfo, jSONObject);
    }
}
