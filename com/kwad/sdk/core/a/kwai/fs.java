package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/fs.class */
public final class fs implements com.kwad.sdk.core.d<AdMatrixInfo.NeoVideoInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.NeoVideoInfo neoVideoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        neoVideoInfo.interactionInfo = new AdMatrixInfo.AdInteractionInfo();
        neoVideoInfo.interactionInfo.parseJson(jSONObject.optJSONObject("interactionInfo"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.NeoVideoInfo neoVideoInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject2, "interactionInfo", neoVideoInfo.interactionInfo);
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.NeoVideoInfo neoVideoInfo, JSONObject jSONObject) {
        a2(neoVideoInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.NeoVideoInfo neoVideoInfo, JSONObject jSONObject) {
        return b2(neoVideoInfo, jSONObject);
    }
}
