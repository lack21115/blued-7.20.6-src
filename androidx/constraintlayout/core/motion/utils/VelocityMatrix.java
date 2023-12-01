package androidx.constraintlayout.core.motion.utils;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/VelocityMatrix.class */
public class VelocityMatrix {
    private static String g = "VelocityMatrix";

    /* renamed from: a  reason: collision with root package name */
    float f2021a;
    float b;

    /* renamed from: c  reason: collision with root package name */
    float f2022c;
    float d;
    float e;
    float f;

    public void applyTransform(float f, float f2, int i, int i2, float[] fArr) {
        float f3 = fArr[0];
        float f4 = fArr[1];
        float f5 = (f - 0.5f) * 2.0f;
        float f6 = (f2 - 0.5f) * 2.0f;
        float f7 = this.f2022c;
        float f8 = this.d;
        float f9 = this.f2021a;
        float f10 = this.b;
        float radians = (float) Math.toRadians(this.f);
        float radians2 = (float) Math.toRadians(this.e);
        double d = (-i) * f5;
        double d2 = radians;
        double sin = Math.sin(d2);
        double d3 = i2 * f6;
        fArr[0] = f3 + f7 + (f9 * f5) + (((float) ((d * sin) - (Math.cos(d2) * d3))) * radians2);
        fArr[1] = f4 + f8 + (f10 * f6) + (radians2 * ((float) (((i * f5) * Math.cos(d2)) - (d3 * Math.sin(d2)))));
    }

    public void clear() {
        this.e = 0.0f;
        this.d = 0.0f;
        this.f2022c = 0.0f;
        this.b = 0.0f;
        this.f2021a = 0.0f;
    }

    public void setRotationVelocity(KeyCycleOscillator keyCycleOscillator, float f) {
        if (keyCycleOscillator != null) {
            this.e = keyCycleOscillator.getSlope(f);
        }
    }

    public void setRotationVelocity(SplineSet splineSet, float f) {
        if (splineSet != null) {
            this.e = splineSet.getSlope(f);
            this.f = splineSet.get(f);
        }
    }

    public void setScaleVelocity(KeyCycleOscillator keyCycleOscillator, KeyCycleOscillator keyCycleOscillator2, float f) {
        if (keyCycleOscillator != null) {
            this.f2021a = keyCycleOscillator.getSlope(f);
        }
        if (keyCycleOscillator2 != null) {
            this.b = keyCycleOscillator2.getSlope(f);
        }
    }

    public void setScaleVelocity(SplineSet splineSet, SplineSet splineSet2, float f) {
        if (splineSet != null) {
            this.f2021a = splineSet.getSlope(f);
        }
        if (splineSet2 != null) {
            this.b = splineSet2.getSlope(f);
        }
    }

    public void setTranslationVelocity(KeyCycleOscillator keyCycleOscillator, KeyCycleOscillator keyCycleOscillator2, float f) {
        if (keyCycleOscillator != null) {
            this.f2022c = keyCycleOscillator.getSlope(f);
        }
        if (keyCycleOscillator2 != null) {
            this.d = keyCycleOscillator2.getSlope(f);
        }
    }

    public void setTranslationVelocity(SplineSet splineSet, SplineSet splineSet2, float f) {
        if (splineSet != null) {
            this.f2022c = splineSet.getSlope(f);
        }
        if (splineSet2 != null) {
            this.d = splineSet2.getSlope(f);
        }
    }
}
