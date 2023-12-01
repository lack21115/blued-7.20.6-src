package com.anythink.splashad.a;

import android.content.Context;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.splashad.api.ATSplashAdExtraInfo;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/splashad/a/a.class */
public abstract class a {
    boolean mHasDismiss;

    public abstract void onAdClick(ATAdInfo aTAdInfo);

    public abstract void onAdDismiss(ATAdInfo aTAdInfo, ATSplashAdExtraInfo aTSplashAdExtraInfo);

    public abstract void onAdShow(ATAdInfo aTAdInfo);

    public void onCallbackAdDismiss(ATAdInfo aTAdInfo, ATSplashAdExtraInfo aTSplashAdExtraInfo) {
        if (this.mHasDismiss) {
            return;
        }
        this.mHasDismiss = true;
        onAdDismiss(aTAdInfo, aTSplashAdExtraInfo);
    }

    public abstract void onDeeplinkCallback(ATAdInfo aTAdInfo, boolean z);

    public abstract void onDownloadConfirm(Context context, ATAdInfo aTAdInfo, ATNetworkConfirmInfo aTNetworkConfirmInfo);
}
