package com.anythink.nativead.api;

import com.anythink.core.api.ATAdInfo;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/nativead/api/ATNativeEventExListener.class */
public interface ATNativeEventExListener extends ATNativeEventListener {
    void onDeeplinkCallback(ATNativeAdView aTNativeAdView, ATAdInfo aTAdInfo, boolean z);
}
