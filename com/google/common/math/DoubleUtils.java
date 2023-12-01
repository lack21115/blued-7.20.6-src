package com.google.common.math;

import com.google.common.base.Preconditions;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/math/DoubleUtils.class */
final class DoubleUtils {
    static final int EXPONENT_BIAS = 1023;
    static final long EXPONENT_MASK = 9218868437227405312L;
    static final long IMPLICIT_BIT = 4503599627370496L;
    static final long ONE_BITS = 4607182418800017408L;
    static final int SIGNIFICAND_BITS = 52;
    static final long SIGNIFICAND_MASK = 4503599627370495L;
    static final long SIGN_MASK = Long.MIN_VALUE;

    private DoubleUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static double bigToDouble(java.math.BigInteger r7) {
        /*
            r0 = r7
            java.math.BigInteger r0 = r0.abs()
            r16 = r0
            r0 = r16
            int r0 = r0.bitLength()
            r8 = r0
            r0 = 1
            r9 = r0
            r0 = r8
            r1 = 1
            int r0 = r0 - r1
            r10 = r0
            r0 = r10
            r1 = 63
            if (r0 >= r1) goto L1e
            r0 = r7
            long r0 = r0.longValue()
            double r0 = (double) r0
            return r0
        L1e:
            r0 = r10
            r1 = 1023(0x3ff, float:1.434E-42)
            if (r0 <= r1) goto L2f
            r0 = r7
            int r0 = r0.signum()
            double r0 = (double) r0
            r1 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            double r0 = r0 * r1
            return r0
        L2f:
            r0 = r10
            r1 = 52
            int r0 = r0 - r1
            r1 = 1
            int r0 = r0 - r1
            r11 = r0
            r0 = r16
            r1 = r11
            java.math.BigInteger r0 = r0.shiftRight(r1)
            long r0 = r0.longValue()
            r12 = r0
            r0 = r12
            r1 = 1
            long r0 = r0 >> r1
            r1 = 4503599627370495(0xfffffffffffff, double:2.225073858507201E-308)
            long r0 = r0 & r1
            r14 = r0
            r0 = r12
            r1 = 1
            long r0 = r0 & r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L70
            r0 = r9
            r8 = r0
            r0 = r14
            r1 = 1
            long r0 = r0 & r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L72
            r0 = r16
            int r0 = r0.getLowestSetBit()
            r1 = r11
            if (r0 >= r1) goto L70
            r0 = r9
            r8 = r0
            goto L72
        L70:
            r0 = 0
            r8 = r0
        L72:
            r0 = r14
            r12 = r0
            r0 = r8
            if (r0 == 0) goto L80
            r0 = r14
            r1 = 1
            long r0 = r0 + r1
            r12 = r0
        L80:
            r0 = r10
            r1 = 1023(0x3ff, float:1.434E-42)
            int r0 = r0 + r1
            long r0 = (long) r0
            r1 = 52
            long r0 = r0 << r1
            r1 = r12
            long r0 = r0 + r1
            r1 = r7
            int r1 = r1.signum()
            long r1 = (long) r1
            r2 = -9223372036854775808
            long r1 = r1 & r2
            long r0 = r0 | r1
            double r0 = java.lang.Double.longBitsToDouble(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.DoubleUtils.bigToDouble(java.math.BigInteger):double");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double ensureNonNegative(double d) {
        Preconditions.checkArgument(!Double.isNaN(d));
        return Math.max(d, 0.0d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getSignificand(double d) {
        Preconditions.checkArgument(isFinite(d), "not a normal value");
        int exponent = Math.getExponent(d);
        long doubleToRawLongBits = Double.doubleToRawLongBits(d) & SIGNIFICAND_MASK;
        return exponent == -1023 ? doubleToRawLongBits << 1 : doubleToRawLongBits | 4503599627370496L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isFinite(double d) {
        return Math.getExponent(d) <= 1023;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isNormal(double d) {
        return Math.getExponent(d) >= -1022;
    }

    static double nextDown(double d) {
        return -Math.nextUp(-d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double scaleNormalize(double d) {
        return Double.longBitsToDouble((Double.doubleToRawLongBits(d) & SIGNIFICAND_MASK) | ONE_BITS);
    }
}
