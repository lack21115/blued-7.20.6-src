package com.huawei.hms.ads.banner;

import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.BannerAdSize;
import com.huawei.hms.ads.reward.RewardVerifyConfig;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/banner/IBannerView.class */
public interface IBannerView {
    void destroy();

    String getAdId();

    AdListener getAdListener();

    BannerAdSize getBannerAdSize();

    boolean isLoading();

    void loadAd(AdParam adParam);

    void pause();

    void resume();

    void setAdId(String str);

    void setAdListener(AdListener adListener);

    void setBannerAdSize(BannerAdSize bannerAdSize);

    void setBannerRefresh(long j);

    void setContentBundle(String str);

    void setRewardVerifyConfig(RewardVerifyConfig rewardVerifyConfig);
}
