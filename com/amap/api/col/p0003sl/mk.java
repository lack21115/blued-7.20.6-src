package com.amap.api.col.p0003sl;

import java.io.Serializable;

/* renamed from: com.amap.api.col.3sl.mk  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/mk.class */
public final class mk extends mj implements Serializable {
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;

    public mk() {
        this.j = 0;
        this.k = 0;
        this.l = 0;
    }

    public mk(boolean z, boolean z2) {
        super(z, z2);
        this.j = 0;
        this.k = 0;
        this.l = 0;
    }

    @Override // com.amap.api.col.p0003sl.mj
    /* renamed from: a */
    public final mj clone() {
        mk mkVar = new mk(this.h, this.i);
        mkVar.a(this);
        mkVar.j = this.j;
        mkVar.k = this.k;
        mkVar.l = this.l;
        mkVar.m = this.m;
        mkVar.n = this.n;
        return mkVar;
    }

    @Override // com.amap.api.col.p0003sl.mj
    public final String toString() {
        return "AmapCellCdma{sid=" + this.j + ", nid=" + this.k + ", bid=" + this.l + ", latitude=" + this.m + ", longitude=" + this.n + ", mcc='" + this.f5383a + "', mnc='" + this.b + "', signalStrength=" + this.f5384c + ", asuLevel=" + this.d + ", lastUpdateSystemMills=" + this.e + ", lastUpdateUtcMills=" + this.f + ", age=" + this.g + ", main=" + this.h + ", newApi=" + this.i + '}';
    }
}
