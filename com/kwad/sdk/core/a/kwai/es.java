package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.af;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/es.class */
public final class es implements com.kwad.sdk.core.d<af.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(af.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.TI = jSONObject.optDouble("progress");
        bVar.status = jSONObject.optInt("status");
        bVar.totalBytes = jSONObject.optLong(DBDefinition.TOTAL_BYTES);
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(af.b bVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (bVar.TI != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "progress", bVar.TI);
        }
        if (bVar.status != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "status", bVar.status);
        }
        if (bVar.totalBytes != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, DBDefinition.TOTAL_BYTES, bVar.totalBytes);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(af.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(af.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
