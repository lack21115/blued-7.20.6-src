package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.PhotoInfo;
import com.sina.weibo.sdk.constant.WBConstants;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/az.class */
public final class az implements com.kwad.sdk.core.d<PhotoInfo.BaseInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(PhotoInfo.BaseInfo baseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        baseInfo.photoId = jSONObject.optLong("photoId");
        baseInfo.sdkExtraData = jSONObject.optString("sdkExtraData");
        if (baseInfo.sdkExtraData == JSONObject.NULL) {
            baseInfo.sdkExtraData = "";
        }
        baseInfo.title = jSONObject.optString("title");
        if (baseInfo.title == JSONObject.NULL) {
            baseInfo.title = "";
        }
        baseInfo.shareUrl = jSONObject.optString(WBConstants.SDK_WEOYOU_SHAREURL);
        if (baseInfo.shareUrl == JSONObject.NULL) {
            baseInfo.shareUrl = "";
        }
        baseInfo.waterMarkPosition = jSONObject.optInt("waterMarkPosition", new Integer("1").intValue());
        baseInfo.recoExt = jSONObject.optString("recoExt");
        if (baseInfo.recoExt == JSONObject.NULL) {
            baseInfo.recoExt = "";
        }
        baseInfo.likeCount = jSONObject.optLong("likeCount");
        baseInfo.commentCount = jSONObject.optLong("commentCount");
        baseInfo.viewCount = jSONObject.optLong("viewCount");
        baseInfo.createTime = jSONObject.optLong("createTime");
        baseInfo.videoDesc = jSONObject.optString("videoDesc");
        if (baseInfo.videoDesc == JSONObject.NULL) {
            baseInfo.videoDesc = "";
        }
        baseInfo.playTimes = jSONObject.optLong("playTimes");
        baseInfo.videoUrlCacheTime = jSONObject.optLong("videoUrlCacheTime");
        baseInfo.contentSourceType = jSONObject.optInt("contentSourceType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(PhotoInfo.BaseInfo baseInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (baseInfo.photoId != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "photoId", baseInfo.photoId);
        }
        if (baseInfo.sdkExtraData != null && !baseInfo.sdkExtraData.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "sdkExtraData", baseInfo.sdkExtraData);
        }
        if (baseInfo.title != null && !baseInfo.title.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "title", baseInfo.title);
        }
        if (baseInfo.shareUrl != null && !baseInfo.shareUrl.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, WBConstants.SDK_WEOYOU_SHAREURL, baseInfo.shareUrl);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "waterMarkPosition", baseInfo.waterMarkPosition);
        if (baseInfo.recoExt != null && !baseInfo.recoExt.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "recoExt", baseInfo.recoExt);
        }
        if (baseInfo.likeCount != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "likeCount", baseInfo.likeCount);
        }
        if (baseInfo.commentCount != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "commentCount", baseInfo.commentCount);
        }
        if (baseInfo.viewCount != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "viewCount", baseInfo.viewCount);
        }
        if (baseInfo.createTime != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "createTime", baseInfo.createTime);
        }
        if (baseInfo.videoDesc != null && !baseInfo.videoDesc.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "videoDesc", baseInfo.videoDesc);
        }
        if (baseInfo.playTimes != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "playTimes", baseInfo.playTimes);
        }
        if (baseInfo.videoUrlCacheTime != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "videoUrlCacheTime", baseInfo.videoUrlCacheTime);
        }
        if (baseInfo.contentSourceType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "contentSourceType", baseInfo.contentSourceType);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(PhotoInfo.BaseInfo baseInfo, JSONObject jSONObject) {
        a2(baseInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(PhotoInfo.BaseInfo baseInfo, JSONObject jSONObject) {
        return b2(baseInfo, jSONObject);
    }
}
