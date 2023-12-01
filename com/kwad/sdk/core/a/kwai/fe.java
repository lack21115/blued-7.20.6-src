package com.kwad.sdk.core.a.kwai;

import android.provider.Downloads;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/fe.class */
public final class fe implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.a.kwai.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.webview.a.kwai.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("Status");
        bVar.contentEncoding = jSONObject.optString("Content-Encoding");
        if (bVar.contentEncoding == JSONObject.NULL) {
            bVar.contentEncoding = "";
        }
        bVar.apW = jSONObject.optString("Cache-Control");
        if (bVar.apW == JSONObject.NULL) {
            bVar.apW = "";
        }
        bVar.apU = jSONObject.optString("Content-Type");
        if (bVar.apU == JSONObject.NULL) {
            bVar.apU = "";
        }
        bVar.apX = new com.kwad.sdk.core.webview.a.kwai.a();
        bVar.apX.parseJson(jSONObject.optJSONObject(Downloads.Impl.RequestHeaders.URI_SEGMENT));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.webview.a.kwai.b bVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (bVar.status != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "Status", bVar.status);
        }
        if (bVar.contentEncoding != null && !bVar.contentEncoding.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "Content-Encoding", bVar.contentEncoding);
        }
        if (bVar.apW != null && !bVar.apW.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "Cache-Control", bVar.apW);
        }
        if (bVar.apU != null && !bVar.apU.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "Content-Type", bVar.apU);
        }
        com.kwad.sdk.utils.t.a(jSONObject2, Downloads.Impl.RequestHeaders.URI_SEGMENT, bVar.apX);
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.webview.a.kwai.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.webview.a.kwai.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
