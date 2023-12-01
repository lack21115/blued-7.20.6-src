package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/Oscillator.class */
public class Oscillator {
    public static final int BOUNCE = 6;
    public static final int COS_WAVE = 5;
    public static final int CUSTOM = 7;
    public static final int REVERSE_SAW_WAVE = 4;
    public static final int SAW_WAVE = 3;
    public static final int SIN_WAVE = 0;
    public static final int SQUARE_WAVE = 1;
    public static String TAG = "Oscillator";
    public static final int TRIANGLE_WAVE = 2;

    /* renamed from: c  reason: collision with root package name */
    double[] f2007c;
    String d;
    MonotonicCurveFit e;
    int f;

    /* renamed from: a  reason: collision with root package name */
    float[] f2006a = new float[0];
    double[] b = new double[0];
    double g = 6.283185307179586d;
    private boolean h = false;

    double a(double d) {
        double d2;
        if (d < 0.0d) {
            d2 = 0.0d;
        } else {
            d2 = d;
            if (d > 1.0d) {
                d2 = 1.0d;
            }
        }
        int binarySearch = Arrays.binarySearch(this.b, d2);
        if (binarySearch > 0) {
            return 1.0d;
        }
        if (binarySearch != 0) {
            int i = (-binarySearch) - 1;
            float[] fArr = this.f2006a;
            float f = fArr[i];
            int i2 = i - 1;
            double d3 = f - fArr[i2];
            double[] dArr = this.b;
            double d4 = d3 / (dArr[i] - dArr[i2]);
            return this.f2007c[i2] + ((fArr[i2] - (dArr[i2] * d4)) * (d2 - dArr[i2])) + ((d4 * ((d2 * d2) - (dArr[i2] * dArr[i2]))) / 2.0d);
        }
        return 0.0d;
    }

    public void addPoint(double d, float f) {
        int length = this.f2006a.length + 1;
        int binarySearch = Arrays.binarySearch(this.b, d);
        int i = binarySearch;
        if (binarySearch < 0) {
            i = (-binarySearch) - 1;
        }
        this.b = Arrays.copyOf(this.b, length);
        this.f2006a = Arrays.copyOf(this.f2006a, length);
        this.f2007c = new double[length];
        double[] dArr = this.b;
        System.arraycopy(dArr, i, dArr, i + 1, (length - i) - 1);
        this.b[i] = d;
        this.f2006a[i] = f;
        this.h = false;
    }

    double b(double d) {
        double d2;
        if (d <= 0.0d) {
            d2 = 1.0E-5d;
        } else {
            d2 = d;
            if (d >= 1.0d) {
                d2 = 0.999999d;
            }
        }
        int binarySearch = Arrays.binarySearch(this.b, d2);
        if (binarySearch > 0) {
            return 0.0d;
        }
        double d3 = 0.0d;
        if (binarySearch != 0) {
            int i = (-binarySearch) - 1;
            float[] fArr = this.f2006a;
            float f = fArr[i];
            int i2 = i - 1;
            double d4 = f - fArr[i2];
            double[] dArr = this.b;
            double d5 = d4 / (dArr[i] - dArr[i2]);
            d3 = (fArr[i2] - (d5 * dArr[i2])) + (d2 * d5);
        }
        return d3;
    }

    public double getSlope(double d, double d2, double d3) {
        double a2 = d2 + a(d);
        double b = b(d) + d3;
        switch (this.f) {
            case 1:
                return 0.0d;
            case 2:
                return b * 4.0d * Math.signum((((a2 * 4.0d) + 3.0d) % 4.0d) - 2.0d);
            case 3:
                return b * 2.0d;
            case 4:
                return (-b) * 2.0d;
            case 5:
                double d4 = this.g;
                return (-d4) * b * Math.sin(d4 * a2);
            case 6:
                return b * 4.0d * ((((a2 * 4.0d) + 2.0d) % 4.0d) - 2.0d);
            case 7:
                return this.e.getSlope(a2 % 1.0d, 0);
            default:
                double d5 = this.g;
                return b * d5 * Math.cos(d5 * a2);
        }
    }

    public double getValue(double d, double d2) {
        double abs;
        double a2 = a(d) + d2;
        switch (this.f) {
            case 1:
                return Math.signum(0.5d - (a2 % 1.0d));
            case 2:
                abs = Math.abs((((a2 * 4.0d) + 1.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return (((a2 * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                abs = ((a2 * 2.0d) + 1.0d) % 2.0d;
                break;
            case 5:
                return Math.cos(this.g * (d2 + a2));
            case 6:
                double abs2 = 1.0d - Math.abs(((a2 * 4.0d) % 4.0d) - 2.0d);
                abs = abs2 * abs2;
                break;
            case 7:
                return this.e.getPos(a2 % 1.0d, 0);
            default:
                return Math.sin(this.g * a2);
        }
        return 1.0d - abs;
    }

    public void normalize() {
        float[] fArr;
        double d = 0.0d;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f2006a.length) {
                break;
            }
            d += fArr[i2];
            i = i2 + 1;
        }
        double d2 = 0.0d;
        int i3 = 1;
        while (true) {
            int i4 = i3;
            float[] fArr2 = this.f2006a;
            if (i4 >= fArr2.length) {
                break;
            }
            int i5 = i4 - 1;
            float f = (fArr2[i5] + fArr2[i4]) / 2.0f;
            double[] dArr = this.b;
            d2 += (dArr[i4] - dArr[i5]) * f;
            i3 = i4 + 1;
        }
        int i6 = 0;
        while (true) {
            int i7 = i6;
            float[] fArr3 = this.f2006a;
            if (i7 >= fArr3.length) {
                break;
            }
            fArr3[i7] = (float) (fArr3[i7] * (d / d2));
            i6 = i7 + 1;
        }
        this.f2007c[0] = 0.0d;
        int i8 = 1;
        while (true) {
            int i9 = i8;
            float[] fArr4 = this.f2006a;
            if (i9 >= fArr4.length) {
                this.h = true;
                return;
            }
            int i10 = i9 - 1;
            float f2 = (fArr4[i10] + fArr4[i9]) / 2.0f;
            double[] dArr2 = this.b;
            double d3 = dArr2[i9];
            double d4 = dArr2[i10];
            double[] dArr3 = this.f2007c;
            dArr3[i9] = dArr3[i10] + ((d3 - d4) * f2);
            i8 = i9 + 1;
        }
    }

    public void setType(int i, String str) {
        this.f = i;
        this.d = str;
        if (str != null) {
            this.e = MonotonicCurveFit.buildWave(str);
        }
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.b) + " period=" + Arrays.toString(this.f2006a);
    }
}
