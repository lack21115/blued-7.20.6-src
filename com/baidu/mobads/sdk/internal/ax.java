package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/ax.class */
public class ax {

    /* renamed from: a  reason: collision with root package name */
    private static DisplayMetrics f9325a;
    private static float b;

    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int a(Context context, int i) {
        try {
            return (int) (i / e(context));
        } catch (Exception e) {
            return i;
        }
    }

    public static Rect a(Context context) {
        DisplayMetrics f = f(context);
        try {
            return f.widthPixels > f.heightPixels ? new Rect(0, 0, f.heightPixels, f.widthPixels) : new Rect(0, 0, f.widthPixels, f.heightPixels);
        } catch (Exception e) {
            return null;
        }
    }

    public static int b(Context context) {
        return a(context).width();
    }

    public static int b(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int b(Context context, int i) {
        try {
            return (int) (i * e(context));
        } catch (Exception e) {
            return i;
        }
    }

    public static int c(Context context) {
        return a(context).height();
    }

    public static Rect d(Context context) {
        DisplayMetrics f = f(context);
        return new Rect(0, 0, f.widthPixels, f.heightPixels);
    }

    public static float e(Context context) {
        if (b < 0.01d) {
            b = f(context).density;
        }
        return b;
    }

    public static DisplayMetrics f(Context context) {
        try {
            if (f9325a != null && f9325a.widthPixels > 0) {
                return f9325a;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (bj.a(context).a() >= 17) {
                ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(displayMetrics);
            }
            f9325a = displayMetrics;
        } catch (Throwable th) {
            f9325a = new DisplayMetrics();
            bq.a().a(th);
        }
        return f9325a;
    }

    public static int g(Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
    }
}
