package com.umeng.commonsdk.config;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/config/a.class */
public class a {
    public static boolean a(int i, int i2) {
        boolean z = false;
        if (i2 >= 0) {
            if (i2 > 31) {
                return false;
            }
            z = false;
            if ((i & (1 << i2)) != 0) {
                z = true;
            }
        }
        return z;
    }

    public static boolean a(long j, int i) {
        boolean z = false;
        if (i >= 0) {
            if (i > 63) {
                return false;
            }
            z = false;
            if ((j & (1 << i)) != 0) {
                z = true;
            }
        }
        return z;
    }

    public static int b(int i, int i2) {
        return i | (1 << i2);
    }

    public static long b(long j, int i) {
        long j2 = j;
        if (i >= 0) {
            if (i > 63) {
                return j;
            }
            j2 = j | (1 << i);
        }
        return j2;
    }

    public static int c(int i, int i2) {
        return i & (1 << i2);
    }

    public static long c(long j, int i) {
        long j2 = j;
        if (i >= 0) {
            if (i > 63) {
                return j;
            }
            j2 = j & (1 << i);
        }
        return j2;
    }
}
