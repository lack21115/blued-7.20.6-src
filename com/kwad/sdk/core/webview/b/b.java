package com.kwad.sdk.core.webview.b;

import com.huawei.openalliance.ad.constant.bc;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/webview/b/b.class */
public final class b implements com.kwad.sdk.core.b {
    public String aqe;
    public String aqf;
    public String data;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.aqe = jSONObject.optString("action");
        this.data = jSONObject.optString("data");
        this.aqf = jSONObject.optString(bc.e.D);
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "action", this.aqe);
        t.putValue(jSONObject, "data", this.data);
        t.putValue(jSONObject, bc.e.D, this.aqf);
        return jSONObject;
    }
}
