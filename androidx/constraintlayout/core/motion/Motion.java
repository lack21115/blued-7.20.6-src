package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.key.MotionKey;
import androidx.constraintlayout.core.motion.key.MotionKeyAttributes;
import androidx.constraintlayout.core.motion.key.MotionKeyCycle;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.key.MotionKeyTimeCycle;
import androidx.constraintlayout.core.motion.key.MotionKeyTrigger;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.DifferentialInterpolator;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.core.motion.utils.KeyFrameArray;
import androidx.constraintlayout.core.motion.utils.Rect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.motion.utils.Utils;
import androidx.constraintlayout.core.motion.utils.ViewState;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/Motion.class */
public class Motion implements TypedValues {
    public static final int DRAW_PATH_AS_CONFIGURED = 4;
    public static final int DRAW_PATH_BASIC = 1;
    public static final int DRAW_PATH_CARTESIAN = 3;
    public static final int DRAW_PATH_NONE = 0;
    public static final int DRAW_PATH_RECTANGLE = 5;
    public static final int DRAW_PATH_RELATIVE = 2;
    public static final int DRAW_PATH_SCREEN = 6;
    public static final int HORIZONTAL_PATH_X = 2;
    public static final int HORIZONTAL_PATH_Y = 3;
    public static final int PATH_PERCENT = 0;
    public static final int PATH_PERPENDICULAR = 1;
    public static final int ROTATION_LEFT = 2;
    public static final int ROTATION_RIGHT = 1;
    public static final int VERTICAL_PATH_X = 4;
    public static final int VERTICAL_PATH_Y = 5;
    private HashMap<String, KeyCycleOscillator> A;
    private MotionKeyTrigger[] B;
    MotionWidget b;
    float f;
    float g;
    private CurveFit[] m;
    private CurveFit n;
    private int[] o;
    private double[] p;
    private double[] q;
    private String[] r;
    private int[] s;
    private HashMap<String, TimeCycleSplineSet> y;
    private HashMap<String, SplineSet> z;

    /* renamed from: a  reason: collision with root package name */
    Rect f2008a = new Rect();
    private int h = -1;
    private MotionPaths i = new MotionPaths();
    private MotionPaths j = new MotionPaths();
    private MotionConstrainedPoint k = new MotionConstrainedPoint();
    private MotionConstrainedPoint l = new MotionConstrainedPoint();

    /* renamed from: c  reason: collision with root package name */
    float f2009c = Float.NaN;
    float d = 0.0f;
    float e = 1.0f;
    private int t = 4;
    private float[] u = new float[4];
    private ArrayList<MotionPaths> v = new ArrayList<>();
    private float[] w = new float[1];
    private ArrayList<MotionKey> x = new ArrayList<>();
    private int C = -1;
    private int D = -1;
    private MotionWidget E = null;
    private int F = -1;
    private float G = Float.NaN;
    private DifferentialInterpolator H = null;
    private boolean I = false;

    public Motion(MotionWidget motionWidget) {
        setView(motionWidget);
    }

