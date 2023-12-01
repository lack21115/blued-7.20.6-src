package com.github.mikephil.charting.animation;

import android.animation.TimeInterpolator;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/animation/Easing.class */
public class Easing {

    /* renamed from: a  reason: collision with root package name */
    public static final EasingFunction f22058a = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.1
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            return f2;
        }
    };
    public static final EasingFunction b = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.2
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            return f2 * f2;
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public static final EasingFunction f22059c = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.3
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            return (-f2) * (f2 - 2.0f);
        }
    };
    public static final EasingFunction d = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.4
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 * 2.0f;
            if (f3 < 1.0f) {
                return 0.5f * f3 * f3;
            }
            float f4 = f3 - 1.0f;
            return ((f4 * (f4 - 2.0f)) - 1.0f) * (-0.5f);
        }
    };
    public static final EasingFunction e = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.5
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            return (float) Math.pow(f2, 3.0d);
        }
    };
    public static final EasingFunction f = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.6
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            return ((float) Math.pow(f2 - 1.0f, 3.0d)) + 1.0f;
        }
    };
    public static final EasingFunction g = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.7
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 * 2.0f;
            return (f3 < 1.0f ? (float) Math.pow(f3, 3.0d) : ((float) Math.pow(f3 - 2.0f, 3.0d)) + 2.0f) * 0.5f;
        }
    };
    public static final EasingFunction h = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.8
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            return (float) Math.pow(f2, 4.0d);
        }
    };
    public static final EasingFunction i = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.9
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            return -(((float) Math.pow(f2 - 1.0f, 4.0d)) - 1.0f);
        }
    };
    public static final EasingFunction j = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.10
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 * 2.0f;
            return f3 < 1.0f ? ((float) Math.pow(f3, 4.0d)) * 0.5f : (((float) Math.pow(f3 - 2.0f, 4.0d)) - 2.0f) * (-0.5f);
        }
    };
    public static final EasingFunction k = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.11
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            return (-((float) Math.cos(f2 * 1.5707963267948966d))) + 1.0f;
        }
    };
    public static final EasingFunction l = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.12
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            return (float) Math.sin(f2 * 1.5707963267948966d);
        }
    };
    public static final EasingFunction m = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.13
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            return (((float) Math.cos(f2 * 3.141592653589793d)) - 1.0f) * (-0.5f);
        }
    };
    public static final EasingFunction n = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.14
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            if (f2 == 0.0f) {
                return 0.0f;
            }
            return (float) Math.pow(2.0d, (f2 - 1.0f) * 10.0f);
        }
    };
    public static final EasingFunction o = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.15
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            if (f2 == 1.0f) {
                return 1.0f;
            }
            return -((float) Math.pow(2.0d, (f2 + 1.0f) * (-10.0f)));
        }
    };
    public static final EasingFunction p = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.16
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            if (f2 == 0.0f) {
                return 0.0f;
            }
            if (f2 == 1.0f) {
                return 1.0f;
            }
            float f3 = f2 * 2.0f;
            return (f3 < 1.0f ? (float) Math.pow(2.0d, (f3 - 1.0f) * 10.0f) : (-((float) Math.pow(2.0d, (f3 - 1.0f) * (-10.0f)))) + 2.0f) * 0.5f;
        }
    };
    public static final EasingFunction q = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.17
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            return -(((float) Math.sqrt(1.0f - (f2 * f2))) - 1.0f);
        }
    };
    public static final EasingFunction r = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.18
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (float) Math.sqrt(1.0f - (f3 * f3));
        }
    };
    public static final EasingFunction s = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.19
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 * 2.0f;
            if (f3 < 1.0f) {
                return (((float) Math.sqrt(1.0f - (f3 * f3))) - 1.0f) * (-0.5f);
            }
            float f4 = f3 - 2.0f;
            return (((float) Math.sqrt(1.0f - (f4 * f4))) + 1.0f) * 0.5f;
        }
    };
    public static final EasingFunction t = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.20
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            if (f2 == 0.0f) {
                return 0.0f;
            }
            if (f2 == 1.0f) {
                return 1.0f;
            }
            float f3 = f2 - 1.0f;
            return -(((float) Math.pow(2.0d, 10.0f * f3)) * ((float) Math.sin(((f3 - (0.047746483f * ((float) Math.asin(1.0d)))) * 6.2831855f) / 0.3f)));
        }
    };
    public static final EasingFunction u = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.21
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            if (f2 == 0.0f) {
                return 0.0f;
            }
            if (f2 == 1.0f) {
                return 1.0f;
            }
            return (((float) Math.pow(2.0d, (-10.0f) * f2)) * ((float) Math.sin(((f2 - (0.047746483f * ((float) Math.asin(1.0d)))) * 6.2831855f) / 0.3f))) + 1.0f;
        }
    };
    public static final EasingFunction v = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.22
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            if (f2 == 0.0f) {
                return 0.0f;
            }
            float f3 = f2 * 2.0f;
            if (f3 == 2.0f) {
                return 1.0f;
            }
            float asin = ((float) Math.asin(1.0d)) * 0.07161972f;
            if (f3 < 1.0f) {
                float f4 = f3 - 1.0f;
                return ((float) Math.pow(2.0d, 10.0f * f4)) * ((float) Math.sin(((f4 * 1.0f) - asin) * 6.2831855f * 2.2222223f)) * (-0.5f);
            }
            float f5 = f3 - 1.0f;
            return (((float) Math.pow(2.0d, (-10.0f) * f5)) * 0.5f * ((float) Math.sin(((f5 * 1.0f) - asin) * 6.2831855f * 2.2222223f))) + 1.0f;
        }
    };
    public static final EasingFunction w = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.23
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            return f2 * f2 * ((f2 * 2.70158f) - 1.70158f);
        }
    };
    public static final EasingFunction x = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.24
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * ((f3 * 2.70158f) + 1.70158f)) + 1.0f;
        }
    };
    public static final EasingFunction y = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.25
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 * 2.0f;
            if (f3 < 1.0f) {
                return f3 * f3 * ((3.5949094f * f3) - 2.5949094f) * 0.5f;
            }
            float f4 = f3 - 2.0f;
            return ((f4 * f4 * ((3.5949094f * f4) + 2.5949094f)) + 2.0f) * 0.5f;
        }
    };
    public static final EasingFunction z = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.26
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            return 1.0f - Easing.A.getInterpolation(1.0f - f2);
        }
    };
    public static final EasingFunction A = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.27
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            if (f2 < 0.36363637f) {
                return 7.5625f * f2 * f2;
            }
            if (f2 < 0.72727275f) {
                float f3 = f2 - 0.54545456f;
                return (7.5625f * f3 * f3) + 0.75f;
            } else if (f2 < 0.90909094f) {
                float f4 = f2 - 0.8181818f;
                return (7.5625f * f4 * f4) + 0.9375f;
            } else {
                float f5 = f2 - 0.95454544f;
                return (7.5625f * f5 * f5) + 0.984375f;
            }
        }
    };
    public static final EasingFunction B = new EasingFunction() { // from class: com.github.mikephil.charting.animation.Easing.28
        @Override // com.github.mikephil.charting.animation.Easing.EasingFunction, android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            return f2 < 0.5f ? Easing.z.getInterpolation(f2 * 2.0f) * 0.5f : (Easing.A.getInterpolation((f2 * 2.0f) - 1.0f) * 0.5f) + 0.5f;
        }
    };

    /* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/animation/Easing$EasingFunction.class */
    public interface EasingFunction extends TimeInterpolator {
        @Override // android.animation.TimeInterpolator
        float getInterpolation(float f);
    }
}
