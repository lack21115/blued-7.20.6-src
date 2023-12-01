package com.kwad.sdk.core.a.kwai;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/fu.class */
public final class fu implements com.kwad.sdk.core.d<com.kwad.sdk.core.network.k> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.network.k kVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        kVar.agC = jSONObject.optLong("request_prepare_cost");
        kVar.agD = jSONObject.optLong("request_add_params_cost");
        kVar.agE = jSONObject.optLong("request_create_cost");
        kVar.agF = jSONObject.optInt("keep_alive");
        kVar.agG = jSONObject.optLong("dns_start");
        kVar.agH = jSONObject.optLong("dns_cost");
        kVar.agI = jSONObject.optLong("connect_establish_start");
        kVar.agJ = jSONObject.optLong("connect_establish_cost");
        kVar.agK = jSONObject.optLong("request_start");
        kVar.agL = jSONObject.optLong("request_cost");
        kVar.agM = jSONObject.optLong("request_size");
        kVar.agN = jSONObject.optLong("response_start");
        kVar.agO = jSONObject.optLong("response_cost");
        kVar.agP = jSONObject.optLong("response_parse_cost");
        kVar.agQ = jSONObject.optLong("response_size");
        kVar.agR = jSONObject.optLong("waiting_response_cost");
        kVar.agS = jSONObject.optLong("total_cost");
        kVar.agT = jSONObject.optInt("proxy_used");
        kVar.agU = jSONObject.optString("request_id");
        if (kVar.agU == JSONObject.NULL) {
            kVar.agU = "";
        }
        kVar.agV = jSONObject.optInt("has_data_v2");
        kVar.result = jSONObject.optInt("result");
        kVar.agW = jSONObject.optLong("response_done_cost");
        kVar.agX = jSONObject.optString(MonitorConstants.HOST_IP);
        if (kVar.agX == JSONObject.NULL) {
            kVar.agX = "";
        }
        kVar.agY = jSONObject.optInt("ip_type");
        kVar.agZ = jSONObject.optInt("recommend_ping_time");
        kVar.aha = jSONObject.optInt("backup_ping_time");
        kVar.ahb = jSONObject.optInt("other_ping_time");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.network.k kVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (kVar.agC != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "request_prepare_cost", kVar.agC);
        }
        if (kVar.agD != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "request_add_params_cost", kVar.agD);
        }
        if (kVar.agE != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "request_create_cost", kVar.agE);
        }
        if (kVar.agF != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "keep_alive", kVar.agF);
        }
        if (kVar.agG != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "dns_start", kVar.agG);
        }
        if (kVar.agH != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "dns_cost", kVar.agH);
        }
        if (kVar.agI != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "connect_establish_start", kVar.agI);
        }
        if (kVar.agJ != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "connect_establish_cost", kVar.agJ);
        }
        if (kVar.agK != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "request_start", kVar.agK);
        }
        if (kVar.agL != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "request_cost", kVar.agL);
        }
        if (kVar.agM != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "request_size", kVar.agM);
        }
        if (kVar.agN != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "response_start", kVar.agN);
        }
        if (kVar.agO != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "response_cost", kVar.agO);
        }
        if (kVar.agP != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "response_parse_cost", kVar.agP);
        }
        if (kVar.agQ != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "response_size", kVar.agQ);
        }
        if (kVar.agR != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "waiting_response_cost", kVar.agR);
        }
        if (kVar.agS != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "total_cost", kVar.agS);
        }
        if (kVar.agT != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "proxy_used", kVar.agT);
        }
        if (kVar.agU != null && !kVar.agU.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "request_id", kVar.agU);
        }
        if (kVar.agV != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "has_data_v2", kVar.agV);
        }
        if (kVar.result != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "result", kVar.result);
        }
        if (kVar.agW != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "response_done_cost", kVar.agW);
        }
        if (kVar.agX != null && !kVar.agX.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, MonitorConstants.HOST_IP, kVar.agX);
        }
        if (kVar.agY != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "ip_type", kVar.agY);
        }
        if (kVar.agZ != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "recommend_ping_time", kVar.agZ);
        }
        if (kVar.aha != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "backup_ping_time", kVar.aha);
        }
        if (kVar.ahb != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "other_ping_time", kVar.ahb);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.network.k kVar, JSONObject jSONObject) {
        a2(kVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.network.k kVar, JSONObject jSONObject) {
        return b2(kVar, jSONObject);
    }
}
