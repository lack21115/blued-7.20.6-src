package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.ak;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/aq.class */
public final class aq implements com.kwad.sdk.core.d<ak.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(ak.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.TI = jSONObject.optDouble("progress");
        aVar.status = jSONObject.optInt("status");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(ak.a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (aVar.TI != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "progress", aVar.TI);
        }
        if (aVar.status != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "status", aVar.status);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ak.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ak.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
