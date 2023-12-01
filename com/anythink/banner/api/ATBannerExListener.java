package com.anythink.banner.api;

import android.content.Context;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATNetworkConfirmInfo;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/banner/api/ATBannerExListener.class */
public interface ATBannerExListener extends ATBannerListener {
    void onDeeplinkCallback(boolean z, ATAdInfo aTAdInfo, boolean z2);

    void onDownloadConfirm(Context context, ATAdInfo aTAdInfo, ATNetworkConfirmInfo aTNetworkConfirmInfo);
}
