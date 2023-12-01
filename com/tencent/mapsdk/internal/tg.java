package com.tencent.mapsdk.internal;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/tg.class */
public class tg {

    /* renamed from: a  reason: collision with root package name */
    private static final int f38029a = 0;
    private static int b;

    public static int a() {
        int i;
        synchronized (tg.class) {
            try {
                i = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    public static void a(Context context) {
        synchronized (tg.class) {
            try {
                b = lc.a(context).b(m4.z);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(Context context, int i) {
        synchronized (tg.class) {
            try {
                b = i;
                lc.a(context).b(m4.z, i);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
