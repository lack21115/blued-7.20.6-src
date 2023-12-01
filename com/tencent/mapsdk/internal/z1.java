package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.internal.y5;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/z1.class */
public class z1 implements y5.a {

    /* renamed from: c  reason: collision with root package name */
    public static final double f38143c = 1.0d;
    private static final a6 d = new a6(1.0d);

    /* renamed from: a  reason: collision with root package name */
    private p5 f38144a;
    private double b;

    public z1(LatLng latLng) {
        this(latLng, 1.0d);
    }

    public z1(LatLng latLng, double d2) {
        a(latLng);
        a(d2);
    }

    @Override // com.tencent.mapsdk.internal.y5.a
    public p5 a() {
        return this.f38144a;
    }

    public void a(double d2) {
        if (d2 >= 0.0d) {
            this.b = d2;
        } else {
            this.b = 1.0d;
        }
    }

    public void a(LatLng latLng) {
        this.f38144a = d.c(latLng);
    }

    public double b() {
        return this.b;
    }

    public LatLng c() {
        return d.b(this.f38144a);
    }
}
