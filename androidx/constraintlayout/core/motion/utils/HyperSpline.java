package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/HyperSpline.class */
public class HyperSpline {

    /* renamed from: a  reason: collision with root package name */
    int f1982a;
    Cubic[][] b;

    /* renamed from: c  reason: collision with root package name */
    int f1983c;
    double[] d;
    double e;
    double[][] f;

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/HyperSpline$Cubic.class */
    public static class Cubic {

        /* renamed from: a  reason: collision with root package name */
        double f1984a;
        double b;

        /* renamed from: c  reason: collision with root package name */
        double f1985c;
        double d;

        public Cubic(double d, double d2, double d3, double d4) {
            this.f1984a = d;
            this.b = d2;
            this.f1985c = d3;
            this.d = d4;
        }

        public double eval(double d) {
            return (((((this.d * d) + this.f1985c) * d) + this.b) * d) + this.f1984a;
        }

        public double vel(double d) {
            return (((this.d * 3.0d * d) + (this.f1985c * 2.0d)) * d) + this.b;
        }
    }

    public HyperSpline() {
    }

    public HyperSpline(double[][] dArr) {
        setup(dArr);
    }

    static Cubic[] a(int i, double[] dArr) {
        double[] dArr2 = new double[i];
        double[] dArr3 = new double[i];
        double[] dArr4 = new double[i];
        int i2 = i - 1;
        int i3 = 0;
        dArr2[0] = 0.5d;
        int i4 = 1;
        int i5 = 1;
        while (true) {
            int i6 = i5;
            if (i6 >= i2) {
                break;
            }
            dArr2[i6] = 1.0d / (4.0d - dArr2[i6 - 1]);
            i5 = i6 + 1;
        }
        int i7 = i2 - 1;
        dArr2[i2] = 1.0d / (2.0d - dArr2[i7]);
        dArr3[0] = (dArr[1] - dArr[0]) * 3.0d * dArr2[0];
        while (true) {
            int i8 = i4;
            if (i8 >= i2) {
                break;
            }
            i4 = i8 + 1;
            int i9 = i8 - 1;
            dArr3[i8] = (((dArr[i4] - dArr[i9]) * 3.0d) - dArr3[i9]) * dArr2[i8];
        }
        dArr3[i2] = (((dArr[i2] - dArr[i7]) * 3.0d) - dArr3[i7]) * dArr2[i2];
        dArr4[i2] = dArr3[i2];
        int i10 = i7;
        while (true) {
            int i11 = i10;
            if (i11 < 0) {
                break;
            }
            dArr4[i11] = dArr3[i11] - (dArr2[i11] * dArr4[i11 + 1]);
            i10 = i11 - 1;
        }
        Cubic[] cubicArr = new Cubic[i2];
        while (true) {
            int i12 = i3;
            if (i12 >= i2) {
                return cubicArr;
            }
            i3 = i12 + 1;
            cubicArr[i12] = new Cubic((float) dArr[i12], dArr4[i12], (((dArr[i3] - dArr[i12]) * 3.0d) - (dArr4[i12] * 2.0d)) - dArr4[i3], ((dArr[i12] - dArr[i3]) * 2.0d) + dArr4[i12] + dArr4[i3]);
        }
    }

