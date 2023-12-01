package com.tencent.smtt.sdk.ui.dialog;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/ui/dialog/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static float f25204a = -1.0f;
    private static int b = -1;

    /* renamed from: c  reason: collision with root package name */
    private static int f25205c = -1;

    public static int a(Context context) {
        if (b == -1) {
            b(context);
        }
        return b;
    }

    public static int a(Context context, float f) {
        return b(context, (f * 160.0f) / 320.0f);
    }

    public static int b(Context context, float f) {
        if (f25204a == -1.0f) {
            b(context);
        }
        return (int) ((f * f25204a) + 0.5f);
    }

    private static void b(Context context) {
        if (f25204a < 0.0f) {
            WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            f25204a = displayMetrics.density;
            b = displayMetrics.heightPixels;
        }
    }
}
