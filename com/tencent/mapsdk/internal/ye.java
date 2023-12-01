package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import com.tencent.map.lib.models.CircleInfo;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.tencentmap.mapsdk.maps.model.CircleOptions;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ye.class */
public class ye extends ze<h0> implements fe, h0 {
    private static final int H = 128;
    private GeoPoint B;
    private double C;
    private float D;
    private CircleOptions E;
    private CircleInfo F;
    private rc G;

    public ye(a1 a1Var) {
        super(a1Var);
        this.B = new GeoPoint(39909230, 116397428);
        this.C = 0.0d;
        this.D = 1000.0f;
        this.F = new CircleInfo();
        this.G = a1Var.A();
    }

    private double a(double d, double d2) {
        return d / Math.cos((d2 * 3.141592653589793d) / 180.0d);
    }

    private LatLng a(x5 x5Var) {
        return new LatLng((float) (((Math.atan(Math.exp((((float) ((x5Var.c() * 180.0d) / 2.003750834E7d)) * 3.141592653589793d) / 180.0d)) * 2.0d) - 1.5707963267948966d) * 57.29577951308232d), (float) ((x5Var.b() * 180.0d) / 2.003750834E7d));
    }

    private x5 b(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        return new x5((latLng.longitude * 2.003750834E7d) / 180.0d, ((Math.log(Math.tan(((latLng.latitude + 90.0d) * 3.141592653589793d) / 360.0d)) / 0.017453292519943295d) * 2.003750834E7d) / 180.0d);
    }

    @Override // com.tencent.mapsdk.internal.ze
    public void E() {
        if (this.G == null) {
            return;
        }
        n();
        J();
    }

    @Override // com.tencent.mapsdk.internal.ze
    public void H() {
        rc rcVar;
        if (a() == -1 || (rcVar = this.G) == null) {
            return;
        }
        rcVar.f().c(a());
        a(-1);
    }

    public void J() {
        if (a() == -1) {
            a(this.G.f().a(this.F));
        } else if (C()) {
            this.G.f().a(a(), this.F);
            this.G.w0();
        }
    }

    @Override // com.tencent.mapsdk.internal.v0
    /* renamed from: K */
    public h0 x() {
        return this;
    }

