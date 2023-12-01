package androidx.constraintlayout.core.motion.utils;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/StopLogicEngine.class */
public class StopLogicEngine implements StopEngine {

    /* renamed from: a  reason: collision with root package name */
    private float f2014a;
    private float b;

    /* renamed from: c  reason: collision with root package name */
    private float f2015c;
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;
    private int j;
    private String k;
    private float m;
    private float n;
    private boolean l = false;
    private boolean o = false;

    private float a(float f) {
        this.o = false;
        float f2 = this.d;
        if (f <= f2) {
            float f3 = this.f2014a;
            return (f3 * f) + ((((this.b - f3) * f) * f) / (f2 * 2.0f));
        }
        int i = this.j;
        if (i == 1) {
            return this.g;
        }
        float f4 = f - f2;
        float f5 = this.e;
        if (f4 < f5) {
            float f6 = this.g;
            float f7 = this.b;
            return f6 + (f7 * f4) + ((((this.f2015c - f7) * f4) * f4) / (f5 * 2.0f));
        } else if (i == 2) {
            return this.h;
        } else {
            float f8 = f4 - f5;
            float f9 = this.f;
            if (f8 > f9) {
                this.o = true;
                return this.i;
            }
            float f10 = this.h;
            float f11 = this.f2015c;
            return (f10 + (f11 * f8)) - (((f11 * f8) * f8) / (f9 * 2.0f));
        }
    }

    private void a(float f, float f2, float f3, float f4, float f5) {
        this.o = false;
        float f6 = f;
        if (f == 0.0f) {
            f6 = 1.0E-4f;
        }
        this.f2014a = f6;
        float f7 = f6 / f3;
        float f8 = (f7 * f6) / 2.0f;
        if (f6 < 0.0f) {
            float sqrt = (float) Math.sqrt((f2 - ((((-f6) / f3) * f6) / 2.0f)) * f3);
            if (sqrt < f4) {
                this.k = "backward accelerate, decelerate";
                this.j = 2;
                this.f2014a = f6;
                this.b = sqrt;
                this.f2015c = 0.0f;
                float f9 = (sqrt - f6) / f3;
                this.d = f9;
                this.e = sqrt / f3;
                this.g = ((f6 + sqrt) * f9) / 2.0f;
                this.h = f2;
                this.i = f2;
                return;
            }
            this.k = "backward accelerate cruse decelerate";
            this.j = 3;
            this.f2014a = f6;
            this.b = f4;
            this.f2015c = f4;
            float f10 = (f4 - f6) / f3;
            this.d = f10;
            float f11 = f4 / f3;
            this.f = f11;
            float f12 = ((f6 + f4) * f10) / 2.0f;
            float f13 = (f11 * f4) / 2.0f;
            this.e = ((f2 - f12) - f13) / f4;
            this.g = f12;
            this.h = f2 - f13;
            this.i = f2;
        } else if (f8 >= f2) {
            this.k = "hard stop";
            this.j = 1;
            this.f2014a = f6;
            this.b = 0.0f;
            this.g = f2;
            this.d = (2.0f * f2) / f6;
        } else {
            float f14 = f2 - f8;
            float f15 = f14 / f6;
            if (f15 + f7 < f5) {
                this.k = "cruse decelerate";
                this.j = 2;
                this.f2014a = f6;
                this.b = f6;
                this.f2015c = 0.0f;
                this.g = f14;
                this.h = f2;
                this.d = f15;
                this.e = f7;
                return;
            }
            float sqrt2 = (float) Math.sqrt((f3 * f2) + ((f6 * f6) / 2.0f));
            float f16 = (sqrt2 - f6) / f3;
            this.d = f16;
            float f17 = sqrt2 / f3;
            this.e = f17;
            if (sqrt2 < f4) {
                this.k = "accelerate decelerate";
                this.j = 2;
                this.f2014a = f6;
                this.b = sqrt2;
                this.f2015c = 0.0f;
                this.d = f16;
                this.e = f17;
                this.g = ((f6 + sqrt2) * f16) / 2.0f;
                this.h = f2;
                return;
            }
            this.k = "accelerate cruse decelerate";
            this.j = 3;
            this.f2014a = f6;
            this.b = f4;
            this.f2015c = f4;
            float f18 = (f4 - f6) / f3;
            this.d = f18;
            float f19 = f4 / f3;
            this.f = f19;
            float f20 = ((f6 + f4) * f18) / 2.0f;
            float f21 = (f19 * f4) / 2.0f;
            this.e = ((f2 - f20) - f21) / f4;
            this.g = f20;
            this.h = f2 - f21;
            this.i = f2;
        }
    }

    public void config(float f, float f2, float f3, float f4, float f5, float f6) {
        boolean z = false;
        this.o = false;
        this.m = f;
        if (f > f2) {
            z = true;
        }
        this.l = z;
        if (z) {
            a(-f3, f - f2, f5, f6, f4);
        } else {
            a(f3, f2 - f, f5, f6, f4);
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public String debug(String str, float f) {
        StringBuilder sb = new StringBuilder();
        sb.append(str + " ===== " + this.k + "\n");
        sb.append(str);
        sb.append(this.l ? "backwards" : "forward ");
        sb.append(" time = ");
        sb.append(f);
        sb.append("  stages ");
        sb.append(this.j);
        sb.append("\n");
        String str2 = sb.toString() + str + " dur " + this.d + " vel " + this.f2014a + " pos " + this.g + "\n";
        String str3 = str2;
        if (this.j > 1) {
            str3 = str2 + str + " dur " + this.e + " vel " + this.b + " pos " + this.h + "\n";
        }
        String str4 = str3;
        if (this.j > 2) {
            str4 = str3 + str + " dur " + this.f + " vel " + this.f2015c + " pos " + this.i + "\n";
        }
        float f2 = this.d;
        if (f <= f2) {
            return str4 + str + "stage 0\n";
        }
        int i = this.j;
        if (i == 1) {
            return str4 + str + "end stage 0\n";
        }
        float f3 = f - f2;
        float f4 = this.e;
        if (f3 < f4) {
            return str4 + str + " stage 1\n";
        } else if (i == 2) {
            return str4 + str + "end stage 1\n";
        } else if (f3 - f4 < this.f) {
            return str4 + str + " stage 2\n";
        } else {
            return str4 + str + " end stage 2\n";
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getInterpolation(float f) {
        float a2 = a(f);
        this.n = f;
        return this.l ? this.m - a2 : this.m + a2;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity() {
        return this.l ? -getVelocity(this.n) : getVelocity(this.n);
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity(float f) {
        float f2 = this.d;
        if (f <= f2) {
            float f3 = this.f2014a;
            return f3 + (((this.b - f3) * f) / f2);
        }
        int i = this.j;
        if (i == 1) {
            return 0.0f;
        }
        float f4 = f - f2;
        float f5 = this.e;
        if (f4 < f5) {
            float f6 = this.b;
            return f6 + (((this.f2015c - f6) * f4) / f5);
        } else if (i == 2) {
            return this.h;
        } else {
            float f7 = f4 - f5;
            float f8 = this.f;
            if (f7 < f8) {
                float f9 = this.f2015c;
                return f9 - ((f7 * f9) / f8);
            }
            return this.i;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public boolean isStopped() {
        return getVelocity() < 1.0E-5f && Math.abs(this.i - this.n) < 1.0E-5f;
    }
}
