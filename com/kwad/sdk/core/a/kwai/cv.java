package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.report.a;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/cv.class */
public final class cv implements com.kwad.sdk.core.d<a.C0395a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(a.C0395a c0395a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0395a.code = jSONObject.optInt("code");
        c0395a.msg = jSONObject.optString("msg");
        if (c0395a.msg == JSONObject.NULL) {
            c0395a.msg = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0395a c0395a, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (c0395a.code != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "code", c0395a.code);
        }
        if (c0395a.msg != null && !c0395a.msg.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "msg", c0395a.msg);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0395a c0395a, JSONObject jSONObject) {
        a2(c0395a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0395a c0395a, JSONObject jSONObject) {
        return b2(c0395a, jSONObject);
    }
}
