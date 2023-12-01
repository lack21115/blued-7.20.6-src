package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/l.class */
public final class l implements com.kwad.sdk.core.d<AdInfo.AdConversionInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.AdConversionInfo adConversionInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adConversionInfo.h5Url = jSONObject.optString("h5Url");
        if (adConversionInfo.h5Url == JSONObject.NULL) {
            adConversionInfo.h5Url = "";
        }
        adConversionInfo.h5Type = jSONObject.optInt("h5Type");
        adConversionInfo.deeplinkUrl = jSONObject.optString("deeplinkUrl");
        if (adConversionInfo.deeplinkUrl == JSONObject.NULL) {
            adConversionInfo.deeplinkUrl = "";
        }
        adConversionInfo.deeplinkConf = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("deeplinkConf");
        if (optJSONArray != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    break;
                }
                AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo = new AdInfo.AdConversionInfo.DeeplinkItemInfo();
                deeplinkItemInfo.parseJson(optJSONArray.optJSONObject(i2));
                adConversionInfo.deeplinkConf.add(deeplinkItemInfo);
                i = i2 + 1;
            }
        }
        adConversionInfo.deeplinkExtra = jSONObject.optString("deeplinkExtra");
        if (adConversionInfo.deeplinkExtra == JSONObject.NULL) {
            adConversionInfo.deeplinkExtra = "";
        }
        adConversionInfo.appDownloadUrl = jSONObject.optString("appDownloadUrl");
        if (adConversionInfo.appDownloadUrl == JSONObject.NULL) {
            adConversionInfo.appDownloadUrl = "";
        }
        adConversionInfo.marketUrl = jSONObject.optString("marketUrl");
        if (adConversionInfo.marketUrl == JSONObject.NULL) {
            adConversionInfo.marketUrl = "";
        }
        adConversionInfo.supportThirdDownload = jSONObject.optInt("supportThirdDownload");
        adConversionInfo.retryH5TimeStep = jSONObject.optInt("retryH5TimeStep", new Integer("2000").intValue());
        adConversionInfo.playableUrl = jSONObject.optString("playableUrl");
        if (adConversionInfo.playableUrl == JSONObject.NULL) {
            adConversionInfo.playableUrl = "";
        }
        adConversionInfo.playableStyleInfo = new AdInfo.PlayableStyleInfo();
        adConversionInfo.playableStyleInfo.parseJson(jSONObject.optJSONObject("playableStyleInfo"));
        adConversionInfo.smallAppJumpInfo = new AdInfo.SmallAppJumpInfo();
        adConversionInfo.smallAppJumpInfo.parseJson(jSONObject.optJSONObject("smallAppJumpInfo"));
        adConversionInfo.webUriSourceType = jSONObject.optInt("webUriSourceType");
        adConversionInfo.callbackUrl = jSONObject.optString("callbackUrl");
        if (adConversionInfo.callbackUrl == JSONObject.NULL) {
            adConversionInfo.callbackUrl = "";
        }
        adConversionInfo.callbackUrlInfo = jSONObject.optString("callbackUrlInfo");
        if (adConversionInfo.callbackUrlInfo == JSONObject.NULL) {
            adConversionInfo.callbackUrlInfo = "";
        }
        adConversionInfo.blockCallbackIfSpam = jSONObject.optBoolean("blockCallbackIfSpam");
        adConversionInfo.needDeeplinkReplaceAdapta = jSONObject.optBoolean("needDeeplinkReplaceAdapta");
        adConversionInfo.h5DeeplinkLimitedTimeMs = jSONObject.optInt("h5DeeplinkLimitedTimeMs", new Integer("0").intValue());
        adConversionInfo.playableDeeplinkLimitedTimeMs = jSONObject.optInt("playableDeeplinkLimitedTimeMs", new Integer("0").intValue());
        adConversionInfo.isSupportKeepPlaying = jSONObject.optBoolean("isSupportKeepPlaying");
        adConversionInfo.keepPlayingBackOffTime = jSONObject.optLong("keepPlayingBackOffTime", new Long("3000").longValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.AdConversionInfo adConversionInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (adConversionInfo.h5Url != null && !adConversionInfo.h5Url.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "h5Url", adConversionInfo.h5Url);
        }
        if (adConversionInfo.h5Type != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "h5Type", adConversionInfo.h5Type);
        }
        if (adConversionInfo.deeplinkUrl != null && !adConversionInfo.deeplinkUrl.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "deeplinkUrl", adConversionInfo.deeplinkUrl);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "deeplinkConf", adConversionInfo.deeplinkConf);
        if (adConversionInfo.deeplinkExtra != null && !adConversionInfo.deeplinkExtra.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "deeplinkExtra", adConversionInfo.deeplinkExtra);
        }
        if (adConversionInfo.appDownloadUrl != null && !adConversionInfo.appDownloadUrl.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "appDownloadUrl", adConversionInfo.appDownloadUrl);
        }
        if (adConversionInfo.marketUrl != null && !adConversionInfo.marketUrl.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "marketUrl", adConversionInfo.marketUrl);
        }
        if (adConversionInfo.supportThirdDownload != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "supportThirdDownload", adConversionInfo.supportThirdDownload);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "retryH5TimeStep", adConversionInfo.retryH5TimeStep);
        if (adConversionInfo.playableUrl != null && !adConversionInfo.playableUrl.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "playableUrl", adConversionInfo.playableUrl);
        }
        com.kwad.sdk.utils.t.a(jSONObject2, "playableStyleInfo", adConversionInfo.playableStyleInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "smallAppJumpInfo", adConversionInfo.smallAppJumpInfo);
        if (adConversionInfo.webUriSourceType != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "webUriSourceType", adConversionInfo.webUriSourceType);
        }
        if (adConversionInfo.callbackUrl != null && !adConversionInfo.callbackUrl.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "callbackUrl", adConversionInfo.callbackUrl);
        }
        if (adConversionInfo.callbackUrlInfo != null && !adConversionInfo.callbackUrlInfo.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "callbackUrlInfo", adConversionInfo.callbackUrlInfo);
        }
        if (adConversionInfo.blockCallbackIfSpam) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "blockCallbackIfSpam", adConversionInfo.blockCallbackIfSpam);
        }
        if (adConversionInfo.needDeeplinkReplaceAdapta) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "needDeeplinkReplaceAdapta", adConversionInfo.needDeeplinkReplaceAdapta);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "h5DeeplinkLimitedTimeMs", adConversionInfo.h5DeeplinkLimitedTimeMs);
        com.kwad.sdk.utils.t.putValue(jSONObject2, "playableDeeplinkLimitedTimeMs", adConversionInfo.playableDeeplinkLimitedTimeMs);
        if (adConversionInfo.isSupportKeepPlaying) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "isSupportKeepPlaying", adConversionInfo.isSupportKeepPlaying);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "keepPlayingBackOffTime", adConversionInfo.keepPlayingBackOffTime);
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdConversionInfo adConversionInfo, JSONObject jSONObject) {
        a2(adConversionInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdConversionInfo adConversionInfo, JSONObject jSONObject) {
        return b2(adConversionInfo, jSONObject);
    }
}
