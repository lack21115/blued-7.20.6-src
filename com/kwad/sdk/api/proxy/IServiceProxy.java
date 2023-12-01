package com.kwad.sdk.api.proxy;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;

@KsAdSdkDynamicApi
/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/proxy/IServiceProxy.class */
public interface IServiceProxy extends IComponentProxy {
    @KsAdSdkDynamicApi
    IBinder onBind(Service service, Intent intent);

    @KsAdSdkDynamicApi
    void onCreate(Service service);

    @KsAdSdkDynamicApi
    void onDestroy(Service service);

    @KsAdSdkDynamicApi
    void onRebind(Service service, Intent intent);

    @KsAdSdkDynamicApi
    int onStartCommand(Service service, Intent intent, int i, int i2);

    boolean onUnbind(Service service, Intent intent);
}
