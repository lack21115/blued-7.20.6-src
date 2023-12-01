package com.tencent.mapsdk.internal;

import com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/x5.class */
public class x5 implements Coordinate, Cloneable {
    public static final double d = 2.003750834E7d;
    private double b = Double.MIN_VALUE;

    /* renamed from: c  reason: collision with root package name */
    private double f38103c = Double.MIN_VALUE;

    public x5(double d2, double d3) {
        setX(d2);
        setY(d3);
    }

    /* renamed from: a */
    public x5 clone() {
        return new x5(this.f38103c, this.b);
    }

    public double b() {
        return this.f38103c;
    }

    public double c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj.hashCode() == hashCode() && (obj instanceof x5)) {
            x5 x5Var = (x5) obj;
            return Double.doubleToLongBits(x5Var.f38103c) == Double.doubleToLongBits(this.f38103c) && Double.doubleToLongBits(x5Var.b) == Double.doubleToLongBits(this.b);
        }
        return false;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f38103c);
        long doubleToLongBits2 = Double.doubleToLongBits(this.b);
        return ((((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32))) + 31) * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate
    public void setX(double d2) {
        this.f38103c = Math.max(-2.003750834E7d, Math.min(2.003750834E7d, d2));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate
    public void setY(double d2) {
        this.b = Math.max(-2.003750834E7d, Math.min(2.003750834E7d, d2));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate
    public void setZ(double d2) {
    }

    public String toString() {
        return "x=" + this.f38103c + ",y=" + this.b;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate
    public double x() {
        return this.f38103c;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate
    public double y() {
        return this.b;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate
    public double z() {
        return 0.0d;
    }
}
