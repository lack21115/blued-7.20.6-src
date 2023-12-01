package com.tencent.mapsdk.internal;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/x8.class */
public class x8 {
    public static double a(long j, float f, float f2, long j2) {
        long j3 = j / j2;
        float f3 = (float) j3;
        return (f2 * f3 * f3 * ((float) ((j3 * 21) - 20))) + f;
    }

    public static double b(long j, float f, float f2, long j2) {
        long j3 = j / j2;
        return (f2 * (1.0d - Math.sqrt(1 - (j3 * j3)))) + f;
    }

    public static double c(long j, float f, float f2, long j2) {
        return (f2 * Math.pow(j / j2, 3.0d)) + f;
    }

    public static double d(long j, float f, float f2, long j2) {
        return (f2 * Math.pow(2.0d, ((j / j2) - 1) * 10)) + f;
    }

    public static double e(long j, float f, float f2, long j2) {
        float f3;
        long j3 = j / (j2 / 2);
        float f4 = f2 / 2.0f;
        if (j3 < 1) {
            int i = (int) (2 * 1.525d);
            f3 = (float) (j3 * j3 * (((i + 1) * j3) - i));
        } else {
            long j4 = j3 - 2;
            int i2 = (int) (2 * 1.525d);
            f3 = (float) ((j4 * j4 * (((i2 + 1) * j4) + i2)) + 2);
        }
        return (f4 * f3) + f;
    }

    public static double f(long j, float f, float f2, long j2) {
        long j3 = j / (j2 / 2);
        if (j3 < 1) {
            return ((f2 / 2.0f) * (1.0d - Math.sqrt(1 - (j3 * j3)))) + f;
        }
        long j4 = j3 - 2;
        return ((f2 / 2.0f) * (Math.sqrt(1 - (j4 * j4)) + 1.0d)) + f;
    }

    public static double g(long j, float f, float f2, long j2) {
        long j3 = j / (j2 / 2);
        return j3 < 1 ? ((f2 / 2.0f) * Math.pow(j3, 3.0d)) + f : ((f2 / 2.0f) * (Math.pow(j3 - 2, 3.0d) + 2.0d)) + f;
    }

    public static double h(long j, float f, float f2, long j2) {
        float f3;
        float f4;
        long j3 = ((float) j) / (((float) j2) / 2.0f);
        if (j3 < 1) {
            float f5 = f2 / 2.0f;
            f4 = (float) j3;
            f3 = f5 * f4;
        } else {
            f3 = (-f2) / 2.0f;
            long j4 = j3 - 1;
            f4 = (float) ((j4 * (j4 - 2)) - 1);
        }
        return (f3 * f4) + f;
    }

    public static double i(long j, float f, float f2, long j2) {
        float f3;
        float f4;
        long j3 = j / (j2 / 2);
        if (j3 < 1) {
            float f5 = f2 / 2.0f;
            f4 = (float) j3;
            f3 = f5 * f4 * f4 * f4;
        } else {
            f3 = (-f2) / 2.0f;
            long j4 = j3 - 2;
            f4 = (float) ((((j4 * j4) * j4) * j4) - 2);
        }
        return (f3 * f4) + f;
    }

    public static double j(long j, float f, float f2, long j2) {
        float f3;
        long j3 = j / (j2 / 2);
        float f4 = f2 / 2.0f;
        if (j3 < 1) {
            f3 = (float) j3;
            f4 = f4 * f3 * f3 * f3 * f3;
        } else {
            long j4 = j3 - 2;
            f3 = (float) ((j4 * j4 * j4 * j4 * j4) + 2);
        }
        return (f4 * f3) + f;
    }

    public static double k(long j, float f, float f2, long j2) {
        return ((f2 / 2.0f) * (1.0d - Math.cos((j * 3.141592653589793d) / j2))) + f;
    }

    public static double l(long j, float f, float f2, long j2) {
        float f3 = ((float) j) / ((float) j2);
        return (f2 * f3 * f3) + f;
    }

    public static double m(long j, float f, float f2, long j2) {
        float f3 = ((float) j) / ((float) j2);
        return (f2 * f3 * f3 * f3 * f3) + f;
    }

    public static double n(long j, float f, float f2, long j2) {
        float f3 = (float) (j / j2);
        return (f2 * f3 * f3 * f3 * f3 * f3) + f;
    }

    public static double o(long j, float f, float f2, long j2) {
        return (f2 * (1.0d - Math.cos((j / j2) * 1.5707963267948966d))) + f;
    }

    public static double p(long j, float f, float f2, long j2) {
        long j3 = (j / j2) - 1;
        return (f2 * ((float) ((j3 * j3 * ((j3 * 21) + 20)) + 1))) + f;
    }

    public static double q(long j, float f, float f2, long j2) {
        long j3 = j / (j2 - 1);
        return (f2 * Math.sqrt(1 - (j3 * j3))) + f;
    }

    public static double r(long j, float f, float f2, long j2) {
        return (f2 * (Math.pow((((float) j) / ((float) j2)) - 1.0f, 3.0d) + 1.0d)) + f;
    }

    public static double s(long j, float f, float f2, long j2) {
        return (f2 * ((-Math.pow(2.0d, (j * (-10)) / j2)) + 1.0d)) + f;
    }

    public static double t(long j, float f, float f2, long j2) {
        float f3 = ((float) j) / ((float) j2);
        return ((-f2) * f3 * (f3 - 2.0f)) + f;
    }

    public static double u(long j, float f, float f2, long j2) {
        float f3 = (float) (j / (j2 - 1));
        return ((-f2) * ((((f3 * f3) * f3) * f3) - 1.0f)) + f;
    }

    public static double v(long j, float f, float f2, long j2) {
        long j3 = (j / j2) - 1;
        return (f2 * ((float) ((j3 * j3 * j3 * j3 * j3) + 1))) + f;
    }

    public static double w(long j, float f, float f2, long j2) {
        return (f2 * Math.sin((j / j2) * 1.5707963267948966d)) + f;
    }

    public static double x(long j, float f, float f2, long j2) {
        return ((f2 * ((float) j)) / ((float) j2)) + f;
    }
}
