package com.kwad.sdk.core.response.a;

import android.text.TextUtils;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.FeedSlideConf;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.bb;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/a/b.class */
public final class b {
    private static Random alN = new Random();

    public static AdMatrixInfo aJ(AdTemplate adTemplate) {
        return d.bT(adTemplate) ? d.cb(adTemplate).adMatrixInfo : new AdMatrixInfo();
    }

    public static FeedSlideConf aK(AdTemplate adTemplate) {
        JSONArray optJSONArray;
        AdMatrixInfo.TemplateData d = d(adTemplate, bh(adTemplate).templateId);
        try {
            JSONObject optJSONObject = new JSONObject(d != null ? d.data : "").optJSONObject("slideInfo");
            if (optJSONObject == null || (optJSONArray = optJSONObject.optJSONArray("angle")) == null || optJSONArray.length() <= 1) {
                return null;
            }
            FeedSlideConf feedSlideConf = new FeedSlideConf();
            feedSlideConf.minRange = ((Integer) optJSONArray.get(0)).intValue();
            feedSlideConf.maxRange = ((Integer) optJSONArray.get(1)).intValue();
            return feedSlideConf;
        } catch (Throwable th) {
            return null;
        }
    }

    public static boolean aL(AdTemplate adTemplate) {
        return f(adTemplate, aM(adTemplate).templateId);
    }

    private static AdMatrixInfo.InterstitialCardInfo aM(AdTemplate adTemplate) {
        return aJ(adTemplate).adDataV2.interstitialCardInfo;
    }

    public static String aN(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate b = b(adTemplate, aJ(adTemplate).adDataV2.splashActionBarInfo.templateId);
        return b != null ? b.templateUrl : "";
    }

    private static AdMatrixInfo.ActionBarInfoNew aO(AdTemplate adTemplate) {
        return aJ(adTemplate).adDataV2.actionBarInfo;
    }

    public static String aP(AdTemplate adTemplate) {
        AdInfo cb = d.cb(adTemplate);
        int bV = d.bV(adTemplate);
        boolean z = bV == 3 || bV == 2;
        if (a.cq(cb)) {
            return "";
        }
        if (z && a.ck(cb)) {
            return cE(cb);
        }
        if (z && a.aI(adTemplate)) {
            AdMatrixInfo.MatrixTemplate b = b(adTemplate, bI(adTemplate).templateId);
            return b != null ? b.templateUrl : "";
        }
        AdMatrixInfo.MatrixTemplate b2 = b(adTemplate, aO(adTemplate).templateId);
        return b2 != null ? b2.templateUrl : "";
    }

    public static long aQ(AdTemplate adTemplate) {
        return aO(adTemplate).maxTimeOut;
    }

    public static boolean aR(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(aP(adTemplate));
    }

    private static AdMatrixInfo.AggregationCardInfo aS(AdTemplate adTemplate) {
        return aJ(adTemplate).adDataV2.aggregationCardInfo;
    }

    public static String aT(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate b = b(adTemplate, aS(adTemplate).templateId);
        return b != null ? b.templateUrl : "";
    }

    public static long aU(AdTemplate adTemplate) {
        return e(adTemplate, aS(adTemplate).templateId);
    }

    public static long aV(AdTemplate adTemplate) {
        return aS(adTemplate).changeTime * 1000;
    }

    public static int aW(AdTemplate adTemplate) {
        return aS(adTemplate).maxTimesPerDay;
    }

    public static long aX(AdTemplate adTemplate) {
        return aS(adTemplate).intervalTime;
    }

    public static boolean aY(AdTemplate adTemplate) {
        AdInfo cb = d.cb(adTemplate);
        return !a.ax(cb) && a.ak(cb);
    }

    public static boolean aZ(AdTemplate adTemplate) {
        if (!TextUtils.isEmpty(aT(adTemplate)) && aU(adTemplate) > 0) {
            return ai.DM();
        }
        return false;
    }

    private static boolean am(AdInfo adInfo) {
        return adInfo.adBaseInfo.taskType == 4;
    }

    private static AdMatrixInfo.MatrixTemplate b(AdTemplate adTemplate, String str) {
        for (AdMatrixInfo.MatrixTemplate matrixTemplate : aJ(adTemplate).styles.templateList) {
            if (bb.isEquals(str, matrixTemplate.templateId)) {
                return matrixTemplate;
            }
        }
        KSLoggerReporter.ReportClient.RESPONE_MONITOR.buildNormalApmReporter().cC("response_biz_error_tk").aF(adTemplate).a(BusinessType.TACHIKOMA).J("TkTemplateDataLost", str).report();
        return null;
    }

