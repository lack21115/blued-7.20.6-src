package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.KeyFrameArray;
import java.lang.reflect.Array;
import java.text.DecimalFormat;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/TimeCycleSplineSet.class */
public abstract class TimeCycleSplineSet {
    protected static float h = 6.2831855f;

    /* renamed from: a  reason: collision with root package name */
    protected CurveFit f2016a;
    protected int e;
    protected String f;
    protected long j;
    protected int b = 0;

    /* renamed from: c  reason: collision with root package name */
    protected int[] f2017c = new int[10];
    protected float[][] d = (float[][]) Array.newInstance(Float.TYPE, 10, 3);
    protected float[] g = new float[3];
    protected boolean i = false;
    protected float k = Float.NaN;

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/TimeCycleSplineSet$CustomSet.class */
    public static class CustomSet extends TimeCycleSplineSet {
        String l;
        KeyFrameArray.CustomArray m;
        KeyFrameArray.FloatArray n = new KeyFrameArray.FloatArray();
        float[] o;
        float[] p;

        public CustomSet(String str, KeyFrameArray.CustomArray customArray) {
            this.l = str.split(",")[1];
            this.m = customArray;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setPoint(int i, float f, float f2, int i2, float f3) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public void setPoint(int i, CustomAttribute customAttribute, float f, int i2, float f2) {
            this.m.append(i, customAttribute);
            this.n.append(i, new float[]{f, f2});
            this.b = Math.max(this.b, i2);
        }

        public boolean setProperty(MotionWidget motionWidget, float f, long j, KeyCache keyCache) {
            this.f2016a.getPos(f, this.o);
            float[] fArr = this.o;
            float f2 = fArr[fArr.length - 2];
            float f3 = fArr[fArr.length - 1];
            long j2 = this.j;
            if (Float.isNaN(this.k)) {
                this.k = keyCache.getFloatValue(motionWidget, this.l, 0);
                if (Float.isNaN(this.k)) {
                    this.k = 0.0f;
                }
            }
            this.k = (float) ((this.k + (((j - j2) * 1.0E-9d) * f2)) % 1.0d);
            this.j = j;
            float a2 = a(this.k);
            this.i = false;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.p.length) {
                    break;
                }
                this.i |= ((double) this.o[i2]) != 0.0d;
                this.p[i2] = (this.o[i2] * a2) + f3;
                i = i2 + 1;
            }
            motionWidget.setInterpolatedValue(this.m.valueAt(0), this.p);
            if (f2 != 0.0f) {
                this.i = true;
            }
            return this.i;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setup(int i) {
            int size = this.m.size();
            int numberOfInterpolatedValues = this.m.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            int i2 = numberOfInterpolatedValues + 2;
            this.o = new float[i2];
            this.p = new float[numberOfInterpolatedValues];
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, size, i2);
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= size) {
                    this.f2016a = CurveFit.get(i, dArr, dArr2);
                    return;
                }
                int keyAt = this.m.keyAt(i4);
                CustomAttribute valueAt = this.m.valueAt(i4);
                float[] valueAt2 = this.n.valueAt(i4);
                dArr[i4] = keyAt * 0.01d;
                valueAt.getValuesToInterpolate(this.o);
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    float[] fArr = this.o;
                    if (i6 < fArr.length) {
                        dArr2[i4][i6] = fArr[i6];
                        i5 = i6 + 1;
                    }
                }
                dArr2[i4][numberOfInterpolatedValues] = valueAt2[0];
                dArr2[i4][numberOfInterpolatedValues + 1] = valueAt2[1];
                i3 = i4 + 1;
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/TimeCycleSplineSet$CustomVarSet.class */
    public static class CustomVarSet extends TimeCycleSplineSet {
        String l;
        KeyFrameArray.CustomVar m;
        KeyFrameArray.FloatArray n = new KeyFrameArray.FloatArray();
        float[] o;
        float[] p;

        public CustomVarSet(String str, KeyFrameArray.CustomVar customVar) {
            this.l = str.split(",")[1];
            this.m = customVar;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setPoint(int i, float f, float f2, int i2, float f3) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public void setPoint(int i, CustomVariable customVariable, float f, int i2, float f2) {
            this.m.append(i, customVariable);
            this.n.append(i, new float[]{f, f2});
            this.b = Math.max(this.b, i2);
        }

        public boolean setProperty(MotionWidget motionWidget, float f, long j, KeyCache keyCache) {
            this.f2016a.getPos(f, this.o);
            float[] fArr = this.o;
            float f2 = fArr[fArr.length - 2];
            float f3 = fArr[fArr.length - 1];
            long j2 = this.j;
            if (Float.isNaN(this.k)) {
                this.k = keyCache.getFloatValue(motionWidget, this.l, 0);
                if (Float.isNaN(this.k)) {
                    this.k = 0.0f;
                }
            }
            this.k = (float) ((this.k + (((j - j2) * 1.0E-9d) * f2)) % 1.0d);
            this.j = j;
            float a2 = a(this.k);
            this.i = false;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.p.length) {
                    break;
                }
                this.i |= ((double) this.o[i2]) != 0.0d;
                this.p[i2] = (this.o[i2] * a2) + f3;
                i = i2 + 1;
            }
            this.m.valueAt(0).setInterpolatedValue(motionWidget, this.p);
            if (f2 != 0.0f) {
                this.i = true;
            }
            return this.i;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setup(int i) {
            int size = this.m.size();
            int numberOfInterpolatedValues = this.m.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            int i2 = numberOfInterpolatedValues + 2;
            this.o = new float[i2];
            this.p = new float[numberOfInterpolatedValues];
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, size, i2);
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= size) {
                    this.f2016a = CurveFit.get(i, dArr, dArr2);
                    return;
                }
                int keyAt = this.m.keyAt(i4);
                CustomVariable valueAt = this.m.valueAt(i4);
                float[] valueAt2 = this.n.valueAt(i4);
                dArr[i4] = keyAt * 0.01d;
                valueAt.getValuesToInterpolate(this.o);
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    float[] fArr = this.o;
                    if (i6 < fArr.length) {
                        dArr2[i4][i6] = fArr[i6];
                        i5 = i6 + 1;
                    }
                }
                dArr2[i4][numberOfInterpolatedValues] = valueAt2[0];
                dArr2[i4][numberOfInterpolatedValues + 1] = valueAt2[1];
                i3 = i4 + 1;
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/TimeCycleSplineSet$Sort.class */
    public static class Sort {
        protected Sort() {
        }

        static void a(int[] iArr, float[][] fArr, int i, int i2) {
            int[] iArr2 = new int[iArr.length + 10];
            iArr2[0] = i2;
            iArr2[1] = i;
            int i3 = 2;
            while (i3 > 0) {
                int i4 = i3 - 1;
                int i5 = iArr2[i4];
                int i6 = i4 - 1;
                int i7 = iArr2[i6];
                i3 = i6;
                if (i5 < i7) {
                    int b = b(iArr, fArr, i5, i7);
                    int i8 = i6 + 1;
                    iArr2[i6] = b - 1;
                    int i9 = i8 + 1;
                    iArr2[i8] = i5;
                    int i10 = i9 + 1;
                    iArr2[i9] = i7;
                    i3 = i10 + 1;
                    iArr2[i10] = b + 1;
                }
            }
        }

        private static int b(int[] iArr, float[][] fArr, int i, int i2) {
            int i3 = iArr[i2];
            int i4 = i;
            while (true) {
                int i5 = i4;
                if (i >= i2) {
                    c(iArr, fArr, i5, i2);
                    return i5;
                }
                int i6 = i5;
                if (iArr[i] <= i3) {
                    c(iArr, fArr, i5, i);
                    i6 = i5 + 1;
                }
                i++;
                i4 = i6;
            }
        }

        private static void c(int[] iArr, float[][] fArr, int i, int i2) {
            int i3 = iArr[i];
            iArr[i] = iArr[i2];
            iArr[i2] = i3;
            float[] fArr2 = fArr[i];
            fArr[i] = fArr[i2];
            fArr[i2] = fArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float a(float f) {
        float abs;
        switch (this.b) {
            case 1:
                return Math.signum(f * h);
            case 2:
                abs = Math.abs(f);
                break;
            case 3:
                return (((f * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                abs = ((f * 2.0f) + 1.0f) % 2.0f;
                break;
            case 5:
                return (float) Math.cos(f * h);
            case 6:
                float abs2 = 1.0f - Math.abs(((f * 4.0f) % 4.0f) - 2.0f);
                abs = abs2 * abs2;
                break;
            default:
                return (float) Math.sin(f * h);
        }
        return 1.0f - abs;
    }

    public void a(long j) {
        this.j = j;
    }

    public CurveFit getCurveFit() {
        return this.f2016a;
    }

    public void setPoint(int i, float f, float f2, int i2, float f3) {
        int[] iArr = this.f2017c;
        int i3 = this.e;
        iArr[i3] = i;
        float[][] fArr = this.d;
        fArr[i3][0] = f;
        fArr[i3][1] = f2;
        fArr[i3][2] = f3;
        this.b = Math.max(this.b, i2);
        this.e++;
    }

    public void setType(String str) {
        this.f = str;
    }

    public void setup(int i) {
        int i2;
        int i3;
        int i4 = this.e;
        if (i4 == 0) {
            System.err.println("Error no points added to " + this.f);
            return;
        }
        Sort.a(this.f2017c, this.d, 0, i4 - 1);
        int i5 = 1;
        int i6 = 0;
        while (true) {
            i2 = i6;
            int[] iArr = this.f2017c;
            if (i5 >= iArr.length) {
                break;
            }
            int i7 = i2;
            if (iArr[i5] != iArr[i5 - 1]) {
                i7 = i2 + 1;
            }
            i5++;
            i6 = i7;
        }
        int i8 = i2;
        if (i2 == 0) {
            i8 = 1;
        }
        double[] dArr = new double[i8];
        double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, i8, 3);
        int i9 = 0;
        for (i3 = 0; i3 < this.e; i3 = i3 + 1) {
            if (i3 > 0) {
                int[] iArr2 = this.f2017c;
                i3 = iArr2[i3] == iArr2[i3 - 1] ? i3 + 1 : 0;
            }
            dArr[i9] = this.f2017c[i3] * 0.01d;
            double[] dArr3 = dArr2[i9];
            float[][] fArr = this.d;
            dArr3[0] = fArr[i3][0];
            dArr2[i9][1] = fArr[i3][1];
            dArr2[i9][2] = fArr[i3][2];
            i9++;
        }
        this.f2016a = CurveFit.get(i, dArr, dArr2);
    }

    public String toString() {
        String str = this.f;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.e) {
                return str;
            }
            str = str + "[" + this.f2017c[i2] + " , " + decimalFormat.format(this.d[i2]) + "] ";
            i = i2 + 1;
        }
    }
}
