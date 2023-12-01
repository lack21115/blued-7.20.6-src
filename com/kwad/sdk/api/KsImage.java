package com.kwad.sdk.api;

import com.kwad.sdk.api.core.KsAdSdkApi;

@KsAdSdkApi
/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/KsImage.class */
public interface KsImage {
    @KsAdSdkApi
    int getHeight();

    @KsAdSdkApi
    String getImageUrl();

    @KsAdSdkApi
    int getWidth();

    @KsAdSdkApi
    boolean isValid();
}
