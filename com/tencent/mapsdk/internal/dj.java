package com.tencent.mapsdk.internal;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/dj.class */
public class dj implements h5 {
    private final yi g;

    public dj(yi yiVar) {
        this.g = yiVar;
    }

    @Override // com.tencent.mapsdk.internal.h5
    public void a(z5 z5Var) {
        yi yiVar = this.g;
        if (yiVar == null || z5Var != z5.SCALE_LEVEL_CHANGED) {
            return;
        }
        yiVar.N();
        this.g.K();
    }
}
