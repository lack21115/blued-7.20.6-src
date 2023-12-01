package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/it.class */
public final class it implements com.kwad.sdk.core.d<com.kwad.sdk.core.threads.b> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.threads.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.ams = jSONObject.optString("pool_name");
        if (bVar.ams == JSONObject.NULL) {
            bVar.ams = "";
        }
        bVar.amt = jSONObject.optInt("core_pool_size");
        bVar.amu = jSONObject.optInt("max_pool_size");
        bVar.amv = jSONObject.optInt("current_pool_size");
        bVar.amw = jSONObject.optInt("active_count");
        bVar.amx = jSONObject.optLong("task_wait_avg_ms");
        bVar.amy = jSONObject.optLong("task_succ_count");
        bVar.interval = jSONObject.optLong("interval_ms");
        bVar.amz = jSONObject.optInt("queue_size");
        bVar.amA = jSONObject.optLong("pass_timestamp");
        bVar.amB = jSONObject.optInt("func_ratio_count");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.threads.b bVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (bVar.ams != null && !bVar.ams.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "pool_name", bVar.ams);
        }
        if (bVar.amt != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "core_pool_size", bVar.amt);
        }
        if (bVar.amu != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "max_pool_size", bVar.amu);
        }
        if (bVar.amv != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "current_pool_size", bVar.amv);
        }
        if (bVar.amw != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "active_count", bVar.amw);
        }
        if (bVar.amx != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "task_wait_avg_ms", bVar.amx);
        }
        if (bVar.amy != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "task_succ_count", bVar.amy);
        }
        if (bVar.interval != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "interval_ms", bVar.interval);
        }
        if (bVar.amz != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "queue_size", bVar.amz);
        }
        if (bVar.amA != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "pass_timestamp", bVar.amA);
        }
        if (bVar.amB != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "func_ratio_count", bVar.amB);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.threads.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.threads.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
