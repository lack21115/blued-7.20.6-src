package com.anythink.rewardvideo.unitgroup.api;

import android.content.Context;
import com.anythink.core.api.ATNetworkConfirmInfo;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/rewardvideo/unitgroup/api/CustomRewardedVideoEventListener.class */
public interface CustomRewardedVideoEventListener {
    void onAgainReward();

    void onDeeplinkCallback(boolean z);

    void onDownloadConfirm(Context context, ATNetworkConfirmInfo aTNetworkConfirmInfo);

    void onReward();

    void onRewardedVideoAdAgainPlayClicked();

    void onRewardedVideoAdAgainPlayEnd();

    void onRewardedVideoAdAgainPlayFailed(String str, String str2);

    void onRewardedVideoAdAgainPlayStart();

    void onRewardedVideoAdClosed();

    void onRewardedVideoAdPlayClicked();

    void onRewardedVideoAdPlayEnd();

    void onRewardedVideoAdPlayFailed(String str, String str2);

    void onRewardedVideoAdPlayStart();
}
