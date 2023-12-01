package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/ib.class */
public final class ib implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.v> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.a.a.v vVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        vVar.nZ = jSONObject.optInt("currentTime");
        vVar.Vm = jSONObject.optBoolean("finished");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.a.a.v vVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (vVar.nZ != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "currentTime", vVar.nZ);
        }
        if (vVar.Vm) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "finished", vVar.Vm);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.a.v vVar, JSONObject jSONObject) {
        a2(vVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.a.v vVar, JSONObject jSONObject) {
        return b2(vVar, jSONObject);
    }
}
