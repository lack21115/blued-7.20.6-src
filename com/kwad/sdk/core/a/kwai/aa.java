package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/aa.class */
public final class aa implements com.kwad.sdk.core.d<AdInfo.AdPreloadInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.AdPreloadInfo adPreloadInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adPreloadInfo.preloadId = jSONObject.optString("preloadId");
        if (adPreloadInfo.preloadId == JSONObject.NULL) {
            adPreloadInfo.preloadId = "";
        }
        adPreloadInfo.preloadType = jSONObject.optInt("preloadType");
        adPreloadInfo.preloadTips = jSONObject.optString("preloadTips", new String("已提前加载"));
        adPreloadInfo.validityPeriod = jSONObject.optInt("validityPeriod", new Integer("604800").intValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.AdPreloadInfo adPreloadInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (adPreloadInfo.preloadId != null && !adPreloadInfo.preloadId.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "preloadId", adPreloadInfo.preloadId);
        }
        if (adPreloadInfo.preloadType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "preloadType", adPreloadInfo.preloadType);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "preloadTips", adPreloadInfo.preloadTips);
        com.kwad.sdk.utils.t.putValue(jSONObject2, "validityPeriod", adPreloadInfo.validityPeriod);
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdPreloadInfo adPreloadInfo, JSONObject jSONObject) {
        a2(adPreloadInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdPreloadInfo adPreloadInfo, JSONObject jSONObject) {
        return b2(adPreloadInfo, jSONObject);
    }
}
