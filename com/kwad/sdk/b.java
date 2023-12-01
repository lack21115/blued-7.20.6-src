package com.kwad.sdk;

import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import java.util.Random;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/b.class */
public final class b {
    private static AdHttpProxy Yk;

    public static AdHttpProxy rZ() {
        AdHttpProxy adHttpProxy = Yk;
        if (adHttpProxy != null) {
            return adHttpProxy;
        }
        if (com.kwad.b.kwai.a.bI.booleanValue()) {
            return sa();
        }
        try {
            Yk = com.kwad.sdk.core.network.kwai.c.wk() != null ? new com.kwad.sdk.core.network.b.b() : new com.kwad.sdk.core.network.b.a();
        } catch (Throwable th) {
            Yk = new com.kwad.sdk.core.network.b.a();
        }
        return Yk;
    }

    private static AdHttpProxy sa() {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return new Random().nextInt(5) != 0 ? new com.kwad.sdk.core.network.b.b() : new com.kwad.sdk.core.network.b.a();
    }
}
