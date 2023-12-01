package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.h;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/ei.class */
public final class ei implements com.kwad.sdk.core.d<h.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(h.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.Si = jSONObject.optString("apkUrl");
        if (aVar.Si == JSONObject.NULL) {
            aVar.Si = "";
        }
        aVar.packageName = jSONObject.optString("packageName");
        if (aVar.packageName == JSONObject.NULL) {
            aVar.packageName = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(h.a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (aVar.Si != null && !aVar.Si.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "apkUrl", aVar.Si);
        }
        if (aVar.packageName != null && !aVar.packageName.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "packageName", aVar.packageName);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(h.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(h.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