    public static String bA(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate b = b(adTemplate, bz(adTemplate).templateId);
        return b != null ? b.templateUrl : "";
    }

    public static boolean bB(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(bA(adTemplate));
    }

    private static AdMatrixInfo.BaseMatrixTemplate bC(AdTemplate adTemplate) {
        return aJ(adTemplate).adDataV2.downloadConfirmCardInfo;
    }

    public static String bD(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate b = b(adTemplate, bC(adTemplate).templateId);
        return b != null ? b.templateUrl : "";
    }

    public static boolean bE(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(bD(adTemplate));
    }

    public static boolean bF(AdTemplate adTemplate) {
        if (adTemplate.adInfoList == null || adTemplate.adInfoList.size() == 0) {
            return false;
        }
        AdInfo adInfo = adTemplate.adInfoList.get(0);
        return (a.cv(adInfo) || a.bv(adInfo) || adInfo.adBaseInfo.taskType != 4) ? false : true;
    }

    private static AdMatrixInfo.BaseMatrixTemplate bG(AdTemplate adTemplate) {
        return aJ(adTemplate).adDataV2.rewardWatchOnceInfo;
    }

    public static String bH(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate b = b(adTemplate, bG(adTemplate).templateId);
        if (b != null) {
            return b.templateUrl;
        }
        return null;
    }

    public static AdMatrixInfo.MerchantLiveReservationInfo bI(AdTemplate adTemplate) {
        return aJ(adTemplate).adDataV2.merchantLiveReservationInfo;
    }

    public static AdMatrixInfo.FullScreenInfo bJ(AdTemplate adTemplate) {
        return aJ(adTemplate).adDataV2.fullScreenInfo;
    }

    public static boolean bK(AdTemplate adTemplate) {
        AdInfo cb = d.cb(adTemplate);
        if (h(cb) || d.co(adTemplate)) {
            return false;
        }
        return !(aO(adTemplate).cardType == 4) && d.cb(adTemplate).adStyleInfo2.playDetailInfo.detailCommonInfo.rewardInteractionType <= 0 && cb.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.interactiveStyle == 2;
    }

    public static boolean bL(AdTemplate adTemplate) {
        AdInfo cb = d.cb(adTemplate);
        if (h(cb) || d.co(adTemplate)) {
            return false;
        }
        return ((aO(adTemplate).cardType == 4) || d.cb(adTemplate).adStyleInfo2.playDetailInfo.detailWebCardInfo.cardType == 4 || cb.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.interactiveStyle != 2) ? false : true;
    }

    public static AdMatrixInfo.PreLandingPageTKInfo bM(AdTemplate adTemplate) {
        return d.cb(adTemplate).adMatrixInfo.adDataV2.preLandingPageTKInfo;
    }

    private static AdMatrixInfo.BaseMatrixTemplate ba(AdTemplate adTemplate) {
        return aJ(adTemplate).adDataV2.halfCardInfo;
    }

    public static String bb(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate b = b(adTemplate, ba(adTemplate).templateId);
        return b != null ? b.templateUrl : "";
    }

    private static AdMatrixInfo.EndCardInfo bc(AdTemplate adTemplate) {
        return aJ(adTemplate).adDataV2.endCardInfo;
    }

    public static String bd(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate b = b(adTemplate, bc(adTemplate).templateId);
        return b != null ? b.templateUrl : "";
    }

    public static boolean be(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(bd(adTemplate));
    }

    private static String bf(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate b = b(adTemplate, d.cb(adTemplate).adMatrixInfo.adDataV2.activityMiddlePageInfo.templateId);
        return b != null ? b.templateUrl : "";
    }

    public static String bg(AdTemplate adTemplate) {
        return (adTemplate.mIsForceJumpLandingPage || !cK(d.cb(adTemplate))) ? a.aK(d.cb(adTemplate)) : bf(adTemplate);
    }

    private static AdMatrixInfo.FeedInfo bh(AdTemplate adTemplate) {
        boolean bi = bi(adTemplate);
        AdMatrixInfo.AdDataV2 adDataV2 = aJ(adTemplate).adDataV2;
        return bi ? adDataV2.adUnionFeedLiveTemplateInfo : adDataV2.feedInfo;
    }

