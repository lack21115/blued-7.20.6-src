package androidx.core.content.res;

import androidx.core.graphics.ColorUtils;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/content/res/CamColor.class */
class CamColor {

    /* renamed from: a  reason: collision with root package name */
    private final float f2422a;
    private final float b;

    /* renamed from: c  reason: collision with root package name */
    private final float f2423c;
    private final float d;
    private final float e;
    private final float f;
    private final float g;
    private final float h;
    private final float i;

    CamColor(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.f2422a = f;
        this.b = f2;
        this.f2423c = f3;
        this.d = f4;
        this.e = f5;
        this.f = f6;
        this.g = f7;
        this.h = f8;
        this.i = f9;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(float f, float f2, float f3) {
        return a(f, f2, f3, ViewingConditions.f2443a);
    }

    static int a(float f, float f2, float f3, ViewingConditions viewingConditions) {
        if (f2 < 1.0d || Math.round(f3) <= 0.0d || Math.round(f3) >= 100.0d) {
            return CamUtils.a(f3);
        }
        float min = f < 0.0f ? 0.0f : Math.min(360.0f, f);
        float f4 = f2;
        CamColor camColor = null;
        float f5 = 0.0f;
        boolean z = true;
        while (Math.abs(f5 - f2) >= 0.4f) {
            CamColor c2 = c(min, f4, f3);
            if (z) {
                if (c2 != null) {
                    return c2.a(viewingConditions);
                }
                z = false;
            } else if (c2 == null) {
                f2 = f4;
            } else {
                camColor = c2;
                f5 = f4;
            }
            f4 = ((f2 - f5) / 2.0f) + f5;
        }
        return camColor == null ? CamUtils.a(f3) : camColor.a(viewingConditions);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CamColor a(int i) {
        return a(i, ViewingConditions.f2443a);
    }

    static CamColor a(int i, ViewingConditions viewingConditions) {
        float f;
        float pow;
        float[] c2 = CamUtils.c(i);
        float[][] fArr = CamUtils.f2424a;
        float f2 = c2[0];
        float f3 = fArr[0][0];
        float f4 = c2[1];
        float f5 = fArr[0][1];
        float f6 = c2[2];
        float f7 = fArr[0][2];
        float f8 = c2[0];
        float f9 = fArr[1][0];
        float f10 = c2[1];
        float f11 = fArr[1][1];
        float f12 = c2[2];
        float f13 = fArr[1][2];
        float f14 = c2[0];
        float f15 = fArr[2][0];
        float f16 = c2[1];
        float f17 = fArr[2][1];
        float f18 = c2[2];
        float f19 = fArr[2][2];
        float f20 = viewingConditions.g()[0] * ((f2 * f3) + (f4 * f5) + (f6 * f7));
        float f21 = viewingConditions.g()[1] * ((f8 * f9) + (f10 * f11) + (f12 * f13));
        float f22 = viewingConditions.g()[2] * ((f14 * f15) + (f16 * f17) + (f18 * f19));
        float pow2 = (float) Math.pow((viewingConditions.h() * Math.abs(f20)) / 100.0d, 0.42d);
        float pow3 = (float) Math.pow((viewingConditions.h() * Math.abs(f21)) / 100.0d, 0.42d);
        float pow4 = (float) Math.pow((viewingConditions.h() * Math.abs(f22)) / 100.0d, 0.42d);
        float signum = ((Math.signum(f20) * 400.0f) * pow2) / (pow2 + 27.13f);
        float signum2 = ((Math.signum(f21) * 400.0f) * pow3) / (pow3 + 27.13f);
        float signum3 = ((Math.signum(f22) * 400.0f) * pow4) / (pow4 + 27.13f);
        double d = signum;
        double d2 = signum2;
        double d3 = signum3;
        float f23 = ((float) (((d * 11.0d) + (d2 * (-12.0d))) + d3)) / 11.0f;
        float f24 = ((float) ((signum + signum2) - (d3 * 2.0d))) / 9.0f;
        float f25 = signum2 * 20.0f;
        float f26 = (((signum * 20.0f) + f25) + (21.0f * signum3)) / 20.0f;
        float f27 = (((signum * 40.0f) + f25) + signum3) / 20.0f;
        float atan2 = (((float) Math.atan2(f24, f23)) * 180.0f) / 3.1415927f;
        if (atan2 < 0.0f) {
            f = atan2 + 360.0f;
        } else {
            f = atan2;
            if (atan2 >= 360.0f) {
                f = atan2 - 360.0f;
            }
        }
        float f28 = (3.1415927f * f) / 180.0f;
        float pow5 = ((float) Math.pow((f27 * viewingConditions.c()) / viewingConditions.a(), viewingConditions.e() * viewingConditions.j())) * 100.0f;
        float e = 4.0f / viewingConditions.e();
        float sqrt = (float) Math.sqrt(pow5 / 100.0f);
        float a2 = viewingConditions.a();
        float i2 = viewingConditions.i();
        float pow6 = ((float) Math.pow(1.64d - Math.pow(0.29d, viewingConditions.b()), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos((((((double) f) < 20.14d ? 360.0f + f : f) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * viewingConditions.f()) * viewingConditions.d()) * ((float) Math.sqrt((f23 * f23) + (f24 * f24)))) / (f26 + 0.305f), 0.9d)) * ((float) Math.sqrt(pow5 / 100.0d));
        float i3 = pow6 * viewingConditions.i();
        float sqrt2 = (float) Math.sqrt((pow * viewingConditions.e()) / (viewingConditions.a() + 4.0f));
        float f29 = (1.7f * pow5) / ((0.007f * pow5) + 1.0f);
        float log = ((float) Math.log((0.0228f * i3) + 1.0f)) * 43.85965f;
        double d4 = f28;
        return new CamColor(f, pow6, pow5, i2 * e * sqrt * (a2 + 4.0f), i3, sqrt2 * 50.0f, f29, log * ((float) Math.cos(d4)), log * ((float) Math.sin(d4)));
    }

    private static CamColor b(float f, float f2, float f3) {
        return b(f, f2, f3, ViewingConditions.f2443a);
    }

    private static CamColor b(float f, float f2, float f3, ViewingConditions viewingConditions) {
        double d;
        float e = 4.0f / viewingConditions.e();
        float sqrt = (float) Math.sqrt(f / 100.0d);
        float a2 = viewingConditions.a();
        float i = viewingConditions.i();
        float i2 = f2 * viewingConditions.i();
        float sqrt2 = (float) Math.sqrt(((f2 / ((float) Math.sqrt(d))) * viewingConditions.e()) / (viewingConditions.a() + 4.0f));
        float f4 = (1.7f * f) / ((0.007f * f) + 1.0f);
        float log = ((float) Math.log((i2 * 0.0228d) + 1.0d)) * 43.85965f;
        double d2 = (3.1415927f * f3) / 180.0f;
        return new CamColor(f3, f2, f, e * sqrt * (a2 + 4.0f) * i, i2, sqrt2 * 50.0f, f4, log * ((float) Math.cos(d2)), log * ((float) Math.sin(d2)));
    }

    private static CamColor c(float f, float f2, float f3) {
        float f4 = 1000.0f;
        CamColor camColor = null;
        float f5 = 1000.0f;
        float f6 = 100.0f;
        float f7 = 0.0f;
        while (Math.abs(f7 - f6) > 0.01f) {
            float f8 = ((f6 - f7) / 2.0f) + f7;
            int g = b(f8, f2, f).g();
            float a2 = CamUtils.a(g);
            float abs = Math.abs(f3 - a2);
            float f9 = f4;
            float f10 = f5;
            CamColor camColor2 = camColor;
            if (abs < 0.2f) {
                CamColor a3 = a(g);
                float a4 = a3.a(b(a3.c(), a3.b(), f));
                f9 = f4;
                f10 = f5;
                camColor2 = camColor;
                if (a4 <= 1.0f) {
                    camColor2 = a3;
                    f9 = abs;
                    f10 = a4;
                }
            }
            if (f9 == 0.0f && f10 == 0.0f) {
                return camColor2;
            }
            if (a2 < f3) {
                f7 = f8;
                f4 = f9;
                f5 = f10;
                camColor = camColor2;
            } else {
                f6 = f8;
                f4 = f9;
                f5 = f10;
                camColor = camColor2;
            }
        }
        return camColor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float a() {
        return this.f2422a;
    }

    float a(CamColor camColor) {
        float d = d() - camColor.d();
        float e = e() - camColor.e();
        float f = f() - camColor.f();
        return (float) (Math.pow(Math.sqrt((d * d) + (e * e) + (f * f)), 0.63d) * 1.41d);
    }

    int a(ViewingConditions viewingConditions) {
        float pow = (float) Math.pow(((((double) b()) == 0.0d || ((double) c()) == 0.0d) ? 0.0f : b() / ((float) Math.sqrt(c() / 100.0d))) / Math.pow(1.64d - Math.pow(0.29d, viewingConditions.b()), 0.73d), 1.1111111111111112d);
        double a2 = (a() * 3.1415927f) / 180.0f;
        float cos = (float) (Math.cos(2.0d + a2) + 3.8d);
        float a3 = viewingConditions.a();
        float pow2 = (float) Math.pow(c() / 100.0d, (1.0d / viewingConditions.e()) / viewingConditions.j());
        float f = viewingConditions.f();
        float d = viewingConditions.d();
        float c2 = (a3 * pow2) / viewingConditions.c();
        float sin = (float) Math.sin(a2);
        float cos2 = (float) Math.cos(a2);
        float f2 = (((0.305f + c2) * 23.0f) * pow) / (((((((cos * 0.25f) * 3846.1538f) * f) * d) * 23.0f) + ((11.0f * pow) * cos2)) + ((pow * 108.0f) * sin));
        float f3 = cos2 * f2;
        float f4 = f2 * sin;
        float f5 = c2 * 460.0f;
        float f6 = (((451.0f * f3) + f5) + (288.0f * f4)) / 1403.0f;
        float f7 = ((f5 - (891.0f * f3)) - (261.0f * f4)) / 1403.0f;
        float f8 = ((f5 - (f3 * 220.0f)) - (f4 * 6300.0f)) / 1403.0f;
        float max = (float) Math.max(0.0d, (Math.abs(f6) * 27.13d) / (400.0d - Math.abs(f6)));
        float signum = Math.signum(f6);
        float h = 100.0f / viewingConditions.h();
        float pow3 = (float) Math.pow(max, 2.380952380952381d);
        float max2 = (float) Math.max(0.0d, (Math.abs(f7) * 27.13d) / (400.0d - Math.abs(f7)));
        float signum2 = Math.signum(f7);
        float h2 = 100.0f / viewingConditions.h();
        float pow4 = (float) Math.pow(max2, 2.380952380952381d);
        float max3 = (float) Math.max(0.0d, (Math.abs(f8) * 27.13d) / (400.0d - Math.abs(f8)));
        float signum3 = Math.signum(f8);
        float h3 = 100.0f / viewingConditions.h();
        float pow5 = (float) Math.pow(max3, 2.380952380952381d);
        float f9 = ((signum * h) * pow3) / viewingConditions.g()[0];
        float f10 = ((signum2 * h2) * pow4) / viewingConditions.g()[1];
        float f11 = ((signum3 * h3) * pow5) / viewingConditions.g()[2];
        float[][] fArr = CamUtils.b;
        return ColorUtils.XYZToColor((fArr[0][0] * f9) + (fArr[0][1] * f10) + (fArr[0][2] * f11), (fArr[1][0] * f9) + (fArr[1][1] * f10) + (fArr[1][2] * f11), (f9 * fArr[2][0]) + (f10 * fArr[2][1]) + (f11 * fArr[2][2]));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float b() {
        return this.b;
    }

    float c() {
        return this.f2423c;
    }

    float d() {
        return this.g;
    }

    float e() {
        return this.h;
    }

    float f() {
        return this.i;
    }

    int g() {
        return a(ViewingConditions.f2443a);
    }
}
