package com.tencent.mapsdk.internal;

import android.graphics.Color;
import android.graphics.Rect;
import android.util.Pair;
import com.tencent.map.tools.IndexCallback;
import com.tencent.tencentmap.mapsdk.maps.model.ArcOptions;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/xe.class */
public class xe extends ze<g0> implements g0 {
    private final rc B;
    public r0 C;
    private LatLng D;
    private LatLng E;
    private LatLng F;
    private float G;
    private LatLng H;
    private double I;
    private double J;
    private int K;
    private float L;
    private boolean M;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/xe$a.class */
    public class a implements IndexCallback<Pair<Double, Double>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LatLng[] f24421a;

        public a(LatLng[] latLngArr) {
            this.f24421a = latLngArr;
        }

        @Override // com.tencent.map.tools.IndexCallback
        /* renamed from: a */
        public void callback(int i, Pair<Double, Double> pair) {
            this.f24421a[i] = xe.this.B.getProjection().a(new x5(pair.first.doubleValue(), pair.second.doubleValue()));
        }
    }

    public xe(ArcOptions arcOptions, a1 a1Var) {
        super(a1Var);
        this.K = Color.BLUE;
        this.L = 10.0f;
        this.B = a1Var.A();
        a(arcOptions);
    }

    private void K() {
        boolean z;
        double a2;
        LatLng latLng = this.D;
        LatLng latLng2 = this.F;
        LatLng latLng3 = this.E;
        float f = this.G;
        x5 a3 = this.B.getProjection().a(latLng);
        x5 a4 = this.B.getProjection().a(latLng3);
        x5 x5Var = new x5(0.0d, 0.0d);
        if (f == 0.0f) {
            x5 a5 = this.B.getProjection().a(latLng2);
            a2 = xa.a(a3, a5, a4, x5Var);
            z = xa.a(a3.x(), a3.y(), a4.x(), a4.y(), a5.x(), a5.y()) > 0.0d;
        } else {
            z = f < 180.0f;
            float f2 = f;
            if (f > 180.0f) {
                f2 = 360.0f - f;
            }
            a2 = xa.a(a3, a4, f2 * 2.0f, z, x5Var);
        }
        this.H = this.B.getProjection().a(x5Var);
        this.I = xa.b(a3, a4, x5Var);
        this.J = xa.a(a3, x5Var);
        LatLng[] latLngArr = new LatLng[360];
        xa.a(x5Var, a2, a3, a4, z, new a(latLngArr));
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.D);
        for (int i = 0; i < 360; i++) {
            LatLng latLng4 = latLngArr[i];
            if (latLng4 != null) {
                arrayList.add(latLng4);
            }
        }
        arrayList.add(this.E);
        r0 r0Var = this.C;
        if (r0Var != null) {
            r0Var.remove();
        }
        Polyline a6 = this.B.a(new PolylineOptions().addAll(arrayList).color(this.K).width(this.L).borderWidth(getStrokeWidth()).borderColor(getStrokeColor()).zIndex(getZIndex()).level(getLevel()).arrow(this.M).lineCap(true));
        if (a6 instanceof y0) {
            this.C = ((y0) a6).x();
        }
        this.B.w0();
    }

    private void f(boolean z) {
        this.M = z;
    }

    @Override // com.tencent.mapsdk.internal.ze
    public void E() {
        if (this.B == null || this.C == null) {
            return;
        }
        if (!isVisible()) {
            this.C.remove();
        } else if (C()) {
            K();
            r0 r0Var = this.C;
            if (r0Var instanceof q4) {
                q4 q4Var = (q4) r0Var;
                if (a() == -1) {
                    a(q4Var.a());
                } else {
                    q4Var.n();
                }
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.ze
    public void H() {
        super.H();
        r0 r0Var = this.C;
        if (r0Var != null) {
            r0Var.remove();
            this.C = null;
        }
    }

    @Override // com.tencent.mapsdk.internal.v0
    /* renamed from: J */
    public g0 x() {
        return this;
    }

    @Override // com.tencent.mapsdk.internal.ze, com.tencent.mapsdk.internal.v0, com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable
    /* renamed from: a */
    public Rect getBound(t4 t4Var) {
        LatLng latLng = this.H;
        if (latLng != null) {
            x5 a2 = t4Var.a(latLng);
            x5 x5Var = new x5(a2.b() - this.J, a2.c() - this.J);
            x5 x5Var2 = new x5(a2.b() + this.J, a2.c() + this.J);
            LatLng a3 = t4Var.a(x5Var);
            LatLng a4 = t4Var.a(x5Var2);
            Rect rect = new Rect();
            rect.left = (int) (a3.longitude * 1000000.0d);
            rect.top = (int) (a3.latitude * 1000000.0d);
            rect.right = (int) (a4.longitude * 1000000.0d);
            rect.bottom = (int) (a4.latitude * 1000000.0d);
            return rect;
        }
        return super.getBound(t4Var);
    }

    public void a(float f) {
        if (this.G != f) {
            this.G = f;
            B();
        }
    }

    @Override // com.tencent.mapsdk.internal.g0
    public void a(ArcOptions arcOptions) {
        if (this.B == null || arcOptions == null) {
            return;
        }
        LatLng startLatLng = arcOptions.getStartLatLng();
        LatLng passLatLng = arcOptions.getPassLatLng();
        LatLng endLatLng = arcOptions.getEndLatLng();
        float angle = arcOptions.getAngle() >= 0.0f ? arcOptions.getAngle() % 360.0f : (arcOptions.getAngle() % 360.0f) + 360.0f;
        if (startLatLng == null || endLatLng == null || startLatLng.equals(endLatLng)) {
            return;
        }
        if (passLatLng == null && (angle == 0.0f || angle == 180.0f)) {
            return;
        }
        if (passLatLng == null || !(passLatLng.equals(startLatLng) || passLatLng.equals(endLatLng))) {
            d(startLatLng);
            b(endLatLng);
            c(passLatLng);
            a(angle);
            setColor(arcOptions.getColor());
            setWidth(arcOptions.getWidth());
            setStrokeWidth(arcOptions.getStrokeWidth());
            setStrokeColor(arcOptions.getStrokeColor());
            f(arcOptions.isShowArrow());
            if (C()) {
                K();
            }
        }
    }

    public void b(LatLng latLng) {
        if (this.E != latLng) {
            this.E = latLng;
            B();
        }
    }

    public void c(LatLng latLng) {
        if (this.F != latLng) {
            this.F = latLng;
            B();
        }
    }

    public void d(LatLng latLng) {
        if (this.D != latLng) {
            this.D = latLng;
            B();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Arc
    public LatLng getCenter() {
        return this.H;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Colorable
    public int getColor() {
        return this.K;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Arc
    public double getLength() {
        return this.I;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Arc
    public double getRadius() {
        return this.J;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Widthable
    public float getWidth() {
        return this.L;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Colorable
    public void setColor(int i) {
        if (this.K != i) {
            this.K = i;
            B();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Widthable
    public void setWidth(float f) {
        if (this.L != f) {
            this.L = f;
            B();
        }
    }
}
