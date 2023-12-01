package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Looper;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/av.class */
public class av {

    /* renamed from: a  reason: collision with root package name */
    private static au f26945a;
    private static boolean b = false;

    public static String a(Context context) {
        synchronized (av.class) {
            try {
                if (context != null) {
                    if (Looper.myLooper() != Looper.getMainLooper()) {
                        b(context);
                        if (f26945a != null) {
                            try {
                                return f26945a.a(context);
                            } catch (Exception e) {
                            }
                        }
                        return null;
                    }
                    throw new IllegalStateException("Cannot be called from the main thread");
                }
                throw new RuntimeException("Context is null");
            } finally {
            }
        }
    }

    private static void b(Context context) {
        if (f26945a != null || b) {
            return;
        }
        synchronized (av.class) {
            try {
                if (f26945a == null && !b) {
                    f26945a = ax.a(context);
                    b = true;
                }
            } finally {
            }
        }
    }
}
