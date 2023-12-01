package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/hd.class */
public final class hd implements com.kwad.sdk.core.d<AdMatrixInfo.RewardWebTaskCloseInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.RewardWebTaskCloseInfo rewardWebTaskCloseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rewardWebTaskCloseInfo.templateId = jSONObject.optString(com.huawei.openalliance.ad.constant.at.C);
        if (rewardWebTaskCloseInfo.templateId == JSONObject.NULL) {
            rewardWebTaskCloseInfo.templateId = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.RewardWebTaskCloseInfo rewardWebTaskCloseInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (rewardWebTaskCloseInfo.templateId != null && !rewardWebTaskCloseInfo.templateId.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, com.huawei.openalliance.ad.constant.at.C, rewardWebTaskCloseInfo.templateId);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.RewardWebTaskCloseInfo rewardWebTaskCloseInfo, JSONObject jSONObject) {
        a2(rewardWebTaskCloseInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.RewardWebTaskCloseInfo rewardWebTaskCloseInfo, JSONObject jSONObject) {
        return b2(rewardWebTaskCloseInfo, jSONObject);
    }
}
