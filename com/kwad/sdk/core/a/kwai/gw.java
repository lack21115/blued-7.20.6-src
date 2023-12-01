package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.webview.c.b;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/gw.class */
public final class gw implements com.kwad.sdk.core.d<b.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.url = jSONObject.optString("url");
        if (aVar.url == JSONObject.NULL) {
            aVar.url = "";
        }
        aVar.method = jSONObject.optString("method");
        if (aVar.method == JSONObject.NULL) {
            aVar.method = "";
        }
        aVar.params = jSONObject.optString("params");
        if (aVar.params == JSONObject.NULL) {
            aVar.params = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(b.a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (aVar.url != null && !aVar.url.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "url", aVar.url);
        }
        if (aVar.method != null && !aVar.method.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "method", aVar.method);
        }
        if (aVar.params != null && !aVar.params.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "params", aVar.params);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(b.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(b.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
