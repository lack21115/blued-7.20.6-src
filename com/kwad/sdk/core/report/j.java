package com.kwad.sdk.core.report;

import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/report/j.class */
public class j extends com.kwad.sdk.core.response.kwai.a {
    public int aiq;
    public long creativeId;
    public long llsid;
    public int score;
    public String source = "union";

    public static j aE(AdTemplate adTemplate) {
        j jVar = new j();
        jVar.creativeId = com.kwad.sdk.core.response.a.d.cl(adTemplate);
        jVar.llsid = com.kwad.sdk.core.response.a.d.bY(adTemplate);
        int cq = com.kwad.sdk.core.response.a.d.cq(adTemplate);
        jVar.score = cq;
        jVar.aiq = cq > 0 ? 1 : 0;
        return jVar;
    }

    public final String wZ() {
        return toJson().toString();
    }
}
