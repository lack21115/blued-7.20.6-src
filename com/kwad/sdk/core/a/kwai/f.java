package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.contentalliance.coupon.model.ActivityInfo;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/f.class */
public final class f implements com.kwad.sdk.core.d<ActivityInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(ActivityInfo activityInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        activityInfo.actTypeId = jSONObject.optInt("actTypeId");
        activityInfo.sceneTypeId = jSONObject.optInt("sceneTypeId");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(ActivityInfo activityInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (activityInfo.actTypeId != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "actTypeId", activityInfo.actTypeId);
        }
        if (activityInfo.sceneTypeId != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "sceneTypeId", activityInfo.sceneTypeId);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ActivityInfo activityInfo, JSONObject jSONObject) {
        a2(activityInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ActivityInfo activityInfo, JSONObject jSONObject) {
        return b2(activityInfo, jSONObject);
    }
}
