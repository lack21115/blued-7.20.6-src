package com.huawei.hms.ads.reward;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/reward/RewardAdListener.class */
public interface RewardAdListener {
    void onRewardAdClosed();

    void onRewardAdCompleted();

    void onRewardAdFailedToLoad(int i);

    void onRewardAdLeftApp();

    void onRewardAdLoaded();

    void onRewardAdOpened();

    void onRewardAdStarted();

    void onRewarded(Reward reward);
}
