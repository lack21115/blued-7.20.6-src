package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.report.y;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/bi.class */
public final class bi implements com.kwad.sdk.core.d<y.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(y.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.templateId = jSONObject.optString("template_id");
        if (aVar.templateId == JSONObject.NULL) {
            aVar.templateId = "";
        }
        aVar.ajZ = jSONObject.optString("template_show_type");
        if (aVar.ajZ == JSONObject.NULL) {
            aVar.ajZ = "";
        }
        aVar.aka = jSONObject.optInt("award_task_name");
        aVar.akb = jSONObject.optInt("jumps_liveroom_type");
        aVar.akc = jSONObject.optInt("universe_feature_freg");
        aVar.ake = jSONObject.optInt("is_special_preload");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(y.a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (aVar.templateId != null && !aVar.templateId.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "template_id", aVar.templateId);
        }
        if (aVar.ajZ != null && !aVar.ajZ.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "template_show_type", aVar.ajZ);
        }
        if (aVar.aka != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "award_task_name", aVar.aka);
        }
        if (aVar.akb != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "jumps_liveroom_type", aVar.akb);
        }
        if (aVar.akc != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "universe_feature_freg", aVar.akc);
        }
        if (aVar.ake != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "is_special_preload", aVar.ake);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(y.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(y.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
