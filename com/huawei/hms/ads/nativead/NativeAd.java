package com.huawei.hms.ads.nativead;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.ads.AdFeedbackListener;
import com.huawei.hms.ads.AdvertiserInfo;
import com.huawei.hms.ads.Image;
import com.huawei.hms.ads.Video;
import com.huawei.hms.ads.VideoOperator;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import java.util.List;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/nativead/NativeAd.class */
public abstract class NativeAd {

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/nativead/NativeAd$ChoicesInfo.class */
    public static abstract class ChoicesInfo {
        public abstract String getContent();

        public abstract List<Image> getIcons();
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/nativead/NativeAd$NativeAdLoadedListener.class */
    public interface NativeAdLoadedListener {
        void onNativeAdLoaded(NativeAd nativeAd);
    }

    public abstract void destroy();

    public abstract void dislikeAd(DislikeAdReason dislikeAdReason);

    public abstract String getAbilityDetailInfo();

    public abstract String getAdSign();

    public abstract String getAdSource();

    public abstract List<AdvertiserInfo> getAdvertiserInfo();

    public abstract String getCallToAction();

    public abstract ChoicesInfo getChoicesInfo();

    public abstract int getCreativeType();

    public abstract String getDescription();

    public abstract List<DislikeAdReason> getDislikeAdReasons();

    public abstract String getDspLogo();

    public abstract String getDspName();

    public abstract Map<String, String> getExt();

    public abstract Bundle getExtraBundle();

    public abstract String getHwChannelId();

    public abstract Image getIcon();

    public abstract List<Image> getImages();

    public abstract String getMarket();

    public abstract MediaContent getMediaContent();

    public abstract String getPrice();

    public abstract Double getRating();

    public abstract String getTitle();

    public abstract String getUniqueId();

    public abstract Video getVideo();

    public abstract VideoOperator getVideoOperator();

    public abstract String getWhyThisAd();

    public abstract void gotoWhyThisAdPage(Context context);

    public abstract boolean hasAdvertiserInfo();

    public abstract boolean isAutoDownloadApp();

    public abstract boolean isCustomClickAllowed();

    public abstract boolean isCustomDislikeThisAdEnabled();

    public abstract void onAdClose(Context context, List<String> list);

    public abstract void recordClickEvent();

    public abstract boolean recordClickEvent(Bundle bundle);

    public abstract boolean recordImpressionEvent(Bundle bundle);

    public abstract boolean recordShowStartEvent(Bundle bundle);

    public abstract void recordTouchEvent(Bundle bundle);

    public abstract void setAdFeedbackListener(AdFeedbackListener adFeedbackListener);

    public abstract void setAllowCustomClick();

    public abstract void setAutoDownloadApp(boolean z);

    public abstract void setDislikeAdListener(DislikeAdListener dislikeAdListener);

    public abstract void setRewardVerifyConfig(RewardVerifyConfig rewardVerifyConfig);

    public abstract void triggerClick(Bundle bundle);
}
