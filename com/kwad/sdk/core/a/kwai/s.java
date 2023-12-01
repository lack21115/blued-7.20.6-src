package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/s.class */
public final class s implements com.kwad.sdk.core.d<AdInfo.AdInsertScreenInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.AdInsertScreenInfo adInsertScreenInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adInsertScreenInfo.cycleAggregateSwitch = jSONObject.optBoolean("cycleAggregateSwitch");
        adInsertScreenInfo.cycleAggregateDailyShowCount = jSONObject.optInt("cycleAggregateDailyShowCount", new Integer("10").intValue());
        adInsertScreenInfo.cycleAggregateStyle = jSONObject.optInt("cycleAggregateStyle");
        adInsertScreenInfo.cycleAggregateInterval = jSONObject.optInt("cycleAggregateInterval", new Integer("10").intValue());
        adInsertScreenInfo.autoCloseTime = jSONObject.optInt("autoCloseTime");
        adInsertScreenInfo.retainWindowStyle = jSONObject.optInt("retainWindowStyle");
        adInsertScreenInfo.retainWindowText = jSONObject.optString("retainWindowText");
        if (adInsertScreenInfo.retainWindowText == JSONObject.NULL) {
            adInsertScreenInfo.retainWindowText = "";
        }
        adInsertScreenInfo.retainWindowBasedAdShowCount = jSONObject.optInt("retainWindowBasedAdShowCount");
        adInsertScreenInfo.retainWindowDailyShowCount = jSONObject.optInt("retainWindowDailyShowCount");
        adInsertScreenInfo.guideShowStyle = jSONObject.optInt("guideShowStyle");
        adInsertScreenInfo.guideShowTime = jSONObject.optInt("guideShowTime", new Integer("5").intValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.AdInsertScreenInfo adInsertScreenInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (adInsertScreenInfo.cycleAggregateSwitch) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "cycleAggregateSwitch", adInsertScreenInfo.cycleAggregateSwitch);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "cycleAggregateDailyShowCount", adInsertScreenInfo.cycleAggregateDailyShowCount);
        if (adInsertScreenInfo.cycleAggregateStyle != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "cycleAggregateStyle", adInsertScreenInfo.cycleAggregateStyle);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "cycleAggregateInterval", adInsertScreenInfo.cycleAggregateInterval);
        if (adInsertScreenInfo.autoCloseTime != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "autoCloseTime", adInsertScreenInfo.autoCloseTime);
        }
        if (adInsertScreenInfo.retainWindowStyle != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "retainWindowStyle", adInsertScreenInfo.retainWindowStyle);
        }
        if (adInsertScreenInfo.retainWindowText != null && !adInsertScreenInfo.retainWindowText.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "retainWindowText", adInsertScreenInfo.retainWindowText);
        }
        if (adInsertScreenInfo.retainWindowBasedAdShowCount != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "retainWindowBasedAdShowCount", adInsertScreenInfo.retainWindowBasedAdShowCount);
        }
        if (adInsertScreenInfo.retainWindowDailyShowCount != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "retainWindowDailyShowCount", adInsertScreenInfo.retainWindowDailyShowCount);
        }
        if (adInsertScreenInfo.guideShowStyle != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "guideShowStyle", adInsertScreenInfo.guideShowStyle);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "guideShowTime", adInsertScreenInfo.guideShowTime);
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdInsertScreenInfo adInsertScreenInfo, JSONObject jSONObject) {
        a2(adInsertScreenInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdInsertScreenInfo adInsertScreenInfo, JSONObject jSONObject) {
        return b2(adInsertScreenInfo, jSONObject);
    }
}
