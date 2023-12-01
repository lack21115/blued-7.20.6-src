package com.kwad.sdk.core.a.kwai;

import com.sina.weibo.sdk.constant.WBConstants;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/bl.class */
public final class bl implements com.kwad.sdk.core.d<com.kwad.sdk.core.report.j> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.report.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jVar.llsid = jSONObject.optLong("llsid");
        jVar.creativeId = jSONObject.optLong(com.anythink.expressad.foundation.d.c.l);
        jVar.score = jSONObject.optInt(WBConstants.GAME_PARAMS_SCORE);
        jVar.aiq = jSONObject.optInt("is_bidding");
        jVar.source = jSONObject.optString("source");
        if (jVar.source == JSONObject.NULL) {
            jVar.source = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.report.j jVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (jVar.llsid != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "llsid", jVar.llsid);
        }
        if (jVar.creativeId != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, com.anythink.expressad.foundation.d.c.l, jVar.creativeId);
        }
        if (jVar.score != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, WBConstants.GAME_PARAMS_SCORE, jVar.score);
        }
        if (jVar.aiq != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "is_bidding", jVar.aiq);
        }
        if (jVar.source != null && !jVar.source.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "source", jVar.source);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.report.j jVar, JSONObject jSONObject) {
        a2(jVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.report.j jVar, JSONObject jSONObject) {
        return b2(jVar, jSONObject);
    }
}
