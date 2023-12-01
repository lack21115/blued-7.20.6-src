package com.kwad.components.ad;

import com.kwad.components.ad.adbit.c;
import com.kwad.components.core.b.d;
import com.kwad.components.core.b.f;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/KsAdLoadManager.class */
public final class KsAdLoadManager {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/KsAdLoadManager$Holder.class */
    public enum Holder {
        INSTANCE;
        
        private final KsAdLoadManager mInstance = new KsAdLoadManager((byte) 0);

        Holder() {
        }
    }

    private KsAdLoadManager() {
    }

    /* synthetic */ KsAdLoadManager(byte b) {
        this();
    }

    public static void a(com.kwad.components.core.n.kwai.a aVar) {
        if (c.b(aVar)) {
            return;
        }
        d.lZ().c(aVar);
    }

    public static KsAdLoadManager ac() {
        return Holder.INSTANCE.mInstance;
    }

    public final <T> void a(T t) {
        synchronized (this) {
            f.mk().add(t);
        }
    }

    public final <T> void b(List<T> list) {
        synchronized (this) {
            for (T t : list) {
                f.mk().add(t);
            }
        }
    }
}
