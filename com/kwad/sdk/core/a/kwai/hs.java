package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdProductInfo;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/hs.class */
public final class hs implements com.kwad.sdk.core.d<AdProductInfo.SpikeInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdProductInfo.SpikeInfo spikeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        spikeInfo.endTime = jSONObject.optLong("endTime");
        spikeInfo.soldStock = jSONObject.optInt("soldStock");
        spikeInfo.originalStock = jSONObject.optInt("originalStock");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdProductInfo.SpikeInfo spikeInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (spikeInfo.endTime != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "endTime", spikeInfo.endTime);
        }
        if (spikeInfo.soldStock != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "soldStock", spikeInfo.soldStock);
        }
        if (spikeInfo.originalStock != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "originalStock", spikeInfo.originalStock);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdProductInfo.SpikeInfo spikeInfo, JSONObject jSONObject) {
        a2(spikeInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdProductInfo.SpikeInfo spikeInfo, JSONObject jSONObject) {
        return b2(spikeInfo, jSONObject);
    }
}
