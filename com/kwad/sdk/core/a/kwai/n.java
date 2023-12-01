package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/n.class */
public final class n implements com.kwad.sdk.core.d<AdMatrixInfo.AdDataV2> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.AdDataV2 adDataV2, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adDataV2.templateDataList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("templateDatas");
        if (optJSONArray != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    break;
                }
                AdMatrixInfo.TemplateData templateData = new AdMatrixInfo.TemplateData();
                templateData.parseJson(optJSONArray.optJSONObject(i2));
                adDataV2.templateDataList.add(templateData);
                i = i2 + 1;
            }
        }
        adDataV2.bottomBannerInfo = new AdMatrixInfo.BottomBannerInfo();
        adDataV2.bottomBannerInfo.parseJson(jSONObject.optJSONObject("bottomBannerInfo"));
        adDataV2.actionBarInfo = new AdMatrixInfo.ActionBarInfoNew();
        adDataV2.actionBarInfo.parseJson(jSONObject.optJSONObject("actionBarInfo"));
        adDataV2.aggregationCardInfo = new AdMatrixInfo.AggregationCardInfo();
        adDataV2.aggregationCardInfo.parseJson(jSONObject.optJSONObject("aggregationCardInfo"));
        adDataV2.halfCardInfo = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.halfCardInfo.parseJson(jSONObject.optJSONObject("halfCardInfo"));
        adDataV2.endCardInfo = new AdMatrixInfo.EndCardInfo();
        adDataV2.endCardInfo.parseJson(jSONObject.optJSONObject("endCardInfo"));
        adDataV2.interstitialCardInfo = new AdMatrixInfo.InterstitialCardInfo();
        adDataV2.interstitialCardInfo.parseJson(jSONObject.optJSONObject("interstitialCardInfo"));
        adDataV2.feedInfo = new AdMatrixInfo.FeedInfo();
        adDataV2.feedInfo.parseJson(jSONObject.optJSONObject("feedInfo"));
        adDataV2.adUnionFeedLiveMediaInfo = new AdMatrixInfo.FeedInfo();
        adDataV2.adUnionFeedLiveMediaInfo.parseJson(jSONObject.optJSONObject("adUnionFeedLiveMediaInfo"));
        adDataV2.adUnionFeedLiveTemplateInfo = new AdMatrixInfo.FeedInfo();
        adDataV2.adUnionFeedLiveTemplateInfo.parseJson(jSONObject.optJSONObject("adUnionFeedLiveTemplateInfo"));
        adDataV2.complianceCardInfo = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.complianceCardInfo.parseJson(jSONObject.optJSONObject("complianceCardInfo"));
        adDataV2.downloadConfirmCardInfo = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.downloadConfirmCardInfo.parseJson(jSONObject.optJSONObject("downloadConfirmCardInfo"));
        adDataV2.splashInfo = new AdMatrixInfo.SplashInfo();
        adDataV2.splashInfo.parseJson(jSONObject.optJSONObject("splashInfo"));
        adDataV2.neoVideoInfo = new AdMatrixInfo.NeoVideoInfo();
        adDataV2.neoVideoInfo.parseJson(jSONObject.optJSONObject("neoVideoInfo"));
        adDataV2.fullScreenInfo = new AdMatrixInfo.FullScreenInfo();
        adDataV2.fullScreenInfo.parseJson(jSONObject.optJSONObject("fullScreenInfo"));
        adDataV2.middleTKCardInfo = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.middleTKCardInfo.parseJson(jSONObject.optJSONObject("middleTKCardInfo"));
        adDataV2.actionBarTKInfo = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.actionBarTKInfo.parseJson(jSONObject.optJSONObject("actionBarTKInfo"));
        adDataV2.topBarTKInfo = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.topBarTKInfo.parseJson(jSONObject.optJSONObject("topBarTKInfo"));
        adDataV2.splashPlayCardTKInfo = new AdMatrixInfo.SplashPlayCardTKInfo();
        adDataV2.splashPlayCardTKInfo.parseJson(jSONObject.optJSONObject("splashPlayCardTKInfo"));
        adDataV2.splashEndCardTKInfo = new AdMatrixInfo.SplashEndCardTKInfo();
        adDataV2.splashEndCardTKInfo.parseJson(jSONObject.optJSONObject("splashEndCardTKInfo"));
        adDataV2.topFloorTKInfo = new AdMatrixInfo.TopFloorTKInfo();
        adDataV2.topFloorTKInfo.parseJson(jSONObject.optJSONObject("topFloorTKInfo"));
        adDataV2.activityMiddlePageInfo = new AdMatrixInfo.ActivityMiddlePageInfo();
        adDataV2.activityMiddlePageInfo.parseJson(jSONObject.optJSONObject("activityMiddlePageInfo"));
        adDataV2.confirmTKInfo = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.confirmTKInfo.parseJson(jSONObject.optJSONObject("confirmTKInfo"));
        adDataV2.playendTKInfo = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.playendTKInfo.parseJson(jSONObject.optJSONObject("playendTKInfo"));
        adDataV2.activityTKInfo = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.activityTKInfo.parseJson(jSONObject.optJSONObject("activityTKInfo"));
        adDataV2.neoTKInfo = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.neoTKInfo.parseJson(jSONObject.optJSONObject("neoTKInfo"));
        adDataV2.rewardWatchOnceInfo = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.rewardWatchOnceInfo.parseJson(jSONObject.optJSONObject("rewardWatchOnceInfo"));
        adDataV2.rewardVideoInteractInfo = new AdMatrixInfo.RewardVideoInteractInfo();
        adDataV2.rewardVideoInteractInfo.parseJson(jSONObject.optJSONObject("rewardVideoInteractInfo"));
        adDataV2.rewardVideoTaskInfo = new AdMatrixInfo.RewardVideoTaskInfo();
        adDataV2.rewardVideoTaskInfo.parseJson(jSONObject.optJSONObject("rewardVideoTaskInfo"));
        adDataV2.mRewardWebTaskCloseInfo = new AdMatrixInfo.RewardWebTaskCloseInfo();
        adDataV2.mRewardWebTaskCloseInfo.parseJson(jSONObject.optJSONObject("mRewardWebTaskCloseInfo"));
        adDataV2.merchantLiveReservationInfo = new AdMatrixInfo.MerchantLiveReservationInfo();
        adDataV2.merchantLiveReservationInfo.parseJson(jSONObject.optJSONObject("merchantLiveReservationInfo"));
        adDataV2.pushTKInfo = new AdMatrixInfo.PushTKInfo();
        adDataV2.pushTKInfo.parseJson(jSONObject.optJSONObject("pushTKInfo"));
        adDataV2.splashActionBarInfo = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.splashActionBarInfo.parseJson(jSONObject.optJSONObject("splashActionBarInfo"));
        adDataV2.videoLiveTKInfo = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.videoLiveTKInfo.parseJson(jSONObject.optJSONObject("videoLiveTKInfo"));
        adDataV2.preLandingPageTKInfo = new AdMatrixInfo.PreLandingPageTKInfo();
        adDataV2.preLandingPageTKInfo.parseJson(jSONObject.optJSONObject("preLandingPageTKInfo"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.AdDataV2 adDataV2, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "templateDatas", adDataV2.templateDataList);
        com.kwad.sdk.utils.t.a(jSONObject2, "bottomBannerInfo", adDataV2.bottomBannerInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "actionBarInfo", adDataV2.actionBarInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "aggregationCardInfo", adDataV2.aggregationCardInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "halfCardInfo", adDataV2.halfCardInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "endCardInfo", adDataV2.endCardInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "interstitialCardInfo", adDataV2.interstitialCardInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "feedInfo", adDataV2.feedInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "adUnionFeedLiveMediaInfo", adDataV2.adUnionFeedLiveMediaInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "adUnionFeedLiveTemplateInfo", adDataV2.adUnionFeedLiveTemplateInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "complianceCardInfo", adDataV2.complianceCardInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "downloadConfirmCardInfo", adDataV2.downloadConfirmCardInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "splashInfo", adDataV2.splashInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "neoVideoInfo", adDataV2.neoVideoInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "fullScreenInfo", adDataV2.fullScreenInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "middleTKCardInfo", adDataV2.middleTKCardInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "actionBarTKInfo", adDataV2.actionBarTKInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "topBarTKInfo", adDataV2.topBarTKInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "splashPlayCardTKInfo", adDataV2.splashPlayCardTKInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "splashEndCardTKInfo", adDataV2.splashEndCardTKInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "topFloorTKInfo", adDataV2.topFloorTKInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "activityMiddlePageInfo", adDataV2.activityMiddlePageInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "confirmTKInfo", adDataV2.confirmTKInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "playendTKInfo", adDataV2.playendTKInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "activityTKInfo", adDataV2.activityTKInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "neoTKInfo", adDataV2.neoTKInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "rewardWatchOnceInfo", adDataV2.rewardWatchOnceInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "rewardVideoInteractInfo", adDataV2.rewardVideoInteractInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "rewardVideoTaskInfo", adDataV2.rewardVideoTaskInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "mRewardWebTaskCloseInfo", adDataV2.mRewardWebTaskCloseInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "merchantLiveReservationInfo", adDataV2.merchantLiveReservationInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "pushTKInfo", adDataV2.pushTKInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "splashActionBarInfo", adDataV2.splashActionBarInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "videoLiveTKInfo", adDataV2.videoLiveTKInfo);
        com.kwad.sdk.utils.t.a(jSONObject2, "preLandingPageTKInfo", adDataV2.preLandingPageTKInfo);
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.AdDataV2 adDataV2, JSONObject jSONObject) {
        a2(adDataV2, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.AdDataV2 adDataV2, JSONObject jSONObject) {
        return b2(adDataV2, jSONObject);
    }
}
