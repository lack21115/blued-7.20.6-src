package com.kwad.components.ad.reward;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.t;
import org.json.JSONArray;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/i.class */
public final class i extends com.kwad.sdk.core.network.d {
    public i(AdTemplate adTemplate) {
        putBody("callbackUrlInfo", com.kwad.sdk.core.response.a.a.bD(com.kwad.sdk.core.response.a.d.cb(adTemplate)));
        com.kwad.components.core.n.kwai.b bVar = new com.kwad.components.core.n.kwai.b(adTemplate.mAdScene);
        JSONArray jSONArray = new JSONArray();
        t.putValue(jSONArray, bVar.toJson());
        putBody("impInfo", jSONArray);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        return com.kwad.sdk.c.si();
    }
}
