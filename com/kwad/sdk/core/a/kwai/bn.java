package com.kwad.sdk.core.a.kwai;

import com.kwad.components.ad.reward.k;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/bn.class */
public final class bn implements com.kwad.sdk.core.d<k.c> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(k.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.style = jSONObject.optInt("style");
        cVar.title = jSONObject.optString("title");
        if (cVar.title == JSONObject.NULL) {
            cVar.title = "";
        }
        cVar.qd = jSONObject.optString("closeBtnText");
        if (cVar.qd == JSONObject.NULL) {
            cVar.qd = "";
        }
        cVar.qe = jSONObject.optString("continueBtnText");
        if (cVar.qe == JSONObject.NULL) {
            cVar.qe = "";
        }
        cVar.qf = jSONObject.optString("viewDetailText");
        if (cVar.qf == JSONObject.NULL) {
            cVar.qf = "";
        }
        cVar.qg = jSONObject.optString("unWatchedVideoTime");
        if (cVar.qg == JSONObject.NULL) {
            cVar.qg = "";
        }
        cVar.qh = jSONObject.optString(DBDefinition.ICON_URL);
        if (cVar.qh == JSONObject.NULL) {
            cVar.qh = "";
        }
        cVar.qi = jSONObject.optString("desc");
        if (cVar.qi == JSONObject.NULL) {
            cVar.qi = "";
        }
        cVar.qj = jSONObject.optString("descTxt");
        if (cVar.qj == JSONObject.NULL) {
            cVar.qj = "";
        }
        cVar.qk = jSONObject.optString("currentPlayTime");
        if (cVar.qk == JSONObject.NULL) {
            cVar.qk = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(k.c cVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (cVar.style != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "style", cVar.style);
        }
        if (cVar.title != null && !cVar.title.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "title", cVar.title);
        }
        if (cVar.qd != null && !cVar.qd.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "closeBtnText", cVar.qd);
        }
        if (cVar.qe != null && !cVar.qe.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "continueBtnText", cVar.qe);
        }
        if (cVar.qf != null && !cVar.qf.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "viewDetailText", cVar.qf);
        }
        if (cVar.qg != null && !cVar.qg.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "unWatchedVideoTime", cVar.qg);
        }
        if (cVar.qh != null && !cVar.qh.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, DBDefinition.ICON_URL, cVar.qh);
        }
        if (cVar.qi != null && !cVar.qi.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "desc", cVar.qi);
        }
        if (cVar.qj != null && !cVar.qj.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "descTxt", cVar.qj);
        }
        if (cVar.qk != null && !cVar.qk.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "currentPlayTime", cVar.qk);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(k.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(k.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }
}
