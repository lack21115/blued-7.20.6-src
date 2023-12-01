package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.e;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/ds.class */
public final class ds implements com.kwad.sdk.core.d<e.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(e.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.Se = jSONObject.optInt("playableSrc");
        bVar.Sf = jSONObject.optInt("isPlayAgainScene");
        bVar.Sg = jSONObject.optInt("isMiddleEnd");
        bVar.JE = jSONObject.optInt("adType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(e.b bVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (bVar.Se != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "playableSrc", bVar.Se);
        }
        if (bVar.Sf != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "isPlayAgainScene", bVar.Sf);
        }
        if (bVar.Sg != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "isMiddleEnd", bVar.Sg);
        }
        if (bVar.JE != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "adType", bVar.JE);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(e.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(e.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
