package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.tencentmap.mapsdk.maps.MapParamConstants;
import com.tencent.tencentmap.mapsdk.maps.model.GeometryConstants;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/v.class */
public class v implements Cloneable {
    private int e;
    private double f;
    private double g;
    private Rect o;
    private rc p;
    private ri q;
    private c s;
    private double h = 0.0d;
    private double i = 1.0d;
    private double j = 0.0d;
    private double k = 1.0d;
    private double l = 0.0d;
    private double m = 1.0d;
    private boolean t = false;
    private int b = 0;

    /* renamed from: c  reason: collision with root package name */
    private b f24365c = new b();
    private Rect d = new Rect();
    private GeoPoint n = new GeoPoint();
    private p5 r = new p5();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/v$a.class */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f24366a;

        static {
            z5.values();
            int[] iArr = new int[3];
            f24366a = iArr;
            try {
                z5 z5Var = z5.SCALE_LEVEL_CHANGED;
                iArr[2] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/v$b.class */
    public static class b implements Cloneable {
        public static final int h = 20;
        public static final int i = 20;
        public static final int j = 20;
        public static final int k = 19;
        public static final int l = 22;
        public static final int m = 16;
        public static final int n = 3;
        public static final float o = 1.6f;
        public static final float p = 0.8f;
        public static final float q = 4.0f;
        public static final float r = 3.0517578E-5f;
        public static final int s = 20;
        public static final int t = 1;
        public static final float u = 1.9073486E-6f;
        private float f;
        private int g;

        /* renamed from: c  reason: collision with root package name */
        private float f24367c = 4.0f;
        private float b = 3.0517578E-5f;
        private int e = 20;
        private int d = 3;

        public float a() {
            return this.f / a(this.g);
        }

        public float a(int i2) {
            return (1 << (i2 - 1)) * 1.9073486E-6f;
        }

        public void a(float f) {
            b bVar = new b();
            this.d = bVar.g();
            this.b = f / bVar.a();
        }

        public void a(int i2, float f) {
            this.f = f;
            this.g = i2;
        }

        public int b() {
            return this.e;
        }

        public void b(float f) {
            this.f = f;
        }

        public void b(int i2) {
            this.e = i2;
        }

        public void b(b bVar) {
            this.b = bVar.b;
            this.f24367c = bVar.f24367c;
            this.d = bVar.d;
            this.e = bVar.e;
            this.f = bVar.f;
            this.g = bVar.g;
        }

        public int c() {
            return 20;
        }

        public void c(int i2) {
            this.d = i2;
        }

        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        public float d() {
            return this.b;
        }

        public int e() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                boolean z = false;
                if (this.f == bVar.f) {
                    z = false;
                    if (this.g == bVar.g) {
                        z = true;
                    }
                }
                return z;
            }
            return false;
        }

        public float f() {
            return this.f;
        }

        public int g() {
            return this.g;
        }

        public int hashCode() {
            return toString().hashCode();
        }

        public String toString() {
            return "scale:" + this.f + ", scaleLevel:" + this.g;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/v$c.class */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private float f24368a;
        private float b;

        public c(float f, float f2) {
            this.f24368a = 0.0f;
            this.b = 0.0f;
            this.f24368a = f;
            this.b = f2;
        }

        public float a() {
            return this.f24368a;
        }

        public void a(float f, float f2) {
            this.f24368a = f;
            this.b = f2;
        }

        public float b() {
            return this.b;
        }
    }

    public v(rc rcVar) {
        this.p = rcVar;
        this.q = rcVar.f();
    }

    private void a(float f) {
        if (this.t) {
            MapParamConstants.MAX_SKEW_ANGLE = c(f);
        } else {
            MapParamConstants.MAX_SKEW_ANGLE = 40.0f;
        }
    }

    private void b(float f) {
        float d = d(f);
        if (d >= x()) {
            return;
        }
        float c2 = c(d);
        if (s() <= c2) {
            return;
        }
        i(c2);
    }

    private float c(float f) {
        float f2;
        float f3;
        if (f < 16.0f) {
            return 40.0f;
        }
        if (f >= 16.0f && f < 17.0f) {
            f2 = (f - 16.0f) * 10.0f;
            f3 = 40.0f;
        } else if (f >= 17.0f && f < 18.0f) {
            f2 = (f - 17.0f) * 10.0f;
            f3 = 50.0f;
        } else if (f < 18.0f || f >= 19.0f) {
            return 75.0f;
        } else {
            f2 = (f - 18.0f) * 15.0f;
            f3 = 60.0f;
        }
        return f2 + f3;
    }

    private float d(float f) {
        return ((float) (Math.log(f) / Math.log(2.0d))) + 20.0f;
    }

    private void g(int i) {
        double d = (1 << i) * 256;
        this.e = (int) d;
        this.f = d / 360.0d;
        this.g = d / 6.283185307179586d;
    }

    public float a(int i) {
        return this.f24365c.a(i);
    }

    public GeoPoint a() {
        return this.n;
    }

    public void a(double d, double d2) {
        this.r.e(d, d2);
    }

    public void a(Rect rect) {
        this.d.set(rect);
    }

    public void a(Rect rect, int i, int i2, int i3) {
        this.o = rect;
        this.d = GeometryConstants.BOUNDARY_WORLD;
        f(i3);
        c(0);
        a(i, i2, false);
    }

    public void a(v vVar) {
        this.b = vVar.b;
        this.f24365c.b(vVar.f24365c);
        this.d.set(vVar.d);
        this.e = vVar.e;
        this.f = vVar.f;
        this.g = vVar.g;
        this.h = vVar.h;
        this.i = vVar.i;
        this.j = vVar.j;
        this.k = vVar.k;
        this.l = vVar.l;
        this.m = vVar.m;
        this.n.setGeoPoint(vVar.n);
        p5 p5Var = this.r;
        p5 p5Var2 = vVar.r;
        p5Var.e(p5Var2.b, p5Var2.f23992c);
        this.o = vVar.o;
    }

    public void a(boolean z) {
        this.t = z;
    }

    public boolean a(float f, float f2, boolean z) {
        c cVar = this.s;
        if (cVar == null) {
            this.s = new c(f, f2);
        } else {
            cVar.a(f, f2);
        }
        this.p.a(f, f2, z);
        return true;
    }

    public boolean a(int i, int i2) {
        return a(i, i2, false);
    }

    public boolean a(int i, int i2, boolean z) {
        int i3;
        int i4;
        int q = (1 << (20 - q())) < 0 ? 0 : 20 - q();
        if (131072 > q) {
            i3 = ((this.o.width() * 131072) - (this.o.width() * q)) / 2;
            i4 = ((this.o.height() * 131072) - (this.o.height() * q)) / 2;
        } else {
            i3 = 0;
            i4 = 0;
        }
        Rect rect = this.d;
        int i5 = rect.left - i3;
        int i6 = rect.right + i3;
        int i7 = rect.top - i4;
        int i8 = rect.bottom + i4;
        int i9 = i;
        if (i < i7) {
            i9 = i7;
        }
        if (i9 > i8) {
            i9 = i8;
        }
        int i10 = i2;
        if (i2 < i5) {
            i10 = i5;
        }
        if (i10 > i6) {
            i10 = i6;
        }
        boolean z2 = true;
        if (i9 == this.n.getLatitudeE6()) {
            z2 = i10 != this.n.getLongitudeE6();
        }
        this.n.setLatitudeE6(i9);
        this.n.setLongitudeE6(i10);
        p5 a2 = y.a(this, this.n);
        a(a2.b, a2.f23992c);
        this.q.a(this.n, z);
        return z2;
    }

    public boolean a(GeoPoint geoPoint) {
        return a(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6(), true);
    }

    public p5 b() {
        return this.r;
    }

    public boolean b(int i) {
        return i == 8 || i == 13 || i == 10;
    }

    public boolean b(int i, int i2) {
        int i3;
        int q = 1 << (20 - q());
        int i4 = 0;
        if (131072 > q) {
            i4 = ((this.o.width() * 131072) - (this.o.width() * q)) / 2;
            i3 = ((this.o.height() * 131072) - (this.o.height() * q)) / 2;
        } else {
            i3 = 0;
        }
        Rect rect = this.d;
        int i5 = rect.left - i4;
        int i6 = rect.right + i4;
        int i7 = rect.top - i3;
        int i8 = rect.bottom + i3;
        int i9 = i;
        if (i < i7) {
            i9 = i7;
        }
        if (i9 > i8) {
            i9 = i8;
        }
        int i10 = i2;
        if (i2 < i5) {
            i10 = i5;
        }
        if (i10 > i6) {
            i10 = i6;
        }
        this.q.d(new GeoPoint(i9, i10));
        return true;
    }

    public boolean b(GeoPoint geoPoint) {
        return b(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6());
    }

    public float c() {
        return this.f24365c.a();
    }

    public boolean c(int i) {
        int B;
        ri riVar = this.q;
        if (riVar == null || (B = riVar.B()) == i) {
            return false;
        }
        if (B == 11) {
            this.p.r(false);
        }
        if (i == 11) {
            this.p.r(true);
        }
        this.b = i;
        this.q.b(i, false);
        this.q.h(b(i));
        na.a(ma.f, "setMapStyle : styleId[" + i + "]");
        return true;
    }

    public Object clone() throws CloneNotSupportedException {
        v vVar = (v) super.clone();
        vVar.d = new Rect(this.d);
        vVar.f24365c = (b) this.f24365c.clone();
        vVar.n = new GeoPoint(this.n);
        p5 p5Var = this.r;
        vVar.r = new p5(p5Var.b, p5Var.f23992c);
        return vVar;
    }

    public double d() {
        return this.m;
    }

    public void d(int i) {
        this.f24365c.b(i);
    }

    public double e() {
        return this.l;
    }

    public void e(float f) {
        this.f24365c.a(f);
    }

    public void e(int i) {
        this.f24365c.c(i);
    }

    public boolean equals(Object obj) {
        if (obj instanceof v) {
            v vVar = (v) obj;
            return vVar.n.equals(this.n) && vVar.f24365c.equals(this.f24365c) && vVar.b == this.b;
        }
        return false;
    }

    public float f(float f) {
        if (this.q.C() == f) {
            return f;
        }
        float f2 = f % 360.0f;
        double radians = Math.toRadians(f);
        this.h = Math.sin(radians);
        this.i = Math.cos(radians);
        ri riVar = this.q;
        if (riVar != null) {
            riVar.b(f2);
        }
        return f2;
    }

    public int f() {
        ri riVar = this.q;
        return riVar == null ? this.b : riVar.B();
    }

    public boolean f(int i) {
        return g(this.f24365c.a(i)) == z5.SCALE_LEVEL_CHANGED;
    }

    public int g() {
        return this.f24365c.b();
    }

    public z5 g(float f) {
        float f2;
        int i;
        z5 z5Var = z5.NO_CHANGED;
        float f3 = this.f24365c.f();
        int g = this.f24365c.g();
        ri riVar = this.q;
        if (riVar != null) {
            riVar.a(f, false);
            f2 = this.q.D();
            i = this.q.E();
        } else {
            f2 = f3;
            i = g;
        }
        this.f24365c.a(i, f2);
        if (i != g) {
            z5Var = z5.SCALE_LEVEL_CHANGED;
        } else if (f2 != f3) {
            z5Var = z5.SCALE_CHANGED;
        }
        if (z5Var.ordinal() == 2) {
            g(this.f24365c.g());
        }
        p5 a2 = y.a(this, a());
        this.r.e(a2.b, a2.f23992c);
        return z5Var;
    }

    public int h() {
        return this.f24365c.c();
    }

    public z5 h(float f) {
        ri riVar = this.q;
        if (riVar != null) {
            riVar.a(f);
        }
        this.f24365c.b(f);
        return z5.SCALE_LEVEL_CHANGED;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public float i() {
        return this.f24365c.d();
    }

    public float i(float f) {
        if (this.q.F() == f) {
            return f;
        }
        a(x());
        float max = Math.max(0.0f, Math.min(MapParamConstants.MAX_SKEW_ANGLE, f));
        double radians = Math.toRadians(f);
        this.j = Math.sin(radians);
        this.k = Math.cos(radians);
        double d = 1.5707963267948966d - radians;
        this.m = Math.cos(d);
        this.l = Math.sin(d);
        ri riVar = this.q;
        if (riVar != null) {
            riVar.c(max);
        }
        return max;
    }

    public int j() {
        return this.f24365c.e();
    }

    public double k() {
        return this.g;
    }

    public double l() {
        return this.f;
    }

    public float m() {
        return this.q.C();
    }

    public double n() {
        return this.i;
    }

    public double o() {
        return this.h;
    }

    public float p() {
        return this.f24365c.f();
    }

    public int q() {
        return this.f24365c.g();
    }

    public Rect r() {
        return this.o;
    }

    public float s() {
        return this.q.F();
    }

    public double t() {
        return this.k;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        GeoPoint a2 = a();
        sb.append("mapParam: ");
        sb.append("center:" + a2.toString() + " ");
        sb.append("mode:" + this.b + " ");
        sb.append("mapScale:" + this.f24365c.toString() + " ");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("screenRect:");
        Rect rect = this.o;
        sb2.append(rect != null ? rect.toString() : com.igexin.push.core.b.l);
        sb2.append(" ");
        sb.append(sb2.toString());
        return sb.toString();
    }

    public double u() {
        return this.j;
    }

    public c v() {
        return this.s;
    }

    public int w() {
        return this.e;
    }

    public float x() {
        return d(this.f24365c.f);
    }

    public byte[] y() {
        return null;
    }

    public void z() {
        if (this.p == null) {
            return;
        }
        this.n = this.q.n();
        int E = this.q.E();
        float D = this.q.D();
        if (E != q()) {
            this.p.h().a(z5.SCALE_LEVEL_CHANGED);
        } else if (D != p()) {
            this.p.h().a(z5.SCALE_CHANGED);
        }
        if (this.f24365c != null) {
            b(D);
            this.f24365c.a(E, D);
        }
        this.b = this.q.B();
    }
}
