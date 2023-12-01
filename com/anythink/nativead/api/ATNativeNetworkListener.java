package com.anythink.nativead.api;

import com.anythink.core.api.AdError;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/nativead/api/ATNativeNetworkListener.class */
public interface ATNativeNetworkListener {
    void onNativeAdLoadFail(AdError adError);

    void onNativeAdLoaded();
}
