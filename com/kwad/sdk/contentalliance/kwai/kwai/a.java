package com.kwad.sdk.contentalliance.kwai.kwai;

import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.l;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/contentalliance/kwai/kwai/a.class */
public final class a {
    public long adStyle;
    public long clickTime;
    public int contentType;
    public long photoId;

    public a() {
        this.clickTime = -1L;
    }

    public a(AdTemplate adTemplate, long j) {
        this.clickTime = -1L;
        this.photoId = d.ch(adTemplate);
        this.clickTime = j;
        this.adStyle = d.bW(adTemplate);
        this.contentType = d.bX(adTemplate);
    }

    public static a ak(AdTemplate adTemplate) {
        return new a(adTemplate, l.cx(adTemplate));
    }

    public final String tQ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("contentType", this.contentType);
            jSONObject.put("adStyle", this.adStyle);
        } catch (JSONException e) {
            com.kwad.sdk.core.d.b.printStackTrace(e);
        }
        return jSONObject.toString();
    }
}
