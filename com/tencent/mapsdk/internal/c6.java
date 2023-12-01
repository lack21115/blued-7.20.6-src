package com.tencent.mapsdk.internal;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/c6.class */
public class c6 {

    /* renamed from: a  reason: collision with root package name */
    private float f37348a;
    private float b;

    /* renamed from: c  reason: collision with root package name */
    private float f37349c;

    public c6(float f, float f2, float f3) {
        this.f37348a = f;
        this.b = f2;
        this.f37349c = f3;
        f();
    }

    public static c6 a(c6 c6Var, c6 c6Var2) {
        return new c6(c6Var.f37348a + c6Var2.f37348a, c6Var.b + c6Var2.b, c6Var.f37349c + c6Var2.f37349c);
    }

    public static c6 b(c6 c6Var) {
        return new c6(-c6Var.f37348a, -c6Var.b, -c6Var.f37349c);
    }

    public static c6 c(c6 c6Var) {
        float f = c6Var.f37348a;
        float f2 = c6Var.b;
        float b = (float) (f / c6Var.b());
        float b2 = (float) ((-f2) / c6Var.b());
        c6 c6Var2 = new c6(b, b2, 0.0f);
        c6 c6Var3 = c6Var2;
        if (c6Var2.a(c6Var) != 90.0d) {
            c6Var3 = new c6(-b, -b2, 0.0f);
        }
        return c6Var3;
    }

    private void f() {
        double b = b();
        if (b == 0.0d) {
            return;
        }
        this.f37348a = (float) (this.f37348a / b);
        this.b = (float) (this.b / b);
        this.f37349c = (float) (this.f37349c / b);
    }

    public double a(c6 c6Var) {
        return (Math.acos((((c() * c6Var.c()) + (d() * c6Var.d())) + (e() * c6Var.e())) / (b() * c6Var.b())) * 180.0d) / 3.141592653589793d;
    }

    public float[] a() {
        return new float[]{this.f37348a, this.b, this.f37349c};
    }

    public double b() {
        float f = this.f37348a;
        float f2 = this.b;
        float f3 = this.f37349c;
        return Math.sqrt((f * f) + (f2 * f2) + (f3 * f3));
    }

    public float c() {
        return this.f37348a;
    }

    public float d() {
        return this.b;
    }

    public float e() {
        return this.f37349c;
    }

    public String toString() {
        return this.f37348a + "," + this.b + "," + this.f37349c;
    }
}
