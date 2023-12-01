package com.kwad.sdk.core.a.kwai;

import com.cdo.oaps.ad.OapsWrapper;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/fy.class */
public final class fy implements com.kwad.sdk.core.d<com.kwad.components.core.webview.kwai.c> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.kwai.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.RY = jSONObject.optString("originalID");
        if (cVar.RY == JSONObject.NULL) {
            cVar.RY = "";
        }
        cVar.RZ = jSONObject.optString(OapsWrapper.KEY_PATH);
        if (cVar.RZ == JSONObject.NULL) {
            cVar.RZ = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.kwai.c cVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (cVar.RY != null && !cVar.RY.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "originalID", cVar.RY);
        }
        if (cVar.RZ != null && !cVar.RZ.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, OapsWrapper.KEY_PATH, cVar.RZ);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.kwai.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.kwai.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }
}
