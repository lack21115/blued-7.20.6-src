package com.anythink.banner.api;

import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.AdError;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/banner/api/ATBannerListener.class */
public interface ATBannerListener {
    void onBannerAutoRefreshFail(AdError adError);

    void onBannerAutoRefreshed(ATAdInfo aTAdInfo);

    void onBannerClicked(ATAdInfo aTAdInfo);

    void onBannerClose(ATAdInfo aTAdInfo);

    void onBannerFailed(AdError adError);

    void onBannerLoaded();

    void onBannerShow(ATAdInfo aTAdInfo);
}
