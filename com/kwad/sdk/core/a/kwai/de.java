package com.kwad.sdk.core.a.kwai;

import com.kwad.components.ad.feed.monitor.FeedWebViewInfo;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/de.class */
public final class de implements com.kwad.sdk.core.d<FeedWebViewInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(FeedWebViewInfo feedWebViewInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        feedWebViewInfo.event = jSONObject.optString("event");
        if (feedWebViewInfo.event == JSONObject.NULL) {
            feedWebViewInfo.event = "";
        }
        feedWebViewInfo.url = jSONObject.optString("url");
        if (feedWebViewInfo.url == JSONObject.NULL) {
            feedWebViewInfo.url = "";
        }
        feedWebViewInfo.sceneId = jSONObject.optString("scene_id");
        if (feedWebViewInfo.sceneId == JSONObject.NULL) {
            feedWebViewInfo.sceneId = "";
        }
        feedWebViewInfo.durationMs = jSONObject.optLong("duration_ms");
        feedWebViewInfo.timeType = jSONObject.optInt("time_type");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(FeedWebViewInfo feedWebViewInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (feedWebViewInfo.event != null && !feedWebViewInfo.event.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "event", feedWebViewInfo.event);
        }
        if (feedWebViewInfo.url != null && !feedWebViewInfo.url.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "url", feedWebViewInfo.url);
        }
        if (feedWebViewInfo.sceneId != null && !feedWebViewInfo.sceneId.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "scene_id", feedWebViewInfo.sceneId);
        }
        if (feedWebViewInfo.durationMs != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "duration_ms", feedWebViewInfo.durationMs);
        }
        if (feedWebViewInfo.timeType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "time_type", feedWebViewInfo.timeType);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(FeedWebViewInfo feedWebViewInfo, JSONObject jSONObject) {
        a2(feedWebViewInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(FeedWebViewInfo feedWebViewInfo, JSONObject jSONObject) {
        return b2(feedWebViewInfo, jSONObject);
    }
}
