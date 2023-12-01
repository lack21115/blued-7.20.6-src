package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/hr.class */
public final class hr implements com.kwad.sdk.core.d<AdInfo.SmallAppJumpInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.SmallAppJumpInfo smallAppJumpInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        smallAppJumpInfo.smallAppJumpUrl = jSONObject.optString("smallAppJumpUrl");
        if (smallAppJumpInfo.smallAppJumpUrl == JSONObject.NULL) {
            smallAppJumpInfo.smallAppJumpUrl = "";
        }
        smallAppJumpInfo.originId = jSONObject.optString("originId");
        if (smallAppJumpInfo.originId == JSONObject.NULL) {
            smallAppJumpInfo.originId = "";
        }
        smallAppJumpInfo.mediaSmallAppId = jSONObject.optString("mediaSmallAppId");
        if (smallAppJumpInfo.mediaSmallAppId == JSONObject.NULL) {
            smallAppJumpInfo.mediaSmallAppId = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.SmallAppJumpInfo smallAppJumpInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (smallAppJumpInfo.smallAppJumpUrl != null && !smallAppJumpInfo.smallAppJumpUrl.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "smallAppJumpUrl", smallAppJumpInfo.smallAppJumpUrl);
        }
        if (smallAppJumpInfo.originId != null && !smallAppJumpInfo.originId.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "originId", smallAppJumpInfo.originId);
        }
        if (smallAppJumpInfo.mediaSmallAppId != null && !smallAppJumpInfo.mediaSmallAppId.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "mediaSmallAppId", smallAppJumpInfo.mediaSmallAppId);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.SmallAppJumpInfo smallAppJumpInfo, JSONObject jSONObject) {
        a2(smallAppJumpInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.SmallAppJumpInfo smallAppJumpInfo, JSONObject jSONObject) {
        return b2(smallAppJumpInfo, jSONObject);
    }
}
