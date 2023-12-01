package com.kwad.sdk.core.a.kwai;

import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/ac.class */
public final class ac implements com.kwad.sdk.core.d<AdInfo.AdRewardInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.AdRewardInfo adRewardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adRewardInfo.skipShowTime = jSONObject.optInt("skipShowTime", new Integer(BaseWrapper.ENTER_ID_TOOLKIT).intValue());
        adRewardInfo.rewardTime = jSONObject.optInt("rewardTime", new Integer(BaseWrapper.ENTER_ID_TOOLKIT).intValue());
        adRewardInfo.showLandingPage = jSONObject.optInt("showLandingPage");
        adRewardInfo.rewardVideoEndCardSwitch = jSONObject.optBoolean("rewardVideoEndCardSwitch");
        adRewardInfo.recommendAggregateSwitch = jSONObject.optBoolean("recommendAggregateSwitch");
        adRewardInfo.callBackStrategyInfo = new AdInfo.CallBackStrategyInfo();
        adRewardInfo.callBackStrategyInfo.parseJson(jSONObject.optJSONObject("callBackStrategyInfo"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.AdRewardInfo adRewardInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "skipShowTime", adRewardInfo.skipShowTime);
        com.kwad.sdk.utils.t.putValue(jSONObject2, "rewardTime", adRewardInfo.rewardTime);
        if (adRewardInfo.showLandingPage != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "showLandingPage", adRewardInfo.showLandingPage);
        }
        if (adRewardInfo.rewardVideoEndCardSwitch) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "rewardVideoEndCardSwitch", adRewardInfo.rewardVideoEndCardSwitch);
        }
        if (adRewardInfo.recommendAggregateSwitch) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "recommendAggregateSwitch", adRewardInfo.recommendAggregateSwitch);
        }
        com.kwad.sdk.utils.t.a(jSONObject2, "callBackStrategyInfo", adRewardInfo.callBackStrategyInfo);
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdRewardInfo adRewardInfo, JSONObject jSONObject) {
        a2(adRewardInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdRewardInfo adRewardInfo, JSONObject jSONObject) {
        return b2(adRewardInfo, jSONObject);
    }
}
