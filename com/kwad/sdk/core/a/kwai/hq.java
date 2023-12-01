package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/hq.class */
public final class hq implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.u> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.a.a.u uVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        uVar.Vk = jSONObject.optBoolean("needPromopt");
        uVar.IQ = jSONObject.optBoolean("needReport");
        uVar.showTime = jSONObject.optInt("showTime");
        uVar.Vl = jSONObject.optLong("playDuration");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.a.a.u uVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (uVar.Vk) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "needPromopt", uVar.Vk);
        }
        if (uVar.IQ) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "needReport", uVar.IQ);
        }
        if (uVar.showTime != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "showTime", uVar.showTime);
        }
        if (uVar.Vl != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "playDuration", uVar.Vl);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.a.u uVar, JSONObject jSONObject) {
        a2(uVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.a.u uVar, JSONObject jSONObject) {
        return b2(uVar, jSONObject);
    }
}
