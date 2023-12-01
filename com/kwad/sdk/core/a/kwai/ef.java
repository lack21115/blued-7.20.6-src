package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.imageloader.ImageLoaderInfo;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/ef.class */
public final class ef implements com.kwad.sdk.core.d<ImageLoaderInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(ImageLoaderInfo imageLoaderInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        imageLoaderInfo.totalCount = jSONObject.optInt("total_count");
        imageLoaderInfo.failedCount = jSONObject.optInt("failed_count");
        imageLoaderInfo.successCount = jSONObject.optInt("success_count");
        imageLoaderInfo.duration = jSONObject.optDouble("duration");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(ImageLoaderInfo imageLoaderInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (imageLoaderInfo.totalCount != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "total_count", imageLoaderInfo.totalCount);
        }
        if (imageLoaderInfo.failedCount != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "failed_count", imageLoaderInfo.failedCount);
        }
        if (imageLoaderInfo.successCount != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "success_count", imageLoaderInfo.successCount);
        }
        if (imageLoaderInfo.duration != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "duration", imageLoaderInfo.duration);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ImageLoaderInfo imageLoaderInfo, JSONObject jSONObject) {
        a2(imageLoaderInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ImageLoaderInfo imageLoaderInfo, JSONObject jSONObject) {
        return b2(imageLoaderInfo, jSONObject);
    }
}
