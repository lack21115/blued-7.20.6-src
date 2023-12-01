package com.kwad.sdk.core.kwai;

import com.kwad.sdk.components.DevelopMangerComponents;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/kwai/d.class */
public final class d {
    private static f afM;

    public static void a(String str, Map<String, String> map, String str2) {
        nw().a(str, map, str2);
    }

    public static String bV(String str) {
        return nw().bV(str);
    }

    public static void d(Map<String, String> map) {
        nw().d(map);
    }

    public static String getResponseData(String str) {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return nw().getResponseData(str);
    }

    private static f nw() {
        a aVar;
        f fVar = afM;
        if (fVar != null) {
            return fVar;
        }
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        com.kwad.sdk.components.f fVar2 = (com.kwad.sdk.components.f) com.kwad.sdk.components.c.f(com.kwad.sdk.components.f.class);
        if (fVar2 != null) {
            fVar2.nw();
            aVar = fVar2.nw();
        } else {
            aVar = new a();
        }
        afM = aVar;
        return afM;
    }
}
