package com.kwad.components.ad.feed;

import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/feed/f.class */
public final class f {
    public static String b(AdTemplate adTemplate) {
        String an = com.kwad.sdk.core.response.a.a.an(com.kwad.sdk.core.response.a.d.cb(adTemplate));
        if (com.kwad.components.core.b.b.lY()) {
            String str = adTemplate.fromCache ? "【cache】" : "";
            return str + an;
        }
        return an;
    }
}
