package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/id.class */
public final class id implements com.kwad.sdk.core.d<AdMatrixInfo.SplashSlideInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.SplashSlideInfo splashSlideInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashSlideInfo.title = jSONObject.optString("title");
        if (splashSlideInfo.title == JSONObject.NULL) {
            splashSlideInfo.title = "";
        }
        splashSlideInfo.subtitle = jSONObject.optString("subtitle");
        if (splashSlideInfo.subtitle == JSONObject.NULL) {
            splashSlideInfo.subtitle = "";
        }
        splashSlideInfo.style = jSONObject.optInt("style");
        splashSlideInfo.convertDistance = jSONObject.optInt("convertDistance");
        splashSlideInfo.downloadTexts = new AdMatrixInfo.DownloadTexts();
        splashSlideInfo.downloadTexts.parseJson(jSONObject.optJSONObject("downloadTexts"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.SplashSlideInfo splashSlideInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (splashSlideInfo.title != null && !splashSlideInfo.title.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "title", splashSlideInfo.title);
        }
        if (splashSlideInfo.subtitle != null && !splashSlideInfo.subtitle.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "subtitle", splashSlideInfo.subtitle);
        }
        if (splashSlideInfo.style != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "style", splashSlideInfo.style);
        }
        if (splashSlideInfo.convertDistance != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "convertDistance", splashSlideInfo.convertDistance);
        }
        com.kwad.sdk.utils.t.a(jSONObject2, "downloadTexts", splashSlideInfo.downloadTexts);
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.SplashSlideInfo splashSlideInfo, JSONObject jSONObject) {
        a2(splashSlideInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.SplashSlideInfo splashSlideInfo, JSONObject jSONObject) {
        return b2(splashSlideInfo, jSONObject);
    }
}
