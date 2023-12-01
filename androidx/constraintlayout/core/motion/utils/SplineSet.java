package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.KeyFrameArray;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.state.WidgetFrame;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/SplineSet.class */
public abstract class SplineSet {

    /* renamed from: a  reason: collision with root package name */
    protected CurveFit f2009a;
    protected int[] b = new int[10];

    /* renamed from: c  reason: collision with root package name */
    protected float[] f2010c = new float[10];
    private int d;
    private String e;

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/SplineSet$CoreSpline.class */
    static class CoreSpline extends SplineSet {
        String d;
        long e;

        public CoreSpline(String str, long j) {
            this.d = str;
            this.e = j;
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setProperty(TypedValues typedValues, float f) {
            typedValues.setValue(typedValues.getId(this.d), get(f));
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/SplineSet$CustomSet.class */
    public static class CustomSet extends SplineSet {
        String d;
        KeyFrameArray.CustomArray e;
        float[] f;

        public CustomSet(String str, KeyFrameArray.CustomArray customArray) {
            this.d = str.split(",")[1];
            this.e = customArray;
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setPoint(int i, float f) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public void setPoint(int i, CustomAttribute customAttribute) {
            this.e.append(i, customAttribute);
        }

        public void setProperty(WidgetFrame widgetFrame, float f) {
            this.f2009a.getPos(f, this.f);
            widgetFrame.setCustomValue(this.e.valueAt(0), this.f);
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setup(int i) {
            int size = this.e.size();
            int numberOfInterpolatedValues = this.e.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            this.f = new float[numberOfInterpolatedValues];
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, size, numberOfInterpolatedValues);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= size) {
                    this.f2009a = CurveFit.get(i, dArr, dArr2);
                    return;
                }
                int keyAt = this.e.keyAt(i3);
                CustomAttribute valueAt = this.e.valueAt(i3);
                dArr[i3] = keyAt * 0.01d;
                valueAt.getValuesToInterpolate(this.f);
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    float[] fArr = this.f;
                    if (i5 < fArr.length) {
                        dArr2[i3][i5] = fArr[i5];
                        i4 = i5 + 1;
                    }
                }
                i2 = i3 + 1;
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/SplineSet$CustomSpline.class */
    public static class CustomSpline extends SplineSet {
        String d;
        KeyFrameArray.CustomVar e;
        float[] f;

        public CustomSpline(String str, KeyFrameArray.CustomVar customVar) {
            this.d = str.split(",")[1];
            this.e = customVar;
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setPoint(int i, float f) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public void setPoint(int i, CustomVariable customVariable) {
            this.e.append(i, customVariable);
        }

        public void setProperty(MotionWidget motionWidget, float f) {
            this.f2009a.getPos(f, this.f);
            this.e.valueAt(0).setInterpolatedValue(motionWidget, this.f);
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setProperty(TypedValues typedValues, float f) {
            setProperty((MotionWidget) typedValues, f);
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setup(int i) {
            int size = this.e.size();
            int numberOfInterpolatedValues = this.e.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            this.f = new float[numberOfInterpolatedValues];
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, size, numberOfInterpolatedValues);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= size) {
                    this.f2009a = CurveFit.get(i, dArr, dArr2);
                    return;
                }
                int keyAt = this.e.keyAt(i3);
                CustomVariable valueAt = this.e.valueAt(i3);
                dArr[i3] = keyAt * 0.01d;
                valueAt.getValuesToInterpolate(this.f);
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    float[] fArr = this.f;
                    if (i5 < fArr.length) {
                        dArr2[i3][i5] = fArr[i5];
                        i4 = i5 + 1;
                    }
                }
                i2 = i3 + 1;
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/SplineSet$Sort.class */
    static class Sort {
        private Sort() {
        }

        static void a(int[] iArr, float[] fArr, int i, int i2) {
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

        private static int b(int[] iArr, float[] fArr, int i, int i2) {
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

        private static void c(int[] iArr, float[] fArr, int i, int i2) {
            int i3 = iArr[i];
            iArr[i] = iArr[i2];
            iArr[i2] = i3;
            float f = fArr[i];
            fArr[i] = fArr[i2];
            fArr[i2] = f;
        }
    }

    public static SplineSet makeCustomSpline(String str, KeyFrameArray.CustomArray customArray) {
        return new CustomSet(str, customArray);
    }

    public static SplineSet makeCustomSplineSet(String str, KeyFrameArray.CustomVar customVar) {
        return new CustomSpline(str, customVar);
    }

    public static SplineSet makeSpline(String str, long j) {
        return new CoreSpline(str, j);
    }

    public float get(float f) {
        return (float) this.f2009a.getPos(f, 0);
    }

    public CurveFit getCurveFit() {
        return this.f2009a;
    }

    public float getSlope(float f) {
        return (float) this.f2009a.getSlope(f, 0);
    }

    public void setPoint(int i, float f) {
        int[] iArr = this.b;
        if (iArr.length < this.d + 1) {
            this.b = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.f2010c;
            this.f2010c = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.b;
        int i2 = this.d;
        iArr2[i2] = i;
        this.f2010c[i2] = f;
        this.d = i2 + 1;
    }

    public void setProperty(TypedValues typedValues, float f) {
        typedValues.setValue(TypedValues.AttributesType.CC.getId(this.e), get(f));
    }

    public void setType(String str) {
        this.e = str;
    }

    public void setup(int i) {
        int i2;
        int i3;
        int i4 = this.d;
        if (i4 == 0) {
            return;
        }
        Sort.a(this.b, this.f2010c, 0, i4 - 1);
        int i5 = 1;
        int i6 = 1;
        while (true) {
            i2 = i6;
            if (i5 >= this.d) {
                break;
            }
            int[] iArr = this.b;
            int i7 = i2;
            if (iArr[i5 - 1] != iArr[i5]) {
                i7 = i2 + 1;
            }
            i5++;
            i6 = i7;
        }
        double[] dArr = new double[i2];
        double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, i2, 1);
        int i8 = 0;
        for (i3 = 0; i3 < this.d; i3 = i3 + 1) {
            if (i3 > 0) {
                int[] iArr2 = this.b;
                i3 = iArr2[i3] == iArr2[i3 - 1] ? i3 + 1 : 0;
            }
            dArr[i8] = this.b[i3] * 0.01d;
            dArr2[i8][0] = this.f2010c[i3];
            i8++;
        }
        this.f2009a = CurveFit.get(i, dArr, dArr2);
    }

    public String toString() {
        String str = this.e;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.d) {
                return str;
            }
            str = str + "[" + this.b[i2] + " , " + decimalFormat.format(this.f2010c[i2]) + "] ";
            i = i2 + 1;
        }
    }
}
