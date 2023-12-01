package net.simonvt.numberpicker;

import android.content.Context;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* loaded from: source-3503164-dex2jar.jar:net/simonvt/numberpicker/Scroller.class */
public class Scroller {
    private static float B;
    private static float C;
    private static float u = (float) (Math.log(0.75d) / Math.log(0.9d));
    private static float v = 800.0f;
    private static float w = 0.4f;
    private static float x = 1.0f - 0.4f;
    private static final float[] y = new float[101];
    private final float A;
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private long l;
    private int m;
    private float n;
    private float o;
    private float p;
    private boolean q;
    private Interpolator r;
    private boolean s;
    private float t;
    private float z;

    static {
        float f;
        float f2;
        float f3 = 0.0f;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 > 100) {
                y[100] = 1.0f;
                B = 8.0f;
                C = 1.0f;
                C = 1.0f / a(1.0f);
                return;
            }
            float f4 = i2 / 100.0f;
            float f5 = 1.0f;
            while (true) {
                float f6 = ((f5 - f3) / 2.0f) + f3;
                float f7 = 1.0f - f6;
                f = 3.0f * f6 * f7;
                f2 = f6 * f6 * f6;
                float f8 = (((f7 * w) + (x * f6)) * f) + f2;
                if (Math.abs(f8 - f4) < 1.0E-5d) {
                    break;
                } else if (f8 > f4) {
                    f5 = f6;
                } else {
                    f3 = f6;
                }
            }
            y[i2] = f + f2;
            i = i2 + 1;
        }
    }

    public Scroller(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public Scroller(Context context, Interpolator interpolator, boolean z) {
        this.q = true;
        this.r = interpolator;
        this.A = context.getResources().getDisplayMetrics().density * 160.0f;
        this.z = b(ViewConfiguration.getScrollFriction());
        this.s = z;
    }

    static float a(float f) {
        float f2 = f * B;
        return (f2 < 1.0f ? f2 - (1.0f - ((float) Math.exp(-f2))) : ((1.0f - ((float) Math.exp(1.0f - f2))) * 0.63212055f) + 0.36787945f) * C;
    }

    private float b(float f) {
        return this.A * 386.0878f * f;
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        this.a = 0;
        this.q = false;
        this.m = i5;
        this.l = AnimationUtils.currentAnimationTimeMillis();
        this.b = i;
        this.c = i2;
        this.d = i + i3;
        this.e = i2 + i4;
        this.o = i3;
        this.p = i4;
        this.n = 1.0f / this.m;
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (this.s && !this.q) {
            float c = c();
            float f = this.d - this.b;
            float f2 = this.e - this.c;
            float sqrt = (float) Math.sqrt((f * f) + (f2 * f2));
            float f3 = f / sqrt;
            float f4 = f2 / sqrt;
            float f5 = f3 * c;
            float f6 = f4 * c;
            float f7 = i3;
            if (Math.signum(f7) == Math.signum(f5)) {
                float f8 = i4;
                i3 = i3;
                if (Math.signum(f8) == Math.signum(f6)) {
                    i3 = (int) (f7 + f5);
                    i4 = (int) (f8 + f6);
                }
            }
        }
        this.a = 1;
        this.q = false;
        float sqrt2 = (float) Math.sqrt((i3 * i3) + (i4 * i4));
        this.t = sqrt2;
        double log = Math.log((w * sqrt2) / v);
        this.m = (int) (Math.exp(log / (u - 1.0d)) * 1000.0d);
        this.l = AnimationUtils.currentAnimationTimeMillis();
        this.b = i;
        this.c = i2;
        float f9 = 1.0f;
        int i9 = (sqrt2 > 0.0f ? 1 : (sqrt2 == 0.0f ? 0 : -1));
        float f10 = i9 == 0 ? 1.0f : i3 / sqrt2;
        if (i9 != 0) {
            f9 = i4 / sqrt2;
        }
        double d = v;
        float f11 = u;
        this.f = i5;
        this.g = i6;
        this.h = i7;
        this.i = i8;
        float exp = (int) (d * Math.exp((f11 / (f11 - 1.0d)) * log));
        int round = i + Math.round(f10 * exp);
        this.d = round;
        int min = Math.min(round, this.g);
        this.d = min;
        this.d = Math.max(min, this.f);
        int round2 = Math.round(exp * f9) + i2;
        this.e = round2;
        int min2 = Math.min(round2, this.i);
        this.e = min2;
        this.e = Math.max(min2, this.h);
    }

    public final void a(boolean z) {
        this.q = z;
    }

    public final boolean a() {
        return this.q;
    }

    public final int b() {
        return this.k;
    }

    public float c() {
        return this.t - ((this.z * g()) / 2000.0f);
    }

    public final int d() {
        return this.c;
    }

    public final int e() {
        return this.e;
    }

    public boolean f() {
        if (this.q) {
            return false;
        }
        int currentAnimationTimeMillis = (int) (AnimationUtils.currentAnimationTimeMillis() - this.l);
        int i = this.m;
        if (currentAnimationTimeMillis >= i) {
            this.j = this.d;
            this.k = this.e;
            this.q = true;
            return true;
        }
        int i2 = this.a;
        if (i2 == 0) {
            float f = currentAnimationTimeMillis * this.n;
            Interpolator interpolator = this.r;
            float a = interpolator == null ? a(f) : interpolator.getInterpolation(f);
            this.j = this.b + Math.round(this.o * a);
            this.k = this.c + Math.round(a * this.p);
            return true;
        } else if (i2 != 1) {
            return true;
        } else {
            float f2 = currentAnimationTimeMillis / i;
            int i3 = (int) (f2 * 100.0f);
            float f3 = i3 / 100.0f;
            int i4 = i3 + 1;
            float f4 = i4 / 100.0f;
            float[] fArr = y;
            float f5 = fArr[i3];
            float f6 = f5 + (((f2 - f3) / (f4 - f3)) * (fArr[i4] - f5));
            int i5 = this.b;
            int round = i5 + Math.round((this.d - i5) * f6);
            this.j = round;
            int min = Math.min(round, this.g);
            this.j = min;
            this.j = Math.max(min, this.f);
            int i6 = this.c;
            int round2 = i6 + Math.round(f6 * (this.e - i6));
            this.k = round2;
            int min2 = Math.min(round2, this.i);
            this.k = min2;
            int max = Math.max(min2, this.h);
            this.k = max;
            if (this.j == this.d && max == this.e) {
                this.q = true;
                return true;
            }
            return true;
        }
    }

    public int g() {
        return (int) (AnimationUtils.currentAnimationTimeMillis() - this.l);
    }
}
