package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.report.q;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/bj.class */
public final class bj implements com.kwad.sdk.core.d<q.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(q.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.ajN = jSONObject.optInt("posIdWidth");
        aVar.ajO = jSONObject.optInt("posIdHeight");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(q.a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (aVar.ajN != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "posIdWidth", aVar.ajN);
        }
        if (aVar.ajO != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "posIdHeight", aVar.ajO);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(q.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(q.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
