package com.kwad.components.offline.api.obiwan;

import android.content.Context;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.sdk.api.SdkConfig;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/obiwan/IObiwanOfflineCompo.class */
public interface IObiwanOfflineCompo extends IOfflineCompo {
    public static final String IMPL = "com.kwad.sdk.core.log.ObiwanOfflineCompoImpl";
    public static final String PACKAGE_NAME = "com.kwad.components.obiwan";

    IObiwanLogcat getLog();

    void initReal(Context context, SdkConfig sdkConfig, IObiwanOfflineCompoInitConfig iObiwanOfflineCompoInitConfig, InitCallBack initCallBack);

    void updateConfigs();
}
