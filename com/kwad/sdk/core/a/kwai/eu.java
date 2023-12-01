package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.av;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/eu.class */
public final class eu implements com.kwad.sdk.core.d<av.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(av.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.jU = jSONObject.optInt("itemClickType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(av.a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (aVar.jU != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "itemClickType", aVar.jU);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(av.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(av.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
