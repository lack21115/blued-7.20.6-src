package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.os.Build;
import android.provider.BrowserContract;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/widget/MotionConstrainedPoint.class */
public class MotionConstrainedPoint implements Comparable<MotionConstrainedPoint> {
    public static final boolean DEBUG = false;
    public static final String TAG = "MotionPaths";

    /* renamed from: c  reason: collision with root package name */
    static String[] f2177c = {BrowserContract.Bookmarks.POSITION, "x", "y", "width", "height", "pathRotate"};
    int b;
    private Easing t;
    private float v;
    private float w;
    private float x;
    private float y;
    private float z;
    private float h = 1.0f;

    /* renamed from: a  reason: collision with root package name */
    int f2178a = 0;
    private boolean i = false;
    private float j = 0.0f;
    private float k = 0.0f;
    private float l = 0.0f;
    public float rotationY = 0.0f;
    private float m = 1.0f;
    private float n = 1.0f;
    private float o = Float.NaN;
    private float p = Float.NaN;
    private float q = 0.0f;
    private float r = 0.0f;
    private float s = 0.0f;
    private int u = 0;
    private float A = Float.NaN;
    private float B = Float.NaN;
    private int C = -1;
    LinkedHashMap<String, ConstraintAttribute> d = new LinkedHashMap<>();
    int e = 0;
    double[] f = new double[18];
    double[] g = new double[18];

    private boolean a(float f, float f2) {
        return (Float.isNaN(f) || Float.isNaN(f2)) ? Float.isNaN(f) != Float.isNaN(f2) : Math.abs(f - f2) > 1.0E-6f;
    }

