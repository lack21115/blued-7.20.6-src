package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.aj;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/ao.class */
public final class ao implements com.kwad.sdk.core.d<aj.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(aj.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.id = jSONObject.optInt("id");
        aVar.status = jSONObject.optInt("status");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(aj.a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (aVar.id != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "id", aVar.id);
        }
        if (aVar.status != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "status", aVar.status);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(aj.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(aj.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
