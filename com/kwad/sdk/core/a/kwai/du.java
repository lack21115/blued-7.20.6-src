package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/du.class */
public final class du implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.i> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.a.a.i iVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        iVar.rewardTime = jSONObject.optInt("rewardTime");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.a.a.i iVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (iVar.rewardTime != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "rewardTime", iVar.rewardTime);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.a.i iVar, JSONObject jSONObject) {
        a2(iVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.a.i iVar, JSONObject jSONObject) {
        return b2(iVar, jSONObject);
    }
}
