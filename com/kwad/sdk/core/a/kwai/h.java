package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/h.class */
public final class h implements com.kwad.sdk.core.d<AdInfo.AdAggregateInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.AdAggregateInfo adAggregateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adAggregateInfo.aggregateAdType = jSONObject.optInt("aggregateAdType");
        adAggregateInfo.upperTab = jSONObject.optString("upperTab");
        if (adAggregateInfo.upperTab == JSONObject.NULL) {
            adAggregateInfo.upperTab = "";
        }
        adAggregateInfo.hotTagUrl = jSONObject.optString("hotTagUrl");
        if (adAggregateInfo.hotTagUrl == JSONObject.NULL) {
            adAggregateInfo.hotTagUrl = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.AdAggregateInfo adAggregateInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (adAggregateInfo.aggregateAdType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "aggregateAdType", adAggregateInfo.aggregateAdType);
        }
        if (adAggregateInfo.upperTab != null && !adAggregateInfo.upperTab.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "upperTab", adAggregateInfo.upperTab);
        }
        if (adAggregateInfo.hotTagUrl != null && !adAggregateInfo.hotTagUrl.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "hotTagUrl", adAggregateInfo.hotTagUrl);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdAggregateInfo adAggregateInfo, JSONObject jSONObject) {
        a2(adAggregateInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdAggregateInfo adAggregateInfo, JSONObject jSONObject) {
        return b2(adAggregateInfo, jSONObject);
    }
}
