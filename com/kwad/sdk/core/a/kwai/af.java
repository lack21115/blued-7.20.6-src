package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdStatusInfo;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/af.class */
public final class af implements com.kwad.sdk.core.d<AdStatusInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdStatusInfo adStatusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adStatusInfo.loadFromCache = jSONObject.optBoolean("loadFromCache");
        adStatusInfo.loadDataTime = jSONObject.optLong("loadDataTime");
        adStatusInfo.downloadFinishTime = jSONObject.optLong("downloadFinishTime");
        adStatusInfo.downloadType = jSONObject.optInt("downloadType");
        adStatusInfo.downloadSize = jSONObject.optLong("downloadSize");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdStatusInfo adStatusInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (adStatusInfo.loadFromCache) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "loadFromCache", adStatusInfo.loadFromCache);
        }
        if (adStatusInfo.loadDataTime != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "loadDataTime", adStatusInfo.loadDataTime);
        }
        if (adStatusInfo.downloadFinishTime != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "downloadFinishTime", adStatusInfo.downloadFinishTime);
        }
        if (adStatusInfo.downloadType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "downloadType", adStatusInfo.downloadType);
        }
        if (adStatusInfo.downloadSize != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "downloadSize", adStatusInfo.downloadSize);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStatusInfo adStatusInfo, JSONObject jSONObject) {
        a2(adStatusInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStatusInfo adStatusInfo, JSONObject jSONObject) {
        return b2(adStatusInfo, jSONObject);
    }
}
