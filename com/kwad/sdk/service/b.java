package com.kwad.sdk.service;

import com.kwad.sdk.service.kwai.d;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/service/b.class */
public final class b {
    public static void gatherException(Throwable th) {
        d dVar = (d) ServiceProvider.get(d.class);
        if (dVar != null) {
            dVar.gatherException(th);
        }
    }
}
