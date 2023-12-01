package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/hl.class */
public final class hl implements com.kwad.sdk.core.d<AdMatrixInfo.ShakeInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.ShakeInfo shakeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        shakeInfo.title = jSONObject.optString("title");
        if (shakeInfo.title == JSONObject.NULL) {
            shakeInfo.title = "";
        }
        shakeInfo.subtitle = jSONObject.optString("subtitle");
        if (shakeInfo.subtitle == JSONObject.NULL) {
            shakeInfo.subtitle = "";
        }
        shakeInfo.acceleration = jSONObject.optInt("acceleration");
        shakeInfo.clickDisabled = jSONObject.optBoolean("clickDisabled");
        shakeInfo.componentIndex = jSONObject.optInt("componentIndex");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.ShakeInfo shakeInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (shakeInfo.title != null && !shakeInfo.title.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "title", shakeInfo.title);
        }
        if (shakeInfo.subtitle != null && !shakeInfo.subtitle.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "subtitle", shakeInfo.subtitle);
        }
        if (shakeInfo.acceleration != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "acceleration", shakeInfo.acceleration);
        }
        if (shakeInfo.clickDisabled) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "clickDisabled", shakeInfo.clickDisabled);
        }
        if (shakeInfo.componentIndex != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "componentIndex", shakeInfo.componentIndex);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.ShakeInfo shakeInfo, JSONObject jSONObject) {
        a2(shakeInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.ShakeInfo shakeInfo, JSONObject jSONObject) {
        return b2(shakeInfo, jSONObject);
    }
}
