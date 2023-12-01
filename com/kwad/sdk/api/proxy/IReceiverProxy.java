package com.kwad.sdk.api.proxy;

import android.content.Context;
import android.content.Intent;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;

@KsAdSdkDynamicApi
/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/proxy/IReceiverProxy.class */
public interface IReceiverProxy extends IComponentProxy {
    @KsAdSdkDynamicApi
    void onReceive(Context context, Intent intent);
}
