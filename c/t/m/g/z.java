package c.t.m.g;

import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/z.class */
public class z {

    /* renamed from: a  reason: collision with root package name */
    public double[] f4021a = {0.0d, 0.0d, 0.0d};
    public double[] b = {0.0d, 0.0d, 0.0d};

    public final double a(double[][] dArr, int i, int i2) {
        int i3;
        Arrays.fill(this.f4021a, 0.0d);
        Arrays.fill(this.b, 0.0d);
        int i4 = (i + i2) / 2;
        int i5 = i;
        while (true) {
            int i6 = i5;
            if (i6 >= i2) {
                break;
            }
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 < 3) {
                    if (i6 < i4) {
                        double[] dArr2 = this.f4021a;
                        dArr2[i8] = dArr2[i8] + dArr[i8 + 0][i6];
                    }
                    double[] dArr3 = this.b;
                    dArr3[i8] = dArr3[i8] + dArr[i8 + 0][i6];
                    i7 = i8 + 1;
                }
            }
            i5 = i6 + 1;
        }
        for (i3 = 0; i3 < 3; i3++) {
            double[] dArr4 = this.f4021a;
            dArr4[i3] = dArr4[i3] / (i4 - i);
            double[] dArr5 = this.b;
            dArr5[i3] = dArr5[i3] / (i2 - i);
        }
        return Math.acos(h3.a(this.f4021a, this.b) / (h3.c(this.f4021a) * h3.c(this.b)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0062, code lost:
        if (r0 > 0.6d) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(double[][] r7) {
        /*
            r6 = this;
            r0 = 0
            r17 = r0
            r0 = r17
            r16 = r0
            r0 = r7
            if (r0 == 0) goto L68
            r0 = r7
            r1 = 3
            r0 = r0[r1]
            boolean r0 = c.t.m.g.m3.a(r0)
            if (r0 == 0) goto L16
            r0 = 0
            return r0
        L16:
            r0 = r7
            r1 = 3
            r0 = r0[r1]
            int r0 = r0.length
            r14 = r0
            r0 = r14
            r1 = 2
            int r0 = r0 / r1
            r15 = r0
            r0 = r6
            r1 = r7
            r2 = 0
            r3 = r15
            double r0 = r0.a(r1, r2, r3)
            r8 = r0
            r0 = r6
            r1 = r7
            r2 = r15
            r3 = r14
            double r0 = r0.a(r1, r2, r3)
            r10 = r0
            r0 = r6
            r1 = r7
            r2 = r14
            r3 = 4
            int r2 = r2 / r3
            r3 = r14
            r4 = 3
            int r3 = r3 * r4
            r4 = 4
            int r3 = r3 / r4
            double r0 = r0.a(r1, r2, r3)
            r12 = r0
            r0 = r8
            r1 = 4603579539098121011(0x3fe3333333333333, double:0.6)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L65
            r0 = r10
            r1 = 4603579539098121011(0x3fe3333333333333, double:0.6)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L65
            r0 = r17
            r16 = r0
            r0 = r12
            r1 = 4603579539098121011(0x3fe3333333333333, double:0.6)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L68
        L65:
            r0 = 1
            r16 = r0
        L68:
            r0 = r16
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.z.a(double[][]):boolean");
    }
}
