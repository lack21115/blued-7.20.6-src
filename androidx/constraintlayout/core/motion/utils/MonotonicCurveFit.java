package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;
import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/MonotonicCurveFit.class */
public class MonotonicCurveFit extends CurveFit {

    /* renamed from: a  reason: collision with root package name */
    double[] f2004a;
    private double[] b;

    /* renamed from: c  reason: collision with root package name */
    private double[][] f2005c;
    private double[][] d;
    private boolean e = true;

    public MonotonicCurveFit(double[] dArr, double[][] dArr2) {
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.f2004a = new double[length2];
        int i = length - 1;
        double[][] dArr3 = (double[][]) Array.newInstance(Double.TYPE, i, length2);
        double[][] dArr4 = (double[][]) Array.newInstance(Double.TYPE, length, length2);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length2) {
                break;
            }
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < i) {
                    int i6 = i5 + 1;
                    dArr3[i5][i3] = (dArr2[i6][i3] - dArr2[i5][i3]) / (dArr[i6] - dArr[i5]);
                    if (i5 == 0) {
                        dArr4[i5][i3] = dArr3[i5][i3];
                    } else {
                        dArr4[i5][i3] = (dArr3[i5 - 1][i3] + dArr3[i5][i3]) * 0.5d;
                    }
                    i4 = i6;
                }
            }
            dArr4[i][i3] = dArr3[length - 2][i3];
            i2 = i3 + 1;
        }
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= i) {
                this.b = dArr;
                this.f2005c = dArr2;
                this.d = dArr4;
                return;
            }
            int i9 = 0;
            while (true) {
                int i10 = i9;
                if (i10 < length2) {
                    if (dArr3[i8][i10] == 0.0d) {
                        dArr4[i8][i10] = 0.0d;
                        dArr4[i8 + 1][i10] = 0.0d;
                    } else {
                        double d = dArr4[i8][i10] / dArr3[i8][i10];
                        int i11 = i8 + 1;
                        double d2 = dArr4[i11][i10] / dArr3[i8][i10];
                        double hypot = Math.hypot(d, d2);
                        if (hypot > 9.0d) {
                            double d3 = 3.0d / hypot;
                            dArr4[i8][i10] = d * d3 * dArr3[i8][i10];
                            dArr4[i11][i10] = d3 * d2 * dArr3[i8][i10];
                        }
                    }
                    i9 = i10 + 1;
                }
            }
            i7 = i8 + 1;
        }
    }

    private static double a(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d2 * d2;
        double d8 = d7 * d2;
        double d9 = 3.0d * d7;
        double d10 = d * d6;
        double d11 = d * d5;
        return (((((((((((-2.0d) * d8) * d4) + (d9 * d4)) + ((d8 * 2.0d) * d3)) - (d9 * d3)) + d3) + (d10 * d8)) + (d8 * d11)) - (d10 * d7)) - (((d * 2.0d) * d5) * d7)) + (d11 * d2);
    }

    private static MonotonicCurveFit a(double[] dArr) {
        int length = (dArr.length * 3) - 2;
        int length2 = dArr.length - 1;
        double d = 1.0d / length2;
        double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, length, 1);
        double[] dArr3 = new double[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= dArr.length) {
                return new MonotonicCurveFit(dArr3, dArr2);
            }
            double d2 = dArr[i2];
            int i3 = i2 + length2;
            dArr2[i3][0] = d2;
            double d3 = i2 * d;
            dArr3[i3] = d3;
            if (i2 > 0) {
                int i4 = (length2 * 2) + i2;
                dArr2[i4][0] = d2 + 1.0d;
                dArr3[i4] = d3 + 1.0d;
                int i5 = i2 - 1;
                dArr2[i5][0] = (d2 - 1.0d) - d;
                dArr3[i5] = (d3 - 1.0d) - d;
            }
            i = i2 + 1;
        }
    }

    private static double b(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d2 * d2;
        double d8 = d2 * 6.0d;
        double d9 = 3.0d * d;
        return ((((((((((-6.0d) * d7) * d4) + (d8 * d4)) + ((6.0d * d7) * d3)) - (d8 * d3)) + ((d9 * d6) * d7)) + ((d9 * d5) * d7)) - (((2.0d * d) * d6) * d2)) - (((4.0d * d) * d5) * d2)) + (d * d5);
    }

    public static MonotonicCurveFit buildWave(String str) {
        double[] dArr = new double[str.length() / 2];
        int indexOf = str.indexOf(40) + 1;
        int indexOf2 = str.indexOf(44, indexOf);
        int i = 0;
        while (true) {
            int i2 = i;
            if (indexOf2 == -1) {
                dArr[i2] = Double.parseDouble(str.substring(indexOf, str.indexOf(41, indexOf)).trim());
                return a(Arrays.copyOf(dArr, i2 + 1));
            }
            dArr[i2] = Double.parseDouble(str.substring(indexOf, indexOf2).trim());
            indexOf = indexOf2 + 1;
            indexOf2 = str.indexOf(44, indexOf);
            i = i2 + 1;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getPos(double d, int i) {
        double[] dArr = this.b;
        int length = dArr.length;
        int i2 = 0;
        if (this.e) {
            if (d <= dArr[0]) {
                return this.f2005c[0][i] + ((d - dArr[0]) * getSlope(dArr[0], i));
            }
            int i3 = length - 1;
            if (d >= dArr[i3]) {
                return this.f2005c[i3][i] + ((d - dArr[i3]) * getSlope(dArr[i3], i));
            }
        } else if (d <= dArr[0]) {
            return this.f2005c[0][i];
        } else {
            int i4 = length - 1;
            if (d >= dArr[i4]) {
                return this.f2005c[i4][i];
            }
        }
        while (i2 < length - 1) {
            double[] dArr2 = this.b;
            if (d == dArr2[i2]) {
                return this.f2005c[i2][i];
            }
            int i5 = i2 + 1;
            if (d < dArr2[i5]) {
                double d2 = dArr2[i5] - dArr2[i2];
                double d3 = (d - dArr2[i2]) / d2;
                double[][] dArr3 = this.f2005c;
                double d4 = dArr3[i2][i];
                double d5 = dArr3[i5][i];
                double[][] dArr4 = this.d;
                return a(d2, d3, d4, d5, dArr4[i2][i], dArr4[i5][i]);
            }
            i2 = i5;
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d, double[] dArr) {
        double[] dArr2 = this.b;
        int length = dArr2.length;
        int length2 = this.f2005c[0].length;
        if (this.e) {
            if (d <= dArr2[0]) {
                getSlope(dArr2[0], this.f2004a);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length2) {
                        return;
                    }
                    dArr[i2] = this.f2005c[0][i2] + ((d - this.b[0]) * this.f2004a[i2]);
                    i = i2 + 1;
                }
            } else {
                int i3 = length - 1;
                if (d >= dArr2[i3]) {
                    getSlope(dArr2[i3], this.f2004a);
                    for (int i4 = 0; i4 < length2; i4++) {
                        dArr[i4] = this.f2005c[i3][i4] + ((d - this.b[i3]) * this.f2004a[i4]);
                    }
                    return;
                }
            }
        } else if (d <= dArr2[0]) {
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= length2) {
                    return;
                }
                dArr[i6] = this.f2005c[0][i6];
                i5 = i6 + 1;
            }
        } else {
            int i7 = length - 1;
            if (d >= dArr2[i7]) {
                int i8 = 0;
                while (true) {
                    int i9 = i8;
                    if (i9 >= length2) {
                        return;
                    }
                    dArr[i9] = this.f2005c[i7][i9];
                    i8 = i9 + 1;
                }
            }
        }
        int i10 = 0;
        while (true) {
            int i11 = i10;
            if (i11 >= length - 1) {
                return;
            }
            if (d == this.b[i11]) {
                int i12 = 0;
                while (true) {
                    int i13 = i12;
                    if (i13 >= length2) {
                        break;
                    }
                    dArr[i13] = this.f2005c[i11][i13];
                    i12 = i13 + 1;
                }
            }
            double[] dArr3 = this.b;
            int i14 = i11 + 1;
            if (d < dArr3[i14]) {
                double d2 = dArr3[i14] - dArr3[i11];
                double d3 = (d - dArr3[i11]) / d2;
                int i15 = 0;
                while (true) {
                    int i16 = i15;
                    if (i16 >= length2) {
                        return;
                    }
                    double[][] dArr4 = this.f2005c;
                    double d4 = dArr4[i11][i16];
                    double d5 = dArr4[i14][i16];
                    double[][] dArr5 = this.d;
                    dArr[i16] = a(d2, d3, d4, d5, dArr5[i11][i16], dArr5[i14][i16]);
                    i15 = i16 + 1;
                }
            } else {
                i10 = i14;
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d, float[] fArr) {
        double[] dArr = this.b;
        int length = dArr.length;
        int length2 = this.f2005c[0].length;
        if (this.e) {
            if (d <= dArr[0]) {
                getSlope(dArr[0], this.f2004a);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length2) {
                        return;
                    }
                    fArr[i2] = (float) (this.f2005c[0][i2] + ((d - this.b[0]) * this.f2004a[i2]));
                    i = i2 + 1;
                }
            } else {
                int i3 = length - 1;
                if (d >= dArr[i3]) {
                    getSlope(dArr[i3], this.f2004a);
                    for (int i4 = 0; i4 < length2; i4++) {
                        fArr[i4] = (float) (this.f2005c[i3][i4] + ((d - this.b[i3]) * this.f2004a[i4]));
                    }
                    return;
                }
            }
        } else if (d <= dArr[0]) {
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= length2) {
                    return;
                }
                fArr[i6] = (float) this.f2005c[0][i6];
                i5 = i6 + 1;
            }
        } else {
            int i7 = length - 1;
            if (d >= dArr[i7]) {
                int i8 = 0;
                while (true) {
                    int i9 = i8;
                    if (i9 >= length2) {
                        return;
                    }
                    fArr[i9] = (float) this.f2005c[i7][i9];
                    i8 = i9 + 1;
                }
            }
        }
        int i10 = 0;
        while (true) {
            int i11 = i10;
            if (i11 >= length - 1) {
                return;
            }
            if (d == this.b[i11]) {
                int i12 = 0;
                while (true) {
                    int i13 = i12;
                    if (i13 >= length2) {
                        break;
                    }
                    fArr[i13] = (float) this.f2005c[i11][i13];
                    i12 = i13 + 1;
                }
            }
            double[] dArr2 = this.b;
            int i14 = i11 + 1;
            if (d < dArr2[i14]) {
                double d2 = dArr2[i14] - dArr2[i11];
                double d3 = (d - dArr2[i11]) / d2;
                int i15 = 0;
                while (true) {
                    int i16 = i15;
                    if (i16 >= length2) {
                        return;
                    }
                    double[][] dArr3 = this.f2005c;
                    double d4 = dArr3[i11][i16];
                    double d5 = dArr3[i14][i16];
                    double[][] dArr4 = this.d;
                    fArr[i16] = (float) a(d2, d3, d4, d5, dArr4[i11][i16], dArr4[i14][i16]);
                    i15 = i16 + 1;
                }
            } else {
                i10 = i14;
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getSlope(double d, int i) {
        double[] dArr = this.b;
        int length = dArr.length;
        int i2 = 0;
        if (d < dArr[0]) {
            d = dArr[0];
        } else {
            int i3 = length - 1;
            if (d >= dArr[i3]) {
                d = dArr[i3];
            }
        }
        while (i2 < length - 1) {
            double[] dArr2 = this.b;
            int i4 = i2 + 1;
            if (d <= dArr2[i4]) {
                double d2 = dArr2[i4] - dArr2[i2];
                double d3 = (d - dArr2[i2]) / d2;
                double[][] dArr3 = this.f2005c;
                double d4 = dArr3[i2][i];
                double d5 = dArr3[i4][i];
                double[][] dArr4 = this.d;
                return b(d2, d3, d4, d5, dArr4[i2][i], dArr4[i4][i]) / d2;
            }
            i2 = i4;
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getSlope(double d, double[] dArr) {
        double[] dArr2 = this.b;
        int length = dArr2.length;
        int length2 = this.f2005c[0].length;
        if (d <= dArr2[0]) {
            d = dArr2[0];
        } else {
            int i = length - 1;
            if (d >= dArr2[i]) {
                d = dArr2[i];
            }
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length - 1) {
                return;
            }
            double[] dArr3 = this.b;
            int i4 = i3 + 1;
            if (d <= dArr3[i4]) {
                double d2 = dArr3[i4] - dArr3[i3];
                double d3 = (d - dArr3[i3]) / d2;
                for (int i5 = 0; i5 < length2; i5++) {
                    double[][] dArr4 = this.f2005c;
                    double d4 = dArr4[i3][i5];
                    double d5 = dArr4[i4][i5];
                    double[][] dArr5 = this.d;
                    dArr[i5] = b(d2, d3, d4, d5, dArr5[i3][i5], dArr5[i4][i5]) / d2;
                }
                return;
            }
            i2 = i4;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.b;
    }
}
