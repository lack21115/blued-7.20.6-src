package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.g.a;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/cr.class */
public final class cr implements com.kwad.sdk.core.d<a.C0574a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(a.C0574a c0574a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0574a.sdkVersion = jSONObject.optString("run_sdk_version");
        if (c0574a.sdkVersion == JSONObject.NULL) {
            c0574a.sdkVersion = "";
        }
        c0574a.aud = jSONObject.optLong("trigger_count", new Long("0").longValue());
        c0574a.aue = jSONObject.optLong("fail_count", new Long("0").longValue());
        c0574a.auf = jSONObject.optLong("real_fail_count", new Long("0").longValue());
        c0574a.aug = jSONObject.optString("business");
        if (c0574a.aug == JSONObject.NULL) {
            c0574a.aug = "";
        }
        c0574a.auh = jSONObject.optString("stage");
        if (c0574a.auh == JSONObject.NULL) {
            c0574a.auh = "";
        }
        c0574a.aui = jSONObject.optString("function");
        if (c0574a.aui == JSONObject.NULL) {
            c0574a.aui = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0574a c0574a, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (c0574a.sdkVersion != null && !c0574a.sdkVersion.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "run_sdk_version", c0574a.sdkVersion);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "trigger_count", c0574a.aud);
        com.kwad.sdk.utils.t.putValue(jSONObject2, "fail_count", c0574a.aue);
        com.kwad.sdk.utils.t.putValue(jSONObject2, "real_fail_count", c0574a.auf);
        if (c0574a.aug != null && !c0574a.aug.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "business", c0574a.aug);
        }
        if (c0574a.auh != null && !c0574a.auh.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "stage", c0574a.auh);
        }
        if (c0574a.aui != null && !c0574a.aui.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "function", c0574a.aui);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0574a c0574a, JSONObject jSONObject) {
        a2(c0574a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0574a c0574a, JSONObject jSONObject) {
        return b2(c0574a, jSONObject);
    }
}
