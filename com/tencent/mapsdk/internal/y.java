package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.location.Location;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mapsdk.internal.rc;
import com.tencent.mapsdk.internal.t4;
import com.tencent.mapsdk.internal.v;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.VisibleRegion;
import java.util.Iterator;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/y.class */
public class y extends a6 implements t4 {
    public static final int e = 268435456;
    private static final int f = 19;
    private static final int g = 14;
    public v b;

    /* renamed from: c  reason: collision with root package name */
    private ri f24428c;
    public rc d;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/y$a.class */
    public class a implements rc.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f24429a;
        public final /* synthetic */ List b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f24430c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Rect e;
        public final /* synthetic */ int f;
        public final /* synthetic */ z g;
        public final /* synthetic */ t4.a h;

        public a(List list, List list2, int i, int i2, Rect rect, int i3, z zVar, t4.a aVar) {
            this.f24429a = list;
            this.b = list2;
            this.f24430c = i;
            this.d = i2;
            this.e = rect;
            this.f = i3;
            this.g = zVar;
            this.h = aVar;
        }

        @Override // com.tencent.mapsdk.internal.rc.b
        public void a(GL10 gl10) {
            float f;
            v.c v;
            GeoPoint a2 = y.this.b.a();
            float p = y.this.b.p();
            float i = y.this.b.i();
            GeoPoint geoPoint = null;
            float f2 = 4.0f;
            while (true) {
                f = f2;
                if (f < i) {
                    break;
                }
                y.this.b(f);
                Rect a3 = y.this.a(this.f24429a, this.b);
                geoPoint = new GeoPoint(a3.centerY(), a3.centerX());
                y.this.c(geoPoint);
                GeoPoint geoPoint2 = new GeoPoint(a3.top, a3.left);
                GeoPoint geoPoint3 = new GeoPoint(a3.bottom, a3.right);
                p5 a4 = y.this.a(geoPoint2);
                p5 a5 = y.this.a(geoPoint3);
                Rect rect = new Rect();
                rect.left = (int) Math.min(a4.b, a5.b);
                rect.right = (int) Math.max(a4.b, a5.b);
                rect.top = (int) Math.min(a4.f23992c, a5.f23992c);
                rect.bottom = (int) Math.max(a4.f23992c, a5.f23992c);
                if (this.f24430c < rect.width() || this.d < rect.height()) {
                    f2 = f / 1.01f;
                } else if (!y.this.c()) {
                    geoPoint = y.this.a(geoPoint, this.e);
                } else if (y.this.d() && (v = y.this.b.v()) != null) {
                    geoPoint = y.this.a(geoPoint, v);
                }
            }
            float max = Math.max(i, f);
            int i2 = this.f;
            if (i2 != 60) {
                this.g.b(i2);
            }
            y.this.c(a2);
            y.this.b(p);
            t4.a aVar = this.h;
            if (aVar != null) {
                try {
                    aVar.a(max, geoPoint, -1.0d);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public y(e1 e1Var) {
        super(4.007501668E7d);
        this.f24428c = e1Var.f();
        this.b = e1Var.b();
        if (e1Var instanceof rc) {
            this.d = (rc) e1Var;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect a(List<? extends Boundable> list, List<GeoPoint> list2) {
        int i;
        int i2;
        int i3;
        Rect bound;
        int i4 = 0;
        int i5 = 0;
        if (list != null) {
            Iterator<? extends Boundable> it = list.iterator();
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            while (true) {
                i4 = i5;
                i = i6;
                i2 = i7;
                i3 = i8;
                if (!it.hasNext()) {
                    break;
                }
                Boundable next = it.next();
                if (next != null && (bound = next.getBound(this)) != null) {
                    int i9 = i5;
                    if (i5 == 0) {
                        i9 = bound.left;
                    }
                    int i10 = i6;
                    if (i6 == 0) {
                        i10 = bound.right;
                    }
                    int i11 = i7;
                    if (i7 == 0) {
                        i11 = bound.top;
                    }
                    int i12 = i8;
                    if (i8 == 0) {
                        i12 = bound.bottom;
                    }
                    int i13 = bound.left;
                    int i14 = i9;
                    if (i13 < i9) {
                        i14 = i13;
                    }
                    int i15 = bound.right;
                    int i16 = i10;
                    if (i15 > i10) {
                        i16 = i15;
                    }
                    int i17 = bound.top;
                    int i18 = i11;
                    if (i17 > i11) {
                        i18 = i17;
                    }
                    int i19 = bound.bottom;
                    i5 = i14;
                    i6 = i16;
                    i7 = i18;
                    i8 = i12;
                    if (i19 < i12) {
                        i8 = i19;
                        i5 = i14;
                        i6 = i16;
                        i7 = i18;
                    }
                }
            }
        } else {
            i = 0;
            i2 = 0;
            i3 = 0;
        }
        int i20 = i4;
        int i21 = i;
        int i22 = i2;
        int i23 = i3;
        if (list2 != null) {
            Iterator<GeoPoint> it2 = list2.iterator();
            int i24 = i3;
            int i25 = i2;
            int i26 = i;
            while (true) {
                i20 = i4;
                i21 = i26;
                i22 = i25;
                i23 = i24;
                if (!it2.hasNext()) {
                    break;
                }
                GeoPoint next2 = it2.next();
                if (next2 != null) {
                    int i27 = i4;
                    if (i4 == 0) {
                        i27 = next2.getLongitudeE6();
                    }
                    int i28 = i26;
                    if (i26 == 0) {
                        i28 = next2.getLongitudeE6();
                    }
                    int i29 = i25;
                    if (i25 == 0) {
                        i29 = next2.getLatitudeE6();
                    }
                    int i30 = i24;
                    if (i24 == 0) {
                        i30 = next2.getLatitudeE6();
                    }
                    int i31 = i27;
                    if (next2.getLongitudeE6() < i27) {
                        i31 = next2.getLongitudeE6();
                    }
                    int i32 = i28;
                    if (next2.getLongitudeE6() > i28) {
                        i32 = next2.getLongitudeE6();
                    }
                    int i33 = i29;
                    if (next2.getLatitudeE6() > i29) {
                        i33 = next2.getLatitudeE6();
                    }
                    i4 = i31;
                    i26 = i32;
                    i25 = i33;
                    i24 = i30;
                    if (next2.getLatitudeE6() < i30) {
                        i24 = next2.getLatitudeE6();
                        i4 = i31;
                        i26 = i32;
                        i25 = i33;
                    }
                }
            }
        }
        return new Rect(i20, i22, i21, i23);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public GeoPoint a(GeoPoint geoPoint, Rect rect) {
        p5 a2;
        if (geoPoint == null || (a2 = a(geoPoint)) == null || rect == null) {
            return null;
        }
        return a(new p5(a2.b - ((rect.left - rect.right) * 0.5d), a2.f23992c - ((rect.top - rect.bottom) * 0.5d)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public GeoPoint a(GeoPoint geoPoint, v.c cVar) {
        p5 a2;
        double d;
        double d2;
        if (geoPoint == null || (a2 = a(geoPoint)) == null || cVar == null) {
            return null;
        }
        double d3 = a2.b;
        double d4 = a2.f23992c;
        Rect rect = new Rect(this.d.e());
        int width = rect.width();
        int height = rect.height();
        float a3 = cVar.a();
        float b = cVar.b();
        double d5 = a3 + 0.5f;
        if (d5 < 0.25d) {
            d = d3 + ((0.25d - d5) * width);
        } else {
            d = d3;
            if (d5 > 0.75d) {
                d = d3 - ((d5 - 0.75d) * width);
            }
        }
        double d6 = b + 0.5f;
        if (d6 < 0.25d) {
            d2 = d4 + ((0.25d - d6) * height);
        } else {
            d2 = d4;
            if (d6 > 0.75d) {
                d2 = d4 - ((d6 - 0.75d) * height);
            }
        }
        return a(new p5(d, d2));
    }

    public static p5 a(v vVar, GeoPoint geoPoint) {
        if (vVar == null || geoPoint == null) {
            return null;
        }
        int w = vVar.w();
        double l = vVar.l();
        double k = vVar.k();
        double min = Math.min(Math.max(Math.sin((geoPoint.getLatitudeE6() / 1000000.0d) * 0.017453292519943295d), -0.9999d), 0.9999d);
        double d = w >> 1;
        return new p5(((geoPoint.getLongitudeE6() / 1000000.0d) * l) + d, d + (Math.log((min + 1.0d) / (1.0d - min)) * k * 0.5d));
    }

    private LatLng a(Context context, p5 p5Var) {
        double d = g7.d(context) * 2.68435456E8f;
        double d2 = d / 2.0d;
        return new LatLng((Math.asin(1.0d - (2.0d / (Math.pow(2.718281828459045d, ((p5Var.f23992c - d2) / 0.5d) / (d / 6.283185307179586d)) + 1.0d))) * 180.0d) / 3.141592653589793d, (p5Var.b - d2) / (d / 360.0d));
    }

    public static x5 b(GeoPoint geoPoint) {
        if (geoPoint == null) {
            return null;
        }
        return new x5(((geoPoint.getLongitudeE6() / 1000000.0d) * 2.003750834E7d) / 180.0d, ((Math.log(Math.tan((((geoPoint.getLatitudeE6() / 1000000.0d) + 90.0d) * 3.141592653589793d) / 360.0d)) / 0.017453292519943295d) * 2.003750834E7d) / 180.0d);
    }

    public static LatLng b(x5 x5Var) {
        if (x5Var == null) {
            return null;
        }
        return new LatLng(((Math.atan(Math.exp((((x5Var.y() / 2.003750834E7d) * 180.0d) * 3.141592653589793d) / 180.0d)) * 2.0d) - 1.5707963267948966d) * 57.29577951308232d, (x5Var.x() / 2.003750834E7d) * 180.0d);
    }

    private p5 c(p5 p5Var) {
        if (p5Var == null) {
            return null;
        }
        p5 b = this.b.b();
        return new p5((this.b.r().width() / 2) + (p5Var.b - b.b), (this.b.r().height() / 2) - (p5Var.f23992c - b.f23992c));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        v.c v = this.b.v();
        boolean z = false;
        if (v == null) {
            return false;
        }
        if (v.a() != 0.0f || v.b() != 0.0f) {
            z = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        v.c v;
        boolean z = false;
        if (this.b.v() == null) {
            return false;
        }
        if (Math.abs(v.a()) > 0.25d || Math.abs(v.b()) > 0.25d) {
            z = true;
        }
        return z;
    }

    @Override // com.tencent.mapsdk.internal.t4
    public double a(Point point, Point point2) {
        GeoPoint a2 = a(new p5(point.x, point.y));
        GeoPoint a3 = a(new p5(point2.x, point2.y));
        float[] fArr = new float[1];
        Location.distanceBetween(a2.getLatitudeE6() / 1000000.0d, a2.getLongitudeE6() / 1000000.0d, a3.getLatitudeE6() / 1000000.0d, a3.getLongitudeE6() / 1000000.0d, fArr);
        return fArr[0] / ((int) Math.sqrt(Math.pow(point.x - point2.x, 2.0d) + Math.pow(point.y - point2.y, 2.0d)));
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x02be  */
    @Override // com.tencent.mapsdk.internal.t4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public float a(com.tencent.tencentmap.mapsdk.maps.model.LatLng r10, com.tencent.tencentmap.mapsdk.maps.model.LatLng r11, int r12, int r13, int r14, int r15, com.tencent.tencentmap.mapsdk.maps.model.LatLng r16) {
        /*
            Method dump skipped, instructions count: 817
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.internal.y.a(com.tencent.tencentmap.mapsdk.maps.model.LatLng, com.tencent.tencentmap.mapsdk.maps.model.LatLng, int, int, int, int, com.tencent.tencentmap.mapsdk.maps.model.LatLng):float");
    }

    @Override // com.tencent.mapsdk.internal.t4
    public GeoPoint a(p5 p5Var) {
        int i;
        Rect f0;
        if (p5Var == null) {
            return null;
        }
        byte[] y = this.b.y();
        Rect r = this.b.r();
        int height = r.height();
        float A = this.f24428c.A();
        float f2 = A;
        if (String.valueOf(A).equals("960.0")) {
            f2 = height;
        }
        double d = p5Var.f23992c;
        double d2 = d;
        if (d >= r.top) {
            double d3 = (i + height) - f2;
            d2 = d;
            if (d < d3) {
                d2 = d3;
            }
        }
        float f3 = (float) p5Var.b;
        float f4 = (float) d2;
        rc rcVar = this.d;
        float f5 = f4;
        float f6 = f3;
        if (rcVar != null) {
            f5 = f4;
            f6 = f3;
            if (rcVar.f0() != null) {
                f6 = f3 - f0.left;
                f5 = f4 - f0.top;
            }
        }
        return this.f24428c.a(y, f6, f5);
    }

    @Override // com.tencent.mapsdk.internal.t4
    public p5 a(Context context, LatLng latLng) {
        double d = g7.d(context) * 2.68435456E8f;
        double d2 = d / 2.0d;
        double d3 = d / 360.0d;
        double d4 = d / 6.283185307179586d;
        double min = Math.min(Math.max(Math.sin(latLng.latitude * 0.017453292519943295d), -0.9999d), 0.9999d);
        return new p5((latLng.longitude * d3) + d2, d2 + (Math.log((min + 1.0d) / (1.0d - min)) * d4 * 0.5d));
    }

    @Override // com.tencent.mapsdk.internal.t4
    public p5 a(GeoPoint geoPoint) {
        if (geoPoint == null) {
            return null;
        }
        double latitudeE6 = geoPoint.getLatitudeE6() / 1000000.0d;
        double longitudeE6 = geoPoint.getLongitudeE6() / 1000000.0d;
        PointF a2 = this.f24428c.a(this.b.y(), latitudeE6, longitudeE6);
        float f2 = a2.x;
        float f3 = a2.y;
        rc rcVar = this.d;
        float f4 = f2;
        float f5 = f3;
        if (rcVar != null) {
            Rect f0 = rcVar.f0();
            f4 = f2;
            f5 = f3;
            if (f0 != null) {
                f4 = f2 + f0.left;
                f5 = f3 + f0.top;
            }
        }
        return new p5(f4, f5);
    }

    @Override // com.tencent.mapsdk.internal.t4
    public x5 a(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        return b(GeoPoint.from(latLng));
    }

    @Override // com.tencent.mapsdk.internal.t4
    public LatLng a(PointF pointF) {
        float[] fArr;
        if (pointF == null) {
            return null;
        }
        float m = this.d.b().m();
        Rect r = this.b.r();
        float width = r.width();
        float height = r.height();
        GeoPoint a2 = this.b.a();
        if (a2 == null) {
            return new LatLng(0.0d, 0.0d);
        }
        p5 c2 = c(fa.d(a2));
        v.c v = this.b.v();
        PointF pointF2 = v == null ? new PointF(width / 2.0f, height / 2.0f) : new PointF((v.a() + 0.5f) * width, (v.b() + 0.5f) * height);
        Matrix matrix = new Matrix();
        matrix.setRotate(-m);
        if (v == null) {
            matrix.preTranslate(width * (-0.5f), (-0.5f) * height);
            matrix.postTranslate(width * 0.5f, height * 0.5f);
        } else {
            matrix.preTranslate(((-0.5f) - v.a()) * width, ((-0.5f) - v.b()) * height);
            matrix.postTranslate((v.a() + 0.5f) * width, (v.b() + 0.5f) * height);
        }
        matrix.mapPoints(new float[2], new float[]{pointF.x, pointF.y});
        double q = (2.003750834E7d / ((1 << this.b.q()) * 256)) * c7.w();
        return b(new p5(c2.b + ((fArr[0] - pointF2.x) * q), c2.f23992c + ((fArr[1] - pointF2.y) * q)));
    }

    @Override // com.tencent.mapsdk.internal.t4
    public LatLng a(x5 x5Var) {
        return b(x5Var);
    }

    public void a(float f2) {
        this.b.f(f2);
    }

    public void a(int i) {
        this.b.f(i);
    }

    public void a(v vVar) {
        this.b = vVar;
    }

    @Override // com.tencent.mapsdk.internal.t4
    public void a(List<? extends Boundable> list, List<GeoPoint> list2, Rect rect, t4.a aVar) {
        if ((list == null || list.isEmpty()) && (list2 == null || list2.isEmpty())) {
            return;
        }
        Rect rect2 = new Rect(this.d.e());
        if (rect != null) {
            rect2.left += rect.left;
            rect2.right -= rect.right;
            rect2.top += rect.top;
            rect2.bottom -= rect.bottom;
        }
        int width = rect2.width();
        int height = rect2.height();
        z g2 = this.d.h().g();
        int f2 = g2.f();
        this.d.a(new a(list, list2, width, height, rect, f2, g2, aVar));
        if (f2 != 60) {
            g2.j();
            g2.d();
        }
    }

    @Override // com.tencent.mapsdk.internal.t4
    public LatLng[] a() {
        Rect e2 = this.d.e();
        float width = e2.width();
        float height = e2.height();
        return new LatLng[]{this.d.getProjection().a(new PointF(0.0f, 0.0f)), this.d.getProjection().a(new PointF(width, 0.0f)), this.d.getProjection().a(new PointF(width, height)), this.d.getProjection().a(new PointF(0.0f, height))};
    }

    @Override // com.tencent.mapsdk.internal.t4
    public PointF b(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        double d = latLng.longitude / 360.0d;
        double sin = Math.sin(Math.toRadians(latLng.latitude));
        return new PointF((float) ((d + 0.5d) * 2.68435456E8d), (float) ((((Math.log((sin + 1.0d) / (1.0d - sin)) * 0.5d) / (-6.283185307179586d)) + 0.5d) * 2.68435456E8d));
    }

    public v b() {
        return this.b;
    }

    public void b(float f2) {
        this.b.h(f2);
    }

    public void c(GeoPoint geoPoint) {
        this.b.b(geoPoint);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.Projection
    public LatLng fromScreenLocation(Point point) {
        return a(new p5(point.x, point.y)).toLatLng();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.Projection
    public VisibleRegion getVisibleRegion() {
        yi yiVar = (yi) this.d.j();
        float A = this.d.f().A();
        int height = this.b.r().height();
        Point point = new Point(0, yiVar.a1);
        Point point2 = new Point(yiVar.Z0, yiVar.a1);
        double d = height - A;
        p5 p5Var = new p5(0.0d, d);
        p5 p5Var2 = new p5(yiVar.Z0, d);
        LatLng fromScreenLocation = fromScreenLocation(point);
        LatLng fromScreenLocation2 = fromScreenLocation(point2);
        LatLng latLng = a(p5Var).toLatLng();
        LatLng latLng2 = a(p5Var2).toLatLng();
        return new VisibleRegion(fromScreenLocation, fromScreenLocation2, latLng, latLng2, LatLngBounds.builder().include(fromScreenLocation).include(fromScreenLocation2).include(latLng).include(latLng2).build());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.Projection
    public float[] glModelMatrix(PointF pointF, float f2) {
        if (pointF == null) {
            return null;
        }
        float[] fArr = new float[16];
        android.opengl.Matrix.setIdentityM(fArr, 0);
        float[] G = this.f24428c.G();
        float[] H = this.f24428c.H();
        GeoPoint n = this.f24428c.n();
        android.opengl.Matrix.multiplyMM(fArr, 0, G, 0, H, 0);
        PointF b = b(fa.d(n));
        android.opengl.Matrix.translateM(fArr, 0, pointF.x - b.x, b.y - pointF.y, 0.0f);
        android.opengl.Matrix.scaleM(fArr, 0, f2, f2, f2);
        return fArr;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.Projection
    public float glPixelRatio() {
        return this.f24428c.I();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.Projection
    public float[] glProjectionMatrix() {
        return this.f24428c.G();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.Projection
    public PointF glVertexForCoordinate(LatLng latLng) {
        return b(latLng);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.Projection
    public float[] glViewMatrix() {
        return this.f24428c.H();
    }

    @Override // com.tencent.mapsdk.internal.t4, com.tencent.tencentmap.mapsdk.maps.Projection
    public double metersPerPixel(double d) {
        return (4.0076E7d / ((Math.pow(2.0d, this.b.x()) * 256.0d) * c7.w())) * Math.cos((d * 3.141592653589793d) / 180.0d);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.Projection
    public Point toScreenLocation(LatLng latLng) {
        PointF a2 = this.f24428c.a(this.b.y(), latLng.latitude, latLng.longitude);
        float f2 = a2.x;
        float f3 = a2.y;
        rc rcVar = this.d;
        float f4 = f2;
        float f5 = f3;
        if (rcVar != null) {
            Rect f0 = rcVar.f0();
            f4 = f2;
            f5 = f3;
            if (f0 != null) {
                f4 = f2 + f0.left;
                f5 = f3 + f0.top;
            }
        }
        p5 p5Var = new p5(f4, f5);
        Point point = new Point();
        point.x = (int) Math.round(p5Var.b);
        point.y = (int) Math.round(p5Var.f23992c);
        return point;
    }
}
