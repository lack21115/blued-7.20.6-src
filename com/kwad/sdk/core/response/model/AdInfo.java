package com.kwad.sdk.core.response.model;

import com.kwad.sdk.utils.ad;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdInfo.class */
public class AdInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    private static final long serialVersionUID = -8738827282880419389L;
    public String downloadFilePath;
    public String downloadId;
    @Deprecated
    public int ocpcActionType;
    public int progress;
    public long soFarBytes;
    public long totalBytes;
    public String trace;
    public AdBaseInfo adBaseInfo = new AdBaseInfo();
    public AdvertiserInfo advertiserInfo = new AdvertiserInfo();
    public AdConversionInfo adConversionInfo = new AdConversionInfo();
    public AdMaterialInfo adMaterialInfo = new AdMaterialInfo();
    public List<AdTrackInfo> adTrackInfoList = new ArrayList();
    public DownloadSafeInfo downloadSafeInfo = new DownloadSafeInfo();
    public UnDownloadConf unDownloadConf = new UnDownloadConf();
    public int status = 0;
    public AdPreloadInfo adPreloadInfo = new AdPreloadInfo();
    public AdSplashInfo adSplashInfo = new AdSplashInfo();
    public AdStyleInfo adStyleInfo = new AdStyleInfo();
    public AdStyleInfo adStyleInfo2 = new AdStyleInfo();
    public AdAggregateInfo adAggregateInfo = new AdAggregateInfo();
    public AdRewardInfo adRewardInfo = new AdRewardInfo();
    public AdStyleConfInfo adStyleConfInfo = new AdStyleConfInfo();
    public FullScreenVideoInfo fullScreenVideoInfo = new FullScreenVideoInfo();
    public AdFeedInfo adFeedInfo = new AdFeedInfo();
    public AdInsertScreenInfo adInsertScreenInfo = new AdInsertScreenInfo();
    public AdProductInfo adProductInfo = new AdProductInfo();
    public AdMatrixInfo adMatrixInfo = new AdMatrixInfo();

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdInfo$AdAggregateInfo.class */
    public static class AdAggregateInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = 6627768757836702989L;
        public int aggregateAdType;
        public String hotTagUrl;
        public String upperTab;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdInfo$AdBaseInfo.class */
    public static class AdBaseInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = 1615884096720946547L;
        public String adActionBarColor;
        public String adActionDescription;
        public int adAttributeType;
        public int adCacheSwitch;
        public String adDescription;
        public String adGrayMarkIcon;
        public String adMarkIcon;
        public int adOperationType;
        public int adShowDuration;
        public String adSourceDescription;
        public int adSourceType;
        public H5Config apiExpParam;
        public String appCategory;
        public String appDescription;
        public String appDownloadCountDesc;
        public String appIconUrl;
        public MaterialSize appImageSize;
        public List<String> appImageUrl;
        public String appName;
        public String appPackageName;
        public int appScore;
        public String appVersion;
        @Deprecated
        public int campaignType;
        public String clickUrl;
        public String convUrl;
        public String corporationName;
        public long creativeId;
        public int ecpm;
        public boolean enableClientProofreadTime;
        public int enableSkipAd;
        public boolean extraClickReward;
        public int industryFirstLevelId;
        public String installAppLabel;
        public int itemType;
        public String liveStreamId;
        public String openAppLabel;
        public long packageSize;
        public String productName;
        public String sdkExtraData;
        public String showUrl;
        public int skipSecond;
        public int taskType;
        public int universeLiveType;
        public String videoPlayedNS;
        public long viewCount;
        public long adCacheSecond = com.anythink.expressad.d.a.b.aC;
        public int adCacheStrategy = 1;
        public int adCacheSize = 1;
        public ABParams mABParams = new ABParams();
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdInfo$AdConversionInfo.class */
    public static class AdConversionInfo extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = -1623240707193173136L;
        public String appDownloadUrl;
        public boolean blockCallbackIfSpam;
        public String callbackUrl;
        public String callbackUrlInfo;
        public List<DeeplinkItemInfo> deeplinkConf;
        public String deeplinkExtra;
        public String deeplinkUrl;
        public int h5DeeplinkLimitedTimeMs;
        public int h5Type;
        public String h5Url;
        public boolean isSupportKeepPlaying;
        public long keepPlayingBackOffTime;
        public String marketUrl;
        public boolean needDeeplinkReplaceAdapta;
        public int playableDeeplinkLimitedTimeMs;
        public PlayableStyleInfo playableStyleInfo;
        public String playableUrl;
        public int retryH5TimeStep;
        public SmallAppJumpInfo smallAppJumpInfo;
        public int supportThirdDownload;
        public int webUriSourceType;

        /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdInfo$AdConversionInfo$DeeplinkItemInfo.class */
        public static class DeeplinkItemInfo extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b, Serializable {
            private static final long serialVersionUID = -8434342914283766519L;
            public List<Integer> areaConf;
            public List<Integer> sceneConf;
            public String url;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdInfo$AdFeedInfo.class */
    public static class AdFeedInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = 9055595743118459339L;
        public int videoAutoPlayType;
        public int videoSoundType;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdInfo$AdInsertScreenInfo.class */
    public static class AdInsertScreenInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = 5131603307173468926L;
        public int autoCloseTime;
        public int cycleAggregateDailyShowCount;
        public int cycleAggregateInterval;
        public int cycleAggregateStyle;
        public boolean cycleAggregateSwitch;
        public int guideShowStyle;
        public int guideShowTime;
        public int retainWindowBasedAdShowCount;
        public int retainWindowDailyShowCount;
        public int retainWindowStyle;
        public String retainWindowText;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdInfo$AdMaterialInfo.class */
    public static class AdMaterialInfo extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = 8841259738296866924L;
        public List<MaterialFeature> materialFeatureList = new ArrayList();
        public int materialType;
        public boolean videoVoice;

        /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdInfo$AdMaterialInfo$MaterialFeature.class */
        public static class MaterialFeature extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b, Serializable {
            private static final long serialVersionUID = -1118440558210936255L;
            public String blurBackgroundUrl;
            public long commentCount;
            public String coverUrl;
            public int featureType;
            public String firstFrame;
            public int height;
            public long likeCount;
            public String materialUrl;
            public long photoId;
            public String ruleId;
            public int source;
            public int videoDuration;
            public int videoHeight;
            public int videoWidth;
            public String webpCoverUrl;
            public int width;

            @Override // com.kwad.sdk.core.response.kwai.a
            public void afterParseJson(JSONObject jSONObject) {
                JSONObject optJSONObject;
                super.afterParseJson(jSONObject);
                if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("materialSize")) == null) {
                    return;
                }
                this.width = optJSONObject.optInt("width");
                this.height = optJSONObject.optInt("height");
            }

            @Override // com.kwad.sdk.core.response.kwai.a
            public void afterToJson(JSONObject jSONObject) {
                super.afterToJson(jSONObject);
                if (jSONObject == null) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("width", this.width);
                    jSONObject2.put("height", this.height);
                    jSONObject.put("materialSize", jSONObject2);
                } catch (JSONException e) {
                    com.kwad.sdk.core.d.b.printStackTrace(e);
                }
            }
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdInfo$AdPreloadInfo.class */
    public static class AdPreloadInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = -1208206464894428350L;
        public String preloadId;
        public String preloadTips;
        public int preloadType;
        public int validityPeriod;

        public boolean equals(Object obj) {
            return (obj instanceof AdPreloadInfo) && ((AdPreloadInfo) obj).preloadId.equals(this.preloadId);
        }

        public int hashCode() {
            String str = this.preloadId;
            return str != null ? str.hashCode() : super.hashCode();
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdInfo$AdRewardInfo.class */
    public static class AdRewardInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = -6571091401675622830L;
        public CallBackStrategyInfo callBackStrategyInfo;
        public int rewardTime;
        public int showLandingPage;
        public int skipShowTime;
        public boolean rewardVideoEndCardSwitch = false;
        public boolean recommendAggregateSwitch = false;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdInfo$AdShowVideoH5Info.class */
    public static class AdShowVideoH5Info extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = -9008557333776946628L;
        public int showPageType;
        public boolean videoAutoLoopAtH5;
        public boolean videoClickAtH5;
        public boolean videoMutedAtH5;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdInfo$AdSplashInfo.class */
    public static class AdSplashInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = 6666286195277235837L;
        public int countdownShow;
        public int imageDisplaySecond;
        public int logoPosition;
        public int mute;
        public int skipSecond;
        public String skipTips;
        public int skipType;
        public String speakerIconUrl;
        public String speakerMuteIconUrl;
        public int videoDisplaySecond;
        public int fullScreenClickSwitch = 0;
        public int skipButtonPosition = 0;
        public int splashShowClickButtonSwitch = 1;
        public CutRuleInfo cutRuleInfo = new CutRuleInfo();
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdInfo$AdStyleConfInfo.class */
    public static class AdStyleConfInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = -6571091401675622831L;
        public int adPushDownloadJumpType;
        public int adPushShowAfterTime;
        public boolean adPushSwitch;
        public long closeDelaySeconds;
        public int fullScreenSkipShowTime;
        public NativeAdInfo nativeAdInfo;
        public long playableCloseSeconds;
        public int rewardSkipConfirmSwitch;
        public boolean rewardVideoInteractSwitch;
        public boolean useNativeForOuterLiveAd;
        public AdShowVideoH5Info adShowVideoH5Info = new AdShowVideoH5Info();
        public int adPushIntervalTime = 900;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdInfo$AdTrackInfo.class */
    public static class AdTrackInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = 1185757456598461137L;
        public int type;
        public List<String> urls;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdInfo$AdvertiserInfo.class */
    public static class AdvertiserInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = 1779108296418044788L;
        public String adAuthorText;
        public String authorIconGuide;
        public String brief;
        public int fansCount;
        public boolean followed;
        public String portraitUrl;
        public String rawUserName;
        public String userGender;
        public long userId;
        public String userName;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdInfo$CallBackStrategyInfo.class */
    public static class CallBackStrategyInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public int callBackAdvanceMs;
        public int impressionCheckMs;
        public boolean rewardAdvanceSwitch;
        public boolean serverCheckSwitch;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdInfo$ComplianceInfo.class */
    public static class ComplianceInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = -6420581965656630668L;
        public int actionBarType;
        public int describeBarType;
        public int materialJumpType;
        public int titleBarTextSwitch;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdInfo$CutRuleInfo.class */
    public static class CutRuleInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = -6799794788698091368L;
        public int picHeight;
        public int safeAreaHeight;
        public int viewTopMargin;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdInfo$DownloadSafeInfo.class */
    public static class DownloadSafeInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = -1575212648797728242L;
        public String appName;
        public String appPermissionInfoUrl;
        public String appPrivacyUrl;
        public String appVersion;
        public String autoDownloadUrl;
        public ComplianceInfo complianceInfo;
        public String corporationName;
        public long packageSize;
        public String permissionInfo;
        public boolean secWindowPopNoWifiSwitch;
        public boolean secWindowPopSwitch;
        public String webPageTipbarText;
        public String windowPopUrl;
        public boolean downloadPauseEnable = false;
        public boolean webPageTipbarSwitch = false;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdInfo$FullScreenVideoInfo.class */
    public static class FullScreenVideoInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = -3671755605746105593L;
        public boolean fullScreenEndCardSwitch = false;
        public int showLandingPage;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdInfo$H5Config.class */
    public static class H5Config extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = -6055740830695990438L;
        public int apiAdTag;
        public int apiBreathLamp;
        public int apiMisTouch;
        public String tagTip;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdInfo$MaterialSize.class */
    public static class MaterialSize extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = 4007237406277888273L;
        public int height;
        public int width;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdInfo$NativeAdInfo.class */
    public static class NativeAdInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = -4576715577357334083L;
        public NativeAdShakeInfo shakeInfo;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdInfo$NativeAdShakeInfo.class */
    public static class NativeAdShakeInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = -2217767053432679267L;
        public int acceleration;
        public boolean enableShake;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdInfo$PlayableStyleInfo.class */
    public static class PlayableStyleInfo extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = -5205269652522127614L;
        public int playableOrientation;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdInfo$SmallAppJumpInfo.class */
    public static class SmallAppJumpInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = 6640822363058234999L;
        public String mediaSmallAppId;
        public String originId;
        public String smallAppJumpUrl;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdInfo$UnDownloadConf.class */
    public static class UnDownloadConf extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = 8376426919835310330L;
        public UnDownloadRegionConf unDownloadRegionConf;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdInfo$UnDownloadRegionConf.class */
    public static class UnDownloadRegionConf extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = -1060670053459154853L;
        public int actionBarType;
        public int describeBarType;
        public int materialJumpType;
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterParseJson(JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        this.downloadId = ad.eC(this.adConversionInfo.appDownloadUrl);
    }
}
