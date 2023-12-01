package android.util;

/* loaded from: source-9557208-dex2jar.jar:android/util/Spline.class */
public abstract class Spline {

    /* loaded from: source-9557208-dex2jar.jar:android/util/Spline$LinearSpline.class */
    public static class LinearSpline extends Spline {
        private final float[] mM;
        private final float[] mX;
        private final float[] mY;

        public LinearSpline(float[] fArr, float[] fArr2) {
            if (fArr == null || fArr2 == null || fArr.length != fArr2.length || fArr.length < 2) {
                throw new IllegalArgumentException("There must be at least two control points and the arrays must be of equal length.");
            }
            int length = fArr.length;
            this.mM = new float[length - 1];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length - 1) {
                    this.mX = fArr;
                    this.mY = fArr2;
                    return;
                }
                this.mM[i2] = (fArr2[i2 + 1] - fArr2[i2]) / (fArr[i2 + 1] - fArr[i2]);
                i = i2 + 1;
            }
        }

        @Override // android.util.Spline
        public float interpolate(float f) {
            int length = this.mX.length;
            if (Float.isNaN(f)) {
                return f;
            }
            if (f <= this.mX[0]) {
                return this.mY[0];
            }
            if (f >= this.mX[length - 1]) {
                return this.mY[length - 1];
            }
            int i = 0;
            while (f >= this.mX[i + 1]) {
                int i2 = i + 1;
                i = i2;
                if (f == this.mX[i2]) {
                    return this.mY[i2];
                }
            }
            return this.mY[i] + (this.mM[i] * (f - this.mX[i]));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            int length = this.mX.length;
            sb.append("LinearSpline{[");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    sb.append("]}");
                    return sb.toString();
                }
                if (i2 != 0) {
                    sb.append(", ");
                }
                sb.append("(").append(this.mX[i2]);
                sb.append(", ").append(this.mY[i2]);
                if (i2 < length - 1) {
                    sb.append(": ").append(this.mM[i2]);
                }
                sb.append(")");
                i = i2 + 1;
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/util/Spline$MonotoneCubicSpline.class */
    public static class MonotoneCubicSpline extends Spline {
        private float[] mM;
        private float[] mX;
        private float[] mY;

        public MonotoneCubicSpline(float[] fArr, float[] fArr2) {
            if (fArr == null || fArr2 == null || fArr.length != fArr2.length || fArr.length < 2) {
                throw new IllegalArgumentException("There must be at least two control points and the arrays must be of equal length.");
            }
            int length = fArr.length;
            float[] fArr3 = new float[length - 1];
            float[] fArr4 = new float[length];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length - 1) {
                    fArr4[0] = fArr3[0];
                    int i3 = 1;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= length - 1) {
                            break;
                        }
                        fArr4[i4] = (fArr3[i4 - 1] + fArr3[i4]) * 0.5f;
                        i3 = i4 + 1;
                    }
                    fArr4[length - 1] = fArr3[length - 2];
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i6 >= length - 1) {
                            this.mX = fArr;
                            this.mY = fArr2;
                            this.mM = fArr4;
                            return;
                        }
                        if (fArr3[i6] == 0.0f) {
                            fArr4[i6] = 0.0f;
                            fArr4[i6 + 1] = 0.0f;
                        } else {
                            float f = fArr4[i6] / fArr3[i6];
                            float f2 = fArr4[i6 + 1] / fArr3[i6];
                            if (f < 0.0f || f2 < 0.0f) {
                                break;
                            }
                            float hypot = FloatMath.hypot(f, f2);
                            if (hypot > 9.0f) {
                                float f3 = 3.0f / hypot;
                                fArr4[i6] = f3 * f * fArr3[i6];
                                fArr4[i6 + 1] = f3 * f2 * fArr3[i6];
                            }
                        }
                        i5 = i6 + 1;
                    }
                    throw new IllegalArgumentException("The control points must have monotonic Y values.");
                }
                float f4 = fArr[i2 + 1] - fArr[i2];
                if (f4 <= 0.0f) {
                    throw new IllegalArgumentException("The control points must all have strictly increasing X values.");
                }
                fArr3[i2] = (fArr2[i2 + 1] - fArr2[i2]) / f4;
                i = i2 + 1;
            }
        }

        @Override // android.util.Spline
        public float interpolate(float f) {
            int length = this.mX.length;
            if (Float.isNaN(f)) {
                return f;
            }
            if (f <= this.mX[0]) {
                return this.mY[0];
            }
            if (f >= this.mX[length - 1]) {
                return this.mY[length - 1];
            }
            int i = 0;
            while (f >= this.mX[i + 1]) {
                int i2 = i + 1;
                i = i2;
                if (f == this.mX[i2]) {
                    return this.mY[i2];
                }
            }
            float f2 = this.mX[i + 1] - this.mX[i];
            float f3 = (f - this.mX[i]) / f2;
            return (((this.mY[i] * ((2.0f * f3) + 1.0f)) + (this.mM[i] * f2 * f3)) * (1.0f - f3) * (1.0f - f3)) + (((this.mY[i + 1] * (3.0f - (2.0f * f3))) + (this.mM[i + 1] * f2 * (f3 - 1.0f))) * f3 * f3);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            int length = this.mX.length;
            sb.append("MonotoneCubicSpline{[");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    sb.append("]}");
                    return sb.toString();
                }
                if (i2 != 0) {
                    sb.append(", ");
                }
                sb.append("(").append(this.mX[i2]);
                sb.append(", ").append(this.mY[i2]);
                sb.append(": ").append(this.mM[i2]).append(")");
                i = i2 + 1;
            }
        }
    }

    public static Spline createLinearSpline(float[] fArr, float[] fArr2) {
        return new LinearSpline(fArr, fArr2);
    }

    public static Spline createMonotoneCubicSpline(float[] fArr, float[] fArr2) {
        return new MonotoneCubicSpline(fArr, fArr2);
    }

    public static Spline createSpline(float[] fArr, float[] fArr2) {
        if (isStrictlyIncreasing(fArr)) {
            return isMonotonic(fArr2) ? createMonotoneCubicSpline(fArr, fArr2) : createLinearSpline(fArr, fArr2);
        }
        throw new IllegalArgumentException("The control points must all have strictly increasing X values.");
    }

    private static boolean isMonotonic(float[] fArr) {
        if (fArr == null || fArr.length < 2) {
            throw new IllegalArgumentException("There must be at least two control points.");
        }
        float f = fArr[0];
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= fArr.length) {
                return true;
            }
            float f2 = fArr[i2];
            if (f2 < f) {
                return false;
            }
            f = f2;
            i = i2 + 1;
        }
    }

    private static boolean isStrictlyIncreasing(float[] fArr) {
        if (fArr == null || fArr.length < 2) {
            throw new IllegalArgumentException("There must be at least two control points.");
        }
        float f = fArr[0];
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= fArr.length) {
                return true;
            }
            float f2 = fArr[i2];
            if (f2 <= f) {
                return false;
            }
            f = f2;
            i = i2 + 1;
        }
    }

    public abstract float interpolate(float f);
}
