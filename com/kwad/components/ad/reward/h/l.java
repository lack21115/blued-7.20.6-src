package com.kwad.components.ad.reward.h;

import com.kwad.components.core.webview.a.kwai.v;
import com.kwad.components.core.webview.jshandler.v;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/h/l.class */
public final class l extends v {
    public final void d(List<AdTemplate> list) {
        b(new v.a(list));
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "registerAggregationDataListener";
    }
}
