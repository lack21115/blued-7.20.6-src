package com.tencent.mapsdk.internal;

import android.os.SystemClock;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/oi.class */
public class oi extends a9 {
    public static final int A0 = 10000;
    public static final long z0 = 500;
    private final Runnable B;
    private final Runnable C;
    private c D;
    public long E;
    private boolean F;
    public long G;
    private Interpolator H;
    private TencentMap.CancelableCallback I;
    private boolean J;
    private boolean K;
    private boolean L;
    private int M;
    private int N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean V;
    private float W;
    private float X;
    private double Y;
    private double Z;
    private double a0;
    private double b0;
    private double c0;
    private boolean d0;
    private int e0;
    private int f0;
    private boolean g0;
    public int h0;
    public int i0;
    public int j0;
    public int k0;
    public int l0;
    public int m0;
    public int n0;
    public int o0;
    private boolean p0;
    public float q0;
    public float r0;
    public float s0;
    public float t0;
    private boolean u0;
    public float v0;
    public float w0;
    public float x0;
    public float y0;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/oi$a.class */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (oi.this.I == null) {
                return;
            }
            oi.this.I.onFinish();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/oi$b.class */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (oi.this.I == null) {
                return;
            }
            oi.this.I.onCancel();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/oi$c.class */
    public interface c {
        float a();

        void a(Runnable runnable);

        GeoPoint b();

        GeoPoint c();

        float d();

        float e();

        int f();

        boolean g();

        float h();
    }

    public oi(int i) {
        super(i, null);
        this.B = new a();
        this.C = new b();
        this.D = null;
        this.E = 500L;
        this.F = false;
        this.G = 0L;
        this.H = new LinearInterpolator();
        this.I = null;
        this.J = false;
        this.K = false;
        this.L = false;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = 0.0f;
        this.X = 0.0f;
        this.Y = 0.0d;
        this.Z = 0.0d;
        this.a0 = 0.0d;
        this.b0 = 0.0d;
        this.c0 = 1.0d;
        this.d0 = false;
        this.e0 = 0;
        this.f0 = 0;
        this.g0 = false;
        this.h0 = 0;
        this.i0 = 0;
        this.j0 = 0;
        this.k0 = 0;
        this.l0 = 0;
        this.m0 = 0;
        this.n0 = 0;
        this.o0 = 0;
        this.p0 = false;
        this.q0 = 0.0f;
        this.r0 = 0.0f;
        this.s0 = 0.0f;
        this.t0 = 0.0f;
        this.u0 = false;
        this.v0 = 0.0f;
        this.w0 = 0.0f;
        this.x0 = 0.0f;
        this.y0 = 0.0f;
    }

    private float a(float f) {
        return ((f % 360.0f) + 360.0f) % 360.0f;
    }

    private float b(float f) {
        float f2 = ((f % 360.0f) + 360.0f) % 360.0f;
        float f3 = f2;
        if (f2 > 45.0f) {
            f3 = 45.0f;
        }
        return f3;
    }

    public void a(double d) {
        this.Y = d;
        this.U = true;
    }

    public void a(int i, int i2) {
        this.h0 = i;
        this.i0 = i2;
        this.g0 = true;
    }

    public void a(long j) {
        this.E = j;
    }

    public void a(c cVar) {
        this.D = cVar;
    }

    public void a(TencentMap.CancelableCallback cancelableCallback) {
        this.I = cancelableCallback;
    }

    public void a(boolean z) {
        this.J = z;
    }

    @Override // com.tencent.mapsdk.internal.a9
    public void b() {
        c cVar;
        super.b();
        this.K = true;
        if (this.I == null || (cVar = this.D) == null) {
            return;
        }
        cVar.a(this.C);
    }

    public void b(int i, int i2) {
        this.e0 = i;
        this.f0 = i2;
        this.d0 = true;
    }

    public void c(float f) {
        this.q0 = a(f);
        this.p0 = true;
    }

    public void c(int i, int i2) {
        if (i == 0 && i2 == 0) {
            this.L = false;
        }
        this.M = i;
        this.N = i2;
        this.L = true;
    }

    public void d(float f) {
        this.v0 = b(f);
        this.u0 = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x0217, code lost:
        if (r0 > 1.0f) goto L114;
     */
    @Override // com.tencent.mapsdk.internal.a9
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean d() {
        /*
            Method dump skipped, instructions count: 928
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.internal.oi.d():boolean");
    }

    public long e() {
        return SystemClock.uptimeMillis();
    }

    public void e(float f) {
        if (f == 0.0f) {
            return;
        }
        this.X = f;
        this.T = true;
    }

    public int f() {
        return this.e0;
    }

    public void f(float f) {
        if (f <= 0.0f) {
            return;
        }
        this.W = f;
        this.S = true;
    }

    public int g() {
        return this.f0;
    }

    public int h() {
        return this.n0;
    }

    public int i() {
        return this.o0;
    }

    public float j() {
        return this.t0;
    }

    public float k() {
        return (float) this.a0;
    }

    public int l() {
        return this.O;
    }

    public int m() {
        return this.Q;
    }

    public float n() {
        return this.y0;
    }

    public boolean o() {
        return this.g0;
    }

    public boolean p() {
        return this.d0;
    }

    public boolean q() {
        return this.J;
    }

    public boolean r() {
        return this.p0;
    }

    public boolean s() {
        return this.L;
    }

    public boolean t() {
        return this.u0;
    }

    public boolean u() {
        return this.T || this.S || this.U;
    }
}
