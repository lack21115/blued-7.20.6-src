package androidx.constraintlayout.core.motion;

import android.provider.BrowserContract;
import androidx.constraintlayout.core.motion.utils.Rect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.Utils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/MotionConstrainedPoint.class */
class MotionConstrainedPoint implements Comparable<MotionConstrainedPoint> {
    public static final boolean DEBUG = false;
    public static final String TAG = "MotionPaths";

    /* renamed from: c  reason: collision with root package name */
    static String[] f2011c = {BrowserContract.Bookmarks.POSITION, "x", "y", "width", "height", "pathRotate"};
    int b;
    private float u;
    private float v;
    private float w;
    private float x;
    private float y;
    private float h = 1.0f;

    /* renamed from: a  reason: collision with root package name */
    int f2012a = 0;
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
    private int t = 0;
    private float z = Float.NaN;
    private float A = Float.NaN;
    private int B = -1;
    LinkedHashMap<String, CustomVariable> d = new LinkedHashMap<>();
    int e = 0;
    double[] f = new double[18];
    double[] g = new double[18];

    private boolean a(float f, float f2) {
        return (Float.isNaN(f) || Float.isNaN(f2)) ? Float.isNaN(f) != Float.isNaN(f2) : Math.abs(f - f2) > 1.0E-6f;
    }

    void a(float f, float f2, float f3, float f4) {
        this.v = f;
        this.w = f2;
        this.x = f3;
        this.y = f4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(MotionConstrainedPoint motionConstrainedPoint, HashSet<String> hashSet) {
        if (a(this.h, motionConstrainedPoint.h)) {
            hashSet.add("alpha");
        }
        if (a(this.j, motionConstrainedPoint.j)) {
            hashSet.add("translationZ");
        }
        int i = this.b;
        int i2 = motionConstrainedPoint.b;
        if (i != i2 && this.f2012a == 0 && (i == 4 || i2 == 4)) {
            hashSet.add("alpha");
        }
        if (a(this.k, motionConstrainedPoint.k)) {
            hashSet.add("rotationZ");
        }
        if (!Float.isNaN(this.z) || !Float.isNaN(motionConstrainedPoint.z)) {
            hashSet.add("pathRotate");
        }
        if (!Float.isNaN(this.A) || !Float.isNaN(motionConstrainedPoint.A)) {
            hashSet.add("progress");
        }
        if (a(this.l, motionConstrainedPoint.l)) {
            hashSet.add("rotationX");
        }
        if (a(this.rotationY, motionConstrainedPoint.rotationY)) {
            hashSet.add("rotationY");
        }
        if (a(this.o, motionConstrainedPoint.o)) {
            hashSet.add("pivotX");
        }
        if (a(this.p, motionConstrainedPoint.p)) {
            hashSet.add("pivotY");
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
        if (a(this.j, motionConstrainedPoint.j)) {
            hashSet.add("elevation");
        }
    }

    public void addValues(HashMap<String, SplineSet> hashMap, int i) {
        for (String str : hashMap.keySet()) {
            SplineSet splineSet = hashMap.get(str);
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
                case -1249320804:
                    if (str.equals("rotationZ")) {
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
                case -987906986:
                    if (str.equals("pivotX")) {
                        z = true;
                        break;
                    }
                    break;
                case -987906985:
                    if (str.equals("pivotY")) {
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
                case 92909918:
                    if (str.equals("alpha")) {
                        z = false;
                        break;
                    }
                    break;
                case 803192288:
                    if (str.equals("pathRotate")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    splineSet.setPoint(i, Float.isNaN(this.h) ? 1.0f : this.h);
                    break;
                case true:
                    splineSet.setPoint(i, Float.isNaN(this.k) ? 0.0f : this.k);
                    break;
                case true:
                    splineSet.setPoint(i, Float.isNaN(this.l) ? 0.0f : this.l);
                    break;
                case true:
                    splineSet.setPoint(i, Float.isNaN(this.rotationY) ? 0.0f : this.rotationY);
                    break;
                case true:
                    splineSet.setPoint(i, Float.isNaN(this.o) ? 0.0f : this.o);
                    break;
                case true:
                    splineSet.setPoint(i, Float.isNaN(this.p) ? 0.0f : this.p);
                    break;
                case true:
                    splineSet.setPoint(i, Float.isNaN(this.z) ? 0.0f : this.z);
                    break;
                case true:
                    splineSet.setPoint(i, Float.isNaN(this.A) ? 0.0f : this.A);
                    break;
                case true:
                    splineSet.setPoint(i, Float.isNaN(this.m) ? 1.0f : this.m);
                    break;
                case true:
                    splineSet.setPoint(i, Float.isNaN(this.n) ? 1.0f : this.n);
                    break;
                case true:
                    splineSet.setPoint(i, Float.isNaN(this.q) ? 0.0f : this.q);
                    break;
                case true:
                    splineSet.setPoint(i, Float.isNaN(this.r) ? 0.0f : this.r);
                    break;
                case true:
                    splineSet.setPoint(i, Float.isNaN(this.s) ? 0.0f : this.s);
                    break;
                default:
                    if (str.startsWith("CUSTOM")) {
                        String str2 = str.split(",")[1];
                        if (this.d.containsKey(str2)) {
                            CustomVariable customVariable = this.d.get(str2);
                            if (splineSet instanceof SplineSet.CustomSpline) {
                                ((SplineSet.CustomSpline) splineSet).setPoint(i, customVariable);
                                break;
                            } else {
                                Utils.loge("MotionPaths", str + " ViewSpline not a CustomSet frame = " + i + ", value" + customVariable.getValueToInterpolate() + splineSet);
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        Utils.loge("MotionPaths", "UNKNOWN spline " + str);
                        break;
                    }
            }
        }
    }

    public void applyParameters(MotionWidget motionWidget) {
        this.b = motionWidget.getVisibility();
        this.h = motionWidget.getVisibility() != 4 ? 0.0f : motionWidget.getAlpha();
        this.i = false;
        this.k = motionWidget.getRotationZ();
        this.l = motionWidget.getRotationX();
        this.rotationY = motionWidget.getRotationY();
        this.m = motionWidget.getScaleX();
        this.n = motionWidget.getScaleY();
        this.o = motionWidget.getPivotX();
        this.p = motionWidget.getPivotY();
        this.q = motionWidget.getTranslationX();
        this.r = motionWidget.getTranslationY();
        this.s = motionWidget.getTranslationZ();
        for (String str : motionWidget.getCustomAttributeNames()) {
            CustomVariable customAttribute = motionWidget.getCustomAttribute(str);
            if (customAttribute != null && customAttribute.isContinuous()) {
                this.d.put(str, customAttribute);
            }
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(MotionConstrainedPoint motionConstrainedPoint) {
        return Float.compare(this.u, motionConstrainedPoint.u);
    }

    public void setState(MotionWidget motionWidget) {
        a(motionWidget.getX(), motionWidget.getY(), motionWidget.getWidth(), motionWidget.getHeight());
        applyParameters(motionWidget);
    }

    public void setState(Rect rect, MotionWidget motionWidget, int i, float f) {
        a(rect.left, rect.top, rect.width(), rect.height());
        applyParameters(motionWidget);
        this.o = Float.NaN;
        this.p = Float.NaN;
        if (i == 1) {
            this.k = f - 90.0f;
        } else if (i != 2) {
        } else {
            this.k = f + 90.0f;
        }
    }
}
