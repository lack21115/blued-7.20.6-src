package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/cg.class */
public final class cg implements com.kwad.sdk.core.d<AdInfo.AdConversionInfo.DeeplinkItemInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        deeplinkItemInfo.sceneConf = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("sceneConf");
        if (optJSONArray != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    break;
                }
                deeplinkItemInfo.sceneConf.add((Integer) optJSONArray.opt(i2));
                i = i2 + 1;
            }
        }
        deeplinkItemInfo.areaConf = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("areaConf");
        if (optJSONArray2 != null) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= optJSONArray2.length()) {
                    break;
                }
                deeplinkItemInfo.areaConf.add((Integer) optJSONArray2.opt(i4));
                i3 = i4 + 1;
            }
        }
        deeplinkItemInfo.url = jSONObject.optString("url");
        if (deeplinkItemInfo.url == JSONObject.NULL) {
            deeplinkItemInfo.url = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "sceneConf", deeplinkItemInfo.sceneConf);
        com.kwad.sdk.utils.t.putValue(jSONObject2, "areaConf", deeplinkItemInfo.areaConf);
        if (deeplinkItemInfo.url != null && !deeplinkItemInfo.url.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "url", deeplinkItemInfo.url);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo, JSONObject jSONObject) {
        a2(deeplinkItemInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo, JSONObject jSONObject) {
        return b2(deeplinkItemInfo, jSONObject);
    }
}
