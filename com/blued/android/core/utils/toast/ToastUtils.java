package com.blued.android.core.utils.toast;

import android.app.Application;
import android.content.res.Resources;
import com.blued.android.core.utils.toast.config.IToastInterceptor;
import com.blued.android.core.utils.toast.config.IToastStrategy;
import com.blued.android.core.utils.toast.config.IToastStyle;
import com.blued.android.core.utils.toast.style.BluedToastStyle;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/toast/ToastUtils.class */
public final class ToastUtils {

    /* renamed from: a  reason: collision with root package name */
    private static Application f9765a;
    private static IToastStrategy b;

    /* renamed from: c  reason: collision with root package name */
    private static IToastStyle<?> f9766c;
    private static IToastInterceptor d;
    private static Boolean e;

    private ToastUtils() {
    }

    public static void a(int i, int i2) {
        try {
            a(f9765a.getResources().getText(i), i2);
        } catch (Resources.NotFoundException e2) {
            a(String.valueOf(i), i2);
        }
    }

    public static void a(Application application) {
        a(application, f9766c);
    }

    public static void a(Application application, IToastStrategy iToastStrategy, IToastStyle<?> iToastStyle) {
        f9765a = application;
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
        iToastStrategy.a(f9765a);
    }

    public static void a(IToastStyle<?> iToastStyle) {
        f9766c = iToastStyle;
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
            e = Boolean.valueOf((f9765a.getApplicationInfo().flags & 2) != 0);
        }
        return e.booleanValue();
    }
}