    void a(float f, float f2, float f3, float f4) {
        this.w = f;
        this.x = f2;
        this.y = f3;
        this.z = f4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(MotionConstrainedPoint motionConstrainedPoint, HashSet<String> hashSet) {
        if (a(this.h, motionConstrainedPoint.h)) {
            hashSet.add("alpha");
        }
        if (a(this.j, motionConstrainedPoint.j)) {
            hashSet.add("elevation");
        }
        int i = this.b;
        int i2 = motionConstrainedPoint.b;
        if (i != i2 && this.f2178a == 0 && (i == 0 || i2 == 0)) {
            hashSet.add("alpha");
        }
        if (a(this.k, motionConstrainedPoint.k)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.A) || !Float.isNaN(motionConstrainedPoint.A)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.B) || !Float.isNaN(motionConstrainedPoint.B)) {
            hashSet.add("progress");
        }
        if (a(this.l, motionConstrainedPoint.l)) {
            hashSet.add("rotationX");
        }
        if (a(this.rotationY, motionConstrainedPoint.rotationY)) {
            hashSet.add("rotationY");
        }
        if (a(this.o, motionConstrainedPoint.o)) {
            hashSet.add(Key.PIVOT_X);
        }
        if (a(this.p, motionConstrainedPoint.p)) {
            hashSet.add(Key.PIVOT_Y);
        }
        if (a(this.m, motionConstrainedPoint.m)) {
            hashSet.add("scaleX");
        }
        if (a(this.n, motionConstrainedPoint.n)) {
            hashSet.add("scaleY");
        }
        if (a(this.q, motionConstrainedPoint.q)) {
            hashSet.add("translationX");
        }
        if (a(this.r, motionConstrainedPoint.r)) {
            hashSet.add("translationY");
        }
        if (a(this.s, motionConstrainedPoint.s)) {
            hashSet.add("translationZ");
        }
    }

    public void addValues(HashMap<String, ViewSpline> hashMap, int i) {
        for (String str : hashMap.keySet()) {
            ViewSpline viewSpline = hashMap.get(str);
            boolean z = true;
            switch (str.hashCode()) {
                case -1249320806:
                    if (str.equals("rotationX")) {
                        z = true;
                        break;
                    }
                    break;
                case -1249320805:
                    if (str.equals("rotationY")) {
                        z = true;
                        break;
                    }
                    break;
                case -1225497657:
                    if (str.equals("translationX")) {
                        z = true;
                        break;
                    }
                    break;
                case -1225497656:
                    if (str.equals("translationY")) {
                        z = true;
                        break;
                    }
                    break;
                case -1225497655:
                    if (str.equals("translationZ")) {
                        z = true;
                        break;
                    }
                    break;
                case -1001078227:
                    if (str.equals("progress")) {
                        z = true;
                        break;
                    }
                    break;
                case -908189618:
                    if (str.equals("scaleX")) {
                        z = true;
                        break;
                    }
                    break;
                case -908189617:
                    if (str.equals("scaleY")) {
                        z = true;
                        break;
                    }
                    break;
                case -760884510:
                    if (str.equals(Key.PIVOT_X)) {
                        z = true;
                        break;
                    }
                    break;
                case -760884509:
                    if (str.equals(Key.PIVOT_Y)) {
                        z = true;
                        break;
                    }
                    break;
                case -40300674:
                    if (str.equals("rotation")) {
                        z = true;
                        break;
                    }
                    break;
                case -4379043:
                    if (str.equals("elevation")) {
                        z = true;
                        break;
                    }
                    break;
                case 37232917:
                    if (str.equals("transitionPathRotate")) {
                        z = true;
                        break;
                    }
                    break;
                case 92909918:
                    if (str.equals("alpha")) {
                        z = false;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    viewSpline.setPoint(i, Float.isNaN(this.h) ? 1.0f : this.h);
                    break;
                case true:
                    viewSpline.setPoint(i, Float.isNaN(this.j) ? 0.0f : this.j);
                    break;
                case true:
                    viewSpline.setPoint(i, Float.isNaN(this.k) ? 0.0f : this.k);
                    break;
                case true:
                    viewSpline.setPoint(i, Float.isNaN(this.l) ? 0.0f : this.l);
                    break;
                case true:
                    viewSpline.setPoint(i, Float.isNaN(this.rotationY) ? 0.0f : this.rotationY);
                    break;
                case true:
                    viewSpline.setPoint(i, Float.isNaN(this.o) ? 0.0f : this.o);
                    break;
                case true:
                    viewSpline.setPoint(i, Float.isNaN(this.p) ? 0.0f : this.p);
                    break;
                case true:
                    viewSpline.setPoint(i, Float.isNaN(this.A) ? 0.0f : this.A);
                    break;
                case true:
                    viewSpline.setPoint(i, Float.isNaN(this.B) ? 0.0f : this.B);
                    break;
                case true:
                    viewSpline.setPoint(i, Float.isNaN(this.m) ? 1.0f : this.m);
                    break;
                case true:
                    viewSpline.setPoint(i, Float.isNaN(this.n) ? 1.0f : this.n);
                    break;
                case true:
                    viewSpline.setPoint(i, Float.isNaN(this.q) ? 0.0f : this.q);
                    break;
                case true:
                    viewSpline.setPoint(i, Float.isNaN(this.r) ? 0.0f : this.r);
                    break;
                case true:
                    viewSpline.setPoint(i, Float.isNaN(this.s) ? 0.0f : this.s);
                    break;
                default:
                    if (str.startsWith("CUSTOM")) {
                        String str2 = str.split(",")[1];
                        if (this.d.containsKey(str2)) {
                            ConstraintAttribute constraintAttribute = this.d.get(str2);
                            if (viewSpline instanceof ViewSpline.CustomSet) {
                                ((ViewSpline.CustomSet) viewSpline).setPoint(i, constraintAttribute);
                                break;
                            } else {
                                Log.e("MotionPaths", str + " ViewSpline not a CustomSet frame = " + i + ", value" + constraintAttribute.getValueToInterpolate() + viewSpline);
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        Log.e("MotionPaths", "UNKNOWN spline " + str);
                        break;
                    }
            }
        }
    }

    public void applyParameters(View view) {
        this.b = view.getVisibility();
        this.h = view.getVisibility() != 0 ? 0.0f : view.getAlpha();
        this.i = false;
        if (Build.VERSION.SDK_INT >= 21) {
            this.j = view.getElevation();
        }
        this.k = view.getRotation();
        this.l = view.getRotationX();
        this.rotationY = view.getRotationY();
        this.m = view.getScaleX();
        this.n = view.getScaleY();
        this.o = view.getPivotX();
        this.p = view.getPivotY();
        this.q = view.getTranslationX();
        this.r = view.getTranslationY();
        if (Build.VERSION.SDK_INT >= 21) {
            this.s = view.getTranslationZ();
        }
    }

    public void applyParameters(ConstraintSet.Constraint constraint) {
        this.f2178a = constraint.propertySet.mVisibilityMode;
        this.b = constraint.propertySet.visibility;
        this.h = (constraint.propertySet.visibility == 0 || this.f2178a != 0) ? constraint.propertySet.alpha : 0.0f;
        this.i = constraint.transform.applyElevation;
        this.j = constraint.transform.elevation;
        this.k = constraint.transform.rotation;
        this.l = constraint.transform.rotationX;
        this.rotationY = constraint.transform.rotationY;
        this.m = constraint.transform.scaleX;
        this.n = constraint.transform.scaleY;
        this.o = constraint.transform.transformPivotX;
        this.p = constraint.transform.transformPivotY;
        this.q = constraint.transform.translationX;
        this.r = constraint.transform.translationY;
        this.s = constraint.transform.translationZ;
        this.t = Easing.getInterpolator(constraint.motion.mTransitionEasing);
        this.A = constraint.motion.mPathRotate;
        this.u = constraint.motion.mDrawPath;
        this.C = constraint.motion.mAnimateRelativeTo;
        this.B = constraint.propertySet.mProgress;
        for (String str : constraint.mCustomConstraints.keySet()) {
            ConstraintAttribute constraintAttribute = constraint.mCustomConstraints.get(str);
            if (constraintAttribute.isContinuous()) {
                this.d.put(str, constraintAttribute);
            }
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(MotionConstrainedPoint motionConstrainedPoint) {
        return Float.compare(this.v, motionConstrainedPoint.v);
    }

    public void setState(Rect rect, View view, int i, float f) {
        a(rect.left, rect.top, rect.width(), rect.height());
        applyParameters(view);
        this.o = Float.NaN;
        this.p = Float.NaN;
        if (i == 1) {
            this.k = f - 90.0f;
        } else if (i != 2) {
        } else {
            this.k = f + 90.0f;
        }
    }

    public void setState(Rect rect, ConstraintSet constraintSet, int i, int i2) {
        a(rect.left, rect.top, rect.width(), rect.height());
        applyParameters(constraintSet.getParameters(i2));
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return;
                    }
                }
            }
            float f = this.k + 90.0f;
            this.k = f;
            if (f > 180.0f) {
                this.k = f - 360.0f;
                return;
            }
            return;
        }
        this.k -= 90.0f;
    }

    public void setState(View view) {
        a(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        applyParameters(view);
    }
}
