package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/iz.class */
public final class iz implements com.kwad.sdk.core.d<AdInfo.UnDownloadRegionConf> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.UnDownloadRegionConf unDownloadRegionConf, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        unDownloadRegionConf.materialJumpType = jSONObject.optInt("materialJumpType");
        unDownloadRegionConf.actionBarType = jSONObject.optInt("actionBarType");
        unDownloadRegionConf.describeBarType = jSONObject.optInt("describeBarType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.UnDownloadRegionConf unDownloadRegionConf, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (unDownloadRegionConf.materialJumpType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "materialJumpType", unDownloadRegionConf.materialJumpType);
        }
        if (unDownloadRegionConf.actionBarType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "actionBarType", unDownloadRegionConf.actionBarType);
        }
        if (unDownloadRegionConf.describeBarType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "describeBarType", unDownloadRegionConf.describeBarType);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.UnDownloadRegionConf unDownloadRegionConf, JSONObject jSONObject) {
        a2(unDownloadRegionConf, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.UnDownloadRegionConf unDownloadRegionConf, JSONObject jSONObject) {
        return b2(unDownloadRegionConf, jSONObject);
    }
}
