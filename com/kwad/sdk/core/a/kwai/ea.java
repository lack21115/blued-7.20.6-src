package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.aa;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/ea.class */
public final class ea implements com.kwad.sdk.core.d<aa.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(aa.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.type = jSONObject.optInt("type");
        aVar.Tm = jSONObject.optInt("playDuration");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(aa.a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (aVar.type != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "type", aVar.type);
        }
        if (aVar.Tm != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "playDuration", aVar.Tm);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(aa.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(aa.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
