package com.huawei.hms.ads.reward;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/reward/RewardAdStatusListener.class */
public abstract class RewardAdStatusListener {

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/reward/RewardAdStatusListener$ErrorCode.class */
    public interface ErrorCode {
        public static final int BACKGROUND = 3;
        public static final int INTERNAL = 0;
        public static final int NOT_LOADED = 2;
        public static final int REUSED = 1;
    }

    public void onRewardAdClosed() {
    }

    public void onRewardAdFailedToShow(int i) {
    }

    public void onRewardAdOpened() {
    }

    public void onRewarded(Reward reward) {
    }
}
