package com.github.mikephil.charting.components;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import com.github.mikephil.charting.formatter.DefaultAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/components/AxisBase.class */
public abstract class AxisBase extends ComponentBase {

    /* renamed from: a  reason: collision with root package name */
    protected ValueFormatter f8478a;
    public int d;
    public int e;
    protected List<LimitLine> m;
    private int C = Color.GRAY;
    private float D = 1.0f;
    private int E = Color.GRAY;
    private float F = 1.0f;
    public float[] b = new float[0];

    /* renamed from: c  reason: collision with root package name */
    public float[] f8479c = new float[0];
    private int G = 6;
    protected float f = 1.0f;
    protected boolean g = false;
    protected boolean h = false;
    protected boolean i = true;
    protected boolean j = true;
    protected boolean k = true;
    protected boolean l = false;
    private DashPathEffect H = null;
    private DashPathEffect I = null;
    protected boolean n = false;
    protected boolean o = true;
    protected float p = 0.0f;
    protected float q = 0.0f;
    protected boolean r = false;
    protected boolean s = false;
    public float t = 0.0f;
    public float u = 0.0f;
    public float v = 0.0f;

    public AxisBase() {
        this.A = Utils.a(10.0f);
        this.x = Utils.a(5.0f);
        this.y = Utils.a(5.0f);
        this.m = new ArrayList();
    }

    public void a(float f) {
        this.F = Utils.a(f);
    }

    public void a(float f, float f2) {
        float f3 = this.r ? this.u : f - this.p;
        float f4 = this.s ? this.t : f2 + this.q;
        float f5 = f3;
        float f6 = f4;
        if (Math.abs(f4 - f3) == 0.0f) {
            f6 = f4 + 1.0f;
            f5 = f3 - 1.0f;
        }
        this.u = f5;
        this.t = f6;
        this.v = Math.abs(f6 - f5);
    }

    public void a(int i) {
        this.E = i;
    }

    public void a(boolean z) {
        this.i = z;
    }

    public boolean a() {
        return this.i;
    }

    public String b(int i) {
        return (i < 0 || i >= this.b.length) ? "" : q().a(this.b[i], this);
    }

    public void b(float f) {
        this.s = true;
        this.t = f;
        this.v = Math.abs(f - this.u);
    }

    public void b(boolean z) {
        this.j = z;
    }

    public boolean b() {
        return this.j;
    }

    public void c(float f) {
        this.p = f;
    }

    public void c(boolean z) {
        this.k = z;
    }

    public boolean c() {
        return this.l && this.d > 0;
    }

    public int d() {
        return this.C;
    }

    public void d(float f) {
        this.q = f;
    }

    public float e() {
        return this.F;
    }

    public float f() {
        return this.D;
    }

    public int g() {
        return this.E;
    }

    public boolean h() {
        return this.k;
    }

    public boolean i() {
        return this.h;
    }

    public int j() {
        return this.G;
    }

    public boolean k() {
        return this.g;
    }

    public float l() {
        return this.f;
    }

    public List<LimitLine> m() {
        return this.m;
    }

    public boolean n() {
        return this.n;
    }

    public boolean o() {
        return this.o;
    }

    public String p() {
        String str = "";
        int i = 0;
        while (i < this.b.length) {
            String b = b(i);
            String str2 = str;
            if (b != null) {
                str2 = str;
                if (str.length() < b.length()) {
                    str2 = b;
                }
            }
            i++;
            str = str2;
        }
        return str;
    }

    public ValueFormatter q() {
        ValueFormatter valueFormatter = this.f8478a;
        if (valueFormatter == null || ((valueFormatter instanceof DefaultAxisValueFormatter) && ((DefaultAxisValueFormatter) valueFormatter).a() != this.e)) {
            this.f8478a = new DefaultAxisValueFormatter(this.e);
        }
        return this.f8478a;
    }

    public DashPathEffect r() {
        return this.I;
    }

    public DashPathEffect s() {
        return this.H;
    }

    public float t() {
        return this.u;
    }
}
