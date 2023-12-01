package com.tencent.mapsdk.internal;

import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/a6.class */
public class a6 {

    /* renamed from: a  reason: collision with root package name */
    public final double f37288a;

    public a6(double d) {
        this.f37288a = d;
    }

    public LatLng b(p5 p5Var) {
        double d = p5Var.b;
        double d2 = this.f37288a;
        double d3 = ((d / d2) - 0.5d) * 360.0d;
        double degrees = 90.0d - Math.toDegrees(Math.atan(Math.exp(((-(0.5d - (p5Var.f37683c / d2))) * 2.0d) * 3.141592653589793d)) * 2.0d);
        double d4 = degrees;
        if (Double.isNaN(degrees)) {
            d4 = 0.0d;
        }
        double d5 = d3;
        if (Double.isNaN(d3)) {
            d5 = 0.0d;
        }
        return new LatLng(d4, d5);
    }

    public p5 c(LatLng latLng) {
        double d = latLng.longitude / 360.0d;
        double sin = Math.sin(Math.toRadians(latLng.latitude));
        double log = (Math.log((sin + 1.0d) / (1.0d - sin)) * 0.5d) / (-6.283185307179586d);
        double d2 = this.f37288a;
        return new p5((d + 0.5d) * d2, (log + 0.5d) * d2);
    }
}
