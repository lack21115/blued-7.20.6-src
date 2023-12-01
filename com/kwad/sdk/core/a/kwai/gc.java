package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.PageInfo;
import com.oplus.quickgame.sdk.hall.Constant;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/gc.class */
public final class gc implements com.kwad.sdk.core.d<PageInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(PageInfo pageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        pageInfo.pageType = jSONObject.optInt(Constant.Param.KEY_RPK_PAGE_TYPE);
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(PageInfo pageInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (pageInfo.pageType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, Constant.Param.KEY_RPK_PAGE_TYPE, pageInfo.pageType);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(PageInfo pageInfo, JSONObject jSONObject) {
        a2(pageInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(PageInfo pageInfo, JSONObject jSONObject) {
        return b2(pageInfo, jSONObject);
    }
}
