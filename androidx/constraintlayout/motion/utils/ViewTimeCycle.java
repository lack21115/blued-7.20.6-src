package androidx.constraintlayout.motion.utils;

import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/utils/ViewTimeCycle.class */
public abstract class ViewTimeCycle extends TimeCycleSplineSet {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/utils/ViewTimeCycle$AlphaSet.class */
    public static class AlphaSet extends ViewTimeCycle {
        AlphaSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            view.setAlpha(get(f, j, view, keyCache));
            return this.i;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/utils/ViewTimeCycle$CustomSet.class */
    public static class CustomSet extends ViewTimeCycle {
        String l;
        SparseArray<ConstraintAttribute> m;
        SparseArray<float[]> n = new SparseArray<>();
        float[] o;
        float[] p;

        public CustomSet(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.l = str.split(",")[1];
            this.m = sparseArray;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setPoint(int i, float f, float f2, int i2, float f3) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public void setPoint(int i, ConstraintAttribute constraintAttribute, float f, int i2, float f2) {
            this.m.append(i, constraintAttribute);
            this.n.append(i, new float[]{f, f2});
            this.b = Math.max(this.b, i2);
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            this.f2016a.getPos(f, this.o);
            float[] fArr = this.o;
            float f2 = fArr[fArr.length - 2];
            float f3 = fArr[fArr.length - 1];
            long j2 = this.j;
            if (Float.isNaN(this.k)) {
                this.k = keyCache.getFloatValue(view, this.l, 0);
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
            CustomSupport.setInterpolatedValue(this.m.valueAt(0), view, this.p);
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
                ConstraintAttribute valueAt = this.m.valueAt(i4);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/utils/ViewTimeCycle$ElevationSet.class */
    public static class ElevationSet extends ViewTimeCycle {
        ElevationSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setElevation(get(f, j, view, keyCache));
            }
            return this.i;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/utils/ViewTimeCycle$PathRotate.class */
    public static class PathRotate extends ViewTimeCycle {
        public boolean setPathRotate(View view, KeyCache keyCache, float f, long j, double d, double d2) {
            view.setRotation(get(f, j, view, keyCache) + ((float) Math.toDegrees(Math.atan2(d2, d))));
            return this.i;
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            return this.i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/utils/ViewTimeCycle$ProgressSet.class */
    public static class ProgressSet extends ViewTimeCycle {
        boolean l = false;

        ProgressSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(get(f, j, view, keyCache));
            } else if (this.l) {
                return false;
            } else {
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException e) {
                    this.l = true;
                }
                if (method != null) {
                    try {
                        method.invoke(view, Float.valueOf(get(f, j, view, keyCache)));
                    } catch (IllegalAccessException e2) {
                        Log.e("ViewTimeCycle", "unable to setProgress", e2);
                    } catch (InvocationTargetException e3) {
                        Log.e("ViewTimeCycle", "unable to setProgress", e3);
                    }
                }
            }
            return this.i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/utils/ViewTimeCycle$RotationSet.class */
    public static class RotationSet extends ViewTimeCycle {
        RotationSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            view.setRotation(get(f, j, view, keyCache));
            return this.i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/utils/ViewTimeCycle$RotationXset.class */
    public static class RotationXset extends ViewTimeCycle {
        RotationXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            view.setRotationX(get(f, j, view, keyCache));
            return this.i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/utils/ViewTimeCycle$RotationYset.class */
    public static class RotationYset extends ViewTimeCycle {
        RotationYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            view.setRotationY(get(f, j, view, keyCache));
            return this.i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/utils/ViewTimeCycle$ScaleXset.class */
    public static class ScaleXset extends ViewTimeCycle {
        ScaleXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            view.setScaleX(get(f, j, view, keyCache));
            return this.i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/utils/ViewTimeCycle$ScaleYset.class */
    public static class ScaleYset extends ViewTimeCycle {
        ScaleYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            view.setScaleY(get(f, j, view, keyCache));
            return this.i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/utils/ViewTimeCycle$TranslationXset.class */
    public static class TranslationXset extends ViewTimeCycle {
        TranslationXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            view.setTranslationX(get(f, j, view, keyCache));
            return this.i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/utils/ViewTimeCycle$TranslationYset.class */
    public static class TranslationYset extends ViewTimeCycle {
        TranslationYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            view.setTranslationY(get(f, j, view, keyCache));
            return this.i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/utils/ViewTimeCycle$TranslationZset.class */
    public static class TranslationZset extends ViewTimeCycle {
        TranslationZset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setTranslationZ(get(f, j, view, keyCache));
            }
            return this.i;
        }
    }

    public static ViewTimeCycle makeCustomSpline(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new CustomSet(str, sparseArray);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static ViewTimeCycle makeSpline(String str, long j) {
        boolean z;
        ViewTimeCycle alphaSet;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -40300674:
                if (str.equals(Key.ROTATION)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        switch (z) {
            case false:
                alphaSet = new AlphaSet();
                break;
            case true:
                alphaSet = new ElevationSet();
                break;
            case true:
                alphaSet = new RotationSet();
                break;
            case true:
                alphaSet = new RotationXset();
                break;
            case true:
                alphaSet = new RotationYset();
                break;
            case true:
                alphaSet = new PathRotate();
                break;
            case true:
                alphaSet = new ScaleXset();
                break;
            case true:
                alphaSet = new ScaleYset();
                break;
            case true:
                alphaSet = new TranslationXset();
                break;
            case true:
                alphaSet = new TranslationYset();
                break;
            case true:
                alphaSet = new TranslationZset();
                break;
            case true:
                alphaSet = new ProgressSet();
                break;
            default:
                return null;
        }
        alphaSet.a(j);
        return alphaSet;
    }

    public float get(float f, long j, View view, KeyCache keyCache) {
        this.f2016a.getPos(f, this.g);
        float f2 = this.g[1];
        int i = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        if (i == 0) {
            this.i = false;
            return this.g[2];
        }
        if (Float.isNaN(this.k)) {
            this.k = keyCache.getFloatValue(view, this.f, 0);
            if (Float.isNaN(this.k)) {
                this.k = 0.0f;
            }
        }
        this.k = (float) ((this.k + (((j - this.j) * 1.0E-9d) * f2)) % 1.0d);
        keyCache.setFloatValue(view, this.f, 0, this.k);
        this.j = j;
        float f3 = this.g[0];
        float a2 = a(this.k);
        float f4 = this.g[2];
        this.i = (f3 == 0.0f && i == 0) ? false : true;
        return (a2 * f3) + f4;
    }

    public abstract boolean setProperty(View view, float f, long j, KeyCache keyCache);
}
