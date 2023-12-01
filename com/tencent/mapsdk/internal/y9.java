package com.tencent.mapsdk.internal;

import android.animation.ObjectAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.ScaleAnimation;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/y9.class */
public class y9 {
    public static void a(View view, float f) {
        if (Build.VERSION.SDK_INT >= 11) {
            view.setAlpha(f);
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, f);
        alphaAnimation.setDuration(0L);
        alphaAnimation.setFillAfter(true);
        view.startAnimation(alphaAnimation);
    }

    public static void a(View view, float f, float f2) {
        if (Build.VERSION.SDK_INT >= 11) {
            view.setScaleX(f);
            view.setScaleY(f2);
            return;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, f, 1.0f, f2);
        scaleAnimation.setDuration(0L);
        scaleAnimation.setFillAfter(true);
        view.startAnimation(scaleAnimation);
    }

    public static void a(Object obj, String str, int i, float... fArr) {
        if (Build.VERSION.SDK_INT >= 11) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(obj, str, fArr[0], fArr[1]);
            ofFloat.setDuration(i);
            ofFloat.start();
        } else if ("Alpha".equals(str) && (obj instanceof View)) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(fArr[0], fArr[1]);
            alphaAnimation.setDuration(i);
            alphaAnimation.setFillAfter(true);
            ((View) obj).startAnimation(alphaAnimation);
        } else if ("Scale".equals(str) && (obj instanceof View)) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(fArr[0], fArr[1], fArr[0], fArr[1]);
            scaleAnimation.setDuration(i);
            scaleAnimation.setFillAfter(true);
            ((View) obj).startAnimation(scaleAnimation);
        }
    }

    public static boolean a(String str, String str2, int i) {
        return d(str, str2, i) == 0;
    }

    public static boolean b(String str, String str2, int i) {
        return d(str, str2, i) > 0;
    }

    public static boolean c(String str, String str2, int i) {
        return d(str, str2, i) < 0;
    }

    public static int d(String str, String str2, int i) {
        int i2;
        int i3 = 0;
        int i4 = 0;
        if (!f7.b(str)) {
            i4 = 0;
            if (!f7.b(str2)) {
                if (str.equals(str2)) {
                    return 0;
                }
                String[] split = str.split("\\.");
                String[] split2 = str2.split("\\.");
                int i5 = 0;
                while (true) {
                    i2 = i5;
                    if (i3 >= i) {
                        break;
                    }
                    try {
                        i2 = Integer.valueOf(Integer.parseInt(i3 < split.length ? split[i3] : "0")).compareTo(Integer.valueOf(Integer.parseInt(i3 < split2.length ? split2[i3] : "0")));
                        i5 = i2;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (i2 != 0) {
                        break;
                    }
                    i3++;
                }
                i4 = i2;
            }
        }
        return i4;
    }
}
