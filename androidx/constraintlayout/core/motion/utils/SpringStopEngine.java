package androidx.constraintlayout.core.motion.utils;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/SpringStopEngine.class */
public class SpringStopEngine implements StopEngine {

    /* renamed from: c  reason: collision with root package name */
    private double f2012c;
    private double d;
    private double e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;

    /* renamed from: a  reason: collision with root package name */
    double f2011a = 0.5d;
    private boolean b = false;
    private int k = 0;

    private void a(double d) {
        double d2 = this.f2012c;
        double d3 = this.f2011a;
        int sqrt = (int) ((9.0d / ((Math.sqrt(d2 / this.i) * d) * 4.0d)) + 1.0d);
        double d4 = d / sqrt;
        for (int i = 0; i < sqrt; i++) {
            float f = this.g;
            double d5 = f;
            double d6 = this.d;
            double d7 = -d2;
            float f2 = this.h;
            double d8 = f2;
            float f3 = this.i;
            double d9 = f2 + (((((d7 * (d5 - d6)) - (d8 * d3)) / f3) * d4) / 2.0d);
            double d10 = ((((-((f + ((d4 * d9) / 2.0d)) - d6)) * d2) - (d9 * d3)) / f3) * d4;
            double d11 = f2;
            double d12 = d10 / 2.0d;
            float f4 = (float) (f2 + d10);
            this.h = f4;
            float f5 = (float) (f + ((d11 + d12) * d4));
            this.g = f5;
            int i2 = this.k;
            if (i2 > 0) {
                if (f5 < 0.0f && (i2 & 1) == 1) {
                    this.g = -f5;
                    this.h = -f4;
                }
                float f6 = this.g;
                if (f6 > 1.0f && (this.k & 2) == 2) {
                    this.g = 2.0f - f6;
                    this.h = -this.h;
                }
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public String debug(String str, float f) {
        return null;
    }

    public float getAcceleration() {
        return ((float) (((-this.f2012c) * (this.g - this.d)) - (this.f2011a * this.h))) / this.i;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getInterpolation(float f) {
        a(f - this.f);
        this.f = f;
        return this.g;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity() {
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity(float f) {
        return this.h;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public boolean isStopped() {
        double d = this.g - this.d;
        double d2 = this.f2012c;
        double d3 = this.h;
        return Math.sqrt((((d3 * d3) * ((double) this.i)) + ((d2 * d) * d)) / d2) <= ((double) this.j);
    }

    public void springConfig(float f, float f2, float f3, float f4, float f5, float f6, float f7, int i) {
        this.d = f2;
        this.f2011a = f6;
        this.b = false;
        this.g = f;
        this.e = f3;
        this.f2012c = f5;
        this.i = f4;
        this.j = f7;
        this.k = i;
        this.f = 0.0f;
    }
}
