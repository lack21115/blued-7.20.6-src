package com.kwad.sdk.core.a.kwai;

import com.baidu.mobads.sdk.api.SplashAd;
import com.huawei.hms.push.AttributionReporter;
import com.kwad.sdk.core.response.model.ABParams;
import com.kwad.sdk.core.response.model.AdInfo;
import com.qq.e.comm.constants.Constants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/i.class */
public final class i implements com.kwad.sdk.core.d<AdInfo.AdBaseInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.AdBaseInfo adBaseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adBaseInfo.creativeId = jSONObject.optLong("creativeId");
        adBaseInfo.adSourceType = jSONObject.optInt("adSourceType");
        adBaseInfo.liveStreamId = jSONObject.optString("liveStreamId");
        if (adBaseInfo.liveStreamId == JSONObject.NULL) {
            adBaseInfo.liveStreamId = "";
        }
        adBaseInfo.universeLiveType = jSONObject.optInt("universeLiveType");
        adBaseInfo.viewCount = jSONObject.optLong("viewCount");
        adBaseInfo.sdkExtraData = jSONObject.optString("sdkExtraData");
        if (adBaseInfo.sdkExtraData == JSONObject.NULL) {
            adBaseInfo.sdkExtraData = "";
        }
        adBaseInfo.adDescription = jSONObject.optString("adDescription");
        if (adBaseInfo.adDescription == JSONObject.NULL) {
            adBaseInfo.adDescription = "";
        }
        adBaseInfo.installAppLabel = jSONObject.optString("installAppLabel");
        if (adBaseInfo.installAppLabel == JSONObject.NULL) {
            adBaseInfo.installAppLabel = "";
        }
        adBaseInfo.openAppLabel = jSONObject.optString("openAppLabel");
        if (adBaseInfo.openAppLabel == JSONObject.NULL) {
            adBaseInfo.openAppLabel = "";
        }
        adBaseInfo.adMarkIcon = jSONObject.optString("adMarkIcon");
        if (adBaseInfo.adMarkIcon == JSONObject.NULL) {
            adBaseInfo.adMarkIcon = "";
        }
        adBaseInfo.adGrayMarkIcon = jSONObject.optString("adGrayMarkIcon");
        if (adBaseInfo.adGrayMarkIcon == JSONObject.NULL) {
            adBaseInfo.adGrayMarkIcon = "";
        }
        adBaseInfo.adSourceDescription = jSONObject.optString("adSourceDescription");
        if (adBaseInfo.adSourceDescription == JSONObject.NULL) {
            adBaseInfo.adSourceDescription = "";
        }
        adBaseInfo.adOperationType = jSONObject.optInt("adOperationType");
        adBaseInfo.adActionDescription = jSONObject.optString("adActionDescription");
        if (adBaseInfo.adActionDescription == JSONObject.NULL) {
            adBaseInfo.adActionDescription = "";
        }
        adBaseInfo.adActionBarColor = jSONObject.optString("adActionBarColor");
        if (adBaseInfo.adActionBarColor == JSONObject.NULL) {
            adBaseInfo.adActionBarColor = "";
        }
        adBaseInfo.adShowDuration = jSONObject.optInt("adShowDuration");
        adBaseInfo.appName = jSONObject.optString("appName");
        if (adBaseInfo.appName == JSONObject.NULL) {
            adBaseInfo.appName = "";
        }
        adBaseInfo.appIconUrl = jSONObject.optString("appIconUrl");
        if (adBaseInfo.appIconUrl == JSONObject.NULL) {
            adBaseInfo.appIconUrl = "";
        }
        adBaseInfo.appPackageName = jSONObject.optString("appPackageName");
        if (adBaseInfo.appPackageName == JSONObject.NULL) {
            adBaseInfo.appPackageName = "";
        }
        adBaseInfo.appScore = jSONObject.optInt("appScore");
        adBaseInfo.appDownloadCountDesc = jSONObject.optString("appDownloadCountDesc");
        if (adBaseInfo.appDownloadCountDesc == JSONObject.NULL) {
            adBaseInfo.appDownloadCountDesc = "";
        }
        adBaseInfo.appCategory = jSONObject.optString("appCategory");
        if (adBaseInfo.appCategory == JSONObject.NULL) {
            adBaseInfo.appCategory = "";
        }
        adBaseInfo.appVersion = jSONObject.optString(AttributionReporter.APP_VERSION);
        if (adBaseInfo.appVersion == JSONObject.NULL) {
            adBaseInfo.appVersion = "";
        }
        adBaseInfo.corporationName = jSONObject.optString("corporationName");
        if (adBaseInfo.corporationName == JSONObject.NULL) {
            adBaseInfo.corporationName = "";
        }
        adBaseInfo.packageSize = jSONObject.optLong("packageSize");
        adBaseInfo.appImageUrl = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("appImageUrl");
        if (optJSONArray != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    break;
                }
                adBaseInfo.appImageUrl.add((String) optJSONArray.opt(i2));
                i = i2 + 1;
            }
        }
        adBaseInfo.appImageSize = new AdInfo.MaterialSize();
        adBaseInfo.appImageSize.parseJson(jSONObject.optJSONObject("appImageSize"));
        adBaseInfo.appDescription = jSONObject.optString("appDescription");
        if (adBaseInfo.appDescription == JSONObject.NULL) {
            adBaseInfo.appDescription = "";
        }
        adBaseInfo.enableSkipAd = jSONObject.optInt("enableSkipAd");
        adBaseInfo.adCacheSwitch = jSONObject.optInt("adCacheSwitch", new Integer("0").intValue());
        adBaseInfo.adCacheSecond = jSONObject.optLong("adCacheSecond", new Long("1800").longValue());
        adBaseInfo.adCacheStrategy = jSONObject.optInt("adCacheStrategy", new Integer("1").intValue());
        adBaseInfo.adCacheSize = jSONObject.optInt("adCacheSize", new Integer("1").intValue());
        adBaseInfo.skipSecond = jSONObject.optInt("skipSecond");
        adBaseInfo.ecpm = jSONObject.optInt(SplashAd.KEY_BIDFAIL_ECPM);
        adBaseInfo.videoPlayedNS = jSONObject.optString("videoPlayedNS");
        if (adBaseInfo.videoPlayedNS == JSONObject.NULL) {
            adBaseInfo.videoPlayedNS = "";
        }
        adBaseInfo.productName = jSONObject.optString("productName");
        if (adBaseInfo.productName == JSONObject.NULL) {
            adBaseInfo.productName = "";
        }
        adBaseInfo.mABParams = new ABParams();
        try {
            adBaseInfo.mABParams.parseJson(new JSONObject(jSONObject.optString("expParam")));
        } catch (Exception e) {
        }
        adBaseInfo.showUrl = jSONObject.optString("showUrl");
        if (adBaseInfo.showUrl == JSONObject.NULL) {
            adBaseInfo.showUrl = "";
        }
        adBaseInfo.clickUrl = jSONObject.optString(Constants.KEYS.EXPOSED_CLICK_URL_KEY);
        if (adBaseInfo.clickUrl == JSONObject.NULL) {
            adBaseInfo.clickUrl = "";
        }
        adBaseInfo.convUrl = jSONObject.optString("convUrl");
        if (adBaseInfo.convUrl == JSONObject.NULL) {
            adBaseInfo.convUrl = "";
        }
        adBaseInfo.adAttributeType = jSONObject.optInt("adAttributeType");
        adBaseInfo.apiExpParam = new AdInfo.H5Config();
        adBaseInfo.apiExpParam.parseJson(jSONObject.optJSONObject("apiExpParam"));
        adBaseInfo.taskType = jSONObject.optInt("taskType");
        adBaseInfo.campaignType = jSONObject.optInt("campaignType");
        adBaseInfo.itemType = jSONObject.optInt("itemType");
        adBaseInfo.industryFirstLevelId = jSONObject.optInt("industryFirstLevelId");
        adBaseInfo.extraClickReward = jSONObject.optBoolean("extraClickReward");
        adBaseInfo.enableClientProofreadTime = jSONObject.optBoolean("enableClientProofreadTime");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.AdBaseInfo adBaseInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (adBaseInfo.creativeId != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "creativeId", adBaseInfo.creativeId);
        }
        if (adBaseInfo.adSourceType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "adSourceType", adBaseInfo.adSourceType);
        }
        if (adBaseInfo.liveStreamId != null && !adBaseInfo.liveStreamId.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "liveStreamId", adBaseInfo.liveStreamId);
        }
        if (adBaseInfo.universeLiveType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "universeLiveType", adBaseInfo.universeLiveType);
        }
        if (adBaseInfo.viewCount != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "viewCount", adBaseInfo.viewCount);
        }
        if (adBaseInfo.sdkExtraData != null && !adBaseInfo.sdkExtraData.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "sdkExtraData", adBaseInfo.sdkExtraData);
        }
        if (adBaseInfo.adDescription != null && !adBaseInfo.adDescription.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "adDescription", adBaseInfo.adDescription);
        }
        if (adBaseInfo.installAppLabel != null && !adBaseInfo.installAppLabel.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "installAppLabel", adBaseInfo.installAppLabel);
        }
        if (adBaseInfo.openAppLabel != null && !adBaseInfo.openAppLabel.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "openAppLabel", adBaseInfo.openAppLabel);
        }
        if (adBaseInfo.adMarkIcon != null && !adBaseInfo.adMarkIcon.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "adMarkIcon", adBaseInfo.adMarkIcon);
        }
        if (adBaseInfo.adGrayMarkIcon != null && !adBaseInfo.adGrayMarkIcon.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "adGrayMarkIcon", adBaseInfo.adGrayMarkIcon);
        }
        if (adBaseInfo.adSourceDescription != null && !adBaseInfo.adSourceDescription.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "adSourceDescription", adBaseInfo.adSourceDescription);
        }
        if (adBaseInfo.adOperationType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "adOperationType", adBaseInfo.adOperationType);
        }
        if (adBaseInfo.adActionDescription != null && !adBaseInfo.adActionDescription.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "adActionDescription", adBaseInfo.adActionDescription);
        }
        if (adBaseInfo.adActionBarColor != null && !adBaseInfo.adActionBarColor.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "adActionBarColor", adBaseInfo.adActionBarColor);
        }
        if (adBaseInfo.adShowDuration != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "adShowDuration", adBaseInfo.adShowDuration);
        }
        if (adBaseInfo.appName != null && !adBaseInfo.appName.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "appName", adBaseInfo.appName);
        }
        if (adBaseInfo.appIconUrl != null && !adBaseInfo.appIconUrl.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "appIconUrl", adBaseInfo.appIconUrl);
        }
        if (adBaseInfo.appPackageName != null && !adBaseInfo.appPackageName.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "appPackageName", adBaseInfo.appPackageName);
        }
        if (adBaseInfo.appScore != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "appScore", adBaseInfo.appScore);
        }
        if (adBaseInfo.appDownloadCountDesc != null && !adBaseInfo.appDownloadCountDesc.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "appDownloadCountDesc", adBaseInfo.appDownloadCountDesc);
        }
        if (adBaseInfo.appCategory != null && !adBaseInfo.appCategory.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "appCategory", adBaseInfo.appCategory);
        }
        if (adBaseInfo.appVersion != null && !adBaseInfo.appVersion.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, AttributionReporter.APP_VERSION, adBaseInfo.appVersion);
        }
        if (adBaseInfo.corporationName != null && !adBaseInfo.corporationName.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "corporationName", adBaseInfo.corporationName);
        }
        if (adBaseInfo.packageSize != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "packageSize", adBaseInfo.packageSize);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "appImageUrl", adBaseInfo.appImageUrl);
        com.kwad.sdk.utils.t.a(jSONObject2, "appImageSize", adBaseInfo.appImageSize);
        if (adBaseInfo.appDescription != null && !adBaseInfo.appDescription.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "appDescription", adBaseInfo.appDescription);
        }
        if (adBaseInfo.enableSkipAd != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "enableSkipAd", adBaseInfo.enableSkipAd);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "adCacheSwitch", adBaseInfo.adCacheSwitch);
        com.kwad.sdk.utils.t.putValue(jSONObject2, "adCacheSecond", adBaseInfo.adCacheSecond);
        com.kwad.sdk.utils.t.putValue(jSONObject2, "adCacheStrategy", adBaseInfo.adCacheStrategy);
        com.kwad.sdk.utils.t.putValue(jSONObject2, "adCacheSize", adBaseInfo.adCacheSize);
        if (adBaseInfo.skipSecond != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "skipSecond", adBaseInfo.skipSecond);
        }
        if (adBaseInfo.ecpm != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, SplashAd.KEY_BIDFAIL_ECPM, adBaseInfo.ecpm);
        }
        if (adBaseInfo.videoPlayedNS != null && !adBaseInfo.videoPlayedNS.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "videoPlayedNS", adBaseInfo.videoPlayedNS);
        }
        if (adBaseInfo.productName != null && !adBaseInfo.productName.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "productName", adBaseInfo.productName);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "expParam", adBaseInfo.mABParams.toJson().toString());
        if (adBaseInfo.showUrl != null && !adBaseInfo.showUrl.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "showUrl", adBaseInfo.showUrl);
        }
        if (adBaseInfo.clickUrl != null && !adBaseInfo.clickUrl.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, Constants.KEYS.EXPOSED_CLICK_URL_KEY, adBaseInfo.clickUrl);
        }
        if (adBaseInfo.convUrl != null && !adBaseInfo.convUrl.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "convUrl", adBaseInfo.convUrl);
        }
        if (adBaseInfo.adAttributeType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "adAttributeType", adBaseInfo.adAttributeType);
        }
        com.kwad.sdk.utils.t.a(jSONObject2, "apiExpParam", adBaseInfo.apiExpParam);
        if (adBaseInfo.taskType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "taskType", adBaseInfo.taskType);
        }
        if (adBaseInfo.campaignType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "campaignType", adBaseInfo.campaignType);
        }
        if (adBaseInfo.itemType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "itemType", adBaseInfo.itemType);
        }
        if (adBaseInfo.industryFirstLevelId != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "industryFirstLevelId", adBaseInfo.industryFirstLevelId);
        }
        if (adBaseInfo.extraClickReward) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "extraClickReward", adBaseInfo.extraClickReward);
        }
        if (adBaseInfo.enableClientProofreadTime) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "enableClientProofreadTime", adBaseInfo.enableClientProofreadTime);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdBaseInfo adBaseInfo, JSONObject jSONObject) {
        a2(adBaseInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdBaseInfo adBaseInfo, JSONObject jSONObject) {
        return b2(adBaseInfo, jSONObject);
    }
}
