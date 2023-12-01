package com.kwad.sdk.api.proxy.app;

import android.content.Context;
import com.kwad.sdk.api.loader.Loader;
import com.kwad.sdk.api.proxy.BaseProxyActivity;
import com.kwad.sdk.api.proxy.IActivityProxy;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/proxy/app/KsFullScreenVideoActivity.class */
public class KsFullScreenVideoActivity extends BaseProxyActivity {
    @Override // com.kwad.sdk.api.proxy.BaseProxyActivity
    public IActivityProxy getDelegate(Context context) {
        return (IActivityProxy) Loader.get().newComponentProxy(context, KsFullScreenVideoActivity.class, this);
    }
}
