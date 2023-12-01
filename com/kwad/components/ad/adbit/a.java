package com.kwad.components.ad.adbit;

import com.kwad.sdk.utils.t;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/adbit/a.class */
public final class a {
    public JSONObject bL;
    public Map<String, String> bM;

    public a(JSONObject jSONObject, Map<String, String> map) {
        this.bL = jSONObject;
        this.bM = map;
    }

    public final String ad() {
        for (String str : this.bM.keySet()) {
            t.putValue(this.bL, str, this.bM.get(str));
        }
        return this.bL.toString();
    }
}
