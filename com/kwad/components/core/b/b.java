package com.kwad.components.core.b;

import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.utils.v;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/b/b.class */
public final class b {
    private static void ai(String str) {
        if (!lY() || KsAdSDKImpl.get() == null || KsAdSDKImpl.get().getContext() == null) {
            return;
        }
        v.H(KsAdSDKImpl.get().getContext(), str);
    }

    public static void b(e eVar) {
        int mg = eVar.mg();
        ai("使用缓存策略: " + mg);
    }

    public static boolean lY() {
        DevelopMangerComponents developMangerComponents = (DevelopMangerComponents) com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return false;
    }
}
