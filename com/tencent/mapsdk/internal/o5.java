package com.tencent.mapsdk.internal;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/o5.class */
public class o5 {

    /* renamed from: a  reason: collision with root package name */
    public final double f23983a;
    public final double b;

    /* renamed from: c  reason: collision with root package name */
    public final double f23984c;
    public final double d;
    public final double e;
    public final double f;

    public o5(double d, double d2, double d3, double d4) {
        this.f23983a = d;
        this.b = d3;
        this.f23984c = d2;
        this.d = d4;
        this.e = (d + d2) / 2.0d;
        this.f = (d3 + d4) / 2.0d;
    }

    public boolean a(double d, double d2) {
        return this.f23983a <= d && d <= this.f23984c && this.b <= d2 && d2 <= this.d;
    }

    public boolean a(double d, double d2, double d3, double d4) {
        return d < this.f23984c && this.f23983a < d2 && d3 < this.d && this.b < d4;
    }

    public boolean a(o5 o5Var) {
        return o5Var.f23983a >= this.f23983a && o5Var.f23984c <= this.f23984c && o5Var.b >= this.b && o5Var.d <= this.d;
    }

    public boolean a(p5 p5Var) {
        return a(p5Var.b, p5Var.f23992c);
    }

    public boolean b(o5 o5Var) {
        return a(o5Var.f23983a, o5Var.f23984c, o5Var.b, o5Var.d);
    }
}
