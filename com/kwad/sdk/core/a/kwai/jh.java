package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/jh.class */
public final class jh implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.z> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.a.a.z zVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        zVar.nZ = jSONObject.optInt("currentTime");
        zVar.Vq = jSONObject.optBoolean(com.alipay.sdk.util.e.f4661a);
        zVar.Vm = jSONObject.optBoolean("finished");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.a.a.z zVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (zVar.nZ != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "currentTime", zVar.nZ);
        }
        if (zVar.Vq) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, com.alipay.sdk.util.e.f4661a, zVar.Vq);
        }
        if (zVar.Vm) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "finished", zVar.Vm);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.a.z zVar, JSONObject jSONObject) {
        a2(zVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.a.z zVar, JSONObject jSONObject) {
        return b2(zVar, jSONObject);
    }
}
