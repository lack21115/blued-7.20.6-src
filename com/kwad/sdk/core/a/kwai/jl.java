package com.kwad.sdk.core.a.kwai;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.kwad.sdk.commercial.model.WebViewLoadMsg;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/jl.class */
public final class jl implements com.kwad.sdk.core.d<WebViewLoadMsg> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(WebViewLoadMsg webViewLoadMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        webViewLoadMsg.url = jSONObject.optString("url");
        if (webViewLoadMsg.url == JSONObject.NULL) {
            webViewLoadMsg.url = "";
        }
        webViewLoadMsg.state = jSONObject.optInt("state");
        webViewLoadMsg.interval = jSONObject.optString(com.umeng.analytics.pro.bh.aX);
        if (webViewLoadMsg.interval == JSONObject.NULL) {
            webViewLoadMsg.interval = "";
        }
        webViewLoadMsg.failReason = jSONObject.optString("fail_reason");
        if (webViewLoadMsg.failReason == JSONObject.NULL) {
            webViewLoadMsg.failReason = "";
        }
        webViewLoadMsg.costTime = jSONObject.optString(HiAnalyticsConstant.BI_KEY_COST_TIME);
        if (webViewLoadMsg.costTime == JSONObject.NULL) {
            webViewLoadMsg.costTime = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(WebViewLoadMsg webViewLoadMsg, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (webViewLoadMsg.url != null && !webViewLoadMsg.url.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "url", webViewLoadMsg.url);
        }
        if (webViewLoadMsg.state != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "state", webViewLoadMsg.state);
        }
        if (webViewLoadMsg.interval != null && !webViewLoadMsg.interval.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, com.umeng.analytics.pro.bh.aX, webViewLoadMsg.interval);
        }
        if (webViewLoadMsg.failReason != null && !webViewLoadMsg.failReason.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "fail_reason", webViewLoadMsg.failReason);
        }
        if (webViewLoadMsg.costTime != null && !webViewLoadMsg.costTime.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, HiAnalyticsConstant.BI_KEY_COST_TIME, webViewLoadMsg.costTime);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(WebViewLoadMsg webViewLoadMsg, JSONObject jSONObject) {
        a2(webViewLoadMsg, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(WebViewLoadMsg webViewLoadMsg, JSONObject jSONObject) {
        return b2(webViewLoadMsg, jSONObject);
    }
}
