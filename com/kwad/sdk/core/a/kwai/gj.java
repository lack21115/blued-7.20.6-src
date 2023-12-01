package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/gj.class */
public final class gj implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdStyleInfo.PlayDetailInfo playDetailInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        playDetailInfo.type = jSONObject.optInt("type");
        playDetailInfo.detailWebCardInfo = new AdStyleInfo.PlayDetailInfo.DetailWebCardInfo();
        playDetailInfo.detailWebCardInfo.parseJson(jSONObject.optJSONObject("detailWebCardInfo"));
        playDetailInfo.detailTopToolBarInfo = new AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo();
        playDetailInfo.detailTopToolBarInfo.parseJson(jSONObject.optJSONObject("detailTopToolBarInfo"));
        playDetailInfo.actionBarInfo = new AdStyleInfo.PlayDetailInfo.ActionBarInfo();
        playDetailInfo.actionBarInfo.parseJson(jSONObject.optJSONObject("actionBarInfo"));
        playDetailInfo.patchAdInfo = new AdStyleInfo.PlayDetailInfo.PatchAdInfo();
        playDetailInfo.patchAdInfo.parseJson(jSONObject.optJSONObject("patchAdInfo"));
        playDetailInfo.detailCommonInfo = new AdStyleInfo.PlayDetailInfo.DetailCommonInfo();
        playDetailInfo.detailCommonInfo.parseJson(jSONObject.optJSONObject("detailCommonInfo"));
        playDetailInfo.drawAdInfo = new AdStyleInfo.PlayDetailInfo.DrawAdInfo();
        playDetailInfo.drawAdInfo.parseJson(jSONObject.optJSONObject("drawAdInfo"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdStyleInfo.PlayDetailInfo playDetailInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (playDetailInfo.type != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "type", playDetailInfo.type);
        }
        com.kwad.sdk.utils.t.a(jSONObject2, "detailWebCardInfo", playDetailInfo.detailWebCardInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "detailTopToolBarInfo", playDetailInfo.detailTopToolBarInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "actionBarInfo", playDetailInfo.actionBarInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "patchAdInfo", playDetailInfo.patchAdInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "detailCommonInfo", playDetailInfo.detailCommonInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "drawAdInfo", playDetailInfo.drawAdInfo);
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.PlayDetailInfo playDetailInfo, JSONObject jSONObject) {
        a2(playDetailInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.PlayDetailInfo playDetailInfo, JSONObject jSONObject) {
        return b2(playDetailInfo, jSONObject);
    }
}
