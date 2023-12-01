package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/bq.class */
public final class bq implements com.kwad.sdk.core.d<AdInfo.ComplianceInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.ComplianceInfo complianceInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        complianceInfo.materialJumpType = jSONObject.optInt("materialJumpType");
        complianceInfo.actionBarType = jSONObject.optInt("actionBarType");
        complianceInfo.describeBarType = jSONObject.optInt("describeBarType");
        complianceInfo.titleBarTextSwitch = jSONObject.optInt("titleBarTextSwitch");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.ComplianceInfo complianceInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (complianceInfo.materialJumpType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "materialJumpType", complianceInfo.materialJumpType);
        }
        if (complianceInfo.actionBarType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "actionBarType", complianceInfo.actionBarType);
        }
        if (complianceInfo.describeBarType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "describeBarType", complianceInfo.describeBarType);
        }
        if (complianceInfo.titleBarTextSwitch != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "titleBarTextSwitch", complianceInfo.titleBarTextSwitch);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.ComplianceInfo complianceInfo, JSONObject jSONObject) {
        a2(complianceInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.ComplianceInfo complianceInfo, JSONObject jSONObject) {
        return b2(complianceInfo, jSONObject);
    }
}
