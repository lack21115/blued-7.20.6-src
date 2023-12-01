package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/ag.class */
public final class ag implements com.kwad.sdk.core.d<AdInfo.AdStyleConfInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.AdStyleConfInfo adStyleConfInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adStyleConfInfo.fullScreenSkipShowTime = jSONObject.optInt("fullScreenSkipShowTime", new Integer("5").intValue());
        adStyleConfInfo.rewardSkipConfirmSwitch = jSONObject.optInt("rewardSkipConfirmSwitch", new Integer("1").intValue());
        adStyleConfInfo.closeDelaySeconds = jSONObject.optLong("closeDelaySeconds");
        adStyleConfInfo.playableCloseSeconds = jSONObject.optLong("playableCloseSeconds");
        adStyleConfInfo.rewardVideoInteractSwitch = jSONObject.optBoolean("rewardVideoInteractSwitch");
        adStyleConfInfo.adShowVideoH5Info = new AdInfo.AdShowVideoH5Info();
        adStyleConfInfo.adShowVideoH5Info.parseJson(jSONObject.optJSONObject("adShowVideoH5Info"));
        adStyleConfInfo.adPushSwitch = jSONObject.optBoolean("adPushSwitch");
        adStyleConfInfo.adPushShowAfterTime = jSONObject.optInt("adPushShowAfterTime");
        adStyleConfInfo.adPushIntervalTime = jSONObject.optInt("adPushIntervalTime", new Integer("900").intValue());
        adStyleConfInfo.nativeAdInfo = new AdInfo.NativeAdInfo();
        adStyleConfInfo.nativeAdInfo.parseJson(jSONObject.optJSONObject("nativeAdInfo"));
        adStyleConfInfo.useNativeForOuterLiveAd = jSONObject.optBoolean("useNativeForOuterLiveAd");
        adStyleConfInfo.adPushDownloadJumpType = jSONObject.optInt("adPushDownloadJumpType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.AdStyleConfInfo adStyleConfInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "fullScreenSkipShowTime", adStyleConfInfo.fullScreenSkipShowTime);
        com.kwad.sdk.utils.t.putValue(jSONObject2, "rewardSkipConfirmSwitch", adStyleConfInfo.rewardSkipConfirmSwitch);
        if (adStyleConfInfo.closeDelaySeconds != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "closeDelaySeconds", adStyleConfInfo.closeDelaySeconds);
        }
        if (adStyleConfInfo.playableCloseSeconds != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "playableCloseSeconds", adStyleConfInfo.playableCloseSeconds);
        }
        if (adStyleConfInfo.rewardVideoInteractSwitch) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "rewardVideoInteractSwitch", adStyleConfInfo.rewardVideoInteractSwitch);
        }
        com.kwad.sdk.utils.t.a(jSONObject2, "adShowVideoH5Info", adStyleConfInfo.adShowVideoH5Info);
        if (adStyleConfInfo.adPushSwitch) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "adPushSwitch", adStyleConfInfo.adPushSwitch);
        }
        if (adStyleConfInfo.adPushShowAfterTime != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "adPushShowAfterTime", adStyleConfInfo.adPushShowAfterTime);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "adPushIntervalTime", adStyleConfInfo.adPushIntervalTime);
        com.kwad.sdk.utils.t.a(jSONObject2, "nativeAdInfo", adStyleConfInfo.nativeAdInfo);
        if (adStyleConfInfo.useNativeForOuterLiveAd) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "useNativeForOuterLiveAd", adStyleConfInfo.useNativeForOuterLiveAd);
        }
        if (adStyleConfInfo.adPushDownloadJumpType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "adPushDownloadJumpType", adStyleConfInfo.adPushDownloadJumpType);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdStyleConfInfo adStyleConfInfo, JSONObject jSONObject) {
        a2(adStyleConfInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdStyleConfInfo adStyleConfInfo, JSONObject jSONObject) {
        return b2(adStyleConfInfo, jSONObject);
    }
}
