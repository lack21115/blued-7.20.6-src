package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.HttpDnsInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/eb.class */
public final class eb implements com.kwad.sdk.core.d<HttpDnsInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(HttpDnsInfo httpDnsInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        httpDnsInfo.recommendList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("recommendList");
        if (optJSONArray != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    break;
                }
                HttpDnsInfo.IpInfo ipInfo = new HttpDnsInfo.IpInfo();
                ipInfo.parseJson(optJSONArray.optJSONObject(i2));
                httpDnsInfo.recommendList.add(ipInfo);
                i = i2 + 1;
            }
        }
        httpDnsInfo.backUpList = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("backUpList");
        if (optJSONArray2 != null) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= optJSONArray2.length()) {
                    break;
                }
                HttpDnsInfo.IpInfo ipInfo2 = new HttpDnsInfo.IpInfo();
                ipInfo2.parseJson(optJSONArray2.optJSONObject(i4));
                httpDnsInfo.backUpList.add(ipInfo2);
                i3 = i4 + 1;
            }
        }
        httpDnsInfo.otherList = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("otherList");
        if (optJSONArray3 == null) {
            return;
        }
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= optJSONArray3.length()) {
                return;
            }
            HttpDnsInfo.IpInfo ipInfo3 = new HttpDnsInfo.IpInfo();
            ipInfo3.parseJson(optJSONArray3.optJSONObject(i6));
            httpDnsInfo.otherList.add(ipInfo3);
            i5 = i6 + 1;
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(HttpDnsInfo httpDnsInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "recommendList", httpDnsInfo.recommendList);
        com.kwad.sdk.utils.t.putValue(jSONObject2, "backUpList", httpDnsInfo.backUpList);
        com.kwad.sdk.utils.t.putValue(jSONObject2, "otherList", httpDnsInfo.otherList);
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(HttpDnsInfo httpDnsInfo, JSONObject jSONObject) {
        a2(httpDnsInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(HttpDnsInfo httpDnsInfo, JSONObject jSONObject) {
        return b2(httpDnsInfo, jSONObject);
    }
}
