package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.g.a;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/cr.class */
public final class cr implements com.kwad.sdk.core.d<a.C0404a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(a.C0404a c0404a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0404a.sdkVersion = jSONObject.optString("run_sdk_version");
        if (c0404a.sdkVersion == JSONObject.NULL) {
            c0404a.sdkVersion = "";
        }
        c0404a.aud = jSONObject.optLong("trigger_count", new Long("0").longValue());
        c0404a.aue = jSONObject.optLong("fail_count", new Long("0").longValue());
        c0404a.auf = jSONObject.optLong("real_fail_count", new Long("0").longValue());
        c0404a.aug = jSONObject.optString("business");
        if (c0404a.aug == JSONObject.NULL) {
            c0404a.aug = "";
        }
        c0404a.auh = jSONObject.optString("stage");
        if (c0404a.auh == JSONObject.NULL) {
            c0404a.auh = "";
        }
        c0404a.aui = jSONObject.optString("function");
        if (c0404a.aui == JSONObject.NULL) {
            c0404a.aui = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0404a c0404a, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (c0404a.sdkVersion != null && !c0404a.sdkVersion.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "run_sdk_version", c0404a.sdkVersion);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "trigger_count", c0404a.aud);
        com.kwad.sdk.utils.t.putValue(jSONObject2, "fail_count", c0404a.aue);
        com.kwad.sdk.utils.t.putValue(jSONObject2, "real_fail_count", c0404a.auf);
        if (c0404a.aug != null && !c0404a.aug.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "business", c0404a.aug);
        }
        if (c0404a.auh != null && !c0404a.auh.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "stage", c0404a.auh);
        }
        if (c0404a.aui != null && !c0404a.aui.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "function", c0404a.aui);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0404a c0404a, JSONObject jSONObject) {
        a2(c0404a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0404a c0404a, JSONObject jSONObject) {
        return b2(c0404a, jSONObject);
    }
}
