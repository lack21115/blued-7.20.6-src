package c.t.m.g;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/a2.class */
public class a2 {
    public static void a() {
        throw new IllegalArgumentException("Illegal matrix dimensions.");
    }

    public static void a(z1 z1Var, z1 z1Var2, z1 z1Var3) {
        int i = z1Var.b;
        int i2 = z1Var2.b;
        if (i == i2) {
            int i3 = z1Var.f4072c;
            int i4 = z1Var2.f4072c;
            if (i3 == i4 && i2 == z1Var3.b && i4 == z1Var3.f4072c) {
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 >= z1Var.b) {
                        return;
                    }
                    int i7 = 0;
                    while (true) {
                        int i8 = i7;
                        if (i8 < z1Var.f4072c) {
                            z1Var.f4071a[i6][i8] = z1Var2.f4071a[i6][i8] * z1Var3.f4071a[i6][i8];
                            i7 = i8 + 1;
                        }
                    }
                    i5 = i6 + 1;
                }
            }
        }
        a();
        throw null;
    }

    public static void a(z1 z1Var, double[][] dArr) {
        a(z1Var.f4071a, dArr);
    }

    public static void a(double[][] dArr, double[][] dArr2) {
        if (dArr.length != dArr2.length || (dArr.length != 0 && dArr[0].length != dArr2[0].length)) {
            a();
            throw null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= dArr.length) {
                return;
            }
            System.arraycopy((Object) dArr2[i2], 0, (Object) dArr[i2], 0, dArr2[i2].length);
            i = i2 + 1;
        }
    }

    public static void b(z1 z1Var, z1 z1Var2, z1 z1Var3) {
        if (z1Var == z1Var2 || z1Var == z1Var3) {
            throw new IllegalArgumentException("resMatrix cannot be mA,mB.");
        }
        if (z1Var.b != z1Var2.b || z1Var.f4072c != z1Var3.f4072c || z1Var2.f4072c != z1Var3.b) {
            a();
            throw null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= z1Var.b) {
                return;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < z1Var.f4072c) {
                    double d = 0.0d;
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i6 < z1Var2.f4072c) {
                            d += z1Var2.f4071a[i2][i6] * z1Var3.f4071a[i6][i4];
                            i5 = i6 + 1;
                        }
                    }
                    z1Var.f4071a[i2][i4] = d;
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
    }
}
