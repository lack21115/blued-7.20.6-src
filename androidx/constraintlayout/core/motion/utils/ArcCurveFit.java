package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/ArcCurveFit.class */
public class ArcCurveFit extends CurveFit {
    public static final int ARC_START_FLIP = 3;
    public static final int ARC_START_HORIZONTAL = 2;
    public static final int ARC_START_LINEAR = 0;
    public static final int ARC_START_VERTICAL = 1;

    /* renamed from: a  reason: collision with root package name */
    Arc[] f1975a;
    private final double[] b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1976c = true;

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/ArcCurveFit$Arc.class */
    static class Arc {
        private static double[] s = new double[91];

        /* renamed from: a  reason: collision with root package name */
        double[] f1977a;
        double b;

        /* renamed from: c  reason: collision with root package name */
        double f1978c;
        double d;
        double e;
        double f;
        double g;
        double h;
        double i;
        double j;
        double k;
        double l;
        double m;
        double n;
        double o;
        double p;
        boolean q;
        boolean r;

        Arc(int i, double d, double d2, double d3, double d4, double d5, double d6) {
            boolean z = false;
            this.r = false;
            this.q = i == 1 ? true : z;
            this.f1978c = d;
            this.d = d2;
            this.i = 1.0d / (d2 - d);
            if (3 == i) {
                this.r = true;
            }
            double d7 = d5 - d3;
            double d8 = d6 - d4;
            if (!this.r && Math.abs(d7) >= 0.001d && Math.abs(d8) >= 0.001d) {
                this.f1977a = new double[101];
                this.j = d7 * (this.q ? -1 : 1);
                this.k = d8 * (this.q ? 1 : -1);
                this.l = this.q ? d5 : d3;
                this.m = this.q ? d4 : d6;
                a(d3, d4, d5, d6);
                this.n = this.b * this.i;
                return;
            }
            this.r = true;
            this.e = d3;
            this.f = d5;
            this.g = d4;
            this.h = d6;
            double hypot = Math.hypot(d8, d7);
            this.b = hypot;
            this.n = hypot * this.i;
            double d9 = this.d;
            double d10 = this.f1978c;
            this.l = d7 / (d9 - d10);
            this.m = d8 / (d9 - d10);
        }

