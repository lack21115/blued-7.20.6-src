package com.kwad.components.core.n;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.t;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/n/d.class */
public final class d extends com.kwad.sdk.core.network.d {
    public long Om;

    public d(int i, AdTemplate adTemplate) {
        String bD = com.kwad.sdk.core.response.a.a.bD(com.kwad.sdk.core.response.a.d.cb(adTemplate));
        try {
            if (!TextUtils.isEmpty(bD) && bD != null) {
                JSONObject jSONObject = new JSONObject(bD);
                t.putValue(jSONObject, "checkType", i);
                putBody("callbackUrlInfo", jSONObject.toString());
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTrace(e);
        }
        com.kwad.components.core.n.kwai.b bVar = new com.kwad.components.core.n.kwai.b(adTemplate.mAdScene);
        JSONArray jSONArray = new JSONArray();
        t.putValue(jSONArray, bVar.toJson());
        putBody("impInfo", jSONArray);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        return com.kwad.sdk.c.sm();
    }
}
