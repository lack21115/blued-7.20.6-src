package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.af;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/er.class */
public final class er implements com.kwad.sdk.core.d<af.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(af.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.TB = jSONObject.optString("adTemplate");
        if (aVar.TB == JSONObject.NULL) {
            aVar.TB = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(af.a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (aVar.TB != null && !aVar.TB.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "adTemplate", aVar.TB);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(af.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(af.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
