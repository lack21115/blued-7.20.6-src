package com.kwad.components.core.r;

import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/r/b.class */
public class b {
    private static volatile b PQ;

    private b() {
    }

    public static b pK() {
        if (PQ == null) {
            synchronized (b.class) {
                try {
                    if (PQ == null) {
                        PQ = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return PQ;
    }

    public final void a(final AdTemplate adTemplate, JSONObject jSONObject, com.kwad.sdk.core.report.i iVar) {
        if (((DevelopMangerComponents) com.kwad.sdk.components.c.f(DevelopMangerComponents.class)) != null) {
            com.kwad.sdk.core.d.b.d("AdEventHelper", "processAdImpress notImpression: false");
        }
        com.kwad.sdk.core.report.a.b(adTemplate, (JSONObject) null, iVar);
        com.kwad.sdk.utils.g.execute(new Runnable() { // from class: com.kwad.components.core.r.b.1
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.components.core.b.a lW = com.kwad.components.core.b.a.lW();
                if (lW != null) {
                    lW.m(com.kwad.sdk.core.response.a.d.cl(adTemplate));
                }
            }
        });
        com.kwad.components.core.b.f.mk().F(adTemplate);
    }
}
