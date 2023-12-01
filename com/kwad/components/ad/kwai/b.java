package com.kwad.components.ad.kwai;

import com.kwad.sdk.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.e;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/kwai/b.class */
public final class b extends com.kwad.sdk.core.network.b {
    public b(String str, List<String> list) {
        putBody("adxId", str);
        putBody("materialIds", new JSONArray((Collection) list));
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
        putBody("protocolVersion", "2.0");
        putBody("SDKVersion", "3.3.40");
        putBody("SDKVersionCode", 3034000);
        putBody("sdkApiVersion", ((e) ServiceProvider.get(e.class)).getApiVersion());
        putBody("sdkApiVersionCode", ((e) ServiceProvider.get(e.class)).getApiVersionCode());
        putBody("sdkType", 1);
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseHeader() {
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        return c.sf();
    }
}
