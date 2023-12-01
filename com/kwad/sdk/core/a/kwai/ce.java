package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/ce.class */
public final class ce implements com.kwad.sdk.core.d<AdMatrixInfo.CycleAggregateInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.CycleAggregateInfo cycleAggregateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cycleAggregateInfo.cutIconUrl = jSONObject.optString("cutIconUrl");
        if (cycleAggregateInfo.cutIconUrl == JSONObject.NULL) {
            cycleAggregateInfo.cutIconUrl = "";
        }
        cycleAggregateInfo.refreshIconUrl = jSONObject.optString("refreshIconUrl");
        if (cycleAggregateInfo.refreshIconUrl == JSONObject.NULL) {
            cycleAggregateInfo.refreshIconUrl = "";
        }
        cycleAggregateInfo.convertIconUrl = jSONObject.optString("convertIconUrl");
        if (cycleAggregateInfo.convertIconUrl == JSONObject.NULL) {
            cycleAggregateInfo.convertIconUrl = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.CycleAggregateInfo cycleAggregateInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (cycleAggregateInfo.cutIconUrl != null && !cycleAggregateInfo.cutIconUrl.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "cutIconUrl", cycleAggregateInfo.cutIconUrl);
        }
        if (cycleAggregateInfo.refreshIconUrl != null && !cycleAggregateInfo.refreshIconUrl.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "refreshIconUrl", cycleAggregateInfo.refreshIconUrl);
        }
        if (cycleAggregateInfo.convertIconUrl != null && !cycleAggregateInfo.convertIconUrl.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "convertIconUrl", cycleAggregateInfo.convertIconUrl);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.CycleAggregateInfo cycleAggregateInfo, JSONObject jSONObject) {
        a2(cycleAggregateInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.CycleAggregateInfo cycleAggregateInfo, JSONObject jSONObject) {
        return b2(cycleAggregateInfo, jSONObject);
    }
}
