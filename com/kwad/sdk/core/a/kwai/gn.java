package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.w;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/gn.class */
public final class gn implements com.kwad.sdk.core.d<w.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(w.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.playableExtraData = jSONObject.optString("playableExtraData");
        if (aVar.playableExtraData == JSONObject.NULL) {
            aVar.playableExtraData = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(w.a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (aVar.playableExtraData != null && !aVar.playableExtraData.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "playableExtraData", aVar.playableExtraData);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(w.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(w.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
