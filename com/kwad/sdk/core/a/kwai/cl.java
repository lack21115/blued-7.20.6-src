package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.kwai.a;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/cl.class */
public final class cl implements com.kwad.sdk.core.d<a.C0373a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(a.C0373a c0373a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0373a.url = jSONObject.optString("url");
        if (c0373a.url == JSONObject.NULL) {
            c0373a.url = "";
        }
        c0373a.packageName = jSONObject.optString("packageName");
        if (c0373a.packageName == JSONObject.NULL) {
            c0373a.packageName = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0373a c0373a, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (c0373a.url != null && !c0373a.url.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "url", c0373a.url);
        }
        if (c0373a.packageName != null && !c0373a.packageName.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "packageName", c0373a.packageName);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0373a c0373a, JSONObject jSONObject) {
        a2(c0373a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0373a c0373a, JSONObject jSONObject) {
        return b2(c0373a, jSONObject);
    }
}
