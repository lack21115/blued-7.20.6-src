package com.kwad.sdk.core.a.kwai;

import com.igexin.assist.sdk.AssistPushConsts;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/fd.class */
public final class fd implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.c.a.c> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.webview.c.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.aqp = jSONObject.optInt("convertType");
        cVar.Ts = jSONObject.optString(AssistPushConsts.MSG_TYPE_PAYLOAD);
        if (cVar.Ts == JSONObject.NULL) {
            cVar.Ts = "";
        }
        cVar.aqq = new com.kwad.sdk.core.webview.c.a.b();
        cVar.aqq.parseJson(jSONObject.optJSONObject("clickInfo"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.webview.c.a.c cVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (cVar.aqp != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "convertType", cVar.aqp);
        }
        if (cVar.Ts != null && !cVar.Ts.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, AssistPushConsts.MSG_TYPE_PAYLOAD, cVar.Ts);
        }
        com.kwad.sdk.utils.t.a(jSONObject2, "clickInfo", cVar.aqq);
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.webview.c.a.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.webview.c.a.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }
}
