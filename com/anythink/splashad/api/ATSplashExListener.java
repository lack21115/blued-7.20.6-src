package com.anythink.splashad.api;

import android.content.Context;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATNetworkConfirmInfo;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/splashad/api/ATSplashExListener.class */
public interface ATSplashExListener extends ATSplashAdListener {
    void onDeeplinkCallback(ATAdInfo aTAdInfo, boolean z);

    void onDownloadConfirm(Context context, ATAdInfo aTAdInfo, ATNetworkConfirmInfo aTNetworkConfirmInfo);
}
