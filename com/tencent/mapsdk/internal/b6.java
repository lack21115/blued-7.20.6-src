package com.tencent.mapsdk.internal;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/b6.class */
public class b6 {

    /* renamed from: a  reason: collision with root package name */
    private d6 f37314a;
    private d6 b;

    /* renamed from: c  reason: collision with root package name */
    private d6 f37315c;
    private e6 d;

    public b6() {
        this.d = new e6();
    }

    public b6(d6 d6Var, d6 d6Var2, d6 d6Var3) {
        this();
        a(d6Var, d6Var2, d6Var3);
    }

    public b6(float[] fArr) {
        this();
        a(new d6(fArr[0], fArr[1], fArr[2]), new d6(fArr[3], fArr[4], fArr[5]), new d6(fArr[6], fArr[7], fArr[8]));
    }

    private float a() {
        float[] a2 = this.d.a();
        float a3 = a(a2[0], a2[1], a2[2], a2[3], a2[4], a2[5]);
        float a4 = a(a2[3], a2[4], a2[5], a2[6], a2[7], a2[8]);
        float a5 = a(a2[0], a2[1], a2[2], a2[6], a2[7], a2[8]);
        float f = ((a3 + a4) + a5) / 2.0f;
        return (float) Math.sqrt((f - a3) * f * (f - a4) * (f - a5));
    }

    private float a(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = f - f4;
        float f8 = f2 - f5;
        float f9 = f3 - f6;
        return (float) Math.sqrt((f7 * f7) + (f8 * f8) + (f9 * f9));
    }

    private void a(d6 d6Var, d6 d6Var2, d6 d6Var3) {
        this.f37314a = d6Var;
        this.b = d6Var2;
        this.f37315c = d6Var3;
        this.d.a(d6Var);
        this.d.a(d6Var2);
        this.d.a(d6Var3);
    }

    public boolean a(float[] fArr) {
        boolean z = false;
        d6 d6Var = new d6(fArr[0], fArr[1], fArr[2]);
        if (Math.abs(a() - ((new b6(d6Var, this.f37314a, this.b).a() + new b6(d6Var, this.f37314a, this.f37315c).a()) + new b6(d6Var, this.b, this.f37315c).a())) < 0.001d) {
            z = true;
        }
        return z;
    }

    public float[] b() {
        return this.d.a();
    }
}
