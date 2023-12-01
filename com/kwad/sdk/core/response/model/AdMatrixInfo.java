package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdMatrixInfo.class */
public class AdMatrixInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    private static final long serialVersionUID = -1399297421861223421L;
    public Styles styles = new Styles();
    public AdDataV2 adDataV2 = new AdDataV2();
    public List<MatrixTag> tag = new ArrayList();

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdMatrixInfo$ActionBarInfoNew.class */
    public static class ActionBarInfoNew extends BaseMatrixTemplate {
        private static final long serialVersionUID = -2897900789505229105L;
        public int cardType;
        public long maxTimeOut;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdMatrixInfo$ActivityMiddlePageInfo.class */
    public static class ActivityMiddlePageInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = -7126817779477974119L;
        public boolean showHeaderBar;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdMatrixInfo$AdDataV2.class */
    public static class AdDataV2 extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = -8017805390945915342L;
        public List<TemplateData> templateDataList = new ArrayList();
        public BottomBannerInfo bottomBannerInfo = new BottomBannerInfo();
        public ActionBarInfoNew actionBarInfo = new ActionBarInfoNew();
        public AggregationCardInfo aggregationCardInfo = new AggregationCardInfo();
        public BaseMatrixTemplate halfCardInfo = new BaseMatrixTemplate();
        public EndCardInfo endCardInfo = new EndCardInfo();
        public InterstitialCardInfo interstitialCardInfo = new InterstitialCardInfo();
        public FeedInfo feedInfo = new FeedInfo();
        public FeedInfo adUnionFeedLiveMediaInfo = new FeedInfo();
        public FeedInfo adUnionFeedLiveTemplateInfo = new FeedInfo();
        public BaseMatrixTemplate complianceCardInfo = new BaseMatrixTemplate();
        public BaseMatrixTemplate downloadConfirmCardInfo = new BaseMatrixTemplate();
        public SplashInfo splashInfo = new SplashInfo();
        public NeoVideoInfo neoVideoInfo = new NeoVideoInfo();
        public FullScreenInfo fullScreenInfo = new FullScreenInfo();
        public BaseMatrixTemplate middleTKCardInfo = new BaseMatrixTemplate();
        public BaseMatrixTemplate actionBarTKInfo = new BaseMatrixTemplate();
        public BaseMatrixTemplate topBarTKInfo = new BaseMatrixTemplate();
        public SplashPlayCardTKInfo splashPlayCardTKInfo = new SplashPlayCardTKInfo();
        public SplashEndCardTKInfo splashEndCardTKInfo = new SplashEndCardTKInfo();
        public TopFloorTKInfo topFloorTKInfo = new TopFloorTKInfo();
        public ActivityMiddlePageInfo activityMiddlePageInfo = new ActivityMiddlePageInfo();
        public BaseMatrixTemplate confirmTKInfo = new BaseMatrixTemplate();
        public BaseMatrixTemplate playendTKInfo = new BaseMatrixTemplate();
        public BaseMatrixTemplate activityTKInfo = new BaseMatrixTemplate();
        public BaseMatrixTemplate neoTKInfo = new BaseMatrixTemplate();
        public BaseMatrixTemplate rewardWatchOnceInfo = new BaseMatrixTemplate();
        public RewardVideoInteractInfo rewardVideoInteractInfo = new RewardVideoInteractInfo();
        public RewardVideoTaskInfo rewardVideoTaskInfo = new RewardVideoTaskInfo();
        public RewardWebTaskCloseInfo mRewardWebTaskCloseInfo = new RewardWebTaskCloseInfo();
        public MerchantLiveReservationInfo merchantLiveReservationInfo = new MerchantLiveReservationInfo();
        public PushTKInfo pushTKInfo = new PushTKInfo();
        public BaseMatrixTemplate splashActionBarInfo = new BaseMatrixTemplate();
        public BaseMatrixTemplate videoLiveTKInfo = new BaseMatrixTemplate();
        public PreLandingPageTKInfo preLandingPageTKInfo = new PreLandingPageTKInfo();
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdMatrixInfo$AdInteractionInfo.class */
    public static class AdInteractionInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = -8105791433429537031L;
        public int interactiveStyle;
        public int interactivityDefaultStyle;
        public boolean isMediaDisable;
        public long switchDefaultTime;
        public long tkDefaultTimeout;
        public ShakeInfo shakeInfo = new ShakeInfo();
        public RotateInfo rotateInfo = new RotateInfo();
        public SplashSlideInfo slideInfo = new SplashSlideInfo();
        public SplashActionBarInfo splashActionBarInfo = new SplashActionBarInfo();
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdMatrixInfo$AggregationCardInfo.class */
    public static class AggregationCardInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = 6065340139053228242L;
        public int changeTime;
        public long intervalTime;
        public int maxTimesPerDay;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdMatrixInfo$BaseMatrixTemplate.class */
    public static class BaseMatrixTemplate extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = 3594661163877934414L;
        public int renderType;
        public String templateId;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdMatrixInfo$BottomBannerInfo.class */
    public static class BottomBannerInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = 9099955467009566699L;
        public int bannerAdType;
        public int bannerSizeType;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdMatrixInfo$CycleAggregateInfo.class */
    public static class CycleAggregateInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = 3365726199254620321L;
        public String convertIconUrl;
        public String cutIconUrl;
        public String refreshIconUrl;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdMatrixInfo$DownloadTexts.class */
    public static class DownloadTexts extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = -2293710579116352440L;
        public String adActionDescription;
        public String installAppLabel;
        public String openAppLabel;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdMatrixInfo$EndCardInfo.class */
    public static class EndCardInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = -1534468715847534303L;
        public int cardShowPlayCount;
        public int cardType;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdMatrixInfo$FeedInfo.class */
    public static class FeedInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = -299328228771513399L;
        public AdInteractionInfo interactionInfo = new AdInteractionInfo();
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdMatrixInfo$FullScreenInfo.class */
    public static class FullScreenInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = 6260475900625987915L;
        public AdInteractionInfo interactionInfo = new AdInteractionInfo();
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdMatrixInfo$InterstitialCardInfo.class */
    public static class InterstitialCardInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = -5881505827627373593L;
        public AdInteractionInfo interactionInfo = new AdInteractionInfo();
        public CycleAggregateInfo cycleAggregateInfo = new CycleAggregateInfo();
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdMatrixInfo$MatrixTag.class */
    public static class MatrixTag extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public boolean isHide;
        public int styleId;
        public String type;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdMatrixInfo$MatrixTemplate.class */
    public static class MatrixTemplate extends BaseMatrixTemplate {
        private static final long serialVersionUID = 1943039524913069727L;
        public String templateMd5;
        public String templateUrl;
        public String templateVersion;
        public long templateVersionCode;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdMatrixInfo$MerchantLiveReservationInfo.class */
    public static class MerchantLiveReservationInfo extends BaseMatrixTemplate implements Serializable {
        private static final int MIN_COUNT = 50;
        private static final long serialVersionUID = -6879010521415024815L;
        public int bookUserCount;
        public List<String> bookUserUrlList;
        public boolean displayBookCount;
        public boolean displayWeakCard;
        public String liveStartTime;
        public LiveReservationPlayEndInfo playEndCard;
        public String title;
        public String userHeadUrl;

        /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdMatrixInfo$MerchantLiveReservationInfo$LiveReservationPlayEndInfo.class */
        public static class LiveReservationPlayEndInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
            private static final long serialVersionUID = 1682477964084325954L;
            public String detailBtnTitle = "查看详情";
            public String reservationBtnTitle = "立即预约";
        }

        public String getFormattedLiveSubscribeCount() {
            int i = this.bookUserCount;
            if (i < 50) {
                return null;
            }
            if (i < 10000) {
                return this.bookUserCount + "人";
            }
            DecimalFormat decimalFormat = new DecimalFormat("#.#");
            float f = this.bookUserCount / 10000.0f;
            return decimalFormat.format(f) + "万人";
        }

        public boolean isEmpty() {
            return TextUtils.isEmpty(this.title) && TextUtils.isEmpty(this.liveStartTime) && TextUtils.isEmpty(this.userHeadUrl);
        }

        public boolean needShowSubscriberCount() {
            return this.displayBookCount && this.bookUserCount >= 50;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdMatrixInfo$NeoVideoInfo.class */
    public static class NeoVideoInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = 6260475900625987915L;
        public AdInteractionInfo interactionInfo = new AdInteractionInfo();
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdMatrixInfo$PreLandingPageTKInfo.class */
    public static class PreLandingPageTKInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = -6610860492486529913L;
        public int preLandingPageShowType = 1;

        public boolean isPlayEndShow() {
            int i = this.preLandingPageShowType;
            return i == 2 || i == 1;
        }

        public boolean isSkipShow() {
            int i = this.preLandingPageShowType;
            return i == 3 || i == 1;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdMatrixInfo$PushTKInfo.class */
    public static class PushTKInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = -1907990715102735992L;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdMatrixInfo$RewardVideoInteractInfo.class */
    public static class RewardVideoInteractInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = 8875349394489272055L;
        public int dayMaxLimit;
        public int duration;
        public String errorMsg;
        public int intervalShow;
        public int rewardTime;
        public int showTime;
        public int style;
        public StyleInfo styleInfo = new StyleInfo();
        public String successfulMsg;
        public String templateId;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdMatrixInfo$RewardVideoTaskInfo.class */
    public static class RewardVideoTaskInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = 2487245975856269581L;
        public int duration;
        public int showTime;
        public int taskType;
        public String templateId;
        public int thresholdTime;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdMatrixInfo$RewardWebTaskCloseInfo.class */
    public static class RewardWebTaskCloseInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = -2697443981301300766L;
        public String templateId;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdMatrixInfo$RotateDegreeInfo.class */
    public static class RotateDegreeInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = -479509878557048331L;
        public int direction;
        public int rotateDegree;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdMatrixInfo$RotateInfo.class */
    public static class RotateInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = -237926423883960071L;
        public String subTitle;
        public String title;
        public DownloadTexts downloadTexts = new DownloadTexts();
        public RotateDegreeInfo x = new RotateDegreeInfo();
        public RotateDegreeInfo y = new RotateDegreeInfo();
        public RotateDegreeInfo z = new RotateDegreeInfo();
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdMatrixInfo$ShakeInfo.class */
    public static class ShakeInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = 4528782399998808588L;
        public int acceleration;
        public boolean clickDisabled;
        public int componentIndex;
        public String subtitle;
        public String title;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdMatrixInfo$SplashActionBarInfo.class */
    public static class SplashActionBarInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = -2897900789505229105L;
        public DownloadTexts downloadTexts = new DownloadTexts();
        public String title;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdMatrixInfo$SplashEndCardTKInfo.class */
    public static class SplashEndCardTKInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = 3536091976265473949L;
        public int endCardCountDaily;
        public boolean endCardFullScreenClick;
        public boolean endCardShowCountDown;
        public int endCardShowSecond;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdMatrixInfo$SplashInfo.class */
    public static class SplashInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = 240426032769377332L;
        public AdInteractionInfo interactionInfo = new AdInteractionInfo();
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdMatrixInfo$SplashPlayCardTKInfo.class */
    public static class SplashPlayCardTKInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = 2182484890680464601L;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdMatrixInfo$SplashSlideInfo.class */
    public static class SplashSlideInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = -5771966197460897593L;
        public int convertDistance;
        public DownloadTexts downloadTexts = new DownloadTexts();
        public int style;
        public String subtitle;
        public String title;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdMatrixInfo$StyleInfo.class */
    public static class StyleInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = 7597936730431611526L;
        public String title;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdMatrixInfo$Styles.class */
    public static class Styles extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = 1713930699658485883L;
        public List<MatrixTemplate> templateList = new ArrayList();
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdMatrixInfo$TemplateData.class */
    public static class TemplateData extends BaseMatrixTemplate {
        private static final long serialVersionUID = -3330357033837521996L;
        public String data;
        public long templateDelayTime;
        public long templateShowTime;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/AdMatrixInfo$TopFloorTKInfo.class */
    public static class TopFloorTKInfo extends BaseMatrixTemplate {
        private static final long serialVersionUID = 341571719184500541L;
    }
}
