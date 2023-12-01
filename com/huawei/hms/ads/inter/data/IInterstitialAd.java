package com.huawei.hms.ads.inter.data;

import android.content.Context;
import com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener;
import com.huawei.hms.ads.reward.RewardAdListener;
import com.huawei.openalliance.ad.inter.data.e;
import com.huawei.openalliance.ad.inter.listeners.INonwifiActionListener;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/inter/data/IInterstitialAd.class */
public interface IInterstitialAd extends e {
    void setNonwifiActionListener(INonwifiActionListener iNonwifiActionListener);

    void setRewardAdListener(RewardAdListener rewardAdListener);

    void show(Context context, IInterstitialAdStatusListener iInterstitialAdStatusListener);
}
