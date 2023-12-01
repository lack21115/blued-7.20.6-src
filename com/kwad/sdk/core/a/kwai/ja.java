package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/ja.class */
public final class ja implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.w> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.a.a.w wVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        wVar.Vn = jSONObject.optInt("rewardTaskState");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.a.a.w wVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (wVar.Vn != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "rewardTaskState", wVar.Vn);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.a.w wVar, JSONObject jSONObject) {
        a2(wVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.a.w wVar, JSONObject jSONObject) {
        return b2(wVar, jSONObject);
    }
}
