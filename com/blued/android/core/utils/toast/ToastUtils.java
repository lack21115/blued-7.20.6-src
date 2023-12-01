package com.blued.android.core.utils.toast;

import android.app.Application;
import android.content.res.Resources;
import com.blued.android.core.utils.toast.config.IToastInterceptor;
import com.blued.android.core.utils.toast.config.IToastStrategy;
import com.blued.android.core.utils.toast.config.IToastStyle;
import com.blued.android.core.utils.toast.style.BluedToastStyle;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/toast/ToastUtils.class */
public final class ToastUtils {
    private static Application a;
    private static IToastStrategy b;
    private static IToastStyle<?> c;
    private static IToastInterceptor d;
    private static Boolean e;

    private ToastUtils() {
    }

    public static void a(int i, int i2) {
        try {
            a(a.getResources().getText(i), i2);
        } catch (Resources.NotFoundException e2) {
            a(String.valueOf(i), i2);
        }
    }

    public static void a(Application application) {
        a(application, c);
    }

    public static void a(Application application, IToastStrategy iToastStrategy, IToastStyle<?> iToastStyle) {
        a = application;
        ToastStrategy toastStrategy = iToastStrategy;
        if (iToastStrategy == null) {
            toastStrategy = new ToastStrategy();
        }
        a(toastStrategy);
        BluedToastStyle bluedToastStyle = iToastStyle;
        if (iToastStyle == null) {
            bluedToastStyle = new BluedToastStyle();
        }
        a(bluedToastStyle);
    }

    public static void a(Application application, IToastStyle<?> iToastStyle) {
        a(application, null, iToastStyle);
    }

    public static void a(IToastStrategy iToastStrategy) {
        b = iToastStrategy;
        iToastStrategy.a(a);
    }

    public static void a(IToastStyle<?> iToastStyle) {
        c = iToastStyle;
        b.a(iToastStyle);
    }

    public static void a(CharSequence charSequence, int i) {
        if (charSequence == null || charSequence.length() == 0) {
            return;
        }
        if (d == null) {
            d = new ToastLogInterceptor();
        }
        if (d.a(charSequence)) {
            return;
        }
        b.a(charSequence, 0L, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        if (e == null) {
            e = Boolean.valueOf((a.getApplicationInfo().flags & 2) != 0);
        }
        return e.booleanValue();
    }
}
