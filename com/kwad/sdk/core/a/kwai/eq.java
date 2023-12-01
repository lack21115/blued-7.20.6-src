package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.HttpDnsInfo;
import com.tencent.tendinsv.a.b;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/eq.class */
public final class eq implements com.kwad.sdk.core.d<HttpDnsInfo.IpInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(HttpDnsInfo.IpInfo ipInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        ipInfo.ip = jSONObject.optString(b.a.q);
        if (ipInfo.ip == JSONObject.NULL) {
            ipInfo.ip = "";
        }
        ipInfo.weight = jSONObject.optInt("weight");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(HttpDnsInfo.IpInfo ipInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (ipInfo.ip != null && !ipInfo.ip.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, b.a.q, ipInfo.ip);
        }
        if (ipInfo.weight != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "weight", ipInfo.weight);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(HttpDnsInfo.IpInfo ipInfo, JSONObject jSONObject) {
        a2(ipInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(HttpDnsInfo.IpInfo ipInfo, JSONObject jSONObject) {
        return b2(ipInfo, jSONObject);
    }
}
