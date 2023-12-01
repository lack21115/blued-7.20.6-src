package com.anythink.nativead.api;

import com.anythink.core.api.ATAdInfo;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/nativead/api/ATNativeEventListener.class */
public interface ATNativeEventListener {
    void onAdClicked(ATNativeAdView aTNativeAdView, ATAdInfo aTAdInfo);

    void onAdImpressed(ATNativeAdView aTNativeAdView, ATAdInfo aTAdInfo);

    void onAdVideoEnd(ATNativeAdView aTNativeAdView);

    void onAdVideoProgress(ATNativeAdView aTNativeAdView, int i);

    void onAdVideoStart(ATNativeAdView aTNativeAdView);
}
