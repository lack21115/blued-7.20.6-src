package androidx.constraintlayout.core.motion.utils;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/CurveFit.class */
public abstract class CurveFit {
    public static final int CONSTANT = 2;
    public static final int LINEAR = 1;
    public static final int SPLINE = 0;

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/CurveFit$Constant.class */
    static class Constant extends CurveFit {

        /* renamed from: a  reason: collision with root package name */
        double f2027a;
        double[] b;

        Constant(double d, double[] dArr) {
            this.f2027a = d;
            this.b = dArr;
        }

        @Override // androidx.constraintlayout.core.motion.utils.CurveFit
        public double getPos(double d, int i) {
            return this.b[i];
        }

        @Override // androidx.constraintlayout.core.motion.utils.CurveFit
        public void getPos(double d, double[] dArr) {
            double[] dArr2 = this.b;
            System.arraycopy((Object) dArr2, 0, (Object) dArr, 0, dArr2.length);
        }

        @Override // androidx.constraintlayout.core.motion.utils.CurveFit
        public void getPos(double d, float[] fArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                double[] dArr = this.b;
                if (i2 >= dArr.length) {
                    return;
                }
                fArr[i2] = (float) dArr[i2];
                i = i2 + 1;
            }
        }

        @Override // androidx.constraintlayout.core.motion.utils.CurveFit
        public double getSlope(double d, int i) {
            return 0.0d;
        }

        @Override // androidx.constraintlayout.core.motion.utils.CurveFit
        public void getSlope(double d, double[] dArr) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.b.length) {
                    return;
                }
                dArr[i2] = 0.0d;
                i = i2 + 1;
            }
        }

        @Override // androidx.constraintlayout.core.motion.utils.CurveFit
        public double[] getTimePoints() {
            return new double[]{this.f2027a};
        }
    }

    public static CurveFit get(int i, double[] dArr, double[][] dArr2) {
        if (dArr.length == 1) {
            i = 2;
        }
        return i != 0 ? i != 2 ? new LinearCurveFit(dArr, dArr2) : new Constant(dArr[0], dArr2[0]) : new MonotonicCurveFit(dArr, dArr2);
    }

    public static CurveFit getArc(int[] iArr, double[] dArr, double[][] dArr2) {
        return new ArcCurveFit(iArr, dArr, dArr2);
    }

    public abstract double getPos(double d, int i);

    public abstract void getPos(double d, double[] dArr);

    public abstract void getPos(double d, float[] fArr);

    public abstract double getSlope(double d, int i);

    public abstract void getSlope(double d, double[] dArr);

    public abstract double[] getTimePoints();
}
