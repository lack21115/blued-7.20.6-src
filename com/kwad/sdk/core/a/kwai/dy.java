package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.at;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/dy.class */
public final class dy implements com.kwad.sdk.core.d<at.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(at.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.visibility = jSONObject.optInt("visibility");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(at.a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (aVar.visibility != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "visibility", aVar.visibility);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(at.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(at.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
