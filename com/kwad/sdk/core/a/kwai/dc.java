package com.kwad.sdk.core.a.kwai;

import com.kwad.components.ad.feed.monitor.FeedPageInfo;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/dc.class */
public final class dc implements com.kwad.sdk.core.d<FeedPageInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(FeedPageInfo feedPageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        feedPageInfo.status = jSONObject.optInt("status");
        feedPageInfo.loadStatus = jSONObject.optInt("load_status");
        feedPageInfo.adNum = jSONObject.optInt(com.anythink.expressad.a.g);
        feedPageInfo.type = jSONObject.optInt("type");
        feedPageInfo.loadDataDuration = jSONObject.optLong("load_data_duration_ms");
        feedPageInfo.resourceLoadDuration = jSONObject.optLong("resource_load_duration_ms");
        feedPageInfo.materialType = jSONObject.optInt("material_type");
        feedPageInfo.materialUrl = jSONObject.optString("material_url");
        if (feedPageInfo.materialUrl == JSONObject.NULL) {
            feedPageInfo.materialUrl = "";
        }
        feedPageInfo.renderDuration = jSONObject.optLong("render_duration_ms");
        feedPageInfo.renderType = jSONObject.optInt("render_type");
        feedPageInfo.expectedRenderType = jSONObject.optInt("expected_render_type");
        feedPageInfo.convertDuration = jSONObject.optLong("convert_duartion_ms");
        feedPageInfo.errorCode = jSONObject.optInt("error_code");
        feedPageInfo.errorMsg = jSONObject.optString("error_msg");
        if (feedPageInfo.errorMsg == JSONObject.NULL) {
            feedPageInfo.errorMsg = "";
        }
        feedPageInfo.extMsg = jSONObject.optString("ext_msg");
        if (feedPageInfo.extMsg == JSONObject.NULL) {
            feedPageInfo.extMsg = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(FeedPageInfo feedPageInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (feedPageInfo.status != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "status", feedPageInfo.status);
        }
        if (feedPageInfo.loadStatus != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "load_status", feedPageInfo.loadStatus);
        }
        if (feedPageInfo.adNum != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, com.anythink.expressad.a.g, feedPageInfo.adNum);
        }
        if (feedPageInfo.type != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "type", feedPageInfo.type);
        }
        if (feedPageInfo.loadDataDuration != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "load_data_duration_ms", feedPageInfo.loadDataDuration);
        }
        if (feedPageInfo.resourceLoadDuration != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "resource_load_duration_ms", feedPageInfo.resourceLoadDuration);
        }
        if (feedPageInfo.materialType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "material_type", feedPageInfo.materialType);
        }
        if (feedPageInfo.materialUrl != null && !feedPageInfo.materialUrl.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "material_url", feedPageInfo.materialUrl);
        }
        if (feedPageInfo.renderDuration != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "render_duration_ms", feedPageInfo.renderDuration);
        }
        if (feedPageInfo.renderType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "render_type", feedPageInfo.renderType);
        }
        if (feedPageInfo.expectedRenderType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "expected_render_type", feedPageInfo.expectedRenderType);
        }
        if (feedPageInfo.convertDuration != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "convert_duartion_ms", feedPageInfo.convertDuration);
        }
        if (feedPageInfo.errorCode != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "error_code", feedPageInfo.errorCode);
        }
        if (feedPageInfo.errorMsg != null && !feedPageInfo.errorMsg.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "error_msg", feedPageInfo.errorMsg);
        }
        if (feedPageInfo.extMsg != null && !feedPageInfo.extMsg.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "ext_msg", feedPageInfo.extMsg);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(FeedPageInfo feedPageInfo, JSONObject jSONObject) {
        a2(feedPageInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(FeedPageInfo feedPageInfo, JSONObject jSONObject) {
        return b2(feedPageInfo, jSONObject);
    }
}
