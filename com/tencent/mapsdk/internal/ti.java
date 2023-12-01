package com.tencent.mapsdk.internal;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ti.class */
public class ti implements b1 {
    private final yi g;

    public ti(yi yiVar) {
        this.g = yiVar;
    }

    @Override // com.tencent.mapsdk.internal.b1
    public void a(v vVar) {
        yi yiVar = this.g;
        if (yiVar == null) {
            return;
        }
        if (vVar != null) {
            yiVar.c(yiVar.getMap().M().x());
        }
        this.g.o0();
    }
}
