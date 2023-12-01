package com.kwad.sdk.i.kwai;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/i/kwai/a.class */
public final class a {
    private final List<b> axL = new ArrayList();

    public final void addBackPressable(b bVar) {
        if (bVar != null) {
            this.axL.add(bVar);
        }
    }

    public final void addBackPressable(b bVar, int i) {
        if (bVar != null) {
            this.axL.add(i, bVar);
        }
    }

    public final boolean bX() {
        for (b bVar : this.axL) {
            if (bVar.bX()) {
                return true;
            }
        }
        return false;
    }

    public final void removeBackPressable(b bVar) {
        if (bVar != null) {
            this.axL.remove(bVar);
        }
    }
}
