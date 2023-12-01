package com.anythink.splashad.api;

import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.AdError;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/splashad/api/ATSplashAdListener.class */
public interface ATSplashAdListener {
    void onAdClick(ATAdInfo aTAdInfo);

    void onAdDismiss(ATAdInfo aTAdInfo, ATSplashAdExtraInfo aTSplashAdExtraInfo);

    void onAdLoadTimeout();

    void onAdLoaded(boolean z);

    void onAdShow(ATAdInfo aTAdInfo);

    void onNoAdError(AdError adError);
}
