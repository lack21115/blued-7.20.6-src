package com.kwad.sdk.api;

import com.kwad.sdk.api.core.KsAdSdkApi;

@KsAdSdkApi
/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/KsInitCallback.class */
public interface KsInitCallback {
    void onFail(int i, String str);

    void onSuccess();
}
