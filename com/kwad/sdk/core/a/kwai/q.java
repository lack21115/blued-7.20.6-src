package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.o;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/q.class */
public final class q implements com.kwad.sdk.core.d<o.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(o.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.creativeId = jSONObject.optLong("creativeId", new Long("-1").longValue());
        aVar.adStyle = jSONObject.optInt("adStyle", new Integer("-1").intValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(o.a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "creativeId", aVar.creativeId);
        com.kwad.sdk.utils.t.putValue(jSONObject2, "adStyle", aVar.adStyle);
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(o.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(o.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
