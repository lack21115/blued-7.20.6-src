package com.kwad.sdk.core.response.a;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.ci;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.bb;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/a/a.class */
public final class a {
    public static long D(AdInfo adInfo) {
        return adInfo.adBaseInfo.creativeId;
    }

    public static String E(AdInfo adInfo) {
        return aN(adInfo).materialUrl;
    }

    public static int F(AdInfo adInfo) {
        return aN(adInfo).videoDuration;
    }

    public static long G(AdInfo adInfo) {
        return F(adInfo) * 1000;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String H(com.kwad.sdk.core.response.model.AdInfo r3) {
        /*
            r0 = r3
            int r0 = aW(r0)
            r4 = r0
            r0 = r4
            r1 = 1
            if (r0 == r1) goto L54
            r0 = r4
            r1 = 2
            if (r0 == r1) goto L1d
            r0 = r4
            r1 = 3
            if (r0 == r1) goto L1d
            r0 = r4
            r1 = 8
            if (r0 == r1) goto L8b
            goto Lc2
        L1d:
            r0 = r3
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo r0 = r0.adMaterialInfo
            java.util.List<com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature> r0 = r0.materialFeatureList
            java.util.Iterator r0 = r0.iterator()
            r5 = r0
        L2a:
            r0 = r5
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L54
            r0 = r5
            java.lang.Object r0 = r0.next()
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature r0 = (com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature) r0
            r6 = r0
            r0 = r6
            int r0 = r0.featureType
            r1 = 2
            if (r0 != r1) goto L2a
            r0 = r6
            java.lang.String r0 = r0.firstFrame
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L2a
            r0 = r6
            java.lang.String r0 = r0.firstFrame
            return r0
        L54:
            r0 = r3
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo r0 = r0.adMaterialInfo
            java.util.List<com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature> r0 = r0.materialFeatureList
            java.util.Iterator r0 = r0.iterator()
            r5 = r0
        L61:
            r0 = r5
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L8b
            r0 = r5
            java.lang.Object r0 = r0.next()
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature r0 = (com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature) r0
            r6 = r0
            r0 = r6
            int r0 = r0.featureType
            r1 = 1
            if (r0 != r1) goto L61
            r0 = r6
            java.lang.String r0 = r0.firstFrame
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L61
            r0 = r6
            java.lang.String r0 = r0.firstFrame
            return r0
        L8b:
            r0 = r3
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo r0 = r0.adMaterialInfo
            java.util.List<com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature> r0 = r0.materialFeatureList
            java.util.Iterator r0 = r0.iterator()
            r3 = r0
        L98:
            r0 = r3
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto Lc2
            r0 = r3
            java.lang.Object r0 = r0.next()
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature r0 = (com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature) r0
            r5 = r0
            r0 = r5
            int r0 = r0.featureType
            r1 = 3
            if (r0 != r1) goto L98
            r0 = r5
            java.lang.String r0 = r0.firstFrame
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L98
            r0 = r5
            java.lang.String r0 = r0.firstFrame
            return r0
        Lc2:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.response.a.a.H(com.kwad.sdk.core.response.model.AdInfo):java.lang.String");
    }

    public static boolean I(AdInfo adInfo) {
        return adInfo.adConversionInfo.supportThirdDownload == 1;
    }

    public static int J(AdInfo adInfo) {
        return aN(adInfo).videoWidth;
    }

    public static int K(AdInfo adInfo) {
        return aN(adInfo).videoHeight;
    }

    public static boolean L(AdInfo adInfo) {
        return adInfo.adConversionInfo.smallAppJumpInfo == null || TextUtils.isEmpty(adInfo.adConversionInfo.smallAppJumpInfo.mediaSmallAppId);
    }

    public static boolean M(AdInfo adInfo) {
        return adInfo.adConversionInfo.webUriSourceType == 2;
    }

    public static boolean N(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature aN = aN(adInfo);
        return aN.videoWidth <= aN.videoHeight;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00b0  */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String O(com.kwad.sdk.core.response.model.AdInfo r3) {
        /*
            r0 = r3
            int r0 = aW(r0)
            r4 = r0
            r0 = r4
            r1 = 1
            if (r0 == r1) goto L63
            r0 = r4
            r1 = 2
            if (r0 == r1) goto L1d
            r0 = r4
            r1 = 3
            if (r0 == r1) goto L1d
            r0 = r4
            r1 = 8
            if (r0 == r1) goto L9a
            goto Ld1
        L1d:
            r0 = r3
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo r0 = r0.adMaterialInfo
            java.util.List<com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature> r0 = r0.materialFeatureList
            java.util.Iterator r0 = r0.iterator()
            r5 = r0
        L2a:
            r0 = r5
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L63
            r0 = r5
            java.lang.Object r0 = r0.next()
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature r0 = (com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature) r0
            r6 = r0
            r0 = r6
            int r0 = r0.featureType
            r1 = 2
            if (r0 != r1) goto L2a
            r0 = r6
            java.lang.String r0 = r0.materialUrl
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L54
            r0 = r6
            java.lang.String r0 = r0.materialUrl
            return r0
        L54:
            r0 = r6
            java.lang.String r0 = r0.coverUrl
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L2a
            r0 = r6
            java.lang.String r0 = r0.coverUrl
            return r0
        L63:
            r0 = r3
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo r0 = r0.adMaterialInfo
            java.util.List<com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature> r0 = r0.materialFeatureList
            java.util.Iterator r0 = r0.iterator()
            r5 = r0
        L70:
            r0 = r5
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L9a
            r0 = r5
            java.lang.Object r0 = r0.next()
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature r0 = (com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature) r0
            r6 = r0
            r0 = r6
            int r0 = r0.featureType
            r1 = 1
            if (r0 != r1) goto L70
            r0 = r6
            java.lang.String r0 = r0.coverUrl
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L70
            r0 = r6
            java.lang.String r0 = r0.coverUrl
            return r0
        L9a:
            r0 = r3
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo r0 = r0.adMaterialInfo
            java.util.List<com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature> r0 = r0.materialFeatureList
            java.util.Iterator r0 = r0.iterator()
            r3 = r0
        La7:
            r0 = r3
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto Ld1
            r0 = r3
            java.lang.Object r0 = r0.next()
            com.kwad.sdk.core.response.model.AdInfo$AdMaterialInfo$MaterialFeature r0 = (com.kwad.sdk.core.response.model.AdInfo.AdMaterialInfo.MaterialFeature) r0
            r5 = r0
            r0 = r5
            int r0 = r0.featureType
            r1 = 3
            if (r0 != r1) goto La7
            r0 = r5
            java.lang.String r0 = r0.coverUrl
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto La7
            r0 = r5
            java.lang.String r0 = r0.coverUrl
            return r0
        Ld1:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.response.a.a.O(com.kwad.sdk.core.response.model.AdInfo):java.lang.String");
    }

    public static String P(AdInfo adInfo) {
        int aW = aW(adInfo);
        if (aW != 1) {
            if (aW != 2 && aW != 3) {
                return "";
            }
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.blurBackgroundUrl)) {
                    return materialFeature.blurBackgroundUrl;
                }
            }
        }
        return aQ(adInfo).blurBackgroundUrl;
    }

    private static int Q(AdInfo adInfo) {
        return aN(adInfo).width;
    }

    private static int R(AdInfo adInfo) {
        return aN(adInfo).height;
    }

    public static long S(AdInfo adInfo) {
        return aN(adInfo).photoId;
    }

    public static String T(AdInfo adInfo) {
        return (adInfo == null || TextUtils.isEmpty(adInfo.adBaseInfo.openAppLabel)) ? "立即打开" : adInfo.adBaseInfo.openAppLabel;
    }

    public static long U(AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardTime;
    }

    public static int V(AdInfo adInfo) {
        return adInfo.adRewardInfo.skipShowTime;
    }

    public static long W(AdInfo adInfo) {
        return adInfo.adRewardInfo.skipShowTime * 1000;
    }

    public static long X(AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardTime * 1000;
    }

    private static int Y(AdInfo adInfo) {
        if (adInfo.adStyleConfInfo != null) {
            return adInfo.adStyleConfInfo.rewardSkipConfirmSwitch;
        }
        com.kwad.sdk.core.d.b.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 1;
    }

    public static boolean Z(AdInfo adInfo) {
        if (adInfo.adStyleConfInfo.nativeAdInfo == null || adInfo.adStyleConfInfo.nativeAdInfo.shakeInfo == null) {
            com.kwad.sdk.core.d.b.w("AdInfoHelper", "adInfo.adStyleConfInfo.nativeAdInfo is null");
            return false;
        }
        return adInfo.adStyleConfInfo.nativeAdInfo.shakeInfo.enableShake;
    }

    public static int aA(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.dayMaxLimit;
    }

    public static int aB(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.showTime;
    }

    public static int aC(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.rewardTime;
    }

    public static int aD(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.showTime;
    }

    public static int aE(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.thresholdTime;
    }

    public static int aF(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.taskType;
    }

    public static boolean aG(AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.rewardVideoTaskInfo.templateId);
    }

    public static String aH(AdTemplate adTemplate) {
        if (adTemplate == null || adTemplate.mAdScene == null || adTemplate.mAdScene.getAdStyle() != 2 || cp(d.cb(adTemplate)) || cq(d.cb(adTemplate))) {
            if (adTemplate == null) {
                return "立即安装";
            }
            AdInfo cb = d.cb(adTemplate);
            return TextUtils.isEmpty(cb.adBaseInfo.installAppLabel) ? "立即安装" : cb.adBaseInfo.installAppLabel;
        }
        return "安装获取奖励";
    }

    public static boolean aH(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.complianceInfo != null && ax(adInfo) && adInfo.downloadSafeInfo.complianceInfo.titleBarTextSwitch == 1;
    }

    public static int aI(AdInfo adInfo) {
        int i = adInfo.adBaseInfo.adOperationType;
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                return 0;
            }
        }
        return i2;
    }

    public static boolean aI(AdTemplate adTemplate) {
        AdInfo cb = d.cb(adTemplate);
        AdMatrixInfo.MerchantLiveReservationInfo bI = b.bI(adTemplate);
        return (bI != null && !bI.isEmpty()) && cb.adBaseInfo.campaignType == 13 && cb.ocpcActionType == 2;
    }

    public static int aJ(AdInfo adInfo) {
        return adInfo.adBaseInfo.ecpm;
    }

    public static String aK(AdInfo adInfo) {
        com.kwad.sdk.service.kwai.e eVar = (com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class);
        return TextUtils.isEmpty(adInfo.adConversionInfo.h5Url) ? "" : ac.c(eVar == null ? null : eVar.getContext(), adInfo.adConversionInfo.h5Url, at(adInfo));
    }

    public static int aL(AdInfo adInfo) {
        return adInfo.adConversionInfo.h5Type;
    }

    public static AdInfo.AdMaterialInfo.MaterialFeature aM(AdInfo adInfo) {
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature != null && materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                return materialFeature;
            }
        }
        com.kwad.sdk.core.d.b.w("AdInfoHelper", "getImageMaterialFeature in null");
        return new AdInfo.AdMaterialInfo.MaterialFeature();
    }

    public static AdInfo.AdMaterialInfo.MaterialFeature aN(AdInfo adInfo) {
        for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
            if (materialFeature != null && materialFeature.featureType == 1 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                return materialFeature;
            }
        }
        com.kwad.sdk.core.d.b.w("AdInfoHelper", "getVideoMaterialFeature in null");
        return new AdInfo.AdMaterialInfo.MaterialFeature();
    }

    public static boolean aO(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature aN = aU(adInfo) ? aN(adInfo) : aM(adInfo);
        return aN.height > aN.width;
    }

    public static float aP(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature aN = aU(adInfo) ? aN(adInfo) : aM(adInfo);
        if (aN == null || aN.width == 0) {
            return -1.0f;
        }
        com.kwad.sdk.core.d.b.d("AdInfoHelper", "getMaterialRatio: height: " + aN.height + ", width: " + aN.width);
        return aN.height / aN.width;
    }

    private static AdInfo.AdMaterialInfo.MaterialFeature aQ(AdInfo adInfo) {
        List<AdInfo.AdMaterialInfo.MaterialFeature> list = adInfo.adMaterialInfo.materialFeatureList;
        AdInfo.AdMaterialInfo.MaterialFeature materialFeature = list.size() > 0 ? list.get(0) : null;
        AdInfo.AdMaterialInfo.MaterialFeature materialFeature2 = materialFeature;
        if (materialFeature == null) {
            materialFeature2 = new AdInfo.AdMaterialInfo.MaterialFeature();
        }
        return materialFeature2;
    }

    public static boolean aR(AdInfo adInfo) {
        AdInfo.AdMaterialInfo.MaterialFeature aN = aN(adInfo);
        return aN.height > aN.width;
    }

    public static String aS(AdInfo adInfo) {
        return adInfo.adPreloadInfo.preloadId;
    }

    public static List<String> aT(AdInfo adInfo) {
        ArrayList arrayList = new ArrayList();
        int aW = aW(adInfo);
        if (aW == 2 || aW == 3) {
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : adInfo.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                    arrayList.add(materialFeature.materialUrl);
                }
            }
            return arrayList;
        }
        return arrayList;
    }

    public static boolean aU(AdInfo adInfo) {
        return aW(adInfo) == 1;
    }

    public static boolean aV(AdInfo adInfo) {
        return aM(adInfo).featureType == 2;
    }

    public static int aW(AdInfo adInfo) {
        int i = adInfo.adMaterialInfo.materialType;
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                if (i != 5) {
                    return i != 8 ? 0 : 8;
                }
                return 3;
            }
        }
        return i2;
    }

    public static int aX(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.actionBarInfo.cardType;
    }

    public static String aY(AdInfo adInfo) {
        return adInfo.adBaseInfo.liveStreamId;
    }

    public static boolean aZ(AdInfo adInfo) {
        return adInfo.adMaterialInfo.materialType == 1;
    }

    public static int aa(AdInfo adInfo) {
        if (adInfo.adStyleConfInfo.nativeAdInfo != null) {
            return adInfo.adStyleConfInfo.nativeAdInfo.shakeInfo.acceleration;
        }
        com.kwad.sdk.core.d.b.w("AdInfoHelper", "adInfo.adStyleConfInfo.nativeAdInfo is null");
        return 2;
    }

    public static boolean ab(AdInfo adInfo) {
        return Y(adInfo) != 0;
    }

    public static long ac(AdInfo adInfo) {
        if (adInfo.adStyleConfInfo != null) {
            return adInfo.adStyleConfInfo.fullScreenSkipShowTime * 1000;
        }
        com.kwad.sdk.core.d.b.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 5000L;
    }

    public static long ad(AdInfo adInfo) {
        if (adInfo.adStyleConfInfo != null) {
            return adInfo.adStyleConfInfo.closeDelaySeconds * 1000;
        }
        com.kwad.sdk.core.d.b.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 0L;
    }

    public static int ae(AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.showPageType;
    }

    public static boolean af(AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.videoAutoLoopAtH5;
    }

    public static boolean ag(AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.videoMutedAtH5;
    }

    public static boolean ah(AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adShowVideoH5Info.videoClickAtH5;
    }

    public static long ai(AdInfo adInfo) {
        if (adInfo.adStyleConfInfo != null) {
            return adInfo.adStyleConfInfo.playableCloseSeconds * 1000;
        }
        com.kwad.sdk.core.d.b.w("AdInfoHelper", "adInfo.adStyleConfInfo is null");
        return 0L;
    }

    public static boolean aj(AdInfo adInfo) {
        return !ax(adInfo) && ak(adInfo);
    }

    public static boolean ak(AdInfo adInfo) {
        if (adInfo.adRewardInfo.showLandingPage == 1) {
            return ((aG(adInfo) && aF(adInfo) == 1) || am(adInfo) || cv(adInfo)) ? false : true;
        }
        return false;
    }

    public static boolean al(AdInfo adInfo) {
        return (!(adInfo.fullScreenVideoInfo.showLandingPage == 1) || !(bb.isNullString(aK(adInfo)) ^ true) || ax(adInfo) || (bb.isNullString(cs(adInfo)) ^ true) || bv(adInfo)) ? false : true;
    }

    private static boolean am(AdInfo adInfo) {
        return adInfo.adBaseInfo.taskType == 4;
    }

    public static String an(AdInfo adInfo) {
        return adInfo.adBaseInfo.adDescription;
    }

    public static String ao(AdInfo adInfo) {
        return adInfo.adBaseInfo.appName;
    }

    public static String ap(AdInfo adInfo) {
        return adInfo.adBaseInfo.productName;
    }

    public static String aq(AdInfo adInfo) {
        if (adInfo == null || adInfo.adBaseInfo == null) {
            return null;
        }
        return adInfo.adBaseInfo.appPackageName;
    }

    public static String ar(AdInfo adInfo) {
        return adInfo.adBaseInfo.appDownloadCountDesc;
    }

    public static float as(AdInfo adInfo) {
        if (adInfo.adBaseInfo.appScore <= 0) {
            return 0.0f;
        }
        return adInfo.adBaseInfo.appScore / 10.0f;
    }

    public static boolean at(AdInfo adInfo) {
        return adInfo.adBaseInfo.enableClientProofreadTime;
    }

    public static float au(AdInfo adInfo) {
        float f = adInfo.adBaseInfo.appScore;
        if (f < 30.0f) {
            return 3.0f;
        }
        if (f < 35.0f) {
            return 3.5f;
        }
        if (f < 40.0f) {
            return 4.0f;
        }
        return f < 45.0f ? 4.5f : 5.0f;
    }

    public static String av(AdInfo adInfo) {
        return bb.isNullString(adInfo.adBaseInfo.adSourceDescription) ? "广告" : adInfo.adBaseInfo.adSourceDescription;
    }

    public static String aw(AdInfo adInfo) {
        if (adInfo == null) {
            return "立即下载";
        }
        String str = adInfo.adBaseInfo.adActionDescription;
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = ax(adInfo) ? "立即下载" : "查看详情";
        }
        return str2;
    }

    public static boolean ax(AdInfo adInfo) {
        return aI(adInfo) == 1;
    }

    public static boolean ay(AdInfo adInfo) {
        return adInfo.adStyleConfInfo.rewardVideoInteractSwitch && !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.templateId);
    }

    public static int az(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.rewardVideoInteractInfo.intervalShow;
    }

    public static boolean b(AdInfo adInfo, boolean z) {
        return ((z && ax(adInfo)) || adInfo.adBaseInfo.mABParams.showVideoAtH5 == 0 || bb.isNullString(aK(adInfo))) ? false : true;
    }

    private static boolean bA(AdInfo adInfo) {
        if (adInfo == null || adInfo.adConversionInfo == null || adInfo.adConversionInfo.playableStyleInfo == null) {
            return false;
        }
        int i = adInfo.adConversionInfo.playableStyleInfo.playableOrientation;
        return i == 0 || i == 1;
    }

    public static String bB(AdInfo adInfo) {
        if (adInfo == null || adInfo.adConversionInfo == null) {
            return null;
        }
        return adInfo.adConversionInfo.playableUrl;
    }

    public static String bC(AdInfo adInfo) {
        if (adInfo == null || adInfo.adConversionInfo == null) {
            return null;
        }
        return adInfo.adConversionInfo.callbackUrl;
    }

    public static String bD(AdInfo adInfo) {
        if (adInfo == null || adInfo.adConversionInfo == null) {
            return null;
        }
        return adInfo.adConversionInfo.callbackUrlInfo;
    }

    public static boolean bE(AdInfo adInfo) {
        return adInfo.fullScreenVideoInfo.fullScreenEndCardSwitch;
    }

    public static boolean bF(AdInfo adInfo) {
        return adInfo.adRewardInfo.rewardVideoEndCardSwitch;
    }

    public static boolean bG(AdInfo adInfo) {
        return (adInfo == null || adInfo.adFeedInfo == null || adInfo.adFeedInfo.videoSoundType != 2) ? false : true;
    }

    public static boolean bH(AdInfo adInfo) {
        if (adInfo == null || adInfo.adFeedInfo == null) {
            return false;
        }
        return adInfo.adFeedInfo.videoAutoPlayType == 1 || adInfo.adFeedInfo.videoAutoPlayType == 0;
    }

    public static boolean bI(AdInfo adInfo) {
        return (adInfo == null || adInfo.adFeedInfo == null || adInfo.adFeedInfo.videoAutoPlayType != 2) ? false : true;
    }

    public static boolean bJ(AdInfo adInfo) {
        return (TextUtils.isEmpty(aK(adInfo)) || ax(adInfo) || adInfo.adStyleInfo.adBrowseInfo.enableAdBrowse != 1) ? false : true;
    }

    public static String bK(AdInfo adInfo) {
        String ao = ax(adInfo) ? ao(adInfo) : ap(adInfo);
        String str = ao;
        if (TextUtils.isEmpty(ao)) {
            str = adInfo.advertiserInfo.rawUserName;
        }
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = "可爱的广告君";
        }
        return str2;
    }

    public static String bL(AdInfo adInfo) {
        return adInfo.advertiserInfo.rawUserName;
    }

    public static String bM(AdInfo adInfo) {
        String str = adInfo.adBaseInfo.appIconUrl;
        if (TextUtils.isEmpty(str) || !ax(adInfo)) {
            str = adInfo.advertiserInfo.portraitUrl;
        }
        return str;
    }

    public static long bN(AdInfo adInfo) {
        return adInfo.advertiserInfo.userId;
    }

    public static String bO(AdInfo adInfo) {
        String str = "跳过";
        if (adInfo != null) {
            str = "跳过";
            if (adInfo.adSplashInfo != null) {
                if (adInfo.adSplashInfo.skipTips == null) {
                    return "跳过";
                }
                str = "跳过";
                if (!TextUtils.isEmpty(adInfo.adSplashInfo.skipTips)) {
                    str = adInfo.adSplashInfo.skipTips;
                }
            }
        }
        return str;
    }

    public static AdInfo.CutRuleInfo bP(AdInfo adInfo) {
        return adInfo.adSplashInfo.cutRuleInfo;
    }

    public static int bQ(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.endCardShowSecond;
    }

    public static boolean bR(AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.endCardShowCountDown;
    }

    public static int bS(AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowBasedAdShowCount;
    }

    public static int bT(AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowDailyShowCount;
    }

    public static int bU(AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowStyle;
    }

    public static int bV(AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.guideShowStyle;
    }

    public static int bW(AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.guideShowTime;
    }

    public static String bX(AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.retainWindowText;
    }

    public static boolean bY(AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.cycleAggregateSwitch;
    }

    public static int bZ(AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.cycleAggregateStyle;
    }

    public static boolean ba(AdInfo adInfo) {
        return adInfo.adConversionInfo.needDeeplinkReplaceAdapta;
    }

    public static boolean bb(AdInfo adInfo) {
        return adInfo.adConversionInfo.isSupportKeepPlaying;
    }

    public static long bc(AdInfo adInfo) {
        return adInfo.adConversionInfo.keepPlayingBackOffTime;
    }

    public static List<Integer> bd(AdInfo adInfo) {
        String str = adInfo.adBaseInfo.videoPlayedNS;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split(",");
                int length = split.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    int parseInt = Integer.parseInt(split[i2]);
                    if (parseInt > 0) {
                        arrayList.add(Integer.valueOf(parseInt));
                    }
                    i = i2 + 1;
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.printStackTrace(e);
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(3);
        }
        return arrayList;
    }

    private static int[] be(AdInfo adInfo) {
        int[] iArr = {3, 3, 3};
        String str = adInfo.adBaseInfo.mABParams.drawActionBarTimes;
        if (TextUtils.isEmpty(str)) {
            return iArr;
        }
        try {
            String[] split = str.split(",");
            if (split.length < 3) {
                return iArr;
            }
            iArr[0] = Integer.parseInt(split[0]);
            iArr[1] = Integer.parseInt(split[1]);
            iArr[2] = Integer.parseInt(split[2]);
            return iArr;
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTrace(e);
            return iArr;
        }
    }

    public static int bf(AdInfo adInfo) {
        int[] be = be(adInfo);
        if (be[0] > 0) {
            return be[0];
        }
        return 3;
    }

    public static int bg(AdInfo adInfo) {
        int[] be = be(adInfo);
        return (be[1] > 0 ? be[1] : 3) + bf(adInfo);
    }

    public static int bh(AdInfo adInfo) {
        int[] be = be(adInfo);
        return (be[2] > 0 ? be[2] : 3) + bg(adInfo);
    }

    public static com.kwad.sdk.core.response.model.b bi(AdInfo adInfo) {
        String str;
        boolean z;
        String H = H(adInfo);
        int J = J(adInfo);
        int K = K(adInfo);
        if (bb.isNullString(H) || bb.eP(H) || J == 0 || K == 0) {
            String O = O(adInfo);
            J = Q(adInfo);
            K = R(adInfo);
            str = O;
            z = true;
        } else {
            str = H;
            z = false;
        }
        com.kwad.sdk.core.d.b.d("AdInfoHelper", "frameUrl=" + str + " useCover=" + z + " isAd=true");
        return new com.kwad.sdk.core.response.model.b(str, J, K, true, z);
    }

    public static String bj(AdInfo adInfo) {
        String str = adInfo.downloadSafeInfo.webPageTipbarText;
        return !TextUtils.isEmpty(str) ? str : "您访问的网站由第三方提供";
    }

    public static boolean bk(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.secWindowPopSwitch;
    }

    public static boolean bl(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.secWindowPopNoWifiSwitch;
    }

    public static int bm(AdInfo adInfo) {
        if (adInfo.downloadSafeInfo.complianceInfo == null) {
            return -1;
        }
        return adInfo.downloadSafeInfo.complianceInfo.materialJumpType;
    }

    public static boolean bn(AdInfo adInfo) {
        return adInfo.downloadSafeInfo.webPageTipbarSwitch;
    }

    public static int bo(AdInfo adInfo) {
        if (adInfo != null) {
            int i = adInfo.status;
            if (i == 0) {
                return 1;
            }
            if (1 == i || 2 == i || 3 == i || 4 == i) {
                return 2;
            }
            return 8 == i ? 3 : 0;
        }
        return 0;
    }

    public static String bp(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.corporationName;
        }
        return null;
    }

    public static String bq(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.permissionInfo;
        }
        return null;
    }

    public static String br(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.appPermissionInfoUrl;
        }
        return null;
    }

    public static String bs(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.downloadSafeInfo.appPrivacyUrl;
        }
        return null;
    }

    public static String bt(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.appVersion;
        }
        return null;
    }

    public static long bu(AdInfo adInfo) {
        if (adInfo != null) {
            return adInfo.adBaseInfo.packageSize;
        }
        return 0L;
    }

    public static boolean bv(AdInfo adInfo) {
        if (adInfo == null || adInfo.adConversionInfo == null) {
            return false;
        }
        return by(adInfo) && (adInfo.adConversionInfo.playableUrl != null && adInfo.adConversionInfo.playableStyleInfo != null && !TextUtils.isEmpty(adInfo.adConversionInfo.playableUrl.trim()));
    }

    public static long bw(AdInfo adInfo) {
        if (adInfo == null || adInfo.adConversionInfo == null) {
            return 0L;
        }
        return adInfo.adConversionInfo.h5DeeplinkLimitedTimeMs;
    }

    public static long bx(AdInfo adInfo) {
        if (adInfo == null || adInfo.adConversionInfo == null) {
            return 0L;
        }
        return adInfo.adConversionInfo.playableDeeplinkLimitedTimeMs;
    }

    @Deprecated
    public static String by(int i) {
        return i(i, "下载中  %s%%");
    }

    public static boolean by(AdInfo adInfo) {
        return ai.DM() ? bA(adInfo) : bz(adInfo);
    }

    public static String bz(int i) {
        return "继续下载 " + i + "%";
    }

    private static boolean bz(AdInfo adInfo) {
        if (adInfo == null || adInfo.adConversionInfo == null || adInfo.adConversionInfo.playableStyleInfo == null) {
            return false;
        }
        int i = adInfo.adConversionInfo.playableStyleInfo.playableOrientation;
        return i == 0 || i == 2;
    }

    public static boolean cA(AdInfo adInfo) {
        return adInfo.adStyleConfInfo.useNativeForOuterLiveAd;
    }

    public static long cB(AdInfo adInfo) {
        return adInfo.adRewardInfo.callBackStrategyInfo.callBackAdvanceMs;
    }

    public static boolean cC(AdInfo adInfo) {
        return adInfo.adRewardInfo.callBackStrategyInfo.serverCheckSwitch;
    }

    public static boolean cD(AdInfo adInfo) {
        return adInfo.adRewardInfo.callBackStrategyInfo.rewardAdvanceSwitch;
    }

    public static int ca(AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.cycleAggregateInterval;
    }

    public static int cb(AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.cycleAggregateDailyShowCount;
    }

    public static boolean cc(AdInfo adInfo) {
        return adInfo.adSplashInfo.skipType == 2 || adInfo.adSplashInfo.skipType == 3;
    }

    public static boolean cd(AdInfo adInfo) {
        if (ce(adInfo)) {
            return adInfo.adSplashInfo.skipType == 0 || adInfo.adSplashInfo.skipType == 2;
        }
        return false;
    }

    public static boolean ce(AdInfo adInfo) {
        return adInfo.adSplashInfo.skipSecond >= 0;
    }

    public static boolean cf(AdInfo adInfo) {
        return (adInfo == null || adInfo.adSplashInfo == null || adInfo.adSplashInfo.countdownShow != 1) ? false : true;
    }

    public static boolean cg(AdInfo adInfo) {
        if (adInfo == null || adInfo.downloadSafeInfo == null) {
            return false;
        }
        return adInfo.downloadSafeInfo.downloadPauseEnable;
    }

    public static String ch(AdInfo adInfo) {
        return adInfo.adBaseInfo.sdkExtraData;
    }

    @Deprecated
    public static boolean ci(AdInfo adInfo) {
        return adInfo.ocpcActionType == 72 && adInfo.adBaseInfo.campaignType == 13;
    }

    public static boolean cj(AdInfo adInfo) {
        return adInfo.advertiserInfo.followed;
    }

    public static boolean ck(AdInfo adInfo) {
        if (adInfo.adBaseInfo.industryFirstLevelId != 1022) {
            return false;
        }
        return adInfo.ocpcActionType == 192 || adInfo.ocpcActionType == 53;
    }

    public static String cl(AdInfo adInfo) {
        int i = adInfo.advertiserInfo.fansCount;
        if (i < 200 || i >= 10000) {
            if (i >= 10000) {
                double d = i / 10000.0d;
                DecimalFormat decimalFormat = new DecimalFormat(ci.d);
                return decimalFormat.format(d) + IAdInterListener.AdReqParam.WIDTH;
            }
            return null;
        }
        return String.valueOf(i);
    }

    public static String cm(AdInfo adInfo) {
        return adInfo.advertiserInfo.brief;
    }

    public static String cn(AdInfo adInfo) {
        return adInfo.advertiserInfo.portraitUrl;
    }

    public static boolean co(AdInfo adInfo) {
        if (ck(adInfo)) {
            return false;
        }
        return (adInfo.ocpcActionType == 395 || adInfo.ocpcActionType == 192) && adInfo.adBaseInfo.campaignType == 13;
    }

    public static boolean cp(AdInfo adInfo) {
        return adInfo.adBaseInfo.itemType == 1 && adInfo.adBaseInfo.campaignType == 14;
    }

    public static boolean cq(AdInfo adInfo) {
        return adInfo.adBaseInfo.universeLiveType == 1 && bN(adInfo) != 0;
    }

    public static boolean cr(AdInfo adInfo) {
        return adInfo.adBaseInfo.itemType == 2 && adInfo.adBaseInfo.campaignType == 14;
    }

    public static String cs(AdInfo adInfo) {
        com.kwad.sdk.service.kwai.e eVar = (com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class);
        return ac.c(eVar == null ? null : eVar.getContext(), adInfo.adConversionInfo.deeplinkUrl, at(adInfo));
    }

    public static AdProductInfo ct(AdInfo adInfo) {
        return adInfo.adProductInfo;
    }

    public static String cu(AdInfo adInfo) {
        return adInfo.adConversionInfo.marketUrl;
    }

    public static boolean cv(AdInfo adInfo) {
        if (ax(adInfo)) {
            return false;
        }
        return adInfo.adBaseInfo.extraClickReward;
    }

    public static boolean cw(AdInfo adInfo) {
        return cv(adInfo) && X(adInfo) < G(adInfo);
    }

    public static boolean cx(AdInfo adInfo) {
        if (TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.pushTKInfo.templateId)) {
            com.kwad.sdk.core.d.b.d("AdInfoHelper", "isPushAdEnable pushTK TemplateId is empty");
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0045, code lost:
        if ((java.lang.System.currentTimeMillis() - r0) > (r10 * 1000)) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean cy(com.kwad.sdk.core.response.model.AdInfo r7) {
        /*
            r0 = r7
            com.kwad.sdk.core.response.model.AdInfo$AdStyleConfInfo r0 = r0.adStyleConfInfo
            boolean r0 = r0.adPushSwitch
            r9 = r0
            r0 = 0
            r8 = r0
            r0 = r9
            if (r0 != 0) goto L10
            r0 = 0
            return r0
        L10:
            long r0 = com.kwad.sdk.utils.y.Dx()
            r14 = r0
            r0 = r14
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L21
        L1c:
            r0 = 1
            r8 = r0
            goto L4b
        L21:
            r0 = r7
            com.kwad.sdk.core.response.model.AdInfo$AdStyleConfInfo r0 = r0.adStyleConfInfo
            int r0 = r0.adPushIntervalTime
            long r0 = (long) r0
            r12 = r0
            r0 = r12
            r10 = r0
            r0 = r12
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L39
            r0 = 900(0x384, double:4.447E-321)
            r10 = r0
        L39:
            long r0 = java.lang.System.currentTimeMillis()
            r1 = r14
            long r0 = r0 - r1
            r1 = r10
            r2 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 * r2
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L4b
            goto L1c
        L4b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            java.lang.String r2 = "isPushAdEnable intervalEnable: "
            r1.<init>(r2)
            r7 = r0
            r0 = r7
            r1 = r8
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "AdInfoHelper"
            r1 = r7
            java.lang.String r1 = r1.toString()
            com.kwad.sdk.core.d.b.d(r0, r1)
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.response.a.a.cy(com.kwad.sdk.core.response.model.AdInfo):boolean");
    }

    public static int cz(AdInfo adInfo) {
        return adInfo.adStyleConfInfo.adPushShowAfterTime * 1000;
    }

    public static SpannableString e(AdInfo adInfo, int i) {
        String format;
        int indexOf;
        String cl = cl(adInfo);
        if (cl == null || (indexOf = (format = String.format("已有%s粉丝关注了TA", cl)).indexOf(cl)) < 0) {
            return null;
        }
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(new ForegroundColorSpan(i), indexOf, cl.length() + indexOf, 18);
        return spannableString;
    }

    public static String i(int i, String str) {
        String str2 = str;
        if (str == null) {
            str2 = "下载中  %s%%";
        }
        return String.format(str2, Integer.valueOf(i));
    }

    public static String xw() {
        return "继续下载";
    }
}
