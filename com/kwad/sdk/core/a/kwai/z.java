package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/z.class */
public final class z implements com.kwad.sdk.core.d<AdMatrixInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo adMatrixInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adMatrixInfo.styles = new AdMatrixInfo.Styles();
        adMatrixInfo.styles.parseJson(jSONObject.optJSONObject("styles"));
        adMatrixInfo.adDataV2 = new AdMatrixInfo.AdDataV2();
        adMatrixInfo.adDataV2.parseJson(jSONObject.optJSONObject("adDataV2"));
        adMatrixInfo.tag = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("tag");
        if (optJSONArray == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= optJSONArray.length()) {
                return;
            }
            AdMatrixInfo.MatrixTag matrixTag = new AdMatrixInfo.MatrixTag();
            matrixTag.parseJson(optJSONArray.optJSONObject(i2));
            adMatrixInfo.tag.add(matrixTag);
            i = i2 + 1;
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo adMatrixInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject2, "styles", adMatrixInfo.styles);
        com.kwad.sdk.utils.t.a(jSONObject2, "adDataV2", adMatrixInfo.adDataV2);
        com.kwad.sdk.utils.t.putValue(jSONObject2, "tag", adMatrixInfo.tag);
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo adMatrixInfo, JSONObject jSONObject) {
        a2(adMatrixInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo adMatrixInfo, JSONObject jSONObject) {
        return b2(adMatrixInfo, jSONObject);
    }
}
