package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/fl.class */
public final class fl implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.m> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.a.a.m mVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        mVar.Vf = jSONObject.optBoolean(com.huawei.openalliance.ad.constant.ao.au);
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.a.a.m mVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (mVar.Vf) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, com.huawei.openalliance.ad.constant.ao.au, mVar.Vf);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.a.m mVar, JSONObject jSONObject) {
        a2(mVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.a.m mVar, JSONObject jSONObject) {
        return b2(mVar, jSONObject);
    }
}
