package com.anythink.rewardvideo.api;

import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.AdError;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/rewardvideo/api/ATRewardVideoListener.class */
public interface ATRewardVideoListener {
    void onReward(ATAdInfo aTAdInfo);

    void onRewardedVideoAdClosed(ATAdInfo aTAdInfo);

    void onRewardedVideoAdFailed(AdError adError);

    void onRewardedVideoAdLoaded();

    void onRewardedVideoAdPlayClicked(ATAdInfo aTAdInfo);

    void onRewardedVideoAdPlayEnd(ATAdInfo aTAdInfo);

    void onRewardedVideoAdPlayFailed(AdError adError, ATAdInfo aTAdInfo);

    void onRewardedVideoAdPlayStart(ATAdInfo aTAdInfo);
}
