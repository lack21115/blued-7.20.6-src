package com.amap.api.col.p0003sl;

import com.autonavi.amap.mapcore.DPoint;

/* renamed from: com.amap.api.col.3sl.df  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/df.class */
public final class df {
    public final double a;
    public final double b;
    public final double c;
    public final double d;
    public final double e;
    public final double f;

    public df(double d, double d2, double d3, double d4) {
        this.a = d;
        this.b = d3;
        this.c = d2;
        this.d = d4;
        this.e = (d + d2) / 2.0d;
        this.f = (d3 + d4) / 2.0d;
    }

    private boolean a(double d, double d2, double d3, double d4) {
        return d < this.c && this.a < d2 && d3 < this.d && this.b < d4;
    }

    public final boolean a(double d, double d2) {
        return this.a <= d && d <= this.c && this.b <= d2 && d2 <= this.d;
    }

    public final boolean a(df dfVar) {
        return a(dfVar.a, dfVar.c, dfVar.b, dfVar.d);
    }

    public final boolean a(DPoint dPoint) {
        return a(dPoint.x, dPoint.y);
    }

    public final boolean b(df dfVar) {
        return dfVar.a >= this.a && dfVar.c <= this.c && dfVar.b >= this.b && dfVar.d <= this.d;
    }
}
