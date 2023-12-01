package com.kwad.sdk.core.network.a;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.f;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/network/a/c.class */
public final class c {
    public static b wy() {
        f fVar = (f) ServiceProvider.get(f.class);
        return (fVar == null || !fVar.sG()) ? new a() : new d();
    }
}
