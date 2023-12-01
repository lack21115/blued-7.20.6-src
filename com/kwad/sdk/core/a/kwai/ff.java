package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import com.tencent.connect.share.QzonePublish;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/ff.class */
public final class ff implements com.kwad.sdk.core.d<AdInfo.AdMaterialInfo.MaterialFeature> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.AdMaterialInfo.MaterialFeature materialFeature, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        materialFeature.featureType = jSONObject.optInt("featureType");
        materialFeature.materialUrl = jSONObject.optString("materialUrl");
        if (materialFeature.materialUrl == JSONObject.NULL) {
            materialFeature.materialUrl = "";
        }
        materialFeature.photoId = jSONObject.optLong("photoId");
        materialFeature.coverUrl = jSONObject.optString("coverUrl");
        if (materialFeature.coverUrl == JSONObject.NULL) {
            materialFeature.coverUrl = "";
        }
        materialFeature.videoDuration = jSONObject.optInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION);
        materialFeature.firstFrame = jSONObject.optString("firstFrame");
        if (materialFeature.firstFrame == JSONObject.NULL) {
            materialFeature.firstFrame = "";
        }
        materialFeature.blurBackgroundUrl = jSONObject.optString("blurBackgroundUrl");
        if (materialFeature.blurBackgroundUrl == JSONObject.NULL) {
            materialFeature.blurBackgroundUrl = "";
        }
        materialFeature.webpCoverUrl = jSONObject.optString("webpCoverUrl");
        if (materialFeature.webpCoverUrl == JSONObject.NULL) {
            materialFeature.webpCoverUrl = "";
        }
        materialFeature.videoWidth = jSONObject.optInt("videoWidth");
        materialFeature.videoHeight = jSONObject.optInt("videoHeight");
        materialFeature.likeCount = jSONObject.optLong("likeCount");
        materialFeature.commentCount = jSONObject.optLong("commentCount");
        materialFeature.source = jSONObject.optInt("source");
        materialFeature.ruleId = jSONObject.optString("ruleId");
        if (materialFeature.ruleId == JSONObject.NULL) {
            materialFeature.ruleId = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.AdMaterialInfo.MaterialFeature materialFeature, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (materialFeature.featureType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "featureType", materialFeature.featureType);
        }
        if (materialFeature.materialUrl != null && !materialFeature.materialUrl.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "materialUrl", materialFeature.materialUrl);
        }
        if (materialFeature.photoId != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "photoId", materialFeature.photoId);
        }
        if (materialFeature.coverUrl != null && !materialFeature.coverUrl.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "coverUrl", materialFeature.coverUrl);
        }
        if (materialFeature.videoDuration != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, materialFeature.videoDuration);
        }
        if (materialFeature.firstFrame != null && !materialFeature.firstFrame.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "firstFrame", materialFeature.firstFrame);
        }
        if (materialFeature.blurBackgroundUrl != null && !materialFeature.blurBackgroundUrl.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "blurBackgroundUrl", materialFeature.blurBackgroundUrl);
        }
        if (materialFeature.webpCoverUrl != null && !materialFeature.webpCoverUrl.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "webpCoverUrl", materialFeature.webpCoverUrl);
        }
        if (materialFeature.videoWidth != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "videoWidth", materialFeature.videoWidth);
        }
        if (materialFeature.videoHeight != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "videoHeight", materialFeature.videoHeight);
        }
        if (materialFeature.likeCount != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "likeCount", materialFeature.likeCount);
        }
        if (materialFeature.commentCount != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "commentCount", materialFeature.commentCount);
        }
        if (materialFeature.source != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "source", materialFeature.source);
        }
        if (materialFeature.ruleId != null && !materialFeature.ruleId.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "ruleId", materialFeature.ruleId);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdMaterialInfo.MaterialFeature materialFeature, JSONObject jSONObject) {
        a2(materialFeature, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdMaterialInfo.MaterialFeature materialFeature, JSONObject jSONObject) {
        return b2(materialFeature, jSONObject);
    }
}
