package com.tencent.mapsdk.internal;

import android.graphics.PointF;
import android.graphics.Rect;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mapsdk.internal.v;
import com.tencent.tencentmap.mapsdk.maps.MapParamConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/d0.class */
public class d0 implements ce, d9, h8, l5, oe {
    private static final int O = 20;
    public static final int P = 12;
    public static final int Q = 11;
    public static final int R = 10;
    public static final int S = 18;
    public static final int T = 13;
    public static final int U = 15;
    public static final int V = 15;
    public static final int W = 17;
    public static final int X = 18;
    public static final int Y = 16;
    public static final int Z = 18;
    public static final int a0 = 12;
    private static int b0 = 116307503;
    private static int c0 = 39984186;
    private static final int d0 = 0;
    private static final int e0 = 1;
    private static final int f0 = 2;
    private static final int g0 = 3;
    private static final int h0 = 4;
    private Rect A;
    private Rect B;
    private Runnable K;
    private boolean N;
    public z g;
    public vf h;
    private List<e5> i;
    private List<z4> j;
    private List<te> k;
    private List<b5> l;
    private List<h5> n;
    private List<g5> o;
    private List<l5> p;
    private List<b1> q;
    private final List<m5> s;
    private List<f5> t;
    private List<j5> u;
    private a1 w;
    private e1 x;
    private v y;
    private t4 z;
    private final byte[] m = new byte[0];
    private final byte[] r = new byte[0];
    private Stack<v> v = new Stack<>();
    private h C = null;
    private float D = 0.5f;
    private float E = 0.5f;
    private boolean F = false;
    private int G = 0;
    private int H = 0;
    private int I = 0;
    private int J = 0;
    private boolean L = false;
    private boolean M = false;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/d0$a.class */
    public class a implements te {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f37380a;

        public a(boolean z) {
            this.f37380a = z;
        }

