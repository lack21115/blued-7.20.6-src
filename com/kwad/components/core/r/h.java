package com.kwad.components.core.r;

import android.content.Context;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/r/h.class */
public final class h {
    public static boolean e(AdTemplate adTemplate, boolean z) {
        if (!z && com.kwad.sdk.core.response.a.b.cK(com.kwad.sdk.core.response.a.d.cb(adTemplate))) {
            return com.kwad.sdk.core.config.d.uW();
        }
        return false;
    }

    public static void g(Context context, AdTemplate adTemplate) {
        AdWebViewActivityProxy.launch(context, new AdWebViewActivityProxy.a.C0529a().av(com.kwad.sdk.core.response.a.b.bg(adTemplate)).L(adTemplate).aB(true).oc());
    }
}
