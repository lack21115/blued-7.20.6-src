package com.tencent.mapsdk.internal;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/og.class */
public class og extends ib {
    private pg b;

    public og(pg pgVar) {
        this.b = pgVar;
    }

    @Override // com.tencent.mapsdk.internal.ib
    public final byte[] e(String str) {
        pg pgVar;
        if (f7.b(str) || !str.startsWith(pg.g) || (pgVar = this.b) == null) {
            return null;
        }
        return pgVar.a(str);
    }
}
