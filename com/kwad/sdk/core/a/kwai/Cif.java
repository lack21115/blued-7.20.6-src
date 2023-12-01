package com.kwad.sdk.core.a.kwai;

import com.kwad.components.ad.splashscreen.monitor.SplashWebMonitorInfo;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.a.kwai.if  reason: invalid class name */
/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/if.class */
public final class Cif implements com.kwad.sdk.core.d<SplashWebMonitorInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(SplashWebMonitorInfo splashWebMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashWebMonitorInfo.event = jSONObject.optString("event");
        if (splashWebMonitorInfo.event == JSONObject.NULL) {
            splashWebMonitorInfo.event = "";
        }
        splashWebMonitorInfo.status = jSONObject.optInt("status");
        splashWebMonitorInfo.url = jSONObject.optString("url");
        if (splashWebMonitorInfo.url == JSONObject.NULL) {
            splashWebMonitorInfo.url = "";
        }
        splashWebMonitorInfo.sceneId = jSONObject.optString("scene_id");
        if (splashWebMonitorInfo.sceneId == JSONObject.NULL) {
            splashWebMonitorInfo.sceneId = "";
        }
        splashWebMonitorInfo.durationMs = jSONObject.optLong("duration_ms");
        splashWebMonitorInfo.timeType = jSONObject.optInt("time_type");
        splashWebMonitorInfo.errorMsg = jSONObject.optString("error_msg");
        if (splashWebMonitorInfo.errorMsg == JSONObject.NULL) {
            splashWebMonitorInfo.errorMsg = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(SplashWebMonitorInfo splashWebMonitorInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (splashWebMonitorInfo.event != null && !splashWebMonitorInfo.event.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "event", splashWebMonitorInfo.event);
        }
        if (splashWebMonitorInfo.status != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "status", splashWebMonitorInfo.status);
        }
        if (splashWebMonitorInfo.url != null && !splashWebMonitorInfo.url.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "url", splashWebMonitorInfo.url);
        }
        if (splashWebMonitorInfo.sceneId != null && !splashWebMonitorInfo.sceneId.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "scene_id", splashWebMonitorInfo.sceneId);
        }
        if (splashWebMonitorInfo.durationMs != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "duration_ms", splashWebMonitorInfo.durationMs);
        }
        if (splashWebMonitorInfo.timeType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "time_type", splashWebMonitorInfo.timeType);
        }
        if (splashWebMonitorInfo.errorMsg != null && !splashWebMonitorInfo.errorMsg.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "error_msg", splashWebMonitorInfo.errorMsg);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(SplashWebMonitorInfo splashWebMonitorInfo, JSONObject jSONObject) {
        a2(splashWebMonitorInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(SplashWebMonitorInfo splashWebMonitorInfo, JSONObject jSONObject) {
        return b2(splashWebMonitorInfo, jSONObject);
    }
}
