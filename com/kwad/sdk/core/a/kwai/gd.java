package com.kwad.sdk.core.a.kwai;

import android.provider.Downloads;
import com.kwad.components.core.webview.jshandler.ai;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/gd.class */
public final class gd implements com.kwad.sdk.core.d<ai.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(ai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.status = jSONObject.optInt("status");
        aVar.errorMsg = jSONObject.optString(Downloads.Impl.COLUMN_ERROR_MSG);
        if (aVar.errorMsg == JSONObject.NULL) {
            aVar.errorMsg = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(ai.a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (aVar.status != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "status", aVar.status);
        }
        if (aVar.errorMsg != null && !aVar.errorMsg.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, Downloads.Impl.COLUMN_ERROR_MSG, aVar.errorMsg);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ai.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ai.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
