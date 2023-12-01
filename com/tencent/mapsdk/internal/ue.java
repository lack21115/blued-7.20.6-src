package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.RectF;
import com.blued.das.live.LiveProtos;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mapsdk.internal.ve;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ue.class */
public class ue extends ve implements ve.a {
    public static final int c0 = 1;
    public static final int d0 = 16;
    public static final int e0 = 256;
    public static final int f0 = 4096;
    public static final int g0 = 65536;
    public double A;
    public double B;
    private RectF C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private float I;
    private float J;
    private boolean K;
    private float L;
    private float M;
    private float N;
    private float O;
    private float P;
    private int Q;
    private float R;
    private float S;
    private boolean T;
    private boolean U;
    private boolean V;
    private boolean W;
    private boolean X;
    private boolean Y;
    private boolean Z;
    private int a0;
    private int b0;
    public int w;
    private String x;
    private String y;
    public Bitmap[] z;

    public ue(jg jgVar) {
        this(jgVar.g(), jgVar.k(), jgVar.c(), jgVar.d(), jgVar.i(), jgVar.j(), jgVar.f());
    }

    public ue(String str, GeoPoint geoPoint, float f, float f2, int i, int i2, Bitmap... bitmapArr) {
        this.H = 0;
        this.I = 0.5f;
        this.J = 0.5f;
        this.K = false;
        this.L = 0.0f;
        this.M = 0.0f;
        this.N = 0.0f;
        this.O = 0.0f;
        this.P = 1.0f;
        this.Q = 0;
        this.R = 1.0f;
        this.S = 1.0f;
        this.T = false;
        this.U = true;
        this.V = false;
        this.W = true;
        this.X = false;
        this.Y = false;
        this.Z = true;
        a(this);
        this.I = f;
        this.J = f2;
        this.D = i;
        this.E = i2;
        if (geoPoint != null) {
            this.A = geoPoint.getLongitudeE6() / 1000000.0d;
            this.B = geoPoint.getLatitudeE6() / 1000000.0d;
        }
        a(str, bitmapArr);
    }

    public ue(String str, GeoPoint geoPoint, float f, float f2, Bitmap... bitmapArr) {
        this(str, geoPoint, f, f2, 0, 0, bitmapArr);
    }

    public ue(String str, GeoPoint geoPoint, Bitmap... bitmapArr) {
        this(str, geoPoint, 0.5f, 0.5f, 0, 0, bitmapArr);
    }

    private Bitmap c(int i) {
        Bitmap[] bitmapArr = this.z;
        if (bitmapArr == null) {
            return null;
        }
        return (i < 0 || i >= bitmapArr.length) ? bitmapArr[0] : bitmapArr[i];
    }

    public boolean A() {
        return this.T;
    }

    public boolean B() {
        return this.U;
    }

    public boolean C() {
        return this.V;
    }

    @Override // com.tencent.mapsdk.internal.ve.a
    public Bitmap a(int i) {
        Bitmap c2;
        synchronized (this) {
            c2 = c(c());
        }
        return c2;
    }

    public void a(float f) {
        this.P = f;
        d(true);
    }

    public void a(float f, float f2) {
        this.I = f;
        this.J = f2;
        a(this.F, this.G);
        d(true);
    }

    public void a(int i, int i2) {
        if (this.F == i && this.G == i2) {
            return;
        }
        this.F = i;
        this.G = i2;
        float f = this.D / i;
        float f2 = this.E / i2;
        this.C = new RectF(f, -f2, 0.0f, 0.0f);
        float f3 = this.I - f;
        this.I = f3;
        float f4 = this.J - f2;
        this.J = f4;
        int i3 = this.F;
        float f5 = (-i3) * f3;
        this.L = f5;
        this.M = i3 + f5;
        float f6 = this.G;
        float f7 = f4 * f6;
        this.N = f7;
        this.O = f7 - f6;
    }

    public void a(GeoPoint geoPoint) {
        if (geoPoint != null) {
            double d = this.T ? 1.0d : 1000000.0d;
            this.A = geoPoint.getLongitudeE6() / d;
            this.B = geoPoint.getLatitudeE6() / d;
            d(true);
        }
    }

