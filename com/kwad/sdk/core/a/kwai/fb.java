package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.ao;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/fb.class */
public final class fb implements com.kwad.sdk.core.d<ao.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(ao.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.status = jSONObject.optInt("status");
        aVar.totalWatchingDuration = jSONObject.optLong("totalWatchingDuration");
        aVar.watchingUserCount = jSONObject.optInt("watchingUserCount");
        aVar.displayWatchingUserCount = jSONObject.optString("displayWatchingUserCount");
        if (aVar.displayWatchingUserCount == JSONObject.NULL) {
            aVar.displayWatchingUserCount = "";
        }
        aVar.liveDuration = jSONObject.optLong("liveDuration");
        aVar.likeUserCount = jSONObject.optInt("likeUserCount");
        aVar.displayLikeUserCount = jSONObject.optString("displayLikeUserCount");
        if (aVar.displayLikeUserCount == JSONObject.NULL) {
            aVar.displayLikeUserCount = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(ao.a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (aVar.status != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "status", aVar.status);
        }
        if (aVar.totalWatchingDuration != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "totalWatchingDuration", aVar.totalWatchingDuration);
        }
        if (aVar.watchingUserCount != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "watchingUserCount", aVar.watchingUserCount);
        }
        if (aVar.displayWatchingUserCount != null && !aVar.displayWatchingUserCount.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "displayWatchingUserCount", aVar.displayWatchingUserCount);
        }
        if (aVar.liveDuration != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "liveDuration", aVar.liveDuration);
        }
        if (aVar.likeUserCount != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "likeUserCount", aVar.likeUserCount);
        }
        if (aVar.displayLikeUserCount != null && !aVar.displayLikeUserCount.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "displayLikeUserCount", aVar.displayLikeUserCount);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ao.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ao.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
