package com.airbnb.lottie;

import androidx.core.os.TraceCompat;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/L.class */
public class L {
    public static boolean a = false;
    private static boolean b = false;
    private static String[] c;
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
            c[i] = str;
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
                if (str.equals(c[i2])) {
                    TraceCompat.endSection();
                    return ((float) (System.nanoTime() - d[e])) / 1000000.0f;
                }
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + c[e] + ".");
            }
            throw new IllegalStateException("Can't end trace section. There are none.");
        } else {
            return 0.0f;
        }
    }
}
