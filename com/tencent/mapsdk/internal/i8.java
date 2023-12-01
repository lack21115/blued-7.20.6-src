package com.tencent.mapsdk.internal;

import com.tencent.tencentmap.mapsdk.maps.model.AlphaAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.Animation;
import com.tencent.tencentmap.mapsdk.maps.model.AnimationSet;
import com.tencent.tencentmap.mapsdk.maps.model.EmergeAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.IAlphaAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.RotateAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.ScaleAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.TranslateAnimation;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/i8.class */
public class i8 {
    public static <A extends Animation> j7 a(q1 q1Var, A a2) {
        IAlphaAnimation iAlphaAnimation;
        j7 j7Var = null;
        if (q1Var != null) {
            if (a2 == null) {
                return null;
            }
            if (a2 instanceof j7) {
                return (j7) a2;
            }
            Class<?> cls = a2.getClass();
            if (cls == AlphaAnimation.class) {
                AlphaAnimation alphaAnimation = (AlphaAnimation) a2;
                iAlphaAnimation = q1Var.createAlphaAnimation(alphaAnimation.mFromAlpha, alphaAnimation.mToAlpha);
            } else if (cls == ScaleAnimation.class) {
                ScaleAnimation scaleAnimation = (ScaleAnimation) a2;
                iAlphaAnimation = q1Var.createScaleAnimation(scaleAnimation.mFromX, scaleAnimation.mToX, scaleAnimation.mFromY, scaleAnimation.mToY);
            } else if (cls == EmergeAnimation.class) {
                iAlphaAnimation = q1Var.createEmergeAnimation(((EmergeAnimation) a2).mStartPoint);
            } else if (cls == AnimationSet.class) {
                AnimationSet animationSet = (AnimationSet) a2;
                iAlphaAnimation = q1Var.createAnimationSet(animationSet.mShareInterpolator);
                for (Animation animation : animationSet.mAnimations) {
                    ((k7) iAlphaAnimation).addAnimation(a(q1Var, animation));
                }
            } else if (cls == RotateAnimation.class) {
                RotateAnimation rotateAnimation = (RotateAnimation) a2;
                iAlphaAnimation = q1Var.createRotateAnimation(rotateAnimation.mFromDegree, rotateAnimation.mToDegree, rotateAnimation.mPivoteX, rotateAnimation.mPivoteY, rotateAnimation.mPivoteZ);
            } else {
                iAlphaAnimation = null;
                if (cls == TranslateAnimation.class) {
                    iAlphaAnimation = q1Var.createTranslateAnimation(((TranslateAnimation) a2).mTargetLatLng);
                }
            }
            if (iAlphaAnimation != null) {
                iAlphaAnimation.setDuration(a2.getDuration());
                iAlphaAnimation.setInterpolator(a2.getInterpolator());
                iAlphaAnimation.setAnimationListener(a2.getAnimationListener());
            }
            j7Var = iAlphaAnimation;
        }
        return j7Var;
    }

    public static double[] a(double d, double d2, int i) {
        double d3 = d + d2;
        double abs = Math.abs(d2) / 2.0d;
        double sqrt = Math.sqrt((4.0d * abs) / 3.141592653589793d);
        int i2 = i >> 1;
        int i3 = i2 << 1;
        double[] dArr = new double[i3];
        int i4 = i2 - 1;
        dArr[i4] = d + (d2 / 2.0d);
        dArr[i3 - 1] = d3;
        double d4 = sqrt / i2;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= i4) {
                return dArr;
            }
            int i7 = i6 + 1;
            double d5 = sqrt - (i7 * d4);
            double acos = Math.acos(d5 / sqrt);
            double sin = (((acos * abs) * 2.0d) / 3.141592653589793d) - ((d5 * (Math.sin(acos) * sqrt)) / 2.0d);
            double d6 = sin;
            if (d2 < 0.0d) {
                d6 = -sin;
            }
            dArr[i6] = d + d6;
            dArr[(i3 - 2) - i6] = d3 - d6;
            i5 = i7;
        }
    }

    public static double[] b(double d, double d2, int i) {
        double[] dArr = new double[i];
        double d3 = i;
        double d4 = ((d2 * 2.0d) / d3) / d3;
        double d5 = d4 / 2.0d;
        int i2 = i - 1;
        dArr[i2] = d + d2;
        dArr[0] = d + d5;
        int i3 = 1;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                return dArr;
            }
            dArr[i4] = dArr[i4 - 1] + (i4 * d4) + d5;
            i3 = i4 + 1;
        }
    }

    public static double[] c(double d, double d2, int i) {
        double d3 = d + d2;
        int i2 = i >> 1;
        int i3 = i2 << 1;
        double[] dArr = new double[i3];
        int i4 = i2 - 1;
        dArr[i4] = (d2 / 2.0d) + d;
        int i5 = i3 - 1;
        dArr[i5] = d3;
        double d4 = i2;
        double d5 = (d2 / d4) / d4;
        double d6 = d5 / 2.0d;
        dArr[0] = d + d6;
        int i6 = i3 - 2;
        dArr[i6] = d3 - d6;
        int i7 = 1;
        while (true) {
            int i8 = i7;
            if (i8 >= i4) {
                return dArr;
            }
            double d7 = (i8 * d5) + d6;
            dArr[i8] = dArr[i8 - 1] + d7;
            dArr[i6 - i8] = dArr[i5 - i8] - d7;
            i7 = i8 + 1;
        }
    }
}