    public void a(jg jgVar) {
        a(jgVar.a());
        a(jgVar.c(), jgVar.d());
        e(jgVar.l());
        f(jgVar.r());
        e(jgVar.q());
        b(jgVar.o());
        a(jgVar.n());
        c(jgVar.p());
        g(jgVar.s());
        d(jgVar.h());
        f(jgVar.m());
    }

    public final void a(String str, Bitmap... bitmapArr) {
        synchronized (this) {
            if (bitmapArr == null) {
                return;
            }
            d(true);
            h(true);
            this.x = str;
            this.z = bitmapArr;
            int i = this.H;
            if (i < 0 || i >= bitmapArr.length) {
                this.H = 0;
            }
            int i2 = this.H;
            if (bitmapArr[i2] != null) {
                a(bitmapArr[i2].getWidth(), bitmapArr[this.H].getHeight());
            }
        }
    }

    public void a(boolean z) {
        this.Y = z;
        na.a(ma.f, "setAvoidMarker = " + z);
        d(true);
    }

    @Override // com.tencent.mapsdk.internal.ve.a
    public boolean a() {
        return true;
    }

    @Override // com.tencent.mapsdk.internal.ve.a
    public String b() {
        return this.x;
    }

    public void b(float f, float f2) {
        this.R = f;
        this.S = f2;
        d(true);
    }

    @Override // com.tencent.mapsdk.internal.ve
    public void b(int i) {
        synchronized (this) {
            this.H = i;
            d(true);
            h(true);
            Bitmap c2 = c(i);
            if (c2 != null) {
                int width = c2.getWidth();
                int height = c2.getHeight();
                if (this.F != width || this.G != height) {
                    a(width, height);
                }
            }
            super.b(i);
        }
    }

    public void b(int i, int i2) {
        this.D = i;
        this.E = i2;
        d(true);
    }

    public void b(boolean z) {
        this.X = z;
        na.a(ma.f, "setAvoidPoi = " + z);
        d(true);
    }

    public void c(boolean z) {
        this.Z = z;
    }

    public float d() {
        return this.P;
    }

    public void d(int i) {
        this.a0 = i;
    }

    public void d(boolean z) {
        this.K = z;
    }

    public float e() {
        return this.I;
    }

    public void e(int i) {
        this.Q = i;
        d(true);
    }

    public void e(boolean z) {
        this.W = z;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof ue) {
            if (this.w == ((ue) obj).w) {
                z = true;
            }
            return z;
        }
        return false;
    }

    public float f() {
        return this.J;
    }

    public void f(int i) {
        this.b0 = i;
    }

    public void f(boolean z) {
        this.T = z;
    }

    public float g() {
        return this.O;
    }

    public void g(boolean z) {
        this.U = z;
        d(true);
    }

    public RectF h() {
        return new RectF(this.C);
    }

    public void h(boolean z) {
        this.V = z;
        if (z) {
            return;
        }
        this.y = this.x;
    }

    public int hashCode() {
        return String.valueOf(this.w).hashCode() + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE;
    }

    public int i() {
        return this.w;
    }

    public String j() {
        return this.x;
    }

    public String k() {
        return this.y;
    }

    public float l() {
        return this.L;
    }

    public int m() {
        return this.a0;
    }

    public double n() {
        return this.A;
    }

    public double o() {
        return this.B;
    }

    public float p() {
        return this.M;
    }

    public float q() {
        return this.Z ? 360 - this.Q : this.Q;
    }

    public float r() {
        return this.R;
    }

    public float s() {
        return this.S;
    }

    public float t() {
        return this.N;
    }

    public int u() {
        return this.b0;
    }

    public boolean v() {
        return this.Y;
    }

    public boolean w() {
        return this.X;
    }

    public boolean x() {
        return this.Z;
    }

    public boolean y() {
        return this.K;
    }

    public boolean z() {
        return this.W;
    }
}
