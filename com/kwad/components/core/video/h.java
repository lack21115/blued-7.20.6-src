package com.kwad.components.core.video;

import com.kwad.sdk.core.network.kwai.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ad;
import java.io.File;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/video/h.class */
public final class h {
    public static boolean a(String str, String str2, a.C0564a c0564a) {
        String eC = ad.eC(str2);
        long currentTimeMillis = System.currentTimeMillis();
        com.kwad.sdk.core.d.b.i("VideoCacheHelper", "start cache video key:" + eC + "--url:" + str);
        boolean b = com.kwad.sdk.core.diskcache.a.a.vs().b(str, str2, c0564a);
        long currentTimeMillis2 = System.currentTimeMillis();
        com.kwad.sdk.core.d.b.i("VideoCacheHelper", "finish cache video key:" + eC + "--cache time:" + (currentTimeMillis2 - currentTimeMillis) + "--success:" + b);
        return b;
    }

    public static boolean i(AdTemplate adTemplate) {
        File aX = com.kwad.sdk.core.diskcache.a.a.vs().aX(com.kwad.sdk.core.response.a.a.E(com.kwad.sdk.core.response.a.d.cb(adTemplate)));
        return aX != null && aX.exists();
    }
}
