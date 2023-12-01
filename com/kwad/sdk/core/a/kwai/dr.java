package com.kwad.sdk.core.a.kwai;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.kwad.components.core.webview.jshandler.e;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/dr.class */
public final class dr implements com.kwad.sdk.core.d<e.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(e.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.Sd = jSONObject.optString(TypedValues.AttributesType.S_TARGET);
        if (aVar.Sd == JSONObject.NULL) {
            aVar.Sd = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(e.a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (aVar.Sd != null && !aVar.Sd.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, TypedValues.AttributesType.S_TARGET, aVar.Sd);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(e.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(e.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
