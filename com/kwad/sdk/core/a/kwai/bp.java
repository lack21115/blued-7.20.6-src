package com.kwad.sdk.core.a.kwai;

import com.opos.mobad.activity.VideoActivity;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/bp.class */
public final class bp implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.g> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.a.a.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        gVar.Ts = jSONObject.optString("payload");
        if (gVar.Ts == JSONObject.NULL) {
            gVar.Ts = "";
        }
        gVar.Tr = jSONObject.optInt(VideoActivity.EXTRA_KEY_ACTION_TYPE);
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.a.a.g gVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (gVar.Ts != null && !gVar.Ts.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "payload", gVar.Ts);
        }
        if (gVar.Tr != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, VideoActivity.EXTRA_KEY_ACTION_TYPE, gVar.Tr);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.a.g gVar, JSONObject jSONObject) {
        a2(gVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.a.g gVar, JSONObject jSONObject) {
        return b2(gVar, jSONObject);
    }
}
