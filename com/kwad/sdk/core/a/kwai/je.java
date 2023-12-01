package com.kwad.sdk.core.a.kwai;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/je.class */
public final class je implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.y> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.components.core.webview.a.a.y yVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        yVar.Vp = jSONObject.optString("status");
        if (yVar.Vp == JSONObject.NULL) {
            yVar.Vp = "";
        }
        yVar.errorCode = jSONObject.optInt("errorCode");
        yVar.errorReason = jSONObject.optString(HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON);
        if (yVar.errorReason == JSONObject.NULL) {
            yVar.errorReason = "";
        }
        yVar.nZ = jSONObject.optInt("currentTime");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.components.core.webview.a.a.y yVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (yVar.Vp != null && !yVar.Vp.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "status", yVar.Vp);
        }
        if (yVar.errorCode != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "errorCode", yVar.errorCode);
        }
        if (yVar.errorReason != null && !yVar.errorReason.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, yVar.errorReason);
        }
        if (yVar.nZ != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "currentTime", yVar.nZ);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.a.y yVar, JSONObject jSONObject) {
        a2(yVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.a.y yVar, JSONObject jSONObject) {
        return b2(yVar, jSONObject);
    }
}
