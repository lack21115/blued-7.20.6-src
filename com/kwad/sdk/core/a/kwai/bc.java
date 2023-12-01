package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.crash.online.monitor.block.BlockEvent;
import com.tencent.connect.common.Constants;
import com.tencent.tendinsv.a.b;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/bc.class */
public final class bc implements com.kwad.sdk.core.d<BlockEvent> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(BlockEvent blockEvent, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        blockEvent.blockDuration = jSONObject.optLong("blockDuration");
        blockEvent.blockTimeThreshold = jSONObject.optLong("blockTimeThreshold", new Long(Constants.DEFAULT_UIN).longValue());
        blockEvent.blockLoopInterval = jSONObject.optLong("blockLoopInterval", new Long("100").longValue());
        blockEvent.calcBlockOverhead = jSONObject.optLong("calcBlockOverhead");
        blockEvent.currentActivity = jSONObject.optString("currentActivity");
        if (blockEvent.currentActivity == JSONObject.NULL) {
            blockEvent.currentActivity = "";
        }
        blockEvent.processName = jSONObject.optString(b.a.u);
        if (blockEvent.processName == JSONObject.NULL) {
            blockEvent.processName = "";
        }
        blockEvent.stackTraceSample = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("stackTraceSample");
        if (optJSONArray == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= optJSONArray.length()) {
                return;
            }
            BlockEvent.a aVar = new BlockEvent.a();
            aVar.parseJson(optJSONArray.optJSONObject(i2));
            blockEvent.stackTraceSample.add(aVar);
            i = i2 + 1;
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(BlockEvent blockEvent, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (blockEvent.blockDuration != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "blockDuration", blockEvent.blockDuration);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "blockTimeThreshold", blockEvent.blockTimeThreshold);
        com.kwad.sdk.utils.t.putValue(jSONObject2, "blockLoopInterval", blockEvent.blockLoopInterval);
        if (blockEvent.calcBlockOverhead != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "calcBlockOverhead", blockEvent.calcBlockOverhead);
        }
        if (blockEvent.currentActivity != null && !blockEvent.currentActivity.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "currentActivity", blockEvent.currentActivity);
        }
        if (blockEvent.processName != null && !blockEvent.processName.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, b.a.u, blockEvent.processName);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "stackTraceSample", blockEvent.stackTraceSample);
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(BlockEvent blockEvent, JSONObject jSONObject) {
        a2(blockEvent, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(BlockEvent blockEvent, JSONObject jSONObject) {
        return b2(blockEvent, jSONObject);
    }
}
