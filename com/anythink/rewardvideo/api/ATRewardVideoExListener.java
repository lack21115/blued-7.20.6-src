package com.anythink.rewardvideo.api;

import android.content.Context;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.AdError;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/rewardvideo/api/ATRewardVideoExListener.class */
public interface ATRewardVideoExListener extends ATRewardVideoListener {
    void onAgainReward(ATAdInfo aTAdInfo);

    void onDeeplinkCallback(ATAdInfo aTAdInfo, boolean z);

    void onDownloadConfirm(Context context, ATAdInfo aTAdInfo, ATNetworkConfirmInfo aTNetworkConfirmInfo);

    void onRewardedVideoAdAgainPlayClicked(ATAdInfo aTAdInfo);

    void onRewardedVideoAdAgainPlayEnd(ATAdInfo aTAdInfo);

    void onRewardedVideoAdAgainPlayFailed(AdError adError, ATAdInfo aTAdInfo);

    void onRewardedVideoAdAgainPlayStart(ATAdInfo aTAdInfo);
}
