package com.anythink.rewardvideo.api;

import android.content.Context;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.AdError;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/rewardvideo/api/ATRewardVideoAutoEventListener.class */
public abstract class ATRewardVideoAutoEventListener {
    public void onAgainReward(ATAdInfo aTAdInfo) {
    }

    public void onDeeplinkCallback(ATAdInfo aTAdInfo, boolean z) {
    }

    public void onDownloadConfirm(Context context, ATAdInfo aTAdInfo, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
    }

    public abstract void onReward(ATAdInfo aTAdInfo);

    public void onRewardedVideoAdAgainPlayClicked(ATAdInfo aTAdInfo) {
    }

    public void onRewardedVideoAdAgainPlayEnd(ATAdInfo aTAdInfo) {
    }

    public void onRewardedVideoAdAgainPlayFailed(AdError adError, ATAdInfo aTAdInfo) {
    }

    public void onRewardedVideoAdAgainPlayStart(ATAdInfo aTAdInfo) {
    }

    public abstract void onRewardedVideoAdClosed(ATAdInfo aTAdInfo);

    public abstract void onRewardedVideoAdPlayClicked(ATAdInfo aTAdInfo);

    public abstract void onRewardedVideoAdPlayEnd(ATAdInfo aTAdInfo);

    public abstract void onRewardedVideoAdPlayFailed(AdError adError, ATAdInfo aTAdInfo);

    public abstract void onRewardedVideoAdPlayStart(ATAdInfo aTAdInfo);
}
