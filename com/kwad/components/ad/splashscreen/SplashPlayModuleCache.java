package com.kwad.components.ad.splashscreen;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/SplashPlayModuleCache.class */
public final class SplashPlayModuleCache {
    private HashMap<String, WeakReference<com.kwad.components.ad.splashscreen.d.a>> BF;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/SplashPlayModuleCache$Holder.class */
    enum Holder {
        INSTANCE;
        
        private SplashPlayModuleCache mInstance = new SplashPlayModuleCache((byte) 0);

        Holder() {
        }

        final SplashPlayModuleCache getInstance() {
            return this.mInstance;
        }
    }

    private SplashPlayModuleCache() {
        this.BF = new HashMap<>(1);
    }

    /* synthetic */ SplashPlayModuleCache(byte b) {
        this();
    }
}
