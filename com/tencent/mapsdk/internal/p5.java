package com.tencent.mapsdk.internal;

import com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/p5.class */
public class p5 implements Coordinate {
    public double b;

    /* renamed from: c  reason: collision with root package name */
    public double f23992c;

    public p5() {
    }

    public p5(double d, double d2) {
        this.b = d;
        this.f23992c = d2;
    }

    public static boolean a(double d, double d2) {
        boolean z = false;
        if (Double.compare(d, d2) == 0) {
            return false;
        }
        if (Math.abs(d - d2) > 1.0E-6d) {
            z = true;
        }
        return z;
    }

    public float a(p5 p5Var) {
        return p5Var.b(this).b();
    }

    public p5 a(double d) {
        return b(d / b());
    }

    public p5 a(float f) {
        double d = f;
        return new p5((float) ((Math.cos(d) * this.b) - (Math.sin(d) * this.f23992c)), (float) ((Math.sin(d) * this.b) + (Math.cos(d) * this.f23992c)));
    }

    public p5 a(int i) {
        double d = this.b;
        double d2 = this.f23992c;
        int i2 = 0;
        while (i2 < i) {
            double d3 = -d;
            i2++;
            d = d2;
            d2 = d3;
        }
        return new p5(d, d2);
    }

    public p5 a(p5 p5Var, float f) {
        return b(p5Var).a(f).c(p5Var);
    }

    public boolean a() {
        double d = this.b;
        if (d < 0.0d || d > 1.0d) {
            return false;
        }
        double d2 = this.f23992c;
        return d2 >= 0.0d && d2 <= 1.0d;
    }

    public float b() {
        return (float) Math.hypot(this.b, this.f23992c);
    }

    public p5 b(double d) {
        return new p5(this.b * d, this.f23992c * d);
    }

    public p5 b(double d, double d2) {
        return new p5(this.b - d, this.f23992c - d2);
    }

    public p5 b(p5 p5Var) {
        return b(p5Var.b, p5Var.f23992c);
    }

    public p5 c() {
        return a(1.0d);
    }

    public p5 c(double d, double d2) {
        return new p5(this.b * d, this.f23992c * d2);
    }

    public p5 c(p5 p5Var) {
        return d(p5Var.b, p5Var.f23992c);
    }

    public p5 d(double d, double d2) {
        return new p5(this.b + d, this.f23992c + d2);
    }

    public void e(double d, double d2) {
        this.b = d;
        this.f23992c = d2;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof p5) {
            p5 p5Var = (p5) obj;
            z = false;
            if (!a(this.b, p5Var.b)) {
                z = false;
                if (!a(this.f23992c, p5Var.f23992c)) {
                    z = true;
                }
            }
        }
        return z;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate
    public void setX(double d) {
        this.b = d;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate
    public void setY(double d) {
        this.f23992c = d;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate
    public void setZ(double d) {
    }

    public String toString() {
        return this.b + "," + this.f23992c;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate
    public double x() {
        return this.b;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate
    public double y() {
        return this.f23992c;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate
    public double z() {
        return 0.0d;
    }
}
