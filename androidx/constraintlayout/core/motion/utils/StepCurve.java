package androidx.constraintlayout.core.motion.utils;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/StepCurve.class */
public class StepCurve extends Easing {

    /* renamed from: c  reason: collision with root package name */
    MonotonicCurveFit f2013c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StepCurve(String str) {
        this.b = str;
        double[] dArr = new double[this.b.length() / 2];
        int indexOf = str.indexOf(40) + 1;
        int indexOf2 = str.indexOf(44, indexOf);
        int i = 0;
        while (true) {
            int i2 = i;
            if (indexOf2 == -1) {
                dArr[i2] = Double.parseDouble(str.substring(indexOf, str.indexOf(41, indexOf)).trim());
                this.f2013c = a(Arrays.copyOf(dArr, i2 + 1));
                return;
            }
            dArr[i2] = Double.parseDouble(str.substring(indexOf, indexOf2).trim());
            indexOf = indexOf2 + 1;
            indexOf2 = str.indexOf(44, indexOf);
            i = i2 + 1;
        }
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
                MonotonicCurveFit monotonicCurveFit = new MonotonicCurveFit(dArr3, dArr2);
                PrintStream printStream = System.out;
                printStream.println(" 0 " + monotonicCurveFit.getPos(0.0d, 0));
                PrintStream printStream2 = System.out;
                printStream2.println(" 1 " + monotonicCurveFit.getPos(1.0d, 0));
                return monotonicCurveFit;
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

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public double get(double d) {
        return this.f2013c.getPos(d, 0);
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public double getDiff(double d) {
        return this.f2013c.getSlope(d, 0);
    }
}
