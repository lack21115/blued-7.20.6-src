package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/hg.class */
public final class hg implements com.kwad.sdk.core.d<AdMatrixInfo.RotateInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.RotateInfo rotateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        rotateInfo.title = jSONObject.optString("title");
        if (rotateInfo.title == JSONObject.NULL) {
            rotateInfo.title = "";
        }
        rotateInfo.subTitle = jSONObject.optString("subTitle");
        if (rotateInfo.subTitle == JSONObject.NULL) {
            rotateInfo.subTitle = "";
        }
        rotateInfo.downloadTexts = new AdMatrixInfo.DownloadTexts();
        rotateInfo.downloadTexts.parseJson(jSONObject.optJSONObject("downloadTexts"));
        rotateInfo.x = new AdMatrixInfo.RotateDegreeInfo();
        rotateInfo.x.parseJson(jSONObject.optJSONObject("x"));
        rotateInfo.y = new AdMatrixInfo.RotateDegreeInfo();
        rotateInfo.y.parseJson(jSONObject.optJSONObject("y"));
        rotateInfo.z = new AdMatrixInfo.RotateDegreeInfo();
        rotateInfo.z.parseJson(jSONObject.optJSONObject(com.umeng.analytics.pro.bh.aG));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.RotateInfo rotateInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (rotateInfo.title != null && !rotateInfo.title.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "title", rotateInfo.title);
        }
        if (rotateInfo.subTitle != null && !rotateInfo.subTitle.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "subTitle", rotateInfo.subTitle);
        }
        com.kwad.sdk.utils.t.a(jSONObject2, "downloadTexts", rotateInfo.downloadTexts);
        com.kwad.sdk.utils.t.a(jSONObject2, "x", rotateInfo.x);
        com.kwad.sdk.utils.t.a(jSONObject2, "y", rotateInfo.y);
        com.kwad.sdk.utils.t.a(jSONObject2, com.umeng.analytics.pro.bh.aG, rotateInfo.z);
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.RotateInfo rotateInfo, JSONObject jSONObject) {
        a2(rotateInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.RotateInfo rotateInfo, JSONObject jSONObject) {
        return b2(rotateInfo, jSONObject);
    }
}
