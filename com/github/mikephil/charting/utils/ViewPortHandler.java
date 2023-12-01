package com.github.mikephil.charting.utils;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/utils/ViewPortHandler.class */
public class ViewPortHandler {

    /* renamed from: a  reason: collision with root package name */
    protected final Matrix f22211a = new Matrix();
    protected RectF b = new RectF();

    /* renamed from: c  reason: collision with root package name */
    protected float f22212c = 0.0f;
    protected float d = 0.0f;
    private float h = 1.0f;
    private float i = Float.MAX_VALUE;
    private float j = 1.0f;
    private float k = Float.MAX_VALUE;
    private float l = 1.0f;
    private float m = 1.0f;
    private float n = 0.0f;
    private float o = 0.0f;
    private float p = 0.0f;
    private float q = 0.0f;
    protected float[] e = new float[9];
    protected Matrix f = new Matrix();
    protected final float[] g = new float[9];

    public float a() {
        return this.b.left;
    }

    public Matrix a(Matrix matrix, View view, boolean z) {
        this.f22211a.set(matrix);
        a(this.f22211a, this.b);
        if (z) {
            view.invalidate();
        }
        matrix.set(this.f22211a);
        return matrix;
    }

    public void a(float f) {
        float f2 = f;
        if (f < 1.0f) {
            f2 = 1.0f;
        }
        this.j = f2;
        a(this.f22211a, this.b);
    }

    public void a(float f, float f2) {
        float a2 = a();
        float c2 = c();
        float b = b();
        float d = d();
        this.d = f2;
        this.f22212c = f;
        a(a2, c2, b, d);
    }

    public void a(float f, float f2, float f3, float f4) {
        this.b.set(f, f2, this.f22212c - f3, this.d - f4);
    }

    public void a(float f, float f2, float f3, float f4, Matrix matrix) {
        matrix.reset();
        matrix.set(this.f22211a);
        matrix.postScale(f, f2, f3, f4);
    }

    public void a(float f, float f2, Matrix matrix) {
        matrix.reset();
        matrix.set(this.f22211a);
        matrix.postScale(f, f2);
    }

    public void a(Matrix matrix, RectF rectF) {
        float f;
        matrix.getValues(this.g);
        float[] fArr = this.g;
        float f2 = fArr[2];
        float f3 = fArr[0];
        float f4 = fArr[5];
        float f5 = fArr[4];
        this.l = Math.min(Math.max(this.j, f3), this.k);
        this.m = Math.min(Math.max(this.h, f5), this.i);
        float f6 = 0.0f;
        if (rectF != null) {
            f6 = rectF.width();
            f = rectF.height();
        } else {
            f = 0.0f;
        }
        this.n = Math.min(Math.max(f2, ((-f6) * (this.l - 1.0f)) - this.p), this.p);
        float max = Math.max(Math.min(f4, (f * (this.m - 1.0f)) + this.q), -this.q);
        this.o = max;
        float[] fArr2 = this.g;
        fArr2[2] = this.n;
        fArr2[0] = this.l;
        fArr2[5] = max;
        fArr2[4] = this.m;
        matrix.setValues(fArr2);
    }

    public void a(float[] fArr, Matrix matrix) {
        matrix.reset();
        matrix.set(this.f22211a);
        matrix.postTranslate(-(fArr[0] - a()), -(fArr[1] - c()));
    }

    public void a(float[] fArr, View view) {
        Matrix matrix = this.f;
        matrix.reset();
        matrix.set(this.f22211a);
        matrix.postTranslate(-(fArr[0] - a()), -(fArr[1] - c()));
        a(matrix, view, true);
    }

    public float b() {
        return this.f22212c - this.b.right;
    }

    public void b(float f) {
        float f2 = f;
        if (f == 0.0f) {
            f2 = Float.MAX_VALUE;
        }
        this.k = f2;
        a(this.f22211a, this.b);
    }

    public void b(float f, float f2, Matrix matrix) {
        matrix.reset();
        matrix.set(this.f22211a);
        matrix.setScale(f, f2);
    }

    public boolean b(float f, float f2) {
        return e(f) && f(f2);
    }

    public float c() {
        return this.b.top;
    }

    public void c(float f) {
        float f2 = f;
        if (f < 1.0f) {
            f2 = 1.0f;
        }
        this.h = f2;
        a(this.f22211a, this.b);
    }

    public float d() {
        return this.d - this.b.bottom;
    }

    public void d(float f) {
        float f2 = f;
        if (f == 0.0f) {
            f2 = Float.MAX_VALUE;
        }
        this.i = f2;
        a(this.f22211a, this.b);
    }

    public float e() {
        return this.b.top;
    }

    public boolean e(float f) {
        return g(f) && h(f);
    }

    public float f() {
        return this.b.left;
    }

    public boolean f(float f) {
        return i(f) && j(f);
    }

    public float g() {
        return this.b.right;
    }

    public boolean g(float f) {
        return this.b.left <= f + 1.0f;
    }

    public float h() {
        return this.b.bottom;
    }

    public boolean h(float f) {
        return this.b.right >= (((float) ((int) (f * 100.0f))) / 100.0f) - 1.0f;
    }

    public float i() {
        return this.b.width();
    }

    public boolean i(float f) {
        return this.b.top <= f;
    }

    public float j() {
        return this.b.height();
    }

    public boolean j(float f) {
        return this.b.bottom >= ((float) ((int) (f * 100.0f))) / 100.0f;
    }

    public RectF k() {
        return this.b;
    }

    public void k(float f) {
        this.p = Utils.a(f);
    }

    public MPPointF l() {
        return MPPointF.a(this.b.centerX(), this.b.centerY());
    }

    public void l(float f) {
        this.q = Utils.a(f);
    }

    public float m() {
        return this.d;
    }

    public float n() {
        return this.f22212c;
    }

    public float o() {
        return Math.min(this.b.width(), this.b.height());
    }

    public Matrix p() {
        return this.f22211a;
    }

    public float q() {
        return this.l;
    }

    public float r() {
        return this.m;
    }

    public boolean s() {
        return u() && t();
    }

    public boolean t() {
        float f = this.m;
        float f2 = this.h;
        return f <= f2 && f2 <= 1.0f;
    }

    public boolean u() {
        float f = this.l;
        float f2 = this.j;
        return f <= f2 && f2 <= 1.0f;
    }

    public boolean v() {
        return this.p <= 0.0f && this.q <= 0.0f;
    }

    public boolean w() {
        return this.l > this.j;
    }

    public boolean x() {
        return this.l < this.k;
    }

    public boolean y() {
        return this.m > this.h;
    }

    public boolean z() {
        return this.m < this.i;
    }
}
