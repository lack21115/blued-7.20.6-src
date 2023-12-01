package com.kwad.sdk.core.a.kwai;

import com.kwad.components.splash.SplashPreloadManager;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/gs.class */
public final class gs implements com.kwad.sdk.core.d<SplashPreloadManager.PreLoadItem> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(SplashPreloadManager.PreLoadItem preLoadItem, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        preLoadItem.cacheTime = jSONObject.optLong("cacheTime");
        preLoadItem.expiredTime = jSONObject.optLong("expiredTime");
        preLoadItem.preloadId = jSONObject.optString("preloadId");
        if (preLoadItem.preloadId == JSONObject.NULL) {
            preLoadItem.preloadId = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(SplashPreloadManager.PreLoadItem preLoadItem, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (preLoadItem.cacheTime != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "cacheTime", preLoadItem.cacheTime);
        }
        if (preLoadItem.expiredTime != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "expiredTime", preLoadItem.expiredTime);
        }
        if (preLoadItem.preloadId != null && !preLoadItem.preloadId.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "preloadId", preLoadItem.preloadId);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(SplashPreloadManager.PreLoadItem preLoadItem, JSONObject jSONObject) {
        a2(preLoadItem, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(SplashPreloadManager.PreLoadItem preLoadItem, JSONObject jSONObject) {
        return b2(preLoadItem, jSONObject);
    }
}
