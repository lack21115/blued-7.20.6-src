package com.amap.api.col.p0003sl;

import java.io.Serializable;

/* renamed from: com.amap.api.col.3sl.mm  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/mm.class */
public final class mm extends mj implements Serializable {
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;

    public mm() {
        this.j = 0;
        this.k = 0;
        this.l = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
        this.n = Integer.MAX_VALUE;
    }

    public mm(boolean z) {
        super(z, true);
        this.j = 0;
        this.k = 0;
        this.l = Integer.MAX_VALUE;
        this.m = Integer.MAX_VALUE;
        this.n = Integer.MAX_VALUE;
    }

    @Override // com.amap.api.col.p0003sl.mj
    /* renamed from: a */
    public final mj clone() {
        mm mmVar = new mm(this.h);
        mmVar.a(this);
        mmVar.j = this.j;
        mmVar.k = this.k;
        mmVar.l = this.l;
        mmVar.m = this.m;
        mmVar.n = this.n;
        return mmVar;
    }

    @Override // com.amap.api.col.p0003sl.mj
    public final String toString() {
        return "AmapCellLte{tac=" + this.j + ", ci=" + this.k + ", pci=" + this.l + ", earfcn=" + this.m + ", timingAdvance=" + this.n + ", mcc='" + this.a + "', mnc='" + this.b + "', signalStrength=" + this.c + ", asuLevel=" + this.d + ", lastUpdateSystemMills=" + this.e + ", lastUpdateUtcMills=" + this.f + ", age=" + this.g + ", main=" + this.h + ", newApi=" + this.i + '}';
    }
}
