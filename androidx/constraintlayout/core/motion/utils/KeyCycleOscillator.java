package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/KeyCycleOscillator.class */
public abstract class KeyCycleOscillator {
    private CurveFit b;

    /* renamed from: c  reason: collision with root package name */
    private CycleOscillator f1988c;
    private String d;
    private int e = 0;
    private String f = null;
    public int mVariesBy = 0;

    /* renamed from: a  reason: collision with root package name */
    ArrayList<WavePoint> f1987a = new ArrayList<>();

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/KeyCycleOscillator$CoreSpline.class */
    static class CoreSpline extends KeyCycleOscillator {
        String b;

        /* renamed from: c  reason: collision with root package name */
        int f1990c;

        public CoreSpline(String str) {
            this.b = str;
            this.f1990c = TypedValues.CycleType.CC.getId(str);
        }

        @Override // androidx.constraintlayout.core.motion.utils.KeyCycleOscillator
        public void setProperty(MotionWidget motionWidget, float f) {
            motionWidget.setValue(this.f1990c, get(f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/KeyCycleOscillator$CycleOscillator.class */
    public static class CycleOscillator {

        /* renamed from: a  reason: collision with root package name */
        Oscillator f1991a;
        float[] b;

        /* renamed from: c  reason: collision with root package name */
        double[] f1992c;
        float[] d;
        float[] e;
        float[] f;
        float[] g;
        int h;
        CurveFit i;
        double[] j;
        double[] k;
        float l;
        private final int m;
        private final int n;
        private final int o;
        private final int p;

        CycleOscillator(int i, String str, int i2, int i3) {
            Oscillator oscillator = new Oscillator();
            this.f1991a = oscillator;
            this.n = 0;
            this.o = 1;
            this.p = 2;
            this.h = i;
            this.m = i2;
            oscillator.setType(i, str);
            this.b = new float[i3];
            this.f1992c = new double[i3];
            this.d = new float[i3];
            this.e = new float[i3];
            this.f = new float[i3];
            this.g = new float[i3];
        }

        public double getLastPhase() {
            return this.j[1];
        }

        public double getSlope(float f) {
            CurveFit curveFit = this.i;
            if (curveFit != null) {
                double d = f;
                curveFit.getSlope(d, this.k);
                this.i.getPos(d, this.j);
            } else {
                double[] dArr = this.k;
                dArr[0] = 0.0d;
                dArr[1] = 0.0d;
                dArr[2] = 0.0d;
            }
            double d2 = f;
            double value = this.f1991a.getValue(d2, this.j[1]);
            double slope = this.f1991a.getSlope(d2, this.j[1], this.k[1]);
            double[] dArr2 = this.k;
            return dArr2[0] + (value * dArr2[2]) + (slope * this.j[2]);
        }

        public double getValues(float f) {
            CurveFit curveFit = this.i;
            if (curveFit != null) {
                curveFit.getPos(f, this.j);
            } else {
                double[] dArr = this.j;
                dArr[0] = this.e[0];
                dArr[1] = this.f[0];
                dArr[2] = this.b[0];
            }
            double[] dArr2 = this.j;
            return dArr2[0] + (this.f1991a.getValue(f, dArr2[1]) * this.j[2]);
        }

        public void setPoint(int i, int i2, float f, float f2, float f3, float f4) {
            this.f1992c[i] = i2 / 100.0d;
            this.d[i] = f;
            this.e[i] = f2;
            this.f[i] = f3;
            this.b[i] = f4;
        }

        public void setup(float f) {
            this.l = f;
            double[][] dArr = (double[][]) Array.newInstance(Double.TYPE, this.f1992c.length, 3);
            float[] fArr = this.b;
            this.j = new double[fArr.length + 2];
            this.k = new double[fArr.length + 2];
            if (this.f1992c[0] > 0.0d) {
                this.f1991a.addPoint(0.0d, this.d[0]);
            }
            double[] dArr2 = this.f1992c;
            int length = dArr2.length - 1;
            if (dArr2[length] < 1.0d) {
                this.f1991a.addPoint(1.0d, this.d[length]);
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= dArr.length) {
                    break;
                }
                dArr[i2][0] = this.e[i2];
                dArr[i2][1] = this.f[i2];
                dArr[i2][2] = this.b[i2];
                this.f1991a.addPoint(this.f1992c[i2], this.d[i2]);
                i = i2 + 1;
            }
            this.f1991a.normalize();
            double[] dArr3 = this.f1992c;
            if (dArr3.length > 1) {
                this.i = CurveFit.get(0, dArr3, dArr);
            } else {
                this.i = null;
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/KeyCycleOscillator$IntDoubleSort.class */
    static class IntDoubleSort {
        private IntDoubleSort() {
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/KeyCycleOscillator$IntFloatFloatSort.class */
    static class IntFloatFloatSort {
        private IntFloatFloatSort() {
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/KeyCycleOscillator$PathRotateSet.class */
    public static class PathRotateSet extends KeyCycleOscillator {
        String b;

        /* renamed from: c  reason: collision with root package name */
        int f1993c;

        public PathRotateSet(String str) {
            this.b = str;
            this.f1993c = TypedValues.CycleType.CC.getId(str);
        }

        public void setPathRotate(MotionWidget motionWidget, float f, double d, double d2) {
            motionWidget.setRotationZ(get(f) + ((float) Math.toDegrees(Math.atan2(d2, d))));
        }

        @Override // androidx.constraintlayout.core.motion.utils.KeyCycleOscillator
        public void setProperty(MotionWidget motionWidget, float f) {
            motionWidget.setValue(this.f1993c, get(f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/KeyCycleOscillator$WavePoint.class */
    public static class WavePoint {

        /* renamed from: a  reason: collision with root package name */
        int f1994a;
        float b;

        /* renamed from: c  reason: collision with root package name */
        float f1995c;
        float d;
        float e;

        public WavePoint(int i, float f, float f2, float f3, float f4) {
            this.f1994a = i;
            this.b = f4;
            this.f1995c = f2;
            this.d = f;
            this.e = f3;
        }
    }

    public static KeyCycleOscillator makeWidgetCycle(String str) {
        return str.equals("pathRotate") ? new PathRotateSet(str) : new CoreSpline(str);
    }

    protected void a(Object obj) {
    }

    public float get(float f) {
        return (float) this.f1988c.getValues(f);
    }

    public CurveFit getCurveFit() {
        return this.b;
    }

    public float getSlope(float f) {
        return (float) this.f1988c.getSlope(f);
    }

    public void setPoint(int i, int i2, String str, int i3, float f, float f2, float f3, float f4) {
        this.f1987a.add(new WavePoint(i, f, f2, f3, f4));
        if (i3 != -1) {
            this.mVariesBy = i3;
        }
        this.e = i2;
        this.f = str;
    }

    public void setPoint(int i, int i2, String str, int i3, float f, float f2, float f3, float f4, Object obj) {
        this.f1987a.add(new WavePoint(i, f, f2, f3, f4));
        if (i3 != -1) {
            this.mVariesBy = i3;
        }
        this.e = i2;
        a(obj);
        this.f = str;
    }

    public void setProperty(MotionWidget motionWidget, float f) {
    }

    public void setType(String str) {
        this.d = str;
    }

    public void setup(float f) {
        int size = this.f1987a.size();
        if (size == 0) {
            return;
        }
        Collections.sort(this.f1987a, new Comparator<WavePoint>() { // from class: androidx.constraintlayout.core.motion.utils.KeyCycleOscillator.1
            @Override // java.util.Comparator
            public int compare(WavePoint wavePoint, WavePoint wavePoint2) {
                return Integer.compare(wavePoint.f1994a, wavePoint2.f1994a);
            }
        });
        double[] dArr = new double[size];
        double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, size, 3);
        this.f1988c = new CycleOscillator(this.e, this.f, this.mVariesBy, size);
        Iterator<WavePoint> it = this.f1987a.iterator();
        int i = 0;
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                this.f1988c.setup(f);
                this.b = CurveFit.get(0, dArr, dArr2);
                return;
            }
            WavePoint next = it.next();
            dArr[i2] = next.d * 0.01d;
            dArr2[i2][0] = next.b;
            dArr2[i2][1] = next.f1995c;
            dArr2[i2][2] = next.e;
            this.f1988c.setPoint(i2, next.f1994a, next.d, next.f1995c, next.e, next.b);
            i = i2 + 1;
        }
    }

    public String toString() {
        String str = this.d;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        Iterator<WavePoint> it = this.f1987a.iterator();
        while (it.hasNext()) {
            WavePoint next = it.next();
            str = str + "[" + next.f1994a + " , " + decimalFormat.format(next.b) + "] ";
        }
        return str;
    }

    public boolean variesByPath() {
        return this.mVariesBy == 1;
    }
}
