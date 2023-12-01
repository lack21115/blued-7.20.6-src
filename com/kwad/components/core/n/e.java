package com.kwad.components.core.n;

import com.kwad.sdk.utils.t;
import com.kwad.sdk.utils.y;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/n/e.class */
public final class e extends com.kwad.sdk.core.network.d {
    public e() {
        JSONArray jSONArray = new JSONArray();
        t.putValue(jSONArray, new JSONObject());
        putBody("impInfo", jSONArray);
        putBody("appTag", y.Dv());
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        return com.kwad.sdk.c.sh();
    }
}
