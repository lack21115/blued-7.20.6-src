package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.VelocityMatrix;
import androidx.constraintlayout.motion.utils.CustomSupport;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.motion.utils.ViewState;
import androidx.constraintlayout.motion.utils.ViewTimeCycle;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/widget/MotionController.class */
public class MotionController {
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
    private HashMap<String, ViewTimeCycle> B;
    private HashMap<String, ViewSpline> C;
    private HashMap<String, ViewOscillator> D;
    private KeyTrigger[] E;
    View b;

    /* renamed from: c  reason: collision with root package name */
    int f2180c;
    String e;
    float i;
    float j;
    private CurveFit[] p;
    private CurveFit q;
    private int[] r;
    private double[] s;
    private double[] t;
    private String[] u;
    private int[] v;

    /* renamed from: a  reason: collision with root package name */
    Rect f2179a = new Rect();
    boolean d = false;
    private int k = -1;
    private MotionPaths l = new MotionPaths();
    private MotionPaths m = new MotionPaths();
    private MotionConstrainedPoint n = new MotionConstrainedPoint();
    private MotionConstrainedPoint o = new MotionConstrainedPoint();
    float f = Float.NaN;
    float g = 0.0f;
    float h = 1.0f;
    private int w = 4;
    private float[] x = new float[4];
    private ArrayList<MotionPaths> y = new ArrayList<>();
    private float[] z = new float[1];
    private ArrayList<Key> A = new ArrayList<>();
    private int F = Key.UNSET;
    private int G = Key.UNSET;
    private View H = null;
    private int I = Key.UNSET;
    private float J = Float.NaN;
    private Interpolator K = null;
    private boolean L = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MotionController(View view) {
        setView(view);
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
            Easing easing = this.l.b;
            Iterator<MotionPaths> it = this.y.iterator();
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
            this.p[0].getPos(d3, this.s);
            this.l.a(d3, this.r, this.s, fArr, 0);
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
            if (this.h != 1.0d) {
                float f3 = f;
                if (f < this.g) {
                    f3 = 0.0f;
                }
                float f4 = this.g;
                f2 = f3;
                if (f3 > f4) {
                    f2 = f3;
                    if (f3 < 1.0d) {
                        f2 = Math.min((f3 - f4) * this.h, 1.0f);
                    }
                }
            }
        }
        Easing easing = this.l.b;
        float f5 = Float.NaN;
        Iterator<MotionPaths> it = this.y.iterator();
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

