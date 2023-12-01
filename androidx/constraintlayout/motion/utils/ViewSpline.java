package androidx.constraintlayout.motion.utils;

import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/utils/ViewSpline.class */
public abstract class ViewSpline extends SplineSet {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/utils/ViewSpline$AlphaSet.class */
    public static class AlphaSet extends ViewSpline {
        AlphaSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float f) {
            view.setAlpha(get(f));
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/utils/ViewSpline$CustomSet.class */
    public static class CustomSet extends ViewSpline {
        String d;
        SparseArray<ConstraintAttribute> e;
        float[] f;

        public CustomSet(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.d = str.split(",")[1];
            this.e = sparseArray;
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setPoint(int i, float f) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public void setPoint(int i, ConstraintAttribute constraintAttribute) {
            this.e.append(i, constraintAttribute);
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float f) {
            this.f2057a.getPos(f, this.f);
            CustomSupport.setInterpolatedValue(this.e.valueAt(0), view, this.f);
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
                    this.f2057a = CurveFit.get(i, dArr, dArr2);
                    return;
                }
                dArr[i3] = this.e.keyAt(i3) * 0.01d;
                this.e.valueAt(i3).getValuesToInterpolate(this.f);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/utils/ViewSpline$ElevationSet.class */
    public static class ElevationSet extends ViewSpline {
        ElevationSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float f) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setElevation(get(f));
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/utils/ViewSpline$PathRotate.class */
    public static class PathRotate extends ViewSpline {
        public void setPathRotate(View view, float f, double d, double d2) {
            view.setRotation(get(f) + ((float) Math.toDegrees(Math.atan2(d2, d))));
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float f) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/utils/ViewSpline$PivotXset.class */
    public static class PivotXset extends ViewSpline {
        PivotXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float f) {
            view.setPivotX(get(f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/utils/ViewSpline$PivotYset.class */
    public static class PivotYset extends ViewSpline {
        PivotYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float f) {
            view.setPivotY(get(f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/utils/ViewSpline$ProgressSet.class */
    public static class ProgressSet extends ViewSpline {
        boolean d = false;

        ProgressSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float f) {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(get(f));
            } else if (this.d) {
            } else {
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException e) {
                    this.d = true;
                }
                if (method != null) {
                    try {
                        method.invoke(view, Float.valueOf(get(f)));
                    } catch (IllegalAccessException e2) {
                        Log.e("ViewSpline", "unable to setProgress", e2);
                    } catch (InvocationTargetException e3) {
                        Log.e("ViewSpline", "unable to setProgress", e3);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/utils/ViewSpline$RotationSet.class */
    public static class RotationSet extends ViewSpline {
        RotationSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float f) {
            view.setRotation(get(f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/utils/ViewSpline$RotationXset.class */
    public static class RotationXset extends ViewSpline {
        RotationXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float f) {
            view.setRotationX(get(f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/utils/ViewSpline$RotationYset.class */
    public static class RotationYset extends ViewSpline {
        RotationYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float f) {
            view.setRotationY(get(f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/utils/ViewSpline$ScaleXset.class */
    public static class ScaleXset extends ViewSpline {
        ScaleXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float f) {
            view.setScaleX(get(f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/utils/ViewSpline$ScaleYset.class */
    public static class ScaleYset extends ViewSpline {
        ScaleYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float f) {
            view.setScaleY(get(f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/utils/ViewSpline$TranslationXset.class */
    public static class TranslationXset extends ViewSpline {
        TranslationXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float f) {
            view.setTranslationX(get(f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/utils/ViewSpline$TranslationYset.class */
    public static class TranslationYset extends ViewSpline {
        TranslationYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float f) {
            view.setTranslationY(get(f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/utils/ViewSpline$TranslationZset.class */
    public static class TranslationZset extends ViewSpline {
        TranslationZset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void setProperty(View view, float f) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setTranslationZ(get(f));
            }
        }
    }

    public static ViewSpline makeCustomSpline(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new CustomSet(str, sparseArray);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static ViewSpline makeSpline(String str) {
        boolean z;
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
            case -797520672:
                if (str.equals(Key.WAVE_VARIES_BY)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -760884510:
                if (str.equals(Key.PIVOT_X)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -760884509:
                if (str.equals(Key.PIVOT_Y)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -40300674:
                if (str.equals("rotation")) {
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
            case 156108012:
                if (str.equals("waveOffset")) {
                    z = true;
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
                return new AlphaSet();
            case true:
                return new ElevationSet();
            case true:
                return new RotationSet();
            case true:
                return new RotationXset();
            case true:
                return new RotationYset();
            case true:
                return new PivotXset();
            case true:
                return new PivotYset();
            case true:
                return new PathRotate();
            case true:
                return new ScaleXset();
            case true:
                return new ScaleYset();
            case true:
                return new AlphaSet();
            case true:
                return new AlphaSet();
            case true:
                return new TranslationXset();
            case true:
                return new TranslationYset();
            case true:
                return new TranslationZset();
            case true:
                return new ProgressSet();
            default:
                return null;
        }
    }

    public abstract void setProperty(View view, float f);
}
