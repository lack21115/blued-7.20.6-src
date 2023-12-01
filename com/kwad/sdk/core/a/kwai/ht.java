package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/ht.class */
public final class ht implements com.kwad.sdk.core.d<AdMatrixInfo.SplashActionBarInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.SplashActionBarInfo splashActionBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashActionBarInfo.title = jSONObject.optString("title");
        if (splashActionBarInfo.title == JSONObject.NULL) {
            splashActionBarInfo.title = "";
        }
        splashActionBarInfo.downloadTexts = new AdMatrixInfo.DownloadTexts();
        splashActionBarInfo.downloadTexts.parseJson(jSONObject.optJSONObject("downloadTexts"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.SplashActionBarInfo splashActionBarInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (splashActionBarInfo.title != null && !splashActionBarInfo.title.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "title", splashActionBarInfo.title);
        }
        com.kwad.sdk.utils.t.a(jSONObject2, "downloadTexts", splashActionBarInfo.downloadTexts);
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.SplashActionBarInfo splashActionBarInfo, JSONObject jSONObject) {
        a2(splashActionBarInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.SplashActionBarInfo splashActionBarInfo, JSONObject jSONObject) {
        return b2(splashActionBarInfo, jSONObject);
    }
}
