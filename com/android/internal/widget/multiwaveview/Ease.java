package com.android.internal.widget.multiwaveview;

import android.animation.TimeInterpolator;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/multiwaveview/Ease.class */
class Ease {
    private static final float DOMAIN = 1.0f;
    private static final float DURATION = 1.0f;
    private static final float START = 0.0f;

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/multiwaveview/Ease$Cubic.class */
    static class Cubic {
        public static final TimeInterpolator easeIn = new TimeInterpolator() { // from class: com.android.internal.widget.multiwaveview.Ease.Cubic.1
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                float f2 = f / 1.0f;
                return (1.0f * f2 * f2 * f2) + 0.0f;
            }
        };
        public static final TimeInterpolator easeOut = new TimeInterpolator() { // from class: com.android.internal.widget.multiwaveview.Ease.Cubic.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                float f2 = (f / 1.0f) - 1.0f;
                return (((f2 * f2 * f2) + 1.0f) * 1.0f) + 0.0f;
            }
        };
        public static final TimeInterpolator easeInOut = new TimeInterpolator() { // from class: com.android.internal.widget.multiwaveview.Ease.Cubic.3
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                float f2 = f / 0.5f;
                if (f2 < 1.0f) {
                    return (0.5f * f2 * f2 * f2) + 0.0f;
                }
                float f3 = f2 - 2.0f;
                return (((f3 * f3 * f3) + 2.0f) * 0.5f) + 0.0f;
            }
        };

        Cubic() {
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/multiwaveview/Ease$Linear.class */
    static class Linear {
        public static final TimeInterpolator easeNone = new TimeInterpolator() { // from class: com.android.internal.widget.multiwaveview.Ease.Linear.1
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return f;
            }
        };

        Linear() {
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/multiwaveview/Ease$Quad.class */
    static class Quad {
        public static final TimeInterpolator easeIn = new TimeInterpolator() { // from class: com.android.internal.widget.multiwaveview.Ease.Quad.1
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                float f2 = f / 1.0f;
                return (1.0f * f2 * f2) + 0.0f;
            }
        };
        public static final TimeInterpolator easeOut = new TimeInterpolator() { // from class: com.android.internal.widget.multiwaveview.Ease.Quad.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                float f2 = f / 1.0f;
                return ((-1.0f) * f2 * (f2 - 2.0f)) + 0.0f;
            }
        };
        public static final TimeInterpolator easeInOut = new TimeInterpolator() { // from class: com.android.internal.widget.multiwaveview.Ease.Quad.3
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                float f2 = f / 0.5f;
                if (f2 < 1.0f) {
                    return (0.5f * f2 * f2) + 0.0f;
                }
                float f3 = f2 - 1.0f;
                return ((-0.5f) * (((f3 - 2.0f) * f3) - 1.0f)) + 0.0f;
            }
        };

        Quad() {
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/multiwaveview/Ease$Quart.class */
    static class Quart {
        public static final TimeInterpolator easeIn = new TimeInterpolator() { // from class: com.android.internal.widget.multiwaveview.Ease.Quart.1
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                float f2 = f / 1.0f;
                return (1.0f * f2 * f2 * f2 * f2) + 0.0f;
            }
        };
        public static final TimeInterpolator easeOut = new TimeInterpolator() { // from class: com.android.internal.widget.multiwaveview.Ease.Quart.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                float f2 = (f / 1.0f) - 1.0f;
                return ((-1.0f) * ((((f2 * f2) * f2) * f2) - 1.0f)) + 0.0f;
            }
        };
        public static final TimeInterpolator easeInOut = new TimeInterpolator() { // from class: com.android.internal.widget.multiwaveview.Ease.Quart.3
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                float f2 = f / 0.5f;
                if (f2 < 1.0f) {
                    return (0.5f * f2 * f2 * f2 * f2) + 0.0f;
                }
                float f3 = f2 - 2.0f;
                return ((-0.5f) * ((((f3 * f3) * f3) * f3) - 2.0f)) + 0.0f;
            }
        };

        Quart() {
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/multiwaveview/Ease$Quint.class */
    static class Quint {
        public static final TimeInterpolator easeIn = new TimeInterpolator() { // from class: com.android.internal.widget.multiwaveview.Ease.Quint.1
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                float f2 = f / 1.0f;
                return (1.0f * f2 * f2 * f2 * f2 * f2) + 0.0f;
            }
        };
        public static final TimeInterpolator easeOut = new TimeInterpolator() { // from class: com.android.internal.widget.multiwaveview.Ease.Quint.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                float f2 = (f / 1.0f) - 1.0f;
                return (((f2 * f2 * f2 * f2 * f2) + 1.0f) * 1.0f) + 0.0f;
            }
        };
        public static final TimeInterpolator easeInOut = new TimeInterpolator() { // from class: com.android.internal.widget.multiwaveview.Ease.Quint.3
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                float f2 = f / 0.5f;
                if (f2 < 1.0f) {
                    return (0.5f * f2 * f2 * f2 * f2 * f2) + 0.0f;
                }
                float f3 = f2 - 2.0f;
                return (((f3 * f3 * f3 * f3 * f3) + 2.0f) * 0.5f) + 0.0f;
            }
        };

        Quint() {
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/multiwaveview/Ease$Sine.class */
    static class Sine {
        public static final TimeInterpolator easeIn = new TimeInterpolator() { // from class: com.android.internal.widget.multiwaveview.Ease.Sine.1
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return ((-1.0f) * ((float) Math.cos((f / 1.0f) * 1.5707963267948966d))) + 1.0f + 0.0f;
            }
        };
        public static final TimeInterpolator easeOut = new TimeInterpolator() { // from class: com.android.internal.widget.multiwaveview.Ease.Sine.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return (((float) Math.sin((f / 1.0f) * 1.5707963267948966d)) * 1.0f) + 0.0f;
            }
        };
        public static final TimeInterpolator easeInOut = new TimeInterpolator() { // from class: com.android.internal.widget.multiwaveview.Ease.Sine.3
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return ((-0.5f) * (((float) Math.cos((3.141592653589793d * f) / 1.0d)) - 1.0f)) + 0.0f;
            }
        };

        Sine() {
        }
    }

    Ease() {
    }
}