    private static Interpolator a(Context context, int i, String str, int i2) {
        if (i != -2) {
            if (i == -1) {
                final Easing interpolator = Easing.getInterpolator(str);
                return new Interpolator() { // from class: androidx.constraintlayout.motion.widget.MotionController.1
                    @Override // android.animation.TimeInterpolator
                    public float getInterpolation(float f) {
                        return (float) Easing.this.get(f);
                    }
                };
            } else if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 4) {
                            if (i != 5) {
                                return null;
                            }
                            return new OvershootInterpolator();
                        }
                        return new BounceInterpolator();
                    }
                    return new DecelerateInterpolator();
                }
                return new AccelerateInterpolator();
            } else {
                return new AccelerateDecelerateInterpolator();
            }
        }
        return AnimationUtils.loadInterpolator(context, i2);
    }

    private void a(MotionPaths motionPaths) {
        int binarySearch = Collections.binarySearch(this.y, motionPaths);
        if (binarySearch == 0) {
            Log.e("MotionController", " KeyPath position \"" + motionPaths.e + "\" outside of range");
        }
        this.y.add((-binarySearch) - 1, motionPaths);
    }

    private void b(MotionPaths motionPaths) {
        motionPaths.a((int) this.b.getX(), (int) this.b.getY(), this.b.getWidth(), this.b.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float a(int i, float f, float f2) {
        float f3 = this.m.f - this.l.f;
        float f4 = this.m.g - this.l.g;
        float f5 = this.l.f;
        float f6 = this.l.h / 2.0f;
        float f7 = this.l.g;
        float f8 = this.l.i / 2.0f;
        float hypot = (float) Math.hypot(f3, f4);
        if (hypot < 1.0E-7d) {
            return Float.NaN;
        }
        float f9 = f - (f5 + f6);
        float f10 = f2 - (f7 + f8);
        if (((float) Math.hypot(f9, f10)) == 0.0f) {
            return 0.0f;
        }
        float f11 = (f9 * f3) + (f10 * f4);
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return 0.0f;
                            }
                            return f10 / f4;
                        }
                        return f9 / f4;
                    }
                    return f10 / f3;
                }
                return f9 / f3;
            }
            return (float) Math.sqrt((hypot * hypot) - (f11 * f11));
        }
        return f11 / hypot;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(String str, float[] fArr, int i) {
        ViewSpline viewSpline = this.C.get(str);
        if (viewSpline == null) {
            return -1;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= fArr.length) {
                return fArr.length;
            }
            fArr[i3] = viewSpline.get(i3 / (fArr.length - 1));
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(float[] fArr, int[] iArr) {
        if (fArr != null) {
            double[] timePoints = this.p[0].getTimePoints();
            if (iArr != null) {
                Iterator<MotionPaths> it = this.y.iterator();
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
            int i3 = 0;
            for (int i4 = 0; i4 < timePoints.length; i4++) {
                this.p[0].getPos(timePoints[i4], this.s);
                this.l.a(timePoints[i4], this.r, this.s, fArr, i3);
                i3 += 2;
            }
            return i3 / 2;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public KeyPositionBase a(int i, int i2, float f, float f2) {
        RectF rectF = new RectF();
        rectF.left = this.l.f;
        rectF.top = this.l.g;
        rectF.right = rectF.left + this.l.h;
        rectF.bottom = rectF.top + this.l.i;
        RectF rectF2 = new RectF();
        rectF2.left = this.m.f;
        rectF2.top = this.m.g;
        rectF2.right = rectF2.left + this.m.h;
        rectF2.bottom = rectF2.top + this.m.i;
        Iterator<Key> it = this.A.iterator();
        while (it.hasNext()) {
            Key next = it.next();
            if (next instanceof KeyPositionBase) {
                KeyPositionBase keyPositionBase = (KeyPositionBase) next;
                if (keyPositionBase.intersects(i, i2, rectF, rectF2, f, f2)) {
                    return keyPositionBase;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MotionPaths a(int i) {
        return this.y.get(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f, float f2, float f3, float[] fArr) {
        double[] dArr;
        float a2 = a(f, this.z);
        CurveFit[] curveFitArr = this.p;
        int i = 0;
        if (curveFitArr == null) {
            float f4 = this.m.f - this.l.f;
            float f5 = this.m.g - this.l.g;
            float f6 = this.m.h;
            float f7 = this.l.h;
            float f8 = this.m.i;
            float f9 = this.l.i;
            fArr[0] = (f4 * (1.0f - f2)) + (((f6 - f7) + f4) * f2);
            fArr[1] = (f5 * (1.0f - f3)) + (((f8 - f9) + f5) * f3);
            return;
        }
        CurveFit curveFit = curveFitArr[0];
        double d = a2;
        curveFit.getSlope(d, this.t);
        this.p[0].getPos(d, this.s);
        float f10 = this.z[0];
        while (true) {
            dArr = this.t;
            if (i >= dArr.length) {
                break;
            }
            dArr[i] = dArr[i] * f10;
            i++;
        }
        CurveFit curveFit2 = this.q;
        if (curveFit2 == null) {
            this.l.a(f2, f3, fArr, this.r, dArr, this.s);
            return;
        }
        double[] dArr2 = this.s;
        if (dArr2.length > 0) {
            curveFit2.getPos(d, dArr2);
            this.q.getSlope(d, this.t);
            this.l.a(f2, f3, fArr, this.r, this.t, this.s);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f, int i, int i2, float f2, float f3, float[] fArr) {
        float a2 = a(f, this.z);
        HashMap<String, ViewSpline> hashMap = this.C;
        ViewOscillator viewOscillator = null;
        ViewSpline viewSpline = hashMap == null ? null : hashMap.get("translationX");
        HashMap<String, ViewSpline> hashMap2 = this.C;
        ViewSpline viewSpline2 = hashMap2 == null ? null : hashMap2.get("translationY");
        HashMap<String, ViewSpline> hashMap3 = this.C;
        ViewSpline viewSpline3 = hashMap3 == null ? null : hashMap3.get("rotation");
        HashMap<String, ViewSpline> hashMap4 = this.C;
        ViewSpline viewSpline4 = hashMap4 == null ? null : hashMap4.get("scaleX");
        HashMap<String, ViewSpline> hashMap5 = this.C;
        ViewSpline viewSpline5 = hashMap5 == null ? null : hashMap5.get("scaleY");
        HashMap<String, ViewOscillator> hashMap6 = this.D;
        ViewOscillator viewOscillator2 = hashMap6 == null ? null : hashMap6.get("translationX");
        HashMap<String, ViewOscillator> hashMap7 = this.D;
        ViewOscillator viewOscillator3 = hashMap7 == null ? null : hashMap7.get("translationY");
        HashMap<String, ViewOscillator> hashMap8 = this.D;
        ViewOscillator viewOscillator4 = hashMap8 == null ? null : hashMap8.get("rotation");
        HashMap<String, ViewOscillator> hashMap9 = this.D;
        ViewOscillator viewOscillator5 = hashMap9 == null ? null : hashMap9.get("scaleX");
        HashMap<String, ViewOscillator> hashMap10 = this.D;
        if (hashMap10 != null) {
            viewOscillator = hashMap10.get("scaleY");
        }
        VelocityMatrix velocityMatrix = new VelocityMatrix();
        velocityMatrix.clear();
        velocityMatrix.setRotationVelocity(viewSpline3, a2);
        velocityMatrix.setTranslationVelocity(viewSpline, viewSpline2, a2);
        velocityMatrix.setScaleVelocity(viewSpline4, viewSpline5, a2);
        velocityMatrix.setRotationVelocity(viewOscillator4, a2);
        velocityMatrix.setTranslationVelocity(viewOscillator2, viewOscillator3, a2);
        velocityMatrix.setScaleVelocity(viewOscillator5, viewOscillator, a2);
        CurveFit curveFit = this.q;
        if (curveFit != null) {
            double[] dArr = this.s;
            if (dArr.length > 0) {
                double d = a2;
                curveFit.getPos(d, dArr);
                this.q.getSlope(d, this.t);
                this.l.a(f2, f3, fArr, this.r, this.t, this.s);
            }
            velocityMatrix.applyTransform(f2, f3, i, i2, fArr);
            return;
        }
        int i3 = 0;
        if (this.p == null) {
            float f4 = this.m.f - this.l.f;
            float f5 = this.m.g - this.l.g;
            float f6 = this.m.h;
            float f7 = this.l.h;
            float f8 = this.m.i;
            float f9 = this.l.i;
            fArr[0] = (f4 * (1.0f - f2)) + (((f6 - f7) + f4) * f2);
            fArr[1] = (f5 * (1.0f - f3)) + (((f8 - f9) + f5) * f3);
            velocityMatrix.clear();
            velocityMatrix.setRotationVelocity(viewSpline3, a2);
            velocityMatrix.setTranslationVelocity(viewSpline, viewSpline2, a2);
            velocityMatrix.setScaleVelocity(viewSpline4, viewSpline5, a2);
            velocityMatrix.setRotationVelocity(viewOscillator4, a2);
            velocityMatrix.setTranslationVelocity(viewOscillator2, viewOscillator3, a2);
            velocityMatrix.setScaleVelocity(viewOscillator5, viewOscillator, a2);
            velocityMatrix.applyTransform(f2, f3, i, i2, fArr);
            return;
        }
        double a3 = a(a2, this.z);
        this.p[0].getSlope(a3, this.t);
        this.p[0].getPos(a3, this.s);
        float f10 = this.z[0];
        while (true) {
            double[] dArr2 = this.t;
            if (i3 >= dArr2.length) {
                this.l.a(f2, f3, fArr, this.r, dArr2, this.s);
                velocityMatrix.applyTransform(f2, f3, i, i2, fArr);
                return;
            }
            dArr2[i3] = dArr2[i3] * f10;
            i3++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f, float[] fArr, int i) {
        this.p[0].getPos(a(f, (float[]) null), this.s);
        this.l.a(this.r, this.s, fArr, i);
    }

    void a(Rect rect, Rect rect2, int i, int i2, int i3) {
        if (i == 1) {
            int i4 = rect.left;
            int i5 = rect.right;
            rect2.left = ((rect.top + rect.bottom) - rect.width()) / 2;
            rect2.top = i3 - (((i4 + i5) + rect.height()) / 2);
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
        } else if (i == 2) {
            int i6 = rect.left;
            int i7 = rect.right;
            rect2.left = i2 - (((rect.top + rect.bottom) + rect.width()) / 2);
            rect2.top = ((i6 + i7) - rect.height()) / 2;
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
        } else if (i == 3) {
            int i8 = rect.left + rect.right;
            int i9 = rect.top;
            int i10 = rect.bottom;
            rect2.left = ((rect.height() / 2) + rect.top) - (i8 / 2);
            rect2.top = i3 - ((i8 + rect.height()) / 2);
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
        } else if (i != 4) {
        } else {
            int i11 = rect.left;
            int i12 = rect.right;
            rect2.left = i2 - (((rect.bottom + rect.top) + rect.width()) / 2);
            rect2.top = ((i11 + i12) - rect.height()) / 2;
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Rect rect, ConstraintSet constraintSet, int i, int i2) {
        int i3 = constraintSet.mRotate;
        if (i3 != 0) {
            a(rect, this.f2179a, i3, i, i2);
        }
        this.l.d = 0.0f;
        this.l.e = 0.0f;
        b(this.l);
        this.l.a(rect.left, rect.top, rect.width(), rect.height());
        ConstraintSet.Constraint parameters = constraintSet.getParameters(this.f2180c);
        this.l.applyParameters(parameters);
        this.f = parameters.motion.mMotionStagger;
        this.n.setState(rect, constraintSet, i3, this.f2180c);
        this.G = parameters.transform.transformPivotTarget;
        this.I = parameters.motion.mQuantizeMotionSteps;
        this.J = parameters.motion.mQuantizeMotionPhase;
        this.K = a(this.b.getContext(), parameters.motion.mQuantizeInterpolatorType, parameters.motion.mQuantizeInterpolatorString, parameters.motion.mQuantizeInterpolatorID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view) {
        this.l.d = 0.0f;
        this.l.e = 0.0f;
        this.l.a(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.n.setState(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, KeyPositionBase keyPositionBase, float f, float f2, String[] strArr, float[] fArr) {
        RectF rectF = new RectF();
        rectF.left = this.l.f;
        rectF.top = this.l.g;
        rectF.right = rectF.left + this.l.h;
        rectF.bottom = rectF.top + this.l.i;
        RectF rectF2 = new RectF();
        rectF2.left = this.m.f;
        rectF2.top = this.m.g;
        rectF2.right = rectF2.left + this.m.h;
        rectF2.bottom = rectF2.top + this.m.i;
        keyPositionBase.positionAttributes(view, rectF, rectF2, f, f2, strArr, fArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ArrayList<Key> arrayList) {
        this.A.addAll(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        if (!"button".equals(Debug.getName(this.b)) || this.E == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            KeyTrigger[] keyTriggerArr = this.E;
            if (i2 >= keyTriggerArr.length) {
                return;
            }
            keyTriggerArr[i2].conditionallyFire(z ? -100.0f : 100.0f, this.b);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float[] fArr, int i) {
        float f;
        float f2;
        float f3 = 1.0f / (i - 1);
        HashMap<String, ViewSpline> hashMap = this.C;
        ViewOscillator viewOscillator = null;
        ViewSpline viewSpline = hashMap == null ? null : hashMap.get("translationX");
        HashMap<String, ViewSpline> hashMap2 = this.C;
        ViewSpline viewSpline2 = hashMap2 == null ? null : hashMap2.get("translationY");
        HashMap<String, ViewOscillator> hashMap3 = this.D;
        ViewOscillator viewOscillator2 = hashMap3 == null ? null : hashMap3.get("translationX");
        HashMap<String, ViewOscillator> hashMap4 = this.D;
        if (hashMap4 != null) {
            viewOscillator = hashMap4.get("translationY");
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            float f4 = i3 * f3;
            float f5 = f4;
            if (this.h != 1.0f) {
                float f6 = f4;
                if (f4 < this.g) {
                    f6 = 0.0f;
                }
                float f7 = this.g;
                f5 = f6;
                if (f6 > f7) {
                    f5 = f6;
                    if (f6 < 1.0d) {
                        f5 = Math.min((f6 - f7) * this.h, 1.0f);
                    }
                }
            }
            double d = f5;
            Easing easing = this.l.b;
            float f8 = Float.NaN;
            Iterator<MotionPaths> it = this.y.iterator();
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
            this.p[0].getPos(d, this.s);
            CurveFit curveFit = this.q;
            if (curveFit != null) {
                double[] dArr = this.s;
                if (dArr.length > 0) {
                    curveFit.getPos(d, dArr);
                }
            }
            int i4 = i3 * 2;
            this.l.a(d, this.r, this.s, fArr, i4);
            if (viewOscillator2 != null) {
                fArr[i4] = fArr[i4] + viewOscillator2.get(f5);
            } else if (viewSpline != null) {
                fArr[i4] = fArr[i4] + viewSpline.get(f5);
            }
            if (viewOscillator != null) {
                int i5 = i4 + 1;
                fArr[i5] = fArr[i5] + viewOscillator.get(f5);
            } else if (viewSpline2 != null) {
                int i6 = i4 + 1;
                fArr[i6] = fArr[i6] + viewSpline2.get(f5);
            }
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(View view, float f, long j, KeyCache keyCache) {
        ViewTimeCycle.PathRotate pathRotate;
        boolean z;
        boolean z2;
        View view2;
        float a2 = a(f, (float[]) null);
        float f2 = a2;
        if (this.I != Key.UNSET) {
            float f3 = 1.0f / this.I;
            float floor = (float) Math.floor(a2 / f3);
            float f4 = (a2 % f3) / f3;
            float f5 = f4;
            if (!Float.isNaN(this.J)) {
                f5 = (f4 + this.J) % 1.0f;
            }
            Interpolator interpolator = this.K;
            f2 = ((interpolator != null ? interpolator.getInterpolation(f5) : ((double) f5) > 0.5d ? 1.0f : 0.0f) * f3) + (floor * f3);
        }
        HashMap<String, ViewSpline> hashMap = this.C;
        if (hashMap != null) {
            for (ViewSpline viewSpline : hashMap.values()) {
                viewSpline.setProperty(view, f2);
            }
        }
        HashMap<String, ViewTimeCycle> hashMap2 = this.B;
        if (hashMap2 != null) {
            pathRotate = null;
            z = false;
            for (ViewTimeCycle viewTimeCycle : hashMap2.values()) {
                if (viewTimeCycle instanceof ViewTimeCycle.PathRotate) {
                    pathRotate = (ViewTimeCycle.PathRotate) viewTimeCycle;
                } else {
                    z |= viewTimeCycle.setProperty(view, f2, j, keyCache);
                }
            }
        } else {
            pathRotate = null;
            z = false;
        }
        CurveFit[] curveFitArr = this.p;
        if (curveFitArr != null) {
            CurveFit curveFit = curveFitArr[0];
            double d = f2;
            curveFit.getPos(d, this.s);
            this.p[0].getSlope(d, this.t);
            CurveFit curveFit2 = this.q;
            if (curveFit2 != null) {
                double[] dArr = this.s;
                if (dArr.length > 0) {
                    curveFit2.getPos(d, dArr);
                    this.q.getSlope(d, this.t);
                }
            }
            if (!this.L) {
                this.l.a(f2, view, this.r, this.s, this.t, null, this.d);
                this.d = false;
            }
            if (this.G != Key.UNSET) {
                if (this.H == null) {
                    this.H = ((View) view.getParent()).findViewById(this.G);
                }
                if (this.H != null) {
                    float top = (view2.getTop() + this.H.getBottom()) / 2.0f;
                    float left = (this.H.getLeft() + this.H.getRight()) / 2.0f;
                    if (view.getRight() - view.getLeft() > 0 && view.getBottom() - view.getTop() > 0) {
                        view.setPivotX(left - view.getLeft());
                        view.setPivotY(top - view.getTop());
                    }
                }
            }
            HashMap<String, ViewSpline> hashMap3 = this.C;
            if (hashMap3 != null) {
                for (ViewSpline viewSpline2 : hashMap3.values()) {
                    if (viewSpline2 instanceof ViewSpline.PathRotate) {
                        double[] dArr2 = this.t;
                        if (dArr2.length > 1) {
                            ((ViewSpline.PathRotate) viewSpline2).setPathRotate(view, f2, dArr2[0], dArr2[1]);
                        }
                    }
                }
            }
            if (pathRotate != null) {
                double[] dArr3 = this.t;
                z |= pathRotate.setPathRotate(view, keyCache, f2, j, dArr3[0], dArr3[1]);
            }
            int i = 1;
            while (true) {
                int i2 = i;
                CurveFit[] curveFitArr2 = this.p;
                if (i2 >= curveFitArr2.length) {
                    break;
                }
                curveFitArr2[i2].getPos(d, this.x);
                CustomSupport.setInterpolatedValue(this.l.p.get(this.u[i2 - 1]), view, this.x);
                i = i2 + 1;
            }
            if (this.n.f2178a == 0) {
                if (f2 <= 0.0f) {
                    view.setVisibility(this.n.b);
                } else if (f2 >= 1.0f) {
                    view.setVisibility(this.o.b);
                } else if (this.o.b != this.n.b) {
                    view.setVisibility(0);
                }
            }
            z2 = z;
            if (this.E != null) {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    KeyTrigger[] keyTriggerArr = this.E;
                    z2 = z;
                    if (i4 >= keyTriggerArr.length) {
                        break;
                    }
                    keyTriggerArr[i4].conditionallyFire(f2, view);
                    i3 = i4 + 1;
                }
            }
        } else {
            float f6 = this.l.f + ((this.m.f - this.l.f) * f2) + 0.5f;
            int i5 = (int) f6;
            float f7 = this.l.g + ((this.m.g - this.l.g) * f2) + 0.5f;
            int i6 = (int) f7;
            int i7 = (int) (f6 + this.l.h + ((this.m.h - this.l.h) * f2));
            int i8 = (int) (f7 + this.l.i + ((this.m.i - this.l.i) * f2));
            if (this.m.h != this.l.h || this.m.i != this.l.i || this.d) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i7 - i5, 1073741824), View.MeasureSpec.makeMeasureSpec(i8 - i6, 1073741824));
                this.d = false;
            }
            view.layout(i5, i6, i7, i8);
            z2 = z;
        }
        HashMap<String, ViewOscillator> hashMap4 = this.D;
        if (hashMap4 != null) {
            for (ViewOscillator viewOscillator : hashMap4.values()) {
                if (viewOscillator instanceof ViewOscillator.PathRotateSet) {
                    ViewOscillator.PathRotateSet pathRotateSet = (ViewOscillator.PathRotateSet) viewOscillator;
                    double[] dArr4 = this.t;
                    pathRotateSet.setPathRotate(view, f2, dArr4[0], dArr4[1]);
                } else {
                    viewOscillator.setProperty(view, f2);
                }
            }
        }
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double[] a(double d) {
        this.p[0].getPos(d, this.s);
        CurveFit curveFit = this.q;
        if (curveFit != null) {
            double[] dArr = this.s;
            if (dArr.length > 0) {
                curveFit.getPos(d, dArr);
            }
        }
        return this.s;
    }

    public void addKey(Key key) {
        this.A.add(key);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Rect rect, ConstraintSet constraintSet, int i, int i2) {
        int i3 = constraintSet.mRotate;
        Rect rect2 = rect;
        if (i3 != 0) {
            a(rect, this.f2179a, i3, i, i2);
            rect2 = this.f2179a;
        }
        this.m.d = 1.0f;
        this.m.e = 1.0f;
        b(this.m);
        this.m.a(rect2.left, rect2.top, rect2.width(), rect2.height());
        this.m.applyParameters(constraintSet.getParameters(this.f2180c));
        this.o.setState(rect2, constraintSet, i3, this.f2180c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(View view) {
        this.l.d = 0.0f;
        this.l.e = 0.0f;
        this.L = true;
        this.l.a(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.m.a(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.n.setState(view);
        this.o.setState(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(float[] fArr, int i) {
        float f = 1.0f / (i - 1);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            this.p[0].getPos(a(i3 * f, (float[]) null), this.s);
            this.l.a(this.r, this.s, fArr, i3 * 8);
            i2 = i3 + 1;
        }
    }

    public int getAnimateRelativeTo() {
        return this.l.m;
    }

    public void getCenter(double d, float[] fArr, float[] fArr2) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.p[0].getPos(d, dArr);
        this.p[0].getSlope(d, dArr2);
        Arrays.fill(fArr2, 0.0f);
        this.l.a(d, this.r, dArr, fArr, dArr2, fArr2);
    }

    public float getCenterX() {
        return this.i;
    }

    public float getCenterY() {
        return this.j;
    }

    public int getDrawPath() {
        int i = this.l.f2203c;
        Iterator<MotionPaths> it = this.y.iterator();
        while (it.hasNext()) {
            i = Math.max(i, it.next().f2203c);
        }
        return Math.max(i, this.m.f2203c);
    }

    public float getFinalHeight() {
        return this.m.i;
    }

    public float getFinalWidth() {
        return this.m.h;
    }

    public float getFinalX() {
        return this.m.f;
    }

    public float getFinalY() {
        return this.m.g;
    }

    public int getKeyFrameInfo(int i, int[] iArr) {
        float[] fArr = new float[2];
        Iterator<Key> it = this.A.iterator();
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            Key next = it.next();
            if (next.d == i || i != -1) {
                iArr[i3] = 0;
                int i4 = i3 + 1;
                iArr[i4] = next.d;
                int i5 = i4 + 1;
                iArr[i5] = next.f2169a;
                double d = next.f2169a / 100.0f;
                this.p[0].getPos(d, this.s);
                this.l.a(d, this.r, this.s, fArr, 0);
                int i6 = i5 + 1;
                iArr[i6] = Float.floatToIntBits(fArr[0]);
                int i7 = i6 + 1;
                iArr[i7] = Float.floatToIntBits(fArr[1]);
                int i8 = i7;
                if (next instanceof KeyPosition) {
                    KeyPosition keyPosition = (KeyPosition) next;
                    int i9 = i7 + 1;
                    iArr[i9] = keyPosition.o;
                    int i10 = i9 + 1;
                    iArr[i10] = Float.floatToIntBits(keyPosition.k);
                    i8 = i10 + 1;
                    iArr[i8] = Float.floatToIntBits(keyPosition.l);
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
        Iterator<Key> it = this.A.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            Key next = it.next();
            iArr[i] = next.f2169a + (next.d * 1000);
            double d = next.f2169a / 100.0f;
            this.p[0].getPos(d, this.s);
            this.l.a(d, this.r, this.s, fArr, i2);
            i2 += 2;
            i++;
        }
        return i;
    }

    public float getStartHeight() {
        return this.l.i;
    }

    public float getStartWidth() {
        return this.l.h;
    }

    public float getStartX() {
        return this.l.f;
    }

    public float getStartY() {
        return this.l.g;
    }

    public int getTransformPivotTarget() {
        return this.G;
    }

    public View getView() {
        return this.b;
    }

    public void remeasure() {
        this.d = true;
    }

    public void setDrawPath(int i) {
        this.l.f2203c = i;
    }

    public void setPathMotionArc(int i) {
        this.F = i;
    }

    public void setStartState(ViewState viewState, View view, int i, int i2, int i3) {
        this.l.d = 0.0f;
        this.l.e = 0.0f;
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
        this.l.a(rect.left, rect.top, rect.width(), rect.height());
        this.n.setState(rect, view, i, viewState.rotation);
    }

    public void setTransformPivotTarget(int i) {
        this.G = i;
        this.H = null;
    }

    public void setView(View view) {
        this.b = view;
        this.f2180c = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            this.e = ((ConstraintLayout.LayoutParams) layoutParams).getConstraintTag();
        }
    }

    public void setup(int i, int i2, float f, long j) {
        ArrayList arrayList;
        int i3;
        double[][] dArr;
        ConstraintAttribute constraintAttribute;
        ViewTimeCycle makeSpline;
        ConstraintAttribute constraintAttribute2;
        Integer num;
        ViewSpline makeSpline2;
        ConstraintAttribute constraintAttribute3;
        new HashSet();
        HashSet<String> hashSet = new HashSet<>();
        HashSet<String> hashSet2 = new HashSet<>();
        HashSet<String> hashSet3 = new HashSet<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        if (this.F != Key.UNSET) {
            this.l.l = this.F;
        }
        this.n.a(this.o, hashSet2);
        ArrayList<Key> arrayList2 = this.A;
        if (arrayList2 != null) {
            Iterator<Key> it = arrayList2.iterator();
            ArrayList arrayList3 = null;
            while (true) {
                arrayList = arrayList3;
                if (!it.hasNext()) {
                    break;
                }
                Key next = it.next();
                if (next instanceof KeyPosition) {
                    KeyPosition keyPosition = (KeyPosition) next;
                    a(new MotionPaths(i, i2, keyPosition, this.l, this.m));
                    if (keyPosition.p != Key.UNSET) {
                        this.k = keyPosition.p;
                    }
                } else if (next instanceof KeyCycle) {
                    next.getAttributeNames(hashSet3);
                } else if (next instanceof KeyTimeCycle) {
                    next.getAttributeNames(hashSet);
                } else if (next instanceof KeyTrigger) {
                    ArrayList arrayList4 = arrayList3;
                    if (arrayList3 == null) {
                        arrayList4 = new ArrayList();
                    }
                    arrayList4.add((KeyTrigger) next);
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
            this.E = (KeyTrigger[]) arrayList.toArray(new KeyTrigger[0]);
        }
        if (!hashSet2.isEmpty()) {
            this.C = new HashMap<>();
            Iterator<String> it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                String next2 = it2.next();
                if (next2.startsWith("CUSTOM,")) {
                    SparseArray sparseArray = new SparseArray();
                    String str = next2.split(",")[1];
                    Iterator<Key> it3 = this.A.iterator();
                    while (it3.hasNext()) {
                        Key next3 = it3.next();
                        if (next3.e != null && (constraintAttribute3 = next3.e.get(str)) != null) {
                            sparseArray.append(next3.f2169a, constraintAttribute3);
                        }
                    }
                    makeSpline2 = ViewSpline.makeCustomSpline(next2, sparseArray);
                } else {
                    makeSpline2 = ViewSpline.makeSpline(next2);
                }
                if (makeSpline2 != null) {
                    makeSpline2.setType(next2);
                    this.C.put(next2, makeSpline2);
                }
            }
            ArrayList<Key> arrayList5 = this.A;
            if (arrayList5 != null) {
                Iterator<Key> it4 = arrayList5.iterator();
                while (it4.hasNext()) {
                    Key next4 = it4.next();
                    if (next4 instanceof KeyAttributes) {
                        next4.addValues(this.C);
                    }
                }
            }
            this.n.addValues(this.C, 0);
            this.o.addValues(this.C, 100);
            for (String str2 : this.C.keySet()) {
                int intValue = (!hashMap.containsKey(str2) || (num = hashMap.get(str2)) == null) ? 0 : num.intValue();
                ViewSpline viewSpline = this.C.get(str2);
                if (viewSpline != null) {
                    viewSpline.setup(intValue);
                }
            }
        }
        if (!hashSet.isEmpty()) {
            if (this.B == null) {
                this.B = new HashMap<>();
            }
            Iterator<String> it5 = hashSet.iterator();
            while (it5.hasNext()) {
                String next5 = it5.next();
                if (!this.B.containsKey(next5)) {
                    if (next5.startsWith("CUSTOM,")) {
                        SparseArray sparseArray2 = new SparseArray();
                        String str3 = next5.split(",")[1];
                        Iterator<Key> it6 = this.A.iterator();
                        while (it6.hasNext()) {
                            Key next6 = it6.next();
                            if (next6.e != null && (constraintAttribute2 = next6.e.get(str3)) != null) {
                                sparseArray2.append(next6.f2169a, constraintAttribute2);
                            }
                        }
                        makeSpline = ViewTimeCycle.makeCustomSpline(next5, sparseArray2);
                    } else {
                        makeSpline = ViewTimeCycle.makeSpline(next5, j);
                    }
                    if (makeSpline != null) {
                        makeSpline.setType(next5);
                        this.B.put(next5, makeSpline);
                    }
                }
            }
            ArrayList<Key> arrayList6 = this.A;
            if (arrayList6 != null) {
                Iterator<Key> it7 = arrayList6.iterator();
                while (it7.hasNext()) {
                    Key next7 = it7.next();
                    if (next7 instanceof KeyTimeCycle) {
                        ((KeyTimeCycle) next7).addTimeValues(this.B);
                    }
                }
            }
            for (String str4 : this.B.keySet()) {
                this.B.get(str4).setup(hashMap.containsKey(str4) ? hashMap.get(str4).intValue() : 0);
            }
        }
        int size = this.y.size() + 2;
        MotionPaths[] motionPathsArr = new MotionPaths[size];
        motionPathsArr[0] = this.l;
        motionPathsArr[size - 1] = this.m;
        if (this.y.size() > 0 && this.k == -1) {
            this.k = 0;
        }
        Iterator<MotionPaths> it8 = this.y.iterator();
        int i4 = 1;
        while (true) {
            int i5 = i4;
            if (!it8.hasNext()) {
                break;
            }
            motionPathsArr[i5] = it8.next();
            i4 = i5 + 1;
        }
        HashSet hashSet4 = new HashSet();
        for (String str5 : this.m.p.keySet()) {
            if (this.l.p.containsKey(str5)) {
                if (!hashSet2.contains("CUSTOM," + str5)) {
                    hashSet4.add(str5);
                }
            }
        }
        String[] strArr = (String[]) hashSet4.toArray(new String[0]);
        this.u = strArr;
        this.v = new int[strArr.length];
        int i6 = 0;
        while (true) {
            int i7 = i6;
            String[] strArr2 = this.u;
            if (i7 >= strArr2.length) {
                break;
            }
            String str6 = strArr2[i7];
            this.v[i7] = 0;
            int i8 = 0;
            while (true) {
                int i9 = i8;
                if (i9 >= size) {
                    break;
                }
                if (motionPathsArr[i9].p.containsKey(str6) && (constraintAttribute = motionPathsArr[i9].p.get(str6)) != null) {
                    int[] iArr = this.v;
                    iArr[i7] = iArr[i7] + constraintAttribute.numberOfInterpolatedValues();
                    break;
                }
                i8 = i9 + 1;
            }
            i6 = i7 + 1;
        }
        boolean z = motionPathsArr[0].l != Key.UNSET;
        int length = 18 + this.u.length;
        boolean[] zArr = new boolean[length];
        int i10 = 1;
        while (true) {
            int i11 = i10;
            if (i11 >= size) {
                break;
            }
            motionPathsArr[i11].a(motionPathsArr[i11 - 1], zArr, this.u, z);
            i10 = i11 + 1;
        }
        int i12 = 1;
        int i13 = 0;
        while (true) {
            i3 = i13;
            if (i12 >= length) {
                break;
            }
            int i14 = i3;
            if (zArr[i12]) {
                i14 = i3 + 1;
            }
            i12++;
            i13 = i14;
        }
        this.r = new int[i3];
        int max = Math.max(2, i3);
        this.s = new double[max];
        this.t = new double[max];
        int i15 = 1;
        int i16 = 0;
        while (true) {
            int i17 = i16;
            if (i15 >= length) {
                break;
            }
            int i18 = i17;
            if (zArr[i15]) {
                this.r[i17] = i15;
                i18 = i17 + 1;
            }
            i15++;
            i16 = i18;
        }
        double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, size, this.r.length);
        double[] dArr3 = new double[size];
        int i19 = 0;
        while (true) {
            int i20 = i19;
            if (i20 >= size) {
                break;
            }
            motionPathsArr[i20].a(dArr2[i20], this.r);
            dArr3[i20] = motionPathsArr[i20].d;
            i19 = i20 + 1;
        }
        int i21 = 0;
        while (true) {
            int i22 = i21;
            int[] iArr2 = this.r;
            if (i22 >= iArr2.length) {
                break;
            }
            if (iArr2[i22] < MotionPaths.f2202a.length) {
                String str7 = MotionPaths.f2202a[this.r[i22]] + " [";
                int i23 = 0;
                while (true) {
                    int i24 = i23;
                    if (i24 < size) {
                        str7 = str7 + dArr2[i24][i22];
                        i23 = i24 + 1;
                    }
                }
            }
            i21 = i22 + 1;
        }
        this.p = new CurveFit[this.u.length + 1];
        int i25 = 0;
        while (true) {
            String[] strArr3 = this.u;
            if (i25 >= strArr3.length) {
                break;
            }
            String str8 = strArr3[i25];
            int i26 = 0;
            double[] dArr4 = null;
            int i27 = 0;
            double[][] dArr5 = null;
            while (true) {
                dArr = dArr5;
                if (i26 < size) {
                    double[] dArr6 = dArr4;
                    int i28 = i27;
                    double[][] dArr7 = dArr;
                    if (motionPathsArr[i26].a(str8)) {
                        dArr7 = dArr;
                        if (dArr == null) {
                            dArr4 = new double[size];
                            dArr7 = (double[][]) Array.newInstance(Double.TYPE, size, motionPathsArr[i26].b(str8));
                        }
                        dArr4[i27] = motionPathsArr[i26].d;
                        motionPathsArr[i26].a(str8, dArr7[i27], 0);
                        i28 = i27 + 1;
                        dArr6 = dArr4;
                    }
                    i26++;
                    dArr4 = dArr6;
                    i27 = i28;
                    dArr5 = dArr7;
                }
            }
            i25++;
            this.p[i25] = CurveFit.get(this.k, Arrays.copyOf(dArr4, i27), (double[][]) Arrays.copyOf(dArr, i27));
        }
        this.p[0] = CurveFit.get(this.k, dArr3, dArr2);
        if (motionPathsArr[0].l != Key.UNSET) {
            int[] iArr3 = new int[size];
            double[] dArr8 = new double[size];
            double[][] dArr9 = (double[][]) Array.newInstance(Double.TYPE, size, 2);
            int i29 = 0;
            while (true) {
                int i30 = i29;
                if (i30 >= size) {
                    break;
                }
                iArr3[i30] = motionPathsArr[i30].l;
                dArr8[i30] = motionPathsArr[i30].d;
                dArr9[i30][0] = motionPathsArr[i30].f;
                dArr9[i30][1] = motionPathsArr[i30].g;
                i29 = i30 + 1;
            }
            this.q = CurveFit.getArc(iArr3, dArr8, dArr9);
        }
        float f2 = Float.NaN;
        this.D = new HashMap<>();
        if (this.A != null) {
            Iterator<String> it9 = hashSet3.iterator();
            while (it9.hasNext()) {
                String next8 = it9.next();
                ViewOscillator makeSpline3 = ViewOscillator.makeSpline(next8);
                if (makeSpline3 != null) {
                    float f3 = f2;
                    if (makeSpline3.variesByPath()) {
                        f3 = f2;
                        if (Float.isNaN(f2)) {
                            f3 = a();
                        }
                    }
                    makeSpline3.setType(next8);
                    this.D.put(next8, makeSpline3);
                    f2 = f3;
                }
            }
            Iterator<Key> it10 = this.A.iterator();
            while (it10.hasNext()) {
                Key next9 = it10.next();
                if (next9 instanceof KeyCycle) {
                    ((KeyCycle) next9).addCycleValues(this.D);
                }
            }
            for (ViewOscillator viewOscillator : this.D.values()) {
                viewOscillator.setup(f2);
            }
        }
    }

    public void setupRelative(MotionController motionController) {
        this.l.setupRelative(motionController, motionController.l);
        this.m.setupRelative(motionController, motionController.m);
    }

    public String toString() {
        return " start: x: " + this.l.f + " y: " + this.l.g + " end: x: " + this.m.f + " y: " + this.m.g;
    }
}