    private static boolean bi(AdTemplate adTemplate) {
        return a.cq(d.cb(adTemplate));
    }

    private static AdMatrixInfo.FeedInfo bj(AdTemplate adTemplate) {
        return aJ(adTemplate).adDataV2.adUnionFeedLiveMediaInfo;
    }

    public static String bk(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate b = b(adTemplate, bh(adTemplate).templateId);
        return b != null ? b.templateUrl : "";
    }

    public static String bl(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate b = b(adTemplate, bj(adTemplate).templateId);
        return b != null ? b.templateUrl : "";
    }

    public static boolean bm(AdTemplate adTemplate) {
        return bh(adTemplate).interactionInfo.interactiveStyle == 2;
    }

    public static boolean bn(AdTemplate adTemplate) {
        return bh(adTemplate).interactionInfo.shakeInfo.clickDisabled;
    }

    public static int bo(AdTemplate adTemplate) {
        AdMatrixInfo.AdInteractionInfo adInteractionInfo = bh(adTemplate).interactionInfo;
        if (adInteractionInfo == null || adInteractionInfo.shakeInfo == null) {
            return 0;
        }
        return adInteractionInfo.shakeInfo.acceleration;
    }

    public static double bp(AdTemplate adTemplate) {
        return d.cb(adTemplate).adStyleInfo.feedAdInfo.heightRatio;
    }

    public static boolean bq(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(bk(adTemplate));
    }

    public static boolean br(AdTemplate adTemplate) {
        return !TextUtils.isEmpty(bl(adTemplate));
    }

    private static AdMatrixInfo.InterstitialCardInfo bs(AdTemplate adTemplate) {
        return aJ(adTemplate).adDataV2.interstitialCardInfo;
    }

    public static float bt(AdTemplate adTemplate) {
        int i;
        try {
            i = d.cb(adTemplate).adMatrixInfo.adDataV2.interstitialCardInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            i = 7;
        }
        if (i > 0) {
            return i;
        }
        return 7.0f;
    }

    public static boolean bu(AdTemplate adTemplate) {
        try {
            return d.cb(adTemplate).adMatrixInfo.adDataV2.interstitialCardInfo.renderType == 1;
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            return false;
        }
    }

    public static int bv(AdTemplate adTemplate) {
        return d.cb(adTemplate).adMatrixInfo.adDataV2.interstitialCardInfo.renderType;
    }

    public static String bw(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate b = b(adTemplate, bs(adTemplate).templateId);
        return b != null ? b.templateUrl : "";
    }

    public static float bx(AdTemplate adTemplate) {
        int i;
        try {
            i = d.cb(adTemplate).adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            i = 7;
        }
        return i;
    }

    public static AdMatrixInfo.RotateInfo by(AdTemplate adTemplate) {
        try {
            return d.cb(adTemplate).adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo;
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            return null;
        }
    }

    private static AdMatrixInfo.BaseMatrixTemplate bz(AdTemplate adTemplate) {
        return aJ(adTemplate).adDataV2.complianceCardInfo;
    }

    public static AdMatrixInfo.MatrixTemplate c(AdTemplate adTemplate, String str) {
        return b(adTemplate, str);
    }

    @Deprecated
    private static String cE(AdInfo adInfo) {
        if (adInfo == null) {
            return null;
        }
        String str = adInfo.adStyleInfo.playDetailInfo.detailWebCardInfo.cardUrl;
        try {
            if (((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).aY(str)) {
                return str;
            }
            return null;
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            return null;
        }
    }

    public static boolean cF(AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.templateId);
    }

    public static boolean cG(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.endCardFullScreenClick;
    }

