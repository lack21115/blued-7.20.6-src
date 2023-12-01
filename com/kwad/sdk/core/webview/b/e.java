package com.kwad.sdk.core.webview.b;

import com.kwad.sdk.utils.t;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/webview/b/e.class */
public final class e implements com.kwad.sdk.core.b {
    private final String ZN;
    private final int result;

    public e(int i, String str) {
        this.result = i;
        this.ZN = str;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "result", this.result);
        t.putValue(jSONObject, "error_msg", this.ZN);
        return jSONObject;
    }
}
