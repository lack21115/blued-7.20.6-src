package androidx.core.content.res;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/content/res/ViewingConditions.class */
final class ViewingConditions {

    /* renamed from: a  reason: collision with root package name */
    static final ViewingConditions f2395a = a(CamUtils.f2377c, (float) ((CamUtils.c(50.0f) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);
    private final float b;

    /* renamed from: c  reason: collision with root package name */
    private final float f2396c;
    private final float d;
    private final float e;
    private final float f;
    private final float g;
    private final float[] h;
    private final float i;
    private final float j;
    private final float k;

    private ViewingConditions(float f, float f2, float f3, float f4, float f5, float f6, float[] fArr, float f7, float f8, float f9) {
        this.g = f;
        this.b = f2;
        this.f2396c = f3;
        this.d = f4;
        this.e = f5;
        this.f = f6;
        this.h = fArr;
        this.i = f7;
        this.j = f8;
        this.k = f9;
    }

    static ViewingConditions a(float[] fArr, float f, float f2, float f3, boolean z) {
        float[][] fArr2 = CamUtils.f2376a;
        float f4 = (fArr[0] * fArr2[0][0]) + (fArr[1] * fArr2[0][1]) + (fArr[2] * fArr2[0][2]);
        float f5 = (fArr[0] * fArr2[1][0]) + (fArr[1] * fArr2[1][1]) + (fArr[2] * fArr2[1][2]);
        float f6 = (fArr[0] * fArr2[2][0]) + (fArr[1] * fArr2[2][1]) + (fArr[2] * fArr2[2][2]);
        float f7 = (f3 / 10.0f) + 0.8f;
        float a2 = ((double) f7) >= 0.9d ? CamUtils.a(0.59f, 0.69f, (f7 - 0.9f) * 10.0f) : CamUtils.a(0.525f, 0.59f, (f7 - 0.8f) * 10.0f);
        float exp = z ? 1.0f : (1.0f - (((float) Math.exp(((-f) - 42.0f) / 92.0f)) * 0.2777778f)) * f7;
        double d = exp;
        if (d > 1.0d) {
            exp = 1.0f;
        } else if (d < 0.0d) {
            exp = 0.0f;
        }
        float[] fArr3 = {(((100.0f / f4) * exp) + 1.0f) - exp, (((100.0f / f5) * exp) + 1.0f) - exp, (((100.0f / f6) * exp) + 1.0f) - exp};
        float f8 = 1.0f / ((5.0f * f) + 1.0f);
        float f9 = f8 * f8 * f8 * f8;
        float f10 = 1.0f - f9;
        float cbrt = (f9 * f) + (0.1f * f10 * f10 * ((float) Math.cbrt(f * 5.0d)));
        float c2 = CamUtils.c(f2) / fArr[1];
        double d2 = c2;
        float sqrt = (float) Math.sqrt(d2);
        float pow = 0.725f / ((float) Math.pow(d2, 0.2d));
        float[] fArr4 = {(float) Math.pow(((fArr3[0] * cbrt) * f4) / 100.0d, 0.42d), (float) Math.pow(((fArr3[1] * cbrt) * f5) / 100.0d, 0.42d), (float) Math.pow(((fArr3[2] * cbrt) * f6) / 100.0d, 0.42d)};
        float[] fArr5 = {(fArr4[0] * 400.0f) / (fArr4[0] + 27.13f), (fArr4[1] * 400.0f) / (fArr4[1] + 27.13f), (fArr4[2] * 400.0f) / (fArr4[2] + 27.13f)};
        return new ViewingConditions(c2, ((fArr5[0] * 2.0f) + fArr5[1] + (fArr5[2] * 0.05f)) * pow, pow, pow, a2, f7, fArr3, cbrt, (float) Math.pow(cbrt, 0.25d), sqrt + 1.48f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float a() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float b() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float c() {
        return this.f2396c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float d() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float e() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float f() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float[] g() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float h() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float i() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float j() {
        return this.k;
    }
}
