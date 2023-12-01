package com.kwad.sdk.api.core;

import android.graphics.Bitmap;
import android.widget.RemoteViews;

@KsAdSdkDynamicApi
/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/core/IProgressRemoteView.class */
public interface IProgressRemoteView {
    @KsAdSdkDynamicApi
    RemoteViews build();

    @KsAdSdkDynamicApi
    void setControlBtnPaused(boolean z);

    @KsAdSdkDynamicApi
    void setIcon(int i);

    @KsAdSdkDynamicApi
    void setIcon(Bitmap bitmap);

    @KsAdSdkDynamicApi
    void setName(String str);

    @KsAdSdkDynamicApi
    void setPercentNum(String str);

    @KsAdSdkDynamicApi
    void setProgress(int i, int i2, boolean z);

    @KsAdSdkDynamicApi
    void setSize(String str);

    @KsAdSdkDynamicApi
    void setStatus(String str);
}
