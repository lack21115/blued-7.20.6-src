package com.kwad.sdk.core.report;

import java.util.List;
import org.json.JSONArray;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/report/g.class */
public final class g extends com.kwad.sdk.core.network.d {
    public g(List<q> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (q qVar : list) {
            com.kwad.sdk.utils.t.putValue(jSONArray, qVar.buildReportData());
        }
        putBody("actionList", jSONArray);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        return com.kwad.sdk.c.sg();
    }
}
