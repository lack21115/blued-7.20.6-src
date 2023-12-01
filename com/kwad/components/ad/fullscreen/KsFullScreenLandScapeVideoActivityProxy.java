package com.kwad.components.ad.fullscreen;

import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.KsFullScreenLandScapeVideoActivity;

@KsAdSdkDynamicImpl(KsFullScreenLandScapeVideoActivity.class)
/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/fullscreen/KsFullScreenLandScapeVideoActivityProxy.class */
public class KsFullScreenLandScapeVideoActivityProxy extends KsFullScreenVideoActivityProxy {
    public static void register() {
        com.kwad.sdk.service.a.a(KsFullScreenLandScapeVideoActivity.class, KsFullScreenLandScapeVideoActivityProxy.class);
    }
}
