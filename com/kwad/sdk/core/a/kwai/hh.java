package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.commercial.model.SDKInitMsg;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/hh.class */
public final class hh implements com.kwad.sdk.core.d<SDKInitMsg> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(SDKInitMsg sDKInitMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        sDKInitMsg.launchIntervalTime = jSONObject.optLong("init_launch_interval_time");
        sDKInitMsg.totalDurationTime = jSONObject.optLong("init_total_duration_time");
        sDKInitMsg.initStatus = jSONObject.optInt("init_status", new Integer("0").intValue());
        sDKInitMsg.errorReason = jSONObject.optString("error_reason");
        if (sDKInitMsg.errorReason == JSONObject.NULL) {
            sDKInitMsg.errorReason = "";
        }
        sDKInitMsg.initCount = jSONObject.optInt("init_count");
        sDKInitMsg.initProcess = jSONObject.optInt("init_process");
        sDKInitMsg.initThread = jSONObject.optInt("init_thread");
        sDKInitMsg.intDynamicSDK = jSONObject.optInt("init_dynamic_sdk");
        sDKInitMsg.intBuildNumber = jSONObject.optInt("init_build_number");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(SDKInitMsg sDKInitMsg, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (sDKInitMsg.launchIntervalTime != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "init_launch_interval_time", sDKInitMsg.launchIntervalTime);
        }
        if (sDKInitMsg.totalDurationTime != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "init_total_duration_time", sDKInitMsg.totalDurationTime);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "init_status", sDKInitMsg.initStatus);
        if (sDKInitMsg.errorReason != null && !sDKInitMsg.errorReason.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "error_reason", sDKInitMsg.errorReason);
        }
        if (sDKInitMsg.initCount != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "init_count", sDKInitMsg.initCount);
        }
        if (sDKInitMsg.initProcess != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "init_process", sDKInitMsg.initProcess);
        }
        if (sDKInitMsg.initThread != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "init_thread", sDKInitMsg.initThread);
        }
        if (sDKInitMsg.intDynamicSDK != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "init_dynamic_sdk", sDKInitMsg.intDynamicSDK);
        }
        if (sDKInitMsg.intBuildNumber != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "init_build_number", sDKInitMsg.intBuildNumber);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(SDKInitMsg sDKInitMsg, JSONObject jSONObject) {
        a2(sDKInitMsg, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(SDKInitMsg sDKInitMsg, JSONObject jSONObject) {
        return b2(sDKInitMsg, jSONObject);
    }
}
