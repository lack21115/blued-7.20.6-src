package com.blued.android.framework.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/utils/DensityUtils.class */
public class DensityUtils {
    public static int a(Activity activity) {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i = rect.top;
        if (i == 0) {
            try {
                Class<?> cls = Class.forName("com.android.internal.R$dimen");
                return activity.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return i;
            } catch (NumberFormatException e3) {
                e3.printStackTrace();
                return i;
            } catch (IllegalArgumentException e4) {
                e4.printStackTrace();
                return i;
            } catch (InstantiationException e5) {
                e5.printStackTrace();
                return i;
            } catch (NoSuchFieldException e6) {
                e6.printStackTrace();
                return i;
            } catch (SecurityException e7) {
                e7.printStackTrace();
                return i;
            }
        }
        return i;
    }

    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int b(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int c(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int d(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
