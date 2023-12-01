package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.g.b;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/hj.class */
public final class hj implements com.kwad.sdk.core.d<b.C0405b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(b.C0405b c0405b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0405b.aul = jSONObject.optInt("enable_monitor");
        c0405b.aum = jSONObject.optString("c_sc_name");
        if (c0405b.aum == JSONObject.NULL) {
            c0405b.aum = "";
        }
        c0405b.aun = jSONObject.optString("c_pcl_name");
        if (c0405b.aun == JSONObject.NULL) {
            c0405b.aun = "";
        }
        c0405b.auo = jSONObject.optString("m_gam_name");
        if (c0405b.auo == JSONObject.NULL) {
            c0405b.auo = "";
        }
        c0405b.aup = jSONObject.optString("m_gsv_name");
        if (c0405b.aup == JSONObject.NULL) {
            c0405b.aup = "";
        }
        c0405b.auq = jSONObject.optString("m_gpv_name");
        if (c0405b.auq == JSONObject.NULL) {
            c0405b.auq = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(b.C0405b c0405b, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (c0405b.aul != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "enable_monitor", c0405b.aul);
        }
        if (c0405b.aum != null && !c0405b.aum.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "c_sc_name", c0405b.aum);
        }
        if (c0405b.aun != null && !c0405b.aun.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "c_pcl_name", c0405b.aun);
        }
        if (c0405b.auo != null && !c0405b.auo.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "m_gam_name", c0405b.auo);
        }
        if (c0405b.aup != null && !c0405b.aup.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "m_gsv_name", c0405b.aup);
        }
        if (c0405b.auq != null && !c0405b.auq.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "m_gpv_name", c0405b.auq);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(b.C0405b c0405b, JSONObject jSONObject) {
        a2(c0405b, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(b.C0405b c0405b, JSONObject jSONObject) {
        return b2(c0405b, jSONObject);
    }
}
