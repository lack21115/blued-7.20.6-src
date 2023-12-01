package com.kwad.sdk.core.network;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/network/i.class */
public class i {
    private static volatile i agy;
    private List<a> agx = new CopyOnWriteArrayList();

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/network/i$a.class */
    public interface a {
        void a(g gVar, int i);
    }

    private i() {
    }

    public static i wf() {
        if (agy == null) {
            synchronized (i.class) {
                try {
                    if (agy == null) {
                        agy = new i();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return agy;
    }

    public final void a(a aVar) {
        this.agx.add(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(g gVar, int i) {
        for (a aVar : this.agx) {
            aVar.a(gVar, i);
        }
    }
}
