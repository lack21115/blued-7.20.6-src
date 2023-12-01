package c.t.m.g;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/h3.class */
public class h3 {
    public static double a(double[] dArr, double d) {
        return Math.sqrt(b(dArr, d));
    }

    public static double a(double[] dArr, double d, int i, int i2) {
        double d2 = 0.0d;
        int i3 = i;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                return d2 / (i2 - i);
            }
            d2 += (dArr[i4] - d) * (dArr[i4] - d);
            i3 = i4 + 1;
        }
    }

    public static double a(double[] dArr, int i, int i2) {
        return b(dArr, i, i2) / (i2 - i);
    }

    public static double a(double[] dArr, double[] dArr2) {
        double d = 0.0d;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= dArr.length) {
                return d;
            }
            d += dArr[i2] * dArr2[i2];
            i = i2 + 1;
        }
    }

    public static int a(double[] dArr) {
        int i = 1;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= dArr.length) {
                return i3;
            }
            int i4 = i3;
            if (dArr[i] > dArr[i3]) {
                i4 = i;
            }
            i++;
            i2 = i4;
        }
    }

    public static void a(double[] dArr, double[] dArr2, double d) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= dArr2.length) {
                return;
            }
            dArr[i2] = dArr2[i2] - d;
            i = i2 + 1;
        }
    }

    public static void a(double[] dArr, double[] dArr2, double[] dArr3) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= dArr2.length) {
                return;
            }
            dArr[i2] = dArr2[i2] * dArr3[i2];
            i = i2 + 1;
        }
    }

    public static double b(double[] dArr) {
        return a(dArr, 0, dArr.length);
    }

    public static double b(double[] dArr, double d) {
        return a(dArr, d, 0, dArr.length);
    }

    public static double b(double[] dArr, int i, int i2) {
        double d = 0.0d;
        while (i < i2) {
            d += dArr[i];
            i++;
        }
        return d;
    }

    public static double c(double... dArr) {
        int length = dArr.length;
        double d = 0.0d;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return Math.sqrt(d);
            }
            double d2 = dArr[i2];
            d += d2 * d2;
            i = i2 + 1;
        }
    }

    public static double d(double[] dArr) {
        return b(dArr, 0, dArr.length);
    }
}
