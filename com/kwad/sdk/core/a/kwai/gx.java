package com.kwad.sdk.core.a.kwai;

import com.kwad.components.ad.reward.check.RewardCheckMonitorInfo;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/gx.class */
public final class gx implements com.kwad.sdk.core.d<RewardCheckMonitorInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(RewardCheckMonitorInfo rewardCheckMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rewardCheckMonitorInfo.checkType = jSONObject.optInt("check_type");
        rewardCheckMonitorInfo.requestStatus = jSONObject.optInt("request_state");
        rewardCheckMonitorInfo.code = jSONObject.optInt("code");
        rewardCheckMonitorInfo.errorMsg = jSONObject.optString("error_msg");
        if (rewardCheckMonitorInfo.errorMsg == JSONObject.NULL) {
            rewardCheckMonitorInfo.errorMsg = "";
        }
        rewardCheckMonitorInfo.creativeId = jSONObject.optLong(com.anythink.expressad.foundation.d.c.l);
        rewardCheckMonitorInfo.dataLoadInterval = jSONObject.optLong("data_load_interval_duration_ms");
        rewardCheckMonitorInfo.posId = jSONObject.optLong("pos_Id");
        rewardCheckMonitorInfo.enviType = jSONObject.optInt("enviType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(RewardCheckMonitorInfo rewardCheckMonitorInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (rewardCheckMonitorInfo.checkType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "check_type", rewardCheckMonitorInfo.checkType);
        }
        if (rewardCheckMonitorInfo.requestStatus != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "request_state", rewardCheckMonitorInfo.requestStatus);
        }
        if (rewardCheckMonitorInfo.code != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "code", rewardCheckMonitorInfo.code);
        }
        if (rewardCheckMonitorInfo.errorMsg != null && !rewardCheckMonitorInfo.errorMsg.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "error_msg", rewardCheckMonitorInfo.errorMsg);
        }
        if (rewardCheckMonitorInfo.creativeId != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, com.anythink.expressad.foundation.d.c.l, rewardCheckMonitorInfo.creativeId);
        }
        if (rewardCheckMonitorInfo.dataLoadInterval != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "data_load_interval_duration_ms", rewardCheckMonitorInfo.dataLoadInterval);
        }
        if (rewardCheckMonitorInfo.posId != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "pos_Id", rewardCheckMonitorInfo.posId);
        }
        if (rewardCheckMonitorInfo.enviType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "enviType", rewardCheckMonitorInfo.enviType);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(RewardCheckMonitorInfo rewardCheckMonitorInfo, JSONObject jSONObject) {
        a2(rewardCheckMonitorInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(RewardCheckMonitorInfo rewardCheckMonitorInfo, JSONObject jSONObject) {
        return b2(rewardCheckMonitorInfo, jSONObject);
    }
}