    private float a() {
        float f;
        float f2;
        float[] fArr = new float[2];
        float f3 = 1.0f / 99;
        double d = 0.0d;
        double d2 = 0.0d;
        float f4 = 0.0f;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 100) {
                return f4;
            }
            float f5 = i2 * f3;
            double d3 = f5;
            Easing easing = this.i.b;
            Iterator<MotionPaths> it = this.v.iterator();
            float f6 = Float.NaN;
            float f7 = 0.0f;
            while (true) {
                f = f7;
                if (!it.hasNext()) {
                    break;
                }
                MotionPaths next = it.next();
                Easing easing2 = easing;
                float f8 = f6;
                float f9 = f;
                if (next.b != null) {
                    if (next.d < f5) {
                        easing2 = next.b;
                        f9 = next.d;
                        f8 = f6;
                    } else {
                        easing2 = easing;
                        f8 = f6;
                        f9 = f;
                        if (Float.isNaN(f6)) {
                            f8 = next.d;
                            f9 = f;
                            easing2 = easing;
                        }
                    }
                }
                easing = easing2;
                f6 = f8;
                f7 = f9;
            }
            if (easing != null) {
                float f10 = f6;
                if (Float.isNaN(f6)) {
                    f10 = 1.0f;
                }
                d3 = (((float) easing.get((f5 - f) / f2)) * (f10 - f)) + f;
            }
            this.m[0].getPos(d3, this.p);
            this.i.a(d3, this.o, this.p, fArr, 0);
            if (i2 > 0) {
                f4 = (float) (f4 + Math.hypot(d2 - fArr[1], d - fArr[0]));
            }
            d = fArr[0];
            d2 = fArr[1];
            i = i2 + 1;
        }
    }

    private float a(float f, float[] fArr) {
        float f2;
        if (fArr != null) {
            fArr[0] = 1.0f;
            f2 = f;
        } else {
            f2 = f;
            if (this.e != 1.0d) {
                float f3 = f;
                if (f < this.d) {
                    f3 = 0.0f;
                }
                float f4 = this.d;
                f2 = f3;
                if (f3 > f4) {
                    f2 = f3;
                    if (f3 < 1.0d) {
                        f2 = Math.min((f3 - f4) * this.e, 1.0f);
                    }
                }
            }
        }
        Easing easing = this.i.b;
        float f5 = Float.NaN;
        Iterator<MotionPaths> it = this.v.iterator();
        float f6 = 0.0f;
        while (it.hasNext()) {
            MotionPaths next = it.next();
            if (next.b != null) {
                if (next.d < f2) {
                    easing = next.b;
                    f6 = next.d;
                } else if (Float.isNaN(f5)) {
                    f5 = next.d;
                }
            }
        }
        float f7 = f2;
        if (easing != null) {
            if (Float.isNaN(f5)) {
                f5 = 1.0f;
            }
            float f8 = f5 - f6;
            double d = (f2 - f6) / f8;
            float f9 = (((float) easing.get(d)) * f8) + f6;
            f7 = f9;
            if (fArr != null) {
                fArr[0] = (float) easing.getDiff(d);
                f7 = f9;
            }
        }
        return f7;
    }

    private static DifferentialInterpolator a(int i, String str, int i2) {
        if (i != -1) {
            return null;
        }
        final Easing interpolator = Easing.getInterpolator(str);
        return new DifferentialInterpolator() { // from class: androidx.constraintlayout.core.motion.Motion.1

            /* renamed from: a  reason: collision with root package name */
            float f2010a;

            @Override // androidx.constraintlayout.core.motion.utils.DifferentialInterpolator
            public float getInterpolation(float f) {
                this.f2010a = f;
                return (float) Easing.this.get(f);
            }

            @Override // androidx.constraintlayout.core.motion.utils.DifferentialInterpolator
            public float getVelocity() {
                return (float) Easing.this.getDiff(this.f2010a);
            }
        };
    }

    private void a(MotionPaths motionPaths) {
        Iterator<MotionPaths> it = this.v.iterator();
        MotionPaths motionPaths2 = null;
        while (it.hasNext()) {
            MotionPaths next = it.next();
            if (motionPaths.e == next.e) {
                motionPaths2 = next;
            }
        }
        if (motionPaths2 != null) {
            this.v.remove(motionPaths2);
        }
        int binarySearch = Collections.binarySearch(this.v, motionPaths);
        if (binarySearch == 0) {
            Utils.loge("MotionController", " KeyPath position \"" + motionPaths.e + "\" outside of range");
        }
        this.v.add((-binarySearch) - 1, motionPaths);
    }

    private void b(MotionPaths motionPaths) {
        motionPaths.a(this.b.getX(), this.b.getY(), this.b.getWidth(), this.b.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double[] a(double d) {
        this.m[0].getPos(d, this.p);
        CurveFit curveFit = this.n;
        if (curveFit != null) {
            double[] dArr = this.p;
            if (dArr.length > 0) {
                curveFit.getPos(d, dArr);
            }
        }
        return this.p;
    }

    public void addKey(MotionKey motionKey) {
        this.x.add(motionKey);
    }

    public int buildKeyFrames(float[] fArr, int[] iArr, int[] iArr2) {
        if (fArr != null) {
            double[] timePoints = this.m[0].getTimePoints();
            if (iArr != null) {
                Iterator<MotionPaths> it = this.v.iterator();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (!it.hasNext()) {
                        break;
                    }
                    iArr[i2] = it.next().q;
                    i = i2 + 1;
                }
            }
            if (iArr2 != null) {
                Iterator<MotionPaths> it2 = this.v.iterator();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (!it2.hasNext()) {
                        break;
                    }
                    iArr2[i4] = (int) (it2.next().e * 100.0f);
                    i3 = i4 + 1;
                }
            }
            int i5 = 0;
            for (int i6 = 0; i6 < timePoints.length; i6++) {
                this.m[0].getPos(timePoints[i6], this.p);
                this.i.a(timePoints[i6], this.o, this.p, fArr, i5);
                i5 += 2;
            }
            return i5 / 2;
        }
        return 0;
    }

    public void buildPath(float[] fArr, int i) {
        float f;
        float f2;
        float f3 = 1.0f / (i - 1);
        HashMap<String, SplineSet> hashMap = this.z;
        KeyCycleOscillator keyCycleOscillator = null;
        SplineSet splineSet = hashMap == null ? null : hashMap.get("translationX");
        HashMap<String, SplineSet> hashMap2 = this.z;
        SplineSet splineSet2 = hashMap2 == null ? null : hashMap2.get("translationY");
        HashMap<String, KeyCycleOscillator> hashMap3 = this.A;
        KeyCycleOscillator keyCycleOscillator2 = hashMap3 == null ? null : hashMap3.get("translationX");
        HashMap<String, KeyCycleOscillator> hashMap4 = this.A;
        if (hashMap4 != null) {
            keyCycleOscillator = hashMap4.get("translationY");
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            float f4 = i3 * f3;
            float f5 = f4;
            if (this.e != 1.0f) {
                float f6 = f4;
                if (f4 < this.d) {
                    f6 = 0.0f;
                }
                float f7 = this.d;
                f5 = f6;
                if (f6 > f7) {
                    f5 = f6;
                    if (f6 < 1.0d) {
                        f5 = Math.min((f6 - f7) * this.e, 1.0f);
                    }
                }
            }
            double d = f5;
            Easing easing = this.i.b;
            float f8 = Float.NaN;
            Iterator<MotionPaths> it = this.v.iterator();
            float f9 = 0.0f;
            while (true) {
                f = f9;
                if (!it.hasNext()) {
                    break;
                }
                MotionPaths next = it.next();
                Easing easing2 = easing;
                float f10 = f8;
                float f11 = f;
                if (next.b != null) {
                    if (next.d < f5) {
                        easing2 = next.b;
                        f11 = next.d;
                        f10 = f8;
                    } else {
                        easing2 = easing;
                        f10 = f8;
                        f11 = f;
                        if (Float.isNaN(f8)) {
                            f10 = next.d;
                            f11 = f;
                            easing2 = easing;
                        }
                    }
                }
                easing = easing2;
                f8 = f10;
                f9 = f11;
            }
            if (easing != null) {
                float f12 = f8;
                if (Float.isNaN(f8)) {
                    f12 = 1.0f;
                }
                d = (((float) easing.get((f5 - f) / f2)) * (f12 - f)) + f;
            }
            this.m[0].getPos(d, this.p);
            CurveFit curveFit = this.n;
            if (curveFit != null) {
                double[] dArr = this.p;
                if (dArr.length > 0) {
                    curveFit.getPos(d, dArr);
                }
            }
            int i4 = i3 * 2;
            this.i.a(d, this.o, this.p, fArr, i4);
            if (keyCycleOscillator2 != null) {
                fArr[i4] = fArr[i4] + keyCycleOscillator2.get(f5);
            } else if (splineSet != null) {
                fArr[i4] = fArr[i4] + splineSet.get(f5);
            }
            if (keyCycleOscillator != null) {
                int i5 = i4 + 1;
                fArr[i5] = fArr[i5] + keyCycleOscillator.get(f5);
            } else if (splineSet2 != null) {
                int i6 = i4 + 1;
                fArr[i6] = fArr[i6] + splineSet2.get(f5);
            }
            i2 = i3 + 1;
        }
    }

    public void buildRect(float f, float[] fArr, int i) {
        this.m[0].getPos(a(f, null), this.p);
        this.i.a(this.o, this.p, fArr, i);
    }

    public int getAnimateRelativeTo() {
        return this.i.m;
    }

    public void getCenter(double d, float[] fArr, float[] fArr2) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.m[0].getPos(d, dArr);
        this.m[0].getSlope(d, dArr2);
        Arrays.fill(fArr2, 0.0f);
        this.i.a(d, this.o, dArr, fArr, dArr2, fArr2);
    }

    public float getCenterX() {
        return this.f;
    }

    public float getCenterY() {
        return this.g;
    }

    public int getDrawPath() {
        int i = this.i.f2014c;
        Iterator<MotionPaths> it = this.v.iterator();
        while (it.hasNext()) {
            i = Math.max(i, it.next().f2014c);
        }
        return Math.max(i, this.j.f2014c);
    }

    public float getFinalHeight() {
        return this.j.i;
    }

    public float getFinalWidth() {
        return this.j.h;
    }

    public float getFinalX() {
        return this.j.f;
    }

    public float getFinalY() {
        return this.j.g;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String str) {
        return 0;
    }

    public MotionPaths getKeyFrame(int i) {
        return this.v.get(i);
    }

    public int getKeyFrameInfo(int i, int[] iArr) {
        float[] fArr = new float[2];
        Iterator<MotionKey> it = this.x.iterator();
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            MotionKey next = it.next();
            if (next.mType == i || i != -1) {
                iArr[i3] = 0;
                int i4 = i3 + 1;
                iArr[i4] = next.mType;
                int i5 = i4 + 1;
                iArr[i5] = next.mFramePosition;
                double d = next.mFramePosition / 100.0f;
                this.m[0].getPos(d, this.p);
                this.i.a(d, this.o, this.p, fArr, 0);
                int i6 = i5 + 1;
                iArr[i6] = Float.floatToIntBits(fArr[0]);
                int i7 = i6 + 1;
                iArr[i7] = Float.floatToIntBits(fArr[1]);
                int i8 = i7;
                if (next instanceof MotionKeyPosition) {
                    MotionKeyPosition motionKeyPosition = (MotionKeyPosition) next;
                    int i9 = i7 + 1;
                    iArr[i9] = motionKeyPosition.mPositionType;
                    int i10 = i9 + 1;
                    iArr[i10] = Float.floatToIntBits(motionKeyPosition.mPercentX);
                    i8 = i10 + 1;
                    iArr[i8] = Float.floatToIntBits(motionKeyPosition.mPercentY);
                }
                int i11 = i8 + 1;
                iArr[i3] = i11 - i3;
                i2++;
                i3 = i11;
            }
        }
        return i2;
    }

    public int getKeyFramePositions(int[] iArr, float[] fArr) {
        Iterator<MotionKey> it = this.x.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            MotionKey next = it.next();
            iArr[i] = next.mFramePosition + (next.mType * 1000);
            double d = next.mFramePosition / 100.0f;
            this.m[0].getPos(d, this.p);
            this.i.a(d, this.o, this.p, fArr, i2);
            i2 += 2;
            i++;
        }
        return i;
    }

    public float getStartHeight() {
        return this.i.i;
    }

    public float getStartWidth() {
        return this.i.h;
    }

    public float getStartX() {
        return this.i.f;
    }

    public float getStartY() {
        return this.i.g;
    }

    public int getTransformPivotTarget() {
        return this.D;
    }

    public MotionWidget getView() {
        return this.b;
    }

    public boolean interpolate(MotionWidget motionWidget, float f, long j, KeyCache keyCache) {
        MotionWidget motionWidget2;
        float a2 = a(f, null);
        int i = this.F;
        float f2 = a2;
        if (i != -1) {
            float f3 = 1.0f / i;
            float floor = (float) Math.floor(a2 / f3);
            float f4 = (a2 % f3) / f3;
            float f5 = f4;
            if (!Float.isNaN(this.G)) {
                f5 = (f4 + this.G) % 1.0f;
            }
            DifferentialInterpolator differentialInterpolator = this.H;
            f2 = ((differentialInterpolator != null ? differentialInterpolator.getInterpolation(f5) : ((double) f5) > 0.5d ? 1.0f : 0.0f) * f3) + (floor * f3);
        }
        HashMap<String, SplineSet> hashMap = this.z;
        if (hashMap != null) {
            for (SplineSet splineSet : hashMap.values()) {
                splineSet.setProperty(motionWidget, f2);
            }
        }
        CurveFit[] curveFitArr = this.m;
        if (curveFitArr != null) {
            CurveFit curveFit = curveFitArr[0];
            double d = f2;
            curveFit.getPos(d, this.p);
            this.m[0].getSlope(d, this.q);
            CurveFit curveFit2 = this.n;
            if (curveFit2 != null) {
                double[] dArr = this.p;
                if (dArr.length > 0) {
                    curveFit2.getPos(d, dArr);
                    this.n.getSlope(d, this.q);
                }
            }
            if (!this.I) {
                this.i.a(f2, motionWidget, this.o, this.p, this.q, (double[]) null);
            }
            if (this.D != -1) {
                if (this.E == null) {
                    this.E = motionWidget.getParent().findViewById(this.D);
                }
                if (this.E != null) {
                    float top = (motionWidget2.getTop() + this.E.getBottom()) / 2.0f;
                    float left = (this.E.getLeft() + this.E.getRight()) / 2.0f;
                    if (motionWidget.getRight() - motionWidget.getLeft() > 0 && motionWidget.getBottom() - motionWidget.getTop() > 0) {
                        motionWidget.setPivotX(left - motionWidget.getLeft());
                        motionWidget.setPivotY(top - motionWidget.getTop());
                    }
                }
            }
            int i2 = 1;
            while (true) {
                int i3 = i2;
                CurveFit[] curveFitArr2 = this.m;
                if (i3 >= curveFitArr2.length) {
                    break;
                }
                curveFitArr2[i3].getPos(d, this.u);
                this.i.p.get(this.r[i3 - 1]).setInterpolatedValue(motionWidget, this.u);
                i2 = i3 + 1;
            }
            if (this.k.f2012a == 0) {
                if (f2 <= 0.0f) {
                    motionWidget.setVisibility(this.k.b);
                } else if (f2 >= 1.0f) {
                    motionWidget.setVisibility(this.l.b);
                } else if (this.l.b != this.k.b) {
                    motionWidget.setVisibility(4);
                }
            }
            if (this.B != null) {
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    MotionKeyTrigger[] motionKeyTriggerArr = this.B;
                    if (i5 >= motionKeyTriggerArr.length) {
                        break;
                    }
                    motionKeyTriggerArr[i5].conditionallyFire(f2, motionWidget);
                    i4 = i5 + 1;
                }
            }
        } else {
            float f6 = this.i.f + ((this.j.f - this.i.f) * f2) + 0.5f;
            int i6 = (int) f6;
            float f7 = this.i.g + ((this.j.g - this.i.g) * f2) + 0.5f;
            motionWidget.layout(i6, (int) f7, (int) (f6 + this.i.h + ((this.j.h - this.i.h) * f2)), (int) (f7 + this.i.i + ((this.j.i - this.i.i) * f2)));
        }
        HashMap<String, KeyCycleOscillator> hashMap2 = this.A;
        if (hashMap2 != null) {
            for (KeyCycleOscillator keyCycleOscillator : hashMap2.values()) {
                if (keyCycleOscillator instanceof KeyCycleOscillator.PathRotateSet) {
                    KeyCycleOscillator.PathRotateSet pathRotateSet = (KeyCycleOscillator.PathRotateSet) keyCycleOscillator;
                    double[] dArr2 = this.q;
                    pathRotateSet.setPathRotate(motionWidget, f2, dArr2[0], dArr2[1]);
                } else {
                    keyCycleOscillator.setProperty(motionWidget, f2);
                }
            }
            return false;
        }
        return false;
    }

    public void setDrawPath(int i) {
        this.i.f2014c = i;
    }

    public void setEnd(MotionWidget motionWidget) {
        this.j.d = 1.0f;
        this.j.e = 1.0f;
        b(this.j);
        this.j.a(motionWidget.getLeft(), motionWidget.getTop(), motionWidget.getWidth(), motionWidget.getHeight());
        this.j.applyParameters(motionWidget);
        this.l.setState(motionWidget);
    }

    public void setPathMotionArc(int i) {
        this.C = i;
    }

    public void setStart(MotionWidget motionWidget) {
        this.i.d = 0.0f;
        this.i.e = 0.0f;
        this.i.a(motionWidget.getX(), motionWidget.getY(), motionWidget.getWidth(), motionWidget.getHeight());
        this.i.applyParameters(motionWidget);
        this.k.setState(motionWidget);
    }

    public void setStartState(ViewState viewState, MotionWidget motionWidget, int i, int i2, int i3) {
        this.i.d = 0.0f;
        this.i.e = 0.0f;
        Rect rect = new Rect();
        if (i == 1) {
            int i4 = viewState.left;
            int i5 = viewState.right;
            rect.left = ((viewState.top + viewState.bottom) - viewState.width()) / 2;
            rect.top = i2 - (((i4 + i5) + viewState.height()) / 2);
            rect.right = rect.left + viewState.width();
            rect.bottom = rect.top + viewState.height();
        } else if (i == 2) {
            int i6 = viewState.left;
            int i7 = viewState.right;
            rect.left = i3 - (((viewState.top + viewState.bottom) + viewState.width()) / 2);
            rect.top = ((i6 + i7) - viewState.height()) / 2;
            rect.right = rect.left + viewState.width();
            rect.bottom = rect.top + viewState.height();
        }
        this.i.a(rect.left, rect.top, rect.width(), rect.height());
        this.k.setState(rect, motionWidget, i, viewState.rotation);
    }

    public void setTransformPivotTarget(int i) {
        this.D = i;
        this.E = null;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, float f) {
        return false;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, int i2) {
        if (i != 509) {
            return i == 704;
        }
        setPathMotionArc(i2);
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, String str) {
        if (705 == i) {
            PrintStream printStream = System.out;
            printStream.println("TYPE_INTERPOLATOR  " + str);
            this.H = a(-1, str, 0);
            return false;
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, boolean z) {
        return false;
    }

    public void setView(MotionWidget motionWidget) {
        this.b = motionWidget;
    }

    public void setup(int i, int i2, float f, long j) {
        ArrayList arrayList;
        int i3;
        CustomVariable customVariable;
        SplineSet makeSpline;
        CustomVariable customVariable2;
        Integer num;
        SplineSet makeSpline2;
        CustomVariable customVariable3;
        Class<Double> cls = Double.TYPE;
        new HashSet();
        HashSet<String> hashSet = new HashSet<>();
        HashSet<String> hashSet2 = new HashSet<>();
        HashSet<String> hashSet3 = new HashSet<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        int i4 = this.C;
        if (i4 != -1) {
            this.i.l = i4;
        }
        this.k.a(this.l, hashSet2);
        ArrayList<MotionKey> arrayList2 = this.x;
        if (arrayList2 != null) {
            Iterator<MotionKey> it = arrayList2.iterator();
            ArrayList arrayList3 = null;
            while (true) {
                arrayList = arrayList3;
                if (!it.hasNext()) {
                    break;
                }
                MotionKey next = it.next();
                if (next instanceof MotionKeyPosition) {
                    MotionKeyPosition motionKeyPosition = (MotionKeyPosition) next;
                    a(new MotionPaths(i, i2, motionKeyPosition, this.i, this.j));
                    if (motionKeyPosition.mCurveFit != -1) {
                        this.h = motionKeyPosition.mCurveFit;
                    }
                } else if (next instanceof MotionKeyCycle) {
                    next.getAttributeNames(hashSet3);
                } else if (next instanceof MotionKeyTimeCycle) {
                    next.getAttributeNames(hashSet);
                } else if (next instanceof MotionKeyTrigger) {
                    ArrayList arrayList4 = arrayList3;
                    if (arrayList3 == null) {
                        arrayList4 = new ArrayList();
                    }
                    arrayList4.add((MotionKeyTrigger) next);
                    arrayList3 = arrayList4;
                } else {
                    next.setInterpolation(hashMap);
                    next.getAttributeNames(hashSet2);
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            this.B = (MotionKeyTrigger[]) arrayList.toArray(new MotionKeyTrigger[0]);
        }
        if (!hashSet2.isEmpty()) {
            this.z = new HashMap<>();
            Iterator<String> it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                String next2 = it2.next();
                if (next2.startsWith("CUSTOM,")) {
                    KeyFrameArray.CustomVar customVar = new KeyFrameArray.CustomVar();
                    String str = next2.split(",")[1];
                    Iterator<MotionKey> it3 = this.x.iterator();
                    while (it3.hasNext()) {
                        MotionKey next3 = it3.next();
                        if (next3.mCustom != null && (customVariable3 = next3.mCustom.get(str)) != null) {
                            customVar.append(next3.mFramePosition, customVariable3);
                        }
                    }
                    makeSpline2 = SplineSet.makeCustomSplineSet(next2, customVar);
                } else {
                    makeSpline2 = SplineSet.makeSpline(next2, j);
                }
                if (makeSpline2 != null) {
                    makeSpline2.setType(next2);
                    this.z.put(next2, makeSpline2);
                }
            }
            ArrayList<MotionKey> arrayList5 = this.x;
            if (arrayList5 != null) {
                Iterator<MotionKey> it4 = arrayList5.iterator();
                while (it4.hasNext()) {
                    MotionKey next4 = it4.next();
                    if (next4 instanceof MotionKeyAttributes) {
                        next4.addValues(this.z);
                    }
                }
            }
            this.k.addValues(this.z, 0);
            this.l.addValues(this.z, 100);
            for (String str2 : this.z.keySet()) {
                int intValue = (!hashMap.containsKey(str2) || (num = hashMap.get(str2)) == null) ? 0 : num.intValue();
                SplineSet splineSet = this.z.get(str2);
                if (splineSet != null) {
                    splineSet.setup(intValue);
                }
            }
        }
        if (!hashSet.isEmpty()) {
            if (this.y == null) {
                this.y = new HashMap<>();
            }
            Iterator<String> it5 = hashSet.iterator();
            while (it5.hasNext()) {
                String next5 = it5.next();
                if (!this.y.containsKey(next5)) {
                    if (next5.startsWith("CUSTOM,")) {
                        KeyFrameArray.CustomVar customVar2 = new KeyFrameArray.CustomVar();
                        String str3 = next5.split(",")[1];
                        Iterator<MotionKey> it6 = this.x.iterator();
                        while (it6.hasNext()) {
                            MotionKey next6 = it6.next();
                            if (next6.mCustom != null && (customVariable2 = next6.mCustom.get(str3)) != null) {
                                customVar2.append(next6.mFramePosition, customVariable2);
                            }
                        }
                        makeSpline = SplineSet.makeCustomSplineSet(next5, customVar2);
                    } else {
                        makeSpline = SplineSet.makeSpline(next5, j);
                    }
                    if (makeSpline != null) {
                        makeSpline.setType(next5);
                    }
                }
            }
            ArrayList<MotionKey> arrayList6 = this.x;
            if (arrayList6 != null) {
                Iterator<MotionKey> it7 = arrayList6.iterator();
                while (it7.hasNext()) {
                    MotionKey next7 = it7.next();
                    if (next7 instanceof MotionKeyTimeCycle) {
                        ((MotionKeyTimeCycle) next7).addTimeValues(this.y);
                    }
                }
            }
            for (String str4 : this.y.keySet()) {
                this.y.get(str4).setup(hashMap.containsKey(str4) ? hashMap.get(str4).intValue() : 0);
            }
        }
        int size = this.v.size() + 2;
        MotionPaths[] motionPathsArr = new MotionPaths[size];
        motionPathsArr[0] = this.i;
        motionPathsArr[size - 1] = this.j;
        if (this.v.size() > 0 && this.h == MotionKey.UNSET) {
            this.h = 0;
        }
        Iterator<MotionPaths> it8 = this.v.iterator();
        int i5 = 1;
        while (true) {
            int i6 = i5;
            if (!it8.hasNext()) {
                break;
            }
            motionPathsArr[i6] = it8.next();
            i5 = i6 + 1;
        }
        HashSet hashSet4 = new HashSet();
        for (String str5 : this.j.p.keySet()) {
            if (this.i.p.containsKey(str5)) {
                if (!hashSet2.contains("CUSTOM," + str5)) {
                    hashSet4.add(str5);
                }
            }
        }
        String[] strArr = (String[]) hashSet4.toArray(new String[0]);
        this.r = strArr;
        this.s = new int[strArr.length];
        int i7 = 0;
        while (true) {
            int i8 = i7;
            String[] strArr2 = this.r;
            if (i8 >= strArr2.length) {
                break;
            }
            String str6 = strArr2[i8];
            this.s[i8] = 0;
            int i9 = 0;
            while (true) {
                int i10 = i9;
                if (i10 >= size) {
                    break;
                }
                if (motionPathsArr[i10].p.containsKey(str6) && (customVariable = motionPathsArr[i10].p.get(str6)) != null) {
                    int[] iArr = this.s;
                    iArr[i8] = iArr[i8] + customVariable.numberOfInterpolatedValues();
                    break;
                }
                i9 = i10 + 1;
            }
            i7 = i8 + 1;
        }
        boolean z = motionPathsArr[0].l != -1;
        int length = 18 + this.r.length;
        boolean[] zArr = new boolean[length];
        int i11 = 1;
        while (true) {
            int i12 = i11;
            if (i12 >= size) {
                break;
            }
            motionPathsArr[i12].a(motionPathsArr[i12 - 1], zArr, this.r, z);
            i11 = i12 + 1;
        }
        int i13 = 1;
        int i14 = 0;
        while (true) {
            i3 = i14;
            if (i13 >= length) {
                break;
            }
            int i15 = i3;
            if (zArr[i13]) {
                i15 = i3 + 1;
            }
            i13++;
            i14 = i15;
        }
        this.o = new int[i3];
        int max = Math.max(2, i3);
        this.p = new double[max];
        this.q = new double[max];
        int i16 = 1;
        int i17 = 0;
        while (true) {
            int i18 = i17;
            if (i16 >= length) {
                break;
            }
            int i19 = i18;
            if (zArr[i16]) {
                this.o[i18] = i16;
                i19 = i18 + 1;
            }
            i16++;
            i17 = i19;
        }
        double[][] dArr = (double[][]) Array.newInstance(Double.TYPE, size, this.o.length);
        double[] dArr2 = new double[size];
        int i20 = 0;
        while (true) {
            int i21 = i20;
            if (i21 >= size) {
                break;
            }
            motionPathsArr[i21].a(dArr[i21], this.o);
            dArr2[i21] = motionPathsArr[i21].d;
            i20 = i21 + 1;
        }
        int i22 = 0;
        while (true) {
            int i23 = i22;
            int[] iArr2 = this.o;
            if (i23 >= iArr2.length) {
                break;
            }
            if (iArr2[i23] < MotionPaths.f2013a.length) {
                String str7 = MotionPaths.f2013a[this.o[i23]] + " [";
                int i24 = 0;
                while (true) {
                    int i25 = i24;
                    if (i25 < size) {
                        str7 = str7 + dArr[i25][i23];
                        i24 = i25 + 1;
                    }
                }
            }
            i22 = i23 + 1;
        }
        this.m = new CurveFit[this.r.length + 1];
        int i26 = 0;
        while (true) {
            String[] strArr3 = this.r;
            if (i26 >= strArr3.length) {
                break;
            }
            double[][] dArr3 = null;
            String str8 = strArr3[i26];
            double[] dArr4 = null;
            int i27 = 0;
            for (int i28 = 0; i28 < size; i28++) {
                if (motionPathsArr[i28].a(str8)) {
                    double[][] dArr5 = dArr3;
                    if (dArr3 == null) {
                        dArr4 = new double[size];
                        dArr5 = (double[][]) Array.newInstance(cls, size, motionPathsArr[i28].b(str8));
                    }
                    dArr4[i27] = motionPathsArr[i28].d;
                    motionPathsArr[i28].a(str8, dArr5[i27], 0);
                    i27++;
                    dArr3 = dArr5;
                }
            }
            i26++;
            this.m[i26] = CurveFit.get(this.h, Arrays.copyOf(dArr4, i27), (double[][]) Arrays.copyOf(dArr3, i27));
        }
        this.m[0] = CurveFit.get(this.h, dArr2, dArr);
        if (motionPathsArr[0].l != -1) {
            int[] iArr3 = new int[size];
            double[] dArr6 = new double[size];
            double[][] dArr7 = (double[][]) Array.newInstance(cls, size, 2);
            int i29 = 0;
            while (true) {
                int i30 = i29;
                if (i30 >= size) {
                    break;
                }
                iArr3[i30] = motionPathsArr[i30].l;
                dArr6[i30] = motionPathsArr[i30].d;
                dArr7[i30][0] = motionPathsArr[i30].f;
                dArr7[i30][1] = motionPathsArr[i30].g;
                i29 = i30 + 1;
            }
            this.n = CurveFit.getArc(iArr3, dArr6, dArr7);
        }
        float f2 = Float.NaN;
        this.A = new HashMap<>();
        if (this.x != null) {
            Iterator<String> it9 = hashSet3.iterator();
            while (it9.hasNext()) {
                String next8 = it9.next();
                KeyCycleOscillator makeWidgetCycle = KeyCycleOscillator.makeWidgetCycle(next8);
                if (makeWidgetCycle != null) {
                    float f3 = f2;
                    if (makeWidgetCycle.variesByPath()) {
                        f3 = f2;
                        if (Float.isNaN(f2)) {
                            f3 = a();
                        }
                    }
                    makeWidgetCycle.setType(next8);
                    this.A.put(next8, makeWidgetCycle);
                    f2 = f3;
                }
            }
            Iterator<MotionKey> it10 = this.x.iterator();
            while (it10.hasNext()) {
                MotionKey next9 = it10.next();
                if (next9 instanceof MotionKeyCycle) {
                    ((MotionKeyCycle) next9).addCycleValues(this.A);
                }
            }
            for (KeyCycleOscillator keyCycleOscillator : this.A.values()) {
                keyCycleOscillator.setup(f2);
            }
        }
    }

    public void setupRelative(Motion motion) {
        this.i.setupRelative(motion, motion.i);
        this.j.setupRelative(motion, motion.j);
    }

    public String toString() {
        return " start: x: " + this.i.f + " y: " + this.i.g + " end: x: " + this.j.f + " y: " + this.j.g;
    }
}
