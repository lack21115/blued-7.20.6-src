package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.PointF;
import android.view.ViewConfiguration;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/vf.class */
public class vf implements w4 {
    private static final int m = 8;
    private static final float n = 10.0f;

    /* renamed from: c  reason: collision with root package name */
    private float f38071c;
    private float d;
    private e1 e;
    private boolean f;
    private float g;
    private float h;
    private yf i;
    private final float k;
    private a1 l;

    /* renamed from: a  reason: collision with root package name */
    private final long f38070a = 250;
    private final long b = 1200;
    private boolean j = false;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/vf$a.class */
    public class a implements Runnable {
        public final /* synthetic */ d0 b;

        public a(d0 d0Var) {
            this.b = d0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.G();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/vf$b.class */
    public class b implements Runnable {
        public final /* synthetic */ d0 b;

        public b(d0 d0Var) {
            this.b = d0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.G();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/vf$c.class */
    public class c implements Runnable {
        public final /* synthetic */ d0 b;

        public c(d0 d0Var) {
            this.b = d0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.G();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/vf$d.class */
    public class d extends a9 {
        public final /* synthetic */ long B;
        public final /* synthetic */ long C;
        public final /* synthetic */ PointF D;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(int i, double[] dArr, long j, long j2, PointF pointF) {
            super(i, dArr);
            this.B = j;
            this.C = j2;
            this.D = pointF;
        }

        @Override // com.tencent.mapsdk.internal.a9
        public void b() {
            vf.this.f = false;
        }

        @Override // com.tencent.mapsdk.internal.a9
        public boolean d() {
            long currentTimeMillis = System.currentTimeMillis() - this.B;
            long j = this.C;
            if (currentTimeMillis > j) {
                vf.this.f = false;
                return true;
            }
            float f = this.D.x;
            if (f != 0.0f) {
                this.b[0] = x8.x(currentTimeMillis, f, -f, j);
            }
            float f2 = this.D.y;
            if (f2 != 0.0f) {
                this.b[1] = x8.x(currentTimeMillis, f2, -f2, this.C);
                return false;
            }
            return false;
        }
    }

    public vf(e1 e1Var) {
        this.f38071c = ViewConfiguration.getMinimumFlingVelocity();
        this.d = ViewConfiguration.getMaximumFlingVelocity();
        this.e = e1Var;
        a1 a1Var = (a1) e1Var.j();
        this.l = a1Var;
        if (a1Var != null) {
            a1Var.a(this);
            Context context = this.l.getContext();
            if (context != null) {
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                this.f38071c = viewConfiguration.getScaledMinimumFlingVelocity();
                this.d = viewConfiguration.getScaledMaximumFlingVelocity();
            }
        }
        this.i = new yf();
        this.k = e1Var.d() * 2.5f;
    }

    private void e(float f, float f2) {
        this.j = true;
        if (this.f) {
            return;
        }
        float f3 = f / 64.0f;
        float f4 = f2 / 64.0f;
        if (Math.abs(f3) >= this.k || Math.abs(f4) >= this.k) {
            float max = Math.max(Math.abs(f), Math.abs(f2));
            float f5 = this.f38071c;
            long j = ((max - f5) / (this.d - f5)) * 950.0f;
            PointF pointF = new PointF(f3, f4);
            long currentTimeMillis = System.currentTimeMillis();
            this.f = true;
            this.e.h().d(new d(3, new double[]{0.0d, 0.0d}, currentTimeMillis, j + 250, pointF));
        }
    }

    private boolean f(float f, float f2) {
        return this.e.g().a(f, f2);
    }

    public void a(yf yfVar) {
        this.i = yfVar;
        boolean a2 = yfVar.a();
        a1 a1Var = this.l;
        if (a1Var == null) {
            return;
        }
        if (a2) {
            a1Var.b(this);
        } else {
            a1Var.a(this);
        }
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean a() {
        ra.a(new Object[0]);
        if (this.i.d()) {
            d0 h = this.e.h();
            h.b(new b(h));
            return false;
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean a(float f) {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean a(float f, float f2) {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean a(PointF pointF, PointF pointF2, double d2, double d3) {
        if (this.i.k()) {
            d0 h = this.e.h();
            h.a(d3 / d2, pointF.x, pointF.y, pointF2.x, pointF2.y, new c(h));
            return false;
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean a(PointF pointF, PointF pointF2, float f) {
        if (this.i.g()) {
            this.e.h().a(f, pointF.x, pointF.y, pointF2.x, pointF2.y);
            return false;
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean b() {
        if (this.f) {
            this.e.h().e();
            this.f = false;
            return false;
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean b(float f) {
        if (this.i.j()) {
            this.e.h().o((f / 8.0f) * 2.0f);
            return true;
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean b(float f, float f2) {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.w4
    public void c() {
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean c(float f, float f2) {
        if (this.i.b()) {
            this.g = this.e.h().q();
            this.h = f2;
            return false;
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean d() {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean d(float f, float f2) {
        ra.a(Float.valueOf(f), Float.valueOf(f2));
        if (this.i.b()) {
            this.e.h().n(Math.pow(2.0d, ((this.h - f2) * 10.0f) / this.e.e().height()) * this.g);
            return true;
        }
        return true;
    }

    public boolean e() {
        boolean z = this.j;
        this.j = false;
        return z;
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean onDoubleTap(float f, float f2) {
        if (this.i.b()) {
            d0 h = this.e.h();
            h.a(f, f2, new a(h));
            return false;
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean onDown(float f, float f2) {
        this.e.h().e();
        return false;
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean onFling(float f, float f2) {
        if (this.i.h() && this.i.e()) {
            e(f, f2);
            return false;
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean onLongPress(float f, float f2) {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean onScroll(float f, float f2) {
        if (this.i.h()) {
            this.e.h().a(f, f2);
            return false;
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean onSingleTap(float f, float f2) {
        if (this.i.i()) {
            return f(f, f2);
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.w4
    public boolean onUp(float f, float f2) {
        return false;
    }
}
