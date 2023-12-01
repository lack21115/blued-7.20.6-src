package com.kwad.components.core.g;

import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/g/c.class */
public final class c {
    private Object JF;
    private AdTemplate JG;

    public c(AdTemplate adTemplate, int i) {
        this.JF = null;
        try {
            this.JF = new b(adTemplate, i);
        } catch (Throwable th) {
            this.JG = adTemplate;
        }
    }

    public static List<AdTemplate> i(List<c> list) {
        ArrayList arrayList = new ArrayList();
        for (c cVar : list) {
            arrayList.add(cVar.getAdTemplate());
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.kwad.sdk.core.response.model.AdTemplate getAdTemplate() {
        /*
            r2 = this;
            r0 = r2
            java.lang.Object r0 = r0.JF
            r3 = r0
            r0 = r3
            if (r0 == 0) goto L14
            r0 = r3
            com.kwad.components.core.g.b r0 = (com.kwad.components.core.g.b) r0     // Catch: java.lang.Exception -> L23
            com.kwad.sdk.core.response.model.AdTemplate r0 = r0.getAdTemplate()     // Catch: java.lang.Exception -> L23
            r3 = r0
            goto L16
        L14:
            r0 = 0
            r3 = r0
        L16:
            r0 = r3
            r4 = r0
            r0 = r3
            if (r0 != 0) goto L21
            r0 = r2
            com.kwad.sdk.core.response.model.AdTemplate r0 = r0.JG
            r4 = r0
        L21:
            r0 = r4
            return r0
        L23:
            r3 = move-exception
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.g.c.getAdTemplate():com.kwad.sdk.core.response.model.AdTemplate");
    }

    public final Object getHost() {
        return this.JF;
    }
}
