package com.airbnb.lottie;

import androidx.core.os.TraceCompat;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/L.class */
public class L {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f4204a = false;
    private static boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private static String[] f4205c;
    private static long[] d;
    private static int e;
    private static int f;

    public static void a(String str) {
        if (b) {
            int i = e;
            if (i == 20) {
                f++;
                return;
            }
            f4205c[i] = str;
            d[i] = System.nanoTime();
            TraceCompat.beginSection(str);
            e++;
        }
    }

    public static float b(String str) {
        int i = f;
        if (i > 0) {
            f = i - 1;
            return 0.0f;
        } else if (b) {
            int i2 = e - 1;
            e = i2;
            if (i2 != -1) {
                if (str.equals(f4205c[i2])) {
                    TraceCompat.endSection();
                    return ((float) (System.nanoTime() - d[e])) / 1000000.0f;
                }
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f4205c[e] + ".");
            }
            throw new IllegalStateException("Can't end trace section. There are none.");
        } else {
            return 0.0f;
        }
    }
}
