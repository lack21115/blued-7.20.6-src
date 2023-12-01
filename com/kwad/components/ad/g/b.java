package com.kwad.components.ad.g;

import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.internal.api.SceneImpl;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/g/b.class */
public class b implements i.a {
    private static volatile b Gi;

    private b() {
    }

    public static b lE() {
        if (Gi == null) {
            synchronized (b.class) {
                try {
                    if (Gi == null) {
                        Gi = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return Gi;
    }

    @Override // com.kwad.sdk.core.network.i.a
    public final void a(g gVar, int i) {
        SceneImpl scene;
        int i2;
        if (!(gVar instanceof com.kwad.components.core.n.a) || i == f.agn.errorCode || (scene = gVar.getScene()) == null) {
            return;
        }
        long posId = scene.getPosId();
        if (i == f.agi.errorCode) {
            i2 = 21001;
        } else if (i == f.agm.errorCode) {
            i2 = 21003;
        } else {
            i2 = 21004;
            if (i > 0) {
                i2 = 21004;
                if (i < 1000) {
                    i2 = 21002;
                }
            }
        }
        com.kwad.components.core.m.a.pb().b(posId, i2);
    }

    public final void init() {
        i.wf().a(this);
    }
}
