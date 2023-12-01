package com.kwad.sdk.core.webview.request;

import com.kwad.sdk.c;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.core.network.q;
import com.kwad.sdk.utils.t;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/webview/request/a.class */
public class a extends d {
    private String aqr;
    private String mUrl;

    public a(String str, String str2, String str3) {
        JSONObject jSONObject;
        this.mUrl = str;
        this.aqr = str2;
        try {
            jSONObject = new JSONObject(str3);
        } catch (JSONException e) {
            com.kwad.sdk.core.d.b.printStackTrace(e);
            jSONObject = null;
        }
        com.kwad.sdk.core.d.b.d("WebCardGetDataRequest", "mBodyParams1 size=" + this.mBodyParams.length());
        if (jSONObject != null) {
            com.kwad.sdk.core.d.b.d("WebCardGetDataRequest", "paramsJsonObj=" + jSONObject.toString());
        }
        t.merge(this.mBodyParams, jSONObject);
        com.kwad.sdk.core.d.b.d("WebCardGetDataRequest", "mBodyParams2 size=" + this.mBodyParams.length());
        addHeader("user-agent", q.getUserAgent());
        com.kwad.sdk.core.d.b.d("WebCardGetDataRequest", "user-agent" + q.getUserAgent());
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String getUrl() {
        return c.sb() + this.mUrl;
    }
}
