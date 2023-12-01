package com.kwad.sdk.core.a.kwai;

import com.anythink.expressad.advanced.js.NativeAdvancedJsUtils;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/aw.class */
public final class aw implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.d> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.a.a.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.UY = jSONObject.optBoolean(NativeAdvancedJsUtils.k);
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.a.a.d dVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (dVar.UY) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, NativeAdvancedJsUtils.k, dVar.UY);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.a.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.a.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }
}
