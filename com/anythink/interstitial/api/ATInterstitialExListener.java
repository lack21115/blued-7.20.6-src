package com.anythink.interstitial.api;

import android.content.Context;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATNetworkConfirmInfo;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/interstitial/api/ATInterstitialExListener.class */
public interface ATInterstitialExListener extends ATInterstitialListener {
    void onDeeplinkCallback(ATAdInfo aTAdInfo, boolean z);

    void onDownloadConfirm(Context context, ATAdInfo aTAdInfo, ATNetworkConfirmInfo aTNetworkConfirmInfo);
}
