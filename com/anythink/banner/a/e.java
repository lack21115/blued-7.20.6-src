package com.anythink.banner.a;

import android.content.Context;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.core.api.ATNetworkConfirmInfo;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/banner/a/e.class */
public interface e {
    void onBannerClicked(CustomBannerAdapter customBannerAdapter);

    void onBannerClose(CustomBannerAdapter customBannerAdapter);

    void onBannerShow(CustomBannerAdapter customBannerAdapter, boolean z);

    void onDeeplinkCallback(CustomBannerAdapter customBannerAdapter, boolean z);

    void onDownloadConfirm(Context context, CustomBannerAdapter customBannerAdapter, ATNetworkConfirmInfo aTNetworkConfirmInfo);
}
