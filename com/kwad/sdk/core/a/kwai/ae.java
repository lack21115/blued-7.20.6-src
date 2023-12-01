package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/ae.class */
public final class ae implements com.kwad.sdk.core.d<AdInfo.AdSplashInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.AdSplashInfo adSplashInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adSplashInfo.logoPosition = jSONObject.optInt("logoPosition", new Integer("1").intValue());
        adSplashInfo.mute = jSONObject.optInt("mute", new Integer("1").intValue());
        adSplashInfo.skipType = jSONObject.optInt("skipType");
        adSplashInfo.skipTips = jSONObject.optString("skipTips");
        if (adSplashInfo.skipTips == JSONObject.NULL) {
            adSplashInfo.skipTips = "";
        }
        adSplashInfo.speakerMuteIconUrl = jSONObject.optString("speakerMuteIconUrl");
        if (adSplashInfo.speakerMuteIconUrl == JSONObject.NULL) {
            adSplashInfo.speakerMuteIconUrl = "";
        }
        adSplashInfo.speakerIconUrl = jSONObject.optString("speakerIconUrl");
        if (adSplashInfo.speakerIconUrl == JSONObject.NULL) {
            adSplashInfo.speakerIconUrl = "";
        }
        adSplashInfo.imageDisplaySecond = jSONObject.optInt("imageDisplaySecond", new Integer("5").intValue());
        adSplashInfo.videoDisplaySecond = jSONObject.optInt("videoDisplaySecond", new Integer("5").intValue());
        adSplashInfo.countdownShow = jSONObject.optInt("countdownShow");
        adSplashInfo.fullScreenClickSwitch = jSONObject.optInt("fullScreenClickSwitch");
        adSplashInfo.skipButtonPosition = jSONObject.optInt("skipButtonPosition");
        adSplashInfo.splashShowClickButtonSwitch = jSONObject.optInt("splashShowClickButtonSwitch", new Integer("1").intValue());
        adSplashInfo.skipSecond = jSONObject.optInt("skipSecond");
        adSplashInfo.cutRuleInfo = new AdInfo.CutRuleInfo();
        adSplashInfo.cutRuleInfo.parseJson(jSONObject.optJSONObject("cutRuleInfo"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.AdSplashInfo adSplashInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "logoPosition", adSplashInfo.logoPosition);
        com.kwad.sdk.utils.t.putValue(jSONObject2, "mute", adSplashInfo.mute);
        if (adSplashInfo.skipType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "skipType", adSplashInfo.skipType);
        }
        if (adSplashInfo.skipTips != null && !adSplashInfo.skipTips.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "skipTips", adSplashInfo.skipTips);
        }
        if (adSplashInfo.speakerMuteIconUrl != null && !adSplashInfo.speakerMuteIconUrl.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "speakerMuteIconUrl", adSplashInfo.speakerMuteIconUrl);
        }
        if (adSplashInfo.speakerIconUrl != null && !adSplashInfo.speakerIconUrl.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "speakerIconUrl", adSplashInfo.speakerIconUrl);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "imageDisplaySecond", adSplashInfo.imageDisplaySecond);
        com.kwad.sdk.utils.t.putValue(jSONObject2, "videoDisplaySecond", adSplashInfo.videoDisplaySecond);
        if (adSplashInfo.countdownShow != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "countdownShow", adSplashInfo.countdownShow);
        }
        if (adSplashInfo.fullScreenClickSwitch != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "fullScreenClickSwitch", adSplashInfo.fullScreenClickSwitch);
        }
        if (adSplashInfo.skipButtonPosition != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "skipButtonPosition", adSplashInfo.skipButtonPosition);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "splashShowClickButtonSwitch", adSplashInfo.splashShowClickButtonSwitch);
        if (adSplashInfo.skipSecond != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "skipSecond", adSplashInfo.skipSecond);
        }
        com.kwad.sdk.utils.t.a(jSONObject2, "cutRuleInfo", adSplashInfo.cutRuleInfo);
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdSplashInfo adSplashInfo, JSONObject jSONObject) {
        a2(adSplashInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdSplashInfo adSplashInfo, JSONObject jSONObject) {
        return b2(adSplashInfo, jSONObject);
    }
}