    public double L() {
        return this.D;
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable
    /* renamed from: a */
    public Rect getBound(t4 t4Var) {
        double a2 = a(this.C, this.B.getLatitudeE6() / 1000000.0d);
        x5 b = b(new LatLng(this.B.getLatitudeE6() / 1000000.0d, this.B.getLongitudeE6() / 1000000.0d));
        x5 x5Var = new x5(b.b() - a2, b.c() + a2);
        x5 x5Var2 = new x5(b.b() + a2, b.c() - a2);
        LatLng a3 = a(x5Var);
        LatLng a4 = a(x5Var2);
        Rect rect = new Rect();
        rect.left = (int) (a3.longitude * 1000000.0d);
        rect.top = (int) (a3.latitude * 1000000.0d);
        rect.right = (int) (a4.longitude * 1000000.0d);
        rect.bottom = (int) (a4.latitude * 1000000.0d);
        return rect;
    }

    public void a(GeoPoint geoPoint) {
        if (geoPoint == null) {
            return;
        }
        GeoPoint geoPoint2 = this.B;
        if (geoPoint2 == null) {
            this.B = new GeoPoint(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6());
        } else {
            geoPoint2.setLatitudeE6(geoPoint.getLatitudeE6());
            this.B.setLongitudeE6(geoPoint.getLongitudeE6());
        }
        B();
    }

    public void a(CircleOptions circleOptions) {
        if (circleOptions == null) {
            return;
        }
        this.E = circleOptions;
        LatLng center = circleOptions.getCenter();
        if (center != null) {
            a(GeoPoint.from(center));
        }
        setRadius(circleOptions.getRadius());
        setStrokeWidth(circleOptions.getStrokeWidth());
        setStrokeColor(circleOptions.getStrokeColor());
        setFillColor(circleOptions.getFillColor());
        setZIndex(circleOptions.getZIndex());
        setVisible(circleOptions.isVisible());
        setLevel(circleOptions.getLevel());
        this.E = circleOptions;
        B();
    }

    @Override // com.tencent.mapsdk.internal.fe
    public boolean a(ze zeVar, float f, float f2) {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable
    /* renamed from: b */
    public Rect getScreenBound(t4 t4Var) {
        Rect bound = getBound(t4Var);
        int i = bound.left;
        int i2 = bound.right;
        int i3 = bound.top;
        int i4 = bound.bottom;
        GeoPoint geoPoint = new GeoPoint(i3, i);
        GeoPoint geoPoint2 = new GeoPoint(i4, i);
        GeoPoint geoPoint3 = new GeoPoint(i4, i2);
        GeoPoint geoPoint4 = new GeoPoint(i3, i2);
        p5 a2 = t4Var.a(geoPoint);
        p5 a3 = t4Var.a(geoPoint2);
        p5 a4 = t4Var.a(geoPoint3);
        p5 a5 = t4Var.a(geoPoint4);
        return new Rect((int) Math.min(Math.min(a2.b, a3.b), Math.min(a4.b, a5.b)), (int) Math.min(Math.min(a2.f23992c, a3.f23992c), Math.min(a4.f23992c, a5.f23992c)), (int) Math.max(Math.max(a2.b, a3.b), Math.max(a4.b, a5.b)), (int) Math.max(Math.max(a2.f23992c, a3.f23992c), Math.max(a4.f23992c, a5.f23992c)));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Circle
    public boolean contains(LatLng latLng) {
        return ea.a(getCenter(), latLng) < getRadius();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Circle
    public LatLng getCenter() {
        GeoPoint geoPoint = this.B;
        if (geoPoint != null) {
            return geoPoint.toLatLng();
        }
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Circle
    public double getRadius() {
        return this.C;
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.mapsdk.internal.q4
    public void n() {
        GeoPoint geoPoint;
        if ((a() > 0 && !C()) || this.G == null || (geoPoint = this.B) == null) {
            return;
        }
        double d = this.C;
        if (d <= 0.0d) {
            return;
        }
        CircleInfo circleInfo = this.F;
        circleInfo.zIndex = (int) this.m;
        circleInfo.borderColor = this.l;
        circleInfo.borderWidth = this.j;
        circleInfo.fillColor = this.k;
        circleInfo.radius = (float) d;
        circleInfo.centerX = geoPoint.getLongitudeE6();
        this.F.centerY = this.B.getLatitudeE6();
        CircleInfo circleInfo2 = this.F;
        circleInfo2.isVisible = this.n;
        circleInfo2.level = this.p;
        B();
    }

    @Override // com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Tappable
    public boolean onTap(float f, float f2) {
        boolean z = false;
        if (this.B != null) {
            rc rcVar = this.G;
            if (rcVar == null) {
                return false;
            }
            GeoPoint a2 = rcVar.getProjection().a(new p5(f, f2));
            z = false;
            if (Math.hypot(a2.getLatitudeE6() - this.B.getLatitudeE6(), a2.getLongitudeE6() - this.B.getLongitudeE6()) <= this.D) {
                z = true;
            }
        }
        return z;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Circle
    public void setCenter(LatLng latLng) {
        a(GeoPoint.from(latLng));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Circle
    public void setOptions(CircleOptions circleOptions) {
        a(circleOptions);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Circle
    public void setRadius(double d) {
        if (d < 0.0d) {
            return;
        }
        double d2 = d;
        if (d == 0.0d) {
            d2 = 1.0E-10d;
        }
        CircleOptions circleOptions = this.E;
        if (circleOptions == null || circleOptions.getCenter() == null) {
            return;
        }
        this.C = d2;
        this.D = (float) c7.a(d2, this.E.getCenter().latitude);
        B();
    }
}
