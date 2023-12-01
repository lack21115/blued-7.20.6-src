package c.t.m.g;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/y2.class */
public final class y2 {

    /* renamed from: a  reason: collision with root package name */
    public static double[] f4064a;
    public static double[] b;

    public static void a(double[] dArr, double[] dArr2) {
        int length = dArr.length;
        if (length != dArr2.length) {
            throw new IllegalArgumentException("Mismatched lengths");
        }
        int numberOfLeadingZeros = 31 - Integer.numberOfLeadingZeros(length);
        if ((1 << numberOfLeadingZeros) != length) {
            throw new IllegalArgumentException("Length is not a power of 2");
        }
        double[] dArr3 = f4064a;
        if (dArr3 == null || dArr3.length != length / 2) {
            int i = length / 2;
            b = new double[i];
            f4064a = new double[i];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    break;
                }
                double d = (i3 * 6.283185307179586d) / length;
                b[i3] = Math.cos(d);
                f4064a[i3] = Math.sin(d);
                i2 = i3 + 1;
            }
        }
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= length) {
                break;
            }
            int reverse = Integer.reverse(i5) >>> (32 - numberOfLeadingZeros);
            if (reverse > i5) {
                double d2 = dArr[i5];
                dArr[i5] = dArr[reverse];
                dArr[reverse] = d2;
                double d3 = dArr2[i5];
                dArr2[i5] = dArr2[reverse];
                dArr2[reverse] = d3;
            }
            i4 = i5 + 1;
        }
        int i6 = 2;
        while (true) {
            int i7 = i6;
            if (i7 > length) {
                return;
            }
            int i8 = i7 / 2;
            int i9 = length / i7;
            int i10 = 0;
            while (true) {
                int i11 = i10;
                if (i11 >= length) {
                    break;
                }
                int i12 = i11;
                int i13 = 0;
                while (true) {
                    int i14 = i13;
                    if (i12 < i11 + i8) {
                        int i15 = i12 + i8;
                        double d4 = dArr[i15];
                        double[] dArr4 = b;
                        double d5 = dArr4[i14];
                        double d6 = dArr2[i15];
                        double[] dArr5 = f4064a;
                        double d7 = (d4 * d5) + (d6 * dArr5[i14]);
                        double d8 = ((-dArr[i15]) * dArr5[i14]) + (dArr2[i15] * dArr4[i14]);
                        dArr[i15] = dArr[i12] - d7;
                        dArr2[i15] = dArr2[i12] - d8;
                        dArr[i12] = dArr[i12] + d7;
                        dArr2[i12] = dArr2[i12] + d8;
                        i12++;
                        i13 = i14 + i9;
                    }
                }
                i10 = i11 + i7;
            }
            if (i7 == length) {
                return;
            }
            i6 = i7 * 2;
        }
    }
}