        @Override // com.tencent.mapsdk.internal.te
        public void a() {
            PointF o = d0.this.o();
            d0.this.a(o.x, o.y, this.f37380a);
            d0.this.b(this);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/d0$b.class */
    public class b extends a9 {
        public final /* synthetic */ long B;
        public final /* synthetic */ float C;
        public final /* synthetic */ float D;
        public final /* synthetic */ double E;
        public final /* synthetic */ double F;
        public final /* synthetic */ double G;
        public final /* synthetic */ double H;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i, double[] dArr, boolean z, long j, float f, float f2, double d, double d2, double d3, double d4) {
            super(i, dArr, z);
            this.B = j;
            this.C = f;
            this.D = f2;
            this.E = d;
            this.F = d2;
            this.G = d3;
            this.H = d4;
        }

        @Override // com.tencent.mapsdk.internal.a9
        public boolean d() {
            long currentTimeMillis = System.currentTimeMillis() - this.B;
            double t = x8.t(currentTimeMillis, 0.0f, this.C, 5000L);
            double t2 = x8.t(currentTimeMillis, 0.0f, this.D, 5000L);
            double[] dArr = this.b;
            dArr[2] = dArr[2] + Math.abs(t);
            double[] dArr2 = this.b;
            dArr2[3] = dArr2[3] + Math.abs(t2);
            boolean z = this.b[2] >= Math.abs(this.E);
            boolean z2 = this.b[3] >= Math.abs(this.F);
            if (z) {
                this.b[0] = this.G - d0.this.p();
            } else {
                this.b[0] = t;
            }
            if (z2) {
                this.b[1] = this.H - d0.this.v();
            } else {
                this.b[1] = t2;
            }
            return z && z2;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/d0$c.class */
    public class c extends a9 {
        public final /* synthetic */ long B;
        public final /* synthetic */ float C;
        public final /* synthetic */ float D;
        public final /* synthetic */ double E;
        public final /* synthetic */ double F;
        public final /* synthetic */ double G;
        public final /* synthetic */ double H;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i, double[] dArr, boolean z, long j, float f, float f2, double d, double d2, double d3, double d4) {
            super(i, dArr, z);
            this.B = j;
            this.C = f;
            this.D = f2;
            this.E = d;
            this.F = d2;
            this.G = d3;
            this.H = d4;
        }

        @Override // com.tencent.mapsdk.internal.a9
        public boolean d() {
            long currentTimeMillis = System.currentTimeMillis() - this.B;
            double t = x8.t(currentTimeMillis, 0.0f, this.C, 5000L);
            double t2 = x8.t(currentTimeMillis, 0.0f, this.D, 5000L);
            double[] dArr = this.b;
            dArr[2] = dArr[2] + Math.abs(t);
            double[] dArr2 = this.b;
            dArr2[3] = dArr2[3] + Math.abs(t2);
            boolean z = this.b[2] >= Math.abs(this.E);
            boolean z2 = this.b[3] >= Math.abs(this.F);
            if (z) {
                this.b[0] = this.G - d0.this.p();
            } else {
                this.b[0] = t;
            }
            if (z2) {
                this.b[1] = this.H - d0.this.v();
            } else {
                this.b[1] = t2;
            }
            return z && z2;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/d0$d.class */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d0.this.a(0.0d, 0.0d, false);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/d0$e.class */
    public class e implements Runnable {
        public final /* synthetic */ double b;

        public e(double d) {
            this.b = d;
        }

        @Override // java.lang.Runnable
        public void run() {
            d0.this.a((360.0d - this.b) % 360.0d, MapParamConstants.MAX_SKEW_ANGLE, false);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/d0$f.class */
    public class f implements Runnable {
        public final /* synthetic */ j8 b;

        public f(j8 j8Var) {
            this.b = j8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            j8 j8Var = this.b;
            if (j8Var != null) {
                j8Var.onFinish();
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/d0$g.class */
    public class g implements Runnable {
        public final /* synthetic */ GeoPoint b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ float f37383c;
        public final /* synthetic */ Runnable d;

        public g(GeoPoint geoPoint, float f, Runnable runnable) {
            this.b = geoPoint;
            this.f37383c = f;
            this.d = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            d0.this.b(this.b, this.f37383c, this.d);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/d0$h.class */
    public interface h {
        void a(a9 a9Var);
    }

    public d0(e1 e1Var) {
        this.x = e1Var;
        this.w = (a1) e1Var.j();
        this.y = e1Var.b();
        this.z = e1Var.getProjection();
        this.A = e1Var.e();
        z zVar = new z(this);
        this.g = zVar;
        zVar.a(this);
        a(this.g);
        this.n = new CopyOnWriteArrayList();
        this.o = new CopyOnWriteArrayList();
        this.i = new CopyOnWriteArrayList();
        this.j = new CopyOnWriteArrayList();
        this.k = new CopyOnWriteArrayList();
        this.s = new CopyOnWriteArrayList();
        this.t = new CopyOnWriteArrayList();
        this.u = new CopyOnWriteArrayList();
        this.p = new CopyOnWriteArrayList();
        a(l4.e);
    }

    private void A() {
        this.y.f(0.0f);
        this.y.i(0.0f);
        h(0.0d);
        i(0.0d);
        D();
    }

    private void D() {
        List<b1> list = this.q;
        if (list == null) {
            return;
        }
        for (b1 b1Var : list) {
            if (b1Var != null) {
                try {
                    b1Var.a(this.y);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        a();
    }

    private void F() {
        for (e5 e5Var : this.i) {
            if (e5Var != null) {
                try {
                    e5Var.a();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        D();
    }

    private double a(double d2) {
        double d3 = d2 % 360.0d;
        if (d3 > 180.0d) {
            return d3 - 360.0d;
        }
        double d4 = d3;
        if (d3 < -180.0d) {
            d4 = d3 + 360.0d;
        }
        return d4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(double d2, double d3, boolean z) {
        double a2 = a(d2 - p());
        double v = d3 - v();
        if (a2 == 0.0d && v == 0.0d) {
            return;
        }
        na.c("postRotateAndSkew distance:" + a2 + "," + v);
        b(new b(102, new double[]{d2, d3, 0.0d, 0.0d}, z ^ true, System.currentTimeMillis(), (float) (a2 * 0.10000000149011612d), (float) (0.10000000149011612d * v), a2, v, d2, d3));
    }

    private void a(double d2, double d3, boolean z, Runnable runnable) {
        double a2 = a(d2 - p());
        double v = d3 - v();
        if (a2 == 0.0d && v == 0.0d) {
            if (runnable != null) {
                a9 a9Var = new a9(runnable);
                a9Var.e = true;
                a9Var.f37292c = 0L;
                b(a9Var);
                return;
            }
            return;
        }
        na.c("postRotateAndSkew distance:" + a2 + "," + v);
        b(new c(102, new double[]{d2, d3, 0.0d, 0.0d}, z ^ true, System.currentTimeMillis(), (float) (a2 * 0.10000000149011612d), (float) (0.10000000149011612d * v), a2, v, d2, d3));
        if (runnable != null) {
            a9 a9Var2 = new a9(runnable);
            a9Var2.e = true;
            a9Var2.f37292c = 0L;
            b(a9Var2);
        }
    }

    private void a(GeoPoint geoPoint, float f2, int i, Runnable runnable, j8 j8Var) {
        if (geoPoint == null) {
            return;
        }
        if (f2 >= 3.0f && f2 <= 20.0f) {
            this.x.f().a(geoPoint, (int) f2, true);
        }
        this.K = runnable;
    }

    private void a(GeoPoint geoPoint, boolean z, Runnable runnable) {
        if (geoPoint == null) {
            return;
        }
        this.g.b();
        int i = z ? 20 : 40;
        GeoPoint a2 = this.y.a();
        double[] c2 = i8.c(a2.getLatitudeE6(), geoPoint.getLatitudeE6() - a2.getLatitudeE6(), i);
        double[] c3 = i8.c(a2.getLongitudeE6(), geoPoint.getLongitudeE6() - a2.getLongitudeE6(), i);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                break;
            }
            b(new a9(4, new double[]{c2[i3], c3[i3]}));
            i2 = i3 + 1;
        }
        if (runnable != null) {
            b(new a9(runnable));
        }
    }

    private void b(int i) {
        for (z4 z4Var : this.j) {
            if (z4Var != null) {
                try {
                    z4Var.a(i);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(GeoPoint geoPoint, float f2, Runnable runnable) {
        int i;
        boolean z;
        if (geoPoint == null) {
            return;
        }
        this.g.b();
        double q = q();
        double d2 = f2;
        double d3 = d2 / q;
        int i2 = (d3 > 1.0d ? 1 : (d3 == 1.0d ? 0 : -1));
        if (i2 > 0) {
            i = (int) (d3 / 0.5d);
            z = true;
        } else if (d3 >= 1.0d) {
            a(geoPoint, true, runnable);
            return;
        } else {
            i = i2 != 0 ? (int) (0.5d / d3) : 0;
            z = false;
        }
        int max = Math.max(60, Math.min(120, (i >> 1) << 1));
        double log10 = Math.log10(q) / Math.log10(2.0d);
        double log102 = Math.log10(d2) / Math.log10(2.0d);
        GeoPoint a2 = this.y.a();
        if (z) {
            int i3 = 0;
            while (i3 < max) {
                long j = max;
                i3++;
                long j2 = i3;
                double pow = Math.pow(2.0d, bc.e(log10, log102, j, j2));
                double f3 = bc.f(a2.getLatitudeE6(), geoPoint.getLatitudeE6(), j, j2);
                double f4 = bc.f(a2.getLongitudeE6(), geoPoint.getLongitudeE6(), j, j2);
                na.c("debug location anim zoomOut:" + f3 + "," + f4);
                b(new a9(120, new double[]{pow, f3, f4}));
            }
        } else {
            int i4 = 0;
            while (i4 < max) {
                long j3 = max;
                i4++;
                long j4 = i4;
                double pow2 = Math.pow(2.0d, bc.b(log10, log102, j3, j4));
                double c2 = bc.c(a2.getLatitudeE6(), geoPoint.getLatitudeE6(), j3, j4);
                double c3 = bc.c(a2.getLongitudeE6(), geoPoint.getLongitudeE6(), j3, j4);
                na.c("debug location anim zoomin:" + c2 + "," + c3);
                b(new a9(120, new double[]{pow2, c2, c3}));
            }
        }
        if (runnable != null) {
            b(new a9(runnable));
        }
    }

    private void c(double d2, double d3) {
        double a2 = a(d2 - p());
        double v = d3 - v();
        if (a2 == 0.0d && v == 0.0d) {
            return;
        }
        na.c("rotateAndSkew distance:" + a2 + "," + v);
        b(new a9(102, new double[]{a2, v, 0.0d, 0.0d}, true));
    }

    private void c(int i) {
        for (m5 m5Var : this.s) {
            if (m5Var != null) {
                try {
                    m5Var.a(i);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        D();
    }

    private void c(a9 a9Var) {
        int i = a9Var.f37291a;
        if (i == 2) {
            a1 a1Var = this.w;
            if (a1Var == null || a1Var.getMapRenderView() == null) {
                return;
            }
            this.w.getMapRenderView().j();
        } else if (i == 3) {
            double[] dArr = a9Var.b;
            a(dArr[0], dArr[1]);
        } else if (i == 4) {
            double[] dArr2 = a9Var.b;
            a((int) dArr2[0], (int) dArr2[1], dArr2.length > 2 ? (int) dArr2[2] : 1);
        } else if (i == 6) {
            Runnable runnable = a9Var.f;
            if (runnable != null) {
                runnable.run();
            }
        } else if (i == 120) {
            e(a9Var.b[0]);
            double[] dArr3 = a9Var.b;
            b((int) dArr3[1], (int) dArr3[2]);
        } else if (i == 10000) {
            h hVar = this.C;
            if (hVar != null) {
                hVar.a(a9Var);
            }
        } else {
            switch (i) {
                case 100:
                    d(a9Var.b[0]);
                    return;
                case 101:
                    int width = this.x.e().width();
                    int height = this.x.e().height();
                    int i2 = width / 2;
                    int i3 = height / 2;
                    v.c v = l().v();
                    int i4 = i2;
                    int i5 = i3;
                    if (v != null) {
                        i4 = (int) (i2 + (v.a() * width));
                        i5 = (int) (i3 + (v.b() * height));
                    }
                    double d2 = i4;
                    double[] dArr4 = a9Var.b;
                    double d3 = dArr4[1];
                    double d4 = i5;
                    double d5 = dArr4[2];
                    double d6 = dArr4[3];
                    double d7 = dArr4[4];
                    a(d2 - d3, d4 - d5);
                    d(a9Var.b[0]);
                    a(d6 - d2, d7 - d4);
                    return;
                case 102:
                    b(a9Var.b[0]);
                    f(a9Var.b[1]);
                    return;
                case 103:
                    int width2 = this.x.e().width() / 2;
                    int height2 = this.x.e().height() / 2;
                    double d8 = width2;
                    double[] dArr5 = a9Var.b;
                    double d9 = dArr5[1];
                    double d10 = height2;
                    a(d8 - d9, d10 - dArr5[2]);
                    b(a9Var.b[0]);
                    double[] dArr6 = a9Var.b;
                    a(dArr6[3] - d8, dArr6[4] - d10);
                    return;
                case 104:
                    A();
                    return;
                default:
                    switch (i) {
                        case 108:
                            e(a9Var.b[0]);
                            return;
                        case 109:
                            c(a9Var.b[0]);
                            return;
                        case 110:
                            g(a9Var.b[0]);
                            return;
                        default:
                            return;
                    }
            }
        }
    }

    private void c(boolean z) {
        if (this.l == null) {
            return;
        }
        boolean B = B();
        for (b5 b5Var : this.l) {
            if (b5Var != null) {
                try {
                    b5Var.a(B, z);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private boolean c() {
        return r() < this.y.g();
    }

    private boolean d() {
        return r() > this.y.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PointF o() {
        int i;
        int i2;
        Rect rect = this.A;
        int i3 = 0;
        if (rect != null) {
            i3 = rect.width();
            i = this.A.height();
        } else {
            i = 0;
        }
        int i4 = ((i3 - this.G) - this.I) / 2;
        int i5 = this.H;
        return (i3 == 0 || i == 0) ? new PointF(0.5f, 0.5f) : new PointF(((i2 + i4) * 1.0f) / i3, ((i5 + (((i - i5) - this.J) / 2)) * 1.0f) / i);
    }

    private boolean y() {
        Rect rect = this.A;
        return rect != null && rect.width() > 0 && this.A.height() > 0;
    }

    public boolean B() {
        return ((double) Math.abs(v())) > 1.0E-6d || Math.abs(p()) > 1.0f;
    }

    public boolean C() {
        return this.N;
    }

    public void E() {
        for (l5 l5Var : this.p) {
            if (l5Var != null) {
                try {
                    l5Var.b();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void G() {
        for (g5 g5Var : this.o) {
            if (g5Var != null) {
                try {
                    g5Var.a();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void H() {
        b(this.B);
        for (te teVar : this.k) {
            if (teVar != null) {
                try {
                    teVar.a();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void I() {
        z zVar = this.g;
        if (zVar != null) {
            zVar.h();
        }
    }

    public boolean J() {
        return this.g.i();
    }

    public void K() {
        c(false);
        M();
    }

    public void L() {
        d(false);
    }

    public void M() {
        this.g.b();
        a(0.0d, 0.0d, true);
    }

    public void N() {
        try {
            v pop = this.v.pop();
            if (pop.q() != this.y.q()) {
                a(z5.SCALE_LEVEL_CHANGED);
            } else if (pop.p() != this.y.p()) {
                a(z5.SCALE_CHANGED);
            }
            if (pop.m() != this.y.m()) {
                h(pop.m());
            }
            if (pop.s() != this.y.s()) {
                i(pop.s());
            }
            this.y.a(pop);
            D();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void O() {
        z zVar = this.g;
        if (zVar != null) {
            zVar.k();
        }
    }

    public void P() {
        try {
            v vVar = (v) this.y.clone();
            na.c("mapParam stack saveMapParam:" + vVar.toString());
            this.v.push(vVar);
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
        }
    }

    public void Q() {
        c(false);
        this.g.b();
        c(0.0d, 0.0d);
    }

    public void R() {
        c(false);
        this.g.b();
        c(p(), MapParamConstants.MAX_SKEW_ANGLE);
    }

    public z S() {
        this.g.l();
        return this.g;
    }

    public void T() {
        z zVar = this.g;
        if (zVar != null) {
            zVar.c();
        }
    }

    public float a(Rect rect, Rect rect2) {
        GeoPoint geoPoint = new GeoPoint(rect.top, rect.left);
        GeoPoint geoPoint2 = new GeoPoint(rect.bottom, rect.right);
        Rect rect3 = new Rect();
        rect3.left = Math.min(geoPoint.getLongitudeE6(), geoPoint2.getLongitudeE6());
        rect3.right = Math.max(geoPoint.getLongitudeE6(), geoPoint2.getLongitudeE6());
        rect3.top = Math.min(geoPoint.getLatitudeE6(), geoPoint2.getLatitudeE6());
        rect3.bottom = Math.max(geoPoint.getLatitudeE6(), geoPoint2.getLatitudeE6());
        return (float) this.x.f().a(rect3, rect2);
    }

    public float a(GeoPoint geoPoint, GeoPoint geoPoint2) {
        if (y()) {
            int latitudeE6 = geoPoint.getLatitudeE6();
            int longitudeE6 = geoPoint.getLongitudeE6();
            int latitudeE62 = geoPoint2.getLatitudeE6();
            int longitudeE62 = geoPoint2.getLongitudeE6();
            return a(new Rect(Math.min(longitudeE62, longitudeE6), Math.min(latitudeE62, latitudeE6), Math.max(longitudeE62, longitudeE6), Math.max(latitudeE62, latitudeE6)), this.A);
        }
        return q();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a9, code lost:
        if ((r8 + r10) > com.tencent.mapsdk.internal.g7.i(r0)) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int a(int r7, int r8, int r9, int r10, boolean r11) {
        /*
            r6 = this;
            r0 = r6
            r1 = r7
            r0.G = r1
            r0 = r6
            r1 = r8
            r0.H = r1
            r0 = r6
            r1 = r9
            r0.I = r1
            r0 = r6
            r1 = r10
            r0.J = r1
            r0 = r6
            android.graphics.Rect r0 = r0.A
            r13 = r0
            r0 = 0
            r12 = r0
            r0 = r13
            if (r0 == 0) goto L6c
            r0 = r13
            int r0 = r0.width()
            if (r0 <= 0) goto L6c
            r0 = r6
            android.graphics.Rect r0 = r0.A
            int r0 = r0.height()
            if (r0 <= 0) goto L6c
            r0 = r7
            r1 = r9
            int r0 = r0 + r1
            r1 = r6
            android.graphics.Rect r1 = r1.A
            int r1 = r1.width()
            if (r0 > r1) goto L6a
            r0 = r8
            r1 = r10
            int r0 = r0 + r1
            r1 = r6
            android.graphics.Rect r1 = r1.A
            int r1 = r1.height()
            if (r0 <= r1) goto L52
            r0 = -1
            return r0
        L52:
            r0 = r6
            android.graphics.PointF r0 = r0.o()
            r13 = r0
            r0 = r6
            r1 = r13
            float r1 = r1.x
            r2 = r13
            float r2 = r2.y
            r3 = r11
            r0.a(r1, r2, r3)
            r0 = 0
            return r0
        L6a:
            r0 = -1
            return r0
        L6c:
            r0 = r6
            com.tencent.mapsdk.internal.d0$a r1 = new com.tencent.mapsdk.internal.d0$a
            r2 = r1
            r3 = r6
            r4 = r11
            r2.<init>(r4)
            r0.a(r1)
            r0 = r6
            com.tencent.mapsdk.internal.e1 r0 = r0.x
            r13 = r0
            r0 = r13
            boolean r0 = r0 instanceof com.tencent.mapsdk.internal.rc
            if (r0 == 0) goto Lb0
            r0 = r13
            com.tencent.mapsdk.internal.rc r0 = (com.tencent.mapsdk.internal.rc) r0
            android.content.Context r0 = r0.getContext()
            r13 = r0
            r0 = r7
            r1 = r9
            int r0 = r0 + r1
            r1 = r13
            int r1 = com.tencent.mapsdk.internal.g7.j(r1)
            if (r0 > r1) goto Lac
            r0 = r12
            r7 = r0
            r0 = r8
            r1 = r10
            int r0 = r0 + r1
            r1 = r13
            int r1 = com.tencent.mapsdk.internal.g7.i(r1)
            if (r0 <= r1) goto Lae
        Lac:
            r0 = -1
            r7 = r0
        Lae:
            r0 = r7
            return r0
        Lb0:
            r0 = -2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.internal.d0.a(int, int, int, int, boolean):int");
    }

    public k8 a(int i, Object obj, Object obj2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        return u8.a(this, 2, p(), (((Number) obj2).doubleValue() - ((Number) obj).doubleValue()) + p());
                    } else if (i != 4) {
                        return null;
                    } else {
                        return u8.a(this, 4, v(), (((Number) obj2).doubleValue() - ((Number) obj).doubleValue()) + v());
                    }
                }
                return u8.a(this, 3, Math.log10(((Number) obj).doubleValue()) / Math.log10(2.0d), Math.log10(((Number) obj2).doubleValue()) / Math.log10(2.0d));
            }
            return u8.a(this, 1, new y7(), new Object[]{obj, obj2});
        }
        return u8.a((h8) this, 0, 0, 1);
    }

    public p5 a(GeoPoint geoPoint, p5 p5Var) {
        double min = Math.min(Math.max(Math.sin((geoPoint.getLatitudeE6() / 1000000.0d) * 0.017453292519943295d), -0.9999d), 0.9999d);
        double longitudeE6 = geoPoint.getLongitudeE6() / 1000000.0d;
        double log = Math.log((min + 1.0d) / (1.0d - min));
        p5 p5Var2 = p5Var;
        if (p5Var == null) {
            p5Var2 = new p5();
        }
        p5Var2.e((longitudeE6 * 745654.0444444445d) + 1.34217728E8d, (log * 4.272282972352698E7d * 0.5d) + 1.34217728E8d);
        return p5Var2;
    }

    @Override // com.tencent.mapsdk.internal.ce
    public void a() {
        this.g.a();
    }

    public void a(double d2, double d3) {
        this.x.f().a((float) d2, (float) d3, false);
        b(1);
        D();
    }

    public void a(double d2, double d3, double d4, double d5, double d6) {
        this.g.b();
        float width = this.x.e().width() / 2.0f;
        float height = this.x.e().height() / 2.0f;
        v.c v = l().v();
        if (this.M) {
            if (v != null) {
                d3 = width + (v.a() * width * 2.0f);
                height += v.b() * height * 2.0f;
            } else {
                d3 = width;
            }
            d4 = height;
            d5 = d3;
            d6 = d4;
        }
        a(new a9(103, new double[]{d2, d3, d4, d5, d6}));
    }

    public void a(double d2, double d3, double d4, double d5, double d6, Runnable runnable) {
        double d7;
        double d8;
        this.g.b();
        float width = this.x.e().width() / 2.0f;
        float height = this.x.e().height() / 2.0f;
        v.c v = l().v();
        if (this.L) {
            if (v != null) {
                d3 = width + (v.a() * width * 2.0f);
                d4 = height + (v.b() * height * 2.0f);
            } else {
                d3 = width;
                d4 = height;
            }
            d8 = d3;
            d7 = d4;
        } else {
            d7 = d6;
            d8 = d5;
        }
        b(new a9(101, new double[]{d2, d3, d4, d8, d7}));
        a9 a9Var = new a9(runnable);
        a9Var.e = false;
        a9Var.f37292c = 0L;
        b(a9Var);
    }

    public void a(float f2) {
        c(f2);
    }

    public void a(float f2, float f3) {
        ri f4;
        e1 e1Var = this.x;
        if (e1Var == null || (f4 = e1Var.f()) == null) {
            return;
        }
        f4.a(f2, f3, false);
        D();
    }

    public void a(float f2, float f3, int i, boolean z) {
        if (this.y.a(f2 - 0.5f, f3 - 0.5f, z)) {
            D();
        }
    }

    public void a(float f2, float f3, Runnable runnable) {
        if (this.L) {
            v.c v = l().v();
            if (v == null) {
                a(runnable);
                return;
            }
            float width = this.x.e().width();
            float a2 = v.a();
            f3 = (v.b() + 0.5f) * this.x.e().height();
            f2 = width * (a2 + 0.5f);
        }
        a(f2, f3, runnable, (j8) null);
    }

    public void a(float f2, float f3, Runnable runnable, j8 j8Var) {
        if (c()) {
            Rect r = this.y.r();
            int height = r.height();
            float A = this.x.f().A();
            int i = r.top;
            float f4 = f3;
            if (f3 >= i) {
                float f5 = (i + height) - A;
                f4 = f3;
                if (f3 < f5) {
                    f4 = f5;
                }
            }
            this.x.f().c(f2, f4);
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public void a(float f2, float f3, boolean z) {
        this.y.a(f2 - 0.5f, f3 - 0.5f, z);
        if (z) {
            D();
        }
    }

    public void a(int i) {
        a(i, (Runnable) new d(), false);
    }

    public void a(int i, double d2, boolean z) {
        if (z) {
            a(i, (Runnable) new e(d2), false);
            return;
        }
        e(i);
        a(((float) (360.0d - d2)) % 360.0f);
        c(MapParamConstants.MAX_SKEW_ANGLE);
    }

    public void a(int i, int i2) {
        a(i, i2);
    }

    public void a(int i, int i2, int i3) {
        this.y.a(i, i2, false);
        if (i3 == 1) {
            b(i3);
            D();
        }
    }

    public void a(int i, GeoPoint geoPoint) {
        b(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6());
        e(i);
    }

    @Override // com.tencent.mapsdk.internal.h8
    public void a(int i, Object obj) {
        if (i == 1) {
            GeoPoint geoPoint = (GeoPoint) obj;
            a(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6(), 2);
        } else if (i == 2) {
            b(((Number) obj).doubleValue() - p());
        } else if (i == 3) {
            e(Math.pow(2.0d, ((Number) obj).doubleValue()));
        } else if (i != 4) {
        } else {
            f(((Number) obj).doubleValue() - v());
        }
    }

    public void a(int i, Runnable runnable, boolean z) {
        this.x.f().c(i, true);
        if (runnable != null) {
            runnable.run();
        }
    }

    public void a(Rect rect) {
        if (y()) {
            float a2 = a(rect, this.A);
            this.y.a(rect);
            this.y.e(a2);
        }
    }

    public void a(Rect rect, Rect rect2, Runnable runnable) {
        a(rect, rect2, runnable, (j8) null);
    }

    public void a(Rect rect, Rect rect2, Runnable runnable, j8 j8Var) {
        if (y()) {
            Rect rect3 = new Rect(this.A);
            if (rect2 != null) {
                rect3.left += rect2.left;
                rect3.right -= rect2.right;
                rect3.top += rect2.top;
                rect3.bottom -= rect2.bottom;
            }
            a(rect, rect2, true);
            b(1);
        }
    }

    public void a(Rect rect, Rect rect2, boolean z) {
        if (y()) {
            Rect rect3 = new Rect(this.A);
            if (rect2 != null) {
                rect3.left += rect2.left;
                rect3.right -= rect2.right;
                rect3.top += rect2.top;
                rect3.bottom -= rect2.bottom;
            }
            GeoPoint geoPoint = new GeoPoint(rect.top, rect.left);
            GeoPoint geoPoint2 = new GeoPoint(rect.bottom, rect.right);
            Rect rect4 = new Rect();
            rect4.left = Math.min(geoPoint.getLongitudeE6(), geoPoint2.getLongitudeE6());
            rect4.right = Math.max(geoPoint.getLongitudeE6(), geoPoint2.getLongitudeE6());
            rect4.top = Math.min(geoPoint.getLatitudeE6(), geoPoint2.getLatitudeE6());
            rect4.bottom = Math.max(geoPoint.getLatitudeE6(), geoPoint2.getLatitudeE6());
            this.x.f().a(rect4, rect3, z);
            a();
        }
    }

    public void a(Rect rect, Runnable runnable) {
        a(rect, (Rect) null, runnable);
    }

    public void a(GeoPoint geoPoint) {
        a(geoPoint, (Runnable) null);
    }

    public void a(GeoPoint geoPoint, float f2, float f3, float f4) {
        b(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6());
        b(f2);
        a(f3);
        c(f4);
    }

    public void a(GeoPoint geoPoint, float f2, Runnable runnable) {
        int i;
        if (geoPoint == null) {
            return;
        }
        this.g.b();
        double q = q();
        double d2 = f2;
        double d3 = d2 / q;
        int i2 = (d3 > 1.0d ? 1 : (d3 == 1.0d ? 0 : -1));
        if (i2 > 0) {
            i = (int) (d3 / 0.5d);
        } else if (d3 >= 1.0d) {
            a(geoPoint, true, runnable);
            return;
        } else {
            i = i2 != 0 ? (int) (0.5d / d3) : 0;
        }
        int max = Math.max(60, Math.min(120, (i >> 1) << 1));
        double log10 = Math.log10(q) / Math.log10(2.0d);
        double log102 = Math.log10(d2) / Math.log10(2.0d);
        GeoPoint a2 = this.y.a();
        int i3 = 0;
        while (i3 < max) {
            long j = max;
            i3++;
            long j2 = i3;
            double pow = Math.pow(2.0d, bc.a(log10, log102, j, j2));
            double a3 = bc.a(a2.getLatitudeE6(), geoPoint.getLatitudeE6(), j, j2);
            double a4 = bc.a(a2.getLongitudeE6(), geoPoint.getLongitudeE6(), j, j2);
            na.c("debug location anim zoomOut:" + a3 + "," + a4);
            b(new a9(120, new double[]{pow, a3, a4}));
        }
        if (runnable != null) {
            b(new a9(runnable));
        }
    }

    public void a(GeoPoint geoPoint, int i, Runnable runnable) {
        a(geoPoint, i, 2, runnable, (j8) null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x007b, code lost:
        if (r0 > r15) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.tencent.map.lib.models.GeoPoint r7, android.graphics.Rect r8) {
        /*
            r6 = this;
            r0 = r6
            com.tencent.mapsdk.internal.t4 r0 = r0.z
            r16 = r0
            r0 = r16
            r1 = r7
            com.tencent.mapsdk.internal.p5 r0 = r0.a(r1)
            r7 = r0
            r0 = r8
            r1 = r7
            double r1 = r1.b
            int r1 = (int) r1
            r2 = r7
            double r2 = r2.f37683c
            int r2 = (int) r2
            boolean r0 = r0.contains(r1, r2)
            if (r0 == 0) goto L21
            return
        L21:
            r0 = r7
            double r0 = r0.b
            r9 = r0
            r0 = r8
            int r0 = r0.left
            r15 = r0
            r0 = r15
            double r0 = (double) r0
            r13 = r0
            r0 = 0
            r11 = r0
            r0 = r9
            r1 = r13
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L3e
            goto L4c
        L3e:
            r0 = r8
            int r0 = r0.right
            r15 = r0
            r0 = r9
            r1 = r15
            double r1 = (double) r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L55
        L4c:
            r0 = r15
            double r0 = (double) r0
            r1 = r9
            double r0 = r0 - r1
            r9 = r0
            goto L57
        L55:
            r0 = 0
            r9 = r0
        L57:
            r0 = r7
            double r0 = r0.f37683c
            r13 = r0
            r0 = r8
            int r0 = r0.top
            r15 = r0
            r0 = r13
            r1 = r15
            double r1 = (double) r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L6f
            goto L7e
        L6f:
            r0 = r8
            int r0 = r0.bottom
            r15 = r0
            r0 = r13
            r1 = r15
            double r1 = (double) r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L86
        L7e:
            r0 = r15
            double r0 = (double) r0
            r1 = r13
            double r0 = r0 - r1
            r11 = r0
        L86:
            r0 = r16
            r1 = r6
            com.tencent.map.lib.models.GeoPoint r1 = r1.h()
            com.tencent.mapsdk.internal.p5 r0 = r0.a(r1)
            r7 = r0
            r0 = r7
            r1 = r7
            double r1 = r1.b
            r2 = r9
            double r1 = r1 - r2
            r0.b = r1
            r0 = r7
            r1 = r7
            double r1 = r1.f37683c
            r2 = r11
            double r1 = r1 - r2
            r0.f37683c = r1
            r0 = r6
            r1 = r16
            r2 = r7
            com.tencent.map.lib.models.GeoPoint r1 = r1.a(r2)
            r0.a(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.internal.d0.a(com.tencent.map.lib.models.GeoPoint, android.graphics.Rect):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.tencent.map.lib.models.GeoPoint r11, com.tencent.mapsdk.internal.j8 r12) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.internal.d0.a(com.tencent.map.lib.models.GeoPoint, com.tencent.mapsdk.internal.j8):void");
    }

    public void a(GeoPoint geoPoint, Runnable runnable) {
        b(geoPoint, 1, runnable);
    }

    public void a(GeoPoint geoPoint, Runnable runnable, j8 j8Var) {
        if (geoPoint == null) {
            return;
        }
        a(geoPoint, r(), 1, runnable, j8Var);
    }

    @Override // com.tencent.mapsdk.internal.d9
    public void a(a9 a9Var) {
        if (a9Var != null) {
            c(a9Var);
        }
    }

    public void a(b1 b1Var) {
        if (b1Var == null) {
            return;
        }
        if (this.q == null) {
            this.q = new CopyOnWriteArrayList();
        }
        synchronized (this.r) {
            if (!this.q.contains(b1Var)) {
                this.q.add(b1Var);
            }
        }
    }

    public void a(b5 b5Var) {
        if (b5Var == null) {
            return;
        }
        if (this.l == null) {
            this.l = new ArrayList();
        }
        synchronized (this.m) {
            if (!this.l.contains(b5Var)) {
                this.l.add(b5Var);
            }
        }
    }

    public void a(h hVar) {
        this.C = hVar;
    }

    public void a(e5 e5Var) {
        if (e5Var == null) {
            return;
        }
        synchronized (this.i) {
            if (!this.i.contains(e5Var)) {
                this.i.add(e5Var);
            }
        }
    }

    public void a(f5 f5Var) {
        if (f5Var == null) {
            return;
        }
        synchronized (this.t) {
            if (!this.t.contains(f5Var)) {
                this.t.add(f5Var);
            }
        }
    }

    public void a(g5 g5Var) {
        if (g5Var == null) {
            return;
        }
        synchronized (this.o) {
            if (!this.o.contains(g5Var)) {
                this.o.add(g5Var);
            }
        }
    }

    public void a(h5 h5Var) {
        if (h5Var == null) {
            return;
        }
        synchronized (this.n) {
            if (!this.n.contains(h5Var)) {
                this.n.add(h5Var);
            }
        }
    }

    public void a(j5 j5Var) {
        if (j5Var == null) {
            return;
        }
        synchronized (this.u) {
            na.c("skew addSkewListener");
            if (!this.u.contains(j5Var)) {
                this.u.add(j5Var);
            }
        }
    }

    public void a(l5 l5Var) {
        if (l5Var == null) {
            return;
        }
        synchronized (this.p) {
            if (!this.p.contains(l5Var)) {
                this.p.add(l5Var);
            }
        }
    }

    public void a(m5 m5Var) {
        if (m5Var == null) {
            return;
        }
        synchronized (this.s) {
            if (!this.s.contains(m5Var)) {
                this.s.add(m5Var);
            }
        }
    }

    public void a(te teVar) {
        if (teVar == null || this.k.contains(teVar)) {
            return;
        }
        this.k.add(teVar);
    }

    public void a(yf yfVar) {
        if (this.h == null) {
            this.h = this.w.d();
        }
        this.h.a(yfVar);
    }

    public void a(z4 z4Var) {
        if (z4Var == null) {
            return;
        }
        synchronized (this.j) {
            if (!this.j.contains(z4Var)) {
                this.j.add(z4Var);
            }
        }
    }

    public void a(z5 z5Var) {
        if (z5Var == z5.NO_CHANGED) {
            return;
        }
        for (h5 h5Var : this.n) {
            if (h5Var != null) {
                h5Var.a(z5Var);
            }
        }
        D();
    }

    public void a(Runnable runnable) {
        a(runnable, (j8) null);
    }

    public void a(Runnable runnable, j8 j8Var) {
        if (c()) {
            this.x.f().c(this.x.e().width() / 2.0f, this.x.e().height() / 2.0f);
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.oe
    public void a(boolean z) {
        if (z) {
            Runnable runnable = this.K;
            if (runnable != null) {
                runnable.run();
                this.K = null;
            }
            D();
        }
    }

    public void a(boolean z, Runnable runnable) {
        this.g.b();
        a(0.0d, 0.0d, z, runnable);
    }

    public double b(GeoPoint geoPoint, GeoPoint geoPoint2) {
        p5 a2 = this.z.a(geoPoint);
        p5 a3 = this.z.a(geoPoint2);
        double d2 = a3.b - a2.b;
        double d3 = a3.f37683c - a2.f37683c;
        return Math.sqrt((d2 * d2) + (d3 * d3));
    }

    public float b(Rect rect, Rect rect2) {
        Rect rect3 = new Rect(this.x.e());
        if (rect2 != null) {
            rect3.left += rect2.left;
            rect3.right -= rect2.right;
            rect3.top += rect2.top;
            rect3.bottom -= rect2.bottom;
        }
        return a(rect, rect3);
    }

    @Override // com.tencent.mapsdk.internal.l5
    public void b() {
        E();
    }

    public void b(double d2) {
        if (d2 == 0.0d) {
            return;
        }
        v vVar = this.y;
        float f2 = vVar.f(vVar.m() + ((float) d2));
        D();
        h(f2);
    }

    public void b(double d2, double d3) {
        this.g.a(d2, d3);
    }

    public void b(float f2) {
        a(this.y.g(f2));
    }

    public void b(float f2, float f3) {
        this.D = f2;
        this.E = f3;
    }

    public void b(int i, int i2) {
        a(i, i2, 1);
    }

    public void b(Rect rect) {
        if (this.A == null || rect == null) {
            return;
        }
        this.B = rect;
        e1 e1Var = this.x;
        if (e1Var instanceof rc) {
            ((rc) e1Var).b(rect);
        }
        D();
    }

    public void b(GeoPoint geoPoint, int i, Runnable runnable) {
        if (geoPoint == null) {
            return;
        }
        a(geoPoint, r(), i, runnable, (j8) null);
    }

    public void b(GeoPoint geoPoint, Rect rect) {
        t4 t4Var = this.z;
        p5 a2 = t4Var.a(geoPoint);
        double centerX = rect.centerX();
        double d2 = a2.b;
        double centerY = rect.centerY();
        double d3 = a2.f37683c;
        p5 a3 = t4Var.a(h());
        a3.b -= centerX - d2;
        a3.f37683c -= centerY - d3;
        a(t4Var.a(a3));
    }

    public void b(GeoPoint geoPoint, Runnable runnable) {
        c(geoPoint, 18, runnable);
    }

    public void b(a9 a9Var) {
        this.g.a(a9Var);
    }

    public void b(b1 b1Var) {
        if (this.q == null) {
            return;
        }
        synchronized (this.r) {
            this.q.remove(b1Var);
        }
    }

    public void b(b5 b5Var) {
        if (this.l == null) {
            return;
        }
        synchronized (this.m) {
            this.l.remove(b5Var);
        }
    }

    public void b(e5 e5Var) {
        synchronized (this.i) {
            this.i.remove(e5Var);
        }
    }

    public void b(f5 f5Var) {
        synchronized (this.t) {
            this.t.remove(f5Var);
        }
    }

    public void b(g5 g5Var) {
        synchronized (this.o) {
            this.o.remove(g5Var);
        }
    }

    public void b(h5 h5Var) {
        synchronized (this.n) {
            this.n.remove(h5Var);
        }
    }

    public void b(j5 j5Var) {
        synchronized (this.u) {
            na.c("skew addSkewListener");
            this.u.remove(j5Var);
        }
    }

    public void b(l5 l5Var) {
        synchronized (this.p) {
            this.p.remove(l5Var);
        }
    }

    public void b(m5 m5Var) {
        synchronized (this.s) {
            this.s.remove(m5Var);
        }
    }

    public void b(te teVar) {
        synchronized (this.k) {
            this.k.remove(teVar);
        }
    }

    public void b(z4 z4Var) {
        synchronized (this.j) {
            this.j.remove(z4Var);
        }
    }

    public void b(Runnable runnable) {
        b(runnable, (j8) null);
    }

    public void b(Runnable runnable, j8 j8Var) {
        if (d()) {
            this.x.f().Y();
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public void b(boolean z) {
        this.N = z;
    }

    public boolean b(GeoPoint geoPoint) {
        boolean z;
        if (geoPoint == null) {
            return true;
        }
        Rect n = n();
        boolean contains = n != null ? n.contains(geoPoint.getLongitudeE6(), geoPoint.getLatitudeE6()) : false;
        p5 a2 = this.z.a(this.y.a());
        p5 a3 = this.z.a(geoPoint);
        if (this.A != null) {
            double abs = Math.abs(a2.b - a3.b);
            double abs2 = Math.abs(a2.f37683c - a3.f37683c);
            if (abs > this.A.width() || abs2 > this.A.height()) {
                z = false;
                return (contains || z) ? false : true;
            }
        }
        z = true;
        if (contains) {
            return false;
        }
    }

    public float c(GeoPoint geoPoint, GeoPoint geoPoint2) {
        int i;
        Rect rect = this.A;
        int i2 = 0;
        if (rect != null) {
            i2 = rect.width();
            i = this.A.height();
        } else {
            i = 0;
        }
        if (i2 == 0 || i == 0 || geoPoint == null || geoPoint2 == null) {
            return 1.0f;
        }
        p5 a2 = a(geoPoint, (p5) null);
        p5 a3 = a(geoPoint2, (p5) null);
        double d2 = a3.b - a2.b;
        double d3 = d2;
        if (d2 < 0.0d) {
            d3 = Math.abs(d2);
        }
        double d4 = a3.f37683c - a2.f37683c;
        double d5 = d4;
        if (d4 < 0.0d) {
            d5 = Math.abs(d4);
        }
        int i3 = (i2 - this.G) - this.I;
        int i4 = (i - this.H) - this.J;
        int i5 = i3;
        if (i3 <= 0) {
            i5 = 1;
        }
        int i6 = i4;
        if (i4 <= 0) {
            i6 = 1;
        }
        float max = (float) (20 - Math.max(Math.log((d3 * 1.0d) / i5) / Math.log(2.0d), Math.log((d5 * 1.0d) / i6) / Math.log(2.0d)));
        v vVar = this.y;
        float f2 = max;
        if (vVar != null) {
            f2 = vVar.a((int) max);
        }
        return f2;
    }

    public void c(double d2) {
        if (xa.b(d2 - this.y.m()) == 0.0d) {
            return;
        }
        float f2 = this.y.f((float) d2);
        D();
        h(f2);
    }

    public void c(float f2) {
        g(f2);
    }

    public void c(Rect rect, Rect rect2) {
        if (rect == null) {
            return;
        }
        if (rect.height() > 0 || rect.width() > 0) {
            a(rect, rect2, false);
        }
        b(1);
    }

    public void c(GeoPoint geoPoint, int i, Runnable runnable) {
        a(geoPoint, i, runnable);
    }

    public void d(double d2) {
        e(this.y.p() * ((float) d2));
    }

    public void d(int i) {
        if (this.y.c(i)) {
            c(i);
        }
    }

    public void d(a9 a9Var) {
        this.g.b();
        b(a9Var);
    }

    public void d(boolean z) {
        c(z);
        a(p(), MapParamConstants.MAX_SKEW_ANGLE, true);
    }

    public void e() {
        this.g.b();
    }

    public void e(double d2) {
        b((float) d2);
    }

    public void e(int i) {
        if (this.y.f(i)) {
            a(z5.SCALE_LEVEL_CHANGED);
        }
    }

    public void e(boolean z) {
        this.F = z;
        this.x.f().e(this.F);
    }

    public v f() {
        try {
            return (v) this.y.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void f(double d2) {
        if (d2 == 0.0d) {
            return;
        }
        v vVar = this.y;
        float i = vVar.i(vVar.s() + ((float) d2));
        D();
        i(i);
    }

    public void f(boolean z) {
        this.M = z;
    }

    public z g() {
        return this.g;
    }

    public void g(double d2) {
        if (d2 == this.y.s()) {
            return;
        }
        float i = this.y.i((float) d2);
        D();
        i(i);
    }

    public void g(boolean z) {
        this.L = z;
    }

    public GeoPoint h() {
        return this.y.a();
    }

    public void h(double d2) {
        for (f5 f5Var : this.t) {
            if (f5Var != null) {
                try {
                    f5Var.a(d2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void h(boolean z) {
        d(z ? 12 : 0);
    }

    public Rect i() {
        p5 p5Var = new p5(this.x.e().width(), this.x.e().height());
        GeoPoint a2 = this.z.a(p5Var);
        p5Var.e(0.0d, this.x.e().height());
        GeoPoint a3 = this.z.a(p5Var);
        p5Var.e(this.x.e().width(), 0.0d);
        GeoPoint a4 = this.z.a(p5Var);
        p5Var.e(0.0d, 0.0d);
        GeoPoint a5 = this.z.a(p5Var);
        return new Rect(Math.min(Math.min(Math.min(a5.getLongitudeE6(), a2.getLongitudeE6()), a3.getLongitudeE6()), a4.getLongitudeE6()), Math.min(Math.min(Math.min(a5.getLatitudeE6(), a2.getLatitudeE6()), a3.getLatitudeE6()), a4.getLatitudeE6()), Math.max(Math.max(Math.max(a5.getLongitudeE6(), a2.getLongitudeE6()), a3.getLongitudeE6()), a4.getLongitudeE6()), Math.max(Math.max(Math.max(a5.getLatitudeE6(), a2.getLatitudeE6()), a3.getLatitudeE6()), a4.getLatitudeE6()));
    }

    public void i(double d2) {
        na.c("skew notifySkew");
        for (j5 j5Var : this.u) {
            if (j5Var != null) {
                try {
                    j5Var.a(d2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void i(boolean z) {
        d(0);
    }

    public float j() {
        return this.y.c();
    }

    public void j(double d2) {
        a((360.0d - d2) % 360.0d, MapParamConstants.MAX_SKEW_ANGLE, true);
    }

    public Rect k() {
        return new Rect(this.G, this.H, this.I, this.J);
    }

    public void k(double d2) {
        this.g.b();
        b(new a9(102, new double[]{d2, 0.0d}));
    }

    public v l() {
        return this.y;
    }

    public void l(double d2) {
        a((360.0d - d2) % 360.0d, v(), true);
    }

    public int m() {
        return this.y.f();
    }

    public void m(double d2) {
        this.g.b();
        b(new a9(100, new double[]{d2}));
    }

    public Rect n() {
        if (this.z == null) {
            return null;
        }
        p5 p5Var = new p5(this.G, this.H);
        GeoPoint a2 = this.z.a(p5Var);
        p5Var.e(this.x.e().width() - this.I, this.x.e().height() - this.J);
        GeoPoint a3 = this.z.a(p5Var);
        return new Rect(Math.min(a2.getLongitudeE6(), a3.getLongitudeE6()), Math.min(a2.getLatitudeE6(), a3.getLatitudeE6()), Math.max(a2.getLongitudeE6(), a3.getLongitudeE6()), Math.max(a2.getLatitudeE6(), a3.getLatitudeE6()));
    }

    public void n(double d2) {
        this.g.b();
        b(new a9(108, new double[]{d2}));
    }

    public void o(double d2) {
        this.g.b();
        b(new a9(102, new double[]{0.0d, d2}));
    }

    public float p() {
        return this.y.m();
    }

    public float q() {
        return this.y.p();
    }

    public int r() {
        return this.y.q();
    }

    public Rect s() {
        GeoPoint t = t();
        GeoPoint u = u();
        return new Rect(t.getLongitudeE6(), t.getLatitudeE6(), u.getLongitudeE6(), u.getLatitudeE6());
    }

    public GeoPoint t() {
        return this.z.a(new p5(0.0d, 0.0d));
    }

    public GeoPoint u() {
        return this.z.a(new p5(this.x.e().width(), this.x.e().height()));
    }

    public float v() {
        return this.y.s();
    }

    public boolean w() {
        return this.g.g();
    }

    public boolean x() {
        vf vfVar = this.h;
        if (vfVar != null) {
            return vfVar.e();
        }
        return false;
    }

    public void z() {
        GeoPoint geoPoint = new GeoPoint(c0, b0);
        this.y.a(this.x.e(), geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6(), 13);
        this.x.f().e(this.F);
    }
}
