package com.kwad.sdk.core.a.kwai;

import com.cdo.oaps.ad.OapsKey;
import com.kwad.components.splash.monitor.SplashMonitorInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/ia.class */
public final class ia implements com.kwad.sdk.core.d<SplashMonitorInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(SplashMonitorInfo splashMonitorInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashMonitorInfo.status = jSONObject.optInt("status");
        splashMonitorInfo.type = jSONObject.optInt("type");
        splashMonitorInfo.preloadId = jSONObject.optString("preload_id");
        if (splashMonitorInfo.preloadId == JSONObject.NULL) {
            splashMonitorInfo.preloadId = "";
        }
        splashMonitorInfo.errorCode = jSONObject.optInt("error_code");
        splashMonitorInfo.errorMsg = jSONObject.optString("error_msg");
        if (splashMonitorInfo.errorMsg == JSONObject.NULL) {
            splashMonitorInfo.errorMsg = "";
        }
        splashMonitorInfo.checkStatus = jSONObject.optInt("check_status");
        splashMonitorInfo.loadDataTime = jSONObject.optLong("load_data_duration_ms");
        splashMonitorInfo.checkDataTime = jSONObject.optLong("check_data_duration_ms");
        splashMonitorInfo.loadAndCheckDataTime = jSONObject.optLong("load_and_check_data_duration_ms");
        splashMonitorInfo.costTime = jSONObject.optLong("duration_ms");
        splashMonitorInfo.ids = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray(OapsKey.KEY_IDS);
        if (optJSONArray != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    break;
                }
                splashMonitorInfo.ids.add((String) optJSONArray.opt(i2));
                i = i2 + 1;
            }
        }
        splashMonitorInfo.count = jSONObject.optInt("count");
        splashMonitorInfo.cacheValidTime = jSONObject.optLong("validity_period_ms");
        splashMonitorInfo.size = jSONObject.optLong(OapsKey.KEY_SIZE);
        splashMonitorInfo.failUrl = jSONObject.optString("fail_url");
        if (splashMonitorInfo.failUrl == JSONObject.NULL) {
            splashMonitorInfo.failUrl = "";
        }
        splashMonitorInfo.creativeId = jSONObject.optLong(com.anythink.expressad.foundation.d.c.l);
        splashMonitorInfo.materialType = jSONObject.optInt("material_type");
        splashMonitorInfo.totalCount = jSONObject.optInt("total_count");
        splashMonitorInfo.creativeIds = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("creative_ids");
        if (optJSONArray2 != null) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= optJSONArray2.length()) {
                    break;
                }
                splashMonitorInfo.creativeIds.add((String) optJSONArray2.opt(i4));
                i3 = i4 + 1;
            }
        }
        splashMonitorInfo.preloadIds = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("preload_ids");
        if (optJSONArray3 != null) {
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= optJSONArray3.length()) {
                    break;
                }
                splashMonitorInfo.preloadIds.add((String) optJSONArray3.opt(i6));
                i5 = i6 + 1;
            }
        }
        splashMonitorInfo.posId = jSONObject.optLong("pos_Id");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(SplashMonitorInfo splashMonitorInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (splashMonitorInfo.status != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "status", splashMonitorInfo.status);
        }
        if (splashMonitorInfo.type != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "type", splashMonitorInfo.type);
        }
        if (splashMonitorInfo.preloadId != null && !splashMonitorInfo.preloadId.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "preload_id", splashMonitorInfo.preloadId);
        }
        if (splashMonitorInfo.errorCode != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "error_code", splashMonitorInfo.errorCode);
        }
        if (splashMonitorInfo.errorMsg != null && !splashMonitorInfo.errorMsg.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "error_msg", splashMonitorInfo.errorMsg);
        }
        if (splashMonitorInfo.checkStatus != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "check_status", splashMonitorInfo.checkStatus);
        }
        if (splashMonitorInfo.loadDataTime != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "load_data_duration_ms", splashMonitorInfo.loadDataTime);
        }
        if (splashMonitorInfo.checkDataTime != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "check_data_duration_ms", splashMonitorInfo.checkDataTime);
        }
        if (splashMonitorInfo.loadAndCheckDataTime != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "load_and_check_data_duration_ms", splashMonitorInfo.loadAndCheckDataTime);
        }
        if (splashMonitorInfo.costTime != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "duration_ms", splashMonitorInfo.costTime);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, OapsKey.KEY_IDS, splashMonitorInfo.ids);
        if (splashMonitorInfo.count != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "count", splashMonitorInfo.count);
        }
        if (splashMonitorInfo.cacheValidTime != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "validity_period_ms", splashMonitorInfo.cacheValidTime);
        }
        if (splashMonitorInfo.size != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, OapsKey.KEY_SIZE, splashMonitorInfo.size);
        }
        if (splashMonitorInfo.failUrl != null && !splashMonitorInfo.failUrl.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "fail_url", splashMonitorInfo.failUrl);
        }
        if (splashMonitorInfo.creativeId != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, com.anythink.expressad.foundation.d.c.l, splashMonitorInfo.creativeId);
        }
        if (splashMonitorInfo.materialType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "material_type", splashMonitorInfo.materialType);
        }
        if (splashMonitorInfo.totalCount != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "total_count", splashMonitorInfo.totalCount);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "creative_ids", splashMonitorInfo.creativeIds);
        com.kwad.sdk.utils.t.putValue(jSONObject2, "preload_ids", splashMonitorInfo.preloadIds);
        if (splashMonitorInfo.posId != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "pos_Id", splashMonitorInfo.posId);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(SplashMonitorInfo splashMonitorInfo, JSONObject jSONObject) {
        a2(splashMonitorInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(SplashMonitorInfo splashMonitorInfo, JSONObject jSONObject) {
        return b2(splashMonitorInfo, jSONObject);
    }
}
