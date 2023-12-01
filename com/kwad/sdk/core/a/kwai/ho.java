package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/ho.class */
public final class ho implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.s> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.a.a.s sVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        sVar.templateId = jSONObject.optString(com.huawei.openalliance.ad.constant.at.C);
        if (sVar.templateId == JSONObject.NULL) {
            sVar.templateId = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.a.a.s sVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (sVar.templateId != null && !sVar.templateId.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, com.huawei.openalliance.ad.constant.at.C, sVar.templateId);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.a.s sVar, JSONObject jSONObject) {
        a2(sVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.a.s sVar, JSONObject jSONObject) {
        return b2(sVar, jSONObject);
    }
}
