package com.kwad.sdk.core.a.kwai;

import android.provider.Downloads;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/bd.class */
public final class bd implements com.kwad.sdk.core.d<com.kwad.sdk.crash.online.monitor.block.c> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.crash.online.monitor.block.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.arW = jSONObject.optString("printerName");
        if (cVar.arW == JSONObject.NULL) {
            cVar.arW = "";
        }
        cVar.errorMsg = jSONObject.optString(Downloads.Impl.COLUMN_ERROR_MSG);
        if (cVar.errorMsg == JSONObject.NULL) {
            cVar.errorMsg = "";
        }
        cVar.arX = jSONObject.optBoolean("isDisable");
        cVar.arY = jSONObject.optBoolean("hasMatrix");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.crash.online.monitor.block.c cVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (cVar.arW != null && !cVar.arW.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "printerName", cVar.arW);
        }
        if (cVar.errorMsg != null && !cVar.errorMsg.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, Downloads.Impl.COLUMN_ERROR_MSG, cVar.errorMsg);
        }
        if (cVar.arX) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "isDisable", cVar.arX);
        }
        if (cVar.arY) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "hasMatrix", cVar.arY);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.crash.online.monitor.block.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.crash.online.monitor.block.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }
}
