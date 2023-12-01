package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.crash.online.monitor.block.BlockEvent;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/iw.class */
public final class iw implements com.kwad.sdk.core.d<BlockEvent.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(BlockEvent.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.arN = jSONObject.optLong("endTimestamp");
        aVar.repeatCount = jSONObject.optInt("repeatCount", new Integer("1").intValue());
        aVar.arO = jSONObject.optBoolean("runIdle");
        aVar.arP = jSONObject.optString("stackTraceDetail");
        if (aVar.arP == JSONObject.NULL) {
            aVar.arP = "";
        }
        aVar.arQ = jSONObject.optLong("startTimestamp");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(BlockEvent.a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (aVar.arN != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "endTimestamp", aVar.arN);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "repeatCount", aVar.repeatCount);
        if (aVar.arO) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "runIdle", aVar.arO);
        }
        if (aVar.arP != null && !aVar.arP.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "stackTraceDetail", aVar.arP);
        }
        if (aVar.arQ != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "startTimestamp", aVar.arQ);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(BlockEvent.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(BlockEvent.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