    public static boolean cH(AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.topFloorTKInfo.templateId);
    }

    public static boolean cI(AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.splashPlayCardTKInfo.templateId);
    }

    public static boolean cI(String str) {
        try {
            return ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).aY(str);
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean cJ(AdInfo adInfo) {
        if (cK(adInfo)) {
            return adInfo.adMatrixInfo.adDataV2.activityMiddlePageInfo.showHeaderBar;
        }
        return true;
    }

    public static boolean cK(AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.activityMiddlePageInfo.templateId);
    }

    public static AdMatrixInfo.DownloadTexts cL(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo.downloadTexts;
    }

    public static AdMatrixInfo.DownloadTexts cM(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.slideInfo.downloadTexts;
    }

    public static String cN(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo.title;
    }

    public static long cO(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.tkDefaultTimeout;
    }

    public static String cP(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo.subTitle;
    }

    public static AdMatrixInfo.DownloadTexts cQ(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.splashActionBarInfo.downloadTexts;
    }

    public static String cR(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.splashActionBarInfo.title;
    }

    public static boolean cS(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.interactionInfo.interactiveStyle == 2;
    }

    public static String cT(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.cycleAggregateInfo.cutIconUrl;
    }

    public static String cU(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.cycleAggregateInfo.refreshIconUrl;
    }

    public static String cV(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.cycleAggregateInfo.convertIconUrl;
    }

    public static int cW(AdInfo adInfo) {
        try {
            int i = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.componentIndex;
            if (i != 2) {
                return 1;
            }
            return i;
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            return 1;
        }
    }

    public static boolean cX(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.isMediaDisable && adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 4;
    }

    public static boolean cY(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 2;
    }

    public static boolean cZ(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 2;
    }

    private static AdMatrixInfo.TemplateData d(AdTemplate adTemplate, String str) {
        for (AdMatrixInfo.TemplateData templateData : aJ(adTemplate).adDataV2.templateDataList) {
            if (bb.isEquals(str, templateData.templateId)) {
                return templateData;
            }
        }
        return null;
    }

    public static boolean da(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 1;
    }

    public static boolean db(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 1;
    }

    public static boolean dc(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 3;
    }

    public static boolean dd(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 10;
    }

    public static boolean de(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 3;
    }

    public static boolean df(AdInfo adInfo) {
        try {
            if (adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle != 4) {
                return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 9;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean dg(AdInfo adInfo) {
        try {
            return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 0;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean dh(AdInfo adInfo) {
        try {
            return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 4;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean di(AdInfo adInfo) {
        try {
            return !adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.clickDisabled;
        } catch (Exception e) {
            return false;
        }
    }

    public static long dj(AdInfo adInfo) {
        try {
            long j = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.switchDefaultTime;
            return j <= 0 ? com.igexin.push.config.c.j : j;
        } catch (Exception e) {
            return com.igexin.push.config.c.j;
        }
    }

    public static boolean dk(AdInfo adInfo) {
        try {
            return !adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.clickDisabled;
        } catch (Exception e) {
            return false;
        }
    }

    public static float dl(AdInfo adInfo) {
        int i;
        try {
            i = adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            i = 7;
        }
        return i;
    }

    public static float dm(AdInfo adInfo) {
        int i;
        try {
            i = adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            i = 7;
        }
        return i;
    }

    public static String dn(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.title;
    }

    /* renamed from: do  reason: not valid java name */
    public static String m7799do(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.title;
    }

    public static String dp(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.subtitle;
    }

    public static String dq(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.subtitle;
    }

    public static AdMatrixInfo.DownloadTexts dr(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.splashActionBarInfo.downloadTexts;
    }

    public static AdMatrixInfo.DownloadTexts ds(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.splashActionBarInfo.downloadTexts;
    }

    public static boolean dt(AdInfo adInfo) {
        for (AdMatrixInfo.MatrixTag matrixTag : adInfo.adMatrixInfo.tag) {
            if ("playEndClose".equals(matrixTag.type)) {
                return matrixTag.isHide;
            }
        }
        return false;
    }

    public static boolean du(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoTKInfo.renderType == 1;
    }

    public static boolean dv(AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.preLandingPageTKInfo.templateId);
    }

    private static long e(AdTemplate adTemplate, String str) {
        AdMatrixInfo.TemplateData d = d(adTemplate, str);
        if (d != null) {
            return d.templateDelayTime;
        }
        return 0L;
    }

    private static boolean f(AdTemplate adTemplate, String str) {
        AdMatrixInfo.TemplateData d = d(adTemplate, str);
        try {
            JSONObject optJSONObject = new JSONObject(d != null ? d.data : "").optJSONObject("autoCallAppInfo");
            boolean z = false;
            if (optJSONObject != null) {
                z = false;
                if (!TextUtils.isEmpty(optJSONObject.optString("adTitle"))) {
                    z = true;
                }
            }
            return z;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean h(AdInfo adInfo) {
        return (!adInfo.adRewardInfo.recommendAggregateSwitch || am(adInfo) || a.cv(adInfo) || a.bv(adInfo)) ? false : true;
    }
}