        private void a(double d, double d2, double d3, double d4) {
            double[] dArr;
            double[] dArr2;
            int i = 0;
            double d5 = 0.0d;
            double d6 = 0.0d;
            double d7 = 0.0d;
            while (true) {
                if (i >= s.length) {
                    break;
                }
                double radians = Math.toRadians((i * 90.0d) / (dArr.length - 1));
                double sin = Math.sin(radians);
                double cos = Math.cos(radians);
                double d8 = sin * (d3 - d);
                double d9 = cos * (d2 - d4);
                if (i > 0) {
                    d5 += Math.hypot(d8 - d6, d9 - d7);
                    s[i] = d5;
                }
                i++;
                d7 = d9;
                d6 = d8;
            }
            this.b = d5;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                double[] dArr3 = s;
                if (i3 >= dArr3.length) {
                    break;
                }
                dArr3[i3] = dArr3[i3] / d5;
                i2 = i3 + 1;
            }
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= this.f1977a.length) {
                    return;
                }
                double length = i5 / (dArr2.length - 1);
                int binarySearch = Arrays.binarySearch(s, length);
                if (binarySearch >= 0) {
                    this.f1977a[i5] = binarySearch / (s.length - 1);
                } else if (binarySearch == -1) {
                    this.f1977a[i5] = 0.0d;
                } else {
                    int i6 = -binarySearch;
                    int i7 = i6 - 2;
                    double d10 = i7;
                    double[] dArr4 = s;
                    this.f1977a[i5] = (d10 + ((length - dArr4[i7]) / (dArr4[i6 - 1] - dArr4[i7]))) / (dArr4.length - 1);
                }
                i4 = i5 + 1;
            }
        }

        double a() {
            return this.l + (this.j * this.o);
        }

        void a(double d) {
            double b = b((this.q ? this.d - d : d - this.f1978c) * this.i) * 1.5707963267948966d;
            this.o = Math.sin(b);
            this.p = Math.cos(b);
        }

        double b() {
            return this.m + (this.k * this.p);
        }

        double b(double d) {
            if (d <= 0.0d) {
                return 0.0d;
            }
            if (d >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.f1977a;
            double length = d * (dArr.length - 1);
            int i = (int) length;
            return dArr[i] + ((length - i) * (dArr[i + 1] - dArr[i]));
        }

        double c() {
            double d = this.j * this.p;
            double hypot = this.n / Math.hypot(d, (-this.k) * this.o);
            double d2 = d;
            if (this.q) {
                d2 = -d;
            }
            return d2 * hypot;
        }

        double d() {
            double d = this.j;
            double d2 = this.p;
            double d3 = (-this.k) * this.o;
            double hypot = this.n / Math.hypot(d * d2, d3);
            return this.q ? (-d3) * hypot : d3 * hypot;
        }

        public double getLinearDX(double d) {
            return this.l;
        }

        public double getLinearDY(double d) {
            return this.m;
        }

        public double getLinearX(double d) {
            double d2 = this.f1978c;
            double d3 = this.i;
            double d4 = this.e;
            return d4 + ((d - d2) * d3 * (this.f - d4));
        }

        public double getLinearY(double d) {
            double d2 = this.f1978c;
            double d3 = this.i;
            double d4 = this.g;
            return d4 + ((d - d2) * d3 * (this.h - d4));
        }
    }

    public ArcCurveFit(int[] iArr, double[] dArr, double[][] dArr2) {
        this.b = dArr;
        this.f1975a = new Arc[dArr.length - 1];
        int i = 0;
        int i2 = 1;
        int i3 = 1;
        while (i < this.f1975a.length) {
            int i4 = iArr[i];
            if (i4 == 0) {
                i3 = 3;
            } else if (i4 == 1) {
                i2 = 1;
                i3 = 1;
            } else if (i4 == 2) {
                i2 = 2;
                i3 = 2;
            } else if (i4 == 3) {
                i2 = i2 == 1 ? 2 : 1;
                i3 = i2;
            }
            int i5 = i + 1;
            this.f1975a[i] = new Arc(i3, dArr[i], dArr[i5], dArr2[i][0], dArr2[i][1], dArr2[i5][0], dArr2[i5][1]);
            i = i5;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getPos(double d, int i) {
        int i2;
        double d2;
        double d3;
        double linearY;
        double linearDY;
        double b;
        double d4;
        if (this.f1976c) {
            if (d < this.f1975a[0].f1978c) {
                double d5 = this.f1975a[0].f1978c;
                d3 = d - this.f1975a[0].f1978c;
                if (!this.f1975a[0].r) {
                    this.f1975a[0].a(d5);
                    if (i == 0) {
                        b = this.f1975a[0].a();
                        d4 = this.f1975a[0].c();
                    } else {
                        b = this.f1975a[0].b();
                        d4 = this.f1975a[0].d();
                    }
                    return b + (d3 * d4);
                } else if (i == 0) {
                    linearY = this.f1975a[0].getLinearX(d5);
                    linearDY = this.f1975a[0].getLinearDX(d5);
                } else {
                    linearY = this.f1975a[0].getLinearY(d5);
                    linearDY = this.f1975a[0].getLinearDY(d5);
                }
            } else {
                Arc[] arcArr = this.f1975a;
                i2 = 0;
                d2 = d;
                if (d > arcArr[arcArr.length - 1].d) {
                    Arc[] arcArr2 = this.f1975a;
                    double d6 = arcArr2[arcArr2.length - 1].d;
                    d3 = d - d6;
                    Arc[] arcArr3 = this.f1975a;
                    int length = arcArr3.length - 1;
                    if (i == 0) {
                        linearY = arcArr3[length].getLinearX(d6);
                        linearDY = this.f1975a[length].getLinearDX(d6);
                    } else {
                        linearY = arcArr3[length].getLinearY(d6);
                        linearDY = this.f1975a[length].getLinearDY(d6);
                    }
                }
            }
            return linearY + (d3 * linearDY);
        } else if (d < this.f1975a[0].f1978c) {
            d2 = this.f1975a[0].f1978c;
            i2 = 0;
        } else {
            Arc[] arcArr4 = this.f1975a;
            i2 = 0;
            d2 = d;
            if (d > arcArr4[arcArr4.length - 1].d) {
                Arc[] arcArr5 = this.f1975a;
                d2 = arcArr5[arcArr5.length - 1].d;
                i2 = 0;
            }
        }
        while (true) {
            Arc[] arcArr6 = this.f1975a;
            if (i2 >= arcArr6.length) {
                return Double.NaN;
            }
            if (d2 <= arcArr6[i2].d) {
                if (this.f1975a[i2].r) {
                    return i == 0 ? this.f1975a[i2].getLinearX(d2) : this.f1975a[i2].getLinearY(d2);
                }
                this.f1975a[i2].a(d2);
                return i == 0 ? this.f1975a[i2].a() : this.f1975a[i2].b();
            }
            i2++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d, double[] dArr) {
        double d2;
        if (!this.f1976c) {
            double d3 = d;
            if (d < this.f1975a[0].f1978c) {
                d3 = this.f1975a[0].f1978c;
            }
            Arc[] arcArr = this.f1975a;
            d2 = d3;
            if (d3 > arcArr[arcArr.length - 1].d) {
                Arc[] arcArr2 = this.f1975a;
                d2 = arcArr2[arcArr2.length - 1].d;
            }
        } else if (d < this.f1975a[0].f1978c) {
            double d4 = this.f1975a[0].f1978c;
            double d5 = d - this.f1975a[0].f1978c;
            if (this.f1975a[0].r) {
                dArr[0] = this.f1975a[0].getLinearX(d4) + (this.f1975a[0].getLinearDX(d4) * d5);
                dArr[1] = this.f1975a[0].getLinearY(d4) + (d5 * this.f1975a[0].getLinearDY(d4));
                return;
            }
            this.f1975a[0].a(d4);
            dArr[0] = this.f1975a[0].a() + (this.f1975a[0].c() * d5);
            dArr[1] = this.f1975a[0].b() + (d5 * this.f1975a[0].d());
            return;
        } else {
            Arc[] arcArr3 = this.f1975a;
            d2 = d;
            if (d > arcArr3[arcArr3.length - 1].d) {
                Arc[] arcArr4 = this.f1975a;
                double d6 = arcArr4[arcArr4.length - 1].d;
                double d7 = d - d6;
                Arc[] arcArr5 = this.f1975a;
                int length = arcArr5.length - 1;
                if (arcArr5[length].r) {
                    dArr[0] = this.f1975a[length].getLinearX(d6) + (this.f1975a[length].getLinearDX(d6) * d7);
                    dArr[1] = this.f1975a[length].getLinearY(d6) + (d7 * this.f1975a[length].getLinearDY(d6));
                    return;
                }
                this.f1975a[length].a(d);
                dArr[0] = this.f1975a[length].a() + (this.f1975a[length].c() * d7);
                dArr[1] = this.f1975a[length].b() + (d7 * this.f1975a[length].d());
                return;
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            Arc[] arcArr6 = this.f1975a;
            if (i2 >= arcArr6.length) {
                return;
            }
            if (d2 <= arcArr6[i2].d) {
                if (this.f1975a[i2].r) {
                    dArr[0] = this.f1975a[i2].getLinearX(d2);
                    dArr[1] = this.f1975a[i2].getLinearY(d2);
                    return;
                }
                this.f1975a[i2].a(d2);
                dArr[0] = this.f1975a[i2].a();
                dArr[1] = this.f1975a[i2].b();
                return;
            }
            i = i2 + 1;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d, float[] fArr) {
        double d2;
        if (this.f1976c) {
            if (d < this.f1975a[0].f1978c) {
                double d3 = this.f1975a[0].f1978c;
                double d4 = d - this.f1975a[0].f1978c;
                if (this.f1975a[0].r) {
                    fArr[0] = (float) (this.f1975a[0].getLinearX(d3) + (this.f1975a[0].getLinearDX(d3) * d4));
                    fArr[1] = (float) (this.f1975a[0].getLinearY(d3) + (d4 * this.f1975a[0].getLinearDY(d3)));
                    return;
                }
                this.f1975a[0].a(d3);
                fArr[0] = (float) (this.f1975a[0].a() + (this.f1975a[0].c() * d4));
                fArr[1] = (float) (this.f1975a[0].b() + (d4 * this.f1975a[0].d()));
                return;
            }
            Arc[] arcArr = this.f1975a;
            d2 = d;
            if (d > arcArr[arcArr.length - 1].d) {
                Arc[] arcArr2 = this.f1975a;
                double d5 = arcArr2[arcArr2.length - 1].d;
                double d6 = d - d5;
                Arc[] arcArr3 = this.f1975a;
                int length = arcArr3.length - 1;
                if (arcArr3[length].r) {
                    fArr[0] = (float) (this.f1975a[length].getLinearX(d5) + (this.f1975a[length].getLinearDX(d5) * d6));
                    fArr[1] = (float) (this.f1975a[length].getLinearY(d5) + (d6 * this.f1975a[length].getLinearDY(d5)));
                    return;
                }
                this.f1975a[length].a(d);
                fArr[0] = (float) this.f1975a[length].a();
                fArr[1] = (float) this.f1975a[length].b();
                return;
            }
        } else if (d < this.f1975a[0].f1978c) {
            d2 = this.f1975a[0].f1978c;
        } else {
            Arc[] arcArr4 = this.f1975a;
            d2 = d;
            if (d > arcArr4[arcArr4.length - 1].d) {
                Arc[] arcArr5 = this.f1975a;
                d2 = arcArr5[arcArr5.length - 1].d;
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            Arc[] arcArr6 = this.f1975a;
            if (i2 >= arcArr6.length) {
                return;
            }
            if (d2 <= arcArr6[i2].d) {
                if (this.f1975a[i2].r) {
                    fArr[0] = (float) this.f1975a[i2].getLinearX(d2);
                    fArr[1] = (float) this.f1975a[i2].getLinearY(d2);
                    return;
                }
                this.f1975a[i2].a(d2);
                fArr[0] = (float) this.f1975a[i2].a();
                fArr[1] = (float) this.f1975a[i2].b();
                return;
            }
            i = i2 + 1;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getSlope(double d, int i) {
        double d2 = d;
        if (d < this.f1975a[0].f1978c) {
            d2 = this.f1975a[0].f1978c;
        }
        Arc[] arcArr = this.f1975a;
        int i2 = 0;
        double d3 = d2;
        if (d2 > arcArr[arcArr.length - 1].d) {
            Arc[] arcArr2 = this.f1975a;
            d3 = arcArr2[arcArr2.length - 1].d;
            i2 = 0;
        }
        while (true) {
            Arc[] arcArr3 = this.f1975a;
            if (i2 >= arcArr3.length) {
                return Double.NaN;
            }
            if (d3 <= arcArr3[i2].d) {
                if (this.f1975a[i2].r) {
                    return i == 0 ? this.f1975a[i2].getLinearDX(d3) : this.f1975a[i2].getLinearDY(d3);
                }
                this.f1975a[i2].a(d3);
                return i == 0 ? this.f1975a[i2].c() : this.f1975a[i2].d();
            }
            i2++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getSlope(double d, double[] dArr) {
        double d2;
        if (d < this.f1975a[0].f1978c) {
            d2 = this.f1975a[0].f1978c;
        } else {
            Arc[] arcArr = this.f1975a;
            d2 = d;
            if (d > arcArr[arcArr.length - 1].d) {
                Arc[] arcArr2 = this.f1975a;
                d2 = arcArr2[arcArr2.length - 1].d;
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            Arc[] arcArr3 = this.f1975a;
            if (i2 >= arcArr3.length) {
                return;
            }
            if (d2 <= arcArr3[i2].d) {
                if (this.f1975a[i2].r) {
                    dArr[0] = this.f1975a[i2].getLinearDX(d2);
                    dArr[1] = this.f1975a[i2].getLinearDY(d2);
                    return;
                }
                this.f1975a[i2].a(d2);
                dArr[0] = this.f1975a[i2].c();
                dArr[1] = this.f1975a[i2].d();
                return;
            }
            i = i2 + 1;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.b;
    }
}
