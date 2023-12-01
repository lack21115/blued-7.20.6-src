package com.anythink.interstitial.api;

import com.anythink.core.api.AdError;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/interstitial/api/ATInterstitialAutoLoadListener.class */
public interface ATInterstitialAutoLoadListener {
    void onInterstitialAutoLoadFail(String str, AdError adError);

    void onInterstitialAutoLoaded(String str);
}
