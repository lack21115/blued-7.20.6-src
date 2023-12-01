package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.g.b;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/hj.class */
public final class hj implements com.kwad.sdk.core.d<b.C0575b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(b.C0575b c0575b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0575b.aul = jSONObject.optInt("enable_monitor");
        c0575b.aum = jSONObject.optString("c_sc_name");
        if (c0575b.aum == JSONObject.NULL) {
            c0575b.aum = "";
        }
        c0575b.aun = jSONObject.optString("c_pcl_name");
        if (c0575b.aun == JSONObject.NULL) {
            c0575b.aun = "";
        }
        c0575b.auo = jSONObject.optString("m_gam_name");
        if (c0575b.auo == JSONObject.NULL) {
            c0575b.auo = "";
        }
        c0575b.aup = jSONObject.optString("m_gsv_name");
        if (c0575b.aup == JSONObject.NULL) {
            c0575b.aup = "";
        }
        c0575b.auq = jSONObject.optString("m_gpv_name");
        if (c0575b.auq == JSONObject.NULL) {
            c0575b.auq = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(b.C0575b c0575b, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (c0575b.aul != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "enable_monitor", c0575b.aul);
        }
        if (c0575b.aum != null && !c0575b.aum.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "c_sc_name", c0575b.aum);
        }
        if (c0575b.aun != null && !c0575b.aun.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "c_pcl_name", c0575b.aun);
        }
        if (c0575b.auo != null && !c0575b.auo.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "m_gam_name", c0575b.auo);
        }
        if (c0575b.aup != null && !c0575b.aup.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "m_gsv_name", c0575b.aup);
        }
        if (c0575b.auq != null && !c0575b.auq.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "m_gpv_name", c0575b.auq);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(b.C0575b c0575b, JSONObject jSONObject) {
        a2(c0575b, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(b.C0575b c0575b, JSONObject jSONObject) {
        return b2(c0575b, jSONObject);
    }
}
