package com.kwad.components.core.r;

import java.util.HashSet;
import java.util.Set;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/r/c.class */
public final class c {
    private Set<b> PS;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/r/c$a.class */
    static final class a {
        private static c PT = new c((byte) 0);
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/r/c$b.class */
    public interface b {
        void onPageClose();
    }

    private c() {
        this.PS = new HashSet();
    }

    /* synthetic */ c(byte b2) {
        this();
    }

    public static c pL() {
        return a.PT;
    }

    public final void a(b bVar) {
        this.PS.add(bVar);
    }

    public final void b(b bVar) {
        this.PS.remove(bVar);
    }

    public final void pM() {
        if (this.PS.size() == 0) {
            return;
        }
        for (b bVar : this.PS) {
            bVar.onPageClose();
        }
    }
}
