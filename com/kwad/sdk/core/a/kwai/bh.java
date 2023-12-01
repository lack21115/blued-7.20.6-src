package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/bh.class */
public final class bh implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.c.a.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.webview.c.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.x = jSONObject.optDouble("x");
        bVar.y = jSONObject.optDouble("y");
        bVar.width = jSONObject.optInt("width");
        bVar.height = jSONObject.optInt("height");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.webview.c.a.b bVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (bVar.x != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "x", bVar.x);
        }
        if (bVar.y != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "y", bVar.y);
        }
        if (bVar.width != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "width", bVar.width);
        }
        if (bVar.height != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "height", bVar.height);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.webview.c.a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.webview.c.a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
