package androidx.dynamicanimation.animation;

import androidx.dynamicanimation.animation.DynamicAnimation;

/* loaded from: source-8756600-dex2jar.jar:androidx/dynamicanimation/animation/SpringForce.class */
public final class SpringForce implements Force {
    public static final float DAMPING_RATIO_HIGH_BOUNCY = 0.2f;
    public static final float DAMPING_RATIO_LOW_BOUNCY = 0.75f;
    public static final float DAMPING_RATIO_MEDIUM_BOUNCY = 0.5f;
    public static final float DAMPING_RATIO_NO_BOUNCY = 1.0f;
    public static final float STIFFNESS_HIGH = 10000.0f;
    public static final float STIFFNESS_LOW = 200.0f;
    public static final float STIFFNESS_MEDIUM = 1500.0f;
    public static final float STIFFNESS_VERY_LOW = 50.0f;

    /* renamed from: a  reason: collision with root package name */
    double f2761a;
    double b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2762c;
    private double d;
    private double e;
    private double f;
    private double g;
    private double h;
    private double i;
    private final DynamicAnimation.MassState j;

    public SpringForce() {
        this.f2761a = Math.sqrt(1500.0d);
        this.b = 0.5d;
        this.f2762c = false;
        this.i = Double.MAX_VALUE;
        this.j = new DynamicAnimation.MassState();
    }

    public SpringForce(float f) {
        this.f2761a = Math.sqrt(1500.0d);
        this.b = 0.5d;
        this.f2762c = false;
        this.i = Double.MAX_VALUE;
        this.j = new DynamicAnimation.MassState();
        this.i = f;
    }

    private void a() {
        if (this.f2762c) {
            return;
        }
        if (this.i == Double.MAX_VALUE) {
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
        double d = this.b;
        if (d > 1.0d) {
            double d2 = -d;
            double d3 = this.f2761a;
            this.f = (d2 * d3) + (d3 * Math.sqrt((d * d) - 1.0d));
            double d4 = this.b;
            double d5 = -d4;
            double d6 = this.f2761a;
            this.g = (d5 * d6) - (d6 * Math.sqrt((d4 * d4) - 1.0d));
        } else if (d >= 0.0d && d < 1.0d) {
            this.h = this.f2761a * Math.sqrt(1.0d - (d * d));
        }
        this.f2762c = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DynamicAnimation.MassState a(double d, double d2, long j) {
        double pow;
        double cos;
        a();
        double d3 = j / 1000.0d;
        double d4 = d - this.i;
        double d5 = this.b;
        if (d5 > 1.0d) {
            double d6 = this.g;
            double d7 = this.f;
            double d8 = d4 - (((d6 * d4) - d2) / (d6 - d7));
            double d9 = ((d4 * d6) - d2) / (d6 - d7);
            pow = (Math.pow(2.718281828459045d, d6 * d3) * d8) + (Math.pow(2.718281828459045d, this.f * d3) * d9);
            double d10 = this.g;
            double pow2 = Math.pow(2.718281828459045d, d10 * d3);
            double d11 = this.f;
            cos = (d8 * d10 * pow2) + (d9 * d11 * Math.pow(2.718281828459045d, d11 * d3));
        } else if (d5 == 1.0d) {
            double d12 = this.f2761a;
            double d13 = d2 + (d12 * d4);
            double d14 = d4 + (d13 * d3);
            pow = Math.pow(2.718281828459045d, (-d12) * d3) * d14;
            double pow3 = Math.pow(2.718281828459045d, (-this.f2761a) * d3);
            double d15 = this.f2761a;
            cos = (d13 * Math.pow(2.718281828459045d, (-d15) * d3)) + (d14 * pow3 * (-d15));
        } else {
            double d16 = this.f2761a;
            double d17 = (1.0d / this.h) * ((d5 * d16 * d4) + d2);
            pow = Math.pow(2.718281828459045d, (-d5) * d16 * d3) * ((Math.cos(this.h * d3) * d4) + (Math.sin(this.h * d3) * d17));
            double d18 = this.f2761a;
            double d19 = -d18;
            double d20 = this.b;
            double pow4 = Math.pow(2.718281828459045d, (-d20) * d18 * d3);
            double d21 = this.h;
            double d22 = -d21;
            double sin = Math.sin(d21 * d3);
            double d23 = this.h;
            cos = (d19 * pow * d20) + (pow4 * ((d22 * d4 * sin) + (d17 * d23 * Math.cos(d23 * d3))));
        }
        this.j.f2756a = (float) (pow + this.i);
        this.j.b = (float) cos;
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(double d) {
        double abs = Math.abs(d);
        this.d = abs;
        this.e = abs * 62.5d;
    }

    @Override // androidx.dynamicanimation.animation.Force
    public float getAcceleration(float f, float f2) {
        float finalPosition = getFinalPosition();
        double d = this.f2761a;
        return (float) (((-(d * d)) * (f - finalPosition)) - (((d * 2.0d) * this.b) * f2));
    }

    public float getDampingRatio() {
        return (float) this.b;
    }

    public float getFinalPosition() {
        return (float) this.i;
    }

    public float getStiffness() {
        double d = this.f2761a;
        return (float) (d * d);
    }

    @Override // androidx.dynamicanimation.animation.Force
    public boolean isAtEquilibrium(float f, float f2) {
        return ((double) Math.abs(f2)) < this.e && ((double) Math.abs(f - getFinalPosition())) < this.d;
    }

    public SpringForce setDampingRatio(float f) {
        if (f >= 0.0f) {
            this.b = f;
            this.f2762c = false;
            return this;
        }
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    }

    public SpringForce setFinalPosition(float f) {
        this.i = f;
        return this;
    }

    public SpringForce setStiffness(float f) {
        if (f > 0.0f) {
            this.f2761a = Math.sqrt(f);
            this.f2762c = false;
            return this;
        }
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }
}
