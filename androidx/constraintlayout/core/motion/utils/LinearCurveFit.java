package androidx.constraintlayout.core.motion.utils;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/LinearCurveFit.class */
public class LinearCurveFit extends CurveFit {

    /* renamed from: a  reason: collision with root package name */
    double[] f2002a;
    private double[] b;

    /* renamed from: c  reason: collision with root package name */
    private double[][] f2003c;
    private double d;
    private boolean e = true;

    public LinearCurveFit(double[] dArr, double[][] dArr2) {
        this.d = Double.NaN;
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.f2002a = new double[length2];
        this.b = dArr;
        this.f2003c = dArr2;
        if (length2 > 2) {
            double d = 0.0d;
            double d2 = 0.0d;
            int i = 0;
            while (i < dArr.length) {
                double d3 = dArr2[i][0];
                double d4 = dArr2[i][0];
                if (i > 0) {
                    Math.hypot(d3 - d, d4 - d2);
                }
                i++;
                d = d3;
                d2 = d4;
            }
            this.d = 0.0d;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getPos(double d, int i) {
        double[] dArr = this.b;
        int length = dArr.length;
        int i2 = 0;
        if (this.e) {
            if (d <= dArr[0]) {
                return this.f2003c[0][i] + ((d - dArr[0]) * getSlope(dArr[0], i));
            }
            int i3 = length - 1;
            if (d >= dArr[i3]) {
                return this.f2003c[i3][i] + ((d - dArr[i3]) * getSlope(dArr[i3], i));
            }
        } else if (d <= dArr[0]) {
            return this.f2003c[0][i];
        } else {
            int i4 = length - 1;
            if (d >= dArr[i4]) {
                return this.f2003c[i4][i];
            }
        }
        while (i2 < length - 1) {
            double[] dArr2 = this.b;
            if (d == dArr2[i2]) {
                return this.f2003c[i2][i];
            }
            int i5 = i2 + 1;
            if (d < dArr2[i5]) {
                double d2 = (d - dArr2[i2]) / (dArr2[i5] - dArr2[i2]);
                double[][] dArr3 = this.f2003c;
                return (dArr3[i2][i] * (1.0d - d2)) + (dArr3[i5][i] * d2);
            }
            i2 = i5;
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d, double[] dArr) {
        double[] dArr2 = this.b;
        int length = dArr2.length;
        int length2 = this.f2003c[0].length;
        if (this.e) {
            if (d <= dArr2[0]) {
                getSlope(dArr2[0], this.f2002a);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length2) {
                        return;
                    }
                    dArr[i2] = this.f2003c[0][i2] + ((d - this.b[0]) * this.f2002a[i2]);
                    i = i2 + 1;
                }
            } else {
                int i3 = length - 1;
                if (d >= dArr2[i3]) {
                    getSlope(dArr2[i3], this.f2002a);
                    for (int i4 = 0; i4 < length2; i4++) {
                        dArr[i4] = this.f2003c[i3][i4] + ((d - this.b[i3]) * this.f2002a[i4]);
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
                dArr[i6] = this.f2003c[0][i6];
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
                    dArr[i9] = this.f2003c[i7][i9];
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
                    dArr[i13] = this.f2003c[i11][i13];
                    i12 = i13 + 1;
                }
            }
            double[] dArr3 = this.b;
            int i14 = i11 + 1;
            if (d < dArr3[i14]) {
                double d2 = (d - dArr3[i11]) / (dArr3[i14] - dArr3[i11]);
                int i15 = 0;
                while (true) {
                    int i16 = i15;
                    if (i16 >= length2) {
                        return;
                    }
                    double[][] dArr4 = this.f2003c;
                    dArr[i16] = (dArr4[i11][i16] * (1.0d - d2)) + (dArr4[i14][i16] * d2);
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
        int length2 = this.f2003c[0].length;
        if (this.e) {
            if (d <= dArr[0]) {
                getSlope(dArr[0], this.f2002a);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length2) {
                        return;
                    }
                    fArr[i2] = (float) (this.f2003c[0][i2] + ((d - this.b[0]) * this.f2002a[i2]));
                    i = i2 + 1;
                }
            } else {
                int i3 = length - 1;
                if (d >= dArr[i3]) {
                    getSlope(dArr[i3], this.f2002a);
                    for (int i4 = 0; i4 < length2; i4++) {
                        fArr[i4] = (float) (this.f2003c[i3][i4] + ((d - this.b[i3]) * this.f2002a[i4]));
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
                fArr[i6] = (float) this.f2003c[0][i6];
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
                    fArr[i9] = (float) this.f2003c[i7][i9];
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
                    fArr[i13] = (float) this.f2003c[i11][i13];
                    i12 = i13 + 1;
                }
            }
            double[] dArr2 = this.b;
            int i14 = i11 + 1;
            if (d < dArr2[i14]) {
                double d2 = (d - dArr2[i11]) / (dArr2[i14] - dArr2[i11]);
                int i15 = 0;
                while (true) {
                    int i16 = i15;
                    if (i16 >= length2) {
                        return;
                    }
                    double[][] dArr3 = this.f2003c;
                    fArr[i16] = (float) ((dArr3[i11][i16] * (1.0d - d2)) + (dArr3[i14][i16] * d2));
                    i15 = i16 + 1;
                }
            } else {
                i10 = i14;
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getSlope(double d, int i) {
        int i2;
        double d2;
        double[] dArr = this.b;
        int length = dArr.length;
        if (d < dArr[0]) {
            d2 = dArr[0];
            i2 = 0;
        } else {
            int i3 = length - 1;
            i2 = 0;
            d2 = d;
            if (d >= dArr[i3]) {
                d2 = dArr[i3];
                i2 = 0;
            }
        }
        while (i2 < length - 1) {
            double[] dArr2 = this.b;
            int i4 = i2 + 1;
            if (d2 <= dArr2[i4]) {
                double d3 = dArr2[i4];
                double d4 = dArr2[i2];
                double d5 = dArr2[i2];
                double[][] dArr3 = this.f2003c;
                return (dArr3[i4][i] - dArr3[i2][i]) / (d3 - d4);
            }
            i2 = i4;
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getSlope(double d, double[] dArr) {
        double d2;
        double[] dArr2 = this.b;
        int length = dArr2.length;
        int length2 = this.f2003c[0].length;
        if (d <= dArr2[0]) {
            d2 = dArr2[0];
        } else {
            int i = length - 1;
            d2 = d;
            if (d >= dArr2[i]) {
                d2 = dArr2[i];
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
            if (d2 <= dArr3[i4]) {
                double d3 = dArr3[i4];
                double d4 = dArr3[i3];
                double d5 = dArr3[i3];
                for (int i5 = 0; i5 < length2; i5++) {
                    double[][] dArr4 = this.f2003c;
                    dArr[i5] = (dArr4[i4][i5] - dArr4[i3][i5]) / (d3 - d4);
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
