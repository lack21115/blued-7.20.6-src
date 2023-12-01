package com.kwad.sdk.core.network;

import android.util.Log;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.request.model.StatusInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/network/d.class */
public abstract class d extends b {
    public static final String TRACK_ID_KEY = "kuaishou-tracing-token";
    private static int sLiveSupportMode;

    public d() {
        this(0, null);
    }

    public d(int i, SceneImpl sceneImpl) {
        putBody("deviceInfo", com.kwad.sdk.core.request.model.b.g(needAppList(), i));
        putBody("statusInfo", StatusInfo.b(sceneImpl));
    }

    @Override // com.kwad.sdk.core.network.b
    protected void buildBaseBody() {
        putBody("protocolVersion", "2.0");
        putBody("SDKVersion", "3.3.40");
        putBody("SDKVersionCode", 3034000);
        putBody("sdkApiVersion", ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getApiVersion());
        putBody("sdkApiVersionCode", ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getApiVersionCode());
        putBody("sdkType", 1);
        putBody("appInfo", com.kwad.sdk.core.request.model.a.xo());
        putBody("tkVersion", "5.0.1");
        putBody("networkInfo", com.kwad.sdk.core.request.model.d.xs());
        if (sLiveSupportMode == 0 && ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).hasLiveCompoReady()) {
            sLiveSupportMode = 1;
        }
        Log.d("CommonBaseRequest", "sLiveSupportMode :" + sLiveSupportMode);
        putBody("liveSupportMode", sLiveSupportMode);
        putBody("geoInfo", com.kwad.sdk.core.request.model.c.xr());
        putBody("ext", com.kwad.sdk.core.request.model.e.xu());
        putBody("userInfo", com.kwad.sdk.core.request.model.g.xv());
        putBody("requestSessionData", r.wi().ce(getUrl()));
    }

    @Override // com.kwad.sdk.core.network.b
    protected void buildBaseHeader() {
        String url = getUrl();
        if (!com.kwad.b.kwai.a.bI.booleanValue() || url == null || url.contains(com.kwad.sdk.c.sg())) {
            return;
        }
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        addHeader("trace-context", "{\"laneId\":\"STAGING.online.u\"}");
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
    }

    protected boolean needAppList() {
        return false;
    }
}
