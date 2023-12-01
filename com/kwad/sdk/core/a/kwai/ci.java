package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/ci.class */
public final class ci implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo detailTopToolBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        detailTopToolBarInfo.callButtonShowTime = jSONObject.optLong("callButtonShowTime");
        detailTopToolBarInfo.callButtonDescription = jSONObject.optString("callButtonDescription");
        if (detailTopToolBarInfo.callButtonDescription == JSONObject.NULL) {
            detailTopToolBarInfo.callButtonDescription = "";
        }
        detailTopToolBarInfo.rewardIconUrl = jSONObject.optString("rewardIconUrl");
        if (detailTopToolBarInfo.rewardIconUrl == JSONObject.NULL) {
            detailTopToolBarInfo.rewardIconUrl = "";
        }
        detailTopToolBarInfo.rewardCallDescription = jSONObject.optString("rewardCallDescription");
        if (detailTopToolBarInfo.rewardCallDescription == JSONObject.NULL) {
            detailTopToolBarInfo.rewardCallDescription = "";
        }
        detailTopToolBarInfo.style = jSONObject.optInt("style");
        detailTopToolBarInfo.maxTimeOut = jSONObject.optLong("maxTimeOut");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo detailTopToolBarInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (detailTopToolBarInfo.callButtonShowTime != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "callButtonShowTime", detailTopToolBarInfo.callButtonShowTime);
        }
        if (detailTopToolBarInfo.callButtonDescription != null && !detailTopToolBarInfo.callButtonDescription.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "callButtonDescription", detailTopToolBarInfo.callButtonDescription);
        }
        if (detailTopToolBarInfo.rewardIconUrl != null && !detailTopToolBarInfo.rewardIconUrl.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "rewardIconUrl", detailTopToolBarInfo.rewardIconUrl);
        }
        if (detailTopToolBarInfo.rewardCallDescription != null && !detailTopToolBarInfo.rewardCallDescription.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "rewardCallDescription", detailTopToolBarInfo.rewardCallDescription);
        }
        if (detailTopToolBarInfo.style != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "style", detailTopToolBarInfo.style);
        }
        if (detailTopToolBarInfo.maxTimeOut != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "maxTimeOut", detailTopToolBarInfo.maxTimeOut);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo detailTopToolBarInfo, JSONObject jSONObject) {
        a2(detailTopToolBarInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo detailTopToolBarInfo, JSONObject jSONObject) {
        return b2(detailTopToolBarInfo, jSONObject);
    }
}