    public double approxLength(Cubic[] cubicArr) {
        double d;
        int i;
        double d2;
        int length = cubicArr.length;
        double[] dArr = new double[cubicArr.length];
        double d3 = 0.0d;
        double d4 = 0.0d;
        while (true) {
            d = d4;
            d2 = 0.0d;
            if (d3 >= 1.0d) {
                break;
            }
            double d5 = 0.0d;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= cubicArr.length) {
                    break;
                }
                double d6 = dArr[i3];
                double eval = cubicArr[i3].eval(d3);
                dArr[i3] = eval;
                double d7 = d6 - eval;
                d5 += d7 * d7;
                i2 = i3 + 1;
            }
            double d8 = d;
            if (d3 > 0.0d) {
                d8 = d + Math.sqrt(d5);
            }
            d3 += 0.1d;
            d4 = d8;
        }
        for (i = 0; i < cubicArr.length; i++) {
            double d9 = dArr[i];
            double eval2 = cubicArr[i].eval(1.0d);
            dArr[i] = eval2;
            double d10 = d9 - eval2;
            d2 += d10 * d10;
        }
        return d + Math.sqrt(d2);
    }

    public double getPos(double d, int i) {
        int i2;
        double d2 = d * this.e;
        int i3 = 0;
        while (true) {
            i2 = i3;
            double[] dArr = this.d;
            if (i2 >= dArr.length - 1 || dArr[i2] >= d2) {
                break;
            }
            d2 -= dArr[i2];
            i3 = i2 + 1;
        }
        return this.b[i][i2].eval(d2 / this.d[i2]);
    }

    public void getPos(double d, double[] dArr) {
        int i;
        int i2;
        double d2 = d * this.e;
        int i3 = 0;
        while (true) {
            i = i3;
            double[] dArr2 = this.d;
            i2 = 0;
            if (i >= dArr2.length - 1) {
                break;
            }
            i2 = 0;
            if (dArr2[i] >= d2) {
                break;
            }
            d2 -= dArr2[i];
            i3 = i + 1;
        }
        while (i2 < dArr.length) {
            dArr[i2] = this.b[i2][i].eval(d2 / this.d[i]);
            i2++;
        }
    }

    public void getPos(double d, float[] fArr) {
        int i;
        int i2;
        double d2 = d * this.e;
        int i3 = 0;
        while (true) {
            i = i3;
            double[] dArr = this.d;
            i2 = 0;
            if (i >= dArr.length - 1) {
                break;
            }
            i2 = 0;
            if (dArr[i] >= d2) {
                break;
            }
            d2 -= dArr[i];
            i3 = i + 1;
        }
        while (i2 < fArr.length) {
            fArr[i2] = (float) this.b[i2][i].eval(d2 / this.d[i]);
            i2++;
        }
    }

    public void getVelocity(double d, double[] dArr) {
        int i;
        int i2;
        double d2 = d * this.e;
        int i3 = 0;
        while (true) {
            i = i3;
            double[] dArr2 = this.d;
            i2 = 0;
            if (i >= dArr2.length - 1) {
                break;
            }
            i2 = 0;
            if (dArr2[i] >= d2) {
                break;
            }
            d2 -= dArr2[i];
            i3 = i + 1;
        }
        while (i2 < dArr.length) {
            dArr[i2] = this.b[i2][i].vel(d2 / this.d[i]);
            i2++;
        }
    }

    /* JADX WARN: Type inference failed for: r1v8, types: [androidx.constraintlayout.core.motion.utils.HyperSpline$Cubic[], androidx.constraintlayout.core.motion.utils.HyperSpline$Cubic[][]] */
    public void setup(double[][] dArr) {
        int i;
        int length = dArr[0].length;
        this.f1983c = length;
        int length2 = dArr.length;
        this.f1982a = length2;
        this.f = (double[][]) Array.newInstance(Double.TYPE, length, length2);
        this.b = new Cubic[this.f1983c];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.f1983c) {
                break;
            }
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < this.f1982a) {
                    this.f[i3][i5] = dArr[i5][i3];
                    i4 = i5 + 1;
                }
            }
            i2 = i3 + 1;
        }
        int i6 = 0;
        while (true) {
            int i7 = i6;
            i = this.f1983c;
            if (i7 >= i) {
                break;
            }
            Cubic[][] cubicArr = this.b;
            double[][] dArr2 = this.f;
            cubicArr[i7] = a(dArr2[i7].length, dArr2[i7]);
            i6 = i7 + 1;
        }
        this.d = new double[this.f1982a - 1];
        this.e = 0.0d;
        Cubic[] cubicArr2 = new Cubic[i];
        int i8 = 0;
        while (true) {
            int i9 = i8;
            if (i9 >= this.d.length) {
                return;
            }
            int i10 = 0;
            while (true) {
                int i11 = i10;
                if (i11 < this.f1983c) {
                    cubicArr2[i11] = this.b[i11][i9];
                    i10 = i11 + 1;
                }
            }
            double d = this.e;
            double[] dArr3 = this.d;
            double approxLength = approxLength(cubicArr2);
            dArr3[i9] = approxLength;
            this.e = d + approxLength;
            i8 = i9 + 1;
        }
    }
}
