package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdStatusInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PageInfo;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/ai.class */
public final class ai implements com.kwad.sdk.core.d<AdTemplate> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdTemplate adTemplate, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adTemplate.mOriginJString = jSONObject.optString("mOriginJString");
        if (adTemplate.mOriginJString == JSONObject.NULL) {
            adTemplate.mOriginJString = "";
        }
        adTemplate.posId = jSONObject.optLong("posId");
        adTemplate.adStyle = jSONObject.optInt("adStyle");
        adTemplate.type = jSONObject.optInt("type");
        adTemplate.contentType = jSONObject.optInt("contentType");
        adTemplate.adInfoList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("adInfo");
        if (optJSONArray != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    break;
                }
                AdInfo adInfo = new AdInfo();
                adInfo.parseJson(optJSONArray.optJSONObject(i2));
                adTemplate.adInfoList.add(adInfo);
                i = i2 + 1;
            }
        }
        adTemplate.impAdExtra = jSONObject.optString("impAdExtra");
        if (adTemplate.impAdExtra == JSONObject.NULL) {
            adTemplate.impAdExtra = "";
        }
        adTemplate.llsid = jSONObject.optLong("llsid");
        adTemplate.mIsFromContent = jSONObject.optBoolean("mIsFromContent");
        adTemplate.extra = jSONObject.optString("extra");
        if (adTemplate.extra == JSONObject.NULL) {
            adTemplate.extra = "";
        }
        adTemplate.mUniqueId = jSONObject.optString("mUniqueId");
        if (adTemplate.mUniqueId == JSONObject.NULL) {
            adTemplate.mUniqueId = "";
        }
        adTemplate.mBidEcpm = jSONObject.optLong("mBidEcpm");
        adTemplate.mAdScene = new SceneImpl();
        adTemplate.mAdScene.parseJson(jSONObject.optJSONObject("mAdScene"));
        adTemplate.realShowType = jSONObject.optInt("realShowType");
        adTemplate.mInitVoiceStatus = jSONObject.optInt("mInitVoiceStatus");
        adTemplate.mMediaPlayerType = jSONObject.optInt("mMediaPlayerType");
        adTemplate.mVideoPlayerStatus = new VideoPlayerStatus();
        adTemplate.mVideoPlayerStatus.parseJson(jSONObject.optJSONObject("mVideoPlayerStatus"));
        adTemplate.mOutClickTimeParam = jSONObject.optLong("mOutClickTimeParam", new Long("-1").longValue());
        adTemplate.mVisibleTimeParam = jSONObject.optLong("mVisibleTimeParam", new Long("-1").longValue());
        adTemplate.mIsLeftSlipStatus = jSONObject.optInt("mIsLeftSlipStatus");
        adTemplate.mPhotoResponseType = jSONObject.optInt("mPhotoResponseType");
        adTemplate.mPageInfo = new PageInfo();
        adTemplate.mPageInfo.parseJson(jSONObject.optJSONObject("mPageInfo"));
        adTemplate.mIsForceJumpLandingPage = jSONObject.optBoolean("mIsForceJumpLandingPage", new Boolean("false").booleanValue());
        adTemplate.mIsAudioEnable = jSONObject.optBoolean("mIsAudioEnable");
        adTemplate.mRewardVerifyCalled = jSONObject.optBoolean("mRewardVerifyCalled");
        adTemplate.isWebViewDownload = jSONObject.optBoolean("isWebViewDownload");
        adTemplate.isPlayAgainData = jSONObject.optBoolean("isPlayAgainData");
        adTemplate.inPlayAgain = jSONObject.optBoolean("inPlayAgain");
        adTemplate.watched = jSONObject.optBoolean("watched");
        adTemplate.converted = jSONObject.optBoolean("converted");
        adTemplate.fromCache = jSONObject.optBoolean("fromCache", new Boolean("false").booleanValue());
        adTemplate.loadDataTime = jSONObject.optLong("loadDataTime");
        adTemplate.showStartTime = jSONObject.optLong("showStartTime");
        adTemplate.notNetworkRequest = jSONObject.optBoolean("notNetworkRequest");
        adTemplate.downloadDuration = jSONObject.optLong("downloadDuration");
        adTemplate.adLoadTotalTime = jSONObject.optLong("adLoadTotalTime");
        adTemplate.adShowStartTimeStamp = jSONObject.optLong("adShowStartTimeStamp");
        adTemplate.mAdStatusInfo = new AdStatusInfo();
        adTemplate.mAdStatusInfo.parseJson(jSONObject.optJSONObject("mAdStatusInfo"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdTemplate adTemplate, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (adTemplate.mOriginJString != null && !adTemplate.mOriginJString.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "mOriginJString", adTemplate.mOriginJString);
        }
        if (adTemplate.posId != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "posId", adTemplate.posId);
        }
        if (adTemplate.adStyle != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "adStyle", adTemplate.adStyle);
        }
        if (adTemplate.type != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "type", adTemplate.type);
        }
        if (adTemplate.contentType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "contentType", adTemplate.contentType);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "adInfo", adTemplate.adInfoList);
        if (adTemplate.impAdExtra != null && !adTemplate.impAdExtra.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "impAdExtra", adTemplate.impAdExtra);
        }
        if (adTemplate.llsid != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "llsid", adTemplate.llsid);
        }
        if (adTemplate.mIsFromContent) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "mIsFromContent", adTemplate.mIsFromContent);
        }
        if (adTemplate.extra != null && !adTemplate.extra.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "extra", adTemplate.extra);
        }
        if (adTemplate.mUniqueId != null && !adTemplate.mUniqueId.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "mUniqueId", adTemplate.mUniqueId);
        }
        if (adTemplate.mBidEcpm != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "mBidEcpm", adTemplate.mBidEcpm);
        }
        com.kwad.sdk.utils.t.a(jSONObject2, "mAdScene", adTemplate.mAdScene);
        if (adTemplate.realShowType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "realShowType", adTemplate.realShowType);
        }
        if (adTemplate.mInitVoiceStatus != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "mInitVoiceStatus", adTemplate.mInitVoiceStatus);
        }
        if (adTemplate.mMediaPlayerType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "mMediaPlayerType", adTemplate.mMediaPlayerType);
        }
        com.kwad.sdk.utils.t.a(jSONObject2, "mVideoPlayerStatus", adTemplate.mVideoPlayerStatus);
        com.kwad.sdk.utils.t.putValue(jSONObject2, "mOutClickTimeParam", adTemplate.mOutClickTimeParam);
        com.kwad.sdk.utils.t.putValue(jSONObject2, "mVisibleTimeParam", adTemplate.mVisibleTimeParam);
        if (adTemplate.mIsLeftSlipStatus != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "mIsLeftSlipStatus", adTemplate.mIsLeftSlipStatus);
        }
        if (adTemplate.mPhotoResponseType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "mPhotoResponseType", adTemplate.mPhotoResponseType);
        }
        com.kwad.sdk.utils.t.a(jSONObject2, "mPageInfo", adTemplate.mPageInfo);
        com.kwad.sdk.utils.t.putValue(jSONObject2, "mIsForceJumpLandingPage", adTemplate.mIsForceJumpLandingPage);
        if (adTemplate.mIsAudioEnable) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "mIsAudioEnable", adTemplate.mIsAudioEnable);
        }
        if (adTemplate.mRewardVerifyCalled) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "mRewardVerifyCalled", adTemplate.mRewardVerifyCalled);
        }
        if (adTemplate.isWebViewDownload) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "isWebViewDownload", adTemplate.isWebViewDownload);
        }
        if (adTemplate.isPlayAgainData) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "isPlayAgainData", adTemplate.isPlayAgainData);
        }
        if (adTemplate.inPlayAgain) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "inPlayAgain", adTemplate.inPlayAgain);
        }
        if (adTemplate.watched) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "watched", adTemplate.watched);
        }
        if (adTemplate.converted) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "converted", adTemplate.converted);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "fromCache", adTemplate.fromCache);
        if (adTemplate.loadDataTime != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "loadDataTime", adTemplate.loadDataTime);
        }
        if (adTemplate.showStartTime != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "showStartTime", adTemplate.showStartTime);
        }
        if (adTemplate.notNetworkRequest) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "notNetworkRequest", adTemplate.notNetworkRequest);
        }
        if (adTemplate.downloadDuration != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "downloadDuration", adTemplate.downloadDuration);
        }
        if (adTemplate.adLoadTotalTime != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "adLoadTotalTime", adTemplate.adLoadTotalTime);
        }
        if (adTemplate.adShowStartTimeStamp != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "adShowStartTimeStamp", adTemplate.adShowStartTimeStamp);
        }
        com.kwad.sdk.utils.t.a(jSONObject2, "mAdStatusInfo", adTemplate.mAdStatusInfo);
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdTemplate adTemplate, JSONObject jSONObject) {
        a2(adTemplate, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdTemplate adTemplate, JSONObject jSONObject) {
        return b2(adTemplate, jSONObject);
    }
}
