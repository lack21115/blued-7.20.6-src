package com.huawei.hms.ads.instreamad;

import com.huawei.hms.ads.AdvertiserInfo;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/instreamad/InstreamAd.class */
public abstract class InstreamAd {
    public abstract String getAdSign();

    public abstract String getAdSource();

    public abstract List<AdvertiserInfo> getAdvertiserInfo();

    public abstract String getCallToAction();

    public abstract String getDspLogo();

    public abstract String getDspName();

    public abstract long getDuration();

    public abstract String getWhyThisAd();

    public abstract boolean hasAdvertiserInfo();

    public abstract boolean isClicked();

    public abstract boolean isExpired();

    public abstract boolean isImageAd();

    public abstract boolean isShown();

    public abstract boolean isVideoAd();

    public abstract void setRewardVerifyConfig(RewardVerifyConfig rewardVerifyConfig);
}
