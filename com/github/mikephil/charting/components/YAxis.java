package com.github.mikephil.charting.components;

import android.graphics.Color;
import android.graphics.Paint;
import com.github.mikephil.charting.utils.Utils;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/components/YAxis.class */
public class YAxis extends AxisBase {
    protected boolean C;
    protected boolean D;
    protected int E;
    protected float F;
    protected float G;
    protected float H;
    protected float I;
    protected float J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;
    private YAxisLabelPosition O;
    private AxisDependency P;

    /* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/components/YAxis$AxisDependency.class */
    public enum AxisDependency {
        LEFT,
        RIGHT
    }

    /* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/components/YAxis$YAxisLabelPosition.class */
    public enum YAxisLabelPosition {
        OUTSIDE_CHART,
        INSIDE_CHART
    }

    public YAxis() {
        this.K = true;
        this.L = true;
        this.C = false;
        this.D = false;
        this.M = false;
        this.N = false;
        this.E = Color.GRAY;
        this.F = 1.0f;
        this.G = 10.0f;
        this.H = 10.0f;
        this.O = YAxisLabelPosition.OUTSIDE_CHART;
        this.I = 0.0f;
        this.J = Float.POSITIVE_INFINITY;
        this.P = AxisDependency.LEFT;
        this.y = 0.0f;
    }

    public YAxis(AxisDependency axisDependency) {
        this.K = true;
        this.L = true;
        this.C = false;
        this.D = false;
        this.M = false;
        this.N = false;
        this.E = Color.GRAY;
        this.F = 1.0f;
        this.G = 10.0f;
        this.H = 10.0f;
        this.O = YAxisLabelPosition.OUTSIDE_CHART;
        this.I = 0.0f;
        this.J = Float.POSITIVE_INFINITY;
        this.P = axisDependency;
        this.y = 0.0f;
    }

    public AxisDependency A() {
        return this.P;
    }

    public float B() {
        return this.I;
    }

    public float C() {
        return this.J;
    }

    public YAxisLabelPosition D() {
        return this.O;
    }

    public boolean E() {
        return this.L;
    }

    public boolean F() {
        return this.K;
    }

    public boolean G() {
        return this.C;
    }

    public float H() {
        return this.G;
    }

    public float I() {
        return this.H;
    }

    public boolean J() {
        return this.D;
    }

    public int K() {
        return this.E;
    }

    public float L() {
        return this.F;
    }

    public boolean M() {
        return z() && h() && D() == YAxisLabelPosition.OUTSIDE_CHART;
    }

    public float a(Paint paint) {
        paint.setTextSize(this.A);
        float a2 = Utils.a(paint, p()) + (u() * 2.0f);
        float B = B();
        float C = C();
        float f = B;
        if (B > 0.0f) {
            f = Utils.a(B);
        }
        float f2 = C;
        if (C > 0.0f) {
            f2 = C;
            if (C != Float.POSITIVE_INFINITY) {
                f2 = Utils.a(C);
            }
        }
        if (f2 <= 0.0d) {
            f2 = a2;
        }
        return Math.max(f, Math.min(a2, f2));
    }

    @Override // com.github.mikephil.charting.components.AxisBase
    public void a(float f, float f2) {
        float f3 = f;
        float f4 = f2;
        if (Math.abs(f2 - f) == 0.0f) {
            f4 = f2 + 1.0f;
            f3 = f - 1.0f;
        }
        float abs = Math.abs(f4 - f3);
        this.u = this.r ? this.u : f3 - ((abs / 100.0f) * I());
        this.t = this.s ? this.t : f4 + ((abs / 100.0f) * H());
        this.v = Math.abs(this.u - this.t);
    }

    public float b(Paint paint) {
        paint.setTextSize(this.A);
        return Utils.b(paint, p()) + (v() * 2.0f);
    }
}
