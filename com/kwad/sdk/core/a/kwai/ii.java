package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.request.model.StatusInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/ii.class */
public final class ii implements com.kwad.sdk.core.d<StatusInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(StatusInfo statusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        statusInfo.alF = jSONObject.optInt("personalRecommend");
        statusInfo.alG = jSONObject.optInt("programmaticRecommend");
        statusInfo.alH = new StatusInfo.SplashAdInfo();
        statusInfo.alH.parseJson(jSONObject.optJSONObject("splashAdInfo"));
        statusInfo.alI = new StatusInfo.NativeAdRequestInfo();
        statusInfo.alI.parseJson(jSONObject.optJSONObject("nativeAdInfo"));
        statusInfo.alJ = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("taskStats");
        if (optJSONArray == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= optJSONArray.length()) {
                return;
            }
            com.kwad.sdk.core.request.model.f fVar = new com.kwad.sdk.core.request.model.f();
            fVar.parseJson(optJSONArray.optJSONObject(i2));
            statusInfo.alJ.add(fVar);
            i = i2 + 1;
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(StatusInfo statusInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (statusInfo.alF != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "personalRecommend", statusInfo.alF);
        }
        if (statusInfo.alG != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "programmaticRecommend", statusInfo.alG);
        }
        com.kwad.sdk.utils.t.a(jSONObject2, "splashAdInfo", statusInfo.alH);
        com.kwad.sdk.utils.t.a(jSONObject2, "nativeAdInfo", statusInfo.alI);
        com.kwad.sdk.utils.t.putValue(jSONObject2, "taskStats", statusInfo.alJ);
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(StatusInfo statusInfo, JSONObject jSONObject) {
        a2(statusInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(StatusInfo statusInfo, JSONObject jSONObject) {
        return b2(statusInfo, jSONObject);
    }
}
