package com.kwad.components.core.internal.api;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/internal/api/c.class */
public final class c {
    private List<b> JI = new CopyOnWriteArrayList();
    private boolean JJ = false;
    private boolean JK = false;

    public final void a(a aVar) {
        com.kwad.sdk.core.d.b.d("KsAdListenerHolder", "notifyAdEnter: " + aVar + ", hadNotifiedEnter: " + this.JK);
        if (this.JK) {
            return;
        }
        for (b bVar : this.JI) {
            bVar.onAdEnter(aVar);
        }
        this.JK = true;
    }

    public final void a(b bVar) {
        if (bVar == null) {
            return;
        }
        this.JI.add(bVar);
    }

    public final void b(a aVar) {
        com.kwad.sdk.core.d.b.d("KsAdListenerHolder", "notifyAdExit: " + aVar + ", hadNotifiedExit: " + this.JJ);
        if (this.JJ) {
            return;
        }
        for (b bVar : this.JI) {
            bVar.onAdExit(aVar);
        }
        this.JJ = true;
    }

    public final void b(b bVar) {
        if (bVar == null) {
            return;
        }
        this.JI.remove(bVar);
    }
}
