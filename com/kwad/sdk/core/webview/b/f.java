package com.kwad.sdk.core.webview.b;

import com.kwad.sdk.utils.t;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/webview/b/f.class */
public final class f implements com.kwad.sdk.core.b {
    public final com.kwad.sdk.core.b aqg;
    public final int result = 1;

    public f(com.kwad.sdk.core.b bVar) {
        this.aqg = bVar;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "result", this.result);
        t.a(jSONObject, "data", this.aqg);
        return jSONObject;
    }
}
