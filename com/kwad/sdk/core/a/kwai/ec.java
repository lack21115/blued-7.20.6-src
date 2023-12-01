package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.commercial.model.HybridLoadMsg;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/ec.class */
public final class ec implements com.kwad.sdk.core.d<HybridLoadMsg> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(HybridLoadMsg hybridLoadMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        hybridLoadMsg.sceneId = jSONObject.optString("scene_id");
        if (hybridLoadMsg.sceneId == JSONObject.NULL) {
            hybridLoadMsg.sceneId = "";
        }
        hybridLoadMsg.h5Version = jSONObject.optString("h5_version");
        if (hybridLoadMsg.h5Version == JSONObject.NULL) {
            hybridLoadMsg.h5Version = "";
        }
        hybridLoadMsg.loadType = jSONObject.optInt("load_type");
        hybridLoadMsg.state = jSONObject.optInt("state");
        hybridLoadMsg.interval = jSONObject.optString(com.umeng.analytics.pro.bh.aX);
        if (hybridLoadMsg.interval == JSONObject.NULL) {
            hybridLoadMsg.interval = "";
        }
        hybridLoadMsg.failState = jSONObject.optInt("fail_state");
        hybridLoadMsg.failReason = jSONObject.optString("fail_reason");
        if (hybridLoadMsg.failReason == JSONObject.NULL) {
            hybridLoadMsg.failReason = "";
        }
        hybridLoadMsg.url = jSONObject.optString("url");
        if (hybridLoadMsg.url == JSONObject.NULL) {
            hybridLoadMsg.url = "";
        }
        hybridLoadMsg.packageUrl = jSONObject.optString("package_url");
        if (hybridLoadMsg.packageUrl == JSONObject.NULL) {
            hybridLoadMsg.packageUrl = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(HybridLoadMsg hybridLoadMsg, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (hybridLoadMsg.sceneId != null && !hybridLoadMsg.sceneId.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "scene_id", hybridLoadMsg.sceneId);
        }
        if (hybridLoadMsg.h5Version != null && !hybridLoadMsg.h5Version.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "h5_version", hybridLoadMsg.h5Version);
        }
        if (hybridLoadMsg.loadType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "load_type", hybridLoadMsg.loadType);
        }
        if (hybridLoadMsg.state != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "state", hybridLoadMsg.state);
        }
        if (hybridLoadMsg.interval != null && !hybridLoadMsg.interval.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, com.umeng.analytics.pro.bh.aX, hybridLoadMsg.interval);
        }
        if (hybridLoadMsg.failState != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "fail_state", hybridLoadMsg.failState);
        }
        if (hybridLoadMsg.failReason != null && !hybridLoadMsg.failReason.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "fail_reason", hybridLoadMsg.failReason);
        }
        if (hybridLoadMsg.url != null && !hybridLoadMsg.url.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "url", hybridLoadMsg.url);
        }
        if (hybridLoadMsg.packageUrl != null && !hybridLoadMsg.packageUrl.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "package_url", hybridLoadMsg.packageUrl);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(HybridLoadMsg hybridLoadMsg, JSONObject jSONObject) {
        a2(hybridLoadMsg, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(HybridLoadMsg hybridLoadMsg, JSONObject jSONObject) {
        return b2(hybridLoadMsg, jSONObject);
    }
}
