package com.blued.android.framework.view.SuperToast.utils;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.TypedValue;
import com.blued.android.framework.view.SuperToast.Style;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/SuperToast/utils/BackgroundUtils.class */
public class BackgroundUtils {
    public static int a(int i) {
        return 0;
    }

    public static Drawable a(Style style, int i) {
        if (style.e > 0) {
            int i2 = style.e;
            if (i2 == 1) {
                return e(i);
            }
            if (i2 == 2) {
                return d(i);
            }
            if (i2 == 3) {
                return c(i);
            }
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 21) {
            style.e = 3;
            return c(i);
        } else if (i3 >= 19) {
            style.e = 2;
            return d(i);
        } else {
            style.e = 1;
            return e(i);
        }
    }

    public static int b(int i) {
        return Math.round(TypedValue.applyDimension(1, i, Resources.getSystem().getDisplayMetrics()));
    }

    private static ColorDrawable c(int i) {
        return new ColorDrawable(i);
    }

    private static GradientDrawable d(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(b(24));
        gradientDrawable.setColor(i);
        return gradientDrawable;
    }

    private static GradientDrawable e(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(b(4));
        gradientDrawable.setColor(i);
        return gradientDrawable;
    }
}
