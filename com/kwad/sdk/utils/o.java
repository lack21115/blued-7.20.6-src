package com.kwad.sdk.utils;

import com.kwad.sdk.service.ServiceProvider;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/o.class */
public final class o {
    private static boolean azs;
    private static boolean azt;

    public static boolean CU() {
        return (!((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).E(2L)) & azs;
    }

    public static boolean CV() {
        return (!((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).E(4L)) & azs;
    }

    public static boolean CW() {
        return ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).sy() && azs;
    }

    public static boolean CX() {
        return (!((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).E(16L)) & azs;
    }

    public static boolean CY() {
        return (!((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).E(4096L)) & azs;
    }

    public static boolean CZ() {
        return (!((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).E(1L)) & azs;
    }

    public static boolean Da() {
        return (!((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).E(128L)) & azs;
    }

    public static boolean Db() {
        return (!((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).E(128L)) & azs;
    }

    public static void bw(boolean z) {
        synchronized (o.class) {
            try {
                if (azt) {
                    return;
                }
                azt = true;
                azs = true;
                ((com.kwad.sdk.service.kwai.b) ServiceProvider.get(com.kwad.sdk.service.kwai.b.class)).st();
            } finally {
            }
        }
    }
}
